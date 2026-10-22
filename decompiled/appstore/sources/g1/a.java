package g1;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.block.trace.ITracer;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.bytedance.apm.block.a implements ITracer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f19782b;

    public a() {
        this.f19782b = false;
    }

    public void f() {
    }

    public void g() {
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public boolean isAlive() {
        return this.f19782b;
    }

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
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onCloseTrace() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f19782b == false) goto L9;
        this.f19782b = false;     // Catch: Throwable -> L7
        g();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onStartTrace() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f19782b == true) goto L9;
        this.f19782b = true;     // Catch: Throwable -> L7
        f();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }
}
