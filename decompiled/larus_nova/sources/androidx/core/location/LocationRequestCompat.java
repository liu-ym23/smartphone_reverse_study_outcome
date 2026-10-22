package androidx.core.location;

import android.location.LocationRequest;
import android.os.Build;
import androidx.camera.video.AudioStats;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
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

    public static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private Api19Impl() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_core_location_LocationRequestCompat$Api19Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public static Object toLocationRequest(LocationRequestCompat r110, String r111) {
        L31:
            return null;
        L4:
            if (sLocationRequestClass != null) goto L7;
            sLocationRequestClass = INVOKESTATIC_androidx_core_location_LocationRequestCompat$Api19Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.location.LocationRequest");     // Catch: Throwable -> L31
        L7:
            if (sCreateFromDeprecatedProviderMethod != null) goto L9;
            Method r100 = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});     // Catch: Throwable -> L31
            sCreateFromDeprecatedProviderMethod = r100;     // Catch: Throwable -> L31
            r100.setAccessible(true);     // Catch: Throwable -> L31
        L9:
            Object r112 = sCreateFromDeprecatedProviderMethod.invoke(null, new Object[]{r111, Long.valueOf(r110.getIntervalMillis()), Float.valueOf(r110.getMinUpdateDistanceMeters()), Boolean.FALSE});     // Catch: Throwable -> L31
            if (r112 != null) goto L13;
            return null;
        L13:
            if (sSetQualityMethod != null) goto L15;
            Method r101 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});     // Catch: Throwable -> L31
            sSetQualityMethod = r101;     // Catch: Throwable -> L31
            r101.setAccessible(true);     // Catch: Throwable -> L31
        L15:
            sSetQualityMethod.invoke(r112, new Object[]{Integer.valueOf(r110.getQuality())});     // Catch: Throwable -> L31
            if (sSetFastestIntervalMethod != null) goto L18;
            Method r102 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});     // Catch: Throwable -> L31
            sSetFastestIntervalMethod = r102;     // Catch: Throwable -> L31
            r102.setAccessible(true);     // Catch: Throwable -> L31
        L18:
            sSetFastestIntervalMethod.invoke(r112, new Object[]{Long.valueOf(r110.getMinUpdateIntervalMillis())});     // Catch: Throwable -> L31
            if (r110.getMaxUpdates() >= Integer.MAX_VALUE) goto L25;
            if (sSetNumUpdatesMethod != null) goto L23;
            Method r103 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});     // Catch: Throwable -> L31
            sSetNumUpdatesMethod = r103;     // Catch: Throwable -> L31
            r103.setAccessible(true);     // Catch: Throwable -> L31
        L23:
            sSetNumUpdatesMethod.invoke(r112, new Object[]{Integer.valueOf(r110.getMaxUpdates())});     // Catch: Throwable -> L31
        L25:
            if (r110.getDurationMillis() < Long.MAX_VALUE) goto L27;
        L30:
            return r112;
        L27:
            if (sSetExpireInMethod != null) goto L29;
            Method r104 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});     // Catch: Throwable -> L31
            sSetExpireInMethod = r104;     // Catch: Throwable -> L31
            r104.setAccessible(true);     // Catch: Throwable -> L31
        L29:
            sSetExpireInMethod.invoke(r112, new Object[]{Long.valueOf(r110.getDurationMillis())});     // Catch: Throwable -> L31
            goto L30
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static LocationRequest toLocationRequest(LocationRequestCompat r100) {
            return new LocationRequest.Builder(r100.getIntervalMillis()).setQuality(r100.getQuality()).setMinUpdateIntervalMillis(r100.getMinUpdateIntervalMillis()).setDurationMillis(r100.getDurationMillis()).setMaxUpdates(r100.getMaxUpdates()).setMinUpdateDistanceMeters(r100.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(r100.getMaxUpdateDelayMillis()).build();
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

        public LocationRequestCompat build() {
            if (this.mIntervalMillis == Long.MAX_VALUE) goto L5;
        L8:
            boolean r100 = true;
        L9:
            Preconditions.checkState(r100, "passive location requests must have an explicit minimum update interval");
            long r101 = this.mIntervalMillis;
            return new LocationRequestCompat(r101, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, r101), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        L5:
            if (this.mMinUpdateIntervalMillis != (-1)) goto L8;
            r100 = false;
            goto L9
        }

        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        public Builder(long r100) {
            setIntervalMillis(r100);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        public Builder setDurationMillis(long r100) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(r100, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        public Builder setIntervalMillis(long r100) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(r100, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long r100) {
            this.mMaxUpdateDelayMillis = r100;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(r100, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        public Builder setMaxUpdates(int r100) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(r100, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float r100) {
            this.mMinUpdateDistanceMeters = r100;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(r100, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long r100) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(r100, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public Builder setQuality(int r100) {
            if (r100 != 104) goto L5;
        L10:
            boolean r101 = true;
        L11:
            Preconditions.checkArgument(r101, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(r100)});
            this.mQuality = r100;
            return this;
        L5:
            if (r100 == 102) goto L10;
            if (r100 == 100) goto L10;
            r101 = false;
            goto L11
        }

        public Builder(LocationRequestCompat r100) {
            this.mIntervalMillis = r100.mIntervalMillis;
            this.mQuality = r100.mQuality;
            this.mDurationMillis = r100.mDurationMillis;
            this.mMaxUpdates = r100.mMaxUpdates;
            this.mMinUpdateIntervalMillis = r100.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = r100.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = r100.mMaxUpdateDelayMillis;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    public long getMinUpdateIntervalMillis() {
        long r100 = this.mMinUpdateIntervalMillis;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.mIntervalMillis;
    }

    public int hashCode() {
        int r100 = this.mQuality * 31;
        long r101 = this.mIntervalMillis;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.mMinUpdateIntervalMillis;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("Request[");
        if (this.mIntervalMillis == Long.MAX_VALUE) goto L14;
        r100.append("@");
        TimeUtils.formatDuration(this.mIntervalMillis, r100);
        int r101 = this.mQuality;
        if (r101 != 100) goto L7;
        r100.append(" HIGH_ACCURACY");
    L16:
        if (this.mDurationMillis == Long.MAX_VALUE) goto L19;
        r100.append(", duration=");
        TimeUtils.formatDuration(this.mDurationMillis, r100);
    L19:
        if (this.mMaxUpdates == Integer.MAX_VALUE) goto L21;
        r100.append(", maxUpdates=");
        r100.append(this.mMaxUpdates);
    L21:
        long r102 = this.mMinUpdateIntervalMillis;
        if (r102 == (-1)) goto L27;
        if (r102 >= this.mIntervalMillis) goto L27;
        r100.append(", minUpdateInterval=");
        TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, r100);
    L27:
        if (this.mMinUpdateDistanceMeters <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L30;
        r100.append(", minUpdateDistance=");
        r100.append(this.mMinUpdateDistanceMeters);
    L30:
        if ((this.mMaxUpdateDelayMillis / 2) <= this.mIntervalMillis) goto L32;
        r100.append(", maxUpdateDelay=");
        TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, r100);
    L32:
        r100.append(']');
        return r100.toString();
    L7:
        if (r101 != 102) goto L9;
        r100.append(" BALANCED");
        goto L16
    L9:
        if (r101 != 104) goto L16;
        r100.append(" LOW_POWER");
        goto L16
    L14:
        r100.append("PASSIVE");
        goto L16
    }

    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocationRequestCompat) == true) goto L8;
        return false;
    L8:
        LocationRequestCompat r101 = (LocationRequestCompat) r100;
        if (this.mQuality == r101.mQuality) goto L11;
    L23:
        return false;
    L11:
        if (this.mIntervalMillis != r101.mIntervalMillis) goto L23;
        if (this.mMinUpdateIntervalMillis != r101.mMinUpdateIntervalMillis) goto L23;
        if (this.mDurationMillis != r101.mDurationMillis) goto L23;
        if (this.mMaxUpdates != r101.mMaxUpdates) goto L23;
        if (Float.compare(r101.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) != 0) goto L23;
        if (this.mMaxUpdateDelayMillis != r101.mMaxUpdateDelayMillis) goto L23;
        return true;
    }

    public LocationRequest toLocationRequest(String r100) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return toLocationRequest();
    L7:
        return (LocationRequest) Api19Impl.toLocationRequest(this, r100);
    }

    public LocationRequestCompat(long r100, int r101, long r102, int r103, long r104, float r105, long r110) {
        this.mIntervalMillis = r100;
        this.mQuality = r101;
        this.mMinUpdateIntervalMillis = r104;
        this.mDurationMillis = r102;
        this.mMaxUpdates = r103;
        this.mMinUpdateDistanceMeters = r105;
        this.mMaxUpdateDelayMillis = r110;
    }
}
