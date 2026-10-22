package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class BtAwareInfo implements Parcelable {
    public static final Parcelable.Creator<BtAwareInfo> CREATOR = null;
    private static final int VERSION = 2;
    private final String mAddress;
    private final int mAddressType;
    private final boolean mConnected;
    private final int mDeviceClass;
    private final int mDeviceType;
    private final String mManufacturer;
    private final String mName;
    private final int mRssi;
    private final long mTimestamp;
    private final ParcelUuid[] mUuids;

    public class a implements Parcelable.Creator<BtAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BtAwareInfo createFromParcel(Parcel r2) {
            return new BtAwareInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BtAwareInfo[] newArray(int r1) {
            return new BtAwareInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BtAwareInfo(String r3, int r4, int r5, String r6, int r7, String r8, int r9, boolean r10, ParcelUuid[] r11) {
        this.mTimestamp = System.currentTimeMillis();
        this.mAddress = r3;
        this.mAddressType = r4;
        this.mDeviceType = r5;
        this.mName = r6;
        this.mDeviceClass = r7;
        this.mManufacturer = r8;
        this.mRssi = r9;
        this.mConnected = r10;
        this.mUuids = r11;
    }

    public static /* synthetic */ String[] a(int r0) {
        return new String[r0];
    }

    public boolean compareTo(BtAwareInfo r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Objects.equals(this.mName, r4.mName) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.mAddress, r4.mAddress) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(Integer.valueOf(this.mAddressType), Integer.valueOf(r4.mAddressType)) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(Integer.valueOf(this.mRssi), Integer.valueOf(r4.mRssi)) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(Boolean.valueOf(this.mConnected), Boolean.valueOf(r4.mConnected)) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(Integer.valueOf(this.mDeviceType), Integer.valueOf(r4.mDeviceType)) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(Integer.valueOf(this.mDeviceClass), Integer.valueOf(r4.mDeviceClass)) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(this.mManufacturer, r4.mManufacturer) == false) goto L31;
        return true;
    L31:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getDeviceClass() {
        return this.mDeviceClass;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getName() {
        return this.mName;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public ParcelUuid[] getUuids() {
        return this.mUuids;
    }

    public int getVersion() {
        return 2;
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public String toString() {
        ParcelUuid[] r0 = this.mUuids;
        if (r0 != null) goto L5;
    L7:
        String r1 = "";
    L9:
        return "BtAwareInfo:[2, timestamp=" + this.mTimestamp + ", address=" + this.mAddress + ", addressType=" + this.mAddressType + ", deviceType=" + this.mDeviceType + ", name=" + this.mName + ", deviceClass=" + this.mDeviceClass + ", manufacturer=" + this.mManufacturer + ", rssi=" + this.mRssi + ", connected=" + this.mConnected + ", uuids=(" + r1 + ")]";
    L5:
        if (r0.length <= 0) goto L7;
        r1 = String.join(",", (CharSequence[]) Arrays.stream(r0).map(new BtAwareInfo$$ExternalSyntheticLambda0()).toArray(new BtAwareInfo$$ExternalSyntheticLambda1()));
        goto L9
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mTimestamp);
        r3.writeString(this.mAddress);
        r3.writeInt(this.mAddressType);
        r3.writeInt(this.mDeviceType);
        r3.writeString(this.mName);
        r3.writeInt(this.mDeviceClass);
        r3.writeString(this.mManufacturer);
        r3.writeInt(this.mRssi);
        r3.writeBoolean(this.mConnected);
        r3.writeTypedArray(this.mUuids, r4);
    }

    public BtAwareInfo(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mAddress = r3.readString();
        this.mAddressType = r3.readInt();
        this.mDeviceType = r3.readInt();
        this.mName = r3.readString();
        this.mDeviceClass = r3.readInt();
        this.mManufacturer = r3.readString();
        this.mRssi = (short) r3.readInt();
        this.mConnected = r3.readBoolean();
        this.mUuids = (ParcelUuid[]) r3.createTypedArray(ParcelUuid.CREATOR);
    }
}
