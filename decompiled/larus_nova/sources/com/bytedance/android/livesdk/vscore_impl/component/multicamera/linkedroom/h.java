package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class h {
    public static final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toColorInt");
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L7;
        r100 = "#".concat(r100);     // Catch: Exception -> L9
    L7:
        return Color.parseColor(r100);
    L12:
        return 0;
    }
}
