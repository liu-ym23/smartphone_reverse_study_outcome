package com.baidu.mapapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.Bm3DModel;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* JADX INFO: loaded from: classes39.dex */
public final class BM3DModel extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f30603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f30604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    LatLng f30605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f30606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f30607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f30608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f30609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f30610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f30611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f30612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f30613q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    BM3DModelOptions.BM3DModelType f30614r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f30615s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f30616t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f30617u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    float f30618v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Bm3DModel f30619w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Animation f30620x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f30621y;

    public void cancelAnimation() {
        if (this.f30620x != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.f30620x.bmAnimation.cancel();
        this.f31207f.b();
        return;
    }

    public void pauseAnimation() {
        if (this.f30620x != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.f30620x.bmAnimation.pause();
        this.f31207f.b();
        return;
    }

    public void resumeAnimation() {
        if (this.f30620x != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.f30620x.bmAnimation.resume();
        this.f31207f.b();
        return;
    }

    public void startAnimation() {
        if (this.f30620x != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.f30620x.bmAnimation.start();
        this.f31207f.b();
        return;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        Bm3DModel r100 = new Bm3DModel();
        this.f30619w = r100;
        r100.a(this);
        setDrawItem(this.f30619w);
        super.toDrawItem();
        this.f30619w.a(this.f30603g, this.f30604h, this.f30614r.getType());
        GeoPoint r101 = CoordUtil.ll2mc(this.f30605i);
        this.f30619w.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
        this.f30619w.e(!this.f30607k);
        this.f30619w.c(this.f30606j);
        this.f30619w.a(this.f30608l, this.f30609m, this.f30610n);
        this.f30619w.a(this.f30611o, this.f30612p, this.f30613q);
        this.f30619w.d(this.f30615s);
        this.f30619w.b(this.f30618v);
        this.f30619w.f(this.f30616t);
        this.f30619w.e(this.f30617u);
        this.f30619w.c(this.f30621y);
        return this.f30619w;
    }

    public BM3DModel() {
        this.f30606j = 1.0f;
        this.f30607k = false;
        this.f30614r = BM3DModelOptions.BM3DModelType.BM3DModelTypeObj;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32153m;
    }

    public int getAnimationIndex() {
        return this.f30617u;
    }

    public int getAnimationRepeatCount() {
        return this.f30616t;
    }

    public float getAnimationSpeed() {
        return this.f30618v;
    }

    public BM3DModelOptions.BM3DModelType getBM3DModelType() {
        return this.f30614r;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem getDrawItem() {
        return this.f30619w;
    }

    public String getModelName() {
        return this.f30604h;
    }

    public String getModelPath() {
        return this.f30603g;
    }

    public float getOffsetX() {
        return this.f30611o;
    }

    public float getOffsetY() {
        return this.f30612p;
    }

    public float getOffsetZ() {
        return this.f30613q;
    }

    public LatLng getPosition() {
        return this.f30605i;
    }

    public float getRotateX() {
        return this.f30608l;
    }

    public float getRotateY() {
        return this.f30609m;
    }

    public float getRotateZ() {
        return this.f30610n;
    }

    public float getScale() {
        return this.f30606j;
    }

    public boolean isSkeletonAnimationEnable() {
        return this.f30615s;
    }

    public boolean isZoomFixed() {
        return this.f30607k;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        if (TextUtils.isEmpty(this.f30603g) == true) goto L15;
        r100.putString("modelPath", this.f30603g);
        if (TextUtils.isEmpty(this.f30604h) == true) goto L13;
        r100.putString("modelName", this.f30604h);
        LatLng r101 = this.f30605i;
        if (r101 == null) goto L11;
        GeoPoint r102 = CoordUtil.ll2mc(r101);
        r100.putDouble("location_x", r102.getLongitudeE6());
        r100.putDouble("location_y", r102.getLatitudeE6());
        r100.putInt("modelType", this.f30614r.ordinal());
        r100.putFloat("scale", this.f30606j);
        r100.putInt("zoomFixed", this.f30607k ? 1 : 0);
        r100.putFloat("rotateX", this.f30608l);
        r100.putFloat("rotateY", this.f30609m);
        r100.putFloat("rotateZ", this.f30610n);
        r100.putFloat("offsetX", this.f30611o);
        r100.putFloat("offsetY", this.f30612p);
        r100.putFloat("offsetZ", this.f30613q);
        r100.putInt("animationIndex", this.f30617u);
        r100.putBoolean("animationIsEnable", this.f30615s);
        r100.putInt("animationRepeatCount", this.f30616t);
        r100.putFloat("animationSpeed", this.f30618v);
        r100.putBoolean("alwaysShowFront", this.f30621y);
        return r100;
    L11:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
    L13:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
    L15:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public void setAnimation(Animation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f30620x = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmAnimation r101 = this.f30620x.bmAnimation;
        if (r101 == null) goto L11;
        this.f30619w.a(r101);
        this.f31207f.b();
        return;
    L11:
        return;
    }

    public void setAnimationIndex(int r100) {
        this.f30617u = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.e(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setAnimationRepeatCount(int r100) {
        this.f30616t = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
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

    public void setAnimationSpeed(float r100) {
        this.f30618v = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.b(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setBM3DModelType(BM3DModelOptions.BM3DModelType r100) {
        this.f30614r = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(this.f30603g, this.f30604h, this.f30614r.getType());
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setModelName(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        this.f30604h = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L16;
        r101.a(this.f30603g, this.f30604h, this.f30614r.getType());
        this.f31207f.b();
        return;
    L16:
        return;
    L11:
        this.listener.c(this);
        return;
    L14:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
    }

    public void setModelPath(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        this.f30603g = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L16;
        r101.a(this.f30603g, this.f30604h, this.f30614r.getType());
        this.f31207f.b();
        return;
    L16:
        return;
    L11:
        this.listener.c(this);
        return;
    L14:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public void setPosition(LatLng r100) {
        if (r100 == null) goto L13;
        this.f30605i = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    L6:
        if (this.f30619w != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        GeoPoint r101 = CoordUtil.ll2mc(this.f30605i);
        this.f30619w.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
        this.f31207f.b();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
    }

    public void setScale(float r100) {
        this.f30606j = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.c(this.f30606j);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setSkeletonAnimationEnable(boolean r100) {
        this.f30615s = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.d(this.f30615s);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setZoomFixed(boolean r100) {
        this.f30607k = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r101 = this.f30619w;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.e(!this.f30607k);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setOffset(float r100, float r101, float r110) {
        this.f30611o = r100;
        this.f30612p = r101;
        this.f30613q = r110;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r102 = this.f30619w;
        if (r102 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r102.a(this.f30611o, this.f30612p, this.f30613q);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setRotate(float r100, float r101, float r102) {
        this.f30608l = r100;
        this.f30609m = r101;
        this.f30610n = r102;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        Bm3DModel r103 = this.f30619w;
        if (r103 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r103.a(this.f30608l, this.f30609m, this.f30610n);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }
}
