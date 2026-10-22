package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.utils.WifiUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WifiStandardData implements Parcelable {
    public static final int AP_TYPE_NORMAL = 0;
    public static final int AP_TYPE_SOFTAP = 1;
    public static final int AP_TYPE_UNKNOWN = -1;
    public static final int AUTH_ENTERPRISE = 1;
    public static final int AUTH_OPEN = 3;
    public static final int AUTH_PERSONAL = 2;
    public static final int AUTH_UNKNOWN = 0;
    public static final Parcelable.Creator<WifiStandardData> CREATOR = null;
    private static final String TAG = "WifiStandardData";
    private static final int VERSION = 1;
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_UNKNOWN = 0;
    public static final int WIFI_STANDARD_11AC = 5;
    public static final int WIFI_STANDARD_11AD = 7;
    public static final int WIFI_STANDARD_11AX = 6;
    public static final int WIFI_STANDARD_11BE = 8;
    public static final int WIFI_STANDARD_11N = 4;
    public static final int WIFI_STANDARD_LEGACY = 1;
    public static final int WIFI_STANDARD_UNKNOWN = 0;
    private int mApStandard;
    private int mApType;
    private int mAuthType;
    private int mBand;
    private String mBssid;
    private long mDataflow;
    private int mFrequency;
    private int mRssi;
    private int mSignalLevel;
    private String mSsid;
    private long mTimestamp;
    private long mUseTime;

    public static class Builder {
        public long a;
        public String b;
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;
        public long h;
        public long i;
        public int j;
        public int k;
        public int l;

        public Builder() {
            this.b = "";
            this.c = "";
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = -1;
            this.l = 0;
        }

        public static /* synthetic */ long a(Builder r2) {
            return r2.a;
        }

        public static /* synthetic */ String b(Builder r0) {
            return r0.b;
        }

        public static /* synthetic */ int c(Builder r0) {
            return r0.k;
        }

        public static /* synthetic */ int d(Builder r0) {
            return r0.l;
        }

        public static /* synthetic */ String e(Builder r0) {
            return r0.c;
        }

        public static /* synthetic */ int f(Builder r0) {
            return r0.d;
        }

        public static /* synthetic */ int g(Builder r0) {
            return r0.e;
        }

        public static /* synthetic */ int h(Builder r0) {
            return r0.f;
        }

        public static /* synthetic */ int i(Builder r0) {
            return r0.g;
        }

        public static /* synthetic */ long j(Builder r2) {
            return r2.h;
        }

        public static /* synthetic */ long k(Builder r2) {
            return r2.i;
        }

        public static /* synthetic */ int l(Builder r0) {
            return r0.j;
        }

        public WifiStandardData build() {
            return new WifiStandardData(this);
        }

        public Builder setApStandard(int r1) {
            this.l = r1;
            return this;
        }

        public Builder setApType(int r1) {
            this.k = r1;
            return this;
        }

        public Builder setAuthType(int r1) {
            this.j = r1;
            return this;
        }

        public Builder setBand(int r1) {
            this.g = r1;
            return this;
        }

        public Builder setBssid(String r1) {
            this.b = r1;
            return this;
        }

        public Builder setDataflow(long r1) {
            this.h = r1;
            return this;
        }

        public Builder setFrequency(int r1) {
            this.f = r1;
            return this;
        }

        public Builder setRssi(int r1) {
            this.e = r1;
            return this;
        }

        public Builder setSignalLevel(int r1) {
            this.d = r1;
            return this;
        }

        public Builder setSsid(String r1) {
            this.c = r1;
            return this;
        }

        public Builder setTimestamp(long r1) {
            this.a = r1;
            return this;
        }

        public Builder setUseTime(long r1) {
            this.i = r1;
            return this;
        }
    }

    public class a implements Parcelable.Creator<WifiStandardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData createFromParcel(Parcel r2) {
            return new WifiStandardData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData[] newArray(int r1) {
            return new WifiStandardData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public WifiStandardData(Builder r3) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = Builder.a(r3);
        this.mBssid = Builder.b(r3);
        this.mSsid = Builder.e(r3);
        this.mSignalLevel = Builder.f(r3);
        this.mRssi = Builder.g(r3);
        this.mFrequency = Builder.h(r3);
        this.mBand = Builder.i(r3);
        this.mDataflow = Builder.j(r3);
        this.mUseTime = Builder.k(r3);
        this.mAuthType = Builder.l(r3);
        this.mApType = Builder.c(r3);
        this.mApStandard = Builder.d(r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getApStandard() {
        return this.mApStandard;
    }

    public int getApType() {
        return this.mApType;
    }

    public int getAuthType() {
        return this.mAuthType;
    }

    public int getBand() {
        return this.mBand;
    }

    public String getBssid() {
        return this.mBssid;
    }

    public long getDataflow() {
        return this.mDataflow;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getSignalLevel() {
        return this.mSignalLevel;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public long getUseTime() {
        return this.mUseTime;
    }

    public int getVersion() {
        return 1;
    }

    public String toString() {
        return "WifiStandardData[1," + this.mTimestamp + "," + WifiUtils.maskMacAddress(this.mBssid) + "," + this.mSsid + "," + this.mSignalLevel + "," + this.mRssi + "," + this.mFrequency + "," + this.mBand + "," + this.mDataflow + "," + this.mUseTime + "," + this.mAuthType + "," + this.mApType + "," + this.mApStandard + ']';
    }

    public String toUnmaskedString() {
        return "WifiStandardData[1," + this.mTimestamp + "," + this.mBssid + "," + this.mSsid + "," + this.mSignalLevel + "," + this.mRssi + "," + this.mFrequency + "," + this.mBand + "," + this.mDataflow + "," + this.mUseTime + "," + this.mAuthType + "," + this.mApType + "," + this.mApStandard + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mTimestamp);
        r3.writeString(this.mBssid);
        r3.writeString(this.mSsid);
        r3.writeInt(this.mSignalLevel);
        r3.writeInt(this.mRssi);
        r3.writeInt(this.mFrequency);
        r3.writeInt(this.mBand);
        r3.writeLong(this.mDataflow);
        r3.writeLong(this.mUseTime);
        r3.writeInt(this.mAuthType);
        r3.writeInt(this.mApType);
        r3.writeInt(this.mApStandard);
    }

    public WifiStandardData(Parcel r3) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = r3.readLong();
        this.mBssid = r3.readString();
        this.mSsid = r3.readString();
        this.mSignalLevel = r3.readInt();
        this.mRssi = r3.readInt();
        this.mFrequency = r3.readInt();
        this.mBand = r3.readInt();
        this.mDataflow = r3.readLong();
        this.mUseTime = r3.readLong();
        this.mAuthType = r3.readInt();
        this.mApType = r3.readInt();
        this.mApStandard = r3.readInt();
    }
}
