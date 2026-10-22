package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RobotAgent implements Parcelable {
    public static final Parcelable.Creator<RobotAgent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RobotAgentType f33913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f33914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f33915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f33916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f33917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f33918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f33919h;

    /* JADX INFO: loaded from: classes43.dex */
    public class a implements Parcelable.Creator<RobotAgent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgent createFromParcel(Parcel r100) {
            return new RobotAgent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RobotAgent[] newArray(int r100) {
            return new RobotAgent[r100];
        }
    }

    public RobotAgent() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgent(Parcel r100) {
        this.f33912a = r100.readString();
        String r101 = r100.readString();
        if (r101 == null) goto L5;
        RobotAgentType r102 = RobotAgentType.valueOf(r101);
    L6:
        this.f33913b = r102;
        this.f33914c = r100.readString();
        this.f33915d = r100.readString();
        this.f33918g = r100.readString();
        this.f33916e = r100.readString();
        this.f33919h = r100.createStringArrayList();
        this.f33917f = r100.readLong();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f33912a);
        RobotAgentType r102 = this.f33913b;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeString(r103);
        r100.writeString(this.f33914c);
        r100.writeString(this.f33915d);
        r100.writeString(this.f33918g);
        r100.writeString(this.f33916e);
        r100.writeStringList(this.f33919h);
        r100.writeLong(this.f33917f);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
