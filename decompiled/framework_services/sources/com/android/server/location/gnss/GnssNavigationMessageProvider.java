package com.android.server.location.gnss;

import android.location.GnssNavigationMessage;
import android.location.IGnssNavigationMessageListener;
import android.location.util.identity.CallerIdentity;
import android.os.IInterface;
import android.util.Log;
import com.android.internal.listeners.ListenerExecutor;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.injector.AppOpsHelper;
import com.android.server.location.injector.Injector;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class GnssNavigationMessageProvider extends GnssListenerMultiplexer<Void, IGnssNavigationMessageListener, Void> implements GnssNative.BaseCallbacks, GnssNative.NavigationMessageCallbacks {
    private final AppOpsHelper mAppOpsHelper;
    private final GnssNative mGnssNative;

    private class GnssNavigationMessageListenerRegistration extends GnssListenerMultiplexer<Void, IGnssNavigationMessageListener, Void>.GnssListenerRegistration {
        public static /* synthetic */ void $r8$lambda$BoBEDBfPyR7gtZVaFDpFnnj87zQ(IGnssNavigationMessageListener r0) {
            lambda$onRegister$0(r0);
        }

        protected GnssNavigationMessageListenerRegistration(GnssNavigationMessageProvider r2, CallerIdentity callerIdentity, IGnssNavigationMessageListener listener) {
            super(r2, null, callerIdentity, listener);
        }

        @Override // com.android.server.location.gnss.GnssListenerMultiplexer.GnssListenerRegistration, com.android.server.location.listeners.BinderListenerRegistration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            executeOperation(new GnssNavigationMessageProvider$GnssNavigationMessageListenerRegistration$$ExternalSyntheticLambda0());
        }

        private static /* synthetic */ void lambda$onRegister$0(IGnssNavigationMessageListener listener) throws Exception {
            listener.onStatusChanged(1);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$34WAYhxRSFJiVL9c4FO-hJtWuT8, reason: not valid java name */
    public static /* synthetic */ ListenerExecutor.ListenerOperation m5261$r8$lambda$34WAYhxRSFJiVL9c4FOhJtWuT8(GnssNavigationMessageProvider r0, GnssNavigationMessage r1, GnssListenerMultiplexer.GnssListenerRegistration r2) {
        return r0.lambda$onReportNavigationMessage$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$f-SZ_rst97IBLhPC3S2XayaZh7U, reason: not valid java name */
    public static /* synthetic */ void m5262$r8$lambda$fSZ_rst97IBLhPC3S2XayaZh7U(GnssNavigationMessage r0, IGnssNavigationMessageListener r1) {
        lambda$onReportNavigationMessage$0(r0, r1);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    public /* bridge */ /* synthetic */ void addListener(CallerIdentity r1, IInterface r2) {
        addListener(r1, (IGnssNavigationMessageListener) r2);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    protected /* bridge */ /* synthetic */ GnssListenerMultiplexer<Void, IGnssNavigationMessageListener, Void>.GnssListenerRegistration createRegistration(Void r1, CallerIdentity r2, IInterface r3) {
        return createRegistration(r1, r2, (IGnssNavigationMessageListener) r3);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean registerWithService(Object r1, Collection r2) {
        return registerWithService((Void) r1, r2);
    }

    public GnssNavigationMessageProvider(Injector injector, GnssNative gnssNative) {
        super(injector);
        this.mAppOpsHelper = injector.getAppOpsHelper();
        this.mGnssNative = gnssNative;
        this.mGnssNative.addBaseCallbacks(this);
        this.mGnssNative.addNavigationMessageCallbacks(this);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    public boolean isSupported() {
        return this.mGnssNative.isNavigationMessageCollectionSupported();
    }

    public void addListener(CallerIdentity identity, IGnssNavigationMessageListener listener) {
        super.addListener(identity, listener);
    }

    protected GnssListenerMultiplexer<Void, IGnssNavigationMessageListener, Void>.GnssListenerRegistration createRegistration(Void request, CallerIdentity callerIdentity, IGnssNavigationMessageListener listener) {
        return new GnssNavigationMessageListenerRegistration(this, callerIdentity, listener);
    }

    protected boolean registerWithService(Void ignored, Collection<GnssListenerMultiplexer<Void, IGnssNavigationMessageListener, Void>.GnssListenerRegistration> registrations) {
        if (this.mGnssNative.startNavigationMessageCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error starting gnss navigation messages");
        return false;
    L5:
        if (GnssManagerService.D == false) goto L11;
        Log.d(GnssManagerService.TAG, "starting gnss navigation messages");
        return true;
    L11:
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
        if (this.mGnssNative.stopNavigationMessageCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error stopping gnss navigation messages");
        return;
    L5:
        if (GnssManagerService.D == false) goto L9;
        Log.d(GnssManagerService.TAG, "stopping gnss navigation messages");
        return;
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        resetService();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.NavigationMessageCallbacks
    public void onReportNavigationMessage(final GnssNavigationMessage event) {
        deliverToListeners(new GnssNavigationMessageProvider$$ExternalSyntheticLambda1(this, event));
    }

    private /* synthetic */ ListenerExecutor.ListenerOperation lambda$onReportNavigationMessage$1(final GnssNavigationMessage event, GnssListenerMultiplexer.GnssListenerRegistration registration) {
        if (this.mAppOpsHelper.noteOpNoThrow(1, registration.getIdentity()) == true) goto L5;
        return null;
    L5:
        return new GnssNavigationMessageProvider$$ExternalSyntheticLambda0(event);
    }

    private static /* synthetic */ void lambda$onReportNavigationMessage$0(GnssNavigationMessage event, IGnssNavigationMessageListener listener) throws Exception {
        listener.onGnssNavigationMessageReceived(event);
    }
}
