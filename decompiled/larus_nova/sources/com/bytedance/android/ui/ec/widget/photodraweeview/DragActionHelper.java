package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/DragActionHelper;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "detector", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;", "(Landroid/content/Context;Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;)V", "HALF_SCREEN_HEIGHT", "", "getContext", "()Landroid/content/Context;", "getDetector", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;", "value", "", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "getDragFactor", "getScaleFactorWhenDragState", "getScreenHeight", "getStatusBarHeight", "isDragOutSatisfied", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragActionHelper {
    private final int HALF_SCREEN_HEIGHT;
    private final Context context;
    private final TransformGestureDetector detector;
    private float maxDragTransitionFactor;

    public final float getScaleFactorWhenDragState() {
        float r100 = 1 - getDragFactor();
        if (r100 <= 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r100 >= 0.3f) goto L8;
        return 0.3f;
    L8:
        return r100;
    }

    public final float getDragFactor() {
        return this.detector.getTranslationY() / this.HALF_SCREEN_HEIGHT;
    }

    public final boolean isDragOutSatisfied() {
        if (getDragFactor() <= this.maxDragTransitionFactor) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.context;
    }

    public final TransformGestureDetector getDetector() {
        return this.detector;
    }

    public final float getMaxDragTransitionFactor() {
        return this.maxDragTransitionFactor;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_DragActionHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final int getScreenHeight(Context r100) {
        Resources r101 = r100.getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_DragActionHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return r102.heightPixels;
    L7:
        return 0;
    }

    private final int getStatusBarHeight(Context r100) {
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100.getResources().getDimensionPixelSize(r101);
    }

    public final void setMaxDragTransitionFactor(float r100) {
        this.maxDragTransitionFactor = r100;
    }

    public DragActionHelper(Context r100, TransformGestureDetector r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "detector");
        this.context = r100;
        this.detector = r101;
        this.HALF_SCREEN_HEIGHT = (getScreenHeight(r100) + getStatusBarHeight(r100)) / 2;
        this.maxDragTransitionFactor = 0.4f;
    }
}
