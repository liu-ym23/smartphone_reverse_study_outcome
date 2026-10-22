package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LooperDispatchMonitor extends AbsMonitor {
    public static volatile IStackTracer A;
    public static int[] B;
    public static int[] C;
    public static int D;
    public static boolean E;
    public static boolean F;
    public static boolean G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f7736y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f7737z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameCallback f7738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f7740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f7743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f7744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f7746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f7748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f7749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f7750r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g5.a f7751s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f7752t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7753u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d2.d f7754v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile boolean f7755w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Runnable f7756x;

    public interface FrameCallback {
        void doFrame(long[] r10);
    }

    public class a implements FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LooperDispatchMonitor f7757a;

        public a(LooperDispatchMonitor r10) {
            this.f7757a = r10;
        }

        @Override // com.bytedance.monitor.collector.LooperDispatchMonitor.FrameCallback
        public void doFrame(long[] r10) {
            if (LooperDispatchMonitor.g(this.f7757a) == true) goto L6;
            return;
        L6:
            if (LooperDispatchMonitor.h(this.f7757a) != null) goto L8;
            return;
        L8:
            h r11 = LooperDispatchMonitor.h(this.f7757a).c();
            if (r11 != null) goto L11;
            return;
        L11:
            if (r11.f7788d != 8) goto L19;
            g r12 = new g();
            if (r10 == null) goto L16;
            r12.f7780a = r10[1];
            r12.f7781b = r10[5];
            r12.f7782c = r10[6];
            r12.f7783d = r10[7];
            r12.f7784e = r10[8];
        L16:
            r11.f7799o = r12;
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7762e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LooperDispatchMonitor f7763f;

        public b(LooperDispatchMonitor r10) {
            this.f7763f = r10;
            this.f7758a = 0;
            this.f7760c = -1;
            this.f7761d = 0;
            this.f7762e = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = SystemClock.uptimeMillis();
            e r11 = LooperDispatchMonitor.p(this.f7763f).c();
            if (this.f7760c != LooperDispatchMonitor.q(this.f7763f)) goto L5;
            this.f7761d++;
        L6:
            this.f7760c = LooperDispatchMonitor.q(this.f7763f);
            int r12 = this.f7761d;
            if (r12 > 0) goto L9;
        L21:
            r11.f7773d = LooperDispatchMonitor.t(this.f7763f);
            r11.f7772c = (r10 - this.f7758a) - ((long) LooperDispatchMonitor.x());
            r11.f7770a = r10;
            long r13 = SystemClock.uptimeMillis();
            this.f7758a = r13;
            r11.f7771b = r13 - r10;
            r11.f7774e = LooperDispatchMonitor.q(this.f7763f);
            LooperDispatchMonitor.j(this.f7763f).g(LooperDispatchMonitor.i(this.f7763f), LooperDispatchMonitor.x());
            LooperDispatchMonitor.p(this.f7763f).a(r11);
            return;
        L9:
            if ((r12 - this.f7762e) < LooperDispatchMonitor.r()) goto L21;
            if (this.f7758a == 0) goto L21;
            if ((r10 - this.f7759b) < LooperDispatchMonitor.s()) goto L21;
            if (LooperDispatchMonitor.t(this.f7763f) == false) goto L21;
            if (LooperDispatchMonitor.v() == null) goto L19;
            r11.f7775f = LooperDispatchMonitor.w(this.f7763f).getStackTrace(Looper.getMainLooper().getThread());
        L20:
            this.f7762e = this.f7761d;
            goto L21
        L19:
            r11.f7775f = g5.h.c(Looper.getMainLooper().getThread().getStackTrace());
            goto L20
        L5:
            this.f7761d = 0;
            this.f7762e = 0;
            this.f7759b = r10;
            goto L6
        }
    }

    public class c extends g5.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LooperDispatchMonitor f7764d;

        public c(LooperDispatchMonitor r10) {
            this.f7764d = r10;
        }

        @Override // g5.a
        public void b(String r10, Message r11) {
            super.b(r10, r11);
            LooperDispatchMonitor.n(this.f7764d);
            LooperDispatchMonitor.m(this.f7764d, false, g5.a.f19916b);
            LooperDispatchMonitor r12 = this.f7764d;
            LooperDispatchMonitor.o(r12, LooperDispatchMonitor.k(r12));
            LooperDispatchMonitor.l(this.f7764d, "no message running");
            LooperDispatchMonitor.u(this.f7764d, false);
        }

        @Override // g5.a
        public void c(String r10) {
            LooperDispatchMonitor.u(this.f7764d, true);
            LooperDispatchMonitor.l(this.f7764d, r10);
            super.c(r10);
            LooperDispatchMonitor.m(this.f7764d, true, g5.a.f19916b);
        }

        @Override // g5.a
        public boolean d() {
            return true;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f7767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LooperDispatchMonitor f7769e;

        public d(LooperDispatchMonitor r10, boolean r11, long r12, long r13, String r14) {
            this.f7769e = r10;
            this.f7765a = r11;
            this.f7766b = r12;
            this.f7767c = r13;
            this.f7768d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            IHyperMonitor.ILogInstance r10 = PerfMonitorManager.o().q();
            if (r10 != null) goto L6;
            return;
        L6:
            if (this.f7765a == false) goto L8;
            r10.i(this.f7769e.f7705a, this.f7766b + "," + this.f7767c + ",B|" + g5.h.b(this.f7768d));
            return;
        L8:
            r10.i(this.f7769e.f7705a, this.f7766b + "," + this.f7767c + ",E");
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f7775f;

        public e() {
        }

        public void a() {
            this.f7770a = -1;
            this.f7771b = -1;
            this.f7772c = -1;
            this.f7774e = -1;
            this.f7775f = null;
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("startTime", this.f7770a);     // Catch: JSONException -> L5
            r10.put("cost", this.f7771b);     // Catch: JSONException -> L5
            r10.put("delay", this.f7772c);     // Catch: JSONException -> L5
            r10.put("isMessage", String.valueOf(this.f7773d));     // Catch: JSONException -> L5
            r10.put("seqNum", this.f7774e);     // Catch: JSONException -> L5
            r10.put("stack", this.f7775f);     // Catch: JSONException -> L5
        L7:
            return r10;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public /* synthetic */ e(a r10) {
            this();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f7778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f7779d;

        public f(int r10) {
            this.f7777b = 0;
            this.f7776a = r10;
            this.f7779d = new ArrayList(r10);
        }

        public void a(e r10) {
            int r11 = this.f7779d.size();
            int r12 = this.f7776a;
            if (r11 >= r12) goto L5;
            this.f7779d.add(r10);
            this.f7777b = this.f7779d.size();
            return;
        L5:
            int r13 = this.f7777b % r12;
            this.f7777b = r13;
            e r14 = (e) this.f7779d.set(r13, r10);
            r14.a();
            this.f7778c = r14;
            this.f7777b++;
        }

        public JSONArray b() {
            JSONArray r10 = new JSONArray();
            int r11 = 0;
            if (this.f7779d.size() != this.f7776a) goto L12;
            int r12 = this.f7777b - 1;
        L6:
            if (r12 >= this.f7779d.size()) goto L9;
            r10.put(((e) this.f7779d.get(r12)).b());
            r12 = r12 + 1;
        L9:
            if (r11 >= (this.f7777b - 1)) goto L14;
            r10.put(((e) this.f7779d.get(r11)).b());
            r11 = r11 + 1;
        L14:
            return r10;
        L12:
            if (r11 >= this.f7779d.size()) goto L14;
            r10.put(((e) this.f7779d.get(r11)).b());
            r11 = r11 + 1;
            goto L12
        }

        public e c() {
            e r10 = this.f7778c;
            a r11 = null;
            if (r10 == null) goto L6;
            this.f7778c = null;
            return r10;
        L6:
            return new e(r11);
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f7783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f7784e;

        public g() {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f7790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f7791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public h5.c f7792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f7793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f7794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public StackTraceElement[] f7795k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public StackTraceElement[] f7796l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f7797m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f7798n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public g f7799o;

        public h() {
        }

        public final void a(JSONObject r10) {
            StackTraceElement[] r11 = this.f7795k;
            if (r11 == null) goto L5;
            r10.put("block_stack", g5.h.c(r11));
        L5:
            r10.put("block_uuid", this.f7798n);
            StackTraceElement[] r12 = this.f7796l;
            if (r12 == null) goto L8;
            r10.put("sblock_stack", g5.h.c(r12));
        L8:
            r10.put("sblock_uuid", this.f7798n);
            if (TextUtils.isEmpty(this.f7797m) == false) goto L12;
            r10.put("evil_msg", this.f7797m);
        L12:
            if (this.f7799o == null) goto L14;
            boolean r13 = true;
        L15:
            r10.put("belong_frame", r13);
            g r14 = this.f7799o;
            if (r14 == null) goto L18;
            r10.put("vsyncDelayTime", this.f7787c - (r14.f7780a / BatteryFactorConfig.WIFI_BPS));
            r10.put("doFrameTime", (this.f7799o.f7781b / BatteryFactorConfig.WIFI_BPS) - this.f7787c);
            g r15 = this.f7799o;
            r10.put("inputHandlingTime", (r15.f7782c / BatteryFactorConfig.WIFI_BPS) - (r15.f7781b / BatteryFactorConfig.WIFI_BPS));
            g r16 = this.f7799o;
            r10.put("animationsTime", (r16.f7783d / BatteryFactorConfig.WIFI_BPS) - (r16.f7782c / BatteryFactorConfig.WIFI_BPS));
            g r17 = this.f7799o;
            r10.put("performTraversalsTime", (r17.f7784e / BatteryFactorConfig.WIFI_BPS) - (r17.f7783d / BatteryFactorConfig.WIFI_BPS));
            r10.put("drawTime", this.f7786b - (this.f7799o.f7784e / BatteryFactorConfig.WIFI_BPS));
        L18:
            h5.c r18 = this.f7792h;
            if (r18 == null) goto L22;
            r10.put("service_name", r18.f20340a);
            r10.put("service_what", this.f7792h.f20341b);
            r10.put("service_time", this.f7792h.f20342c);
            r10.put("service_thread", this.f7792h.f20344e);
            r10.put("service_token", this.f7792h.f20343d);
            return;
        L22:
            return;
        L14:
            r13 = false;
            goto L15
        }

        public boolean b() {
            if ((this.f7786b - this.f7787c) <= 17) goto L5;
            return true;
        L5:
            if (this.f7790f > 400) goto L22;
            int r10 = this.f7789e;
            if (r10 <= 300) goto L10;
            return true;
        L10:
            if (r10 >= 20) goto L13;
            return true;
        L13:
            if (this.f7788d != 1) goto L16;
            return true;
        L16:
            if (this.f7791g < 20) goto L24;
            return false;
        L24:
            return true;
        L22:
            return true;
        }

        public void c() {
            this.f7788d = -1;
            this.f7789e = -1;
            this.f7790f = -1;
            this.f7793i = null;
            this.f7795k = null;
            this.f7796l = null;
            this.f7797m = null;
            this.f7798n = null;
            this.f7799o = null;
            this.f7792h = null;
            this.f7794j = null;
        }

        public JSONObject d() {
            JSONObject r10 = new JSONObject();
            r10.put("msg", g5.h.b(this.f7793i));     // Catch: JSONException -> L5
            r10.put("cpuDuration", this.f7791g);     // Catch: JSONException -> L5
            r10.put("duration", this.f7790f);     // Catch: JSONException -> L5
            r10.put("type", this.f7788d);     // Catch: JSONException -> L5
            r10.put("messageCount", this.f7789e);     // Catch: JSONException -> L5
            r10.put("lastDuration", this.f7786b - this.f7787c);     // Catch: JSONException -> L5
            r10.put("start", this.f7785a);     // Catch: JSONException -> L5
            r10.put("end", this.f7786b);     // Catch: JSONException -> L5
            a(r10);     // Catch: JSONException -> L5
        L7:
            return r10;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public String e() {
            return "msg:" + g5.h.b(this.f7793i) + ",cpuDuration:" + this.f7791g + ",duration:" + this.f7790f + ",type:" + this.f7788d + ",messageCount:" + this.f7789e + ",lastDuration:" + (this.f7786b - this.f7787c) + ",start:" + this.f7785a + ",end:" + this.f7786b;
        }

        public void f(String r10, StackTraceElement[] r11, StackTraceElement[] r12, String r13) {
            if (TextUtils.isEmpty(r10) == true) goto L5;
            this.f7798n = r10;
        L5:
            if (r11 == null) goto L7;
            this.f7795k = r11;
        L7:
            if (r12 == null) goto L10;
            this.f7796l = r12;
        L10:
            if (TextUtils.isEmpty(r13) == true) goto L13;
            this.f7797m = r13;
            return;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f7802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f7803d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f7804a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f7805b;

            public a(i r10, String r11) {
                this.f7805b = r10;
                this.f7804a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                s1.a.b("block_looper_info", this.f7804a);
            }
        }

        public i(int r10) {
            this.f7803d = new ArrayList();
            this.f7800a = r10;
        }

        public void a(h r10) {
            int r11 = this.f7803d.size();
            int r12 = this.f7800a;
            if (r11 >= r12) goto L5;
            this.f7803d.add(r10);
            this.f7801b = this.f7803d.size();
        L7:
            if (s1.a.e() == true) goto L9;
            return;
        L9:
            if (r10.b() == false) goto L13;
            AsyncEventManager.e().h(new a(this, r10.e()));
            return;
        L13:
            return;
        L5:
            int r13 = this.f7801b % r12;
            this.f7801b = r13;
            h r14 = (h) this.f7803d.set(r13, r10);
            r14.c();
            this.f7802c = r14;
            this.f7801b++;
            goto L7
        }

        public List b() {
            ArrayList r10 = new ArrayList();
            int r11 = 0;
            if (this.f7803d.size() != this.f7800a) goto L12;
            int r12 = this.f7801b - 1;
        L6:
            if (r12 >= this.f7803d.size()) goto L9;
            r10.add((h) this.f7803d.get(r12));
            r12 = r12 + 1;
        L9:
            if (r11 >= (this.f7801b - 1)) goto L14;
            r10.add((h) this.f7803d.get(r11));
            r11 = r11 + 1;
        L14:
            return r10;
        L12:
            if (r11 >= this.f7803d.size()) goto L14;
            r10.add(this.f7803d.get(r11));
            r11 = r11 + 1;
            goto L12
        }

        public h c() {
            int r10 = this.f7801b;
            if (r10 > 0) goto L7;
            return null;
        L7:
            return (h) this.f7803d.get(r10 - 1);
        }

        public h d(int r10) {
            h r11 = this.f7802c;
            if (r11 == null) goto L5;
            r11.f7788d = r10;
            this.f7802c = null;
            return r11;
        L5:
            h r12 = new h();
            r12.f7788d = r10;
            return r12;
        }
    }

    static {
        B = new int[]{600, 300};
        C = new int[]{200, 100};
        E = false;
        F = false;
        G = false;
    }

    public LooperDispatchMonitor(int r10, boolean r11) {
        super(r10, "block_looper_info");
        this.f7739g = 0;
        this.f7740h = 0;
        this.f7741i = 100;
        this.f7742j = 200;
        this.f7745m = -1;
        this.f7746n = -1;
        this.f7747o = -1;
        this.f7748p = -1;
        this.f7752t = false;
        this.f7753u = false;
        this.f7755w = false;
        this.f7756x = new b(this);
        h5.d.c().e();
        this.f7738f = new a(this);
        if (r11 == false) goto L5;
    L8:
        d2.d r12 = new d2.d("looper_monitor__");
        this.f7754v = r12;
        r12.k();
        y();
        this.f7744l = new f(300);
        r12.g(this.f7756x, f7736y);
        return;
    L5:
        if (E == true) goto L8;
        this.f7754v = null;
    }

    public static JSONObject K(Message r10, long r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != null) goto L21;
        return r12;
    L21:
        r12.put("when", r10.getWhen() - r11);     // Catch: JSONException -> L8
        if (r10.getCallback() == null) goto L10;
        r12.put("callback", String.valueOf(r10.getCallback()));     // Catch: JSONException -> L8
    L10:
        r12.put("what", r10.what);     // Catch: JSONException -> L8
        if (r10.getTarget() == null) goto L13;
        r12.put("target", String.valueOf(r10.getTarget()));     // Catch: JSONException -> L8
    L14:
        r12.put("arg1", r10.arg1);     // Catch: JSONException -> L8
        r12.put("arg2", r10.arg2);     // Catch: JSONException -> L8
        Object r13 = r10.obj;     // Catch: JSONException -> L8
        if (r13 == null) goto L17;
        r12.put("obj", String.valueOf(r13));     // Catch: JSONException -> L8
    L17:
        r12.put("start", r10.getWhen());     // Catch: JSONException -> L8
        r12.put("end", -1);     // Catch: JSONException -> L8
    L20:
        return r12;
    L13:
        r12.put("barrier", r10.arg1);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public static /* synthetic */ boolean g(LooperDispatchMonitor r10) {
        return r10.f7753u;
    }

    public static /* synthetic */ i h(LooperDispatchMonitor r10) {
        return r10.f7743k;
    }

    public static /* synthetic */ Runnable i(LooperDispatchMonitor r10) {
        return r10.f7756x;
    }

    public static /* synthetic */ d2.d j(LooperDispatchMonitor r10) {
        return r10.f7754v;
    }

    public static /* synthetic */ String k(LooperDispatchMonitor r10) {
        return r10.f7750r;
    }

    public static /* synthetic */ String l(LooperDispatchMonitor r10, String r11) {
        r10.f7750r = r11;
        return r11;
    }

    public static /* synthetic */ void m(LooperDispatchMonitor r10, boolean r11, long r12) {
        r10.G(r11, r12);
    }

    public static /* synthetic */ int n(LooperDispatchMonitor r10) {
        int r11 = r10.f7739g;
        r10.f7739g = r11 + 1;
        return r11;
    }

    public static /* synthetic */ String o(LooperDispatchMonitor r10, String r11) {
        r10.f7749q = r11;
        return r11;
    }

    public static /* synthetic */ f p(LooperDispatchMonitor r10) {
        return r10.f7744l;
    }

    public static /* synthetic */ int q(LooperDispatchMonitor r10) {
        return r10.f7740h;
    }

    public static /* synthetic */ int r() {
        return D;
    }

    public static /* synthetic */ int s() {
        return f7737z;
    }

    public static /* synthetic */ boolean t(LooperDispatchMonitor r10) {
        return r10.f7755w;
    }

    public static /* synthetic */ boolean u(LooperDispatchMonitor r10, boolean r11) {
        r10.f7755w = r11;
        return r11;
    }

    public static /* synthetic */ IStackTracer v() {
        return A;
    }

    public static /* synthetic */ IStackTracer w(LooperDispatchMonitor r10) {
        return r10.F();
    }

    public static /* synthetic */ int x() {
        return f7736y;
    }

    public final JSONObject A(long r10) {
        JSONObject r11 = new JSONObject();
        r11.put("message", this.f7750r);     // Catch: Throwable -> L5
        r11.put("currentMessageCost", r10 - this.f7746n);     // Catch: Throwable -> L5
        r11.put("currentMessageCpu", g5.e.h(this.f7747o) - this.f7748p);     // Catch: Throwable -> L5
        r11.put("messageCount", this.f7739g);     // Catch: Throwable -> L5
        r11.put("start", this.f7746n);     // Catch: Throwable -> L5
        r11.put("end", r10);     // Catch: Throwable -> L5
    L4:
        return r11;
    }

    public JSONArray B() {
        JSONArray r10 = new JSONArray();
        List r11 = this.f7743k.b();     // Catch: Throwable -> L15
        if (r11 != null) goto L6;
        return r10;
    L6:
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L15
        int r13 = 0;
    L8:
        if (r12.hasNext() == false) goto L14;
        h r14 = (h) r12.next();     // Catch: Throwable -> L15
        if (r14 == null) goto L8;
        r13 = r13 + 1;     // Catch: Throwable -> L15
        r10.put(r14.d().put("id", r13));     // Catch: Throwable -> L15
    L14:
        return r10;
    }

    public JSONObject C() {
        long r10 = SystemClock.uptimeMillis();
        JSONObject r11 = new JSONObject();
        JSONArray r12 = B();
        JSONObject r13 = A(r10);
        JSONArray r14 = D(100, r10);
        r11.put("history_message", r12);     // Catch: JSONException -> L5
        r11.put("current_message", r13);     // Catch: JSONException -> L5
        r11.put("pending_messages", r14);     // Catch: JSONException -> L5
        r11.put("check_time_info", z());     // Catch: JSONException -> L5
    L4:
        return r11;
    }

    public final JSONArray D(int r10, long r11) {
        MessageQueue r12 = g5.c.a();
        JSONArray r13 = new JSONArray();
        if (r12 != null) goto L25;
        return r13;
    L25:
        monitor-enter(r12);     // Catch: Throwable -> L22
        Message r14 = g5.c.b(r12);     // Catch: Throwable -> L10
        if (r14 != null) goto L12;
        monitor-exit(r12);     // Catch: Throwable -> L10
        return r13;
    L12:
        int r15 = 0;
        int r16 = 0;
    L13:
        if (r14 == null) goto L18;
        if (r15 >= r10) goto L18;
        r15 = r15 + 1;     // Catch: Throwable -> L10
        r16 = r16 + 1;     // Catch: Throwable -> L10
        JSONObject r17 = K(r14, r11);     // Catch: Throwable -> L10
        r17.put("id", r16);     // Catch: Throwable -> L10 JSONException -> L23
    L17:
        r13.put(r17);     // Catch: Throwable -> L10
        r14 = g5.c.c(r14);     // Catch: Throwable -> L10
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        return r13;
    }

    public h E() {
        i r10 = this.f7743k;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.f7753u == true) goto L9;
        return null;
    L9:
        if (r10.c().f7788d == 8) goto L12;
        return null;
    L12:
        return this.f7743k.c();
    }

    public final IStackTracer F() {
        return A;
    }

    public final void G(boolean r14, long r15) {
        int r10 = this.f7740h + 1;
        this.f7740h = r10;
        this.f7740h = r10 & SupportMenu.USER_MASK;
        this.f7753u = false;
        if (this.f7745m >= 0) goto L6;
        this.f7745m = r15;
    L6:
        if (this.f7746n >= 0) goto L9;
        this.f7746n = r15;
    L9:
        if (this.f7747o >= 0) goto L11;
        this.f7747o = Process.myTid();
        this.f7748p = SystemClock.currentThreadTimeMillis();
    L11:
        h5.c r11 = h5.d.b();
        h5.d.a();
        long r12 = r15 - this.f7745m;
        int r13 = this.f7742j;
        if (r12 > r13) goto L14;
        if (r11 != null) goto L14;
    L28:
        this.f7746n = r15;
        String r16 = this.f7750r;
        if (this.f7708d == false) goto L32;
        PerfMonitorManager.o().f7839r.f(new d(this, r14, r15, SystemClock.currentThreadTimeMillis(), r16));
        return;
    L32:
        return;
    L14:
        long r17 = this.f7746n;
        if ((r15 - r17) > r13) goto L19;
        if (r11 != null) goto L19;
        H(9, r15, this.f7750r);
    L19:
        if (r14 == false) goto L25;
        if (this.f7739g != 0) goto L23;
        H(1, r15, "no message running");
        goto L28
    L23:
        H(9, r17, this.f7749q);
        I(1, r15, "no message running", false, null);
        goto L28
    L25:
        if (this.f7739g != 0) goto L27;
        I(8, r15, this.f7750r, true, r11);
        goto L28
    L27:
        I(9, r17, this.f7749q, false, null);
        I(8, r15, this.f7750r, true, r11);
        goto L28
    }

    public final void H(int r10, long r11, String r12) {
        I(r10, r11, r12, true, null);
    }

    public final void I(int r10, long r11, String r12, boolean r13, h5.c r14) {
        this.f7753u = true;
        h r15 = this.f7743k.d(r10);
        r15.f7790f = r11 - this.f7745m;
        if (r13 == false) goto L5;
        long r16 = SystemClock.currentThreadTimeMillis();
        r15.f7791g = r16 - this.f7748p;
        this.f7748p = r16;
    L6:
        r15.f7789e = this.f7739g;
        r15.f7793i = r12;
        r15.f7794j = this.f7749q;
        r15.f7785a = this.f7745m;
        r15.f7786b = r11;
        r15.f7787c = this.f7746n;
        if (r14 == null) goto L9;
        r15.f7792h = r14;
    L9:
        this.f7743k.a(r15);
        this.f7739g = 0;
        this.f7745m = r11;
        return;
    L5:
        r15.f7791g = -1;
        goto L6
    }

    public void J() {
        if (this.f7752t == false) goto L5;
        return;
    L5:
        this.f7752t = true;
        L();
        this.f7743k = new i(this.f7741i);
        c r10 = new c(this);
        this.f7751s = r10;
        LooperMonitor.k(r10);
        g5.c.b(g5.c.a());
    }

    public final void L() {
        int r10 = this.f7707c;
        if (r10 != 0) goto L5;
    L12:
        this.f7741i = 100;
        this.f7742j = 300;
        return;
    L5:
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L9;
    L11:
        this.f7741i = 300;
        this.f7742j = 200;
        return;
    L9:
        if (r10 == 3) goto L11;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair a() {
        return new Pair(this.f7705a, C());
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair b(long r10, long r11) {
        return new Pair(this.f7705a, C());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void d() {
        super.d();
        J();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void f(int r10) {
    }

    public final void y() {
        boolean r10 = G;
        if (r10 == false) goto L5;
    L7:
        if (r10 == false) goto L9;
    L11:
        if (r10 == true) goto L13;
    L15:
        if (r10 == true) goto L17;
        return;
    L17:
        if (F == true) goto L24;
        int r11 = C[0];
        f7736y = r11;
        int r12 = B[1];
        f7737z = r12;
        D = r12 / r11;
        return;
    L24:
        return;
    L13:
        if (F == false) goto L15;
        int r13 = C[1];
        f7736y = r13;
        int r14 = B[1];
        f7737z = r14;
        D = r14 / r13;
        return;
    L9:
        if (F == true) goto L11;
        int r15 = C[0];
        f7736y = r15;
        int r16 = B[0];
        f7737z = r16;
        D = r16 / r15;
        return;
    L5:
        if (F == false) goto L7;
        int r17 = C[1];
        f7736y = r17;
        int r18 = B[0];
        f7737z = r18;
        D = r18 / r17;
    }

    public JSONArray z() {
        f r10 = this.f7744l;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.b();
    }
}
