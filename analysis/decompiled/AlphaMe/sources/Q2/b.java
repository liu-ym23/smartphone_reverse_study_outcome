package Q2;

import android.os.Looper;
import android.os.SystemClock;
import f0.HandlerC0555a;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f1644a;

    /* renamed from: b, reason: collision with root package name */
    public long f1645b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1646c = false;

    /* renamed from: d, reason: collision with root package name */
    public final HandlerC0555a f1647d = new HandlerC0555a(this, Looper.getMainLooper(), 4);

    public b(long j4) {
        this.f1644a = j4;
    }

    public final synchronized void a() {
        this.f1646c = true;
        this.f1647d.removeMessages(1);
        this.f1647d.removeMessages(-1);
    }

    public abstract void b();

    public final synchronized void c() {
        this.f1646c = false;
        this.f1645b = SystemClock.elapsedRealtime() + this.f1644a;
        HandlerC0555a handlerC0555a = this.f1647d;
        handlerC0555a.sendMessage(handlerC0555a.obtainMessage(1));
    }
}
