package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.android.ui.ec.widget.photodraweeview.ScaleFactorRetriever;
import com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "zoomableControllerImp", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;)V", "doubleTapViewPoint", "Landroid/graphics/PointF;", "isDoubleClickScaleEnabled", "", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "scaleFactorRetriever", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "getScaleFactorRetriever", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "setScaleFactorRetriever", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;)V", "onDoubleTapEvent", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onSingleTapConfirmed", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DefaultGestureHandler extends GestureDetector.SimpleOnGestureListener {
    private final PointF doubleTapViewPoint;
    private boolean isDoubleClickScaleEnabled;
    private ScaleFactorRetriever scaleFactorRetriever;
    private final ZoomableControllerImp zoomableControllerImp;

    public final ScaleFactorRetriever getScaleFactorRetriever() {
        return this.scaleFactorRetriever;
    }

    public final boolean isDoubleClickScaleEnabled() {
        return this.isDoubleClickScaleEnabled;
    }

    public DefaultGestureHandler(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomableControllerImp");
        this.zoomableControllerImp = r100;
        this.doubleTapViewPoint = new PointF();
        this.isDoubleClickScaleEnabled = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.isDoubleClickScaleEnabled == true) goto L5;
        return false;
    L5:
        ScaleFactorRetriever r101 = this.scaleFactorRetriever;
        if (r101 != null) goto L8;
        return false;
    L8:
        ZoomableControllerImp r102 = this.zoomableControllerImp;
        PointF r103 = new PointF(r100.getX(), r100.getY());
        int r104 = r100.getActionMasked();
        if (r104 == 0) goto L13;
        if (r104 != 1) goto L14;
        r102.zoomToPoint(r101.nextFactor(r102.getScaleFactor()), r103, null, null);
    L14:
        return true;
    L13:
        this.doubleTapViewPoint.set(r103);
        goto L14
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        super.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return super.onSingleTapConfirmed(r100);
    }

    public final void setDoubleClickScaleEnabled(boolean r100) {
        this.isDoubleClickScaleEnabled = r100;
    }

    public final void setScaleFactorRetriever(ScaleFactorRetriever r100) {
        this.scaleFactorRetriever = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        ZoomableControllerImp r104 = this.zoomableControllerImp;
        if (r104.getScaleFactor() <= r104.getMinScaleFactor()) goto L7;
        r104.fling((int) r102, (int) r103);
        return false;
    L7:
        return false;
    }
}
