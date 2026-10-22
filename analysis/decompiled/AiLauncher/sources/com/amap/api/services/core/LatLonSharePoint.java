package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private String f17343c;

    public static class a implements Parcelable.Creator<LatLonSharePoint> {
        @Override // android.os.Parcelable.Creator
        public LatLonSharePoint createFromParcel(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LatLonSharePoint[] newArray(int i10) {
            return new LatLonSharePoint[i10];
        }
    }

    public LatLonSharePoint(double d10, double d11, String str) {
        super(d10, d11);
        this.f17343c = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f17343c;
        if (str == null) {
            if (latLonSharePoint.f17343c != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f17343c)) {
            return false;
        }
        return true;
    }

    public String getSharePointName() {
        return this.f17343c;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f17343c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public void setSharePointName(String str) {
        this.f17343c = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + Const.STR_MART_COMMA + this.f17343c;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f17343c);
    }

    public LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f17343c = parcel.readString();
    }
}
