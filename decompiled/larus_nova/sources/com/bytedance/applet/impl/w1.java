package com.bytedance.applet.impl;

import com.larus.platform.api.x4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w1 implements x4 {
    public w1() {
    }

    @Override // com.larus.platform.api.x4
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        if (Intrinsics.areEqual(r100, "aweme_v2") == true) goto L5;
        return;
    L5:
        com.larus.utils.y.c(new u1());
    }
}
