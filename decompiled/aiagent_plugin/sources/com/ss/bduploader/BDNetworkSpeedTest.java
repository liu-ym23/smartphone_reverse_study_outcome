package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BDNetworkSpeedTest extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDNetworkRoutModeDomain = 0;
    public static final int BDNetworkRoutModeTopNHost = 1;
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
    public static final int KeyIsAuthType = 416;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsDisableUploadInfo = 301;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableExternNet = 26;
    public static final int KeyIsEnableFileTryHttps = 25;
    public static final int KeyIsEnableHeaderXStorageMode = 83;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableIntelligentSpeedTest = 431;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnableMutiTask = 29;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsEnableQuic = 28;
    public static final int KeyIsExternFileReader = 200;
    public static final int KeyIsExternNetLoader = 27;
    public static final int KeyIsExternNetParameter = 41;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsIntelligentTestResult = 432;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessActionType = 65;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetUserRefrence = 62;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
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
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int keyIsConfigString = 56;
    private boolean hasInit;
    private int mEnableIntelligentSpeedTest;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private String mIntelligentModelURL;
    private o mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private com.ss.bduploader.b.e mSmartSpeedTest;
    private long mStartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    private static native void _close(long r0);

    private final native long _create();

    private static native void _setIntValue(long r0, int r2, int r3);

    private static native void _setStringValue(long r0, int r2, String r3);

    private static native void _start(long r0);

    private static native void _stop(long r0);

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public void onLogInfo(int r1, int r2, String r3) {
    }

    public BDNetworkSpeedTest() {
        this.mState = -1;
        this.mIntelligentModelURL = "";
        this.mEnableIntelligentSpeedTest = 0;
        this.hasInit = false;
        this.mHandler = null;
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.mReadWritedLock = r1;
        this.mListener = null;
        if (Looper.myLooper() == null) goto L5;
        this.mHandler = new Handler(this);
    L6:
        this.mReadLock = r1.readLock();
        this.mWriteLock = r1.writeLock();
        this.mHandle = _create();     // Catch: Throwable -> L9
    L10:
        long r2 = this.mHandle;
        if (r2 == 0) goto L15;
        _setIntValue(r2, BDAbstractUpload.KeyIsEnableNativeLog, t.h.booleanValue() ? 1 : 0);
        return;
    L15:
        throw new Exception("create native speed tester fail");
    L9:
        this.mHandle = 0;
        goto L10
    L5:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L6
    }

    public void onNotify(int r2, long r3, int r5, String r6) {
        JSONObject r7 = new JSONObject(r6).getJSONObject("upload_log");     // Catch: Exception -> L4
    L5:
        x.f37566a.a(r7);
        n r8 = new n(r6, r2, (int) r3);
        Handler r1 = this.mHandler;
        if (r1 == null) goto L11;
        Message r4 = r1.obtainMessage();
        r4.what = r2;
        r4.obj = r8;
        r4.sendToTarget();
        return;
    L11:
        return;
    L4:
        r7 = null;
        goto L5
    }

    public int checkNet(int r1, int r2) {
        o r0 = this.mListener;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.a(r1, r2);
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }

    public void setListener(o r3) {
        this.mListener = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
    }

    public void setUploadDomain(String r2) {
        setStringValue(46, r2);
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

    public void setStringValue(int r5, String r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r6 == null) goto L9;
        _setStringValue(r0, r5, r6);
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
        long r0 = this.mHandle;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        _stop(r0);     // Catch: Throwable -> L8
        this.mState = 4;     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
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

    public void setProcessActionType(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 65, r5);
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

    public void setTranTimeOutUnit(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 64, r5);
        return;
    L9:
        return;
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

    public void setMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 13, r5);
        return;
    L9:
        return;
    }

    public void setTcpOpenTimeOutMilliSec(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 24, r5);
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

    public void setEnableHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 19, r5);
        return;
    L9:
        return;
    }

    public void setEnableExternDNS(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 21, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setNetworkType(int r5, int r6) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, r5, r6);
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

    public void setRegionName(String r2) {
        setStringValue(47, r2);
    }

    public void setSpaceName(String r2) {
        setStringValue(45, r2);
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

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        if (this.mListener != null) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3.obj, n.class) == false) goto L10;
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3.obj, n.class, "com.obric.aiagent.plugin");
        this.mListener.a(r4.f37503b, r4.f37504c, r4.f37502a);
        return true;
    L10:
        return true;
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

    public void setIntelligentSpeedTestInfo(int r5, String r6) {
        if (this.mHandle == 0) goto L11;
        if (r6 == null) goto L12;
        this.mEnableIntelligentSpeedTest = r5;
        this.mIntelligentModelURL = r6;
        if (r5 != 1) goto L9;
        checkAndInit(r6);
        preloadModel();
    L9:
        _setIntValue(this.mHandle, KeyIsEnableIntelligentSpeedTest, r5);
        return;
    L12:
        return;
    }

    private void checkAndInit(String r2) {
        if (this.hasInit == false) goto L5;
        return;
    L5:
        this.hasInit = true;
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return;
    L8:
        com.ss.bduploader.b.e r0 = new com.ss.bduploader.b.e();
        this.mSmartSpeedTest = r0;
        r0.a();
        this.mSmartSpeedTest.b(r2);
        this.mSmartSpeedTest.b();
    }

    private void preloadModel() {
        com.ss.bduploader.b.e r0 = this.mSmartSpeedTest;
        if (r0 == null) goto L6;
        r0.c();
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

    private float predictIntelligentSpeed(JSONObject r1) {
        com.ss.bduploader.b.e r0 = this.mSmartSpeedTest;
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.a(r1);
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String intelligentInterface(int r6, String r7) {
        INVOKESTATIC_com_ss_bduploader_BDNetworkSpeedTest_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "intelligentInterface:what:" + r6 + ",value:" + r7);
        JSONObject r0 = new JSONObject();
        if (r6 == 3) goto L8;
        if (r6 == 5) goto L8;
    L22:
        if (r0 != null) goto L24;
        return "";
    L24:
        INVOKESTATIC_com_ss_bduploader_BDNetworkSpeedTest_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("Intelligent speed test", " what: " + r6 + "prediction result: " + r0.toString());
        return r0.toString();
    L8:
        if (r6 != 3) goto L10;
        int r2 = 1;
    L11:
        com.ss.bduploader.b.e r4 = this.mSmartSpeedTest;
        if (r4 != null) goto L14;
        return "";
    L14:
        r4.a(r2);
        JSONObject r3 = new JSONObject(r7);     // Catch: Exception -> L21
        if (this.mEnableIntelligentSpeedTest != 1) goto L22;
        float r5 = predictIntelligentSpeed(r3);     // Catch: Exception -> L21
        if (r5 <= 0.0f) goto L22;
        r0.put("intelligentTestResult", r5);     // Catch: Exception -> L21
    L21:
        r0 = null;
        goto L22
    L10:
        r2 = 0;
        goto L11
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDNetworkSpeedTest_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
