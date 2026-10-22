package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import f2.C0702g;

/* loaded from: classes.dex */
public class DataToken implements Parcelable {
    public static final Parcelable.Creator<DataToken> CREATOR = new a();
    public static final int INVALID_ALPHA_ME_CLOSED = -3;
    public static final int INVALID_DATA_ERROR = -2;
    public static final int INVALID_DIGITAL_WELLBEING_CLOSED = -4;
    public static final int INVALID_NO_PERMISSION = -1;
    public static final int VALID = 0;
    private int mInvalidType;
    private int mToken;
    private int mType;
    private long mUpdateTime;

    class a implements Parcelable.Creator<DataToken> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataToken createFromParcel(Parcel parcel) {
            return new DataToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DataToken[] newArray(int i5) {
            return new DataToken[i5];
        }
    }

    public DataToken(int i5, long j5, int i6, int i7) {
        this.mUpdateTime = j5;
        this.mType = i5;
        this.mToken = i6;
        this.mInvalidType = i7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getInvalidType() {
        return this.mInvalidType;
    }

    public int getToken() {
        return this.mToken;
    }

    public int getType() {
        return this.mType;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public boolean isValid() {
        return this.mInvalidType == 0;
    }

    public final void readFromParcel(Parcel parcel) {
        this.mUpdateTime = parcel.readLong();
        this.mType = parcel.readInt();
        this.mToken = parcel.readInt();
        this.mInvalidType = parcel.readInt();
    }

    public void setInvalidType(int i5) {
        this.mInvalidType = i5;
    }

    public void setType(int i5) {
        this.mType = i5;
    }

    public void setUpdateTime(long j5) {
        this.mUpdateTime = j5;
    }

    public String toString() {
        return "DataToken{mUpdateTime=" + C0702g.t(this.mUpdateTime, true) + ", mType=" + this.mType + ", mInvalidType=" + this.mInvalidType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.mUpdateTime);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mToken);
        parcel.writeInt(this.mInvalidType);
    }

    public DataToken(int i5, long j5, int i6) {
        this(i5, j5, i6, 0);
    }

    protected DataToken(Parcel parcel) {
        this.mInvalidType = -1;
        readFromParcel(parcel);
    }
}
