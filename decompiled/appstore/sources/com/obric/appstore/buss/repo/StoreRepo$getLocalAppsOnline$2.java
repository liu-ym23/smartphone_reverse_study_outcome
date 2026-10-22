package com.obric.appstore.buss.repo;

import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.entity.AppInfoResp;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.LocalAppsOnlineReq;
import com.obric.appstore.network.g;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/appstore/network/g;", "", "Lcom/obric/appstore/network/entity/AppInfoResp;", "<anonymous>", "()Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo$getLocalAppsOnline$2", f = "StoreRepo.kt", i = {}, l = {236, 231}, m = "invokeSuspend", n = {}, s = {})
public final class StoreRepo$getLocalAppsOnline$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ List<String> $apps;
    Object L$0;
    int label;

    public StoreRepo$getLocalAppsOnline$2(List<String> r10, Continuation<? super StoreRepo$getLocalAppsOnline$2> r11) {
        this.$apps = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new StoreRepo$getLocalAppsOnline$2(this.$apps, r10);
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
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        StoreRepo r13 = (StoreRepo) this.L$0;
        c.b(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        r10 = r13.a((Response) r10, this);
        if (r10 != r11) goto L16;
        return r11;
    L10:
        c.b(r10);
        r13 = StoreRepo.f10831a;
        Deferred<Response<HttpResp<List<AppInfoResp>>>> r14 = StoreHttpEngine.f10958b.h().getLocalAppsOnline(new LocalAppsOnlineReq(this.$apps));
        this.L$0 = r13;
        this.label = 1;
        r10 = r14.await(this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super g> r10) {
        return ((StoreRepo$getLocalAppsOnline$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
