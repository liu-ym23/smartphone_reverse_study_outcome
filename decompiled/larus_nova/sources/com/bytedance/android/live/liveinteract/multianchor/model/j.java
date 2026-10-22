package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements am3.c<ListUserContent> {
    public j() {
    }

    public static ListUserContent a(am3.g r100) throws Exception {
        ListUserContent r101 = new ListUserContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 2) goto L8;
        r101.linkmicContent = (ListUserLinkmicContent) vh7.f.a(r100, ListUserLinkmicContent.class);
        goto L3
    L8:
        if (r103 != 3) goto L9;
        r101.mLinkmicAudienceContent = (ListUserLinkmicAudienceContent) vh7.f.a(r100, ListUserLinkmicAudienceContent.class);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final ListUserContent decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
