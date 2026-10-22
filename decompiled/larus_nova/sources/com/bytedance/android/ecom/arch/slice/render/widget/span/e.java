package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends ReplacementSpan implements a, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SlcImageFetchManager f50987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f50988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<BaseSlcViewManager<?>> f50991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f50992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f50993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f50994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f50995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f50996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f50997k;

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a
    public final void onFailure(Throwable r100) {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.span.a
    public final void a() {
        this.f50987a.g();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.span.a
    public final void c() {
        this.f50987a.h();
    }

    public final int e() {
        if (this.f50988b == false) goto L16;
        if (this.f50994h >= 0) goto L16;
        int r100 = this.f50993g;
        if (r100 <= 0) goto L14;
        float r101 = this.f50995i;
        if (r101 <= 0) goto L14;
        return (int) (r100 / r101);
    L14:
        return this.f50990d;
    L16:
        return this.f50994h;
    }

    public final int f() {
        int r100 = this.f50993g;
        if (r100 < 0) goto L6;
        return r100;
    L6:
        if (this.f50988b == false) goto L8;
        int r101 = e();
    L9:
        if (r101 <= 0) goto L15;
        float r102 = this.f50995i;
        if (r102 <= 0) goto L15;
        return (int) (r101 * r102);
    L15:
        return this.f50989c;
    L8:
        r101 = this.f50994h;
        goto L9
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.span.a
    public final Drawable getDrawable() {
        return this.f50987a.e();
    }

    private final void update(BaseSlcViewManager<?> r100) {
        this.f50991e = new WeakReference(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.span.a
    public final void b(BaseSlcViewManager<?> r100, Drawable.Callback r101) {
        update(r100);
        Drawable r102 = this.f50987a.e();
        if (r102 == null) goto L5;
        r102.setBounds(0, 0, f(), e());
    L5:
        Drawable r103 = this.f50987a.e();
        if (r103 == null) goto L9;
        r103.setCallback(r101);
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a
    public final void d(CloseableReference<CloseableImage> r100, Drawable r101) {
        if (this.f50988b == false) goto L55;
        int r102 = this.f50993g;
        boolean r103 = true;
        if (r102 < 0) goto L7;
    L13:
        boolean r104 = false;
    L15:
        if (this.f50994h < 0) goto L17;
    L22:
        r103 = false;
    L23:
        if (r104 == true) goto L29;
        if (r103 == true) goto L29;
        BaseSlcViewManager<?> r105 = this.f50991e.get();
        if (r105 == null) goto L75;
        r105.n0();
        return;
    L75:
        return;
    L29:
        CloseableImage r106 = com.bytedance.android.ecom.arch.slice.render.util.e.g(r100);
        if (r106 == null) goto L32;
        int r107 = r106.getWidth();
    L33:
        if (r106 == null) goto L35;
        int r108 = r106.getHeight();
    L36:
        if (r107 <= 0) goto L47;
        if (r108 <= 0) goto L47;
        float r109 = r107 / r108;
        if (this.f50993g < 0) goto L41;
    L43:
        if (r104 == false) goto L45;
        this.f50989c = (int) (r109 * e());
        goto L47
    L45:
        if (r103 == false) goto L47;
        this.f50990d = (int) (f() / r109);
        goto L47
    L41:
        if (this.f50994h >= 0) goto L43;
        this.f50989c = r107;
        this.f50990d = r108;
    L47:
        Drawable r110 = this.f50987a.e();
        if (r110 == null) goto L50;
        r110.setBounds(0, 0, f(), e());
    L50:
        BaseSlcViewManager<?> r111 = this.f50991e.get();
        if (r111 == null) goto L77;
        r111.J0();
        return;
    L77:
        return;
    L35:
        r108 = 0;
        goto L36
    L32:
        r107 = 0;
        goto L33
    L17:
        if (this.f50990d != 0) goto L22;
        if (r102 < 0) goto L23;
        if (this.f50995i > 0) goto L22;
    L7:
        if (this.f50989c != 0) goto L13;
        if (this.f50994h >= 0) goto L11;
    L12:
        r104 = true;
        goto L15
    L11:
        if (this.f50995i > 0) goto L13;
    L55:
        if (this.f50993g < 0) goto L57;
    L71:
        BaseSlcViewManager<?> r112 = this.f50991e.get();
        if (r112 == null) goto L80;
        r112.n0();
        return;
    L80:
        return;
    L57:
        if (this.f50989c != 0) goto L71;
        CloseableImage r113 = com.bytedance.android.ecom.arch.slice.render.util.e.g(r100);
        if (r113 != null) goto L61;
    L64:
        int r114 = 0;
    L65:
        this.f50989c = r114;
        Drawable r115 = this.f50987a.e();
        if (r115 == null) goto L68;
        r115.setBounds(0, 0, f(), this.f50994h);
    L68:
        BaseSlcViewManager<?> r116 = this.f50991e.get();
        if (r116 == null) goto L78;
        r116.J0();
        return;
    L78:
        return;
    L61:
        if (r113.getHeight() == 0) goto L64;
        r114 = (int) ((r113.getWidth() / r113.getHeight()) * this.f50994h);
        goto L65
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (r104 == null) goto L25;
        if (r104.ascent == 0) goto L6;
    L12:
        int r105 = ((r104.descent - r104.ascent) - e()) / 2;
        int r106 = (r104.ascent + r105) + this.f50997k;
        int r107 = e() + r106;
        if (r106 >= r104.ascent) goto L16;
        r104.ascent = r106;
    L16:
        if (r106 >= r104.top) goto L19;
        r104.top = r106;
    L19:
        if (r107 <= r104.descent) goto L22;
        r104.descent = r107;
    L22:
        if (r107 <= r104.bottom) goto L25;
        r104.bottom = r107;
        goto L25
    L6:
        if (r104.descent != 0) goto L12;
        if (r104.top != 0) goto L12;
        if (r104.bottom != 0) goto L12;
        r100.getFontMetricsInt(r104);
    L25:
        return f();
    }

    public e(SlcRenderContext r100, Object r101, String r102, String r103, int r104, int r105, float r106, String r107, int r108) {
        this.f50992f = r103;
        this.f50993g = r104;
        this.f50994h = r105;
        this.f50995i = r106;
        this.f50996j = r107;
        this.f50997k = r108;
        SlcImageFetchManager r109 = com.bytedance.android.ecom.arch.slice.render.util.e.b(r100, r101);
        ScalingUtils.ScaleType r110 = ScalingUtils.ScaleType.FIT_XY;
        GenericDraweeHierarchy r111 = r109.f();
        if (r111 == null) goto L5;
        r111.setActualImageScaleType(r110);
    L5:
        r109.f50370n = this;
        r109.a(r102, null);
        this.f50987a = r109;
        this.f50988b = r100.K;
        this.f50991e = new WeakReference(null);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        if (Intrinsics.areEqual(this.f50992f, "hidden") == false) goto L5;
        return;
    L5:
        Drawable r109 = this.f50987a.e();
        if (r109 == null) goto L13;
        r100.save();
        if ((r107 - r105) != e()) goto L10;
        float r110 = r105;
    L11:
        r100.translate(r104, Math.round(r110 + this.f50997k));
        r109.draw(r100);
        r100.restore();
        return;
    L10:
        r110 = r106 + (((r108.getFontMetricsInt().ascent + r108.getFontMetricsInt().descent) - e()) / 2.0f);
        goto L11
    }
}
