package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import android.view.MotionEvent;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionZoomableControllerImp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransitionGestureHandler;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", "transitionZoomableControllerImp", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionZoomableControllerImp;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionZoomableControllerImp;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "onSingleTapConfirmed", "e", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionGestureHandler extends DefaultGestureHandler {
    private final TransitionZoomableControllerImp transitionZoomableControllerImp;

    public TransitionGestureHandler(TransitionZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionZoomableControllerImp");
        super(r100);
        this.transitionZoomableControllerImp = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.DefaultGestureHandler, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.transitionZoomableControllerImp.isSingleTagDismissEnabled() == false) goto L7;
        this.transitionZoomableControllerImp.dismissAnimated();
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.DefaultGestureHandler, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (this.transitionZoomableControllerImp.isInDragTransitionState() == false) goto L6;
        return false;
    L6:
        return super.onFling(r100, r101, r102, r103);
    }
}
