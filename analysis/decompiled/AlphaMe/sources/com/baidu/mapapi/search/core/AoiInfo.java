package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AoiInfo implements Parcelable {
    public static final Parcelable.Creator<AoiInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7260a;

    /* renamed from: b, reason: collision with root package name */
    private String f7261b;

    /* renamed from: c, reason: collision with root package name */
    private String f7262c;

    /* renamed from: d, reason: collision with root package name */
    private AoiType f7263d;

    /* renamed from: e, reason: collision with root package name */
    private int f7264e;

    /* renamed from: f, reason: collision with root package name */
    private int f7265f;

    /* renamed from: g, reason: collision with root package name */
    private int f7266g;

    public enum AoiType {
        AOI_TYPE_UNKNOWN(0),
        AOI_TYPE_AIRPORT(1),
        AOI_TYPE_RAILWAT_STATION(2),
        AOI_TYPE_SHOPPINGMALL(3),
        AOI_TYPE_GAS_STATION(4),
        AOI_TYPE_SCHOOL(5),
        AOI_TYPE_HOSPITAL(6),
        AOI_TYPE_RESIDENTIAL_DISTRICT(7),
        AOI_TYPE_SCENIC_AREA(8),
        AOI_TYPE_PARK(9),
        AOI_TYPE_FREEWAY_SERVICE(10),
        AOI_TYPE_WATER(11);


        /* renamed from: b, reason: collision with root package name */
        private final int f7268b;

        AoiType(int i4) {
            this.f7268b = i4;
        }

        public int toInt() {
            return this.f7268b;
        }

        public static AoiType valueOf(int i4) {
            switch (i4) {
                case 1:
                    return AOI_TYPE_AIRPORT;
                case 2:
                    return AOI_TYPE_RAILWAT_STATION;
                case 3:
                    return AOI_TYPE_SHOPPINGMALL;
                case 4:
                    return AOI_TYPE_GAS_STATION;
                case 5:
                    return AOI_TYPE_SCHOOL;
                case 6:
                    return AOI_TYPE_HOSPITAL;
                case 7:
                    return AOI_TYPE_RESIDENTIAL_DISTRICT;
                case 8:
                    return AOI_TYPE_SCENIC_AREA;
                case 9:
                    return AOI_TYPE_PARK;
                case 10:
                    return AOI_TYPE_FREEWAY_SERVICE;
                case 11:
                    return AOI_TYPE_WATER;
                default:
                    return AOI_TYPE_UNKNOWN;
            }
        }
    }

    public static class a implements Parcelable.Creator<AoiInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiInfo createFromParcel(Parcel parcel) {
            return new AoiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiInfo[] newArray(int i4) {
            return new AoiInfo[i4];
        }
    }

    public AoiInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAoiName() {
        return this.f7261b;
    }

    public AoiType getAoiType() {
        return this.f7263d;
    }

    public int getNearestDistance() {
        return this.f7264e;
    }

    public int getOrder() {
        return this.f7265f;
    }

    public String getPolygon() {
        return this.f7262c;
    }

    public int getRelation() {
        return this.f7266g;
    }

    public String getUid() {
        return this.f7260a;
    }

    public void setAoiName(String str) {
        this.f7261b = str;
    }

    public void setAoiType(AoiType aoiType) {
        this.f7263d = aoiType;
    }

    public void setNearestDistance(int i4) {
        this.f7264e = i4;
    }

    public void setOrder(int i4) {
        this.f7265f = i4;
    }

    public void setPolygon(String str) {
        this.f7262c = str;
    }

    public void setRelation(int i4) {
        this.f7266g = i4;
    }

    public void setUid(String str) {
        this.f7260a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiInfo: \n; uid = ");
        stringBuffer.append(this.f7260a);
        stringBuffer.append("; polygon = ");
        stringBuffer.append(this.f7262c);
        stringBuffer.append("; aoiName = ");
        stringBuffer.append(this.f7261b);
        stringBuffer.append("; aoiType = ");
        stringBuffer.append(this.f7263d);
        stringBuffer.append("; nearestDistance= ");
        stringBuffer.append(this.f7264e);
        stringBuffer.append("; order= ");
        stringBuffer.append(this.f7265f);
        stringBuffer.append("; relation= ");
        stringBuffer.append(this.f7266g);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7260a);
        parcel.writeString(this.f7262c);
        parcel.writeString(this.f7261b);
        parcel.writeInt(this.f7263d.ordinal());
        parcel.writeInt(this.f7264e);
        parcel.writeInt(this.f7265f);
        parcel.writeInt(this.f7266g);
    }

    public AoiInfo(Parcel parcel) {
        this.f7262c = parcel.readString();
        this.f7261b = parcel.readString();
    }
}
