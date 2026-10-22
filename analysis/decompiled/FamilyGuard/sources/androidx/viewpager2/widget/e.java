package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
final class e extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager2.i f11743a;

    /* renamed from: b, reason: collision with root package name */
    private final ViewPager2 f11744b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView f11745c;

    /* renamed from: d, reason: collision with root package name */
    private final LinearLayoutManager f11746d;

    /* renamed from: e, reason: collision with root package name */
    private int f11747e;

    /* renamed from: f, reason: collision with root package name */
    private int f11748f;

    /* renamed from: g, reason: collision with root package name */
    private a f11749g;

    /* renamed from: h, reason: collision with root package name */
    private int f11750h;

    /* renamed from: i, reason: collision with root package name */
    private int f11751i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11752j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11753k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11754l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11755m;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f11756a;

        /* renamed from: b, reason: collision with root package name */
        float f11757b;

        /* renamed from: c, reason: collision with root package name */
        int f11758c;

        a() {
        }

        void a() {
            this.f11756a = -1;
            this.f11757b = 0.0f;
            this.f11758c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.f11744b = viewPager2;
        RecyclerView recyclerView = viewPager2.f11703j;
        this.f11745c = recyclerView;
        this.f11746d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f11749g = new a();
        l();
    }

    private void a(int i5, float f5, int i6) {
        ViewPager2.i iVar = this.f11743a;
        if (iVar != null) {
            iVar.b(i5, f5, i6);
        }
    }

    private void b(int i5) {
        ViewPager2.i iVar = this.f11743a;
        if (iVar != null) {
            iVar.c(i5);
        }
    }

    private void c(int i5) {
        if ((this.f11747e == 3 && this.f11748f == 0) || this.f11748f == i5) {
            return;
        }
        this.f11748f = i5;
        ViewPager2.i iVar = this.f11743a;
        if (iVar != null) {
            iVar.a(i5);
        }
    }

    private int d() {
        return this.f11746d.findFirstVisibleItemPosition();
    }

    private boolean i() {
        int i5 = this.f11747e;
        return i5 == 1 || i5 == 4;
    }

    private void l() {
        this.f11747e = 0;
        this.f11748f = 0;
        this.f11749g.a();
        this.f11750h = -1;
        this.f11751i = -1;
        this.f11752j = false;
        this.f11753k = false;
        this.f11755m = false;
        this.f11754l = false;
    }

    private void n(boolean z5) {
        this.f11755m = z5;
        this.f11747e = z5 ? 4 : 1;
        int i5 = this.f11751i;
        if (i5 != -1) {
            this.f11750h = i5;
            this.f11751i = -1;
        } else if (this.f11750h == -1) {
            this.f11750h = d();
        }
        c(1);
    }

    private void o() {
        int top;
        a aVar = this.f11749g;
        int iFindFirstVisibleItemPosition = this.f11746d.findFirstVisibleItemPosition();
        aVar.f11756a = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            aVar.a();
            return;
        }
        View viewFindViewByPosition = this.f11746d.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f11746d.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f11746d.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f11746d.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f11746d.getBottomDecorationHeight(viewFindViewByPosition);
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
        if (this.f11746d.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f11745c.getPaddingLeft();
            if (this.f11744b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f11745c.getPaddingTop();
        }
        int i5 = -top;
        aVar.f11758c = i5;
        if (i5 >= 0) {
            aVar.f11757b = height == 0 ? 0.0f : i5 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f11746d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f11758c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    double e() {
        o();
        a aVar = this.f11749g;
        return aVar.f11756a + aVar.f11757b;
    }

    int f() {
        return this.f11748f;
    }

    boolean g() {
        return this.f11755m;
    }

    boolean h() {
        return this.f11748f == 0;
    }

    void j() {
        this.f11754l = true;
    }

    void k(int i5, boolean z5) {
        this.f11747e = z5 ? 2 : 3;
        this.f11755m = false;
        boolean z6 = this.f11751i != i5;
        this.f11751i = i5;
        c(2);
        if (z6) {
            b(i5);
        }
    }

    void m(ViewPager2.i iVar) {
        this.f11743a = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
        if (!(this.f11747e == 1 && this.f11748f == 1) && i5 == 1) {
            n(false);
            return;
        }
        if (i() && i5 == 2) {
            if (this.f11753k) {
                c(2);
                this.f11752j = true;
                return;
            }
            return;
        }
        if (i() && i5 == 0) {
            o();
            if (this.f11753k) {
                a aVar = this.f11749g;
                if (aVar.f11758c == 0) {
                    int i6 = this.f11750h;
                    int i7 = aVar.f11756a;
                    if (i6 != i7) {
                        b(i7);
                    }
                }
            } else {
                int i8 = this.f11749g.f11756a;
                if (i8 != -1) {
                    a(i8, 0.0f, 0);
                }
            }
            c(0);
            l();
        }
        if (this.f11747e == 2 && i5 == 0 && this.f11754l) {
            o();
            a aVar2 = this.f11749g;
            if (aVar2.f11758c == 0) {
                int i9 = this.f11751i;
                int i10 = aVar2.f11756a;
                if (i9 != i10) {
                    if (i10 == -1) {
                        i10 = 0;
                    }
                    b(i10);
                }
                c(0);
                l();
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
            r3.f11753k = r4
            r3.o()
            boolean r0 = r3.f11752j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f11752j = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f11744b
            boolean r6 = r6.d()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.e$a r5 = r3.f11749g
            int r6 = r5.f11758c
            if (r6 == 0) goto L29
            int r5 = r5.f11756a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.e$a r5 = r3.f11749g
            int r5 = r5.f11756a
        L2d:
            r3.f11751i = r5
            int r6 = r3.f11750h
            if (r6 == r5) goto L45
            r3.b(r5)
            goto L45
        L37:
            int r5 = r3.f11747e
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.e$a r5 = r3.f11749g
            int r5 = r5.f11756a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.b(r5)
        L45:
            androidx.viewpager2.widget.e$a r5 = r3.f11749g
            int r6 = r5.f11756a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.f11757b
            int r5 = r5.f11758c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f11749g
            int r6 = r5.f11756a
            int r0 = r3.f11751i
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f11758c
            if (r5 != 0) goto L6b
            int r5 = r3.f11748f
            if (r5 == r4) goto L6b
            r3.c(r2)
            r3.l()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
