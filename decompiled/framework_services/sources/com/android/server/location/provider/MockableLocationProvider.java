package com.android.server.location.provider;

import android.location.Location;
import android.location.LocationResult;
import android.location.provider.ProviderRequest;
import android.os.Bundle;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class MockableLocationProvider extends AbstractLocationProvider {
    private MockLocationProvider mMockProvider;
    final Object mOwnerLock;
    private AbstractLocationProvider mProvider;
    private AbstractLocationProvider mRealProvider;
    private ProviderRequest mRequest;
    private boolean mStarted;

    private class ListenerWrapper implements AbstractLocationProvider.Listener {
        private final AbstractLocationProvider mListenerProvider;
        final /* synthetic */ MockableLocationProvider this$0;

        /* JADX INFO: renamed from: $r8$lambda$-OaxEM5nNcchTLhF3jHu6bbV1hc, reason: not valid java name */
        public static /* synthetic */ AbstractLocationProvider.State m5415$r8$lambda$OaxEM5nNcchTLhF3jHu6bbV1hc(AbstractLocationProvider.State r0, AbstractLocationProvider.State r1) {
            return lambda$onStateChanged$0(r0, r1);
        }

        ListenerWrapper(MockableLocationProvider r1, AbstractLocationProvider listenerProvider) {
            this.this$0 = r1;
            this.mListenerProvider = listenerProvider;
        }

        @Override // com.android.server.location.provider.AbstractLocationProvider.Listener
        public final void onStateChanged(AbstractLocationProvider.State oldState, final AbstractLocationProvider.State newState) {
            Object r0 = this.this$0.mOwnerLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mListenerProvider == MockableLocationProvider.m5414$$Nest$fgetmProvider(this.this$0)) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.this$0.setState(new MockableLocationProvider$ListenerWrapper$$ExternalSyntheticLambda0(newState));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private static /* synthetic */ AbstractLocationProvider.State lambda$onStateChanged$0(AbstractLocationProvider.State newState, AbstractLocationProvider.State prevState) {
            return newState;
        }

        @Override // com.android.server.location.provider.AbstractLocationProvider.Listener
        public final void onReportLocation(LocationResult locationResult) {
            Object r0 = this.this$0.mOwnerLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mListenerProvider == MockableLocationProvider.m5414$$Nest$fgetmProvider(this.this$0)) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.this$0.reportLocation(locationResult);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$va9Z2xDqK0vFpiJbyUFkO_K-fVw, reason: not valid java name */
    public static /* synthetic */ AbstractLocationProvider.State m5413$r8$lambda$va9Z2xDqK0vFpiJbyUFkO_KfVw(AbstractLocationProvider.State r0, AbstractLocationProvider.State r1) {
        return lambda$setProviderLocked$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ AbstractLocationProvider m5414$$Nest$fgetmProvider(MockableLocationProvider r0) {
        return r0.mProvider;
    }

    public MockableLocationProvider(Object ownerLock) {
        super(ConcurrentUtils.DIRECT_EXECUTOR, null, null, Collections.emptySet());
        this.mOwnerLock = ownerLock;
        this.mRequest = ProviderRequest.EMPTY_REQUEST;
    }

    public AbstractLocationProvider getProvider() {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
        AbstractLocationProvider r1 = this.mProvider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRealProvider(AbstractLocationProvider provider) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRealProvider != provider) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mRealProvider = provider;     // Catch: Throwable -> L8
        if (isMock() == true) goto L13;
        setProviderLocked(this.mRealProvider);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void setMockProvider(MockLocationProvider provider) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMockProvider != provider) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mMockProvider = provider;     // Catch: Throwable -> L8
        if (this.mMockProvider == null) goto L13;
        setProviderLocked(this.mMockProvider);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        setProviderLocked(this.mRealProvider);     // Catch: Throwable -> L8
        goto L14
    }

    private void setProviderLocked(AbstractLocationProvider provider) {
        if (this.mProvider != provider) goto L5;
        return;
    L5:
        AbstractLocationProvider oldProvider = this.mProvider;
        this.mProvider = provider;
        if (oldProvider == null) goto L11;
        oldProvider.getController().setListener(null);
        if (oldProvider.getController().isStarted() == false) goto L11;
        oldProvider.getController().setRequest(ProviderRequest.EMPTY_REQUEST);
        oldProvider.getController().stop();
    L11:
        if (this.mProvider == null) goto L21;
        final AbstractLocationProvider.State newState = this.mProvider.getController().setListener(new ListenerWrapper(this, this.mProvider));
        if (this.mStarted == false) goto L19;
        if (this.mProvider.getController().isStarted() == true) goto L17;
        this.mProvider.getController().start();
    L17:
        this.mProvider.getController().setRequest(this.mRequest);
    L22:
        setState(new MockableLocationProvider$$ExternalSyntheticLambda0(newState));
        return;
    L19:
        if (this.mProvider.getController().isStarted() == false) goto L22;
        this.mProvider.getController().setRequest(ProviderRequest.EMPTY_REQUEST);
        this.mProvider.getController().stop();
        goto L22
    L21:
        newState = AbstractLocationProvider.State.EMPTY_STATE;
        goto L22
    }

    private static /* synthetic */ AbstractLocationProvider.State lambda$setProviderLocked$0(AbstractLocationProvider.State newState, AbstractLocationProvider.State prevState) {
        return newState;
    }

    public boolean isMock() {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mMockProvider != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mProvider != this.mMockProvider) goto L11;
        r1 = true;
        goto L12
    }

    public void setMockProviderAllowed(boolean allowed) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
        Preconditions.checkState(isMock());     // Catch: Throwable -> L7
        this.mMockProvider.setProviderAllowed(allowed);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMockProviderLocation(Location location) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
        Preconditions.checkState(isMock());     // Catch: Throwable -> L7
        this.mMockProvider.setProviderLocation(location);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ProviderRequest getCurrentRequest() {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
        ProviderRequest r1 = this.mRequest;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onStart() {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L13
        this.mStarted = true;     // Catch: Throwable -> L13
        if (this.mProvider == null) goto L15;
        this.mProvider.getController().start();     // Catch: Throwable -> L13
        if (this.mRequest.equals(ProviderRequest.EMPTY_REQUEST) == true) goto L15;
        this.mProvider.getController().setRequest(this.mRequest);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onStop() {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
        Preconditions.checkState(this.mStarted);     // Catch: Throwable -> L9
        this.mStarted = false;     // Catch: Throwable -> L9
        if (this.mProvider != null) goto L7;
    L12:
        this.mRequest = ProviderRequest.EMPTY_REQUEST;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mRequest.equals(ProviderRequest.EMPTY_REQUEST) == true) goto L11;
        this.mProvider.getController().setRequest(ProviderRequest.EMPTY_REQUEST);     // Catch: Throwable -> L9
    L11:
        this.mProvider.getController().stop();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onSetRequest(ProviderRequest request) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (request != this.mRequest) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mRequest = request;     // Catch: Throwable -> L8
        if (this.mProvider == null) goto L13;
        this.mProvider.getController().setRequest(request);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onFlush(Runnable callback) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProvider == null) goto L9;
        this.mProvider.getController().flush(callback);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        callback.run();     // Catch: Throwable -> L7
        goto L10
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onExtraCommand(int uid, int pid, String command, Bundle extras) {
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProvider == null) goto L9;
        this.mProvider.getController().sendExtraCommand(uid, pid, command, extras);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Preconditions.checkState(!Thread.holdsLock(this.mOwnerLock));
        Object r0 = this.mOwnerLock;
        monitor-enter(r0);
        AbstractLocationProvider provider = this.mProvider;     // Catch: Throwable -> L18
        AbstractLocationProvider.State providerState = getState();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        pw.println("allowed=" + providerState.allowed);
        if (providerState.identity == null) goto L10;
        pw.println("identity=" + providerState.identity);
    L10:
        if (providerState.extraAttributionTags.isEmpty() == true) goto L13;
        pw.println("extra attribution tags=" + providerState.extraAttributionTags);
    L13:
        if (providerState.properties == null) goto L15;
        pw.println("properties=" + providerState.properties);
    L15:
        if (provider == null) goto L23;
        provider.dump(fd, pw, args);
        return;
    L23:
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
