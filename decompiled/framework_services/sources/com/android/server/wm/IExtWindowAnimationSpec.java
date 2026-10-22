package com.android.server.wm;

import android.graphics.Point;
import android.pico.utils.IExtBase;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowAnimationSpec extends IExtBase {
    Point getCurrentPosition();

    void onApply(Transformation r1, float[] r2);
}
