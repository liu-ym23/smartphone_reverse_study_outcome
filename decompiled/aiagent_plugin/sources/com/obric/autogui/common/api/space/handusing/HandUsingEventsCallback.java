package com.obric.autogui.common.api.space.handusing;

import android.view.MotionEvent;
import com.obric.autogui.common.api.platform.special.VDBackNavListener;

/* JADX INFO: compiled from: HandUsingEventsCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface HandUsingEventsCallback extends VDBackNavListener {
    void onSurfaceViewOriginTouchEvent(MotionEvent r1);

    void onSurfaceViewTouchCanceled();

    void onSurfaceViewTouchEnded();

    void onSurfaceViewTouched();
}
