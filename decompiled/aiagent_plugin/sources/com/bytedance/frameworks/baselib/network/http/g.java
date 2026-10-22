package com.bytedance.frameworks.baselib.network.http;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.retrofit2.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkParams.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static boolean A = false;

    @Deprecated
    private static volatile int B = 0;
    private static boolean C = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f8335a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f8336b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static l f8337c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f8338d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f8339e = false;
    private static volatile boolean f = false;
    private static m g;
    private static c h;
    private static e i;
    private static j j;
    private static f k;
    private static k l;
    private static i m;
    private static InterfaceC0188g n;
    private static s o;
    private static String p;
    private static b q;
    private static a r;
    private static volatile t s;
    private static volatile r t;
    private static volatile n u;
    private static final Map<String, o> v = null;
    private static volatile q w;
    private static AtomicBoolean x;
    private static int y;
    private static boolean z;

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface a {
        Map<String, String> a(String r1, Map<String, List<String>> r2);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface b {
        Map<String, String> a(String r1, Map<String, List<String>> r2);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface c {
        boolean a();
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface d<T extends com.bytedance.frameworks.baselib.network.http.b> {
        String a(String r1, boolean r2);

        String a(String r1, boolean r2, Object... r3);

        @Deprecated
        Map<String, String> a(int r1);

        default Map<String, String> a(String r1, boolean r2, int r3) {
            return null;
        }

        void a();
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface e<T extends com.bytedance.frameworks.baselib.network.http.c> {
        String a(String r1, T r2);

        void a(String r1, String r2, boolean r3);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    @Deprecated
    public interface f {
        @Deprecated
        Map<String, List<String>> a(URI r1, Map<String, List<String>> r2);

        @Deprecated
        void b(URI r1, Map<String, List<String>> r2);
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NetworkParams.java */
    public interface InterfaceC0188g {
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface h {
        String a();

        void a(List<String> r1);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface i {
        boolean a(String r1);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    @Deprecated
    public interface j {
        @Deprecated
        List<String> a(CookieManager r1, com.bytedance.frameworks.baselib.network.http.d.b r2, URI r3);

        List<String> b(String r1);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface k {
        void a(String r1, String r2);

        void a(Set<String> r1);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface l<T extends com.bytedance.frameworks.baselib.network.http.b> {
        void a(long r1, long r3, String r5, String r6, T r7);

        void a(long r1, long r3, String r5, String r6, T r7, Throwable r8);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface m<T extends com.bytedance.frameworks.baselib.network.http.b> {
        void a(long r1, long r3, String r5, String r6, T r7, Throwable r8, JSONObject r9);

        void a(long r1, long r3, String r5, String r6, T r7, JSONObject r8);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface n {
        com.bytedance.frameworks.baselib.network.http.i a(String r1, List<com.bytedance.retrofit2.b.b> r2, Map<String, List<String>> r3, boolean r4);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface o {
        com.bytedance.frameworks.baselib.network.http.i a(Map<String, List<String>> r1);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface p extends o {
        com.bytedance.frameworks.baselib.network.http.i a(String r1, List<com.bytedance.retrofit2.b.b> r2, Map<String, List<String>> r3);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface q {
        com.bytedance.frameworks.baselib.network.http.i a(String r1, String r2, com.bytedance.frameworks.baselib.network.http.b r3, int r4, List<com.bytedance.retrofit2.b.b> r5, Map<String, List<String>> r6);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface r {
        com.bytedance.frameworks.baselib.network.http.i a(Map<String, List<String>> r1);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface s {
        InputStream a(InputStream r1, Map<String, List<String>> r2, af r3);
    }

    /* JADX INFO: compiled from: NetworkParams.java */
    public interface t {
        boolean a(Map<String, List<String>> r1);
    }

    public static int a() {
        return 15000;
    }

    public static int b() {
        return 15000;
    }

    public g() {
    }

    public static void a(h r2) {
        f8335a = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
    }

    public static h c() {
        return f8335a;
    }

    public static void a(d r2) {
        f8336b = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    public static void a(af r1) {
        d r0 = f8336b;
        if (r0 == null) goto L13;
        if (r1 == null) goto L14;
        r1.ae();
    L14:
        r0.a();     // Catch: Throwable -> L9
        if (r1 == null) goto L16;
        r1.af();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (r1 == null) goto L12;
        r1.af();
    L12:
        throw th;
    }

    public static String a(String r1, boolean r2, af r3) {
        if (f8336b == null) goto L13;
        if (r3 == null) goto L14;
        r3.r();
    L14:
        r1 = f8336b.a(r1, r2);     // Catch: Throwable -> L9
        if (r3 == null) goto L13;
        r3.s();
    L9:
        th = move-exception;
        if (r3 == null) goto L12;
        r3.s();
    L12:
        throw th;
    L13:
        return r1;
    }

    public static Map<String, String> a(String r1, boolean r2, int r3, af r4) {
        if (f8336b == null) goto L13;
        if (r4 == null) goto L15;
        r4.r();
    L15:
        Map<String, String> r5 = f8336b.a(r1, r2, r3);     // Catch: Throwable -> L9
        if (r4 == null) goto L17;
        r4.s();
        return r5;
    L17:
        return r5;
    L9:
        th = move-exception;
        if (r4 == null) goto L12;
        r4.s();
    L12:
        throw th;
    L13:
        return null;
    }

    public static String a(String r1, boolean r2, af r3, Object... r4) {
        if (f8336b == null) goto L13;
        if (r3 == null) goto L15;
        r3.v();
    L15:
        String r5 = f8336b.a(r1, r2, r4);     // Catch: Throwable -> L9
        if (r3 == null) goto L17;
        r3.w();
        return r5;
    L17:
        return r5;
    L9:
        th = move-exception;
        if (r3 == null) goto L12;
        r3.w();
    L12:
        throw th;
    L13:
        return null;
    }

    @Deprecated
    public static Map<String, String> a(int r1, af r2) {
        if (f8336b == null) goto L13;
        if (r2 == null) goto L15;
        r2.r();
    L15:
        Map<String, String> r3 = f8336b.a(r1);     // Catch: Throwable -> L9
        if (r2 == null) goto L17;
        r2.s();
        return r3;
    L17:
        return r3;
    L9:
        th = move-exception;
        if (r2 == null) goto L12;
        r2.s();
    L12:
        throw th;
    L13:
        return null;
    }

    public static void a(boolean r0) {
        f8338d = r0;
    }

    public static void b(boolean r0) {
        f8339e = r0;
    }

    public static void c(boolean r0) {
        f = r0;
    }

    public static boolean d() {
        return f;
    }

    public static void a(l r2) {
        f8337c = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.k.a();
    }

    private static boolean c(String r4, com.bytedance.frameworks.baselib.network.http.b r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.R == false) goto L6;
        return false;
    L6:
        if (com.bytedance.common.utility.j.a(r5.f8138d.aF.j) == false) goto L8;
        return false;
    L8:
        if (r5.f8138d.aE.a() >= 0) goto L11;
        return false;
    L11:
        return !com.bytedance.common.utility.j.a(r4);
    }

    public static void a(String r10, com.bytedance.frameworks.baselib.network.http.b r11, Throwable r12) {
        if (c(r10, r11) == true) goto L5;
        return;
    L5:
        if (f8337c == null) goto L11;
        if (r12 == null) goto L12;
        r11.f8138d.k();
        f8337c.a(r11.f8138d.aE.a(), r11.f8138d.aE.f.l, r10, r11.P, r11, r12);
        return;
    L12:
        return;
    }

    public static void a(String r9, com.bytedance.frameworks.baselib.network.http.b r10) {
        if (c(r9, r10) == true) goto L5;
        return;
    L5:
        if (f8337c == null) goto L10;
        r10.f8138d.k();
        f8337c.a(r10.f8138d.aE.a(), r10.f8138d.aE.f.l, r9, r10.P, r10);
        return;
    }

    public static void a(m r2) {
        g = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.k.a();
    }

    public static void b(String r10, com.bytedance.frameworks.baselib.network.http.b r11) {
        if (c(r10, r11) == true) goto L5;
        return;
    L5:
        if (g == null) goto L17;
        r11.f8138d.k();
        JSONObject r9 = new JSONObject();
        r11.f8138d.c(r9);     // Catch: JSONException -> L10
    L12:
        g.a(r11.f8138d.aE.a(), r11.f8138d.aE.f.l, r10, r11.P, r11, r9);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void b(String r11, com.bytedance.frameworks.baselib.network.http.b r12, Throwable r13) {
        if (c(r11, r12) == true) goto L5;
        return;
    L5:
        if (g == null) goto L18;
        if (r13 == null) goto L19;
        r12.f8138d.k();
        JSONObject r10 = new JSONObject();
        r12.f8138d.c(r10);     // Catch: JSONException -> L11
    L13:
        g.a(r12.f8138d.aE.a(), r12.f8138d.aE.f.l, r11, r12.P, r12, r13, r10);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L19:
        return;
    }

    public static boolean e() {
        c r0 = h;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public static void a(e r2) {
        i = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
    }

    public static String a(String r1, af r2) {
        return a(r1, null, r2);
    }

    public static String a(String r1, com.bytedance.frameworks.baselib.network.http.c r2, af r3) {
        if (com.bytedance.common.utility.j.a(r1) == false) goto L6;
        return r1;
    L6:
        if (i == null) goto L16;
        if (r3 == null) goto L17;
        r3.n();
    L17:
        r1 = i.a(r1, r2);     // Catch: Throwable -> L12
        if (r3 == null) goto L16;
        r3.o();
    L12:
        th = move-exception;
        if (r3 == null) goto L15;
        r3.o();
    L15:
        throw th;
    L16:
        return r1;
    }

    public static void a(String r1, String r2, boolean r3, af r4) {
        if (com.bytedance.common.utility.j.a(r1) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.j.a(r2) == false) goto L8;
        return;
    L8:
        if (i == null) goto L27;
        if (r4 == null) goto L25;
        if (r3 == true) goto L12;
        r4.l();
        goto L25
    L12:
        r4.p();
    L25:
        i.a(r1, r2, r3);     // Catch: Throwable -> L18
        if (r4 == null) goto L28;
        if (r3 == true) goto L17;
        r4.m();
        return;
    L17:
        r4.q();
        return;
    L28:
        return;
    L18:
        th = move-exception;
        if (r4 == null) goto L23;
        if (r3 == true) goto L22;
        r4.m();
        goto L23
    L22:
        r4.q();
    L23:
        throw th;
    }

    @Deprecated
    public static void a(j r2) {
        j = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static j f() {
        return j;
    }

    @Deprecated
    public static f g() {
        return k;
    }

    public static k h() {
        return l;
    }

    public static void a(i r2) {
        m = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
    }

    public static i i() {
        return m;
    }

    public static void a(InterfaceC0188g r2) {
        n = (InterfaceC0188g) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0188g.class, "com.obric.aiagent.plugin");
    }

    public static s j() {
        return o;
    }

    public static CookieManager k() {
        return a("");
    }

    public static CookieManager a(String r0) {
        a(null);
        return com.bytedance.frameworks.baselib.network.http.b.a.b();
    }

    public static String l() {
        return p;
    }

    public static void b(String r6) {
        if (r6 != null) goto L19;
    L16:
        p = r6;
        return;
    L19:
        if (r6.length() <= 0) goto L16;
        char[] r0 = r6.toCharArray();     // Catch: Exception -> L18
        int r1 = r0.length;     // Catch: Exception -> L18
        int r2 = 0;
        boolean r3 = false;
    L6:
        if (r2 >= r1) goto L13;
        if (r0[r2] >= ' ') goto L10;
    L11:
        r0[r2] = '?';     // Catch: Exception -> L18
        r3 = true;
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L18
        goto L6
    L10:
        if (r0[r2] <= '~') goto L12;
    L13:
        if (r3 == false) goto L16;
        r6 = new String(r0);     // Catch: Exception -> L18
        goto L16
    }

    public static void a(b r2) {
        q = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public static Map<String, String> a(String r2, Map<String, List<String>> r3) {
        Map<String, List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        b r0 = q;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r2, r4);
    }

    public static Map<String, String> b(String r2, Map<String, List<String>> r3) {
        Map<String, List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        a r0 = r;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r2, r4);
    }

    static {
        v = new ConcurrentHashMap();
        x = new AtomicBoolean(false);
        y = 100;
        z = true;
        A = false;
        B = -1;
    }

    public static synchronized boolean a(String r6, o r7) {
        monitor-enter(g.class);
        o r8 = (o) ZeusTransformUtils.wrapperContextForParams(r7, o.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (com.bytedance.common.utility.j.a(r6) == false) goto L7;
    L21:
        monitor-exit(g.class);
        return false;
    L7:
        if (r6.toLowerCase().contains("verify") == false) goto L21;
        if (r8 == null) goto L21;
        Iterator<String> r1 = v.keySet().iterator();     // Catch: Throwable -> L23
    L12:
        if (r1.hasNext() == false) goto L17;
        if (((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase(r6) == false) goto L12;
        monitor-exit(g.class);
        return false;
    L17:
        v.put(r6, r8);     // Catch: Throwable -> L23
        monitor-exit(g.class);
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    private static synchronized Map.Entry<String, o> a(Set<String> r8) {
        monitor-enter(g.class);
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Iterator<Map.Entry<String, o>> r1 = v.entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<String, o> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Iterator r3 = r9.iterator();     // Catch: Throwable -> L19
    L9:
        if (r3.hasNext() == false) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (com.bytedance.common.utility.j.a(r4) == true) goto L9;
        if (r4.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L9;
        monitor-exit(g.class);
        return r2;
    L17:
        monitor-exit(g.class);
        return null;
    L19:
        th = move-exception;
        throw th;
    }

    private static com.bytedance.frameworks.baselib.network.http.i a(Map<String, List<String>> r2) {
        Map<String, List<String>> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (t == null) goto L7;
        com.bytedance.frameworks.baselib.network.http.i r0 = t.a(r3);
        r3.remove("bdturing-verify");
        return r0;
    L7:
        if (s == null) goto L11;
        boolean r1 = s.a(r3);
        r3.remove("bdturing-verify");
        return new com.bytedance.frameworks.baselib.network.http.i(r1);
    L11:
        return new com.bytedance.frameworks.baselib.network.http.i(false);
    }

    private static com.bytedance.frameworks.baselib.network.http.i a(com.bytedance.retrofit2.b.c r9, com.bytedance.frameworks.baselib.network.http.b r10, List<com.bytedance.retrofit2.b.b> r11, Map<String, List<String>> r12) {
        List<com.bytedance.retrofit2.b.b> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, List<String>> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        com.bytedance.frameworks.baselib.network.http.i r0 = new com.bytedance.frameworks.baselib.network.http.i(false);
        if (r14 != null) goto L5;
    L54:
        return r0;
    L5:
        if (r14.isEmpty() == true) goto L54;
        if (v.isEmpty() == true) goto L54;
        Iterator<String> r3 = r14.keySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L17;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r4) == true) goto L11;
        if (r4.toLowerCase().contains("verify") == false) goto L11;
        r2 = true;
    L17:
        if (r2 == true) goto L19;
        return r0;
    L19:
        Map.Entry<String, o> r5 = a(r14.keySet());
        if (r5 != null) goto L23;
        return r0;
    L23:
        if (r13 == null) goto L34;
        String r6 = "x-tt-bypass-retry-by-" + ((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"));
        Iterator<com.bytedance.retrofit2.b.b> r7 = r13.iterator();
    L26:
        if (r7.hasNext() == false) goto L34;
        com.bytedance.retrofit2.b.b r8 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L26;
        if (r6.equalsIgnoreCase(r8.a()) == false) goto L26;
        if ("1".equals(r8.b()) == false) goto L26;
        return r0;
    L34:
        o r15 = (o) ZeusTransformUtils.preCheckCast(r5.getValue(), o.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L37;
        return r0;
    L37:
        r10.f8138d.ai();
    L51:
        th = move-exception;
        r10.f8138d.aj();
        throw th;
    L39:
        if (ZeusTransformUtils.instanceOf(r15, p.class) == false) goto L41;
        com.bytedance.frameworks.baselib.network.http.i r16 = ((p) ZeusTransformUtils.preCheckCast(r15, p.class, "com.obric.aiagent.plugin")).a(r9.b(), r13, r14);     // Catch: Throwable -> L51
    L42:
        r10.f8138d.aj();
        r10.V = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L45;
    L50:
        return r16;
    L45:
        if (r16.a() == false) goto L50;
        r10.T = true;
        Map<String, String> r17 = r16.c();
        if (r17 != null) goto L49;
        r17 = new HashMap();
    L49:
        r17.put("x-tt-retry-by-" + ((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin")), "1");
        r16.a(r17);
        goto L50
    L41:
        r16 = r15.a(r14);     // Catch: Throwable -> L51
        goto L42
    }

    public static void d(boolean r1) {
        x.set(r1);
    }

    private static com.bytedance.frameworks.baselib.network.http.i a(com.bytedance.retrofit2.b.c r16, com.bytedance.frameworks.baselib.network.http.b r17, int r18, List<com.bytedance.retrofit2.b.b> r19, Map<String, List<String>> r20, boolean r21) {
        List<com.bytedance.retrofit2.b.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.i r10 = new com.bytedance.frameworks.baselib.network.http.i(false);
        if (r21 == false) goto L5;
    L43:
        return r10;
    L5:
        if (r17.T == true) goto L43;
        if (r17.W == true) goto L43;
        if (x.get() == true) goto L43;
        if (w == null) goto L43;
        com.bytedance.frameworks.baselib.network.http.j r8 = r17.Z;
        if (r8 != null) goto L17;
        return r10;
    L17:
        if (r8.a() == false) goto L20;
        r8.a(r16.n(), r16.o(), r18, -1, r10, r17);
        return r10;
    L20:
        String r2 = r16.b();
        com.bytedance.frameworks.baselib.network.http.c.C0184c r0 = r8.b();
        if (r0 != null) goto L23;
        return r10;
    L23:
        String r1 = r0.f8194a;
        String r3 = r0.f8195b;
        if (TextUtils.isEmpty(r1) == true) goto L43;
        if (TextUtils.isEmpty(r3) == true) goto L43;
        String r11 = r16.n();
        String r12 = r16.o();
        String r13 = r2.replaceFirst(r11, r1).replaceFirst(r12, r3);
        long r14 = SystemClock.elapsedRealtime();
        r17.f8138d.am();
        r10 = w.a(r2, r13, r17, r18, r6, r7);     // Catch: Throwable -> L31
    L30:
        r17.f8138d.an();
        r8.a(r11, r12, r18, SystemClock.elapsedRealtime() - r14, r10, r17);
        if (r10 != null) goto L37;
    L39:
        return r10;
    L37:
        if (r10.a() == false) goto L39;
        r17.Y = true;
        r10.a(r13);
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r17.f8138d.an();
        throw th;
    }

    private static com.bytedance.frameworks.baselib.network.http.i a(String r7, com.bytedance.frameworks.baselib.network.http.b r8, boolean r9, List<com.bytedance.retrofit2.b.b> r10, Map<String, List<String>> r11) {
        List<com.bytedance.retrofit2.b.b> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map<String, List<String>> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.i r2 = null;
        if (u != null) goto L6;
        return null;
    L6:
        if (r12 == null) goto L17;
        Iterator<com.bytedance.retrofit2.b.b> r3 = r12.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        com.bytedance.retrofit2.b.b r4 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        if ("x-tt-bypass-retry-for-account".equalsIgnoreCase(r4.a()) == false) goto L9;
        if ("1".equals(r4.b()) == false) goto L9;
        return null;
    L17:
        r8.f8138d.ak();
        r2 = u.a(r7, r12, r13, r9);     // Catch: Throwable -> L29
    L19:
        r8.f8138d.al();
        if (r9 == true) goto L28;
        if (r2 == null) goto L28;
        if (r2.a() == false) goto L28;
        HashMap r14 = new HashMap();
        r14.put("x-tt-retry-for-account", "1");
        if (r2.c() == null) goto L27;
        r14.putAll(r2.c());
    L27:
        r2.a(r14);
        r8.W = true;
    L28:
        return r2;
    }

    private static com.bytedance.frameworks.baselib.network.http.i a(com.bytedance.frameworks.baselib.network.http.b r7, List<com.bytedance.retrofit2.b.b> r8, Map<String, List<String>> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.i r0 = new com.bytedance.frameworks.baselib.network.http.i(false);
        if (r11 != null) goto L5;
    L30:
        return r0;
    L5:
        if (r11.containsKey("bdturing-verify") == false) goto L30;
        if (r10 == null) goto L19;
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L19;
        com.bytedance.retrofit2.b.b r4 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r12.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        if ("x-tt-bypass-bdturing".equalsIgnoreCase(r4.a()) == false) goto L11;
        if ("1".equals(r4.b()) == false) goto L11;
        return r0;
    L19:
        TreeMap r13 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r13.putAll(r11);
        r7.f8138d.ai();
        com.bytedance.frameworks.baselib.network.http.i r14 = a(r13);
        r7.f8138d.aj();
        if (r13.containsKey("bdturing-verify") == true) goto L22;
        r7.S = true;
        r7.V = "bdturing-verify";
    L22:
        if (r14 != null) goto L24;
    L29:
        return r14;
    L24:
        if (r14.a() == false) goto L29;
        r7.T = true;
        HashMap r15 = new HashMap();
        r15.put("x-tt-bdturing-retry", "1");
        if (r14.c() == null) goto L28;
        r15.putAll(r14.c());
    L28:
        r14.a(r15);
        goto L29
    }

    private static boolean b(Map<String, List<String>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L16:
        return false;
    L5:
        if (r5.isEmpty() == true) goto L16;
        Iterator r6 = r5.keySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r2) == true) goto L9;
        if (r2.toLowerCase().contains("ignore-status-code") == false) goto L9;
        return true;
    }

    public static com.bytedance.frameworks.baselib.network.http.i a(com.bytedance.retrofit2.b.c r8, int r9, com.bytedance.frameworks.baselib.network.http.b r10, List<com.bytedance.retrofit2.b.b> r11, Map<String, List<String>> r12, boolean r13, boolean r14) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        boolean r15 = false;
        com.bytedance.frameworks.baselib.network.http.i r16 = new com.bytedance.frameworks.baselib.network.http.i(false);
        r10.Y = false;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return r16;
    L6:
        if (r9 != 200) goto L8;
    L9:
        if (r13 == false) goto L11;
        com.bytedance.frameworks.baselib.network.http.i r17 = a(r10, r5, r6);
        if (r10.S == true) goto L16;
        r17 = a(r8, r10, r5, r6);
    L16:
        if (r17 != null) goto L18;
    L20:
        boolean r0 = false;
    L21:
        com.bytedance.frameworks.baselib.network.http.i r1 = a(r8.b(), r10, r0, r5, r6);
        if (r0 == true) goto L27;
        if (r1 == null) goto L27;
        if (r17 == null) goto L26;
        r1.a(r17.b());
    L26:
        r17 = r1;
    L34:
        if (r17 != null) goto L36;
    L38:
        if (r15 == false) goto L40;
        return r17;
    L40:
        com.bytedance.frameworks.baselib.network.http.i r18 = a(r8, r10, r9, r5, r6, r14);
        if (r17 == null) goto L44;
        if (r18 == null) goto L44;
        r18.a(r17.b());
    L44:
        return r18;
    L36:
        if (r17.a() == false) goto L38;
        r15 = true;
    L27:
        if (r1 == null) goto L34;
        if (r1.c() == null) goto L34;
        HashMap r2 = new HashMap();
        if (r17.c() == null) goto L33;
        r2.putAll(r17.c());
    L33:
        r2.putAll(r1.c());
        r17.a(r2);
        goto L34
    L18:
        if (r17.a() == false) goto L20;
        r0 = true;
    L11:
        return a(r8, r10, r9, r5, r6, r14);
    L8:
        if (b(r6) == false) goto L11;
        goto L9
    }

    public static void a(int r0) {
        y = r0;
    }

    public static int m() {
        return y;
    }

    public static void e(boolean r0) {
        z = r0;
    }

    public static boolean n() {
        return z;
    }

    public static boolean o() {
        return A;
    }

    public static boolean p() {
        return C;
    }

    public static void f(boolean r0) {
        C = r0;
    }
}
