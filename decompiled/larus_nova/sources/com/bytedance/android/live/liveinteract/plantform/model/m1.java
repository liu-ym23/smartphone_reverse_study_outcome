package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class m1 implements am3.c<ListTag.ListTagFriendContent> {
    public m1() {
    }

    @Override // am3.c
    public final ListTag.ListTagFriendContent decode(am3.g r100) throws Exception {
        ListTag.ListTagFriendContent r101 = new ListTag.ListTagFriendContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        r101.friendTag = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
