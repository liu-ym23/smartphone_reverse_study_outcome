package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes17.dex */
final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    public static class ExtractedDex extends File {

        /* JADX INFO: renamed from: crc, reason: collision with root package name */
        public long f15580crc;

        public ExtractedDex(File r100, String r101) {
            super(r100, r101);
            this.f15580crc = -1;
        }
    }

    private void clearDexDir() {
        File[] r100 = this.dexDir.listFiles(new AnonymousClass1(this));
        if (r100 != null) goto L6;
        this.dexDir.getPath();
        return;
    L6:
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L13;
        File r103 = r100[r102];
        r103.getPath();
        r103.length();
        if (r103.delete() == true) goto L11;
        r103.getPath();
    L12:
        r102 = r102 + 1;
        goto L7
    L11:
        r103.getPath();
        goto L12
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        String r100 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList r101 = new ArrayList();
        ZipFile r102 = new ZipFile(this.sourceApk);
        ZipEntry r103 = r102.getEntry("classes2.dex");     // Catch: Throwable -> L24
        int r104 = 2;
    L4:
        if (r103 == null) goto L35;
        ExtractedDex r105 = new ExtractedDex(this.dexDir, r100 + r104 + ".zip");     // Catch: Throwable -> L24
        r101.add(r105);     // Catch: Throwable -> L24
        r105.toString();     // Catch: Throwable -> L24
        int r106 = 0;
        boolean r107 = false;
    L7:
        if (r106 >= 3) goto L18;
        if (r107 == true) goto L18;
        r106 = r106 + 1;     // Catch: Throwable -> L24
        extract(r102, r103, r105, r100);     // Catch: Throwable -> L24
        r105.f15580crc = getZipCrc(r105);     // Catch: IOException -> L12 Throwable -> L24
        r107 = true;
    L13:
        r105.getAbsolutePath();     // Catch: Throwable -> L24
        r105.length();     // Catch: Throwable -> L24
        if (r107 == true) goto L7;
        r105.delete();     // Catch: Throwable -> L24
        if (r105.exists() == false) goto L7;
        r105.getPath();     // Catch: Throwable -> L24
        goto L7
    L12:
        r105.getAbsolutePath();     // Catch: Throwable -> L24
        r107 = false;
    L18:
        if (r107 == false) goto L21;
        r104 = r104 + 1;     // Catch: Throwable -> L24
        r103 = r102.getEntry(DEX_PREFIX + r104 + ".dex");     // Catch: Throwable -> L24
        goto L4
    L21:
        throw new IOException("Could not create zip file " + r105.getAbsolutePath() + " for secondary dex (" + r104 + ")");     // Catch: Throwable -> L24
    L35:
        r102.close();     // Catch: IOException -> L27
    L23:
        return r101;
    L24:
        th = move-exception;
        r102.close();     // Catch: IOException -> L28
    L26:
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    private static void closeQuietly(Closeable r100) {
        r100.close();     // Catch: IOException -> L4
        return;
    }

    private static SharedPreferences getMultiDexPreferences(Context r100) {
        return r100.getSharedPreferences(PREFS_FILE, 4);
    }

    private static long getTimeStamp(File r100) {
        long r101 = r100.lastModified();
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    private static long getZipCrc(File r100) throws IOException {
        long r101 = ZipUtil.getZipCrc(r100);
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    public MultiDexExtractor(File r100, File r101) throws IOException {
        r100.getPath();
        r101.getPath();
        this.sourceApk = r100;
        this.dexDir = r101;
        this.sourceCrc = getZipCrc(r100);
        File r102 = new File(r101, LOCK_FILENAME);
        RandomAccessFile r103 = new RandomAccessFile(r102, "rw");
        this.lockRaf = r103;
        FileChannel r104 = r103.getChannel();     // Catch: Error -> L14 RuntimeException -> L16 Throwable -> L18
        this.lockChannel = r104;     // Catch: Error -> L14 RuntimeException -> L16 Throwable -> L18
        r102.getPath();     // Catch: Error -> L7 RuntimeException -> L9 IOException -> L11
        this.cacheLock = r104.lock();     // Catch: Error -> L7 RuntimeException -> L9 IOException -> L11
        r102.getPath();     // Catch: Error -> L14 RuntimeException -> L16 Throwable -> L18
        return;
    L11:
        e = e;
    L12:
        closeQuietly(this.lockChannel);     // Catch: Error -> L14 RuntimeException -> L16 Throwable -> L18
        throw e;     // Catch: Error -> L14 RuntimeException -> L16 Throwable -> L18
    L7:
        e = e;
    L9:
        e = e;
    L18:
        e = move-exception;
        closeQuietly(this.lockRaf);
        throw e;
    }

    private List<ExtractedDex> loadExistingExtractions(Context r110, String r111) throws IOException {
        String r100 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences r101 = getMultiDexPreferences(r110);
        int r102 = r101.getInt(r111 + KEY_DEX_NUMBER, 1);
        ArrayList r103 = new ArrayList(r102 + (-1));
        int r104 = 2;
    L3:
        if (r104 > r102) goto L15;
        ExtractedDex r105 = new ExtractedDex(this.dexDir, r100 + r104 + ".zip");
        if (r105.isFile() == false) goto L14;
        r105.f15580crc = getZipCrc(r105);
        long r112 = r101.getLong(r111 + KEY_DEX_CRC + r104, -1);
        long r106 = r101.getLong(r111 + KEY_DEX_TIME + r104, -1);
        long r113 = r105.lastModified();
        if (r106 != r113) goto L12;
        String r107 = r100;
        SharedPreferences r114 = r101;
        if (r112 != r105.f15580crc) goto L12;
        r103.add(r105);
        r104 = r104 + 1;
        r101 = r114;
        r100 = r107;
    L12:
        throw new IOException("Invalid extracted dex: " + r105 + " (key \"" + r111 + "\"), expected modification time: " + r106 + ", modification time: " + r113 + ", expected crc: " + r112 + ", file crc: " + r105.f15580crc);
    L14:
        throw new IOException("Missing extracted secondary dex file '" + r105.getPath() + "'");
    L15:
        return r103;
    }

    public List<? extends File> load(Context r110, String r111, boolean r112) throws IOException {
        this.sourceApk.getPath();
        if (this.cacheLock.isValid() == false) goto L14;
        if (r112 == false) goto L6;
    L10:
        List<ExtractedDex> r100 = performExtractions();
        putStoredApkInfo(r110, r111, getTimeStamp(this.sourceApk), this.sourceCrc, r100);
    L11:
        r100.size();
        return r100;
    L6:
        if (isModified(r110, this.sourceApk, this.sourceCrc, r111) == true) goto L10;
        r100 = loadExistingExtractions(r110, r111);     // Catch: IOException -> L9
    L9:
        r100 = performExtractions();
        putStoredApkInfo(r110, r111, getTimeStamp(this.sourceApk), this.sourceCrc, r100);
        goto L11
    L14:
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    private static void extract(ZipFile r100, ZipEntry r101, File r102, String r103) throws IOException, FileNotFoundException {
        InputStream r104 = r100.getInputStream(r101);
        File r105 = File.createTempFile("tmp-" + r103, ".zip", r102.getParentFile());
        r105.getPath();
        ZipOutputStream r106 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(r105)));     // Catch: Throwable -> L22
        ZipEntry r107 = new ZipEntry("classes.dex");     // Catch: Throwable -> L19
        r107.setTime(r101.getTime());     // Catch: Throwable -> L19
        r106.putNextEntry(r107);     // Catch: Throwable -> L19
        byte[] r108 = new byte[16384];     // Catch: Throwable -> L19
        int r109 = r104.read(r108);     // Catch: Throwable -> L19
    L6:
        if (r109 == (-1)) goto L8;
        r106.write(r108, 0, r109);     // Catch: Throwable -> L19
        r109 = r104.read(r108);     // Catch: Throwable -> L19
        goto L6
    L8:
        r106.closeEntry();     // Catch: Throwable -> L19
        r106.close();     // Catch: Throwable -> L22
        if (r105.setReadOnly() == false) goto L18;
        r102.getPath();     // Catch: Throwable -> L22
        if (r105.renameTo(r102) == false) goto L16;
        closeQuietly(r104);
        r105.delete();
        return;
    L16:
        throw new IOException("Failed to rename \"" + r105.getAbsolutePath() + "\" to \"" + r102.getAbsolutePath() + "\"");     // Catch: Throwable -> L22
    L18:
        throw new IOException("Failed to mark readonly \"" + r105.getAbsolutePath() + "\" (tmp of \"" + r102.getAbsolutePath() + "\")");     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        closeQuietly(r104);
        r105.delete();
        throw th;
    }

    private static boolean isModified(Context r100, File r101, long r102, String r110) {
        SharedPreferences r103 = getMultiDexPreferences(r100);
        if (r103.getLong(r110 + "timestamp", -1) == getTimeStamp(r101)) goto L5;
    L8:
        return true;
    L5:
        if (r103.getLong(r110 + KEY_CRC, -1) != r102) goto L8;
        return false;
    }

    private static void putStoredApkInfo(Context r100, String r101, long r102, long r103, List<ExtractedDex> r104) {
        SharedPreferences.Editor r105 = getMultiDexPreferences(r100).edit();
        r105.putLong(r101 + "timestamp", r102);
        r105.putLong(r101 + KEY_CRC, r103);
        r105.putInt(r101 + KEY_DEX_NUMBER, r104.size() + 1);
        Iterator<ExtractedDex> r106 = r104.iterator();
        int r107 = 2;
    L4:
        if (r106.hasNext() == false) goto L6;
        ExtractedDex r108 = r106.next();
        r105.putLong(r101 + KEY_DEX_CRC + r107, r108.f15580crc);
        r105.putLong(r101 + KEY_DEX_TIME + r107, r108.lastModified());
        r107 = r107 + 1;
        goto L4
    L6:
        r105.commit();
    }
}
