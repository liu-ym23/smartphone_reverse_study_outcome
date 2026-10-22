package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public abstract class GnssStatusCompat {
    public static final int CONSTELLATION_BEIDOU = 5;
    public static final int CONSTELLATION_GALILEO = 6;
    public static final int CONSTELLATION_GLONASS = 3;
    public static final int CONSTELLATION_GPS = 1;
    public static final int CONSTELLATION_IRNSS = 7;
    public static final int CONSTELLATION_QZSS = 4;
    public static final int CONSTELLATION_SBAS = 2;
    public static final int CONSTELLATION_UNKNOWN = 0;

    public static abstract class Callback {
        public Callback() {
        }

        public void onFirstFix(int r100) {
        }

        public void onSatelliteStatusChanged(GnssStatusCompat r100) {
        }

        public void onStarted() {
        }

        public void onStopped() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConstellationType {
    }

    public GnssStatusCompat() {
    }

    public abstract float getAzimuthDegrees(int r100);

    public abstract float getBasebandCn0DbHz(int r100);

    public abstract float getCarrierFrequencyHz(int r100);

    public abstract float getCn0DbHz(int r100);

    public abstract int getConstellationType(int r100);

    public abstract float getElevationDegrees(int r100);

    public abstract int getSatelliteCount();

    public abstract int getSvid(int r100);

    public abstract boolean hasAlmanacData(int r100);

    public abstract boolean hasBasebandCn0DbHz(int r100);

    public abstract boolean hasCarrierFrequencyHz(int r100);

    public abstract boolean hasEphemerisData(int r100);

    public abstract boolean usedInFix(int r100);

    public static GnssStatusCompat wrap(GnssStatus r100) {
        return new GnssStatusWrapper(r100);
    }

    public static GnssStatusCompat wrap(GpsStatus r100) {
        return new GpsStatusWrapper(r100);
    }
}
