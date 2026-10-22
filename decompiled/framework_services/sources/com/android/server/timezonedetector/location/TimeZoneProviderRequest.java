package com.android.server.timezonedetector.location;

import java.time.Duration;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class TimeZoneProviderRequest {
    private static final TimeZoneProviderRequest STOP_UPDATES = null;
    private final Duration mEventFilteringAgeThreshold;
    private final Duration mInitializationTimeout;
    private final boolean mSendUpdates;

    static {
        STOP_UPDATES = new TimeZoneProviderRequest(false, null, null);
    }

    private TimeZoneProviderRequest(boolean sendUpdates, Duration initializationTimeout, Duration eventFilteringAgeThreshold) {
        this.mSendUpdates = sendUpdates;
        this.mInitializationTimeout = initializationTimeout;
        this.mEventFilteringAgeThreshold = eventFilteringAgeThreshold;
    }

    public static TimeZoneProviderRequest createStartUpdatesRequest(Duration initializationTimeout, Duration eventFilteringAgeThreshold) {
        initializationTimeout.getClass();
        eventFilteringAgeThreshold.getClass();
        return new TimeZoneProviderRequest(true, initializationTimeout, eventFilteringAgeThreshold);
    }

    public static TimeZoneProviderRequest createStopUpdatesRequest() {
        return STOP_UPDATES;
    }

    public boolean sendUpdates() {
        return this.mSendUpdates;
    }

    public Duration getInitializationTimeout() {
        return this.mInitializationTimeout;
    }

    public Duration getEventFilteringAgeThreshold() {
        return this.mEventFilteringAgeThreshold;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L19;
        TimeZoneProviderRequest that = (TimeZoneProviderRequest) o;
        if (this.mSendUpdates != that.mSendUpdates) goto L18;
        if (Objects.equals(this.mInitializationTimeout, that.mInitializationTimeout) == false) goto L18;
        if (Objects.equals(this.mEventFilteringAgeThreshold, that.mEventFilteringAgeThreshold) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mSendUpdates), this.mInitializationTimeout, this.mEventFilteringAgeThreshold});
    }

    public String toString() {
        return "TimeZoneProviderRequest{mSendUpdates=" + this.mSendUpdates + ", mInitializationTimeout=" + this.mInitializationTimeout + ", mEventFilteringAgeThreshold=" + this.mEventFilteringAgeThreshold + "}";
    }
}
