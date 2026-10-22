package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSDisplayMonitorInfo implements Parcelable {
    public static final int BRIGHTNESS_BUCKET_COUNT = 61;
    public static final Parcelable.Creator<StepOSDisplayMonitorInfo> CREATOR = new Parcelable.Creator<StepOSDisplayMonitorInfo>() { // from class: com.stepos.powermonitor.StepOSDisplayMonitorInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSDisplayMonitorInfo createFromParcel(Parcel in) {
            return new StepOSDisplayMonitorInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSDisplayMonitorInfo[] newArray(int size) {
            return new StepOSDisplayMonitorInfo[size];
        }
    };
    public static final int LUX_BUCKET_COUNT = 78;
    public static final int REFRESH_RATE_BUCKET_COUNT = 6;
    public long aodTotalDurationMs;
    public long[] brightnessHistogramMs;
    public List<StepOSHbmSegment> hbmSegments;
    public StepOSDisplaySnapshot latest;
    public long[] luxHistogramMs;
    public long[] refreshRateHistogramMs;
    public long snapshotWallMs;
    public long windowStartWallMs;

    public StepOSDisplayMonitorInfo() {
        this.hbmSegments = Collections.emptyList();
        this.brightnessHistogramMs = new long[61];
        this.luxHistogramMs = new long[78];
        this.refreshRateHistogramMs = new long[6];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.latest == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            this.latest.writeToParcel(dest, flags);
        }
        dest.writeLong(this.aodTotalDurationMs);
        int segN = this.hbmSegments != null ? this.hbmSegments.size() : 0;
        dest.writeInt(segN);
        for (int i = 0; i < segN; i++) {
            this.hbmSegments.get(i).writeToParcel(dest, flags);
        }
        dest.writeLongArray(this.brightnessHistogramMs);
        dest.writeLongArray(this.luxHistogramMs);
        dest.writeLongArray(this.refreshRateHistogramMs);
        dest.writeLong(this.windowStartWallMs);
        dest.writeLong(this.snapshotWallMs);
    }

    private StepOSDisplayMonitorInfo(Parcel in) {
        this.latest = in.readInt() == 0 ? null : StepOSDisplaySnapshot.CREATOR.createFromParcel(in);
        this.aodTotalDurationMs = in.readLong();
        int segN = in.readInt();
        List<StepOSHbmSegment> segs = new ArrayList<>(Math.max(0, segN));
        for (int i = 0; i < segN; i++) {
            segs.add(StepOSHbmSegment.CREATOR.createFromParcel(in));
        }
        this.hbmSegments = segs;
        this.brightnessHistogramMs = in.createLongArray();
        this.luxHistogramMs = in.createLongArray();
        this.refreshRateHistogramMs = in.createLongArray();
        this.windowStartWallMs = in.readLong();
        this.snapshotWallMs = in.readLong();
    }
}
