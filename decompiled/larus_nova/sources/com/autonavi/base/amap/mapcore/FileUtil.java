package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.mapcore.util.t6;
import com.amap.api.mapcore.util.w3;
import com.amap.api.mapcore.util.z3;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static class UnZipFileBrake {
        public boolean mIsAborted;

        public UnZipFileBrake() {
            this.mIsAborted = false;
        }
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long r100);
    }

    public static void createNoMediaFileIfNotExist(String r100) {
    }

    public FileUtil() {
    }

    public static boolean checkCanWrite(File r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.canWrite() == true) goto L8;
        return false;
    L8:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "amap.tmp");
        r101.createNewFile();     // Catch: IOException -> L19
        if (r101.exists() == true) goto L24;
        return false;
    L24:
        r101.delete();     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static byte[] compress(byte[] r100) {
        GZIPOutputStream r101 = null;
        if (r100 != null) goto L5;
    L23:
        return null;
    L5:
        if (r100.length == 0) goto L23;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        GZIPOutputStream r103 = new GZIPOutputStream(r102);     // Catch: IOException -> L15 Throwable -> L20
        r103.write(r100);     // Catch: Throwable -> L11 IOException -> L13
        r103.close();     // Catch: Throwable -> L11 IOException -> L13
    L18:
        safelyCloseFile(r103);
        return r102.toByteArray();
    L13:
        e = e;
        r101 = r103;
    L16:
        e.getMessage();     // Catch: Throwable -> L20
        r103 = r101;
    L11:
        th = th;
        r101 = r103;
    L21:
        safelyCloseFile(r101);
        throw th;
    L20:
        th = th;
    L15:
        e = e;
        goto L16
    }

    public static boolean deleteFile(File r100) {
        if (r100 != null) goto L5;
    L26:
        return false;
    L5:
        if (r100.exists() == false) goto L26;
        if (r100.isDirectory() == false) goto L24;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L24;
        int r102 = 0;
    L13:
        if (r102 >= r101.length) goto L24;
        if (r101[r102].isFile() == false) goto L20;
        if (r101[r102].delete() == true) goto L23;
        return false;
    L23:
        r102 = r102 + 1;
        goto L13
    L20:
        if (deleteFile(r101[r102]) == false) goto L21;
        r101[r102].delete();
        goto L23
    L21:
        return false;
    L24:
        r100.delete();
        return true;
    }

    private static void fileProber(File r100) {
        File r101 = r100.getParentFile();
        if (r101.exists() == true) goto L6;
        fileProber(r101);
        r101.mkdir();
        return;
    }

    public static String getExternalStroragePath(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.getExternalFilesDir("").getAbsolutePath() + File.separatorChar;
    }

    public static String getMapBaseStorage(Context r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        SharedPreferences r102 = r100.getSharedPreferences("base_path", 0);
        String r103 = MapsInitializer.sdcardDir;
        if (r103 != null) goto L8;
    L10:
        String r104 = r102.getString("map_base_path_v44", "");
        String r105 = getExternalStroragePath(r100);
        if (r104 != null) goto L13;
    L15:
        r101 = r104;
    L17:
        if (r101 != null) goto L19;
    L38:
        String r106 = getExternalStroragePath(r100) + AeUtil.ROOTPATH;
        if (r106 != null) goto L41;
    L51:
        String r107 = r100.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (r107 != null) goto L54;
    L59:
        return r107;
    L54:
        if (r107.length() <= 2) goto L59;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107);
        if (r108.exists() == true) goto L58;
        r108.mkdir();
    L58:
        r108.isDirectory();
        goto L59
    L41:
        if (r106.length() <= 2) goto L51;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r106);
        if (r109.exists() == true) goto L46;
        r109.mkdir();
    L46:
        if (r109.isDirectory() == false) goto L51;
        if (r109.canWrite() == false) goto L51;
        SharedPreferences.Editor r110 = r102.edit();
        r110.putString("map_base_path_v44", r106);
        r110.commit();
        createNoMediaFileIfNotExist(r106);
        return r106;
    L19:
        if (r101.length() <= 2) goto L38;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r101);
        if (r111.exists() == true) goto L24;
        r111.mkdir();
    L24:
        if (r111.isDirectory() == false) goto L38;
        if (checkCanWrite(r111) == false) goto L28;
        return r101;
    L28:
        String r112 = r100.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (r112 == null) goto L38;
        if (r112.length() <= 2) goto L38;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r112);
        if (r113.exists() == true) goto L36;
        r113.mkdir();
    L36:
        if (r113.isDirectory() == false) goto L38;
        return r112;
    L13:
        if (r104.contains(r105) == true) goto L15;
    L8:
        if (r103.trim().length() <= 0) goto L10;
        r101 = MapsInitializer.sdcardDir + File.separatorChar;
        goto L17
    }

    public static String getName(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.substring(indexOfLastSeparator(r100) + 1);
    }

    private static InputStream getZipInputStream(byte[] r100) throws IOException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L14;
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);
        if (isGzip(r100) == false) goto L11;
        return new GZIPInputStream(r101);
    L11:
        return new ZipInputStream(r101);
    L14:
        return null;
    }

    public static int indexOfLastSeparator(String r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return Math.max(r100.lastIndexOf(47), r100.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] r100) {
        int r101 = r100[0] << 8;
        if (((r100[1] & UByte.MAX_VALUE) | r101) != 8075) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isSafeEntryName(String r100) {
        if (r100.contains("..") == false) goto L5;
        return false;
    L5:
        if (r100.contains(FILE_PATH_ENTRY_SEPARATOR1) == false) goto L7;
        return false;
    L7:
        if (r100.contains("%") == true) goto L13;
        return true;
    L13:
        return false;
    }

    private static byte[] readByteByStream(InputStream r100) throws IOException {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[] r101 = new byte[1024];
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
    L18:
        int r103 = r100.read(r101);     // Catch: Throwable -> L12 IOException -> L14
        if (r103 == (-1)) goto L9;
        r102.write(r101, 0, r103);     // Catch: Throwable -> L12 IOException -> L14
        goto L18
    L9:
        byte[] r104 = r102.toByteArray();     // Catch: Throwable -> L12 IOException -> L14
        safelyCloseFile(r102);
        return r104;
    L12:
        th = move-exception;
        safelyCloseFile(r102);
        throw th;
    L14:
        e = move-exception;
        throw e;     // Catch: Throwable -> L12
    }

    public static byte[] readFileContents(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L20
        if (r101.exists() == true) goto L7;
        safelyCloseFile(null);
        safelyCloseFile(null);
        return null;
    L7:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L20
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L18
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
    L30:
        int r105 = r102.read(r103);     // Catch: Throwable -> L16
        if (r105 == (-1)) goto L13;
        r104.write(r103, 0, r105);     // Catch: Throwable -> L16
        goto L30
    L13:
        byte[] r106 = r104.toByteArray();     // Catch: Throwable -> L16
        safelyCloseFile(r104);
        safelyCloseFile(r102);
        return r106;
    L16:
        Throwable th10 = th;
    L34:
        t6.a(th10, TAG, "readFileContents");     // Catch: Throwable -> L27
        w3.a(th10);     // Catch: Throwable -> L27
        z3.a("[map][function][res]", "read file from disk failed " + th10.getMessage());     // Catch: Throwable -> L27
        safelyCloseFile(r104);
        safelyCloseFile(r102);
        return null;
    L27:
        th = move-exception;
        safelyCloseFile(r104);
        safelyCloseFile(r102);
        throw th;
    L18:
        th10 = th;
        r104 = null;
    L20:
        th = move-exception;
        th10 = th;
        r102 = null;
        r104 = null;
        goto L34
    }

    private static void safelyCloseFile(InputStream r100) {
        if (r100 == null) goto L11;
        if ((r100 instanceof ZipInputStream) == false) goto L6;
        ((ZipInputStream) r100).closeEntry();     // Catch: Throwable -> L8
    L6:
        r100.close();     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    public static byte[] uncompress(byte[] r100) {
        if (r100 != null) goto L5;
    L29:
        return null;
    L5:
        if (r100.length == 0) goto L29;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        InputStream r102 = getZipInputStream(r100);     // Catch: Throwable -> L21
        if (r102 != null) goto L32;
        safelyCloseFile(r102);
    L25:
        return null;
    L32:
        byte[] r103 = new byte[256];     // Catch: Throwable -> L18
    L12:
        int r104 = r102.read(r103);     // Catch: Throwable -> L18
        if (r104 < 0) goto L15;
        r101.write(r103, 0, r104);     // Catch: Throwable -> L18
        goto L12
    L15:
        byte[] r105 = r101.toByteArray();     // Catch: Throwable -> L18
        safelyCloseFile(r102);
        return r105;
    L18:
        th = th;
    L30:
        th.getMessage();     // Catch: Throwable -> L26
        safelyCloseFile(r102);
    L26:
        th = move-exception;
        safelyCloseFile(r102);
        throw th;
    L21:
        th = th;
        r102 = null;
        goto L30
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] r100) {
        if (r100 != null) goto L5;
    L37:
        return null;
    L5:
        if (r100.length == 0) goto L37;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        InputStream r102 = getZipInputStream(r100);     // Catch: Throwable -> L29
    L27:
        th = th;
    L40:
        th.getMessage();     // Catch: Throwable -> L34
        safelyCloseFile(r102);
    L33:
        return null;
    L34:
        th = move-exception;
        safelyCloseFile(r102);
        throw th;
    L10:
        if ((r102 instanceof ZipInputStream) == false) goto L16;
        String r103 = ((ZipInputStream) r102).getNextEntry().getName();     // Catch: Throwable -> L27
        if (isSafeEntryName(r103) == false) goto L14;
    L17:
        if (r102 != null) goto L19;
        safelyCloseFile(r102);
        goto L33
    L19:
        byte[] r104 = new byte[256];     // Catch: Throwable -> L27
    L20:
        int r105 = r102.read(r104);     // Catch: Throwable -> L27
        if (r105 < 0) goto L23;
        r101.write(r104, 0, r105);     // Catch: Throwable -> L27
        goto L20
    L23:
        Pair<String, byte[]> r106 = new Pair(r103, r101.toByteArray());     // Catch: Throwable -> L27
        safelyCloseFile(r102);
        return r106;
    L14:
        safelyCloseFile(r102);
        return null;
    L16:
        r103 = "";
    L29:
        th = th;
        r102 = null;
        goto L40
    }

    public static byte[] uncompressToByteArray(byte[] r100) {
        if (r100 != null) goto L5;
    L27:
        return null;
    L5:
        if (r100.length == 0) goto L27;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        GZIPInputStream r103 = new GZIPInputStream(r102);     // Catch: Throwable -> L19
        byte[] r104 = new byte[256];     // Catch: Throwable -> L17
    L11:
        int r105 = r103.read(r104);     // Catch: Throwable -> L17
        if (r105 < 0) goto L14;
        r101.write(r104, 0, r105);     // Catch: Throwable -> L17
        goto L11
    L14:
        byte[] r106 = r101.toByteArray();     // Catch: Throwable -> L17
        GLFileUtil.closeQuietly(r101);
        GLFileUtil.closeQuietly(r102);
        GLFileUtil.closeQuietly(r103);
        return r106;
    L17:
        Throwable th10 = th;
    L32:
        w3.a(th10);     // Catch: Throwable -> L24
        th10.printStackTrace();     // Catch: Throwable -> L24
        GLFileUtil.closeQuietly(r101);
        GLFileUtil.closeQuietly(r102);
        GLFileUtil.closeQuietly(r103);
        return null;
    L24:
        th = move-exception;
        GLFileUtil.closeQuietly(r101);
        GLFileUtil.closeQuietly(r102);
        GLFileUtil.closeQuietly(r103);
        throw th;
    L19:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L32
    }

    public static String uncompressToString(byte[] r100) {
        return uncompressToString(r100, "UTF-8");
    }

    private static void safelyCloseFile(OutputStream r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static byte[] compress(String r100, String r101) {
        GZIPOutputStream r102 = null;
        if (r100 != null) goto L5;
    L23:
        return null;
    L5:
        if (r100.length() == 0) goto L23;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        GZIPOutputStream r104 = new GZIPOutputStream(r103);     // Catch: IOException -> L15 Throwable -> L20
        r104.write(r100.getBytes(r101));     // Catch: Throwable -> L11 IOException -> L13
        r104.close();     // Catch: Throwable -> L11 IOException -> L13
    L18:
        safelyCloseFile(r104);
        return r103.toByteArray();
    L13:
        e = e;
        r102 = r104;
    L16:
        e.getMessage();     // Catch: Throwable -> L20
        r104 = r102;
    L11:
        th = th;
        r102 = r104;
    L21:
        safelyCloseFile(r102);
        throw th;
    L20:
        th = th;
    L15:
        e = e;
        goto L16
    }

    public static void decompress(InputStream r100, String r101) throws Exception {
        decompress(r100, r101, 0, null);
    }

    public static void saveFileContents(String r100, byte[] r101) {
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: Throwable -> L8
        r102.write(r101);     // Catch: Throwable -> L6
    L13:
        safelyCloseFile(r102);
        return;
    L6:
        Throwable th10 = th;
    L22:
        t6.a(th10, TAG, "saveFileContents");     // Catch: Throwable -> L15
        w3.a(th10);     // Catch: Throwable -> L15
        z3.a("[map][function][res]", "save file from disk failed " + th10.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        safelyCloseFile(r102);
        throw th;
    L8:
        th = move-exception;
        th10 = th;
        r102 = null;
        goto L22
    }

    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] r100, String[] r101) {
        HashMap r102 = new HashMap();
        if (r100 != null) goto L5;
    L48:
        return r102;
    L5:
        if (r100.length == 0) goto L48;
        InputStream r103 = null;
        InputStream r104 = getZipInputStream(r100);     // Catch: Throwable -> L41
    L39:
        th = th;
        r103 = r104;
    L49:
        th.getMessage();     // Catch: Throwable -> L45
        safelyCloseFile(r103);
    L44:
        return r102;
    L45:
        th = move-exception;
        safelyCloseFile(r103);
        throw th;
    L10:
        if ((r104 instanceof ZipInputStream) == false) goto L38;
        ZipInputStream r105 = (ZipInputStream) r104;     // Catch: Throwable -> L39
    L12:
        ZipEntry r106 = r105.getNextEntry();     // Catch: Throwable -> L39
        if (r106 == null) goto L38;
        if (r106.isDirectory() == true) goto L36;
        String r107 = r106.getName();     // Catch: IOException -> L34 Throwable -> L39
        if (isSafeEntryName(r107) == true) goto L21;
    L19:
        safelyCloseFile(r104);
        return null;
    L21:
        if (r101 != null) goto L25;
        byte[] r108 = readByteByStream(r105);     // Catch: IOException -> L34 Throwable -> L39
        if (r108 == null) goto L36;
        r102.put(r107, r108);     // Catch: IOException -> L34 Throwable -> L39
        goto L36
    L25:
        int r109 = r101.length;     // Catch: IOException -> L34 Throwable -> L39
        int r110 = 0;
    L26:
        if (r110 >= r109) goto L36;
        String r111 = r101[r110];     // Catch: IOException -> L34 Throwable -> L39
        if (r107.equals(r111) == true) goto L29;
        r110 = r110 + 1;
        goto L26
    L29:
        byte[] r112 = readByteByStream(r105);     // Catch: IOException -> L34 Throwable -> L39
        if (r112 == null) goto L36;
        r102.put(r111, r112);     // Catch: IOException -> L34 Throwable -> L39
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
    L36:
        r105.closeEntry();     // Catch: Throwable -> L39
    L38:
        safelyCloseFile(r104);
    L41:
        th = th;
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static String uncompressToString(byte[] r100, String r101) {
        ?? r102 = 0;
        if (r100 != null) goto L5;
    L32:
        return null;
    L5:
        if (r100.length == 0) goto L32;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        InputStream r104 = getZipInputStream(r100);     // Catch: Throwable -> L23 IOException -> L25
        if (r104 != null) goto L34;
        safelyCloseFile(r104);
    L29:
        return null;
    L34:
        byte[] r105 = new byte[256];     // Catch: Throwable -> L18 IOException -> L20
    L12:
        int r106 = r104.read(r105);     // Catch: Throwable -> L18 IOException -> L20
        if (r106 < 0) goto L15;
        r103.write(r105, 0, r106);     // Catch: Throwable -> L18 IOException -> L20
        goto L12
    L15:
        String r107 = r103.toString(r101);     // Catch: Throwable -> L18 IOException -> L20
        safelyCloseFile(r104);
        return r107;
    L20:
        e = e;
    L27:
        e.getMessage();     // Catch: Throwable -> L18
        safelyCloseFile(r104);
        goto L29
    L18:
        th = th;
        r102 = r100;
    L30:
        safelyCloseFile(r102);
        throw th;
    L25:
        e = e;
        r104 = null;
    L23:
        th = th;
        goto L30
    }

    public static void writeDatasToFile(String r100, byte[] r101) {
        ReentrantReadWriteLock.WriteLock r102 = new ReentrantReadWriteLock().writeLock();
        r102.lock();
        PolarisFileOutputStreamWrapper r103 = null;
        if (r101 != null) goto L31;
    L27:
        r102.unlock();
        safelyCloseFile(null);
        return;
    L31:
    L19:
        e = move-exception;
        Exception e100 = e;
    L29:
        e100.printStackTrace();     // Catch: Throwable -> L24
        r102.unlock();
        safelyCloseFile(r103);
        return;
    L24:
        Throwable th10 = th;
    L25:
        r102.unlock();
        safelyCloseFile(r103);
        throw th10;
    L17:
        th = move-exception;
        th10 = th;
        goto L25
    L5:
        if (r101.length == 0) goto L27;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L17 Exception -> L19
        if (r104.exists() == false) goto L10;
        r104.delete();     // Catch: Throwable -> L17 Exception -> L19
    L10:
        r104.createNewFile();     // Catch: Throwable -> L17 Exception -> L19
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L17 Exception -> L19
    L33:
        r105.write(r101);     // Catch: Throwable -> L13 Exception -> L15
        r105.flush();     // Catch: Throwable -> L13 Exception -> L15
        r102.unlock();
        safelyCloseFile(r105);
        return;
    L15:
        e100 = e;
        r103 = r105;
    L13:
        th10 = th;
        r103 = r105;
        goto L25
    }

    private static void decompress(InputStream r100, String r110, long r111, ZipCompressProgressListener r112) throws Exception {
        CheckedInputStream r101 = new CheckedInputStream(r100, new CRC32());
        ZipInputStream r102 = new ZipInputStream(r101);
        decompress(null, new PolarisFileWrapper(r110), r102, r111, r112, null);
        r102.close();
        r101.close();
    }

    private static void decompress(File r110, File r111, ZipInputStream r112, long r113, ZipCompressProgressListener r114, UnZipFileBrake r115) throws Exception {
        boolean r100 = false;
        int r116 = 0;
    L3:
        ZipEntry r101 = r112.getNextEntry();
        if (r101 == null) goto L21;
        if (r115 != null) goto L7;
    L10:
        String r102 = r101.getName();
        if (TextUtils.isEmpty(r102) == true) goto L20;
        if (isSafeEntryName(r102) == false) goto L20;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111.getPath() + File.separator + r102);
        fileProber(r103);
        if (r101.isDirectory() == false) goto L18;
        r103.mkdirs();
    L19:
        r112.closeEntry();
        goto L3
    L18:
        r116 = r116 + decompressFile(r103, r112, r116, r113, r114, r115);
    L20:
        r100 = true;
        goto L21
    L7:
        if (r115.mIsAborted == false) goto L10;
        r112.closeEntry();
        return;
    L21:
        if (r100 == false) goto L34;
        if (r110 == null) goto L35;
        r110.delete();     // Catch: Exception -> L25
        return;
    L36:
        return;
    L35:
        return;
    }

    private static int decompressFile(File r100, ZipInputStream r101, long r110, long r111, ZipCompressProgressListener r112, UnZipFileBrake r113) throws Exception {
        BufferedOutputStream r102 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r100));
        byte[] r103 = new byte[1024];
        int r104 = 0;
    L3:
        int r105 = r101.read(r103, 0, 1024);
        if (r105 == (-1)) goto L18;
        if (r113 != null) goto L7;
    L10:
        r102.write(r103, 0, r105);
        r104 = r104 + r105;
        if (r111 <= 0) goto L3;
        if (r112 == null) goto L3;
        long r106 = ((((long) r104) + r110) * 100) / r111;
        if (r113 == null) goto L17;
        if (r113.mIsAborted == true) goto L3;
    L17:
        r112.onFinishProgress(r106);
        goto L3
    L7:
        if (r113.mIsAborted == false) goto L10;
        r102.close();
        return r104;
    L18:
        r102.close();
        return r104;
    }
}
