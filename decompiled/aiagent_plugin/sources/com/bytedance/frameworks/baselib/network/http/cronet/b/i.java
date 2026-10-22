package com.bytedance.frameworks.baselib.network.http.cronet.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SsCronetHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends com.bytedance.frameworks.baselib.network.http.a implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8234a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f8235b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f8236c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ICronetClient f8237d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile i f8238e = null;
    private static volatile boolean f = true;
    private static volatile String g;
    private static volatile String h;
    private static ConcurrentHashMap<String, Integer> i;
    private static Map<String, Integer> j;
    private static volatile ICronetAppProvider k;
    private static a l;
    private static b m;
    private static c n;
    private static d o;

    /* JADX INFO: compiled from: SsCronetHttpClient.java */
    public interface a {
        boolean a();
    }

    /* JADX INFO: compiled from: SsCronetHttpClient.java */
    public interface b {
        boolean b();
    }

    /* JADX INFO: compiled from: SsCronetHttpClient.java */
    public interface c {
        boolean a();

        String b();
    }

    /* JADX INFO: compiled from: SsCronetHttpClient.java */
    public interface d {
        JSONObject c();
    }

    public static boolean a(int r1) {
        if (r1 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 20971520) goto L7;
        return true;
    }

    public static boolean b(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 20971520) goto L6;
        return true;
    }

    public static boolean c(int r1) {
        if (r1 >= 16384) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 10485760) goto L7;
        return true;
    }

    static {
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
    }

    public static void a(ICronetAppProvider r2) {
        k = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetAppProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        a r0 = l;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.a();
    }

    public static void a(a r2) {
        l = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    public static void a(b r2) {
        m = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public static void a(c r2) {
        n = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        c r0 = n;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        c r0 = n;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.b();
    }

    public static void a(d r2) {
        o = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    public static d a() {
        return o;
    }

    public static void a(boolean r0) {
        f = r0;
    }

    public static boolean b() {
        return f;
    }

    public static i a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f8238e != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8238e != null) goto L9;
        f8238e = new i(r3);     // Catch: Throwable -> L11
        h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f8238e;
    }

    public static int a(String r2, com.bytedance.frameworks.baselib.network.http.b r3) {
        if (a(f8235b) == false) goto L7;
        return f8235b;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L18:
        if (r3 != null) goto L20;
        return 0;
    L20:
        if (r3.f8137c != 0) goto L22;
        return 0;
    L22:
        if (a(r3.f8137c.o) == true) goto L28;
        if (r3.f8137c.p == true) goto L26;
        return 0;
    L26:
        if (b(r3.f8137c.o) == true) goto L28;
        return 0;
    L28:
        return r3.f8137c.o;
    L9:
        if (j.isEmpty() == true) goto L18;
        if (j.containsKey(r2) == false) goto L18;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(j.get(r2), Integer.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L18;
        if (a(r4.intValue()) == false) goto L18;
        return r4.intValue();
    }

    public static int a(String r2, int r3) {
        if (c(r3) == true) goto L7;
        r3 = 0;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return r3;
    L10:
        if (i.containsKey(r2) == false) goto L16;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(i.get(r2), Integer.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L14;
        r3 = 0;
        goto L16
    L14:
        r3 = r4.intValue();
    L16:
        if (c(r3) == true) goto L18;
        return 0;
    L18:
        return r3;
    }

    private static void b(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        i.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        int r2 = r4.optInt(r1);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (c(r2) == false) goto L6;
        i.put(r1, Integer.valueOf(r2));
        goto L6
    }

    private static void c(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        j.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        int r2 = r4.optInt(r1);
        if (b(r2) == false) goto L6;
        j.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public static void a(JSONObject r7, SharedPreferences r8) {
        SharedPreferences r9 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r8, SharedPreferences.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L18;
        f8235b = r7.optInt("cronet_inputstream_buff_size", 0);
        JSONObject r5 = r7.optJSONObject("post_body_buffer_size");     // Catch: Throwable -> L26
        if (r5 == null) goto L8;
        b(r5);     // Catch: Throwable -> L26
        g = r5.toString();     // Catch: Throwable -> L26
    L9:
        JSONObject r10 = r7.optJSONObject("path_cronet_inputstream_buff_size");     // Catch: Throwable -> L26
        if (r10 == null) goto L17;
        String r6 = r10.toString();     // Catch: Throwable -> L26
        if (h != null) goto L14;
    L16:
        c(r10);     // Catch: Throwable -> L26
        h = r6;     // Catch: Throwable -> L26
        goto L18
    L14:
        if (r6.equals(h) == false) goto L16;
        return;
    L17:
        j.clear();     // Catch: Throwable -> L26
        h = "";     // Catch: Throwable -> L26
        goto L18
    L8:
        i.clear();     // Catch: Throwable -> L26
        g = "";     // Catch: Throwable -> L26
    L18:
        if (r9 == null) goto L34;
        f8235b = r9.getInt("cronet_inputstream_buff_size", 0);
        String r11 = r9.getString("post_body_buffer_size", "");
        if (TextUtils.isEmpty(r11) == false) goto L29;
    L22:
        String r12 = r9.getString("path_cronet_inputstream_buff_size", "");
        if (TextUtils.isEmpty(r12) == true) goto L35;
        c(new JSONObject(r12));     // Catch: Throwable -> L28
        return;
    L36:
        return;
    L35:
        return;
    L29:
        b(new JSONObject(r11));     // Catch: Throwable -> L27
        goto L22
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        r3.putInt("cronet_inputstream_buff_size", f8235b);
        if (g == null) goto L6;
        r3.putString("post_body_buffer_size", g);
    L6:
        if (h == null) goto L9;
        r3.putString("path_cronet_inputstream_buff_size", h);
        return;
    }

    private i(Context r3) {
        f8236c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.retrofit2.b.a
    public com.bytedance.retrofit2.b.e a(com.bytedance.retrofit2.b.c r3) {
        com.bytedance.retrofit2.b.c r2 = b(r3);
        com.bytedance.retrofit2.b.c r4 = com.bytedance.frameworks.baselib.network.e.d.a().a(r2);
        if (r4 == null) goto L6;
        r2 = r4;
    L6:
        if (f.a().b() == false) goto L18;
        if (r2.b().contains("no_retry=1") == true) goto L18;
        f.a r5 = f.a().a(r2);
        if (r5 == null) goto L18;
        if (r5.a() == null) goto L18;
        if (r5.a().size() < 2) goto L18;
        r2.p().aF.i.f9622a = true;
        return new com.bytedance.frameworks.baselib.network.http.cronet.b.b(r2, r5);
    L18:
        return new e(r2);
    }

    public com.bytedance.retrofit2.b.c b(com.bytedance.retrofit2.b.c r3) {
        com.bytedance.retrofit2.e.j r2 = r3.d();
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.retrofit2.e.c.class) == true) goto L5;
        return r3;
    L5:
        com.bytedance.retrofit2.e.c r4 = (com.bytedance.retrofit2.e.c) ZeusTransformUtils.preCheckCast(r2, com.bytedance.retrofit2.e.c.class, "com.obric.aiagent.plugin");
        r4.a(r3);
        return r3.m().a(r4).b();
    }

    private static void h() {
        if (f8237d == null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.j.a(f8234a) == true) goto L7;
        String r1 = f8234a;
    L8:
        Logger.w("SsCronetHttpClient", "tryResolveImpl:" + r1);
        Object r2 = ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin").newInstance();     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r2, ICronetClient.class) == false) goto L19;
        f8237d = (ICronetClient) ZeusTransformUtils.preCheckCast(r2, ICronetClient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w("SsCronetHttpClient", "load CronetClient exception: " + th);
        return;
    L7:
        r1 = "org.chromium.CronetClient";
        goto L8
    }

    public void a(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, ICronetAppProvider r15) {
        ICronetAppProvider r8 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r15, ICronetAppProvider.class, "com.obric.aiagent.plugin");
        h();
        ICronetClient r16 = f8237d;
        if (r16 == null) goto L6;
        r16.setCronetBootFailureCheckerProvider(this);
        f8237d.setCronetThreadStackOptFailureCheckerProvider(this);
        f8237d.tryCreateCronetEngine(f8236c, r10, r11, r12, r13, com.bytedance.frameworks.baselib.network.http.g.l(), r14, r8);
        return;
    }

    public static HttpURLConnection b(String r9, com.bytedance.frameworks.baselib.network.http.b r10) {
        h();
        ICronetClient r0 = f8237d;
        if (r0 == null) goto L11;
        r0.setCronetBootFailureCheckerProvider(f8238e);
        f8237d.setCronetThreadStackOptFailureCheckerProvider(f8238e);
        ICronetClient r2 = f8237d;
        Context r3 = f8236c;
        b r1 = m;
        if (r1 != null) goto L7;
        boolean r4 = false;
    L9:
        return r2.openConnection(r3, r9, r4, com.bytedance.frameworks.baselib.network.http.g.l(), r10, k);
    L7:
        r4 = r1.b();
        goto L9
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static Context getContext() {
        return f8236c;
    }

    private static void i() {
        if (f8237d == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static String c() {
        i();
        return f8237d.getCronetVersion();
    }

    public static int a(HttpURLConnection r1) {
        return f8237d.getCronetInternalErrorCode(r1);
    }

    public void b(boolean r1) {
        if (f8237d != null) goto L6;
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(f8236c) == true) goto L8;
        return;
    L8:
        f8237d.triggerGetDomain(r1);
    }

    public void c(boolean r1) {
        if (f8237d != null) goto L6;
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(f8236c) == true) goto L8;
        return;
    L8:
        f8237d.runInBackGround(r1);
    }

    public void a(String[] r10, byte[] r11, byte[] r12, long r13, long r15, boolean r17) {
        if (f8237d != null) goto L5;
        return;
    L5:
        if (r17 == false) goto L7;
    L9:
        f8237d.addClientOpaqueData(r10, r11, r12, r13, r15);
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(f8236c) == true) goto L9;
    }

    public void d(boolean r1) {
        if (f8237d != null) goto L5;
        return;
    L5:
        if (r1 == false) goto L7;
    L9:
        f8237d.clearClientOpaqueData();
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(f8236c) == true) goto L9;
    }

    public void a(String r1, boolean r2) {
        if (f8237d != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
    L9:
        f8237d.removeClientOpaqueData(r1);
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(f8236c) == true) goto L9;
    }

    public static k a(String r1, int r2, boolean r3) {
        i();
        return f8237d.ttUrlDispatch(r1, r2, r3);
    }

    public void a(String r2, Map<String, String> r3) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        i();
        f8237d.preconnectUrl(r2, r1);
    }

    public void a(String[] r1, int r2, int r3) {
        i();
        f8237d.tryStartNetDetect(r1, r2, r3);
    }

    public void a(String r2, int r3, String r4, Map<String, String> r5) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        i();
        f8237d.ttDnsResolve(r2, r3, r4, r1);
    }

    public void b(String r1) {
        i();
        f8237d.getMappingRequestState(r1);
    }

    public int d() {
        i();
        return f8237d.getEffectiveConnectionType();
    }

    public void a(String r8, String r9, String r10, String r11, String r12, String r13) {
        i();
        f8237d.notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
    }

    public static void a(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        i();
        f8237d.notifyStoreRegionUpdated(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void c(String r1) {
        i();
        f8237d.setProxy(r1);
    }

    public g e() {
        i();
        return f8237d.getNetworkQuality();
    }

    public h d(int r1) {
        i();
        return f8237d.getPacketLossRateMetrics(r1);
    }

    public Map<String, g> f() {
        i();
        return f8237d.getGroupRttEstimates();
    }

    public void d(String r1) {
        i();
        f8237d.setHostResolverRules(r1);
    }

    public void a(long r1) {
        i();
        f8237d.setAlogFuncAddr(r1);
    }

    public void a(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        i();
        f8237d.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public void a(String[] r1, int r2, long r3) {
        i();
        f8237d.startThrottle(r1, r2, r3);
    }

    public void a(String[] r1, int r2) {
        i();
        f8237d.stopThrottle(r1, r2);
    }

    public static void a(String r1, String r2) {
        i();
        f8237d.setBestHostWithRouteSelectionName(r1, r2);
    }

    public void g() {
        i();
        f8237d.setCookieInitCompleted();
    }

    public void e(String r1) {
        i();
        f8237d.reportNetDiagnosisUserLog(r1);
    }

    public void a(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        i();
        f8237d.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
    }

    public void a(JSONObject r1) {
        i();
        f8237d.setSlaSamplingSetting(r1);
    }
}
