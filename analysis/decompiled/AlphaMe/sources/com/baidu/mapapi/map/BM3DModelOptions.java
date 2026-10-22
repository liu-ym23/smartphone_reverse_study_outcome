package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class BM3DModelOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f6077a;

    /* renamed from: b, reason: collision with root package name */
    private String f6078b;

    /* renamed from: c, reason: collision with root package name */
    private LatLng f6079c;

    /* renamed from: f, reason: collision with root package name */
    private float f6082f;

    /* renamed from: g, reason: collision with root package name */
    private float f6083g;

    /* renamed from: h, reason: collision with root package name */
    private float f6084h;

    /* renamed from: i, reason: collision with root package name */
    private float f6085i;

    /* renamed from: j, reason: collision with root package name */
    private float f6086j;

    /* renamed from: k, reason: collision with root package name */
    private float f6087k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6088l;

    /* renamed from: q, reason: collision with root package name */
    private int f6093q;

    /* renamed from: d, reason: collision with root package name */
    private float f6080d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6081e = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6089m = true;
    public ModelYawAxis yawAxis = ModelYawAxis.Z;

    /* renamed from: n, reason: collision with root package name */
    private BM3DModelType f6090n = BM3DModelType.BM3DModelTypeObj;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6091o = false;

    /* renamed from: p, reason: collision with root package name */
    private int f6092p = 0;

    /* renamed from: r, reason: collision with root package name */
    private float f6094r = 1.0f;

    public enum BM3DModelType {
        BM3DModelTypeObj(0),
        BM3DModelTypeglTF(2);


        /* renamed from: b, reason: collision with root package name */
        private final int f6096b;

        BM3DModelType(int i4) {
            this.f6096b = i4;
        }

        public int getType() {
            return this.f6096b;
        }
    }

    public enum ModelYawAxis {
        Z,
        X,
        Y
    }

    public BM3DModelOptions animationIndex(int i4) {
        this.f6093q = i4;
        return this;
    }

    public BM3DModelOptions animationRepeatCount(int i4) {
        this.f6092p = i4;
        return this;
    }

    public BM3DModelOptions animationSpeed(float f4) {
        this.f6094r = f4;
        return this;
    }

    public int getAnimationIndex() {
        return this.f6093q;
    }

    public int getAnimationRepeatCount() {
        return this.f6092p;
    }

    public float getAnimationSpeed() {
        return this.f6094r;
    }

    public BM3DModelType getBM3DModelType() {
        return this.f6090n;
    }

    public String getModelName() {
        return this.f6078b;
    }

    public String getModelPath() {
        return this.f6077a;
    }

    public float getOffsetX() {
        return this.f6085i;
    }

    public float getOffsetY() {
        return this.f6086j;
    }

    public float getOffsetZ() {
        return this.f6087k;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BM3DModel bM3DModel = new BM3DModel();
        if (TextUtils.isEmpty(this.f6077a)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        bM3DModel.f6058g = this.f6077a;
        if (TextUtils.isEmpty(this.f6078b)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
        }
        bM3DModel.f6059h = this.f6078b;
        LatLng latLng = this.f6079c;
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
        }
        bM3DModel.f6060i = latLng;
        bM3DModel.f6061j = this.f6080d;
        bM3DModel.f6062k = this.f6081e;
        bM3DModel.f6063l = this.f6082f;
        bM3DModel.f6064m = this.f6083g;
        bM3DModel.f6065n = this.f6084h;
        bM3DModel.f6066o = this.f6085i;
        bM3DModel.f6067p = this.f6086j;
        bM3DModel.f6068q = this.f6087k;
        bM3DModel.f6721d = this.f6089m;
        bM3DModel.f6069r = this.f6090n;
        bM3DModel.f6072u = this.f6093q;
        bM3DModel.f6070s = this.f6091o;
        bM3DModel.f6071t = this.f6092p;
        bM3DModel.f6073v = this.f6094r;
        bM3DModel.f6076y = this.f6088l;
        return bM3DModel;
    }

    public LatLng getPosition() {
        return this.f6079c;
    }

    public float getRotateX() {
        return this.f6082f;
    }

    public float getRotateY() {
        return this.f6083g;
    }

    public float getRotateZ() {
        return this.f6084h;
    }

    public float getScale() {
        return this.f6080d;
    }

    public int getYawAxis() {
        return this.yawAxis.ordinal();
    }

    public boolean isSkeletonAnimationEnable() {
        return this.f6091o;
    }

    public boolean isVisible() {
        return this.f6089m;
    }

    public boolean isZoomFixed() {
        return this.f6081e;
    }

    public boolean ismAlwaysShow() {
        return this.f6088l;
    }

    public BM3DModelOptions setAlwaysShow(boolean z4) {
        this.f6088l = z4;
        return this;
    }

    public BM3DModelOptions setBM3DModelType(BM3DModelType bM3DModelType) {
        this.f6090n = bM3DModelType;
        return this;
    }

    public BM3DModelOptions setModelName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
        }
        this.f6078b = str;
        return this;
    }

    public BM3DModelOptions setModelPath(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        this.f6077a = str;
        return this;
    }

    public BM3DModelOptions setOffset(float f4, float f5, float f6) {
        this.f6085i = f4;
        this.f6086j = f5;
        this.f6087k = f6;
        return this;
    }

    public BM3DModelOptions setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
        }
        this.f6079c = latLng;
        return this;
    }

    public BM3DModelOptions setRotate(float f4, float f5, float f6) {
        this.f6082f = f4;
        this.f6083g = f5;
        this.f6084h = f6;
        return this;
    }

    public BM3DModelOptions setScale(float f4) {
        this.f6080d = f4;
        return this;
    }

    public BM3DModelOptions setSkeletonAnimationEnable(boolean z4) {
        this.f6091o = z4;
        return this;
    }

    public BM3DModelOptions setYawAxis(ModelYawAxis modelYawAxis) {
        this.yawAxis = modelYawAxis;
        return this;
    }

    public BM3DModelOptions setZoomFixed(boolean z4) {
        this.f6081e = z4;
        return this;
    }

    public BM3DModelOptions visible(boolean z4) {
        this.f6089m = z4;
        return this;
    }
}
