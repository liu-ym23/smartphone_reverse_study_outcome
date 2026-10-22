package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Method sSetIsFromMockProviderMethod;

    private static class Api17Impl {
        private Api17Impl() {
        }

        static long getElapsedRealtimeNanos(Location r2) {
            return r2.getElapsedRealtimeNanos();
        }
    }

    private static class Api18Impl {
        private Api18Impl() {
        }

        static boolean isMock(Location r0) {
            return r0.isFromMockProvider();
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static boolean hasVerticalAccuracy(Location r0) {
            return r0.hasVerticalAccuracy();
        }

        static float getVerticalAccuracyMeters(Location r0) {
            return r0.getVerticalAccuracyMeters();
        }

        static void setVerticalAccuracyMeters(Location r0, float r1) {
            r0.setVerticalAccuracyMeters(r1);
        }

        static boolean hasSpeedAccuracy(Location r0) {
            return r0.hasSpeedAccuracy();
        }

        static float getSpeedAccuracyMetersPerSecond(Location r0) {
            return r0.getSpeedAccuracyMetersPerSecond();
        }

        static void setSpeedAccuracyMetersPerSecond(Location r0, float r1) {
            r0.setSpeedAccuracyMetersPerSecond(r1);
        }

        static boolean hasBearingAccuracy(Location r0) {
            return r0.hasBearingAccuracy();
        }

        static float getBearingAccuracyDegrees(Location r0) {
            return r0.getBearingAccuracyDegrees();
        }

        static void setBearingAccuracyDegrees(Location r0, float r1) {
            r0.setBearingAccuracyDegrees(r1);
        }
    }

    private LocationCompat() {
    }

    public static long getElapsedRealtimeNanos(Location r2) {
        return Api17Impl.getElapsedRealtimeNanos(r2);
    }

    public static long getElapsedRealtimeMillis(Location r3) {
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(r3));
    }

    public static boolean hasVerticalAccuracy(Location r0) {
        return Api26Impl.hasVerticalAccuracy(r0);
    }

    public static float getVerticalAccuracyMeters(Location r0) {
        return Api26Impl.getVerticalAccuracyMeters(r0);
    }

    public static void setVerticalAccuracyMeters(Location r0, float r1) {
        Api26Impl.setVerticalAccuracyMeters(r0, r1);
    }

    public static boolean hasSpeedAccuracy(Location r0) {
        return Api26Impl.hasSpeedAccuracy(r0);
    }

    public static float getSpeedAccuracyMetersPerSecond(Location r0) {
        return Api26Impl.getSpeedAccuracyMetersPerSecond(r0);
    }

    public static void setSpeedAccuracyMetersPerSecond(Location r0, float r1) {
        Api26Impl.setSpeedAccuracyMetersPerSecond(r0, r1);
    }

    public static boolean hasBearingAccuracy(Location r0) {
        return Api26Impl.hasBearingAccuracy(r0);
    }

    public static float getBearingAccuracyDegrees(Location r0) {
        return Api26Impl.getBearingAccuracyDegrees(r0);
    }

    public static void setBearingAccuracyDegrees(Location r0, float r1) {
        Api26Impl.setBearingAccuracyDegrees(r0, r1);
    }

    public static double getMslAltitudeMeters(Location r2) {
        Preconditions.checkState(hasMslAltitude(r2), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(r2).getDouble(EXTRA_MSL_ALTITUDE);
    }

    public static void setMslAltitudeMeters(Location r1, double r2) {
        getOrCreateExtras(r1).putDouble(EXTRA_MSL_ALTITUDE, r2);
    }

    public static boolean hasMslAltitude(Location r1) {
        return containsExtra(r1, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitude(Location r1) {
        removeExtra(r1, EXTRA_MSL_ALTITUDE);
    }

    public static float getMslAltitudeAccuracyMeters(Location r2) {
        Preconditions.checkState(hasMslAltitudeAccuracy(r2), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(r2).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void setMslAltitudeAccuracyMeters(Location r1, float r2) {
        getOrCreateExtras(r1).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, r2);
    }

    public static boolean hasMslAltitudeAccuracy(Location r1) {
        return containsExtra(r1, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void removeMslAltitudeAccuracy(Location r1) {
        removeExtra(r1, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean isMock(Location r0) {
        return Api18Impl.isMock(r0);
    }

    public static void setMock(Location r3, boolean r4) {
        getSetIsFromMockProviderMethod().invoke(r3, new Object[]{Boolean.valueOf(r4)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L7 NoSuchMethodException -> L10
        return;
    L7:
        e = move-exception;
        IllegalAccessError r5 = new IllegalAccessError();
        r5.initCause(e);
        throw r5;
    L10:
        e = move-exception;
        NoSuchMethodError r6 = new NoSuchMethodError();
        r6.initCause(e);
        throw r6;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod != null) goto L6;
        Method r0 = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
        sSetIsFromMockProviderMethod = r0;
        r0.setAccessible(true);
    L6:
        return sSetIsFromMockProviderMethod;
    }

    private static Bundle getOrCreateExtras(Location r1) {
        Bundle r0 = r1.getExtras();
        if (r0 != null) goto L6;
        r1.setExtras(new Bundle());
        return r1.getExtras();
    L6:
        return r0;
    }

    private static boolean containsExtra(Location r0, String r1) {
        Bundle r2 = r0.getExtras();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.containsKey(r1) == false) goto L7;
        return true;
    }

    private static void removeExtra(Location r1, String r2) {
        Bundle r0 = r1.getExtras();
        if (r0 == null) goto L8;
        r0.remove(r2);
        if (r0.isEmpty() == false) goto L9;
        r1.setExtras(null);
        return;
    L9:
        return;
    }
}
