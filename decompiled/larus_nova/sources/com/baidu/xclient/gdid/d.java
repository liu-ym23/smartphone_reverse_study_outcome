package com.baidu.xclient.gdid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.mshield.b.a.g;
import com.baidu.xclient.gdid.d.b;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f33590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f33591b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f33592c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f33593d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f33594e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f33595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicBoolean f33596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f33597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f33598i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f33599a;

        public a(d r100) {
            this.f33599a = r100;
        }

        public void com_baidu_xclient_gdid_d$a__run$___twin___() {
            d.a(this.f33599a);     // Catch: Throwable -> L4
            this.f33599a.a(true, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            com.baidu.xclient.gdid.j.d.a(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_xclient_gdid_d$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_xclient_gdid_d$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_xclient_gdid_d$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements Runnable {
        public b(d r100) {
        }

        public void com_baidu_xclient_gdid_d$b__run$___twin___() {
            h.a().a(d.f33591b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            com.baidu.xclient.gdid.j.d.a(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_xclient_gdid_d$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_xclient_gdid_d$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_baidu_xclient_gdid_d$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f33594e = new HashMap();
    }

    public d() {
        this.f33596g = new AtomicBoolean(false);
        this.f33598i = new ConcurrentHashMap();
    }

    public static d a() {
        if (f33590a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33590a != null) goto L9;
        f33590a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f33590a;
    }

    public static /* synthetic */ void a(d r100) {
        r100.g();
    }

    public Object a(int r100, Object r101, Object r102, Object r103) {
        return com.baidu.xclient.gdid.jni.c.a(f33591b).a(r100, r101, r102, r103);
    }

    public String a(Context r100) {
        String r101 = c("p");     // Catch: Throwable -> L5
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    L8:
        return r100.getPackageName();
    L5:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        goto L8
    }

    public String a(String r100) {
        return com.baidu.xclient.gdid.jni.c.a(f33591b).a(r100);
    }

    public void a(Context r100, String r101, String r102) {
    L7:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return;
    L3:
        if (this.f33596g.get() == false) goto L5;
        return;
    L5:
        f33591b = r100;     // Catch: Throwable -> L7
        f33592c = r101;     // Catch: Throwable -> L7
        f33593d = r102;     // Catch: Throwable -> L7
        i();     // Catch: Throwable -> L7
        this.f33596g.set(true);     // Catch: Throwable -> L7
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "client/gdid/d"));     // Catch: Throwable -> L7
    }

    public void a(Context r100, String r101, String r102, HashMap<String, String> r103) {
        f33591b = r100;
        f33592c = r101;
        f33593d = r102;
        if (r103 == null) goto L12;
        HashMap<String, String> r104 = f33594e;
        monitor-enter(r104);
        r104.putAll(r103);     // Catch: Throwable -> L9
        monitor-exit(r104);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void a(HashMap<String, String> r100) {
        if (r100 == null) goto L25;
    L17:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return;
    L4:
        if (r100.size() == 0) goto L26;
        HashMap<String, String> r101 = f33594e;     // Catch: Throwable -> L17
        monitor-enter(r101);     // Catch: Throwable -> L17
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Throwable -> L14
    L10:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Throwable -> L14
        f33594e.put(r103, r100.get(r103));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
    L27:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L26:
        return;
    }

    public final void a(JSONObject r100) {
        a(r100, "15027", com.baidu.xclient.gdid.b.a.a(f33591b));     // Catch: Throwable -> L4
        a(r100, "15003", com.baidu.mshield.b.b.a.a(f33591b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public final void a(JSONObject r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L15;
        return;
    L15:
    L12:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return;
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        r102 = "";
    L10:
        r100.put(r101, r102);     // Catch: Throwable -> L12
    }

    public final void a(JSONObject r100, StringBuilder r101) {
        a(r100, "15200", "C");     // Catch: Throwable -> L4
        a(r100, "01001", com.baidu.xclient.gdid.j.a.a(f33591b));     // Catch: Throwable -> L4
        a(r100, "15017", (String) com.baidu.xclient.gdid.j.d.c(f33591b).first);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public void a(boolean r100) {
        if (e.e().v() == false) goto L6;
        return;
    L6:
        if (e.e().w() == false) goto L8;
        b(r100);
        return;
    L8:
        long r101 = e.e().h();
        long r102 = e.e().i();
        if ((System.currentTimeMillis() - r101) >= r102) goto L12;
        b(r100);
        return;
    L12:
        f();
    }

    public void a(boolean r100, boolean r101) {
        c.a().a(f33591b);     // Catch: Throwable -> L10
        a(r100);     // Catch: Throwable -> L10
        if (r101 == false) goto L15;
        long r102 = e.e().l();     // Catch: Throwable -> L10
        long r103 = e.e().m();     // Catch: Throwable -> L10
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L10
        long r105 = r104 - r102;     // Catch: Throwable -> L10
        if (r105 < r103) goto L7;
        e.e().e(r104);     // Catch: Throwable -> L10
    L8:
        com.baidu.xclient.gdid.d.a.a(f33591b, r103);     // Catch: Throwable -> L10
        return;
    L7:
        r103 = r103 - r105;     // Catch: Throwable -> L10
        goto L8
    L15:
        return;
    L10:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public String b(String r100) {
        return com.baidu.xclient.gdid.jni.c.a(f33591b).d(r100);
    }

    public void b() {
        h();     // Catch: Throwable -> L4
        this.f33596g.set(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public final void b(JSONObject r100) {
        r100.put("12006", com.baidu.mshield.b.e.a.c(f33591b, "screen_brightness"));     // Catch: Throwable -> L5
        return;
    L14:
        r100.put("12006", -1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public final void b(JSONObject r100, StringBuilder r101) {
        a(r100, "02018", com.baidu.xclient.gdid.j.c.a("02018", c("arid"), r101));     // Catch: Throwable -> L42
        r100.put("02015", c("arv"));     // Catch: Throwable -> L42
        r100.put("02016", c("arl"));     // Catch: Throwable -> L42
        r100.put("02002", com.baidu.xclient.gdid.jni.c.a(f33591b).f());     // Catch: Throwable -> L42
        r100.put("02003", c("mod"));     // Catch: Throwable -> L42
        r100.put("02004", com.baidu.xclient.gdid.jni.c.a(f33591b).k());     // Catch: Throwable -> L42
        r100.put("02005", com.baidu.xclient.gdid.jni.c.a(f33591b).j());     // Catch: Throwable -> L42
        r100.put("02006", com.baidu.xclient.gdid.jni.c.a(f33591b).i());     // Catch: Throwable -> L42
        r100.put("02007", com.baidu.xclient.gdid.jni.c.a(f33591b).h());     // Catch: Throwable -> L42
        r100.put("02008", com.baidu.xclient.gdid.jni.c.a(f33591b).g());     // Catch: Throwable -> L42
        r100.put("15023", com.baidu.xclient.gdid.i.a.a());     // Catch: Throwable -> L42
        r100.put("15021", com.baidu.xclient.gdid.i.a.c());     // Catch: Throwable -> L42
        r100.put("15020", com.baidu.xclient.gdid.i.a.b());     // Catch: Throwable -> L42
        r100.put("15022", com.baidu.xclient.gdid.i.a.d());     // Catch: Throwable -> L42
        String r102 = g.b(f33591b);     // Catch: Throwable -> L42
        String r103 = g.c(f33591b);     // Catch: Throwable -> L42
        r100.put("15029", r102);     // Catch: Throwable -> L42
        r100.put("15030", r103);     // Catch: Throwable -> L42
        a(r100, "15048", com.baidu.xclient.gdid.jni.b.a(f33591b).a());     // Catch: Throwable -> L42
        if (com.baidu.mshield.b.a.e.c() == false) goto L16;
        String r104 = "1";
    L15:
        a(r100, "p", r104);     // Catch: Throwable -> L42
        a(r100, "s", com.baidu.xclient.gdid.jni.c.a(f33591b).a());     // Catch: Throwable -> L42
        a(r100, "11005", String.valueOf(com.baidu.mshield.b.a.e.b()));     // Catch: Throwable -> L42
        String r105 = com.baidu.mshield.b.a.e.a();     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r105) == false) goto L24;
    L29:
        a(r100, "11003", r105);     // Catch: Throwable -> L42
        a(r100, "02010", com.baidu.xclient.gdid.i.a.a(f33591b));     // Catch: Throwable -> L42
        a(r100, "02012", com.baidu.xclient.gdid.i.a.b(f33591b));     // Catch: Throwable -> L42
        a(r100, "02059", com.baidu.xclient.gdid.jni.c.a(f33591b).e());     // Catch: Throwable -> L42
        com.baidu.xclient.gdid.j.e r106 = new com.baidu.xclient.gdid.j.e();     // Catch: Throwable -> L32
        r106.a(10, 10);     // Catch: Throwable -> L32
        String r107 = r106.f33632f.glGetString(7937);     // Catch: Throwable -> L32
        a(r100, "20081", r106.f33632f.glGetString(7936));     // Catch: Throwable -> L32
        a(r100, "20082", r107);     // Catch: Throwable -> L32
        r106.b();     // Catch: Throwable -> L32
    L34:
        a(r100, "12001", com.baidu.xclient.gdid.i.a.c(f33591b));     // Catch: Throwable -> L42
        a(r100, "12007", String.valueOf(com.baidu.xclient.gdid.i.a.d(f33591b)));     // Catch: Throwable -> L42
        a(r100, "06011", String.valueOf(com.baidu.xclient.gdid.i.a.e(f33591b)));     // Catch: Throwable -> L42
        a(r100, "06012", String.valueOf(com.baidu.xclient.gdid.i.a.f(f33591b) ? 1 : 0));     // Catch: Throwable -> L42
        return;
    L32:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);     // Catch: Throwable -> L42
        goto L34
    L24:
        if (r105.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == true) goto L27;
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L42
        String r109 = "32 ";
    L26:
        r108.append(r109);     // Catch: Throwable -> L42
        r108.append(r105);     // Catch: Throwable -> L42
        r105 = r108.toString();     // Catch: Throwable -> L42
        goto L29
    L27:
        r108 = new StringBuilder();     // Catch: Throwable -> L42
        r109 = "64 ";
        goto L26
    L16:
        r104 = "0";
    L42:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        com.baidu.xclient.gdid.j.b.b().postDelayed(new b(this), 65000);
        return;
    L4:
        h.a().a(f33591b);
    }

    public String c(String r100) {
        HashMap<String, String> r101 = f33594e;     // Catch: Throwable -> L15
        if (r101.size() <= 0) goto L21;
        monitor-enter(r101);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L6:
        if (r101.containsKey(r100) == false) goto L10;
        String r102 = r101.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return "";
    L21:
        return "";
    L15:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return "";
    }

    public JSONObject c() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L6
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L6
        a(r100, r101);     // Catch: Throwable -> L6
        a(r100);     // Catch: Throwable -> L6
        b(r100, r101);     // Catch: Throwable -> L6
        b(r100);     // Catch: Throwable -> L6
        r100.put("15057", r101);     // Catch: Throwable -> L6
        r100.put("15006", TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(f33591b).a()) ? 1 : 0);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return null;
    }

    public synchronized String[] d() {
        monitor-enter(this);
        String[] r100 = {"", ""};     // Catch: Throwable -> L10
        String r101 = this.f33597h;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r101) == false) goto L7;
        monitor-exit(this);
        return r100;
    L7:
        String r102 = this.f33598i.get(r101);     // Catch: Throwable -> L10
        r100[0] = r101;     // Catch: Throwable -> L10
        r100[1] = r102;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public String e() {
        return "";
    }

    public final void f() {
    L16:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return;
    L3:
        if (com.baidu.xclient.gdid.j.d.a(f33591b) == true) goto L6;
        return;
    L6:
        if (com.baidu.mshield.b.e.a.d(f33591b) == true) goto L8;
        return;
    L8:
        JSONObject r100 = c();     // Catch: Throwable -> L16
        if (r100 != null) goto L11;
        return;
    L11:
        JSONObject r101 = com.baidu.xclient.gdid.j.d.a(f33591b, r100, "1072101");     // Catch: Throwable -> L16
        if (new com.baidu.xclient.gdid.g.a(f33591b, null).a(r101.toString()) == false) goto L14;
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L16
        e.e().g(r102);     // Catch: Throwable -> L16
        e.e().c(r102);     // Catch: Throwable -> L16
    L19:
        return;
    L14:
        h.a().a(f33591b);     // Catch: Throwable -> L16
        goto L19
    }

    public final void g() {
        this.f33595f = new b();     // Catch: Throwable -> L11
        IntentFilter r100 = new IntentFilter();     // Catch: Throwable -> L11
        r100.addAction(b.f33603a);     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT >= 33) goto L14;
        INVOKEVIRTUAL_com_baidu_xclient_gdid_d_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(f33591b, this.f33595f, r100);     // Catch: Throwable -> L11
    L16:
        return;
    L14:
        INVOKEVIRTUAL_com_baidu_xclient_gdid_d_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(f33591b, this.f33595f, r100, 4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public final void h() {
        INVOKEVIRTUAL_com_baidu_xclient_gdid_d_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(f33591b, this.f33595f);     // Catch: Throwable -> L4
        this.f33595f = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }

    public final void i() {
        String r100 = e.e().p();
        String r101 = e.e().u();
        e.e().t();
        if (TextUtils.isEmpty(r101) == false) goto L12;
        JSONObject r102 = new JSONObject();
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        this.f33598i.put(r100, r102.toString());
        this.f33597h = r100;
        return;
    L14:
        return;
    L12:
        r102 = new JSONObject(r101);     // Catch: JSONException -> L7
    L7:
        r102 = new JSONObject();
        goto L9
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_baidu_xclient_gdid_d_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_xclient_gdid_d_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_xclient_gdid_d_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, int r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r111, null, null, 3, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, r111);
    L35:
        return r100.registerReceiver(r101, r110, r111);
    }
}
