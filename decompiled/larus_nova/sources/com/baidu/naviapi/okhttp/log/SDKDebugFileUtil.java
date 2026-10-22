package com.baidu.naviapi.okhttp.log;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.obric.sva.sdk.controller.Global;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes39.dex */
public class SDKDebugFileUtil {
    private static final DebugFileHandlerThread DEBUG_FILE_HANDLER_THREAD = null;
    private static final int MAX_LINE = 50000;
    private static final int MAX_SIZE = 10485760;
    private static Map<String, SDKDebugFileUtil> sFiles;
    private static SDKDebugFileUtil sInstance;
    private static String sModuleFileName;
    private static String sSDCardPath;
    private boolean mAddFileNameTime;
    private int mAllCoreLogLine;
    private BufferedWriter mBW;
    private DebugFileHandlerThread.Callback mChildThreadCallback;
    private BufferedWriter mCoreLogBW;
    private BufferedWriter mCoreLogBWForAllLog;
    private File mCoreLogDir;
    private int mCoreLogLine;
    private boolean mCoreLogRecordEnable;
    private SimpleDateFormat mCoreLogSDF;
    private File mFile;
    private String mFileName;
    private String mFilePath;
    private boolean mHasTime;
    private SimpleDateFormat mSDF;

    public static class CoreLogModuleInt {
        public static final int CORE_LOG_ALL = 4;

        public CoreLogModuleInt() {
        }
    }

    public void uploadLogFile(int r100, boolean r101, boolean r102, long r103) {
    }

    static {
        DEBUG_FILE_HANDLER_THREAD = new DebugFileHandlerThread("bd-log");
        sFiles = new ConcurrentHashMap();
        sInstance = null;
    }

    private void ensureFileNum() {
        File[] r100 = new PolarisFileWrapper(getCoreLogDir()).listFiles();     // Catch: Exception -> L13
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length <= 3) goto L22;
        int r101 = 0;
    L8:
        if (r101 >= (r100.length - 3)) goto L23;
        File r102 = findOldestFile(getCoreLogDir());     // Catch: Exception -> L13
        if (r102 == null) goto L12;
        r102.delete();     // Catch: Exception -> L13
    L12:
        r101 = r101 + 1;
        goto L8
    L23:
        return;
    L22:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static SDKDebugFileUtil getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SDKDebugFileUtil.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SDKDebugFileUtil();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SDKDebugFileUtil.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static void releaseRes() {
        Iterator<String> r100 = sFiles.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L16;
        String r101 = r100.next();
        SDKDebugFileUtil r102 = sFiles.get(r101);
        if (r102 == null) goto L24;
        BufferedWriter r103 = r102.mBW;
        if (r103 == null) goto L25;
        r103.flush();     // Catch: Throwable -> L12 IOException -> L17
        r102.mBW.close();     // Catch: Throwable -> L12 IOException -> L17
    L12:
        th = move-exception;
        sFiles.remove(r101);
        throw th;
    L15:
        sFiles.remove(r101);
        goto L4
    L25:
        return;
    L24:
        return;
    }

