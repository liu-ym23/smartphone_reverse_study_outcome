package com.android.server.location.gnss;

import android.location.GnssCapabilities;
import android.util.IndentingPrintWriter;
import android.util.TimeUtils;
import com.android.internal.util.Preconditions;
import java.io.FileDescriptor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class GnssPowerStats {
    private final int mElapsedRealtimeFlags;
    private final long mElapsedRealtimeNanos;
    private final double mElapsedRealtimeUncertaintyNanos;
    private final double mMultibandAcquisitionModeEnergyMilliJoule;
    private final double mMultibandTrackingModeEnergyMilliJoule;
    private final double[] mOtherModesEnergyMilliJoule;
    private final double mSinglebandAcquisitionModeEnergyMilliJoule;
    private final double mSinglebandTrackingModeEnergyMilliJoule;
    private final double mTotalEnergyMilliJoule;

    public GnssPowerStats(int elapsedRealtimeFlags, long elapsedRealtimeNanos, double elapsedRealtimeUncertaintyNanos, double totalEnergyMilliJoule, double singlebandTrackingModeEnergyMilliJoule, double multibandTrackingModeEnergyMilliJoule, double singlebandAcquisitionModeEnergyMilliJoule, double multibandAcquisitionModeEnergyMilliJoule, double[] otherModesEnergyMilliJoule) {
        this.mElapsedRealtimeFlags = elapsedRealtimeFlags;
        this.mElapsedRealtimeNanos = elapsedRealtimeNanos;
        this.mElapsedRealtimeUncertaintyNanos = elapsedRealtimeUncertaintyNanos;
        this.mTotalEnergyMilliJoule = totalEnergyMilliJoule;
        this.mSinglebandTrackingModeEnergyMilliJoule = singlebandTrackingModeEnergyMilliJoule;
        this.mMultibandTrackingModeEnergyMilliJoule = multibandTrackingModeEnergyMilliJoule;
        this.mSinglebandAcquisitionModeEnergyMilliJoule = singlebandAcquisitionModeEnergyMilliJoule;
        this.mMultibandAcquisitionModeEnergyMilliJoule = multibandAcquisitionModeEnergyMilliJoule;
        this.mOtherModesEnergyMilliJoule = otherModesEnergyMilliJoule;
    }

    public boolean hasElapsedRealtimeNanos() {
        if ((this.mElapsedRealtimeFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasElapsedRealtimeUncertaintyNanos() {
        if ((this.mElapsedRealtimeFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getElapsedRealtimeNanos() {
        return this.mElapsedRealtimeNanos;
    }

    public double getElapsedRealtimeUncertaintyNanos() {
        return this.mElapsedRealtimeUncertaintyNanos;
    }

    public double getTotalEnergyMilliJoule() {
        return this.mTotalEnergyMilliJoule;
    }

    public double getSinglebandTrackingModeEnergyMilliJoule() {
        return this.mSinglebandTrackingModeEnergyMilliJoule;
    }

    public double getMultibandTrackingModeEnergyMilliJoule() {
        return this.mMultibandTrackingModeEnergyMilliJoule;
    }

    public double getSinglebandAcquisitionModeEnergyMilliJoule() {
        return this.mSinglebandAcquisitionModeEnergyMilliJoule;
    }

    public double getMultibandAcquisitionModeEnergyMilliJoule() {
        return this.mMultibandAcquisitionModeEnergyMilliJoule;
    }

    public double[] getOtherModesEnergyMilliJoule() {
        return this.mOtherModesEnergyMilliJoule;
    }

    public void validate() {
        Preconditions.checkArgument(hasElapsedRealtimeNanos());
    }

    public void dump(FileDescriptor fd, IndentingPrintWriter ipw, String[] args, GnssCapabilities capabilities) {
        if (hasElapsedRealtimeNanos() == false) goto L10;
        ipw.print("time: ");
        ipw.print(TimeUtils.formatRealtime(TimeUnit.NANOSECONDS.toMillis(this.mElapsedRealtimeNanos)));
        if (hasElapsedRealtimeUncertaintyNanos() == false) goto L10;
        if (this.mElapsedRealtimeUncertaintyNanos == 0.0d) goto L10;
        ipw.print(" +/- ");
        ipw.print(TimeUnit.NANOSECONDS.toMillis((long) this.mElapsedRealtimeUncertaintyNanos));
    L10:
        if (capabilities.hasPowerTotal() == false) goto L13;
        ipw.print("total power: ");
        ipw.print(this.mTotalEnergyMilliJoule);
        ipw.println("mJ");
    L13:
        if (capabilities.hasPowerSinglebandTracking() == false) goto L16;
        ipw.print("single-band tracking power: ");
        ipw.print(this.mSinglebandTrackingModeEnergyMilliJoule);
        ipw.println("mJ");
    L16:
        if (capabilities.hasPowerMultibandTracking() == false) goto L19;
        ipw.print("multi-band tracking power: ");
        ipw.print(this.mMultibandTrackingModeEnergyMilliJoule);
        ipw.println("mJ");
    L19:
        if (capabilities.hasPowerSinglebandAcquisition() == false) goto L22;
        ipw.print("single-band acquisition power: ");
        ipw.print(this.mSinglebandAcquisitionModeEnergyMilliJoule);
        ipw.println("mJ");
    L22:
        if (capabilities.hasPowerMultibandAcquisition() == false) goto L25;
        ipw.print("multi-band acquisition power: ");
        ipw.print(this.mMultibandAcquisitionModeEnergyMilliJoule);
        ipw.println("mJ");
    L25:
        if (capabilities.hasPowerOtherModes() == false) goto L30;
        int i = 0;
    L28:
        if (i >= this.mOtherModesEnergyMilliJoule.length) goto L32;
        ipw.print("other mode [" + i + "] power: ");
        ipw.print(this.mOtherModesEnergyMilliJoule[i]);
        ipw.println("mJ");
        i = i + 1;
        goto L28
    L32:
        return;
    }
}
