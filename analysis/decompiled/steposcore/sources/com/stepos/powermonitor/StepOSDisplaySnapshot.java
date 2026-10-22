package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSDisplaySnapshot implements Parcelable {
    public static final Parcelable.Creator<StepOSDisplaySnapshot> CREATOR = new Parcelable.Creator<StepOSDisplaySnapshot>() { // from class: com.stepos.powermonitor.StepOSDisplaySnapshot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSDisplaySnapshot createFromParcel(Parcel in) {
            return new StepOSDisplaySnapshot(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSDisplaySnapshot[] newArray(int size) {
            return new StepOSDisplaySnapshot[size];
        }
    };
    public boolean isAod;
    public boolean isHbmActive;
    public boolean isUseAutoBrightness;
    public long wallClockMs;

    public StepOSDisplaySnapshot() {
    }

    public StepOSDisplaySnapshot(long wallClockMs, boolean isUseAutoBrightness, boolean isAod, boolean isHbmActive) {
        this.wallClockMs = wallClockMs;
        this.isUseAutoBrightness = isUseAutoBrightness;
        this.isAod = isAod;
        this.isHbmActive = isHbmActive;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.wallClockMs);
        parcel.writeInt(this.isUseAutoBrightness ? 1 : 0);
        parcel.writeInt(this.isAod ? 1 : 0);
        parcel.writeInt(this.isHbmActive ? 1 : 0);
    }

    private StepOSDisplaySnapshot(Parcel in) {
        this.wallClockMs = in.readLong();
        this.isUseAutoBrightness = in.readInt() != 0;
        this.isAod = in.readInt() != 0;
        this.isHbmActive = in.readInt() != 0;
    }
}
