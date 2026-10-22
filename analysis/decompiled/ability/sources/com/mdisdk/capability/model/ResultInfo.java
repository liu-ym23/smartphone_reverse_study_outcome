package com.mdisdk.capability.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class ResultInfo implements Parcelable {
    public static final Parcelable.Creator<ResultInfo> CREATOR = new Parcelable.Creator<ResultInfo>() { // from class: com.mdisdk.capability.model.ResultInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultInfo createFromParcel(Parcel parcel) {
            return new ResultInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultInfo[] newArray(int i) {
            return new ResultInfo[i];
        }
    };
    private String function;
    private long requestId;
    private int resultCode;

    @Nullable
    private WindowStateInfo windowStateInfo;

    public ResultInfo(long j5, String str, int i) {
        this.windowStateInfo = null;
        this.requestId = j5;
        this.function = str;
        this.resultCode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String dump() {
        StringBuilder sb = new StringBuilder("requestId: ");
        sb.append(this.requestId);
        sb.append("\nfunction: ");
        sb.append(this.function);
        sb.append("\nresultCode: ");
        sb.append(this.resultCode);
        sb.append("\n");
        if (this.windowStateInfo != null) {
            sb.append("info: ");
            sb.append(this.windowStateInfo);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getFunction() {
        return this.function;
    }

    public long getRequestId() {
        return this.requestId;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    @Nullable
    public WindowStateInfo getWindowStateInfo() {
        return this.windowStateInfo;
    }

    public String toString() {
        return dump();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.requestId);
        parcel.writeString(this.function);
        parcel.writeInt(this.resultCode);
        parcel.writeParcelable(this.windowStateInfo, i);
    }

    public ResultInfo(long j5, String str, int i, WindowStateInfo windowStateInfo) {
        this.requestId = j5;
        this.function = str;
        this.resultCode = i;
        this.windowStateInfo = windowStateInfo;
    }

    public ResultInfo(Parcel parcel) {
        this.windowStateInfo = null;
        this.requestId = parcel.readLong();
        this.function = parcel.readString();
        this.resultCode = parcel.readInt();
        this.windowStateInfo = (WindowStateInfo) parcel.readParcelable(WindowStateInfo.class.getClassLoader());
    }
}
