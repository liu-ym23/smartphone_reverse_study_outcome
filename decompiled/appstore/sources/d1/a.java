package d1;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.ListUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b1.a f18994c;

    /* JADX INFO: renamed from: d1.a$a, reason: collision with other inner class name */
    public class RunnableC0229a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f18995a;

        public RunnableC0229a(a r10) {
            this.f18995a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f18995a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            i6.a.d(th, "handleReportAndHandleCache");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18996a = null;

        static {
            f18996a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f18996a;
        }
    }

    public /* synthetic */ a(RunnableC0229a r10) {
        this();
    }

    public static /* synthetic */ void a(a r10) {
        r10.n();
    }

    public static a h() {
        return b.a();
    }

    public final void b(long r10) {
        f().m(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        i6.a.d(e, "cleanBatteryLog");
    }

    public final boolean c(d1.b r10, List r11) {
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L26;
        p1.a r15 = (p1.a) r14.next();
        if (r15.m() == true) goto L7;
        r13.add(r15);
        goto L4
    L7:
        r12.add(r15);
        goto L4
    L26:
    L15:
        e = move-exception;
        i6.a.d(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r12.isEmpty() == false) goto L13;
    L17:
        boolean r16 = true;
    L19:
        if (r13.isEmpty() == true) goto L34;
        if (m(r10, r13) == true) goto L34;
        return false;
    L34:
        return r16;
    L13:
        if (m(r10, r12) == true) goto L17;
        r16 = false;
        goto L19
    }

    public final boolean d(d1.b r10, List r11) {
        HashMap r12 = new HashMap(4);
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L21;
        p1.a r14 = (p1.a) r13.next();
        String r15 = r14.d();
        List r16 = (List) r12.get(r15);
        if (r16 != null) goto L7;
        LinkedList r17 = new LinkedList();
        r17.add(r14);
        r12.put(r15, r17);
        goto L4
    L7:
        r16.add(r14);
        goto L4
    L21:
        Iterator r18 = r12.values().iterator();     // Catch: Exception -> L16
        boolean r19 = true;
    L12:
        if (r18.hasNext() == false) goto L34;
        if (c(r10, (List) r18.next()) == true) goto L12;
        r19 = false;
        goto L12
    L34:
        return r19;
    L16:
        e = move-exception;
        i6.a.d(e, "divideBySceneAndReport");
        return false;
    }

    public final List e(boolean r10, long r11) {
        return f().k(r10, r11);
    L5:
        return Collections.emptyList();
    }

    public final b1.a f() {
        if (this.f18994c != null) goto L6;
        this.f18994c = b1.a.j();
    L6:
        return this.f18994c;
    }

    public String g() {
        return this.f18992a;
    }

    public final void i(p1.a r10) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        if (r10.k() == true) goto L10;
        r10.t(false);
        return;
    }

    public final void j(p1.a r10) {
        if (TextUtils.isEmpty(this.f18993b) == false) goto L5;
        this.f18993b = String.valueOf(System.currentTimeMillis());
    L5:
        r10.p(c.F());
        r10.q(c.h());
        r10.s(this.f18993b);
        if (r10.k() == false) goto L8;
        String r11 = this.f18992a;
    L10:
        if (TextUtils.isEmpty(r10.d()) == true) goto L13;
        r11 = r10.d() + "#" + r11;
    L13:
        r10.r(r11);
        i(r10);
        o(r10);
        return;
    L8:
        r11 = "background";
        goto L10
    }

    public void k(boolean r10) {
        if (r10 == false) goto L9;
        AsyncEventManager.e().h(new RunnableC0229a(this));
        return;
    L9:
        n();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        i6.a.d(th, "handleReportAndHandleCache");
    }

    public void l(p1.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        j(r10);
    }

    public final boolean m(d1.b r10, List r11) {
        Map r12 = y0.a.E().C();
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r11.iterator();
        String r15 = null;
    L4:
        if (r14.hasNext() == false) goto L19;
        p1.a r16 = (p1.a) r14.next();
        if (r15 != null) goto L8;
    L9:
        r15 = r16.f();
        r13.append(r15);
    L11:
        if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(r16.f23268d) == true) goto L13;
        IBatteryStats r17 = (IBatteryStats) r12.get(r16.f23268d);
        if (r17 == null) goto L4;
        r17.updateStatsRet(r10, r16);
        goto L4
    L13:
        if (r16.k() == true) goto L14;
        r10.c(r16.a());
        goto L4
    L14:
        r10.m(r16.a());
        goto L4
    L8:
        if (r15.equals(r16.f()) == true) goto L11;
    L19:
        p1.a r18 = (p1.a) r11.get(0);
        r10.C(r18.l());
        r10.D(r18.c());
        r10.F(r13.toString());
        r10.E(r18.d());
        r10.B(r18.m());
        s1.a.d(Constants.TAG_BATTERY, "Report Data proc:" + r18.c() + " scene:" + r18.d() + " size:" + r11.size());
        return r10.z(true);
    }

    public final void n() {
        if (c.F() == true) goto L5;
        return;
    L5:
        d1.b r10 = new d1.b();
        List r11 = e(true, 0);
        if (ListUtils.b(r11) == false) goto L8;
        return;
    L8:
        boolean r12 = d(r10, r11);
        r10.y();
        p1.a r13 = (p1.a) r11.get(r11.size() - 1);
        long r14 = r13.b();
        long r15 = r13.g();
        if (r12 == true) goto L16;
        if (c.B() == false) goto L13;
        s1.c.g(s1.b.f24484b, new String[]{"report main process data failed, clean data and stop calc data of other process"});
    L13:
        b(r14);
        return;
    L16:
        if (c.B() == false) goto L18;
        s1.c.d(s1.b.f24484b, new String[]{"report main process data over, begin handle other process data"});
    L18:
        List r16 = e(false, r15);
        HashMap r17 = new HashMap(4);
        Iterator r18 = r16.iterator();
    L20:
        if (r18.hasNext() == false) goto L34;
        p1.a r19 = (p1.a) r18.next();
        String r20 = r19.c();
        List r21 = (List) r17.get(r20);
        if (r21 != null) goto L23;
        LinkedList r22 = new LinkedList();
        r22.add(r19);
        r17.put(r20, r22);
        goto L20
    L23:
        r21.add(r19);
        goto L20
    L34:
        Iterator r23 = r17.values().iterator();     // Catch: Exception -> L30
    L27:
        if (r23.hasNext() == false) goto L32;
        d(r10, (List) r23.next());     // Catch: Exception -> L30
        r10.y();     // Catch: Exception -> L30
    L32:
        r10.A();
        b(r14);
        s1.a.d(Constants.TAG_BATTERY, "Report Data All Success");
        return;
    L30:
        e = move-exception;
        i6.a.d(e, "reportLastTimeBattery");
        goto L32
    }

    public final void o(p1.a r10) {
    L5:
        e = move-exception;
        i6.a.d(e, "saveBatteryLog");
        return;
    L3:
        if (c.B() == false) goto L7;
        s1.c.d(s1.b.f24484b, new String[]{"saveBatteryLog into db: " + r10});     // Catch: Exception -> L5
    L7:
        s1.a.d(Constants.TAG_BATTERY_LOCAL, q(r10));     // Catch: Exception -> L5
        f().l(r10);     // Catch: Exception -> L5
    }

    public void p(String r10) {
        this.f18992a = r10;
    }

    public final String q(p1.a r10) {
        JSONObject r11 = r10.v();
        if (TextUtils.equals(r10.h(), BatteryTypeInf.BATTERY_CPU_ACTIVE) == false) goto L6;
        r11.put("accumulation", (r10.a() * 1000) / com.bytedance.apm.util.b.h(100));
    L10:
        return r11.toString();
    L6:
        if (TextUtils.equals(r10.h(), "traffic") == false) goto L8;
        r11.put("accumulation", r10.a() / 1024);
        goto L10
    L8:
        r11.put("accumulation", r10.a());
        goto L10
    }

    public a() {
        this.f18992a = "";
    }
}
