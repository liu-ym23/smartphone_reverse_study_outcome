package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.ad.AdHttpEngine;
import com.bytedanceos.appstore.buss.network.ad.AdHttpResult;
import com.bytedanceos.appstore.buss.network.ad.d;
import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/ad/d;", "Lcom/bytedanceos/common/ad/entity/rep/RepAdEntity;", "Lcom/bytedanceos/common/ad/entity/rep/media/RepSplashMediaEntity;", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/ad/d;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.repository.AppSplashRepository$getAd$2", f = "AppSplashRepository.kt", i = {}, l = {19, 19}, m = "invokeSuspend", n = {}, s = {})
public final class AppSplashRepository$getAd$2 extends SuspendLambda implements Function1<Continuation<? super d>, Object> {
    final /* synthetic */ RequestBody $requestBody;
    Object L$0;
    int label;

    public AppSplashRepository$getAd$2(RequestBody r10, Continuation<? super AppSplashRepository$getAd$2> r11) {
        this.$requestBody = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new AppSplashRepository$getAd$2(this.$requestBody, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super d> r10) {
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
        AppSplashRepository r13 = (AppSplashRepository) this.L$0;
        c.b(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        r10 = AppSplashRepository.c(r13, (Response) r10, this);
        if (r10 != r11) goto L16;
        return r11;
    L10:
        c.b(r10);
        r13 = AppSplashRepository.f9013a;
        Deferred<Response<AdHttpResult<RepAdEntity<RepSplashMediaEntity>>>> r14 = AdHttpEngine.f8783b.f().getAd(this.$requestBody);
        this.L$0 = r13;
        this.label = 1;
        r10 = r14.await(this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super d> r10) {
        return ((AppSplashRepository$getAd$2) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
