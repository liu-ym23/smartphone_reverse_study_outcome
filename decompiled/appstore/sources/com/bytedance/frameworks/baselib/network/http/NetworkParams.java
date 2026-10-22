package com.bytedance.frameworks.baselib.network.http;

import android.os.Looper;
import android.webkit.CookieManager;
import com.bytedance.apm.block.BlockConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.e;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o4.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConnectionQualitySamplerHook f7188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CdnConnectionQualitySamplerHook f7189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static StreamProcessor f7190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f7191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static CommandListener f7192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ApiProcessHook f7193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static MonitorProcessHook f7194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static OldMonitorProcessHook f7195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile AtomicBoolean f7196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f7197j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static CountDownLatch f7198k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile int f7199l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ApiRequestInterceptor f7200m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static CookieShareInterceptor f7201n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static AppCookieStore f7202o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile addResponseHeadersCallback f7203p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static AddSecurityFactorProcessCallback f7204q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile boolean f7205r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f7206s;

    public interface AddSecurityFactorProcessCallback {
        Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, List<String>> r11);
    }

    public interface ApiProcessHook<T extends BaseHttpRequestInfo> {
        String addCommonParams(String r10, boolean r11);

        String addRequestVertifyParams(String r10, boolean r11, Object... r12);

        Map<String, String> getCommonParamsByLevel(int r10);

        @Deprecated
        void handleApiError(String r10, Throwable r11, long r12, T r13);

        @Deprecated
        void handleApiOk(String r10, long r11, T r12);

        void onTryInit();

        void putCommonParams(Map<String, String> r10, boolean r11);
    }

    public interface ApiRequestInterceptor<T extends a> {
        String filterUrl(String r10, T r11);

        boolean isOkHttp3Open();

        boolean isOkHttpOpen();

        void monitorApiHttp(String r10, String r11, boolean r12) throws IOException;

        @Deprecated
        List<InetAddress> resolveInetAddresses(String r10);

        @Deprecated
        String tryDnsMapping(String r10, String[] r11);
    }

    public interface AppCookieStore {
        Map<String, List<String>> get(URI r10, Map<String, List<String>> r11);

        void put(URI r10, Map<String, List<String>> r11);
    }

    public interface CdnConnectionQualitySamplerHook {
        boolean cdnShouldSampling(String r10);
    }

    public interface CommandListener {
        String getHeaderKey();

        void onCommandReceived(List<String> r10);
    }

    public interface ConnectionQualitySamplerHook {
        boolean shouldSampling(String r10);
    }

    public interface CookieShareInterceptor {
        List<String> getShareCookie(CookieManager r10, r4.a r11, URI r12);

        List<String> getShareCookieHostList(String r10);
    }

    public interface MonitorProcessHook<T extends BaseHttpRequestInfo> {
        void monitorApiError(long r10, long r11, String r12, String r13, T r14, Throwable r15);

        void monitorApiOk(long r10, long r11, String r12, String r13, T r14);
    }

    public interface OldMonitorProcessHook {
        boolean getOldmonitorSwitch();
    }

    public interface StreamProcessor {
        InputStream processInputStream(InputStream r10, Map<String, List<String>> r11, RetrofitMetrics r12);
    }

    public interface addResponseHeadersCallback {
        boolean onCallToRetryRequestByTuringHeader(Map<String, List<String>> r10);
    }

    static {
        f7196i = new AtomicBoolean(false);
        f7197j = new Object();
        f7198k = new CountDownLatch(1);
        f7199l = -1;
        f7205r = false;
        f7206s = false;
    }

    public static void A(boolean r10) {
        if (f7196i.get() != r10) goto L5;
        return;
    L5:
        f7196i.getAndSet(r10);
        b();
        if (r10 == true) goto L9;
        f7198k = new CountDownLatch(1);
        return;
    }

    public static void B(CookieShareInterceptor r10) {
        f7201n = r10;
    }

    public static void C(String r10) {
        if (r10 != null) goto L19;
    L16:
        f7191d = r10;
        return;
    L19:
        if (r10.length() <= 0) goto L16;
        char[] r11 = r10.toCharArray();     // Catch: Exception -> L18
        int r12 = r11.length;     // Catch: Exception -> L18
        int r13 = 0;
        boolean r14 = false;
    L6:
        if (r13 >= r12) goto L13;
        char r15 = r11[r13];     // Catch: Exception -> L18
        if (r15 >= ' ') goto L10;
    L11:
        r11[r13] = '?';     // Catch: Exception -> L18
        r14 = true;
    L12:
        r13 = r13 + 1;     // Catch: Exception -> L18
        goto L6
    L10:
        if (r15 <= '~') goto L12;
    L13:
        if (r14 == false) goto L16;
        r10 = new String(r11);     // Catch: Exception -> L18
        goto L16
    }

    public static void D(MonitorProcessHook r10) {
        f7194g = r10;
    }

    public static boolean E(int r10, Map r11) {
        if (r10 == 200) goto L5;
        return false;
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L8;
        return false;
    L8:
        return u(r11);
    }

    public static String F(String r10, boolean r11, Object... r12) {
        ApiProcessHook r13 = f7193f;
        if (r13 != null) goto L5;
        return r10;
    L5:
        return r13.addRequestVertifyParams(r10, r11, r12);
    }

    public static Map G(String r10, Map r11) {
        AddSecurityFactorProcessCallback r12 = f7204q;
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.onCallToAddSecurityFactor(r10, r11);
    }

    public static void H() {
        ApiProcessHook r10 = f7193f;
        if (r10 == null) goto L6;
        r10.onTryInit();
        return;
    }

    public static CookieManager I() {
        Object r10 = f7197j;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (f7196i.get() == false) goto L30;
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L13
        CookieManager r11 = CookieManager.getInstance();     // Catch: Throwable -> L22
        if (r11.acceptCookie() == true) goto L36;
        r11.setAcceptCookie(true);     // Catch: Throwable -> L26
        return r11;
    L36:
        return r11;
    L38:
        return r11;
    L22:
        return null;
    L30:
        CountDownLatch r12 = f7198k;     // Catch: Throwable -> L13 Exception -> L27
        if (r12 == null) goto L15;
        r12.await(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13 Exception -> L27
        if (f7198k.getCount() != 1) goto L15;
        f7198k.countDown();     // Catch: Throwable -> L13 Exception -> L27
    L15:
        f7196i.getAndSet(true);     // Catch: Throwable -> L13
        goto L16
    }

    public static CookieManager J() {
        return K("");
    }

    public static CookieManager K(String r10) {
        H();
        return I();
    }

    public static String a(String r10, boolean r11) {
        ApiProcessHook r12 = f7193f;
        if (r12 != null) goto L5;
        return r10;
    L5:
        return r12.addCommonParams(r10, r11);
    }

    public static void b() {
        CountDownLatch r10 = f7198k;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getCount() <= 0) goto L9;
        f7198k.countDown();
        return;
    }

    public static String c(String r10) {
        return d(r10, null);
    }

    public static String d(String r10, a r11) {
        if (e.b(r10) == false) goto L5;
        return r10;
    L5:
        ApiRequestInterceptor r12 = f7200m;
        if (r12 != null) goto L8;
        return r10;
    L8:
        return r12.filterUrl(r10, r11);
    }

    public static AppCookieStore e() {
        return f7202o;
    }

    public static CommandListener f() {
        return f7192e;
    }

    public static int g() {
        return BlockConstants.DEFAULT_RELEASE_BUFFER_DELAY;
    }

    public static ConnectionQualitySamplerHook h() {
        return f7188a;
    }

    public static CookieShareInterceptor i() {
        return f7201n;
    }

    public static boolean j() {
        return f7206s;
    }

    public static int k() {
        return BlockConstants.DEFAULT_RELEASE_BUFFER_DELAY;
    }

    public static StreamProcessor l() {
        return f7190c;
    }

    public static String m() {
        return f7191d;
    }

    public static void n(String r10, Throwable r11, long r12, BaseHttpRequestInfo r13) {
        if (e.b(r10) == true) goto L13;
        if (r11 == null) goto L17;
        ApiProcessHook r14 = f7193f;
        OldMonitorProcessHook r15 = f7195h;
        if (r14 == null) goto L14;
        if (r15 != null) goto L10;
        return;
    L10:
        if (r15.getOldmonitorSwitch() == false) goto L16;
        r14.handleApiError(r10, r11, r12, r13);
        return;
    L16:
        return;
    L14:
        return;
    L17:
        return;
    }

    public static void o(String r10, long r11, BaseHttpRequestInfo r12) {
        ApiProcessHook r13 = f7193f;
        OldMonitorProcessHook r14 = f7195h;
        if (e.b(r10) == false) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L13;
        if (r13 == null) goto L14;
        if (r14 != null) goto L9;
        return;
    L9:
        if (r14.getOldmonitorSwitch() == false) goto L16;
        r13.handleApiOk(r10, r11, r12);
        return;
    L16:
        return;
    L14:
        return;
    }

    public static boolean p(Object r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r10 instanceof a) == false) goto L8;
        if (((a) r10).f22494q == false) goto L8;
        return true;
    }

    public static void q(long r10, long r11, String r13, String r14, BaseHttpRequestInfo r15, Throwable r16) {
        if (e.b(r13) == true) goto L13;
        if (r16 == null) goto L15;
        MonitorProcessHook r12 = f7194g;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r15.A == false) goto L11;
        r15.f7161J.set(true);
    L11:
        r12.monitorApiError(r10, r11, r13, r14, r15, r16);
        return;
    L15:
        return;
    }

    public static void r(String r10, String r11, boolean r12) {
        if (e.b(r10) == false) goto L5;
        return;
    L5:
        if (e.b(r11) == true) goto L13;
        ApiRequestInterceptor r13 = f7200m;
        if (r13 == null) goto L12;
        r13.monitorApiHttp(r10, r11, r12);
        return;
    L12:
        return;
    }

    public static void s(long r10, long r11, String r12, String r13, BaseHttpRequestInfo r14) {
        MonitorProcessHook r15 = f7194g;
        if (e.b(r12) == false) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L17;
        if (r15 != null) goto L8;
        return;
    L8:
        if (r14.A == false) goto L12;
        if (r14.f7161J.get() == false) goto L12;
        return;
    L12:
        if (r14.A == false) goto L14;
        r14.f7161J.set(true);
    L14:
        r15.monitorApiOk(r10, r11, r12, r13, r14);
        return;
    }

    public static boolean t() {
        return f7205r;
    }

    public static boolean u(Map r10) {
        if (f7203p == null) goto L6;
        boolean r11 = f7203p.onCallToRetryRequestByTuringHeader(r10);
        r10.remove("bdturing-verify");
        return r11;
    L6:
        return false;
    }

    public static void v(ApiProcessHook r10) {
        f7193f = r10;
    }

    public static void w(ApiRequestInterceptor r10) {
        f7200m = r10;
    }

    public static void x(CdnConnectionQualitySamplerHook r10) {
        f7189b = r10;
    }

    public static void y(CommandListener r10) {
        f7192e = r10;
    }

    public static void z(ConnectionQualitySamplerHook r10) {
        f7188a = r10;
    }
}
