package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RobotAgentProof implements Parcelable {
    public static final Parcelable.Creator<RobotAgentProof> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RobotDeviceStatus f33922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f33923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f33924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f33925f;

    /* JADX INFO: loaded from: classes43.dex */
    public class a implements Parcelable.Creator<RobotAgentProof> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgentProof createFromParcel(Parcel r100) {
            return new RobotAgentProof(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgentProof[] newArray(int r100) {
            return new RobotAgentProof[r100];
        }
    }

    public RobotAgentProof() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgentProof(Parcel r100) {
        this.f33920a = r100.readString();
        this.f33921b = r100.readString();
        this.f33922c = (RobotDeviceStatus) r100.readParcelable(RobotDeviceStatus.class.getClassLoader());
        this.f33923d = r100.createByteArray();
        this.f33924e = r100.createStringArrayList();
        this.f33925f = r100.createByteArray();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f33920a);
        r100.writeString(this.f33921b);
        r100.writeParcelable(this.f33922c, r101);
        r100.writeByteArray(this.f33923d);
        r100.writeStringList(this.f33924e);
        r100.writeByteArray(this.f33925f);
    }
}
