package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSAlarmInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSAlarmInfo> CREATOR = new Parcelable.Creator<StepOSAlarmInfo>() { // from class: com.stepos.powermonitor.StepOSAlarmInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAlarmInfo createFromParcel(Parcel in) {
            return new StepOSAlarmInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAlarmInfo[] newArray(int size) {
            return new StepOSAlarmInfo[size];
        }
    };
    public int count;
    public String packageName;
    public String tag;
    public long timestamp;
    public int uid;

    public StepOSAlarmInfo() {
    }

    public StepOSAlarmInfo(int uid, String packageName, String tag, long timestamp, int count) {
        this.uid = uid;
        this.packageName = packageName;
        this.tag = tag;
        this.timestamp = timestamp;
        this.count = count;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeString(this.packageName);
        dest.writeString(this.tag);
        dest.writeLong(this.timestamp);
        dest.writeInt(this.count);
    }

    private StepOSAlarmInfo(Parcel in) {
        this.uid = in.readInt();
        this.packageName = in.readString();
        this.tag = in.readString();
        this.timestamp = in.readLong();
        this.count = in.readInt();
    }
}
