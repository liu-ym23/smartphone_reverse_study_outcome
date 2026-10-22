package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailWrap;
import com.bytedanceos.appstore.buss.network.HttpResult;
import com.bytedanceos.appstore.buss.network.StoreHttpEngine;
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
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailWrap;", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.AppDetailRepository$getAppDetail$2", f = "AppDetailRepository.kt", i = {}, l = {21, 22, 20}, m = "invokeSuspend", n = {}, s = {})
public final class AppDetailRepository$getAppDetail$2 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    final /* synthetic */ String $entitySource;
    final /* synthetic */ String $packageName;
    final /* synthetic */ int $source;
    Object L$0;
    int label;

    public AppDetailRepository$getAppDetail$2(String r10, String r11, int r12, Continuation<? super AppDetailRepository$getAppDetail$2> r13) {
        this.$entitySource = r10;
        this.$packageName = r11;
        this.$source = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new AppDetailRepository$getAppDetail$2(this.$entitySource, this.$packageName, this.$source, r10);
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
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        c.b(r11);
    L26:
        return r11;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        BaseRepository r13 = (BaseRepository) this.L$0;
        c.b(r11);
    L22:
        Response r14 = (Response) r11;
    L18:
        Response r15 = r14;
        BaseRepository r16 = r13;
        this.L$0 = null;
        this.label = 3;
        r11 = BaseRepository.d(r16, r15, null, null, this, 6, null);
        if (r11 != r10) goto L26;
        return r10;
    L11:
        r13 = (BaseRepository) this.L$0;
        c.b(r11);
    L17:
        r14 = (Response) r11;
        goto L18
    L12:
        c.b(r11);
        r13 = AppDetailRepository.f9009a;
        if (q.b(this.$entitySource, "yyb") == false) goto L19;
        Deferred<Response<HttpResult<TvAppDetailWrap>>> r17 = StoreHttpEngine.f8778b.g().getAppDetailPInfo(this.$packageName, this.$source);
        this.L$0 = r13;
        this.label = 1;
        r11 = r17.await(this);
        if (r11 != r10) goto L17;
        return r10;
    L19:
        Deferred<Response<HttpResult<TvAppDetailWrap>>> r18 = StoreHttpEngine.f8778b.g().getAppDetailInfo(this.$packageName, this.$source);
        this.L$0 = r13;
        this.label = 2;
        r11 = r18.await(this);
        if (r11 != r10) goto L22;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((AppDetailRepository$getAppDetail$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
