package m6;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ICronetDepend, ICronetAppProvider {

    /* JADX INFO: renamed from: m6.a$a, reason: collision with other inner class name */
    public class C0314a extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f22115e;

        public C0314a(a r10, String r11) {
            this.f22115e = r10;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            TTNetInit.notifyColdStartFinish();
        }
    }

    public class b extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22117f;

        public b(a r10, String r11, String r12) {
            this.f22117f = r10;
            this.f22116e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            TTNetInit.onClientIPChanged(this.f22116e);
        }
    }

    public class c extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List f22118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List f22119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f22120g;

        public c(a r10, String r11, List r12, List r13) {
            this.f22120g = r10;
            this.f22118e = r12;
            this.f22119f = r13;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            TTNetInit.onPublicIPsChanged(this.f22118e, this.f22119f);
        }
    }

    public class d extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f22122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f22123g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f22124h;

        public d(a r10, String r11, String r12, String r13, String r14) {
            this.f22124h = r10;
            this.f22121e = r12;
            this.f22122f = r13;
            this.f22123g = r14;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            m6.b.a().c(this.f22121e, this.f22122f, this.f22123g);
            StoreRegionManager.m().r(this.f22121e, this.f22122f, this.f22123g);
        }
    }

    public class e extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f22125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f22126f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f22127g;

        public e(a r10, String r11, ArrayList r12, String r13) {
            this.f22127g = r10;
            this.f22125e = r12;
            this.f22126f = r13;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.b.a().b(this.f22125e, this.f22126f);
        }
    }

    public class f extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f22128e;

        public f(a r10, String r11) {
            this.f22128e = r10;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(TTNetInit.getTTNetDepend().getContext()).n();
            HttpClient.d(true);
        }
    }

    public class g extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22129e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22130f;

        public g(a r10, String r11, String r12) {
            this.f22130f = r10;
            this.f22129e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(TTNetInit.getTTNetDepend().getContext()).q(this.f22129e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class h extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22131e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22132f;

        public h(a r10, String r11, String r12) {
            this.f22132f = r10;
            this.f22131e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(TTNetInit.getTTNetDepend().getContext()).p(this.f22131e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class i extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22133e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22134f;

        public i(a r10, String r11, String r12) {
            this.f22134f = r10;
            this.f22133e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(TTNetInit.getTTNetDepend().getContext()).i(this.f22133e);     // Catch: Throwable -> L4
            ClientKeyManager.j().c(this.f22133e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class j extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22135e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f22136f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f22137g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f22138h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f22139i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ List f22140j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f22141k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ a f22142l;

        public j(a r10, String r11, String r12, String r13, int r14, int r15, int r16, List r17, String r18) {
            this.f22142l = r10;
            this.f22135e = r12;
            this.f22136f = r13;
            this.f22137g = r14;
            this.f22138h = r15;
            this.f22139i = r16;
            this.f22140j = r17;
            this.f22141k = r18;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            q6.a.c().a(this.f22135e, this.f22136f, this.f22137g, this.f22138h, this.f22139i, this.f22140j, this.f22141k);
        }
    }

    public class k extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f22143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22144f;

        public k(a r10, String r11, String r12) {
            this.f22144f = r10;
            this.f22143e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            this.f22144f.d(this.f22143e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class l extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f22145e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f22146f;

        public l(a r10, String r11, int r12) {
            this.f22146f = r10;
            this.f22145e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            this.f22146f.a(this.f22145e);
        }
    }

    public class m extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f22147e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f22148f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f22149g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f22150h;

        public m(a r10, String r11, int r12, int r13, int r14) {
            this.f22150h = r10;
            this.f22147e = r12;
            this.f22148f = r13;
            this.f22149g = r14;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            this.f22150h.c(this.f22147e, this.f22148f, this.f22149g);
        }
    }

    public class n extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f22151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ double f22152f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ double f22153g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ double f22154h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ double f22155i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ a f22156j;

        public n(a r10, String r11, int r12, double r13, double r14, double r15, double r16) {
            this.f22156j = r10;
            this.f22151e = r12;
            this.f22152f = r13;
            this.f22153g = r14;
            this.f22154h = r15;
            this.f22155i = r16;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            this.f22156j.b(this.f22151e, this.f22152f, this.f22153g, this.f22154h, this.f22155i);
        }
    }

    public a() {
    }

    public void a(int r10) {
    }

    public void b(int r10, double r11, double r12, double r13, double r14) {
    }

    public void c(int r10, int r11, int r12) {
    }

    public void d(String r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void doLoadLibrary(String r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbClient() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFeature() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFlag() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        return Build.SUPPORTED_ABIS[0];
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getBypassBOEJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCityName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map getClientOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        return l6.a.f(TTNetInit.getTTNetDepend().getContext()).e();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        int r10 = UIUtils.a(TTNetInit.getTTNetDepend().getContext());
        if (r10 > 0) goto L5;
        return "";
    L5:
        return String.valueOf(r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDevicePlatform() {
        return "android";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceType() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getGetDomainDefaultJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map getGetDomainDependHostMap() {
        LinkedHashMap r10 = new LinkedHashMap();
        String[] r11 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r11 != null) goto L5;
    L13:
        Map<String, String> r12 = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r12.get("httpdns")) == true) goto L24;
        if (TextUtils.isEmpty(r12.get(TTNetInit.DOMAIN_NETLOG_KEY)) == true) goto L24;
        if (TextUtils.isEmpty(r12.get(TTNetInit.DOMAIN_BOE_KEY)) == true) goto L20;
    L21:
        r10.putAll(r12);
        return r10;
    L20:
        if (TextUtils.isEmpty(TTNetInit.DOMAIN_BOE_HTTPS_KEY) == false) goto L21;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (r11.length <= 0) goto L8;
        r10.put("first", r11[0]);
    L8:
        if (r11.length <= 1) goto L11;
        r10.put("second", r11[1]);
    L11:
        if (r11.length <= 2) goto L13;
        r10.put("third", r11[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return AdReportParam.ClickPosType.SKIP;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return NetworkUtils.d(TTNetInit.getTTNetDepend().getContext());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r10 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r10 != null) goto L5;
        return r10;
    L5:
        if (r10.length() <= 10) goto L13;
        return r10.substring(0, 10);
    L13:
        return r10;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return com.bytedance.frameworks.baselib.network.http.util.f.c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        String r10 = UIUtils.c(TTNetInit.getTTNetDepend().getContext());
        if (com.bytedance.common.utility.e.b(r10) == true) goto L5;
        return r10;
    L5:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkAppId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return "X-SS-Cookie";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return "a";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return AdReportParam.ClickPosType.SKIP;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map getTNCRequestHeader() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map getTNCRequestQuery() {
        TTNetInit.getTTNetDepend();
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUUID() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void handleApiResult(boolean r13, String r14, String r15, String r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, boolean r37, long r38, long r40, String r42, String r43, String r44, Exception r45) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "handleApiResult, succ: " + r13 + " url: " + r14 + "tracecode: " + r15 + " remoteIp: " + r16 + " appStart: " + r17);
    L6:
        BaseHttpRequestInfo r10 = BaseHttpRequestInfo.a();
        r10.f7162a = r16;
        r10.f7164c = r17;
        r10.f7165d = r17;
        r10.f7166e = r19;
        r10.f7167f = r21;
        r10.f7168g = r23;
        r10.f7169h = r25;
        r10.f7171j = r27;
        r10.f7172k = r29;
        r10.f7173l = r31;
        r10.f7174m = r33;
        r10.f7176o = r35;
        r10.f7177p = r37;
        r10.f7178q = r38;
        long r11 = r25 - r19;
        r10.f7179r = r11;
        r10.f7181t = r40;
        r10.f7186y = r42;
        r10.B = r43;
        r10.C = r44;
        r10.f7183v = 0;
        if (r13 == false) goto L9;
        NetworkParams.o(r14, r11, r10);
        NetworkParams.s(r11, r19, r14, r15, r10);
        return;
    L9:
        NetworkParams.n(r14, r45, r11, r10);
        NetworkParams.q(r11, r19, r14, r15, r10, r45);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isBOEProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableBrotli() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableHttp2() {
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableQuic() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r10, String r11) {
        Logger.d(r10, r11);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean needCustomLoadLibrary() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map onCallToAddSecurityFactor(String r10, Map r11) {
        HashMap r12 = new HashMap();
        Iterator r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Map.Entry r14 = (Map.Entry) r13.next();
        ArrayList r15 = new ArrayList();
        r15.add(r14.getValue());
        r12.put(r14.getKey(), r15);
        goto L4
    L7:
        return NetworkParams.G(r10, r12);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(String r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onClientIPChanged");
    L5:
        new b(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onColdStartFinish");
    L5:
        new C0314a(this, "NetWork-Event").a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onCronetBootSucceed... ");
    L5:
        new f(this, "NetWork-Event").a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onEffectiveConnectionTypeChanged state = " + r10);
    L5:
        new l(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onMultiNetworkStateChanged(int r10, int r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onMultiNetworkStateChanged prev state = " + r10 + ", curr state = " + r11);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityLevelChanged(int r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onNetworkQualityLevelChanged nql: " + r10);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onNetworkQualityLevelChanged, effectiveHrttMs: " + r10 + ", effectiveTrttMs: " + r11 + ", effectiveRxThroughputKbps: " + r12);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r15, double r16, double r18, double r20, double r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onPacketLossComputed protocol = " + r15 + ", upstreamLossRate = " + r16 + ", upstreamLossRateVariance = " + r18 + ", downstreamLossRate = " + r20 + ", downstreamLossRateVariance = " + r22);
    L6:
        new n(this, "NetWork-Event", r15, r16, r18, r20, r22).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPublicIPsChanged(List r10, List r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onPublicIPsChanged");
    L5:
        new c(this, "NetWork-Event", r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onRTTOrThroughputEstimatesComputed httpRtt = " + r10 + ", transportRttMs = " + r11 + ",downstreamThroughputKbps = " + r12);
    L5:
        new m(this, "NetWork-Event", r10, r11, r12).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigABTestChanged(String r10) {
        new h(this, "NetWork-Event", r10).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(String r10) {
        new g(this, "NetWork-Event", r10).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(String r10) {
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (Logger.debug() == false) goto L7;
        Logger.d("CronetDependAdapter", "config = " + r10);     // Catch: Throwable -> L5
    L7:
        new i(this, "NetWork-Event", r10).a();     // Catch: Throwable -> L5
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(String r10, String r11, String r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onStoreIdcChanged");
    L5:
        new d(this, "NetWork-Event", r10, r11, r12).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(ArrayList r10, String r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTNCUpdateFailed");
    L5:
        new e(this, "NetWork-Event", r10, r11).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(String r13, String r14, int r15, int r16, int r17, List r18, String r19) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onTTDnsResolveResult uuid = " + r13 + " host = " + r14);
    L6:
        new j(this, "NetWork-Event", r13, r14, r15, r16, r17, r18, r19).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(String r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTTNetDetectInfoChanged result = " + r10);
    L5:
        new k(this, "NetWork-Event", r10).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r10) {
    }
}
