package com.android.server.appfunctions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import java.util.concurrent.Executor;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class RemoteServiceCallerImpl<T> implements RemoteServiceCaller<T> {
    private static final String TAG = "AppFunctionsServiceCall";
    private final Context mContext;
    private final Executor mExecutor;
    private final Handler mHandler;
    private final Function<IBinder, T> mInterfaceConverter;

    private class OneOffServiceConnection implements ServiceConnection, RemoteServiceCaller.ServiceUsageCompleteListener {
        private final RemoteServiceCaller.RunServiceCallCallback<T> mCallback;
        private final IBinder mCallerBinder;
        private final CancellationSignal mCancellationSignal;
        private final long mCancellationTimeoutMillis;
        private final Runnable mCancellationTimeoutRunnable;
        private IBinder.DeathRecipient mDirectServiceVulture;
        private final int mFlags;
        private final Intent mIntent;
        private final UserHandle mUserHandle;
        final /* synthetic */ RemoteServiceCallerImpl this$0;

        public static /* synthetic */ void $r8$lambda$1n4cdoFiCzonraZ_LmLZcsSPRlo(OneOffServiceConnection r0) {
            r0.lambda$bindAndRun$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$ZOxpwBo-RFIF3aZciI2a6D-StWs, reason: not valid java name */
        public static /* synthetic */ void m1698$r8$lambda$ZOxpwBoRFIF3aZciI2a6DStWs(OneOffServiceConnection r0, Object r1) {
            r0.lambda$onServiceConnected$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$jRI7ZCajnAJtW9Z_h6t3UcXC5v0(OneOffServiceConnection r0) {
            r0.lambda$bindAndRun$0();
        }

        public static /* synthetic */ void $r8$lambda$oz66ips8C2vPpUhpUdoB9AOp8Sg(OneOffServiceConnection r0) {
            r0.safeUnbind();
        }

        OneOffServiceConnection(RemoteServiceCallerImpl r1, Intent intent, int flags, UserHandle userHandle, long cancellationTimeoutMillis, CancellationSignal cancellationSignal, RemoteServiceCaller.RunServiceCallCallback<T> callback, IBinder callerBinder) {
            this.this$0 = r1;
            this.mIntent = intent;
            this.mFlags = flags;
            this.mCallback = callback;
            this.mUserHandle = userHandle;
            this.mCancellationTimeoutMillis = cancellationTimeoutMillis;
            this.mCancellationSignal = cancellationSignal;
            this.mCancellationTimeoutRunnable = new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda3(this);
            this.mCallerBinder = callerBinder;
        }

        public boolean bindAndRun() {
            boolean bindServiceResult = RemoteServiceCallerImpl.m1694$$Nest$fgetmContext(this.this$0).bindServiceAsUser(this.mIntent, this, this.mFlags, this.mUserHandle);
            if (bindServiceResult == false) goto L9;
            this.mCancellationSignal.setOnCancelListener(new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda0(this));
            this.mDirectServiceVulture = new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda1(this);
            this.mCallerBinder.linkToDeath(this.mDirectServiceVulture, 0);     // Catch: RemoteException -> L7
        L10:
            return bindServiceResult;
        L7:
            e = move-exception;
            Slog.w(RemoteServiceCallerImpl.TAG, "Failed to link to death on " + this.mCallerBinder + ": ", e);
            goto L10
        L9:
            safeUnbind();
            goto L10
        }

        private /* synthetic */ void lambda$bindAndRun$0() {
            this.mCallback.onCancelled();
            RemoteServiceCallerImpl.m1696$$Nest$fgetmHandler(this.this$0).postDelayed(this.mCancellationTimeoutRunnable, this.mCancellationTimeoutMillis);
        }

        private /* synthetic */ void lambda$bindAndRun$1() {
            Slog.w(RemoteServiceCallerImpl.TAG, "Caller process onDeath signal received");
            this.mCancellationSignal.cancel();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            final Object r0 = RemoteServiceCallerImpl.m1697$$Nest$fgetmInterfaceConverter(this.this$0).apply(service);
            RemoteServiceCallerImpl.m1695$$Nest$fgetmExecutor(this.this$0).execute(new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda4(this, r0));
        }

        private /* synthetic */ void lambda$onServiceConnected$2(Object serviceInterface) {
            this.mCallback.onServiceConnected(serviceInterface, this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            safeUnbind();
            Executor r0 = RemoteServiceCallerImpl.m1695$$Nest$fgetmExecutor(this.this$0);
            RemoteServiceCaller.RunServiceCallCallback<T> r1 = this.mCallback;
            r1.getClass();
            r0.execute(new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda2(r1));
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName name) {
            safeUnbind();
            Executor r0 = RemoteServiceCallerImpl.m1695$$Nest$fgetmExecutor(this.this$0);
            RemoteServiceCaller.RunServiceCallCallback<T> r1 = this.mCallback;
            r1.getClass();
            r0.execute(new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda2(r1));
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            safeUnbind();
            Executor r0 = RemoteServiceCallerImpl.m1695$$Nest$fgetmExecutor(this.this$0);
            RemoteServiceCaller.RunServiceCallCallback<T> r1 = this.mCallback;
            r1.getClass();
            r0.execute(new RemoteServiceCallerImpl$OneOffServiceConnection$$ExternalSyntheticLambda2(r1));
        }

        private void safeUnbind() {
            RemoteServiceCallerImpl.m1696$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mCancellationTimeoutRunnable);     // Catch: Exception -> L6
            RemoteServiceCallerImpl.m1694$$Nest$fgetmContext(this.this$0).unbindService(this);     // Catch: Exception -> L6
            if (this.mDirectServiceVulture == null) goto L13;
            this.mCallerBinder.unlinkToDeath(this.mDirectServiceVulture, 0);     // Catch: Exception -> L6
            return;
        L13:
            return;
        L6:
            ex = move-exception;
            Log.w(RemoteServiceCallerImpl.TAG, "Failed to unbind", ex);
        }

        @Override // com.android.server.appfunctions.RemoteServiceCaller.ServiceUsageCompleteListener
        public void onCompleted() {
            safeUnbind();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1694$$Nest$fgetmContext(RemoteServiceCallerImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m1695$$Nest$fgetmExecutor(RemoteServiceCallerImpl r0) {
        return r0.mExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1696$$Nest$fgetmHandler(RemoteServiceCallerImpl r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInterfaceConverter, reason: not valid java name */
    static /* bridge */ /* synthetic */ Function m1697$$Nest$fgetmInterfaceConverter(RemoteServiceCallerImpl r0) {
        return r0.mInterfaceConverter;
    }

    public RemoteServiceCallerImpl(Context context, Function<IBinder, T> interfaceConverter, Executor executor) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mContext = context;
        this.mInterfaceConverter = interfaceConverter;
        this.mExecutor = executor;
    }

    @Override // com.android.server.appfunctions.RemoteServiceCaller
    public boolean runServiceCall(Intent intent, int bindFlags, UserHandle userHandle, long cancellationTimeoutMillis, CancellationSignal cancellationSignal, RemoteServiceCaller.RunServiceCallCallback<T> callback, IBinder callerBinder) {
        RemoteServiceCallerImpl<T>.OneOffServiceConnection serviceConnection = new OneOffServiceConnection(this, intent, bindFlags, userHandle, cancellationTimeoutMillis, cancellationSignal, callback, callerBinder);
        return serviceConnection.bindAndRun();
    }
}
