package com.obric.appstore.buss.myapp.update;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM$pauseAllUpdates$1$1$1$2$1", f = "UpdateVM.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
public final class UpdateVM$pauseAllUpdates$1$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $it;
    int label;

    public UpdateVM$pauseAllUpdates$1$1$1$2$1(com.smt.obric.appstore.domain.app.entity.a r10, Continuation<? super UpdateVM$pauseAllUpdates$1$1$1$2$1> r11) {
        this.$it = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UpdateVM$pauseAllUpdates$1$1$1$2$1(this.$it, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        com.smt.obric.appstore.domain.usecase.app.install.c r13 = new com.smt.obric.appstore.domain.usecase.app.install.c();
        com.smt.obric.appstore.domain.app.entity.a r14 = this.$it;
        this.label = 1;
        if (r13.a(r14, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UpdateVM$pauseAllUpdates$1$1$1$2$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
