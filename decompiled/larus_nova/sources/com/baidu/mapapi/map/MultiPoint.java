package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmMultiPoint;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class MultiPoint extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    List<MultiPointItem> f31156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    BitmapDescriptor f31157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f31158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f31159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f31160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f31161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f31162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BmMultiPoint f31163n;

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmMultiPoint r100 = new BmMultiPoint();
        this.f31163n = r100;
        r100.a(this);
        setDrawItem(this.f31163n);
        super.getDrawItem();
        this.f31163n.b(this.f31160k);
        this.f31163n.c(this.f31161l);
        this.f31163n.b(this.f31158i);
        this.f31163n.a(this.f31159j);
        this.f31163n.a(this.f31162m);
        List<MultiPointItem> r101 = this.f31156g;
        if (r101 == null) goto L15;
        if (r101.size() <= 0) goto L15;
        int r102 = 0;
        GeoPoint r103 = CoordUtil.ll2mc(((MultiPointItem) ListProtector.get(this.f31156g, 0)).getPoint());
        this.f31163n.a(new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6()));
        BmGeoElement r104 = new BmGeoElement();
        ArrayList r105 = new ArrayList();
    L8:
        if (r102 >= this.f31156g.size()) goto L13;
        MultiPointItem r106 = (MultiPointItem) ListProtector.get(this.f31156g, r102);
        if (r106 == null) goto L12;
        GeoPoint r107 = CoordUtil.ll2mc(r106.getPoint());
        r105.add(new com.baidu.platform.comapi.bmsdk.b(r107.getLongitudeE6(), r107.getLatitudeE6()));
    L12:
        r102 = r102 + 1;
        goto L8
    L13:
        r104.a(r105);
        this.f31163n.a(r104);
    L15:
        if (this.f31157h == null) goto L18;
        this.f31163n.a(new BmBitmapResource(this.f31157h.getBitmap()));
    L18:
        return this.f31163n;
    }

    public MultiPoint() {
        this.f31162m = true;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32151k;
    }

    public float getAnchorX() {
        return this.f31160k;
    }

    public float getAnchorY() {
        return this.f31161l;
    }

    public BitmapDescriptor getIcon() {
        return this.f31157h;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.f31156g;
    }

    public int getPointSizeHeight() {
        return this.f31159j;
    }

    public int getPointSizeWidth() {
        return this.f31158i;
    }

    public boolean isClickable() {
        return this.f31162m;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        List<MultiPointItem> r101 = this.f31156g;
        if (r101 != null) goto L5;
    L14:
        BitmapDescriptor r102 = this.f31157h;
        if (r102 == null) goto L17;
        r100.putBundle("image_info", r102.a());
    L17:
        r100.putInt("isClickable", this.f31162m ? 1 : 0);
        r100.putFloat("anchor_x", this.f31160k);
        r100.putFloat("anchor_y", this.f31161l);
        r100.putFloat("pointsize_x", this.f31158i);
        r100.putFloat("pointsize_y", this.f31159j);
        return r100;
    L5:
        if (r101.size() <= 0) goto L14;
        int r103 = 0;
        GeoPoint r104 = CoordUtil.ll2mc(((MultiPointItem) ListProtector.get(this.f31156g, 0)).getPoint());
        r100.putDouble("location_x", r104.getLongitudeE6());
        r100.putDouble("location_y", r104.getLatitudeE6());
        ArrayList r105 = new ArrayList();
    L8:
        if (r103 >= this.f31156g.size()) goto L13;
        MultiPointItem r106 = (MultiPointItem) ListProtector.get(this.f31156g, r103);
        if (r106 == null) goto L12;
        r105.add(r106.getPoint());
    L12:
        r103 = r103 + 1;
        goto L8
    L13:
        Overlay.c(r105, r100);
        goto L14
    }

    public MultiPointItem getMultiPointItem(int r100) {
        List<MultiPointItem> r101 = this.f31156g;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100 < r101.size()) goto L7;
        return null;
    L7:
        return (MultiPointItem) ListProtector.get(this.f31156g, r100);
    }

    public void setClickable(boolean r100) {
        this.f31162m = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmMultiPoint r101 = this.f31163n;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setIcon(BitmapDescriptor r100) {
        if (r100 == null) goto L19;
        this.f31157h = r100;
        if (this.f31158i != 0) goto L7;
        this.f31158i = r100.getBitmap().getWidth();
    L7:
        if (this.f31159j != 0) goto L10;
        this.f31159j = r100.getBitmap().getHeight();
    L10:
        if (OverlayUtil.isOverlayUpgrade() == true) goto L12;
        this.listener.c(this);
        return;
    L12:
        if (this.f31163n != null) goto L14;
        return;
    L14:
        if (this.f31207f == null) goto L21;
        BmBitmapResource r101 = new BmBitmapResource(this.f31157h.getBitmap());
        this.f31163n.a(r101);
        this.f31207f.b();
        return;
    L21:
        return;
    L19:
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public void setMultiPointItems(List<MultiPointItem> r100) {
        if (r100 == null) goto L24;
        if (r100.contains(null) == true) goto L22;
        this.f31156g = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L19;
        BmMultiPoint r101 = this.f31163n;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L29;
        r101.c();
        int r102 = 0;
        GeoPoint r103 = CoordUtil.ll2mc(((MultiPointItem) ListProtector.get(this.f31156g, 0)).getPoint());
        this.f31163n.a(new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6()));
        BmGeoElement r104 = new BmGeoElement();
        ArrayList r105 = new ArrayList();
    L13:
        if (r102 >= this.f31156g.size()) goto L18;
        MultiPointItem r106 = (MultiPointItem) ListProtector.get(this.f31156g, r102);
        if (r106 == null) goto L17;
        GeoPoint r107 = CoordUtil.ll2mc(r106.getPoint());
        r105.add(new com.baidu.platform.comapi.bmsdk.b(r107.getLongitudeE6(), r107.getLatitudeE6()));
    L17:
        r102 = r102 + 1;
        goto L13
    L18:
        r104.a(r105);
        this.f31163n.a(r104);
        this.f31207f.b();
        return;
    L29:
        return;
    L19:
        this.listener.c(this);
        return;
    L22:
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
    L24:
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
    }

    public void anchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 <= 1.0f) goto L8;
        return;
    L8:
        if (r101 >= 0.0f) goto L10;
        return;
    L10:
        if (r101 > 1.0f) goto L27;
        this.f31160k = r100;
        this.f31161l = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L19;
        BmMultiPoint r102 = this.f31163n;
        if (r102 != null) goto L17;
        return;
    L17:
        if (this.f31207f == null) goto L24;
        r102.b(this.f31160k);
        this.f31163n.c(this.f31161l);
        this.f31207f.b();
        return;
    L24:
        return;
    L19:
        this.listener.c(this);
        return;
    }

    public void setPointSize(int r100, int r101) {
        if (this.f31158i <= 0) goto L16;
        if (this.f31159j <= 0) goto L16;
        this.f31158i = r100;
        this.f31159j = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmMultiPoint r102 = this.f31163n;
        if (r102 != null) goto L11;
        return;
    L11:
        if (this.f31207f == null) goto L18;
        r102.b(this.f31158i);
        this.f31163n.a(this.f31159j);
        this.f31207f.b();
        return;
    L18:
        return;
    L13:
        this.listener.c(this);
        return;
    L16:
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
    }
}
