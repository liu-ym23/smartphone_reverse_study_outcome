package com.obric.appstore.base;

import com.bytedanceos.common.toolbox.e0;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lcom/obric/appstore/base/j;", "LP", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.base.ILoadViewModel$load$1", f = "LoadViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class ILoadViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $loadParams;
    int label;
    final /* synthetic */ ILoadViewModel this$0;

    public ILoadViewModel$load$1(ILoadViewModel r10, j r11, Continuation<? super ILoadViewModel$load$1> r12) {
        this.this$0 = r10;
        this.$loadParams = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ILoadViewModel$load$1(this.this$0, this.$loadParams, r11);
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
    L11:
        com.obric.appstore.network.g r13 = (com.obric.appstore.network.g) r10;
        if ((r13 instanceof com.obric.appstore.network.g.d) == false) goto L15;
        this.this$0.t(((com.obric.appstore.network.g.d) r13).a(), this.$loadParams);
    L21:
        this.this$0.u(r13, this.$loadParams);
        ILoadViewModel.f(this.this$0).c(1);
        return Unit.f21064a;
    L15:
        if (this.$loadParams.b() == false) goto L21;
        if ((r13 instanceof com.obric.appstore.network.g.a) == false) goto L21;
        if (com.bytedanceos.common.toolbox.e.A0(pa.a.f23414a.a()) == true) goto L21;
        e0.e(R.string.retry_connection);
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CoroutineDispatcher r14 = l0.b();
        ILoadViewModel$load$1$newState$1 r15 = new ILoadViewModel$load$1$newState$1(this.this$0, this.$loadParams, null);
        this.label = 1;
        r10 = kotlinx.coroutines.h.g(r14, r15, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((ILoadViewModel$load$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
