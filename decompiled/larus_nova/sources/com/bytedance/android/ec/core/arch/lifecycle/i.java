package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public final class i {
    public static final Object a(LifecycleOwner r100, Lifecycle.State r101, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super Unit> r103) {
        Lifecycle r104 = r100.getLifecycle();
        if (r101 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L20;
        if (r104.getCurrentState() != Lifecycle.State.DESTROYED) goto L10;
        Object r106 = Unit.INSTANCE;
    L15:
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r106;
    L18:
        return Unit.INSTANCE;
    L10:
        r106 = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(r104, r101, r102, null), r103);
        if (r106 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r106 = Unit.INSTANCE;
        goto L15
    L20:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r105 = false;
        goto L6
    }
}
