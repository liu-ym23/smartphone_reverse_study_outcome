package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CardViewBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f592a;

    @Override // androidx.cardview.widget.e
    public void g(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
    }

    c() {
        this.f592a = new RectF();
    }

    @Override // androidx.cardview.widget.e
    public void a() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new AnonymousClass1(this);
    }

    @Override // androidx.cardview.widget.e
    public void a(d r7, Context r8, ColorStateList r9, float r10, float r11, float r12) {
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        RoundRectDrawableWithShadow r14 = a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), r9, r10, r11, r12);
        r14.setAddPaddingForCorners(r13.b());
        r13.a(r14);
        f(r13);
    }

    private RoundRectDrawableWithShadow a(Context r8, ColorStateList r9, float r10, float r11, float r12) {
        return new RoundRectDrawableWithShadow(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"), r9, r10, r11, r12);
    }

    @Override // androidx.cardview.widget.e
    public void f(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        Rect r0 = new Rect();
        j(r6).getMaxShadowAndCornerPadding(r0);
        r6.a((int) Math.ceil(b(r6)), (int) Math.ceil(c(r6)));
        r6.a(r0.left, r0.top, r0.right, r0.bottom);
    }

    @Override // androidx.cardview.widget.e
    public void h(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        j(r4).setAddPaddingForCorners(r4.b());
        f(r4);
    }

    @Override // androidx.cardview.widget.e
    public void a(d r3, ColorStateList r4) {
        j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).setColor(r4);
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList i(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getColor();
    }

    @Override // androidx.cardview.widget.e
    public void a(d r3, float r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        j(r5).setCornerRadius(r4);
        f(r5);
    }

    @Override // androidx.cardview.widget.e
    public float d(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getCornerRadius();
    }

    @Override // androidx.cardview.widget.e
    public void c(d r3, float r4) {
        j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).setShadowSize(r4);
    }

    @Override // androidx.cardview.widget.e
    public float e(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getShadowSize();
    }

    @Override // androidx.cardview.widget.e
    public void b(d r3, float r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        j(r5).setMaxShadowSize(r4);
        f(r5);
    }

    @Override // androidx.cardview.widget.e
    public float a(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.e
    public float b(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getMinWidth();
    }

    @Override // androidx.cardview.widget.e
    public float c(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getMinHeight();
    }

    private RoundRectDrawableWithShadow j(d r2) {
        return (RoundRectDrawableWithShadow) ZeusTransformUtils.preCheckCast(((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).c(), RoundRectDrawableWithShadow.class, "com.obric.aiagent.plugin");
    }
}
