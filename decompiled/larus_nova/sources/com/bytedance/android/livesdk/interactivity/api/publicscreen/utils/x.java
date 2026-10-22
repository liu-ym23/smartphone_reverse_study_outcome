package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spanned;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x {
    public static final Object[] a(Spanned r100, int r101, Class r102) {
        Intrinsics.checkNotNullParameter(r102, "type");
        if (r100 != null) goto L6;
        return null;
    L6:
        Object[] r103 = r100.getSpans(0, r101, r102);
        if (r103 == null) goto L9;
        Arrays.sort(r103, new w(r100));
    L9:
        return r103;
    }
}
