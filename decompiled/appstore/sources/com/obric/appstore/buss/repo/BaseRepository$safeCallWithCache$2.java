package com.obric.appstore.buss.repo;

import com.obric.appstore.network.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lcom/obric/appstore/network/g;", "<anonymous>", "()Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.BaseRepository$safeCallWithCache$2", f = "BaseRepository.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRepository$safeCallWithCache$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ Function2<Boolean, Continuation<? super g>, Object> $call;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRepository$safeCallWithCache$2(Function2<? super Boolean, ? super Continuation<? super g>, ? extends Object> r10, Continuation<? super BaseRepository$safeCallWithCache$2> r11) {
        this.$call = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new BaseRepository$safeCallWithCache$2(this.$call, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super g> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        Function2<Boolean, Continuation<? super g>, Object> r13 = this.$call;
        Boolean r14 = tf.a.a(true);
        this.label = 1;
        r10 = r13.mo0invoke(r14, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super g> r10) {
        return ((BaseRepository$safeCallWithCache$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
