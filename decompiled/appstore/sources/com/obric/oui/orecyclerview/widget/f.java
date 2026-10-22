package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.LayoutManager f15698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f15700c;

    public class a extends f {
        public a(RecyclerView.LayoutManager r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int d(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f15698a.Q(r10) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int e(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f15698a.P(r10) + ((ViewGroup.MarginLayoutParams) r11).leftMargin) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int f(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f15698a.O(r10) + ((ViewGroup.MarginLayoutParams) r11).topMargin) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int g(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f15698a.N(r10) - ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int h() {
            return this.f15698a.k0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int i() {
            return this.f15698a.k0() - this.f15698a.c0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int j() {
            return this.f15698a.c0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int k() {
            return this.f15698a.l0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int l() {
            return this.f15698a.b0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int m() {
            return (this.f15698a.k0() - this.f15698a.b0()) - this.f15698a.c0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int o(View r10) {
            this.f15698a.j0(r10, true, this.f15700c);
            return this.f15700c.right;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int p(View r10) {
            this.f15698a.j0(r10, true, this.f15700c);
            return this.f15700c.left;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public void q(int r10) {
            this.f15698a.x0(r10);
        }
    }

    public class b extends f {
        public b(RecyclerView.LayoutManager r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int d(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f15698a.L(r10) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int e(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f15698a.O(r10) + ((ViewGroup.MarginLayoutParams) r11).topMargin) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int f(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f15698a.P(r10) + ((ViewGroup.MarginLayoutParams) r11).leftMargin) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int g(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f15698a.R(r10) - ((ViewGroup.MarginLayoutParams) r11).topMargin;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int h() {
            return this.f15698a.T();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int i() {
            return this.f15698a.T() - this.f15698a.a0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int j() {
            return this.f15698a.a0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int k() {
            return this.f15698a.U();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int l() {
            return this.f15698a.d0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int m() {
            return (this.f15698a.T() - this.f15698a.d0()) - this.f15698a.a0();
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int o(View r10) {
            this.f15698a.j0(r10, true, this.f15700c);
            return this.f15700c.bottom;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public int p(View r10) {
            this.f15698a.j0(r10, true, this.f15700c);
            return this.f15700c.top;
        }

        @Override // com.obric.oui.orecyclerview.widget.f
        public void q(int r10) {
            this.f15698a.y0(r10);
        }
    }

    public /* synthetic */ f(RecyclerView.LayoutManager r10, a r11) {
        this(r10);
    }

    public static f a(RecyclerView.LayoutManager r10) {
        return new a(r10);
    }

    public static f b(RecyclerView.LayoutManager r10, int r11) {
        if (r11 == 0) goto L10;
        if (r11 != 1) goto L8;
        return c(r10);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return a(r10);
    }

    public static f c(RecyclerView.LayoutManager r10) {
        return new b(r10);
    }

    public abstract int d(View r10);

    public abstract int e(View r10);

    public abstract int f(View r10);

    public abstract int g(View r10);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public int n() {
        if (Integer.MIN_VALUE != this.f15699b) goto L6;
        return 0;
    L6:
        return m() - this.f15699b;
    }

    public abstract int o(View r10);

    public abstract int p(View r10);

    public abstract void q(int r10);

    public void r() {
        this.f15699b = m();
    }

    public f(RecyclerView.LayoutManager r10) {
        this.f15699b = Integer.MIN_VALUE;
        this.f15700c = new Rect();
        this.f15698a = r10;
    }
}
