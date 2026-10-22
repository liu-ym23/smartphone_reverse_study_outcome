package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes28.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f26684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f26685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f26686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f26687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f26688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f26689k;

    static {
        CREATOR = new AnonymousClass1();
    }

    public PoiItem() {
        this.f26679a = "";
        this.f26680b = "";
        this.f26681c = "";
        this.f26682d = "";
        this.f26683e = "";
        this.f26684f = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26685g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26686h = "";
        this.f26687i = "";
        this.f26688j = "";
        this.f26689k = "";
    }

    public PoiItem(Parcel r100) {
        this.f26679a = "";
        this.f26680b = "";
        this.f26681c = "";
        this.f26682d = "";
        this.f26683e = "";
        this.f26684f = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26685g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26686h = "";
        this.f26687i = "";
        this.f26688j = "";
        this.f26689k = "";
        this.f26679a = r100.readString();
        this.f26680b = r100.readString();
        this.f26681c = r100.readString();
        this.f26682d = r100.readString();
        this.f26683e = r100.readString();
        this.f26684f = r100.readDouble();
        this.f26685g = r100.readDouble();
        this.f26686h = r100.readString();
        this.f26687i = r100.readString();
        this.f26688j = r100.readString();
        this.f26689k = r100.readString();
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f26683e;
    }

    public String getAdname() {
        return this.f26689k;
    }

    public String getCity() {
        return this.f26688j;
    }

    public double getLatitude() {
        return this.f26684f;
    }

    public double getLongitude() {
        return this.f26685g;
    }

    public String getPoiId() {
        return this.f26680b;
    }

    public String getPoiName() {
        return this.f26679a;
    }

    public String getPoiType() {
        return this.f26681c;
    }

    public String getProvince() {
        return this.f26687i;
    }

    public String getTel() {
        return this.f26686h;
    }

    public String getTypeCode() {
        return this.f26682d;
    }

    public void setAddress(String r100) {
        this.f26683e = r100;
    }

    public void setAdname(String r100) {
        this.f26689k = r100;
    }

    public void setCity(String r100) {
        this.f26688j = r100;
    }

    public void setLatitude(double r100) {
        this.f26684f = r100;
    }

    public void setLongitude(double r100) {
        this.f26685g = r100;
    }

    public void setPoiId(String r100) {
        this.f26680b = r100;
    }

    public void setPoiName(String r100) {
        this.f26679a = r100;
    }

    public void setPoiType(String r100) {
        this.f26681c = r100;
    }

    public void setProvince(String r100) {
        this.f26687i = r100;
    }

    public void setTel(String r100) {
        this.f26686h = r100;
    }

    public void setTypeCode(String r100) {
        this.f26682d = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f26679a);
        r100.writeString(this.f26680b);
        r100.writeString(this.f26681c);
        r100.writeString(this.f26682d);
        r100.writeString(this.f26683e);
        r100.writeDouble(this.f26684f);
        r100.writeDouble(this.f26685g);
        r100.writeString(this.f26686h);
        r100.writeString(this.f26687i);
        r100.writeString(this.f26688j);
        r100.writeString(this.f26689k);
    }
}
