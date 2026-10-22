package com.obric.cae.libs.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class CaeDcfScanResult implements Parcelable {
    public static final Parcelable.Creator<CaeDcfScanResult> CREATOR = null;
    private final String mDeviceId;
    private final byte[] mRawData;
    private final long mTimestamp;

    public class a implements Parcelable.Creator<CaeDcfScanResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeDcfScanResult createFromParcel(Parcel r2) {
            return new CaeDcfScanResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeDcfScanResult[] newArray(int r1) {
            return new CaeDcfScanResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeDcfScanResult(String r1, byte[] r2, long r3) {
        this.mDeviceId = r1;
        this.mRawData = r2;
        this.mTimestamp = r3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public byte[] getRawData() {
        return this.mRawData;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.mDeviceId);
        r3.writeByteArray(this.mRawData);
        r3.writeLong(this.mTimestamp);
    }

    public CaeDcfScanResult(Parcel r3) {
        this.mDeviceId = r3.readString();
        this.mRawData = r3.createByteArray();
        this.mTimestamp = r3.readLong();
    }
}
