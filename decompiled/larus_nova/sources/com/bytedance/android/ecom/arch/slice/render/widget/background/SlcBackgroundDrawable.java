package com.bytedance.android.ecom.arch.slice.render.widget.background;

import android.graphics.BlurMaskFilter;
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
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.bytedance.android.ecom.arch.slice.render.k;
import com.bytedance.android.ecom.arch.slice.render.m;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import vq.e;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcBackgroundDrawable extends Drawable implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f50846t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f50847u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f50848v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f50850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f50851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<uq.a> f50853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vq.b f50854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f50855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f50856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f50857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f50858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.widget.background.a f50860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f50861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Paint f50862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Paint f50863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f50864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f50865q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SlcImageFetchManager f50866r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f50867s;

    public static final class a {
        public a() {
        }

        public static float c(String r100) {
            int r101 = r100.length();
            if (r101 > 1) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L12;
            return CastFloatProtector.parseFloat(r100.substring(0, r100.length() - 1));
        L12:
            throw new IllegalArgumentException("invalid background_position percent");
        L5:
            if (r100.charAt(r101 - 1) != '%') goto L7;
            r102 = true;
            goto L8
        }

        public static float d(String r100) {
            int r101 = r100.hashCode();
            if (r101 == (-1364013995)) goto L16;
            if (r101 == 3317767) goto L13;
            if (r101 != 108511772) goto L19;
            if (r100.equals("right") == false) goto L19;
            return 100.0f;
        L19:
            return c(r100);
        L13:
            if (r100.equals("left") == false) goto L19;
            return 0.0f;
        L16:
            if (r100.equals("center") == false) goto L19;
            return 50.0f;
        }

        public static float e(String r100) {
            int r101 = r100.hashCode();
            if (r101 == (-1383228885)) goto L16;
            if (r101 == (-1364013995)) goto L13;
            if (r101 != 115029) goto L19;
            if (r100.equals("top") == false) goto L19;
            return 0.0f;
        L19:
            return c(r100);
        L13:
            if (r100.equals("center") == false) goto L19;
            return 50.0f;
        L16:
            if (r100.equals("bottom") == false) goto L19;
            return 100.0f;
        }

        public static boolean a(Object r100, float[] r101) {
            if (r100 != null) goto L38;
            return false;
        L38:
            if ((r100 instanceof String) == false) goto L10;
            return b(((String) r100).trim(), r101);
        L10:
            if ((r100 instanceof List) == false) goto L36;
            int r102 = ((List) r100).size();     // Catch: Throwable -> L37
            Object r103 = null;
            if (r102 != 1) goto L14;
            Object r104 = ListProtector.get((List) r100, 0);     // Catch: Throwable -> L37
            if ((r104 instanceof String) == false) goto L35;
            r103 = r104;
        L35:
            return b((String) r103, r101);
        L14:
            if (r102 == 2) goto L16;
            return false;
        L16:
            Object r105 = ListProtector.get((List) r100, 0);     // Catch: Throwable -> L37
            if ((r105 instanceof String) == true) goto L19;
            r105 = null;
        L19:
            String r106 = (String) r105;     // Catch: Throwable -> L37
            if (r106 == null) goto L29;
            Object r107 = ListProtector.get((List) r100, 1);     // Catch: Throwable -> L37
            if ((r107 instanceof String) == false) goto L25;
            r103 = r107;
        L25:
            String r108 = (String) r103;     // Catch: Throwable -> L37
            if (r108 == null) goto L29;
            r101[0] = d(r106);     // Catch: Throwable -> L37
            r101[1] = e(r108);     // Catch: Throwable -> L37
            return true;
        L29:
            return false;
        L36:
            return false;
        }

        public static boolean b(String r100, float[] r101) {
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(r100, "top") == false) goto L14;
        L17:
            r101[0] = 50.0f;
            r101[1] = e(r100);
        L18:
            return true;
        L14:
            if (Intrinsics.areEqual(r100, "bottom") == true) goto L17;
            r101[0] = d(r100);
            r101[1] = 50.0f;
            goto L18
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a
    public final void onFailure(Throwable r100) {
    }

    static {
        f50848v = new a();
        f50847u = true;
    }

    public final com.bytedance.android.ecom.arch.slice.render.widget.background.a b() {
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r100 = this.f50860l;
        if (r100 != null) goto L6;
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r101 = new com.bytedance.android.ecom.arch.slice.render.widget.background.a();
        this.f50860l = r101;
        return r101;
    L6:
        return r100;
    }

    public final Paint c() {
        Paint r100 = this.f50862n;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(1);
        this.f50862n = r101;
        return r101;
    L6:
        return r100;
    }

    public final Drawable e() {
        SlcImageFetchManager r100 = this.f50866r;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e();
    }

    public final Paint f() {
        Paint r100 = this.f50861m;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(6);
        this.f50861m = r101;
        return r101;
    L6:
        return r100;
    }

    public final Paint g() {
        Paint r100 = this.f50864p;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        this.f50864p = r101;
        return r101;
    L6:
        return r100;
    }

    public final Rect h() {
        Rect r100 = this.f50856h;
        if (r100 != null) goto L6;
        Rect r101 = new Rect();
        this.f50856h = r101;
        return r101;
    L6:
        return r100;
    }

    public final Paint i() {
        Paint r100 = this.f50863o;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(1);
        this.f50863o = r101;
        return r101;
    L6:
        return r100;
    }

    public final Paint j() {
        Paint r100 = this.f50865q;
        if (r100 != null) goto L6;
        Paint r101 = new Paint(1);
        this.f50865q = r101;
        return r101;
    L6:
        return r100;
    }

    public SlcBackgroundDrawable() {
        this.f50850b = 50.0f;
        this.f50851c = 50.0f;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        if (e() == null) goto L18;
        Drawable r100 = e();
        if (r100 == null) goto L7;
        int r101 = r100.getAlpha();
    L8:
        if (r101 >= 255) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L18;
        if (f().getAlpha() != 255) goto L18;
        if (this.f50867s == false) goto L18;
        return -1;
    L10:
        r102 = false;
        goto L11
    L7:
        r101 = 255;
    L18:
        if (Color.alpha(this.f50849a) == 255) goto L23;
        return -3;
    L23:
        return -1;
    }

    public final void s() {
        if (h().isEmpty() == true) goto L10;
        vq.b r100 = this.f50854f;
        if (r100 == null) goto L7;
        int r101 = e.f556754a;
        LinearGradient r102 = e.a(h(), r100);
    L8:
        i().setShader(r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void A(Rect r100) {
        int r101 = r100.width();
        int r102 = r100.height();
        List<uq.a> r103 = this.f50853e;
        List<uq.a> r104 = r103;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L32;
        uq.a r106 = (uq.a) ListProtector.get(r103, 0);
        if (r103.size() <= 1) goto L13;
        uq.a r107 = (uq.a) ListProtector.get(r103, 1);
    L14:
        int r108 = r106.f551168b;
        if (r108 == 0) goto L22;
        if (r108 == 1) goto L20;
        if (r108 != 2) goto L23;
        float r109 = (r106.f551167a / 100) * r100.width();
    L21:
        r101 = (int) r109;
    L23:
        int r110 = r107.f551168b;
        if (r110 == 0) goto L31;
        if (r110 == 1) goto L29;
        if (r110 != 2) goto L32;
        float r111 = (r107.f551167a / 100) * r100.height();
    L30:
        r102 = (int) r111;
        goto L32
    L29:
        r111 = r107.f551167a;
        goto L30
    L31:
        r102 = r100.height();
        goto L32
    L20:
        r109 = r106.f551167a;
        goto L21
    L22:
        r101 = r100.width();
        goto L23
    L13:
        r107 = new uq.a(0.0f, 0);
    L32:
        k r112 = new k((int) (((r100.width() - r101) * this.f50850b) / 100.0f), (int) (((r100.height() - r102) * this.f50851c) / 100.0f));
        Rect r113 = h();
        int r114 = r112.f50678a;
        int r115 = r112.f50679b;
        r113.set(r114, r115, r101 + r114, r102 + r115);
        s();
        return;
    L5:
        if (r104.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    public final void a(Canvas r100) {
        if (this.f50849a == 0) goto L6;
        r100.drawRect(getBounds(), c());
    L6:
        if (this.f50859k == false) goto L8;
        int r101 = r100.save();
        r100.clipRect(getBounds());
        r100.translate(this.f50857i, this.f50858j);
    L20:
        Drawable r102 = e();     // Catch: Exception -> L13
        if (r102 == null) goto L15;
        r102.draw(r100);     // Catch: Exception -> L13
    L15:
        if (this.f50854f == null) goto L17;
        r100.drawRect(h(), i());
    L17:
        if (r101 <= 0) goto L22;
        r100.restoreToCount(r101);
        return;
    L22:
        return;
    L13:
        nq.a.c(null, new SlcBackgroundDrawable$drawBgImage$1(this), 1);
        goto L15
    L8:
        r101 = -1;
        goto L20
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r100 = this.f50860l;
        if (r100 == null) goto L5;
        b r101 = r100.f50892y;
    L7:
        if (r101 == null) goto L53;
        if (r100 == null) goto L53;
        if (r100.f50883p == false) goto L13;
        Rect r102 = getBounds();
        r100.d(r102.left, r102.top, r102.right, r102.bottom);
    L13:
        if (r100.A == false) goto L44;
        Rect r103 = getBounds();
        b r104 = r100.f50892y;
        if (r100.A == false) goto L44;
        if (r104 == null) goto L44;
        r100.A = false;
        int r105 = r100.f50868a;
        if (r105 <= 0) goto L21;
        float r106 = RangesKt.coerceAtLeast(r105 + r104.f50896c, 0.0f);
    L22:
        int r111 = r100.f50870c;
        if (r111 <= 0) goto L25;
        float r107 = RangesKt.coerceAtLeast(r111 + r104.f50896c, 0.0f);
    L26:
        int r112 = r100.f50871d;
        if (r112 <= 0) goto L29;
        float r108 = RangesKt.coerceAtLeast(r112 + r104.f50896c, 0.0f);
    L30:
        int r113 = r100.f50869b;
        if (r113 <= 0) goto L33;
        float r109 = RangesKt.coerceAtLeast(r113 + r104.f50896c, 0.0f);
    L34:
        float r114 = -r104.f50896c;
        float r115 = r103.width();
        float r116 = r104.f50896c;
        float r117 = r115 + r116;
        float r118 = -r116;
        float r119 = r103.height() + r104.f50896c;
        RectF r120 = r100.B;
        if (r120 != null) goto L37;
        r120 = new RectF();
        r100.B = r120;
    L37:
        r120.set(r114, r118, r117, r119);
        float[] r121 = r100.C;
        if (r121 != null) goto L40;
        r121 = new float[8];
        r100.C = r121;
    L40:
        r121[0] = r106;
        r121[1] = r106;
        r121[2] = r107;
        r121[3] = r107;
        r121[4] = r108;
        r121[5] = r108;
        r121[6] = r109;
        r121[7] = r109;
        Path r122 = r100.f50893z;
        if (r122 != null) goto L43;
        r122 = new Path();
        r100.f50893z = r122;
    L43:
        r122.reset();
        r122.addRoundRect(r120, r121, Path.Direction.CCW);
        goto L44
    L33:
        r109 = 0.0f;
        goto L34
    L29:
        r108 = 0.0f;
        goto L30
    L25:
        r107 = 0.0f;
        goto L26
    L21:
        r106 = 0.0f;
    L44:
        r110.save();
        if (Build.VERSION.SDK_INT < 28) goto L47;
        r110.clipOutPath(r100.b());
    L48:
        r110.translate(r100.a().f50894a, r100.a().f50895b);
        Path r123 = r100.f50893z;
        if (r123 != null) goto L51;
        r123 = new Path();
        r100.f50893z = r123;
    L51:
        r110.drawPath(r123, j());
        r110.restore();
        goto L53
    L47:
        r110.clipPath(r100.b(), Region.Op.DIFFERENCE);
    L53:
        if (this.f50849a == 0) goto L55;
    L58:
        if (r100 != null) goto L60;
    L110:
        a(r110);
    L111:
        if (r100 == null) goto L148;
        float r124 = 0;
        if (r100.f50877j > r124) goto L115;
    L117:
        boolean r125 = false;
    L118:
        if (r125 == true) goto L120;
        return;
    L120:
        if (r100.f50887t == false) goto L139;
        Rect r126 = getBounds();
        if (r100.f50887t == false) goto L139;
        if (r100.f50877j <= r124) goto L139;
        r100.f50887t = false;
        Path r127 = r100.f50886s;
        if (r127 != null) goto L129;
        r127 = new Path();
        r100.f50886s = r127;
    L129:
        r127.reset();
        float r128 = r100.f50877j / 2.0f;
        RectF r129 = r100.f50884q;
        if (r129 != null) goto L132;
        r129 = new RectF();
        r100.f50884q = r129;
    L132:
        r129.set(r126.left + r128, r126.top + r128, r126.right - r128, r126.bottom - r128);
        if (r100.f50873f != 0) goto L135;
        float r130 = RangesKt.coerceAtLeast(r100.f50874g - r128, 0.0f);
        r127.addRoundRect(r129, r130, r130, Path.Direction.CCW);
        goto L139
    L135:
        float r131 = r100.f50868a;
        float r132 = r100.f50870c;
        float r133 = r100.f50871d;
        float r134 = r100.f50869b;
        float[] r135 = r100.f50885r;
        if (r135 != null) goto L138;
        r135 = new float[8];
        r100.f50885r = r135;
    L138:
        float r136 = r131 - r128;
        r135[0] = RangesKt.coerceAtLeast(r136, 0.0f);
        r135[1] = RangesKt.coerceAtLeast(r136, 0.0f);
        float r137 = r132 - r128;
        r135[2] = RangesKt.coerceAtLeast(r137, 0.0f);
        r135[3] = RangesKt.coerceAtLeast(r137, 0.0f);
        float r138 = r133 - r128;
        r135[4] = RangesKt.coerceAtLeast(r138, 0.0f);
        r135[5] = RangesKt.coerceAtLeast(r138, 0.0f);
        float r139 = r134 - r128;
        r135[6] = RangesKt.coerceAtLeast(r139, 0.0f);
        r135[7] = RangesKt.coerceAtLeast(r139, 0.0f);
        r127.addRoundRect(r129, r135, Path.Direction.CCW);
    L139:
        Path r140 = r100.f50886s;
        if (r140 != null) goto L142;
        r140 = new Path();
        r100.f50886s = r140;
    L142:
        r110.drawPath(r140, g());
        return;
    L115:
        if (r100.f50878k == 0) goto L117;
        r125 = true;
        goto L118
    L148:
        return;
    L60:
        if (r100.f50872e == true) goto L62;
    L64:
        boolean r141 = false;
    L65:
        if (r141 == false) goto L110;
        if (r100.f50883p == false) goto L70;
        Rect r142 = getBounds();
        r100.d(r142.left, r142.top, r142.right, r142.bottom);
    L70:
        if (f50847u == true) goto L77;
        Path r143 = r100.b();
        int r144 = r110.save();
        r110.clipPath(r143);
        a(r110);     // Catch: Throwable -> L74
        r110.restoreToCount(r144);
    L74:
        th = move-exception;
        r110.restoreToCount(r144);
        throw th;
    L77:
        Path r145 = r100.b();
        if (this.f50849a == 0) goto L81;
        r110.drawPath(r145, c());
    L81:
        if (e() == null) goto L83;
        boolean r146 = true;
    L85:
        if (this.f50854f == null) goto L87;
        boolean r147 = true;
    L88:
        if (r146 == true) goto L91;
        if (r147 == false) goto L111;
    L91:
        if (r146 == true) goto L98;
        if (r147 == false) goto L98;
        if (this.f50859k == true) goto L98;
        if (Intrinsics.areEqual(h(), getBounds()) == false) goto L98;
        r110.drawPath(r145, i());
    L98:
        int r148 = r110.save();
        r110.clipPath(r145);
        if (this.f50859k == false) goto L101;
        r110.translate(this.f50857i, this.f50858j);
    L101:
        if (r146 == true) goto L146;
    L107:
        if (r147 == false) goto L109;
        r110.drawRect(h(), i());
    L109:
        r110.restoreToCount(r148);
        goto L111
    L146:
        Drawable r149 = e();     // Catch: Exception -> L106
        if (r149 == null) goto L107;
        r149.draw(r110);     // Catch: Exception -> L106
    L106:
        nq.a.c(null, new SlcBackgroundDrawable$drawBgImage$1(this), 1);
        goto L107
    L87:
        r147 = false;
        goto L88
    L83:
        r146 = false;
        goto L85
    L62:
        if (r100.f50875h == true) goto L64;
        r141 = true;
        goto L65
    L55:
        if (e() != null) goto L58;
        if (this.f50854f == null) goto L111;
    L5:
        r101 = null;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r110) {
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r100 = this.f50860l;
        if (r100 != null) goto L5;
    L25:
        super.getOutline(r110);
        return;
    L5:
        if (r100.f50875h == false) goto L25;
        int r101 = r100.f50873f;
        int r102 = r100.f50874g;
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

    public final void k(float r100) {
        this.f50857i = r100;
        if (r100 == 0.0f) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f50859k = r101;
        invalidateSelf();
        return;
    L5:
        if (this.f50858j != 0.0f) goto L8;
        r101 = false;
        goto L9
    }

    public final void l(float r100) {
        this.f50858j = r100;
        if (this.f50857i == 0.0f) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f50859k = r101;
        invalidateSelf();
        return;
    L5:
        if (r100 != 0.0f) goto L8;
        r101 = false;
        goto L9
    }

    public final void m(Object r100) {
        float[] r101 = new float[2];
        f50848v.getClass();
        if (a.a(r100, r101) == false) goto L5;
        n(r101[0], r101[1]);
        return;
    L5:
        n(50.0f, 50.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        if (r100.isEmpty() == true) goto L11;
        z(r100);
        if (this.f50854f == null) goto L7;
        A(r100);
    L7:
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r101 = this.f50860l;
        if (r101 == null) goto L12;
        r101.f50891x = true;
        r101.f50883p = true;
        r101.f50887t = true;
        r101.A = true;
        return;
    L12:
        return;
    }

    public final void p(int r100) {
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r101 = b();
        r101.f50878k = r100;
        g().setColor(r100);
        if (r101.f50877j <= 0) goto L6;
        invalidateSelf();
        return;
    }

    public final void q(float r100) {
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r101 = b();
        r101.f50877j = r100;
        g().setStrokeWidth(r100);
        if (getBounds().isEmpty() == true) goto L5;
        r101.f50887t = true;
    L5:
        invalidateSelf();
    }

    public final void r(vq.b r100) {
        this.f50854f = r100;
        if (getBounds().isEmpty() == true) goto L6;
        if (r100 == null) goto L6;
        A(getBounds());
    L6:
        s();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (r100 == f().getAlpha()) goto L9;
        f().setAlpha(r100);
        c().setAlpha(r100);
        i().setAlpha(r100);
        g().setAlpha(r100);
        Drawable r101 = e();
        if (r101 == null) goto L7;
        r101.setAlpha(r100);
    L7:
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        f().setColorFilter(r100);
        c().setColorFilter(r100);
        i().setColorFilter(r100);
        g().setColorFilter(r100);
        SlcImageFetchManager r101 = this.f50866r;
        if (r101 == null) goto L7;
        GenericDraweeHierarchy r102 = r101.f();
        if (r102 == null) goto L7;
        r102.setActualImageColorFilter(r100);
    L7:
        invalidateSelf();
    }

    public final void u(float r100) {
        b().a();
        if (r100 > 0.0f) goto L5;
        j().setMaskFilter(null);
    L6:
        invalidateSelf();
        return;
    L5:
        j().setMaskFilter(new BlurMaskFilter(r100, BlurMaskFilter.Blur.NORMAL));
        goto L6
    }

    public final void v(int r100) {
        b().a();
        j().setColor(r100);
        invalidateSelf();
    }

    public final void w(float r100) {
        b().a().f50894a = r100;
        invalidateSelf();
    }

    public final void x(float r100) {
        b().a().f50895b = r100;
        invalidateSelf();
    }

    public final void y(float r100) {
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r101 = b();
        r101.a().f50896c = r100;
        r101.A = true;
        invalidateSelf();
    }

    public final void z(Rect r110) {
        if (e() == null) goto L115;
        boolean r100 = false;
        if (this.f50853e != null) goto L13;
        if (this.f50852d != null) goto L13;
        Drawable r101 = e();
        if (r101 == null) goto L11;
        r101.setBounds(r110);
    L11:
        this.f50867s = false;
        return;
    L13:
        if (e() == null) goto L100;
        List<uq.a> r102 = this.f50853e;
        if (r102 != null) goto L17;
    L20:
        boolean r103 = true;
    L21:
        if (r103 == false) goto L31;
        String r104 = this.f50852d;
        if (r104 != null) goto L25;
    L28:
        boolean r105 = true;
    L29:
        if (r105 == false) goto L31;
    L25:
        if (r104.length() == 0) goto L28;
        r105 = false;
    L31:
        Drawable r106 = e();
        if (r106 == null) goto L36;
        Rect r107 = r106.getBounds();
        if (r107 == null) goto L36;
        int r108 = r107.width();
    L37:
        Drawable r109 = e();
        if (r109 == null) goto L42;
        Rect r111 = r109.getBounds();
        if (r111 == null) goto L42;
        int r112 = r111.height();
    L43:
        if (r108 == 0) goto L99;
        if (r112 == 0) goto L99;
        if (r110.height() == 0) goto L99;
        if (r110.width() == 0) goto L99;
        if (this.f50852d == null) goto L63;
        float r113 = (r108 * 1.0f) / r112;
        float r114 = (r110.width() * 1.0f) / r110.height();
        if (Intrinsics.areEqual(this.f50852d, LynxVideoManagerLite.CONTAIN) == false) goto L59;
        if (r113 <= r114) goto L57;
        int r115 = r110.width();
        int r116 = Math.round(r115 / r113);
    L62:
        int r117 = r115;
        r112 = r116;
        r108 = r117;
    L98:
        m r118 = new m(r108, r112);
    L101:
        int r119 = (int) (((r110.width() - r118.f50680a) * this.f50850b) / 100.0f);
        int r120 = r110.height();
        int r121 = r118.f50681b;
        int r122 = (int) (((r120 - r121) * this.f50851c) / 100.0f);
        int r123 = r118.f50680a + r119;
        int r124 = r121 + r122;
        Drawable r125 = e();
        if (r125 == null) goto L105;
        r125.setBounds(r119, r122, r123, r124);
    L105:
        if (r119 <= r110.left) goto L107;
    L113:
        this.f50867s = r100;
        return;
    L107:
        if (r122 > r110.top) goto L113;
        if (r123 < r110.right) goto L113;
        if (r124 < r110.bottom) goto L113;
        r100 = true;
        goto L113
    L57:
        r112 = r110.height();
        r108 = Math.round(r112 * r113);
        goto L98
    L59:
        if (r113 <= r114) goto L61;
        r112 = r110.height();
        r108 = Math.round(r112 * r113);
        goto L98
    L61:
        r115 = r110.width();
        r116 = Math.round(r115 / r113);
        goto L62
    L63:
        List<uq.a> r126 = this.f50853e;
        if (r126 == null) goto L98;
        if (r126.size() != 2) goto L98;
        uq.a r127 = (uq.a) ListProtector.get(r126, 0);
        uq.a r128 = (uq.a) ListProtector.get(r126, 1);
        int r129 = r127.f551168b;
        if (r129 != 0) goto L73;
        if (r128.f551168b == 0) goto L98;
    L73:
        if (r129 == 0) goto L81;
        if (r129 == 1) goto L78;
        if (r129 == 2) goto L77;
        int r130 = r108;
    L80:
        boolean r131 = false;
    L82:
        int r132 = r128.f551168b;
        if (r132 == 0) goto L91;
        if (r132 == 1) goto L88;
        if (r132 == 2) goto L87;
        int r133 = r112;
    L90:
        boolean r134 = false;
    L92:
        if (r131 == false) goto L94;
        r108 = (int) (r133 * ((r108 * 1.0f) / r112));
        r112 = r133;
        goto L98
    L94:
        if (r134 == false) goto L96;
        r112 = (int) (r130 / ((r108 * 1.0f) / r112));
    L97:
        r108 = r130;
        goto L98
    L96:
        r112 = r133;
        goto L97
    L87:
        float r135 = (r128.f551167a / 100) * r110.height();
    L89:
        r133 = (int) r135;
        goto L90
    L88:
        r135 = r128.f551167a;
        goto L89
    L91:
        r133 = r112;
        r134 = true;
        goto L92
    L77:
        float r136 = (r127.f551167a / 100) * r110.width();
    L79:
        r130 = (int) r136;
        goto L80
    L78:
        r136 = r127.f551167a;
        goto L79
    L81:
        r130 = r108;
        r131 = true;
    L99:
        r118 = new m(r110.width(), r110.height());
    L42:
        r112 = 0;
    L36:
        r108 = 0;
        goto L37
    L17:
        if (r102.isEmpty() == true) goto L20;
        r103 = false;
    L100:
        r118 = new m(r110.width(), r110.height());
        goto L101
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a
    public final void d(CloseableReference<CloseableImage> r100, Drawable r101) {
        CloseableImage r102 = com.bytedance.android.ecom.arch.slice.render.util.e.g(r100);
        if (r102 == null) goto L7;
        Drawable r103 = e();
        if (r103 == null) goto L9;
        r103.setBounds(0, 0, r102.getWidth(), r102.getHeight());
    L9:
        if (getBounds().isEmpty() == true) goto L11;
        z(getBounds());
    L11:
        invalidateSelf();
        return;
    L7:
        nq.a.b(null, SlcBackgroundDrawable$onSuccess$1.INSTANCE);
        goto L9
    }

    public final void n(float r100, float r101) {
        this.f50850b = r100;
        this.f50851c = r101;
        if (getBounds().isEmpty() == true) goto L7;
        z(getBounds());
        if (this.f50854f == null) goto L7;
        A(getBounds());
    L7:
        invalidateSelf();
    }

    public final void o(com.bytedance.android.ecom.arch.slice.render.context.b r110, String r111) {
        if (r111 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        this.f50853e = null;
    L34:
        if (getBounds().isEmpty() == true) goto L38;
        z(getBounds());
        if (this.f50854f == null) goto L38;
        A(getBounds());
    L38:
        invalidateSelf();
        return;
    L12:
        if (r111 == null) goto L41;
        String r101 = r111.trim();
        if (Intrinsics.areEqual(r101, "cover") == false) goto L17;
        this.f50852d = "cover";
        this.f50853e = null;
        goto L34
    L17:
        if (Intrinsics.areEqual(r101, LynxVideoManagerLite.CONTAIN) == false) goto L19;
        this.f50852d = LynxVideoManagerLite.CONTAIN;
        this.f50853e = null;
        goto L34
    L19:
        this.f50852d = null;
        List r112 = StringsKt.split$default(r101, new char[]{' '}, false, 0, 6, null);
        ArrayList r102 = new ArrayList();
        Iterator r113 = r112.iterator();
    L21:
        if (r113.hasNext() == false) goto L26;
        Object r103 = r113.next();
        if ((!StringsKt.isBlank((String) r103)) == false) goto L21;
        r102.add(r103);
        goto L21
    L26:
        if (r102.isEmpty() == false) goto L28;
        this.f50853e = null;
        goto L34
    L28:
        uq.a r114 = uq.b.c(r110, (String) ListProtector.get(r102, 0));
        if (r102.size() > 1) goto L31;
        uq.a r115 = new uq.a(0.0f, 0);
    L32:
        this.f50853e = CollectionsKt.listOf(new uq.a[]{r114, r115});
        goto L34
    L31:
        r115 = uq.b.c(r110, (String) ListProtector.get(r102, 1));
        goto L32
    L41:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L5:
        if (r111.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    public final SlcImageFetchManager t(SlcRenderContext r100, Object r101) {
        if (this.f50866r != null) goto L5;
        boolean r102 = true;
    L6:
        nq.a.e(r102, null, 6);
        SlcImageFetchManager r103 = com.bytedance.android.ecom.arch.slice.render.util.e.b(r100, r101);
        this.f50866r = r103;
        ScalingUtils.ScaleType r104 = ScalingUtils.ScaleType.FIT_XY;
        GenericDraweeHierarchy r105 = r103.f();
        if (r105 == null) goto L9;
        r105.setActualImageScaleType(r104);
    L9:
        GenericDraweeHierarchy r106 = r103.f();
        if (r106 == null) goto L12;
        r106.setFadeDuration(0);
    L12:
        r103.f50370n = this;
        return r103;
    L5:
        r102 = false;
        goto L6
    }
}
