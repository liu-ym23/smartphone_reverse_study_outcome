package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Application.ActivityLifecycleCallbacks {
    public i() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity r10, @Nullable Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity r10, @NotNull Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
    }
}
