package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class BuildingInfo implements Parcelable {
    public static final Parcelable.Creator<BuildingInfo> CREATOR = null;
    private int accuracy;
    private LatLng center;
    private String geom;
    private float height;
    private int label;
    private String structId;

    public static class a implements Parcelable.Creator<BuildingInfo> {
        public a() {
        }

        public BuildingInfo a(Parcel r100) {
            return new BuildingInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BuildingInfo createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BuildingInfo[] newArray(int r100) {
            return a(r100);
        }

        public BuildingInfo[] a(int r100) {
            return new BuildingInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("BuidingInfo: \n; height = ");
        r100.append(this.height);
        r100.append("; accuracy = ");
        r100.append(this.accuracy);
        r100.append("; geom = ");
        r100.append(this.geom);
        r100.append("; center = ");
        r100.append(this.center);
        return r100.toString();
    }

    public BuildingInfo() {
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public LatLng getCenter() {
        return this.center;
    }

    public String getGeom() {
        return this.geom;
    }

    public float getHeight() {
        return this.height;
    }

    public int getLabel() {
        return this.label;
    }

    public String getStructID() {
        return this.structId;
    }

    public BuildingInfo(Parcel r100) {
        this.height = r100.readFloat();
        this.accuracy = r100.readInt();
        this.geom = r100.readString();
        this.center = (LatLng) r100.readValue(LatLng.class.getClassLoader());
    }

    public void setAccuracy(int r100) {
        this.accuracy = r100;
    }

    public void setCenter(LatLng r100) {
        this.center = r100;
    }

    public void setGeom(String r100) {
        this.geom = r100;
    }

    public void setHeight(float r100) {
        this.height = r100;
    }

    public void setLabel(int r100) {
        this.label = r100;
    }

    public void setStructID(String r100) {
        this.structId = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.height);
        r100.writeInt(this.accuracy);
        r100.writeString(this.geom);
        r100.writeValue(this.center);
    }
}
