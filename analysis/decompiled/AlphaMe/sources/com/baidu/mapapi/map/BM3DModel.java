package com.baidu.mapapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.Bm3DModel;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.stepos.alphame.sleep.SleepModeData;

/* loaded from: classes.dex */
public final class BM3DModel extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    String f6058g;

    /* renamed from: h, reason: collision with root package name */
    String f6059h;

    /* renamed from: i, reason: collision with root package name */
    LatLng f6060i;

    /* renamed from: l, reason: collision with root package name */
    float f6063l;

    /* renamed from: m, reason: collision with root package name */
    float f6064m;

    /* renamed from: n, reason: collision with root package name */
    float f6065n;

    /* renamed from: o, reason: collision with root package name */
    float f6066o;

    /* renamed from: p, reason: collision with root package name */
    float f6067p;

    /* renamed from: q, reason: collision with root package name */
    float f6068q;

    /* renamed from: s, reason: collision with root package name */
    boolean f6070s;

    /* renamed from: t, reason: collision with root package name */
    int f6071t;

    /* renamed from: u, reason: collision with root package name */
    int f6072u;

    /* renamed from: v, reason: collision with root package name */
    float f6073v;

    /* renamed from: w, reason: collision with root package name */
    private Bm3DModel f6074w;

    /* renamed from: x, reason: collision with root package name */
    Animation f6075x;

    /* renamed from: y, reason: collision with root package name */
    boolean f6076y;

    /* renamed from: j, reason: collision with root package name */
    float f6061j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    boolean f6062k = false;

    /* renamed from: r, reason: collision with root package name */
    BM3DModelOptions.BM3DModelType f6069r = BM3DModelOptions.BM3DModelType.BM3DModelTypeObj;

    public BM3DModel() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.BM3DModel;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (TextUtils.isEmpty(this.f6058g)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        bundle.putString("modelPath", this.f6058g);
        if (TextUtils.isEmpty(this.f6059h)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
        }
        bundle.putString("modelName", this.f6059h);
        LatLng latLng = this.f6060i;
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        bundle.putInt("modelType", this.f6069r.ordinal());
        bundle.putFloat("scale", this.f6061j);
        bundle.putInt("zoomFixed", this.f6062k ? 1 : 0);
        bundle.putFloat("rotateX", this.f6063l);
        bundle.putFloat("rotateY", this.f6064m);
        bundle.putFloat("rotateZ", this.f6065n);
        bundle.putFloat("offsetX", this.f6066o);
        bundle.putFloat("offsetY", this.f6067p);
        bundle.putFloat("offsetZ", this.f6068q);
        bundle.putInt("animationIndex", this.f6072u);
        bundle.putBoolean("animationIsEnable", this.f6070s);
        bundle.putInt("animationRepeatCount", this.f6071t);
        bundle.putFloat("animationSpeed", this.f6073v);
        bundle.putBoolean("alwaysShowFront", this.f6076y);
        return bundle;
    }

    public void cancelAnimation() {
        if (this.f6075x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6075x.bmAnimation.cancel();
        this.f6723f.b();
    }

    public int getAnimationIndex() {
        return this.f6072u;
    }

    public int getAnimationRepeatCount() {
        return this.f6071t;
    }

    public float getAnimationSpeed() {
        return this.f6073v;
    }

    public BM3DModelOptions.BM3DModelType getBM3DModelType() {
        return this.f6069r;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem getDrawItem() {
        return this.f6074w;
    }

    public String getModelName() {
        return this.f6059h;
    }

    public String getModelPath() {
        return this.f6058g;
    }

    public float getOffsetX() {
        return this.f6066o;
    }

    public float getOffsetY() {
        return this.f6067p;
    }

    public float getOffsetZ() {
        return this.f6068q;
    }

    public LatLng getPosition() {
        return this.f6060i;
    }

    public float getRotateX() {
        return this.f6063l;
    }

    public float getRotateY() {
        return this.f6064m;
    }

    public float getRotateZ() {
        return this.f6065n;
    }

    public float getScale() {
        return this.f6061j;
    }

    public boolean isSkeletonAnimationEnable() {
        return this.f6070s;
    }

    public boolean isZoomFixed() {
        return this.f6062k;
    }

    public void pauseAnimation() {
        if (this.f6075x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6075x.bmAnimation.pause();
        this.f6723f.b();
    }

    public void resumeAnimation() {
        if (this.f6075x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6075x.bmAnimation.resume();
        this.f6723f.b();
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null) {
            return;
        }
        this.f6075x = animation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.f6075x.bmAnimation) == null) {
            return;
        }
        this.f6074w.a(bmAnimation);
        this.f6723f.b();
    }

    public void setAnimationIndex(int i4) {
        this.f6072u = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.e(i4);
        this.f6723f.b();
    }

    public void setAnimationRepeatCount(int i4) {
        this.f6071t = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.f(i4);
        this.f6723f.b();
    }

    public void setAnimationSpeed(float f4) {
        this.f6073v = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.b(f4);
        this.f6723f.b();
    }

    public void setBM3DModelType(BM3DModelOptions.BM3DModelType bM3DModelType) {
        this.f6069r = bM3DModelType;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.a(this.f6058g, this.f6059h, this.f6069r.getType());
        this.f6723f.b();
    }

    public void setModelName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
        }
        this.f6059h = str;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.a(this.f6058g, this.f6059h, this.f6069r.getType());
        this.f6723f.b();
    }

    public void setModelPath(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        this.f6058g = str;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.a(this.f6058g, this.f6059h, this.f6069r.getType());
        this.f6723f.b();
    }

    public void setOffset(float f4, float f5, float f6) {
        this.f6066o = f4;
        this.f6067p = f5;
        this.f6068q = f6;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.a(this.f6066o, this.f6067p, this.f6068q);
        this.f6723f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
        }
        this.f6060i = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6074w == null || this.f6723f == null) {
                return;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6060i);
            this.f6074w.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f6723f.b();
        }
    }

    public void setRotate(float f4, float f5, float f6) {
        this.f6063l = f4;
        this.f6064m = f5;
        this.f6065n = f6;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.a(this.f6063l, this.f6064m, this.f6065n);
        this.f6723f.b();
    }

    public void setScale(float f4) {
        this.f6061j = f4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.c(this.f6061j);
        this.f6723f.b();
    }

    public void setSkeletonAnimationEnable(boolean z4) {
        this.f6070s = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.d(this.f6070s);
        this.f6723f.b();
    }

    public void setZoomFixed(boolean z4) {
        this.f6062k = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.f6074w;
        if (bm3DModel == null || this.f6723f == null) {
            return;
        }
        bm3DModel.e(!this.f6062k);
        this.f6723f.b();
    }

    public void startAnimation() {
        if (this.f6075x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6075x.bmAnimation.start();
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        Bm3DModel bm3DModel = new Bm3DModel();
        this.f6074w = bm3DModel;
        bm3DModel.a(this);
        setDrawItem(this.f6074w);
        super.toDrawItem();
        this.f6074w.a(this.f6058g, this.f6059h, this.f6069r.getType());
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6060i);
        this.f6074w.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        this.f6074w.e(!this.f6062k);
        this.f6074w.c(this.f6061j);
        this.f6074w.a(this.f6063l, this.f6064m, this.f6065n);
        this.f6074w.a(this.f6066o, this.f6067p, this.f6068q);
        this.f6074w.d(this.f6070s);
        this.f6074w.b(this.f6073v);
        this.f6074w.f(this.f6071t);
        this.f6074w.e(this.f6072u);
        this.f6074w.c(this.f6076y);
        return this.f6074w;
    }
}
