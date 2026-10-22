package com.obric.appstore.buss.repo;

import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.PageAppsResp;
import com.obric.appstore.network.entity.SearchAppsReq;
import com.obric.appstore.network.g;
import com.obric.appstore.network.h;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/appstore/network/g;", "Lcom/obric/appstore/network/entity/PageListResp;", "Lcom/bytedanceos/common/model/AppInfo;", "<anonymous>", "()Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo$getSearchApps$2", f = "StoreRepo.kt", i = {}, l = {177, 174}, m = "invokeSuspend", n = {}, s = {})
public final class StoreRepo$getSearchApps$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ String $kwd;
    final /* synthetic */ int $page;
    Object L$0;
    int label;

    public StoreRepo$getSearchApps$2(String r10, int r11, Continuation<? super StoreRepo$getSearchApps$2> r12) {
        this.$kwd = r10;
        this.$page = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new StoreRepo$getSearchApps$2(this.$kwd, this.$page, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super g> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = a.d();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        c.b(r12);
    L17:
        return h.a((g) r12, StoreRepo$getSearchApps$2$1$1.INSTANCE);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        StoreRepo r13 = (StoreRepo) this.L$0;
        c.b(r12);
    L13:
        this.L$0 = null;
        this.label = 2;
        r12 = r13.a((Response) r12, this);
        if (r12 != r10) goto L17;
        return r10;
    L10:
        c.b(r12);
        r13 = StoreRepo.f10831a;
        Deferred<Response<HttpResp<PageAppsResp<CommonAppEntity>>>> r14 = StoreHttpEngine.f10958b.h().getSearchApps(new SearchAppsReq(this.$kwd, this.$page, 0, 4, null));
        this.L$0 = r13;
        this.label = 1;
        r12 = r14.await(this);
        if (r12 != r10) goto L13;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super g> r10) {
        return ((StoreRepo$getSearchApps$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
