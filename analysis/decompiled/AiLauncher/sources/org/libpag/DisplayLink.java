package org.libpag;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes5.dex */
class DisplayLink implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f37837a;
    private long nativeContext = 0;

    /* renamed from: b, reason: collision with root package name */
    private Handler f37838b = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayLink.this.f37837a.start();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayLink.this.f37837a.cancel();
        }
    }

    private DisplayLink() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f37837a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.f37837a.addUpdateListener(this);
        this.f37837a.setRepeatCount(-1);
    }

    public static DisplayLink Create(long j10) {
        DisplayLink displayLink = new DisplayLink();
        displayLink.nativeContext = j10;
        return displayLink;
    }

    private native void onUpdate(long j10);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        onUpdate(this.nativeContext);
    }

    public void start() {
        this.f37838b.post(new a());
    }

    public void stop() {
        this.f37838b.post(new b());
    }
}
