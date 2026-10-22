package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSTrafficInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSTrafficInfo> CREATOR = new Parcelable.Creator<StepOSTrafficInfo>() { // from class: com.stepos.powermonitor.StepOSTrafficInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSTrafficInfo createFromParcel(Parcel in) {
            return new StepOSTrafficInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSTrafficInfo[] newArray(int size) {
            return new StepOSTrafficInfo[size];
        }
    };
    public long durationMs;
    public int pid;
    public long rxBytes;
    public long rxPackets;
    public long txBytes;
    public long txPackets;
    public int uid;

    public StepOSTrafficInfo() {
    }

    public StepOSTrafficInfo(int uid, int pid, long durationMs, long rxPackets, long txPackets, long rxBytes, long txBytes) {
        this.uid = uid;
        this.pid = pid;
        this.durationMs = durationMs;
        this.rxPackets = rxPackets;
        this.txPackets = txPackets;
        this.rxBytes = rxBytes;
        this.txBytes = txBytes;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeInt(this.pid);
        dest.writeLong(this.durationMs);
        dest.writeLong(this.rxPackets);
        dest.writeLong(this.txPackets);
        dest.writeLong(this.rxBytes);
        dest.writeLong(this.txBytes);
    }

    private StepOSTrafficInfo(Parcel in) {
        this.uid = in.readInt();
        this.pid = in.readInt();
        this.durationMs = in.readLong();
        this.rxPackets = in.readLong();
        this.txPackets = in.readLong();
        this.rxBytes = in.readLong();
        this.txBytes = in.readLong();
    }
}
