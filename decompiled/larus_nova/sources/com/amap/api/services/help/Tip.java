package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f28963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f28967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28969h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "name:" + this.f28964c + " district:" + this.f28965d + " adcode:" + this.f28966e;
    }

    public Tip() {
        this.f28969h = "";
    }

    public String getAdcode() {
        return this.f28966e;
    }

    public String getAddress() {
        return this.f28967f;
    }

    public String getDistrict() {
        return this.f28965d;
    }

    public String getName() {
        return this.f28964c;
    }

    public String getPoiID() {
        return this.f28962a;
    }

    public LatLonPoint getPoint() {
        return this.f28963b;
    }

    public String getTypeCode() {
        return this.f28968g;
    }

    private Tip(Parcel r100) {
        this.f28969h = "";
        this.f28964c = r100.readString();
        this.f28966e = r100.readString();
        this.f28965d = r100.readString();
        this.f28962a = r100.readString();
        this.f28963b = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28967f = r100.readString();
        this.f28968g = r100.readString();
        this.f28969h = r100.readString();
    }

    public void setAdcode(String r100) {
        this.f28966e = r100;
    }

    public void setAddress(String r100) {
        this.f28967f = r100;
    }

    public void setDistrict(String r100) {
        this.f28965d = r100;
    }

    public void setID(String r100) {
        this.f28962a = r100;
    }

    public void setName(String r100) {
        this.f28964c = r100;
    }

    public void setPostion(LatLonPoint r100) {
        this.f28963b = r100;
    }

    public void setTypeCode(String r100) {
        this.f28968g = r100;
    }

    public /* synthetic */ Tip(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28964c);
        r100.writeString(this.f28966e);
        r100.writeString(this.f28965d);
        r100.writeString(this.f28962a);
        r100.writeValue(this.f28963b);
        r100.writeString(this.f28967f);
        r100.writeString(this.f28968g);
        r100.writeString(this.f28969h);
    }
}
