package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q0 {
    public static final String a(ILinkMicBattleInviteMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$inviteUid");
        Long r101 = r100.get_inviteUid();
        if (r101 != null) goto L7;
        return null;
    L7:
        return String.valueOf(r101.longValue());
    }
}
