package u0;

import androidx.appcompat.app.o;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import t0.C0911F;
import t0.C0917c;
import t0.x;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final C0917c f15471a;

    /* renamed from: b, reason: collision with root package name */
    public final C0911F f15472b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15473c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f15474d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f15475e;

    public d(C0917c runnableScheduler, C0911F launcher) {
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        long millis = TimeUnit.MINUTES.toMillis(90L);
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.f15471a = runnableScheduler;
        this.f15472b = launcher;
        this.f15473c = millis;
        this.f15474d = new Object();
        this.f15475e = new LinkedHashMap();
    }

    public final void a(x token) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(token, "token");
        synchronized (this.f15474d) {
            runnable = (Runnable) this.f15475e.remove(token);
        }
        if (runnable != null) {
            this.f15471a.f15383a.removeCallbacks(runnable);
        }
    }

    public final void b(x token) {
        Intrinsics.checkNotNullParameter(token, "token");
        o oVar = new o(8, this, token);
        synchronized (this.f15474d) {
        }
        C0917c c0917c = this.f15471a;
        c0917c.f15383a.postDelayed(oVar, this.f15473c);
    }
}
