package com.bytedance.android.livesdk.multilink.base.model;

/* JADX INFO: loaded from: classes11.dex */
public final class b0 {
    public static final String a(a0 r100) {
        com.bytedance.android.live.base.model.user.o0.a r101 = com.bytedance.android.live.base.model.user.o0.f58946a;
        String r102 = null;
        if (r100 == null) goto L5;
        Long r103 = Long.valueOf(r100.getTargetAwemeUid());
    L6:
        if (r100 == null) goto L8;
        r102 = r100.getTargetOpenId();
    L8:
        r101.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r103, r102);
    L5:
        r103 = null;
        goto L6
    }
}
