package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSHbmSegment implements Parcelable {
    public static final Parcelable.Creator<StepOSHbmSegment> CREATOR = new Parcelable.Creator<StepOSHbmSegment>() { // from class: com.stepos.powermonitor.StepOSHbmSegment.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSHbmSegment createFromParcel(Parcel in) {
            return new StepOSHbmSegment(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSHbmSegment[] newArray(int size) {
            return new StepOSHbmSegment[size];
        }
    };
    public long endWallMs;
    public long startWallMs;

    public StepOSHbmSegment() {
    }

    public StepOSHbmSegment(long startWallMs, long endWallMs) {
        this.startWallMs = startWallMs;
        this.endWallMs = endWallMs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.startWallMs);
        dest.writeLong(this.endWallMs);
    }

    private StepOSHbmSegment(Parcel in) {
        this.startWallMs = in.readLong();
        this.endWallMs = in.readLong();
    }
}
