package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public ViewPager2.i f15149a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f15150b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f15151c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f15152d;

    /* renamed from: e, reason: collision with root package name */
    public int f15153e;

    /* renamed from: f, reason: collision with root package name */
    public int f15154f;

    /* renamed from: g, reason: collision with root package name */
    public a f15155g;

    /* renamed from: h, reason: collision with root package name */
    public int f15156h;

    /* renamed from: i, reason: collision with root package name */
    public int f15157i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15158j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15159k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15160l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15161m;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f15162a;

        /* renamed from: b, reason: collision with root package name */
        public float f15163b;

        /* renamed from: c, reason: collision with root package name */
        public int f15164c;

        public void a() {
            this.f15162a = -1;
            this.f15163b = 0.0f;
            this.f15164c = 0;
        }
    }

    public f(ViewPager2 viewPager2) {
        this.f15150b = viewPager2;
        RecyclerView recyclerView = viewPager2.f15105j;
        this.f15151c = recyclerView;
        this.f15152d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f15155g = new a();
        o();
    }

    public final void a(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f15149a;
        if (iVar != null) {
            iVar.onPageScrolled(i10, f10, i11);
        }
    }

    public final void b(int i10) {
        ViewPager2.i iVar = this.f15149a;
        if (iVar != null) {
            iVar.onPageSelected(i10);
        }
    }

    public final void c(int i10) {
        if ((this.f15153e == 3 && this.f15154f == 0) || this.f15154f == i10) {
            return;
        }
        this.f15154f = i10;
        ViewPager2.i iVar = this.f15149a;
        if (iVar != null) {
            iVar.onPageScrollStateChanged(i10);
        }
    }

    public final int d() {
        return this.f15152d.findFirstVisibleItemPosition();
    }

    public double e() {
        r();
        a aVar = this.f15155g;
        return aVar.f15162a + aVar.f15163b;
    }

    public int f() {
        return this.f15154f;
    }

    public boolean g() {
        return this.f15154f == 1;
    }

    public boolean h() {
        return this.f15161m;
    }

    public boolean i() {
        return this.f15154f == 0;
    }

    public final boolean j() {
        int i10 = this.f15153e;
        return i10 == 1 || i10 == 4;
    }

    public void k() {
        this.f15153e = 4;
        q(true);
    }

    public void l() {
        this.f15160l = true;
    }

    public void m() {
        if (!g() || this.f15161m) {
            this.f15161m = false;
            r();
            a aVar = this.f15155g;
            if (aVar.f15164c != 0) {
                c(2);
                return;
            }
            int i10 = aVar.f15162a;
            if (i10 != this.f15156h) {
                b(i10);
            }
            c(0);
            o();
        }
    }

    public void n(int i10, boolean z10) {
        this.f15153e = z10 ? 2 : 3;
        this.f15161m = false;
        boolean z11 = this.f15157i != i10;
        this.f15157i = i10;
        c(2);
        if (z11) {
            b(i10);
        }
    }

    public final void o() {
        this.f15153e = 0;
        this.f15154f = 0;
        this.f15155g.a();
        this.f15156h = -1;
        this.f15157i = -1;
        this.f15158j = false;
        this.f15159k = false;
        this.f15161m = false;
        this.f15160l = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if (!(this.f15153e == 1 && this.f15154f == 1) && i10 == 1) {
            q(false);
            return;
        }
        if (j() && i10 == 2) {
            if (this.f15159k) {
                c(2);
                this.f15158j = true;
                return;
            }
            return;
        }
        if (j() && i10 == 0) {
            r();
            if (this.f15159k) {
                a aVar = this.f15155g;
                if (aVar.f15164c == 0) {
                    int i11 = this.f15156h;
                    int i12 = aVar.f15162a;
                    if (i11 != i12) {
                        b(i12);
                    }
                }
            } else {
                int i13 = this.f15155g.f15162a;
                if (i13 != -1) {
                    a(i13, 0.0f, 0);
                }
            }
            c(0);
            o();
        }
        if (this.f15153e == 2 && i10 == 0 && this.f15160l) {
            r();
            a aVar2 = this.f15155g;
            if (aVar2.f15164c == 0) {
                int i14 = this.f15157i;
                int i15 = aVar2.f15162a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    b(i15);
                }
                c(0);
                o();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f15159k = r4
            r3.r()
            boolean r0 = r3.f15158j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f15158j = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f15150b
            boolean r6 = r6.g()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.f$a r5 = r3.f15155g
            int r6 = r5.f15164c
            if (r6 == 0) goto L29
            int r5 = r5.f15162a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.f$a r5 = r3.f15155g
            int r5 = r5.f15162a
        L2d:
            r3.f15157i = r5
            int r6 = r3.f15156h
            if (r6 == r5) goto L45
            r3.b(r5)
            goto L45
        L37:
            int r5 = r3.f15153e
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.f$a r5 = r3.f15155g
            int r5 = r5.f15162a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.b(r5)
        L45:
            androidx.viewpager2.widget.f$a r5 = r3.f15155g
            int r6 = r5.f15162a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.f15163b
            int r5 = r5.f15164c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.f$a r5 = r3.f15155g
            int r6 = r5.f15162a
            int r0 = r3.f15157i
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f15164c
            if (r5 != 0) goto L6b
            int r5 = r3.f15154f
            if (r5 == r4) goto L6b
            r3.c(r2)
            r3.o()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.f.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public void p(ViewPager2.i iVar) {
        this.f15149a = iVar;
    }

    public final void q(boolean z10) {
        this.f15161m = z10;
        this.f15153e = z10 ? 4 : 1;
        int i10 = this.f15157i;
        if (i10 != -1) {
            this.f15156h = i10;
            this.f15157i = -1;
        } else if (this.f15156h == -1) {
            this.f15156h = d();
        }
        c(1);
    }

    public final void r() {
        int top;
        a aVar = this.f15155g;
        int iFindFirstVisibleItemPosition = this.f15152d.findFirstVisibleItemPosition();
        aVar.f15162a = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            aVar.a();
            return;
        }
        View viewFindViewByPosition = this.f15152d.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f15152d.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f15152d.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f15152d.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f15152d.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f15152d.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f15151c.getPaddingLeft();
            if (this.f15150b.g()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f15151c.getPaddingTop();
        }
        int i10 = -top;
        aVar.f15164c = i10;
        if (i10 >= 0) {
            aVar.f15163b = height == 0 ? 0.0f : i10 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f15152d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f15164c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }
}
