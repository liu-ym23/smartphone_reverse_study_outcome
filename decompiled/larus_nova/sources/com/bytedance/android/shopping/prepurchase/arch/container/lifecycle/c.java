package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements CoroutineScope, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f180820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f180821b;

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f180821b;
    }

    public c(Lifecycle r100, CoroutineContext r101) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "coroutineContext");
        this.f180820a = r100;
        this.f180821b = r101;
        if (r100.b() != Lifecycle.State.DESTROYED) goto L6;
        JobKt.cancel$default(r101, null, 1, null);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(e r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f180820a.b().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        this.f180820a.c(this);
        JobKt.cancel$default(this.f180821b, null, 1, null);
        return;
    }
}
