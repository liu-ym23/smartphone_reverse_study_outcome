package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.AssistantSearchResultEntityWrap;
import com.bytedanceos.appstore.buss.network.AssistantHttpEngine;
import com.bytedanceos.appstore.buss.network.AssistantHttpResult;
import com.bytedanceos.appstore.buss.network.StoreService;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.common.toolbox.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntityWrap;", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.SearchRepository$getSearchAppsForAssistant$2", f = "SearchRepository.kt", i = {}, l = {79, 80}, m = "invokeSuspend", n = {}, s = {})
final class SearchRepository$getSearchAppsForAssistant$2 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    final /* synthetic */ RequestBody $requestBody;
    int label;

    public SearchRepository$getSearchAppsForAssistant$2(RequestBody r10, Continuation<? super SearchRepository$getSearchAppsForAssistant$2> r11) {
        this.$requestBody = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new SearchRepository$getSearchAppsForAssistant$2(this.$requestBody, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super h> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        c.b(r11);
    L16:
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        c.b(r11);
    L13:
        SearchRepository r13 = SearchRepository.f9037a;
        this.label = 2;
        r11 = BaseRepository.b(r13, (Response) r11, null, null, this, 6, null);
        if (r11 != r10) goto L16;
        return r10;
    L10:
        c.b(r11);
        j.a("StoreAtomic  getSearchAppsForAssistant start");
        StoreService r14 = AssistantHttpEngine.f8771b.g();
        RequestBody r15 = this.$requestBody;
        q.f(r15, "$requestBody");
        Deferred<Response<AssistantHttpResult<AssistantSearchResultEntityWrap>>> r16 = r14.getSearchAppsForAssistant(r15);
        this.label = 1;
        r11 = r16.await(this);
        if (r11 != r10) goto L13;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((SearchRepository$getSearchAppsForAssistant$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
