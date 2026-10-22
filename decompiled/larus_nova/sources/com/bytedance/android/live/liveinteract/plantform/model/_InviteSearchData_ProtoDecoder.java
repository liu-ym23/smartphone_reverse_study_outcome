package com.bytedance.android.live.liveinteract.plantform.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class _InviteSearchData_ProtoDecoder implements am3.c<InviteSearchData> {
    public _InviteSearchData_ProtoDecoder() {
    }

    public static InviteSearchData decodeStatic(am3.g r100) throws Exception {
        InviteSearchData r101 = new InviteSearchData();
        r101.setThreadSafe(false);
        r101.mPlayerInfo = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        r101.mPlayerInfo.add(g1.a(r100));
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final InviteSearchData decode(am3.g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ InviteSearchData decode(am3.g r100) throws Exception {
        return decode(r100);
    }
}
