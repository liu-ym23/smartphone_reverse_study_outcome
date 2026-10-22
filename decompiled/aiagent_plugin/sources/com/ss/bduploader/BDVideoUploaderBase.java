package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.obric.capabilitykit.entity.ResultCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BDVideoUploaderBase extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int ExternalReaderModeSequence = 1;
    public static final int ExternalReaderModeSkipHeader = 0;
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
    public static final int KeyIsExternalReaderMode = 412;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetUUID = 1;
    public static final int KeyIsGetUploadErrorMessage = 415;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMaxUploadSpeedThresh = 413;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsPrivateVideo = 414;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessActionType = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
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
    public static final int MAX_HEADER_SIZE = 20;
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackSingleEventLog = 107;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsDiskResumeInfoError = 120;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsReadSliceUserCancel = 121;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsAllVideosComplete = 10;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsFlushComplete = 50;
    public static final int MsgIsSingleVideoComplete = 8;
    public static final int MsgIsSingleVideoFail = 9;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int VideoUploadFunctionTypeEncryption = 1;
    public static final int VideoUploadFunctionTypeNoProcess = 0;
    public static final int keyIsConfigString = 56;
    public static final int keyIsMediaData = 0;
    int headerIndex;
    protected v mAbstractListener;
    private boolean mEnableVideoPatch;
    private long mEndTime;
    private boolean mFinish;
    protected long mHandle;
    private Handler mHandler;
    private String[] mHeaders;
    private Lock mHeadersLock;
    private JSONObject mJsonInfo;
    protected w mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mStartTime;
    private int mState;
    protected final ReentrantReadWriteLock.WriteLock mWriteLock;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f37465b;

        public int a() {
            return this.f37464a;
        }

        public String b() {
            return this.f37465b;
        }

        public a(int r1, String r2) {
            this.f37464a = r1;
            this.f37465b = r2;
        }
    }

    public static native void _cancelUpload(long r0);

    private static native void _close(long r0);

    private final native long _create();

    private static native long _getLongValue(long r0, int r2);

    private static native String _getStrByKeyAndIndex(long r0, int r2, int r3);

    private static native String _getStringValue(long r0, int r2);

    public static native void _mergeUpload(long r0);

    public static native void _setContext(long r0, String r2);

    private static native void _setFilePaths(long r0, int r2, String[] r3);

    public static native void _setInt64Value(long r0, int r2, long r3);

    public static native void _setIntValue(long r0, int r2, int r3);

    public static native void _setObject(long r0, int r2, Object r3);

    private static native void _setPoster(long r0, float r2);

    private static native void _setSpecifiedContentType(long r0, int r2, String[] r3);

    public static native void _setStringValue(long r0, int r2, String r3);

    private static native void _start(long r0);

    private static native void _stop(long r0);

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public BDVideoUploaderBase() {
        this.mState = -1;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mHeadersLock = new ReentrantLock();
        this.mFinish = false;
        this.mEnableVideoPatch = false;
        this.mHandle = _create();     // Catch: Throwable -> L5
    L7:
        long r4 = this.mHandle;
        if (r4 == 0) goto L19;
        _setIntValue(r4, BDAbstractUpload.KeyIsEnableNativeLog, t.h.booleanValue() ? 1 : 0);
        if (Looper.myLooper() == null) goto L12;
        this.mHandler = new Handler(this);
    L13:
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        this.mHeaders = new String[20];
        int r3 = 0;
    L14:
        if (r3 >= 20) goto L16;
        this.mHeaders[r3] = null;
        r3 = r3 + 1;
        goto L14
    L16:
        this.headerIndex = 0;
        setTraceId(UUID.randomUUID().toString());
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsXQuicLibAvailable, t.a() ? 1 : 0);
        setBatchVideoId();
        return;
    L12:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L13
    L19:
        throw new Exception("create native uploader fail:" + mErrorMsg);
    L5:
        th = move-exception;
        this.mHandle = 0;
        INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", th.toString());
        goto L7
    }

    public void setAbstractListener(v r1) {
        this.mAbstractListener = r1;
    }

    public static boolean isError() {
        return IsErrored;
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }

    public void setListener(w r3) {
        this.mListener = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
    }

    public void onNotify(int r18, long r19, int r21, String r22) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "onNotify, what:" + r18 + ", parameter:" + r19 + ", code:" + r21);
        if (r18 == 0) goto L40;
        if (r18 == 1) goto L36;
        if (r18 == 2) goto L29;
        if (r18 != 3) goto L12;
        parseLog();
        u r2 = new u(null, null, r19, null, _getStringValue(this.mHandle, 14), null, null);
    L46:
        Message r0 = this.mHandler.obtainMessage();
        r0.what = r18;
        r0.obj = r2;
        r0.sendToTarget();
        return;
    L12:
        if (r18 == 50) goto L40;
        if (r18 == 120) goto L36;
        if (r18 == 121) goto L22;
        switch(r18) {
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L18;
        };
    L18:
        r2 = null;
        goto L46
    L19:
        parseLog();
        r2 = new u(null, null, r19, null, null, null, null);
        this.mState = 3;
        goto L46
    L20:
        r2 = new u(null, null, r19, r21, r22, null, null, null, null);
        goto L46
    L21:
        int r3 = (int) r19;
        r2 = new u(_getStrByKeyAndIndex(this.mHandle, 10, r3), _getStrByKeyAndIndex(this.mHandle, 12, r3), r19, r21, null, _getStrByKeyAndIndex(this.mHandle, 300, r3), _getStrByKeyAndIndex(this.mHandle, 68, r3), _getStrByKeyAndIndex(this.mHandle, 407, r3), _getStrByKeyAndIndex(this.mHandle, 1002, r3));
        goto L46
    L22:
        String r7 = getDNSIP();
        if (r7 != null) goto L25;
    L27:
        r2 = new u(null, null, r19, _getStringValue(this.mHandle, 415), _getStringValue(this.mHandle, 14), null, null);
        parseLog();
        this.mState = 2;
        goto L46
    L25:
        if (r7.isEmpty() == true) goto L27;
        setStringValue(75, r7);
        goto L27
    L29:
        String r8 = getDNSIP();
        if (r8 != null) goto L32;
    L34:
        r2 = new u(null, null, r19, _getStringValue(this.mHandle, 415), _getStringValue(this.mHandle, 14), null, null);
        parseLog();
        this.mState = 2;
        goto L46
    L32:
        if (r8.isEmpty() == true) goto L34;
        setStringValue(75, r8);
    L36:
        INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "what:" + r18 + ", parameter:" + r19 + ", code:" + r21);
        if (this.mEnableVideoPatch == false) goto L39;
        r2 = new u(null, null, r19, r21, null, null, null, null, null);
        goto L46
    L39:
        r2 = new u(null, null, r19, null, null, null, null);
    L40:
        this.mEndTime = System.currentTimeMillis();
        u r13 = new u(_getStringValue(this.mHandle, 10), _getStringValue(this.mHandle, 12), r19, null, _getStringValue(this.mHandle, 300), _getStringValue(this.mHandle, 68), _getStringValue(this.mHandle, 407), _getStringValue(this.mHandle, 1002));
        String r4 = getDNSIP();
        if (r4 != null) goto L43;
    L45:
        parseLog();
        this.mState = 3;
        r2 = r13;
        goto L46
    L43:
        if (r4.isEmpty() == true) goto L45;
        setStringValue(75, r4);
        goto L45
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

    public void onLogInfoSync(int r5, int r6, String r7) {
        if (r5 != 102) goto L15;
        if (TextUtils.isEmpty(r7) == true) goto L15;
        this.mHeadersLock.lock();     // Catch: Throwable -> L11
        if (this.headerIndex < 20) goto L9;
        this.headerIndex = 0;     // Catch: Throwable -> L11
    L9:
        String[] r8 = this.mHeaders;     // Catch: Throwable -> L11
        int r9 = this.headerIndex;     // Catch: Throwable -> L11
        r8[r9] = r7;     // Catch: Throwable -> L11
        this.headerIndex = r9 + 1;     // Catch: Throwable -> L11
        this.mHeadersLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mHeadersLock.unlock();
        throw th;
    L15:
        if (r5 != 104) goto L30;
        if (this.mAbstractListener == null) goto L54;
        new HashMap(20);
        JSONObject r10 = new JSONObject(r7);     // Catch: JSONException -> L27
        JSONObject r11 = this.mJsonInfo;     // Catch: JSONException -> L27
        if (r11 == null) goto L25;
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L27
    L23:
        if (r12.hasNext() == false) goto L25;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L27
        r10.put(r13, this.mJsonInfo.get(r13));     // Catch: JSONException -> L27
    L25:
        t.a(r10);     // Catch: JSONException -> L27
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L54:
        return;
    L30:
        if (r5 != 103) goto L35;
        long r0 = new Date().getTime() / 1000;
        w r2 = this.mListener;
        if (r2 == null) goto L35;
        r2.a(r6, r0);
    L35:
        if (r5 == 107) goto L50;
    L42:
        w r4 = this.mListener;
        if (r4 == null) goto L56;
        r4.a(r5, r6, r7);
        return;
    L56:
        return;
    L50:
        JSONObject r1 = new JSONObject(r7);     // Catch: Exception -> L38
    L39:
        x.f37566a.a(r1);
        v r3 = this.mAbstractListener;
        if (r3 == null) goto L42;
        r3.a();
    L38:
        r1 = null;
        goto L39
    }

    public int checkNet(int r3, int r4) {
        INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ttmn", "checketNet");
        w r2 = this.mListener;
        if (r2 != null) goto L7;
        return 1;
    L7:
        return r2.a(r3, r4);
    }

    public String getDNSIP() {
        return t.b();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        int r0 = r5.what;
        if (ZeusTransformUtils.instanceOf(r5.obj, a.class) == false) goto L7;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5.obj, a.class, "com.obric.aiagent.plugin");
        onLogInfoSync(r0, r6.a(), r6.b());
        return true;
    L7:
        if (this.mListener != null) goto L9;
        return true;
    L9:
        u r7 = (u) ZeusTransformUtils.preCheckCast(r5.obj, u.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L12;
        long r1 = r7.f37565e;
    L13:
        this.mListener.a(r0, r1, r7);
        return true;
    L12:
        r1 = 0;
        goto L13
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

    public void setExternFileReader(k r5, int r6) {
        k r7 = (k) ZeusTransformUtils.wrapperContextForParams(r5, k.class, "com.obric.aiagent.plugin");
        if (this.mHandle == 0) goto L9;
        if (r7 == null) goto L10;
        if (r6 <= 0) goto L11;
        setEnableBatch();
        _setIntValue(this.mHandle, 71, r6);
        _setIntValue(this.mHandle, 81, 1);
        _setObject(this.mHandle, 200, r7);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPathName(String r2) {
        setStringValue(0, r2);
    }

    public void setFilePath(int r5, String[] r6) {
        if (this.mHandle == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        setEnableBatch();
        _setFilePaths(this.mHandle, r5, r6);
        _setIntValue(this.mHandle, 81, 0);
        return;
    L11:
        return;
    L10:
        return;
    }

    private void setEnableBatch() {
        this.mEnableVideoPatch = true;
        _setIntValue(this.mHandle, ResultCode.ERROR_MULTI_DETAIL, 1);
    }

    public void setObjectType(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.equals("") == true) goto L12;
        setStringValue(54, r5);
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

    public void setServerParameter(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 16, r5);
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

    public void setEnableBigFile(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 83, r5);
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

    public void setEnableKeepAlive(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 20, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
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

    public void setEnableFiletryHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 25, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setAliveMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 22, r5);
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

    public void setPoster(float r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r5 < 0.0f) goto L10;
        _setPoster(r0, r5);
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

    public void setSliceReTryCount(int r5) {
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

    public void setMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 13, r5);
        return;
    L9:
        return;
    }

    public void setMediaDataReader(j r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r6 == null) goto L9;
        _setIntValue(r0, 81, 2);
        _setObject(this.mHandle, 201, r6);
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

    public void setScenesTag(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 85, r5);
        return;
    L9:
        return;
    }

    public void start() {
        this.mWriteLock.lock();
        if (t.f37559d != null) goto L5;
    L15:
    L12:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L8:
        if (this.mHandle == 0) goto L10;
        this.mFinish = false;     // Catch: Throwable -> L12
        this.mState = 1;     // Catch: Throwable -> L12
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L12
        _start(this.mHandle);     // Catch: Throwable -> L12
    L10:
        this.mWriteLock.unlock();
        return;
    L5:
        if (t.f37559d.length() <= 0) goto L15;
        setContextDir(t.f37559d);
        setDiskResumeDir(t.f37559d);
        setRetryStatesDir(t.f37559d);
        goto L15
    }

    public void stop() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;     // Catch: Throwable -> L13
        if (r0 == 0) goto L11;
        _stop(r0);     // Catch: Throwable -> L13
        String r1 = getDNSIP();     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
    L10:
        parseLog();     // Catch: Throwable -> L13
        this.mState = 4;     // Catch: Throwable -> L13
        goto L11
    L8:
        if (r1.isEmpty() == true) goto L10;
        setStringValue(75, r1);     // Catch: Throwable -> L13
    L11:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void close() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        _stop(r0);     // Catch: Throwable -> L8
        parseLog();     // Catch: Throwable -> L8
        _close(this.mHandle);     // Catch: Throwable -> L8
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

    private void parseLog() {
        if (this.mFinish == false) goto L5;
        return;
    L5:
        this.mFinish = true;
        addLogToManager(_getStringValue(this.mHandle, 100));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject addLogToManager(String r11) {
        String r3 = UUID.randomUUID().toString();
        int r4 = 0;
        JSONArray r5 = null;
        JSONObject r6 = new JSONObject(r11);     // Catch: Exception -> L23
        r6.put("dns_version", BDUploadResolver.f37460b);     // Catch: Exception -> L23
        r6.put("main_dns_type", com.ss.bduploader.net.c.f37521a);     // Catch: Exception -> L23
        r6.put("main_back_type", com.ss.bduploader.net.c.f37522b);     // Catch: Exception -> L23
        r6.put("back_delayed_time", com.ss.bduploader.net.c.f37523c);     // Catch: Exception -> L23
        r6.put("expired_time", com.ss.bduploader.net.c.f37524d);     // Catch: Exception -> L23
        JSONObject r12 = this.mJsonInfo;     // Catch: Exception -> L23
        if (r12 == null) goto L9;
        Iterator<String> r13 = r12.keys();     // Catch: Exception -> L23
    L7:
        if (r13.hasNext() == false) goto L9;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        r6.put(r7, this.mJsonInfo.get(r7));     // Catch: Exception -> L23
    L9:
        String r14 = "";
        this.mHeadersLock.lock();     // Catch: Throwable -> L20
        int r8 = 0;
    L12:
        if (r8 >= 20) goto L17;
        if (TextUtils.isEmpty(this.mHeaders[r8]) == true) goto L16;
        r14 = r14 + "#" + this.mHeaders[r8];     // Catch: Throwable -> L20
    L16:
        r8 = r8 + 1;
        goto L12
    L17:
        this.mHeadersLock.unlock();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r14) == true) goto L24;
        r6.put("cdn_headers", r14);     // Catch: Exception -> L23
    L24:
        if (r6 != null) goto L48;
    L43:
        x.f37566a.a(r6);
        return r6;
    L48:
        Object r10 = r6.get("video_array");     // Catch: Exception -> L41
        if (ZeusTransformUtils.instanceOf(r10, JSONArray.class) == false) goto L28;
        r5 = (JSONArray) ZeusTransformUtils.preCheckCast(r10, JSONArray.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L41
        r6.remove("video_array");     // Catch: Exception -> L41
    L28:
        int r15 = r6.getInt("file_num");     // Catch: Exception -> L41
    L29:
        if (r4 >= r15) goto L40;
        JSONObject r16 = new JSONObject(r6.toString());     // Catch: Exception -> L41
        r16.remove("event");     // Catch: Exception -> L41
        r16.put("event", "bd_video_upload");     // Catch: Exception -> L41
        if (r5 != null) goto L33;
    L38:
        r16.put("uuid", r3);     // Catch: Exception -> L41
        x.f37566a.a(r16);     // Catch: Exception -> L41
        r4 = r4 + 1;
        goto L29
    L33:
        if (r5.length() <= r4) goto L38;
        JSONObject r1 = r5.getJSONObject(r4);     // Catch: Exception -> L41
        Iterator<String> r9 = r1.keys();     // Catch: Exception -> L41
    L36:
        if (r9.hasNext() == false) goto L38;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L41
        r16.put(r17, r1.get(r17));     // Catch: Exception -> L41
        goto L36
    L40:
        return r6;
    L41:
        e = move-exception;
        INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ttmn", "get video_array failed" + e);
    L20:
        th = move-exception;
        this.mHeadersLock.unlock();     // Catch: Exception -> L23
        throw th;     // Catch: Exception -> L23
    L23:
        r6 = null;
        goto L24
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

    public void allowMergeUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _mergeUpload(r0);
    }

    public void setPreUploadEncryptionMode(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 74, r5);
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String getStringFromExtern(int r1) {
        if (r1 != 0) goto L4;
        w r0 = this.mListener;
        if (r0 != null) goto L13;
    L10:
        return null;
    L13:
        return r0.a(r1);
    L4:
        if (r1 != 1) goto L10;
        return UUID.randomUUID().toString();
    }

    public void setResponseTimeOut(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 76, r5);
        return;
    L9:
        return;
    }

    public void setMaxUploadSpeedThresh(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, KeyIsMaxUploadSpeedThresh, r5);
    }

    private void setDiskResumeDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        String r6 = r5 + File.separator + t.f37557b;
        t.a(r6);
        _setStringValue(this.mHandle, 303, r6);
        return;
    L9:
        return;
    }

    private void setRetryStatesDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        String r6 = r5 + File.separator + t.f37558c;
        t.a(r6);
        _setStringValue(this.mHandle, BDAbstractUpload.KeyIsRetryStatesDir, r6);
        return;
    L9:
        return;
    }

    public void setDiskResumeUniqueKey(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 301, r5);
        return;
    L12:
        return;
    }

    public void setDiskResumeOption(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 302, r5);
    }

    private void setBatchVideoId() {
        String r0 = UUID.randomUUID().toString();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L9;
        _setStringValue(this.mHandle, BDAbstractUpload.KeyIsBatchSessionKey, r0);
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

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDVideoUploaderBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
