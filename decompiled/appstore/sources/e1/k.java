package e1;

import android.os.IBinder;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends a implements IHookService {
    public k() {
        super(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.os.IPowerManager";
    }

    @Override // e1.a
    public void i(double r10, double r11) {
        if (r10 < z0.a.g()) goto L5;
        int r12 = 17;
    L7:
        if (r11 < z0.a.f()) goto L9;
        r12 = r12 | 18;
    L9:
        if (r12 != 0) goto L23;
        return;
    L23:
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L22
        r13.put(Constants.BATTERY_ISSUE_TYPE, r12).put(Constants.KEY_TOTAL_HOLD_TIME, r10).put(Constants.KEY_TOTAL_ACQUIRE_COUNT, r11);     // Catch: Throwable -> L22
        ConcurrentHashMap r14 = this.f19246e;     // Catch: Throwable -> L22
        if (r14 != null) goto L14;
    L20:
        v1.b.b(r13, "battery_trace");     // Catch: Throwable -> L22
        l1.a.p().e(new m1.d("battery_trace", r13));     // Catch: Throwable -> L22
        return;
    L14:
        if (r14.size() <= 0) goto L20;
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r16 = this.f19246e.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r16.hasNext() == false) goto L19;
        r15.put(((f1.d) r16.next()).b());     // Catch: Throwable -> L22
        goto L17
    L19:
        r13.put("detail", r15);     // Catch: Throwable -> L22
    L26:
        return;
    L5:
        r12 = 0;
        goto L7
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public synchronized void invoke(Object r10, Method r11, Object[] r12) {
        monitor-enter(this);
        String r13 = r11.getName();     // Catch: Throwable -> L6 Exception -> L16
        if ("acquireWakeLock".equals(r13) == false) goto L9;
        k(r12);     // Catch: Throwable -> L6 Exception -> L16
    L17:
        goto L14
    L9:
        if ("releaseWakeLock".equals(r13) == false) goto L17;
        l(r12);     // Catch: Throwable -> L6 Exception -> L16
    L6:
        th = move-exception;
        throw th;
    L14:
        monitor-exit(this);
    }

    @Override // e1.a
    public /* bridge */ /* synthetic */ void j(f1.b r10, long r11) {
        m((f1.d) r10, r11);
    }

    public final void k(Object[] r10) {
        e();
        if (y0.a.E().H() == true) goto L5;
        return;
    L5:
        if (r10.length <= 7) goto L7;
        return;
    L7:
        if (r10.length < 4) goto L37;
        Object r11 = r10[0];
        if (r11 != null) goto L12;
        return;
    L12:
        if ((r11 instanceof IBinder) == false) goto L36;
        int r12 = r11.hashCode();
        if (this.f19246e.containsKey(Integer.valueOf(r12)) == true) goto L25;
        f1.d r13 = new f1.d();
        Object r14 = r10[1];
        if (r14 != null) goto L18;
        return;
    L18:
        if ((r14 instanceof Integer) == false) goto L30;
        r13.f19443e = ((Integer) r14).intValue();
        Object r15 = r10[2];
        if (r15 != null) goto L22;
        return;
    L22:
        if ((r15 instanceof String) == false) goto L32;
        r13.f19444f = (String) r15;
        r13.f19439b = -1;
    L28:
        r13.f19441d = Thread.currentThread().getStackTrace();
        r13.f19440c = Thread.currentThread().getName();
        r13.f19438a = System.currentTimeMillis();
        this.f19246e.put(Integer.valueOf(r12), r13);
        return;
    L32:
        return;
    L30:
        return;
    L25:
        r13 = (f1.d) this.f19246e.get(Integer.valueOf(r12));
        if (r13 != null) goto L28;
        return;
    L36:
        return;
    }

    public final void l(Object[] r10) {
        h();
        if (y0.a.E().H() == true) goto L5;
        return;
    L5:
        if (r10.length == 2) goto L7;
        return;
    L7:
        Object r11 = r10[0];
        if (r11 != null) goto L10;
        return;
    L10:
        if ((r11 instanceof IBinder) == false) goto L17;
        int r12 = r11.hashCode();
        f1.d r13 = (f1.d) this.f19246e.get(Integer.valueOf(r12));
        if (r13 == null) goto L18;
        r13.f19439b = System.currentTimeMillis();
        this.f19246e.put(Integer.valueOf(r12), r13);
        return;
    L18:
        return;
    }

    public void m(f1.d r10, long r11) {
        if (r11 >= z0.a.c()) goto L8;
        return;
    L8:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L7
        r12.put("event_type", "battery_trace");     // Catch: JSONException -> L7
        r12.put(Constants.BATTERY_ISSUE_TYPE, 16).put("single_hold_time", r11).put(Constants.KEY_WAKE_LOCK_INFO, r10.toString());     // Catch: JSONException -> L7
        v1.b.b(r12, "battery_trace");     // Catch: JSONException -> L7
        l1.a.p().e(new m1.d("battery_trace", r12));     // Catch: JSONException -> L7
        return;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (b().equals(r11.f23268d) == true) goto L5;
        return;
    L5:
        if (r11.k() == false) goto L7;
        r10.r(r11.a());
        return;
    L7:
        r10.h(r11.a());
    }
}
