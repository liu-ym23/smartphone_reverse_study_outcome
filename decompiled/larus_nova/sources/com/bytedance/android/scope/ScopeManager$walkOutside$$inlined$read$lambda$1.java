package com.bytedance.android.scope;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"R", "Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/android/scope/tree/d;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/scope/tree/ScopeNode$walkOutside$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.scope.tree.ScopeNode$walkOutside$1$1", f = "ScopeNode.kt", i = {0, 0}, l = {215}, m = "invokeSuspend", n = {"$this$sequence", "cur"}, s = {"L$0", "L$1"})
public final class ScopeManager$walkOutside$$inlined$read$lambda$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super com.bytedance.android.scope.tree.d>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $action$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ com.bytedance.android.scope.tree.d this$0;

    public ScopeManager$walkOutside$$inlined$read$lambda$1(Continuation r100, com.bytedance.android.scope.tree.d r101, Function1 r102) {
        this.this$0 = r101;
        this.$action$inlined = r102;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        ScopeManager$walkOutside$$inlined$read$lambda$1 r102 = new ScopeManager$walkOutside$$inlined$read$lambda$1(r101, this.this$0, this.$action$inlined);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super com.bytedance.android.scope.tree.d> r100, Continuation<? super Unit> r101) {
        return ((ScopeManager$walkOutside$$inlined$read$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0037 -> B:13:0x003a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        com.bytedance.android.scope.tree.d r103 = (com.bytedance.android.scope.tree.d) this.L$1;
        SequenceScope r104 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        ScopeManager$walkOutside$$inlined$read$lambda$1 r105 = this;
    L13:
        r103 = r103.f163473l;
    L9:
        if (r103 == null) goto L15;
        r105.L$0 = r104;
        r105.L$1 = r103;
        r105.label = 1;
        if (r104.yield(r103, r105) != r101) goto L13;
        return r101;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        SequenceScope r106 = (SequenceScope) this.L$0;
        r103 = this.this$0;
        r104 = r106;
        r105 = this;
        goto L9
    }
}
