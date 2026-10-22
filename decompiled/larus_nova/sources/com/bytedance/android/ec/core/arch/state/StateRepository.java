package com.bytedance.android.ec.core.arch.state;

import com.bytedance.android.ec.core.arch.state.b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
public final class StateRepository<S extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<S> f43859a;

    public final Object a(Continuation<? super S> r100) {
        CompletableDeferred r101 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        StateRepository$awaitState$2 r102 = new StateRepository$awaitState$2(r101);
        a<S> r103 = this.f43859a;
        e r104 = new e(r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "block");
        r103.f43861b.offer(r104);
        return r101.await(r100);
    }

    public StateRepository(S r100, CoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r101, "coroutinesScope");
        this.f43859a = new a(r100, r101);
    }
}
