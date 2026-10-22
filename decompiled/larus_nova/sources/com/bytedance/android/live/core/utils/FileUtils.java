package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes45.dex */
public class FileUtils {
    public static final String BEAUTY = "beauty";
    private static final int BYTE_PER_KB = 1024;
    public static final String CACHE_DIR = "huoshan/cache";
    public static final String DIR_VIDEO_EDIT = "VideoEdit";
    private static final String EDIT_MUSIC = "edit_music";
    public static final String FEED_CACHE = "feed";
    public static final String FILTER = "filter";
    public static final String MODEL = "models";
    public static final String PICTURE = "picture";
    public static final String PICTURE_THEME = "theme";
    public static final String QRCODE = "qrcode";
    private static final int RADIX = 16;
    public static final String RESHARP = "resharp";
    public static final String SDKLOG = "sdklog";
    public static final String SDKLOG_UPLOAD = "sdklog_upload";
    public static final String SEGMENT_ROOT = "segment_draft";
    public static final String STICKER = "sticker";
    public static final String TAG = "file_path";
    public static final String TMP = "/tmp/";
    private static final String UNIT_B = "unit_b";
    public static final String UNIT_KB = "unit_kb";
    public static final String UNIT_MB = "unit_mb";
    public static final String VIDEO = "video";
    public static final String VIDEO_TMP = "video_tmp";
    static final String[] VIDEO_TYPE = null;

    static {
        VIDEO_TYPE = new String[]{"mp4", "flv", "mov", "mkv"};
    }

