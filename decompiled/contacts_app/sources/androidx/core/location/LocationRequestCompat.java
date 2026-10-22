package androidx.core.location;

import android.location.LocationRequest;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import com.android.contacts.common.list.DefaultContactListAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequestCompat {
    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    private static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
        }

        public static Object toLocationRequest(LocationRequestCompat r10, String r11) {
        L31:
            return null;
        L4:
            if (sLocationRequestClass != null) goto L7;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L31
        L7:
            if (sCreateFromDeprecatedProviderMethod != null) goto L9;
            Method r1 = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});     // Catch: Throwable -> L31
            sCreateFromDeprecatedProviderMethod = r1;     // Catch: Throwable -> L31
            r1.setAccessible(true);     // Catch: Throwable -> L31
        L9:
            Object r12 = sCreateFromDeprecatedProviderMethod.invoke(null, new Object[]{r11, Long.valueOf(r10.getIntervalMillis()), Float.valueOf(r10.getMinUpdateDistanceMeters()), false});     // Catch: Throwable -> L31
            if (r12 != null) goto L13;
            return null;
        L13:
            if (sSetQualityMethod != null) goto L15;
            Method r2 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});     // Catch: Throwable -> L31
            sSetQualityMethod = r2;     // Catch: Throwable -> L31
            r2.setAccessible(true);     // Catch: Throwable -> L31
        L15:
            sSetQualityMethod.invoke(r12, new Object[]{Integer.valueOf(r10.getQuality())});     // Catch: Throwable -> L31
            if (sSetFastestIntervalMethod != null) goto L18;
            Method r3 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});     // Catch: Throwable -> L31
            sSetFastestIntervalMethod = r3;     // Catch: Throwable -> L31
            r3.setAccessible(true);     // Catch: Throwable -> L31
        L18:
            sSetFastestIntervalMethod.invoke(r12, new Object[]{Long.valueOf(r10.getMinUpdateIntervalMillis())});     // Catch: Throwable -> L31
            if (r10.getMaxUpdates() >= Integer.MAX_VALUE) goto L25;
            if (sSetNumUpdatesMethod != null) goto L23;
            Method r4 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});     // Catch: Throwable -> L31
            sSetNumUpdatesMethod = r4;     // Catch: Throwable -> L31
            r4.setAccessible(true);     // Catch: Throwable -> L31
        L23:
            sSetNumUpdatesMethod.invoke(r12, new Object[]{Integer.valueOf(r10.getMaxUpdates())});     // Catch: Throwable -> L31
        L25:
            if (r10.getDurationMillis() < Long.MAX_VALUE) goto L27;
        L30:
            return r12;
        L27:
            if (sSetExpireInMethod != null) goto L29;
            Method r5 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});     // Catch: Throwable -> L31
            sSetExpireInMethod = r5;     // Catch: Throwable -> L31
            r5.setAccessible(true);     // Catch: Throwable -> L31
        L29:
            sSetExpireInMethod.invoke(r12, new Object[]{Long.valueOf(r10.getDurationMillis())});     // Catch: Throwable -> L31
            goto L30
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static LocationRequest toLocationRequest(LocationRequestCompat r3) {
            return new LocationRequest.Builder(r3.getIntervalMillis()).setQuality(r3.getQuality()).setMinUpdateIntervalMillis(r3.getMinUpdateIntervalMillis()).setDurationMillis(r3.getDurationMillis()).setMaxUpdates(r3.getMaxUpdates()).setMinUpdateDistanceMeters(r3.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(r3.getMaxUpdateDelayMillis()).build();
        }
    }

    public static final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long r1) {
            setIntervalMillis(r1);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        public Builder(LocationRequestCompat r3) {
            this.mIntervalMillis = r3.mIntervalMillis;
            this.mQuality = r3.mQuality;
            this.mDurationMillis = r3.mDurationMillis;
            this.mMaxUpdates = r3.mMaxUpdates;
            this.mMinUpdateIntervalMillis = r3.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = r3.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = r3.mMaxUpdateDelayMillis;
        }

        public Builder setIntervalMillis(long r8) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(r8, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public Builder setQuality(int r5) {
            if (r5 != 104) goto L5;
        L10:
            boolean r0 = true;
        L11:
            Preconditions.checkArgument(r0, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(r5)});
            this.mQuality = r5;
            return this;
        L5:
            if (r5 == 102) goto L10;
            if (r5 == 100) goto L10;
            r0 = false;
            goto L11
        }

        public Builder setDurationMillis(long r8) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(r8, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        public Builder setMaxUpdates(int r4) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(r4, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long r8) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(r8, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float r4) {
            this.mMinUpdateDistanceMeters = r4;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(r4, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long r8) {
            this.mMaxUpdateDelayMillis = r8;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(r8, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        public LocationRequestCompat build() {
            if (this.mIntervalMillis == Long.MAX_VALUE) goto L5;
        L8:
            boolean r0 = true;
        L9:
            Preconditions.checkState(r0, "passive location requests must have an explicit minimum update interval");
            long r3 = this.mIntervalMillis;
            return new LocationRequestCompat(r3, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, r3), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        L5:
            if (this.mMinUpdateIntervalMillis != (-1)) goto L8;
            r0 = false;
            goto L9
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    LocationRequestCompat(long r1, int r3, long r4, int r6, long r7, float r9, long r10) {
        this.mIntervalMillis = r1;
        this.mQuality = r3;
        this.mMinUpdateIntervalMillis = r7;
        this.mDurationMillis = r4;
        this.mMaxUpdates = r6;
        this.mMinUpdateDistanceMeters = r9;
        this.mMaxUpdateDelayMillis = r10;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    public long getMinUpdateIntervalMillis() {
        long r0 = this.mMinUpdateIntervalMillis;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return this.mIntervalMillis;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    public LocationRequest toLocationRequest(String r1) {
        return toLocationRequest();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LocationRequestCompat) == true) goto L8;
        return false;
    L8:
        LocationRequestCompat r9 = (LocationRequestCompat) r8;
        if (this.mQuality != r9.mQuality) goto L24;
        if (this.mIntervalMillis != r9.mIntervalMillis) goto L24;
        if (this.mMinUpdateIntervalMillis != r9.mMinUpdateIntervalMillis) goto L24;
        if (this.mDurationMillis != r9.mDurationMillis) goto L24;
        if (this.mMaxUpdates != r9.mMaxUpdates) goto L24;
        if (Float.compare(r9.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) != 0) goto L24;
        if (this.mMaxUpdateDelayMillis != r9.mMaxUpdateDelayMillis) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.mQuality * 31;
        long r1 = this.mIntervalMillis;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.mMinUpdateIntervalMillis;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Request[");
        if (this.mIntervalMillis == Long.MAX_VALUE) goto L14;
        r0.append("@");
        TimeUtils.formatDuration(this.mIntervalMillis, r0);
        int r1 = this.mQuality;
        if (r1 != 100) goto L7;
        r0.append(" HIGH_ACCURACY");
    L16:
        if (this.mDurationMillis == Long.MAX_VALUE) goto L19;
        r0.append(", duration=");
        TimeUtils.formatDuration(this.mDurationMillis, r0);
    L19:
        if (this.mMaxUpdates == Integer.MAX_VALUE) goto L21;
        r0.append(", maxUpdates=").append(this.mMaxUpdates);
    L21:
        long r2 = this.mMinUpdateIntervalMillis;
        if (r2 == (-1)) goto L27;
        if (r2 >= this.mIntervalMillis) goto L27;
        r0.append(", minUpdateInterval=");
        TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, r0);
    L27:
        if (this.mMinUpdateDistanceMeters <= 0.0d) goto L30;
        r0.append(", minUpdateDistance=").append(this.mMinUpdateDistanceMeters);
    L30:
        if ((this.mMaxUpdateDelayMillis / 2) <= this.mIntervalMillis) goto L32;
        r0.append(", maxUpdateDelay=");
        TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, r0);
    L32:
        r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH);
        return r0.toString();
    L7:
        if (r1 != 102) goto L9;
        r0.append(" BALANCED");
        goto L16
    L9:
        if (r1 != 104) goto L16;
        r0.append(" LOW_POWER");
        goto L16
    L14:
        r0.append("PASSIVE");
        goto L16
    }
}
