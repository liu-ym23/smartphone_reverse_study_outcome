package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes17.dex */
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float getCarrierFrequencyHz(GnssStatus r100, int r101) {
            return r100.getCarrierFrequencyHz(r101);
        }

        public static boolean hasCarrierFrequencyHz(GnssStatus r100, int r101) {
            return r100.hasCarrierFrequencyHz(r101);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static float getBasebandCn0DbHz(GnssStatus r100, int r101) {
            return r100.getBasebandCn0DbHz(r101);
        }

        public static boolean hasBasebandCn0DbHz(GnssStatus r100, int r101) {
            return r100.hasBasebandCn0DbHz(r101);
        }
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public GnssStatusWrapper(Object r100) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GnssStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GnssStatusWrapper) r100).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r100) {
        return this.mWrapped.getAzimuthDegrees(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r100) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getBasebandCn0DbHz(this.mWrapped, r100);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, r100);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r100) {
        return this.mWrapped.getCn0DbHz(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r100) {
        return this.mWrapped.getConstellationType(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r100) {
        return this.mWrapped.getElevationDegrees(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r100) {
        return this.mWrapped.getSvid(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r100) {
        return this.mWrapped.hasAlmanacData(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return false;
    L5:
        return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r100) {
        return this.mWrapped.hasEphemerisData(r100);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r100) {
        return this.mWrapped.usedInFix(r100);
    }
}
