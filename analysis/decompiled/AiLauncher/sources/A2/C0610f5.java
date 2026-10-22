package A2;

import android.os.SystemClock;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: A2.f5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0610f5 implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final Map f662h = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f663a;

    /* renamed from: b, reason: collision with root package name */
    public int f664b;

    /* renamed from: c, reason: collision with root package name */
    public double f665c;

    /* renamed from: d, reason: collision with root package name */
    public long f666d;

    /* renamed from: e, reason: collision with root package name */
    public long f667e;

    /* renamed from: f, reason: collision with root package name */
    public long f668f;

    /* renamed from: g, reason: collision with root package name */
    public long f669g;

    public C0610f5(String str) {
        this.f668f = 2147483647L;
        this.f669g = -2147483648L;
        this.f663a = str;
    }

    public static C0610f5 l(String str) {
        F5.a();
        if (!F5.b()) {
            return C0596d5.f630i;
        }
        Map map = f662h;
        if (map.get("detectorTaskWithResource#run") == null) {
            map.put("detectorTaskWithResource#run", new C0610f5("detectorTaskWithResource#run"));
        }
        return (C0610f5) map.get("detectorTaskWithResource#run");
    }

    public final void b() {
        this.f664b = 0;
        this.f665c = 0.0d;
        this.f666d = 0L;
        this.f668f = 2147483647L;
        this.f669g = -2147483648L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10 = this.f666d;
        if (j10 == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        i(j10);
    }

    public C0610f5 e() {
        this.f666d = SystemClock.elapsedRealtimeNanos() / 1000;
        return this;
    }

    public void g(long j10) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j11 = this.f667e;
        if (j11 != 0 && jElapsedRealtimeNanos - j11 >= 1000000) {
            b();
        }
        this.f667e = jElapsedRealtimeNanos;
        this.f664b++;
        this.f665c += j10;
        this.f668f = Math.min(this.f668f, j10);
        this.f669g = Math.max(this.f669g, j10);
        if (this.f664b % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", this.f663a, Long.valueOf(j10), Integer.valueOf(this.f664b), Long.valueOf(this.f668f), Long.valueOf(this.f669g), Integer.valueOf((int) (this.f665c / this.f664b)));
            F5.a();
        }
        if (this.f664b % 500 == 0) {
            b();
        }
    }

    public void i(long j10) {
        g((SystemClock.elapsedRealtimeNanos() / 1000) - j10);
    }
}
