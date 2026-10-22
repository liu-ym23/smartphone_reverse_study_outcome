package com.obric.autogui.common.api.platform.display.capture;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import d.c.d;
import d.h.a.a;

/* JADX INFO: compiled from: IScreenshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IScreenshot {
    Bitmap getBitmap();

    float getScale();

    AOOperatingSpace.SpaceType getSpaceType();

    boolean isValid();

    void release();

    <T> Object withResourcesLocked(a<? extends T> r1, d<? super T> r2);
}
