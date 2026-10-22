package w2;

import android.app.Activity;
import com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy;
import com.bytedance.apm6.cpu.exception.ICpuExceptionState;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;

/* JADX INFO: loaded from: classes.dex */
public class d extends q3.a implements ICpuExceptionPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile v2.d f25309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityLifecycleService f25310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ICpuExceptionState f25311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ICpuExceptionState f25312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ICpuExceptionState f25313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ICpuExceptionState f25314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ICpuExceptionState f25315g;

    public d() {
        ActivityLifecycleService r10 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
        this.f25310b = r10;
        this.f25309a = new v2.d(r10);
        this.f25311c = new f(this.f25309a);
        this.f25312d = new g(this.f25309a);
        this.f25313e = new h(this.f25309a);
        this.f25314f = new c(this.f25309a);
        this.f25315g = new e(this.f25309a);
        this.f25309a.c(this.f25311c, this.f25312d, this.f25313e, this.f25314f, this.f25315g);
        this.f25310b.register(this);
    }

    @Override // q3.a, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onBackground(Activity r10) {
        this.f25309a.g(true);
    }

    @Override // q3.a, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onFront(Activity r10) {
        this.f25309a.g(false);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy
    public void startDetect(u2.b r10) {
        this.f25309a.k(r10);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy
    public void stopDetect() {
        this.f25309a.l();
    }
}
