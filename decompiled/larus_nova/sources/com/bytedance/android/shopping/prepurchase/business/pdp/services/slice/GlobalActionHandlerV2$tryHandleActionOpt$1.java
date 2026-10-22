package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.GlobalActionHandlerV2$tryHandleActionOpt$1", f = "GlobalActionHandlerV2.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
final class GlobalActionHandlerV2$tryHandleActionOpt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e73.a $actions;
    int label;
    final /* synthetic */ c this$0;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GlobalActionHandlerV2$tryHandleActionOpt$1 f182139c;

        @Override // java.lang.Runnable
        public final void run() {
            if (PdpPerfOpt.c() == false) goto L5;
            GlobalActionHandlerV2$tryHandleActionOpt$1 r100 = this.f182139c;
            r100.this$0.a(r100.$actions);
        L5:
            GlobalActionHandlerV2$tryHandleActionOpt$1 r101 = this.f182139c;
            c r102 = r101.this$0;
            e73.a r103 = r101.$actions;
            if (r102.f182167c == true) goto L10;
            r102.f182167c = true;
            r102.b(r103.a());
            return;
        }

        public a(GlobalActionHandlerV2$tryHandleActionOpt$1 r100) {
            this.f182139c = r100;
            super("handle_global_action");
        }
    }

    public GlobalActionHandlerV2$tryHandleActionOpt$1(c r100, e73.a r101, Continuation r102) {
        this.this$0 = r100;
        this.$actions = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new GlobalActionHandlerV2$tryHandleActionOpt$1(this.this$0, this.$actions, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GlobalActionHandlerV2$tryHandleActionOpt$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ((com.bytedance.android.shopping.prepurchase.arch.container.ability.l) r100).e1(new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.bytedance.android.shopping.prepurchase.arch.container.component.j r103 = this.this$0.f182170f;
        this.label = 1;
        r100 = r103.e(com.bytedance.android.shopping.prepurchase.arch.container.ability.l.class, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
