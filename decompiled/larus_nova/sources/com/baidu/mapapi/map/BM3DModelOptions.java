package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class BM3DModelOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLng f30624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f30625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f30627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f30628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f30629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f30630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f30631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f30632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f30633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f30634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BM3DModelType f30635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f30636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f30637p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f30638q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f30639r;
    public ModelYawAxis yawAxis;

    public static final enum BM3DModelType extends Enum<BM3DModelType> {
        public static final BM3DModelType BM3DModelTypeObj = null;
        public static final BM3DModelType BM3DModelTypeglTF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ BM3DModelType[] f30640a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30641b;

        static {
            BM3DModelType r100 = new BM3DModelType("BM3DModelTypeObj", 0, 0);
            BM3DModelTypeObj = r100;
            BM3DModelType r101 = new BM3DModelType("BM3DModelTypeglTF", 1, 2);
            BM3DModelTypeglTF = r101;
            f30640a = new BM3DModelType[]{r100, r101};
        }

        public static BM3DModelType[] values() {
            return (BM3DModelType[]) f30640a.clone();
        }

        public int getType() {
            return this.f30641b;
        }

        public static BM3DModelType valueOf(String r100) {
            return (BM3DModelType) r27.a.a(BM3DModelType.class, r100);
        }

        private BM3DModelType(String r100, int r101, int r102) {
            super(r100, r101);
            this.f30641b = r102;
        }
    }

    public static final enum ModelYawAxis extends Enum<ModelYawAxis> {
        public static final ModelYawAxis X = null;
        public static final ModelYawAxis Y = null;
        public static final ModelYawAxis Z = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ ModelYawAxis[] f30642a = null;

        static {
            ModelYawAxis r100 = new ModelYawAxis("Z", 0);
            Z = r100;
            ModelYawAxis r101 = new ModelYawAxis("X", 1);
            X = r101;
            ModelYawAxis r102 = new ModelYawAxis("Y", 2);
            Y = r102;
            f30642a = new ModelYawAxis[]{r100, r101, r102};
        }

        public static ModelYawAxis[] values() {
            return (ModelYawAxis[]) f30642a.clone();
        }

        public static ModelYawAxis valueOf(String r100) {
            return (ModelYawAxis) r27.a.a(ModelYawAxis.class, r100);
        }

        private ModelYawAxis(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BM3DModel r100 = new BM3DModel();
        if (TextUtils.isEmpty(this.f30622a) == true) goto L15;
        r100.f30603g = this.f30622a;
        if (TextUtils.isEmpty(this.f30623b) == true) goto L13;
        r100.f30604h = this.f30623b;
        LatLng r101 = this.f30624c;
        if (r101 == null) goto L11;
        r100.f30605i = r101;
        r100.f30606j = this.f30625d;
        r100.f30607k = this.f30626e;
        r100.f30608l = this.f30627f;
        r100.f30609m = this.f30628g;
        r100.f30610n = this.f30629h;
        r100.f30611o = this.f30630i;
        r100.f30612p = this.f30631j;
        r100.f30613q = this.f30632k;
        r100.f31205d = this.f30634m;
        r100.f30614r = this.f30635n;
        r100.f30617u = this.f30638q;
        r100.f30615s = this.f30636o;
        r100.f30616t = this.f30637p;
        r100.f30618v = this.f30639r;
        r100.f30621y = this.f30633l;
        return r100;
    L11:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
    L13:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
    L15:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public int getYawAxis() {
        return this.yawAxis.ordinal();
    }

    public BM3DModelOptions() {
        this.f30625d = 1.0f;
        this.f30626e = false;
        this.f30634m = true;
        this.yawAxis = ModelYawAxis.Z;
        this.f30635n = BM3DModelType.BM3DModelTypeObj;
        this.f30636o = false;
        this.f30637p = 0;
        this.f30639r = 1.0f;
    }

    public int getAnimationIndex() {
        return this.f30638q;
    }

    public int getAnimationRepeatCount() {
        return this.f30637p;
    }

    public float getAnimationSpeed() {
        return this.f30639r;
    }

    public BM3DModelType getBM3DModelType() {
        return this.f30635n;
    }

    public String getModelName() {
        return this.f30623b;
    }

    public String getModelPath() {
        return this.f30622a;
    }

    public float getOffsetX() {
        return this.f30630i;
    }

    public float getOffsetY() {
        return this.f30631j;
    }

    public float getOffsetZ() {
        return this.f30632k;
    }

    public LatLng getPosition() {
        return this.f30624c;
    }

    public float getRotateX() {
        return this.f30627f;
    }

    public float getRotateY() {
        return this.f30628g;
    }

    public float getRotateZ() {
        return this.f30629h;
    }

    public float getScale() {
        return this.f30625d;
    }

    public boolean isSkeletonAnimationEnable() {
        return this.f30636o;
    }

    public boolean isVisible() {
        return this.f30634m;
    }

    public boolean isZoomFixed() {
        return this.f30626e;
    }

    public boolean ismAlwaysShow() {
        return this.f30633l;
    }

    public BM3DModelOptions animationIndex(int r100) {
        this.f30638q = r100;
        return this;
    }

    public BM3DModelOptions animationRepeatCount(int r100) {
        this.f30637p = r100;
        return this;
    }

    public BM3DModelOptions animationSpeed(float r100) {
        this.f30639r = r100;
        return this;
    }

    public BM3DModelOptions setAlwaysShow(boolean r100) {
        this.f30633l = r100;
        return this;
    }

    public BM3DModelOptions setBM3DModelType(BM3DModelType r100) {
        this.f30635n = r100;
        return this;
    }

    public BM3DModelOptions setModelName(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f30623b = r100;
        return this;
    L7:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
    }

    public BM3DModelOptions setModelPath(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f30622a = r100;
        return this;
    L7:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public BM3DModelOptions setPosition(LatLng r100) {
        if (r100 == null) goto L6;
        this.f30624c = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
    }

    public BM3DModelOptions setScale(float r100) {
        this.f30625d = r100;
        return this;
    }

    public BM3DModelOptions setSkeletonAnimationEnable(boolean r100) {
        this.f30636o = r100;
        return this;
    }

    public BM3DModelOptions setYawAxis(ModelYawAxis r100) {
        this.yawAxis = r100;
        return this;
    }

    public BM3DModelOptions setZoomFixed(boolean r100) {
        this.f30626e = r100;
        return this;
    }

    public BM3DModelOptions visible(boolean r100) {
        this.f30634m = r100;
        return this;
    }

    public BM3DModelOptions setOffset(float r100, float r101, float r102) {
        this.f30630i = r100;
        this.f30631j = r101;
        this.f30632k = r102;
        return this;
    }

    public BM3DModelOptions setRotate(float r100, float r101, float r102) {
        this.f30627f = r100;
        this.f30628g = r101;
        this.f30629h = r102;
        return this;
    }
}
