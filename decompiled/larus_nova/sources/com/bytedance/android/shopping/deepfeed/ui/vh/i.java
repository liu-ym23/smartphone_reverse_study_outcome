package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: loaded from: classes13.dex */
public final class i {
    public static final Typeface a(Typeface r100, int r101) {
        if (r100 != null) goto L5;
        r100 = Typeface.DEFAULT;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        return Typeface.create(r100, r101, true);
    L8:
        return Typeface.create(r100, 3);
    }
}
