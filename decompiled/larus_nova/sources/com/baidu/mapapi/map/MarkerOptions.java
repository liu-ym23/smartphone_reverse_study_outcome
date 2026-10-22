package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public final class MarkerOptions extends OverlayOptions {
    private int A;
    private boolean B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    int G;
    boolean H;
    Bundle I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f31129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BitmapDescriptor f31130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmBitmapResource f31131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f31135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TitleOptions f31138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f31139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f31140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f31141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList<BitmapDescriptor> f31143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f31148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f31149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f31150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f31151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Point f31152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f31153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private InfoWindow f31154z;

    public static final enum MarkerAnimateType extends Enum<MarkerAnimateType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ MarkerAnimateType[] f31155a = null;
        public static final MarkerAnimateType drop = null;
        public static final MarkerAnimateType grow = null;
        public static final MarkerAnimateType jump = null;
        public static final MarkerAnimateType none = null;

        static {
            MarkerAnimateType r100 = new MarkerAnimateType("none", 0);
            none = r100;
            MarkerAnimateType r101 = new MarkerAnimateType("drop", 1);
            drop = r101;
            MarkerAnimateType r102 = new MarkerAnimateType("grow", 2);
            grow = r102;
            MarkerAnimateType r103 = new MarkerAnimateType(Notice.CLICK_TYPE_JUMP, 3);
            jump = r103;
            f31155a = new MarkerAnimateType[]{r100, r101, r102, r103};
        }

        public static MarkerAnimateType[] values() {
            return (MarkerAnimateType[]) f31155a.clone();
        }

        public static MarkerAnimateType valueOf(String r100) {
            return (MarkerAnimateType) r27.a.a(MarkerAnimateType.class, r100);
        }

        private MarkerAnimateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MarkerAnimateType getAnimateType() {
        int r100 = this.f31150v;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return MarkerAnimateType.none;
    L11:
        return MarkerAnimateType.jump;
    L13:
        return MarkerAnimateType.grow;
    L15:
        return MarkerAnimateType.drop;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Marker r100 = new Marker();
        r100.f31119q = this.f31139k;
        r100.f31205d = this.H;
        r100.f31204c = this.G;
        r100.f31206e = this.I;
        LatLng r101 = this.f31129a;
        if (r101 == null) goto L18;
        r100.f31109g = r101;
        BitmapDescriptor r102 = this.f31130b;
        if (r102 == null) goto L7;
    L13:
        r100.f31110h = r102;
        r100.f31111i = this.f31131c;
        r100.f31114l = this.f31132d;
        r100.f31115m = this.f31134f;
        r100.f31113k = this.f31133e;
        r100.f31116n = this.f31135g;
        r100.f31117o = this.f31136h;
        r100.f31118p = this.f31137i;
        r100.f31120r = this.f31138j;
        r100.f31122t = this.f31140l;
        r100.f31123u = this.f31141m;
        r100.f31124v = this.f31142n;
        r100.G = this.f31143o;
        r100.f31108J = this.f31144p;
        r100.F = this.f31145q;
        r100.f31126x = this.f31148t;
        r100.E = this.f31149u;
        r100.L = this.f31146r;
        r100.M = this.f31147s;
        r100.f31127y = this.f31150v;
        r100.f31128z = this.f31151w;
        r100.P = this.f31154z;
        r100.A = this.f31153y;
        r100.S = this.A;
        r100.D = this.B;
        r100.U = this.C;
        r100.V = this.D;
        r100.B = this.E;
        r100.C = this.F;
        Point r103 = this.f31152x;
        if (r103 == null) goto L16;
        r100.O = r103;
    L16:
        return r100;
    L7:
        if (this.f31143o != null) goto L13;
        if (this.f31131c != null) goto L13;
        throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
    L18:
        throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
    }

    public MarkerOptions() {
        this.f31132d = 0.5f;
        this.f31133e = 2;
        this.f31134f = 1.0f;
        this.f31135g = true;
        this.f31136h = false;
        this.f31142n = false;
        this.f31144p = 20;
        this.f31145q = 160;
        this.f31146r = 1.0f;
        this.f31147s = 1.0f;
        this.f31148t = 1.0f;
        this.f31149u = 0;
        this.f31150v = MarkerAnimateType.none.ordinal();
        this.f31151w = false;
        this.f31153y = true;
        this.A = Integer.MAX_VALUE;
        this.B = false;
        this.C = 4;
        this.D = 22;
        this.E = false;
        this.F = false;
        this.H = true;
    }

    public float getAlpha() {
        return this.f31148t;
    }

    public float getAnchorX() {
        return this.f31132d;
    }

    public float getAnchorY() {
        return this.f31134f;
    }

    public int getEndLevel() {
        return this.D;
    }

    public Bundle getExtraInfo() {
        return this.I;
    }

    public boolean getForceDisPlay() {
        return this.B;
    }

    public int getHeight() {
        return this.f31149u;
    }

    public BitmapDescriptor getIcon() {
        return this.f31130b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f31143o;
    }

    public int getInterval() {
        return this.f31145q;
    }

    public boolean getIsClickable() {
        return this.f31153y;
    }

    public boolean getJoinCollision() {
        return this.E;
    }

    public int getPeriod() {
        return this.f31144p;
    }

    public LatLng getPosition() {
        return this.f31129a;
    }

    public int getPriority() {
        return this.A;
    }

    public float getRotate() {
        return this.f31137i;
    }

    public int getStartLevel() {
        return this.C;
    }

    public String getTitle() {
        return this.f31139k;
    }

    public TitleOptions getTitleOptions() {
        return this.f31138j;
    }

    public int getZIndex() {
        return this.G;
    }

    public boolean isDraggable() {
        return this.f31136h;
    }

    public boolean isFlat() {
        return this.f31142n;
    }

    public boolean isPerspective() {
        return this.f31135g;
    }

    public boolean isPoiCollided() {
        return this.F;
    }

    public boolean isVisible() {
        return this.H;
    }

    public MarkerOptions alpha(float r100) {
        if (r100 >= 0.0f) goto L5;
    L9:
        this.f31148t = 1.0f;
        return this;
    L5:
        if (r100 > 1.0f) goto L9;
        this.f31148t = r100;
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType r100) {
        if (r100 != null) goto L4;
        r100 = MarkerAnimateType.none;
    L4:
        this.f31150v = r100.ordinal();
        return this;
    }

    public MarkerOptions bitmapResource(BmBitmapResource r100) {
        this.f31131c = r100;
        return this;
    }

    public MarkerOptions clickable(boolean r100) {
        this.f31153y = r100;
        return this;
    }

    public MarkerOptions draggable(boolean r100) {
        this.f31136h = r100;
        return this;
    }

    public MarkerOptions endLevel(int r100) {
        this.D = r100;
        return this;
    }

    public MarkerOptions extraInfo(Bundle r100) {
        this.I = r100;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point r100) {
        this.f31152x = r100;
        this.f31151w = true;
        return this;
    }

    public MarkerOptions flat(boolean r100) {
        this.f31142n = r100;
        return this;
    }

    public MarkerOptions height(int r100) {
        if (r100 >= 0) goto L5;
        this.f31149u = 0;
        return this;
    L5:
        this.f31149u = r100;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor r100) {
        if (r100 == null) goto L6;
        this.f31130b = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> r100) {
        if (r100 == null) goto L19;
        if (r100.isEmpty() == false) goto L6;
        return this;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= r100.size()) goto L16;
        if (ListProtector.get(r100, r101) == null) goto L15;
        if (((BitmapDescriptor) ListProtector.get(r100, r101)).f30786a == null) goto L15;
        r101 = r101 + 1;
    L15:
        return this;
    L16:
        this.f31143o = r100;
        return this;
    L19:
        throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
    }

    public MarkerOptions infoWindow(InfoWindow r100) {
        this.f31154z = r100;
        return this;
    }

    public MarkerOptions interval(int r100) {
        if (r100 <= 0) goto L6;
        this.f31145q = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: marker's interval must be greater than zero ");
    }

    public MarkerOptions isForceDisPlay(boolean r100) {
        this.B = r100;
        return this;
    }

    public MarkerOptions isJoinCollision(boolean r100) {
        this.E = r100;
        return this;
    }

    public MarkerOptions period(int r100) {
        if (r100 <= 0) goto L6;
        this.f31144p = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
    }

    public MarkerOptions perspective(boolean r100) {
        this.f31135g = r100;
        return this;
    }

    public MarkerOptions poiCollided(boolean r100) {
        this.F = r100;
        return this;
    }

    public MarkerOptions position(LatLng r100) {
        if (r100 == null) goto L6;
        this.f31129a = r100;
        return this;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public MarkerOptions priority(int r100) {
        this.A = r100;
        return this;
    }

    public MarkerOptions rotate(float r100) {
    L3:
        if (r100 >= 0.0f) goto L5;
        r100 = r100 + 360.0f;
        goto L3
    L5:
        this.f31137i = r100 % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float r100) {
        if (r100 >= 0.0f) goto L5;
        return this;
    L5:
        this.f31146r = r100;
        return this;
    }

    public MarkerOptions scaleY(float r100) {
        if (r100 >= 0.0f) goto L5;
        return this;
    L5:
        this.f31147s = r100;
        return this;
    }

    public MarkerOptions startLevel(int r100) {
        this.C = r100;
        return this;
    }

    public MarkerOptions title(String r100) {
        this.f31139k = r100;
        return this;
    }

    public MarkerOptions titleOptions(TitleOptions r100) {
        this.f31138j = r100;
        return this;
    }

    public MarkerOptions visible(boolean r100) {
        this.H = r100;
        return this;
    }

    public MarkerOptions xOffset(int r100) {
        this.f31141m = r100;
        return this;
    }

    public MarkerOptions yOffset(int r100) {
        this.f31140l = r100;
        return this;
    }

    public MarkerOptions zIndex(int r100) {
        this.G = r100;
        return this;
    }

    public MarkerOptions anchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
    L13:
        return this;
    L5:
        if (r100 > 1.0f) goto L13;
        if (r101 < 0.0f) goto L13;
        if (r101 > 1.0f) goto L13;
        this.f31132d = r100;
        this.f31134f = r101;
        goto L13
    }
}
