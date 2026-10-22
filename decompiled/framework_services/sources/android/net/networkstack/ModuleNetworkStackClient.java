package android.net.networkstack;

import android.content.Context;
import android.net.INetworkStackConnector;
import android.net.NetworkStack;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class ModuleNetworkStackClient extends NetworkStackClientBase implements IBinder.DeathRecipient {
    private static final String TAG = null;
    private static ModuleNetworkStackClient sInstance;
    private IBinder mBinder;

    private class PollingRunner implements Runnable {
        final /* synthetic */ ModuleNetworkStackClient this$0;

        /* synthetic */ PollingRunner(ModuleNetworkStackClient r1, ModuleNetworkStackClientIA r2) {
            this(r1);
        }

        private PollingRunner(ModuleNetworkStackClient r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            IBinder nss = NetworkStack.getService();
            if (nss != null) goto L9;
            Thread.sleep(200);     // Catch: InterruptedException -> L7
        L7:
            e = move-exception;
            Log.e(ModuleNetworkStackClient.m36$$Nest$sfgetTAG(), "Interrupted while waiting for NetworkStack connector", e);
            goto L2
        L9:
            ModuleNetworkStackClient.m35$$Nest$fputmBinder(this.this$0, nss);
            this.this$0.linkDeathRecipient();
            this.this$0.onNetworkStackConnected(INetworkStackConnector.Stub.asInterface(nss));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m35$$Nest$fputmBinder(ModuleNetworkStackClient r0, IBinder r1) {
        r0.mBinder = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m36$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = ModuleNetworkStackClient.class.getSimpleName();
    }

    private ModuleNetworkStackClient() {
    }

    public static synchronized ModuleNetworkStackClient getInstance(Context packageContext) {
        monitor-enter(ModuleNetworkStackClient.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new ModuleNetworkStackClient();     // Catch: Throwable -> L7
        sInstance.startPolling();     // Catch: Throwable -> L7
    L9:
        ModuleNetworkStackClient r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(ModuleNetworkStackClient.class);
        return r1;
    }

    protected static synchronized void resetInstanceForTest() {
        monitor-enter(ModuleNetworkStackClient.class);
        sInstance = null;     // Catch: Throwable -> L8
        monitor-exit(ModuleNetworkStackClient.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void linkDeathRecipient() {
        if (this.mBinder == null) goto L11;
        this.mBinder.linkToDeath(this, 0);     // Catch: RemoteException -> L6
        return;
    L7:
        binderDied();
        return;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.mBinder = null;
        sInstance = null;
        onNetworkStackDisconnected();
    }

    private void startPolling() {
        IBinder nss = NetworkStack.getService();
        if (nss == null) goto L6;
        this.mBinder = nss;
        linkDeathRecipient();
        onNetworkStackConnected(INetworkStackConnector.Stub.asInterface(nss));
        return;
    L6:
        new Thread(new PollingRunner(this, null)).start();
    }
}
