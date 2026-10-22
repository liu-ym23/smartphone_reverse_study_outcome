package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSAudioPlaybackInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSAudioPlaybackInfo> CREATOR = new Parcelable.Creator<StepOSAudioPlaybackInfo>() { // from class: com.stepos.powermonitor.StepOSAudioPlaybackInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAudioPlaybackInfo createFromParcel(Parcel in) {
            return new StepOSAudioPlaybackInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSAudioPlaybackInfo[] newArray(int size) {
            return new StepOSAudioPlaybackInfo[size];
        }
    };
    public long endTime;
    public int pid;
    public long startTime;
    public int uid;

    public StepOSAudioPlaybackInfo() {
    }

    public StepOSAudioPlaybackInfo(int uid, int pid, long startTime, long endTime) {
        this.uid = uid;
        this.pid = pid;
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
        dest.writeInt(this.pid);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
    }

    private StepOSAudioPlaybackInfo(Parcel in) {
        this.uid = in.readInt();
        this.pid = in.readInt();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
    }
}
