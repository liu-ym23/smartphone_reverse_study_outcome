package com.obric.appstore.buss.repo;

import com.obric.appstore.network.StoreHttpEngine;
import com.obric.appstore.network.StoreService;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.PageListResp;
import com.obric.appstore.network.entity.PageTypeReq;
import com.obric.appstore.network.entity.TemplateResp;
import com.obric.appstore.network.entity.template.PageType;
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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "forceCache", "Lcom/obric/appstore/network/g;", "Lcom/obric/appstore/network/entity/PageListResp;", "Lcom/obric/appstore/network/entity/TemplateResp;", "<anonymous>", "(Z)Lcom/obric/appstore/network/g;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo$getPageDataWithCache$2", f = "StoreRepo.kt", i = {}, l = {75, 70}, m = "invokeSuspend", n = {}, s = {})
public final class StoreRepo$getPageDataWithCache$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super g>, Object> {
    final /* synthetic */ PageType $pageType;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public StoreRepo$getPageDataWithCache$2(PageType r10, Continuation<? super StoreRepo$getPageDataWithCache$2> r11) {
        this.$pageType = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        StoreRepo$getPageDataWithCache$2 r12 = new StoreRepo$getPageDataWithCache$2(this.$pageType, r11);
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
    public final Object invokeSuspend(@NotNull Object r15) {
        Object r10 = a.d();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        c.b(r15);
    L20:
        return r15;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        StoreRepo r12 = (StoreRepo) this.L$0;
        c.b(r15);
    L17:
        this.L$0 = null;
        this.label = 2;
        r15 = r12.a((Response) r15, this);
        if (r15 != r10) goto L20;
        return r10;
    L10:
        c.b(r15);
        boolean r16 = this.Z$0;
        r12 = StoreRepo.f10831a;
        StoreService r13 = StoreHttpEngine.f10958b.h();
        PageTypeReq r14 = new PageTypeReq(this.$pageType.getValue(), 0, null, 0, 100, 14, null);
        String r17 = this.$pageType.getValue();
        if (r16 == false) goto L13;
        int r18 = -1;
    L14:
        Deferred<Response<HttpResp<PageListResp<TemplateResp>>>> r19 = r13.getPageAppsWithCache(r14, r17, r18);
        this.L$0 = r12;
        this.label = 1;
        r15 = r19.await(this);
        if (r15 != r10) goto L17;
        return r10;
    L13:
        r18 = 60;
        goto L14
    }

    @Nullable
    public final Object invoke(boolean r10, @Nullable Continuation<? super g> r11) {
        return ((StoreRepo$getPageDataWithCache$2) create(Boolean.valueOf(r10), r11)).invokeSuspend(Unit.f21064a);
    }
}
