package com.obric.aiagent.assistant.utils;

import android.content.Context;
import android.os.CancellationSignal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ObricAppStatusUtility.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1", f = "ObricAppStatusUtility.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class ObricAppStatusUtility$checkApprovalAsync$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PrivacyApprovalStatus>, Object> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ObricAppStatusUtility this$0;

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObricAppStatusUtility.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1$1", f = "ObricAppStatusUtility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CancellationSignal $cancellationSignal;
        final /* synthetic */ Context $context;
        final /* synthetic */ CompletableDeferred<PrivacyApprovalStatus> $deferred;
        int label;
        final /* synthetic */ ObricAppStatusUtility this$0;

        AnonymousClass1(ObricAppStatusUtility r1, Context r2, CancellationSignal r3, CompletableDeferred<PrivacyApprovalStatus> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$context = r2;
            this.$cancellationSignal = r3;
            this.$deferred = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$context, this.$cancellationSignal, this.$deferred, r8);
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
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            PrivacyApprovalStatus r4 = this.this$0.checkApprovalSync(this.$context, this.$cancellationSignal);
            this.$deferred.complete(r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    ObricAppStatusUtility$checkApprovalAsync$result$1(ObricAppStatusUtility r1, Context r2, CancellationSignal r3, Continuation<? super ObricAppStatusUtility$checkApprovalAsync$result$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$cancellationSignal = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAppStatusUtility$checkApprovalAsync$result$1(this.this$0, this.$context, this.$cancellationSignal, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super PrivacyApprovalStatus> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super PrivacyApprovalStatus> r2) {
        return ((ObricAppStatusUtility$checkApprovalAsync$result$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CompletableDeferred r14 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(ObricAppStatusUtility.access$getMScope$p(this.this$0), null, null, new AnonymousClass1(this.this$0, this.$context, this.$cancellationSignal, r14, null), 3, null);
        this.label = 1;
        r13 = r14.await(this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
