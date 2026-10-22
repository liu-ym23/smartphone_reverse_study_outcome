package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowCartInfoDTO;
import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowRemoteDataSource {
    public ECWindowInnerFlowRemoteDataSource() {
    }

    public final Object b(Continuation<? super ECShopInnerFlowCartInfoDTO> r100) {
        if ((r100 instanceof ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1) == false) goto L7;
        ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1 r101 = (ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L25
    L21:
        ECShopInnerFlowCartInfoDTO r106 = (ECShopInnerFlowCartInfoDTO) r103;     // Catch: Throwable -> L25
    L23:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r107) == false) goto L31;
        return null;
    L31:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L25
        ECWindowInnerFlowApi.f189182a.getClass();     // Catch: Throwable -> L25
        ECWindowInnerFlowApi r109 = ECWindowInnerFlowApi.a.f189183a;     // Catch: Throwable -> L25
        if (r109 == null) goto L22;
        r101.label = 1;     // Catch: Throwable -> L25
        r103 = r109.getInnerFlowCartInfo(r101);     // Catch: Throwable -> L25
        if (r103 != r104) goto L21;
        return r104;
    L22:
        r106 = null;
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1(this, r100);
        goto L8
    }

    public final Object a(ECWindowInnerFlowReqParam r110, Continuation<? super ECShopInnerFlowDTO> r111) {
        if ((r111 instanceof ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1) == false) goto L7;
        ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1 r100 = (ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L25
    L21:
        ECShopInnerFlowDTO r105 = (ECShopInnerFlowDTO) r102;     // Catch: Throwable -> L25
    L23:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r106) == false) goto L31;
        return null;
    L31:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L25
        ECWindowInnerFlowApi.f189182a.getClass();     // Catch: Throwable -> L25
        ECWindowInnerFlowApi r108 = ECWindowInnerFlowApi.a.f189183a;     // Catch: Throwable -> L25
        if (r108 == null) goto L22;
        String r109 = r110.getSecAuthorId();     // Catch: Throwable -> L25
        int r113 = r110.getInnerFlowType();     // Catch: Throwable -> L25
        String r114 = r110.getCustomId();     // Catch: Throwable -> L25
        String r115 = r110.getPromotionId();     // Catch: Throwable -> L25
        String r116 = r110.getFilterPromotionIds().toString();     // Catch: Throwable -> L25
        long r117 = r110.getPageNum();     // Catch: Throwable -> L25
        Integer r118 = Boxing.boxInt(r110.getPageSize());     // Catch: Throwable -> L25
        String r119 = r110.getPassThroughApi();     // Catch: Throwable -> L25
        r112.label = 1;     // Catch: Throwable -> L25
        r102 = r108.getInnerFlowData(r109, r113, r114, r115, r116, r117, r118, r119, null, null, r112);     // Catch: Throwable -> L25
        if (r102 != r103) goto L21;
        return r103;
    L22:
        r105 = null;
    L25:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1(this, r111);
        goto L8
    }
}
