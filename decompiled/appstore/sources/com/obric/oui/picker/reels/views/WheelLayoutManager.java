package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import bg.h;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.q;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class WheelLayoutManager extends RecyclerView.LayoutManager {
    public float A;
    public float B;
    public boolean C;
    public int D;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f15939r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f15940s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f15941t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f15942u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f15943v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f15944w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f15945x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f15946y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f15947z;

    public WheelLayoutManager(final Context r10) {
        q.g(r10, "context");
        this.f15939r = f.d(r10, 8000.0f);
        this.f15940s = kotlin.b.b(new WheelLayoutManager$defaultStartColor$2(r10));
        this.f15941t = kotlin.b.b(new WheelLayoutManager$defaultEndColor$2(r10));
        this.f15942u = F1();
        this.f15943v = E1();
        this.f15944w = 30.0f;
        this.f15945x = 3;
        this.f15946y = 0.017453292f;
    }

    public final void A1(View r10, int r11, float r12) {
        float r13 = r11 - r12;
        float r14 = h.j(this.f15944w * r13, -90.0f, 90.0f);
        float r15 = this.f15946y * r14;
        float r16 = h.j(Math.abs(r14) / 90.0f, 0.0f, 1.0f);
        float r17 = h.j(Math.abs(r13), 0.0f, 1.0f);
        float r18 = I1(1.0f, 0.8f, r16);
        r10.setPivotX(r10.getWidth() / 2.0f);
        r10.setPivotY(r10.getHeight() / 2.0f);
        r10.setRotationX(r14);
        r10.setScaleX(r18);
        r10.setScaleY(r18);
        double r19 = r15;
        r10.setTranslationY(((float) Math.sin(r19)) * this.B);
        float r20 = (float) Math.cos(r19);
        float r21 = this.B;
        r10.setTranslationZ((r20 * r21) - r21);
        r10.setCameraDistance(this.f15939r);
        if ((r10 instanceof TextView) == false) goto L5;
        TextView r22 = (TextView) r10;
        r22.setTextColor(androidx.core.graphics.d.c(this.f15942u, this.f15943v, r17));
        r22.setTypeface(Typeface.create(Typeface.DEFAULT, yf.b.b(I1(450.0f, 300.0f, r17)), false));
    L5:
        r10.setAlpha(I1(1.0f, 0.2f, r16));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams B() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final float B1(int r10) {
        return r10 / ((float) Math.tan(this.f15944w * this.f15946y));
    }

    public final int C1(int r10) {
        if (this.f15947z != 0) goto L5;
    L13:
        return 0;
    L5:
        if (V() == 0) goto L13;
        if (this.C == false) goto L10;
        int r11 = h.k(r10, 0, V() - 1);
    L12:
        return yf.b.b((r11 * this.f15947z) - this.A);
    L10:
        int r12 = this.D;
        r11 = h.k(r10, r12, h.d((V() - this.D) - 1, r12));
        goto L12
    }

    public final int D1() {
        if (this.f15947z != 0) goto L5;
    L16:
        return 0;
    L5:
        if (H() == 0) goto L16;
        if (V() > 0) goto L10;
        return 0;
    L10:
        float r10 = this.A / this.f15947z;
        if (this.C == false) goto L13;
        int r11 = h.k(yf.b.b(r10), 0, V() - 1);
    L15:
        return yf.b.b((r11 * this.f15947z) - this.A);
    L13:
        int r12 = this.D;
        r11 = h.k(yf.b.b(r10), r12, h.d((V() - this.D) - 1, r12));
        goto L15
    }

    public final int E1() {
        return ((Number) this.f15941t.getValue()).intValue();
    }

    public final int F1() {
        return ((Number) this.f15940s.getValue()).intValue();
    }

    public final int G1() {
        if (this.f15947z != 0) goto L5;
        return -1;
    L5:
        if (V() == 0) goto L15;
        int r10 = yf.b.b(this.A / this.f15947z);
        if (this.C == true) goto L14;
        int r11 = this.D;
        return h.k(r10, r11, h.d((V() - this.D) - 1, r11));
    L14:
        return h.k(r10, 0, V() - 1);
    L15:
        return -1;
    }

    public final void H1(RecyclerView.o r15) {
        u(r15);
        int r10 = (T() - d0()) - a0();
        if (r10 > 0) goto L5;
        return;
    L5:
        if (this.f15947z == 0) goto L16;
        float r11 = d0() + (r10 / 2.0f);
        float r12 = this.A / this.f15947z;
        float r13 = 1;
        int r14 = h.d((int) Math.floor((r12 - this.f15945x) - r13), 0);
        int r16 = h.g((int) Math.ceil((this.f15945x + r12) + r13), V() - 1);
        if (r14 > r16) goto L15;
    L9:
        int r17 = r14 + 1;
        View r18 = r15.n(r14);
        q.f(r18, "recycler.getViewForPosition(position)");
        c(r18);
        v0(r18, 0, 0);
        int r19 = P(r18);
        int r20 = ((((k0() - b0()) - c0()) - r19) / 2) + b0();
        int r110 = yf.b.b(r11 - (this.f15947z / 2.0f));
        t0(r18, r20, r110, r20 + r19, r110 + this.f15947z);
        A1(r18, r14, r12);
        if (r14 == r16) goto L17;
        r14 = r17;
        goto L9
    L17:
        return;
    L15:
        return;
    }

    public final float I1(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    public final void J1(boolean r10) {
        this.C = r10;
    }

    public final void K1(int r10) {
        this.D = r10;
    }

    public final void L1(int r10) {
        this.f15943v = r10;
    }

    public final void M1(int r10) {
        this.f15942u = r10;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void R0(RecyclerView.o r10, RecyclerView.q r11) {
        q.g(r10, "recycler");
        q.g(r11, WsConstants.KEY_CONNECTION_STATE);
        if (V() != 0) goto L7;
        u(r10);
        this.A = 0.0f;
        return;
    L7:
        if (this.f15947z != 0) goto L9;
        View r12 = r10.n(0);
        q.f(r12, "recycler.getViewForPosition(0)");
        c(r12);
        v0(r12, 0, 0);
        int r13 = O(r12);
        this.f15947z = r13;
        this.B = B1(r13);
        v(r12, r10);
    L9:
        H1(r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean j() {
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void o1(int r10) {
        if (V() != 0) goto L5;
        return;
    L5:
        if (this.f15947z != 0) goto L8;
        return;
    L8:
        if (this.C == false) goto L10;
        int r11 = h.k(r10, 0, V() - 1);
    L11:
        this.A = r11 * this.f15947z;
        l1();
        return;
    L10:
        int r12 = this.D;
        r11 = h.k(r10, r12, h.d((V() - this.D) - 1, r12));
        goto L11
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int p1(int r10, RecyclerView.o r11, RecyclerView.q r12) {
        q.g(r11, "recycler");
        q.g(r12, WsConstants.KEY_CONNECTION_STATE);
        if (H() == 0) goto L16;
        if (r10 == 0) goto L16;
        if (this.f15947z == 0) goto L16;
        if (V() == 0) goto L16;
        float r13 = h.d(V() - 1, 0) * this.f15947z;
        if (this.C == false) goto L13;
        Pair r14 = kotlin.d.a(Float.valueOf(0.0f), Float.valueOf(r13));
    L14:
        float r15 = h.j(this.A + r10, ((Number) r14.component1()).floatValue(), ((Number) r14.component2()).floatValue());
        float r16 = r15 - this.A;
        this.A = r15;
        H1(r11);
        return yf.b.b(r16);
    L13:
        int r17 = this.D;
        int r18 = h.d((V() - this.D) - 1, r17);
        int r19 = this.f15947z;
        r14 = kotlin.d.a(Float.valueOf(r17 * r19), Float.valueOf(r18 * r19));
    L16:
        return 0;
    }
}
