package com.bytedanceos.common.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class WebParam implements Parcelable {
    public static final Parcelable.Creator<WebParam> CREATOR = null;
    private String adDsp;
    private String adExtra;
    private String appName;
    private String pkg;
    private String title;

    static {
        CREATOR = new AnonymousClass1();
    }

    public WebParam() {
        this.title = "";
        this.pkg = "";
        this.adExtra = "";
        this.adDsp = "";
        this.appName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdDsp() {
        return this.adDsp;
    }

    public String getAdExtra() {
        return this.adExtra;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdDsp(String r10) {
        this.adDsp = r10;
    }

    public void setAdExtra(String r10) {
        this.adExtra = r10;
    }

    public void setAppName(String r10) {
        this.appName = r10;
    }

    public void setPkg(String r10) {
        this.pkg = r10;
    }

    public void setTitle(String r10) {
        this.title = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.title);
        r10.writeString(this.pkg);
        r10.writeString(this.adExtra);
        r10.writeString(this.adDsp);
        r10.writeString(this.appName);
    }

    public WebParam(Parcel r10) {
        this.title = "";
        this.pkg = "";
        this.adExtra = "";
        this.adDsp = "";
        this.appName = "";
        this.title = r10.readString();
        this.pkg = r10.readString();
        this.adExtra = r10.readString();
        this.adDsp = r10.readString();
        this.appName = r10.readString();
    }
}
