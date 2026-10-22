package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private double f6515a;

    /* renamed from: b, reason: collision with root package name */
    private double f6516b;
    public final LatLngBounds bound;

    /* renamed from: c, reason: collision with root package name */
    s f6517c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    public static class a implements Parcelable.Creator<MapStatus> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MapStatus createFromParcel(Parcel parcel) {
            return new MapStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MapStatus[] newArray(int i4) {
            return new MapStatus[i4];
        }
    }

    public MapStatus(float f4, LatLng latLng, float f5, float f6, Point point, LatLngBounds latLngBounds) {
        this.rotate = f4;
        this.target = latLng;
        this.overlook = f5;
        this.zoom = f6;
        this.targetScreen = point;
        if (latLng != null) {
            this.f6515a = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.f6516b = CoordUtil.ll2mc(latLng).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public static MapStatus a(s sVar) {
        if (sVar == null) {
            return null;
        }
        float f4 = sVar.f8100b;
        double d4 = sVar.f8103e;
        double d5 = sVar.f8102d;
        LatLng latLngMc2ll = CoordUtil.mc2ll(new GeoPoint(d4, d5));
        float f5 = sVar.f8101c;
        float f6 = sVar.f8099a;
        Point point = new Point(sVar.f8104f, sVar.f8105g);
        LatLng latLngMc2ll2 = CoordUtil.mc2ll(new GeoPoint(sVar.f8109k.f8122e.getDoubleY(), sVar.f8109k.f8122e.getDoubleX()));
        LatLng latLngMc2ll3 = CoordUtil.mc2ll(new GeoPoint(sVar.f8109k.f8123f.getDoubleY(), sVar.f8109k.f8123f.getDoubleX()));
        LatLng latLngMc2ll4 = CoordUtil.mc2ll(new GeoPoint(sVar.f8109k.f8125h.getDoubleY(), sVar.f8109k.f8125h.getDoubleX()));
        LatLng latLngMc2ll5 = CoordUtil.mc2ll(new GeoPoint(sVar.f8109k.f8124g.getDoubleY(), sVar.f8109k.f8124g.getDoubleX()));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLngMc2ll2);
        builder.include(latLngMc2ll3);
        builder.include(latLngMc2ll4);
        builder.include(latLngMc2ll5);
        WinRound winRound = sVar.f8108j;
        LatLngBounds latLngBoundsBuild = builder.build();
        latLngBoundsBuild.setCenter(CoordUtil.mc2ll(new GeoPoint(sVar.f8109k.f8122e.getDoubleY() + ((sVar.f8109k.f8124g.getDoubleY() - sVar.f8109k.f8122e.getDoubleY()) / 2.0d), sVar.f8109k.f8122e.getDoubleX() + ((sVar.f8109k.f8124g.getDoubleX() - sVar.f8109k.f8122e.getDoubleX()) / 2.0d))));
        return new MapStatus(f4, latLngMc2ll, f5, f6, point, sVar, d5, d4, latLngBoundsBuild, winRound);
    }

    public double b() {
        return this.f6515a;
    }

    public double c() {
        return this.f6516b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.target != null) {
            sb.append("target lat: " + this.target.latitude + "\n");
            sb.append("target lng: " + this.target.longitude + "\n");
        }
        if (this.targetScreen != null) {
            sb.append("target screen x: " + this.targetScreen.x + "\n");
            sb.append("target screen y: " + this.targetScreen.y + "\n");
        }
        sb.append("zoom: " + this.zoom + "\n");
        sb.append("rotate: " + this.rotate + "\n");
        sb.append("overlook: " + this.overlook + "\n");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i4);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i4);
        parcel.writeParcelable(this.bound, i4);
        parcel.writeDouble(this.f6515a);
        parcel.writeDouble(this.f6516b);
    }

    public s b(s sVar) {
        if (sVar == null) {
            return null;
        }
        float f4 = this.rotate;
        if (f4 != -2.1474836E9f) {
            sVar.f8100b = (int) f4;
        }
        float f5 = this.zoom;
        if (f5 != -2.1474836E9f) {
            sVar.f8099a = f5;
        }
        float f6 = this.overlook;
        if (f6 != -2.1474836E9f) {
            sVar.f8101c = (int) f6;
        }
        if (this.target != null) {
            sVar.f8102d = this.f6515a;
            sVar.f8103e = this.f6516b;
        }
        Point point = this.targetScreen;
        if (point != null) {
            sVar.f8104f = point.x;
            sVar.f8105g = point.y;
        }
        return sVar;
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private float f6518a;

        /* renamed from: b, reason: collision with root package name */
        private LatLng f6519b;

        /* renamed from: c, reason: collision with root package name */
        private float f6520c;

        /* renamed from: d, reason: collision with root package name */
        private float f6521d;

        /* renamed from: e, reason: collision with root package name */
        private Point f6522e;

        /* renamed from: f, reason: collision with root package name */
        private LatLngBounds f6523f;

        /* renamed from: g, reason: collision with root package name */
        private double f6524g;

        /* renamed from: h, reason: collision with root package name */
        private double f6525h;

        /* renamed from: i, reason: collision with root package name */
        private final float f6526i;

        public Builder() {
            this.f6518a = -2.1474836E9f;
            this.f6519b = null;
            this.f6520c = -2.1474836E9f;
            this.f6521d = -2.1474836E9f;
            this.f6522e = null;
            this.f6523f = null;
            this.f6524g = 0.0d;
            this.f6525h = 0.0d;
            this.f6526i = 15.0f;
        }

        private float a(float f4) {
            if (15.0f == f4) {
                return 15.5f;
            }
            return f4;
        }

        public MapStatus build() {
            return new MapStatus(this.f6518a, this.f6519b, this.f6520c, this.f6521d, this.f6522e, this.f6523f);
        }

        public Builder overlook(float f4) {
            this.f6520c = f4;
            return this;
        }

        public Builder rotate(float f4) {
            this.f6518a = f4;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.f6519b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.f6522e = point;
            return this;
        }

        public Builder zoom(float f4) {
            this.f6521d = a(f4);
            return this;
        }

        public Builder(MapStatus mapStatus) {
            this.f6518a = -2.1474836E9f;
            this.f6519b = null;
            this.f6520c = -2.1474836E9f;
            this.f6521d = -2.1474836E9f;
            this.f6522e = null;
            this.f6523f = null;
            this.f6524g = 0.0d;
            this.f6525h = 0.0d;
            this.f6526i = 15.0f;
            this.f6518a = mapStatus.rotate;
            this.f6519b = mapStatus.target;
            this.f6520c = mapStatus.overlook;
            this.f6521d = mapStatus.zoom;
            this.f6522e = mapStatus.targetScreen;
            this.f6524g = mapStatus.b();
            this.f6525h = mapStatus.c();
        }
    }

    public MapStatus(float f4, LatLng latLng, float f5, float f6, Point point, double d4, double d5, LatLngBounds latLngBounds) {
        this.rotate = f4;
        this.target = latLng;
        this.overlook = f5;
        this.zoom = f6;
        this.targetScreen = point;
        this.f6515a = d4;
        this.f6516b = d5;
        this.bound = latLngBounds;
    }

    public MapStatus(float f4, LatLng latLng, float f5, float f6, Point point, s sVar, double d4, double d5, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f4;
        this.target = latLng;
        this.overlook = f5;
        this.zoom = f6;
        this.targetScreen = point;
        this.f6517c = sVar;
        this.f6515a = d4;
        this.f6516b = d5;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    public MapStatus(Parcel parcel) {
        this.rotate = parcel.readFloat();
        this.target = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.overlook = parcel.readFloat();
        this.zoom = parcel.readFloat();
        this.targetScreen = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        this.f6515a = parcel.readDouble();
        this.f6516b = parcel.readDouble();
    }

    public s a() {
        return b(new s());
    }
}
