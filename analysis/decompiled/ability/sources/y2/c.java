package y2;

import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f6890a;

    static {
        HashSet hashSet = new HashSet();
        f6890a = hashSet;
        com.stepos.statsrpk.service.c.s(hashSet, "HeapTaskDaemon", "ThreadPlus", "ApiDispatcher", "ApiLocalDispatcher");
        com.stepos.statsrpk.service.c.s(hashSet, "AsyncLoader", "AsyncTask", "Binder", "PackageProcessor");
        com.stepos.statsrpk.service.c.s(hashSet, "SettingsObserver", "WifiManager", "JavaBridge", "Compiler");
        com.stepos.statsrpk.service.c.s(hashSet, "Signal Catcher", "GC", "ReferenceQueueDaemon", "FinalizerDaemon");
        com.stepos.statsrpk.service.c.s(hashSet, "FinalizerWatchdogDaemon", "CookieSyncManager", "RefQueueWorker", "CleanupReference");
        com.stepos.statsrpk.service.c.s(hashSet, "VideoManager", "DBHelper-AsyncOp", "InstalledAppTracker2", "AppData-AsyncOp");
        com.stepos.statsrpk.service.c.s(hashSet, "IdleConnectionMonitor", "LogReaper", "ActionReaper", "Okio Watchdog");
        com.stepos.statsrpk.service.c.s(hashSet, "CheckWaitingQueue", "NPTH-CrashTimer", "NPTH-JavaCallback", "NPTH-LocalParser");
        hashSet.add("ANR_FILE_MODIFY");
    }
}
