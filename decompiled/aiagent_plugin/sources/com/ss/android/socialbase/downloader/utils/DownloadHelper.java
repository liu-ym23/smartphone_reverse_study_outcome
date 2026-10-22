package com.ss.android.socialbase.downloader.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadInnerConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.g.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadHelper {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ETAG = "Etag";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String GZIP = "gzip";
    public static final String IDENTITY = "identity";
    public static final String IF_MATCH = "If-Match";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final String TAG = "DownloadHelper";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String TTNET_PROTO_TYPE = "x-ttnet-http-proto-type";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    public static final String X_CONTENT_LENGTH = "X-Content-Length";
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap;

    public static int convertToBytes(double r2) {
        return (int) ((r2 * 1000.0d) / 8.0d);
    }

    public static boolean isResponseDataFromBegin(int r1) {
        if (r1 != 200) goto L5;
    L9:
        return true;
    L5:
        if (r1 == 201) goto L9;
        if (r1 == 0) goto L9;
        return false;
    }

    public DownloadHelper() {
    }

    static {
        saveTempFileStatusMap = new SparseArray();
        saveTempFileListeners = new SparseArray();
    }

    public static long parseContentRangeOfInstanceLength(String r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        String[] r6 = r5.split("/");
        if (r6.length >= 2) goto L13;
    L12:
        return -1;
    L13:
        return Long.parseLong(r6[1]);
    L10:
        e = move-exception;
        Logger.globalError(TAG, "parseContentRangeOfInstanceLength", "Exception:" + e);
        goto L12
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo r8, String r9, String r10, int r11, boolean r12) {
        if (TextUtils.isEmpty(r9) == true) goto L59;
        if (TextUtils.isEmpty(r10) == true) goto L59;
        File r0 = new File(r9, r10);
        boolean r2 = false;
        if (r0.exists() == false) goto L14;
        if (r0.isDirectory() == false) goto L14;
        throw new BaseException(DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{r9, Boolean.valueOf(r0.isDirectory())})));
    L14:
        if (r0.exists() == true) goto L57;
        File r13 = new File(r9);     // Catch: IOException -> L53
        if (r13.exists() == false) goto L20;
        if (r13.isDirectory() == false) goto L20;
    L44:
        r0.createNewFile();     // Catch: IOException -> L53
    L20:
        if (r13.exists() == false) goto L22;
        r13.delete();     // Catch: IOException -> L53
        if (r13.mkdirs() == true) goto L52;
        if (r13.exists() == true) goto L52;
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + r9);     // Catch: IOException -> L53
    L52:
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:" + r9);     // Catch: IOException -> L53
    L22:
        if (r13.mkdirs() == true) goto L44;
        if (r13.exists() == true) goto L44;
        if (DownloadSetting.obtain(r8).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) goto L43;
        int r1 = 0;
    L29:
        if (r2 == true) goto L35;
        int r3 = r1 + 1;
        if (r1 >= 3) goto L35;
        Thread.sleep(10);     // Catch: InterruptedException -> L60 IOException -> L53
        r2 = r13.mkdirs();     // Catch: IOException -> L53
        r1 = r3;
    L35:
        if (r2 == true) goto L44;
        if (DownloadUtils.getAvailableSpaceBytes(r8.getSavePath()) >= 16384) goto L41;
        throw new BaseException(1006, "download savePath directory can not created:" + r9);     // Catch: IOException -> L53
    L41:
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + r9);     // Catch: IOException -> L53
    L43:
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + r9);     // Catch: IOException -> L53
    L53:
        e = move-exception;
        throw new BaseException(DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, e);
    L57:
        return new RandomAccessOutputStream(r0, r11, r12);
    L59:
        throw new BaseException(DownloadErrorCode.ERROR_ARGUMENT, new IOException("path must be not empty"));
    }

    public static boolean checkPermission(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r4.checkCallingOrSelfPermission(r3) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static void saveFileAsTargetName(DownloadInfo r18, IDownloadMonitorDepend r19, ITempFileSaveCompleteCallback r20) {
        IDownloadMonitorDepend r0 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r19, IDownloadMonitorDepend.class, "com.obric.aiagent.plugin");
        ITempFileSaveCompleteCallback r2 = (ITempFileSaveCompleteCallback) ZeusTransformUtils.wrapperContextForParams(r20, ITempFileSaveCompleteCallback.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(r18) == false) goto L109;
        Logger.taskDebug(TAG, r18, "saveFileAsTargetName", "TargetName: " + r18.getTargetFilePath());
    L109:
        SparseArray<Boolean> r5 = saveTempFileStatusMap;     // Catch: Throwable -> L99
        monitor-enter(r5);     // Catch: Throwable -> L99
    L96:
        th = move-exception;
        throw th;     // Catch: Throwable -> L99
    L9:
        if (saveTempFileStatusMap.get(r18.getId()) != Boolean.TRUE) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L24;
        if (Logger.debugScene(r18) == false) goto L16;
        Logger.taskDebug(TAG, r18, "saveFileAsTargetName", "Has another same task is saving temp file");     // Catch: Throwable -> L96
    L16:
        if (r2 == null) goto L21;
        List<ITempFileSaveCompleteCallback> r1 = (List) ZeusTransformUtils.preCheckCast(saveTempFileListeners.get(r18.getId()), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96
        if (r1 != null) goto L20;
        r1 = new ArrayList();     // Catch: Throwable -> L96
        saveTempFileListeners.put(r18.getId(), r1);     // Catch: Throwable -> L96
    L20:
        r1.add(r2);     // Catch: Throwable -> L96
        r2.onSameTaskSave();     // Catch: Throwable -> L96
    L21:
        monitor-exit(r5);     // Catch: Throwable -> L96
        return;
    L24:
        if (Logger.debugScene(r18) == false) goto L26;
        Logger.taskDebug(TAG, r18, "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + r18.getId());     // Catch: Throwable -> L96
    L26:
        saveTempFileStatusMap.put(r18.getId(), Boolean.TRUE);     // Catch: Throwable -> L96
        monitor-exit(r5);     // Catch: Throwable -> L96
        DownloadFile r7 = new DownloadFile(r18.getTempPath(), r18.getTempName());     // Catch: Throwable -> L99
        DownloadFile r8 = new DownloadFile(r18.getSavePath(), r18.getName());     // Catch: Throwable -> L99
        if (r18.isForce() == true) goto L63;
        if (DownloadFileUtils.existsAndNotEmpty(r8) == false) goto L63;
        if (DownloadUtils.checkFileLength(r18, r8) == false) goto L63;
        if (Logger.debugScene(r18) == false) goto L37;
        Logger.taskDebug(TAG, r18, "saveFileAsTargetName", "TargetFile exist");     // Catch: Throwable -> L99
    L37:
        long r14 = SystemClock.uptimeMillis();     // Catch: Throwable -> L99
        int r9 = DownloadUtils.checkMd5Status(r8, r18.getMd5());     // Catch: Throwable -> L99
        r18.setMd5Time(SystemClock.uptimeMillis() - r14);     // Catch: Throwable -> L99
        if (DownloadUtils.isMd5Valid(r9) == false) goto L47;
        if (Logger.debugScene(r18) == false) goto L42;
        Logger.taskDebug(TAG, r18, "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid");     // Catch: Throwable -> L99
    L42:
        r18.setTTMd5CheckStatus(r9);     // Catch: Throwable -> L99
        if (r2 == null) goto L45;
        r2.onSuccess();     // Catch: Throwable -> L99
    L45:
        handleTempSaveCallback(r18.getId(), true, null);     // Catch: Throwable -> L99
    L68:
        boolean r10 = false;
    L70:
        if (r10 == false) goto L110;
        int r3 = DownloadSetting.obtain(r18.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FINISH_CHECK_TTMD5, 2);     // Catch: BaseException -> L84 Throwable -> L99
        if (r3 <= 0) goto L83;
        long r15 = SystemClock.uptimeMillis();     // Catch: BaseException -> L84 Throwable -> L99
        int r11 = DownloadUtils.checkMd5Status(r7, r18.getMd5());     // Catch: BaseException -> L84 Throwable -> L99
        r18.setMd5Time(SystemClock.uptimeMillis() - r15);     // Catch: BaseException -> L84 Throwable -> L99
        r18.setTTMd5CheckStatus(r11);     // Catch: BaseException -> L84 Throwable -> L99
        if (r3 < 2) goto L83;
        if (DownloadUtils.isMd5Valid(r11) == true) goto L83;
        BaseException r4 = new BaseException(DownloadErrorCode.ERROR_MD5_INVALID, DownloadUtils.getMd5StatusMsg(r11));     // Catch: BaseException -> L84 Throwable -> L99
        if (r2 == null) goto L80;
        r2.onFailed(r4);     // Catch: BaseException -> L84 Throwable -> L99
    L80:
        handleTempSaveCallback(r18.getId(), false, r4);     // Catch: BaseException -> L84 Throwable -> L99
        DownloadUtils.deleteAllDownloadFiles(r18, DownloadDirUtils.isSavePathSecurity(r18.getSavePath()));     // Catch: BaseException -> L84 Throwable -> L99
        return;
    L83:
        boolean r12 = !moveFile(r7, r8);
        BaseException r13 = null;
    L86:
        if (r12 == false) goto L92;
        if (r13 != null) goto L89;
        r13 = new BaseException(DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName()}));     // Catch: Throwable -> L99
    L89:
        if (r2 == null) goto L91;
        r2.onFailed(r13);     // Catch: Throwable -> L99
    L91:
        handleTempSaveCallback(r18.getId(), false, r13);     // Catch: Throwable -> L99
        return;
    L92:
        if (r2 == null) goto L94;
        r2.onSuccess();     // Catch: Throwable -> L99
    L94:
        handleTempSaveCallback(r18.getId(), true, null);     // Catch: Throwable -> L99
        return;
    L84:
        e = move-exception;
        r13 = e;
        r12 = true;
        goto L86
    L110:
        return;
    L47:
        if (r7.exists() == true) goto L52;
        BaseException r16 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName(), DownloadUtils.getMd5StatusMsg(r9)}));     // Catch: Throwable -> L99
        if (r2 == null) goto L51;
        r2.onFailed(r16);     // Catch: Throwable -> L99
    L51:
        handleTempSaveCallback(r18.getId(), false, r16);     // Catch: Throwable -> L99
        r10 = false;
    L54:
        if (r8.delete() == true) goto L70;
        if (r10 == true) goto L58;
        if (r0 == null) goto L70;
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r0, r18, new BaseException(DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r18.getStatus());     // Catch: Throwable -> L99
        goto L70
    L58:
        BaseException r17 = new BaseException(DownloadErrorCode.ERROR_TARGET_FILE_DELETE_FAILED, "delete targetPath file existed with md5 check invalid status:" + DownloadUtils.getMd5StatusMsg(r9));     // Catch: Throwable -> L99
        if (r2 == null) goto L61;
        r2.onFailed(r17);     // Catch: Throwable -> L99
    L61:
        handleTempSaveCallback(r18.getId(), false, r17);     // Catch: Throwable -> L99
        goto L68
    L52:
        r10 = true;
    L63:
        if (r7.exists() == true) goto L69;
        BaseException r21 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName()}));     // Catch: Throwable -> L99
        if (r2 == null) goto L67;
        r2.onFailed(r21);     // Catch: Throwable -> L99
    L67:
        handleTempSaveCallback(r18.getId(), false, r21);     // Catch: Throwable -> L99
        goto L68
    L69:
        r10 = true;
        goto L70
    L11:
        r6 = false;
    L99:
        th = move-exception;
        BaseException r22 = new BaseException(DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, DownloadUtils.getErrorMsgWithTagPrefix(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
        if (Logger.debugScene(r18) == false) goto L103;
        Logger.taskDebug(TAG, r18, "saveFileAsTargetName", "Error: " + r22);
    L103:
        if (r2 == null) goto L105;
        r2.onFailed(r22);
    L105:
        handleTempSaveCallback(r18.getId(), false, r22);
    }

    private static void handleTempSaveCallback(int r5, boolean r6, BaseException r7) {
        SparseArray<Boolean> r0 = saveTempFileStatusMap;
        monitor-enter(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(saveTempFileListeners.get(r5), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r1 == null) goto L15;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L20
    L8:
        if (r2.hasNext() == false) goto L15;
        ITempFileSaveCompleteCallback r3 = (ITempFileSaveCompleteCallback) ZeusTransformUtils.preCheckCast(r2.next(), ITempFileSaveCompleteCallback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r3 == null) goto L8;
        if (r6 == true) goto L12;
        r3.onFailed(r7);     // Catch: Throwable -> L20
        goto L8
    L12:
        r3.onSuccess();     // Catch: Throwable -> L20
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.taskDebug(TAG, r5, "handleTempSaveCallback", "Run");     // Catch: Throwable -> L20
    L17:
        saveTempFileStatusMap.remove(r5);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo r5, String r6, String r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return;
    L8:
        if (r7.equals(r5.getName()) == true) goto L28;
        DownloadFile r8 = new DownloadFile(r5.getSavePath(), r7);
        DownloadFile r0 = new DownloadFile(r5.getSavePath(), r5.getName());
        if (Logger.debugScene(r5) == false) goto L14;
        Logger.taskDebug(TAG, r5, "copyFileFromExistFileWithSameName", "ExistFile:" + r8.getPath() + " targetFile:" + r0.getPath());
    L14:
        if (r0.exists() == false) goto L21;
        if (r0.canWrite() == true) goto L21;
        throw new BaseException(1001, "targetPath file exists but read-only");
    L21:
        if ((!copyFile(r8, r0, true)) == true) goto L24;
        return;
    L24:
        throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[]{r5.getSavePath(), r7, r5.getSavePath(), r5.getName()}));
    }

    public static boolean copyFile(File r1, File r2) {
        return copyFile(r1, r2, true);
    }

    public static boolean copyFile(File r1, File r2, boolean r3) {
        return copyFile(new DownloadFile(r1), new DownloadFile(r2), r3);
    }

    public static boolean copyFile(DownloadFile r6, DownloadFile r7, boolean r8) {
        if (r6 == null) goto L42;
        if (r7 == null) goto L42;
    L40:
        e = move-exception;
        throw e;
    L37:
        th = move-exception;
        parseException(th, "CopyFile");
        return false;
    L6:
        if (r6.exists() == false) goto L42;
        if (r6.isDirectory() == true) goto L42;
        if (r6.getAbsolutePath().equals(r7.getAbsolutePath()) == true) goto L42;
        if (r7.isTypeFile() == false) goto L25;
        File r1 = r7.getParentFile();     // Catch: Throwable -> L37 BaseException -> L40
        if (r1 == null) goto L25;
        if (r1.mkdirs() == true) goto L25;
        if (r1.isDirectory() == true) goto L25;
        throw new BaseException(DownloadErrorCode.ERROR_TARGET_DIR_MKDIR_FAILED, "Destination '" + r1 + "' directory cannot be created");     // Catch: Throwable -> L37 BaseException -> L40
    L25:
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "copyFile", "SrcFile:" + r6.getPath() + " DestFile:" + r7.getPath());     // Catch: Throwable -> L37 BaseException -> L40
    L28:
        if (r7.exists() == true) goto L30;
    L34:
        doCopyFile(r6, r7, r8);     // Catch: Throwable -> L37 BaseException -> L40
        return true;
    L30:
        if (r7.canWrite() == true) goto L34;
        throw new IOException("Destination '" + r7.getAbsolutePath() + "' exists but is read-only");     // Catch: Throwable -> L37 BaseException -> L40
    L42:
        return false;
    }

    private static void doCopyFile(DownloadFile r17, DownloadFile r18, boolean r19) {
        if (r18.exists() == false) goto L10;
        if (r18.isDirectory() == false) goto L10;
        throw new IOException("Destination '" + r18 + "' exists but is a directory");
    L10:
        if (Build.VERSION.SDK_INT >= 29) goto L12;
    L19:
        FileInputStream r1 = r17.obtainInputStream();
        FileChannel r8 = r1.getChannel();     // Catch: Throwable -> L86
        FileOutputStream r9 = r18.obtainOutputStream();     // Catch: Throwable -> L74
        FileChannel r10 = r9.getChannel();     // Catch: Throwable -> L62
        long r11 = r8.size();     // Catch: Throwable -> L50
        long r15 = 0;
    L25:
        if (r15 >= r11) goto L35;
        long r2 = r11 - r15;     // Catch: Throwable -> L50
        if (r2 <= FILE_COPY_BUFFER_SIZE) goto L29;
        long r6 = 31457280;
    L30:
        long r3 = r10.transferFrom(r8, r15, r6);     // Catch: Throwable -> L50
    L32:
        if (r3 == 0) goto L35;
        r15 = r15 + r3;
        goto L25
    L29:
        r6 = r2;
    L35:
        if (r10 == null) goto L37;
        r10.close();     // Catch: Throwable -> L62
    L37:
        if (r9 == null) goto L39;
        r9.close();     // Catch: Throwable -> L74
    L39:
        if (r8 == null) goto L41;
        r8.close();     // Catch: Throwable -> L86
    L41:
        if (r1 == null) goto L43;
        r1.close();
    L43:
        long r4 = r17.length();
        long r5 = r18.length();
        if (r4 != r5) goto L49;
        if (r19 == false) goto L120;
        r18.setLastModified(r17.lastModified());
        return;
    L120:
        return;
    L49:
        throw new IOException("Failed to copy full contents from '" + r17 + "' to '" + r18 + "' Expected length: " + r4 + " Actual: " + r5);
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        if (r10 == null) goto L121;
        r10.close();     // Catch: Throwable -> L58
    L122:
        throw th;     // Catch: Throwable -> L62
    L58:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L121:
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        if (r9 == null) goto L123;
        r9.close();     // Catch: Throwable -> L70
    L124:
        throw th;     // Catch: Throwable -> L74
    L70:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L123:
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        if (r8 == null) goto L125;
        r8.close();     // Catch: Throwable -> L82
    L126:
        throw th;     // Catch: Throwable -> L86
    L82:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L125:
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        if (r1 == null) goto L127;
        r1.close();     // Catch: Throwable -> L94
        throw th;
    L94:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L127:
        throw th;
    L12:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r18.getPath()) == false) goto L19;
        Uri r7 = DownloadFileUtils.getUriFromFilePath(r18.getPath());
        if (r7 == null) goto L18;
        copyFileToExternal((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r17.getPath(), r7);
        return;
    L18:
        throw new IOException("Destination " + r18 + "exists but contentUri is null");
    }

    public static void copyFileToExternal(Context r5, String r6, Uri r7) {
        ContentResolver r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getContentResolver();
        Closeable r0 = null;
        OutputStream r1 = null;
        r1 = null;
        r1 = null;
        Closeable r2 = null;
        FileInputStream r3 = new FileInputStream(new File(r6));     // Catch: Throwable -> L16 IOException -> L20
        if (r7 != null) goto L25;
    L9:
        if (r1 == null) goto L15;
        byte[] r9 = new byte[4096];     // Catch: Throwable -> L6 IOException -> L8
    L11:
        int r10 = r3.read(r9);     // Catch: Throwable -> L6 IOException -> L8
        if (r10 == (-1)) goto L15;
        r1.write(r9, 0, r10);     // Catch: Throwable -> L6 IOException -> L8
        goto L11
    L8:
        OutputStream r11 = r1;
        r2 = r3;
    L21:
        DownloadUtils.safeClose(new Closeable[]{r2});
        DownloadUtils.safeClose(new Closeable[]{r11});
        return;
    L6:
        th = th;
        OutputStream r12 = r1;
        r0 = r3;
    L18:
        DownloadUtils.safeClose(new Closeable[]{r0});
        DownloadUtils.safeClose(new Closeable[]{r12});
        throw th;
    L15:
        DownloadUtils.safeClose(new Closeable[]{r3});
        DownloadUtils.safeClose(new Closeable[]{r1});
        return;
    L25:
        r1 = r8.openOutputStream(r7);     // Catch: Throwable -> L6 IOException -> L8
        goto L9
    L20:
        r11 = null;
    L16:
        th = th;
        r12 = null;
        goto L18
    }

    public static boolean moveFile(DownloadFile r6, DownloadFile r7) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "moveFile", "DownloadFile Src:" + r6.getPath() + " Dest:" + r7.getPath());
    L6:
        if (DownloadFileUtils.isScopedStorage() == true) goto L8;
    L12:
        boolean r0 = r6.renameTo(r7);
    L13:
        if (r0 == true) goto L22;
        r0 = copyFile(r6, r7, true);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "moveFile", "Copy DownloadFile Src:" + r6.getPath() + " Dest:" + r7.getPath());     // Catch: Throwable -> L20
    L18:
        r6.delete();     // Catch: Throwable -> L20
    L22:
        return r0;
    L8:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r6.getAbsolutePath()) == true) goto L12;
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r7.getAbsolutePath()) == false) goto L12;
        r0 = false;
        goto L13
    }

    public static boolean canAcceptPartial(int r3, String r4) {
        if (r3 < 400) goto L6;
        return false;
    L6:
        if (r3 == 206) goto L11;
        if (r3 == 1) goto L11;
        if ("bytes".equals(r4) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection r5) {
        IDownloadHeadHttpConnection r6 = (IDownloadHeadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadHeadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L6;
        return false;
    L6:
        if (VALUE_CHUNKED.equals(r6.getResponseHeaderField(TRANSFER_ENCODING)) == false) goto L8;
    L9:
        return true;
    L8:
        if (DownloadUtils.getContentLength(r6) == (-1)) goto L9;
        return false;
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> r6, String r7, long r8, long r10) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L19;
        if (r9.size() <= 0) goto L19;
        Iterator r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L19;
        HttpHeader r3 = (HttpHeader) ZeusTransformUtils.preCheckCast(r11.next(), HttpHeader.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        if (ACCEPT_ENCODING.equalsIgnoreCase(r3.getName()) == false) goto L17;
        if (GZIP.equalsIgnoreCase(r3.getValue()) == true) goto L8;
    L17:
        r0.add(r3);
    L19:
        if (TextUtils.isEmpty(r7) == true) goto L21;
        r0.add(new HttpHeader(IF_MATCH, r7));
    L21:
        r0.add(new HttpHeader(ACCEPT_ENCODING, IDENTITY));
        if (r10 > 0) goto L24;
        String r12 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r8)});
    L25:
        r0.add(new HttpHeader("Range", r12));
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "addRangeHeader", "CurrentOffset:" + r8 + " EndOffset:" + r10 + ", range = " + r12);
    L28:
        return r0;
    L24:
        r12 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r8), Long.valueOf(r10)});
        goto L25
    }

    public static boolean isMainProcess() {
        Boolean r0 = sIsMainProcess;
        if (r0 != null) goto L5;
        boolean r1 = false;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_INDEPENDENT_PROCESS) <= 0) goto L11;
        Boolean r2 = false;
        sIsMainProcess = r2;
        return r2.booleanValue();
    L11:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_MAIN_PROCESS) <= 0) goto L15;
        Boolean r3 = true;
        sIsMainProcess = r3;
        return r3.booleanValue();
    L15:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L17;
        return true;
    L17:
        String r4 = DownloadUtils.getCurProcessName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r4 != null) goto L20;
    L22:
        if (r4 != null) goto L24;
    L26:
        sIsMainProcess = Boolean.valueOf(r1);
    L28:
        return sIsMainProcess.booleanValue();
    L24:
        if (r4.equals(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName()) == false) goto L26;
        r1 = true;
        goto L26
    L20:
        if (r4.contains(":") == false) goto L22;
        sIsMainProcess = false;
        goto L28
    L5:
        return r0.booleanValue();
    }

    public static boolean needNotifyDownloaderProcess() {
        if (isDownloaderProcess() == false) goto L5;
    L9:
        return false;
    L5:
        if (DownloadComponentManager.isDownloadInMultiProcess() == false) goto L9;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L9;
        return true;
    }

    public static boolean isDownloaderProcess() {
        Boolean r0 = sIsDownloaderProcess;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L9;
        return false;
    L9:
        String r1 = DownloadUtils.getCurProcessName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r1 != null) goto L12;
    L14:
        sIsDownloaderProcess = false;
    L16:
        return sIsDownloaderProcess.booleanValue();
    L12:
        if (r1.equals(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName() + ":downloader") == false) goto L14;
        sIsDownloaderProcess = true;
        goto L16
    }

    public static boolean isTimeOutException(Throwable r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = DownloadUtils.getThrowableMsg(r3);
        if (ZeusTransformUtils.instanceOf(r3, SocketTimeoutException.class) == false) goto L8;
    L13:
        return true;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return false;
    L10:
        if (r1.contains("time out") == true) goto L13;
        if (r1.contains("Time-out") == true) goto L13;
        return false;
    }

    public static boolean isForbiddenException(Throwable r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r1 = DownloadUtils.getThrowableMsg(r5);
        if (ZeusTransformUtils.instanceOf(r5, DownloadHttpException.class) == false) goto L17;
        DownloadHttpException r6 = (DownloadHttpException) ZeusTransformUtils.preCheckCast(r5, DownloadHttpException.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        if (r6.getHttpStatusCode() != 403) goto L12;
    L15:
        return true;
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (r1.contains("403") == true) goto L15;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L19;
        return false;
    L19:
        if (r1.contains("Forbidden") == true) goto L21;
        return false;
    L21:
        return true;
    }

    public static boolean isNetNotAvailableException(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = DownloadUtils.getThrowableMsg(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.contains("network not available") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isConnectionException(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = DownloadUtils.getThrowableMsg(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.contains("Exception in connect") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isResponseCode412Error(Throwable r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(r4) != 412) goto L8;
        return true;
    L8:
        String r5 = DownloadUtils.getThrowableMsg(r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return false;
    L11:
        if (r5.contains("Precondition Failed") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isResponseCode416Error(Throwable r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(r4) != 416) goto L8;
        return true;
    L8:
        String r5 = DownloadUtils.getThrowableMsg(r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return false;
    L11:
        if (r5.contains("Requested Range Not Satisfiable") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isHttpDataDirtyError(BaseException r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getErrorCode() != 1051) goto L6;
    L11:
        return true;
    L6:
        if (r2.getErrorCode() == 1027) goto L11;
        if (r2.getErrorCode() == 1026) goto L11;
        if (r2.getErrorCode() != 1044) goto L12;
        goto L11
    }

    public static boolean isResponseCodeError(BaseException r3) {
        if (ZeusTransformUtils.instanceOf(r3, DownloadHttpException.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (((DownloadHttpException) ZeusTransformUtils.preCheckCast(r3, DownloadHttpException.class, "com.obric.aiagent.plugin")).getHttpStatusCode() != 412) goto L7;
    L8:
        return true;
    L7:
        if (((DownloadHttpException) ZeusTransformUtils.preCheckCast(r3, DownloadHttpException.class, "com.obric.aiagent.plugin")).getHttpStatusCode() != 416) goto L9;
        goto L8
    }

    public static boolean isInterceptError(Throwable r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (ZeusTransformUtils.instanceOf(r2, BaseException.class) == false) goto L8;
        if (((BaseException) ZeusTransformUtils.preCheckCast(r2, BaseException.class, "com.obric.aiagent.plugin")).getErrorCode() != 1083) goto L8;
        return true;
    }

    public static boolean isHttpsError(BaseException r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getErrorCode() != 1011) goto L8;
    L11:
        return true;
    L8:
        if (r3.getCause() != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r3.getCause(), SSLHandshakeException.class) == true) goto L11;
        return false;
    }

    public static void parseException(Throwable r4, String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        String r0 = r5;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, BaseException.class) == false) goto L9;
        ((BaseException) ZeusTransformUtils.preCheckCast(r4, BaseException.class, "com.obric.aiagent.plugin")).setErrorMsg(r0 + "-" + ((BaseException) ZeusTransformUtils.preCheckCast(r4, BaseException.class, "com.obric.aiagent.plugin")).getErrorMessage());
        throw ((BaseException) ZeusTransformUtils.preCheckCast(r4, BaseException.class, "com.obric.aiagent.plugin"));
    L9:
        if (ZeusTransformUtils.instanceOf(r4, SSLHandshakeException.class) == true) goto L41;
        if (isTimeOutException(r4) == true) goto L39;
        if (isResponseCode412Error(r4) == true) goto L37;
        if (isResponseCode416Error(r4) == true) goto L35;
        if (isForbiddenException(r4) == true) goto L33;
        if (isNetNotAvailableException(r4) == true) goto L31;
        if (isConnectionException(r4) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r4, IOException.class) == false) goto L27;
        parseTTNetException(r4, r5);
        parseIOException((IOException) ZeusTransformUtils.preCheckCast(r4, IOException.class, "com.obric.aiagent.plugin"), r5);
        return;
    L27:
        throw new BaseException(1000, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L29:
        throw new BaseException(DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L31:
        throw new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L33:
        throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L35:
        throw new DownloadHttpException(1004, 416, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L37:
        throw new DownloadHttpException(1004, 412, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L39:
        throw new BaseException(DownloadErrorCode.ERROR_TIME_OUT, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L41:
        throw new BaseException(1011, DownloadUtils.getErrorMsgWithTagPrefix(r4, r0));
    L5:
        r0 = "";
        goto L7
    }

    public static DownloadTTNetException getTTNetException(Throwable r2, String r3) {
        DownloadTTNetException r0 = DownloadComponentManager.getTTNetHandler().translateTTNetException(r2, null);
        if (r0 != null) goto L5;
        r0 = DownloadComponentManager.getTTNetHandler().translateTTNetException(r2.getCause(), null);
    L5:
        if (r0 == null) goto L8;
        String r4 = DownloadUtils.getErrorMsgWithTagPrefix(r0, r3);
        return new DownloadTTNetException(r0.getErrorCode(), r4).setRequestLog(r0.getRequestLog()).setRemoteIp(r0.getRemoteIp());
    L8:
        return null;
    }

    private static void parseTTNetException(Throwable r0, String r1) {
        DownloadTTNetException r2 = getTTNetException(r0, r1);
        if (r2 != null) goto L5;
        return;
    L5:
        throw r2;
    }

    public static void parseIOException(IOException r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        String r3 = DownloadUtils.getErrorMsgWithTagPrefix(r1, r2);
        if (ZeusTransformUtils.instanceOf(r1, ConnectException.class) == true) goto L73;
        if (ZeusTransformUtils.instanceOf(r1, UnknownHostException.class) == true) goto L71;
        if (ZeusTransformUtils.instanceOf(r1, NoRouteToHostException.class) == true) goto L69;
        if (ZeusTransformUtils.instanceOf(r1, UnknownServiceException.class) == true) goto L67;
        if (ZeusTransformUtils.instanceOf(r1, PortUnreachableException.class) == true) goto L65;
        if (ZeusTransformUtils.instanceOf(r1, SocketTimeoutException.class) == true) goto L63;
        if (ZeusTransformUtils.instanceOf(r1, SocketException.class) == true) goto L61;
        if (ZeusTransformUtils.instanceOf(r1, HttpRetryException.class) == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r1, ProtocolException.class) == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r1, MalformedURLException.class) == true) goto L55;
        if (ZeusTransformUtils.instanceOf(r1, FileNotFoundException.class) == true) goto L53;
        if (ZeusTransformUtils.instanceOf(r1, InterruptedIOException.class) == true) goto L51;
        if (ZeusTransformUtils.instanceOf(r1, UnsupportedEncodingException.class) == true) goto L49;
        if (ZeusTransformUtils.instanceOf(r1, EOFException.class) == true) goto L47;
        if (ZeusTransformUtils.instanceOf(r1, n.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r1, SSLException.class) == true) goto L43;
        if (DownloadUtils.isInsufficientSpaceError(r1) == false) goto L41;
        throw new BaseException(1006, r3);
    L41:
        throw new BaseException(DownloadErrorCode.ERROR_IO, r3);
    L43:
        throw new BaseException(1011, r3);
    L45:
        throw new BaseException(DownloadErrorCode.ERROR_STREAM_RESET, r3);
    L47:
        throw new BaseException(DownloadErrorCode.ERROR_EOF, r3);
    L49:
        throw new BaseException(DownloadErrorCode.ERROR_UNSUPPORTED_ENCODING, r3);
    L51:
        throw new BaseException(DownloadErrorCode.ERROR_INTERRUPTED_IO, r3);
    L53:
        throw new BaseException(DownloadErrorCode.ERROR_FILE_NOT_FOUND, r3);
    L55:
        throw new BaseException(DownloadErrorCode.ERROR_MALFORMED_URL, r3);
    L57:
        throw new BaseException(DownloadErrorCode.ERROR_PROTOCOL, r3);
    L59:
        throw new BaseException(DownloadErrorCode.ERROR_HTTP_RETRY, r3);
    L61:
        throw new BaseException(DownloadErrorCode.ERROR_SOCKET, r3);
    L63:
        throw new BaseException(DownloadErrorCode.ERROR_TIME_OUT, r3);
    L65:
        throw new BaseException(DownloadErrorCode.ERROR_PORT_UNREACHABLE, r3);
    L67:
        throw new BaseException(DownloadErrorCode.ERROR_UNKNOWN_SERVICE, r3);
    L69:
        throw new BaseException(DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, r3);
    L71:
        throw new BaseException(DownloadErrorCode.ERROR_UNKNOWN_HOST, r3);
    L73:
        throw new BaseException(DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, r3);
    }

    public static ListenerType convertListenerType(int r2) {
        ListenerType r0 = ListenerType.MAIN;
        if (r2 != ListenerType.SUB.ordinal()) goto L6;
        return ListenerType.SUB;
    L6:
        if (r2 == ListenerType.NOTIFICATION.ordinal()) goto L8;
        return r0;
    L8:
        return ListenerType.NOTIFICATION;
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, K> r0 = new HashMap();
        int r1 = r5.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int r3 = r5.keyAt(r2);
        K r4 = r5.valueAt(r2);
        r0.put(Integer.valueOf(r3), r4);
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> void sparseArrayPutAll(SparseArray<K> r4, Map<Integer, K> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        if (r4 == 0) goto L18;
        Iterator r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r0.getKey() == null) goto L8;
        r4.put(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue(), r0.getValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public static <K, V> void mapConvertToList(Map<K, V> r3, List<V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        if (r6 == null) goto L18;
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r0.getKey() == null) goto L8;
        r6.add(r0.getValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public static Map<Integer, DownloadInfo> listConvertToMap(List<DownloadInfo> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r6.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r2.getId() == 0) goto L8;
        r0.put(Integer.valueOf(r2.getId()), r2);
        goto L8
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void copyMap(Map<K, V> r3, Map<K, V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        if (r6 == 0) goto L18;
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r0.getKey() == null) goto L8;
        r6.put(r0.getKey(), r0.getValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public static long getFirstOffset(DownloadInfo r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getCurBytes();
    }

    public static long getCurByte(DownloadInfo r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        boolean r2 = r6.isFileDataValid();
        if (Logger.debugScene(r6) == false) goto L8;
        Logger.taskDebug(TAG, r6, "getCurByte", "ResumeAvailable:" + r2);
    L8:
        if (r2 == true) goto L10;
        return 0;
    L10:
        return r6.getCurBytes();
    }

    public static String getFixLengthString(String r1, int r2) {
        if (r2 != 0) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r1;
    L8:
        if (r1.length() > r2) goto L11;
        return r1;
    L11:
        return r1.substring(0, r2);
    }

    public static void addTTNetParam(DownloadSetting r4, List<HttpHeader> r5, DownloadInfo r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        long r0 = r6.getThrottleNetSpeed();
        if (r0 <= 0) goto L5;
        r7.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(r0)));
    L5:
        long r1 = r6.getTtnetProtectTimeout();
        if (r1 <= 300) goto L9;
        r7.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(r1)));
    L9:
        if (r6.isAddTTNetCommonParam() == false) goto L12;
        r7.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_TTNET_COMMON_PARAMS, "true"));
    L12:
        if (r4.optInt(DownloadSettingKeys.ENABLE_DOWNLOAD_NETWORK_TAG, 0) <= 0) goto L14;
        r7.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_ID_HEADER_NAME, "dl"));
        r7.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_VERSION_HEADER_NAME, BuildConfig.DL_VERSION_NAME));
    L14:
        int r8 = r4.optInt(DownloadSettingKeys.TTNET_ERROR_PROTO_TYPE, 0);
        if (r8 <= 0) goto L18;
        r7.add(new HttpHeader(TTNET_PROTO_TYPE, String.valueOf(r8)));
        return;
    }

    public static long parserMaxAge(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return 0;
    L13:
        Matcher r4 = Pattern.compile("max-age=([0-9]+)").matcher(r3);     // Catch: Throwable -> L10
        if (r4.find() == false) goto L15;
        return Long.parseLong(r4.group(1));
    L15:
        return 0;
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static HashMap<String, Integer> jsonObjectToHashMap(JSONObject r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        HashMap<String, Integer> r1 = new HashMap();
        Iterator<String> r2 = r6.keys();
    L7:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r1.put(r3, Integer.valueOf(r6.optInt(r3, 0)));
        goto L7
    L12:
        if (r1.isEmpty() == false) goto L15;
        return null;
    L15:
        return r1;
    }

    public static DownloadInfo parseDownloadInfo(Cursor r8) {
        Cursor r9 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r8, Cursor.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        DownloadInfo.RawBuilder r0 = new DownloadInfo.RawBuilder();
        int r1 = r9.getColumnIndex("_id");     // Catch: Exception -> L172
        if (r1 == (-1)) goto L10;
        r0.id = r9.getInt(r1);     // Catch: Exception -> L172
    L10:
        int r2 = r9.getColumnIndex("name");     // Catch: Exception -> L172
        if (r2 == (-1)) goto L13;
        r0.name(r9.getString(r2));     // Catch: Exception -> L172
    L13:
        int r3 = r9.getColumnIndex(DBDefinition.TITLE);     // Catch: Exception -> L172
        if (r3 == (-1)) goto L16;
        r0.title(r9.getString(r3));     // Catch: Exception -> L172
    L16:
        int r4 = r9.getColumnIndex("url");     // Catch: Exception -> L172
        if (r4 == (-1)) goto L19;
        r0.url(r9.getString(r4));     // Catch: Exception -> L172
    L19:
        int r5 = r9.getColumnIndex(DBDefinition.SAVE_PATH);     // Catch: Exception -> L172
        if (r5 == (-1)) goto L22;
        r0.savePath(r9.getString(r5));     // Catch: Exception -> L172
    L22:
        int r6 = r9.getColumnIndex(DBDefinition.TEMP_PATH);     // Catch: Exception -> L172
        if (r6 == (-1)) goto L25;
        r0.tempPath(r9.getString(r6));     // Catch: Exception -> L172
    L25:
        int r7 = r9.getColumnIndex(DBDefinition.CHUNK_COUNT);     // Catch: Exception -> L172
        if (r7 == (-1)) goto L28;
        r0.chunkCount = r9.getInt(r7);     // Catch: Exception -> L172
    L28:
        int r10 = r9.getColumnIndex("status");     // Catch: Exception -> L172
        boolean r11 = false;
        if (r10 == (-1)) goto L31;
        r0.status = r9.getInt(r10);     // Catch: Exception -> L172
    L32:
        int r12 = r9.getColumnIndex(DBDefinition.CUR_BYTES);     // Catch: Exception -> L172
        if (r12 == (-1)) goto L35;
        r0.curBytes = r9.getLong(r12);     // Catch: Exception -> L172
    L36:
        int r13 = r9.getColumnIndex(DBDefinition.BACK_CUR_BYTES);     // Catch: Exception -> L172
        if (r13 == (-1)) goto L39;
        r0.backCurBytes = r9.getLong(r13);     // Catch: Exception -> L172
    L40:
        int r14 = r9.getColumnIndex(DBDefinition.TOTAL_BYTES);     // Catch: Exception -> L172
        if (r14 == (-1)) goto L43;
        r0.totalBytes = r9.getLong(r14);     // Catch: Exception -> L172
    L43:
        int r15 = r9.getColumnIndex(DBDefinition.ETAG);     // Catch: Exception -> L172
        if (r15 == (-1)) goto L46;
        r0.etag = r9.getString(r15);     // Catch: Exception -> L172
    L46:
        int r16 = r9.getColumnIndex(DBDefinition.ONLY_WIFI);     // Catch: Exception -> L172
        if (r16 != (-1)) goto L49;
    L53:
        int r17 = r9.getColumnIndex(DBDefinition.FORCE);     // Catch: Exception -> L172
        if (r17 != (-1)) goto L56;
    L60:
        int r18 = r9.getColumnIndex(DBDefinition.RETRY_COUNT);     // Catch: Exception -> L172
        if (r18 == (-1)) goto L63;
        r0.retryCount(r9.getInt(r18));     // Catch: Exception -> L172
    L63:
        int r19 = r9.getColumnIndex("extra");     // Catch: Exception -> L172
        if (r19 == (-1)) goto L66;
        r0.extra(r9.getString(r19));     // Catch: Exception -> L172
    L66:
        int r20 = r9.getColumnIndex(DBDefinition.MIME_TYPE);     // Catch: Exception -> L172
        if (r20 == (-1)) goto L69;
        r0.mimeType(r9.getString(r20));     // Catch: Exception -> L172
    L69:
        int r21 = r9.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);     // Catch: Exception -> L172
        if (r21 != (-1)) goto L72;
    L76:
        int r22 = r9.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);     // Catch: Exception -> L172
        if (r22 == (-1)) goto L79;
        r0.notificationVisibility = r9.getInt(r22);     // Catch: Exception -> L172
    L79:
        int r23 = r9.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);     // Catch: Exception -> L172
        if (r23 != (-1)) goto L82;
    L86:
        int r24 = r9.getColumnIndex(DBDefinition.FIRST_SUCCESS);     // Catch: Exception -> L172
        if (r24 != (-1)) goto L89;
    L93:
        int r25 = r9.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);     // Catch: Exception -> L172
        if (r25 != (-1)) goto L96;
    L100:
        int r26 = r9.getColumnIndex(DBDefinition.DOWNLOAD_TIME);     // Catch: Exception -> L172
        if (r26 == (-1)) goto L103;
        r0.downloadTime = r9.getLong(r26);     // Catch: Exception -> L172
    L103:
        int r27 = r9.getColumnIndex("packageName");     // Catch: Exception -> L172
        if (r27 == (-1)) goto L106;
        r0.packageName(r9.getString(r27));     // Catch: Exception -> L172
    L106:
        int r28 = r9.getColumnIndex("md5");     // Catch: Exception -> L172
        if (r28 == (-1)) goto L109;
        r0.md5(r9.getString(r28));     // Catch: Exception -> L172
    L109:
        int r29 = r9.getColumnIndex(DBDefinition.CUR_RETRY_TIME);     // Catch: Exception -> L172
        if (r29 == (-1)) goto L112;
        r0.curRetryTime = r9.getInt(r29);     // Catch: Exception -> L172
    L112:
        int r30 = r9.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);     // Catch: Exception -> L172
        if (r30 != (-1)) goto L115;
    L119:
        int r31 = r9.getColumnIndex(DBDefinition.BACKUP_URLS_STR);     // Catch: Exception -> L172
        if (r31 == (-1)) goto L122;
        r0.backUpUrlsStr = r9.getString(r31);     // Catch: Exception -> L172
    L122:
        int r32 = r9.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);     // Catch: Exception -> L172
        if (r32 == (-1)) goto L125;
        r0.backUpUrlRetryCount(r9.getInt(r32));     // Catch: Exception -> L172
    L125:
        int r33 = r9.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);     // Catch: Exception -> L172
        if (r33 == (-1)) goto L128;
        r0.realDownloadTime = r9.getLong(r33);     // Catch: Exception -> L172
    L128:
        int r34 = r9.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);     // Catch: Exception -> L172
        if (r34 == (-1)) goto L131;
        r0.realBackDownloadTime = r9.getLong(r34);     // Catch: Exception -> L172
    L131:
        int r35 = r9.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);     // Catch: Exception -> L172
        if (r35 != (-1)) goto L134;
    L138:
        int r36 = r9.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);     // Catch: Exception -> L172
        if (r36 == (-1)) goto L141;
        r0.dbJsonDataString = r9.getString(r36);     // Catch: Exception -> L172
    L141:
        int r37 = r9.getColumnIndex(DBDefinition.ICON_URL);     // Catch: Exception -> L172
        if (r37 == (-1)) goto L144;
        r0.iconUrl(r9.getString(r37));     // Catch: Exception -> L172
    L144:
        int r38 = r9.getColumnIndex(DBDefinition.APP_VERSION_CODE);     // Catch: Exception -> L172
        if (r38 == (-1)) goto L147;
        r0.appVersionCode(r9.getInt(r38));     // Catch: Exception -> L172
    L147:
        int r39 = r9.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);     // Catch: Exception -> L172
        if (r39 == (-1)) goto L150;
        r0.downloadStartTimeStamp = r9.getLong(r39);     // Catch: Exception -> L172
    L150:
        int r40 = r9.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);     // Catch: Exception -> L172
        if (r40 == (-1)) goto L153;
        r0.downloadFinishTimeStamp = r9.getLong(r40);     // Catch: Exception -> L172
    L153:
        int r41 = r9.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);     // Catch: Exception -> L172
        if (r41 == (-1)) goto L156;
        r0.installedTimeStamp = r9.getLong(r41);     // Catch: Exception -> L172
    L156:
        int r42 = r9.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);     // Catch: Exception -> L172
        if (r42 == (-1)) goto L159;
        r0.cacheLifeTimeMax(r9.getLong(r42));     // Catch: Exception -> L172
    L159:
        int r43 = r9.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);     // Catch: Exception -> L172
        if (r43 != (-1)) goto L162;
    L165:
        int r44 = r9.getColumnIndex(DBDefinition.PCDN_URLS_STR);     // Catch: Exception -> L172
        if (r44 == (-1)) goto L168;
        r0.pcdnUrlsStr = r9.getString(r44);     // Catch: Exception -> L172
    L168:
        int r45 = r9.getColumnIndex(DBDefinition.CDN_URLS_STR);     // Catch: Exception -> L172
        if (r45 == (-1)) goto L175;
        r0.cdnUrlsStr = r9.getString(r45);     // Catch: Exception -> L172
    L175:
        return r0.build();
    L162:
        if (r9.getInt(r43) != 1) goto L164;
        r11 = true;
    L164:
        r0.hasDoInstallation = r11;     // Catch: Exception -> L172
        goto L165
    L134:
        if (r9.getInt(r35) != 1) goto L136;
        boolean r46 = true;
    L137:
        r0.needIndependentProcess(r46);     // Catch: Exception -> L172
        goto L138
    L136:
        r46 = false;
        goto L137
    L115:
        if (r9.getInt(r30) != 1) goto L117;
        boolean r47 = true;
    L118:
        r0.needDefaultHttpServiceBackUp(r47);     // Catch: Exception -> L172
        goto L119
    L117:
        r47 = false;
        goto L118
    L96:
        if (r9.getInt(r25) != 1) goto L98;
        boolean r48 = true;
    L99:
        r0.needHttpsToHttpRetry(r48);     // Catch: Exception -> L172
        goto L100
    L98:
        r48 = false;
        goto L99
    L89:
        if (r9.getInt(r24) != 1) goto L91;
        boolean r49 = true;
    L92:
        r0.isFirstSuccess = r49;     // Catch: Exception -> L172
        goto L93
    L91:
        r49 = false;
        goto L92
    L82:
        if (r9.getInt(r23) != 1) goto L84;
        boolean r50 = true;
    L85:
        r0.isFirstDownload = r50;     // Catch: Exception -> L172
        goto L86
    L84:
        r50 = false;
        goto L85
    L72:
        if (r9.getInt(r21) == 0) goto L74;
        boolean r51 = true;
    L75:
        r0.showNotification(r51);     // Catch: Exception -> L172
        goto L76
    L74:
        r51 = false;
        goto L75
    L56:
        if (r9.getInt(r17) == 0) goto L58;
        boolean r52 = true;
    L59:
        r0.force(r52);     // Catch: Exception -> L172
        goto L60
    L58:
        r52 = false;
        goto L59
    L49:
        if (r9.getInt(r16) == 0) goto L51;
        boolean r53 = true;
    L52:
        r0.onlyWifi(r53);     // Catch: Exception -> L172
        goto L53
    L51:
        r53 = false;
        goto L52
    L39:
        r0.backCurBytes = 0;     // Catch: Exception -> L172
        goto L40
    L35:
        r0.curBytes = 0;     // Catch: Exception -> L172
        goto L36
    L31:
        r0.status = 0;     // Catch: Exception -> L172
    L172:
        e = move-exception;
        e.printStackTrace();
        goto L175
    L5:
        return new DownloadInfo();
    }

    public static ContentValues toContentValues(DownloadInfo r4) {
        ContentValues r0 = new ContentValues();
        r0.put("_id", Integer.valueOf(r4.getRawId()));
        r0.put("url", r4.getUrl());
        r0.put(DBDefinition.SAVE_PATH, r4.getSavePath());
        r0.put(DBDefinition.TEMP_PATH, r4.getRawTempPath());
        r0.put("name", r4.getName());
        r0.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(r4.getChunkCount()));
        r0.put("status", Integer.valueOf(r4.getStatus()));
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r4.getCurBytes()));
        r0.put(DBDefinition.BACK_CUR_BYTES, Long.valueOf(r4.getBackCurBytes()));
        r0.put(DBDefinition.TOTAL_BYTES, Long.valueOf(r4.getTotalBytes()));
        r0.put(DBDefinition.ETAG, r4.geteTag());
        r0.put(DBDefinition.ONLY_WIFI, Integer.valueOf(r4.isOnlyWifi() ? 1 : 0));
        r0.put(DBDefinition.FORCE, Integer.valueOf(r4.isForce() ? 1 : 0));
        r0.put(DBDefinition.RETRY_COUNT, Integer.valueOf(r4.getRetryCount()));
        r0.put("extra", r4.getExtra());
        r0.put(DBDefinition.MIME_TYPE, r4.getMimeType());
        r0.put(DBDefinition.TITLE, r4.getRawTitle());
        r0.put(DBDefinition.NOTIFICATION_ENABLE, Integer.valueOf(r4.isShowNotification() ? 1 : 0));
        r0.put(DBDefinition.NOTIFICATION_VISIBILITY, Integer.valueOf(r4.getNotificationVisibility()));
        r0.put(DBDefinition.FIRST_DOWNLOAD, Integer.valueOf(r4.getIsFirstDownload() ? 1 : 0));
        r0.put(DBDefinition.FIRST_SUCCESS, Integer.valueOf(r4.isFirstSuccess() ? 1 : 0));
        r0.put(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY, Integer.valueOf(r4.isNeedHttpsToHttpRetry() ? 1 : 0));
        r0.put(DBDefinition.DOWNLOAD_TIME, Long.valueOf(r4.getDownloadTime()));
        r0.put("packageName", r4.getPackageName());
        r0.put("md5", r4.getMd5());
        r0.put(DBDefinition.CUR_RETRY_TIME, Integer.valueOf(r4.getCurRetryTime()));
        r0.put(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP, Integer.valueOf(r4.isNeedDefaultHttpServiceBackUp() ? 1 : 0));
        r0.put(DBDefinition.CHUNK_RUNNABLE_REUSE, 0);
        r0.put(DBDefinition.CHUNK_DOWNGRADE_RETRY, 0);
        r0.put(DBDefinition.BACKUP_URLS_STR, r4.getBackUpUrlsStr());
        r0.put(DBDefinition.BACKUP_URL_RETRY_COUNT, Integer.valueOf(r4.getBackUpUrlRetryCount()));
        r0.put(DBDefinition.REAL_DOWNLOAD_TIME, Long.valueOf(r4.getRawRealDownloadTime()));
        r0.put(DBDefinition.REAL_BACK_DOWNLOAD_TIME, Long.valueOf(r4.getRawRealBackDownloadTime()));
        r0.put(DBDefinition.INDEPENDENT_PROCESS, Integer.valueOf(r4.isNeedIndependentProcess() ? 1 : 0));
        r0.put(DBDefinition.AUXILIARY_JSONOBJECT_STRING, r4.getDBJsonDataString());
        r0.put(DBDefinition.ICON_URL, r4.getIconUrl());
        r0.put(DBDefinition.APP_VERSION_CODE, Integer.valueOf(r4.getAppVersionCode()));
        r0.put(DBDefinition.TASK_ID, null);
        r0.put(DBDefinition.DOWNLOAD_START_TIMESTAMP, Long.valueOf(r4.getDownloadStartTimeStamp()));
        r0.put(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP, Long.valueOf(r4.getDownloadFinishTimeStamp()));
        r0.put(DBDefinition.INSTALLED_TIMESTAMP, Long.valueOf(r4.getInstalledTimeStamp()));
        r0.put(DBDefinition.HAS_DO_INSTALLATION, Integer.valueOf(r4.isHasDoInstallation() ? 1 : 0));
        r0.put(DBDefinition.CACHE_LIFE_TIME_MAX, Long.valueOf(r4.getCacheLifeTimeMax()));
        r0.put(DBDefinition.PCDN_URLS_STR, r4.getPcdnUrlsStr());
        r0.put(DBDefinition.CDN_URLS_STR, r4.getCdnUrlsStr());
        return r0;
    }

    public static void injectRemoteIp(IDownloadHttpConnection r2, BaseException r3) {
        IDownloadHttpConnection r4 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, AbsDownloadHttpConnection.class) == false) goto L16;
        if (r3 != null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, DownloadTTNetException.class) == false) goto L18;
        String r5 = ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r4, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).getHostIp();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        ((DownloadTTNetException) ZeusTransformUtils.preCheckCast(r3, DownloadTTNetException.class, "com.obric.aiagent.plugin")).setRemoteIp(r5);
    L13:
        ((DownloadTTNetException) ZeusTransformUtils.preCheckCast(r3, DownloadTTNetException.class, "com.obric.aiagent.plugin")).parseRemoteIp();
        return;
    L18:
        return;
    }

    public static void checkWorkerThread(String r3) {
        if (Logger.debug() == true) goto L5;
        return;
    L5:
        if (DownloadUtils.isMainThread() == false) goto L11;
        Logger.globalError(TAG, "checkWorkerThread", "This method:" + r3 + " cannot be executed on the main thread");
        IDownloadThreadCheckListener r0 = DownloadComponentManager.getDownloadThreadCheckListener();
        if (r0 == null) goto L12;
        r0.onError(r3);
        return;
    L12:
        return;
    }

    public static boolean isCdnCacheHit(List<Pair<String, String>> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return false;
    L5:
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.second, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
        if (((String) ZeusTransformUtils.preCheckCast(r2.second, String.class, "com.obric.aiagent.plugin")).toLowerCase().contains("hit") == false) goto L7;
        return true;
    L14:
        return false;
    }

    public static void removeHeaderKey(List<HttpHeader> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L25;
        if (r4 == null) goto L26;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L27;
        HttpHeader r0 = (HttpHeader) ZeusTransformUtils.preCheckCast(r6.next(), HttpHeader.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0.getName()) == true) goto L8;
        if (r0.getName().contains(r4) == false) goto L8;
        r6.remove();
        return;
    L27:
        return;
    L26:
        return;
    }

    public static void deleteDir(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (r5.contains(r6) == true) goto L34;
        File r0 = new File(r5);
        if (r0.exists() == true) goto L10;
        return;
    L10:
        if (r0.isDirectory() == false) goto L35;
        File[] r7 = r0.listFiles();
        if (r7 != null) goto L15;
    L26:
        r0.delete();
        return;
    L15:
        if (r7.length == 0) goto L26;
        int r1 = r7.length;
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L26;
        File r3 = r7[r2];
        if (r3.isFile() == false) goto L22;
        r3.delete();
    L25:
        r2 = r2 + 1;
        goto L17
    L22:
        if (r3.isDirectory() == false) goto L25;
        deleteDir(r3.getAbsolutePath(), r6);
        return;
    L35:
        return;
    }

    public static Set<String> getSkipDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.SKIP_DB_INIT_MONITOR_SCENE_LIST));
    }

    public static Set<String> getSkipDbInitExpectMimeTypeSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.SKIP_DB_INIT_EXPECT_MIME_TYPE));
    }

    public static Set<String> getDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.DB_INIT_MONITOR_SCENE_LIST));
    }

    private static Set<String> parseJSONArrayToSet(JSONArray r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.length() <= 0) goto L19;
        HashSet r0 = new HashSet();
        int r1 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r0;
    L8:
        if (r1 >= r3.length()) goto L13;
        r0.add(r3.getString(r1));     // Catch: JSONException -> L11
        r1 = r1 + 1;
        goto L16
    L19:
        return null;
    }

    public static boolean hitSkipDbInitScene(Set<String> r2, Set<String> r3, Set<String> r4, String r5, String r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L9:
        if (r8 != null) goto L11;
    L16:
        return false;
    L11:
        if (r8.contains(r5) == true) goto L16;
        if (r9 != null) goto L14;
        return true;
    L14:
        if (r9.contains(r6) == true) goto L16;
        return true;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (r7.contains(r6) == false) goto L9;
        return true;
    }
}
