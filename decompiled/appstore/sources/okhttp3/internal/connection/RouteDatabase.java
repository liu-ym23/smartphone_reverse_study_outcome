package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* JADX INFO: loaded from: classes4.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes;

    public RouteDatabase() {
        this.failedRoutes = new LinkedHashSet();
    }

    public synchronized void connected(Route r10) {
        monitor-enter(this);
        this.failedRoutes.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void failed(Route r10) {
        monitor-enter(this);
        this.failedRoutes.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean shouldPostpone(Route r10) {
        monitor-enter(this);
        boolean r11 = this.failedRoutes.contains(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
