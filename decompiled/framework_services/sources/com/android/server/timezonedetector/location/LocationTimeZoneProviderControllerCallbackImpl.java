package com.android.server.timezonedetector.location;

import com.android.server.LocalServices;
import com.android.server.timezonedetector.LocationAlgorithmEvent;
import com.android.server.timezonedetector.TimeZoneDetectorInternal;

/* JADX INFO: loaded from: classes3.dex */
class LocationTimeZoneProviderControllerCallbackImpl extends LocationTimeZoneProviderController.Callback {
    LocationTimeZoneProviderControllerCallbackImpl(ThreadingDomain threadingDomain) {
        super(threadingDomain);
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.Callback
    void sendEvent(LocationAlgorithmEvent event) {
        this.mThreadingDomain.assertCurrentThread();
        TimeZoneDetectorInternal timeZoneDetector = (TimeZoneDetectorInternal) LocalServices.getService(TimeZoneDetectorInternal.class);
        timeZoneDetector.handleLocationAlgorithmEvent(event);
    }
}
