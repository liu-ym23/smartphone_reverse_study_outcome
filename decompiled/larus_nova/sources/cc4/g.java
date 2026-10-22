package cc4;

import android.app.Activity;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;
import qb4.s;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile g f23267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<d> f23268h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<h> f23269i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<h> f23270j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, c> f23271k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f23272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f23273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f23274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f23275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f23276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f23277q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f23282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23283f;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23285b;

        public final void a() {
            ConcurrentHashMap r100 = (ConcurrentHashMap) g.f23271k;
            if (((c) r100.get(this.f23284a)) != null) goto L5;
            c r101 = new c(this.f23284a, r100.size());
            g.d().getClass();
            g.l(r101);
        L5:
            List<d> r102 = g.f23268h;
            LinkedList r103 = (LinkedList) r102;
            if (r103.size() < 60) goto L8;
            ListProtector.remove(r102, 0);
        L8:
            d r104 = new d(this.f23284a);
            r104.f23259b = System.currentTimeMillis();
            int r105 = r103.lastIndexOf(r104);
            if (r105 >= 0) goto L11;
            r103.add(r104);
            return;
        L11:
            if (((d) ListProtector.get(r102, r105)).f23260c <= 0) goto L15;
            r103.add(r104);
            return;
        }

        public final void b() {
            d r100 = new d(this.f23284a);
            List<d> r101 = g.f23268h;
            int r102 = ((LinkedList) r101).lastIndexOf(r100);
            if (r102 < 0) goto L19;
            d r103 = (d) ListProtector.get(r101, r102);
            r103.f23260c = System.currentTimeMillis();
            Map<String, c> r104 = g.f23271k;
            ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
            c r106 = (c) r105.get(this.f23284a);
            if (r106 == null) goto L20;
            h r107 = r106.f23254f;
            if (r107 == null) goto L9;
            r103.f23261d = r107.a();
        L9:
            h r108 = r106.f23255g;
            if (r108 == null) goto L12;
            r103.f23262e = r108.a();
        L12:
            h r109 = r106.f23256h;
            if (r109 == null) goto L15;
            r103.f23263f = r109.a();
        L15:
            h r110 = r106.f23257i;
            if (r110 == null) goto L21;
            r103.f23264g = r110.a();
            return;
        L21:
            return;
        L20:
            return;
        }

        /* JADX INFO: Removed unreachable split cross block B:22:0x001e */
        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f23285b;     // Catch: Throwable -> L10 Exception -> L12
            if (r100 != 2) goto L5;
            b();     // Catch: Throwable -> L10 Exception -> L12
        L19:
            return;
        L5:
            if (r100 != 4) goto L19;
            a();     // Catch: Throwable -> L10 Exception -> L12
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L12:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L10
            goto L19
        }

        public a(String r100, int r101) {
            this.f23284a = r100;
            this.f23285b = r101;
        }
    }

    static {
        f23268h = new LinkedList();
        f23269i = new LinkedList();
        f23270j = new LinkedList();
        f23271k = new ConcurrentHashMap();
        f23272l = 0;
    }

    public static String b() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L13;
        Activity r101 = r100.getTopActivity();
        if (r101 == null) goto L13;
        return r101.getClass().getName();
    L13:
        List<d> r102 = f23268h;     // Catch: Exception -> L10
        return ((d) ListProtector.get(r102, ((LinkedList) r102).size() - 1)).f23258a;
    L10:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put("page_history_count", ((LinkedList) f23268h).size());     // Catch: Exception -> L5
        r100.put("touch_event_count", ((LinkedList) f23269i).size());     // Catch: Exception -> L5
        r100.put("first_touch_event_count", ((LinkedList) f23270j).size());     // Catch: Exception -> L5
        r100.put("page_profile_count", ((ConcurrentHashMap) f23271k).size());     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static g d() {
        if (f23267g != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f23267g != null) goto L9;
        f23267g = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f23267g;
    }

    public static JSONArray e() {
        List<d> r100 = f23268h;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L60;
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L7:
        List<d> r103 = f23268h;
        LinkedList r104 = (LinkedList) r103;
        if (r102 >= r104.size()) goto L51;
        d r105 = (d) ListProtector.get(r103, r102);
        if (r105 == null) goto L49;
        if (r102 == (r104.size() - 1)) goto L14;
    L52:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L45
        r106.put("id", r105.f23258a);     // Catch: Exception -> L43
        r106.put("et", r105.f23259b);     // Catch: Exception -> L43
        r106.put("lt", r105.f23260c);     // Catch: Exception -> L43
        h r107 = r105.f23261d;     // Catch: Exception -> L43
        if (r107 == null) goto L33;
        r106.put(ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, r107.b());     // Catch: Exception -> L43
    L33:
        h r108 = r105.f23262e;     // Catch: Exception -> L43
        if (r108 == null) goto L36;
        r106.put("up", r108.b());     // Catch: Exception -> L43
    L36:
        h r109 = r105.f23263f;     // Catch: Exception -> L43
        if (r109 == null) goto L39;
        r106.put("move_1", r109.b());     // Catch: Exception -> L43
    L39:
        h r110 = r105.f23264g;     // Catch: Exception -> L43
        if (r110 == null) goto L48;
        r106.put("move_2", r110.b());     // Catch: Exception -> L43
    L48:
        r101.put(r106);
    L43:
        e = e;
    L47:
        e.printStackTrace();
    L45:
        e = e;
        r106 = null;
        goto L47
    L14:
        if (r105.f23261d != null) goto L52;
        c r111 = (c) ((ConcurrentHashMap) f23271k).get(b());
        if (r111 == null) goto L52;
        h r112 = r111.f23254f;
        if (r112 == null) goto L20;
        r105.f23261d = r112.a();
    L20:
        h r113 = r111.f23255g;
        if (r113 == null) goto L23;
        r105.f23262e = r113.a();
    L23:
        h r114 = r111.f23256h;
        if (r114 == null) goto L26;
        r105.f23263f = r114.a();
    L26:
        h r115 = r111.f23257i;
        if (r115 == null) goto L52;
        r105.f23264g = r115.a();
    L49:
        r102 = r102 + 1;
        goto L7
    L51:
        return r101;
    L60:
        return null;
    }

    public static JSONArray f() {
        JSONArray r100 = new JSONArray();
        Map<String, c> r101 = f23271k;
        if (r101 == null) goto L23;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        if (r102.isEmpty() == true) goto L23;
        Iterator r103 = r102.keySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L23;
        String r104 = (String) r103.next();
        c r105 = (c) ((ConcurrentHashMap) f23271k).get(r104);
        if (r105 == null) goto L8;
        JSONObject r106 = new JSONObject();
        r106.put("index", r105.f23251c);     // Catch: Exception -> L20
        r106.put("ts", r105.f23249a);     // Catch: Exception -> L20
        r106.put("name", r105.f23250b);     // Catch: Exception -> L20
        if (r105.f23252d == null) goto L22;
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L20
        if (r105.f23252d.booleanValue() == false) goto L17;
        int r108 = 1;
    L18:
        r107.put("success", r108);     // Catch: Exception -> L20
        r107.put("ts", r105.f23253e);     // Catch: Exception -> L20
        r106.put("touch_hook", r107);     // Catch: Exception -> L20
        goto L22
    L17:
        r108 = 0;
    L22:
        r100.put(r106);
    L20:
        e = move-exception;
        e.printStackTrace();
    L23:
        return r100;
    }

    public static JSONObject g() {
        JSONObject r100 = new JSONObject();
        r100.put("init_pid", f23273m);     // Catch: Exception -> L5
        r100.put("pid", Process.myPid());     // Catch: Exception -> L5
        r100.put("init_time", f23274n);     // Catch: Exception -> L5
        r100.put("life_cycle_register_time", s.f532383e);     // Catch: Exception -> L5
        r100.put("th_init_ts", f23276p);     // Catch: Exception -> L5
        r100.put("th_init_result", f23275o);     // Catch: Exception -> L5
        r100.put("th_init_page_id", f23277q);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void i() {
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f23283f == false) goto L5;
        return;
    L5:
        JSONObject r100 = b.a();     // Catch: Exception -> L16
        boolean r101 = false;
        if (r100 == null) goto L8;
        boolean r102 = r100.optBoolean("collect_touch_event_pre", false);     // Catch: Exception -> L16
    L9:
        this.f23280c = r102;     // Catch: Exception -> L16
        JSONObject r103 = b.a();     // Catch: Exception -> L16
        if (r103 == null) goto L12;
        r101 = r103.optBoolean("collect_page_history_pre", false);     // Catch: Exception -> L16
    L12:
        this.f23281d = r101;     // Catch: Exception -> L16
        this.f23283f = true;     // Catch: Exception -> L16
        f23273m = Process.myPid();     // Catch: Exception -> L16
        f23274n = System.currentTimeMillis();     // Catch: Exception -> L16
        if (this.f23280c == false) goto L21;
        c0.a.f532328a.a(new e(this));     // Catch: Exception -> L16
        return;
    L21:
        return;
    L8:
        r102 = false;
        goto L9
    }

    public g() {
        this.f23278a = 0;
        this.f23279b = false;
        this.f23280c = false;
        this.f23281d = false;
        this.f23283f = false;
    }

    public static boolean a(g r100) {
        r100.getClass();
        boolean r101 = false;
        BdTuringConfig r102 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L6
        if (r102 == null) goto L8;
        Activity r103 = r102.getTopActivity();     // Catch: Exception -> L6
    L9:
        if (r103 == null) goto L31;
        Window.Callback r104 = r103.getWindow().getCallback();     // Catch: Exception -> L6
        if (r104 != null) goto L13;
    L26:
        boolean r105 = r100.k(r103);     // Catch: Exception -> L6
        f23276p = System.currentTimeMillis();     // Catch: Exception -> L29
        f23275o = r105;     // Catch: Exception -> L29
        f23277q = r103.getClass().getName();     // Catch: Exception -> L29
        r100.h(r103, false);     // Catch: Exception -> L29
        return r105;
    L29:
        e = e;
        r101 = r105;
    L33:
        EventReport.j(e.getMessage());
        return r101;
    L13:
        if ((r104 instanceof Proxy) == false) goto L19;
        InvocationHandler r106 = Proxy.getInvocationHandler(r104);     // Catch: Exception -> L6
        if (r106 == null) goto L19;
        if ((r106 instanceof i) == false) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L26;
        f23276p = System.currentTimeMillis();     // Catch: Exception -> L6
        f23275o = true;     // Catch: Exception -> L24
        f23277q = r103.getClass().getName();     // Catch: Exception -> L24
        return true;
    L24:
        e = e;
        r101 = true;
    L19:
        r107 = false;
        goto L20
    L31:
        f23276p = System.currentTimeMillis();     // Catch: Exception -> L6
        f23275o = false;     // Catch: Exception -> L6
        f23277q = "";     // Catch: Exception -> L6
        return false;
    L8:
        r103 = null;
    L6:
        e = e;
        goto L33
    }

    public static void l(c r100) {
        if (TextUtils.isEmpty(r100.f23250b) == true) goto L10;
        ConcurrentHashMap r101 = (ConcurrentHashMap) f23271k;
        if (r101.size() <= 80) goto L8;
        return;
    L8:
        r101.put(r100.f23250b, r100);
        return;
    }

    public static JSONArray m(List r100) {
        JSONArray r101 = new JSONArray();
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L10;
        int r102 = 0;
    L8:
        if (r102 >= ((LinkedList) r100).size()) goto L10;
        r101.put(((h) ListProtector.get(r100, r102)).b());
        r102 = r102 + 1;
        goto L8
    }

    public final void j(MotionEvent r110) {
        if (this.f23280c == false) goto L39;
        long r100 = System.currentTimeMillis();
        long r101 = this.f23282e;
        if (r100 != r101) goto L7;
        return;
    L7:
        long r102 = r100 - r101;
        int r103 = r110.getActionMasked();
        if (2 == r103) goto L10;
    L12:
        this.f23282e = r100;
        h r104 = new h();
        r104.f23287b = r103;
        r104.f23288c = r110.getX();
        r104.f23289d = r110.getY();
        r104.f23290e = r110.getTouchMajor();
        r104.f23291f = r110.getPressure();
        r104.f23286a = r100;
        LinkedList r111 = (LinkedList) f23270j;
        if (r111.size() >= 100) goto L15;
        r111.add(r104);
    L19:
        c r112 = (c) ((ConcurrentHashMap) f23271k).get(b());
        if (r112 == null) goto L34;
        if (r103 != 0) goto L23;
        r112.f23254f = r104;
        r112.f23256h = null;
        r112.f23257i = null;
        goto L34
    L23:
        if (1 != r103) goto L25;
        r112.f23255g = r104;
        goto L34
    L25:
        if (2 != r103) goto L34;
        h r105 = r112.f23256h;
        if (r105 != null) goto L30;
        r112.f23256h = r104;
        goto L34
    L30:
        if (r112.f23257i != null) goto L34;
        if ((r104.f23286a - r105.f23286a) <= 50) goto L34;
        r112.f23257i = r104;
    L34:
        List<h> r113 = f23269i;
        LinkedList r106 = (LinkedList) r113;
        if (r106.size() < 600) goto L37;
        ListProtector.remove(r113, 0);
    L37:
        r106.add(r104);
        return;
    L15:
        if (1 != r103) goto L19;
        if (r111.size() != 100) goto L19;
        r111.add(r104);
        goto L19
    L10:
        if (r102 >= 33.0d) goto L12;
        return;
    }

    public final boolean k(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f23280c == true) goto L8;
        return false;
    L8:
        String r101 = r100.getClass().getName();
        ConcurrentHashMap r102 = (ConcurrentHashMap) f23271k;
        c r103 = (c) r102.get(r101);
        if (r103 != null) goto L29;
        r103 = new c(r101, r102.size());
        l(r103);
    L29:
        Window.Callback r104 = r100.getWindow().getCallback();     // Catch: Exception -> L26
        if (r104 != null) goto L15;
        return false;
    L15:
        if ((r104 instanceof Proxy) == false) goto L21;
        InvocationHandler r105 = Proxy.getInvocationHandler(r104);     // Catch: Exception -> L26
        if (r105 == null) goto L21;
        if ((r105 instanceof i) == false) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L24;
        return true;
    L24:
        r100.getWindow().setCallback((Window.Callback) Proxy.newProxyInstance(r104.getClass().getClassLoader(), new Class[]{Window.Callback.class}, new i(r104)));     // Catch: Exception -> L26
        r103.f23252d = Boolean.TRUE;     // Catch: Exception -> L26
        r103.f23253e = System.currentTimeMillis();     // Catch: Exception -> L26
        return true;
    L21:
        r106 = false;
    L26:
        e = move-exception;
        e.printStackTrace();
        r103.f23252d = Boolean.FALSE;
        r103.f23253e = System.currentTimeMillis();
        EventReport.j(e.getMessage());
        return false;
    }

    public final void h(Activity r100, boolean r101) {
        if (this.f23281d == false) goto L8;
        if (r100 == null) goto L6;
        String r102 = r100.getClass().getName();
    L7:
        rb4.d.b().a(new a(r102, 4));
        goto L8
    L6:
        r102 = "";
    L8:
        if (r101 == false) goto L11;
        k(r100);
        return;
    }
}
