package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: ScrollEventAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class g extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager2.e f2966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f2967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f2968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayoutManager f2969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2970e;
    private int f;
    private a g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    /* JADX INFO: compiled from: ScrollEventAdapter.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2973c;

        a() {
        }

        void a() {
            this.f2971a = -1;
            this.f2972b = 0.0f;
            this.f2973c = 0;
        }
    }

    g(ViewPager2 r3) {
        this.f2967b = r3;
        RecyclerView r4 = r3.mRecyclerView;
        this.f2968c = r4;
        this.f2969d = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r4.getLayoutManager(), LinearLayoutManager.class, "com.obric.aiagent.plugin");
        this.g = new a();
        i();
    }

    private void i() {
        this.f2970e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void a(RecyclerView r6, int r7) {
        boolean r1 = true;
        if (this.f2970e == 1) goto L5;
    L6:
        if (r7 != 1) goto L10;
        a(false);
        return;
    L10:
        if (k() == false) goto L17;
        if (r7 != 2) goto L17;
        if (this.k == false) goto L48;
        a(2);
        this.j = true;
        return;
    L48:
        return;
    L17:
        if (k() == false) goto L33;
        if (r7 != 0) goto L33;
        j();
        if (this.k == true) goto L25;
        if (this.g.f2971a == (-1)) goto L30;
        a(this.g.f2971a, 0.0f, 0);
    L30:
        if (r1 == false) goto L33;
        a(0);
        i();
        goto L33
    L25:
        if (this.g.f2973c == 0) goto L27;
        r1 = false;
        goto L30
    L27:
        if (this.h == this.g.f2971a) goto L30;
        b(this.g.f2971a);
    L33:
        if (this.f2970e != 2) goto L49;
        if (r7 == 0) goto L36;
        return;
    L36:
        if (this.l == false) goto L51;
        j();
        if (this.g.f2973c == 0) goto L40;
        return;
    L40:
        if (this.i != this.g.f2971a) goto L42;
    L46:
        a(0);
        i();
        return;
    L42:
        if (this.g.f2971a != (-1)) goto L44;
        int r8 = 0;
    L45:
        b(r8);
        goto L46
    L44:
        r8 = this.g.f2971a;
        goto L45
    L51:
        return;
    L49:
        return;
    L5:
        if (this.f == 1) goto L10;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void a(RecyclerView r4, int r5, int r6) {
        this.k = true;
        j();
        if (this.j == false) goto L24;
        this.j = false;
        if (r6 > 0) goto L14;
        if (r6 != 0) goto L13;
        if (r5 >= 0) goto L9;
        boolean r7 = true;
    L11:
        if (r7 != this.f2967b.isRtl()) goto L13;
    L9:
        r7 = false;
    L13:
        boolean r8 = false;
    L15:
        if (r8 == true) goto L17;
    L19:
        int r9 = this.g.f2971a;
    L20:
        this.i = r9;
        if (this.h == r9) goto L30;
        b(r9);
    L30:
        if (this.g.f2971a != (-1)) goto L32;
        int r10 = 0;
    L33:
        a(r10, this.g.f2972b, this.g.f2973c);
        int r11 = this.g.f2971a;
        int r12 = this.i;
        if (r11 == r12) goto L37;
        if (r12 == (-1)) goto L37;
        return;
    L37:
        if (this.g.f2973c == 0) goto L39;
        return;
    L39:
        if (this.f == 1) goto L44;
        a(0);
        i();
        return;
    L44:
        return;
    L32:
        r10 = this.g.f2971a;
        goto L33
    L17:
        if (this.g.f2973c == 0) goto L19;
        r9 = this.g.f2971a + 1;
    L14:
        r8 = true;
        goto L15
    L24:
        if (this.f2970e != 0) goto L30;
        int r13 = this.g.f2971a;
        if (r13 != (-1)) goto L28;
        r13 = 0;
    L28:
        b(r13);
        goto L30
    }

    private void j() {
        a r0 = this.g;
        r0.f2971a = this.f2969d.o();
        if (r0.f2971a != (-1)) goto L6;
        r0.a();
        return;
    L6:
        View r1 = this.f2969d.c(r0.f2971a);
        if (r1 != null) goto L10;
        r0.a();
        return;
    L10:
        int r2 = this.f2969d.n(r1);
        int r3 = this.f2969d.o(r1);
        int r4 = this.f2969d.l(r1);
        int r5 = this.f2969d.m(r1);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2 = r2 + r7.leftMargin;
        r3 = r3 + r7.rightMargin;
        r4 = r4 + r7.topMargin;
        r5 = r5 + r7.bottomMargin;
    L13:
        int r8 = (r1.getHeight() + r4) + r5;
        int r9 = (r1.getWidth() + r2) + r3;
        if (this.f2969d.h() != 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L22;
        int r11 = (r1.getLeft() - r2) - this.f2968c.getPaddingLeft();
        if (this.f2967b.isRtl() == false) goto L21;
        r11 = -r11;
    L21:
        r8 = r9;
    L23:
        r0.f2973c = -r11;
        if (r0.f2973c < 0) goto L26;
        if (r8 != 0) goto L33;
        float r12 = 0.0f;
    L34:
        r0.f2972b = r12;
        return;
    L33:
        r12 = r0.f2973c / r8;
        goto L34
    L26:
        if (new androidx.viewpager2.widget.a(this.f2969d).a() == false) goto L30;
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L30:
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(r0.f2973c)}));
    L22:
        r11 = (r1.getTop() - r4) - this.f2968c.getPaddingTop();
        goto L23
    L16:
        r10 = false;
        goto L17
    }

    private void a(boolean r3) {
        this.m = r3;
        if (r3 == false) goto L5;
        int r4 = 4;
    L6:
        this.f2970e = r4;
        int r5 = this.i;
        if (r5 == (-1)) goto L10;
        this.h = r5;
        this.i = -1;
    L12:
        a(1);
        return;
    L10:
        if (this.h != (-1)) goto L12;
        this.h = l();
        goto L12
    L5:
        r4 = 1;
        goto L6
    }

    void a() {
        this.l = true;
    }

    void a(int r3, boolean r4) {
        if (r4 == false) goto L5;
        int r5 = 2;
    L6:
        this.f2970e = r5;
        boolean r6 = false;
        this.m = false;
        if (this.i == r3) goto L9;
        r6 = true;
    L9:
        this.i = r3;
        a(2);
        if (r6 == false) goto L13;
        b(r3);
        return;
    L13:
        return;
    L5:
        r5 = 3;
        goto L6
    }

    void b() {
        this.f2970e = 4;
        a(true);
    }

    void c() {
        if (f() == true) goto L5;
    L7:
        this.m = false;
        j();
        if (this.g.f2973c == 0) goto L10;
        a(2);
        return;
    L10:
        if (this.g.f2971a == this.h) goto L12;
        b(this.g.f2971a);
    L12:
        a(0);
        i();
        return;
    L5:
        if (this.m == true) goto L7;
    }

    void a(ViewPager2.e r1) {
        this.f2966a = r1;
    }

    int d() {
        return this.f;
    }

    boolean e() {
        if (this.f != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean f() {
        if (this.f == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean g() {
        return this.m;
    }

    private boolean k() {
        int r2 = this.f2970e;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    double h() {
        j();
        return ((double) this.g.f2971a) + ((double) this.g.f2972b);
    }

    private void a(int r3) {
        if (this.f2970e != 3) goto L8;
        if (this.f != 0) goto L8;
        return;
    L8:
        if (this.f != r3) goto L10;
        return;
    L10:
        this.f = r3;
        ViewPager2.e r2 = this.f2966a;
        if (r2 == null) goto L14;
        r2.a(r3);
        return;
    }

    private void b(int r1) {
        ViewPager2.e r0 = this.f2966a;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    private void a(int r1, float r2, int r3) {
        ViewPager2.e r0 = this.f2966a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    private int l() {
        return this.f2969d.o();
    }
}
