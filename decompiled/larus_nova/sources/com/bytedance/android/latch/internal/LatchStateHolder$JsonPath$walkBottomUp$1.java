package com.bytedance.android.latch.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/android/latch/internal/LatchStateHolder$JsonPath;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.latch.internal.LatchStateHolder$JsonPath$walkBottomUp$1", f = "LatchStateHolder.kt", i = {0, 0}, l = {176}, m = "invokeSuspend", n = {"$this$sequence", "current"}, s = {"L$0", "L$1"})
public final class LatchStateHolder$JsonPath$walkBottomUp$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super LatchStateHolder.JsonPath>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LatchStateHolder.JsonPath this$0;

    public LatchStateHolder$JsonPath$walkBottomUp$1(LatchStateHolder.JsonPath r100, Continuation<? super LatchStateHolder$JsonPath$walkBottomUp$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        LatchStateHolder$JsonPath$walkBottomUp$1 r102 = new LatchStateHolder$JsonPath$walkBottomUp$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super LatchStateHolder.JsonPath> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super LatchStateHolder.JsonPath> r100, Continuation<? super Unit> r101) {
        return ((LatchStateHolder$JsonPath$walkBottomUp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:15:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        LatchStateHolder.JsonPath r103 = (LatchStateHolder.JsonPath) this.L$1;
        SequenceScope r104 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        LatchStateHolder$JsonPath$walkBottomUp$1 r105 = this;
    L15:
        r103 = r103.f58273b;
    L9:
        if (r103 == null) goto L17;
        LatchStateHolder.JsonPath r106 = LatchStateHolder.JsonPath.f58271c;
        if (Intrinsics.areEqual(r103, LatchStateHolder.JsonPath.f58271c) == true) goto L17;
        r105.L$0 = r104;
        r105.L$1 = r103;
        r105.label = 1;
        if (r104.yield(r103, r105) != r101) goto L15;
        return r101;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        SequenceScope r107 = (SequenceScope) this.L$0;
        r103 = this.this$0;
        r104 = r107;
        r105 = this;
        goto L9
    }
}
