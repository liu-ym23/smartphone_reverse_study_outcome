package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class OrientationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.LayoutManager f4184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f4186c;

    public class a extends OrientationHelper {
        public a(RecyclerView.LayoutManager r10) {
            super(r10, null);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int d(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f4184a.getDecoratedRight(r10) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int e(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f4184a.getDecoratedMeasuredWidth(r10) + ((ViewGroup.MarginLayoutParams) r11).leftMargin) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int f(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f4184a.getDecoratedMeasuredHeight(r10) + ((ViewGroup.MarginLayoutParams) r11).topMargin) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int g(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f4184a.getDecoratedLeft(r10) - ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int h() {
            return this.f4184a.getWidth();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int i() {
            return this.f4184a.getWidth() - this.f4184a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int j() {
            return this.f4184a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int l() {
            return this.f4184a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int m() {
            return this.f4184a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int n() {
            return this.f4184a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int o() {
            return (this.f4184a.getWidth() - this.f4184a.getPaddingLeft()) - this.f4184a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int q(View r10) {
            this.f4184a.getTransformedBoundingBox(r10, true, this.f4186c);
            return this.f4186c.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int r(View r10) {
            this.f4184a.getTransformedBoundingBox(r10, true, this.f4186c);
            return this.f4186c.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void s(int r10) {
            this.f4184a.offsetChildrenHorizontal(r10);
        }
    }

    public class b extends OrientationHelper {
        public b(RecyclerView.LayoutManager r10) {
            super(r10, null);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int d(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f4184a.getDecoratedBottom(r10) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int e(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f4184a.getDecoratedMeasuredHeight(r10) + ((ViewGroup.MarginLayoutParams) r11).topMargin) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int f(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return (this.f4184a.getDecoratedMeasuredWidth(r10) + ((ViewGroup.MarginLayoutParams) r11).leftMargin) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int g(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            return this.f4184a.getDecoratedTop(r10) - ((ViewGroup.MarginLayoutParams) r11).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int h() {
            return this.f4184a.getHeight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int i() {
            return this.f4184a.getHeight() - this.f4184a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int j() {
            return this.f4184a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int l() {
            return this.f4184a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int m() {
            return this.f4184a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int n() {
            return this.f4184a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int o() {
            return (this.f4184a.getHeight() - this.f4184a.getPaddingTop()) - this.f4184a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int q(View r10) {
            this.f4184a.getTransformedBoundingBox(r10, true, this.f4186c);
            return this.f4186c.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int r(View r10) {
            this.f4184a.getTransformedBoundingBox(r10, true, this.f4186c);
            return this.f4186c.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void s(int r10) {
            this.f4184a.offsetChildrenVertical(r10);
        }
    }

    public /* synthetic */ OrientationHelper(RecyclerView.LayoutManager r10, a r11) {
        this(r10);
    }

    public static OrientationHelper a(RecyclerView.LayoutManager r10) {
        return new a(r10);
    }

    public static OrientationHelper b(RecyclerView.LayoutManager r10, int r11) {
        if (r11 == 0) goto L10;
        if (r11 != 1) goto L8;
        return c(r10);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return a(r10);
    }

    public static OrientationHelper c(RecyclerView.LayoutManager r10) {
        return new b(r10);
    }

    public abstract int d(View r10);

    public abstract int e(View r10);

    public abstract int f(View r10);

    public abstract int g(View r10);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.LayoutManager k() {
        return this.f4184a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE != this.f4185b) goto L6;
        return 0;
    L6:
        return o() - this.f4185b;
    }

    public abstract int q(View r10);

    public abstract int r(View r10);

    public abstract void s(int r10);

    public void t() {
        this.f4185b = o();
    }

    public OrientationHelper(RecyclerView.LayoutManager r10) {
        this.f4185b = Integer.MIN_VALUE;
        this.f4186c = new Rect();
        this.f4184a = r10;
    }
}
