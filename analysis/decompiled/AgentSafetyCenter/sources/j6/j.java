package j6;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends AtomicLong implements ThreadFactory {

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f6608g = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public final String f6609c;

    /* renamed from: f, reason: collision with root package name */
    public final int f6610f;

    public j(String str) {
        StringBuilder sbV = k0.a.v(str, "-pool-");
        sbV.append(f6608g.getAndIncrement());
        sbV.append("-thread-");
        this.f6609c = sbV.toString();
        this.f6610f = 5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        h hVar = new h(runnable, this.f6609c + getAndIncrement());
        hVar.setDaemon(false);
        hVar.setUncaughtExceptionHandler(new i());
        hVar.setPriority(this.f6610f);
        return hVar;
    }
}
