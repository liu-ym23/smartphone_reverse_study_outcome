package com.android.server.om;

import android.os.FabricatedOverlayInfo;
import android.os.FabricatedOverlayInternal;
import android.os.IBinder;
import android.os.IIdmap2;
import android.os.OverlayConstraint;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.SystemService;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.FgThread;
import com.android.server.job.controllers.JobStatus;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
class IdmapDaemon {
    private static final String IDMAP_DAEMON = "idmap2d";
    private static final int SERVICE_CONNECT_INTERVAL_SLEEP_MS = 5;
    private static final int SERVICE_CONNECT_UPTIME_TIMEOUT_MS = 5000;
    private static final int SERVICE_CONNECT_WALLTIME_TIMEOUT_MS = 30000;
    private static final int SERVICE_TIMEOUT_MS = 10000;
    private static IdmapDaemon sInstance;
    private final Object mIdmapToken;
    private int mOpenedCount;
    private volatile IIdmap2 mService;

    private final class Connection implements AutoCloseable {
        private final IIdmap2 mIdmap2;
        private boolean mOpened;
        final /* synthetic */ IdmapDaemon this$0;

        /* JADX INFO: renamed from: $r8$lambda$rOBH-D7dR5i5A5y99m9wut-LaKQ, reason: not valid java name */
        public static /* synthetic */ void m6337$r8$lambda$rOBHD7dR5i5A5y99m9wutLaKQ(Connection r0, IIdmap2 r1) {
            r0.lambda$close$0(r1);
        }

        /* synthetic */ Connection(IdmapDaemon r1, IIdmap2 r2, IdmapDaemonIA r3) {
            this(r1, r2);
        }

        /* synthetic */ Connection(IdmapDaemon r1, IdmapDaemonIA r2) {
            this(r1);
        }

        private Connection(IdmapDaemon r1) {
            this.this$0 = r1;
            this.mOpened = true;
            this.mIdmap2 = null;
            this.mOpened = false;
        }

