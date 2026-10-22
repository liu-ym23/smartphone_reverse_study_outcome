package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements com.bytedance.android.ec.hybrid.list.ability.j0 {
    public n() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.s
    public final void release() {
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.j0
    public final int Dv(ECHybridListItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        IntRange r101 = m0.f185095a;
        Intrinsics.checkNotNullParameter(r100, "vo");
        Integer r102 = r100.f47028c;
        int r103 = 0;
        if (r102 == null) goto L38;
        int r104 = r102.intValue();
        int r105 = com.bytedance.android.ec.store.window.a.f49001a;
        ECHybridListItemType.a r106 = ECHybridListItemType.Companion;
        r106.getClass();
        if (ECHybridListItemType.a.a(r104) == false) goto L39;
        Integer r107 = r100.f47028c;
        if (r107 == null) goto L10;
        int r108 = r107.intValue();
    L11:
        Integer r109 = Integer.valueOf(r108);
        Integer r110 = r100.i();
        if (r110 == null) goto L14;
        int r111 = r110.intValue();
    L16:
        if (r111 < 2) goto L18;
        boolean r112 = true;
    L19:
        if (r109 == null) goto L24;
        int r113 = r109.intValue();
        r106.getClass();
        if (ECHybridListItemType.a.a(r113) == true) goto L24;
        int r114 = r109.intValue();
    L40:
        return r114;
    L24:
        if (r109 == null) goto L27;
        r103 = r109.intValue();
    L27:
        if (m0.f185095a.contains(r103) == false) goto L29;
        m0.a r115 = m0.f185097c;
    L30:
        if (r112 == false) goto L32;
        ConcurrentHashMap<Integer, Integer> r116 = r115.f185099b;
    L33:
        Integer r117 = r116.get(Integer.valueOf(r103));
        if (r117 == null) goto L36;
        r114 = r117.intValue();
        goto L40
    L36:
        int r118 = r115.f185101d.getAndIncrement();
        r116.put(Integer.valueOf(r103), Integer.valueOf(r118));
        r115.f185100c.put(Integer.valueOf(r118), Integer.valueOf(r103));
        return r118;
    L32:
        r116 = r115.f185098a;
        goto L33
    L29:
        r115 = m0.f185096b;
        goto L30
    L18:
        r112 = false;
        goto L19
    L14:
        r111 = 0;
        goto L16
    L10:
        r108 = 0;
        goto L11
    L39:
        return r104;
    L38:
        return 0;
    }
}
