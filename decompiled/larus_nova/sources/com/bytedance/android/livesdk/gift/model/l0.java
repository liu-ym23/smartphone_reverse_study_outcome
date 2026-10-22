package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l0 {
    public static final boolean a(k0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLocked");
        if (r100.getLockStatus() != k0.LOCKED_GRAY) goto L5;
    L8:
        return true;
    L5:
        if (r100.getLockStatus() == k0.LOCKED_NORMAL) goto L8;
        return false;
    }
}
