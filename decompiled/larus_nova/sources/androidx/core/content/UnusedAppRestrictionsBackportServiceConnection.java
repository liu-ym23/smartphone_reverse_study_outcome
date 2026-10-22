package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: loaded from: classes17.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    private final Context mContext;
    private boolean mHasBoundService;
    ResolvableFuture<Integer> mResultFuture;
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService;

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new AnonymousClass1(this);
    }

    public void disconnectFromService() {
        if (this.mHasBoundService == false) goto L7;
        this.mHasBoundService = false;
        this.mContext.unbindService(this);
        return;
    L7:
        throw new IllegalStateException("bindService must be called before unbind");
    }

    public UnusedAppRestrictionsBackportServiceConnection(Context r100) {
        this.mUnusedAppRestrictionsService = null;
        this.mHasBoundService = false;
        this.mContext = r100;
    }

    public void connectAndFetchResult(ResolvableFuture<Integer> r100) {
        if (this.mHasBoundService == true) goto L7;
        this.mHasBoundService = true;
        this.mResultFuture = r100;
        Intent r101 = new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager()));
        this.mContext.bindService(r101, this, 1);
        return;
    L7:
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r100) {
        this.mUnusedAppRestrictionsService = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r100, IBinder r101) {
        IUnusedAppRestrictionsBackportService r102 = IUnusedAppRestrictionsBackportService.Stub.asInterface(r101);
        this.mUnusedAppRestrictionsService = r102;
        r102.isPermissionRevocationEnabledForApp(getBackportCallback());     // Catch: RemoteException -> L5
        return;
    L5:
        this.mResultFuture.set(0);
    }
}
