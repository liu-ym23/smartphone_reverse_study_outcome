package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.window.shop.repository.dto.k;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$liveHotSingleTransformers$7 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$liveHotSingleTransformers$7(c r100) {
        super(1, r100, c.class, "anchorItemDto2Vo", "anchorItemDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((c) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        k r101 = (k) r100;
        int r102 = sq3.c.f542965n;
        Intrinsics.checkNotNullParameter(r101, "dto");
        sq3.c r103 = new sq3.c();
        r101.getClass();
        r103.f542966j = r101.c();
        r103.f542967k = r101.d();
        r103.f542968l = r101.b();
        r103.f542969m = r101.a();
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        return invoke(r100);
    }
}
