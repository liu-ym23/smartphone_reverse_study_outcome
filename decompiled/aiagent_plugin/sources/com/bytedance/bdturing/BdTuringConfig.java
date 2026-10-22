package com.bytedance.bdturing;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BdTuringConfig {
    public static final int DEFAULT_EVENT_COUNT = 6000;
    private static final int MAX_LOCAL_PARAMS = 2;
    private static final int OS_TYPE = 0;
    private static final String TAG = "BdTuringConfig";
    private f bdTuringDepend;
    private d eventClient;
    private com.bytedance.bdturing.ttnet.b httpClient;
    private String mAppId;
    private com.bytedance.bdturing.a mAppInfoProvider;
    private String mAppKey;
    private String mAppName;
    private String mAppVersion;
    private String mAppVersionCode;
    private boolean mBypassBdTuring;
    private int mChallengeCode;
    private String mChannel;
    private Context mContext;
    private final com.bytedance.bdturing.utils.b mContextHolder;
    private JSONObject mDOWNSMSTheme;
    private String mDeviceBrand;
    private String mDeviceId;
    private String mDeviceModel;
    private JSONObject mECAFTheme;
    private JSONObject mEMAILTheme;
    private int mEmailDigits;
    private boolean mEnableTTNetProcessor;
    private boolean mFullScreen;
    private JSONObject mIDENTIFYTheme;
    private JSONObject mIMGTheme;
    private JSONObject mINFOVERIFYTheme;
    private com.bytedance.bdturing.identityverify.a mIdentityVerifyDepend;
    private boolean mInjectHeader;
    private String mInstallId;
    private String mLanguage;
    private String mLocale;
    private boolean mMaskCancel;
    private String mOpenUdid;
    private String mOsName;
    private String mOsVersion;
    private JSONObject mPASSWORDTheme;
    private JSONObject mQATheme;
    private b mRegionType;
    private String mRiskInfo;
    private JSONObject mSMARTERTheme;
    private JSONObject mSMSTheme;
    private JSONObject mSMSVOICETheme;
    private String mScene;
    private String mSdkVersion;
    private com.bytedance.bdturing.setting.f mServiceInterceptor;
    private String mSessionId;
    private boolean mShowToastSuccess;
    private int mSmsDigits;
    private com.bytedance.bdturing.c.c mThemeConfig;
    private ConcurrentHashMap<Integer, JSONObject> mThemeMap;
    private JSONObject mUPSMSTheme;
    private JSONObject mVOICETheme;
    private HashMap<Integer, Pair<String, String>> testConfig;
    private String ticket;
    private com.bytedance.bdturing.twiceverify.b twiceVerifyDepend;

    /* JADX INFO: renamed from: com.bytedance.bdturing.BdTuringConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {
        private com.bytedance.bdturing.utils.b A;
        private com.bytedance.bdturing.a B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f6457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f6458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f6459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f6460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f6461e;
        private String f;
        private String g;
        private String h;
        private Context i;
        private String j;
        private String k;
        private String l;
        private boolean m;
        private boolean n;
        private d o;
        private com.bytedance.bdturing.ttnet.b p;
        private com.bytedance.bdturing.twiceverify.b q;
        private String r;
        private String s;
        private f t;
        private int u;
        private int v;
        private com.bytedance.bdturing.setting.f w;
        private boolean x;
        private boolean y;
        private com.bytedance.bdturing.identityverify.a z;

        static /* synthetic */ com.bytedance.bdturing.a A(a r0) {
            return r0.B;
        }

        static /* synthetic */ com.bytedance.bdturing.identityverify.a B(a r0) {
            return r0.z;
        }

        static /* synthetic */ b a(a r0) {
            return r0.f6457a;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f6458b;
        }

        static /* synthetic */ String c(a r0) {
            return r0.f6459c;
        }

        static /* synthetic */ String d(a r0) {
            return r0.f6460d;
        }

        static /* synthetic */ String e(a r0) {
            return r0.f6461e;
        }

        static /* synthetic */ String f(a r0) {
            return r0.f;
        }

        static /* synthetic */ String g(a r0) {
            return r0.g;
        }

        static /* synthetic */ String h(a r0) {
            return r0.h;
        }

        static /* synthetic */ String i(a r0) {
            return r0.r;
        }

        static /* synthetic */ d j(a r0) {
            return r0.o;
        }

        static /* synthetic */ com.bytedance.bdturing.ttnet.b k(a r0) {
            return r0.p;
        }

        static /* synthetic */ com.bytedance.bdturing.twiceverify.b l(a r0) {
            return r0.q;
        }

        static /* synthetic */ int m(a r0) {
            return r0.v;
        }

        static /* synthetic */ int n(a r0) {
            return r0.u;
        }

        static /* synthetic */ f o(a r0) {
            return r0.t;
        }

        static /* synthetic */ String p(a r0) {
            return r0.j;
        }

        static /* synthetic */ String q(a r0) {
            return r0.k;
        }

        static /* synthetic */ String r(a r0) {
            return r0.l;
        }

        static /* synthetic */ String s(a r0) {
            return r0.s;
        }

        static /* synthetic */ Context t(a r0) {
            return r0.i;
        }

        static /* synthetic */ boolean u(a r0) {
            return r0.m;
        }

        static /* synthetic */ boolean v(a r0) {
            return r0.n;
        }

        static /* synthetic */ com.bytedance.bdturing.setting.f w(a r0) {
            return r0.w;
        }

        static /* synthetic */ boolean x(a r0) {
            return r0.x;
        }

        static /* synthetic */ boolean y(a r0) {
            return r0.y;
        }

        static /* synthetic */ com.bytedance.bdturing.utils.b z(a r0) {
            return r0.A;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6462a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f6463b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f6464c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f6465d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f6466e = null;
        private static final /* synthetic */ b[] g = null;
        private String f;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("REGION_CN", 0, "cn");
            f6462a = r0;
            b r1 = new b("REGION_SINGAPOER", 1, "sg");
            f6463b = r1;
            b r3 = new b("REGION_USA_EAST", 2, "va");
            f6464c = r3;
            b r5 = new b("REGION_INDIA", 3, "in");
            f6465d = r5;
            b r7 = new b("REGION_BOE", 4, TTNetInit.DOMAIN_BOE_KEY);
            f6466e = r7;
            g = new b[]{r0, r1, r3, r5, r7};
        }

        private b(String r1, int r2, String r3) {
            super(r1, r2);
            this.f = r3;
        }

        public String a() {
            return this.f;
        }
    }

    @Deprecated
    public int getOsType() {
        return 0;
    }

    /* synthetic */ BdTuringConfig(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public int getSmsDigits() {
        return this.mSmsDigits;
    }

    public BdTuringConfig setSmsDigits(int r1) {
        this.mSmsDigits = r1;
        return this;
    }

    public int getEmailDigits() {
        return this.mEmailDigits;
    }

    public BdTuringConfig setEmailDigits(int r1) {
        this.mEmailDigits = r1;
        return this;
    }

    private BdTuringConfig(a r8) {
        this.mSdkVersion = "3.2.0.cn";
        this.mAppVersionCode = "";
        this.mOsName = "android";
        this.mOsVersion = "" + Build.VERSION.SDK_INT;
        this.mDeviceBrand = Build.BRAND;
        this.mDeviceModel = Build.MODEL;
        this.testConfig = new HashMap();
        this.mQATheme = null;
        this.mSMSTheme = null;
        this.mIMGTheme = null;
        this.mIDENTIFYTheme = null;
        this.mSMARTERTheme = null;
        this.mUPSMSTheme = null;
        this.mDOWNSMSTheme = null;
        this.mPASSWORDTheme = null;
        this.mECAFTheme = null;
        this.mINFOVERIFYTheme = null;
        this.mEMAILTheme = null;
        this.mVOICETheme = null;
        this.mSMSVOICETheme = null;
        this.mThemeMap = new ConcurrentHashMap();
        this.ticket = null;
        this.mRiskInfo = null;
        this.mFullScreen = true;
        this.mScene = null;
        this.mShowToastSuccess = false;
        this.bdTuringDepend = null;
        this.mRegionType = a.a(r8);
        this.mAppId = a.b(r8);
        this.mLanguage = a.c(r8);
        this.mAppName = a.d(r8);
        this.mChannel = a.e(r8);
        this.mAppKey = a.f(r8);
        this.mAppVersion = a.g(r8);
        this.mAppVersionCode = a.h(r8);
        Locale r1 = Locale.getDefault();
        if (TextUtils.isEmpty(a.i(r8)) == false) goto L5;
        String r2 = r1.toString();
    L6:
        this.mLocale = r2;
        this.eventClient = a.j(r8);
        this.httpClient = a.k(r8);
        this.twiceVerifyDepend = a.l(r8);
        this.mSmsDigits = a.m(r8);
        this.mEmailDigits = a.n(r8);
        this.bdTuringDepend = a.o(r8);
        if (TextUtils.isEmpty(a.i(r8)) == false) goto L21;
        String r3 = this.mLocale;
        if (r3 == null) goto L21;
        String[] r4 = r3.split("_");
        if (r4 == null) goto L21;
        if (r4.length <= 2) goto L21;
        this.mLocale = r4[0] + "_" + r4[1];
    L21:
        this.mDeviceBrand = URLEncoder.encode(Build.BRAND, "utf-8");     // Catch: UnsupportedEncodingException -> L17
        this.mDeviceModel = URLEncoder.encode(Build.MODEL, "utf-8");     // Catch: UnsupportedEncodingException -> L17
    L19:
        this.mInstallId = a.p(r8);
        this.mDeviceId = a.q(r8);
        this.mSessionId = a.r(r8);
        this.mOpenUdid = a.s(r8);
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.t(r8), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mMaskCancel = a.u(r8);
        this.mInjectHeader = a.v(r8);
        this.mServiceInterceptor = a.w(r8);
        this.mEnableTTNetProcessor = a.x(r8);
        this.mBypassBdTuring = a.y(r8);
        this.mContextHolder = a.z(r8);
        this.mAppInfoProvider = a.A(r8);
        this.mIdentityVerifyDepend = a.B(r8);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L5:
        r2 = a.i(r8);
        goto L6
    }

    public b getRegionType() {
        return this.mRegionType;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getAppVersionCode() {
        if (TextUtils.isEmpty(this.mAppVersionCode) == false) goto L7;
        return "";
    L7:
        return this.mAppVersionCode;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    @Deprecated
    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getChannel() {
        return this.mChannel;
    }

    @Deprecated
    public String getDeviceBrand() {
        return this.mDeviceBrand;
    }

    @Deprecated
    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    @Deprecated
    public String getOsVersion() {
        return this.mOsVersion;
    }

    @Deprecated
    public String getOsName() {
        return this.mOsName;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public Activity getTopActivity() {
        f r0 = this.bdTuringDepend;
        if (r0 != null) goto L5;
        com.bytedance.bdturing.utils.b r1 = this.mContextHolder;
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1.f6632a != null) goto L11;
        return null;
    L11:
        return (Activity) ZeusTransformUtils.preCheckCast(this.mContextHolder.f6632a.get(), Activity.class, "com.obric.aiagent.plugin");
    L5:
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    }

    public Pair<String, String> getTestConfig(int r2) {
        return (Pair) ZeusTransformUtils.preCheckCast(this.testConfig.get(Integer.valueOf(r2)), Pair.class, "com.obric.aiagent.plugin");
    }

    public String getInstallId() {
        String r0 = this.mInstallId;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.b();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    public String getDeviceId() {
        String r0 = this.mDeviceId;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.a();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    public String getSessionId() {
        String r0 = this.mSessionId;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.d();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    public String getOpenUdid() {
        String r0 = this.mOpenUdid;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.c();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    public String getLocale() {
        String r2 = this.mLocale;
    L10:
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L8:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = Locale.getDefault().toString();     // Catch: Throwable -> L8 Exception -> L10
    L6:
        if (r2 != null) goto L13;
        return "";
    }

    public boolean getInjectHeader() {
        return this.mInjectHeader;
    }

    @Deprecated
    public boolean getMaskCancel() {
        return this.mMaskCancel;
    }

    public JSONObject getTheme(int r2) {
        return (JSONObject) ZeusTransformUtils.preCheckCast(this.mThemeMap.get(Integer.valueOf(r2)), JSONObject.class, "com.obric.aiagent.plugin");
    }

    public d getEventClient() {
        return this.eventClient;
    }

    public void setHttpClient(com.bytedance.bdturing.ttnet.b r3) {
        this.httpClient = (com.bytedance.bdturing.ttnet.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdturing.ttnet.b.class, "com.obric.aiagent.plugin");
    }

    public com.bytedance.bdturing.ttnet.b getHttpClient() {
        return this.httpClient;
    }

    @Deprecated
    public int getChallengeCode() {
        return this.mChallengeCode;
    }

    @Deprecated
    public String getScene() {
        return this.mScene;
    }

    @Deprecated
    public boolean getShowToastSuccess() {
        return this.mShowToastSuccess;
    }

    @Deprecated
    public String getRiskInfo() {
        return this.mRiskInfo;
    }

    @Deprecated
    public boolean getFullScreen() {
        return this.mFullScreen;
    }

    @Deprecated
    public String getTicket() {
        return this.ticket;
    }

    public com.bytedance.bdturing.twiceverify.b getTwiceVerifyDepend() {
        return this.twiceVerifyDepend;
    }

    public BdTuringConfig setInstallId(String r1) {
        this.mInstallId = r1;
        return this;
    }

    public BdTuringConfig setTestConfig(int r3, String r4, String r5) {
        this.testConfig.put(Integer.valueOf(r3), new Pair(r4, r5));
        return this;
    }

    public BdTuringConfig removeTestConfig(int r2) {
        this.testConfig.remove(Integer.valueOf(r2));
        return this;
    }

    public BdTuringConfig setDeviceId(String r1) {
        this.mDeviceId = r1;
        return this;
    }

    public BdTuringConfig setSessionId(String r1) {
        this.mSessionId = r1;
        return this;
    }

    public BdTuringConfig setOpenUdid(String r1) {
        this.mOpenUdid = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setMaskCancel(boolean r1) {
        this.mMaskCancel = r1;
        return this;
    }

    public BdTuringConfig setAppId(String r1) {
        this.mAppId = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setChallengeCode(int r1) {
        this.mChallengeCode = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setScene(String r1) {
        this.mScene = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setShowToastSuccess(boolean r1) {
        this.mShowToastSuccess = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setTicket(String r1) {
        this.ticket = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setFullScreen(boolean r1) {
        this.mFullScreen = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setRiskInfo(String r1) {
        this.mRiskInfo = r1;
        return this;
    }

    public BdTuringConfig setTheme(JSONObject r2, int r3) {
        if (r2 != null) goto L9;
        return this;
    L9:
        this.mThemeMap.put(Integer.valueOf(r3), r2);     // Catch: Exception -> L6
    L8:
        return this;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public BdTuringConfig setLanguage(String r1) {
        this.mLanguage = r1;
        return this;
    }

    public BdTuringConfig setLocale(String r1) {
        this.mLocale = r1;
        return this;
    }

    public BdTuringConfig setRegionType(b r1) {
        this.mRegionType = r1;
        return this;
    }

    public BdTuringConfig setIBdturingDepend(f r3) {
        this.bdTuringDepend = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        return this;
    }

    public BdTuringConfig setServiceInterceptor(com.bytedance.bdturing.setting.f r3) {
        this.mServiceInterceptor = (com.bytedance.bdturing.setting.f) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdturing.setting.f.class, "com.obric.aiagent.plugin");
        return this;
    }

    public com.bytedance.bdturing.setting.f getServiceInterceptor() {
        return this.mServiceInterceptor;
    }

    public boolean isTTNetProcessorEnable() {
        return this.mEnableTTNetProcessor;
    }

    public void enableTTNetProcessor(boolean r1) {
        this.mEnableTTNetProcessor = r1;
    }

    public boolean isBypassBdTuring() {
        return this.mBypassBdTuring;
    }

    public BdTuringConfig setBypassBdTuring(boolean r1) {
        this.mBypassBdTuring = r1;
        return this;
    }

    public BdTuringConfig setAppInfoProvider(com.bytedance.bdturing.a r1) {
        this.mAppInfoProvider = r1;
        return this;
    }

    public com.bytedance.bdturing.c.c getThemeConfig() {
        return this.mThemeConfig;
    }

    public void setThemeConfig(com.bytedance.bdturing.c.c r1) {
        this.mThemeConfig = r1;
    }

    public com.bytedance.bdturing.a getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    public com.bytedance.bdturing.utils.b getContextHolder() {
        return this.mContextHolder;
    }

    public com.bytedance.bdturing.identityverify.a getIdentityVerifyDepend() {
        if (this.mIdentityVerifyDepend != null) goto L9;
        this.mIdentityVerifyDepend = (com.bytedance.bdturing.identityverify.a) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.bdturing.identity_verify_adapter.DefaultIdentityVerifyDepend", "com.obric.aiagent.plugin").newInstance(), com.bytedance.bdturing.identityverify.a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return this.mIdentityVerifyDepend;
    }

    public void setIdentityVerifyDepend(com.bytedance.bdturing.identityverify.a r3) {
        this.mIdentityVerifyDepend = (com.bytedance.bdturing.identityverify.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdturing.identityverify.a.class, "com.obric.aiagent.plugin");
    }
}
