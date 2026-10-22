package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
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

    private static int getConstellationFromPrn(int r100) {
        if (r100 <= 0) goto L8;
        if (r100 > 32) goto L8;
        return 1;
    L8:
        if (r100 < 33) goto L12;
        if (r100 > 64) goto L12;
        return 2;
    L12:
        if (r100 <= 64) goto L18;
        if (r100 > 88) goto L18;
        return 3;
    L18:
        if (r100 <= 200) goto L24;
        if (r100 > 235) goto L24;
        return 5;
    L24:
        if (r100 < 193) goto L28;
        if (r100 > 200) goto L30;
        return 4;
    L30:
        return 0;
    L28:
        return 0;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r100) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r100) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        GpsStatus r100 = this.mWrapped;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCachedSatelliteCount != (-1)) goto L11;
        Iterator<GpsSatellite> r101 = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L14
    L8:
        if (r101.hasNext() == false) goto L10;
        GpsSatellite r102 = r101.next();     // Catch: Throwable -> L14
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L14
        goto L8
    L10:
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L14
    L11:
        int r103 = this.mCachedSatelliteCount;     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r103;
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public GpsStatusWrapper(GpsStatus r100) {
        GpsStatus r101 = (GpsStatus) Preconditions.checkNotNull(r100);
        this.mWrapped = r101;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = r101.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private GpsSatellite getSatellite(int r100) {
        GpsStatus r101 = this.mWrapped;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r100 >= this.mCachedIteratorPosition) goto L7;
        this.mCachedIterator = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L17
        this.mCachedIteratorPosition = -1;     // Catch: Throwable -> L17
    L7:
        int r102 = this.mCachedIteratorPosition;     // Catch: Throwable -> L17
        if (r102 >= r100) goto L13;
        this.mCachedIteratorPosition = r102 + 1;     // Catch: Throwable -> L17
        if (this.mCachedIterator.hasNext() == false) goto L11;
        this.mCachedSatellite = this.mCachedIterator.next();     // Catch: Throwable -> L17
        goto L7
    L11:
        this.mCachedSatellite = null;     // Catch: Throwable -> L17
    L13:
        GpsSatellite r103 = this.mCachedSatellite;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return (GpsSatellite) Preconditions.checkNotNull(r103);
    }

    private static int getSvidFromPrn(int r100) {
        int r101 = getConstellationFromPrn(r100);
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L14;
        if (r101 == 5) goto L13;
        return r100;
    L13:
        return r100 - 200;
    L14:
        return r100 - 64;
    L12:
        return r100 + 87;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GpsStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GpsStatusWrapper) r100).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r100) {
        return getSatellite(r100).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r100) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r100) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r100) {
        return getSatellite(r100).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return 1;
    L7:
        return getConstellationFromPrn(getSatellite(r100).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r100) {
        return getSatellite(r100).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return getSatellite(r100).getPrn();
    L7:
        return getSvidFromPrn(getSatellite(r100).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r100) {
        return getSatellite(r100).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r100) {
        return getSatellite(r100).hasEphemeris();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r100) {
        return getSatellite(r100).usedInFix();
    }
}
