package com.bytedance.android.shopping.abscontainer.common_biz.module;

import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lv43/s;", "Lv43/a;", "STATE", "Lu33/a;", "PROPS", "Lkotlinx/coroutines/CoroutineScope;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.abscontainer.common_biz.module.UplinkInterceptorModule$saveUplinkCacheIfNeed$1", f = "UplinkInterceptorModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UplinkInterceptorModule$saveUplinkCacheIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.shopping.skubuy.cache.a $cacheKey;
    final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.c $copiedProtocol;
    int label;

    public UplinkInterceptorModule$saveUplinkCacheIfNeed$1(com.bytedance.kmp.ec.yata.common.protocol.data.c r100, com.bytedance.android.shopping.skubuy.cache.a r101, Continuation r102) {
        this.$copiedProtocol = r100;
        this.$cacheKey = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new UplinkInterceptorModule$saveUplinkCacheIfNeed$1(this.$copiedProtocol, this.$cacheKey, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UplinkInterceptorModule$saveUplinkCacheIfNeed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        com.bytedance.kmp.ec.yata.common.protocol.data.c r101 = this.$copiedProtocol;
        if (r101 == null) goto L8;
        Lazy r102 = SkuBuyResponseCacheHelper.f183110a;
        SkuBuyResponseCacheHelper.d(this.$cacheKey, new n33.a(r101, 2), true);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
