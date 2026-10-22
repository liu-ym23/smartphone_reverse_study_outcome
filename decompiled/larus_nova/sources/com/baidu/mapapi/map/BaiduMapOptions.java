package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.q;

/* JADX INFO: loaded from: classes39.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MapStatus f30774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f30775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f30776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f30777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f30778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f30779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f30780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f30781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f30782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    LogoPosition f30783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Point f30784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Point f30785l;

    public static class a implements Parcelable.Creator<BaiduMapOptions> {
        public a() {
        }

        public BaiduMapOptions a(Parcel r100) {
            return new BaiduMapOptions(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BaiduMapOptions createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BaiduMapOptions[] newArray(int r100) {
            return a(r100);
        }

        public BaiduMapOptions[] a(int r100) {
            return new BaiduMapOptions[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public q a() {
        return new q().a(this.f30774a.a()).a(this.f30775b).a(this.f30776c).c(this.f30777d).d(this.f30778e).b(this.f30779f).e(this.f30780g);
    }

    public BaiduMapOptions() {
        this.f30774a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f30775b = false;
        this.f30776c = 1;
        this.f30777d = true;
        this.f30778e = true;
        this.f30779f = true;
        this.f30780g = true;
        this.f30781h = true;
        this.f30782i = true;
    }

    public BaiduMapOptions(Parcel r100) {
        this.f30774a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        boolean r101 = false;
        this.f30775b = false;
        this.f30776c = 1;
        this.f30777d = true;
        this.f30778e = true;
        this.f30779f = true;
        this.f30780g = true;
        this.f30781h = true;
        this.f30782i = true;
        this.f30774a = (MapStatus) r100.readParcelable(MapStatus.class.getClassLoader());
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f30775b = r102;
        this.f30776c = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f30777d = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f30778e = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.f30779f = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.f30780g = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.f30781h = r107;
        if (r100.readByte() == 0) goto L29;
        r101 = true;
    L29:
        this.f30782i = r101;
        this.f30784k = (Point) r100.readParcelable(Point.class.getClassLoader());
        this.f30785l = (Point) r100.readParcelable(Point.class.getClassLoader());
        return;
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public BaiduMapOptions compassEnabled(boolean r100) {
        this.f30775b = r100;
        return this;
    }

    public BaiduMapOptions logoPosition(LogoPosition r100) {
        this.f30783j = r100;
        return this;
    }

    public BaiduMapOptions mapStatus(MapStatus r100) {
        if (r100 == null) goto L4;
        this.f30774a = r100;
    L4:
        return this;
    }

    public BaiduMapOptions mapType(int r100) {
        this.f30776c = r100;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean r100) {
        this.f30779f = r100;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean r100) {
        this.f30777d = r100;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean r100) {
        this.f30782i = r100;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point r100) {
        this.f30784k = r100;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean r100) {
        this.f30778e = r100;
        return this;
    }

    public BaiduMapOptions zoomControlsEnabled(boolean r100) {
        this.f30781h = r100;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point r100) {
        this.f30785l = r100;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean r100) {
        this.f30780g = r100;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f30774a, r101);
        r100.writeByte(this.f30775b ? 1 : 0);
        r100.writeInt(this.f30776c);
        r100.writeByte(this.f30777d ? 1 : 0);
        r100.writeByte(this.f30778e ? 1 : 0);
        r100.writeByte(this.f30779f ? 1 : 0);
        r100.writeByte(this.f30780g ? 1 : 0);
        r100.writeByte(this.f30781h ? 1 : 0);
        r100.writeByte(this.f30782i ? 1 : 0);
        r100.writeParcelable(this.f30784k, r101);
        r100.writeParcelable(this.f30785l, r101);
    }
}
