package com.bytedance.android.livesdk.gamecp.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements dw.j {
    public o() {
    }

    @Override // dw.j
    public final void openMiniGamePlayGame(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "startParmaMap");
    }

    @Override // dw.j
    public final void preloadMiniGamePlayGame(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }
}
