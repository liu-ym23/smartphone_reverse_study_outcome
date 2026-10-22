package d3;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.CompletableFuture;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f1799a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f1800b;

    public e(f fVar, ServiceConnection serviceConnection) {
        this.f1800b = fVar;
        this.f1799a = serviceConnection;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        CompletableFuture completableFuture = this.f1800b.f1803c;
        try {
            IInterface iInterfaceA = this.f1800b.a(iBinder);
            synchronized (this.f1800b.f1802b) {
                this.f1800b.f1801a = iInterfaceA;
            }
            try {
                iInterfaceA.asBinder().linkToDeath(this.f1800b.f1804e, 0);
            } catch (RemoteException e9) {
                Log.w(this.f1800b.e(), "linkToDeath failed: " + e9.getMessage());
            }
            if (!completableFuture.isDone()) {
                completableFuture.complete(iInterfaceA);
            }
            this.f1799a.onServiceConnected(componentName, iBinder);
        } catch (Exception e10) {
            Log.e(this.f1800b.e(), "asInterface failed: " + e10.getMessage());
            if (completableFuture.isDone()) {
                return;
            }
            completableFuture.completeExceptionally(e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        IInterface iInterface = this.f1800b.f1801a;
        if (iInterface != null) {
            try {
                iInterface.asBinder().unlinkToDeath(this.f1800b.f1804e, 0);
            } catch (Exception e9) {
                Log.w(this.f1800b.e(), "unlinkToDeath failed: " + e9.getMessage());
            }
        }
        synchronized (this.f1800b.f1802b) {
            this.f1800b.f1801a = null;
        }
        this.f1799a.onServiceDisconnected(componentName);
    }
}