    public String getCoreLogDir() {
        File r100 = this.mCoreLogDir;     // Catch: Exception -> L15
        if (r100 == null) goto L10;
        if (r100.exists() == false) goto L10;
        if (this.mCoreLogDir.isDirectory() == false) goto L10;
    L17:
        File r101 = this.mCoreLogDir;
        if (r101 != null) goto L20;
        return null;
    L20:
        return r101.getAbsolutePath();
    L10:
        if (TextUtils.isEmpty(sModuleFileName) == true) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(sModuleFileName + File.separator + "NaviCoreLog");     // Catch: Exception -> L15
        this.mCoreLogDir = r102;     // Catch: Exception -> L15
        if (r102.exists() == true) goto L17;
        this.mCoreLogDir.mkdirs();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public String getKey() {
        return this.mFilePath + this.mFileName;
    }

    public boolean isValid() {
        File r100 = this.mFile;
        if (r100 != null) goto L5;
    L10:
        DEBUG_FILE_HANDLER_THREAD.unregisterCallback(this.mChildThreadCallback);
        return false;
    L5:
        if (r100.exists() == false) goto L10;
        if (this.mFile.isFile() == false) goto L10;
        return true;
    }

    private SDKDebugFileUtil() {
        this.mCoreLogDir = null;
        this.mCoreLogBW = null;
        this.mCoreLogBWForAllLog = null;
        this.mCoreLogSDF = null;
        this.mAllCoreLogLine = 0;
        this.mCoreLogLine = 0;
        this.mFilePath = null;
        this.mFileName = null;
        this.mAddFileNameTime = true;
        this.mHasTime = true;
        this.mFile = null;
        this.mBW = null;
        this.mSDF = null;
        this.mCoreLogRecordEnable = true;
        DebugFileHandlerThread.Callback r100 = new AnonymousClass1(this);
        this.mChildThreadCallback = r100;
        DEBUG_FILE_HANDLER_THREAD.registerCallback(r100);
    }

    public File getFile() {
        return this.mFile;
    }

    public static /* synthetic */ BufferedWriter access$100(SDKDebugFileUtil r100) {
        return r100.mBW;
    }

    public static /* synthetic */ boolean access$200(SDKDebugFileUtil r100) {
        return r100.mHasTime;
    }

    public static /* synthetic */ SimpleDateFormat access$300(SDKDebugFileUtil r100) {
        return r100.mSDF;
    }

    private void checkAllLogFile(File r100) {
        if (this.mAllCoreLogLine >= 50000) goto L6;
        return;
    L6:
        if (this.mCoreLogBWForAllLog != null) goto L9;
        return;
    L9:
        if (r100.length() <= BdpOkClient.CACHE_MAX_SIZE) goto L17;
        this.mAllCoreLogLine = 0;
        this.mCoreLogBWForAllLog.flush();     // Catch: IOException -> L13
        this.mCoreLogBWForAllLog.close();     // Catch: IOException -> L13
        this.mCoreLogBWForAllLog = null;     // Catch: IOException -> L13
        return;
    L13:
        this.mCoreLogBWForAllLog = null;
        return;
    }

    private void checkCoreLogFile(File r100) {
        if (this.mCoreLogLine >= 50000) goto L6;
        return;
    L6:
        if (this.mCoreLogBW != null) goto L9;
        return;
    L9:
        if (r100.length() <= BdpOkClient.CACHE_MAX_SIZE) goto L17;
        this.mCoreLogLine = 0;
        this.mCoreLogBW.flush();     // Catch: IOException -> L13
        this.mCoreLogBW.close();     // Catch: IOException -> L13
        this.mCoreLogBW = null;     // Catch: IOException -> L13
        return;
    L13:
        this.mCoreLogBW = null;
        return;
    }

    public static void end(String r100) {
        end(null, r100);
    }

    private File findOldestFile(String r100) {
        File[] r101 = new PolarisFileWrapper(r100).listFiles();
        File r102 = null;
        if (r101 != null) goto L15;
        return null;
    L15:
        SimpleDateFormat r103 = new SimpleDateFormat("yyyyMMdd");     // Catch: Exception -> L14
        Date r104 = r103.parse("99999999");     // Catch: Exception -> L14
        int r105 = r101.length;     // Catch: Exception -> L14
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L13;
        File r107 = r101[r106];     // Catch: Exception -> L14
        if (r107.getName().contains("naviCoreLog") == false) goto L12;
        Date r108 = r103.parse(r107.getName().substring(12));     // Catch: Exception -> L14
        if (r108.compareTo(r104) >= 0) goto L12;
        r102 = r107;
        r104 = r108;
    L12:
        r106 = r106 + 1;
    L13:
        return r102;
    }

    public static SDKDebugFileUtil get(String r100) {
        return get(null, r100, true, true);
    }

    public static void setModuleFileName(String r100) {
        sModuleFileName = r100;
    }

    public static void setSDCardPath(String r100) {
        sSDCardPath = r100;
    }

    public void add(String r100) {
        BufferedWriter r101 = this.mBW;
        if (r101 != null) goto L11;
        return;
    L11:
        StringBuilder r102 = new StringBuilder();     // Catch: IOException -> L10
        if (this.mHasTime == false) goto L8;
        r100 = this.mSDF.format(new Date()) + " # " + r100;     // Catch: IOException -> L10
    L8:
        r102.append(r100);     // Catch: IOException -> L10
        r102.append("\n");     // Catch: IOException -> L10
        r101.append(r102.toString());     // Catch: IOException -> L10
        this.mBW.flush();     // Catch: IOException -> L10
        return;
    }

    public void asyncAdd(String r110) {
        if (this.mHasTime == false) goto L7;
        SimpleDateFormat r100 = this.mSDF;
        if (r100 == null) goto L7;
        String r101 = r100.format(new Date());
    L8:
        String r102 = Process.myPid() + " " + Process.myTid();
        DebugFileHandlerThread r103 = DEBUG_FILE_HANDLER_THREAD;
        int r104 = hashCode();
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r110 = r101 + "###" + r102 + "###" + r110;
    L12:
        r103.sendMessage(303, r104, 0, r110, 0);
        return;
    L7:
        r101 = "";
        goto L8
    }

    public void asyncAddV2(String r100) {
        DEBUG_FILE_HANDLER_THREAD.sendMessage(303, hashCode(), 0, r100, 0);
    }

    public void doAsyncAdd(String r100) {
        BufferedWriter r101 = this.mBW;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.append(r100).append("\n");     // Catch: IOException -> L7
        this.mBW.flush();     // Catch: IOException -> L7
        return;
    }

    public void forceAdd(final String r100) {
        DebugFileHandlerThread r101 = DEBUG_FILE_HANDLER_THREAD;
        if (r101.getHandler() == null) goto L6;
        r101.getHandler().post(new AnonymousClass2(this, r100));
        return;
    }

    public void setCoreLogRecordEnable(boolean r100) {
        this.mCoreLogRecordEnable = r100;
    }

    private void doAddCoreLog(int r100, String r110) {
        if (getCoreLogDir() != null) goto L6;
        return;
    L6:
        if (4 != r100) goto L8;
        PolarisFileWrapper r101 = new PolarisFileWrapper(getCoreLogDir() + File.separator + "naviAllLog");
        checkAllLogFile(r101);
    L10:
        if (r101.exists() == false) goto L56;
    L16:
        boolean r102 = false;
    L17:
        if (r101 != null) goto L19;
        return;
    L19:
        if (r101.exists() == true) goto L22;
        return;
    L22:
        if (this.mCoreLogSDF != null) goto L25;
        this.mCoreLogSDF = new SimpleDateFormat("HH:mm:ss:SSS");
    L25:
        if (4 != r100) goto L39;
        if (this.mCoreLogBWForAllLog != null) goto L32;
        this.mAllCoreLogLine = 0;     // Catch: IOException -> L30
        this.mCoreLogBWForAllLog = new BufferedWriter(new PolarisFileWriterWrapper(r101));     // Catch: IOException -> L30
    L30:
        this.mCoreLogBWForAllLog = null;
    L32:
        if (this.mCoreLogSDF == null) goto L63;
        BufferedWriter r103 = this.mCoreLogBWForAllLog;
        if (r103 == null) goto L64;
        this.mAllCoreLogLine++;     // Catch: IOException -> L37
        r103.append(this.mCoreLogSDF.format(new Date()) + " " + r110 + "\n");     // Catch: IOException -> L37
        this.mCoreLogBWForAllLog.flush();     // Catch: IOException -> L37
        return;
    L37:
        this.mCoreLogBWForAllLog = null;
        return;
    L64:
        return;
    L63:
        return;
    L39:
        if (this.mCoreLogBW == null) goto L58;
        if (r102 == true) goto L58;
    L45:
        if (this.mCoreLogSDF == null) goto L66;
        BufferedWriter r104 = this.mCoreLogBW;
        if (r104 == null) goto L67;
        r104.append(this.mCoreLogSDF.format(new Date()) + " " + r110 + "\n");     // Catch: IOException -> L50
        this.mCoreLogLine = this.mCoreLogLine + 1;     // Catch: IOException -> L50
        this.mCoreLogBW.flush();     // Catch: IOException -> L50
        return;
    L50:
        this.mCoreLogBW = null;
        return;
    L67:
        return;
    L66:
        return;
    L58:
        this.mCoreLogLine = 0;     // Catch: IOException -> L43
        this.mCoreLogBW = new BufferedWriter(new PolarisFileWriterWrapper(r101));     // Catch: IOException -> L43
    L43:
        this.mCoreLogBW = null;
        goto L45
    L56:
        ensureFileNum();     // Catch: Exception -> L15
        if (r101.createNewFile() == true) goto L14;
        r101 = null;
    L14:
        r102 = true;
    L15:
        r101 = null;
        goto L16
    L8:
        PolarisFileWrapper r105 = new PolarisFileWrapper(getCoreLogDir() + File.separator + "naviCoreLog_" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
        checkCoreLogFile(r105);
        r101 = r105;
        goto L10
    }

    public static void end(String r100, String r101) {
        String r102 = getKey(r100, r101);
        if (sFiles.containsKey(r102) == true) goto L5;
        return;
    L5:
        SDKDebugFileUtil r103 = sFiles.get(r102);
        if (r103 == null) goto L20;
        BufferedWriter r104 = r103.mBW;
        if (r104 == null) goto L21;
        r104.flush();     // Catch: Throwable -> L12 IOException -> L17
        r103.mBW.close();     // Catch: Throwable -> L12 IOException -> L17
    L12:
        th = move-exception;
        sFiles.remove(r102);
        throw th;
    L15:
        sFiles.remove(r102);
        return;
    L21:
        return;
    }

    public static String getKey(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r100.length() == 0) goto L6;
    L9:
        return r100 + r101;
    L6:
        if (TextUtils.isEmpty(sSDCardPath) == true) goto L9;
        r100 = sSDCardPath + File.separator + "log";
        goto L9
    }

    public static /* synthetic */ void access$000(SDKDebugFileUtil r100, int r101, String r102) {
        r100.doAddCoreLog(r101, r102);
    }

    public static SDKDebugFileUtil get(String r100, String r101, boolean r102) {
        return get(r100, r101, true, r102);
    }

    public static SDKDebugFileUtil get(String r100, boolean r101, boolean r102) {
        return get(null, r100, r101, r102);
    }

    private SDKDebugFileUtil(String r100, String r101, boolean r102, boolean r103) {
        this.mCoreLogDir = null;
        this.mCoreLogBW = null;
        this.mCoreLogBWForAllLog = null;
        this.mCoreLogSDF = null;
        this.mAllCoreLogLine = 0;
        this.mCoreLogLine = 0;
        this.mFilePath = null;
        this.mFileName = null;
        this.mAddFileNameTime = true;
        this.mHasTime = true;
        this.mFile = null;
        this.mBW = null;
        this.mSDF = null;
        this.mCoreLogRecordEnable = true;
        this.mChildThreadCallback = new AnonymousClass1(this);
        this.mFilePath = r100;
        this.mFileName = r101;
        this.mAddFileNameTime = r102;
        this.mHasTime = r103;
        if (r100 == null) goto L7;
        if (r100.length() == 0) goto L7;
    L9:
        BufferedWriter r104 = this.mBW;
        if (r104 == null) goto L15;
        r104.close();     // Catch: IOException -> L13
    L15:
        if (this.mFilePath != null) goto L17;
    L37:
        this.mFile = null;
    L39:
        if (this.mFile == null) goto L53;
        this.mSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        this.mBW = new BufferedWriter(new PolarisFileWriterWrapper(this.mFile, true));     // Catch: IOException -> L43
        sFiles.put(getKey(), this);     // Catch: IOException -> L43
        DEBUG_FILE_HANDLER_THREAD.registerCallback(this.mChildThreadCallback);     // Catch: IOException -> L43
        return;
    L43:
        this.mSDF = null;
        this.mFile = null;
        this.mBW = null;
        return;
    L53:
        return;
    L17:
        if (this.mFileName == null) goto L37;
        SimpleDateFormat r105 = new SimpleDateFormat("yyyyMMdd_HH");
        this.mSDF = r105;
        String r106 = r105.format(new Date());
        StringBuilder r107 = new StringBuilder();
        r107.append(this.mFilePath);
        r107.append(File.separator);
        r107.append(this.mFileName);
        if (this.mAddFileNameTime == false) goto L21;
        String r108 = "_" + r106;
    L22:
        r107.append(r108);
        r107.append(Global.SUFFIX_TXT_FILE);
        PolarisFileWrapper r109 = new PolarisFileWrapper(r107.toString());
        this.mFile = r109;
    L27:
        this.mFile = null;
    L28:
        File r110 = this.mFile;
        if (r110 == null) goto L39;
        if (r110.exists() == true) goto L39;
    L36:
        this.mFile = null;
        goto L39
    L33:
        if (this.mFile.createNewFile() == true) goto L39;
        this.mFile = null;     // Catch: IOException -> L36
        goto L39
    L24:
        if (r109.getParentFile().exists() == true) goto L28;
        this.mFile.getParentFile().mkdirs();     // Catch: Exception -> L27
        goto L28
    L21:
        r108 = "";
    L7:
        if (TextUtils.isEmpty(sSDCardPath) == true) goto L9;
        this.mFilePath = sSDCardPath + File.separator + "log";
        goto L9
    }

    public static synchronized SDKDebugFileUtil get(String r100, String r101, boolean r102, boolean r103) {
        monitor-enter(SDKDebugFileUtil.class);
        String r104 = getKey(r100, r101);     // Catch: Throwable -> L16
        if (sFiles.containsKey(r104) == false) goto L13;
        SDKDebugFileUtil r105 = sFiles.get(r104);     // Catch: Throwable -> L16
        if (r105 != null) goto L9;
    L12:
        sFiles.remove(r104);     // Catch: Throwable -> L16
        goto L13
    L9:
        if (r105.isValid() == false) goto L12;
        monitor-exit(SDKDebugFileUtil.class);
        return r105;
    L13:
        releaseRes();     // Catch: Throwable -> L16
        SDKDebugFileUtil r106 = new SDKDebugFileUtil(r100, r101, r102, r103);     // Catch: Throwable -> L16
        monitor-exit(SDKDebugFileUtil.class);
        return r106;
    L16:
        th = move-exception;
        throw th;
    }
}
