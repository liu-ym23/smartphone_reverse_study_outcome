package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: loaded from: classes39.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f31030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f31031b;
    public final LatLngBounds bound;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    s f31032c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f31033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LatLng f31034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f31035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f31036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Point f31037e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private LatLngBounds f31038f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private double f31039g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private double f31040h;

        public MapStatus build() {
            return new MapStatus(this.f31033a, this.f31034b, this.f31035c, this.f31036d, this.f31037e, this.f31038f);
        }

        public Builder() {
            this.f31033a = -2.1474836E9f;
            this.f31034b = null;
            this.f31035c = -2.1474836E9f;
            this.f31036d = -2.1474836E9f;
            this.f31037e = null;
            this.f31038f = null;
            this.f31039g = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f31040h = AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        public Builder(MapStatus r100) {
            this.f31033a = -2.1474836E9f;
            this.f31034b = null;
            this.f31035c = -2.1474836E9f;
            this.f31036d = -2.1474836E9f;
            this.f31037e = null;
            this.f31038f = null;
            this.f31039g = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f31040h = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f31033a = r100.rotate;
            this.f31034b = r100.target;
            this.f31035c = r100.overlook;
            this.f31036d = r100.zoom;
            this.f31037e = r100.targetScreen;
            this.f31039g = r100.b();
            this.f31040h = r100.c();
        }

        public Builder overlook(float r100) {
            this.f31035c = r100;
            return this;
        }

        public Builder rotate(float r100) {
            this.f31033a = r100;
            return this;
        }

        public Builder target(LatLng r100) {
            this.f31034b = r100;
            return this;
        }

        public Builder targetScreen(Point r100) {
            this.f31037e = r100;
            return this;
        }

        public Builder zoom(float r100) {
            this.f31036d = r100;
            return this;
        }
    }

    public static class a implements Parcelable.Creator<MapStatus> {
        public a() {
        }

        public MapStatus a(Parcel r100) {
            return new MapStatus(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapStatus createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapStatus[] newArray(int r100) {
            return a(r100);
        }

        public MapStatus[] a(int r100) {
            return new MapStatus[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public s a() {
        return b(new s());
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.target == null) goto L6;
        r100.append("target lat: " + this.target.latitude + "\n");
        r100.append("target lng: " + this.target.longitude + "\n");
    L6:
        if (this.targetScreen == null) goto L8;
        r100.append("target screen x: " + this.targetScreen.x + "\n");
        r100.append("target screen y: " + this.targetScreen.y + "\n");
    L8:
        r100.append("zoom: " + this.zoom + "\n");
        r100.append("rotate: " + this.rotate + "\n");
        r100.append("overlook: " + this.overlook + "\n");
        return r100.toString();
    }

    public double b() {
        return this.f31030a;
    }

    public double c() {
        return this.f31031b;
    }

    public MapStatus(Parcel r100) {
        this.rotate = r100.readFloat();
        this.target = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());
        this.overlook = r100.readFloat();
        this.zoom = r100.readFloat();
        this.targetScreen = (Point) r100.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) r100.readParcelable(LatLngBounds.class.getClassLoader());
        this.f31030a = r100.readDouble();
        this.f31031b = r100.readDouble();
    }

    public static MapStatus a(s r210) {
        if (r210 != null) goto L6;
        return null;
    L6:
        float r100 = r210.f32201b;
        double r101 = r210.f32204e;
        double r102 = r210.f32203d;
        LatLng r103 = CoordUtil.mc2ll(new GeoPoint(r101, r102));
        float r104 = r210.f32202c;
        float r105 = r210.f32200a;
        Point r106 = new Point(r210.f32205f, r210.f32206g);
        LatLng r107 = CoordUtil.mc2ll(new GeoPoint(r210.f32210k.f32223e.getDoubleY(), r210.f32210k.f32223e.getDoubleX()));
        LatLng r110 = CoordUtil.mc2ll(new GeoPoint(r210.f32210k.f32224f.getDoubleY(), r210.f32210k.f32224f.getDoubleX()));
        LatLng r108 = CoordUtil.mc2ll(new GeoPoint(r210.f32210k.f32226h.getDoubleY(), r210.f32210k.f32226h.getDoubleX()));
        LatLng r111 = CoordUtil.mc2ll(new GeoPoint(r210.f32210k.f32225g.getDoubleY(), r210.f32210k.f32225g.getDoubleX()));
        LatLngBounds.Builder r112 = new LatLngBounds.Builder();
        r112.include(r107);
        r112.include(r110);
        r112.include(r108);
        r112.include(r111);
        WinRound r113 = r210.f32209j;
        LatLngBounds r114 = r112.build();
        r114.setCenter(CoordUtil.mc2ll(new GeoPoint(((r210.f32210k.f32225g.getDoubleY() - r210.f32210k.f32223e.getDoubleY()) / 2.0d) + r210.f32210k.f32223e.getDoubleY(), ((r210.f32210k.f32225g.getDoubleX() - r210.f32210k.f32223e.getDoubleX()) / 2.0d) + r210.f32210k.f32223e.getDoubleX())));
        return new MapStatus(r100, r103, r104, r105, r106, r210, r102, r101, r114, r113);
    }

    public s b(s r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        float r101 = this.rotate;
        if (r101 == (-2.1474836E9f)) goto L8;
        r100.f32201b = (int) r101;
    L8:
        float r102 = this.zoom;
        if (r102 == (-2.1474836E9f)) goto L11;
        r100.f32200a = r102;
    L11:
        float r103 = this.overlook;
        if (r103 == (-2.1474836E9f)) goto L15;
        r100.f32202c = (int) r103;
    L15:
        if (this.target == null) goto L17;
        r100.f32203d = this.f31030a;
        r100.f32204e = this.f31031b;
    L17:
        Point r104 = this.targetScreen;
        if (r104 == null) goto L20;
        r100.f32205f = r104.x;
        r100.f32206g = r104.y;
    L20:
        return r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.rotate);
        r100.writeParcelable(this.target, r101);
        r100.writeFloat(this.overlook);
        r100.writeFloat(this.zoom);
        r100.writeParcelable(this.targetScreen, r101);
        r100.writeParcelable(this.bound, r101);
        r100.writeDouble(this.f31030a);
        r100.writeDouble(this.f31031b);
    }

    public MapStatus(float r100, LatLng r101, float r102, float r103, Point r104, LatLngBounds r105) {
        this.rotate = r100;
        this.target = r101;
        this.overlook = r102;
        this.zoom = r103;
        this.targetScreen = r104;
        if (r101 == null) goto L5;
        this.f31030a = CoordUtil.ll2mc(r101).getLongitudeE6();
        this.f31031b = CoordUtil.ll2mc(r101).getLatitudeE6();
    L5:
        this.bound = r105;
    }

    public MapStatus(float r100, LatLng r101, float r102, float r103, Point r104, double r105, double r106, LatLngBounds r110) {
        this.rotate = r100;
        this.target = r101;
        this.overlook = r102;
        this.zoom = r103;
        this.targetScreen = r104;
        this.f31030a = r105;
        this.f31031b = r106;
        this.bound = r110;
    }

    public MapStatus(float r100, LatLng r101, float r102, float r103, Point r104, s r105, double r106, double r107, LatLngBounds r110, WinRound r111) {
        this.rotate = r100;
        this.target = r101;
        this.overlook = r102;
        this.zoom = r103;
        this.targetScreen = r104;
        this.f31032c = r105;
        this.f31030a = r106;
        this.f31031b = r107;
        this.bound = r110;
        this.winRound = r111;
    }
}
