package com.bytedance.android.ec.hybrid.xelement.ecomimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends FrescoImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f47772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f47773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f47774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f47775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f47776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearGradient f47777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearGradient f47778g;

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (getDrawable() != null) goto L5;
        return;
    L5:
        r100.save();
        Matrix r101 = getImageMatrix();
        if (r101 == null) goto L8;
        r100.concat(r101);
    L8:
        Drawable r102 = getDrawable();
        if (r102 == null) goto L18;
        Rect r103 = r102.getBounds();
        if (r103 == null) goto L18;
        if (this.f47772a == 0.0f) goto L16;
        this.f47776e.set(r103);
        this.f47776e.bottom = r103.top + (r103.height() * this.f47772a);
        RectF r104 = this.f47776e;
        Paint r105 = this.f47774c;
        r105.setShader(f(r104, false));
        Unit r106 = Unit.INSTANCE;
        r100.drawRect(r104, r105);
    L16:
        if (this.f47773b == 0.0f) goto L18;
        this.f47775d.set(r103);
        this.f47775d.top = r103.bottom - (r103.height() * this.f47773b);
        RectF r107 = this.f47775d;
        Paint r108 = this.f47774c;
        r108.setShader(f(r107, true));
        Unit r109 = Unit.INSTANCE;
        r100.drawRect(r107, r108);
    L18:
        r100.restore();
    }

    public final LinearGradient f(RectF r110, boolean r111) {
        if (r111 == false) goto L7;
        LinearGradient r100 = this.f47778g;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        if (r111 == true) goto L12;
        LinearGradient r101 = this.f47777f;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNull(r101);
        return r101;
    L12:
        float r102 = 1.0f;
        if (r111 == false) goto L15;
        float r103 = 0.0f;
    L16:
        if (r111 == true) goto L19;
        r102 = 0.0f;
    L19:
        float r104 = r110.left;
        float r105 = 255;
        LinearGradient r106 = new LinearGradient(r104, r110.top, r104, r110.bottom, (RangesKt.coerceAtMost(255, RangesKt.coerceAtLeast(0, (int) (r103 * r105))) << 24) + 16777215, (RangesKt.coerceAtMost(255, RangesKt.coerceAtLeast(0, (int) (r102 * r105))) << 24) + 16777215, Shader.TileMode.CLAMP);
        if (r111 == false) goto L22;
        this.f47778g = r106;
    L23:
        return r106;
    L22:
        this.f47777f = r106;
        goto L23
    L15:
        r103 = 1.0f;
        goto L16
    }

    public a(Context r100, AbstractDraweeControllerBuilder r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, null, r102);
        Paint r103 = new Paint(1);
        r103.setDither(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        Unit r104 = Unit.INSTANCE;
        this.f47774c = r103;
        this.f47775d = new RectF();
        this.f47776e = new RectF();
        setLayerType(1, null);
    }
}
