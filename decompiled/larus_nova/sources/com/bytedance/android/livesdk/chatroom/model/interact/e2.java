package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e2 {
    public static final String a(d2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAckMessage");
        if ((r100 instanceof UpdateLinkTypeApplyResponse) == true) goto L5;
        r100 = null;
    L5:
        UpdateLinkTypeApplyResponse r101 = (UpdateLinkTypeApplyResponse) r100;
        if (r101 == null) goto L9;
        String r102 = r101.getAckMessageRaw();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return "";
    }
}
