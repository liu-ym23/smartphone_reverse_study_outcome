package com.android.server.timezonedetector;

import android.app.time.TimeZoneCapabilitiesAndConfig;
import android.app.time.TimeZoneConfiguration;
import android.app.timezonedetector.ManualTimeZoneSuggestion;
import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeZoneDetectorInternalImpl implements TimeZoneDetectorInternal {
    private final Context mContext;
    private final CurrentUserIdentityInjector mCurrentUserIdentityInjector;
    private final Handler mHandler;
    private final TimeZoneDetectorStrategy mTimeZoneDetectorStrategy;

    public static /* synthetic */ void $r8$lambda$mBHFmNM5bIrQZMojzV5JXmuVbwQ(TimeZoneDetectorInternalImpl r0, LocationAlgorithmEvent r1) {
        r0.lambda$handleLocationAlgorithmEvent$0(r1);
    }

    public TimeZoneDetectorInternalImpl(Context context, Handler handler, CurrentUserIdentityInjector currentUserIdentityInjector, TimeZoneDetectorStrategy timeZoneDetectorStrategy) {
        context.getClass();
        this.mContext = context;
        handler.getClass();
        this.mHandler = handler;
        currentUserIdentityInjector.getClass();
        this.mCurrentUserIdentityInjector = currentUserIdentityInjector;
        timeZoneDetectorStrategy.getClass();
        this.mTimeZoneDetectorStrategy = timeZoneDetectorStrategy;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorInternal
    public TimeZoneCapabilitiesAndConfig getCapabilitiesAndConfigForDpm() {
        int currentUserId = this.mCurrentUserIdentityInjector.getCurrentUserId();
        return this.mTimeZoneDetectorStrategy.getCapabilitiesAndConfig(currentUserId, true);
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorInternal
    public boolean updateConfigurationForDpm(TimeZoneConfiguration configuration) {
        configuration.getClass();
        int currentUserId = this.mCurrentUserIdentityInjector.getCurrentUserId();
        return this.mTimeZoneDetectorStrategy.updateConfiguration(currentUserId, configuration, true);
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorInternal
    public boolean setManualTimeZoneForDpm(ManualTimeZoneSuggestion suggestion) {
        suggestion.getClass();
        int currentUserId = this.mCurrentUserIdentityInjector.getCurrentUserId();
        return this.mTimeZoneDetectorStrategy.suggestManualTimeZone(currentUserId, suggestion, true);
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorInternal
    public void handleLocationAlgorithmEvent(final LocationAlgorithmEvent locationAlgorithmEvent) {
        locationAlgorithmEvent.getClass();
        this.mHandler.post(new TimeZoneDetectorInternalImpl$$ExternalSyntheticLambda0(this, locationAlgorithmEvent));
    }

    private /* synthetic */ void lambda$handleLocationAlgorithmEvent$0(LocationAlgorithmEvent locationAlgorithmEvent) {
        this.mTimeZoneDetectorStrategy.handleLocationAlgorithmEvent(locationAlgorithmEvent);
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorInternal
    public MetricsTimeZoneDetectorState generateMetricsState() {
        return this.mTimeZoneDetectorStrategy.generateMetricsState();
    }
}
