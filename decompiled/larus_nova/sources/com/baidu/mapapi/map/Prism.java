package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class Prism extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f31311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f31312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<LatLng> f31314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    BmGeoElement f31315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f31316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f31317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    BitmapDescriptor f31318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    BmPrism f31319o;

    public static final enum AnimateType extends Enum<AnimateType> {
        public static final AnimateType AnimateFast = null;
        public static final AnimateType AnimateNormal = null;
        public static final AnimateType AnimateSlow = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AnimateType[] f31320a = null;

        static {
            AnimateType r100 = new AnimateType("AnimateSlow", 0);
            AnimateSlow = r100;
            AnimateType r101 = new AnimateType("AnimateNormal", 1);
            AnimateNormal = r101;
            AnimateType r102 = new AnimateType("AnimateFast", 2);
            AnimateFast = r102;
            f31320a = new AnimateType[]{r100, r101, r102};
        }

        public static AnimateType[] values() {
            return (AnimateType[]) f31320a.clone();
        }

        public static AnimateType valueOf(String r100) {
            return (AnimateType) r27.a.a(AnimateType.class, r100);
        }

        private AnimateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        if (this.f31319o != null) goto L5;
        BmPrism r100 = new BmPrism();
        this.f31319o = r100;
        r100.a(this);
        setDrawItem(this.f31319o);
    L5:
        super.toDrawItem();
        BmSurfaceStyle r101 = new BmSurfaceStyle();
        BmSurfaceStyle r102 = new BmSurfaceStyle();
        r101.a(this.f31316l);
        r102.a(this.f31317m);
        if (this.f31318n == null) goto L8;
        r102.a(new BmBitmapResource(this.f31318n.getBitmap()));
    L8:
        this.f31315k = new BmGeoElement();
        String r103 = this.f31312h;
        if (r103 == null) goto L14;
        if (r103.length() <= 0) goto L14;
        this.f31315k.a(this.f31312h);
        this.f31315k.a(this.f31313i);
    L20:
        float r104 = this.f31311g;
        if (r104 <= 0.0f) goto L23;
        this.f31319o.c(r104);
    L23:
        this.f31319o.d(r101);
        this.f31319o.c(r102);
        return this.f31319o;
    L14:
        if (this.f31314j == null) goto L20;
        ArrayList r105 = new ArrayList();
        int r106 = 0;
    L17:
        if (r106 >= this.f31314j.size()) goto L19;
        GeoPoint r107 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31314j, r106));
        r105.add(new com.baidu.platform.comapi.bmsdk.b(r107.getLongitudeE6(), r107.getLatitudeE6()));
        r106 = r106 + 1;
        goto L17
    L19:
        this.f31315k.a(r105);
        this.f31319o.a(this.f31315k);
        goto L20
    }

    public Prism() {
        this.f31316l = -16777216;
        this.f31317m = FakePickerAvatarCreator.GREEN;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32152l;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.f31318n;
    }

    public float getHeight() {
        return this.f31311g;
    }

    public List<LatLng> getPoints() {
        return this.f31314j;
    }

    public int getSideFaceColor() {
        return this.f31317m;
    }

    public int getTopFaceColor() {
        return this.f31316l;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        Overlay.f(this.f31316l, r100);
        Overlay.e(this.f31317m, r100);
        BitmapDescriptor r101 = this.f31318n;
        if (r101 == null) goto L5;
        r100.putBundle("image_info", r101.a());
    L5:
        List<LatLng> r102 = this.f31314j;
        if (r102 == null) goto L8;
        GeoPoint r103 = CoordUtil.ll2mc((LatLng) ListProtector.get(r102, 0));
        r100.putDouble("location_x", r103.getLongitudeE6());
        r100.putDouble("location_y", r103.getLatitudeE6());
        Overlay.c(this.f31314j, r100);
        r100.putDouble("m_height", this.f31311g);
    L8:
        return r100;
    }

    public void setCustomSideImage(BitmapDescriptor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f31318n = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L7;
        this.listener.c(this);
        return;
    L7:
        if (this.f31319o != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L14;
        BmSurfaceStyle r101 = new BmSurfaceStyle();
        r101.a(this.f31317m);
        r101.a(new BmBitmapResource(this.f31318n.getBitmap()));
        this.f31319o.c(r101);
        this.f31207f.b();
        return;
    }

    public void setHeight(float r100) {
        this.f31311g = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmPrism r101 = this.f31319o;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.c(this.f31311g);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> r100) {
        if (r100 == null) goto L37;
        if (r100.size() <= 3) goto L35;
        if (r100.contains(null) == true) goto L33;
        int r101 = 0;
        int r102 = 0;
    L9:
        if (r102 >= r100.size()) goto L19;
        int r103 = r102 + 1;
        int r104 = r103;
    L12:
        if (r104 >= r100.size()) goto L18;
        if (((LatLng) ListProtector.get(r100, r102)) == ((LatLng) ListProtector.get(r100, r104))) goto L17;
        r104 = r104 + 1;
        goto L12
    L17:
        throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
    L18:
        r102 = r103;
        goto L9
    L19:
        this.f31314j = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L30;
        BmPrism r105 = this.f31319o;
        if (r105 != null) goto L24;
        return;
    L24:
        if (this.f31207f == null) goto L43;
        r105.c();
        ArrayList r106 = new ArrayList();
    L27:
        if (r101 >= this.f31314j.size()) goto L29;
        GeoPoint r107 = CoordUtil.ll2mc((LatLng) ListProtector.get(this.f31314j, r101));
        r106.add(new com.baidu.platform.comapi.bmsdk.b(r107.getLongitudeE6(), r107.getLatitudeE6()));
        r101 = r101 + 1;
        goto L27
    L29:
        this.f31315k.a(r106);
        this.f31319o.a(this.f31315k);
        this.f31207f.b();
        return;
    L43:
        return;
    L30:
        this.listener.c(this);
        return;
    L33:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L35:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
    L37:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setSideFaceColor(int r100) {
        this.f31317m = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f31319o != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        BmSurfaceStyle r101 = new BmSurfaceStyle();
        r101.a(this.f31317m);
        this.f31319o.c(r101);
        this.f31207f.b();
        return;
    }

    public void setTopFaceColor(int r100) {
        this.f31316l = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f31319o != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        BmSurfaceStyle r101 = new BmSurfaceStyle();
        r101.a(this.f31316l);
        this.f31319o.d(r101);
        this.f31207f.b();
        return;
    }
}
