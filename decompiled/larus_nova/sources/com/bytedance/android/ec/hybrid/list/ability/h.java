package com.bytedance.android.ec.hybrid.list.ability;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f46973a = null;

    public h() {
    }

    static {
        f46973a = new h();
    }

    public final void update(com.bytedance.android.ec.hybrid.list.entity.i r100, f0 r101) {
        Intrinsics.checkNotNullParameter(r100, "section");
        if (r101 == null) goto L5;
        String r102 = r100.f47107a;
        r101.a();
    L5:
        ArrayList<ECHybridListItemVO> r103 = r100.f47115i;
        if (r103 == null) goto L16;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L24;
        ECHybridListItemVO r105 = (ECHybridListItemVO) r104.next();
        Integer r106 = r105.f47028c;
        int r107 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType();
        if (r106 == null) goto L9;
        if (r106.intValue() != r107) goto L9;
        r105.f47026a = 2;
        goto L9
    L24:
        return;
    }

    public final void update(List<? extends ECHybridListItemVO> r100, String r101, f0 r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        if (r102 == null) goto L5;
        r102.a();
    L5:
        Iterator<T> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        ECHybridListItemVO r104 = (ECHybridListItemVO) r103.next();
        Integer r105 = r104.f47028c;
        int r106 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD.getType();
        if (r105 == null) goto L7;
        if (r105.intValue() != r106) goto L7;
        r104.f47026a = 2;
        goto L7
    }
}
