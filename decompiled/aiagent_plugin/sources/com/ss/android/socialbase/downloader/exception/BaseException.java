package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes4.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = null;
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;
    private String extraInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaseException() {
        this.extraInfo = "";
    }

    public BaseException(int r3, String r4) {
        super(TAG + r4);
        this.extraInfo = "";
        this.errorMsg = TAG + r4;
        this.errorCode = r3;
    }

    public void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public BaseException(int r1, Throwable r2) {
        this(r1, DownloadUtils.getThrowableMsg(r2));
    }

    public BaseException(int r3, String r4, Throwable r5) {
        super(TAG + r4, r5);
        this.extraInfo = "";
        this.errorMsg = TAG + r4;
        this.errorCode = r3;
    }

    public BaseException(Parcel r2) {
        this.extraInfo = "";
        readFromParcel(r2);
    }

    public void readFromParcel(Parcel r2) {
        this.errorCode = r2.readInt();
        this.errorMsg = r2.readString();
        this.extraInfo = r2.readString();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(String r1) {
        this.extraInfo = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.errorCode);
        r1.writeString(this.errorMsg);
        r1.writeString(this.extraInfo);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }
}
