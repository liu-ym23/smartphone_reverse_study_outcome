package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSJobExecutionInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSJobExecutionInfo> CREATOR = new Parcelable.Creator<StepOSJobExecutionInfo>() { // from class: com.stepos.powermonitor.StepOSJobExecutionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSJobExecutionInfo createFromParcel(Parcel in) {
            return new StepOSJobExecutionInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSJobExecutionInfo[] newArray(int size) {
            return new StepOSJobExecutionInfo[size];
        }
    };
    public int count;
    public String jobTag;
    public String packageName;
    public int uid;

    public StepOSJobExecutionInfo() {
    }

    public StepOSJobExecutionInfo(int uid, String packageName, String jobTag, int count) {
        this.uid = uid;
        this.packageName = packageName;
        this.jobTag = jobTag;
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
        dest.writeString(this.jobTag);
        dest.writeInt(this.count);
    }

    private StepOSJobExecutionInfo(Parcel in) {
        this.uid = in.readInt();
        this.packageName = in.readString();
        this.jobTag = in.readString();
        this.count = in.readInt();
    }
}
