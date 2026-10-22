package e1;

import android.text.TextUtils;
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
public class g extends a implements IHookService {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f19257k;

    public g() {
        super("location");
        this.f19257k = new ArrayList();
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.location.ILocationManager";
    }

    @Override // e1.a
    public void i(double r10, double r11) {
        if (r10 < z0.a.e()) goto L5;
        int r12 = 33;
    L7:
        if (r11 < z0.a.d()) goto L9;
        r12 = r12 | 34;
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
        r15.put(((f1.c) r16.next()).b());     // Catch: Throwable -> L22
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
    public void invoke(Object r10, Method r11, Object[] r12) {
        String r13 = r11.getName();     // Catch: Exception -> L14
        if (TextUtils.equals(r13, "requestLocationUpdates") == false) goto L6;
        l(r12);     // Catch: Exception -> L14
    L15:
        return;
    L6:
        if (TextUtils.equals(r13, "registerLocationListener") == false) goto L9;
        m(r12);     // Catch: Exception -> L14
        goto L15
    L9:
        if (TextUtils.equals(r13, "removeUpdates") == false) goto L11;
    L12:
        k(r12);     // Catch: Exception -> L14
        goto L15
    L11:
        if (TextUtils.equals(r13, "unregisterLocationListener") == false) goto L15;
    }

    @Override // e1.a
    public /* bridge */ /* synthetic */ void j(f1.b r10, long r11) {
        o((f1.c) r10, r11);
    }

    public final void k(Object[] r10) {
        Object r11 = r10[0];
        if (r11 == null) goto L13;
        int r12 = r11.hashCode();
        String r13 = String.valueOf(r12);
        if (this.f19257k.contains(r13) == false) goto L8;
        h();
        this.f19257k.remove(r13);
    L8:
        if (y0.a.E().H() == false) goto L14;
        f1.c r14 = (f1.c) this.f19246e.get(Integer.valueOf(r12));
        if (r14 == null) goto L15;
        r14.f19439b = System.currentTimeMillis();
        this.f19246e.put(Integer.valueOf(r12), r14);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void l(Object[] r10) {
        if (r10[0] == null) goto L8;
        Object r11 = r10[1];
        if (r11 == null) goto L9;
        n(r11.hashCode(), r10[0].toString());
        return;
    L9:
        return;
    }

    public final void m(Object[] r10) {
        if (r10[1] == null) goto L8;
        Object r11 = r10[2];
        if (r11 == null) goto L9;
        n(r11.hashCode(), r10[1].toString());
        return;
    L9:
        return;
    }

    public final void n(int r10, String r11) {
        String r12 = String.valueOf(r10);
        if (this.f19257k.contains(r12) == true) goto L6;
        e();
        this.f19257k.add(r12);
    L6:
        if (y0.a.E().H() == false) goto L12;
        f1.c r13 = (f1.c) this.f19246e.get(Integer.valueOf(r10));
        if (r13 != null) goto L10;
        r13 = new f1.c();
        r13.f19442e = r11;
    L10:
        r13.f19438a = System.currentTimeMillis();
        r13.f19439b = -1;
        r13.f19441d = Thread.currentThread().getStackTrace();
        r13.f19440c = Thread.currentThread().getName();
        this.f19246e.put(Integer.valueOf(r10), r13);
        return;
    }

    public void o(f1.c r10, long r11) {
        if (r11 >= z0.a.b()) goto L8;
        return;
    L8:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L7
        r12.put(Constants.BATTERY_ISSUE_TYPE, 32).put("single_hold_time", r11);     // Catch: Throwable -> L7
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L7
        r13.put(r10.b());     // Catch: Throwable -> L7
        r12.put("detail", r13);     // Catch: Throwable -> L7
        v1.b.b(r12, "battery_trace");     // Catch: Throwable -> L7
        l1.a.p().e(new m1.d("battery_trace", r12));     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (b().equals(r11.f23268d) == true) goto L5;
        return;
    L5:
        if (r11.k() == false) goto L7;
        r10.n(r11.a());
        return;
    L7:
        r10.d(r11.a());
    }
}
