package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends u0 {
    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogName");
        super("livesdk_" + r100 + "_dialog_cancel");
    }
}
