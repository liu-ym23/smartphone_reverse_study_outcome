package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CellAwareInfo implements Parcelable {
    public static final Parcelable.Creator<CellAwareInfo> CREATOR = null;
    private static final String LTE = "LTE";
    private static final long MAX_NCI = 68719476735L;
    private static final int MAX_NRARFCN = 3279165;
    private static final int MAX_PCI = 1007;
    private static final int MAX_TAC = 16777215;
    private static final String NR = "NR";
    private static final int VERSION = 2;
    private int mArfcn;
    private int[] mBands;
    private long mCi;
    private int mLevel;
    private String mMcc;
    private String mMnc;
    private int mPci;
    private boolean mRegistered;
    private int mSignalQuality;
    private int mSignalStrength;
    private String mStandard;
    private int mTac;
    private String mTimestamp;

    public static class Builder {
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public long f;
        public int[] g;
        public String h;
        public String i;
        public int j;
        public int k;
        public int l;
        public boolean m;

        public Builder() {
        }

        public static /* synthetic */ String a(Builder r0) {
            return r0.a;
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

        public static /* synthetic */ boolean e(Builder r0) {
            return r0.m;
        }

        public static /* synthetic */ int f(Builder r0) {
            return r0.c;
        }

        public static /* synthetic */ int g(Builder r0) {
            return r0.d;
        }

        public static /* synthetic */ int h(Builder r0) {
            return r0.e;
        }

        public static /* synthetic */ long i(Builder r2) {
            return r2.f;
        }

        public static /* synthetic */ int[] j(Builder r0) {
            return r0.g;
        }

        public static /* synthetic */ String k(Builder r0) {
            return r0.h;
        }

        public static /* synthetic */ String l(Builder r0) {
            return r0.i;
        }

        public static /* synthetic */ int m(Builder r0) {
            return r0.j;
        }

        public Builder arfcn(int r1) {
            this.c = r1;
            return this;
        }

        public Builder bands(int[] r1) {
            this.g = r1;
            return this;
        }

        public CellAwareInfo build() {
            return new CellAwareInfo(this);
        }

        public Builder ci(long r1) {
            this.f = r1;
            return this;
        }

        public Builder level(int r1) {
            this.l = r1;
            return this;
        }

        public Builder mcc(String r1) {
            this.h = r1;
            return this;
        }

        public Builder mnc(String r1) {
            this.i = r1;
            return this;
        }

        public Builder pci(int r1) {
            this.d = r1;
            return this;
        }

        public Builder registered(boolean r1) {
            this.m = r1;
            return this;
        }

        public Builder signalQuality(int r1) {
            this.k = r1;
            return this;
        }

        public Builder signalStrength(int r1) {
            this.j = r1;
            return this;
        }

        public Builder standard(String r1) {
            this.b = r1;
            return this;
        }

        public Builder tac(int r1) {
            this.e = r1;
            return this;
        }

        public Builder timestamp(String r1) {
            this.a = r1;
            return this;
        }
    }

    public class a implements Parcelable.Creator<CellAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo createFromParcel(Parcel r2) {
            return new CellAwareInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo[] newArray(int r1) {
            return new CellAwareInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CellAwareInfo() {
        this.mTimestamp = String.valueOf(System.currentTimeMillis());
        this.mStandard = "";
        this.mArfcn = 0;
        this.mPci = 0;
        this.mTac = 0;
        this.mCi = 0;
        this.mBands = new int[0];
        this.mMcc = "";
        this.mMnc = "";
        this.mSignalStrength = 0;
        this.mSignalQuality = 0;
        this.mLevel = 0;
        this.mRegistered = false;
    }

    public boolean compareTo(CellAwareInfo r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L25;
        if (this.mArfcn != r7.mArfcn) goto L24;
        if (this.mPci != r7.mPci) goto L24;
        if (this.mTac != r7.mTac) goto L24;
        if (this.mCi != r7.mCi) goto L24;
        if (this.mRegistered != r7.mRegistered) goto L24;
        if (Objects.equals(this.mStandard, r7.mStandard) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getArfcn() {
        return this.mArfcn;
    }

    public int[] getBands() {
        return this.mBands;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getMcc() {
        return this.mMcc;
    }

    public long getMci() {
        return this.mCi;
    }

    public String getMnc() {
        return this.mMnc;
    }

    public int getPci() {
        return this.mPci;
    }

    public int getSignalQuality() {
        return this.mSignalQuality;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public String getStandard() {
        return this.mStandard;
    }

    public int getTac() {
        return this.mTac;
    }

    public String getTimestamp() {
        return this.mTimestamp;
    }

    public int getVersion() {
        return 2;
    }

    public boolean isRegistered() {
        return this.mRegistered;
    }

    public void readFromParcel(Parcel r3) {
        this.mTimestamp = r3.readString();
        this.mStandard = r3.readString();
        this.mArfcn = r3.readInt();
        this.mPci = r3.readInt();
        this.mTac = r3.readInt();
        this.mCi = r3.readLong();
        this.mBands = r3.createIntArray();
        this.mMcc = r3.readString();
        this.mMnc = r3.readString();
        this.mSignalStrength = r3.readInt();
        this.mSignalQuality = r3.readInt();
        this.mLevel = r3.readInt();
        this.mRegistered = r3.readBoolean();
    }

    public void setArfcn(int r1) {
        this.mArfcn = r1;
    }

    public void setBands(int[] r1) {
        this.mBands = r1;
    }

    public void setLevel(int r1) {
        this.mLevel = r1;
    }

    public void setMcc(String r1) {
        this.mMcc = r1;
    }

    public void setMci(long r1) {
        this.mCi = r1;
    }

    public void setMnc(String r1) {
        this.mMnc = r1;
    }

    public void setPci(int r1) {
        this.mPci = r1;
    }

    public void setRegistered(boolean r1) {
        this.mRegistered = r1;
    }

    public void setSignalQuality(int r1) {
        this.mSignalQuality = r1;
    }

    public void setSignalStrength(int r1) {
        this.mSignalStrength = r1;
    }

    public void setStandard(String r1) {
        this.mStandard = r1;
    }

    public void setTac(int r1) {
        this.mTac = r1;
    }

    public void setTimestamp(String r1) {
        this.mTimestamp = r1;
    }

    public String toString() {
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=***, mCi=***, mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
    }

    public String toUnmaskedString() {
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=" + this.mTac + ", mCi=" + this.mCi + ", mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.mTimestamp);
        r3.writeString(this.mStandard);
        r3.writeInt(this.mArfcn);
        r3.writeInt(this.mPci);
        r3.writeInt(this.mTac);
        r3.writeLong(this.mCi);
        r3.writeIntArray(this.mBands);
        r3.writeString(this.mMcc);
        r3.writeString(this.mMnc);
        r3.writeInt(this.mSignalStrength);
        r3.writeInt(this.mSignalQuality);
        r3.writeInt(this.mLevel);
        r3.writeBoolean(this.mRegistered);
    }

    public CellAwareInfo(Parcel r3) {
        this.mTimestamp = r3.readString();
        this.mStandard = r3.readString();
        this.mArfcn = r3.readInt();
        this.mPci = r3.readInt();
        this.mTac = r3.readInt();
        this.mCi = r3.readLong();
        this.mBands = r3.createIntArray();
        this.mMcc = r3.readString();
        this.mMnc = r3.readString();
        this.mSignalStrength = r3.readInt();
        this.mSignalQuality = r3.readInt();
        this.mLevel = r3.readInt();
        this.mRegistered = r3.readBoolean();
    }

    public CellAwareInfo(Builder r3) {
        this.mTimestamp = Builder.a(r3);
        this.mStandard = Builder.b(r3);
        this.mArfcn = Builder.f(r3);
        this.mPci = Builder.g(r3);
        this.mTac = Builder.h(r3);
        this.mCi = Builder.i(r3);
        this.mBands = Builder.j(r3);
        this.mMcc = Builder.k(r3);
        this.mMnc = Builder.l(r3);
        this.mSignalStrength = Builder.m(r3);
        this.mSignalQuality = Builder.c(r3);
        this.mLevel = Builder.d(r3);
        this.mRegistered = Builder.e(r3);
    }
}