        private Connection(IdmapDaemon r4, IIdmap2 idmap2) {
            this.this$0 = r4;
            this.mOpened = true;
            this.mIdmap2 = idmap2;
            Object r1 = IdmapDaemon.m6331$$Nest$fgetmIdmapToken(r4);
            monitor-enter(r1);
            IdmapDaemon.m6334$$Nest$fputmOpenedCount(r4, IdmapDaemon.m6332$$Nest$fgetmOpenedCount(r4) + 1);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            Object r0 = IdmapDaemon.m6331$$Nest$fgetmIdmapToken(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mOpened == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.mOpened = false;     // Catch: Throwable -> L8
            IdmapDaemon r1 = this.this$0;     // Catch: Throwable -> L8
            int r2 = IdmapDaemon.m6332$$Nest$fgetmOpenedCount(r1) - 1;     // Catch: Throwable -> L8
            IdmapDaemon.m6334$$Nest$fputmOpenedCount(r1, r2);     // Catch: Throwable -> L8
            if (r2 == 0) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L14:
            final IIdmap2 service = IdmapDaemon.m6333$$Nest$fgetmService(this.this$0);     // Catch: Throwable -> L8
            FgThread.getHandler().postDelayed(new IdmapDaemon$Connection$$ExternalSyntheticLambda0(this, service), IdmapDaemon.m6331$$Nest$fgetmIdmapToken(this.this$0), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$close$0(IIdmap2 service) {
            Object r0 = IdmapDaemon.m6331$$Nest$fgetmIdmapToken(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (IdmapDaemon.m6333$$Nest$fgetmService(this.this$0) != service) goto L14;
            if (IdmapDaemon.m6332$$Nest$fgetmOpenedCount(this.this$0) != 0) goto L14;
            IdmapDaemon.m6336$$Nest$smstopIdmapServiceLocked();     // Catch: Throwable -> L12
            IdmapDaemon.m6335$$Nest$fputmService(this.this$0, null);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public IIdmap2 getIdmap2() {
            return this.mIdmap2;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$gF_qdnHUHUDllnxzP_BbWXzZv-I, reason: not valid java name */
    public static /* synthetic */ void m6330$r8$lambda$gF_qdnHUHUDllnxzP_BbWXzZvI() {
        lambda$getIdmapServiceLocked$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdmapToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6331$$Nest$fgetmIdmapToken(IdmapDaemon r0) {
        return r0.mIdmapToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOpenedCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6332$$Nest$fgetmOpenedCount(IdmapDaemon r0) {
        return r0.mOpenedCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IIdmap2 m6333$$Nest$fgetmService(IdmapDaemon r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOpenedCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6334$$Nest$fputmOpenedCount(IdmapDaemon r0, int r1) {
        r0.mOpenedCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6335$$Nest$fputmService(IdmapDaemon r0, IIdmap2 r1) {
        r0.mService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$smstopIdmapServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6336$$Nest$smstopIdmapServiceLocked() {
        stopIdmapServiceLocked();
    }

    IdmapDaemon() {
        this.mOpenedCount = 0;
        this.mIdmapToken = new Object();
    }

    static IdmapDaemon getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new IdmapDaemon();
    L6:
        return sInstance;
    }

    String createIdmap(String targetPath, String overlayPath, String overlayName, int policies, boolean enforce, int userId, OverlayConstraint[] constraints) throws TimeoutException, RemoteException {
        Connection c = connect();
        IIdmap2 idmap2 = c.getIdmap2();     // Catch: Throwable -> L15
        if (idmap2 != null) goto L24;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L21
        r5.append("idmap2d service is not ready for createIdmap(\"");     // Catch: Throwable -> L21
        r5.append(targetPath);     // Catch: Throwable -> L21
        r5.append("\", \"");     // Catch: Throwable -> L21
        r5.append(overlayPath);     // Catch: Throwable -> L21
        r5.append("\", \"");     // Catch: Throwable -> L21
        r5.append(overlayName);     // Catch: Throwable -> L21
        r5.append("\", ");     // Catch: Throwable -> L21
        r5.append(policies);     // Catch: Throwable -> L19
        r5.append(", ");     // Catch: Throwable -> L19
        r5.append(enforce);     // Catch: Throwable -> L17
        r5.append(", ");     // Catch: Throwable -> L17
        r5.append(userId);     // Catch: Throwable -> L15
        r5.append(")");     // Catch: Throwable -> L15
        Slog.w("OverlayManager", r5.toString());     // Catch: Throwable -> L15
        c.close();
        return null;
    L17:
        th = th;
    L16:
        Throwable r1 = th;
        if (c == null) goto L42;
        c.close();     // Catch: Throwable -> L30
        throw r1;
    L30:
        th = move-exception;
        r1.addSuppressed(th);
        throw r1;
    L42:
        throw r1;
    L19:
        th = th;
    L21:
        th = th;
        goto L16
    L24:
        String r0 = idmap2.createIdmap(targetPath, overlayPath, TextUtils.emptyIfNull(overlayName), policies, enforce, userId, constraints);     // Catch: Throwable -> L15
        c.close();
        return r0;
    L15:
        th = th;
        goto L16
    }

    boolean removeIdmap(String overlayPath, int userId) throws TimeoutException, RemoteException {
        Connection c = connect();
        IIdmap2 idmap2 = c.getIdmap2();     // Catch: Throwable -> L8
        if (idmap2 != null) goto L10;
        Slog.w("OverlayManager", "idmap2d service is not ready for removeIdmap(\"" + overlayPath + "\", " + userId + ")");     // Catch: Throwable -> L8
        c.close();
        return false;
    L10:
        boolean r2 = idmap2.removeIdmap(overlayPath, userId);     // Catch: Throwable -> L8
        c.close();
        return r2;
    L8:
        th = move-exception;
        if (c != null) goto L19;
    L18:
        throw th;
    L19:
        c.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    boolean verifyIdmap(String targetPath, String overlayPath, String overlayName, int policies, boolean enforce, int userId, OverlayConstraint[] constraints) throws Exception {
        Connection c = connect();
        IIdmap2 idmap2 = c.getIdmap2();     // Catch: Throwable -> L15
        if (idmap2 != null) goto L24;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L21
        r5.append("idmap2d service is not ready for verifyIdmap(\"");     // Catch: Throwable -> L21
        r5.append(targetPath);     // Catch: Throwable -> L21
        r5.append("\", \"");     // Catch: Throwable -> L21
        r5.append(overlayPath);     // Catch: Throwable -> L21
        r5.append("\", \"");     // Catch: Throwable -> L21
        r5.append(overlayName);     // Catch: Throwable -> L21
        r5.append("\", ");     // Catch: Throwable -> L21
        r5.append(policies);     // Catch: Throwable -> L19
        r5.append(", ");     // Catch: Throwable -> L19
        r5.append(enforce);     // Catch: Throwable -> L17
        r5.append(", ");     // Catch: Throwable -> L17
        r5.append(userId);     // Catch: Throwable -> L15
        r5.append(")");     // Catch: Throwable -> L15
        Slog.w("OverlayManager", r5.toString());     // Catch: Throwable -> L15
        c.close();
        return false;
    L17:
        th = th;
    L16:
        Throwable r1 = th;
        if (c == null) goto L42;
        c.close();     // Catch: Throwable -> L30
        throw r1;
    L30:
        th = move-exception;
        r1.addSuppressed(th);
        throw r1;
    L42:
        throw r1;
    L19:
        th = th;
    L21:
        th = th;
        goto L16
    L24:
        boolean r0 = idmap2.verifyIdmap(targetPath, overlayPath, TextUtils.emptyIfNull(overlayName), policies, enforce, userId, constraints);     // Catch: Throwable -> L15
        c.close();
        return r0;
    L15:
        th = th;
        goto L16
    }

    boolean idmapExists(String overlayPath, int userId) {
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        Connection c = connect();     // Catch: Throwable -> L10 Exception -> L12
        IIdmap2 idmap2 = c.getIdmap2();     // Catch: Throwable -> L14
        if (idmap2 != null) goto L16;
        Slog.w("OverlayManager", "idmap2d service is not ready for idmapExists(\"" + overlayPath + "\", " + userId + ")");     // Catch: Throwable -> L14
        c.close();     // Catch: Throwable -> L10 Exception -> L12
        StrictMode.setThreadPolicy(oldPolicy);
        return false;
    L16:
        boolean r5 = new File(idmap2.getIdmapPath(overlayPath, userId)).isFile();     // Catch: Throwable -> L14
        c.close();     // Catch: Throwable -> L10 Exception -> L12
        StrictMode.setThreadPolicy(oldPolicy);
        return r5;
    L14:
        th = move-exception;
        if (c != null) goto L34;
    L26:
        throw th;     // Catch: Throwable -> L10 Exception -> L12
    L34:
        c.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        Slog.wtf("OverlayManager", "failed to check if idmap exists for " + overlayPath, e);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(oldPolicy);
        return false;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(oldPolicy);
        throw th;
    }

    FabricatedOverlayInfo createFabricatedOverlay(FabricatedOverlayInternal overlay) {
        Connection c = connect();     // Catch: Exception -> L9
        IIdmap2 idmap2 = c.getIdmap2();     // Catch: Throwable -> L11
        if (idmap2 != null) goto L13;
        Slog.w("OverlayManager", "idmap2d service is not ready for createFabricatedOverlay()");     // Catch: Throwable -> L11
        c.close();     // Catch: Exception -> L9
        return null;
    L13:
        FabricatedOverlayInfo r4 = idmap2.createFabricatedOverlay(overlay);     // Catch: Throwable -> L11
        c.close();     // Catch: Exception -> L9
        return r4;
    L11:
        th = move-exception;
        if (c != null) goto L25;
    L22:
        throw th;     // Catch: Exception -> L9
    L25:
        c.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Slog.wtf("OverlayManager", "failed to fabricate overlay " + overlay, e);
        return null;
    }

    boolean deleteFabricatedOverlay(String path) {
        Connection c = connect();     // Catch: Exception -> L9
        IIdmap2 idmap2 = c.getIdmap2();     // Catch: Throwable -> L11
        if (idmap2 != null) goto L13;
        Slog.w("OverlayManager", "idmap2d service is not ready for deleteFabricatedOverlay(\"" + path + "\")");     // Catch: Throwable -> L11
        c.close();     // Catch: Exception -> L9
        return false;
    L13:
        boolean r4 = idmap2.deleteFabricatedOverlay(path);     // Catch: Throwable -> L11
        c.close();     // Catch: Exception -> L9
        return r4;
    L11:
        th = move-exception;
        if (c != null) goto L26;
    L22:
        throw th;     // Catch: Exception -> L9
    L26:
        c.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Slog.wtf("OverlayManager", "failed to delete fabricated overlay '" + path + "'", e);
        return false;
    }

    synchronized List<FabricatedOverlayInfo> getFabricatedOverlayInfos() {
        monitor-enter(this);
        ArrayList<FabricatedOverlayInfo> allInfos = new ArrayList();     // Catch: Throwable -> L13
        Connection c = null;
        Connection c2 = connect();     // Catch: Throwable -> L21 Exception -> L23
        IIdmap2 service = c2.getIdmap2();     // Catch: Throwable -> L21 Exception -> L23
        if (service != null) goto L25;
        Slog.w("OverlayManager", "idmap2d service is not ready for getFabricatedOverlayInfos()");     // Catch: Throwable -> L21 Exception -> L23
        List<FabricatedOverlayInfo> r5 = Collections.emptyList();     // Catch: Throwable -> L21 Exception -> L23
        if (c2.getIdmap2() == null) goto L18;
        if ((-1) == (-1)) goto L18;
        c2.getIdmap2().releaseFabricatedOverlayIterator(-1);     // Catch: Throwable -> L13 RemoteException -> L15
    L18:
        c2.close();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r5;
    L25:
        int iteratorId = service.acquireFabricatedOverlayIterator();     // Catch: Throwable -> L21 Exception -> L23
    L26:
        List<FabricatedOverlayInfo> infos = service.nextFabricatedOverlayInfos(iteratorId);     // Catch: Throwable -> L21 Exception -> L23
        if (infos.isEmpty() == true) goto L79;
        allInfos.addAll(infos);     // Catch: Throwable -> L21 Exception -> L23
        goto L26
    L79:
        if (c2.getIdmap2() == null) goto L39;
        if (iteratorId == (-1)) goto L39;
        c2.getIdmap2().releaseFabricatedOverlayIterator(iteratorId);     // Catch: Throwable -> L13 RemoteException -> L36
    L39:
        c2.close();     // Catch: Throwable -> L13
        monitor-exit(this);
        return allInfos;
    L23:
        e = move-exception;
        Slog.wtf("OverlayManager", "failed to get all fabricated overlays", e);     // Catch: Throwable -> L56
        if (0 == 0) goto L55;
        if (c.getIdmap2() == null) goto L53;
        if ((-1) == (-1)) goto L53;
        c.getIdmap2().releaseFabricatedOverlayIterator(-1);     // Catch: Throwable -> L13 RemoteException -> L50
    L53:
        c.close();     // Catch: Throwable -> L13
    L55:
        return allInfos;
    L56:
        th = th;
    L57:
        if (0 != 0) goto L73;
    L67:
        throw th;     // Catch: Throwable -> L13
    L73:
        if (c.getIdmap2() == null) goto L66;
        if ((-1) == (-1)) goto L66;
        c.getIdmap2().releaseFabricatedOverlayIterator(-1);     // Catch: Throwable -> L13 RemoteException -> L63
    L66:
        c.close();     // Catch: Throwable -> L13
    L21:
        th = th;
    L13:
        th = move-exception;
        throw th;
    }

    String dumpIdmap(String overlayPath) {
        Connection c = connect();     // Catch: Exception -> L9
        IIdmap2 service = c.getIdmap2();     // Catch: Throwable -> L11
        if (service != null) goto L13;
        Slog.w("OverlayManager", "idmap2d service is not ready for dumpIdmap()");     // Catch: Throwable -> L11
        c.close();     // Catch: Exception -> L9
        return "idmap2d service is not ready for dumpIdmap()";
    L13:
        String dump = service.dumpIdmap(overlayPath);     // Catch: Throwable -> L11
        String r4 = TextUtils.nullIfEmpty(dump);     // Catch: Throwable -> L11
        c.close();     // Catch: Exception -> L9
        return r4;
    L11:
        th = move-exception;
        if (c != null) goto L27;
    L22:
        throw th;     // Catch: Exception -> L9
    L27:
        c.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Slog.wtf("OverlayManager", "failed to dump idmap", e);
        return null;
    }

    private IBinder getIdmapServiceLocked() throws TimeoutException, RemoteException {
    L7:
        e = move-exception;
        Slog.wtf("OverlayManager", "Failed to enable idmap2 daemon", e);
        if (e.getMessage().contains("failed to set system property") == false) goto L14;
        return null;
    L14:
        long endUptimeMillis = SystemClock.uptimeMillis() + 5000;
        long walltimeMillis = SystemClock.elapsedRealtime();
        long endWalltimeMillis = walltimeMillis + 30000;
    L15:
        IBinder binder = ServiceManager.getService("idmap");
        if (binder != null) goto L17;
        SystemClock.sleep(5);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis > endUptimeMillis) goto L25;
        long r13 = SystemClock.elapsedRealtime();
        walltimeMillis = r13;
        if (r13 <= endWalltimeMillis) goto L15;
    L25:
        throw new TimeoutException(TextUtils.formatSimple("Failed to connect to '%s' in %d/%d ms (spent %d/%d ms)", new Object[]{"idmap", 5000, 30000, Long.valueOf((uptimeMillis - endUptimeMillis) + 5000), Long.valueOf((walltimeMillis - endWalltimeMillis) + 30000)}));
    L17:
        binder.linkToDeath(new IdmapDaemon$$ExternalSyntheticLambda0(), 0);
        return binder;
    L4:
        if (SystemService.isRunning(IDMAP_DAEMON) == true) goto L14;
        SystemService.start(IDMAP_DAEMON);     // Catch: RuntimeException -> L7
        goto L14
    }

    private static /* synthetic */ void lambda$getIdmapServiceLocked$0() {
        Slog.w("OverlayManager", TextUtils.formatSimple("service '%s' died", new Object[]{"idmap"}));
    }

    private static void stopIdmapServiceLocked() {
    L7:
        e = move-exception;
        Slog.w("OverlayManager", "Failed to disable idmap2 daemon", e);
        return;
    L4:
        if (SystemService.isRunning(IDMAP_DAEMON) == false) goto L13;
        SystemService.stop(IDMAP_DAEMON);     // Catch: RuntimeException -> L7
        return;
    }

    private Connection connect() throws TimeoutException, RemoteException {
        Object r0 = this.mIdmapToken;
        monitor-enter(r0);
        FgThread.getHandler().removeCallbacksAndMessages(this.mIdmapToken);     // Catch: Throwable -> L9
        IdmapDaemonIA r2 = null;
        if (this.mService == null) goto L11;
        Connection r1 = new Connection(this, this.mService, r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        IBinder binder = getIdmapServiceLocked();     // Catch: Throwable -> L9
        if (binder != null) goto L16;
        Connection r3 = new Connection(this, r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L16:
        this.mService = IIdmap2.Stub.asInterface(binder);     // Catch: Throwable -> L9
        Connection r4 = new Connection(this, this.mService, r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L9:
        th = move-exception;
        throw th;
    }
}
