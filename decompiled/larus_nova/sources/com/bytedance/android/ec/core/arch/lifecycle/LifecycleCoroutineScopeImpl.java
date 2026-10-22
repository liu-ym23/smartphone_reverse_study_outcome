package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/arch/lifecycle/LifecycleCoroutineScopeImpl;", "Lcom/bytedance/android/ec/core/arch/lifecycle/d;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleObserver;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifecycleCoroutineScopeImpl extends d implements LifecycleEventObserver, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f43833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f43834b;

    @Override // com.bytedance.android.ec.core.arch.lifecycle.d
    public final Lifecycle a() {
        return this.f43833a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f43834b;
    }

    public LifecycleCoroutineScopeImpl(Lifecycle r100, CoroutineContext r101) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "coroutineContext");
        this.f43833a = r100;
        this.f43834b = r101;
        if (r100.getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        JobKt.cancel$default(r101, null, 1, null);
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f43833a.getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        this.f43833a.removeObserver(this);
        JobKt.cancel$default(this.f43834b, null, 1, null);
        return;
    }
}
