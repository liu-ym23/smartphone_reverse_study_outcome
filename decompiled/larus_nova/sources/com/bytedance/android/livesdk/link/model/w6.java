package com.bytedance.android.livesdk.link.model;

/* JADX INFO: loaded from: classes10.dex */
public final class w6 {
    public static final IListUserLinkmicContent a(v6 r100) {
        if (r100 == null) goto L6;
        com.bytedance.android.livesdk.link.model.bridge.m1 r101 = r100.getLinkMicContent();
        if (r101 == null) goto L6;
        return (IListUserLinkmicContent) r101.castTo(IListUserLinkmicContent.class);
    L6:
        return null;
    }
}
