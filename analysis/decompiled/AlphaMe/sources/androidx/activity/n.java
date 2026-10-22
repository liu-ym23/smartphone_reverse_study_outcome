package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.G;
import ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: classes.dex */
public final class n implements m, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: b, reason: collision with root package name */
    public Runnable f2398b;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f2400d;

    /* renamed from: a, reason: collision with root package name */
    public final long f2397a = SystemClock.uptimeMillis() + AbstractComponentTracker.LINGERING_TIMEOUT;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2399c = false;

    public n(G g4) {
        this.f2400d = g4;
    }

    public final void a() {
        o oVar = this.f2400d;
        oVar.getWindow().getDecorView().removeCallbacks(this);
        oVar.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }

    @Override // androidx.activity.m
    public final void d(View view) {
        if (this.f2399c) {
            return;
        }
        this.f2399c = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f2398b = runnable;
        View decorView = this.f2400d.getWindow().getDecorView();
        if (!this.f2399c) {
            decorView.postOnAnimation(new d(1, this));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z4;
        Runnable runnable = this.f2398b;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f2397a) {
                this.f2399c = false;
                this.f2400d.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f2398b = null;
        q qVar = this.f2400d.mFullyDrawnReporter;
        synchronized (qVar.f2405b) {
            z4 = qVar.f2406c;
        }
        if (z4) {
            this.f2399c = false;
            this.f2400d.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2400d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
