package com.android.volley.toolbox;

import B0.g;
import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import com.stepos.activeview.utils.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    public static class CacheHeader {
        public String etag;
        public String key;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.lastModified = entry.lastModified;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public static CacheHeader readHeader(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) != DiskBasedCache.CACHE_MAGIC) {
                throw new IOException();
            }
            cacheHeader.key = DiskBasedCache.readString(inputStream);
            String string = DiskBasedCache.readString(inputStream);
            cacheHeader.etag = string;
            if (string.equals("")) {
                cacheHeader.etag = null;
            }
            cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
            cacheHeader.lastModified = DiskBasedCache.readLong(inputStream);
            cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
            cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
            cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
            return cacheHeader;
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) throws IOException {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                String str = this.etag;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.writeString(outputStream, str);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.lastModified);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e4) {
                VolleyLog.d("%s", e4.toString());
                return false;
            }
        }
    }

    public static class CountingInputStream extends FilterInputStream {
        private int bytesRead;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i4 = super.read();
            if (i4 != -1) {
                this.bytesRead++;
            }
            return i4;
        }

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = super.read(bArr, i4, i5);
            if (i6 != -1) {
                this.bytesRead += i6;
            }
            return i6;
        }
    }

    public DiskBasedCache(File file, int i4) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i4;
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        StringBuilder sbS = g.s(String.valueOf(str.substring(0, length).hashCode()));
        sbS.append(String.valueOf(str.substring(length).hashCode()));
        return sbS.toString();
    }

    private void pruneIfNeeded(int i4) {
        if (this.mTotalSize + i4 < this.mMaxCacheSizeInBytes) {
            return;
        }
        int i5 = 0;
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j4 = this.mTotalSize;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
        while (it.hasNext()) {
            CacheHeader value = it.next().getValue();
            if (getFileForKey(value.key).delete()) {
                this.mTotalSize -= value.size;
            } else {
                String str = value.key;
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
            }
            it.remove();
            i5++;
            if (this.mTotalSize + r2 < this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                break;
            }
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i5), Long.valueOf(this.mTotalSize - j4), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (this.mEntries.containsKey(str)) {
            this.mTotalSize = (cacheHeader.size - this.mEntries.get(str).size) + this.mTotalSize;
        } else {
            this.mTotalSize += cacheHeader.size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private static int read(InputStream inputStream) throws IOException {
        int i4 = inputStream.read();
        if (i4 != -1) {
            return i4;
        }
        throw new EOFException();
    }

    public static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | read(inputStream) | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    public static long readLong(InputStream inputStream) throws IOException {
        return (read(inputStream) & 255) | ((read(inputStream) & 255) << 8) | ((read(inputStream) & 255) << 16) | ((read(inputStream) & 255) << 24) | ((read(inputStream) & 255) << 32) | ((read(inputStream) & 255) << 40) | ((read(inputStream) & 255) << 48) | ((255 & read(inputStream)) << 56);
    }

    public static String readString(InputStream inputStream) throws IOException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), Constants.UTF_8_CODE);
    }

    public static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        int i4 = readInt(inputStream);
        Map<String, String> mapEmptyMap = i4 == 0 ? Collections.emptyMap() : new HashMap<>(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            mapEmptyMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return mapEmptyMap;
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    private static byte[] streamToBytes(InputStream inputStream, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int i6 = inputStream.read(bArr, i5, i4 - i5);
            if (i6 == -1) {
                break;
            }
            i5 += i6;
        }
        if (i5 == i4) {
            return bArr;
        }
        throw new IOException("Expected " + i4 + " bytes, read " + i5 + " bytes");
    }

    public static void writeInt(OutputStream outputStream, int i4) throws IOException {
        outputStream.write(i4 & 255);
        outputStream.write((i4 >> 8) & 255);
        outputStream.write((i4 >> 16) & 255);
        outputStream.write((i4 >> 24) & 255);
    }

    public static void writeLong(OutputStream outputStream, long j4) throws IOException {
        outputStream.write((byte) j4);
        outputStream.write((byte) (j4 >>> 8));
        outputStream.write((byte) (j4 >>> 16));
        outputStream.write((byte) (j4 >>> 24));
        outputStream.write((byte) (j4 >>> 32));
        outputStream.write((byte) (j4 >>> 40));
        outputStream.write((byte) (j4 >>> 48));
        outputStream.write((byte) (j4 >>> 56));
    }

    public static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Constants.UTF_8_CODE);
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            writeInt(outputStream, 0);
            return;
        }
        writeInt(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writeString(outputStream, entry.getKey());
            writeString(outputStream, entry.getValue());
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        try {
            File[] fileArrListFiles = this.mRootDirectory.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
            this.mEntries.clear();
            this.mTotalSize = 0L;
            VolleyLog.d("Cache cleared.", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.volley.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.android.volley.Cache.Entry get(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.Map<java.lang.String, com.android.volley.toolbox.DiskBasedCache$CacheHeader> r0 = r11.mEntries     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L3f
            com.android.volley.toolbox.DiskBasedCache$CacheHeader r0 = (com.android.volley.toolbox.DiskBasedCache.CacheHeader) r0     // Catch: java.lang.Throwable -> L3f
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r11)
            return r1
        Le:
            java.io.File r2 = r11.getFileForKey(r12)     // Catch: java.lang.Throwable -> L3f
            r3 = 1
            r4 = 0
            r5 = 2
            com.android.volley.toolbox.DiskBasedCache$CountingInputStream r6 = new com.android.volley.toolbox.DiskBasedCache$CountingInputStream     // Catch: java.lang.Throwable -> L49 java.lang.NegativeArraySizeException -> L4c java.io.IOException -> L4f
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L49 java.lang.NegativeArraySizeException -> L4c java.io.IOException -> L4f
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.lang.NegativeArraySizeException -> L4c java.io.IOException -> L4f
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L49 java.lang.NegativeArraySizeException -> L4c java.io.IOException -> L4f
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L49 java.lang.NegativeArraySizeException -> L4c java.io.IOException -> L4f
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L49 java.lang.NegativeArraySizeException -> L4c java.io.IOException -> L4f
            com.android.volley.toolbox.DiskBasedCache.CacheHeader.readHeader(r6)     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            long r7 = r2.length()     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            int r9 = com.android.volley.toolbox.DiskBasedCache.CountingInputStream.access$100(r6)     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            long r9 = (long) r9     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            long r7 = r7 - r9
            int r7 = (int) r7     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            byte[] r7 = streamToBytes(r6, r7)     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            com.android.volley.Cache$Entry r12 = r0.toCacheEntry(r7)     // Catch: java.lang.Throwable -> L43 java.lang.NegativeArraySizeException -> L45 java.io.IOException -> L47
            r6.close()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            monitor-exit(r11)
            return r12
        L3f:
            r12 = move-exception
            goto L9b
        L41:
            monitor-exit(r11)
            return r1
        L43:
            r12 = move-exception
            goto L92
        L45:
            r0 = move-exception
            goto L52
        L47:
            r0 = move-exception
            goto L72
        L49:
            r12 = move-exception
            r6 = r1
            goto L92
        L4c:
            r0 = move-exception
            r6 = r1
            goto L52
        L4f:
            r0 = move-exception
            r6 = r1
            goto L72
        L52:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L43
            r5[r4] = r2     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L43
            r5[r3] = r0     // Catch: java.lang.Throwable -> L43
            com.android.volley.VolleyLog.d(r7, r5)     // Catch: java.lang.Throwable -> L43
            r11.remove(r12)     // Catch: java.lang.Throwable -> L43
            if (r6 == 0) goto L70
            r6.close()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L6e
            goto L70
        L6e:
            monitor-exit(r11)
            return r1
        L70:
            monitor-exit(r11)
            return r1
        L72:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L43
            r5[r4] = r2     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L43
            r5[r3] = r0     // Catch: java.lang.Throwable -> L43
            com.android.volley.VolleyLog.d(r7, r5)     // Catch: java.lang.Throwable -> L43
            r11.remove(r12)     // Catch: java.lang.Throwable -> L43
            if (r6 == 0) goto L90
            r6.close()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L8e
            goto L90
        L8e:
            monitor-exit(r11)
            return r1
        L90:
            monitor-exit(r11)
            return r1
        L92:
            if (r6 == 0) goto L9a
            r6.close()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L98
            goto L9a
        L98:
            monitor-exit(r11)
            return r1
        L9a:
            throw r12     // Catch: java.lang.Throwable -> L3f
        L9b:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.get(java.lang.String):com.android.volley.Cache$Entry");
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        BufferedInputStream bufferedInputStream;
        if (!this.mRootDirectory.exists()) {
            if (!this.mRootDirectory.mkdirs()) {
                VolleyLog.e("Unable to create cache dir %s", this.mRootDirectory.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.mRootDirectory.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                CacheHeader header = CacheHeader.readHeader(bufferedInputStream);
                header.size = file.length();
                putEntry(header.key, header);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
                bufferedInputStream2 = bufferedInputStream;
                if (file != null) {
                    file.delete();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String str, boolean z4) {
        try {
            Cache.Entry entry = get(str);
            if (entry != null) {
                entry.softTtl = 0L;
                if (z4) {
                    entry.ttl = 0L;
                }
                put(str, entry);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        pruneIfNeeded(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
            CacheHeader cacheHeader = new CacheHeader(str, entry);
            if (!cacheHeader.writeHeader(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(entry.data);
            bufferedOutputStream.close();
            putEntry(str, cacheHeader);
        } catch (IOException unused) {
            if (fileForKey.delete()) {
                return;
            }
            VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String str) {
        boolean zDelete = getFileForKey(str).delete();
        removeEntry(str);
        if (!zDelete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }
}
