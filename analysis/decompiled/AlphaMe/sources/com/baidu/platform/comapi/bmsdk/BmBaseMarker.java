package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BmBaseMarker extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private double f8608i;

    /* renamed from: j, reason: collision with root package name */
    private double f8609j;

    /* renamed from: k, reason: collision with root package name */
    private double f8610k;

    /* renamed from: l, reason: collision with root package name */
    private int f8611l;

    /* renamed from: m, reason: collision with root package name */
    private int f8612m;

    /* renamed from: n, reason: collision with root package name */
    private int f8613n;

    /* renamed from: o, reason: collision with root package name */
    private float f8614o;

    /* renamed from: p, reason: collision with root package name */
    private float f8615p;

    /* renamed from: q, reason: collision with root package name */
    private float f8616q;

    /* renamed from: r, reason: collision with root package name */
    private float f8617r;

    /* renamed from: s, reason: collision with root package name */
    private String f8618s;

    /* renamed from: t, reason: collision with root package name */
    private String f8619t;

    /* renamed from: u, reason: collision with root package name */
    private String f8620u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<BmRichView> f8621v;

    private BmBaseMarker() {
        super(3, 0L);
        this.f8608i = 0.0d;
        this.f8609j = 0.0d;
        this.f8610k = 0.0d;
        this.f8611l = 0;
        this.f8612m = 0;
        this.f8613n = 0;
        this.f8614o = Property.DEFAULT_FLOAT_VALUE;
        this.f8615p = 1.0f;
        this.f8616q = 1.0f;
        this.f8617r = 1.0f;
        this.f8618s = "";
        this.f8619t = "";
        this.f8620u = "";
        this.f8621v = new ArrayList<>();
    }

    private static native boolean nativeAddRichView(long j4, long j5);

    private static native boolean nativeClearRichViews(long j4);

    private static native boolean nativeRemoveRichView(long j4, long j5);

    private static native boolean nativeSetAnchorX(long j4, float f4);

    private static native boolean nativeSetAnchorY(long j4, float f4);

    private static native boolean nativeSetBuildingId(long j4, String str);

    private static native boolean nativeSetCollisionBehavior(long j4, int i4);

    private static native boolean nativeSetCollisionPriority(long j4, int i4);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j4, boolean z4);

    private static native boolean nativeSetFixX(long j4, int i4);

    private static native boolean nativeSetFixY(long j4, int i4);

    private static native boolean nativeSetFloorId(long j4, String str);

    private static native boolean nativeSetFollowMapRotateAxis(long j4, int i4);

    private static native boolean nativeSetHeight(long j4, int i4);

    private static native boolean nativeSetId(long j4, String str);

    private static native boolean nativeSetIsFix(long j4, int i4);

    private static native boolean nativeSetLocated(long j4, int i4);

    private static native boolean nativeSetOffsetX(long j4, int i4, int i5);

    private static native boolean nativeSetOffsetY(long j4, int i4, int i5);

    private static native boolean nativeSetPerspective(long j4, int i4);

    private static native boolean nativeSetRotate(long j4, float f4);

    private static native boolean nativeSetRotateFeature(long j4, int i4);

    private static native boolean nativeSetScale(long j4, float f4);

    private static native boolean nativeSetScaleX(long j4, float f4);

    private static native boolean nativeSetScaleY(long j4, float f4);

    private static native boolean nativeSetTrackBy(long j4, int i4);

    private static native boolean nativeSetWidth(long j4, int i4);

    private static native boolean nativeSetX(long j4, double d4);

    private static native boolean nativeSetXYZ(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetY(long j4, double d4);

    private static native boolean nativeSetZ(long j4, double d4);

    public boolean a(b bVar) {
        double d4 = bVar.f8679a;
        this.f8608i = d4;
        double d5 = bVar.f8680b;
        this.f8609j = d5;
        double d6 = bVar.f8681c;
        this.f8610k = d6;
        return nativeSetXYZ(this.nativeInstance, d4, d5, d6);
    }

    public boolean b(float f4) {
        return nativeSetAnchorX(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        return nativeSetAnchorY(this.nativeInstance, f4);
    }

    public boolean d(float f4) {
        this.f8614o = f4;
        return nativeSetRotate(this.nativeInstance, f4);
    }

    public boolean e(float f4) {
        this.f8615p = f4;
        this.f8616q = f4;
        return nativeSetScale(this.nativeInstance, f4);
    }

    public boolean f(float f4) {
        this.f8615p = f4;
        return nativeSetScaleX(this.nativeInstance, f4);
    }

    public boolean g(int i4) {
        return nativeSetFixX(this.nativeInstance, i4);
    }

    public boolean h(int i4) {
        return nativeSetFixY(this.nativeInstance, i4);
    }

    public boolean i(int i4) {
        return nativeSetFollowMapRotateAxis(this.nativeInstance, i4);
    }

    public boolean j(int i4) {
        return nativeSetIsFix(this.nativeInstance, i4);
    }

    public boolean k(int i4) {
        this.f8611l = i4;
        return nativeSetLocated(this.nativeInstance, i4);
    }

    public boolean l(int i4) {
        return a(i4, d.NO_SCALE_DPI);
    }

    public boolean m(int i4) {
        return b(i4, d.NO_SCALE_DPI);
    }

    public boolean n(int i4) {
        return nativeSetPerspective(this.nativeInstance, i4);
    }

    public boolean b(int i4, d dVar) {
        this.f8613n = i4;
        return nativeSetOffsetY(this.nativeInstance, i4, dVar.a());
    }

    public boolean c() {
        this.f8621v.clear();
        return nativeClearRichViews(this.nativeInstance);
    }

    public boolean g(float f4) {
        this.f8616q = f4;
        return nativeSetScaleY(this.nativeInstance, f4);
    }

    public boolean f(int i4) {
        long j4 = this.nativeInstance;
        if (i4 < 0) {
            i4 = 0;
        }
        return nativeSetCollisionPriority(j4, i4);
    }

    public boolean b(BmRichView bmRichView) {
        this.f8621v.remove(bmRichView);
        return nativeRemoveRichView(this.nativeInstance, bmRichView.getNativeInstance());
    }

    public boolean e(int i4) {
        return nativeSetCollisionBehavior(this.nativeInstance, i4);
    }

    public boolean a(int i4, d dVar) {
        this.f8612m = i4;
        return nativeSetOffsetX(this.nativeInstance, i4, dVar.a());
    }

    public BmBaseUI b(long j4) {
        if (j4 == 0) {
            return null;
        }
        Iterator<BmRichView> it = this.f8621v.iterator();
        while (it.hasNext()) {
            BmBaseUI bmBaseUIA = it.next().a(j4);
            if (bmBaseUIA != null) {
                return bmBaseUIA;
            }
        }
        return null;
    }

    public boolean a(BmRichView bmRichView) {
        this.f8621v.add(bmRichView);
        return nativeAddRichView(this.nativeInstance, bmRichView.getNativeInstance());
    }

    public boolean a(String str) {
        return nativeSetId(this.nativeInstance, str);
    }

    public BmBaseMarker(int i4, long j4) {
        super(i4, j4);
        this.f8608i = 0.0d;
        this.f8609j = 0.0d;
        this.f8610k = 0.0d;
        this.f8611l = 0;
        this.f8612m = 0;
        this.f8613n = 0;
        this.f8614o = Property.DEFAULT_FLOAT_VALUE;
        this.f8615p = 1.0f;
        this.f8616q = 1.0f;
        this.f8617r = 1.0f;
        this.f8618s = "";
        this.f8619t = "";
        this.f8620u = "";
        this.f8621v = new ArrayList<>();
    }
}
