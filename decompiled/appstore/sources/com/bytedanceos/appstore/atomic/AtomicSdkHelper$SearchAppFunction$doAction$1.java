package com.bytedanceos.appstore.atomic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.atomic.AtomicSdkHelper$SearchAppFunction", f = "AtomicSdkHelper.kt", i = {0}, l = {103}, m = "doAction", n = {"keyWord"}, s = {"L$0"})
final class AtomicSdkHelper$SearchAppFunction$doAction$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a.c this$0;

    public AtomicSdkHelper$SearchAppFunction$doAction$1(a.c r10, Continuation<? super AtomicSdkHelper$SearchAppFunction$doAction$1> r11) {
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
