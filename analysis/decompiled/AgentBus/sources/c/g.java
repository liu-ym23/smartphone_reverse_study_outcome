package c;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.a0;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class g implements ViewTreeObserver.OnDrawListener, Runnable, Executor {

    /* renamed from: f, reason: collision with root package name */
    public final long f1675f = SystemClock.uptimeMillis() + 10000;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f1676g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1677h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i f1678i;

    public g(i iVar) {
        this.f1678i = iVar;
    }

    public final void a(View view) {
        if (this.f1677h) {
            return;
        }
        this.f1677h = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        q7.k.e(runnable, "runnable");
        this.f1676g = runnable;
        View decorView = this.f1678i.getWindow().getDecorView();
        q7.k.d(decorView, "getDecorView(...)");
        if (!this.f1677h) {
            decorView.postOnAnimation(new a0(2, this));
        } else if (q7.k.a(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z4;
        Runnable runnable = this.f1676g;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f1675f) {
                this.f1677h = false;
                this.f1678i.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f1676g = null;
        j jVar = (j) this.f1678i.f1690l.getValue();
        synchronized (jVar.f1703a) {
            z4 = jVar.f1704b;
        }
        if (z4) {
            this.f1677h = false;
            this.f1678i.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1678i.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
