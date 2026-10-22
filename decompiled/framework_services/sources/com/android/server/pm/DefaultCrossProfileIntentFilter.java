package com.android.server.pm;

import android.content.IntentFilter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultCrossProfileIntentFilter {
    public final int direction;
    public final WatchedIntentFilter filter;
    public final int flags;
    public final boolean letsPersonalDataIntoProfile;

    static final class Builder {
        private final int mDirection;
        private final WatchedIntentFilter mFilter;
        private final int mFlags;
        private final boolean mLetsPersonalDataIntoProfile;

        Builder(int direction, int flags, boolean letsPersonalDataIntoProfile) {
            this.mFilter = new WatchedIntentFilter();
            this.mDirection = direction;
            this.mFlags = flags;
            this.mLetsPersonalDataIntoProfile = letsPersonalDataIntoProfile;
        }

        Builder addAction(String action) {
            this.mFilter.addAction(action);
            return this;
        }

        Builder addCategory(String category) {
            this.mFilter.addCategory(category);
            return this;
        }

        Builder addDataType(String type) {
            this.mFilter.addDataType(type);     // Catch: IntentFilter.MalformedMimeTypeException -> L4
        L5:
            return this;
        }

        Builder addDataScheme(String scheme) {
            this.mFilter.addDataScheme(scheme);
            return this;
        }

        DefaultCrossProfileIntentFilter build() {
            return new DefaultCrossProfileIntentFilter(this.mFilter, this.mFlags, this.mDirection, this.mLetsPersonalDataIntoProfile, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int TO_PARENT = 0;
        public static final int TO_PROFILE = 1;
    }

    /* synthetic */ DefaultCrossProfileIntentFilter(WatchedIntentFilter r1, int r2, int r3, boolean r4, DefaultCrossProfileIntentFilterIA r5) {
        this(r1, r2, r3, r4);
    }

    private DefaultCrossProfileIntentFilter(WatchedIntentFilter filter, int flags, int direction, boolean letsPersonalDataIntoProfile) {
        filter.getClass();
        this.filter = filter;
        this.flags = flags;
        this.direction = direction;
        this.letsPersonalDataIntoProfile = letsPersonalDataIntoProfile;
    }
}
