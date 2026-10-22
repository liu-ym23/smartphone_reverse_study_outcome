package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q {
    public static final int a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorAuthRole");
        com.bytedance.android.livesdk.link.model.bridge.k1 r101 = r100.getContent();
        if (r101 == null) goto L10;
        com.bytedance.android.livesdk.link.model.bridge.m1 r102 = r101.getLinkMicContent();
        if (r102 == null) goto L10;
        IListUserLinkmicContent r103 = (IListUserLinkmicContent) r102.castTo(IListUserLinkmicContent.class);
        if (r103 == null) goto L10;
        return r103.getAnchorAuthRole();
    L10:
        return IListUserLinkmicContent.IAnchorAuthRole.AnchorAuthRoleGeneral.ordinal();
    }

    public static final com.bytedance.android.livesdk.link.model.bridge.j b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorLinkMicIdInfo");
        com.bytedance.android.livesdk.link.model.bridge.k1 r101 = r100.getContent();
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.link.model.bridge.m1 r102 = r101.getLinkMicContent();
        if (r102 == null) goto L7;
        return r102.getAnchorLinkMicIdInfo();
    L7:
        return null;
    }

    public static final v6 c(p r100) {
        if (r100 == null) goto L6;
        com.bytedance.android.livesdk.link.model.bridge.k1 r101 = r100.getContent();
        if (r101 == null) goto L6;
        return (v6) r101.castTo(v6.class);
    L6:
        return null;
    }

    public static final int d(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pkRole");
        com.bytedance.android.livesdk.link.model.bridge.k1 r101 = r100.getContent();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.link.model.bridge.m1 r102 = r101.getLinkMicContent();
        if (r102 == null) goto L9;
        IListUserLinkmicContent r103 = (IListUserLinkmicContent) r102.castTo(IListUserLinkmicContent.class);
        if (r103 == null) goto L9;
        return r103.getRole();
    L9:
        return 0;
    }
}
