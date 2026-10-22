package com.obric.memorydata.sdk.entity.search.userprofile;

import android.os.Parcel;
import android.os.Parcelable;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: UserProfileMemoryResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UserProfileMemoryResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final int errorCode;
    private final String errorMsg;
    private final String profileValue;

    /* JADX INFO: compiled from: UserProfileMemoryResult.kt */
    public static final class CREATOR implements Parcelable.Creator<UserProfileMemoryResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UserProfileMemoryResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UserProfileMemoryResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfileMemoryResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new UserProfileMemoryResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfileMemoryResult[] newArray(int r1) {
            return new UserProfileMemoryResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserProfileMemoryResult(int r1, String r2, String r3) {
        this.errorCode = r1;
        this.errorMsg = r2;
        this.profileValue = r3;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getProfileValue() {
        return this.profileValue;
    }

    public final boolean isSuccess() {
        if (this.errorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public UserProfileMemoryResult(Parcel r3) {
        o.e(r3, "parcel");
        this(r3.readInt(), r3.readString(), r3.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeInt(this.errorCode);
        r1.writeString(this.errorMsg);
        r1.writeString(this.profileValue);
    }
}
