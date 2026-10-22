package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$liveHotSingleTransformers$3 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$liveHotSingleTransformers$3(c r100) {
        super(1, r100, c.class, "liveAppointmentDto2Vo", "liveAppointmentDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((c) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = sq3.g.f542979n;
        com.bytedance.android.window.shop.repository.dto.h r102 = (com.bytedance.android.window.shop.repository.dto.h) r100;
        Intrinsics.checkNotNullParameter(r102, "dto");
        sq3.g r103 = new sq3.g();
        r102.getClass();
        r103.f542980j = r102.d();
        r103.f542981k = r102.a();
        r103.f542982l = r102.c();
        r103.f542983m = r102.b();
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        return invoke(r100);
    }
}
