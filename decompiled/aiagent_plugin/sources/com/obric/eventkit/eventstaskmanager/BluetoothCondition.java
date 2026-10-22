package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<BluetoothCondition> CREATOR = null;
    private final String address;
    private final String name;

    public static final class Creator implements Parcelable.Creator<BluetoothCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BluetoothCondition createFromParcel(Parcel r5) {
            int r4 = r5.readInt();
            o.e(r5, "parcel");
            BluetoothCondition r0 = new BluetoothCondition(r5.readString(), r5.readString());
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = Creator.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.a.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BluetoothCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BluetoothCondition[] newArray(int r1) {
            return new BluetoothCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BluetoothCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public BluetoothCondition(String r2, String r3) {
        o.e(r2, "name");
        this.name = r2;
        this.address = r3;
    }

    public static /* synthetic */ BluetoothCondition copy$default(BluetoothCondition r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.address;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address;
    }

    public final BluetoothCondition copy(String r1, String r2) {
        o.e(r1, "name");
        return new BluetoothCondition(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BluetoothCondition.class) == true) goto L8;
        return false;
    L8:
        BluetoothCondition r6 = (BluetoothCondition) ZeusTransformUtils.preCheckCast(r5, BluetoothCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.address, r6.address) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int r0 = this.name.hashCode() * 31;
        String r1 = this.address;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BluetoothCondition(name=" + this.name + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.name);
        r1.writeString(this.address);
    }
}
