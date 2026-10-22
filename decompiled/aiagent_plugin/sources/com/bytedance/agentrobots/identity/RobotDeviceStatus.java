package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class RobotDeviceStatus implements Parcelable {
    public static final Parcelable.Creator<RobotDeviceStatus> CREATOR = null;
    private a color;
    private boolean isKernelIntegrity;
    private boolean isLocked;
    private boolean isSELinuxEnforcing;
    private boolean isSecure;
    private String osBuildType;
    private String osPatchLevel;
    private String osVersion;
    private byte[] verifiedBootHash;
    private byte[] verifiedBootKey;
    private int version;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4028a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4029b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4030c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4031d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f4032e = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ a[] a() {
            return new a[]{f4028a, f4029b, f4030c, f4031d};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f4032e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            f4028a = new a("BOOT_STATE_GREEN", 0);
            f4029b = new a("BOOT_STATE_ORANGE", 1);
            f4030c = new a("BOOT_STATE_YELLOW", 2);
            f4031d = new a("BOOT_STATE_RED", 3);
            f4032e = a();
        }

        public static a a(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return f4028a;
        L12:
            return f4031d;
        L14:
            return f4029b;
        L16:
            return f4030c;
        L18:
            return f4028a;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RobotDeviceStatus() {
    }

    public RobotDeviceStatus(int r1, String r2, String r3, String r4, boolean r5, boolean r6, byte[] r7, byte[] r8, boolean r9, a r10, boolean r11) {
        this.version = r1;
        this.osVersion = r2;
        this.osPatchLevel = r3;
        this.osBuildType = r4;
        this.isSELinuxEnforcing = r5;
        this.isKernelIntegrity = r6;
        this.verifiedBootKey = r7;
        this.verifiedBootHash = r8;
        this.isLocked = r9;
        this.color = r10;
        this.isSecure = r11;
    }

    public RobotDeviceStatus(Parcel r4) {
        this.version = r4.readInt();
        this.osVersion = r4.readString();
        this.osPatchLevel = r4.readString();
        this.osBuildType = r4.readString();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isSELinuxEnforcing = r0;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.isKernelIntegrity = r2;
        this.verifiedBootKey = r4.createByteArray();
        this.verifiedBootHash = r4.createByteArray();
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.isLocked = r3;
        String r5 = r4.readString();
        if (r5 == null) goto L17;
        a r6 = a.valueOf(r5);
    L18:
        this.color = r6;
        if (r4.readByte() != 0) goto L22;
        r1 = false;
    L22:
        this.isSecure = r1;
        return;
    L17:
        r6 = null;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.version);
        r1.writeString(this.osVersion);
        r1.writeString(this.osPatchLevel);
        r1.writeString(this.osBuildType);
        r1.writeByte(this.isSELinuxEnforcing ? 1 : 0);
        r1.writeByte(this.isKernelIntegrity ? 1 : 0);
        r1.writeByteArray(this.verifiedBootKey);
        r1.writeByteArray(this.verifiedBootHash);
        r1.writeByte(this.isLocked ? 1 : 0);
        a r3 = this.color;
        if (r3 == null) goto L5;
        String r4 = r3.name();
    L6:
        r1.writeString(r4);
        r1.writeByte(this.isSecure ? 1 : 0);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int r1) {
        this.version = r1;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String r1) {
        this.osVersion = r1;
    }

    public String getOsPatchLevel() {
        return this.osPatchLevel;
    }

    public void setOsPatchLevel(String r1) {
        this.osPatchLevel = r1;
    }

    public String getOsBuildType() {
        return this.osBuildType;
    }

    public void setOsBuildType(String r1) {
        this.osBuildType = r1;
    }

    public boolean isSELinuxEnforcing() {
        return this.isSELinuxEnforcing;
    }

    public void setSELinuxEnforcing(boolean r1) {
        this.isSELinuxEnforcing = r1;
    }

    public boolean isKernelIntegrity() {
        return this.isKernelIntegrity;
    }

    public void setKernelIntegrity(boolean r1) {
        this.isKernelIntegrity = r1;
    }

    public byte[] getVerifiedBootKey() {
        return this.verifiedBootKey;
    }

    public void setVerifiedBootKey(byte[] r1) {
        this.verifiedBootKey = r1;
    }

    public byte[] getVerifiedBootHash() {
        return this.verifiedBootHash;
    }

    public void setVerifiedBootHash(byte[] r1) {
        this.verifiedBootHash = r1;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setLocked(boolean r1) {
        this.isLocked = r1;
    }

    public a getColor() {
        return this.color;
    }

    public void setColor(a r1) {
        this.color = r1;
    }

    public boolean isSecure() {
        return this.isSecure;
    }

    public void setSecure(boolean r1) {
        this.isSecure = r1;
    }
}
