package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class PolylineOptions extends OverlayOptions {
    private LineBloomType A;
    private float B;
    private int C;
    private int D;
    private int E;
    private LineBloomDirection F;
    private boolean G;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LatLng> f31282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Integer> f31283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Integer> f31284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WidthType f31285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BitmapDescriptor f31287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<BitmapDescriptor> f31288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f31289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f31290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f31291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f31292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f31293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31294n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Bundle f31295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LineJoinType f31297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LineCapType f31298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f31299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ThinAndSmoothAlgorithm f31300t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f31301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ThinAndSmoothAlgorithm f31302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f31303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f31304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f31305y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private LineDirectionCross180 f31306z;

    public static final enum LineBloomType extends Enum<LineBloomType> {
        public static final LineBloomType BLUR = null;
        public static final LineBloomType GradientA = null;
        public static final LineBloomType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ LineBloomType[] f31307a = null;

        static {
            LineBloomType r100 = new LineBloomType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            LineBloomType r101 = new LineBloomType("GradientA", 1);
            GradientA = r101;
            LineBloomType r102 = new LineBloomType("BLUR", 2);
            BLUR = r102;
            f31307a = new LineBloomType[]{r100, r101, r102};
        }

        public static LineBloomType[] values() {
            return (LineBloomType[]) f31307a.clone();
        }

        public static LineBloomType valueOf(String r100) {
            return (LineBloomType) r27.a.a(LineBloomType.class, r100);
        }

        private LineBloomType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LineCapType extends Enum<LineCapType> {
        public static final LineCapType LineCapButt = null;
        public static final LineCapType LineCapRound = null;
        public static final LineCapType LineCapSQUARE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ LineCapType[] f31308a = null;

        static {
            LineCapType r100 = new LineCapType("LineCapButt", 0);
            LineCapButt = r100;
            LineCapType r101 = new LineCapType("LineCapRound", 1);
            LineCapRound = r101;
            LineCapType r102 = new LineCapType("LineCapSQUARE", 2);
            LineCapSQUARE = r102;
            f31308a = new LineCapType[]{r100, r101, r102};
        }

        public static LineCapType[] values() {
            return (LineCapType[]) f31308a.clone();
        }

        public static LineCapType valueOf(String r100) {
            return (LineCapType) r27.a.a(LineCapType.class, r100);
        }

        private LineCapType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LineDirectionCross180 extends Enum<LineDirectionCross180> {
        public static final LineDirectionCross180 FROM_EAST_TO_WEST = null;
        public static final LineDirectionCross180 FROM_WEST_TO_EAST = null;
        public static final LineDirectionCross180 NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ LineDirectionCross180[] f31309a = null;

        static {
            LineDirectionCross180 r100 = new LineDirectionCross180(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            LineDirectionCross180 r101 = new LineDirectionCross180("FROM_EAST_TO_WEST", 1);
            FROM_EAST_TO_WEST = r101;
            LineDirectionCross180 r102 = new LineDirectionCross180("FROM_WEST_TO_EAST", 2);
            FROM_WEST_TO_EAST = r102;
            f31309a = new LineDirectionCross180[]{r100, r101, r102};
        }

        public static LineDirectionCross180[] values() {
            return (LineDirectionCross180[]) f31309a.clone();
        }

        public static LineDirectionCross180 valueOf(String r100) {
            return (LineDirectionCross180) r27.a.a(LineDirectionCross180.class, r100);
        }

        private LineDirectionCross180(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LineJoinType extends Enum<LineJoinType> {
        public static final LineJoinType LineJoinBerzier = null;
        public static final LineJoinType LineJoinBevel = null;
        public static final LineJoinType LineJoinMiter = null;
        public static final LineJoinType LineJoinRound = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ LineJoinType[] f31310a = null;

        static {
            LineJoinType r100 = new LineJoinType("LineJoinBevel", 0);
            LineJoinBevel = r100;
            LineJoinType r101 = new LineJoinType("LineJoinMiter", 1);
            LineJoinMiter = r101;
            LineJoinType r102 = new LineJoinType("LineJoinRound", 2);
            LineJoinRound = r102;
            LineJoinType r103 = new LineJoinType("LineJoinBerzier", 3);
            LineJoinBerzier = r103;
            f31310a = new LineJoinType[]{r100, r101, r102, r103};
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) f31310a.clone();
        }

        public static LineJoinType valueOf(String r100) {
            return (LineJoinType) r27.a.a(LineJoinType.class, r100);
        }

        private LineJoinType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Polyline r100 = new Polyline();
        List<LatLng> r101 = this.f31282b;
        if (r101 == null) goto L30;
        if (r101.size() < 2) goto L30;
        r100.U = this.A;
        r100.K = this.F;
        r100.E = this.D;
        r100.F = this.E;
        r100.G = this.B;
        r100.H = this.C;
        boolean r102 = this.f31305y;
        if (r102 == false) goto L9;
        r100.type = com.baidu.mapsdkplatform.comapi.map.d.f32154n;
    L9:
        r100.f31205d = this.f31292l;
        r100.f31266o = this.f31293m;
        r100.f31204c = this.f31291k;
        r100.f31206e = this.f31295o;
        r100.f31259h = this.f31282b;
        r100.f31258g = this.f31281a;
        r100.f31264m = this.f31285e;
        r100.f31265n = this.f31286f;
        r100.f31270s = this.f31287g;
        r100.f31272u = this.f31288h;
        r100.f31267p = this.f31289i;
        r100.f31268q = this.f31290j;
        r100.f31269r = this.f31294n;
        r100.f31275x = this.f31299s;
        r100.f31276y = this.f31300t;
        r100.f31277z = this.f31301u;
        r100.A = this.f31302v;
        r100.B = this.f31303w;
        r100.C = this.f31304x;
        r100.D = r102;
        r100.f31274w = this.f31296p;
        r100.S = this.f31297q;
        r100.R = this.f31298r;
        r100.T = this.f31306z;
        List<Integer> r103 = this.f31283c;
        int r104 = 0;
        if (r103 != null) goto L12;
    L18:
        List<Integer> r105 = this.f31284d;
        if (r105 != null) goto L21;
    L27:
        r100.I = this.G;
        r100.f31257J = this.H;
        return r100;
    L21:
        if (r105.size() <= 0) goto L27;
        int[] r106 = new int[this.f31284d.size()];
        Iterator<Integer> r107 = this.f31284d.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        r106[r104] = r107.next().intValue();
        r104 = r104 + 1;
        goto L24
    L26:
        r100.f31262k = r106;
        goto L27
    L12:
        if (r103.size() <= 0) goto L18;
        int[] r108 = new int[this.f31283c.size()];
        Iterator<Integer> r109 = this.f31283c.iterator();
        int r110 = 0;
    L15:
        if (r109.hasNext() == false) goto L17;
        r108[r110] = r109.next().intValue();
        r110 = r110 + 1;
        goto L15
    L17:
        r100.f31260i = r108;
    L30:
        throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
    }

    public int getWidth() {
        return (int) this.f31286f;
    }

    public PolylineOptions() {
        this.f31281a = -16777216;
        this.f31285e = WidthType.AdaptWidth;
        this.f31286f = 5.0f;
        this.f31289i = true;
        this.f31290j = false;
        this.f31292l = true;
        this.f31293m = false;
        this.f31294n = true;
        this.f31296p = 0;
        this.f31297q = LineJoinType.LineJoinRound;
        this.f31298r = LineCapType.LineCapButt;
        this.f31299s = true;
        this.f31300t = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;
        this.f31301u = 4.0f;
        this.f31302v = ThinAndSmoothAlgorithm.BEZIER_SMOOTH;
        this.f31303w = 16.0f;
        this.f31304x = false;
        this.f31305y = false;
        this.f31306z = LineDirectionCross180.NONE;
        this.A = LineBloomType.NONE;
        this.B = 5.0f;
        this.C = 1;
        this.F = LineBloomDirection.BloomAround;
        this.H = false;
    }

    public int getColor() {
        return this.f31281a;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f31287g;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.f31288h;
    }

    public Bundle getExtraInfo() {
        return this.f31295o;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.F;
    }

    public List<LatLng> getPoints() {
        return this.f31282b;
    }

    public List<Integer> getTextureIndexs() {
        return this.f31283c;
    }

    public float getWidthFloat() {
        return this.f31286f;
    }

    public WidthType getWidthType() {
        return this.f31285e;
    }

    public int getZIndex() {
        return this.f31291k;
    }

    public boolean isDottedLine() {
        return this.f31293m;
    }

    public boolean isFocus() {
        return this.f31289i;
    }

    public boolean isVisible() {
        return this.f31292l;
    }

    public boolean poiCollided() {
        return this.H;
    }

    public PolylineOptions bloomAlpha(int r100) {
        if (r100 > 255) goto L5;
        if (r100 < 0) goto L5;
    L6:
        this.E = r100;
        return this;
    L5:
        r100 = 255;
        goto L6
    }

    public PolylineOptions bloomType(LineBloomType r100) {
        this.A = r100;
        return this;
    }

    public PolylineOptions bloomWidth(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.D = r100;
        return this;
    }

    public PolylineOptions clickable(boolean r100) {
        this.f31294n = r100;
        return this;
    }

    public PolylineOptions color(int r100) {
        this.f31281a = r100;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> r100) {
        if (r100 == null) goto L10;
        if (r100.contains(null) == true) goto L8;
        this.f31284d = r100;
        return this;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
    L10:
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public PolylineOptions customTexture(BitmapDescriptor r100) {
        this.f31287g = r100;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> r100) {
        if (r100 == null) goto L10;
        r100.size();
        Iterator<BitmapDescriptor> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L7;
        BitmapDescriptor r102 = r101.next();
        goto L5
    L7:
        this.f31288h = r100;
        return this;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
    }

    public PolylineOptions dottedLine(boolean r100) {
        this.f31293m = r100;
        return this;
    }

    public PolylineOptions dottedLineType(PolylineDottedLineType r100) {
        this.f31296p = r100.ordinal();
        return this;
    }

    public PolylineOptions extraInfo(Bundle r100) {
        this.f31295o = r100;
        return this;
    }

    public PolylineOptions focus(boolean r100) {
        this.f31289i = r100;
        return this;
    }

    public PolylineOptions isGeodesic(boolean r100) {
        this.f31304x = r100;
        return this;
    }

    public PolylineOptions isGradient(boolean r100) {
        this.f31305y = r100;
        return this;
    }

    public PolylineOptions isPoiCollided(boolean r100) {
        this.H = r100;
        return this;
    }

    public PolylineOptions isThined(boolean r100) {
        this.f31299s = r100;
        return this;
    }

    public PolylineOptions keepScale(boolean r100) {
        this.f31290j = r100;
        return this;
    }

    public PolylineOptions lineBloomDirection(LineBloomDirection r100) {
        this.F = r100;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType r100) {
        this.f31298r = r100;
        return this;
    }

    public PolylineOptions lineDirectionCross180(LineDirectionCross180 r100) {
        this.f31306z = r100;
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType r100) {
        this.f31297q = r100;
        return this;
    }

    public PolylineOptions points(List<LatLng> r100) {
        if (r100 == null) goto L14;
        if (r100.size() < 2) goto L12;
        if (r100.contains(null) == true) goto L10;
        this.f31282b = r100;
        return this;
    L10:
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
    L12:
        throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    L14:
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolylineOptions setBloomBlurTimes(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 <= 10) goto L8;
        r100 = 10;
    L8:
        this.C = r100;
        return this;
    }

    public PolylineOptions setBloomGradientASpeed(float r100) {
        if (r100 >= 1.0f) goto L6;
        r100 = 1.0f;
    L6:
        if (r100 <= 10.0f) goto L8;
        r100 = 10.0f;
    L8:
        this.B = r100;
        return this;
    }

    public PolylineOptions setHighPrecision(boolean r100) {
        this.G = r100;
        return this;
    }

    public PolylineOptions smoothAlgorithm(ThinAndSmoothAlgorithm r100) {
        this.f31302v = r100;
        return this;
    }

    public PolylineOptions smoothFactor(float r100) {
        if (r100 <= 0.0f) goto L5;
        this.f31303w = r100;
    L5:
        return this;
    }

    public PolylineOptions textureIndex(List<Integer> r100) {
        if (r100 == null) goto L10;
        if (r100.contains(null) == true) goto L8;
        this.f31283c = r100;
        return this;
    L8:
        throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
    L10:
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public PolylineOptions thinAlgorithm(ThinAndSmoothAlgorithm r100) {
        this.f31300t = r100;
        return this;
    }

    public PolylineOptions thinFactor(float r100) {
        if (r100 <= 0.0f) goto L5;
        this.f31301u = r100;
    L5:
        return this;
    }

    public PolylineOptions visible(boolean r100) {
        this.f31292l = r100;
        return this;
    }

    public PolylineOptions width(float r100) {
        if (r100 <= 0.0f) goto L5;
        this.f31286f = r100;
    L5:
        return this;
    }

    public PolylineOptions widthType(WidthType r100) {
        this.f31285e = r100;
        return this;
    }

    public PolylineOptions zIndex(int r100) {
        this.f31291k = r100;
        return this;
    }
}
