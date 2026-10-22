package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RobotAgentRegReq implements Parcelable {
    public static final Parcelable.Creator<RobotAgentRegReq> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RobotAgentType f33927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f33928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f33929d;

    /* JADX INFO: loaded from: classes43.dex */
    public class a implements Parcelable.Creator<RobotAgentRegReq> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgentRegReq createFromParcel(Parcel r100) {
            return new RobotAgentRegReq(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgentRegReq[] newArray(int r100) {
            return new RobotAgentRegReq[r100];
        }
    }

    public RobotAgentRegReq() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgentRegReq(Parcel r100) {
        this.f33926a = r100.readString();
        int r101 = r100.readInt();
        if (r101 != (-1)) goto L5;
        RobotAgentType r102 = null;
    L6:
        this.f33927b = r102;
        this.f33928c = r100.readString();
        this.f33929d = r100.createStringArrayList();
        return;
    L5:
        r102 = RobotAgentType.values()[r101];
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f33926a);
        RobotAgentType r102 = this.f33927b;
        if (r102 == null) goto L5;
        int r103 = r102.ordinal();
    L6:
        r100.writeInt(r103);
        r100.writeString(this.f33928c);
        r100.writeStringList(this.f33929d);
        return;
    L5:
        r103 = -1;
        goto L6
    }
}
