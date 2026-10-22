package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BDImageUploader extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDPreHeatModeLocalStorge = 2;
    public static final int BDPreHeatModeNone = 0;
    public static final int BDPreHeatModeReader = 1;
    public static final int BDPreHeatModeUseStorge = 3;
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int CommitTypeCommit = 1;
    public static final int CommitTypeNoCommit = 0;
    public static final int CommitTypeNoDepend = 2;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsAliveMaxFailTime = 22;
    public static final int KeyIsApplyAuth = 83;
    public static final int KeyIsAuthType = 416;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsCommitAuth = 84;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsEnableCommitUpload = 401;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetImageMeta = 410;
    public static final int KeyIsGetImageURI = 409;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetUUID = 1;
    public static final int KeyIsGetUploadErrorMessage = 415;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsImageCountThreshold = 438;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMetaInfoParams = 61;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadApply = 419;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessAction = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetfileNum = 71;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceThreshold = 402;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTopAccessKey = 42;
    public static final int KeyIsTopSecretKey = 43;
    public static final int KeyIsTopSessionToken = 44;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsPreHeatComplete = 123;
    public static final int MessageIsPreHeatResultUsed = 124;
    public static final int MessageIsUploadCompleteTos = 122;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsSingleImageComplete = 6;
    public static final int MsgIsSingleImageFail = 7;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int UploadFunctionTypeEncryption = 1;
    public static final int UploadFunctionTypeGetMedia = 2;
    public static final int UploadFunctionTypeNoProcess = 0;
    public static final int UploadFunctionTypeUploadMediaLog = 2;
    public static final int keyIsConfigString = 56;
    public static final int keyIsMediaData = 0;
    private static final int mInnerUploaderType = 0;
    private c mAbstractListener;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private int mImageNum;
    private d mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mStartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f37454b;

        public int a() {
            return this.f37453a;
        }

        public String b() {
            return this.f37454b;
        }

        public a(int r1, String r2) {
            this.f37453a = r1;
            this.f37454b = r2;
        }
    }

    private static native void _allowContinueUpload(long r0);

    private static native void _cancelUpload(long r0);

    private static native void _close(long r0);

    private final native long _create(int r1);

    private static native long _getLongValue(long r0, int r2);

    private static native String _getStrByKeyAndIndex(long r0, int r2, int r3);

    private static native String _getStringValue(long r0, int r2);

    private static native void _mergeUpload(long r0);

    private static native void _setFileData(long r0, int r2, byte[][] r3);

    private static native void _setFileName(long r0, int r2, String[] r3);

    private static native void _setFileNum(long r0, int r2);

    private static native void _setFilePaths(long r0, int r2, String[] r3);

    private static native void _setFileStoreKeys(long r0, int r2, String[] r3);

    private static native void _setInt64Value(long r0, int r2, long r3);

    private static native void _setIntValue(long r0, int r2, int r3);

    private static native void _setObject(long r0, int r2, Object r3);

    private static native void _setSpecifiedContentType(long r0, int r2, String[] r3);

    private static native void _setStringValue(long r0, int r2, String r3);

    private static native void _start(long r0);

    private static native void _stop(long r0);

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public void setPreUpload(boolean r1) {
    }

    public BDImageUploader() {
        this.mState = -1;
        this.mImageNum = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mHandle = _create(0);     // Catch: Throwable -> L5
    L6:
        long r3 = this.mHandle;
        if (r3 == 0) goto L15;
        _setIntValue(r3, BDAbstractUpload.KeyIsEnableNativeLog, t.h.booleanValue() ? 1 : 0);
        if (Looper.myLooper() == null) goto L11;
        this.mHandler = new Handler(this);
    L12:
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        return;
    L11:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L12
    L15:
        throw new Exception("create native uploader fail");
    L5:
        this.mHandle = 0;
        goto L6
    }

    public static boolean isError() {
        return IsErrored;
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }

    public void setListener(d r3) {
        this.mListener = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
    }

    public void setAbstractListener(c r1) {
        this.mAbstractListener = r1;
    }

    public void startPreHeat() {
        setPreheatUploader(2);
        start();
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String getStringFromExtern(int r1) {
        if (r1 != 0) goto L4;
        c r0 = this.mAbstractListener;
        if (r0 != null) goto L13;
    L10:
        return null;
    L13:
        return r0.a(r1);
    L4:
        if (r1 != 1) goto L10;
        return UUID.randomUUID().toString();
    }

    public void onNotify(int r11, long r12, int r14, String r15) {
        int r1 = 1;
        if (this.mState == 1) goto L5;
        return;
    L5:
        b r0 = null;
        int r13 = (int) r12;
        if (r11 == 0) goto L34;
        if (r11 != 1) goto L9;
        r0 = new b(null, r14, null, r13, null, null);
    L40:
        r1 = r13;
    L41:
        Message r10 = this.mHandler.obtainMessage();
        r10.what = r11;
        r10.arg1 = r1;
        r10.obj = r0;
        r10.sendToTarget();
        return;
    L9:
        if (r11 == 2) goto L27;
        if (r11 != 3) goto L12;
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 2;
        goto L40
    L12:
        if (r11 != 6) goto L14;
        this.mEndTime = System.currentTimeMillis();
        r0 = new b(_getStrByKeyAndIndex(this.mHandle, 409, r13), 0, null, r13, _getStrByKeyAndIndex(this.mHandle, 410, r13), _getStrByKeyAndIndex(this.mHandle, 407, r13));
        goto L40
    L14:
        if (r11 != 7) goto L16;
        _getStrByKeyAndIndex(this.mHandle, 415, r13);
        r0 = new b(null, r14, r15, r13, null, null);
        goto L40
    L16:
        if (r11 != 123) goto L18;
        r0 = new b(null, r14, null, r13, null, null);
        goto L40
    L18:
        if (r11 != 124) goto L40;
        if (r13 == 0) goto L41;
        r1 = 0;
        goto L41
    L27:
        String r16 = getDNSIP();
        if (r16 != null) goto L30;
    L32:
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 2;
        goto L40
    L30:
        if (r16.isEmpty() == true) goto L32;
        setStringValue(75, r16);
        goto L32
    L34:
        String r17 = getDNSIP();
        if (r17 != null) goto L37;
    L39:
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 3;
        goto L40
    L37:
        if (r17.isEmpty() == true) goto L39;
        setStringValue(75, r17);
        goto L39
    }

    public void onLogInfo(int r3, int r4, String r5) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        a r0 = new a(r4, r5);
        Message r2 = this.mHandler.obtainMessage();
        r2.what = r3;
        r2.obj = r0;
        r2.sendToTarget();
    }

    public void onLogInfoSync(int r4, int r5, String r6) {
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (r4 != 103) goto L9;
        long r0 = new Date().getTime();
        c r2 = this.mAbstractListener;
        if (r2 == null) goto L9;
        r2.a(r5, r0);
    L9:
        this.mListener.a(r4, r5, r6);
    }

    public int checkNet(int r1, int r2) {
        d r0 = this.mListener;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.a(r1, r2);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r7) {
        int r0 = r7.what;
        if (ZeusTransformUtils.instanceOf(r7.obj, a.class) == false) goto L7;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7.obj, a.class, "com.obric.aiagent.plugin");
        onLogInfoSync(r0, r8.a(), r8.b());
        return true;
    L7:
        if (this.mListener != null) goto L9;
        return true;
    L9:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r7.obj, b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L12;
        long r4 = r1.f37470c;
    L14:
        if (r0 != 124) goto L16;
        r4 = r7.arg1;
    L16:
        this.mListener.a(r0, r4, r1);
        return true;
    L12:
        r4 = 0;
        goto L14
    }

    public String getDNSIP() {
        return t.b();
    }

    public void setProcessActionType(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 65, r5);
    }

    public void setObjectType(String r2) {
        setStringValue(54, r2);
    }

    public void setFilePath(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        this.mImageNum = r5;
        _setFilePaths(r0, r5, r6);
        _setIntValue(this.mHandle, 81, 0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileNum(int r5, int r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        this.mImageNum = r5;
        _setFileNum(r0, r5);
        _setIntValue(this.mHandle, KeyIsImageCountThreshold, r6);
        return;
    L9:
        return;
    }

    public void setTopAccessKey(String r2) {
        setStringValue(42, r2);
    }

    public void setTopSecretKey(String r2) {
        setStringValue(43, r2);
    }

    public void setTopSessionToken(String r2) {
        setStringValue(44, r2);
    }

    public void setSpaceName(String r2) {
        setStringValue(45, r2);
    }

    public void setUploadDomain(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        setStringValue(46, r5);
        return;
    L9:
        return;
    }

    public void setStringValue(int r5, String r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r6 == null) goto L9;
        _setStringValue(r0, r5, r6);
        return;
    L9:
        return;
    }

    public void setServerParameter(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 16, r5);
        return;
    L9:
        return;
    }

    public void setRWTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 7, r5);
        return;
    L9:
        return;
    }

    public void setSliceSize(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 8, r5);
        return;
    L9:
        return;
    }

    public void setSocketNum(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 9, r5);
        return;
    L9:
        return;
    }

    public void setMaxConcurrentFileNum(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 400, r5);
        return;
    L9:
        return;
    }

    public void setSliceRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 5, r5);
        return;
    L9:
        return;
    }

    public void setFileRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 6, r5);
        return;
    L9:
        return;
    }

    public void setEnableHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 19, r5);
        return;
    L9:
        return;
    }

    public void setPolicyParams(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = t.a(r5);
        if (r6 == null) goto L11;
        setStringValue(55, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void SetExtraParams(JSONObject r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        setStringValue(61, r5.toString());
        return;
    L9:
        return;
    }

    public void setConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = t.a(r5);
        if (r6 == null) goto L11;
        setStringValue(56, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setCustomConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L21;
        if (r5 == null) goto L22;
        JSONObject r6 = t.b(r5);
        if (r6 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();
        r0.put("custom_config", r6);     // Catch: Throwable -> L15
        String r7 = r0.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r7) == true) goto L20;
        setStringValue(63, r7);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public void setMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 13, r5);
        return;
    L9:
        return;
    }

    public void setTranTimeOutUnit(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 64, r5);
        return;
    L9:
        return;
    }

    public void start() {
        this.mReadLock.lock();
        if (t.f37559d != null) goto L5;
    L15:
    L12:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L8:
        if (this.mHandle == 0) goto L10;
        this.mState = 1;     // Catch: Throwable -> L12
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L12
        _start(this.mHandle);     // Catch: Throwable -> L12
    L10:
        this.mReadLock.unlock();
        return;
    L5:
        if (t.f37559d.length() <= 0) goto L15;
        setContextDir(t.f37559d);
        goto L15
    }

    public void stop() {
        this.mWriteLock.lock();
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mHandle == 0) goto L6;
        INVOKESTATIC_com_ss_bduploader_BDImageUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ttmn", "before java stop");     // Catch: Throwable -> L8
        _stop(this.mHandle);     // Catch: Throwable -> L8
        addLogToManager(_getStringValue(this.mHandle, 100));     // Catch: Throwable -> L8
        this.mState = 4;     // Catch: Throwable -> L8
        INVOKESTATIC_com_ss_bduploader_BDImageUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ttmn", "after java stop");     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
    }

    public void close() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        _close(r0);     // Catch: Throwable -> L8
        this.mHandle = 0;     // Catch: Throwable -> L8
        this.mState = 5;     // Catch: Throwable -> L8
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void addLogToManager(String r11) {
        String r2 = UUID.randomUUID().toString();
        if (r2 != null) goto L5;
    L6:
        r2 = "invalid_uuid";
    L27:
        JSONObject r3 = new JSONObject(r11);     // Catch: Exception -> L9
        r3.put("dns_version", BDUploadResolver.f37460b);     // Catch: Exception -> L9
        r3.put("main_dns_type", com.ss.bduploader.net.c.f37521a);     // Catch: Exception -> L9
        r3.put("main_back_type", com.ss.bduploader.net.c.f37522b);     // Catch: Exception -> L9
        r3.put("back_delayed_time", com.ss.bduploader.net.c.f37523c);     // Catch: Exception -> L9
        r3.put("expired_time", com.ss.bduploader.net.c.f37524d);     // Catch: Exception -> L9
        r3.put("uuid", r2);     // Catch: Exception -> L9
        r3.remove("event");     // Catch: Exception -> L9
        r3.put("event", "bd_image_upload_all");     // Catch: Exception -> L9
    L10:
        if (r3 != null) goto L25;
    L23:
        x.f37566a.a(r3);
        return;
    L25:
        JSONArray r12 = r3.getJSONArray("image_array");     // Catch: Exception -> L22
        if (r12 == null) goto L23;
        r3.remove("image_array");     // Catch: Exception -> L22
        int r0 = 0;
    L14:
        if (r0 >= r12.length()) goto L23;
        JSONObject r4 = new JSONObject(r3.toString());     // Catch: Exception -> L22
        r4.remove("event");     // Catch: Exception -> L22
        r4.put("event", "bd_image_upload_single");     // Catch: Exception -> L22
        JSONObject r5 = r12.getJSONObject(r0);     // Catch: Exception -> L22
        Iterator<String> r6 = r5.keys();     // Catch: Exception -> L22
    L18:
        if (r6.hasNext() == false) goto L20;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
        r4.put(r7, r5.get(r7));     // Catch: Exception -> L22
        goto L18
    L20:
        r4.put("uuid", r2);     // Catch: Exception -> L22
        x.f37566a.a(r4);     // Catch: Exception -> L22
        r0 = r0 + 1;
    L22:
        INVOKESTATIC_com_ss_bduploader_BDImageUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ttmn", "get image_array failed");
    L9:
        r3 = null;
        goto L10
    L5:
        if (r2.length() > 0) goto L27;
        goto L6
    }

    public void setTraceId(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 69, r5);
        return;
    L12:
        return;
    }

    public void setOpenBoe(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        _setIntValue(r0, 67, 1);
        return;
    L8:
        _setIntValue(r0, 67, 0);
    }

    public void setMediaDataReader(j r5, int r6) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r7 == null) goto L10;
        if (r6 <= 0) goto L11;
        _setIntValue(r0, 71, r6);
        _setIntValue(this.mHandle, 81, 2);
        _setObject(this.mHandle, 201, r7);
        return;
    L11:
        return;
    L10:
        return;
    }

    private void setMediaDataReader(j r5, int r6, int r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
        if (this.mHandle == 0) goto L9;
        if (r8 == null) goto L10;
        if (r6 <= 0) goto L11;
        setMediaDataReader(r8, r6);
        _setIntValue(this.mHandle, 81, r7);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileName(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _setFileName(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSpecifiedContentType(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _setSpecifiedContentType(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileData(int r5, byte[][] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _setFileData(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setScenesTag(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 85, r5);
        return;
    L9:
        return;
    }

    public void setEnableCommitUpload(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 401, r5);
    }

    public void setEnableCommitUpload(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 401, r5 ? 1 : 0);
    }

    public void setSliceThreshold(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 402, r5);
    }

    public void setNetworkType(int r5, int r6) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, r5, r6);
    }

    public void setEnableLogCallBack(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        _setIntValue(r0, 78, 1);
        return;
    L8:
        _setIntValue(r0, 78, 0);
    }

    public void setDataTransportProtocol(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 411, r5);
        return;
    L9:
        return;
    }

    public void setAuthType(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 416, r5);
    }

    public void setQueryAuth(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 15, r5);
        return;
    L9:
        return;
    }

    public void setSDKConfigDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        t.a(r5);
        _setStringValue(this.mHandle, 417, r5);
        setContextDir(r5);
        return;
    L9:
        return;
    }

    private void setContextDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        String r6 = r5 + File.separator + t.f37556a;
        t.a(r6);
        _setStringValue(this.mHandle, 418, r6);
        return;
    L9:
        return;
    }

    public void setCustomHttpHeaders(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = t.a(r5);
        if (r6 == null) goto L11;
        setStringValue(BDAbstractUpload.KeyIsCustomHttpHeaders, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void allowMergeUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _mergeUpload(r0);
    }

    public void setPreUploadEncryptionMode(int r5) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (r5 != 2) goto L12;
        String r0 = UUID.randomUUID().toString();
        if (r0 == null) goto L12;
        if (r0.length() <= 0) goto L12;
        _setStringValue(this.mHandle, BDAbstractUpload.KeyIsBatchSessionKey, r0);
    L12:
        _setIntValue(this.mHandle, 74, r5);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        this.mWriteLock.unlock();
        return;
    L6:
        _cancelUpload(r0);
        this.mWriteLock.unlock();
    }

    public void setPreheatUploader(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 419, r5 ? 1 : 0);
    }

    public void setPreheatUploader(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 419, r5);
    }

    public void allowContinueUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _allowContinueUpload(r0);
    }

    public void setCustomNetworkTimeoutParams(int r5, int r6, int r7, int r8, int r9) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, BDAbstractUpload.KeyIsSocketConnectTimeout, r5);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketReadTimeout, r6);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketWriteTimeout, r7);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsTotalRequestTimeout, r8);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSDKRetryPolicy, r9);
    }

    public void setSDKMaxRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, BDAbstractUpload.KeyIsSDKMaxRetryCount, r5);
    }

    public void setSDKMaxRetryTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, BDAbstractUpload.KeyIsSDKMaxRetryTimeout, r5);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDImageUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
