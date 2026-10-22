package com.bytedance.android.live.liveinteract.plantform.model;

import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class k1 implements am3.c<ListTag.ListTagFansClubContent> {
    public k1() {
    }

    @Override // am3.c
    public final ListTag.ListTagFansClubContent decode(am3.g r110) throws Exception {
        ListTag.ListTagFansClubContent r100 = new ListTag.ListTagFansClubContent();
        r100.setThreadSafe(false);
        r100.icons = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L26;
        am3.g.a r103 = r100.decodeExtensionFields(r102, r110);
        if (r102 != 1) goto L7;
        long r104 = r110.c();
        Integer r105 = null;
        py.k r106 = null;
    L11:
        int r111 = r110.f();
        if (r111 == (-1)) goto L18;
        if (r111 != 1) goto L14;
        r105 = Integer.valueOf(r110.i());
        goto L11
    L14:
        if (r111 != 2) goto L11;
        r106 = (py.k) vh7.f.a(r110, py.k.class);
        goto L11
    L18:
        r110.d(r104);
        if (r105 == null) goto L25;
        if (r106 == null) goto L23;
        r100.icons.put(r105, r106);
        goto L3
    L23:
        throw new IllegalStateException("Map value must not be null!");
    L25:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r102 != 2) goto L8;
        r100.clubName = am3.h.c(r110);
        goto L3
    L8:
        am3.h.d(r103, r110);
        goto L3
    L26:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }
}
