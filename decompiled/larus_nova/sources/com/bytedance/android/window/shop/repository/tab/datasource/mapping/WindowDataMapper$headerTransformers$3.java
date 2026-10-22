package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.window.shop.repository.dto.h0;
import com.bytedance.android.window.shop.repository.dto.r0;
import com.bytedance.android.window.shop.repository.dto.x;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uq3.k;
import uq3.p;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$3 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$3(h r100) {
        super(1, r100, h.class, "everyoneTalkDto2Vo", "everyoneTalkDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((h) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = oq3.c.f524871l;
        h0 r102 = (h0) r100;
        Intrinsics.checkNotNullParameter(r102, "dto");
        oq3.c r103 = new oq3.c();
        List<r0> r104 = r102.b();
        k r105 = null;
        if (r104 == null) goto L8;
        List<r0> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L6:
        if (r108.hasNext() == false) goto L9;
        r0 r109 = (r0) r108.next();
        int r110 = p.f551273c;
        Intrinsics.checkNotNullParameter(r109, "dto");
        p r111 = new p();
        r111.f551274a = r109.b();
        r111.f551275b = r109.a();
        r107.add(r111);
    L9:
        r103.f524872j = r107;
        x r112 = r102.a();
        if (r112 == null) goto L12;
        int r113 = k.f551238b;
        r105 = k.a.a(r112);
    L12:
        r103.f524873k = r105;
        return r103;
    L8:
        r107 = null;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r100) {
        return invoke(r100);
    }
}
