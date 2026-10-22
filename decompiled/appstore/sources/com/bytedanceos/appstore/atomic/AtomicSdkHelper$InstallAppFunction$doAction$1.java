package com.bytedanceos.appstore.atomic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.atomic.AtomicSdkHelper$InstallAppFunction", f = "AtomicSdkHelper.kt", i = {0}, l = {60}, m = "doAction", n = {"keyWord"}, s = {"L$0"})
final class AtomicSdkHelper$InstallAppFunction$doAction$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a.C0108a this$0;

    public AtomicSdkHelper$InstallAppFunction$doAction$1(a.C0108a r10, Continuation<? super AtomicSdkHelper$InstallAppFunction$doAction$1> r11) {
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
