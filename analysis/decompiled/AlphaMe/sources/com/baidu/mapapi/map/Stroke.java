package com.baidu.mapapi.map;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class Stroke {
    public final int color;
    public final int strokeWidth;

    public Stroke(int i4, int i5) {
        this.strokeWidth = i4 <= 0 ? 5 : i4;
        this.color = i5;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("width", this.strokeWidth);
        Overlay.d(this.color, bundle);
        return bundle;
    }
}
