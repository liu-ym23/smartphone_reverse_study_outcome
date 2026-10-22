package com.android.server.timezonedetector.location;

import com.android.server.timezonedetector.LocationAlgorithmEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class LocationTimeZoneManagerServiceState {
    private final String mControllerState;
    private final List<String> mControllerStates;
    private final LocationAlgorithmEvent mLastEvent;
    private final List<LocationTimeZoneProvider.ProviderState> mPrimaryProviderStates;
    private final List<LocationTimeZoneProvider.ProviderState> mSecondaryProviderStates;

    static final class Builder {
        private String mControllerState;
        private List<String> mControllerStates;
        private LocationAlgorithmEvent mLastEvent;
        private List<LocationTimeZoneProvider.ProviderState> mPrimaryProviderStates;
        private List<LocationTimeZoneProvider.ProviderState> mSecondaryProviderStates;

        /* JADX INFO: renamed from: -$$Nest$fgetmControllerState, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8609$$Nest$fgetmControllerState(Builder r0) {
            return r0.mControllerState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmControllerStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8610$$Nest$fgetmControllerStates(Builder r0) {
            return r0.mControllerStates;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ LocationAlgorithmEvent m8611$$Nest$fgetmLastEvent(Builder r0) {
            return r0.mLastEvent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPrimaryProviderStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8612$$Nest$fgetmPrimaryProviderStates(Builder r0) {
            return r0.mPrimaryProviderStates;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSecondaryProviderStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8613$$Nest$fgetmSecondaryProviderStates(Builder r0) {
            return r0.mSecondaryProviderStates;
        }

        Builder() {
        }

        public Builder setControllerState(String stateEnum) {
            this.mControllerState = stateEnum;
            return this;
        }

        Builder setLastEvent(LocationAlgorithmEvent lastEvent) {
            lastEvent.getClass();
            this.mLastEvent = lastEvent;
            return this;
        }

        public Builder setStateChanges(List<String> states) {
            this.mControllerStates = new ArrayList(states);
            return this;
        }

        Builder setPrimaryProviderStateChanges(List<LocationTimeZoneProvider.ProviderState> primaryProviderStates) {
            this.mPrimaryProviderStates = new ArrayList(primaryProviderStates);
            return this;
        }

        Builder setSecondaryProviderStateChanges(List<LocationTimeZoneProvider.ProviderState> secondaryProviderStates) {
            this.mSecondaryProviderStates = new ArrayList(secondaryProviderStates);
            return this;
        }

        LocationTimeZoneManagerServiceState build() {
            return new LocationTimeZoneManagerServiceState(this);
        }
    }

    LocationTimeZoneManagerServiceState(Builder builder) {
        this.mControllerState = Builder.m8609$$Nest$fgetmControllerState(builder);
        this.mLastEvent = Builder.m8611$$Nest$fgetmLastEvent(builder);
        List<String> r0 = Builder.m8610$$Nest$fgetmControllerStates(builder);
        r0.getClass();
        this.mControllerStates = r0;
        List<LocationTimeZoneProvider.ProviderState> r1 = Builder.m8612$$Nest$fgetmPrimaryProviderStates(builder);
        r1.getClass();
        this.mPrimaryProviderStates = r1;
        List<LocationTimeZoneProvider.ProviderState> r2 = Builder.m8613$$Nest$fgetmSecondaryProviderStates(builder);
        r2.getClass();
        this.mSecondaryProviderStates = r2;
    }

    public String getControllerState() {
        return this.mControllerState;
    }

    public LocationAlgorithmEvent getLastEvent() {
        return this.mLastEvent;
    }

    public List<String> getControllerStates() {
        return this.mControllerStates;
    }

    public List<LocationTimeZoneProvider.ProviderState> getPrimaryProviderStates() {
        return Collections.unmodifiableList(this.mPrimaryProviderStates);
    }

    public List<LocationTimeZoneProvider.ProviderState> getSecondaryProviderStates() {
        return Collections.unmodifiableList(this.mSecondaryProviderStates);
    }

    public String toString() {
        return "LocationTimeZoneManagerServiceState{mControllerState=" + this.mControllerState + ", mLastEvent=" + this.mLastEvent + ", mControllerStates=" + this.mControllerStates + ", mPrimaryProviderStates=" + this.mPrimaryProviderStates + ", mSecondaryProviderStates=" + this.mSecondaryProviderStates + '}';
    }
}
