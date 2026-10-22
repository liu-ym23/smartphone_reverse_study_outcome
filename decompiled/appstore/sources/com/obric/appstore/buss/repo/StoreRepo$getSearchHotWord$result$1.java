package com.obric.appstore.buss.repo;

import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.StoreService;
import com.obric.appstore.network.entity.HotWordsReq;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.PageReq;
import com.obric.appstore.network.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "forceCache", "Lcom/obric/appstore/network/g;", "Lcom/obric/appstore/network/entity/HotWordsReq;", "<anonymous>", "(Z)Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo$getSearchHotWord$result$1", f = "StoreRepo.kt", i = {}, l = {94, 91}, m = "invokeSuspend", n = {}, s = {})
public final class StoreRepo$getSearchHotWord$result$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super g>, Object> {
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public StoreRepo$getSearchHotWord$result$1(Continuation<? super StoreRepo$getSearchHotWord$result$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        StoreRepo$getSearchHotWord$result$1 r12 = new StoreRepo$getSearchHotWord$result$1(r11);
        r12.Z$0 = ((Boolean) r10).booleanValue();
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(Boolean r10, Continuation<? super g> r11) {
        return invoke(r10.booleanValue(), r11);
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
    L20:
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        StoreRepo r13 = (StoreRepo) this.L$0;
        c.b(r10);
    L17:
        this.L$0 = null;
        this.label = 2;
        r10 = r13.a((Response) r10, this);
        if (r10 != r11) goto L20;
        return r11;
    L10:
        c.b(r10);
        boolean r14 = this.Z$0;
        r13 = StoreRepo.f10831a;
        StoreService r15 = StoreHttpEngine.f10958b.h();
        PageReq r16 = new PageReq(0, 0, 3, null);
        if (r14 == false) goto L13;
        int r17 = -1;
    L14:
        Deferred<Response<HttpResp<HotWordsReq>>> r18 = r15.getSearchHotWords(r16, r17);
        this.L$0 = r13;
        this.label = 1;
        r10 = r18.await(this);
        if (r10 != r11) goto L17;
        return r11;
    L13:
        r17 = 60;
        goto L14
    }

    @Nullable
    public final Object invoke(boolean r10, @Nullable Continuation<? super g> r11) {
        return ((StoreRepo$getSearchHotWord$result$1) create(Boolean.valueOf(r10), r11)).invokeSuspend(Unit.f21064a);
    }
}
