package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;

/* JADX INFO: loaded from: classes39.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected z f33288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f33289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f33290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f33291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f33292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f33293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f33294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f33295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f33296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f33298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f33299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f33300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f33301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected double[] f33302o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected double[] f33303p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int[] f33304q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected GeoPoint f33305r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected GeoPoint f33306s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f33307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected JsonBuilder f33308u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f33309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f33310w;

    public abstract String a();

    public f(z r100) {
        this.f33298k = 5.0f;
        this.f33299l = false;
        this.f33300m = 0;
        this.f33301n = 0;
        this.f33305r = new GeoPoint(0, 0);
        this.f33306s = new GeoPoint(0, 0);
        this.f33307t = true;
        this.f33309v = -1;
        this.f33310w = 0;
        this.f33288a = r100;
    }

    public String a(int r100) {
        JsonBuilder r101 = new JsonBuilder();
        this.f33308u = r101;
        r101.object();
        int r102 = 0;
        if (r100 != 0) goto L17;
        this.f33308u.key("path").arrayValue();
        if (this.f33302o == null) goto L10;
        int r103 = 0;
    L7:
        double[] r104 = this.f33302o;
        if (r103 >= r104.length) goto L10;
        this.f33308u.value(r104[r103]);
        r103 = r103 + 1;
    L10:
        this.f33308u.endArrayValue();
        this.f33308u.key("arrColor").arrayValue();
        if (this.f33304q == null) goto L16;
        int r105 = 0;
    L13:
        int[] r106 = this.f33304q;
        if (r105 >= r106.length) goto L16;
        this.f33308u.value(r106[r105]);
        r105 = r105 + 1;
    L16:
        this.f33308u.endArrayValue();
        this.f33308u.key("useColorArray").value(this.f33294g);
    L34:
        this.f33308u.key("ud").value(String.valueOf(hashCode()));
        this.f33308u.key(MapBundleKey.MapObjKey.OBJ_DIR).value(0);
        z r107 = this.f33288a;
        if (r107 != null) goto L37;
    L39:
        int r108 = this.f33310w;
        if (r108 != 3) goto L42;
        this.f33308u.key("ty").value(3100);
    L45:
        this.f33308u.key(MapBundleKey.MapObjKey.OBJ_OFFSET).value(0);
        this.f33308u.key("in").value(0);
        this.f33308u.key(MapBundleKey.MapObjKey.OBJ_TEXT).value("");
        this.f33308u.key(MapBundleKey.MapObjKey.OBJ_DIS).value(0);
        this.f33308u.key("align").value(0);
        if (this.f33289b == false) goto L49;
        this.f33308u.key("dash").value(1);
        this.f33308u.key("ty").value(this.f33310w);
    L49:
        if (this.f33290c == false) goto L52;
        this.f33308u.key("trackMove").object();
        this.f33308u.key("pointStyle").value(((a0) this.f33288a).e());
        this.f33308u.endObject();
    L52:
        if (this.f33292e == false) goto L54;
        this.f33308u.key("cancelDataReduction").value(1);
    L56:
        if (this.f33293f == false) goto L58;
        this.f33308u.key("cancelSmooth").value(1);
    L60:
        if (this.f33297j == false) goto L62;
        this.f33308u.key("isTrackBloom").value(1);
        this.f33308u.key("bloomSpeed").value(this.f33298k);
    L64:
        if (this.f33291d == false) goto L82;
        this.f33308u.key("pointMove").object();
        if (this.f33295h == false) goto L68;
        this.f33308u.key("use3dPoint").value(1);
    L70:
        if (this.f33299l == false) goto L72;
        this.f33308u.key("duration").value(this.f33300m);
        this.f33308u.key("easingCurve").value(this.f33301n);
        this.f33299l = false;
    L73:
        this.f33308u.key("pointArray").arrayValue();
        if (this.f33303p == null) goto L78;
    L75:
        double[] r109 = this.f33303p;
        if (r102 >= r109.length) goto L78;
        this.f33308u.value(r109[r102]);
        r102 = r102 + 1;
    L78:
        this.f33308u.endArrayValue();
        if (TextUtils.isEmpty(this.f33296i) == true) goto L81;
        this.f33308u.key("imagePath").value(this.f33296i);
    L81:
        this.f33308u.endObject();
        goto L82
    L72:
        this.f33308u.key("duration").value(0);
        this.f33308u.key("easingCurve").value(0);
        goto L73
    L68:
        this.f33308u.key("use3dPoint").value(0);
    L82:
        this.f33308u.key("style").object();
        if (this.f33288a == null) goto L88;
        this.f33308u.key("width").value(this.f33288a.d());
        this.f33308u.key("color").value(z.c(this.f33288a.a()));
        int r110 = this.f33310w;
        if (r110 == 3) goto L87;
        if (r110 != 4) goto L88;
    L87:
        this.f33308u.key("scolor").value(z.c(this.f33288a.b()));
    L88:
        this.f33308u.endObject();
        this.f33308u.endObject();
        return this.f33308u.toString();
    L62:
        this.f33308u.key("isTrackBloom").value(0);
        goto L64
    L58:
        this.f33308u.key("cancelSmooth").value(0);
        goto L60
    L54:
        this.f33308u.key("cancelDataReduction").value(0);
        goto L56
    L42:
        if (r108 != 4) goto L44;
        this.f33308u.key("ty").value(3200);
        goto L45
    L44:
        this.f33308u.key("ty").value(-1);
        goto L45
    L37:
        if (r107.c() == 0) goto L39;
        this.f33308u.key(MapBundleKey.MapObjKey.OBJ_NORMALSTYTLE).value(this.f33288a.c());
        this.f33308u.key(MapBundleKey.MapObjKey.OBJ_FOCUSSTYTLE).value(this.f33288a.c());
        this.f33308u.key("ty").value(32);
        goto L45
    L17:
        if (r100 != 1) goto L34;
        this.f33308u.key("sgeo");
        this.f33308u.object();
        this.f33308u.key("bound").arrayValue();
        GeoPoint r111 = this.f33305r;
        if (r111 != null) goto L21;
    L23:
        this.f33308u.endArrayValue();
        if (this.f33310w != 4) goto L26;
        this.f33308u.key("type").value(3);
    L27:
        this.f33308u.key(SlcElement.KEY_ELEMENTS).arrayValue();
        this.f33308u.object();
        this.f33308u.key("points").arrayValue();
        if (this.f33302o == null) goto L33;
        int r112 = 0;
    L30:
        double[] r113 = this.f33302o;
        if (r112 >= r113.length) goto L33;
        this.f33308u.value(r113[r112]);
        r112 = r112 + 1;
    L33:
        this.f33308u.endArrayValue();
        this.f33308u.endObject();
        this.f33308u.endArrayValue();
        this.f33308u.endObject();
        goto L34
    L26:
        this.f33308u.key("type").value(this.f33310w);
        goto L27
    L21:
        if (this.f33306s == null) goto L23;
        this.f33308u.value(r111.getLongitude());
        this.f33308u.value(this.f33305r.getLatitude());
        this.f33308u.value(this.f33306s.getLongitude());
        this.f33308u.value(this.f33306s.getLatitude());
        goto L23
    }

    public void a(boolean r100, int r101, int r102) {
        this.f33299l = r100;
        this.f33300m = r101;
        this.f33301n = r102;
    }
}
