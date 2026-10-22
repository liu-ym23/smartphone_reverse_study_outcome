package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    static class Api26Impl {
        private Api26Impl() {
        }

        static float getCarrierFrequencyHz(GnssStatus r0, int r1) {
            return r0.getCarrierFrequencyHz(r1);
        }

        static boolean hasCarrierFrequencyHz(GnssStatus r0, int r1) {
            return r0.hasCarrierFrequencyHz(r1);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static boolean hasBasebandCn0DbHz(GnssStatus r0, int r1) {
            return r0.hasBasebandCn0DbHz(r1);
        }

        static float getBasebandCn0DbHz(GnssStatus r0, int r1) {
            return r0.getBasebandCn0DbHz(r1);
        }
    }

    GnssStatusWrapper(Object r1) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r1) {
        return this.mWrapped.getConstellationType(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r1) {
        return this.mWrapped.getSvid(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r1) {
        return this.mWrapped.getCn0DbHz(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r1) {
        return this.mWrapped.getElevationDegrees(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r1) {
        return this.mWrapped.getAzimuthDegrees(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r1) {
        return this.mWrapped.hasEphemerisData(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r1) {
        return this.mWrapped.hasAlmanacData(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r1) {
        return this.mWrapped.usedInFix(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r1) {
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r1) {
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r1) {
        return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r1) {
        return Api30Impl.getBasebandCn0DbHz(this.mWrapped, r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof GnssStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GnssStatusWrapper) r2).mWrapped);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }
}
