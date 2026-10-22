package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.window.shop.repository.dto.d1;
import com.bytedance.android.window.shop.repository.tab.entity.c0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/d1;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/dto/d1;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$videoSingleTransformers$3 extends FunctionReferenceImpl implements Function1<d1, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$videoSingleTransformers$3(e r100) {
        super(1, r100, e.class, "videoCardExplainDto2Vo", "videoCardExplainDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowVideoItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke2(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((e) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = c0.f189527s;
        return c0.a.a(203, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(d1 r100) {
        return invoke2(r100);
    }
}
