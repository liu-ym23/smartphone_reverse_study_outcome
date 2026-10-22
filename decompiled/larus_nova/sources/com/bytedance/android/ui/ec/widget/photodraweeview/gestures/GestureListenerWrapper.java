package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J*\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016J*\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListenerWrapper;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "defaultGestureHandler", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;)V", "listener", "getListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GestureListenerWrapper extends GestureDetector.SimpleOnGestureListener {
    private final DefaultGestureHandler defaultGestureHandler;
    private GestureDetector.SimpleOnGestureListener listener;

    public final GestureDetector.SimpleOnGestureListener getListener() {
        return this.listener;
    }

    public GestureListenerWrapper(DefaultGestureHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultGestureHandler");
        this.defaultGestureHandler = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onDoubleTap(r100);
    L6:
        return this.defaultGestureHandler.onDoubleTap(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onDoubleTapEvent(r100);
    L6:
        return this.defaultGestureHandler.onDoubleTapEvent(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onDown(r100);
    L6:
        return this.defaultGestureHandler.onDown(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L5;
        r101.onLongPress(r100);
    L5:
        this.defaultGestureHandler.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L5;
        r101.onShowPress(r100);
    L5:
        this.defaultGestureHandler.onShowPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onSingleTapConfirmed(r100);
    L6:
        return this.defaultGestureHandler.onSingleTapConfirmed(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onSingleTapUp(r100);
    L6:
        return this.defaultGestureHandler.onSingleTapUp(r100);
    }

    public final void setListener(GestureDetector.SimpleOnGestureListener r100) {
        this.listener = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        GestureDetector.SimpleOnGestureListener r104 = this.listener;
        if (r104 == null) goto L6;
        r104.onFling(r100, r101, r102, r103);
    L6:
        return this.defaultGestureHandler.onFling(r100, r101, r102, r103);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        GestureDetector.SimpleOnGestureListener r104 = this.listener;
        if (r104 == null) goto L6;
        r104.onScroll(r100, r101, r102, r103);
    L6:
        return this.defaultGestureHandler.onScroll(r100, r101, r102, r103);
    }
}
