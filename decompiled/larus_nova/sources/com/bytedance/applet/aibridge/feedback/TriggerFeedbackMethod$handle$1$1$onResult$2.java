package com.bytedance.applet.aibridge.feedback;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.feedback.TriggerFeedbackMethod$handle$1$1$onResult$2", f = "TriggerFeedbackMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TriggerFeedbackMethod$handle$1$1$onResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    int label;

    public TriggerFeedbackMethod$handle$1$1$onResult$2(Fragment r100, Continuation<? super TriggerFeedbackMethod$handle$1$1$onResult$2> r101) {
        this.$fragment = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TriggerFeedbackMethod$handle$1$1$onResult$2(this.$fragment, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TriggerFeedbackMethod$handle$1$1$onResult$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        s r101 = s.f544207a;
        Context r102 = this.$fragment.getContext();
        r101.getClass();
        s.o(r102, R.string.larus_dislike_feedback_submit_toast, false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
