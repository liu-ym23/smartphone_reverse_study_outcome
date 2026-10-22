package com.bytedance.android.ec.hybrid.list;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46933a = 0;

    static {
    }

    public static void a(View r100) {
        if (r100 == null) goto L5;
        r100.setLayerType(2, null);
        return;
    }

    public static void b(View r100) {
        if (r100 == null) goto L5;
        Paint r101 = new Paint();
        ColorMatrix r102 = new ColorMatrix();
        r102.setSaturation(0.0f);
        r101.setColorFilter(new ColorMatrixColorFilter(r102));
        r100.setLayerType(2, r101);
        return;
    }
}
