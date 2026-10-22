package android.net.util;

import android.net.INetd;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class NetdService {
    private static final long BASE_TIMEOUT_MS = 100;
    private static final long MAX_TIMEOUT_MS = 1000;
    private static final String TAG = null;

    public interface NetdCommand {
        void run(INetd r1) throws RemoteException;
    }

    public NetdService() {
    }

    static {
        TAG = NetdService.class.getSimpleName();
    }

    public static INetd getInstance() {
        INetd netdInstance = INetd.Stub.asInterface(ServiceManager.getService("netd"));
        if (netdInstance != null) goto L5;
        Log.w(TAG, "WARNING: returning null INetd instance.");
    L5:
        return netdInstance;
    }

    public static INetd get(long maxTimeoutMs) {
        if (maxTimeoutMs != 0) goto L7;
        return getInstance();
    L7:
        if (maxTimeoutMs <= 0) goto L9;
        long stop = SystemClock.elapsedRealtime() + maxTimeoutMs;
    L10:
        long timeoutMs = 0;
    L11:
        INetd netdInstance = getInstance();
        if (netdInstance != null) goto L13;
        long remaining = stop - SystemClock.elapsedRealtime();
        if (remaining <= 0) goto L16;
        long timeoutMs2 = Math.min(BASE_TIMEOUT_MS + timeoutMs, 1000);
        timeoutMs = Math.min(timeoutMs2, remaining);
        Thread.sleep(timeoutMs);     // Catch: InterruptedException -> L21
        goto L11
    L16:
        return null;
    L13:
        return netdInstance;
    L9:
        stop = Long.MAX_VALUE;
        goto L10
    }

    public static INetd get() {
        return get(-1);
    }

    public static void run(NetdCommand cmd) {
    L6:
        cmd.run(get());     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        Log.e(TAG, "error communicating with netd: " + re);
        goto L6
    }
}
