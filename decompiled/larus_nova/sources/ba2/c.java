package ba2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18387a;

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultGestureHandler");
        this.f18387a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return this.f18387a.onDoubleTap(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return this.f18387a.onDoubleTapEvent(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return this.f18387a.onDown(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f18387a.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f18387a.onShowPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return this.f18387a.onSingleTapConfirmed(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return this.f18387a.onSingleTapUp(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        return this.f18387a.onFling(r100, r101, r102, r103);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        return this.f18387a.onScroll(r100, r101, r102, r103);
    }
}
