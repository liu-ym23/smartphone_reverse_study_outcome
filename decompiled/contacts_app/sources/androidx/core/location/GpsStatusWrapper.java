package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    private Iterator<GpsSatellite> mCachedIterator;
    private int mCachedIteratorPosition;
    private GpsSatellite mCachedSatellite;
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    private static int getConstellationFromPrn(int r2) {
        if (r2 <= 0) goto L8;
        if (r2 > 32) goto L8;
        return 1;
    L8:
        if (r2 < 33) goto L12;
        if (r2 > 64) goto L12;
        return 2;
    L12:
        if (r2 <= 64) goto L18;
        if (r2 > 88) goto L18;
        return 3;
    L18:
        if (r2 <= 200) goto L24;
        if (r2 > 235) goto L24;
        return 5;
    L24:
        if (r2 < 193) goto L28;
        if (r2 > 200) goto L30;
        return 4;
    L30:
        return 0;
    L28:
        return 0;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r1) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r1) {
        return false;
    }

    GpsStatusWrapper(GpsStatus r2) {
        GpsStatus r3 = (GpsStatus) Preconditions.checkNotNull(r2);
        this.mWrapped = r3;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = r3.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        GpsStatus r0 = this.mWrapped;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCachedSatelliteCount != (-1)) goto L11;
        Iterator<GpsSatellite> r1 = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L14
    L8:
        if (r1.hasNext() == false) goto L10;
        GpsSatellite r2 = r1.next();     // Catch: Throwable -> L14
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L14
        goto L8
    L10:
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L14
    L11:
        int r3 = this.mCachedSatelliteCount;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r1) {
        return getConstellationFromPrn(getSatellite(r1).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r1) {
        return getSvidFromPrn(getSatellite(r1).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r1) {
        return getSatellite(r1).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r1) {
        return getSatellite(r1).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r1) {
        return getSatellite(r1).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r1) {
        return getSatellite(r1).hasEphemeris();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r1) {
        return getSatellite(r1).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r1) {
        return getSatellite(r1).usedInFix();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r1) {
        throw new UnsupportedOperationException();
    }

    private GpsSatellite getSatellite(int r3) {
        GpsStatus r0 = this.mWrapped;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r3 >= this.mCachedIteratorPosition) goto L7;
        this.mCachedIterator = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L17
        this.mCachedIteratorPosition = -1;     // Catch: Throwable -> L17
    L7:
        int r1 = this.mCachedIteratorPosition;     // Catch: Throwable -> L17
        if (r1 >= r3) goto L13;
        this.mCachedIteratorPosition = r1 + 1;     // Catch: Throwable -> L17
        if (this.mCachedIterator.hasNext() == false) goto L11;
        this.mCachedSatellite = this.mCachedIterator.next();     // Catch: Throwable -> L17
        goto L7
    L11:
        this.mCachedSatellite = null;     // Catch: Throwable -> L17
    L13:
        GpsSatellite r2 = this.mCachedSatellite;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return (GpsSatellite) Preconditions.checkNotNull(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof GpsStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GpsStatusWrapper) r2).mWrapped);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    private static int getSvidFromPrn(int r2) {
        int r0 = getConstellationFromPrn(r2);
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L14;
        if (r0 == 5) goto L13;
        return r2;
    L13:
        return r2 - 200;
    L14:
        return r2 - 64;
    L12:
        return r2 + 87;
    }
}
