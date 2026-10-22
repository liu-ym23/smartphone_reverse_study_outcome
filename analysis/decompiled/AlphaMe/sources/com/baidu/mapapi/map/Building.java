package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Prism;
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
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Building extends Prism {

    /* renamed from: p, reason: collision with root package name */
    BuildingInfo f6265p;

    /* renamed from: s, reason: collision with root package name */
    int f6268s;

    /* renamed from: v, reason: collision with root package name */
    BitmapDescriptor f6271v;

    /* renamed from: x, reason: collision with root package name */
    int f6273x;

    /* renamed from: y, reason: collision with root package name */
    boolean f6274y;

    /* renamed from: q, reason: collision with root package name */
    float f6266q = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: r, reason: collision with root package name */
    float f6267r = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: t, reason: collision with root package name */
    int f6269t = 0;

    /* renamed from: u, reason: collision with root package name */
    boolean f6270u = false;

    /* renamed from: w, reason: collision with root package name */
    Prism.AnimateType f6272w = Prism.AnimateType.AnimateNormal;

    /* renamed from: z, reason: collision with root package name */
    boolean f6275z = false;

    /* renamed from: A, reason: collision with root package name */
    float f6264A = 5.0f;

    public enum AnimateType {
        AnimateSlow,
        AnimateNormal,
        AnimateFast
    }

    public Building() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.prism;
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f6265p != null) {
            bundle.putDouble("m_height", r0.getHeight());
            bundle.putString("encodedPoints", this.f6265p.getGeom());
            bundle.putInt("encodePointType", EncodePointType.BUILDINGINFO.ordinal());
            bundle.putInt("m_showLevel", this.f6273x);
            bundle.putInt("m_isAnimation", this.f6274y ? 1 : 0);
            bundle.putInt("m_has_floor", this.f6270u ? 1 : 0);
            bundle.putFloat("m_floor_height", this.f6266q);
            bundle.putFloat("m_last_floor_height", this.f6267r);
            Overlay.a(this.f6269t, bundle);
            if (this.f6271v != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("image_info", this.f6271v.a());
                bundle.putBundle("m_floor_image", bundle2);
            }
            bundle.putInt("m_buildingFloorAnimateType", this.f6272w.ordinal());
            bundle.putInt("m_isRoundedCorner", this.f6275z ? 1 : 0);
            bundle.putFloat("m_roundedCornerRadius", this.f6264A);
        }
        bundle.putInt("m_isBuilding", this.f6265p != null ? 1 : 0);
        int iHashCode = hashCode();
        this.f6268s = iHashCode;
        bundle.putInt("buildingId", iHashCode);
        return bundle;
    }

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.f6272w;
    }

    public int getBuildingId() {
        return this.f6268s;
    }

    public BuildingInfo getBuildingInfo() {
        return this.f6265p;
    }

    public int getFloorColor() {
        return this.f6269t;
    }

    public float getFloorHeight() {
        return this.f6266q;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.f6271v;
    }

    @Override // com.baidu.mapapi.map.Prism
    public float getHeight() {
        return this.f6857g;
    }

    @Override // com.baidu.mapapi.map.Prism
    public List<LatLng> getPoints() {
        return this.f6860j;
    }

    public float getRoundedCornerRadius() {
        return this.f6264A;
    }

    public int getShowLevel() {
        return this.f6273x;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getSideFaceColor() {
        return this.f6863m;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getTopFaceColor() {
        return this.f6862l;
    }

    public boolean isAnimation() {
        return this.f6274y;
    }

    public boolean isRoundedCorner() {
        return this.f6275z;
    }

    public void setAnimation(boolean z4) {
        BmPrism bmPrism;
        this.f6274y = z4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmPrism = this.f6865o) == null || this.f6723f == null) {
            return;
        }
        bmPrism.c(z4);
        this.f6723f.b();
    }

    public void setBuildingFloorAnimateType(Prism.AnimateType animateType) {
        this.f6272w = animateType;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.f(this.f6272w.ordinal());
        this.f6723f.b();
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        if (buildingInfo == null) {
            return;
        }
        this.f6265p = buildingInfo;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.c();
        float height = this.f6265p.getHeight();
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = new t().d(this.f6265p.getGeom()).iterator();
        while (it.hasNext()) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.f6861k.a(arrayList);
        this.f6865o.a(this.f6861k);
        this.f6865o.c(height);
        this.f6723f.b();
    }

    public void setFloorColor(int i4) {
        this.f6270u = true;
        this.f6269t = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6865o == null || this.f6723f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        BmSurfaceStyle bmSurfaceStyle2 = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.f6269t);
        bmSurfaceStyle2.a(this.f6269t);
        if (this.f6271v != null) {
            bmSurfaceStyle.a(new BmBitmapResource(this.f6271v.getBitmap()));
        }
        this.f6865o.e(this.f6270u);
        this.f6865o.b(bmSurfaceStyle2);
        this.f6865o.a(bmSurfaceStyle);
        this.f6723f.b();
    }

    public void setFloorHeight(float f4) {
        BuildingInfo buildingInfo = this.f6265p;
        if (buildingInfo == null) {
            return;
        }
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            this.f6267r = this.f6266q;
            this.f6266q = Property.DEFAULT_FLOAT_VALUE;
            return;
        }
        if (f4 > buildingInfo.getHeight()) {
            this.f6267r = this.f6266q;
            this.f6266q = this.f6265p.getHeight();
            return;
        }
        this.f6267r = this.f6266q;
        this.f6266q = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.b(this.f6266q);
        this.f6865o.d(this.f6267r);
        this.f6723f.b();
    }

    public void setFloorSideTextureImage(BitmapDescriptor bitmapDescriptor) {
        this.f6271v = bitmapDescriptor;
        this.f6270u = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6865o == null || this.f6723f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.f6269t);
        if (this.f6271v != null) {
            bmSurfaceStyle.a(new BmBitmapResource(this.f6271v.getBitmap()));
        }
        this.f6865o.a(bmSurfaceStyle);
        this.f6865o.e(this.f6270u);
        this.f6723f.b();
    }

    public void setRoundedCornerEnable(boolean z4) {
        this.f6275z = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.f(z4);
        this.f6723f.b();
    }

    public void setRoundedCornerRadius(float f4) {
        float f5 = Property.DEFAULT_FLOAT_VALUE;
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            f5 = f4;
        }
        this.f6264A = f5;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.f6865o;
        if (bmPrism == null || this.f6723f == null) {
            return;
        }
        bmPrism.e(f4);
        this.f6723f.b();
    }

    public void setShowLevel(int i4) {
        this.f6273x = i4;
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPrism bmPrism = new BmPrism();
        this.f6865o = bmPrism;
        bmPrism.a(this);
        setDrawItem(this.f6865o);
        super.toDrawItem();
        this.f6861k = new BmGeoElement();
        BuildingInfo buildingInfo = this.f6265p;
        if (buildingInfo != null) {
            this.f6865o.c(buildingInfo.getHeight());
            this.f6865o.d(true);
            this.f6865o.c(this.f6274y);
            this.f6865o.b(this.f6273x);
            BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
            BmSurfaceStyle bmSurfaceStyle2 = new BmSurfaceStyle();
            if (this.f6271v != null) {
                bmSurfaceStyle.a(new BmBitmapResource(this.f6271v.getBitmap()));
            }
            bmSurfaceStyle.a(this.f6269t);
            bmSurfaceStyle2.a(this.f6269t);
            this.f6865o.e(this.f6270u);
            this.f6865o.d(this.f6267r);
            this.f6865o.a(bmSurfaceStyle);
            this.f6865o.b(bmSurfaceStyle2);
            this.f6865o.b(this.f6266q);
            this.f6865o.f(this.f6272w.ordinal());
            this.f6865o.e(1);
            ArrayList arrayList = new ArrayList();
            Iterator<LatLng> it = new t().d(this.f6265p.getGeom()).iterator();
            while (it.hasNext()) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            }
            this.f6861k.a(arrayList);
            this.f6865o.a(this.f6861k);
            this.f6865o.f(this.f6275z);
            this.f6865o.e(this.f6264A);
        }
        int iHashCode = hashCode();
        this.f6268s = iHashCode;
        this.f6865o.a(String.valueOf(iHashCode));
        return this.f6865o;
    }
}
