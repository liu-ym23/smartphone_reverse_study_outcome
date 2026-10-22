package a0;

import A6.l;
import H.h;
import L0.f;
import android.app.Activity;
import android.util.Log;
import c0.AbstractC0867a;
import c0.C0868b;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import m0.C1668b;
import org.json.JSONObject;
import w0.AbstractC2080a;

/* renamed from: a0.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0294c extends AbstractC2080a {
    public final ConcurrentHashMap g = new ConcurrentHashMap();
    public long h = -1;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f1625j;

    public C0294c() {
        this.e = "battery";
    }

    @Override // w0.AbstractC2080a
    public final void b(JSONObject jSONObject) {
        this.f1625j = jSONObject.optLong("battery_record_interval", 10L);
        int iOptInt = jSONObject.optInt("enable_upload", 0);
        if (h.b) {
            Log.e("<monitor><battery>", U7.a.e(new String[]{"mRecordInterval:" + this.f1625j + ",mBatteryCollectEnabled" + iOptInt}));
        }
        if (iOptInt <= 0 || this.f1625j <= 0) {
            this.g.clear();
            ActivityLifeObserver.getInstance().unregister(this);
            f fVar = L0.d.f925a;
            fVar.getClass();
            try {
                fVar.f.remove(this);
            } catch (Throwable unused) {
            }
        }
        if (jSONObject.optInt("trace_enable", 0) == 1) {
            jSONObject.optLong("max_single_wake_lock_hold_time_second", 120L);
            jSONObject.optInt("max_total_wake_lock_acquire_count", 5);
            jSONObject.optLong("max_total_wake_lock_hold_time_second", 240L);
            jSONObject.optInt("max_wake_up_alarm_invoke_count", 5);
            jSONObject.optInt("max_normal_alarm_invoke_count", 10);
            jSONObject.optLong("max_single_loc_request_time_second", 120L);
            jSONObject.optInt("max_total_loc_request_count", 5);
            jSONObject.optLong("max_total_loc_request_time_second", 240L);
        }
    }

    @Override // w0.AbstractC2080a, B.c
    /* renamed from: c */
    public final void mo0c() {
        this.b = false;
        if (h.b) {
            Log.i("<monitor><battery>", U7.a.e(new String[]{"onChangeToFront, record data"}));
        }
        l();
        for (d0.b bVar : this.g.values()) {
            bVar.getClass();
            bVar.b = true;
        }
        this.i = true;
    }

    @Override // w0.AbstractC2080a, B.c
    public final void f(Activity activity) {
        this.b = true;
        if (h.b) {
            Log.i("<monitor><battery>", U7.a.e(new String[]{"onChangeToBack, record data"}));
        }
        l();
        for (d0.b bVar : this.g.values()) {
            bVar.getClass();
            bVar.b = false;
        }
        this.i = false;
    }

    @Override // w0.AbstractC2080a
    public final boolean h() {
        return true;
    }

    @Override // w0.AbstractC2080a
    public final void i() {
    }

    @Override // w0.AbstractC2080a
    public final void j() {
        if (h.b) {
            Log.i("<monitor><battery>", U7.a.e(new String[]{"onTimer record, current is background? : " + ActivityLifeObserver.getInstance().isForeground()}));
        }
        l();
        Iterator it = this.g.values().iterator();
        if (it.hasNext()) {
            ((d0.b) it.next()).getClass();
            System.currentTimeMillis();
            throw null;
        }
    }

    @Override // w0.AbstractC2080a
    public final long k() {
        return this.f1625j * 60000;
    }

    public final void l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.h != -1) {
            C0868b c0868b = AbstractC0867a.f2067a;
            c0868b.b = ActivityLifeObserver.getInstance().getTopActivityClassName();
            c0868b.c(new C1668b(this.i, "ground_record", jCurrentTimeMillis, jCurrentTimeMillis - this.h));
        }
        this.h = jCurrentTimeMillis;
    }

    @Override // w0.AbstractC2080a, C.a
    public final void onReady() {
        super.onReady();
        C0868b c0868b = AbstractC0867a.f2067a;
        c0868b.getClass();
        if (h.b) {
            Log.d("ApmIn", U7.a.e(new String[]{"handleReportAndHandleCache()"}));
        }
        L0.d.f925a.b(new l(c0868b, 17));
    }
}
