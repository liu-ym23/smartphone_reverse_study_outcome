package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetectorCompatImpl f2673a;

    public interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent r10);

        void setIsLongpressEnabled(boolean r10);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10);
    }

    public static class a implements GestureDetectorCompatImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GestureDetector f2674a;

        public a(Context r10, GestureDetector.OnGestureListener r11, Handler r12) {
            this.f2674a = new GestureDetector(r10, r11, r12);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.f2674a.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent r10) {
            return this.f2674a.onTouchEvent(r10);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean r10) {
            this.f2674a.setIsLongpressEnabled(r10);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10) {
            this.f2674a.setOnDoubleTapListener(r10);
        }
    }

    public GestureDetectorCompat(Context r10, GestureDetector.OnGestureListener r11) {
        this(r10, r11, null);
    }

    public boolean a(MotionEvent r10) {
        return this.f2673a.onTouchEvent(r10);
    }

    public void setOnDoubleTapListener(@Nullable GestureDetector.OnDoubleTapListener r10) {
        this.f2673a.setOnDoubleTapListener(r10);
    }

    public GestureDetectorCompat(Context r10, GestureDetector.OnGestureListener r11, Handler r12) {
        this.f2673a = new a(r10, r11, r12);
    }
}
