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
public final class d implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1798a;

    public d(f fVar) {
        this.f1798a = fVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        CompletableFuture completableFuture = this.f1798a.f1803c;
        try {
            if (iBinder == null) {
                throw new IllegalStateException("iBinder is null");
            }
            IInterface iInterfaceA = this.f1798a.a(iBinder);
            this.f1798a.f1801a = iInterfaceA;
            try {
                iInterfaceA.asBinder().linkToDeath(this.f1798a.f1804e, 0);
            } catch (RemoteException e9) {
                Log.w(this.f1798a.e(), "linkToDeath failed: " + e9.getMessage());
            }
            completableFuture.complete(iInterfaceA);
        } catch (Exception e10) {
            Log.e(this.f1798a.e(), "asInterface failed: " + e10.getMessage());
            completableFuture.completeExceptionally(e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        f fVar;
        IInterface iInterface = this.f1798a.f1801a;
        if (iInterface != null) {
            try {
                iInterface.asBinder().unlinkToDeath(this.f1798a.f1804e, 0);
            } catch (Exception e9) {
                Log.w(this.f1798a.e(), "unlinkToDeath failed: " + e9.getMessage());
            }
        }
        synchronized (this.f1798a.f1802b) {
            fVar = this.f1798a;
            fVar.f1801a = null;
        }
        synchronized (fVar.d) {
            fVar.d.removeIf(new a(3));
        }
    }
}
