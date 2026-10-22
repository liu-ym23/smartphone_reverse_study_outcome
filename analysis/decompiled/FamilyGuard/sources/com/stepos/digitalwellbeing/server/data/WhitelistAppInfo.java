package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WhitelistAppInfo implements Parcelable {
    public static final Parcelable.Creator<WhitelistAppInfo> CREATOR = new a();
    private long mAdminId;
    private String mPackageName;
    private boolean mRemovable;

    class a implements Parcelable.Creator<WhitelistAppInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WhitelistAppInfo createFromParcel(Parcel parcel) {
            return new WhitelistAppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WhitelistAppInfo[] newArray(int i5) {
            return new WhitelistAppInfo[i5];
        }
    }

    public WhitelistAppInfo(String str, long j5, boolean z5) {
        this.mPackageName = str;
        this.mAdminId = j5;
        this.mRemovable = z5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAdminId() {
        return this.mAdminId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean isRemovable() {
        return this.mRemovable;
    }

    public void setAdminId(long j5) {
        this.mAdminId = j5;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setRemovable(boolean z5) {
        this.mRemovable = z5;
    }

    public String toString() {
        return "WhitelistAppInfo{mPackageName='" + this.mPackageName + "', mAdminId=" + this.mAdminId + ", mRemovable=" + this.mRemovable + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.mPackageName);
        parcel.writeLong(this.mAdminId);
        parcel.writeByte(this.mRemovable ? (byte) 1 : (byte) 0);
    }

    protected WhitelistAppInfo(Parcel parcel) {
        this.mPackageName = parcel.readString();
        this.mAdminId = parcel.readLong();
        this.mRemovable = parcel.readByte() != 0;
    }
}
