package com.obric.appstore.buss.search;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/appstore/network/g;", "it", "", "<anonymous>", "(Lcom/obric/appstore/network/g;)Z"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1", f = "SearchAppFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1 extends SuspendLambda implements Function2<com.obric.appstore.network.g, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1(Continuation<? super SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1 r12 = new SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull com.obric.appstore.network.g r10, @Nullable Continuation<? super Boolean> r11) {
        return ((SearchAppFragment$autoDownloadIfFirstExactMatch$2$firstLoadResult$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L14;
        kotlin.c.b(r10);
        com.obric.appstore.network.g r11 = (com.obric.appstore.network.g) this.L$0;
        if ((r11 instanceof com.obric.appstore.network.g.d) == false) goto L7;
    L10:
        boolean r12 = true;
    L12:
        return tf.a.a(r12);
    L7:
        if ((r11 instanceof com.obric.appstore.network.g.a) == true) goto L10;
        r12 = false;
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(com.obric.appstore.network.g r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }
}
