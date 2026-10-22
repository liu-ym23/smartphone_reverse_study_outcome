package com.android.server.location.gnss;

import android.location.GnssMeasurement;
import android.location.GnssMeasurementRequest;
import android.location.GnssMeasurementsEvent;
import android.location.IGnssMeasurementsListener;
import android.location.util.identity.CallerIdentity;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.android.internal.listeners.ListenerExecutor;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.location.eventlog.LocationEventLog;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.injector.AppOpsHelper;
import com.android.server.location.injector.Injector;
import com.android.server.location.injector.LocationUsageLogger;
import com.android.server.location.injector.SettingsHelper;
import com.android.server.location.listeners.ListenerRegistration;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class GnssMeasurementsProvider extends GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest> implements SettingsHelper.GlobalSettingChangedListener, GnssNative.BaseCallbacks, GnssNative.MeasurementCallbacks {
    private final AppOpsHelper mAppOpsHelper;
    private final GnssNative mGnssNative;
    private GnssMeasurementsEvent mLastGnssMeasurementsEvent;
    private final LocationUsageLogger mLogger;

    private class GnssMeasurementListenerRegistration extends GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration {
        final /* synthetic */ GnssMeasurementsProvider this$0;

        public static /* synthetic */ void $r8$lambda$HF7Nsddx5j39_8GGOZjJuqMFJoI(IGnssMeasurementsListener r0) {
            lambda$onRegister$0(r0);
        }

        protected GnssMeasurementListenerRegistration(GnssMeasurementsProvider r1, GnssMeasurementRequest request, CallerIdentity callerIdentity, IGnssMeasurementsListener listener) {
            this.this$0 = r1;
            super(r1, request, callerIdentity, listener);
        }

        @Override // com.android.server.location.gnss.GnssListenerMultiplexer.GnssListenerRegistration, com.android.server.location.listeners.BinderListenerRegistration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            LocationEventLog.EVENT_LOG.logGnssMeasurementClientRegistered(getIdentity(), (GnssMeasurementRequest) getRequest());
            executeOperation(new GnssMeasurementsProvider$GnssMeasurementListenerRegistration$$ExternalSyntheticLambda0());
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + getIdentity().getUserId() + "]request gnss measurements from " + getIdentity());
        }

        private static /* synthetic */ void lambda$onRegister$0(IGnssMeasurementsListener listener) throws Exception {
            listener.onStatusChanged(1);
        }

        @Override // com.android.server.location.listeners.BinderListenerRegistration, com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
        protected void onUnregister() {
            LocationEventLog.EVENT_LOG.logGnssMeasurementClientUnregistered(getIdentity());
            super.onUnregister();
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + getIdentity().getUserId() + "]remove gnss measurements from " + getIdentity());
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected void onActive() {
            GnssMeasurementsProvider.m5258$$Nest$fgetmAppOpsHelper(this.this$0).startOpNoThrow(42, getIdentity());
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected void onInactive() {
            GnssMeasurementsProvider.m5258$$Nest$fgetmAppOpsHelper(this.this$0).finishOp(42, getIdentity());
        }
    }

    public static /* synthetic */ ListenerExecutor.ListenerOperation $r8$lambda$No3Dm8uryGXU3sw3KDMzPQjpXCE(GnssMeasurementsProvider r0, GnssMeasurementsEvent r1, GnssListenerMultiplexer.GnssListenerRegistration r2) {
        return r0.lambda$onReportMeasurements$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$S8pdLPl99PS7zjoxENRN9LwkjGc(GnssMeasurementsEvent r0, IGnssMeasurementsListener r1) {
        lambda$onReportMeasurements$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsHelper m5258$$Nest$fgetmAppOpsHelper(GnssMeasurementsProvider r0) {
        return r0.mAppOpsHelper;
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    public /* bridge */ /* synthetic */ void addListener(GnssMeasurementRequest r1, CallerIdentity r2, IInterface r3) {
        addListener(r1, r2, (IGnssMeasurementsListener) r3);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    protected /* bridge */ /* synthetic */ GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration createRegistration(GnssMeasurementRequest r1, CallerIdentity r2, IInterface r3) {
        return createRegistration(r1, r2, (IGnssMeasurementsListener) r3);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer, com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ Object mergeRegistrations(Collection r1) {
        return mergeRegistrations(r1);
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
        return registerWithService((GnssMeasurementRequest) r1, r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean reregisterWithService(Object r1, Object r2, Collection r3) {
        return reregisterWithService((GnssMeasurementRequest) r1, (GnssMeasurementRequest) r2, r3);
    }

    public GnssMeasurementsProvider(Injector injector, GnssNative gnssNative) {
        super(injector);
        this.mAppOpsHelper = injector.getAppOpsHelper();
        this.mLogger = injector.getLocationUsageLogger();
        this.mGnssNative = gnssNative;
        this.mGnssNative.addBaseCallbacks(this);
        this.mGnssNative.addMeasurementCallbacks(this);
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer
    public boolean isSupported() {
        return this.mGnssNative.isMeasurementSupported();
    }

    public void addListener(GnssMeasurementRequest request, CallerIdentity identity, IGnssMeasurementsListener listener) {
        super.addListener(request, identity, listener);
    }

    protected GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration createRegistration(GnssMeasurementRequest request, CallerIdentity callerIdentity, IGnssMeasurementsListener listener) {
        return new GnssMeasurementListenerRegistration(this, request, callerIdentity, listener);
    }

    protected boolean registerWithService(GnssMeasurementRequest request, Collection<GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration> registrations) {
        if (request.getIntervalMillis() != Integer.MAX_VALUE) goto L6;
        return true;
    L6:
        if (this.mGnssNative.startMeasurementCollection(request.isFullTracking(), request.isCorrelationVectorOutputsEnabled(), request.getIntervalMillis()) == true) goto L8;
        Log.e(GnssManagerService.TAG, "error starting gnss measurements");
        return false;
    L8:
        if (GnssManagerService.D == false) goto L10;
        Log.d(GnssManagerService.TAG, "starting gnss measurements (" + request + ")");
    L10:
        return true;
    }

    protected boolean reregisterWithService(GnssMeasurementRequest old, GnssMeasurementRequest request, Collection<GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration> registrations) {
        boolean aidlV3Plus = true;
        if (request.getIntervalMillis() != Integer.MAX_VALUE) goto L6;
        unregisterWithService();
        return true;
    L6:
        GnssConfiguration.HalInterfaceVersion halInterfaceVersion = this.mGnssNative.getConfiguration().getHalInterfaceVersion();
        if (halInterfaceVersion.mMajor == 3) goto L9;
    L11:
        aidlV3Plus = false;
    L12:
        if (aidlV3Plus == true) goto L15;
        unregisterWithService();
    L15:
        return registerWithService(request, registrations);
    L9:
        if (halInterfaceVersion.mMinor < 3) goto L11;
        goto L11
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
        if (this.mGnssNative.stopMeasurementCollection() == true) goto L5;
        Log.e(GnssManagerService.TAG, "error stopping gnss measurements");
        return;
    L5:
        if (GnssManagerService.D == false) goto L9;
        Log.d(GnssManagerService.TAG, "stopping gnss measurements");
        return;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onActive() {
        this.mSettingsHelper.addOnGnssMeasurementsFullTrackingEnabledChangedListener(this);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onInactive() {
        this.mSettingsHelper.removeOnGnssMeasurementsFullTrackingEnabledChangedListener(this);
    }

    @Override // com.android.server.location.injector.SettingsHelper.GlobalSettingChangedListener
    public void onSettingChanged() {
        updateService();
    }

    @Override // com.android.server.location.gnss.GnssListenerMultiplexer, com.android.server.location.listeners.ListenerMultiplexer
    protected GnssMeasurementRequest mergeRegistrations(Collection<GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration> registrations) {
        boolean fullTracking = false;
        boolean enableCorrVecOutputs = false;
        int intervalMillis = Integer.MAX_VALUE;
        if (this.mSettingsHelper.isGnssMeasurementsFullTrackingEnabled() == false) goto L5;
        fullTracking = true;
    L5:
        Iterator<GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration> r3 = registrations.iterator();
    L7:
        if (r3.hasNext() == false) goto L19;
        GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration registration = r3.next();
        GnssMeasurementRequest request = registration.getRequest();
        if (request.getIntervalMillis() == Integer.MAX_VALUE) goto L7;
        if (request.isFullTracking() == false) goto L15;
        fullTracking = true;
    L15:
        if (request.isCorrelationVectorOutputsEnabled() == false) goto L17;
        enableCorrVecOutputs = true;
    L17:
        intervalMillis = Math.min(intervalMillis, request.getIntervalMillis());
        goto L7
    L19:
        return new GnssMeasurementRequest.Builder().setFullTracking(fullTracking).setCorrelationVectorOutputsEnabled(enableCorrVecOutputs).setIntervalMillis(intervalMillis).build();
    }

    protected void onRegistrationAdded(IBinder key, GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration registration) {
        this.mLogger.logLocationApiUsage(0, 2, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), null, null, true, false, null, registration.isForeground());
    }

    protected void onRegistrationRemoved(IBinder key, GnssListenerMultiplexer<GnssMeasurementRequest, IGnssMeasurementsListener, GnssMeasurementRequest>.GnssListenerRegistration registration) {
        this.mLogger.logLocationApiUsage(1, 2, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), null, null, true, false, null, registration.isForeground());
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        resetService();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.MeasurementCallbacks
    public void onReportMeasurements(final GnssMeasurementsEvent event) {
        deliverToListeners(new GnssMeasurementsProvider$$ExternalSyntheticLambda0(this, event));
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        this.mLastGnssMeasurementsEvent = event;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ ListenerExecutor.ListenerOperation lambda$onReportMeasurements$1(final GnssMeasurementsEvent event, GnssListenerMultiplexer.GnssListenerRegistration registration) {
        if (this.mAppOpsHelper.noteOpNoThrow(1, registration.getIdentity()) == false) goto L6;
        LocationEventLog.EVENT_LOG.logGnssMeasurementsDelivered(event.getMeasurements().size(), registration.getIdentity());
        return new GnssMeasurementsProvider$$ExternalSyntheticLambda1(event);
    L6:
        return null;
    }

    private static /* synthetic */ void lambda$onReportMeasurements$0(GnssMeasurementsEvent event, IGnssMeasurementsListener listener) throws Exception {
        listener.onGnssMeasurementsReceived(event);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        super.dump(fd, pw, args);
        pw.print("last measurements=");
        pw.println(getLastMeasurementEventSummary());
    }

    private String getLastMeasurementEventSummary() {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mLastGnssMeasurementsEvent != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        StringBuilder builder = new StringBuilder("[");     // Catch: Throwable -> L9
        builder.append("elapsedRealtimeNs=");     // Catch: Throwable -> L9
        builder.append(this.mLastGnssMeasurementsEvent.getClock().getElapsedRealtimeNanos());     // Catch: Throwable -> L9
        builder.append(" measurementCount=");     // Catch: Throwable -> L9
        builder.append(this.mLastGnssMeasurementsEvent.getMeasurements().size());     // Catch: Throwable -> L9
        float sumBasebandCn0 = 0.0f;
        int countBasebandCn0 = 0;
        Iterator<GnssMeasurement> r4 = this.mLastGnssMeasurementsEvent.getMeasurements().iterator();     // Catch: Throwable -> L9
    L13:
        if (r4.hasNext() == false) goto L18;
        GnssMeasurement measurement = r4.next();     // Catch: Throwable -> L9
        if (measurement.hasBasebandCn0DbHz() == false) goto L13;
        sumBasebandCn0 = (float) (((double) sumBasebandCn0) + measurement.getBasebandCn0DbHz());     // Catch: Throwable -> L9
        countBasebandCn0 = countBasebandCn0 + 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        if (countBasebandCn0 <= 0) goto L20;
        builder.append(" avgBasebandCn0=");     // Catch: Throwable -> L9
        builder.append(sumBasebandCn0 / countBasebandCn0);     // Catch: Throwable -> L9
    L20:
        builder.append("]");     // Catch: Throwable -> L9
        String r5 = builder.toString();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r5;
    }
}
