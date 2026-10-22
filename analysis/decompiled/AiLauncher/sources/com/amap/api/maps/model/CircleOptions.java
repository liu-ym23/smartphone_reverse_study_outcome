package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1570k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    PolygonOptions f17223a;

    /* renamed from: b, reason: collision with root package name */
    String f17224b;
    private LatLng point;
    private double radius;

    public static class a implements Parcelable.Creator<CircleOptions> {
        @Override // android.os.Parcelable.Creator
        public CircleOptions createFromParcel(Parcel parcel) {
            return new CircleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CircleOptions[] newArray(int i10) {
            return new CircleOptions[i10];
        }
    }

    public CircleOptions() {
        this.point = null;
        this.radius = 0.0d;
        ArrayList arrayList = new ArrayList();
        PolygonOptions polygonOptions = new PolygonOptions();
        this.f17223a = polygonOptions;
        polygonOptions.addAll(arrayList);
    }

    private void a() {
        ArrayList arrayList = new ArrayList();
        LatLng latLng = this.point;
        if (latLng != null) {
            double d10 = this.radius;
            if (d10 != 0.0d) {
                C1570k.k(arrayList, latLng, d10);
            }
        }
        this.f17223a.setPoints(arrayList);
    }

    public CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.f17223a.addHoles(baseHoleOptionsArr);
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        this.point = latLng;
        a();
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i10) {
        this.f17223a.fillColor(i10);
        return this;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public int getFillColor() {
        return this.f17223a.getFillColor();
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.f17223a.getHoleOptions();
    }

    public double getRadius() {
        return this.radius;
    }

    public int getStrokeColor() {
        return this.f17223a.getStrokeColor();
    }

    public float getStrokeWidth() {
        return this.f17223a.getStrokeWidth();
    }

    public float getZIndex() {
        return this.f17223a.getZIndex();
    }

    public boolean isVisible() {
        return this.f17223a.isVisible();
    }

    public CircleOptions radius(double d10) {
        this.radius = d10;
        a();
        return this;
    }

    public CircleOptions strokeColor(int i10) {
        this.f17223a.strokeColor(i10);
        return this;
    }

    public CircleOptions strokeWidth(float f10) {
        this.f17223a.strokeWidth(f10);
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public String toJson() {
        return this.f17223a.toJson();
    }

    public CircleOptions visible(boolean z10) {
        this.f17223a.visible(z10);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        this.f17223a.writeToParcel(parcel, i10);
    }

    public CircleOptions zIndex(float f10) {
        this.f17223a.zIndex(f10);
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CircleOptions m12clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f17224b = this.f17224b;
        circleOptions.point = this.point;
        circleOptions.radius = this.radius;
        circleOptions.f17223a = this.f17223a.m15clone();
        return circleOptions;
    }

    public CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                this.f17223a.addHoles(iterable);
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public CircleOptions(Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        this.f17223a = (PolygonOptions) parcel.readParcelable(PolygonOptions.class.getClassLoader());
        this.point = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.radius = parcel.readDouble();
        this.f17224b = parcel.readString();
    }
}
