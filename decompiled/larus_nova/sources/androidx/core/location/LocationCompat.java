package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ReplaceWith;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes17.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float getBearingAccuracyDegrees(Location r100) {
            return r100.getBearingAccuracyDegrees();
        }

        public static float getSpeedAccuracyMetersPerSecond(Location r100) {
            return r100.getSpeedAccuracyMetersPerSecond();
        }

        public static float getVerticalAccuracyMeters(Location r100) {
            return r100.getVerticalAccuracyMeters();
        }

        public static boolean hasBearingAccuracy(Location r100) {
            return r100.hasBearingAccuracy();
        }

        public static boolean hasSpeedAccuracy(Location r100) {
            return r100.hasSpeedAccuracy();
        }

        public static boolean hasVerticalAccuracy(Location r100) {
            return r100.hasVerticalAccuracy();
        }

        public static void removeBearingAccuracy(Location r100) {
            byte r101 = (byte) (LocationCompat.getFieldsMaskField().getByte(r100) & (~LocationCompat.getHasBearingAccuracyMask()));     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            LocationCompat.getFieldsMaskField().setByte(r100, r101);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            return;
        L4:
            e = move-exception;
            IllegalAccessError r102 = new IllegalAccessError();
            r102.initCause(e);
            throw r102;
        L7:
            e = move-exception;
            NoSuchFieldError r103 = new NoSuchFieldError();
            r103.initCause(e);
            throw r103;
        }

        public static void removeSpeedAccuracy(Location r100) {
            byte r101 = (byte) (LocationCompat.getFieldsMaskField().getByte(r100) & (~LocationCompat.getHasSpeedAccuracyMask()));     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            LocationCompat.getFieldsMaskField().setByte(r100, r101);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            return;
        L4:
            e = move-exception;
            IllegalAccessError r102 = new IllegalAccessError();
            r102.initCause(e);
            throw r102;
        L7:
            e = move-exception;
            NoSuchFieldError r103 = new NoSuchFieldError();
            r103.initCause(e);
            throw r103;
        }

        public static void removeVerticalAccuracy(Location r100) {
            byte r101 = (byte) (LocationCompat.getFieldsMaskField().getByte(r100) & (~LocationCompat.getHasVerticalAccuracyMask()));     // Catch: IllegalAccessException -> L4 Throwable -> L6
            LocationCompat.getFieldsMaskField().setByte(r100, r101);     // Catch: IllegalAccessException -> L4 Throwable -> L6
            return;
        L6:
            e = move-exception;
            IllegalAccessError r102 = new IllegalAccessError();
            r102.initCause(e);
            throw r102;
        }

        public static void setBearingAccuracyDegrees(Location r100, float r101) {
            r100.setBearingAccuracyDegrees(r101);
        }

        public static void setSpeedAccuracyMetersPerSecond(Location r100, float r101) {
            r100.setSpeedAccuracyMetersPerSecond(r101);
        }

        public static void setVerticalAccuracyMeters(Location r100, float r101) {
            r100.setVerticalAccuracyMeters(r101);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static void removeBearingAccuracy(Location r210) {
            if (r210.hasBearingAccuracy() == true) goto L5;
            return;
        L5:
            String r100 = r210.getProvider();
            long r101 = r210.getTime();
            long r102 = r210.getElapsedRealtimeNanos();
            double r103 = r210.getLatitude();
            double r104 = r210.getLongitude();
            boolean r110 = r210.hasAltitude();
            double r111 = r210.getAltitude();
            boolean r112 = r210.hasSpeed();
            float r113 = r210.getSpeed();
            boolean r114 = r210.hasBearing();
            float r115 = r210.getBearing();
            boolean r116 = r210.hasAccuracy();
            float r117 = r210.getAccuracy();
            boolean r118 = r210.hasVerticalAccuracy();
            float r119 = r210.getVerticalAccuracyMeters();
            boolean r211 = r210.hasSpeedAccuracy();
            float r120 = r210.getSpeedAccuracyMetersPerSecond();
            Bundle r121 = r210.getExtras();
            r210.reset();
            r210.setProvider(r100);
            r210.setTime(r101);
            r210.setElapsedRealtimeNanos(r102);
            r210.setLatitude(r103);
            r210.setLongitude(r104);
            if (r110 == false) goto L8;
            r210.setAltitude(r111);
        L8:
            if (r112 == false) goto L10;
            r210.setSpeed(r113);
        L10:
            if (r114 == false) goto L12;
            r210.setBearing(r115);
        L12:
            if (r116 == false) goto L14;
            r210.setAccuracy(r117);
        L14:
            if (r118 == false) goto L16;
            r210.setVerticalAccuracyMeters(r119);
        L16:
            if (r211 == false) goto L18;
            r210.setBearingAccuracyDegrees(r120);
        L18:
            if (r121 == null) goto L21;
            r210.setExtras(r121);
            return;
        }

        public static void removeSpeedAccuracy(Location r210) {
            if (r210.hasSpeedAccuracy() == true) goto L5;
            return;
        L5:
            String r100 = r210.getProvider();
            long r101 = r210.getTime();
            long r102 = r210.getElapsedRealtimeNanos();
            double r103 = r210.getLatitude();
            double r104 = r210.getLongitude();
            boolean r110 = r210.hasAltitude();
            double r111 = r210.getAltitude();
            boolean r112 = r210.hasSpeed();
            float r113 = r210.getSpeed();
            boolean r114 = r210.hasBearing();
            float r115 = r210.getBearing();
            boolean r116 = r210.hasAccuracy();
            float r117 = r210.getAccuracy();
            boolean r118 = r210.hasVerticalAccuracy();
            float r119 = r210.getVerticalAccuracyMeters();
            boolean r211 = r210.hasBearingAccuracy();
            float r120 = r210.getBearingAccuracyDegrees();
            Bundle r121 = r210.getExtras();
            r210.reset();
            r210.setProvider(r100);
            r210.setTime(r101);
            r210.setElapsedRealtimeNanos(r102);
            r210.setLatitude(r103);
            r210.setLongitude(r104);
            if (r110 == false) goto L8;
            r210.setAltitude(r111);
        L8:
            if (r112 == false) goto L10;
            r210.setSpeed(r113);
        L10:
            if (r114 == false) goto L12;
            r210.setBearing(r115);
        L12:
            if (r116 == false) goto L14;
            r210.setAccuracy(r117);
        L14:
            if (r118 == false) goto L16;
            r210.setVerticalAccuracyMeters(r119);
        L16:
            if (r211 == false) goto L18;
            r210.setBearingAccuracyDegrees(r120);
        L18:
            if (r121 == null) goto L21;
            r210.setExtras(r121);
            return;
        }

        public static void removeVerticalAccuracy(Location r210) {
            if (r210.hasVerticalAccuracy() == true) goto L5;
            return;
        L5:
            String r100 = r210.getProvider();
            long r101 = r210.getTime();
            long r102 = r210.getElapsedRealtimeNanos();
            double r103 = r210.getLatitude();
            double r104 = r210.getLongitude();
            boolean r110 = r210.hasAltitude();
            double r111 = r210.getAltitude();
            boolean r112 = r210.hasSpeed();
            float r113 = r210.getSpeed();
            boolean r114 = r210.hasBearing();
            float r115 = r210.getBearing();
            boolean r116 = r210.hasAccuracy();
            float r117 = r210.getAccuracy();
            boolean r118 = r210.hasSpeedAccuracy();
            float r119 = r210.getSpeedAccuracyMetersPerSecond();
            boolean r211 = r210.hasBearingAccuracy();
            float r120 = r210.getBearingAccuracyDegrees();
            Bundle r121 = r210.getExtras();
            r210.reset();
            r210.setProvider(r100);
            r210.setTime(r101);
            r210.setElapsedRealtimeNanos(r102);
            r210.setLatitude(r103);
            r210.setLongitude(r104);
            if (r110 == false) goto L8;
            r210.setAltitude(r111);
        L8:
            if (r112 == false) goto L10;
            r210.setSpeed(r113);
        L10:
            if (r114 == false) goto L12;
            r210.setBearing(r115);
        L12:
            if (r116 == false) goto L14;
            r210.setAccuracy(r117);
        L14:
            if (r118 == false) goto L16;
            r210.setSpeedAccuracyMetersPerSecond(r119);
        L16:
            if (r211 == false) goto L18;
            r210.setBearingAccuracyDegrees(r120);
        L18:
            if (r121 == null) goto L21;
            r210.setExtras(r121);
            return;
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void removeBearingAccuracy(Location r100) {
            if (r100.hasBearingAccuracy() == true) goto L5;
            return;
        L5:
            double r101 = r100.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeBearingAccuracy(r100);
            r100.setElapsedRealtimeUncertaintyNanos(r101);
        }

        public static void removeSpeedAccuracy(Location r100) {
            if (r100.hasSpeedAccuracy() == true) goto L5;
            return;
        L5:
            double r101 = r100.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeSpeedAccuracy(r100);
            r100.setElapsedRealtimeUncertaintyNanos(r101);
        }

        public static void removeVerticalAccuracy(Location r100) {
            if (r100.hasVerticalAccuracy() == true) goto L5;
            return;
        L5:
            double r101 = r100.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeVerticalAccuracy(r100);
            r100.setElapsedRealtimeUncertaintyNanos(r101);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static boolean isMock(Location r100) {
            return r100.isMock();
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static void removeBearingAccuracy(Location r100) {
            r100.removeBearingAccuracy();
        }

        public static void removeSpeedAccuracy(Location r100) {
            r100.removeSpeedAccuracy();
        }

        public static void removeVerticalAccuracy(Location r100) {
            r100.removeVerticalAccuracy();
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static float getMslAltitudeAccuracyMeters(Location r100) {
            return r100.getMslAltitudeAccuracyMeters();
        }

        public static double getMslAltitudeMeters(Location r100) {
            return r100.getMslAltitudeMeters();
        }

        public static boolean hasMslAltitude(Location r100) {
            return r100.hasMslAltitude();
        }

        public static boolean hasMslAltitudeAccuracy(Location r100) {
            return r100.hasMslAltitudeAccuracy();
        }

        public static void removeMslAltitude(Location r100) {
            r100.removeMslAltitude();
        }

        public static void removeMslAltitudeAccuracy(Location r100) {
            r100.removeMslAltitudeAccuracy();
        }

        public static void setMslAltitudeAccuracyMeters(Location r100, float r101) {
            r100.setMslAltitudeAccuracyMeters(r101);
        }

        public static void setMslAltitudeMeters(Location r100, double r101) {
            r100.setMslAltitudeMeters(r101);
        }
    }

    public static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField != null) goto L6;
        Field r100 = Location.class.getDeclaredField("mFieldsMask");
        sFieldsMaskField = r100;
        r100.setAccessible(true);
    L6:
        return sFieldsMaskField;
    }

    public static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask != null) goto L6;
        Field r100 = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
        r100.setAccessible(true);
        sHasBearingAccuracyMask = Integer.valueOf(r100.getInt(null));
    L6:
        return sHasBearingAccuracyMask.intValue();
    }

    public static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask != null) goto L6;
        Field r100 = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
        r100.setAccessible(true);
        sHasSpeedAccuracyMask = Integer.valueOf(r100.getInt(null));
    L6:
        return sHasSpeedAccuracyMask.intValue();
    }

    public static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask != null) goto L6;
        Field r100 = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
        r100.setAccessible(true);
        sHasVerticalAccuracyMask = Integer.valueOf(r100.getInt(null));
    L6:
        return sHasVerticalAccuracyMask.intValue();
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod != null) goto L6;
        Method r100 = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
        sSetIsFromMockProviderMethod = r100;
        r100.setAccessible(true);
    L6:
        return sSetIsFromMockProviderMethod;
    }

    private LocationCompat() {
    }

    public static float getBearingAccuracyDegrees(Location r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L10;
        return 0.0f;
    L10:
        return r101.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getBearingAccuracyDegrees(r100);
    }

    public static long getElapsedRealtimeMillis(Location r100) {
        return TimeUnit.NANOSECONDS.toMillis(r100.getElapsedRealtimeNanos());
    }

    @ReplaceWith(expression = "location.getElapsedRealtimeNanos()")
    public static long getElapsedRealtimeNanos(Location r100) {
        return r100.getElapsedRealtimeNanos();
    }

    public static float getMslAltitudeAccuracyMeters(Location r100) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMslAltitudeAccuracyMeters(r100);
    L7:
        return getOrCreateExtras(r100).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(Location r100) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMslAltitudeMeters(r100);
    L7:
        return getOrCreateExtras(r100).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(Location r100) {
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L6;
        r100.setExtras(new Bundle());
        return r100.getExtras();
    L6:
        return r101;
    }

    public static float getSpeedAccuracyMetersPerSecond(Location r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L10;
        return 0.0f;
    L10:
        return r101.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getSpeedAccuracyMetersPerSecond(r100);
    }

    public static float getVerticalAccuracyMeters(Location r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L10;
        return 0.0f;
    L10:
        return r101.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getVerticalAccuracyMeters(r100);
    }

    public static boolean hasBearingAccuracy(Location r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasBearingAccuracy(r100);
    L7:
        return containsExtra(r100, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(Location r100) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasMslAltitude(r100);
    L7:
        return containsExtra(r100, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(Location r100) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasMslAltitudeAccuracy(r100);
    L7:
        return containsExtra(r100, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(Location r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasSpeedAccuracy(r100);
    L7:
        return containsExtra(r100, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(Location r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasVerticalAccuracy(r100);
    L7:
        return containsExtra(r100, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(Location r100) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.isMock(r100);
    L7:
        return r100.isFromMockProvider();
    }

    public static void removeBearingAccuracy(Location r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 33) goto L6;
        Api33Impl.removeBearingAccuracy(r100);
        return;
    L6:
        if (r101 < 29) goto L9;
        Api29Impl.removeBearingAccuracy(r100);
        return;
    L9:
        if (r101 < 28) goto L12;
        Api28Impl.removeBearingAccuracy(r100);
        return;
    L12:
        if (r101 < 26) goto L14;
        Api26Impl.removeBearingAccuracy(r100);
        return;
    L14:
        removeExtra(r100, EXTRA_BEARING_ACCURACY);
    }

    public static void removeMslAltitude(Location r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.removeMslAltitude(r100);
        return;
    L5:
        removeExtra(r100, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitudeAccuracy(Location r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.removeMslAltitudeAccuracy(r100);
        return;
    L5:
        removeExtra(r100, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void removeSpeedAccuracy(Location r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 33) goto L6;
        Api33Impl.removeSpeedAccuracy(r100);
        return;
    L6:
        if (r101 < 29) goto L9;
        Api29Impl.removeSpeedAccuracy(r100);
        return;
    L9:
        if (r101 < 28) goto L12;
        Api28Impl.removeSpeedAccuracy(r100);
        return;
    L12:
        if (r101 < 26) goto L14;
        Api26Impl.removeSpeedAccuracy(r100);
        return;
    L14:
        removeExtra(r100, EXTRA_SPEED_ACCURACY);
    }

    public static void removeVerticalAccuracy(Location r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 33) goto L6;
        Api33Impl.removeVerticalAccuracy(r100);
        return;
    L6:
        if (r101 < 29) goto L9;
        Api29Impl.removeVerticalAccuracy(r100);
        return;
    L9:
        if (r101 < 28) goto L12;
        Api28Impl.removeVerticalAccuracy(r100);
        return;
    L12:
        if (r101 < 26) goto L14;
        Api26Impl.removeVerticalAccuracy(r100);
        return;
    L14:
        removeExtra(r100, EXTRA_VERTICAL_ACCURACY);
    }

    private static boolean containsExtra(Location r100, String r101) {
        Bundle r102 = r100.getExtras();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.containsKey(r101) == false) goto L7;
        return true;
    }

    private static void removeExtra(Location r100, String r101) {
        Bundle r102 = r100.getExtras();
        if (r102 == null) goto L8;
        r102.remove(r101);
        if (r102.isEmpty() == false) goto L9;
        r100.setExtras(null);
        return;
    L9:
        return;
    }

    public static void setBearingAccuracyDegrees(Location r100, float r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setBearingAccuracyDegrees(r100, r101);
        return;
    L5:
        getOrCreateExtras(r100).putFloat(EXTRA_BEARING_ACCURACY, r101);
    }

    public static void setMock(Location r100, boolean r101) {
        getSetIsFromMockProviderMethod().invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L7 NoSuchMethodException -> L10
        return;
    L7:
        e = move-exception;
        IllegalAccessError r102 = new IllegalAccessError();
        r102.initCause(e);
        throw r102;
    L10:
        e = move-exception;
        NoSuchMethodError r103 = new NoSuchMethodError();
        r103.initCause(e);
        throw r103;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setMslAltitudeAccuracyMeters(Location r100, float r101) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMslAltitudeAccuracyMeters(r100, r101);
        return;
    L5:
        getOrCreateExtras(r100).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, r101);
    }

    public static void setMslAltitudeMeters(Location r100, double r101) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMslAltitudeMeters(r100, r101);
        return;
    L5:
        getOrCreateExtras(r100).putDouble(EXTRA_MSL_ALTITUDE, r101);
    }

    public static void setSpeedAccuracyMetersPerSecond(Location r100, float r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setSpeedAccuracyMetersPerSecond(r100, r101);
        return;
    L5:
        getOrCreateExtras(r100).putFloat(EXTRA_SPEED_ACCURACY, r101);
    }

    public static void setVerticalAccuracyMeters(Location r100, float r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setVerticalAccuracyMeters(r100, r101);
        return;
    L5:
        getOrCreateExtras(r100).putFloat(EXTRA_VERTICAL_ACCURACY, r101);
    }
}
