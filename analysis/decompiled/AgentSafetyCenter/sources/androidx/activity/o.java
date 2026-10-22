package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o implements n, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: c, reason: collision with root package name */
    public long f689c;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f690f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f691g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ p f692h;

    public final void a(View view) {
        if (this.f691g) {
            return;
        }
        this.f691g = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f690f = runnable;
        View decorView = this.f692h.getWindow().getDecorView();
        if (this.f691g) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
                return;
            } else {
                decorView.postInvalidate();
                return;
            }
        }
        a4.t tVar = new a4.t(5);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        decorView.postOnAnimation(tVar);
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z10;
        Runnable runnable = this.f690f;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f689c) {
                this.f691g = false;
                this.f692h.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f690f = null;
        t tVar = this.f692h.mFullyDrawnReporter;
        synchronized (tVar.f696a) {
            z10 = tVar.f697b;
        }
        if (z10) {
            this.f691g = false;
            this.f692h.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f692h.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
