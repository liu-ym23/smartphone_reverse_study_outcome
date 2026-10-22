package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class o1 implements am3.c<ListTag> {
    public o1() {
    }

    @Override // am3.c
    public final ListTag decode(am3.g r100) throws Exception {
        ListTag r101 = new ListTag();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r101.ecomFansClubTag = (ListTag.ListTagEcomFansClubContent) vh7.f.a(r100, ListTag.ListTagEcomFansClubContent.class);
        goto L3
    L9:
        r101.ecomViewTag = (ListTag.ListTagEcomViewContent) vh7.f.a(r100, ListTag.ListTagEcomViewContent.class);
        goto L3
    L10:
        r101.listTagFansContent = (ListTag.ListTagFansContent) vh7.f.a(r100, ListTag.ListTagFansContent.class);
        goto L3
    L11:
        r101.listTagFriendContent = (ListTag.ListTagFriendContent) vh7.f.a(r100, ListTag.ListTagFriendContent.class);
        goto L3
    L12:
        r101.listTagHonorLevelContent = (ListTag.ListTagHonorLevelContent) vh7.f.a(r100, ListTag.ListTagHonorLevelContent.class);
        goto L3
    L13:
        r101.listTagFansClubContent = (ListTag.ListTagFansClubContent) vh7.f.a(r100, ListTag.ListTagFansClubContent.class);
        goto L3
    L14:
        r101.type = r100.i();
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
