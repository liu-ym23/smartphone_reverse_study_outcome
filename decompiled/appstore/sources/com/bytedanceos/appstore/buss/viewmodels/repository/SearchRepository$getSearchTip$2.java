package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.StoreHttpEngine;
import com.bytedanceos.appstore.buss.network.StoreService;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.buss.network.h;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/SearchAssociateEntityWrap;", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.SearchRepository$getSearchTip$2", f = "SearchRepository.kt", i = {}, l = {40, 40}, m = "invokeSuspend", n = {}, s = {})
public final class SearchRepository$getSearchTip$2 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    final /* synthetic */ String $appName;
    Object L$0;
    int label;

    public SearchRepository$getSearchTip$2(String r10, Continuation<? super SearchRepository$getSearchTip$2> r11) {
        this.$appName = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new SearchRepository$getSearchTip$2(this.$appName, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super h> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r13) {
        Object r10 = a.d();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        c.b(r13);
    L17:
        return r13;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        BaseRepository r12 = (BaseRepository) this.L$0;
        c.b(r13);
    L10:
        BaseRepository r14 = r12;
        this.L$0 = null;
        this.label = 2;
        r13 = BaseRepository.d(r14, (Response) r13, null, null, this, 6, null);
        if (r13 != r10) goto L17;
        return r10;
    L11:
        c.b(r13);
        r12 = SearchRepository.f9037a;
        Deferred r15 = StoreService.b.c(StoreHttpEngine.f8778b.g(), this.$appName, 0, 2, null);
        this.L$0 = r12;
        this.label = 1;
        r13 = r15.await(this);
        if (r13 != r10) goto L10;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((SearchRepository$getSearchTip$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
