package com.android.server.location.gnss;

import android.location.GnssStatus;
import android.location.IGnssStatusListener;
import android.location.util.identity.CallerIdentity;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.android.internal.listeners.ListenerExecutor;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.injector.AppOpsHelper;
import com.android.server.location.injector.Injector;
import com.android.server.location.injector.LocationUsageLogger;
import com.android.server.location.listeners.ListenerRegistration;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class GnssStatusProvider extends GnssListenerMultiplexer<Void, IGnssStatusListener, Void> implements GnssNative.BaseCallbacks, GnssNative.StatusCallbacks, GnssNative.SvStatusCallbacks {
    private final AppOpsHelper mAppOpsHelper;
    private final GnssNative mGnssNative;
    private boolean mIsNavigating;
    private final LocationUsageLogger mLogger;

    /* JADX INFO: renamed from: $r8$lambda$QnNO7PdANICknwN8-IxCjQtzSjk, reason: not valid java name */
    public static /* synthetic */ void m5287$r8$lambda$QnNO7PdANICknwN8IxCjQtzSjk(GnssStatus r0, IGnssStatusListener r1) {
        lambda$onReportSvStatus$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$eaIhH4H2tx-3aS4Cx-dp2aJYReU, reason: not valid java name */
    public static /* synthetic */ void m5288$r8$lambda$eaIhH4H2tx3aS4Cxdp2aJYReU(int r0, IGnssStatusListener r1) {
        lambda$onReportFirstFix$0(r0, r1);
    }

    public static /* synthetic */ ListenerExecutor.ListenerOperation $r8$lambda$qsAsPFmMRqqZQ8vYzi0g499QgHI(GnssStatusProvider r0, GnssStatus r1, GnssListenerMultiplexer.GnssListenerRegistration r2) {
        return r0.lambda$onReportSvStatus$2(r1, r2);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    public /* bridge */ /* synthetic */ void addListener(CallerIdentity r1, IInterface r2) {
        addListener(r1, (IGnssStatusListener) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationAdded(IBinder r1, ListenerRegistration r2) {
        onRegistrationAdded(r1, (GnssListenerMultiplexer.GnssListenerRegistration) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationRemoved(IBinder r1, ListenerRegistration r2) {
        onRegistrationRemoved(r1, (GnssListenerMultiplexer.GnssListenerRegistration) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean registerWithService(Object r1, Collection r2) {
        return registerWithService((Void) r1, r2);
    }

    public GnssStatusProvider(Injector injector, GnssNative gnssNative) {
        super(injector);
        this.mIsNavigating = false;
        this.mAppOpsHelper = injector.getAppOpsHelper();
        this.mLogger = injector.getLocationUsageLogger();
        this.mGnssNative = gnssNative;
        gnssNative.addBaseCallbacks(this);
        gnssNative.addStatusCallbacks(this);
        gnssNative.addSvStatusCallbacks(this);
    }

    public void addListener(CallerIdentity identity, IGnssStatusListener listener) {
        super.addListener(identity, listener);
    }

    protected boolean registerWithService(Void ignored, Collection<GnssListenerMultiplexer<Void, IGnssStatusListener, Void>.GnssListenerRegistration> registrations) {
        if (this.mGnssNative.startSvStatusCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error starting gnss sv status");
        return false;
    L5:
        if (GnssManagerService.D == false) goto L11;
        Log.d(GnssManagerService.TAG, "starting gnss sv status");
        return true;
    L11:
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
        if (this.mGnssNative.stopSvStatusCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error stopping gnss sv status");
        return;
    L5:
        if (GnssManagerService.D == false) goto L9;
        Log.d(GnssManagerService.TAG, "stopping gnss sv status");
        return;
    }

    protected void onRegistrationAdded(IBinder key, GnssListenerMultiplexer<Void, IGnssStatusListener, Void>.GnssListenerRegistration registration) {
        this.mLogger.logLocationApiUsage(0, 3, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), null, null, true, false, null, registration.isForeground());
    }

    protected void onRegistrationRemoved(IBinder key, GnssListenerMultiplexer<Void, IGnssStatusListener, Void>.GnssListenerRegistration registration) {
        this.mLogger.logLocationApiUsage(1, 3, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), null, null, true, false, null, registration.isForeground());
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        resetService();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.StatusCallbacks
    public void onReportStatus(int gnssStatus) {
        switch(gnssStatus) {
            case 1: goto L5;
            case 2: goto L4;
            case 3: goto L3;
            case 4: goto L4;
            default: goto L3;
        };
    L3:
        boolean isNavigating = this.mIsNavigating;
    L7:
        if (isNavigating == this.mIsNavigating) goto L13;
        this.mIsNavigating = isNavigating;
        if (isNavigating == false) goto L11;
        deliverToListeners(new GnssStatusProvider$$ExternalSyntheticLambda3());
        return;
    L11:
        deliverToListeners(new GnssStatusProvider$$ExternalSyntheticLambda4());
        return;
    L13:
        return;
    L4:
        isNavigating = false;
        goto L7
    L5:
        isNavigating = true;
        goto L7
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.StatusCallbacks
    public void onReportFirstFix(final int ttff) {
        deliverToListeners(new GnssStatusProvider$$ExternalSyntheticLambda0(ttff));
    }

    private static /* synthetic */ void lambda$onReportFirstFix$0(int ttff, IGnssStatusListener listener) throws Exception {
        listener.onFirstFix(ttff);
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.SvStatusCallbacks
    public void onReportSvStatus(final GnssStatus gnssStatus) {
        deliverToListeners(new GnssStatusProvider$$ExternalSyntheticLambda2(this, gnssStatus));
    }

    private /* synthetic */ ListenerExecutor.ListenerOperation lambda$onReportSvStatus$2(final GnssStatus gnssStatus, GnssListenerMultiplexer.GnssListenerRegistration registration) {
        if (this.mAppOpsHelper.noteOpNoThrow(1, registration.getIdentity()) == true) goto L5;
        return null;
    L5:
        return new GnssStatusProvider$$ExternalSyntheticLambda1(gnssStatus);
    }

    private static /* synthetic */ void lambda$onReportSvStatus$1(GnssStatus gnssStatus, IGnssStatusListener listener) throws Exception {
        listener.onSvStatusChanged(gnssStatus);
    }
}
