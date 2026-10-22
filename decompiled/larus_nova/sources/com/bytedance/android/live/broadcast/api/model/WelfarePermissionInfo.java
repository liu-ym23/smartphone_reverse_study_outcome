package com.bytedance.android.live.broadcast.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class WelfarePermissionInfo implements Parcelable {
    public static final Parcelable.Creator<WelfarePermissionInfo> CREATOR = null;

    @SerializedName("available")
    public boolean available;

    @SerializedName("setting_page_url")
    public String settingPageUrl;

    public class a implements Parcelable.Creator<WelfarePermissionInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WelfarePermissionInfo createFromParcel(Parcel r100) {
            return new WelfarePermissionInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WelfarePermissionInfo[] newArray(int r100) {
            return new WelfarePermissionInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WelfarePermissionInfo() {
    }

    public WelfarePermissionInfo(Parcel r100) {
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.available = r101;
        this.settingPageUrl = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.available ? 1 : 0);
        r100.writeString(this.settingPageUrl);
    }
}
