package okhttp3;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.internal.d.g f40163a;

    public k(okhttp3.internal.d.g r2) {
        d.h.b.o.e(r2, "delegate");
        this.f40163a = r2;
    }

    public final okhttp3.internal.d.g a() {
        return this.f40163a;
    }

    public k(int r8, long r9, TimeUnit r11) {
        d.h.b.o.e(r11, "timeUnit");
        this(new okhttp3.internal.d.g(okhttp3.internal.c.d.f39849b, r8, r9, r11));
    }

    public k() {
        this(5, 5, TimeUnit.MINUTES);
    }
}
