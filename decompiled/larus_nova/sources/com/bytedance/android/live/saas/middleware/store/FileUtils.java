package com.bytedance.android.live.saas.middleware.store;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
class FileUtils implements IFileUtils {
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

    public FileUtils() {
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalAppPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/livestream";
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalPictureDir() {
        return getAppExternalTypeDir("picture");
    }

    public File getExternalVideoDir() {
        return getAppExternalTypeDir("video");
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    L4:
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalAppDir() {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r100 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/livestream");
        ensureDirExists(r100);
        Logger.d("file_path", "app path:" + r100.getAbsolutePath());
        return r100;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardAvailable() {
        String r100 = Environment.getExternalStorageState();     // Catch: Exception -> L4
    L7:
        if ("mounted".equals(r100) == false) goto L9;
    L12:
        return true;
    L9:
        if ("mounted_ro".equals(r100) == true) goto L12;
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L7
    }

    private File getAppExternalTypeDir(String r100) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r101 = new PolarisFileWrapper(getExternalAppDir(), r100);
        ensureDirExists(r101);
        Logger.d("file_path", r100 + " path:" + r101.getAbsolutePath());
        return r101;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String appendFileSeparateForPath(String r100) {
        if (StringUtils.isEmpty(r100) == true) goto L8;
        String r101 = File.separator;
        if (r100.endsWith(r101) == false) goto L7;
        return r100;
    L7:
        return r100 + r101;
    L8:
        return r100;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkFileExists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r100).exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeExternalDirIsExist(String r100) {
        return new PolarisFileWrapper(getExternalAppDir(), r100).exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r100) throws Exception {
        com.bytedance.common.utility.io.FileUtils.clearDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean ensureDirExists(File r100) {
        if (r100.exists() == true) goto L6;
        r100.mkdirs();
    L6:
        return r100.exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public byte[] getByteArray(String r100) {
        return com.bytedance.common.utility.io.FileUtils.getByteArray(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getCacheDirPath(Context r100) throws NullPointerException {
        return com.bytedance.common.utility.io.FileUtils.getCacheDirPath(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getCacheSize(Context r100) {
        File r101 = getExternalCacheDir(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return getDirSize(r101.getAbsolutePath()) + getDirSize(getEidtAbsoluteExternalDir("huoshan/cache", r100));
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getConfiJsonFilePath(String r100) {
        String r101 = File.separator;
        if (r100.endsWith(r101) == false) goto L6;
        return r100.concat(ComposerHelper.CONFIG_FILE_NAME);
    L6:
        return r100 + r101 + ComposerHelper.CONFIG_FILE_NAME;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getDirSize(String r100) {
        long r101 = 0;
        if (isSdcardWritable() == true) goto L5;
    L25:
        return r101;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L25;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L25;
        if (r102.isDirectory() == false) goto L25;
        File[] r103 = r102.listFiles();
        if (r103 != null) goto L15;
        return 0;
    L15:
        int r104 = r103.length;
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L25;
        File r106 = r103[r105];
        if (r106.isFile() == false) goto L22;
        long r107 = r106.length();
    L20:
        r101 = r101 + r107;
    L24:
        r105 = r105 + 1;
        goto L16
    L22:
        if (r106.isDirectory() == false) goto L24;
        r107 = getDirSize(r106.getAbsolutePath());
        goto L20
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheDir(Context r100) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r100.getPackageName() + "/cache");
        ensureDirExists(r101);
        StringBuilder r102 = new StringBuilder("cache path:");
        r102.append(r101.getAbsolutePath());
        Logger.d("file_path", r102.toString());
        return r101;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalCachePath(Context r100) {
        return Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r100.getPackageName() + "/cache";
    }

    public File getExternalFeedCacheDir(Context r100) {
        return getExternalCacheTypeDir("feed", r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalFilesDir(Context r100) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r100.getPackageName() + "/files");
        ensureDirExists(r101);
        return r101;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalModelDir(Context r100) {
        return getEditExternalTypeDir("models", r100);
    }

    public File getExternalPictureCacheDir(Context r100) {
        return getExternalCacheTypeDir("picture", r100);
    }

    public File getExternalVideoCacheDir(Context r100) {
        return getExternalCacheTypeDir("video", r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getFileSize(File r100) {
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

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getFilesDir(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Environment.isExternalStorageEmulated() == true) goto L13;
        File r101 = r100.getExternalFilesDir(null);
        if (r101 == null) goto L12;
        ensureDirExists(r101);
        return r101;
    L12:
        return r100.getFilesDir();
    L13:
        return r100.getFilesDir();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public com.bytedance.common.utility.io.FileUtils.ImageType getImageType(String r100) {
        return com.bytedance.common.utility.io.FileUtils.getImageType(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public InputStream getInputStream(String r100) {
        return com.bytedance.common.utility.io.FileUtils.getInputStream(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDir(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir().getPath());
        if (ensureDirExists(r101) == true) goto L6;
        return null;
    L6:
        Logger.d("file_path", "internal storage path:" + r101.getAbsolutePath());
        return r101;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalDataDir(Context r100) {
        if (Environment.isExternalStorageEmulated() == false) goto L6;
        File r101 = r100.getDir("VideoEdit", 0);
    L11:
        ensureDirExists(r101);
        return r101;
    L6:
        if (isSdcardAvailable() == true) goto L8;
        return null;
    L8:
        if (isSdcardWritable() == false) goto L15;
        r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r100.getPackageName() + File.separator + "VideoEdit");
        goto L11
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getOutDataDir(Context r100) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r100.getPackageName() + "/VideoEdit");
        ensureDirExists(r101);
        return r101;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public JSONObject parseJsonFile(String r100) {
        if (new PolarisFileWrapper(r100).exists() == true) goto L56;
    L45:
        return null;
    L56:
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L20 IOException -> L22
    L58:
        InputStreamReader r102 = new InputStreamReader(r101, "UTF-8");     // Catch: Throwable -> L16 IOException -> L18
        char[] r103 = new char[r101.available()];     // Catch: IOException -> L14 Throwable -> L35
        r102.read(r103);     // Catch: IOException -> L12 Throwable -> L35
        r102.close();     // Catch: IOException -> L12 Throwable -> L35
        r101.close();     // Catch: IOException -> L12 Throwable -> L35
        r102.close();     // Catch: IOException -> L10
        r101.close();     // Catch: IOException -> L10
    L29:
        if (r103 == null) goto L45;
        return new JSONObject(new String(r103));
    L33:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L35
        if (r102 == null) goto L27;
        r102.close();     // Catch: IOException -> L10
    L27:
        if (r101 == null) goto L29;
        r101.close();     // Catch: IOException -> L10
    L14:
        e = e;
        r103 = null;
    L35:
        Throwable th10 = th;
    L36:
        if (r102 != null) goto L53;
    L40:
        if (r101 == null) goto L44;
        r101.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L44:
        throw th10;
    L53:
        r102.close();     // Catch: IOException -> L38
        goto L40
    L18:
        e = e;
        r102 = null;
        r103 = null;
    L16:
        th = move-exception;
        th10 = th;
        r102 = null;
    L22:
        e = e;
        r102 = null;
        r101 = null;
        r103 = null;
    L20:
        th = move-exception;
        r101 = null;
        th10 = th;
        r102 = null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readConfigJsonFile(String r100) {
        if (new PolarisFileWrapper(r100).exists() == true) goto L51;
    L42:
        return null;
    L51:
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L20 IOException -> L22
    L53:
        InputStreamReader r102 = new InputStreamReader(r101, "UTF-8");     // Catch: Throwable -> L16 IOException -> L18
        char[] r103 = new char[r101.available()];     // Catch: IOException -> L14 Throwable -> L32
        r102.read(r103);     // Catch: IOException -> L12 Throwable -> L32
        r102.close();     // Catch: IOException -> L12 Throwable -> L32
        r101.close();     // Catch: IOException -> L12 Throwable -> L32
        r102.close();     // Catch: IOException -> L10
        r101.close();     // Catch: IOException -> L10
    L29:
        if (r103 == null) goto L42;
        return new String(r103);
    L12:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L32
        if (r102 == null) goto L27;
        r102.close();     // Catch: IOException -> L10
    L27:
        if (r101 == null) goto L29;
        r101.close();     // Catch: IOException -> L10
    L14:
        e = e;
        r103 = null;
    L32:
        Throwable th10 = th;
    L33:
        if (r102 != null) goto L45;
    L37:
        if (r101 == null) goto L41;
        r101.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L41:
        throw th10;
    L45:
        r102.close();     // Catch: IOException -> L35
        goto L37
    L18:
        e = e;
        r102 = null;
        r103 = null;
    L16:
        th = move-exception;
        th10 = th;
        r102 = null;
    L22:
        e = e;
        r102 = null;
        r101 = null;
        r103 = null;
    L20:
        th = move-exception;
        r101 = null;
        th10 = th;
        r102 = null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readStringFromFile(File r100) {
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

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void removeDir(File r100) {
        if (r100.isDirectory() == false) goto L16;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.length == 0) goto L21;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L22;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L14;
        removeDir(r104);
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r104.delete();
        goto L15
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean removeFile(String r100) {
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

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void updateMediaStore(String r100) {
        final Context r101 = BDLiveSdk.getContext();
        MediaScannerConnection.scanFile(r101, new String[]{r100}, null, new AnonymousClass1(this, r101));
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeInternalDirIsExist(String r100, Context r101) {
        return new PolarisFileWrapper(getInternalAppDir(r101), r100).exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r100, Set<String> r101) throws Exception {
        com.bytedance.common.utility.io.FileUtils.clearDir(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File createFile(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L15;
        if (r101 == true) goto L18;
        r102.mkdirs();
        goto L15
    L18:
        File r103 = r102.getParentFile();     // Catch: IOException -> L13
        if (r103.exists() == true) goto L11;
        r103.mkdirs();     // Catch: IOException -> L13
    L11:
        r102.createNewFile();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        return r102;
    L16:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean fileChannelCopy(String r110, String r111) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        PolarisFileInputStreamWrapper r100 = null;
        FileChannel r101 = null;
        r101 = null;
        r101 = null;
        r100 = null;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L39 IOException -> L42 FileNotFoundException -> L59
        r110 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L30 IOException -> L33 FileNotFoundException -> L36
    L101:
        r111 = r104.getChannel();     // Catch: Throwable -> L24 IOException -> L26 FileNotFoundException -> L28
    L103:
        r101 = r110.getChannel();     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L22
        r111.transferTo(0, r111.size(), r101);     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L22
        r104.close();     // Catch: IOException -> L14
        r111.close();     // Catch: IOException -> L14
        r110.close();     // Catch: IOException -> L14
        if (r101 == null) goto L106;
        r101.close();     // Catch: IOException -> L14
        return true;
    L106:
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L22:
        e = e;
        FileChannel r105 = r101;
        r102 = r104;
        ?? r112 = r110;
        ?? r113 = r111;
    L62:
        e.printStackTrace();     // Catch: Throwable -> L76
        if (r102 != null) goto L90;
    L67:
        if (r113 == 0) goto L69;
        r113.close();     // Catch: IOException -> L65
    L69:
        if (r112 == 0) goto L71;
        r112.close();     // Catch: IOException -> L65
    L71:
        if (r105 == null) goto L75;
        r105.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L75:
        return false;
    L90:
        r102.close();     // Catch: IOException -> L65
    L20:
        e = e;
        FileChannel r106 = r101;
        r103 = r104;
        ?? r114 = r110;
        ?? r115 = r111;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L76
        if (r103 != null) goto L94;
    L50:
        if (r115 == 0) goto L52;
        r115.close();     // Catch: IOException -> L48
    L52:
        if (r114 == 0) goto L54;
        r114.close();     // Catch: IOException -> L48
    L54:
        if (r106 == null) goto L58;
        r106.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
    L58:
        return false;
    L94:
        r103.close();     // Catch: IOException -> L48
    L18:
        th = th;
        ?? r107 = r101;
        r100 = r104;
    L77:
        if (r100 != null) goto L96;
    L81:
        if (r111 == 0) goto L83;
        r111.close();     // Catch: IOException -> L79
    L83:
        if (r110 == 0) goto L85;
        r110.close();     // Catch: IOException -> L79
    L85:
        if (r107 == 0) goto L89;
        r107.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
    L89:
        throw th;
    L96:
        r100.close();     // Catch: IOException -> L79
    L28:
        e = e;
        FileChannel r116 = null;
        ?? r117 = r110;
    L38:
        r102 = r104;
        ?? r118 = r117;
        FileChannel r119 = r116;
    L61:
        r105 = r119;
        r112 = r118;
        r113 = r119;
    L26:
        e = e;
        FileChannel r120 = null;
        ?? r121 = r110;
    L35:
        r103 = r104;
        ?? r122 = r121;
        FileChannel r123 = r120;
    L44:
        r106 = r123;
        r114 = r122;
        r115 = r123;
    L24:
        th = th;
        Object r124 = null;
        ?? r125 = r110;
    L32:
        r100 = r104;
        r110 = r125;
        r111 = r124;
    L41:
        r107 = r111;
    L36:
        e = e;
        r117 = 0;
        r116 = null;
    L33:
        e = e;
        r121 = 0;
        r120 = null;
    L30:
        th = th;
        r125 = 0;
        r124 = null;
        goto L32
    L76:
        th = th;
    L59:
        e = e;
        r118 = 0;
        r119 = null;
    L42:
        e = e;
        r122 = 0;
        r123 = null;
    L39:
        th = th;
        r110 = 0;
        r111 = 0;
        goto L41
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getEditExternalTypeDir(String r100, Context r101) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == true) goto L8;
        return null;
    L8:
        if (TextUtils.equals("InnerSDKCore.getChannel();", "local_test") == false) goto L10;
        File r102 = getOutDataDir(r101);
    L11:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, r100);
        ensureDirExists(r103);
        Logger.d("file_path", r100 + " path:" + r103.getAbsolutePath());
        return r103;
    L10:
        r102 = getInternalDataDir(r101);
        goto L11
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getEidtAbsoluteExternalDir(String r100, Context r101) {
        return getEditExternalTypeDir(r100, r101).getAbsolutePath() + HTTP.URL_DEFAULT;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheTypeDir(String r100, Context r101) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r102 = new PolarisFileWrapper(getExternalCacheDir(r101), r100);
        ensureDirExists(r102);
        Logger.d("file_path", r100 + " cache path:" + r102.getAbsolutePath());
        return r102;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDirWithType(String r100, Context r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(getInternalAppDir(r101), r100);
        if (ensureDirExists(r102) == true) goto L6;
        return null;
    L6:
        Logger.d("file_path", r100 + " path:" + r102.getAbsolutePath());
        return r102;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean renameFile(String r100, String r101) {
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

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void saveImageToGallery(Context r100, File r101) {
        String r102 = r101.getAbsolutePath();
        MediaStore.Images.Media.insertImage(r100.getContentResolver(), r101.getAbsolutePath(), r101.getName(), null);     // Catch: FileNotFoundException -> L5
    L7:
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriProtector.parse(MSkiaImageRegionDecoder.FILE_PREFIX + r102)));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void unZipFolder(String r100, String r101) throws IOException {
        ZipInputStream r102 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r100)));
    L3:
        ZipEntry r103 = r102.getNextEntry();
        if (r103 == null) goto L20;
        String r104 = r103.getName();
        if (r104.contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L3;
        if (r103.isDirectory() == true) goto L10;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101 + File.separator + r104);
        if (r105.exists() == false) goto L14;
        r105.delete();
    L15:
        r105.createNewFile();
        BufferedOutputStream r106 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r105));
        byte[] r107 = new byte[2048];
    L16:
        int r108 = r102.read(r107);
        if (r108 == (-1)) goto L19;
        r106.write(r107, 0, r108);
        goto L16
    L19:
        r106.flush();
        r106.close();
        goto L3
    L14:
        r105.getParentFile().mkdirs();
        goto L15
    L10:
        new PolarisFileWrapper(r101 + File.separator + r104).mkdirs();
        goto L3
    L20:
        r102.close();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean writeString2File(String r100, String r101) {
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

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean copyFile(String r100, String r101, String r102) {
        return com.bytedance.common.utility.io.FileUtils.copyFile(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean saveInputStream(InputStream r100, String r101, String r102) {
        return com.bytedance.common.utility.io.FileUtils.saveInputStream(r100, r101, r102);
    }
}
