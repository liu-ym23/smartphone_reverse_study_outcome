package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import up3.f;
import up3.g;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<g, vp3.b> f189185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.window.shop.repository.tab.datasource.impl.g f189186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECWindowInnerFlowReqParam f189187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECWindowInnerFlowRemoteDataSource f189188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutexImpl f189189e;

    public ECWindowInnerFlowRepo() {
        this.f189185a = new b(MapsKt.mapOf(TuplesKt.to(602, new Pair(f.class, new ECWindowInnerFlowRepo$mixDataTransformer$1(a.f189190a)))));
        ECWindowInnerFlowRemoteDataSource r100 = new ECWindowInnerFlowRemoteDataSource();
        this.f189186b = new com.bytedance.android.window.shop.repository.tab.datasource.impl.g();
        this.f189187c = new ECWindowInnerFlowReqParam();
        this.f189188d = r100;
        this.f189189e = kotlinx.coroutines.sync.b.a();
    }

    public final Object b(Continuation<? super e<List<vp3.b>>> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECWindowInnerFlowRepo$getInnerFlowData$2(this, null), r100);
    }

    public final Object d(Continuation<? super vp3.a> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECWindowInnerFlowRepo$getShopCartInfo$2(this, null), r100);
    }

    public static final void a(ECWindowInnerFlowRepo r100, List r101) {
        r100.getClass();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((vp3.b) r103.next()).getClass();
        goto L4
    L6:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        ((vp3.b) r105.next()).getClass();
        r104.add(null);
        goto L8
    L10:
        List r106 = CollectionsKt.toMutableList(r104);
        String r107 = r100.f189187c.getCustomId();
        if (r107 == null) goto L13;
        r106.add(r107);
        r100.f189187c.setCustomId(null);
        r100.f189187c.setPromotionId(null);
    L13:
        Iterator r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L24;
        String r109 = (String) r108.next();
        StringBuilder r110 = r100.f189187c.getFilterPromotionIds();
        if (r100.f189187c.getFilterPromotionIds().length() != 0) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == true) goto L23;
        r109 = "," + r109;
    L23:
        r110.append(r109);
        goto L15
    L19:
        r111 = false;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    public final Object c(ECWindowInnerFlowReqParam r100, Continuation<? super ECShopInnerFlowDTO> r110) {
        if ((r110 instanceof ECWindowInnerFlowRepo$getInnerFlowDataSafely$1) == false) goto L7;
        ECWindowInnerFlowRepo$getInnerFlowDataSafely$1 r101 = (ECWindowInnerFlowRepo$getInnerFlowDataSafely$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ?? r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L35:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (ECWindowInnerFlowReqParam) r101.L$1;
        ECWindowInnerFlowRepo r106 = (ECWindowInnerFlowRepo) r101.L$0;
        ResultKt.throwOnFailure(r111);
        ?? r112 = r111;
    L20:
        r111 = (ECShopInnerFlowDTO) r112;
        if (r111 != 0) goto L24;
        return null;
    L24:
        if (r111.getHasMore() == false) goto L35;
        List<g> r107 = r111.getMixCards();
        if (r107 != null) goto L28;
    L31:
        if (r105 == false) goto L35;
        r100.setPageNum(r111.getCursor());
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        r111 = r106.c(r100, r101);
        if (r111 != r103) goto L35;
        return r103;
    L28:
        if (r107.isEmpty() == true) goto L31;
        r105 = false;
        goto L31
    L16:
        ResultKt.throwOnFailure(r111);
        ECWindowInnerFlowRemoteDataSource r113 = this.f189188d;
        r101.L$0 = this;
        r101.L$1 = r100;
        r101.label = 1;
        Object r114 = r113.a(r100, r101);
        if (r114 != r103) goto L19;
        return r103;
    L19:
        r106 = this;
        r112 = r114;
    L7:
        r101 = new ECWindowInnerFlowRepo$getInnerFlowDataSafely$1(this, r110);
        goto L8
    }
}
