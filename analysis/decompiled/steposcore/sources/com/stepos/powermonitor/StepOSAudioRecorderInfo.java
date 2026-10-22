package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSAudioRecorderInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSAudioRecorderInfo> CREATOR = new Parcelable.Creator<StepOSAudioRecorderInfo>() { // from class: com.stepos.powermonitor.StepOSAudioRecorderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAudioRecorderInfo createFromParcel(Parcel in) {
            return new StepOSAudioRecorderInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAudioRecorderInfo[] newArray(int size) {
            return new StepOSAudioRecorderInfo[size];
        }
    };
    public long endTime;
    public String packageName;
    public long startTime;
    public int uid;

    public StepOSAudioRecorderInfo() {
    }

    public StepOSAudioRecorderInfo(int uid, String packageName, long startTime, long endTime) {
        this.uid = uid;
        this.packageName = packageName != null ? packageName : "";
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeString(this.packageName);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
    }

    private StepOSAudioRecorderInfo(Parcel in) {
        this.uid = in.readInt();
        this.packageName = in.readString();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
    }
}
