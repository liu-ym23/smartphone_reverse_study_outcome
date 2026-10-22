package com.bytedanceos.appstore.PreloadInstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.tracker.TrackerElement;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class PreLoadAppInfo implements Parcelable {
    public static final Parcelable.Creator<PreLoadAppInfo> CREATOR = null;

    @SerializedName("file_name")
    private String fileName;
    private String filePath;

    @SerializedName(TrackerElement.PACKAGE_NAME)
    private String packageName;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public PreLoadAppInfo a(Parcel r10) {
            return new PreLoadAppInfo(r10);
        }

        public PreLoadAppInfo[] b(int r10) {
            return new PreLoadAppInfo[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public PreLoadAppInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setFileName(String r10) {
        this.fileName = r10;
    }

    public void setFilePath(String r10) {
        this.filePath = r10;
    }

    public void setPackageName(String r10) {
        this.packageName = r10;
    }

    public String toString() {
        return "PreLoadAppInfo{packageName='" + this.packageName + "', fileName='" + this.fileName + "', filePath='" + this.filePath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.packageName);
        r10.writeString(this.fileName);
        r10.writeString(this.filePath);
    }

    public PreLoadAppInfo(Parcel r10) {
        this.packageName = r10.readString();
        this.fileName = r10.readString();
        this.filePath = r10.readString();
    }
}
