package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSKernelWakelockInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSKernelWakelockInfo> CREATOR = new Parcelable.Creator<StepOSKernelWakelockInfo>() { // from class: com.stepos.powermonitor.StepOSKernelWakelockInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSKernelWakelockInfo createFromParcel(Parcel in) {
            return new StepOSKernelWakelockInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSKernelWakelockInfo[] newArray(int size) {
            return new StepOSKernelWakelockInfo[size];
        }
    };
    public int deltaCount;
    public long deltaTotalTimeUs;
    public String name;
    public long windowDurationMs;

    public StepOSKernelWakelockInfo() {
    }

    public StepOSKernelWakelockInfo(String name, long windowDurationMs, long deltaTotalTimeUs, int deltaCount) {
        this.name = name;
        this.windowDurationMs = windowDurationMs;
        this.deltaTotalTimeUs = deltaTotalTimeUs;
        this.deltaCount = deltaCount;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeLong(this.windowDurationMs);
        dest.writeLong(this.deltaTotalTimeUs);
        dest.writeInt(this.deltaCount);
    }

    private StepOSKernelWakelockInfo(Parcel in) {
        this.name = in.readString();
        this.windowDurationMs = in.readLong();
        this.deltaTotalTimeUs = in.readLong();
        this.deltaCount = in.readInt();
    }
}
