package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSKernelWakeupInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSKernelWakeupInfo> CREATOR = new Parcelable.Creator<StepOSKernelWakeupInfo>() { // from class: com.stepos.powermonitor.StepOSKernelWakeupInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSKernelWakeupInfo createFromParcel(Parcel in) {
            return new StepOSKernelWakeupInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSKernelWakeupInfo[] newArray(int size) {
            return new StepOSKernelWakeupInfo[size];
        }
    };
    public int count;
    public String reason;

    public StepOSKernelWakeupInfo() {
    }

    public StepOSKernelWakeupInfo(String reason, int count) {
        this.reason = reason;
        this.count = count;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reason);
        dest.writeInt(this.count);
    }

    private StepOSKernelWakeupInfo(Parcel in) {
        this.reason = in.readString();
        this.count = in.readInt();
    }
}
