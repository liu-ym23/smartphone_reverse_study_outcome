package com.bytedance.android.ecom.arch.slice.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bytedance.android.ecom.arch.slice.render.k;
import com.bytedance.android.ecom.arch.slice.render.m;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import vq.e;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f50017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<uq.a> f50020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vq.b f50021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f50022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f50023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f50024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f50025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f50026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f50027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f50028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Rect f50029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f50030o;

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.background.a$a, reason: collision with other inner class name */
    public static final class C0854a {
    }

    static {
    }

    public final Paint a() {
        Paint r100 = this.f50025j;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(1);
        this.f50025j = r101;
        return r101;
    L6:
        return r100;
    }

    public final Paint b() {
        Paint r100 = this.f50024i;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(6);
        this.f50024i = r101;
        return r101;
    L6:
        return r100;
    }

    public final Rect d() {
        Rect r100 = this.f50022g;
        if (r100 != null) goto L6;
        Rect r101 = new Rect();
        this.f50022g = r101;
        return r101;
    L6:
        return r100;
    }

    public final Paint e() {
        Paint r100 = this.f50026k;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(1);
        this.f50026k = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        Bitmap r100 = this.f50017b;
        if (r100 == null) goto L14;
        if (r100 == null) goto L6;
        boolean r101 = r100.hasAlpha();
    L7:
        if (r101 == true) goto L14;
        if (b().getAlpha() != 255) goto L14;
        if (this.f50030o == false) goto L14;
        return -1;
    L6:
        r101 = false;
    L14:
        if (Color.alpha(this.f50016a) == 255) goto L19;
        return -3;
    L19:
        return -1;
    }

    public final void h() {
        if (d().isEmpty() == true) goto L10;
        vq.b r100 = this.f50021f;
        if (r100 == null) goto L7;
        int r101 = e.f556754a;
        LinearGradient r102 = e.a(d(), r100);
    L8:
        e().setShader(r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public a() {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        c r100 = this.f50023h;
        if (r100 == null) goto L5;
        com.bytedance.android.ecom.arch.slice.render.widget.background.b r101 = r100.f50047m;
    L6:
        boolean r102 = false;
        if (r101 == null) goto L67;
        if (r100 == null) goto L67;
        if (r100.f50046l == false) goto L14;
        Rect r103 = getBounds();
        r100.a(r103.left, r103.top, r103.right, r103.bottom);
    L14:
        if (r100.f50049o == false) goto L44;
        Rect r104 = getBounds();
        Intrinsics.checkNotNullParameter(r104, "bounds");
        com.bytedance.android.ecom.arch.slice.render.widget.background.b r105 = r100.f50047m;
        if (r100.f50049o == false) goto L44;
        if (r105 == null) goto L44;
        r100.f50049o = false;
        int r106 = r100.f50035a;
        float r107 = 0.0f;
        if (r106 <= 0) goto L22;
        float r108 = RangesKt.coerceAtLeast(r106 + r105.f50896c, 0.0f);
    L23:
        int r109 = r100.f50037c;
        if (r109 <= 0) goto L26;
        float r111 = RangesKt.coerceAtLeast(r109 + r105.f50896c, 0.0f);
    L27:
        int r112 = r100.f50038d;
        if (r112 <= 0) goto L30;
        float r113 = RangesKt.coerceAtLeast(r112 + r105.f50896c, 0.0f);
    L31:
        int r114 = r100.f50036b;
        if (r114 <= 0) goto L34;
        r107 = RangesKt.coerceAtLeast(r114 + r105.f50896c, 0.0f);
    L34:
        float r115 = -r105.f50896c;
        float r116 = r104.width();
        float r117 = r105.f50896c;
        float r118 = r116 + r117;
        float r119 = -r117;
        float r120 = r104.height() + r105.f50896c;
        RectF r121 = r100.f50050p;
        if (r121 != null) goto L37;
        r121 = new RectF();
        r100.f50050p = r121;
    L37:
        r121.set(r115, r119, r118, r120);
        float[] r122 = r100.f50051q;
        if (r122 != null) goto L40;
        r122 = new float[8];
        r100.f50051q = r122;
    L40:
        r122[0] = r108;
        r122[1] = r108;
        r122[2] = r111;
        r122[3] = r111;
        r122[4] = r113;
        r122[5] = r113;
        r122[6] = r107;
        r122[7] = r107;
        Path r123 = r100.f50048n;
        if (r123 != null) goto L43;
        r123 = new Path();
        r100.f50048n = r123;
    L43:
        r123.reset();
        r123.addRoundRect(r121, r122, Path.Direction.CCW);
        goto L44
    L30:
        r113 = 0.0f;
        goto L31
    L26:
        r111 = 0.0f;
        goto L27
    L22:
        r108 = 0.0f;
    L44:
        r110.save();
        if (Build.VERSION.SDK_INT < 28) goto L50;
        Path r124 = r100.f50045k;
        if (r124 != null) goto L49;
        r124 = new Path();
        r100.f50045k = r124;
    L49:
        r110.clipOutPath(r124);
    L54:
        com.bytedance.android.ecom.arch.slice.render.widget.background.b r125 = r100.f50047m;
        if (r125 != null) goto L57;
        r125 = new com.bytedance.android.ecom.arch.slice.render.widget.background.b();
        r100.f50047m = r125;
    L57:
        float r126 = r125.f50894a;
        com.bytedance.android.ecom.arch.slice.render.widget.background.b r127 = r100.f50047m;
        if (r127 != null) goto L60;
        r127 = new com.bytedance.android.ecom.arch.slice.render.widget.background.b();
        r100.f50047m = r127;
    L60:
        r110.translate(r126, r127.f50895b);
        Path r128 = r100.f50048n;
        if (r128 != null) goto L63;
        r128 = new Path();
        r100.f50048n = r128;
    L63:
        Paint r129 = this.f50028m;
        if (r129 != null) goto L66;
        r129 = new Paint(1);
        this.f50028m = r129;
    L66:
        r110.drawPath(r128, r129);
        r110.restore();
        goto L67
    L50:
        Path r130 = r100.f50045k;
        if (r130 != null) goto L53;
        r130 = new Path();
        r100.f50045k = r130;
    L53:
        r110.clipPath(r130, Region.Op.DIFFERENCE);
    L67:
        int r131 = this.f50016a;
        if (r131 == 0) goto L70;
    L73:
        if (r100 != null) goto L75;
    L116:
        if (r131 == 0) goto L118;
        r110.drawRect(getBounds(), a());
    L118:
        Bitmap r132 = this.f50017b;
        if (r132 == null) goto L125;
        Rect r133 = this.f50029n;
        if (r133 != null) goto L123;
        r133 = new Rect();
        this.f50029n = r133;
    L123:
        r110.drawBitmap(r132, null, r133, b());
    L125:
        if (this.f50021f == null) goto L131;
        r110.drawRect(d(), e());
        return;
    L131:
        return;
    L75:
        if (r100.f50039e == true) goto L77;
    L79:
        boolean r134 = false;
    L80:
        if (r134 == false) goto L116;
        if (r100.f50046l == false) goto L84;
        Rect r135 = getBounds();
        r100.a(r135.left, r135.top, r135.right, r135.bottom);
    L84:
        Path r136 = r100.f50045k;
        if (r136 != null) goto L88;
        r136 = new Path();
        r100.f50045k = r136;
    L88:
        if (this.f50016a == 0) goto L91;
        r110.drawPath(r136, a());
    L91:
        if (this.f50017b == null) goto L93;
        boolean r137 = true;
    L95:
        if (this.f50021f == null) goto L97;
        r102 = true;
    L97:
        if (r137 == true) goto L100;
        if (r102 == true) goto L100;
        return;
    L100:
        if (r137 == true) goto L105;
        if (r102 == false) goto L105;
        if (Intrinsics.areEqual(d(), getBounds()) == false) goto L105;
        r110.drawPath(r136, e());
        return;
    L105:
        int r138 = r110.save();
        r110.clipPath(r136);
        if (r137 == false) goto L113;
        Bitmap r139 = this.f50017b;
        if (r139 == null) goto L113;
        Rect r140 = this.f50029n;
        if (r140 != null) goto L112;
        r140 = new Rect();
        this.f50029n = r140;
    L112:
        r110.drawBitmap(r139, null, r140, b());
    L113:
        if (r102 == false) goto L115;
        r110.drawRect(d(), e());
    L115:
        r110.restoreToCount(r138);
        return;
    L93:
        r137 = false;
        goto L95
    L77:
        if (r100.f50042h == true) goto L79;
        r134 = true;
        goto L80
    L70:
        if (this.f50017b != null) goto L73;
        if (this.f50021f != null) goto L73;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void f(String r100) {
        Integer r101 = com.bytedance.android.ecom.arch.slice.render.util.b.g(r100);
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        Integer r104 = Integer.valueOf(r103);
        if (r104 == null) goto L9;
        r102 = r104.intValue();
    L9:
        this.f50016a = r102;
        a().setColor(this.f50016a);
        invalidateSelf();
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void g(Bitmap r100) {
        this.f50017b = r100;
        if (getBounds().isEmpty() == true) goto L5;
        i(getBounds());
    L5:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r110) {
        Intrinsics.checkNotNullParameter(r110, "outline");
        c r100 = this.f50023h;
        if (r100 != null) goto L5;
    L25:
        super.getOutline(r110);
        return;
    L5:
        if (r100.f50042h == false) goto L25;
        int r101 = r100.f50040f;
        int r102 = r100.f50041g;
        Rect r103 = getBounds();
        switch(r101) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L9;
        };
    L9:
        int r104 = r103.width();
        int r105 = r103.height();
    L21:
        int r106 = r104;
        int r107 = r105;
        int r108 = 0;
    L22:
        int r109 = 0;
    L23:
        r110.setRoundRect(r108, r109, r106, r107, RangesKt.coerceAtMost(RangesKt.coerceAtMost(r102, r103.width()), r103.height()));
        return;
    L10:
        r106 = r103.width();
        r108 = 0 - r102;
        r109 = r108;
        r107 = r103.height();
        goto L23
    L11:
        int r111 = 0 - r102;
        int r112 = r103.width();
        int r113 = r103.height() + r102;
    L17:
        r108 = r111;
        r106 = r112;
        r107 = r113;
        goto L22
    L12:
        int r114 = 0 - r102;
        int r115 = r103.width() + r102;
        int r116 = r103.height();
    L15:
        r109 = r114;
        r106 = r115;
        r107 = r116;
        r108 = 0;
        goto L23
    L13:
        r104 = r103.width() + r102;
        int r117 = r103.height();
    L19:
        r105 = r117 + r102;
        goto L21
    L14:
        r114 = 0 - r102;
        r115 = r103.width();
        r116 = r103.height();
        goto L15
    L16:
        r111 = 0 - r102;
        r112 = r103.width();
        r113 = r103.height();
        goto L17
    L18:
        r104 = r103.width();
        r117 = r103.height();
        goto L19
    L20:
        r104 = r103.width() + r102;
        r105 = r103.height();
        goto L21
    }

    public final void i(Rect r110) {
        if (this.f50017b != null) goto L5;
        return;
    L5:
        List<uq.a> r100 = this.f50020e;
        boolean r101 = false;
        if (r100 == null) goto L8;
    L13:
        List<uq.a> r102 = r100;
        if (r102 != null) goto L16;
    L19:
        boolean r103 = true;
    L20:
        if (r103 == false) goto L30;
        String r104 = this.f50019d;
        if (r104 != null) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == false) goto L30;
        m r106 = new m(r110.width(), r110.height());
    L121:
        k r107 = c(r110, r106);
        int r108 = r107.f50678a + r106.f50680a;
        int r109 = r107.f50679b + r106.f50681b;
        if (this.f50017b == null) goto L128;
        Rect r111 = this.f50029n;
        if (r111 != null) goto L126;
        r111 = new Rect();
        this.f50029n = r111;
    L126:
        r111.set(r107.f50678a, r107.f50679b, r108, r109);
    L128:
        if (r107.f50678a <= r110.left) goto L130;
    L136:
        this.f50030o = r101;
        return;
    L130:
        if (r107.f50679b > r110.top) goto L136;
        if (r108 < r110.right) goto L136;
        if (r109 < r110.bottom) goto L136;
        r101 = true;
        goto L136
    L24:
        if (r104.length() == 0) goto L27;
        r105 = false;
    L30:
        Bitmap r112 = this.f50017b;
        if (r112 == null) goto L33;
        int r113 = r112.getWidth();
    L34:
        Bitmap r114 = this.f50017b;
        if (r114 == null) goto L37;
        int r115 = r114.getHeight();
    L38:
        if (r113 == 0) goto L120;
        if (r115 == 0) goto L120;
        if (r110.height() == 0) goto L120;
        if (r110.width() == 0) goto L120;
        if (this.f50019d == null) goto L58;
        float r116 = (r113 * 1.0f) / r115;
        float r117 = (r110.width() * 1.0f) / r110.height();
        if (Intrinsics.areEqual(this.f50019d, LynxVideoManagerLite.CONTAIN) == false) goto L54;
        if (r116 <= r117) goto L52;
        int r118 = r110.width();
        HashMap<String, WeakReference<Bitmap>> r119 = PdpBackgroundUtil.f50015a;
        int r120 = Math.round(r118 / r116);
    L57:
        int r121 = r118;
        r115 = r120;
        r113 = r121;
    L119:
        r106 = new m(r113, r115);
        goto L121
    L52:
        r115 = r110.height();
        HashMap<String, WeakReference<Bitmap>> r122 = PdpBackgroundUtil.f50015a;
        r113 = Math.round(r115 * r116);
        goto L119
    L54:
        if (r116 <= r117) goto L56;
        r115 = r110.height();
        HashMap<String, WeakReference<Bitmap>> r123 = PdpBackgroundUtil.f50015a;
        r113 = Math.round(r115 * r116);
        goto L119
    L56:
        r118 = r110.width();
        HashMap<String, WeakReference<Bitmap>> r124 = PdpBackgroundUtil.f50015a;
        r120 = Math.round(r118 / r116);
        goto L57
    L58:
        List<uq.a> r125 = this.f50020e;
        if (r125 == null) goto L119;
        if (r125.size() != 2) goto L119;
        uq.a r126 = (uq.a) CollectionsKt.getOrNull(r125, 0);
        uq.a r127 = (uq.a) CollectionsKt.getOrNull(r125, 1);
        if (r126 != null) goto L65;
    L70:
        Integer r128 = null;
        if (r126 == null) goto L73;
        Integer r129 = Integer.valueOf(r126.f551168b);
    L75:
        if (r129 != null) goto L78;
    L80:
        if (r129 != null) goto L83;
    L86:
        if (r129 != null) goto L89;
    L91:
        int r130 = r113;
    L92:
        boolean r131 = false;
    L93:
        if (r127 == null) goto L95;
        r128 = Integer.valueOf(r127.f551168b);
    L95:
        if (r128 != null) goto L98;
    L100:
        if (r128 != null) goto L103;
    L106:
        if (r128 != null) goto L109;
    L111:
        int r132 = r115;
    L112:
        boolean r133 = false;
    L113:
        if (r131 == false) goto L115;
        r113 = (int) (r132 * ((r113 * 1.0f) / r115));
        r115 = r132;
        goto L119
    L115:
        if (r133 == false) goto L117;
        r115 = (int) (r130 / ((r113 * 1.0f) / r115));
    L118:
        r113 = r130;
        goto L119
    L117:
        r115 = r132;
        goto L118
    L109:
        if (r128.intValue() != 0) goto L111;
        r132 = r115;
        r133 = true;
        goto L113
    L103:
        if (r128.intValue() != 2) goto L106;
        float r134 = (r127.f551167a / 100) * r110.height();
    L105:
        r132 = (int) r134;
        goto L112
    L98:
        if (r128.intValue() != 1) goto L100;
        r134 = r127.f551167a;
        goto L105
    L89:
        if (r129.intValue() != 0) goto L91;
        r130 = r113;
        r131 = true;
        goto L93
    L83:
        if (r129.intValue() != 2) goto L86;
        float r135 = (r126.f551167a / 100) * r110.width();
    L85:
        r130 = (int) r135;
        goto L92
    L78:
        if (r129.intValue() != 1) goto L80;
        r135 = r126.f551167a;
        goto L85
    L73:
        r129 = null;
        goto L75
    L65:
        if (r126.f551168b != 0) goto L70;
        if (r127 == null) goto L70;
        if (r127.f551168b != 0) goto L70;
    L120:
        r106 = new m(r110.width(), r110.height());
        goto L121
    L37:
        r115 = 0;
        goto L38
    L33:
        r113 = 0;
        goto L34
    L16:
        if (r102.isEmpty() == true) goto L19;
        r103 = false;
        goto L20
    L8:
        if (this.f50019d != null) goto L13;
        Rect r136 = this.f50029n;
        if (r136 != null) goto L12;
        r136 = new Rect();
        this.f50029n = r136;
    L12:
        r136.set(r110);
        this.f50030o = false;
    }

    public final void j(Rect r110) {
        int r100 = r110.width();
        int r101 = r110.height();
        List<uq.a> r102 = this.f50020e;
        List<uq.a> r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L53;
        uq.a r105 = (uq.a) CollectionsKt.getOrNull(r102, 0);
        if (r102.size() <= 1) goto L13;
        uq.a r106 = (uq.a) CollectionsKt.getOrNull(r102, 1);
    L14:
        Integer r107 = null;
        if (r105 == null) goto L17;
        Integer r108 = Integer.valueOf(r105.f551168b);
    L19:
        if (r108 != null) goto L22;
    L25:
        if (r108 != null) goto L28;
    L30:
        if (r108 != null) goto L33;
    L35:
        if (r106 == null) goto L37;
        r107 = Integer.valueOf(r106.f551168b);
    L37:
        if (r107 != null) goto L40;
    L43:
        if (r107 != null) goto L46;
    L48:
        if (r107 == null) goto L53;
        if (r107.intValue() != 0) goto L53;
        r101 = r110.height();
        goto L53
    L46:
        if (r107.intValue() != 2) goto L48;
        float r109 = (r106.f551167a / 100) * r110.height();
    L42:
        r101 = (int) r109;
        goto L53
    L40:
        if (r107.intValue() != 1) goto L43;
        r109 = r106.f551167a;
        goto L42
    L33:
        if (r108.intValue() != 0) goto L35;
        r100 = r110.width();
        goto L35
    L28:
        if (r108.intValue() != 2) goto L30;
        float r111 = (r105.f551167a / 100) * r110.width();
    L24:
        r100 = (int) r111;
        goto L35
    L22:
        if (r108.intValue() != 1) goto L25;
        r111 = r105.f551167a;
        goto L24
    L17:
        r108 = null;
        goto L19
    L13:
        r106 = new uq.a(0.0f, 0);
    L53:
        k r112 = c(r110, new m(r100, r101));
        Rect r113 = d();
        int r114 = r112.f50678a;
        int r115 = r112.f50679b;
        r113.set(r114, r115, r100 + r114, r101 + r115);
        h();
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        if (r100.isEmpty() == true) goto L11;
        i(r100);
        if (this.f50021f == null) goto L7;
        j(r100);
    L7:
        c r101 = this.f50023h;
        if (r101 == null) goto L12;
        r101.f50046l = true;
        r101.f50049o = true;
        return;
    L12:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (r100 == b().getAlpha()) goto L9;
        b().setAlpha(r100);
        a().setAlpha(r100);
        e().setAlpha(r100);
        Paint r101 = this.f50027l;
        if (r101 != null) goto L7;
        r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        this.f50027l = r101;
    L7:
        r101.setAlpha(r100);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        b().setColorFilter(r100);
        a().setColorFilter(r100);
        e().setColorFilter(r100);
        Paint r101 = this.f50027l;
        if (r101 != null) goto L5;
        r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        this.f50027l = r101;
    L5:
        r101.setColorFilter(r100);
        invalidateSelf();
    }

    public final k c(Rect r100, m r101) {
        String r102 = this.f50018c;
        if (r102 == null) goto L20;
        int r103 = 0;
        switch(r102.hashCode()) {
            case -1383228885: goto L18;
            case 115029: goto L15;
            case 3317767: goto L12;
            case 108511772: goto L9;
            default: goto L20;
        };
    L9:
        if (r102.equals("right") == false) goto L20;
        r103 = r100.width() - r101.f50680a;
        int r104 = (r100.height() - r101.f50681b) / 2;
    L22:
        return new k(r103, r104);
    L12:
        if (r102.equals("left") == false) goto L20;
        r104 = (r100.height() - r101.f50681b) / 2;
        goto L22
    L15:
        if (r102.equals("top") == false) goto L20;
        r103 = (r100.width() - r101.f50680a) / 2;
        r104 = 0;
        goto L22
    L18:
        if (r102.equals("bottom") == false) goto L20;
        int r105 = r100.height() - r101.f50681b;
        r103 = (r100.width() - r101.f50680a) / 2;
        r104 = r105;
    L20:
        r103 = (r100.width() - r101.f50680a) / 2;
        r104 = (r100.height() - r101.f50681b) / 2;
        goto L22
    }
}
