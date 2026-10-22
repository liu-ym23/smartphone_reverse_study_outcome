package com.obric.appstore.buss.repo;

import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.SearchSuggestReq;
import com.obric.appstore.network.entity.SearchSuggestResp;
import com.obric.appstore.network.g;
import com.obric.appstore.network.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/appstore/network/g;", "", "Lza/b;", "<anonymous>", "()Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo$getSearchSuggestApps$2", f = "StoreRepo.kt", i = {}, l = {152, 149}, m = "invokeSuspend", n = {}, s = {})
public final class StoreRepo$getSearchSuggestApps$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ String $kwd;
    Object L$0;
    int label;

    public StoreRepo$getSearchSuggestApps$2(String r10, Continuation<? super StoreRepo$getSearchSuggestApps$2> r11) {
        this.$kwd = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new StoreRepo$getSearchSuggestApps$2(this.$kwd, r10);
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
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        c.b(r10);
    L16:
        final ArrayList r13 = new ArrayList();
        return h.a((g) r10, new StoreRepo$getSearchSuggestApps$2$1$1(r13));
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        StoreRepo r14 = (StoreRepo) this.L$0;
        c.b(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        r10 = r14.a((Response) r10, this);
        if (r10 != r11) goto L16;
        return r11;
    L10:
        c.b(r10);
        r14 = StoreRepo.f10831a;
        Deferred<Response<HttpResp<SearchSuggestResp>>> r15 = StoreHttpEngine.f10958b.h().getSearchSuggestApps(new SearchSuggestReq(this.$kwd));
        this.L$0 = r14;
        this.label = 1;
        r10 = r15.await(this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super g> r10) {
        return ((StoreRepo$getSearchSuggestApps$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
