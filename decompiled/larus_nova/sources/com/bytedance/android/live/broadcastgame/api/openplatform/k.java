package com.bytedance.android.live.broadcastgame.api.openplatform;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class k {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLynxDebugSchema");
        return StringsKt.contains$default(r100, "remote_debug_livegame", false, 2, null);
    }
}
