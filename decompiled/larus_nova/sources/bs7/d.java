package bs7;

import com.danikula.videocache.ProxyCacheException;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f20279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f20281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f20282d;

    public final synchronized void a() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f20279a.decrementAndGet() > 0) goto L6;
        this.f20281c = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public d(String r100, f r101) {
        this.f20279a = new AtomicInteger(0);
        r100.getClass();
        this.f20280b = r100;
        r101.getClass();
        this.f20282d = r101;
    }

    public final void b(a r100, Socket r101) throws ProxyCacheException, IOException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f20281c != null) goto L6;
        String r102 = this.f20280b;     // Catch: Throwable -> L15
        f r103 = this.f20282d;     // Catch: Throwable -> L15
        b r104 = new b(new e(r102, r103.f20290a, r103.f20291b));     // Catch: Throwable -> L15
    L7:
        this.f20281c = r104;     // Catch: Throwable -> L15
        monitor-exit(this);
        this.f20279a.incrementAndGet();     // Catch: Throwable -> L12
        this.f20281c.a(r100, r101);     // Catch: Throwable -> L12
        a();
        return;
    L12:
        th = move-exception;
        a();
        throw th;
    L6:
        r104 = this.f20281c;     // Catch: Throwable -> L15
        goto L7
    }
}
