package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    private final Context mContext;
    private boolean mHasBoundService;
    androidx.c.a.b<Integer> mResultFuture;
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService;

    UnusedAppRestrictionsBackportServiceConnection(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.mUnusedAppRestrictionsService = null;
        this.mHasBoundService = false;
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        IUnusedAppRestrictionsBackportService r4 = IUnusedAppRestrictionsBackportService.Stub.asInterface((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin"));
        this.mUnusedAppRestrictionsService = r4;
        r4.isPermissionRevocationEnabledForApp(getBackportCallback());     // Catch: RemoteException -> L5
        return;
    L5:
        this.mResultFuture.a(0);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        this.mUnusedAppRestrictionsService = null;
    }

    public void connectAndFetchResult(androidx.c.a.b<Integer> r4) {
        if (this.mHasBoundService == true) goto L7;
        this.mHasBoundService = true;
        this.mResultFuture = r4;
        Intent r5 = new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(c.a(this.mContext.getPackageManager()));
        ZeusTransformUtils.bindService(this.mContext, r5, this, 1, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void disconnectFromService() {
        if (this.mHasBoundService == false) goto L7;
        this.mHasBoundService = false;
        ZeusTransformUtils.unbindService(this.mContext, this, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new IllegalStateException("bindService must be called before unbind");
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new AnonymousClass1(this);
    }
}
