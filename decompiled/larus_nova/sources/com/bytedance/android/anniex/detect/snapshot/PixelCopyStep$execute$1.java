package com.bytedance.android.anniex.detect.snapshot;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.snapshot.PixelCopyStep", f = "PixelCopyStep.kt", i = {0, 0}, l = {37}, m = "execute", n = {"this", "captureLog"}, s = {"L$0", "L$1"})
public final class PixelCopyStep$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PixelCopyStep this$0;

    public PixelCopyStep$execute$1(PixelCopyStep r100, Continuation<? super PixelCopyStep$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
