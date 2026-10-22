package com.baidu.mapapi.map;

import android.os.Bundle;

/* JADX INFO: loaded from: classes39.dex */
public final class Stroke {
    public final int color;
    public final float strokeWidth;
    public final WidthType strokeWidthType;

    public Bundle a(Bundle r100) {
        r100.putInt("width", (int) this.strokeWidth);
        Overlay.d(this.color, r100);
        return r100;
    }

    public Stroke(float r100, int r101) {
        if (r100 > 0.0f) goto L5;
        r100 = 5.0f;
    L5:
        this.strokeWidthType = WidthType.AdaptWidth;
        this.strokeWidth = r100;
        this.color = r101;
    }

    public Stroke(WidthType r100, float r101, int r102) {
        if (r101 > 0.0f) goto L5;
        r101 = 5.0f;
    L5:
        this.strokeWidthType = r100;
        this.strokeWidth = r101;
        this.color = r102;
    }
}
