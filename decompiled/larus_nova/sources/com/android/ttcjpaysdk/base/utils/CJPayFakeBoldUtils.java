package com.android.ttcjpaysdk.base.utils;

import android.graphics.Paint;
import android.widget.TextView;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayFakeBoldUtils {
    public CJPayFakeBoldUtils() {
    }

    public static void fakeBold(TextView r100) {
        fakeBold(r100, 0.5f);
    }

    public static void resetFakeBold(TextView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getPaint().setStyle(Paint.Style.FILL);
        r100.getPaint().setStrokeWidth(0.0f);
    }

    public static void fakeBold(TextView r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r100.getPaint().setStrokeWidth(r101);
    }

    public static void fakeBold(Paint r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.setStrokeWidth(r101);
    }
}
