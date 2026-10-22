package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class RobotDeviceStatus implements Parcelable {
    public static final Parcelable.Creator<RobotDeviceStatus> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f33937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f33938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f33941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f33942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BootState f33944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f33945k;

    /* JADX INFO: loaded from: classes43.dex */
    public static final enum BootState extends Enum<BootState> {
        public static final BootState BOOT_STATE_GREEN = null;
        public static final BootState BOOT_STATE_ORANGE = null;
        public static final BootState BOOT_STATE_RED = null;
        public static final BootState BOOT_STATE_YELLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BootState[] f33946a = null;

        static {
            BootState r100 = new BootState("BOOT_STATE_GREEN", 0);
            BOOT_STATE_GREEN = r100;
            BootState r101 = new BootState("BOOT_STATE_ORANGE", 1);
            BOOT_STATE_ORANGE = r101;
            BootState r102 = new BootState("BOOT_STATE_YELLOW", 2);
            BOOT_STATE_YELLOW = r102;
            BootState r103 = new BootState("BOOT_STATE_RED", 3);
            BOOT_STATE_RED = r103;
            f33946a = new BootState[]{r100, r101, r102, r103};
        }

        public static BootState[] values() {
            return (BootState[]) f33946a.clone();
        }

        public static BootState fromInt(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return BOOT_STATE_GREEN;
        L12:
            return BOOT_STATE_RED;
        L14:
            return BOOT_STATE_ORANGE;
        L16:
            return BOOT_STATE_YELLOW;
        L18:
            return BOOT_STATE_GREEN;
        }

        public static BootState valueOf(String r100) {
            return (BootState) r27.a.a(BootState.class, r100);
        }

        public BootState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<RobotDeviceStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RobotDeviceStatus createFromParcel(Parcel r100) {
            return new RobotDeviceStatus(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RobotDeviceStatus[] newArray(int r100) {
            return new RobotDeviceStatus[r100];
        }
    }

    public RobotDeviceStatus() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotDeviceStatus(Parcel r100) {
        this.f33935a = r100.readInt();
        this.f33936b = r100.readString();
        this.f33937c = r100.readString();
        this.f33938d = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f33939e = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f33940f = r103;
        this.f33941g = r100.createByteArray();
        this.f33942h = r100.createByteArray();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f33943i = r104;
        String r105 = r100.readString();
        if (r105 == null) goto L17;
        BootState r106 = BootState.valueOf(r105);
    L18:
        this.f33944j = r106;
        if (r100.readByte() != 0) goto L22;
        r101 = false;
    L22:
        this.f33945k = r101;
        return;
    L17:
        r106 = null;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f33935a);
        r100.writeString(this.f33936b);
        r100.writeString(this.f33937c);
        r100.writeString(this.f33938d);
        r100.writeByte(this.f33939e ? 1 : 0);
        r100.writeByte(this.f33940f ? 1 : 0);
        r100.writeByteArray(this.f33941g);
        r100.writeByteArray(this.f33942h);
        r100.writeByte(this.f33943i ? 1 : 0);
        BootState r102 = this.f33944j;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeString(r103);
        r100.writeByte(this.f33945k ? 1 : 0);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
