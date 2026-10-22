package com.bytedance.android.livesdk.chatroom.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {
    public static final boolean a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAudioTalk");
        if (r100.t().f114792a != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isKtvRoom");
        if (r100.t().f114792a != 9) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isShortVideo");
        if (r100.t().f114792a != 10) goto L5;
        return true;
    L5:
        return false;
    }
}
