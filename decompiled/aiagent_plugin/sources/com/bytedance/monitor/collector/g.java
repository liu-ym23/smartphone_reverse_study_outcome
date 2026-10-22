package com.bytedance.monitor.collector;

import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.monitor.collector.service.ServiceTrackMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LooperDispatchMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.bytedance.monitor.collector.b {
    private static int[] D = null;
    private static int[] E = null;
    private static int F = 0;
    private static final String TAG = "LooperDispatchMonitor";
    public static boolean g;
    public static boolean h;
    public static boolean i;
    private static int j;
    private static int k;
    private static volatile com.bytedance.monitor.collector.f y;
    private boolean A;
    private final ThreadWithHandler B;
    private volatile boolean C;
    private Runnable G;
    c f;
    private int l;
    private volatile int m;
    private int n;
    private int o;
    private f p;
    private b q;
    private long r;
    private long s;
    private int t;
    private long u;
    private String v;
    private String w;
    private com.bytedance.monitor.collector.a x;
    private volatile boolean z;

    /* JADX INFO: compiled from: LooperDispatchMonitor.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f8969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f8972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f8973e;
        String f;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("startTime", this.f8969a);     // Catch: JSONException -> L5
            r0.put("cost", this.f8970b);     // Catch: JSONException -> L5
            r0.put("delay", this.f8971c);     // Catch: JSONException -> L5
            r0.put("isMessage", String.valueOf(this.f8972d));     // Catch: JSONException -> L5
            r0.put("seqNum", this.f8973e);     // Catch: JSONException -> L5
            r0.put("stack", this.f);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        void b() {
            this.f8969a = -1;
            this.f8970b = -1;
            this.f8971c = -1;
            this.f8973e = -1;
            this.f = null;
        }
    }

    /* JADX INFO: compiled from: LooperDispatchMonitor.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f8975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List<a> f8976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8977d;

        public b(int r2) {
            this.f8977d = 0;
            this.f8974a = r2;
            this.f8976c = new ArrayList(r2);
        }

        a a() {
            a r0 = this.f8975b;
            AnonymousClass1 r1 = null;
            if (r0 == null) goto L6;
            this.f8975b = null;
            return r0;
        L6:
            return new a(r1);
        }

        void a(a r3) {
            int r0 = this.f8976c.size();
            int r1 = this.f8974a;
            if (r0 >= r1) goto L5;
            this.f8976c.add(r3);
            this.f8977d = this.f8976c.size();
            return;
        L5:
            int r2 = this.f8977d % r1;
            this.f8977d = r2;
            a r4 = (a) ZeusTransformUtils.preCheckCast(this.f8976c.set(r2, r3), a.class, "com.obric.aiagent.plugin");
            r4.b();
            this.f8975b = r4;
            this.f8977d++;
        }

        JSONArray b() {
            JSONArray r0 = new JSONArray();
            int r3 = 0;
            if (this.f8976c.size() != this.f8974a) goto L12;
            int r1 = this.f8977d - 1;
        L6:
            if (r1 >= this.f8976c.size()) goto L9;
            r0.put(((a) ZeusTransformUtils.preCheckCast(this.f8976c.get(r1), a.class, "com.obric.aiagent.plugin")).a());
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.f8977d - 1)) goto L14;
            r0.put(((a) ZeusTransformUtils.preCheckCast(this.f8976c.get(r3), a.class, "com.obric.aiagent.plugin")).a());
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.f8976c.size()) goto L14;
            r0.put(((a) ZeusTransformUtils.preCheckCast(this.f8976c.get(r3), a.class, "com.obric.aiagent.plugin")).a());
            r3 = r3 + 1;
            goto L12
        }
    }

    /* JADX INFO: compiled from: LooperDispatchMonitor.java */
    public interface c {
        void a(long[] r1);
    }

    /* JADX INFO: compiled from: LooperDispatchMonitor.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f8978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f8981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f8982e;

        public d() {
        }
    }

    /* JADX INFO: compiled from: LooperDispatchMonitor.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f8986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f8987e;
        long f;
        long g;
        com.bytedance.monitor.collector.service.c h;
        String i;
        public String j;
        StackTraceElement[] k;
        StackTraceElement[] l;
        String m;
        String n;
        d o;

        public e() {
        }

        public void a(String r2, StackTraceElement[] r3, StackTraceElement[] r4, String r5) {
            if (TextUtils.isEmpty(r2) == true) goto L5;
            this.n = r2;
        L5:
            if (r3 == null) goto L7;
            this.k = r3;
        L7:
            if (r4 == null) goto L10;
            this.l = r4;
        L10:
            if (TextUtils.isEmpty(r5) == true) goto L13;
            this.m = r5;
            return;
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("msg", o.a(this.i));     // Catch: JSONException -> L5
            r0.put("cpuDuration", this.g);     // Catch: JSONException -> L5
            r0.put("duration", this.f);     // Catch: JSONException -> L5
            r0.put("type", this.f8986d);     // Catch: JSONException -> L5
            r0.put("messageCount", this.f8987e);     // Catch: JSONException -> L5
            r0.put("lastDuration", this.f8984b - this.f8985c);     // Catch: JSONException -> L5
            r0.put("start", this.f8983a);     // Catch: JSONException -> L5
            r0.put("end", this.f8984b);     // Catch: JSONException -> L5
            a(r0);     // Catch: JSONException -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public String b() {
            return "msg:" + o.a(this.i) + ",cpuDuration:" + this.g + ",duration:" + this.f + ",type:" + this.f8986d + ",messageCount:" + this.f8987e + ",lastDuration:" + (this.f8984b - this.f8985c) + ",start:" + this.f8983a + ",end:" + this.f8984b;
        }

        boolean c() {
            if ((this.f8984b - this.f8985c) <= 17) goto L5;
            return true;
        L5:
            if (this.f > 400) goto L22;
            int r0 = this.f8987e;
            if (r0 <= 300) goto L10;
            return true;
        L10:
            if (r0 >= 20) goto L13;
            return true;
        L13:
            if (this.f8986d != 1) goto L16;
            return true;
        L16:
            if (this.g < 20) goto L24;
            return false;
        L24:
            return true;
        L22:
            return true;
        }

        private void a(JSONObject r8) {
            StackTraceElement[] r0 = this.k;
            if (r0 == null) goto L5;
            r8.put("block_stack", o.a(r0));
        L5:
            r8.put("block_uuid", this.n);
            StackTraceElement[] r1 = this.l;
            if (r1 == null) goto L8;
            r8.put("sblock_stack", o.a(r1));
        L8:
            r8.put("sblock_uuid", this.n);
            if (TextUtils.isEmpty(this.m) == false) goto L12;
            r8.put("evil_msg", this.m);
        L12:
            if (this.o == null) goto L14;
            boolean r2 = true;
        L15:
            r8.put("belong_frame", r2);
            d r3 = this.o;
            if (r3 == null) goto L18;
            r8.put("vsyncDelayTime", this.f8985c - (r3.f8978a / 1000000));
            r8.put("doFrameTime", (this.o.f8979b / 1000000) - this.f8985c);
            r8.put("inputHandlingTime", (this.o.f8980c / 1000000) - (this.o.f8979b / 1000000));
            r8.put("animationsTime", (this.o.f8981d / 1000000) - (this.o.f8980c / 1000000));
            r8.put("performTraversalsTime", (this.o.f8982e / 1000000) - (this.o.f8981d / 1000000));
            r8.put("drawTime", this.f8984b - (this.o.f8982e / 1000000));
        L18:
            com.bytedance.monitor.collector.service.c r4 = this.h;
            if (r4 == null) goto L22;
            r8.put("service_name", r4.f9030a);
            r8.put("service_what", this.h.f9031b);
            r8.put("service_time", this.h.f9032c);
            r8.put("service_thread", this.h.f9034e);
            r8.put("service_token", this.h.f9033d);
            return;
        L22:
            return;
        L14:
            r2 = false;
            goto L15
        }

        void d() {
            this.f8986d = -1;
            this.f8987e = -1;
            this.f = -1;
            this.i = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.h = null;
            this.j = null;
        }
    }

    /* JADX INFO: compiled from: LooperDispatchMonitor.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f8990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<e> f8991d;

        f(int r2) {
            this.f8991d = new ArrayList();
            this.f8988a = r2;
        }

        e a(int r2) {
            e r0 = this.f8990c;
            if (r0 == null) goto L5;
            r0.f8986d = r2;
            e r3 = this.f8990c;
            this.f8990c = null;
            return r3;
        L5:
            e r1 = new e();
            r1.f8986d = r2;
            return r1;
        }

        void a(e r4) {
            int r0 = this.f8991d.size();
            int r1 = this.f8988a;
            if (r0 >= r1) goto L5;
            this.f8991d.add(r4);
            this.f8989b = this.f8991d.size();
        L7:
            if (com.bytedance.apm.h.a.a() == true) goto L9;
            return;
        L9:
            if (r4.c() == false) goto L13;
            final String r5 = r4.b();
            com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this, r5));
            return;
        L13:
            return;
        L5:
            int r2 = this.f8989b % r1;
            this.f8989b = r2;
            e r3 = (e) ZeusTransformUtils.preCheckCast(this.f8991d.set(r2, r4), e.class, "com.obric.aiagent.plugin");
            r3.d();
            this.f8990c = r3;
            this.f8989b++;
            goto L7
        }

        e a() {
            int r0 = this.f8989b;
            if (r0 > 0) goto L7;
            return null;
        L7:
            return (e) ZeusTransformUtils.preCheckCast(this.f8991d.get(r0 - 1), e.class, "com.obric.aiagent.plugin");
        }

        List<e> b() {
            ArrayList r0 = new ArrayList();
            int r3 = 0;
            if (this.f8991d.size() != this.f8988a) goto L12;
            int r1 = this.f8989b - 1;
        L6:
            if (r1 >= this.f8991d.size()) goto L9;
            r0.add((e) ZeusTransformUtils.preCheckCast(this.f8991d.get(r1), e.class, "com.obric.aiagent.plugin"));
            r1 = r1 + 1;
        L9:
            if (r3 >= (this.f8989b - 1)) goto L14;
            r0.add((e) ZeusTransformUtils.preCheckCast(this.f8991d.get(r3), e.class, "com.obric.aiagent.plugin"));
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            if (r3 >= this.f8991d.size()) goto L14;
            r0.add(this.f8991d.get(r3));
            r3 = r3 + 1;
            goto L12
        }
    }

    @Override // com.bytedance.monitor.collector.b
    public void b(int r1) {
    }

    static /* synthetic */ String a(g r0, String r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ void a(g r0, boolean r1, long r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ boolean a(g r0) {
        return r0.A;
    }

    static /* synthetic */ boolean a(g r0, boolean r1) {
        r0.C = r1;
        return r1;
    }

    static /* synthetic */ f b(g r0) {
        return r0.p;
    }

    static /* synthetic */ String b(g r0, String r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ b c(g r0) {
        return r0.q;
    }

    static /* synthetic */ int d(g r0) {
        return r0.m;
    }

    static /* synthetic */ boolean e(g r0) {
        return r0.C;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f f(g r0) {
        return r0.m();
    }

    static /* synthetic */ Runnable g(g r0) {
        return r0.G;
    }

    static /* synthetic */ ThreadWithHandler h(g r0) {
        return r0.B;
    }

    static /* synthetic */ int i() {
        return F;
    }

    static /* synthetic */ int i(g r2) {
        int r0 = r2.l;
        r2.l = r0 + 1;
        return r0;
    }

    static /* synthetic */ int j() {
        return k;
    }

    static /* synthetic */ String j(g r0) {
        return r0.w;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f k() {
        return y;
    }

    static /* synthetic */ int l() {
        return j;
    }

    static {
        D = new int[]{600, 300};
        E = new int[]{200, 100};
        g = false;
        h = false;
        i = false;
    }

    private com.bytedance.monitor.collector.f m() {
        return y;
    }

    public g(int r4, boolean r5) {
        super(r4, "block_looper_info");
        this.l = 0;
        this.m = 0;
        this.n = 100;
        this.o = 200;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.z = false;
        this.A = false;
        this.C = false;
        this.G = new AnonymousClass2(this);
        ServiceTrackMonitor.getInstance().start();
        this.f = new AnonymousClass1(this);
        if (r5 == false) goto L5;
    L8:
        ThreadWithHandler r6 = new ThreadWithHandler("looper_monitor__");
        this.B = r6;
        r6.a();
        n();
        this.q = new b(300);
        r6.a(this.G, j);
        return;
    L5:
        if (g == true) goto L8;
        this.B = null;
    }

    private void n() {
        boolean r3 = i;
        if (r3 == false) goto L5;
    L7:
        if (r3 == false) goto L9;
    L11:
        if (r3 == true) goto L13;
    L15:
        if (r3 == true) goto L17;
        return;
    L17:
        if (h == true) goto L24;
        int r4 = E[0];
        j = r4;
        int r0 = D[1];
        k = r0;
        F = r0 / r4;
        return;
    L24:
        return;
    L13:
        if (h == false) goto L15;
        int r5 = E[1];
        j = r5;
        int r1 = D[1];
        k = r1;
        F = r1 / r5;
        return;
    L9:
        if (h == true) goto L11;
        int r6 = E[0];
        j = r6;
        int r2 = D[0];
        k = r2;
        F = r2 / r6;
        return;
    L5:
        if (h == false) goto L7;
        int r7 = E[1];
        j = r7;
        int r8 = D[0];
        k = r8;
        F = r8 / r7;
    }

    private void o() {
        int r0 = this.f8952c;
        if (r0 != 0) goto L5;
    L12:
        this.n = 100;
        this.o = 300;
        return;
    L5:
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L9;
    L11:
        this.n = 300;
        this.o = 200;
        return;
    L9:
        if (r0 == 3) goto L11;
    }

    public void d() {
        if (this.z == false) goto L5;
        return;
    L5:
        this.z = true;
        o();
        this.p = new f(this.n);
        com.bytedance.monitor.collector.a r0 = new AnonymousClass3(this);
        this.x = r0;
        h.b(r0);
        i.a(i.a());
    }

    private void a(final boolean r14, final long r15) {
        int r0 = this.m + 1;
        this.m = r0;
        this.m = r0 & SupportMenu.USER_MASK;
        this.A = false;
        if (this.r >= 0) goto L6;
        this.r = r15;
    L6:
        if (this.s >= 0) goto L9;
        this.s = r15;
    L9:
        if (this.t >= 0) goto L11;
        this.t = Process.myTid();
        this.u = SystemClock.currentThreadTimeMillis();
    L11:
        com.bytedance.monitor.collector.service.c r10 = ServiceTrackMonitor.getCurrentService();
        ServiceTrackMonitor.clearCurrentService();
        long r2 = r15 - this.r;
        int r1 = this.o;
        if (r2 > r1) goto L14;
        if (r10 != null) goto L14;
    L28:
        this.s = r15;
        final String r11 = this.w;
        if (this.f8953d == false) goto L32;
        final long r5 = SystemClock.currentThreadTimeMillis();
        k.a().f9015b.b(new AnonymousClass4(this, r14, r15, r5, r11));
        return;
    L32:
        return;
    L14:
        long r3 = this.s;
        if ((r15 - r3) > r1) goto L19;
        if (r10 != null) goto L19;
        a(9, r15, this.w);
    L19:
        if (r14 == false) goto L25;
        if (this.l != 0) goto L23;
        a(1, r15, "no message running");
        goto L28
    L23:
        a(9, r3, this.v);
        a(1, r15, "no message running", false, null);
        goto L28
    L25:
        if (this.l != 0) goto L27;
        a(8, r15, this.w, true, r10);
        goto L28
    L27:
        a(9, r3, this.v, false, null);
        a(8, r15, this.w, true, r10);
        goto L28
    }

    private void a(int r8, long r9, String r11) {
        a(r8, r9, r11, true, null);
    }

    private void a(int r5, long r6, String r8, boolean r9, com.bytedance.monitor.collector.service.c r10) {
        this.A = true;
        e r7 = this.p.a(r5);
        r7.f = r6 - this.r;
        if (r9 == false) goto L5;
        long r0 = SystemClock.currentThreadTimeMillis();
        r7.g = r0 - this.u;
        this.u = r0;
    L6:
        r7.f8987e = this.l;
        r7.i = r8;
        r7.j = this.v;
        r7.f8983a = this.r;
        r7.f8984b = r6;
        r7.f8985c = this.s;
        if (r10 == null) goto L9;
        r7.h = r10;
    L9:
        this.p.a(r7);
        this.l = 0;
        this.r = r6;
        return;
    L5:
        r7.g = -1;
        goto L6
    }

    public e e() {
        f r0 = this.p;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.A == true) goto L9;
        return null;
    L9:
        if (r0.a().f8986d == 8) goto L12;
        return null;
    L12:
        return this.p.a();
    }

    @Override // com.bytedance.monitor.collector.b
    void a() {
        super.a();
        d();
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> c() {
        return new Pair(this.f8950a, f());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> a(long r1, long r3) {
        return new Pair(this.f8950a, f());
    L4:
        return null;
    }

    public JSONObject f() {
        long r0 = SystemClock.uptimeMillis();
        JSONObject r2 = new JSONObject();
        JSONArray r3 = h();
        JSONObject r4 = a(r0);
        JSONArray r1 = a(100, r0);
        r2.put("history_message", r3);     // Catch: JSONException -> L5
        r2.put("current_message", r4);     // Catch: JSONException -> L5
        r2.put("pending_messages", r1);     // Catch: JSONException -> L5
        r2.put("check_time_info", g());     // Catch: JSONException -> L5
    L4:
        return r2;
    }

    public JSONArray g() {
        b r0 = this.q;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b();
    }

    public JSONArray h() {
        JSONArray r0 = new JSONArray();
        List<e> r5 = this.p.b();     // Catch: Throwable -> L15
        if (r5 != null) goto L6;
        return r0;
    L6:
        int r1 = 0;
        Iterator<e> r6 = r5.iterator();     // Catch: Throwable -> L15
    L8:
        if (r6.hasNext() == false) goto L14;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r6.next(), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        r1 = r1 + 1;     // Catch: Throwable -> L15
        r0.put(r2.a().put(DbHelper.COL_ID, r1));     // Catch: Throwable -> L15
    L14:
        return r0;
    }

    private JSONObject a(long r7) {
        JSONObject r0 = new JSONObject();
        r0.put("message", this.w);     // Catch: Throwable -> L5
        r0.put("currentMessageCost", r7 - this.s);     // Catch: Throwable -> L5
        r0.put("currentMessageCpu", l.c(this.t) - this.u);     // Catch: Throwable -> L5
        r0.put("messageCount", this.l);     // Catch: Throwable -> L5
        r0.put("start", this.s);     // Catch: Throwable -> L5
        r0.put("end", r7);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    private JSONArray a(int r7, long r8) {
        MessageQueue r6 = i.a();
        JSONArray r0 = new JSONArray();
        if (r6 != null) goto L24;
        return r0;
    L24:
        monitor-enter(r6);     // Catch: Throwable -> L21
        Message r1 = i.a(r6);     // Catch: Throwable -> L18
        if (r1 != null) goto L10;
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L10:
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r1 == null) goto L16;
        if (r2 >= r7) goto L16;
        r2 = r2 + 1;     // Catch: Throwable -> L18
        r3 = r3 + 1;     // Catch: Throwable -> L18
        JSONObject r4 = a(r1, r8);     // Catch: Throwable -> L18
        r4.put(DbHelper.COL_ID, r3);     // Catch: JSONException -> L22 Throwable -> L18
    L15:
        r0.put(r4);     // Catch: Throwable -> L18
        r1 = i.a(r1);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);     // Catch: Throwable -> L18
        return r0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        return r0;
    }

    private static JSONObject a(Message r3, long r4) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L20;
        return r0;
    L20:
        r0.put("when", r3.getWhen() - r4);     // Catch: JSONException -> L17
        if (r3.getCallback() == null) goto L8;
        r0.put("callback", String.valueOf(r3.getCallback()));     // Catch: JSONException -> L17
    L8:
        r0.put("what", r3.what);     // Catch: JSONException -> L17
        if (r3.getTarget() == null) goto L11;
        r0.put("target", String.valueOf(r3.getTarget()));     // Catch: JSONException -> L17
    L12:
        r0.put("arg1", r3.arg1);     // Catch: JSONException -> L17
        r0.put("arg2", r3.arg2);     // Catch: JSONException -> L17
        if (r3.obj == null) goto L15;
        r0.put("obj", String.valueOf(r3.obj));     // Catch: JSONException -> L17
    L15:
        r0.put("start", r3.getWhen());     // Catch: JSONException -> L17
        r0.put("end", -1);     // Catch: JSONException -> L17
    L19:
        return r0;
    L11:
        r0.put("barrier", r3.arg1);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