    public static boolean isSdcardWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    L4:
        return false;
    }

    private FileUtils() {
    }

    public static String calculateMD5(File r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L18
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        byte[] r103 = new byte[8192];
    L30:
        int r104 = r102.read(r103);     // Catch: Throwable -> L11 IOException -> L13
        if (r104 <= 0) goto L8;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L11 IOException -> L13
        goto L30
    L8:
        String r105 = String.format("%32s", new Object[]{new BigInteger(1, r101.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L11 IOException -> L13
        r102.close();     // Catch: IOException -> L19
    L10:
        return r105;
    L11:
        th = move-exception;
        r102.close();     // Catch: IOException -> L20
    L17:
        throw th;
    L22:
        r102.close();     // Catch: IOException -> L21
    L15:
        return "";
    L18:
        return null;
    }

    public static boolean checkFileExists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r100).exists();
    }

    public static boolean ensureDirExists(File r100) {
        if (r100 == null) goto L7;
        if (r100.exists() == true) goto L7;
        r100.mkdirs();
    L7:
        return r100.exists();
    }

    public static File getExternalCacheDir(Context r100) {
        File r101 = r100.getExternalCacheDir();
        if (r101 == null) goto L5;
        ensureDirExists(r101);
        Logger.d("file_path", "cache path:" + r101.getAbsolutePath());
    L6:
        return r101;
    L5:
        Logger.d("file_path", "cache path: is null");
        goto L6
    }

    public static long getFileSize(File r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.exists() == false) goto L16;
    L17:
        return new PolarisFileInputStreamWrapper(r100).available();
    L11:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L16:
        return 0;
    }

    public static boolean isFileEmpty(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return true;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return true;
    L8:
        if (r101.length() <= 0) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isGIF(File r100) {
        String r101 = r100.getName().substring(r100.getName().lastIndexOf(".") + 1);
        if ("gif".equals(r101) == false) goto L5;
    L9:
        return true;
    L5:
        if ("webp".equals(r101) == true) goto L9;
        return false;
    }

    public static boolean isVideo(File r100) {
        String r101 = r100.getName().substring(r100.getName().lastIndexOf(".") + 1);
        String[] r102 = VIDEO_TYPE;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        if (r102[r104].equals(r101) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public static String readFromFile(File r100) {
        String r101 = "";
        if (checkFileExists(r100.getPath()) == true) goto L52;
        return "";
    L52:
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L25 Exception -> L27
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L21 Exception -> L23
    L56:
        String r104 = r103.readLine();     // Catch: Exception -> L19 Throwable -> L38
        if (r104 == null) goto L59;
        r101 = r101 + r104;     // Catch: Exception -> L19 Throwable -> L38
        goto L56
    L59:
        r102.close();     // Catch: IOException -> L13
    L15:
        r103.close();     // Catch: IOException -> L17
    L51:
    L37:
        return r101;
    L13:
        e = move-exception;
        e.printStackTrace();
    L19:
        Exception e100 = e;
    L29:
        e100.printStackTrace();     // Catch: Throwable -> L38
        if (r102 != null) goto L63;
    L35:
        if (r103 == null) goto L37;
        r103.close();     // Catch: IOException -> L17
        goto L51
    L63:
        r102.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L38:
        Throwable th10 = th;
    L39:
        if (r102 != null) goto L61;
    L44:
        if (r103 == null) goto L69;
        r103.close();     // Catch: IOException -> L47
        throw th10;
    L47:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L69:
        throw th10;
    L61:
        r102.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L23:
        e = move-exception;
        e100 = e;
        r103 = null;
    L21:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L39
    L17:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        r102 = null;
        e100 = e;
        r103 = null;
    L25:
        th = move-exception;
        r102 = null;
        th10 = th;
        r103 = null;
        goto L39
    }

    public static void removeDir(File r100) {
        if (r100.isDirectory() == false) goto L21;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.length == 0) goto L23;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L16;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L14;
        removeDir(r104);
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r104.delete();
        goto L15
    L16:
        r100.delete();
        return;
    L23:
        return;
    }

    public static boolean removeFile(String r100) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L10;
        return false;
    L10:
        if (r101.canWrite() == true) goto L12;
        return false;
    L12:
        if (r101.delete() == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public static long getFileSize(String r100) {
        return getFileSize(new PolarisFileWrapper(r100));
    L4:
        return 0;
    }

    public static boolean isVideo(String r100) {
        r100.substring(r100.lastIndexOf(".") + 1);
        String[] r101 = VIDEO_TYPE;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101[r103].equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public static boolean fileChannelCopy(FileInputStream r100, FileOutputStream r110) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        FileChannel r101 = null;
        FileChannel r102 = r100.getChannel();     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L40
    L80:
        r101 = r110.getChannel();     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        r102.transferTo(0, r102.size(), r101);     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        r100.close();     // Catch: IOException -> L12
        r102.close();     // Catch: IOException -> L12
        r110.close();     // Catch: IOException -> L12
        if (r101 == null) goto L82;
        r101.close();     // Catch: IOException -> L12
        return true;
    L82:
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return true;
    L20:
        e = move-exception;
        FileNotFoundException r103 = e;
        FileChannel r104 = r101;
        r101 = r102;
    L42:
        r103.printStackTrace();     // Catch: Throwable -> L56
        if (r100 != null) goto L71;
    L47:
        if (r101 == null) goto L49;
        r101.close();     // Catch: IOException -> L45
    L49:
        if (r110 == null) goto L51;
        r110.close();     // Catch: IOException -> L45
    L51:
        if (r104 == null) goto L55;
        r104.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L55:
        return false;
    L71:
        r100.close();     // Catch: IOException -> L45
    L18:
        e = move-exception;
        IOException r105 = e;
        FileChannel r106 = r101;
        r101 = r102;
    L26:
        r105.printStackTrace();     // Catch: Throwable -> L56
        if (r100 != null) goto L73;
    L31:
        if (r101 == null) goto L33;
        r101.close();     // Catch: IOException -> L29
    L33:
        if (r110 == null) goto L35;
        r110.close();     // Catch: IOException -> L29
    L35:
        if (r106 == null) goto L39;
        r106.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L39:
        return false;
    L73:
        r100.close();     // Catch: IOException -> L29
    L16:
        th = th;
        FileChannel r107 = r101;
        r101 = r102;
    L57:
        if (r100 != null) goto L75;
    L61:
        if (r101 == null) goto L63;
        r101.close();     // Catch: IOException -> L59
    L63:
        if (r110 == null) goto L65;
        r110.close();     // Catch: IOException -> L59
    L65:
        if (r107 == null) goto L69;
        r107.close();     // Catch: IOException -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L69:
        throw th;
    L75:
        r100.close();     // Catch: IOException -> L59
    L56:
        th = th;
    L40:
        e = move-exception;
        r103 = e;
        r104 = null;
    L24:
        e = move-exception;
        r105 = e;
        r106 = null;
    L22:
        th = th;
        r107 = null;
        goto L57
    }

    public static boolean renameFile(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L10;
        return false;
    L10:
        if (r102.renameTo(r103) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static void unZipFolder(String r110, String r111) throws IOException {
        ZipInputStream r100 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r110)));
    L3:
        ZipEntry r101 = r100.getNextEntry();
        if (r101 == null) goto L23;
        String r102 = r101.getName();
        if (r102.contains("../") == true) goto L7;
        if (new PolarisFileWrapper(r111, r102).getCanonicalPath().startsWith(new PolarisFileWrapper(r111).getCanonicalPath()) == false) goto L10;
        if (r101.isDirectory() == true) goto L13;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111 + File.separator + r102);
        if (r103.exists() == false) goto L17;
        r103.delete();
    L18:
        r103.createNewFile();
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r103));
        byte[] r105 = new byte[2048];
    L19:
        int r106 = r100.read(r105);
        if (r106 == (-1)) goto L22;
        r104.write(r105, 0, r106);
        goto L19
    L22:
        r104.flush();
        r104.close();
        goto L3
    L17:
        r103.getParentFile().mkdirs();
        goto L18
    L13:
        new PolarisFileWrapper(r111 + File.separator + r102).mkdirs();
        goto L3
    L10:
        ALogger.e("file_path", "unZipFolder slip exception; name=" + r102 + ", outPath=" + r111 + ", zipFilePath=" + r110);
        SafetyGuard.b(new SecurityException("live unzip slip exception;"));
        goto L3
    L7:
        ALogger.e("file_path", "unZipFolder slip exception; name=" + r102 + ", outPath=" + r111 + ", zipFilePath=" + r110);
        SafetyGuard.b(new SecurityException("live unzip slip exception;"));
        goto L3
    L23:
        r100.close();
        ALogger.i("file_path", "UNZIP FINISH; zipFilePath=" + r110 + ", outPath=" + r111);
    }

    public static boolean writeFile(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L11:
        return true;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        PolarisFileWriterWrapper r102 = new PolarisFileWriterWrapper(r100, false);     // Catch: Exception -> L10
        r102.write(r101);     // Catch: Exception -> L10
        r102.flush();     // Catch: Exception -> L10
        r102.close();     // Catch: Exception -> L10
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0063 -> B:73:0x0066). Please report as a decompilation issue!!! */
    public static boolean writeStreamToFile(InputStream e100, String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        boolean r102 = false;
        ?? r103 = 0;
        r103 = 0;
        r103 = 0;
        r103 = 0;
        ?? r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L37
    L80:
        byte[] r105 = new byte[4096];     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
    L6:
        r103 = e100.read(r105);     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
        if (r103 <= 0) goto L9;
        r104.write(r105, 0, r103);     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
        goto L6
    L9:
        r104.flush();     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
        e100.close();     // Catch: IOException -> L12
        ?? r106 = e100;
    L67:
        r104.close();     // Catch: IOException -> L16
        e100 = r106;
    L18:
        r102 = true;
    L73:
        return r102;
    L16:
        e = move-exception;
        e.printStackTrace();
        e100 = e;
    L12:
        e = move-exception;
        e.printStackTrace();
        r106 = e;
        goto L67
    L23:
        e = e;
        r103 = r104;
    L38:
        e.printStackTrace();     // Catch: Throwable -> L25
        e100 = e100;
        if (e100 != 0) goto L63;
    L44:
        if (r103 == 0) goto L73;
        r103.close();     // Catch: IOException -> L47
        goto L73
    L63:
        e100.close();     // Catch: IOException -> L42
        e100 = e100;
    L42:
        e = move-exception;
        e.printStackTrace();
        e100 = e;
    L21:
        e = e;
        r103 = r104;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L25
        e100 = e100;
        if (e100 != 0) goto L69;
    L34:
        if (r103 == 0) goto L73;
        r103.close();     // Catch: IOException -> L47
        goto L73
    L69:
        e100.close();     // Catch: IOException -> L32
        e100 = e100;
    L32:
        e = move-exception;
        e.printStackTrace();
        e100 = e;
    L19:
        th = th;
        r103 = r104;
    L50:
        if (e100 != 0) goto L65;
    L55:
        if (r103 == 0) goto L83;
        r103.close();     // Catch: IOException -> L58
        throw th;
    L58:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L83:
        throw th;
    L65:
        e100.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
    L37:
        e = e;
    L27:
        e = e;
    L47:
        e100 = e;
        e100.printStackTrace();
        goto L73
    }

    public static boolean fileChannelCopy(String r100, String r101) {
        if (isSdcardWritable() == true) goto L11;
        return false;
    L11:
        fileChannelCopy(new PolarisFileInputStreamWrapper(r100), new PolarisFileOutputStreamWrapper(r101));     // Catch: FileNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void saveImageToGallery(Context r100, String r101, String r102) {
        MediaStore.Images.Media.insertImage(r100.getContentResolver(), r101, r102, null);     // Catch: FileNotFoundException -> L4
    L6:
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriProtector.parse(MSkiaImageRegionDecoder.FILE_PREFIX + r101)));
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }
}
