package com.android.server.timezonedetector.location;

import android.os.SystemClock;
import com.android.server.timezonedetector.ConfigurationInternal;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.timezonedetector.StateChangeListener;
import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
class LocationTimeZoneProviderControllerEnvironmentImpl extends LocationTimeZoneProviderController.Environment {
    private final StateChangeListener mConfigurationInternalChangeListener;
    private final ServiceConfigAccessor mServiceConfigAccessor;

    /* JADX INFO: renamed from: $r8$lambda$7A0T2SYrfZ-50JtnkrKtzz_qer0, reason: not valid java name */
    public static /* synthetic */ void m8616$r8$lambda$7A0T2SYrfZ50JtnkrKtzz_qer0(LocationTimeZoneProviderControllerEnvironmentImpl r0, LocationTimeZoneProviderController r1) {
        r0.lambda$new$0(r1);
    }

    LocationTimeZoneProviderControllerEnvironmentImpl(ThreadingDomain threadingDomain, ServiceConfigAccessor serviceConfigAccessor, final LocationTimeZoneProviderController controller) {
        super(threadingDomain);
        serviceConfigAccessor.getClass();
        this.mServiceConfigAccessor = serviceConfigAccessor;
        this.mConfigurationInternalChangeListener = new LocationTimeZoneProviderControllerEnvironmentImpl$$ExternalSyntheticLambda1(this, controller);
        this.mServiceConfigAccessor.addConfigurationInternalChangeListener(this.mConfigurationInternalChangeListener);
    }

    private /* synthetic */ void lambda$new$0(final LocationTimeZoneProviderController controller) {
        ThreadingDomain r0 = this.mThreadingDomain;
        controller.getClass();
        r0.post(new LocationTimeZoneProviderControllerEnvironmentImpl$$ExternalSyntheticLambda0(controller));
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    void destroy() {
        this.mServiceConfigAccessor.removeConfigurationInternalChangeListener(this.mConfigurationInternalChangeListener);
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    ConfigurationInternal getCurrentUserConfigurationInternal() {
        return this.mServiceConfigAccessor.getCurrentUserConfigurationInternal();
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    Duration getProviderInitializationTimeout() {
        return this.mServiceConfigAccessor.getLocationTimeZoneProviderInitializationTimeout();
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    Duration getProviderInitializationTimeoutFuzz() {
        return this.mServiceConfigAccessor.getLocationTimeZoneProviderInitializationTimeoutFuzz();
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    Duration getUncertaintyDelay() {
        return this.mServiceConfigAccessor.getLocationTimeZoneUncertaintyDelay();
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    Duration getProviderEventFilteringAgeThreshold() {
        return this.mServiceConfigAccessor.getLocationTimeZoneProviderEventFilteringAgeThreshold();
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Environment
    long elapsedRealtimeMillis() {
        return SystemClock.elapsedRealtime();
    }
}
