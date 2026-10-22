package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class i1 implements am3.c<ListTag.ListTagEcomFansClubContent> {
    public i1() {
    }

    @Override // am3.c
    public final ListTag.ListTagEcomFansClubContent decode(am3.g r100) throws Exception {
        ListTag.ListTagEcomFansClubContent r101 = new ListTag.ListTagEcomFansClubContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.ecomFansClubTag = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.clubName = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
