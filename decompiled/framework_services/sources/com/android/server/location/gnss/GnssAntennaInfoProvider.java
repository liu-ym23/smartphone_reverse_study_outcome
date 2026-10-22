package com.android.server.location.gnss;

import android.location.GnssAntennaInfo;
import android.location.IGnssAntennaInfoListener;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.IBinder;
import com.android.internal.util.ConcurrentUtils;
import com.android.server.FgThread;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.listeners.BinderListenerRegistration;
import com.android.server.location.listeners.ListenerMultiplexer;
import com.android.server.location.listeners.ListenerRegistration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class GnssAntennaInfoProvider extends ListenerMultiplexer<IBinder, IGnssAntennaInfoListener, ListenerRegistration<IGnssAntennaInfoListener>, Void> implements GnssNative.BaseCallbacks, GnssNative.AntennaInfoCallbacks {
    private volatile List<GnssAntennaInfo> mAntennaInfos;
    private final GnssNative mGnssNative;

    protected class AntennaInfoListenerRegistration extends BinderListenerRegistration<IBinder, IGnssAntennaInfoListener> {
        private final CallerIdentity mIdentity;
        final /* synthetic */ GnssAntennaInfoProvider this$0;

        @Override // com.android.server.location.listeners.BinderListenerRegistration
        protected /* bridge */ /* synthetic */ IBinder getBinderFromKey(IBinder r1) {
            return getBinderFromKey2(r1);
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected /* bridge */ /* synthetic */ ListenerMultiplexer getOwner() {
            return getOwner();
        }

        protected AntennaInfoListenerRegistration(GnssAntennaInfoProvider this$0, CallerIdentity identity, IGnssAntennaInfoListener listener) {
            this.this$0 = this$0;
            if (identity.isMyProcess() == false) goto L5;
            Executor r0 = FgThread.getExecutor();
        L6:
            super(r0, listener);
            this.mIdentity = identity;
            return;
        L5:
            r0 = ConcurrentUtils.DIRECT_EXECUTOR;
            goto L6
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected String getTag() {
            return GnssManagerService.TAG;
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected GnssAntennaInfoProvider getOwner() {
            return this.this$0;
        }

        /* JADX INFO: renamed from: getBinderFromKey, reason: avoid collision after fix types in other method */
        protected IBinder getBinderFromKey2(IBinder key) {
            return key;
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public String toString() {
            return this.mIdentity.toString();
        }
    }

    public static /* synthetic */ void $r8$lambda$388qpu9OIFDanZibuiwKhrZ6esA(List r0, IGnssAntennaInfoListener r1) {
        lambda$onReportAntennaInfo$0(r0, r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ Void mergeRegistrations(Collection r1) {
        return mergeRegistrations2(r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean registerWithService(Void r1, Collection r2) {
        return registerWithService2(r1, r2);
    }

    GnssAntennaInfoProvider(GnssNative gnssNative) {
        this.mGnssNative = gnssNative;
        this.mGnssNative.addBaseCallbacks(this);
        this.mGnssNative.addAntennaInfoCallbacks(this);
    }

    List<GnssAntennaInfo> getAntennaInfos() {
        return this.mAntennaInfos;
    }

    public boolean isSupported() {
        return this.mGnssNative.isAntennaInfoSupported();
    }

    public void addListener(CallerIdentity callerIdentity, IGnssAntennaInfoListener listener) {
        long identity = Binder.clearCallingIdentity();
        putRegistration(listener.asBinder(), new AntennaInfoListenerRegistration(this, callerIdentity, listener));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void removeListener(IGnssAntennaInfoListener listener) {
        long identity = Binder.clearCallingIdentity();
        removeRegistration(listener.asBinder());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    /* JADX INFO: renamed from: registerWithService, reason: avoid collision after fix types in other method */
    protected boolean registerWithService2(Void merged, Collection<ListenerRegistration<IGnssAntennaInfoListener>> listenerRegistrations) {
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected boolean isActive(ListenerRegistration<IGnssAntennaInfoListener> registration) {
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    /* JADX INFO: renamed from: mergeRegistrations, reason: avoid collision after fix types in other method */
    protected Void mergeRegistrations2(Collection<ListenerRegistration<IGnssAntennaInfoListener>> listenerRegistrations) {
        return null;
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalStarted() {
        this.mGnssNative.startAntennaInfoListening();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        this.mGnssNative.startAntennaInfoListening();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.AntennaInfoCallbacks
    public void onReportAntennaInfo(final List<GnssAntennaInfo> antennaInfos) {
        if (antennaInfos.equals(this.mAntennaInfos) == false) goto L5;
        return;
    L5:
        this.mAntennaInfos = antennaInfos;
        deliverToListeners(new GnssAntennaInfoProvider$$ExternalSyntheticLambda0(antennaInfos));
    }

    private static /* synthetic */ void lambda$onReportAntennaInfo$0(List antennaInfos, IGnssAntennaInfoListener listener) throws Exception {
        listener.onGnssAntennaInfoChanged(antennaInfos);
    }
}
