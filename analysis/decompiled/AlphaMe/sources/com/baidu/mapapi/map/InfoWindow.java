package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class InfoWindow {

    /* renamed from: a, reason: collision with root package name */
    String f6476a;

    /* renamed from: b, reason: collision with root package name */
    BitmapDescriptor f6477b;

    /* renamed from: c, reason: collision with root package name */
    View f6478c;

    /* renamed from: d, reason: collision with root package name */
    LatLng f6479d;

    /* renamed from: e, reason: collision with root package name */
    boolean f6480e;

    /* renamed from: f, reason: collision with root package name */
    int f6481f;

    /* renamed from: g, reason: collision with root package name */
    int f6482g;

    /* renamed from: h, reason: collision with root package name */
    OnInfoWindowClickListener f6483h;

    /* renamed from: i, reason: collision with root package name */
    a f6484i;

    /* renamed from: j, reason: collision with root package name */
    int f6485j;

    /* renamed from: k, reason: collision with root package name */
    boolean f6486k;

    /* renamed from: l, reason: collision with root package name */
    int f6487l;

    /* renamed from: m, reason: collision with root package name */
    boolean f6488m;

    /* renamed from: n, reason: collision with root package name */
    boolean f6489n;

    /* renamed from: o, reason: collision with root package name */
    boolean f6490o;

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view, LatLng latLng, int i4) {
        this.f6476a = "";
        this.f6480e = false;
        this.f6486k = false;
        this.f6487l = SysOSUtil.getDensityDpi();
        this.f6488m = false;
        this.f6489n = false;
        this.f6490o = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6478c = view;
        this.f6479d = latLng;
        this.f6485j = i4;
        this.f6489n = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.f6477b;
    }

    public LatLng getPosition() {
        return this.f6479d;
    }

    public String getTag() {
        return this.f6476a;
    }

    public View getView() {
        return this.f6478c;
    }

    public int getYOffset() {
        return this.f6485j;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        a aVar;
        if (bitmapDescriptor == null || (aVar = this.f6484i) == null) {
            return;
        }
        this.f6477b = bitmapDescriptor;
        aVar.b(this);
    }

    public void setPosition(LatLng latLng) {
        a aVar;
        if (latLng == null || (aVar = this.f6484i) == null) {
            return;
        }
        this.f6479d = latLng;
        aVar.b(this);
    }

    public void setScreenPosition(int i4, int i5) {
        this.f6480e = true;
        this.f6481f = i4;
        this.f6482g = i5;
    }

    public void setTag(String str) {
        this.f6476a = str;
    }

    public void setView(View view) {
        a aVar;
        if (view == null || (aVar = this.f6484i) == null) {
            return;
        }
        this.f6478c = view;
        aVar.b(this);
    }

    public void setYOffset(int i4) {
        a aVar = this.f6484i;
        if (aVar == null) {
            return;
        }
        this.f6485j = i4;
        aVar.b(this);
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i4, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f6476a = "";
        this.f6480e = false;
        this.f6486k = false;
        this.f6487l = SysOSUtil.getDensityDpi();
        this.f6488m = false;
        this.f6489n = false;
        this.f6490o = false;
        if (bitmapDescriptor != null && latLng != null) {
            this.f6477b = bitmapDescriptor;
            this.f6479d = latLng;
            this.f6483h = onInfoWindowClickListener;
            this.f6485j = i4;
            this.f6490o = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
    }

    public InfoWindow(View view, LatLng latLng, int i4, boolean z4, int i5) {
        this.f6476a = "";
        this.f6480e = false;
        this.f6486k = false;
        this.f6487l = SysOSUtil.getDensityDpi();
        this.f6488m = false;
        this.f6489n = false;
        this.f6490o = false;
        if (view != null && latLng != null) {
            this.f6478c = view;
            this.f6479d = latLng;
            this.f6485j = i4;
            this.f6486k = z4;
            this.f6487l = i5;
            this.f6489n = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }
}
