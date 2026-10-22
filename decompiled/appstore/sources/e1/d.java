package e1;

import android.app.PendingIntent;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends c implements IHookService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f19247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f19249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f19251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f19252k;

    public d() {
        super(BatteryTypeInf.BATTERY_ALARM);
        this.f19249h = new ArrayList();
        this.f19251j = new Object();
        this.f19252k = new ArrayList();
    }

    @Override // e1.c
    public /* bridge */ /* synthetic */ void a(f1.b r10, long r11, long r12) {
        d((f1.a) r10, r11, r12);
    }

    @Override // e1.c
    public void c(long r10, long r11, boolean r12) {
        this.f19248g = 0;
        this.f19247f = new int[2];
        this.f19252k.add(Long.valueOf(r10));
        Object r13 = this.f19251j;
        monitor-enter(r13);
        this.f19252k.addAll(this.f19249h);     // Catch: Throwable -> L15
        this.f19249h.clear();     // Catch: Throwable -> L15
        monitor-exit(r13);     // Catch: Throwable -> L15
        this.f19252k.add(Long.valueOf(r11));
        this.f19250i = 1;
    L8:
        if (this.f19250i >= this.f19252k.size()) goto L10;
        super.c(((Long) this.f19252k.get(this.f19250i - 1)).longValue(), ((Long) this.f19252k.get(this.f19250i)).longValue(), r12);
        this.f19250i++;
        goto L8
    L10:
        int[] r14 = this.f19247f;
        if ((r14[0] + r14[1]) == 0) goto L13;
        g(r14, this.f19252k.size());
    L13:
        this.f19252k.clear();
        h();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void d(f1.a r11, long r12, long r14) {
        long r10 = r11.f19436f;
        int r13 = 1;
        if (r10 > 0) goto L10;
        long r15 = r11.f19438a;
        if (r12 <= r15) goto L7;
        return;
    L7:
        if (r15 <= r14) goto L23;
        return;
    L23:
        if (r11.c() == false) goto L25;
        int[] r16 = this.f19247f;
        int r17 = this.f19250i % 2;
        r16[r17] = r16[r17] + r13;
        return;
    L25:
        this.f19248g += r13;
        return;
    L10:
        long r18 = r11.f19438a;
        if (r18 >= r12) goto L13;
        r18 = (r12 + r10) - ((r12 - r18) % r10);
    L13:
        long r19 = r11.f19439b;
        if (r19 <= r14) goto L16;
    L19:
        long r110 = r14 - r18;
        if (r110 <= 0) goto L28;
        r13 = 1 + ((int) (r110 / r10));
        goto L23
    L28:
        return;
    L16:
        if (r19 <= 0) goto L19;
        r14 = r19;
        goto L19
    }

    public final void e(Object[] r10) {
        Object r11 = r10[0];
        if (r11 != null) goto L5;
    L7:
        int r12 = -1;
    L8:
        f1.a r13 = (f1.a) this.f19246e.get(Integer.valueOf(r12));
        if (r13 != null) goto L11;
        return;
    L11:
        if (r13.f19436f <= 0) goto L15;
        r13.f19439b = System.currentTimeMillis();
        this.f19246e.put(Integer.valueOf(r12), r13);
        return;
    L15:
        return;
    L5:
        if ((r11 instanceof PendingIntent) == false) goto L7;
        r12 = r11.hashCode();
        goto L8
    }

    public final void f(Object[] r10) {
        f1.a r11 = new f1.a();
        int r12 = r10.length;
        int r13 = 0;
        boolean r14 = false;
        int r15 = 0;
        int r16 = -1;
    L3:
        if (r13 >= r12) goto L20;
        Object r17 = r10[r13];
        if ((r17 instanceof Integer) == false) goto L9;
        if (r14 == true) goto L9;
        r11.f19435e = ((Integer) r17).intValue();
        r14 = true;
    L19:
        r13 = r13 + 1;
    L9:
        if ((r17 instanceof Long) == false) goto L17;
        if (r15 != 0) goto L13;
        r11.f19438a = ((Long) r17).longValue();
        r11.f19438a = r11.b();
    L15:
        r15 = r15 + 1;
        goto L19
    L13:
        if (r15 != 2) goto L15;
        r11.f19436f = ((Long) r17).longValue();
        goto L15
    L17:
        if ((r17 instanceof PendingIntent) == false) goto L19;
        PendingIntent r18 = (PendingIntent) r17;
        r11.f19437g = com.bytedance.apm.util.h.a(r18);
        r16 = r18.hashCode();
        goto L19
    L20:
        if (r16 != (-1)) goto L22;
        return;
    L22:
        if (r11.f19436f != 0) goto L24;
        long r19 = r11.f19438a;
    L25:
        r11.f19439b = r19;
        if (y0.a.E().H() == false) goto L28;
        r11.f19440c = Thread.currentThread().getName();
        r11.f19441d = Thread.currentThread().getStackTrace();
    L28:
        this.f19246e.put(Integer.valueOf(r16), r11);
        return;
    L24:
        r19 = -1;
        goto L25
    }

    public final void g(int[] r14, int r15) {
        long r10 = System.currentTimeMillis();
        if (this.f19244c == false) goto L7;
        if ((r15 % 2) != 0) goto L7;
    L10:
        d1.a.h().l(new p1.a(false, r10, b(), this.f19245d, r14[0], null));
        d1.a.h().l(new p1.a(true, r10, b(), this.f19245d, r14[1], null));
        return;
    L7:
        if (this.f19244c == false) goto L9;
    L11:
        d1.a.h().l(new p1.a(true, r10, b(), this.f19245d, r14[0], null));
        d1.a.h().l(new p1.a(false, r10, b(), this.f19245d, r14[1], null));
        return;
    L9:
        if ((r15 % 2) != 1) goto L11;
        goto L10
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.app.IAlarmManager";
    }

    public final void h() {
        long r10 = System.currentTimeMillis();
        int[] r11 = this.f19247f;
        int r12 = 0;
        double r13 = (((((double) r11[0]) + ((double) r11[1])) / (r10 - this.f19243b)) * 60000.0d) * 10.0d;
        double r14 = ((((double) this.f19248g) / (r10 - this.f19243b)) * 60000.0d) * 10.0d;
        if (r13 < z0.a.h()) goto L6;
        r12 = 49;
    L6:
        if (r14 < z0.a.a()) goto L8;
        r12 = r12 | 50;
    L8:
        if (r12 != 0) goto L22;
        return;
    L22:
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L21
        r15.put(Constants.BATTERY_ISSUE_TYPE, r12).put(Constants.KEY_WAKE_UP_COUNT, r13).put(Constants.KEY_NORMAL_COUNT, r14);     // Catch: Throwable -> L21
        ConcurrentHashMap r16 = this.f19246e;     // Catch: Throwable -> L21
        if (r16 != null) goto L13;
    L19:
        v1.b.b(r15, "battery_trace");     // Catch: Throwable -> L21
        l1.a.p().e(new m1.d("battery_trace", r15));     // Catch: Throwable -> L21
        return;
    L13:
        if (r16.size() <= 0) goto L19;
        JSONArray r17 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r18 = this.f19246e.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r18.hasNext() == false) goto L18;
        r17.put(((f1.a) r18.next()).d());     // Catch: Throwable -> L21
        goto L16
    L18:
        r15.put("detail", r17);     // Catch: Throwable -> L21
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public void invoke(Object r10, Method r11, Object[] r12) {
        String r13 = r11.getName();     // Catch: Exception -> L9
        if ("set".equals(r13) == false) goto L6;
        f(r12);     // Catch: Exception -> L9
    L10:
        return;
    L6:
        if ("remove".equals(r13) == false) goto L10;
        e(r12);     // Catch: Exception -> L9
    }

    @Override // e1.c, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r10) {
        super.onBack(r10);
        long r11 = System.currentTimeMillis();
        Object r12 = this.f19251j;
        monitor-enter(r12);
        this.f19249h.add(Long.valueOf(r11));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r10, boolean r11) {
        this.f19245d = r10;
    }

    @Override // e1.c, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r10) {
        super.onFront(r10);
        long r11 = System.currentTimeMillis();
        Object r12 = this.f19251j;
        monitor-enter(r12);
        this.f19249h.add(Long.valueOf(r11));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r10, boolean r11) {
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r10, boolean r11) {
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (b().equals(r11.f23268d) == true) goto L6;
        return;
    L6:
        if (r11.j() == false) goto L8;
        r10.i(r11.a());
        return;
    L8:
        r10.s(r11.a());
    }
}
