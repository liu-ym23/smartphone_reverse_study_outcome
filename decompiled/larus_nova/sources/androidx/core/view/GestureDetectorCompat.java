package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes17.dex */
public final class GestureDetectorCompat {
    private final GestureDetector mDetector;

    public boolean isLongpressEnabled() {
        return this.mDetector.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent r100) {
        return this.mDetector.onTouchEvent(r100);
    }

    public void setIsLongpressEnabled(boolean r100) {
        this.mDetector.setIsLongpressEnabled(r100);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r100) {
        this.mDetector.setOnDoubleTapListener(r100);
    }

    public GestureDetectorCompat(Context r100, GestureDetector.OnGestureListener r101) {
        this(r100, r101, null);
    }

    public GestureDetectorCompat(Context r100, GestureDetector.OnGestureListener r101, Handler r102) {
        this.mDetector = new GestureDetector(r100, r101, r102);
    }
}
