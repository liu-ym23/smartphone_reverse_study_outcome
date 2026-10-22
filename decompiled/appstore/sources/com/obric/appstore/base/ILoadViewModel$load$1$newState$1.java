package com.obric.appstore.base;

import com.obric.appstore.util.t;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lcom/obric/appstore/base/j;", "LP", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/appstore/network/g;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.base.ILoadViewModel$load$1$newState$1", f = "LoadViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLoadViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadViewModel.kt\ncom/obric/appstore/base/ILoadViewModel$load$1$newState$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,238:1\n1#2:239\n*E\n"})
public final class ILoadViewModel$load$1$newState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.obric.appstore.network.g>, Object> {
    final /* synthetic */ j $loadParams;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ILoadViewModel this$0;

    public ILoadViewModel$load$1$newState$1(ILoadViewModel r10, j r11, Continuation<? super ILoadViewModel$load$1$newState$1> r12) {
        this.this$0 = r10;
        this.$loadParams = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ILoadViewModel$load$1$newState$1 r12 = new ILoadViewModel$load$1$newState$1(this.this$0, this.$loadParams, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super com.obric.appstore.network.g> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L11;
        ILoadViewModel r13 = (ILoadViewModel) this.L$1;
        j r14 = (j) this.L$0;
        kotlin.c.b(r10);     // Catch: Throwable -> L8
    L17:
        Object r15 = Result.m35constructorimpl(r13.g(r14, (com.obric.appstore.network.g) r10));     // Catch: Throwable -> L8
    L20:
        Throwable r16 = Result.m38exceptionOrNullimpl(r15);
        if (r16 != null) goto L23;
    L26:
        Throwable r17 = Result.m38exceptionOrNullimpl(r15);
        if (r17 != null) goto L30;
        return r15;
    L30:
        return t.a(r17);
    L23:
        if ((r16 instanceof CancellationException) == false) goto L26;
        throw r16;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlin.c.b(r10);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        ILoadViewModel r19 = this.this$0;
        j r20 = this.$loadParams;
        Result.a r21 = Result.Companion;     // Catch: Throwable -> L8
        this.L$0 = r20;     // Catch: Throwable -> L8
        this.L$1 = r19;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        Object r22 = r19.j(r20, this);     // Catch: Throwable -> L8
        if (r22 != r11) goto L16;
        return r11;
    L16:
        r13 = r19;
        r10 = r22;
        r14 = r20;
    L8:
        th = move-exception;
        Result.a r23 = Result.Companion;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L20
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super com.obric.appstore.network.g> r11) {
        return ((ILoadViewModel$load$1$newState$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
