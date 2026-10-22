package com.bytedance.android.live.profit.redpacket;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    public static final boolean a(RedPacketState r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTerminalState");
        if ((r100 instanceof RedPacketState.Rushed) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r100 instanceof RedPacketState.Empty) == true) goto L12;
        if ((r100 instanceof RedPacketState.Expired) == true) goto L12;
        if ((r100 instanceof RedPacketState.Disposed) == true) goto L12;
        return false;
    }
}
