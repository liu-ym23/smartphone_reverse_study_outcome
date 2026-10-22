package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.window.shop.repository.dto.f0;
import com.bytedance.android.window.shop.repository.dto.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$4 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$4(h r100) {
        super(1, r100, h.class, "bubble2Vo", "bubble2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((h) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = oq3.b.f524869k;
        f0 r102 = (f0) r100;
        Intrinsics.checkNotNullParameter(r102, "dto");
        oq3.b r103 = new oq3.b();
        List<n> r104 = r102.a();
        if (r104 == null) goto L8;
        List<n> r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L6:
        if (r107.hasNext() == false) goto L9;
        n r108 = (n) r107.next();
        int r109 = uq3.e.f551217h;
        r106.add(uq3.e.a.a(r108));
    L9:
        r103.f524870j = r106;
        return r103;
    L8:
        r106 = null;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        return invoke(r100);
    }
}
