package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import com.ttnet.org.chromium.net.PrivateKeyType;
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

/* JADX INFO: loaded from: classes.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    /* JADX INFO: renamed from: com.android.volley.toolbox.DiskBasedCache$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

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

        public static CacheHeader readHeader(InputStream r10) throws IOException {
            CacheHeader r11 = new CacheHeader();
            if (DiskBasedCache.readInt(r10) != DiskBasedCache.CACHE_MAGIC) goto L10;
            r11.key = DiskBasedCache.readString(r10);
            String r12 = DiskBasedCache.readString(r10);
            r11.etag = r12;
            if (r12.equals("") == false) goto L7;
            r11.etag = null;
        L7:
            r11.serverDate = DiskBasedCache.readLong(r10);
            r11.lastModified = DiskBasedCache.readLong(r10);
            r11.ttl = DiskBasedCache.readLong(r10);
            r11.softTtl = DiskBasedCache.readLong(r10);
            r11.responseHeaders = DiskBasedCache.readStringStringMap(r10);
            return r11;
        L10:
            throw new IOException();
        }

        public Cache.Entry toCacheEntry(byte[] r10) {
            Cache.Entry r11 = new Cache.Entry();
            r11.data = r10;
            r11.etag = this.etag;
            r11.serverDate = this.serverDate;
            r11.lastModified = this.lastModified;
            r11.ttl = this.ttl;
            r11.softTtl = this.softTtl;
            r11.responseHeaders = this.responseHeaders;
            return r11;
        }

        public boolean writeHeader(OutputStream r10) {
            DiskBasedCache.writeInt(r10, DiskBasedCache.CACHE_MAGIC);     // Catch: IOException -> L6
            DiskBasedCache.writeString(r10, this.key);     // Catch: IOException -> L6
            String r11 = this.etag;     // Catch: IOException -> L6
            if (r11 != null) goto L8;
            r11 = "";
        L8:
            DiskBasedCache.writeString(r10, r11);     // Catch: IOException -> L6
            DiskBasedCache.writeLong(r10, this.serverDate);     // Catch: IOException -> L6
            DiskBasedCache.writeLong(r10, this.lastModified);     // Catch: IOException -> L6
            DiskBasedCache.writeLong(r10, this.ttl);     // Catch: IOException -> L6
            DiskBasedCache.writeLong(r10, this.softTtl);     // Catch: IOException -> L6
            DiskBasedCache.writeStringStringMap(this.responseHeaders, r10);     // Catch: IOException -> L6
            r10.flush();     // Catch: IOException -> L6
            return true;
        L6:
            e = move-exception;
            VolleyLog.d("%s", new Object[]{e.toString()});
            return false;
        }

        public CacheHeader(String r10, Cache.Entry r11) {
            this.key = r10;
            this.size = r11.data.length;
            this.etag = r11.etag;
            this.serverDate = r11.serverDate;
            this.lastModified = r11.lastModified;
            this.ttl = r11.ttl;
            this.softTtl = r11.softTtl;
            this.responseHeaders = r11.responseHeaders;
        }
    }

    public static class CountingInputStream extends FilterInputStream {
        private int bytesRead;

        public /* synthetic */ CountingInputStream(InputStream r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ int access$100(CountingInputStream r10) {
            return r10.bytesRead;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int r10 = super.read();
            if (r10 == (-1)) goto L5;
            this.bytesRead++;
        L5:
            return r10;
        }

        private CountingInputStream(InputStream r10) {
            super(r10);
            this.bytesRead = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r10, int r11, int r12) throws IOException {
            int r13 = super.read(r10, r11, r12);
            if (r13 == (-1)) goto L5;
            this.bytesRead += r13;
        L5:
            return r13;
        }
    }

    public DiskBasedCache(File r10, int r11) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectory = r10;
        this.mMaxCacheSizeInBytes = r11;
    }

    private String getFilenameForKey(String r10) {
        int r11 = r10.length() / 2;
        String r12 = String.valueOf(String.valueOf(r10.substring(0, r11).hashCode()));
        String r13 = String.valueOf(String.valueOf(r10.substring(r11).hashCode()));
        if (r13.length() == 0) goto L6;
        return r12.concat(r13);
    L6:
        return new String(r12);
    }

    private void pruneIfNeeded(int r13) {
        long r10 = r13;
        if ((this.mTotalSize + r10) >= this.mMaxCacheSizeInBytes) goto L5;
        return;
    L5:
        int r11 = 0;
        if (VolleyLog.DEBUG == false) goto L8;
        VolleyLog.v("Pruning old cache entries.", new Object[0]);
    L8:
        long r12 = this.mTotalSize;
        long r14 = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> r15 = this.mEntries.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L18;
        CacheHeader r16 = r15.next().getValue();
        if (getFileForKey(r16.key).delete() == false) goto L14;
        this.mTotalSize -= r16.size;
    L15:
        r15.remove();
        r11 = r11 + 1;
        if ((this.mTotalSize + r10) >= (this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR)) goto L10;
    L14:
        String r17 = r16.key;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{r17, getFilenameForKey(r17)});
    L18:
        if (VolleyLog.DEBUG == false) goto L24;
        VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[]{Integer.valueOf(r11), Long.valueOf(this.mTotalSize - r12), Long.valueOf(SystemClock.elapsedRealtime() - r14)});
        return;
    }

    private void putEntry(String r10, CacheHeader r11) {
        if (this.mEntries.containsKey(r10) == true) goto L5;
        this.mTotalSize += r11.size;
    L6:
        this.mEntries.put(r10, r11);
        return;
    L5:
        this.mTotalSize += r11.size - this.mEntries.get(r10).size;
        goto L6
    }

    private static int read(InputStream r10) throws IOException {
        int r11 = r10.read();
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        throw new EOFException();
    }

    public static int readInt(InputStream r10) throws IOException {
        int r11 = (read(r10) | (read(r10) << 8)) | (read(r10) << 16);
        return (read(r10) << 24) | r11;
    }

    public static long readLong(InputStream r10) throws IOException {
        return (((((((((long) read(r10)) & 255) | ((((long) read(r10)) & 255) << 8)) | ((((long) read(r10)) & 255) << 16)) | ((((long) read(r10)) & 255) << 24)) | ((((long) read(r10)) & 255) << 32)) | ((((long) read(r10)) & 255) << 40)) | ((((long) read(r10)) & 255) << 48)) | ((255 & ((long) read(r10))) << 56);
    }

    public static String readString(InputStream r10) throws IOException {
        return new String(streamToBytes(r10, (int) readLong(r10)), "UTF-8");
    }

    public static Map<String, String> readStringStringMap(InputStream r10) throws IOException {
        int r11 = readInt(r10);
        if (r11 != 0) goto L5;
        Map<String, String> r12 = Collections.emptyMap();
    L6:
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        r12.put(readString(r10).intern(), readString(r10).intern());
        r13 = r13 + 1;
        goto L7
    L9:
        return r12;
    L5:
        r12 = new HashMap(r11);
        goto L6
    }

    private void removeEntry(String r10) {
        CacheHeader r11 = this.mEntries.get(r10);
        if (r11 == null) goto L6;
        this.mTotalSize -= r11.size;
        this.mEntries.remove(r10);
        return;
    }

    private static byte[] streamToBytes(InputStream r10, int r11) throws IOException {
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L7;
        int r14 = r10.read(r12, r13, r11 - r13);
        if (r14 == (-1)) goto L7;
        r13 = r13 + r14;
    L7:
        if (r13 != r11) goto L9;
        return r12;
    L9:
        StringBuilder r15 = new StringBuilder(50);
        r15.append("Expected ");
        r15.append(r11);
        r15.append(" bytes, read ");
        r15.append(r13);
        r15.append(" bytes");
        throw new IOException(r15.toString());
    }

    public static void writeInt(OutputStream r10, int r11) throws IOException {
        r10.write(r11 & PrivateKeyType.INVALID);
        r10.write((r11 >> 8) & PrivateKeyType.INVALID);
        r10.write((r11 >> 16) & PrivateKeyType.INVALID);
        r10.write((r11 >> 24) & PrivateKeyType.INVALID);
    }

    public static void writeLong(OutputStream r10, long r11) throws IOException {
        r10.write((byte) r11);
        r10.write((byte) (r11 >>> 8));
        r10.write((byte) (r11 >>> 16));
        r10.write((byte) (r11 >>> 24));
        r10.write((byte) (r11 >>> 32));
        r10.write((byte) (r11 >>> 40));
        r10.write((byte) (r11 >>> 48));
        r10.write((byte) (r11 >>> 56));
    }

    public static void writeString(OutputStream r10, String r11) throws IOException {
        byte[] r12 = r11.getBytes("UTF-8");
        writeLong(r10, r12.length);
        r10.write(r12, 0, r12.length);
    }

    public static void writeStringStringMap(Map<String, String> r10, OutputStream r11) throws IOException {
        if (r10 == null) goto L7;
        writeInt(r11, r10.size());
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L5:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<String, String> r13 = r12.next();
        writeString(r11, r13.getKey());
        writeString(r11, r13.getValue());
        goto L5
    L10:
        return;
    L7:
        writeInt(r11, 0);
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        monitor-enter(this);
        File[] r10 = this.mRootDirectory.listFiles();     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        int r11 = r10.length;     // Catch: Throwable -> L8
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L10;
        r10[r12].delete();     // Catch: Throwable -> L8
        r12 = r12 + 1;     // Catch: Throwable -> L8
    L10:
        this.mEntries.clear();     // Catch: Throwable -> L8
        this.mTotalSize = 0;     // Catch: Throwable -> L8
        VolleyLog.d("Cache cleared.", new Object[0]);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.volley.Cache
    public synchronized Cache.Entry get(String r10) {
        monitor-enter(this);
        CacheHeader r11 = this.mEntries.get(r10);     // Catch: Throwable -> L14
        FilterInputStream r12 = null;
        Object[] r13 = 0;
        if (r11 != null) goto L42;
        monitor-exit(this);
        return null;
    L42:
        File r14 = getFileForKey(r10);     // Catch: Throwable -> L14
        CountingInputStream r15 = new CountingInputStream(new BufferedInputStream(new FileInputStream(r14)), r13 == true ? 1 : 0);     // Catch: Throwable -> L22 IOException -> L24
        CacheHeader.readHeader(r15);     // Catch: Throwable -> L18 IOException -> L20
        Cache.Entry r16 = r11.toCacheEntry(streamToBytes(r15, (int) (r14.length() - ((long) CountingInputStream.access$100(r15)))));     // Catch: Throwable -> L18 IOException -> L20
        r15.close();     // Catch: Throwable -> L14 IOException -> L16
        monitor-exit(this);
        return r16;
    L17:
        return null;
    L20:
        e = e;
    L26:
        VolleyLog.d("%s: %s", new Object[]{r14.getAbsolutePath(), e.toString()});     // Catch: Throwable -> L18
        remove(r10);     // Catch: Throwable -> L18
        if (r15 != null) goto L43;
    L32:
        monitor-exit(this);
        return null;
    L43:
        r15.close();     // Catch: Throwable -> L14 IOException -> L30
    L31:
        return null;
    L24:
        e = e;
        r15 = null;
    L22:
        th = th;
    L34:
        if (0 != 0) goto L47;
    L39:
        throw th;     // Catch: Throwable -> L14
    L47:
        r12.close();     // Catch: Throwable -> L14 IOException -> L37
    L38:
        return null;
    L18:
        th = th;
    L14:
        th = move-exception;
        throw th;
    }

    public File getFileForKey(String r10) {
        return new File(this.mRootDirectory, getFilenameForKey(r10));
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mRootDirectory.exists() == false) goto L6;
        File[] r10 = this.mRootDirectory.listFiles();     // Catch: Throwable -> L9
        if (r10 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        int r11 = r10.length;     // Catch: Throwable -> L9
        int r12 = 0;
    L18:
        if (r12 >= r11) goto L39;
        File r13 = r10[r12];     // Catch: Throwable -> L9
        BufferedInputStream r14 = null;
        BufferedInputStream r15 = new BufferedInputStream(new FileInputStream(r13));     // Catch: Throwable -> L28 IOException -> L45
        goto L30
    L53:
        CacheHeader r16 = CacheHeader.readHeader(r15);     // Catch: Throwable -> L25 IOException -> L27
        r16.size = r13.length();     // Catch: Throwable -> L25 IOException -> L27
        putEntry(r16.key, r16);     // Catch: Throwable -> L25 IOException -> L27
        r15.close();     // Catch: Throwable -> L9 IOException -> L43
    L38:
        r12 = r12 + 1;
        goto L18
    L27:
        r14 = r15;
    L25:
        th = th;
        r14 = r15;
    L33:
        if (r14 != null) goto L49;
    L35:
        throw th;     // Catch: Throwable -> L9
    L49:
        r14.close();     // Catch: Throwable -> L9 IOException -> L44
    L28:
        th = th;
    L30:
        if (r13 == null) goto L36;
        r13.delete();     // Catch: Throwable -> L28
    L36:
        if (r14 == null) goto L38;
        r14.close();     // Catch: Throwable -> L9 IOException -> L43
        goto L38
    L39:
        monitor-exit(this);
        return;
    L6:
        if (this.mRootDirectory.mkdirs() == true) goto L11;
        VolleyLog.e("Unable to create cache dir %s", new Object[]{this.mRootDirectory.getAbsolutePath()});     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String r10, boolean r11) {
        monitor-enter(this);
        Cache.Entry r12 = get(r10);     // Catch: Throwable -> L8
        if (r12 == null) goto L11;
        r12.softTtl = 0;     // Catch: Throwable -> L8
        if (r11 == false) goto L10;
        r12.ttl = 0;     // Catch: Throwable -> L8
    L10:
        put(r10, r12);     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String r10, Cache.Entry r11) {
        monitor-enter(this);
        pruneIfNeeded(r11.data.length);     // Catch: Throwable -> L9
        File r12 = getFileForKey(r10);     // Catch: Throwable -> L9
        BufferedOutputStream r13 = new BufferedOutputStream(new FileOutputStream(r12));     // Catch: Throwable -> L9 IOException -> L13
        CacheHeader r14 = new CacheHeader(r10, r11);     // Catch: Throwable -> L9 IOException -> L13
        if (r14.writeHeader(r13) == false) goto L11;
        r13.write(r11.data);     // Catch: Throwable -> L9 IOException -> L13
        r13.close();     // Catch: Throwable -> L9 IOException -> L13
        putEntry(r10, r14);     // Catch: Throwable -> L9 IOException -> L13
        monitor-exit(this);
        return;
    L11:
        r13.close();     // Catch: Throwable -> L9 IOException -> L13
        VolleyLog.d("Failed to write header for %s", new Object[]{r12.getAbsolutePath()});     // Catch: Throwable -> L9 IOException -> L13
        throw new IOException();     // Catch: Throwable -> L9 IOException -> L13
    L14:
        if (r12.delete() == true) goto L22;
        VolleyLog.d("Could not clean up file %s", new Object[]{r12.getAbsolutePath()});     // Catch: Throwable -> L9
        return;
    L22:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String r10) {
        monitor-enter(this);
        boolean r11 = getFileForKey(r10).delete();     // Catch: Throwable -> L7
        removeEntry(r10);     // Catch: Throwable -> L7
        if (r11 == true) goto L9;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{r10, getFilenameForKey(r10)});     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public DiskBasedCache(File r10) {
        this(r10, DEFAULT_DISK_USAGE_BYTES);
    }
}
