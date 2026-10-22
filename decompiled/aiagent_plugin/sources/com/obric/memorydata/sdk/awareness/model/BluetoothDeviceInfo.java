package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BluetoothDeviceInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<BluetoothDeviceInfo> CREATOR = null;
    private final String address;
    private final Integer batteryLevel;
    private final int deviceClass;
    private final int majorDeviceClass;
    private final String name;

    /* JADX INFO: compiled from: BluetoothDeviceInfo.kt */
    public static final class Creator implements Parcelable.Creator<BluetoothDeviceInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BluetoothDeviceInfo createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            String r1 = r7.readString();
            String r2 = r7.readString();
            if (r7.readInt() != 0) goto L5;
            Integer r0 = null;
        L7:
            return new BluetoothDeviceInfo(r1, r2, r0, r7.readInt(), r7.readInt());
        L5:
            r0 = Integer.valueOf(r7.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BluetoothDeviceInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BluetoothDeviceInfo[] newArray(int r1) {
            return new BluetoothDeviceInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BluetoothDeviceInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ BluetoothDeviceInfo copy$default(BluetoothDeviceInfo r3, String r4, String r5, Integer r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.name;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.address;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.batteryLevel;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.deviceClass;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.majorDeviceClass;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address;
    }

    public final Integer component3() {
        return this.batteryLevel;
    }

    public final int component4() {
        return this.deviceClass;
    }

    public final int component5() {
        return this.majorDeviceClass;
    }

    public final BluetoothDeviceInfo copy(String r7, String r8, Integer r9, int r10, int r11) {
        o.e(r7, "name");
        o.e(r8, SensitiveType.ADDRESS);
        return new BluetoothDeviceInfo(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BluetoothDeviceInfo.class) == true) goto L8;
        return false;
    L8:
        BluetoothDeviceInfo r6 = (BluetoothDeviceInfo) ZeusTransformUtils.preCheckCast(r5, BluetoothDeviceInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.address, r6.address) == true) goto L15;
        return false;
    L15:
        if (o.a(this.batteryLevel, r6.batteryLevel) == true) goto L18;
        return false;
    L18:
        if (this.deviceClass == r6.deviceClass) goto L21;
        return false;
    L21:
        if (this.majorDeviceClass == r6.majorDeviceClass) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.name.hashCode() * 31) + this.address.hashCode()) * 31;
        Integer r1 = this.batteryLevel;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Integer.hashCode(this.deviceClass)) * 31) + Integer.hashCode(this.majorDeviceClass);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BluetoothDeviceInfo(name=" + this.name + ", address=" + this.address + ", batteryLevel=" + this.batteryLevel + ", deviceClass=" + this.deviceClass + ", majorDeviceClass=" + this.majorDeviceClass + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "dest");
        r2.writeString(this.name);
        r2.writeString(this.address);
        Integer r4 = this.batteryLevel;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        r2.writeInt(r5);
        r2.writeInt(this.deviceClass);
        r2.writeInt(this.majorDeviceClass);
        return;
    L5:
        r2.writeInt(1);
        r5 = r4.intValue();
        goto L6
    }

    public BluetoothDeviceInfo(String r2, String r3, Integer r4, int r5, int r6) {
        o.e(r2, "name");
        o.e(r3, SensitiveType.ADDRESS);
        this.name = r2;
        this.address = r3;
        this.batteryLevel = r4;
        this.deviceClass = r5;
        this.majorDeviceClass = r6;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    public final int getDeviceClass() {
        return this.deviceClass;
    }

    public final int getMajorDeviceClass() {
        return this.majorDeviceClass;
    }
}
