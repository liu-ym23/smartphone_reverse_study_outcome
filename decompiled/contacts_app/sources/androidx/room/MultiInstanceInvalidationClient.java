package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
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

    MultiInstanceInvalidationClient(Context context, String name, InvalidationTracker invalidationTracker, Executor executor) {
        this.mCallback = new AnonymousClass1(this);
        this.mStopped = new AtomicBoolean(false);
        ServiceConnection r0 = new AnonymousClass2(this);
        this.mServiceConnection = r0;
        this.mSetUpRunnable = new AnonymousClass3(this);
        this.mRemoveObserverRunnable = new AnonymousClass4(this);
        Context r4 = context.getApplicationContext();
        this.mAppContext = r4;
        this.mName = name;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        final String[] r5 = (String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0]);
        this.mObserver = new AnonymousClass5(this, r5);
        r4.bindService(new Intent(r4, MultiInstanceInvalidationService.class), r0, 1);
    }

    void stop() {
        if (this.mStopped.compareAndSet(false, true) == false) goto L15;
        this.mInvalidationTracker.removeObserver(this.mObserver);
        IMultiInstanceInvalidationService r0 = this.mService;     // Catch: RemoteException -> L9
        if (r0 == null) goto L11;
        r0.unregisterCallback(this.mCallback, this.mClientId);     // Catch: RemoteException -> L9
    L11:
        this.mAppContext.unbindService(this.mServiceConnection);
        return;
    L9:
        e = move-exception;
        Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
        goto L11
    }
}
