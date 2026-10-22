package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.util.JsonBuilder;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    protected z f9183a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9184b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9185c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9186d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9187e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9188f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9189g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9190h;

    /* renamed from: i, reason: collision with root package name */
    public String f9191i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9192j;

    /* renamed from: o, reason: collision with root package name */
    protected double[] f9197o;

    /* renamed from: p, reason: collision with root package name */
    protected double[] f9198p;

    /* renamed from: q, reason: collision with root package name */
    protected int[] f9199q;

    /* renamed from: u, reason: collision with root package name */
    protected JsonBuilder f9203u;

    /* renamed from: k, reason: collision with root package name */
    public float f9193k = 5.0f;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9194l = false;

    /* renamed from: m, reason: collision with root package name */
    private int f9195m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f9196n = 0;

    /* renamed from: r, reason: collision with root package name */
    protected GeoPoint f9200r = new GeoPoint(0, 0);

    /* renamed from: s, reason: collision with root package name */
    protected GeoPoint f9201s = new GeoPoint(0, 0);

    /* renamed from: t, reason: collision with root package name */
    protected boolean f9202t = true;

    /* renamed from: v, reason: collision with root package name */
    protected int f9204v = -1;

    /* renamed from: w, reason: collision with root package name */
    protected int f9205w = 0;

    public f(z zVar) {
        this.f9183a = zVar;
    }

    public abstract String a();

    public String a(int i4) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        this.f9203u = jsonBuilder;
        jsonBuilder.object();
        int i5 = 0;
        if (i4 == 0) {
            this.f9203u.key("path").arrayValue();
            if (this.f9197o != null) {
                int i6 = 0;
                while (true) {
                    double[] dArr = this.f9197o;
                    if (i6 >= dArr.length) {
                        break;
                    }
                    this.f9203u.value(dArr[i6]);
                    i6++;
                }
            }
            this.f9203u.endArrayValue();
            this.f9203u.key("arrColor").arrayValue();
            if (this.f9199q != null) {
                int i7 = 0;
                while (true) {
                    int[] iArr = this.f9199q;
                    if (i7 >= iArr.length) {
                        break;
                    }
                    this.f9203u.value(iArr[i7]);
                    i7++;
                }
            }
            this.f9203u.endArrayValue();
            this.f9203u.key("useColorArray").value(this.f9189g);
        } else if (i4 == 1) {
            this.f9203u.key("sgeo");
            this.f9203u.object();
            this.f9203u.key("bound").arrayValue();
            GeoPoint geoPoint = this.f9200r;
            if (geoPoint != null && this.f9201s != null) {
                this.f9203u.value(geoPoint.getLongitude());
                this.f9203u.value(this.f9200r.getLatitude());
                this.f9203u.value(this.f9201s.getLongitude());
                this.f9203u.value(this.f9201s.getLatitude());
            }
            this.f9203u.endArrayValue();
            if (this.f9205w == 4) {
                this.f9203u.key("type").value(3);
            } else {
                this.f9203u.key("type").value(this.f9205w);
            }
            this.f9203u.key("elements").arrayValue();
            this.f9203u.object();
            this.f9203u.key("points").arrayValue();
            if (this.f9197o != null) {
                int i8 = 0;
                while (true) {
                    double[] dArr2 = this.f9197o;
                    if (i8 >= dArr2.length) {
                        break;
                    }
                    this.f9203u.value(dArr2[i8]);
                    i8++;
                }
            }
            this.f9203u.endArrayValue();
            this.f9203u.endObject();
            this.f9203u.endArrayValue();
            this.f9203u.endObject();
        }
        this.f9203u.key("ud").value(String.valueOf(hashCode()));
        this.f9203u.key(MapBundleKey.MapObjKey.OBJ_DIR).value(0);
        z zVar = this.f9183a;
        if (zVar == null || zVar.c() == 0) {
            int i9 = this.f9205w;
            if (i9 == 3) {
                this.f9203u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(3100);
            } else if (i9 == 4) {
                this.f9203u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(3200);
            } else {
                this.f9203u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(-1);
            }
        } else {
            this.f9203u.key(MapBundleKey.MapObjKey.OBJ_NORMALSTYTLE).value(this.f9183a.c());
            this.f9203u.key(MapBundleKey.MapObjKey.OBJ_FOCUSSTYTLE).value(this.f9183a.c());
            this.f9203u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(32);
        }
        this.f9203u.key(MapBundleKey.MapObjKey.OBJ_OFFSET).value(0);
        this.f9203u.key("in").value(0);
        this.f9203u.key(MapBundleKey.MapObjKey.OBJ_TEXT).value("");
        this.f9203u.key(MapBundleKey.MapObjKey.OBJ_DIS).value(0);
        this.f9203u.key("align").value(0);
        if (this.f9184b) {
            this.f9203u.key("dash").value(1);
            this.f9203u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(this.f9205w);
        }
        if (this.f9185c) {
            this.f9203u.key("trackMove").object();
            this.f9203u.key("pointStyle").value(((a0) this.f9183a).e());
            this.f9203u.endObject();
        }
        if (this.f9187e) {
            this.f9203u.key("cancelDataReduction").value(1);
        } else {
            this.f9203u.key("cancelDataReduction").value(0);
        }
        if (this.f9188f) {
            this.f9203u.key("cancelSmooth").value(1);
        } else {
            this.f9203u.key("cancelSmooth").value(0);
        }
        if (this.f9192j) {
            this.f9203u.key("isTrackBloom").value(1);
            this.f9203u.key("bloomSpeed").value(this.f9193k);
        } else {
            this.f9203u.key("isTrackBloom").value(0);
        }
        if (this.f9186d) {
            this.f9203u.key("pointMove").object();
            if (this.f9190h) {
                this.f9203u.key("use3dPoint").value(1);
            } else {
                this.f9203u.key("use3dPoint").value(0);
            }
            if (this.f9194l) {
                this.f9203u.key("duration").value(this.f9195m);
                this.f9203u.key("easingCurve").value(this.f9196n);
                this.f9194l = false;
            } else {
                this.f9203u.key("duration").value(0);
                this.f9203u.key("easingCurve").value(0);
            }
            this.f9203u.key("pointArray").arrayValue();
            if (this.f9198p != null) {
                while (true) {
                    double[] dArr3 = this.f9198p;
                    if (i5 >= dArr3.length) {
                        break;
                    }
                    this.f9203u.value(dArr3[i5]);
                    i5++;
                }
            }
            this.f9203u.endArrayValue();
            if (!TextUtils.isEmpty(this.f9191i)) {
                this.f9203u.key("imagePath").value(this.f9191i);
            }
            this.f9203u.endObject();
        }
        this.f9203u.key("style").object();
        if (this.f9183a != null) {
            this.f9203u.key("width").value(this.f9183a.d());
            this.f9203u.key("color").value(z.c(this.f9183a.a()));
            int i10 = this.f9205w;
            if (i10 == 3 || i10 == 4) {
                this.f9203u.key("scolor").value(z.c(this.f9183a.b()));
            }
        }
        this.f9203u.endObject();
        this.f9203u.endObject();
        return this.f9203u.toString();
    }

    public void a(boolean z4, int i4, int i5) {
        this.f9194l = z4;
        this.f9195m = i4;
        this.f9196n = i5;
    }
}
