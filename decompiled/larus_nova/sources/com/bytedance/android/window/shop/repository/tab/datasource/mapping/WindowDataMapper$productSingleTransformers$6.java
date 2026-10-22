package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.window.shop.repository.dto.q;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/q;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/dto/q;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$6 extends FunctionReferenceImpl implements Function1<q, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$productSingleTransformers$6(d r100) {
        super(1, r100, d.class, "couponBarDto2Vo", "couponBarDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowCouponItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke2(q r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((d) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        fo.a<tq3.a> r101 = tq3.a.f547127k;
        if (r100 == null) goto L5;
        List<q.c> r102 = r100.a();
    L6:
        List<q.c> r103 = r102;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        return new tq3.a(CollectionsKt.emptyList());
    L16:
        return new tq3.a(r102);
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(q r100) {
        return invoke2(r100);
    }
}
