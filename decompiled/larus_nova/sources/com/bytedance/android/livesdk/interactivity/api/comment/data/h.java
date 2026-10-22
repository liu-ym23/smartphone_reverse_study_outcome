package com.bytedance.android.livesdk.interactivity.api.comment.data;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements am3.c<IntercomChangeSyncData> {
    public h() {
    }

    @Override // am3.c
    public final IntercomChangeSyncData decode(am3.g r100) throws Exception {
        IntercomChangeSyncData r101 = new IntercomChangeSyncData();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.intercomStatus = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.closeReason = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }
}
