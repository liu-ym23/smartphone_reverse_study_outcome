package ao6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f15795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Application> f15796b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.f();
        this.f15796b.element.unregisterActivityLifecycleCallbacks(this);
        this.f15795a.f15797a = null;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.g();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.i();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.getClass();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.getClass();
        return;
    }

    public a(b r100, Ref.ObjectRef<Application> r101) {
        this.f15795a = r100;
        this.f15796b = r101;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.e(r101);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (b.a(this.f15795a, r100) == false) goto L6;
        this.f15795a.h(r101);
        return;
    }
}
