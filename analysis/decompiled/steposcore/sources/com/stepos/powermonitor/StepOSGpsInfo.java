package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSGpsInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSGpsInfo> CREATOR = new Parcelable.Creator<StepOSGpsInfo>() { // from class: com.stepos.powermonitor.StepOSGpsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSGpsInfo createFromParcel(Parcel in) {
            return new StepOSGpsInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSGpsInfo[] newArray(int size) {
            return new StepOSGpsInfo[size];
        }
    };
    public long duration;
    public long endTime;
    public String packageName;
    public long startTime;
    public int uid;

    public StepOSGpsInfo() {
    }

    public StepOSGpsInfo(int uid, String packageName, long startTime, long endTime, long duration) {
        this.uid = uid;
        this.packageName = packageName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
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
        dest.writeLong(this.duration);
    }

    private StepOSGpsInfo(Parcel in) {
        this.uid = in.readInt();
        this.packageName = in.readString();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
        this.duration = in.readLong();
    }
}
