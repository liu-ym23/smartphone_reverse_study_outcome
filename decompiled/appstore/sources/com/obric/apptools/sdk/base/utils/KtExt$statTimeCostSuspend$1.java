package com.obric.apptools.sdk.base.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "com.obric.apptools.sdk.base.utils.KtExt", f = "KtExt.kt", i = {0, 0, 0}, l = {67}, m = "statTimeCostSuspend", n = {"tag", "signature", "start"}, s = {"L$0", "L$1", "J$0"})
final class KtExt$statTimeCostSuspend$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public KtExt$statTimeCostSuspend$1(a r10, Continuation<? super KtExt$statTimeCostSuspend$1> r11) {
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
