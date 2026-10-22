package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
class MultiInstanceInvalidationClient {
    final Context mAppContext;
    final IMultiInstanceInvalidationCallback mCallback;
    int mClientId;
    final Executor mExecutor;
    final InvalidationTracker mInvalidationTracker;
    final String mName;
    final InvalidationTracker.Observer mObserver;
    final Runnable mRemoveObserverRunnable;
    IMultiInstanceInvalidationService mService;
    final ServiceConnection mServiceConnection;
    final Runnable mSetUpRunnable;
    final AtomicBoolean mStopped;

    public void stop() {
        if (this.mStopped.compareAndSet(false, true) == false) goto L13;
        this.mInvalidationTracker.removeObserver(this.mObserver);
        IMultiInstanceInvalidationService r100 = this.mService;     // Catch: RemoteException -> L10
        if (r100 == null) goto L8;
        r100.unregisterCallback(this.mCallback, this.mClientId);     // Catch: RemoteException -> L10
    L8:
        this.mAppContext.unbindService(this.mServiceConnection);
        return;
    }

    public MultiInstanceInvalidationClient(Context r100, String r101, Intent r102, InvalidationTracker r103, Executor r104) {
        this.mCallback = new AnonymousClass1(this);
        this.mStopped = new AtomicBoolean(false);
        ServiceConnection r105 = new AnonymousClass2(this);
        this.mServiceConnection = r105;
        this.mSetUpRunnable = new AnonymousClass3(this);
        this.mRemoveObserverRunnable = new AnonymousClass4(this);
        Context r106 = r100.getApplicationContext();
        this.mAppContext = r106;
        this.mName = r101;
        this.mInvalidationTracker = r103;
        this.mExecutor = r104;
        final String[] r107 = (String[]) r103.mTableIdLookup.keySet().toArray(new String[0]);
        this.mObserver = new AnonymousClass5(this, r107);
        r106.bindService(r102, r105, 1);
    }
}
