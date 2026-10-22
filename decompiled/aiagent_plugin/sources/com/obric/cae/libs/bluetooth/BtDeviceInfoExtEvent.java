package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BtDeviceInfoExtEvent implements Parcelable {
    public static final Parcelable.Creator<BtDeviceInfoExtEvent> CREATOR = null;
    public static final int INVALID_PRODUCT_ID = 0;
    private final BluetoothDevice mDevice;
    private final int mProductId;

    public class a implements Parcelable.Creator<BtDeviceInfoExtEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BtDeviceInfoExtEvent createFromParcel(Parcel r1) {
            return new BtDeviceInfoExtEvent(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final BtDeviceInfoExtEvent[] newArray(int r1) {
            return new BtDeviceInfoExtEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BtDeviceInfoExtEvent(BluetoothDevice r1, int r2) {
        this.mDevice = r1;
        this.mProductId = r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public int getProductId() {
        return this.mProductId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mDevice, 0);
        r2.writeInt(this.mProductId);
    }

    public BtDeviceInfoExtEvent(Parcel r4) {
        this.mDevice = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r4.readParcelable(null), BluetoothDevice.class, "com.obric.aiagent.plugin");
        this.mProductId = r4.readInt();
    }
}
