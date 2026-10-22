package com.bytedance.android.gamecp.common.utils;

import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g1 {
    public static final void a(SpannableStringBuilder r100, CharSequence r101, com.bytedance.android.gamecp.common.ui.e r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendSpan");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "what");
        int r103 = r100.length();
        r100.append(r101);
        r100.setSpan(r102, r103, r100.length(), 33);
    }
}
