package com.zyql.ai.crop.callback;

import android.graphics.RectF;

/* loaded from: classes4.dex */
public interface OverlayViewChangeListener {
    void onCropRectUpdated(RectF rectF);

    void postTranslate(float f10, float f11);
}
