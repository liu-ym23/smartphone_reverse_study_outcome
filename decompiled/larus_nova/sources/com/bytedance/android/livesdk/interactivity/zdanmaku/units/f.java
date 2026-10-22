package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.l;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.zdanmaku.j;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.facebook.drawee.generic.RootDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> extends tk6.b<T> implements com.bytedance.live.zdanmaku.render.canvas.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f141815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearGradient f141816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f141817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f141818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f141819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f141820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f141821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LottieDrawable f141822n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RootDrawable f141823o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RootDrawable f141824p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f141825q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f141826r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f141827s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f141828t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f141829u;

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void f() {
        Canvas r100 = this.f546532f;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f141821m == true) goto L9;
        MainThreadPostUtils.b(new e(this));
        this.f141821m = true;
    L9:
        float r101 = c().f254828c.f254853b;
        of6.a r102 = this.f523105c;
        if (r102 == null) goto L14;
        com.bytedance.live.artist.render.f r103 = r102.f254851b;
        if (r103 == null) goto L14;
        float r104 = r103.f254853b;
    L15:
        if (r102 == null) goto L19;
        com.bytedance.live.artist.render.f r105 = r102.f254851b;
        if (r105 == null) goto L19;
        float r106 = r105.f254852a;
    L20:
        this.f141818j = 1.5f * r104;
        float r107 = c().f254829d.f254847a;
        float r108 = c().f254829d.f254848b;
        this.f141819k.setShader(this.f141816h);
        this.f141817i.reset();
        this.f141817i.setTranslate(r107 - this.f141818j, r108);
        Matrix r109 = this.f141817i;
        float r110 = this.f141818j;
        r109.postScale((2 * r110) + r106, r104, r107 - r110, r108);
        this.f141816h.setLocalMatrix(this.f141817i);
        RectF r111 = this.f141815g;
        float r112 = this.f141818j;
        r111.left = r107 - r112;
        r111.right = (r107 + r106) + r112;
        r111.top = r108;
        r111.bottom = r108 + r104;
        float r113 = (r101 - r104) * 0.5f;
        r100.save();
        r100.translate(0.0f, r113);
        r100.drawRoundRect(this.f141815g, r104, r104, this.f141819k);
        super.f();
        r100.restore();
        r100.save();
        float r114 = r108 + r113;
        double r115 = r114;
        r100.translate(c().f254829d.f254847a + this.f141827s, (float) ((((double) (r104 - this.f141825q)) * 0.5d) + r115));
        RootDrawable r116 = this.f141823o;
        if (r116 == null) goto L23;
        r116.draw(r100);
    L23:
        r100.restore();
        RootDrawable r117 = this.f141824p;
        if (r117 == null) goto L27;
        r100.save();
        r100.translate(((c().f254829d.f254847a + this.f141827s) + this.f141826r) + this.f141828t, (float) (r115 + (((double) (r104 - this.f141825q)) * 0.5d)));
        r117.draw(r100);
        r100.restore();
    L27:
        if (this.f141829u == false) goto L30;
        r100.save();
        r100.translate(c().f254829d.f254847a, r114);
        r100.scale(0.5f, 0.5f);
        this.f141822n.setAlpha(255);
        this.f141822n.draw(r100);
        r100.restore();
        return;
    L30:
        return;
    L19:
        r106 = 0.0f;
    L14:
        r104 = 0.0f;
        goto L15
    }

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void d() {
        super.d();
        this.f141820l = null;
        MainThreadPostUtils.b(new d(this));
        this.f141821m = false;
    }

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void e() {
        super.e();
        RootDrawable r100 = null;
        if (this.f141829u == false) goto L16;
        View r101 = this.f141820l;
        if (r101 == null) goto L15;
        Context r102 = r101.getContext();
        if (r102 == null) goto L62;
        l<LottieComposition> r103 = LottieCompositionFactory.fromAssetSync(r102, "supreme/data.json");
        if (r103 == null) goto L12;
        LottieComposition r104 = r103.f24812a;
    L13:
        if (r104 == null) goto L16;
        this.f141822n.m(r104);
        LottieDrawable r105 = this.f141822n;
        r105.f24733j = "supreme/images";
        r105.w(-1);
        this.f141822n.setCallback(this.f141820l);
        this.f141822n.e("image_0");
        goto L16
    L12:
        r104 = null;
        goto L13
    L62:
        return;
    L15:
        return;
    L16:
        T r106 = this.f523106d;
        if ((r106 instanceof j) == true) goto L19;
        r106 = (T) null;
    L19:
        j r107 = r106;
        boolean r108 = true;
        if (r107 == null) goto L39;
        s3 r109 = r107.f141646a;
        if (r109 == null) goto L39;
        if (r109.getBadgeDrawable() == null) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == true) goto L30;
        r109 = null;
    L30:
        if (r109 == null) goto L39;
        Drawable r111 = r109.getBadgeDrawable();
        if ((r111 instanceof RootDrawable) == true) goto L34;
        r111 = null;
    L34:
        RootDrawable r112 = (RootDrawable) r111;
        if (r112 == null) goto L37;
        r112.setBounds(0, 0, r109.getBadgeWidth(), r109.getBadgeHeight());
        this.f141826r = r109.getBadgeWidth();
        r112.setCallback(this.f141820l);
        Unit r113 = Unit.INSTANCE;
    L38:
        this.f141823o = r112;
        goto L39
    L37:
        r112 = null;
        goto L38
    L26:
        r110 = false;
    L39:
        T r114 = this.f523106d;
        if ((r114 instanceof j) == true) goto L42;
        r114 = (T) null;
    L42:
        j r115 = r114;
        if (r115 == null) goto L63;
        s3 r116 = r115.f141646a;
        if (r116 != null) goto L47;
        return;
    L47:
        if (r116.getRecentBadgeDrawable() != null) goto L50;
        r108 = false;
    L50:
        if (r108 == true) goto L53;
        r116 = null;
    L53:
        if (r116 == null) goto L65;
        Drawable r117 = r116.getRecentBadgeDrawable();
        if ((r117 instanceof RootDrawable) == true) goto L57;
        r117 = null;
    L57:
        RootDrawable r118 = (RootDrawable) r117;
        if (r118 == null) goto L60;
        r118.setBounds(0, 0, r116.getRecentBadgeWidth(), r116.getRecentBadgeHeight());
        r118.setCallback(this.f141820l);
        Unit r119 = Unit.INSTANCE;
        r100 = r118;
    L60:
        this.f141824p = r100;
        return;
    L65:
        return;
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.c
    public final void a(View r100) {
        this.f141820l = r100;
    }

    public f(Object r100, tk6.e r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, ThumbGlideUrl.SOURCE_TEMPLATE);
        super(r100, r110);
        this.f141829u = r111;
        this.f141815g = new RectF();
        this.f141816h = new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, new int[]{0, -1, -1, 0}, new float[]{0.0f, 0.1f, 0.9f, 1.0f}, Shader.TileMode.CLAMP);
        this.f141817i = new Matrix();
        Paint r101 = new Paint(1);
        r101.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r112 = Unit.INSTANCE;
        this.f141819k = r101;
        this.f141822n = new LottieDrawable();
        this.f141825q = s1.f(16.0f);
        this.f141826r = s1.f(32.0f);
        this.f141827s = s1.f(4.0f);
        this.f141828t = s1.f(2.0f);
    }
}
