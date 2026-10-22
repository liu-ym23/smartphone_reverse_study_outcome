package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.GpsStatus;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public abstract class GnssStatusCompat {

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_BEIDOU = 5;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_GALILEO = 6;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_GLONASS = 3;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_GPS = 1;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_IRNSS = 7;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_QZSS = 4;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_SBAS = 2;

    @SuppressLint({"InlinedApi"})
    public static final int CONSTELLATION_UNKNOWN = 0;

    public static abstract class Callback {
        public void onFirstFix(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i) {
        }

        public void onSatelliteStatusChanged(GnssStatusCompat gnssStatusCompat) {
        }

        public void onStarted() {
        }

        public void onStopped() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ConstellationType {
    }

    @RequiresApi(24)
    public static GnssStatusCompat wrap(GnssStatus gnssStatus) {
        return new GnssStatusWrapper(gnssStatus);
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public abstract float getAzimuthDegrees(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    @FloatRange(from = 0.0d, to = 63.0d)
    public abstract float getBasebandCn0DbHz(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    @FloatRange(from = 0.0d)
    public abstract float getCarrierFrequencyHz(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    @FloatRange(from = 0.0d, to = 63.0d)
    public abstract float getCn0DbHz(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    public abstract int getConstellationType(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    @FloatRange(from = -90.0d, to = 90.0d)
    public abstract float getElevationDegrees(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public abstract int getSatelliteCount();

    @IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID, to = 200)
    public abstract int getSvid(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    public abstract boolean hasAlmanacData(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    public abstract boolean hasBasebandCn0DbHz(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    public abstract boolean hasCarrierFrequencyHz(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    public abstract boolean hasEphemerisData(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    public abstract boolean usedInFix(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i);

    @SuppressLint({"ReferencesDeprecated"})
    public static GnssStatusCompat wrap(GpsStatus gpsStatus) {
        return new GpsStatusWrapper(gpsStatus);
    }
}
