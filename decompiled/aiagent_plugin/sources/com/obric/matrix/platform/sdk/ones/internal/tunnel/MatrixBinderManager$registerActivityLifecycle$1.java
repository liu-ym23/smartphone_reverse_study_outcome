package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: MatrixBinderManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MatrixBinderManager$registerActivityLifecycle$1 implements Application.ActivityLifecycleCallbacks {
    MatrixBinderManager$registerActivityLifecycle$1() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin"), "activity");
        d.f33701a.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "activity");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixBinderManagerlifecycle", "onActivityStart", null, 4, null);
        d.f33701a.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "activity");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixBinderManagerlifecycle", "onActivityResume", null, 4, null);
        d.f33701a.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "activity");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixBinderManagerlifecycle", "onActivityPaused", null, 4, null);
        d.f33701a.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "activity");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixBinderManagerlifecycle", "onActivityStop", null, 4, null);
        d.f33701a.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        o.e(r3, "outState");
        d.f33701a.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        d.f33701a.f();
    }
}
