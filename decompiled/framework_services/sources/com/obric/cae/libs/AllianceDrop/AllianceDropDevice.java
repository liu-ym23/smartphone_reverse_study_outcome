package com.obric.cae.libs.AllianceDrop;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class AllianceDropDevice implements Parcelable {
    public static final Parcelable.Creator<AllianceDropDevice> CREATOR = null;
    private final BluetoothDevice mBluetoothDevice;
    private final String mDeviceId;
    private final String mDeviceName;
    private final int mDeviceType;
    private final int mManuId;
    private int mStatus;

    public class a implements Parcelable.Creator<AllianceDropDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropDevice createFromParcel(Parcel r2) {
            return new AllianceDropDevice(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropDevice[] newArray(int r1) {
            return new AllianceDropDevice[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AllianceDropDevice(BluetoothDevice r1, int r2, int r3, String r4, String r5) {
        this.mBluetoothDevice = r1;
        this.mManuId = r2;
        this.mDeviceType = r3;
        this.mDeviceName = r4;
        this.mDeviceId = r5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getManuId() {
        return this.mManuId;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int r1) {
        this.mStatus = r1;
    }

    public boolean supportBleDataEncryption() {
        if ((this.mStatus & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mBluetoothDevice, r3);
        r2.writeInt(this.mManuId);
        r2.writeInt(this.mDeviceType);
        r2.writeString(this.mDeviceName);
        r2.writeString(this.mDeviceId);
        r2.writeInt(this.mStatus);
    }

    public AllianceDropDevice(Parcel r2) {
        this.mBluetoothDevice = (BluetoothDevice) r2.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mManuId = r2.readInt();
        this.mDeviceType = r2.readInt();
        this.mDeviceName = r2.readString();
        this.mDeviceId = r2.readString();
        this.mStatus = r2.readInt();
    }
}
