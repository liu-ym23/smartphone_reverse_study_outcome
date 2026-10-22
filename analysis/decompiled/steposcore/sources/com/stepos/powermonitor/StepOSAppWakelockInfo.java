package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSAppWakelockInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSAppWakelockInfo> CREATOR = new Parcelable.Creator<StepOSAppWakelockInfo>() { // from class: com.stepos.powermonitor.StepOSAppWakelockInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAppWakelockInfo createFromParcel(Parcel in) {
            return new StepOSAppWakelockInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAppWakelockInfo[] newArray(int size) {
            return new StepOSAppWakelockInfo[size];
        }
    };
    public int count;
    public long duration;
    public long endTime;
    public boolean isLongWakeLock;
    public String packageName;
    public long startTime;
    public String tag;
    public int type;
    public int uid;

    public StepOSAppWakelockInfo() {
    }

    public StepOSAppWakelockInfo(int uid, String packageName, String tag, int type, boolean isLongWakeLock, long startTime, long endTime, long duration, int count) {
        this.uid = uid;
        this.packageName = packageName;
        this.tag = tag;
        this.type = type;
        this.isLongWakeLock = isLongWakeLock;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
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
        dest.writeInt(this.type);
        dest.writeBoolean(this.isLongWakeLock);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeLong(this.duration);
        dest.writeInt(this.count);
    }

    private StepOSAppWakelockInfo(Parcel in) {
        this.uid = in.readInt();
        this.packageName = in.readString();
        this.tag = in.readString();
        this.type = in.readInt();
        this.isLongWakeLock = in.readBoolean();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
        this.duration = in.readLong();
        this.count = in.readInt();
    }
}
