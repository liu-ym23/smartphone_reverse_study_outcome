package com.android.server.location.provider;

import android.location.LocationResult;
import android.location.provider.ProviderRequest;
import android.os.Bundle;
import com.android.internal.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class DelegateLocationProvider extends AbstractLocationProvider implements AbstractLocationProvider.Listener {
    protected final AbstractLocationProvider mDelegate;
    private final Object mInitializationLock;
    private boolean mInitialized;

    public static /* synthetic */ AbstractLocationProvider.State $r8$lambda$9B5bGEtOtEOea6gWt4F6In9MWIM(AbstractLocationProvider.State r0, AbstractLocationProvider.State r1) {
        return lambda$onStateChanged$1(r0, r1);
    }

    public static /* synthetic */ AbstractLocationProvider.State $r8$lambda$hKmTAh3Lkch37CsGOexFrOexsbA(DelegateLocationProvider r0, AbstractLocationProvider.State r1) {
        return r0.lambda$initializeDelegate$0(r1);
    }

    DelegateLocationProvider(Executor executor, AbstractLocationProvider delegate) {
        super(executor, null, null, Collections.emptySet());
        this.mInitializationLock = new Object();
        this.mInitialized = false;
        this.mDelegate = delegate;
    }

    protected void initializeDelegate() {
        Object r0 = this.mInitializationLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitialized == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L11
        setState(new DelegateLocationProvider$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L11
        this.mInitialized = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1 = false;
        goto L8
    }

    private /* synthetic */ AbstractLocationProvider.State lambda$initializeDelegate$0(AbstractLocationProvider.State previousState) {
        return this.mDelegate.getController().setListener(this);
    }

    protected final void waitForInitialization() {
        Object r0 = this.mInitializationLock;
        monitor-enter(r0);
        Preconditions.checkState(this.mInitialized);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider.Listener
    public void onStateChanged(AbstractLocationProvider.State oldState, final AbstractLocationProvider.State newState) {
        waitForInitialization();
        setState(new DelegateLocationProvider$$ExternalSyntheticLambda0(newState));
    }

    private static /* synthetic */ AbstractLocationProvider.State lambda$onStateChanged$1(AbstractLocationProvider.State newState, AbstractLocationProvider.State previousState) {
        return newState;
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider.Listener
    public void onReportLocation(LocationResult locationResult) {
        waitForInitialization();
        reportLocation(locationResult);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onStart() {
        Preconditions.checkState(this.mInitialized);
        this.mDelegate.getController().start();
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onStop() {
        Preconditions.checkState(this.mInitialized);
        this.mDelegate.getController().stop();
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onSetRequest(ProviderRequest request) {
        Preconditions.checkState(this.mInitialized);
        this.mDelegate.getController().setRequest(request);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onFlush(Runnable callback) {
        Preconditions.checkState(this.mInitialized);
        this.mDelegate.getController().flush(callback);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onExtraCommand(int uid, int pid, String command, Bundle extras) {
        Preconditions.checkState(this.mInitialized);
        this.mDelegate.getController().sendExtraCommand(uid, pid, command, extras);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Preconditions.checkState(this.mInitialized);
        this.mDelegate.dump(fd, pw, args);
    }
}
