package com.obric.appstore.buss.repo;

import com.obric.appstore.network.b;
import com.obric.appstore.network.d;
import com.obric.appstore.network.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/appstore/network/g;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.BaseRepository$executeResponse$2", f = "BaseRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRepository$executeResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ b $apiResponse;
    int label;

    public BaseRepository$executeResponse$2(b r10, Continuation<? super BaseRepository$executeResponse$2> r11) {
        this.$apiResponse = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new BaseRepository$executeResponse$2(this.$apiResponse, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super g> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        a.d();
        if (this.label != 0) goto L14;
        c.b(r10);
        b r11 = this.$apiResponse;
        if ((r11 instanceof d) == false) goto L8;
        return new g.d(((d) r11).a().getData());
    L8:
        if ((r11 instanceof com.obric.appstore.network.a) == false) goto L12;
        return new g.a(((com.obric.appstore.network.a) r11).a(), ((com.obric.appstore.network.a) this.$apiResponse).b());
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super g> r11) {
        return ((BaseRepository$executeResponse$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
