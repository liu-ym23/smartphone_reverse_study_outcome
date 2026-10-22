package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.window.shop.repository.dto.i0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$2 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$2(h r100) {
        super(1, r100, h.class, "fansBuyDto2Vo", "fansBuyDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((h) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = oq3.d.f524874l;
        i0 r102 = (i0) r100;
        Intrinsics.checkNotNullParameter(r102, "dto");
        oq3.d r103 = new oq3.d();
        r103.f524875j = r102.a();
        r103.f524876k = r102.b();
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        return invoke(r100);
    }
}
