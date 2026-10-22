package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends ir1.c {
    public final boolean p() {
        if (l() == true) goto L5;
    L7:
        return false;
    L5:
        if (g() == true) goto L7;
        return true;
    }

    public a() {
    }

    public final boolean o(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == true) goto L5;
    L11:
        return false;
    L5:
        if (l() == true) goto L7;
    L10:
        return true;
    L7:
        if (g() == false) goto L11;
        if (l() == false) goto L11;
        goto L10
    }
}
