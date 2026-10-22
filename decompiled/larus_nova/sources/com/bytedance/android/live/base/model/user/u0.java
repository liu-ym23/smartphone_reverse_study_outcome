package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class u0 implements am3.c<PublicAreaBadgeInfo> {
    public u0() {
    }

    public static PublicAreaBadgeInfo a(am3.g r110) throws Exception {
        PublicAreaBadgeInfo r100 = new PublicAreaBadgeInfo();
        r100.badgeInfoMap = new HashMap();
        r100.badgeList = new ArrayList();
        r100.webcastDslBadgeList = new ArrayList();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L29;
        if (r102 != 1) goto L7;
        long r103 = r110.c();
        Long r104 = null;
        py.k r105 = null;
    L14:
        int r111 = r110.f();
        if (r111 == (-1)) goto L21;
        if (r111 != 1) goto L17;
        r104 = Long.valueOf(r110.j());
        goto L14
    L17:
        if (r111 != 2) goto L14;
        r105 = (py.k) vh7.f.a(r110, py.k.class);
        goto L14
    L21:
        r110.d(r103);
        if (r104 == null) goto L28;
        if (r105 == null) goto L26;
        r100.badgeInfoMap.put(r104, r105);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r102 != 2) goto L9;
        r100.badgeList.add(Long.valueOf(r110.j()));
        goto L3
    L9:
        if (r102 != 3) goto L10;
        r100.webcastDslBadgeList.add(v0.a(r110));
        goto L3
    L10:
        am3.h.e(r110);
        goto L3
    L29:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final PublicAreaBadgeInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
