package v1;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IActivityLifeObserver, IConfigListener, AsyncEventManager.IMonitorTimeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f24971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f24972f;

    public a() {
    }

    private final void k() {
        if (this.f24970d == true) goto L7;
        this.f24970d = true;
        if (e() == false) goto L7;
        AsyncEventManager.e().addTimeTask(this);
    L7:
        h();
        this.f24972f = System.currentTimeMillis();
    }

    public final void a() {
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) n5.b.a(IConfigManager.class)).unregisterConfigListener(this);
        f();
    }

    public void b(JSONObject r10) {
    }

    public final void c() {
        if (this.f24969c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f24971e) == true) goto L12;
        this.f24969c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f24968b = true ^ ActivityLifeObserver.getInstance().isForeground();
        g();
        ((IConfigManager) n5.b.a(IConfigManager.class)).registerConfigListener(this);
        if (w0.c.B() == false) goto L13;
        s1.c.b("AbstractPerfCollector", new String[]{"perf init: " + this.f24971e});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    public boolean d() {
        return this.f24968b;
    }

    public abstract boolean e();

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public void j(m1.e r10) {
        b.c(r10);
        b.a(r10, r10.e());
        l1.a.p().e(r10);
    }

    public final void l() {
        if (this.f24970d == false) goto L7;
        this.f24970d = false;
        if (e() == false) goto L7;
        AsyncEventManager.e().removeTimeTask(this);
    L7:
        i();
    }

    public abstract long m();

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r10) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        this.f24968b = true;
        if (w0.c.I() == false) goto L6;
        l();
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        this.f24968b = false;
        if (w0.c.I() == true) goto L5;
        return;
    L5:
        if (this.f24967a == false) goto L9;
        k();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.f24967a = true;
        k();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject(this.f24971e);
        if (r13 != null) goto L8;
        return;
    L8:
        b(r13);
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public final void onTimeEvent(long r10) {
        long r11 = m();
        if (r11 > 0) goto L5;
        return;
    L5:
        if ((r10 - this.f24972f) > r11) goto L7;
        return;
    L7:
        if (this.f24967a == false) goto L12;
        h();
        this.f24972f = System.currentTimeMillis();
        return;
    }
}
