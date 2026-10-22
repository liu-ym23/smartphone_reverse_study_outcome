package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends u0 {
    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogName");
        super("livesdk_" + r100 + "_dialog_show");
    }
}
