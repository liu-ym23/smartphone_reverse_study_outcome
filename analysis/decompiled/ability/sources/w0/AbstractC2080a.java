package w0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2080a implements B.c, C.a, L0.e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6806a;
    public boolean b;
    public boolean c;
    public boolean d;
    public String e;
    public long f;

    public final void a(P.e eVar) {
        S0.b.z(eVar);
        O.a.g().c(eVar);
    }

    public abstract void b(JSONObject jSONObject);

    @Override // B.c
    public final void c(Activity activity) {
    }

    public final void d() {
        if (this.c) {
            return;
        }
        if (TextUtils.isEmpty(this.e)) {
            throw new IllegalStateException("Must set collector Setting key, before init");
        }
        this.c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.b = true ^ ActivityLifeObserver.getInstance().isForeground();
        i();
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(this);
        if (H.h.b) {
            Log.d("AbstractPerfCollector", U7.a.e(new String[]{"perf init: " + this.e}));
        }
    }

    @Override // L0.e
    public final void e(long j5) {
        long jK = k();
        if (jK <= 0 || j5 - this.f <= jK || !this.f6806a) {
            return;
        }
        j();
        this.f = System.currentTimeMillis();
    }

    @Override // B.c
    public void f(Activity activity) {
        this.b = true;
        Application application = H.h.f711a;
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    public abstract boolean h();

    public void i() {
    }

    public abstract void j();

    public abstract long k();

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    public void onReady() {
        this.f6806a = true;
        if (!this.d) {
            this.d = true;
            if (h()) {
                L0.d.f925a.a(this);
            }
        }
        j();
        this.f = System.currentTimeMillis();
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(this.e)) == null) {
            return;
        }
        jSONObjectOptJSONObject.optInt("enable_upload", 0);
        b(jSONObjectOptJSONObject);
    }

    @Override // B.c
    /* renamed from: c */
    public void mo0c() {
        this.b = false;
        Application application = H.h.f711a;
    }
}
