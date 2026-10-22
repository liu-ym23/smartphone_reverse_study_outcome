package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class BdimPredictEvent implements Parcelable {
    public static final Parcelable.Creator<BdimPredictEvent> CREATOR = null;
    private final String mActualCodType;
    private final String mAddress;
    private final String mCod;
    private final BluetoothDevice mDevice;
    private final String mIoCapability;
    private final String mManuf;
    private final String mMethod;
    private final String mName;
    private final String mServiceInfo;

    public class a implements Parcelable.Creator<BdimPredictEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdimPredictEvent createFromParcel(Parcel r2) {
            return new BdimPredictEvent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BdimPredictEvent[] newArray(int r1) {
            return new BdimPredictEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BdimPredictEvent(BluetoothDevice r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        this.mDevice = r1;
        this.mAddress = r2;
        this.mName = r3;
        this.mServiceInfo = r4;
        this.mMethod = r5;
        this.mIoCapability = r6;
        this.mCod = r7;
        this.mManuf = r8;
        this.mActualCodType = r9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActualCodType() {
        return this.mActualCodType;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getCod() {
        return this.mCod;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public String getIoCapability() {
        return this.mIoCapability;
    }

    public String getManuf() {
        return this.mManuf;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public String getName() {
        return this.mName;
    }

    public String getServiceInfo() {
        return this.mServiceInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mDevice, r3);
        r2.writeString(this.mAddress);
        r2.writeString(this.mName);
        r2.writeString(this.mServiceInfo);
        r2.writeString(this.mMethod);
        r2.writeString(this.mIoCapability);
        r2.writeString(this.mCod);
        r2.writeString(this.mManuf);
        r2.writeString(this.mActualCodType);
    }

    public BdimPredictEvent(Parcel r2) {
        this.mDevice = (BluetoothDevice) r2.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mAddress = r2.readString();
        this.mName = r2.readString();
        this.mServiceInfo = r2.readString();
        this.mMethod = r2.readString();
        this.mIoCapability = r2.readString();
        this.mCod = r2.readString();
        this.mManuf = r2.readString();
        this.mActualCodType = r2.readString();
    }
}
