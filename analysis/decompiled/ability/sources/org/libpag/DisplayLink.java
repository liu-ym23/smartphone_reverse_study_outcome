package org.libpag;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
class DisplayLink implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f5481a;
    private long nativeContext = 0;
    private Handler b = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayLink.this.f5481a.start();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayLink.this.f5481a.cancel();
        }
    }

    private DisplayLink() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5481a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.f5481a.addUpdateListener(this);
        this.f5481a.setRepeatCount(-1);
    }

    public static DisplayLink Create(long j5) {
        DisplayLink displayLink = new DisplayLink();
        displayLink.nativeContext = j5;
        return displayLink;
    }

    private native void onUpdate(long j5);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        onUpdate(this.nativeContext);
    }

    public void start() {
        this.b.post(new a());
    }

    public void stop() {
        this.b.post(new b());
    }
}
