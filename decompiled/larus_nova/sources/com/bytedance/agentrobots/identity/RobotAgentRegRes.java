package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class RobotAgentRegRes implements Parcelable {
    public static final Parcelable.Creator<RobotAgentRegRes> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f33930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RobotAgent f33931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RobotAgentProof f33932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RobotDeviceStatus f33933d;

    /* JADX INFO: loaded from: classes43.dex */
    public class a implements Parcelable.Creator<RobotAgentRegRes> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgentRegRes createFromParcel(Parcel r100) {
            return new RobotAgentRegRes(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgentRegRes[] newArray(int r100) {
            return new RobotAgentRegRes[r100];
        }
    }

    public RobotAgentRegRes() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgentRegRes(Parcel r100) {
        this.f33930a = r100.readInt();
        this.f33931b = (RobotAgent) r100.readParcelable(RobotAgent.class.getClassLoader());
        this.f33932c = (RobotAgentProof) r100.readParcelable(RobotAgentProof.class.getClassLoader());
        this.f33933d = (RobotDeviceStatus) r100.readParcelable(RobotDeviceStatus.class.getClassLoader());
    }

    public void setResult(int r100) {
        this.f33930a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f33930a);
        r100.writeParcelable(this.f33931b, r101);
        r100.writeParcelable(this.f33932c, r101);
        r100.writeParcelable(this.f33933d, r101);
    }
}
