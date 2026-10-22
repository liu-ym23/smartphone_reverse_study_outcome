package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class InfoWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f30991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BitmapDescriptor f30992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f30993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    LatLng f30994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f30995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f30996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f30997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    OnInfoWindowClickListener f30998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    a f30999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f31000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f31001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f31002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f31003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f31004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f31005o;

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public interface a {
        void a(InfoWindow r100);

        void b(InfoWindow r100);
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.f30992b;
    }

    public LatLng getPosition() {
        return this.f30994d;
    }

    public String getTag() {
        return this.f30991a;
    }

    public View getView() {
        return this.f30993c;
    }

    public int getYOffset() {
        return this.f31000j;
    }

    public void setBitmapDescriptor(BitmapDescriptor r100) {
        if (r100 == null) goto L8;
        a r101 = this.f30999i;
        if (r101 == null) goto L9;
        this.f30992b = r100;
        r101.b(this);
        return;
    L9:
        return;
    }

    public void setPosition(LatLng r100) {
        if (r100 == null) goto L8;
        a r101 = this.f30999i;
        if (r101 == null) goto L9;
        this.f30994d = r100;
        r101.b(this);
        return;
    L9:
        return;
    }

    public void setTag(String r100) {
        this.f30991a = r100;
    }

    public void setView(View r100) {
        if (r100 == null) goto L8;
        a r101 = this.f30999i;
        if (r101 == null) goto L9;
        this.f30993c = r100;
        r101.b(this);
        return;
    L9:
        return;
    }

    public void setYOffset(int r100) {
        a r101 = this.f30999i;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f31000j = r100;
        r101.b(this);
    }

    public void setScreenPosition(int r100, int r101) {
        this.f30995e = true;
        this.f30996f = r100;
        this.f30997g = r101;
    }

    public InfoWindow(View r100, LatLng r101, int r102) {
        this.f30991a = "";
        this.f30995e = false;
        this.f31001k = false;
        this.f31002l = SysOSUtil.getDensityDpi();
        this.f31003m = false;
        this.f31004n = false;
        this.f31005o = false;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        this.f30993c = r100;
        this.f30994d = r101;
        this.f31000j = r102;
        this.f31004n = true;
        return;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }

    public InfoWindow(BitmapDescriptor r100, LatLng r101, int r102, OnInfoWindowClickListener r103) {
        this.f30991a = "";
        this.f30995e = false;
        this.f31001k = false;
        this.f31002l = SysOSUtil.getDensityDpi();
        this.f31003m = false;
        this.f31004n = false;
        this.f31005o = false;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        this.f30992b = r100;
        this.f30994d = r101;
        this.f30998h = r103;
        this.f31000j = r102;
        this.f31005o = true;
        return;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
    }

    public InfoWindow(View r100, LatLng r101, int r102, boolean r103, int r104) {
        this.f30991a = "";
        this.f30995e = false;
        this.f31001k = false;
        this.f31002l = SysOSUtil.getDensityDpi();
        this.f31003m = false;
        this.f31004n = false;
        this.f31005o = false;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        this.f30993c = r100;
        this.f30994d = r101;
        this.f31000j = r102;
        this.f31001k = r103;
        this.f31002l = r104;
        this.f31004n = true;
        return;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }
}
