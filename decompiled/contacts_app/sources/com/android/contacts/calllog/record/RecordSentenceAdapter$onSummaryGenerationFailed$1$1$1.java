package com.android.contacts.calllog.record;

import android.content.Context;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.model.CallFeatureModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RecordSentenceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.android.contacts.calllog.record.RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1", f = "RecordSentenceAdapter.kt", i = {}, l = {505}, m = "invokeSuspend", n = {}, s = {})
final class RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordSentenceAdapter.HeaderHolder $holder;
    final /* synthetic */ ViewGroup $this_apply;
    int label;
    final /* synthetic */ RecordSentenceAdapter this$0;

    /* JADX INFO: renamed from: com.android.contacts.calllog.record.RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecordSentenceAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.record.RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1$1", f = "RecordSentenceAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RecordSentenceAdapter.HeaderHolder $holder;
        final /* synthetic */ CallSummaryResult $result;
        int label;
        final /* synthetic */ RecordSentenceAdapter this$0;

        AnonymousClass1(CallSummaryResult r1, RecordSentenceAdapter r2, RecordSentenceAdapter.HeaderHolder r3, Continuation<? super AnonymousClass1> r4) {
            this.$result = r1;
            this.this$0 = r2;
            this.$holder = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$result, this.this$0, this.$holder, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (CallSummaryGenerateManager.resultSuccess(this.$result) == true) goto L8;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("CallRecordAndSummaryActivity_RecordSentenceAdapter", "onSummaryGenerationFailed: retry summary failed");
            this.this$0.onSummaryGenerationFailed(this.$holder);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1(RecordSentenceAdapter r1, ViewGroup r2, RecordSentenceAdapter.HeaderHolder r3, Continuation<? super RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1> r4) {
        this.this$0 = r1;
        this.$this_apply = r2;
        this.$holder = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1(this.this$0, this.$this_apply, this.$holder, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((RecordSentenceAdapter$onSummaryGenerationFailed$1$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        Pair<Long, String> r9 = new Pair(Boxing.boxLong(RecordSentenceAdapter.access$getCallCreateTime$p(this.this$0)), RecordSentenceAdapter.access$getPhoneNumber$p(this.this$0));
        CallFeatureModel.INSTANCE.callSummaryStarted(r9);
        CallSummaryGenerateManager r2 = CallSummaryGenerateManager.INSTANCE;
        Context r3 = this.$this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        CallSummaryResult r4 = r2.retryCallSummary(r3, RecordSentenceAdapter.access$getCallCreateTime$p(this.this$0), RecordSentenceAdapter.access$getPhoneNumber$p(this.this$0));
        CallFeatureModel.INSTANCE.callSummaryFinished(r9, r4);
        this.label = 1;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(r4, this.this$0, this.$holder, null), this) != r0) goto L12;
        return r0;
    }
}
