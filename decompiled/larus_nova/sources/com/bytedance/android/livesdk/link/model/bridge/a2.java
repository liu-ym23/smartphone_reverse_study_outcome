package com.bytedance.android.livesdk.link.model.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a2 {
    public static final String a(z1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$simpleString");
        return "PreRTCUser{" + r100.getLinkmicIdStr() + ": push=" + r100.getRtcPushStream() + ",status=" + r100.getLinkStatus() + '}';
    }
}
