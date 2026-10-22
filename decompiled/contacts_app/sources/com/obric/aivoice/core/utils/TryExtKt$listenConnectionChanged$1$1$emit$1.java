package com.obric.aivoice.core.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: TryExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1$1", f = "TryExt.kt", i = {}, l = {17}, m = "emit", n = {}, s = {})
final class TryExtKt$listenConnectionChanged$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TryExtKt.AnonymousClass1.C00731<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    TryExtKt$listenConnectionChanged$1$1$emit$1(TryExtKt.AnonymousClass1.C00731<? super T> r1, Continuation<? super TryExtKt$listenConnectionChanged$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, this);
    }
}
