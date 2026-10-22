package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public class v0 {
    private int A;
    private int B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f28149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f28150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MotionEvent f28152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MotionEvent f28153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f28154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f28155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f28156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f28157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f28158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f28159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f28160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f28161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f28162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f28163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f28164p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f28165q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final float f28166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f28167s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f28168t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f28169u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f28170v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f28171w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f28172x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f28173y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f28174z;

    public interface a {
    }

    private void j() {
        MotionEvent r100 = this.f28152d;
        if (r100 == null) goto L5;
        r100.recycle();
        this.f28152d = null;
    L5:
        MotionEvent r101 = this.f28153e;
        if (r101 == null) goto L8;
        r101.recycle();
        this.f28153e = null;
    L8:
        this.f28169u = false;
        this.f28151c = false;
        this.f28171w = -1;
        this.f28172x = -1;
        this.f28170v = false;
    }

    public float h() {
        if (this.f28162n != (-1.0f)) goto L12;
        if (this.f28160l != (-1.0f)) goto L7;
        float r100 = this.f28158j;
        float r101 = this.f28159k;
        this.f28160l = (float) Math.sqrt((r100 * r100) + (r101 * r101));
    L7:
        float r102 = this.f28160l;
        if (this.f28161m != (-1.0f)) goto L10;
        float r103 = this.f28156h;
        float r104 = this.f28157i;
        this.f28161m = (float) Math.sqrt((r103 * r103) + (r104 * r104));
    L10:
        this.f28162n = r102 / this.f28161m;
    L12:
        return this.f28162n;
    }

    public float a() {
        return this.f28158j;
    }

    public float b() {
        return this.f28159k;
    }

    public MotionEvent c() {
        return this.f28153e;
    }

    public float d() {
        return this.f28154f;
    }

    public float e() {
        return this.f28155g;
    }

    public float f() {
        return this.f28156h;
    }

    public float g() {
        return this.f28157i;
    }

    public long i() {
        return this.f28165q;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_mapcore_util_v0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void b(MotionEvent r110) {
        MotionEvent r100 = this.f28153e;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f28153e = MotionEvent.obtain(r110);
        this.f28160l = -1.0f;
        this.f28161m = -1.0f;
        this.f28162n = -1.0f;
        MotionEvent r101 = this.f28152d;
        int r102 = r101.findPointerIndex(this.f28171w);
        int r103 = r101.findPointerIndex(this.f28172x);
        int r104 = r110.findPointerIndex(this.f28171w);
        int r105 = r110.findPointerIndex(this.f28172x);
        if (r102 < 0) goto L13;
        if (r103 < 0) goto L13;
        if (r104 < 0) goto L13;
        if (r105 < 0) goto L13;
        float r106 = r101.getX(r102);
        float r107 = r101.getY(r102);
        float r108 = r101.getX(r103);
        float r109 = r101.getY(r103);
        float r111 = r110.getX(r104);
        float r112 = r110.getY(r104);
        float r113 = r110.getX(r105);
        float r114 = r113 - r111;
        float r115 = r110.getY(r105) - r112;
        this.f28156h = r108 - r106;
        this.f28157i = r109 - r107;
        this.f28158j = r114;
        this.f28159k = r115;
        this.f28154f = r111 + (r114 * 0.5f);
        this.f28155g = r112 + (r115 * 0.5f);
        this.f28165q = r110.getEventTime() - r101.getEventTime();
        this.f28163o = r110.getPressure(r104) + r110.getPressure(r105);
        this.f28164p = r101.getPressure(r102) + r101.getPressure(r103);
        return;
    L13:
        this.f28170v = true;
        if (this.f28151c == false) goto L17;
        w0.a r116 = (w0.a) this.f28150b;
        r116.getClass();
        r116.c((w0) this);
        return;
    }

    public boolean a(MotionEvent r110) {
        int r100 = r110.getAction() & 255;
        if (r100 != 0) goto L5;
        j();
    L5:
        boolean r101 = false;
        if (this.f28170v == true) goto L180;
        int r102 = -1;
        if (this.f28151c == true) goto L130;
        if (r100 == 0) goto L129;
        if (r100 != 1) goto L13;
        j();
    L178:
        return true;
    L13:
        if (r100 == 2) goto L89;
        if (r100 == 5) goto L41;
        if (r100 != 6) goto L178;
        if (this.f28169u == false) goto L178;
        int r103 = r110.getPointerCount();
        int r104 = r110.getActionIndex();
        int r105 = r110.getPointerId(r104);
        if (r103 <= 2) goto L31;
        int r106 = this.f28171w;
        if (r105 != r106) goto L27;
        int r107 = a(r110, this.f28172x, r104);
        if (r107 < 0) goto L178;
        this.f28171w = r110.getPointerId(r107);
        goto L178
    L27:
        if (r105 != this.f28172x) goto L178;
        int r108 = a(r110, r106, r104);
        if (r108 < 0) goto L178;
        this.f28172x = r110.getPointerId(r108);
        goto L178
    L31:
        int r109 = this.f28171w;
        if (r105 != r109) goto L34;
        r109 = this.f28172x;
    L34:
        int r111 = r110.findPointerIndex(r109);
        if (r111 >= 0) goto L40;
        this.f28170v = true;
        if (this.f28151c == false) goto L39;
        w0.a r112 = (w0.a) this.f28150b;
        r112.getClass();
        r112.c((w0) this);
    L39:
        return false;
    L40:
        this.f28171w = r110.getPointerId(r111);
        this.f28173y = true;
        this.f28172x = -1;
        this.f28154f = r110.getX(r111);
        this.f28155g = r110.getY(r111);
        goto L178
    L41:
        int r113 = this.f28174z;
        if (r113 == 0) goto L47;
        int r114 = this.A;
        if (r114 == 0) goto L47;
        float r115 = this.f28166r;
        this.f28167s = r113 - r115;
        this.f28168t = r114 - r115;
    L48:
        MotionEvent r116 = this.f28152d;
        if (r116 == null) goto L51;
        r116.recycle();
    L51:
        this.f28152d = MotionEvent.obtain(r110);
        this.f28165q = 0;
        int r117 = r110.getActionIndex();
        int r118 = r110.findPointerIndex(this.f28171w);
        int r119 = r110.getPointerId(r117);
        this.f28172x = r119;
        if (r118 < 0) goto L54;
        if (r118 == r117) goto L54;
    L58:
        this.f28173y = false;
        b(r110);
        float r120 = this.f28166r;
        float r121 = this.f28167s;
        float r122 = this.f28168t;
        float r123 = a(r110, r118);
        float r124 = b(r110, r118);
        float r125 = a(r110, r117);
        float r126 = b(r110, r117);
        if (r123 >= r120) goto L61;
    L68:
        boolean r127 = true;
    L70:
        if (r125 >= r120) goto L72;
    L79:
        boolean r128 = true;
    L80:
        if (r127 == false) goto L83;
        if (r128 == false) goto L83;
        this.f28154f = -1.0f;
        this.f28155g = -1.0f;
        this.f28169u = true;
    L83:
        if (r127 == false) goto L85;
        this.f28154f = r110.getX(r117);
        this.f28155g = r110.getY(r117);
        this.f28169u = true;
        goto L178
    L85:
        if (r128 == false) goto L87;
        this.f28154f = r110.getX(r118);
        this.f28155g = r110.getY(r118);
        this.f28169u = true;
        goto L178
    L87:
        this.f28169u = false;
        ((w0.a) this.f28150b).a(this);
        this.f28151c = true;
        goto L178
    L72:
        if (r126 < r120) goto L79;
        if (r125 > r121) goto L79;
        if (r126 > r122) goto L79;
        r128 = false;
        goto L80
    L61:
        if (r124 < r120) goto L68;
        if (r123 > r121) goto L68;
        if (r124 > r122) goto L68;
        r127 = false;
    L54:
        if (r118 == r117) goto L57;
        r102 = r119;
    L57:
        r118 = a(r110, r102, r118);
        this.f28171w = r110.getPointerId(r118);
    L47:
        DisplayMetrics r129 = INVOKEVIRTUAL_com_amap_api_mapcore_util_v0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.f28149a.getResources());
        float r130 = r129.widthPixels;
        float r131 = this.f28166r;
        this.f28167s = r130 - r131;
        this.f28168t = r129.heightPixels - r131;
        goto L48
    L89:
        if (this.f28169u == false) goto L178;
        float r132 = this.f28166r;
        float r133 = this.f28167s;
        float r134 = this.f28168t;
        int r135 = r110.findPointerIndex(this.f28171w);
        int r136 = r110.findPointerIndex(this.f28172x);
        float r137 = a(r110, r135);
        float r138 = b(r110, r135);
        float r139 = a(r110, r136);
        float r140 = b(r110, r136);
        if (r137 >= r132) goto L93;
    L100:
        boolean r141 = true;
    L102:
        if (r139 >= r132) goto L104;
    L111:
        boolean r142 = true;
    L112:
        if (r141 == false) goto L116;
        int r143 = a(r110, this.f28172x, r135);
        if (r143 < 0) goto L116;
        this.f28171w = r110.getPointerId(r143);
        a(r110, r143);
        b(r110, r143);
        r135 = r143;
        r141 = false;
    L116:
        if (r142 == false) goto L120;
        int r144 = a(r110, this.f28171w, r136);
        if (r144 < 0) goto L120;
        this.f28172x = r110.getPointerId(r144);
        a(r110, r144);
        b(r110, r144);
        r136 = r144;
        r142 = false;
    L120:
        if (r141 == false) goto L123;
        if (r142 == false) goto L123;
        this.f28154f = -1.0f;
        this.f28155g = -1.0f;
    L123:
        if (r141 == false) goto L125;
        this.f28154f = r110.getX(r136);
        this.f28155g = r110.getY(r136);
        goto L178
    L125:
        if (r142 == false) goto L127;
        this.f28154f = r110.getX(r135);
        this.f28155g = r110.getY(r135);
        goto L178
    L127:
        this.f28169u = false;
        ((w0.a) this.f28150b).a(this);
        this.f28151c = true;
        goto L178
    L104:
        if (r140 < r132) goto L111;
        if (r139 > r133) goto L111;
        if (r140 > r134) goto L111;
        r142 = false;
        goto L112
    L93:
        if (r138 < r132) goto L100;
        if (r137 > r133) goto L100;
        if (r138 > r134) goto L100;
        r141 = false;
        goto L102
    L129:
        this.f28171w = r110.getPointerId(0);
        this.f28173y = true;
        goto L178
    L130:
        if (r100 == 1) goto L177;
        if (r100 != 2) goto L133;
        b(r110);
        if ((this.f28163o / this.f28164p) <= 0.67f) goto L178;
        w0.a r145 = (w0.a) this.f28150b;
        r145.getClass();
        if (r145.a((w0) this) == false) goto L178;
        this.f28152d.recycle();
        this.f28152d = MotionEvent.obtain(r110);
        goto L178
    L133:
        if (r100 == 3) goto L171;
        if (r100 == 5) goto L157;
        if (r100 != 6) goto L178;
        int r146 = r110.getPointerCount();
        int r147 = r110.getActionIndex();
        int r148 = r110.getPointerId(r147);
        if (r146 <= 2) goto L151;
        int r149 = this.f28171w;
        if (r148 != r149) goto L145;
        int r150 = a(r110, this.f28172x, r147);
        if (r150 < 0) goto L149;
        w0.a r151 = (w0.a) this.f28150b;
        r151.getClass();
        r151.c((w0) this);
        this.f28171w = r110.getPointerId(r150);
        this.f28173y = true;
        this.f28152d = MotionEvent.obtain(r110);
        b(r110);
        ((w0.a) this.f28150b).a(this);
        this.f28151c = true;
    L150:
        this.f28152d.recycle();
        this.f28152d = MotionEvent.obtain(r110);
        b(r110);
    L152:
        if (r101 == false) goto L178;
        b(r110);
        int r152 = this.f28171w;
        if (r148 != r152) goto L156;
        r152 = this.f28172x;
    L156:
        int r153 = r110.findPointerIndex(r152);
        this.f28154f = r110.getX(r153);
        this.f28155g = r110.getY(r153);
        w0.a r154 = (w0.a) this.f28150b;
        r154.getClass();
        r154.c((w0) this);
        j();
        this.f28171w = r152;
        this.f28173y = true;
    L149:
        r101 = true;
        goto L150
    L145:
        if (r148 != this.f28172x) goto L150;
        int r155 = a(r110, r149, r147);
        if (r155 < 0) goto L149;
        w0.a r156 = (w0.a) this.f28150b;
        r156.getClass();
        r156.c((w0) this);
        this.f28172x = r110.getPointerId(r155);
        this.f28173y = false;
        this.f28152d = MotionEvent.obtain(r110);
        b(r110);
        ((w0.a) this.f28150b).a(this);
        this.f28151c = true;
        goto L150
    L151:
        r101 = true;
        goto L152
    L157:
        w0.a r157 = (w0.a) this.f28150b;
        r157.getClass();
        r157.c((w0) this);
        int r158 = this.f28171w;
        int r159 = this.f28172x;
        j();
        this.f28152d = MotionEvent.obtain(r110);
        if (this.f28173y == true) goto L161;
        r158 = r159;
    L161:
        this.f28171w = r158;
        this.f28172x = r110.getPointerId(r110.getActionIndex());
        this.f28173y = false;
        int r160 = r110.findPointerIndex(this.f28171w);
        if (r160 >= 0) goto L164;
    L165:
        int r161 = this.f28171w;
        int r162 = this.f28172x;
        if (r161 == r162) goto L169;
        r102 = r162;
    L169:
        this.f28171w = r110.getPointerId(a(r110, r102, r160));
    L170:
        b(r110);
        ((w0.a) this.f28150b).a(this);
        this.f28151c = true;
        goto L178
    L164:
        if (this.f28171w != this.f28172x) goto L170;
    L171:
        w0.a r163 = (w0.a) this.f28150b;
        r163.getClass();
        r163.c((w0) this);
        j();
        goto L178
    L177:
        j();
        goto L178
    L180:
        return false;
    }

    public v0(Context r100, a r101) {
        this.f28174z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        ViewConfiguration r102 = ViewConfiguration.get(r100);
        this.f28149a = r100;
        this.f28150b = r101;
        this.f28166r = r102.getScaledEdgeSlop();
    }

    private float a(MotionEvent r100, int r101) {
        if (this.f28174z <= 0) goto L9;
        if (this.A <= 0) goto L9;
        return s0.a(r100, r101, this.B);
    L9:
        return s0.a(r100, r101);
    }

    private float b(MotionEvent r100, int r101) {
        if (this.f28174z <= 0) goto L9;
        if (this.A <= 0) goto L9;
        return s0.b(r100, r101, this.C);
    L9:
        return s0.b(r100, r101);
    }

    private int a(MotionEvent r100, int r110, int r111) {
        int r101 = r100.getPointerCount();
        int r112 = r100.findPointerIndex(r110);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L16;
        if (r102 == r111) goto L15;
        if (r102 == r112) goto L15;
        float r103 = this.f28166r;
        float r104 = this.f28167s;
        float r105 = this.f28168t;
        float r106 = a(r100, r102);
        float r107 = b(r100, r102);
        if (r106 < r103) goto L15;
        if (r107 < r103) goto L15;
        if (r106 > r104) goto L15;
        if (r107 > r105) goto L15;
        return r102;
    L15:
        r102 = r102 + 1;
        goto L3
    L16:
        return -1;
    }

    public void a(int r100, int r101, int r102, int r103) {
        this.f28174z = r100;
        this.A = r101;
        this.B = r102;
        this.C = r103;
    }
}
