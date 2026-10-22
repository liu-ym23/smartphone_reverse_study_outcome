package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.e;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.m;
import d.s;

/* JADX INFO: compiled from: WheelLayoutManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f35965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f35966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f35967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f35969e;
    private final float f;
    private final int g;
    private final float h;
    private int i;
    private float j;
    private float k;
    private boolean l;
    private int m;

    /* JADX INFO: compiled from: WheelLayoutManager.kt */
    static final class a extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35970a;

        a(Context r3) {
            this.f35970a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(androidx.core.content.a.c(this.f35970a, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: WheelLayoutManager.kt */
    static final class b extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35971a;

        b(Context r3) {
            this.f35971a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(androidx.core.content.a.c(this.f35971a, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg")));
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    private final float a(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean g() {
        return true;
    }

    public c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f35965a = g.c(r5, 8000.0f);
        this.f35966b = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.f35967c = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.f35968d = i();
        this.f35969e = j();
        this.f = 30.0f;
        this.g = 3;
        this.h = 0.017453292f;
    }

    private final int i() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f35966b.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private final int j() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f35967c.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    public final void a(boolean r1) {
        this.l = r1;
    }

    public final void a(int r1) {
        this.m = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void c(RecyclerView.o r3, RecyclerView.s r4) {
        o.e(r3, "recycler");
        o.e(r4, "state");
        if (I() != 0) goto L7;
        a(r3);
        this.j = 0.0f;
        return;
    L7:
        if (this.i != 0) goto L9;
        View r0 = r3.c(0);
        o.c(r0, "recycler.getViewForPosition(0)");
        b(r0);
        a(r0, 0, 0);
        int r5 = g(r0);
        this.i = r5;
        this.k = m(r5);
        a(r0, r3);
    L9:
        d(r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int b(int r4, RecyclerView.o r5, RecyclerView.s r6) {
        o.e(r5, "recycler");
        o.e(r6, "state");
        if (y() == 0) goto L16;
        if (r4 == 0) goto L16;
        if (this.i == 0) goto L16;
        if (I() == 0) goto L16;
        float r7 = n.c(I() - 1, 0) * this.i;
        if (this.l == false) goto L13;
        m r8 = s.a(Float.valueOf(0.0f), Float.valueOf(r7));
    L14:
        float r9 = n.a(this.j + r4, ((Number) ZeusTransformUtils.preCheckCast(r8.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r8.d(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        float r10 = r9 - this.j;
        this.j = r9;
        d(r5);
        return d.i.a.a(r10);
    L13:
        int r11 = this.m;
        int r0 = n.c((I() - this.m) - 1, r11);
        int r1 = this.i;
        r8 = s.a(Float.valueOf(r11 * r1), Float.valueOf(r0 * r1));
    L16:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void e(int r4) {
        if (I() != 0) goto L5;
        return;
    L5:
        if (this.i != 0) goto L8;
        return;
    L8:
        if (this.l == false) goto L10;
        int r5 = n.a(r4, 0, I() - 1);
    L11:
        this.j = r5 * this.i;
        r();
        return;
    L10:
        int r0 = this.m;
        r5 = n.a(r4, r0, n.c((I() - this.m) - 1, r0));
        goto L11
    }

    private final void d(RecyclerView.o r15) {
        a(r15);
        int r0 = (C() - E()) - G();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (this.i == 0) goto L16;
        float r1 = E() + (r0 / 2.0f);
        float r2 = this.j / this.i;
        float r5 = 1;
        int r3 = n.c((int) Math.floor((r2 - this.g) - r5), 0);
        int r4 = n.d((int) Math.ceil((this.g + r2) + r5), I() - 1);
        if (r3 > r4) goto L15;
    L9:
        int r6 = r3 + 1;
        View r13 = r15.c(r3);
        o.c(r13, "recycler.getViewForPosition(position)");
        b(r13);
        a(r13, 0, 0);
        int r7 = f(r13);
        int r9 = ((((B() - D()) - F()) - r7) / 2) + D();
        int r10 = d.i.a.a(r1 - (this.i / 2.0f));
        a(r13, r9, r10, r9 + r7, r10 + this.i);
        a(r13, r3, r2);
        if (r3 == r4) goto L17;
        r3 = r6;
        goto L9
    L17:
        return;
    L15:
        return;
    }

    private final void a(View r7, int r8, float r9) {
        float r10 = r8 - r9;
        float r11 = n.a(this.f * r10, -90.0f, 90.0f);
        float r0 = this.h * r11;
        float r2 = n.a(Math.abs(r11) / 90.0f, 0.0f, 1.0f);
        float r12 = n.a(Math.abs(r10), 0.0f, 1.0f);
        float r1 = a(1.0f, 0.8f, r2);
        r7.setPivotX(r7.getWidth() / 2.0f);
        r7.setPivotY(r7.getHeight() / 2.0f);
        r7.setRotationX(r11);
        r7.setScaleX(r1);
        r7.setScaleY(r1);
        double r3 = r0;
        r7.setTranslationY(((float) Math.sin(r3)) * this.k);
        float r13 = (float) Math.cos(r3);
        float r4 = this.k;
        r7.setTranslationZ((r13 * r4) - r4);
        r7.setCameraDistance(this.f35965a);
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L7;
        ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).setTextColor(e.a(this.f35968d, this.f35969e, r12));
        int r14 = d.i.a.a(a(450.0f, 300.0f, r12));
        if (Build.VERSION.SDK_INT < 28) goto L7;
        ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).setTypeface(Typeface.create(Typeface.DEFAULT, r14, false));
    L7:
        r7.setAlpha(a(1.0f, 0.2f, r2));
    }

    public final int b() {
        if (this.i != 0) goto L5;
    L16:
        return 0;
    L5:
        if (y() == 0) goto L16;
        if (I() > 0) goto L10;
        return 0;
    L10:
        float r0 = this.j / this.i;
        if (this.l == false) goto L13;
        int r1 = n.a(d.i.a.a(r0), 0, I() - 1);
    L15:
        return d.i.a.a((r1 * this.i) - this.j);
    L13:
        int r2 = this.m;
        r1 = n.a(d.i.a.a(r0), r2, n.c((I() - this.m) - 1, r2));
        goto L15
    }

    public final int b(int r4) {
        if (this.i != 0) goto L5;
    L13:
        return 0;
    L5:
        if (I() == 0) goto L13;
        if (this.l == false) goto L10;
        int r5 = n.a(r4, 0, I() - 1);
    L12:
        return d.i.a.a((r5 * this.i) - this.j);
    L10:
        int r0 = this.m;
        r5 = n.a(r4, r0, n.c((I() - this.m) - 1, r0));
        goto L12
    }

    public final int h() {
        if (this.i != 0) goto L5;
        return -1;
    L5:
        if (I() == 0) goto L15;
        int r0 = d.i.a.a(this.j / this.i);
        if (this.l == true) goto L14;
        int r1 = this.m;
        return n.a(r0, r1, n.c((I() - this.m) - 1, r1));
    L14:
        return n.a(r0, 0, I() - 1);
    L15:
        return -1;
    }

    private final float m(int r3) {
        return r3 / ((float) Math.tan(this.f * this.h));
    }

    public final void d(int r1) {
        this.f35968d = r1;
    }

    public final void f(int r1) {
        this.f35969e = r1;
    }
}
