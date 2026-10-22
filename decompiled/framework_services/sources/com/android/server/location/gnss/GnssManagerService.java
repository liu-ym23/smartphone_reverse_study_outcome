package com.android.server.location.gnss;

import android.content.Context;
import android.content.Intent;
import android.hardware.location.GeofenceHardwareImpl;
import android.location.FusedBatchOptions;
import android.location.GnssAntennaInfo;
import android.location.GnssAssistance;
import android.location.GnssCapabilities;
import android.location.GnssMeasurementCorrections;
import android.location.GnssMeasurementRequest;
import android.location.IGnssAntennaInfoListener;
import android.location.IGnssMeasurementsListener;
import android.location.IGnssNavigationMessageListener;
import android.location.IGnssNmeaListener;
import android.location.IGnssStatusListener;
import android.location.IGpsGeofenceHardware;
import android.location.Location;
import android.location.provider.IGnssAssistanceCallback;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.internal.app.IBatteryStats;
import com.android.server.FgThread;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.injector.Injector;
import com.android.server.location.provider.proxy.ProxyGnssAssistanceProvider;
import java.io.FileDescriptor;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GnssManagerService implements GnssNative.GnssAssistanceCallbacks {
    private static final String ATTRIBUTION_ID = "GnssService";
    public static final boolean D = false;
    public static final String TAG = "GnssManager";
    private final GnssCapabilitiesHalModule mCapabilitiesHalModule;
    final Context mContext;
    private final GnssGeofenceHalModule mGeofenceHalModule;
    private final GnssAntennaInfoProvider mGnssAntennaInfoProvider;
    private final IGpsGeofenceHardware mGnssGeofenceProxy;
    private final GnssLocationProvider mGnssLocationProvider;
    private final GnssMeasurementsProvider mGnssMeasurementsProvider;
    private final GnssMetrics mGnssMetrics;
    private final GnssNative mGnssNative;
    private final GnssNavigationMessageProvider mGnssNavigationMessageProvider;
    private final GnssNmeaProvider mGnssNmeaProvider;
    private final GnssStatusProvider mGnssStatusProvider;
    private ProxyGnssAssistanceProvider mProxyGnssAssistanceProvider;

    /* JADX INFO: renamed from: com.android.server.location.gnss.GnssManagerService$1, reason: invalid class name */
    class AnonymousClass1 extends IGnssAssistanceCallback.Stub {
        final /* synthetic */ GnssManagerService this$0;

        AnonymousClass1(GnssManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onError() {
            Log.e(GnssManagerService.TAG, "GnssAssistanceCallback.onError");
        }

        public void onResult(GnssAssistance gnssAssistance) {
            Log.d(GnssManagerService.TAG, "GnssAssistanceCallback.onResult");
            GnssManagerService.m5254$$Nest$fgetmGnssNative(this.this$0).injectGnssAssistance(gnssAssistance);
        }
    }

    private class GnssCapabilitiesHalModule implements GnssNative.BaseCallbacks {
        final /* synthetic */ GnssManagerService this$0;

        GnssCapabilitiesHalModule(GnssManagerService r1, GnssNative gnssNative) {
            this.this$0 = r1;
            gnssNative.addBaseCallbacks(this);
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
        public void onHalRestarted() {
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
        public void onCapabilitiesChanged(GnssCapabilities oldCapabilities, GnssCapabilities newCapabilities) {
            long ident = Binder.clearCallingIdentity();
            Intent intent = new Intent("android.location.action.GNSS_CAPABILITIES_CHANGED").putExtra("android.location.extra.GNSS_CAPABILITIES", newCapabilities).addFlags(1073741824).addFlags(268435456);     // Catch: Throwable -> L6
            this.this$0.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }
    }

    private class GnssGeofenceHalModule implements GnssNative.GeofenceCallbacks {
        private GeofenceHardwareImpl mGeofenceHardwareImpl;
        final /* synthetic */ GnssManagerService this$0;

        public static /* synthetic */ void $r8$lambda$2owXT7etoTw1nBlu35qII2eupJI(GnssGeofenceHalModule r0, int r1, int r2) {
            r0.lambda$onReportGeofencePauseStatus$4(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$74HUUdWklDXFQXHdlQf84aSx3-M, reason: not valid java name */
        public static /* synthetic */ void m5255$r8$lambda$74HUUdWklDXFQXHdlQf84aSx3M(GnssGeofenceHalModule r0, int r1, int r2) {
            r0.lambda$onReportGeofenceResumeStatus$5(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$FMo6hGAeFF59sUBZjZibwlRVVpY(GnssGeofenceHalModule r0, int r1, int r2) {
            r0.lambda$onReportGeofenceRemoveStatus$3(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$HGdYuzeCtBmKAb4ypcbn5fc0-Q8, reason: not valid java name */
        public static /* synthetic */ void m5256$r8$lambda$HGdYuzeCtBmKAb4ypcbn5fc0Q8(GnssGeofenceHalModule r0, int r1, Location r2) {
            r0.lambda$onReportGeofenceStatus$1(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$OwvRX_GuOMN3u5n5yf43jnP-gIo, reason: not valid java name */
        public static /* synthetic */ void m5257$r8$lambda$OwvRX_GuOMN3u5n5yf43jnPgIo(GnssGeofenceHalModule r0, int r1, int r2) {
            r0.lambda$onReportGeofenceAddStatus$2(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$pRA6xcVsmGjSVAfLK3HHR752yr8(GnssGeofenceHalModule r0, int r1, Location r2, int r3, long r4) {
            r0.lambda$onReportGeofenceTransition$0(r1, r2, r3, r4);
        }

        GnssGeofenceHalModule(GnssManagerService r1, GnssNative gnssNative) {
            this.this$0 = r1;
            gnssNative.setGeofenceCallbacks(this);
        }

        private synchronized GeofenceHardwareImpl getGeofenceHardware() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mGeofenceHardwareImpl != null) goto L8;
            this.mGeofenceHardwareImpl = GeofenceHardwareImpl.getInstance(this.this$0.mContext);     // Catch: Throwable -> L6
        L8:
            GeofenceHardwareImpl r0 = this.mGeofenceHardwareImpl;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        }

        private /* synthetic */ void lambda$onReportGeofenceTransition$0(int geofenceId, Location location, int transition, long timestamp) {
            getGeofenceHardware().reportGeofenceTransition(geofenceId, location, transition, timestamp, 0, FusedBatchOptions.SourceTechnologies.GNSS);
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.GeofenceCallbacks
        public void onReportGeofenceTransition(final int geofenceId, final Location location, final int transition, final long timestamp) {
            FgThread.getHandler().post(new GnssManagerService$GnssGeofenceHalModule$$ExternalSyntheticLambda2(this, geofenceId, location, transition, timestamp));
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.GeofenceCallbacks
        public void onReportGeofenceStatus(final int status, final Location location) {
            FgThread.getHandler().post(new GnssManagerService$GnssGeofenceHalModule$$ExternalSyntheticLambda4(this, status, location));
        }

        private /* synthetic */ void lambda$onReportGeofenceStatus$1(int status, Location location) {
            int monitorStatus = 1;
            if (status != 2) goto L5;
            monitorStatus = 0;
        L5:
            getGeofenceHardware().reportGeofenceMonitorStatus(0, monitorStatus, location, FusedBatchOptions.SourceTechnologies.GNSS);
        }

        private /* synthetic */ void lambda$onReportGeofenceAddStatus$2(int geofenceId, int status) {
            getGeofenceHardware().reportGeofenceAddStatus(geofenceId, translateGeofenceStatus(status));
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.GeofenceCallbacks
        public void onReportGeofenceAddStatus(final int geofenceId, final int status) {
            FgThread.getHandler().post(new GnssManagerService$GnssGeofenceHalModule$$ExternalSyntheticLambda1(this, geofenceId, status));
        }

        private /* synthetic */ void lambda$onReportGeofenceRemoveStatus$3(int geofenceId, int status) {
            getGeofenceHardware().reportGeofenceRemoveStatus(geofenceId, translateGeofenceStatus(status));
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.GeofenceCallbacks
        public void onReportGeofenceRemoveStatus(final int geofenceId, final int status) {
            FgThread.getHandler().post(new GnssManagerService$GnssGeofenceHalModule$$ExternalSyntheticLambda3(this, geofenceId, status));
        }

        private /* synthetic */ void lambda$onReportGeofencePauseStatus$4(int geofenceId, int status) {
            getGeofenceHardware().reportGeofencePauseStatus(geofenceId, translateGeofenceStatus(status));
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.GeofenceCallbacks
        public void onReportGeofencePauseStatus(final int geofenceId, final int status) {
            FgThread.getHandler().post(new GnssManagerService$GnssGeofenceHalModule$$ExternalSyntheticLambda0(this, geofenceId, status));
        }

        private /* synthetic */ void lambda$onReportGeofenceResumeStatus$5(int geofenceId, int status) {
            getGeofenceHardware().reportGeofenceResumeStatus(geofenceId, translateGeofenceStatus(status));
        }

        @Override // com.android.server.location.gnss.hal.GnssNative.GeofenceCallbacks
        public void onReportGeofenceResumeStatus(final int geofenceId, final int status) {
            FgThread.getHandler().post(new GnssManagerService$GnssGeofenceHalModule$$ExternalSyntheticLambda5(this, geofenceId, status));
        }

        private int translateGeofenceStatus(int status) {
            switch(status) {
                case -149: goto L15;
                case -103: goto L13;
                case -102: goto L11;
                case -101: goto L9;
                case 0: goto L7;
                case 100: goto L5;
                default: goto L3;
            };
        L3:
            return -1;
        L5:
            return 1;
        L7:
            return 0;
        L9:
            return 2;
        L11:
            return 3;
        L13:
            return 4;
        L15:
            return 5;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGnssNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ GnssNative m5254$$Nest$fgetmGnssNative(GnssManagerService r0) {
        return r0.mGnssNative;
    }

    static {
        D = Log.isLoggable(TAG, 3);
    }

    public GnssManagerService(Context context, Injector injector, GnssNative gnssNative) {
        this.mProxyGnssAssistanceProvider = null;
        this.mContext = context.createAttributionContext(ATTRIBUTION_ID);
        this.mGnssNative = gnssNative;
        this.mGnssMetrics = new GnssMetrics(this.mContext, IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats")), this.mGnssNative);
        this.mGnssLocationProvider = new GnssLocationProvider(this.mContext, this.mGnssNative, this.mGnssMetrics);
        this.mGnssStatusProvider = new GnssStatusProvider(injector, this.mGnssNative);
        this.mGnssNmeaProvider = new GnssNmeaProvider(injector, this.mGnssNative);
        this.mGnssMeasurementsProvider = new GnssMeasurementsProvider(injector, this.mGnssNative);
        this.mGnssNavigationMessageProvider = new GnssNavigationMessageProvider(injector, this.mGnssNative);
        this.mGnssAntennaInfoProvider = new GnssAntennaInfoProvider(this.mGnssNative);
        this.mGnssGeofenceProxy = new GnssGeofenceProxy(this.mGnssNative);
        this.mGeofenceHalModule = new GnssGeofenceHalModule(this, this.mGnssNative);
        this.mCapabilitiesHalModule = new GnssCapabilitiesHalModule(this, this.mGnssNative);
        this.mGnssNative.register();
    }

    public void onSystemReady() {
        this.mGnssLocationProvider.onSystemReady();
    }

    public GnssLocationProvider getGnssLocationProvider() {
        return this.mGnssLocationProvider;
    }

    public void setAutomotiveGnssSuspended(boolean suspended) {
        this.mGnssLocationProvider.setAutomotiveGnssSuspended(suspended);
    }

    public boolean isAutomotiveGnssSuspended() {
        return this.mGnssLocationProvider.isAutomotiveGnssSuspended();
    }

    public IGpsGeofenceHardware getGnssGeofenceProxy() {
        return this.mGnssGeofenceProxy;
    }

    public int getGnssYearOfHardware() {
        return this.mGnssNative.getHardwareYear();
    }

    public String getGnssHardwareModelName() {
        return this.mGnssNative.getHardwareModelName();
    }

    public GnssCapabilities getGnssCapabilities() {
        return this.mGnssNative.getCapabilities();
    }

    public List<GnssAntennaInfo> getGnssAntennaInfos() {
        return this.mGnssAntennaInfoProvider.getAntennaInfos();
    }

    public int getGnssBatchSize() {
        return this.mGnssLocationProvider.getBatchSize();
    }

    public void registerGnssStatusCallback(IGnssStatusListener listener, String packageName, String attributionTag, String listenerId) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", null);
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        this.mGnssStatusProvider.addListener(identity, listener);
    }

    public void unregisterGnssStatusCallback(IGnssStatusListener listener) {
        this.mGnssStatusProvider.removeListener(listener);
    }

    public void registerGnssNmeaCallback(IGnssNmeaListener listener, String packageName, String attributionTag, String listenerId) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", null);
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        this.mGnssNmeaProvider.addListener(identity, listener);
    }

    public void unregisterGnssNmeaCallback(IGnssNmeaListener listener) {
        this.mGnssNmeaProvider.removeListener(listener);
    }

    public void addGnssMeasurementsListener(GnssMeasurementRequest request, IGnssMeasurementsListener listener, String packageName, String attributionTag, String listenerId) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", null);
        if (request.isCorrelationVectorOutputsEnabled() == false) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.LOCATION_HARDWARE", null);
    L5:
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        this.mGnssMeasurementsProvider.addListener(request, identity, listener);
    }

    public void injectGnssMeasurementCorrections(GnssMeasurementCorrections corrections) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.LOCATION_HARDWARE", null);
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", null);
        if (this.mGnssNative.injectMeasurementCorrections(corrections) == true) goto L6;
        Log.w(TAG, "failed to inject GNSS measurement corrections");
        return;
    }

    public void removeGnssMeasurementsListener(IGnssMeasurementsListener listener) {
        this.mGnssMeasurementsProvider.removeListener(listener);
    }

    public void addGnssNavigationMessageListener(IGnssNavigationMessageListener listener, String packageName, String attributionTag, String listenerId) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", null);
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        this.mGnssNavigationMessageProvider.addListener(identity, listener);
    }

    public void removeGnssNavigationMessageListener(IGnssNavigationMessageListener listener) {
        this.mGnssNavigationMessageProvider.removeListener(listener);
    }

    public void addGnssAntennaInfoListener(IGnssAntennaInfoListener listener, String packageName, String attributionTag, String listenerId) {
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        this.mGnssAntennaInfoProvider.addListener(identity, listener);
    }

    public void removeGnssAntennaInfoListener(IGnssAntennaInfoListener listener) {
        this.mGnssAntennaInfoProvider.removeListener(listener);
    }

    public void dump(FileDescriptor fd, IndentingPrintWriter ipw, String[] args) {
        if (args.length > 0) goto L5;
    L8:
        ipw.println("Capabilities: " + this.mGnssNative.getCapabilities());
        ipw.println("GNSS Hardware Model Name: " + getGnssHardwareModelName());
        if (this.mGnssStatusProvider.isSupported() == false) goto L12;
        ipw.println("Status Provider:");
        ipw.increaseIndent();
        this.mGnssStatusProvider.dump(fd, ipw, args);
        ipw.decreaseIndent();
    L12:
        if (this.mGnssMeasurementsProvider.isSupported() == false) goto L15;
        ipw.println("Measurements Provider:");
        ipw.increaseIndent();
        this.mGnssMeasurementsProvider.dump(fd, ipw, args);
        ipw.decreaseIndent();
    L15:
        if (this.mGnssNavigationMessageProvider.isSupported() == false) goto L18;
        ipw.println("Navigation Message Provider:");
        ipw.increaseIndent();
        this.mGnssNavigationMessageProvider.dump(fd, ipw, args);
        ipw.decreaseIndent();
    L18:
        if (this.mGnssAntennaInfoProvider.isSupported() == false) goto L20;
        ipw.println("Antenna Info Provider:");
        ipw.increaseIndent();
        ipw.println("Antenna Infos: " + this.mGnssAntennaInfoProvider.getAntennaInfos());
        this.mGnssAntennaInfoProvider.dump(fd, ipw, args);
        ipw.decreaseIndent();
    L20:
        GnssPowerStats powerStats = this.mGnssNative.getLastKnownPowerStats();
        if (powerStats == null) goto L24;
        ipw.println("Last Known Power Stats:");
        ipw.increaseIndent();
        powerStats.dump(fd, ipw, args, this.mGnssNative.getCapabilities());
        ipw.decreaseIndent();
        return;
    L24:
        return;
    L5:
        if (args[0].equals("--gnssmetrics") == false) goto L8;
        ipw.append(this.mGnssMetrics.dumpGnssMetricsAsProtoString());
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.GnssAssistanceCallbacks
    public void onRequestGnssAssistanceInject() {
    }
}
