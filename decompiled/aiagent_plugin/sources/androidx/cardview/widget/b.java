package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CardViewApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class b implements e {
    @Override // androidx.cardview.widget.e
    public void a() {
    }

    b() {
    }

    @Override // androidx.cardview.widget.e
    public void a(d r3, Context r4, ColorStateList r5, float r6, float r7, float r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        r9.a(new RoundRectDrawable(r5, r6));
        View r11 = r9.d();
        r11.setClipToOutline(true);
        r11.setElevation(r7);
        b(r9, r8);
    }

    @Override // androidx.cardview.widget.e
    public void a(d r3, float r4) {
        j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).setRadius(r4);
    }

    @Override // androidx.cardview.widget.e
    public void b(d r4, float r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        j(r6).setPadding(r5, r6.a(), r6.b());
        f(r6);
    }

    @Override // androidx.cardview.widget.e
    public float a(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getPadding();
    }

    @Override // androidx.cardview.widget.e
    public float b(d r3) {
        return d((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float c(d r3) {
        return d((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float d(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getRadius();
    }

    @Override // androidx.cardview.widget.e
    public void c(d r2, float r3) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).d().setElevation(r3);
    }

    @Override // androidx.cardview.widget.e
    public float e(d r2) {
        return ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).d().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public void f(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if (r6.a() == true) goto L6;
        r6.a(0, 0, 0, 0);
        return;
    L6:
        float r0 = a(r6);
        float r4 = d(r6);
        int r1 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(r0, r4, r6.b()));
        int r7 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(r0, r4, r6.b()));
        r6.a(r1, r7, r1, r7);
    }

    @Override // androidx.cardview.widget.e
    public void g(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        b(r4, a(r4));
    }

    @Override // androidx.cardview.widget.e
    public void h(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        b(r4, a(r4));
    }

    @Override // androidx.cardview.widget.e
    public void a(d r3, ColorStateList r4) {
        j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).setColor(r4);
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList i(d r3) {
        return j((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")).getColor();
    }

    private RoundRectDrawable j(d r2) {
        return (RoundRectDrawable) ZeusTransformUtils.preCheckCast(((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).c(), RoundRectDrawable.class, "com.obric.aiagent.plugin");
    }
}
