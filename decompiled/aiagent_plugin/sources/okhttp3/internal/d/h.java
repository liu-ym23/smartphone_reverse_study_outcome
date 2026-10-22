package okhttp3.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.af;

/* JADX INFO: compiled from: RouteDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<af> f39904a;

    public h() {
        this.f39904a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    }

    public final synchronized void a(af r2) {
        monitor-enter(this);
        o.e(r2, "failedRoute");     // Catch: Throwable -> L6
        this.f39904a.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(af r2) {
        monitor-enter(this);
        o.e(r2, "route");     // Catch: Throwable -> L6
        this.f39904a.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(af r2) {
        monitor-enter(this);
        o.e(r2, "route");     // Catch: Throwable -> L6
        boolean r3 = this.f39904a.contains(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }
}
