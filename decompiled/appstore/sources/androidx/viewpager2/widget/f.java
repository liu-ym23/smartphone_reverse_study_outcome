package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2.h f5206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f5207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f5208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f5209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f5212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5218m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f5220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5221c;

        public a() {
        }

        public void a() {
            this.f5219a = -1;
            this.f5220b = 0.0f;
            this.f5221c = 0;
        }
    }

    public f(ViewPager2 r10) {
        this.f5207b = r10;
        RecyclerView r11 = r10.f5167j;
        this.f5208c = r11;
        this.f5209d = (LinearLayoutManager) r11.getLayoutManager();
        this.f5212g = new a();
        l();
    }

    public final void a(int r10, float r11, int r12) {
        ViewPager2.h r13 = this.f5206a;
        if (r13 == null) goto L6;
        r13.onPageScrolled(r10, r11, r12);
        return;
    }

    public final void b(int r10) {
        ViewPager2.h r11 = this.f5206a;
        if (r11 == null) goto L6;
        r11.onPageSelected(r10);
        return;
    }

    public final void c(int r10) {
        if (this.f5210e != 3) goto L8;
        if (this.f5211f != 0) goto L8;
        return;
    L8:
        if (this.f5211f != r10) goto L10;
        return;
    L10:
        this.f5211f = r10;
        ViewPager2.h r11 = this.f5206a;
        if (r11 == null) goto L14;
        r11.onPageScrollStateChanged(r10);
        return;
    }

    public final int d() {
        return this.f5209d.findFirstVisibleItemPosition();
    }

    public double e() {
        o();
        a r10 = this.f5212g;
        return ((double) r10.f5219a) + ((double) r10.f5220b);
    }

    public int f() {
        return this.f5211f;
    }

    public boolean g() {
        return this.f5218m;
    }

    public boolean h() {
        if (this.f5211f != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        int r10 = this.f5210e;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    public void j() {
        this.f5217l = true;
    }

    public void k(int r10, boolean r11) {
        if (r11 == false) goto L5;
        int r12 = 2;
    L6:
        this.f5210e = r12;
        boolean r13 = false;
        this.f5218m = false;
        if (this.f5214i == r10) goto L9;
        r13 = true;
    L9:
        this.f5214i = r10;
        c(2);
        if (r13 == false) goto L13;
        b(r10);
        return;
    L13:
        return;
    L5:
        r12 = 3;
        goto L6
    }

    public final void l() {
        this.f5210e = 0;
        this.f5211f = 0;
        this.f5212g.a();
        this.f5213h = -1;
        this.f5214i = -1;
        this.f5215j = false;
        this.f5216k = false;
        this.f5218m = false;
        this.f5217l = false;
    }

    public void m(ViewPager2.h r10) {
        this.f5206a = r10;
    }

    public final void n(boolean r10) {
        this.f5218m = r10;
        if (r10 == false) goto L5;
        int r11 = 4;
    L6:
        this.f5210e = r11;
        int r12 = this.f5214i;
        if (r12 == (-1)) goto L10;
        this.f5213h = r12;
        this.f5214i = -1;
    L12:
        c(1);
        return;
    L10:
        if (this.f5213h != (-1)) goto L12;
        this.f5213h = d();
        goto L12
    L5:
        r11 = 1;
        goto L6
    }

    public final void o() {
        a r10 = this.f5212g;
        int r11 = this.f5209d.findFirstVisibleItemPosition();
        r10.f5219a = r11;
        if (r11 != (-1)) goto L6;
        r10.a();
        return;
    L6:
        View r12 = this.f5209d.findViewByPosition(r11);
        if (r12 != null) goto L10;
        r10.a();
        return;
    L10:
        int r13 = this.f5209d.getLeftDecorationWidth(r12);
        int r14 = this.f5209d.getRightDecorationWidth(r12);
        int r15 = this.f5209d.getTopDecorationHeight(r12);
        int r16 = this.f5209d.getBottomDecorationHeight(r12);
        ViewGroup.LayoutParams r17 = r12.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        r13 = r13 + r18.leftMargin;
        r14 = r14 + r18.rightMargin;
        r15 = r15 + r18.topMargin;
        r16 = r16 + r18.bottomMargin;
    L13:
        int r19 = (r12.getHeight() + r15) + r16;
        int r20 = (r12.getWidth() + r13) + r14;
        if (this.f5209d.getOrientation() != 0) goto L19;
        int r21 = (r12.getLeft() - r13) - this.f5208c.getPaddingLeft();
        if (this.f5207b.d() == false) goto L18;
        r21 = -r21;
    L18:
        r19 = r20;
    L20:
        int r22 = -r21;
        r10.f5221c = r22;
        if (r22 < 0) goto L23;
        if (r19 != 0) goto L30;
        float r23 = 0.0f;
    L31:
        r10.f5220b = r23;
        return;
    L30:
        r23 = r22 / r19;
        goto L31
    L23:
        if (new androidx.viewpager2.widget.a(this.f5209d).d() == false) goto L27;
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L27:
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(r10.f5221c)}));
    L19:
        r21 = (r12.getTop() - r15) - this.f5208c.getPaddingTop();
        goto L20
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r10, int r11) {
        if (this.f5210e == 1) goto L5;
    L6:
        if (r11 != 1) goto L10;
        n(false);
        return;
    L10:
        if (i() == false) goto L17;
        if (r11 != 2) goto L17;
        if (this.f5216k == false) goto L44;
        c(2);
        this.f5215j = true;
        return;
    L44:
        return;
    L17:
        if (i() == false) goto L31;
        if (r11 != 0) goto L31;
        o();
        if (this.f5216k == true) goto L24;
        int r12 = this.f5212g.f5219a;
        if (r12 == (-1)) goto L29;
        a(r12, 0.0f, 0);
    L29:
        c(0);
        l();
        goto L31
    L24:
        a r13 = this.f5212g;
        if (r13.f5221c != 0) goto L31;
        int r14 = this.f5213h;
        int r15 = r13.f5219a;
        if (r14 == r15) goto L29;
        b(r15);
    L31:
        if (this.f5210e != 2) goto L45;
        if (r11 == 0) goto L34;
        return;
    L34:
        if (this.f5217l == false) goto L47;
        o();
        a r16 = this.f5212g;
        if (r16.f5221c != 0) goto L48;
        int r17 = this.f5214i;
        int r18 = r16.f5219a;
        if (r17 == r18) goto L42;
        if (r18 != (-1)) goto L41;
        r18 = 0;
    L41:
        b(r18);
    L42:
        c(0);
        l();
        return;
    L48:
        return;
    L47:
        return;
    L45:
        return;
    L5:
        if (this.f5211f == 1) goto L10;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r10, int r11, int r12) {
        this.f5216k = true;
        o();
        if (this.f5215j == false) goto L20;
        this.f5215j = false;
        if (r12 > 0) goto L12;
        if (r12 != 0) goto L15;
        if (r11 >= 0) goto L9;
        boolean r13 = true;
    L11:
        if (r13 != this.f5207b.d()) goto L15;
    L9:
        r13 = false;
    L15:
        int r14 = this.f5212g.f5219a;
    L16:
        this.f5214i = r14;
        if (this.f5213h == r14) goto L25;
        b(r14);
    L25:
        a r15 = this.f5212g;
        int r16 = r15.f5219a;
        if (r16 != (-1)) goto L28;
        r16 = 0;
    L28:
        a(r16, r15.f5220b, r15.f5221c);
        a r17 = this.f5212g;
        int r18 = r17.f5219a;
        int r19 = this.f5214i;
        if (r18 == r19) goto L32;
        if (r19 == (-1)) goto L32;
        return;
    L32:
        if (r17.f5221c == 0) goto L34;
        return;
    L34:
        if (this.f5211f == 1) goto L39;
        c(0);
        l();
        return;
    L39:
        return;
    L12:
        a r20 = this.f5212g;
        if (r20.f5221c == 0) goto L15;
        r14 = r20.f5219a + 1;
        goto L16
    L20:
        if (this.f5210e != 0) goto L25;
        int r21 = this.f5212g.f5219a;
        if (r21 != (-1)) goto L24;
        r21 = 0;
    L24:
        b(r21);
        goto L25
    }
}
