package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Gainmap;
import android.hardware.display.VirtualDisplayConfig;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ Gainmap d(Bitmap bitmap) {
        return new Gainmap(bitmap);
    }

    public static /* synthetic */ VirtualDisplayConfig.Builder f(String str, int i, int i6, int i10) {
        return new VirtualDisplayConfig.Builder(str, i, i6, i10);
    }

    public static /* synthetic */ void k() {
    }
}
