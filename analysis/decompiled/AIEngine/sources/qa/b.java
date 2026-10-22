package qa;

import android.os.Looper;
import android.os.SystemClock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f11632a;

    /* renamed from: b, reason: collision with root package name */
    public long f11633b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11634c = false;

    /* renamed from: d, reason: collision with root package name */
    public final com.stepos.statsrpk.a f11635d = new com.stepos.statsrpk.a(this, Looper.getMainLooper(), 1);

    public b(long j10) {
        this.f11632a = j10;
    }

    public final synchronized void a() {
        this.f11634c = true;
        this.f11635d.removeMessages(1);
        this.f11635d.removeMessages(-1);
    }

    public abstract void b();

    public final synchronized void c() {
        this.f11634c = false;
        this.f11633b = SystemClock.elapsedRealtime() + this.f11632a;
        com.stepos.statsrpk.a aVar = this.f11635d;
        aVar.sendMessage(aVar.obtainMessage(1));
    }
}
