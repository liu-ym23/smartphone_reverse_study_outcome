package v9;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.util.y;
import com.monitor.cloudmessage.callback.IABTestConsumer;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.callback.ICommandReceiveObserver;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.callback.IPatchConsumer;
import com.monitor.cloudmessage.callback.IPluginConsumer;
import com.monitor.cloudmessage.callback.IRouteConsumer;
import com.monitor.cloudmessage.callback.ITemplateConsumer;
import com.monitor.cloudmessage.handler.IMessageHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import y9.c;
import y9.d;
import y9.e;
import y9.f;
import y9.g;
import y9.h;
import y9.i;
import y9.j;
import y9.k;
import y9.l;
import y9.m;
import y9.n;
import y9.o;
import y9.p;
import y9.q;
import y9.r;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Context f25092g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f25093h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static IPluginConsumer f25094i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IPatchConsumer f25095j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static IABTestConsumer f25096k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static IAlogConsumer f25097l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static IMonitorLogConsumer f25098m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static IRouteConsumer f25099n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static ITemplateConsumer f25100o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f25101p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile boolean f25102q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile String f25103r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile String f25104s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile String f25105t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile String f25106u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile String[] f25107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f25108w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f25109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f25110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f25111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile HashMap f25112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile WeakReference f25113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f25114f;

    /* JADX INFO: renamed from: v9.a$a, reason: collision with other inner class name */
    public class RunnableC0393a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f25116b;

        public RunnableC0393a(a r10, String r11) {
            this.f25116b = r10;
            this.f25115a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f25116b, w9.a.a(this.f25115a));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25117a;

        public b(a r10) {
            this.f25117a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            aa.a.a(a.b());     // Catch: Throwable -> L4
            return;
        }
    }

    static {
    }

    public a() {
        this.f25112d = new HashMap();
        this.f25113e = null;
        this.f25109a = new Vector(10);
        this.f25111c = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        ArrayList r10 = new ArrayList(20);
        r10.add(new f());
        r10.add(new c());
        r10.add(new q());
        r10.add(new j());
        r10.add(new o());
        r10.add(new r());
        r10.add(new d());
        r10.add(new p());
        r10.add(new m());
        r10.add(new h());
        r10.add(new y9.b());
        r10.add(new y9.a());
        r10.add(new l());
        r10.add(new n());
        r10.add(new g());
        r10.add(new i());
        r10.add(new e());
        r10.add(new k());
        this.f25110b = Collections.unmodifiableList(r10);
        o();
        c();
        f25106u = d(f25092g).getAbsolutePath() + "/dump.hprof";     // Catch: Exception -> L5
        return;
    }

    public static /* synthetic */ void a(a r10, w9.a r11) {
        r10.q(r11);
    }

    public static /* synthetic */ Context b() {
        return f25092g;
    }

    public static File d(Context r10) {
        File r11 = new File(r10.getExternalFilesDir(null) + "/monitor");
        if (r11.exists() == true) goto L5;
        r11.mkdir();
    L5:
        return r11;
    }

    public static String f() {
        return f25104s;
    }

    public static String[] g() {
        return f25107v;
    }

    public static String j() {
        return f25106u;
    }

    public static a k() {
        if (f25093h != null) goto L20;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f25093h == null) goto L9;
    L15:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L20
    L9:
        if (f25102q == false) goto L14;
        f25093h = new a();     // Catch: Throwable -> L11
        goto L15
    L14:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L11
    L20:
        return f25093h;
    }

    public static String m() {
        return f25103r;
    }

    public static String n() {
        return f25105t;
    }

    public static void r(Context r10) {
        f25102q = true;
        f25092g = r10.getApplicationContext();
        k();
        if (w0.c.B() == false) goto L6;
        s1.c.b("cloudmessage", new String[]{"CloudMessageManager Init."});
        return;
    }

    public static boolean s() {
        return f25101p;
    }

    public static void v(IAlogConsumer r10) {
        if (f25102q == false) goto L5;
        k().u(r10);
        return;
    L5:
        f25097l = r10;
    }

    public static void x(IMonitorLogConsumer r10) {
        if (f25102q == false) goto L5;
        k().w(r10);
        return;
    L5:
        f25098m = r10;
    }

    public final void A(IRouteConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof o) == false) goto L5;
        ((o) r12).k(r10);
        return;
    L14:
        return;
    }

    public final void B(ITemplateConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof r) == false) goto L5;
        ((r) r12).k(r10);
        return;
    L14:
        return;
    }

    public final void c() {
        this.f25111c.execute(new b(this));
    }

    public void e() {
        f25108w = z1.a.f26274c;
        long r10 = System.currentTimeMillis();
        if ((r10 - this.f25114f) >= 120000) goto L6;
        s1.c.b("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.f25114f = r10;
        String r11 = y.a("https://" + f25108w + "/monitor/collect/c/cloudcontrol/get", w0.c.x());     // Catch: Exception -> L10
        HashMap r12 = new HashMap();     // Catch: Exception -> L10
        r12.put("Content-Type", "application/json");     // Catch: Exception -> L10
        r12.put("Version-Code", "1");     // Catch: Exception -> L10
        r12.put("Accept", "application/json");     // Catch: Exception -> L10
        i6.c r13 = w0.c.d(r11, r3.h.b(new JSONObject().toString()), r12);     // Catch: Exception -> L10
        if (w0.c.B() == false) goto L12;
        s1.c.b("cloudmessage", new String[]{"fetchCommandImmediately: url=" + r11});     // Catch: Exception -> L10
    L12:
        if (r13 != null) goto L16;
        s1.c.b("cloudmessage", new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L10
        return;
    L16:
        if (r13.c() != 200) goto L67;
        JSONObject r14 = new JSONObject(new String(r13.b()));     // Catch: Exception -> L10
        if (w0.c.B() == false) goto L20;
        s1.c.b("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + r14.toString()});     // Catch: Exception -> L10
    L20:
        Map r15 = r13.a();     // Catch: Exception -> L10
        if (r15 != null) goto L23;
    L34:
        String r16 = null;
    L35:
        String r17 = r14.optString("data");     // Catch: Exception -> L10
        if (r17.isEmpty() == true) goto L42;
        if (TextUtils.isEmpty(r16) == true) goto L40;
        r14 = new JSONObject(com.bytedance.apm.util.c.a(r17.getBytes(), r16));     // Catch: Exception -> L10
        goto L42
    L40:
        r14 = new JSONObject(new String(r17.getBytes()));     // Catch: Exception -> L10
    L42:
        if (w0.c.B() == false) goto L45;
        s1.c.b("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + r14});     // Catch: Exception -> L10
    L45:
        if (com.bytedance.apm.util.i.d(r14) == false) goto L47;
        return;
    L47:
        JSONObject r18 = r14.optJSONObject("configs");     // Catch: Exception -> L10
        if (com.bytedance.apm.util.i.d(r18) == false) goto L50;
        return;
    L50:
        JSONArray r19 = r18.optJSONArray("cloud_commands");     // Catch: Exception -> L10
        if (r19 == null) goto L68;
        int r20 = 0;
    L54:
        if (r20 >= r19.length()) goto L69;
        p(r19.optString(r20));     // Catch: Exception -> L10
        r20 = r20 + 1;
        goto L54
    L69:
        return;
    L68:
        return;
    L23:
        if (r15.isEmpty() == true) goto L34;
        r16 = (String) r15.get("ran");     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r16) == false) goto L35;
        Iterator r21 = r15.entrySet().iterator();     // Catch: Throwable -> L59
    L29:
        if (r21.hasNext() == false) goto L35;
        Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L59
        if ("ran".equalsIgnoreCase((String) r22.getKey()) == false) goto L29;
        r16 = (String) r22.getValue();     // Catch: Throwable -> L59
        goto L35
    L67:
        return;
    L10:
        e = move-exception;
        s1.c.f("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
    }

    public HashMap h() {
        return this.f25112d;
    }

    public Context i() {
        return f25092g;
    }

    public Enumeration l() {
        return this.f25109a.elements();
    }

    public final void o() {
        IPluginConsumer r10 = f25094i;
        if (r10 == null) goto L5;
        z(r10);
        f25094i = null;
    L5:
        IPatchConsumer r11 = f25095j;
        if (r11 == null) goto L8;
        y(r11);
        f25095j = null;
    L8:
        IABTestConsumer r12 = f25096k;
        if (r12 == null) goto L11;
        t(r12);
        f25096k = null;
    L11:
        IAlogConsumer r13 = f25097l;
        if (r13 == null) goto L14;
        u(r13);
        f25097l = null;
    L14:
        IMonitorLogConsumer r14 = f25098m;
        if (r14 == null) goto L17;
        w(r14);
        f25098m = null;
    L17:
        IRouteConsumer r15 = f25099n;
        if (r15 == null) goto L20;
        A(r15);
        f25099n = null;
    L20:
        ITemplateConsumer r16 = f25100o;
        if (r16 == null) goto L24;
        B(r16);
        f25100o = null;
        return;
    }

    public void p(String r10) {
        this.f25111c.execute(new RunnableC0393a(this, r10));
    }

    public final void q(w9.a r10) {
        if (w0.c.B() == false) goto L5;
        s1.c.b("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + r10});
    L5:
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.f25113e != null) goto L10;
        ICommandReceiveObserver r11 = null;
    L11:
        if (r11 == null) goto L13;
        r11.notifyCommandReceived(r10);
    L13:
        Iterator r12 = this.f25110b.iterator();
    L15:
        if (r12.hasNext() == false) goto L22;
        if (((IMessageHandler) r12.next()).handleCloudMessage(r10) == false) goto L15;
        return;
    L22:
        return;
    L10:
        r11 = (ICommandReceiveObserver) this.f25113e.get();
        goto L11
    }

    public final void t(IABTestConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof y9.a) == false) goto L5;
        ((y9.a) r12).k(r10);
        return;
    L14:
        return;
    }

    public final void u(IAlogConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof y9.b) == false) goto L5;
        ((y9.b) r12).k(r10);
        return;
    L14:
        return;
    }

    public final void w(IMonitorLogConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof h) == false) goto L5;
        ((h) r12).o(r10);
        return;
    L14:
        return;
    }

    public final void y(IPatchConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof l) == false) goto L5;
        ((l) r12).k(r10);
        return;
    L14:
        return;
    }

    public final void z(IPluginConsumer r10) {
        if (r10 == null) goto L13;
        Iterator r11 = this.f25110b.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        IMessageHandler r12 = (IMessageHandler) r11.next();
        if ((r12 instanceof n) == false) goto L5;
        ((n) r12).k(r10);
        return;
    L14:
        return;
    }
}
