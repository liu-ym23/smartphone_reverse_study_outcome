package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class Building extends Prism {
    float A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    BuildingInfo f30789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f30790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f30791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f30792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f30793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f30794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    BitmapDescriptor f30795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Prism.AnimateType f30796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f30797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f30798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f30799z;

    public static final enum AnimateType extends Enum<AnimateType> {
        public static final AnimateType AnimateFast = null;
        public static final AnimateType AnimateNormal = null;
        public static final AnimateType AnimateSlow = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AnimateType[] f30800a = null;

        static {
            AnimateType r100 = new AnimateType("AnimateSlow", 0);
            AnimateSlow = r100;
            AnimateType r101 = new AnimateType("AnimateNormal", 1);
            AnimateNormal = r101;
            AnimateType r102 = new AnimateType("AnimateFast", 2);
            AnimateFast = r102;
            f30800a = new AnimateType[]{r100, r101, r102};
        }

        public static AnimateType[] values() {
            return (AnimateType[]) f30800a.clone();
        }

        public static AnimateType valueOf(String r100) {
            return (AnimateType) r27.a.a(AnimateType.class, r100);
        }

        private AnimateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPrism r100 = new BmPrism();
        this.f31319o = r100;
        r100.a(this);
        setDrawItem(this.f31319o);
        super.toDrawItem();
        this.f31315k = new BmGeoElement();
        BuildingInfo r101 = this.f30789p;
        if (r101 == null) goto L12;
        float r102 = r101.getHeight();
        this.f31319o.c(r102);
        this.f31319o.d(true);
        this.f31319o.c(this.f30798y);
        this.f31319o.b(this.f30797x);
        BmSurfaceStyle r103 = new BmSurfaceStyle();
        BmSurfaceStyle r104 = new BmSurfaceStyle();
        if (this.f30795v == null) goto L7;
        r103.a(new BmBitmapResource(this.f30795v.getBitmap()));
    L7:
        r103.a(this.f30793t);
        r104.a(this.f30793t);
        this.f31319o.e(this.f30794u);
        this.f31319o.d(this.f30791r);
        this.f31319o.a(r103);
        this.f31319o.b(r104);
        this.f31319o.b(this.f30790q);
        this.f31319o.f(this.f30796w.ordinal());
        this.f31319o.e(1);
        ArrayList r105 = new ArrayList();
        Iterator<LatLng> r106 = new t().d(this.f30789p.getGeom()).iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        GeoPoint r107 = CoordUtil.ll2mc(r106.next());
        r105.add(new com.baidu.platform.comapi.bmsdk.b(r107.getLongitudeE6(), r107.getLatitudeE6()));
        goto L9
    L11:
        this.f31315k.a(r105);
        this.f31319o.a(this.f31315k);
        this.f31319o.f(this.f30799z);
        this.f31319o.e(this.A);
    L12:
        int r108 = hashCode();
        this.f30792s = r108;
        this.f31319o.a(String.valueOf(r108));
        return this.f31319o;
    }

    public Building() {
        this.f30790q = 0.0f;
        this.f30791r = 0.0f;
        this.f30793t = 0;
        this.f30794u = false;
        this.f30796w = Prism.AnimateType.AnimateNormal;
        this.f30799z = false;
        this.A = 5.0f;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32152l;
    }

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.f30796w;
    }

    public int getBuildingId() {
        return this.f30792s;
    }

    public BuildingInfo getBuildingInfo() {
        return this.f30789p;
    }

    public int getFloorColor() {
        return this.f30793t;
    }

    public float getFloorHeight() {
        return this.f30790q;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.f30795v;
    }

    @Override // com.baidu.mapapi.map.Prism
    public float getHeight() {
        return this.f31311g;
    }

    @Override // com.baidu.mapapi.map.Prism
    public List<LatLng> getPoints() {
        return this.f31314j;
    }

    public float getRoundedCornerRadius() {
        return this.A;
    }

    public int getShowLevel() {
        return this.f30797x;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getSideFaceColor() {
        return this.f31317m;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getTopFaceColor() {
        return this.f31316l;
    }

    public boolean isAnimation() {
        return this.f30798y;
    }

    public boolean isRoundedCorner() {
        return this.f30799z;
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        BuildingInfo r101 = this.f30789p;
        if (r101 == null) goto L9;
        r100.putDouble("m_height", r101.getHeight());
        r100.putString("encodedPoints", this.f30789p.getGeom());
        r100.putInt("encodePointType", EncodePointType.BUILDINGINFO.ordinal());
        r100.putInt("m_showLevel", this.f30797x);
        r100.putInt("m_isAnimation", this.f30798y ? 1 : 0);
        r100.putInt("m_has_floor", this.f30794u ? 1 : 0);
        r100.putFloat("m_floor_height", this.f30790q);
        r100.putFloat("m_last_floor_height", this.f30791r);
        Overlay.a(this.f30793t, r100);
        if (this.f30795v == null) goto L7;
        Bundle r102 = new Bundle();
        r102.putBundle("image_info", this.f30795v.a());
        r100.putBundle("m_floor_image", r102);
    L7:
        r100.putInt("m_buildingFloorAnimateType", this.f30796w.ordinal());
        r100.putInt("m_isRoundedCorner", this.f30799z ? 1 : 0);
        r100.putFloat("m_roundedCornerRadius", this.A);
    L9:
        if (this.f30789p == null) goto L11;
        int r103 = 1;
    L12:
        r100.putInt("m_isBuilding", r103);
        int r104 = hashCode();
        this.f30792s = r104;
        r100.putInt("buildingId", r104);
        return r100;
    L11:
        r103 = 0;
        goto L12
    }

    public void setAnimation(boolean r100) {
        this.f30798y = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmPrism r101 = this.f31319o;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.c(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setBuildingFloorAnimateType(Prism.AnimateType r100) {
        this.f30796w = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmPrism r101 = this.f31319o;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.f(this.f30796w.ordinal());
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setBuildingInfo(BuildingInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f30789p = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L15;
        BmPrism r101 = this.f31319o;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L19;
        r101.c();
        float r102 = this.f30789p.getHeight();
        ArrayList r103 = new ArrayList();
        Iterator<LatLng> r104 = new t().d(this.f30789p.getGeom()).iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        GeoPoint r105 = CoordUtil.ll2mc(r104.next());
        r103.add(new com.baidu.platform.comapi.bmsdk.b(r105.getLongitudeE6(), r105.getLatitudeE6()));
        goto L12
    L14:
        this.f31315k.a(r103);
        this.f31319o.a(this.f31315k);
        this.f31319o.c(r102);
        this.f31207f.b();
        return;
    L19:
        return;
    L15:
        this.listener.c(this);
    }

    public void setFloorColor(int r100) {
        this.f30794u = true;
        this.f30793t = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f31319o != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L15;
        BmSurfaceStyle r101 = new BmSurfaceStyle();
        BmSurfaceStyle r102 = new BmSurfaceStyle();
        r101.a(this.f30793t);
        r102.a(this.f30793t);
        if (this.f30795v == null) goto L11;
        r101.a(new BmBitmapResource(this.f30795v.getBitmap()));
    L11:
        this.f31319o.e(this.f30794u);
        this.f31319o.b(r102);
        this.f31319o.a(r101);
        this.f31207f.b();
        return;
    }

    public void setFloorHeight(float r100) {
        BuildingInfo r101 = this.f30789p;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 >= 0.0f) goto L10;
        this.f30791r = this.f30790q;
        this.f30790q = 0.0f;
        return;
    L10:
        if (r100 <= r101.getHeight()) goto L13;
        this.f30791r = this.f30790q;
        this.f30790q = this.f30789p.getHeight();
        return;
    L13:
        this.f30791r = this.f30790q;
        this.f30790q = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L20;
        BmPrism r102 = this.f31319o;
        if (r102 != null) goto L18;
        return;
    L18:
        if (this.f31207f == null) goto L23;
        r102.b(this.f30790q);
        this.f31319o.d(this.f30791r);
        this.f31207f.b();
        return;
    L23:
        return;
    L20:
        this.listener.c(this);
    }

    public void setFloorSideTextureImage(BitmapDescriptor r100) {
        this.f30795v = r100;
        this.f30794u = true;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f31319o != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L15;
        BmSurfaceStyle r101 = new BmSurfaceStyle();
        r101.a(this.f30793t);
        if (this.f30795v == null) goto L11;
        r101.a(new BmBitmapResource(this.f30795v.getBitmap()));
    L11:
        this.f31319o.a(r101);
        this.f31319o.e(this.f30794u);
        this.f31207f.b();
        return;
    }

    public void setRoundedCornerEnable(boolean r100) {
        this.f30799z = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmPrism r101 = this.f31319o;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.f(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setRoundedCornerRadius(float r100) {
        float r101 = 0.0f;
        if (r100 <= 0.0f) goto L6;
        r101 = r100;
    L6:
        this.A = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmPrism r102 = this.f31319o;
        if (r102 != null) goto L11;
        return;
    L11:
        if (this.f31207f == null) goto L16;
        r102.e(r100);
        this.f31207f.b();
        return;
    L16:
        return;
    L13:
        this.listener.c(this);
    }

    public void setShowLevel(int r100) {
        this.f30797x = r100;
    }
}
