package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSRpmInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSRpmInfo> CREATOR = new Parcelable.Creator<StepOSRpmInfo>() { // from class: com.stepos.powermonitor.StepOSRpmInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSRpmInfo createFromParcel(Parcel in) {
            return new StepOSRpmInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSRpmInfo[] newArray(int size) {
            return new StepOSRpmInfo[size];
        }
    };
    public long count;
    public long durationMs;
    public String name;

    public StepOSRpmInfo() {
    }

    public StepOSRpmInfo(String name, long count, long durationMs) {
        this.name = name;
        this.count = count;
        this.durationMs = durationMs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeLong(this.count);
        dest.writeLong(this.durationMs);
    }

    private StepOSRpmInfo(Parcel in) {
        this.name = in.readString();
        this.count = in.readLong();
        this.durationMs = in.readLong();
    }
}
