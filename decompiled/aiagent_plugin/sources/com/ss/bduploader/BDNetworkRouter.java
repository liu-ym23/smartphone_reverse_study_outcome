package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BDNetworkRouter extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDNetworkRoutModeDomain = 0;
    public static final int BDNetworkRoutModeTopNHost = 1;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    private static boolean IsErrored = false;
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
    public static final int KeyIsIntelligentInitial = 0;
    public static final int KeyIsIntelligentPredict = 1;
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
    public static final int KeyIsRouteWeight = 408;
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
    public static final int RoutingQUIC = 0;
    public static final int RoutingTCP = 1;
    public static final int keyIsConfigString = 56;
    private boolean hasInit;
    private long mEndTime;
    private int mEstimatedFileSize;
    private long mHandle;
    private Handler mHandler;
    private m mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private com.ss.bduploader.b.b mSmartRouting;
    private long mStartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    static {
    }

    private static native void _close(long r0);

    private final native long _create(int r1);

    private static native void _setContext(long r0, String r2);

    private static native void _setIntValue(long r0, int r2, int r3);

    private static native void _setStringValue(long r0, int r2, String r3);

    private static native void _start(long r0);

    private static native void _stop(long r0);

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public void onLogInfo(int r1, int r2, String r3) {
    }

    public BDNetworkRouter(int r5) {
        this.hasInit = false;
        this.mState = -1;
        this.mEstimatedFileSize = -1;
        this.mHandler = null;
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.mReadWritedLock = r1;
        this.mListener = null;
        if (Looper.myLooper() == null) goto L5;
        this.mHandler = new Handler(this);
    L6:
        this.mReadLock = r1.readLock();
        this.mWriteLock = r1.writeLock();
        this.mHandle = _create(r5);     // Catch: Throwable -> L9
    L10:
        long r4 = this.mHandle;
        if (r4 == 0) goto L15;
        _setIntValue(r4, BDAbstractUpload.KeyIsEnableNativeLog, t.h.booleanValue() ? 1 : 0);
        return;
    L15:
        throw new Exception("create native network router fail");
    L9:
        this.mHandle = 0;
        goto L10
    L5:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L6
    }

    public void onNotify(int r1, long r2, int r4, String r5) {
        l r6 = new l(r5, r1, (int) r2);
        Handler r0 = this.mHandler;
        if (r0 == null) goto L6;
        Message r3 = r0.obtainMessage();
        r3.what = r1;
        r3.obj = r6;
        r3.sendToTarget();
        return;
    }

    public int checkNet(int r1, int r2) {
        m r0 = this.mListener;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.a(r1, r2);
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }

    public void setListener(m r3) {
        this.mListener = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
    }

    public void setUploadDomain(String r2) {
        setStringValue(46, r2);
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

    public void setProcessActionType(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 65, r5);
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

    public void setRouteWeight(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 408, r5);
        return;
    L9:
        return;
    }

    private void setStringValue(int r5, String r6) {
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

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        if (this.mListener != null) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3.obj, l.class) == false) goto L10;
        l r4 = (l) ZeusTransformUtils.preCheckCast(r3.obj, l.class, "com.obric.aiagent.plugin");
        this.mListener.a(r4.f37500b, r4.f37501c, r4.f37499a);
        return true;
    L10:
        return true;
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String intelligentInterface(int r3, String r4) {
        INVOKESTATIC_com_ss_bduploader_BDNetworkRouter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "intelligentInterface:what:" + r3 + ",value:" + r4);
        if (r3 != 0) goto L5;
        checkAndInit(r4);
        preloadModel();
    L9:
        JSONObject r2 = null;
    L10:
        if (r2 != null) goto L13;
        return "";
    L13:
        INVOKESTATIC_com_ss_bduploader_BDNetworkRouter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("intelligent_routing", "prediction result: " + r2.toString());
        return r2.toString();
    L5:
        if (r3 != 1) goto L9;
        r2 = processIntelligentPrediction(predictIntelligentTCPQUIC(insertFileSizeInfo(r4)));
        goto L10
    }

    private String insertFileSizeInfo(String r3) {
        JSONObject r0 = new JSONObject(r3);     // Catch: Exception -> L4
        r0.put("file_size", (this.mEstimatedFileSize / 1024) / 1024);     // Catch: Exception -> L4
    L5:
        if (r0 != null) goto L8;
        return r3;
    L8:
        return r0.toString();
    L4:
        r0 = null;
        goto L5
    }

    private JSONObject processIntelligentPrediction(float r7) {
        INVOKESTATIC_com_ss_bduploader_BDNetworkRouter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("intelligent routing", "process prediction result:" + r7);
        JSONObject r6 = new JSONObject();
        if (r7 >= 0.0f) goto L5;
    L15:
        return null;
    L5:
        if (r7 > 1.0f) goto L15;
        if (r7 < 0.5d) goto L10;
        r6.put("intelligentRoutingResult", 1);     // Catch: JSONException -> L13
    L16:
        return r6;
    L10:
        r6.put("intelligentRoutingResult", 0);     // Catch: JSONException -> L13
    L19:
        return null;
    }

    private float predictIntelligentTCPQUIC(String r3) {
        if (this.mSmartRouting != null) goto L9;
        return -1.0f;
    L9:
        JSONObject r0 = new JSONObject(r3);     // Catch: Exception -> L8
        return this.mSmartRouting.a(r0);
    L8:
        return -1.0f;
    }

    private void checkAndInit(String r2) {
        if (this.hasInit == false) goto L5;
        return;
    L5:
        this.hasInit = true;
        com.ss.bduploader.b.b r0 = new com.ss.bduploader.b.b();
        this.mSmartRouting = r0;
        r0.a();
        this.mSmartRouting.a(r2);
        this.mSmartRouting.b();
    }

    private void preloadModel() {
        com.ss.bduploader.b.b r0 = this.mSmartRouting;
        if (r0 == null) goto L6;
        r0.c();
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

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDNetworkRouter_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
