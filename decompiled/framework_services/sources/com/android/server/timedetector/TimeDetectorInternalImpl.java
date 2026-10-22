package com.android.server.timedetector;

import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.app.timedetector.ManualTimeSuggestion;
import android.content.Context;
import android.os.Handler;
import com.android.server.timezonedetector.CurrentUserIdentityInjector;
import com.android.server.timezonedetector.StateChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public class TimeDetectorInternalImpl implements TimeDetectorInternal {
    private final Context mContext;
    private final CurrentUserIdentityInjector mCurrentUserIdentityInjector;
    private final Handler mHandler;
    private final ServiceConfigAccessor mServiceConfigAccessor;
    private final TimeDetectorStrategy mTimeDetectorStrategy;

    /* JADX INFO: renamed from: $r8$lambda$bnCKR-V5eNm4k8BLYvsu1i339go, reason: not valid java name */
    public static /* synthetic */ void m8557$r8$lambda$bnCKRV5eNm4k8BLYvsu1i339go(TimeDetectorInternalImpl r0, NetworkTimeSuggestion r1) {
        r0.lambda$suggestNetworkTime$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dCFx5COe-jm1Viw3JWZNtmNXMFA, reason: not valid java name */
    public static /* synthetic */ void m8558$r8$lambda$dCFx5COejm1Viw3JWZNtmNXMFA(TimeDetectorInternalImpl r0, GnssTimeSuggestion r1) {
        r0.lambda$suggestGnssTime$1(r1);
    }

    public TimeDetectorInternalImpl(Context context, Handler handler, CurrentUserIdentityInjector currentUserIdentityInjector, ServiceConfigAccessor serviceConfigAccessor, TimeDetectorStrategy timeDetectorStrategy) {
        context.getClass();
        this.mContext = context;
        handler.getClass();
        this.mHandler = handler;
        currentUserIdentityInjector.getClass();
        this.mCurrentUserIdentityInjector = currentUserIdentityInjector;
        serviceConfigAccessor.getClass();
        this.mServiceConfigAccessor = serviceConfigAccessor;
        timeDetectorStrategy.getClass();
        this.mTimeDetectorStrategy = timeDetectorStrategy;
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public TimeCapabilitiesAndConfig getCapabilitiesAndConfigForDpm() {
        int currentUserId = this.mCurrentUserIdentityInjector.getCurrentUserId();
        ConfigurationInternal configurationInternal = this.mServiceConfigAccessor.getConfigurationInternal(currentUserId);
        return configurationInternal.createCapabilitiesAndConfig(true);
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public boolean updateConfigurationForDpm(TimeConfiguration configuration) {
        configuration.getClass();
        int currentUserId = this.mCurrentUserIdentityInjector.getCurrentUserId();
        return this.mServiceConfigAccessor.updateConfiguration(currentUserId, configuration, true);
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public boolean setManualTimeForDpm(ManualTimeSuggestion suggestion) {
        suggestion.getClass();
        int userId = this.mCurrentUserIdentityInjector.getCurrentUserId();
        return this.mTimeDetectorStrategy.suggestManualTime(userId, suggestion, false);
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public void suggestNetworkTime(final NetworkTimeSuggestion suggestion) {
        suggestion.getClass();
        this.mHandler.post(new TimeDetectorInternalImpl$$ExternalSyntheticLambda1(this, suggestion));
    }

    private /* synthetic */ void lambda$suggestNetworkTime$0(NetworkTimeSuggestion suggestion) {
        this.mTimeDetectorStrategy.suggestNetworkTime(suggestion);
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public void addNetworkTimeUpdateListener(StateChangeListener networkTimeUpdateListener) {
        networkTimeUpdateListener.getClass();
        this.mTimeDetectorStrategy.addNetworkTimeUpdateListener(networkTimeUpdateListener);
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public NetworkTimeSuggestion getLatestNetworkSuggestion() {
        return this.mTimeDetectorStrategy.getLatestNetworkSuggestion();
    }

    @Override // com.android.server.timedetector.TimeDetectorInternal
    public void suggestGnssTime(final GnssTimeSuggestion suggestion) {
        suggestion.getClass();
        this.mHandler.post(new TimeDetectorInternalImpl$$ExternalSyntheticLambda0(this, suggestion));
    }

    private /* synthetic */ void lambda$suggestGnssTime$1(GnssTimeSuggestion suggestion) {
        this.mTimeDetectorStrategy.suggestGnssTime(suggestion);
    }
}
