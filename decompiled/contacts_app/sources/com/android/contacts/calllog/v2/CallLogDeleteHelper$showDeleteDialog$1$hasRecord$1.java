package com.android.contacts.calllog.v2;

import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CallLogDeleteHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1", f = "CallLogDeleteHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Set<Long> $selectedIds;
    int label;
    final /* synthetic */ CallLogDeleteHelper this$0;

    CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1(CallLogDeleteHelper r1, Set<Long> r2, Continuation<? super CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1> r3) {
        this.this$0 = r1;
        this.$selectedIds = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1(this.this$0, this.$selectedIds, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return ((CallLogDeleteHelper$showDeleteDialog$1$hasRecord$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return Boxing.boxBoolean(CallLogDeleteHelper.access$checkHasRecord(this.this$0, this.$selectedIds));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
