package y0;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.SystemClock;
import androidx.appcompat.widget.p;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends v1.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f25947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f25948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f25949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap f25950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList f25951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList f25952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f25953n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f25954o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f25955p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f25956q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f25957r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f25958s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f25959t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f25960u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f25961a = null;

        static {
            f25961a = new f();
        }

        public static /* synthetic */ f a() {
            return f25961a;
        }
    }

    public f() {
        this.f25950k = new ConcurrentHashMap();
        this.f25951l = new LinkedList();
        this.f25952m = new LinkedList();
        this.f25953n = 0;
        this.f25954o = 0;
        this.f25955p = 0;
        this.f25956q = 0;
        this.f25957r = 0;
        this.f25958s = 0;
        this.f25959t = 0;
        this.f24971e = "battery";
    }

    public static f p() {
        return a.a();
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        boolean r11 = false;
        if (r10.optInt(SlardarSettingsConsts.PER_POWER_MONITOR_ENABLE, 0) != 1) goto L5;
        r11 = true;
    L5:
        this.f25946g = r11;
        if (r11 == false) goto L8;
        this.f25947h = r10.optLong(SlardarSettingsConsts.PER_POWER_CPU_MONITOR_INTERVAL, 60000);
        this.f25948i = r10.optLong(SlardarSettingsConsts.PER_POWER_BATTERY_MONITOR_INTERVAL, 300000);
        this.f25949j = r10.optLong(SlardarSettingsConsts.PER_POWER_PROC_CPU_UPLOAD_INTERVAL, 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        AsyncEventManager.e().removeTimeTask(this);
    }

    @Override // v1.a
    public boolean e() {
        return this.f25946g;
    }

    @Override // v1.a
    public void h() {
        super.h();
        o();
        n();
        q();
    }

    @Override // v1.a
    public void i() {
        super.i();
    }

    @Override // v1.a
    public long m() {
        return this.f25947h;
    }

    public final void n() {
        long r10 = SystemClock.uptimeMillis();
        long r11 = this.f25958s;
        if ((this.f25948i + r11) <= r10) goto L5;
        return;
    L5:
        long r12 = r10 - r11;
        this.f25958s = r10;
        int r13 = ((BatteryManager) r3.a.b().getSystemService("batterymanager")).getIntProperty(4);
        int r14 = r13 - this.f25957r;
        if (this.f25959t == this.f25953n) goto L8;
    L13:
        this.f25957r = r13;
        this.f25959t = this.f25953n;
        return;
    L8:
        if (d() == true) goto L13;
        if (r14 > 0) goto L13;
        int r15 = Math.abs(r14);
        if (r15 > 100) goto L13;
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L15
        r16.put("battery", Math.abs(r15));     // Catch: Exception -> L15
        r16.put("duraion", r12);     // Catch: Exception -> L15
        k2.a.g("apm_battery_monitor", null, r16, null);     // Catch: Exception -> L15
        goto L13
    }

    public void o() {
        long r10 = com.bytedance.apm.util.b.a();
        long r11 = SystemClock.uptimeMillis();
        long r12 = this.f25955p;
        if (r12 != 0) goto L5;
    L14:
        this.f25956q = this.f25953n;
        this.f25954o = r10;
        this.f25955p = r11;
        return;
    L5:
        if (this.f25956q != this.f25953n) goto L14;
        double r13 = (r11 - r12) / 60000.0d;
        if (r13 <= 0.0d) goto L14;
        double r14 = Math.round(((r10 - this.f25954o) / r13) * 100.0d) / 100.0d;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L16
        if (d() == false) goto L12;
        String r16 = "background";
    L13:
        r15.put("status", r16);     // Catch: Exception -> L16
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L16
        r17.put("cpu_speed_min", r14);     // Catch: Exception -> L16
        k2.a.g("apm_cpu_speed", r15, r17, null);     // Catch: Exception -> L16
        goto L14
    L12:
        r16 = "foreground";
        goto L13
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        this.f25953n++;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        super.onFront(r10);
        this.f25953n++;
    }

    public final void q() {
        long r10 = SystemClock.uptimeMillis();
        if ((this.f25960u + this.f25949j) <= r10) goto L5;
        return;
    L5:
        this.f25960u = r10;
        LinkedList r11 = this.f25952m;
        monitor-enter(r11);
        Iterator r12 = this.f25952m.iterator();     // Catch: Throwable -> L13
    L9:
        if (r12.hasNext() == false) goto L10;
        p.a(r12.next());     // Catch: Throwable -> L13
        new JSONObject();     // Catch: Exception -> L20 Throwable -> L13
        throw null;     // Catch: Exception -> L20 Throwable -> L13
    L10:
        this.f25952m.clear();     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
