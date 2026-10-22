package com.stepos.service.find;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class FindPhoneData implements Parcelable {
    public static final Parcelable.Creator<FindPhoneData> CREATOR = new Parcelable.Creator<FindPhoneData>() { // from class: com.stepos.service.find.FindPhoneData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FindPhoneData createFromParcel(Parcel in) {
            return new FindPhoneData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FindPhoneData[] newArray(int size) {
            return new FindPhoneData[size];
        }
    };
    public static final int ERROR_GETUSERNAME_EMPTY_SN = 8;
    public static final int ERROR_NETWORK_UNAVAILABLE = 9;
    public static final int ERROR_UNKNOWN = 0;
    public static final int ERROR_UNLOCKPHONE_ACCOUNT_NO_BIND_SN = 6;
    public static final int ERROR_UNLOCKPHONE_COUNT_LIMIT = 7;
    public static final int ERROR_UNLOCKPHONE_EMPTY_USER_OR_PSW = 5;
    public static final int ERROR_UNLOCKPHONE_WRONG_USER_OR_PSW = 4;
    public static final int INVALID_TOKEN_ERROR = 3;
    public static final int SERVER_ERROR = 2;
    public static final int SUCCESS = 1;
    public int mCode;
    public int mCount;
    public String mData;
    public int mDuration;
    public String mMessage;

    public FindPhoneData() {
    }

    public FindPhoneData(int code, String data, String message) {
        this.mCode = code;
        this.mData = data;
        this.mMessage = message;
    }

    public void setResult(int code, String data, String message) {
        this.mCode = code;
        this.mData = data;
        this.mMessage = message;
    }

    public void setUnlockResult(int count, int duration) {
        this.mCount = count;
        this.mDuration = duration;
    }

    protected FindPhoneData(Parcel in) {
        this.mCode = in.readInt();
        this.mData = in.readString();
        this.mMessage = in.readString();
        this.mDuration = in.readInt();
        this.mCount = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCode);
        dest.writeString(this.mData);
        dest.writeString(this.mMessage);
        dest.writeInt(this.mDuration);
        dest.writeInt(this.mCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FindPhoneData{mCode=" + this.mCode + ", mData='" + this.mData + "', mMessage='" + this.mMessage + "', mDuration=" + this.mDuration + ", mCount=" + this.mCount + '}';
    }
}
