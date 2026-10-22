package m9;

import android.R;
import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.R$id;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f22224v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f22225w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Map f22226x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Window f22228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f22229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f22230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m9.b f22231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m9.a f22232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f22233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ContentObserver f22237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m9.c f22238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f22239m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22240n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22241o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f22242p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f22243q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f22244r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f22245s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f22246t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f22247u;

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f22248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f22249b;

        public a(e r10, Handler r11, View r12) {
            this.f22249b = r10;
            this.f22248a = r12;
            super(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            e r11 = this.f22249b;
            e.b(r11, new m9.a(e.c(r11)));
            int r12 = e.d(this.f22249b).getPaddingBottom();
            int r13 = e.d(this.f22249b).getPaddingRight();
            if (e.c(this.f22249b) != null) goto L5;
        L34:
            e r14 = this.f22249b;
            e.k(r14, 0, e.d(r14).getPaddingTop(), r13, r12);
            return;
        L5:
            if (e.c(this.f22249b).getContentResolver() == null) goto L34;
            if (Settings.System.getInt(e.c(this.f22249b).getContentResolver(), "navigationbar_is_min", 0) != 1) goto L10;
            this.f22248a.setVisibility(8);
        L9:
            r12 = 0;
            r13 = 0;
            goto L34
        L10:
            this.f22248a.setVisibility(0);
            if (e.n(e.e(this.f22249b).findViewById(R.id.content)) == true) goto L9;
            if (e.f(this.f22249b) != 0) goto L17;
            e r15 = this.f22249b;
            e.g(r15, e.a(r15).d());
        L17:
            if (e.h(this.f22249b) != 0) goto L20;
            e r16 = this.f22249b;
            e.i(r16, e.a(r16).f());
        L20:
            if (e.j(this.f22249b).f22187h == true) goto L34;
            FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) this.f22248a.getLayoutParams();
            if (e.a(this.f22249b).l() == false) goto L28;
            r17.gravity = 80;
            r17.height = e.f(this.f22249b);
            if (e.j(this.f22249b).f22186g == true) goto L26;
            int r18 = e.f(this.f22249b);
        L27:
            int r19 = 0;
        L33:
            this.f22248a.setLayoutParams(r17);
            r12 = r18;
            r13 = r19;
            goto L34
        L26:
            r18 = 0;
            goto L27
        L28:
            r17.gravity = 8388613;
            r17.width = e.h(this.f22249b);
            if (e.j(this.f22249b).f22186g == true) goto L31;
            int r20 = e.h(this.f22249b);
        L32:
            r19 = r20;
            r18 = 0;
            goto L33
        L31:
            r20 = 0;
            goto L32
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f22250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f22251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f22252c;

        public b(ViewGroup.LayoutParams r10, View r11, Activity r12) {
            this.f22250a = r10;
            this.f22251b = r11;
            this.f22252c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams r10 = this.f22250a;
            r10.height = this.f22251b.getHeight() + e.E(this.f22252c);
            View r11 = this.f22251b;
            r11.setPadding(r11.getPaddingLeft(), this.f22251b.getPaddingTop() + e.E(this.f22252c), this.f22251b.getPaddingRight(), this.f22251b.getPaddingBottom());
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22253a = null;

        static {
            int[] r10 = new int[BarHide.values().length];
            f22253a = r10;
            r10[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f22253a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f22253a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f22253a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f22224v = R$id.immersion_status_bar_view;
        f22225w = R$id.immersion_navigation_bar_view;
        f22226x = new HashMap();
    }

    public e(Activity r10) {
        this.f22234h = 0;
        this.f22235i = 0;
        this.f22236j = false;
        this.f22237k = null;
        this.f22238l = null;
        this.f22239m = new HashMap();
        this.f22240n = false;
        this.f22241o = 0;
        this.f22242p = false;
        this.f22243q = false;
        this.f22244r = 0;
        this.f22245s = 0;
        this.f22246t = 0;
        this.f22247u = 0;
        this.f22227a = r10;
        this.f22228b = r10.getWindow();
        this.f22233g = this.f22227a.toString();
        this.f22231e = new m9.b();
        ViewGroup r11 = (ViewGroup) this.f22228b.getDecorView();
        this.f22229c = r11;
        this.f22230d = (ViewGroup) r11.findViewById(R.id.content);
    }

    public static int E(Activity r10) {
        return new m9.a(r10).i();
    }

    public static boolean K() {
        g.m();
        return true;
    }

    public static boolean L() {
        if (g.m() == true) goto L7;
        g.k();
        return true;
    L7:
        return true;
    }

    public static void U(Activity r10, View r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = E(r10);
        r11.setLayoutParams(r12);
    }

    public static void V(Activity r10, View r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        int r13 = r12.height;
        if (r13 != (-2)) goto L9;
    L12:
        r11.post(new b(r12, r11, r10));
        return;
    L9:
        if (r13 == (-1)) goto L12;
        r12.height = r13 + E(r10);
        r11.setPadding(r11.getPaddingLeft(), r11.getPaddingTop() + E(r10), r11.getPaddingRight(), r11.getPaddingBottom());
    }

    public static void W(Activity r10, View r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        r12.setMargins(r12.leftMargin, r12.topMargin + E(r10), r12.rightMargin, r12.bottomMargin);
    }

    public static /* synthetic */ m9.a a(e r10) {
        return r10.f22232f;
    }

    public static /* synthetic */ m9.a b(e r10, m9.a r11) {
        r10.f22232f = r11;
        return r11;
    }

    public static /* synthetic */ Activity c(e r10) {
        return r10.f22227a;
    }

    public static /* synthetic */ ViewGroup d(e r10) {
        return r10.f22230d;
    }

    public static e d0(Activity r10) {
        e r11 = (e) f22226x.get(r10.toString());
        if (r11 != null) goto L6;
        e r12 = new e(r10);
        f22226x.put(r10.toString(), r12);
        return r12;
    L6:
        return r11;
    }

    public static /* synthetic */ ViewGroup e(e r10) {
        return r10.f22229c;
    }

    public static /* synthetic */ int f(e r10) {
        return r10.f22234h;
    }

    public static /* synthetic */ int g(e r10, int r11) {
        r10.f22234h = r11;
        return r11;
    }

    public static /* synthetic */ int h(e r10) {
        return r10.f22235i;
    }

    public static /* synthetic */ int i(e r10, int r11) {
        r10.f22235i = r11;
        return r11;
    }

    public static /* synthetic */ m9.b j(e r10) {
        return r10.f22231e;
    }

    public static /* synthetic */ void k(e r10, int r11, int r12, int r13, int r14) {
        r10.S(r11, r12, r13, r14);
    }

    public static boolean n(View r10) {
        if (r10.getFitsSystemWindows() == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L18;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L18;
        View r14 = r11.getChildAt(r13);
        if ((r14 instanceof DrawerLayout) == false) goto L15;
        if (n(r14) == false) goto L15;
        return true;
    L15:
        if (r14.getFitsSystemWindows() == true) goto L16;
        r13 = r13 + 1;
        goto L8
    L16:
        return true;
    L18:
        return false;
    }

    public static int z(Activity r10) {
        return new m9.a(r10).d();
    }

    public int A() {
        return this.f22247u;
    }

    public int B() {
        return this.f22244r;
    }

    public int C() {
        return this.f22246t;
    }

    public int D() {
        return this.f22245s;
    }

    public final int F(int r10) {
        int r11 = c.f22253a[this.f22231e.f22188i.ordinal()];
        if (r11 != 1) goto L5;
        r10 = r10 | 518;
    L13:
        return r10 | 4096;
    L5:
        if (r11 != 2) goto L7;
        r10 = r10 | 1028;
        goto L13
    L7:
        if (r11 != 3) goto L13;
        r10 = r10 | 514;
        goto L13
    }

    public e G(BarHide r10) {
        this.f22231e.f22188i = r10;
        if (g.i() == false) goto L11;
        m9.b r11 = this.f22231e;
        r11.f22182c = false;
        BarHide r12 = r11.f22188i;
        if (r12 != BarHide.FLAG_HIDE_NAVIGATION_BAR) goto L7;
    L10:
        r11.f22187h = true;
        goto L11
    L7:
        if (r12 == BarHide.FLAG_HIDE_BAR) goto L10;
        r11.f22187h = false;
    L11:
        return this;
    }

    public void H() {
        c0();
        P();
        s();
        r();
        a0();
    }

    public final int I(int r10) {
        if (this.f22242p == true) goto L5;
        m9.b r11 = this.f22231e;
        r11.f22183d = this.f22228b.getNavigationBarColor();
        this.f22242p = true;
    L5:
        int r12 = r10 | 1024;
        m9.b r13 = this.f22231e;
        if (r13.f22186g == true) goto L8;
    L10:
        this.f22228b.clearFlags(67108864);
        if (this.f22232f.k() == false) goto L13;
        this.f22228b.clearFlags(134217728);
    L13:
        this.f22228b.addFlags(Integer.MIN_VALUE);
        m9.b r14 = this.f22231e;
        if (r14.f22195p == false) goto L16;
        this.f22228b.setStatusBarColor(androidx.core.graphics.d.c(r14.f22180a, r14.f22196q, r14.f22184e));
    L17:
        m9.b r15 = this.f22231e;
        if (r15.E == false) goto L20;
        this.f22228b.setNavigationBarColor(androidx.core.graphics.d.c(r15.f22181b, r15.f22197r, r15.f22185f));
    L21:
        return r12;
    L20:
        this.f22228b.setNavigationBarColor(r15.f22183d);
        goto L21
    L16:
        this.f22228b.setStatusBarColor(androidx.core.graphics.d.c(r14.f22180a, 0, r14.f22184e));
        goto L17
    L8:
        if (r13.E == false) goto L10;
        r12 = r10 | 1536;
        goto L10
    }

    public final void J() {
        this.f22228b.addFlags(67108864);
        Y();
        if (this.f22232f.k() == false) goto L5;
    L6:
        m9.b r10 = this.f22231e;
        if (r10.E == true) goto L9;
    L11:
        this.f22228b.clearFlags(134217728);
    L13:
        if (this.f22234h != 0) goto L16;
        this.f22234h = this.f22232f.d();
    L16:
        if (this.f22235i != 0) goto L18;
        this.f22235i = this.f22232f.f();
    L18:
        X();
        return;
    L9:
        if (r10.F == false) goto L11;
        this.f22228b.addFlags(134217728);
        goto L13
    L5:
        if (g.i() == true) goto L6;
    }

    public e M(int r10) {
        m9.b r11 = this.f22231e;
        r11.f22181b = r10;
        r11.f22182c = false;
        return this;
    }

    public e N(boolean r10) {
        return O(r10, 0.2f);
    }

    public e O(boolean r10, float r11) {
        this.f22231e.f22190k = r10;
        if (r10 == true) goto L5;
    L7:
        this.f22231e.f22185f = 0.0f;
    L8:
        return this;
    L5:
        if (K() == true) goto L7;
        this.f22231e.f22185f = r11;
        goto L8
    }

    public final void P() {
        p();
        int r10 = 256;
        if (g.i() == true) goto L5;
        t();
        int r11 = T(I(256));
        o();
        r10 = R(r11);
    L6:
        int r12 = F(r10);
        u();
        this.f22229c.setSystemUiVisibility(r12);
        if (g.m() == false) goto L12;
        Q(this.f22228b, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.f22231e.f22189j);
        m9.b r13 = this.f22231e;
        if (r13.E == false) goto L12;
        Q(this.f22228b, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", r13.f22190k);
    L12:
        if (g.k() == false) goto L18;
        m9.b r14 = this.f22231e;
        int r15 = r14.A;
        if (r15 == 0) goto L16;
        d.c(this.f22227a, r15);
        return;
    L16:
        d.d(this.f22227a, r14.f22189j);
        return;
    L18:
        return;
    L5:
        J();
        goto L6
    }

    public final void Q(Window r10, String r11, boolean r12) {
        if (r10 == null) goto L13;
        Class<?> r13 = r10.getClass();
        Class<?> r14 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L9
        int r15 = r14.getField(r11).getInt(r14);     // Catch: Exception -> L9
        Class r16 = Integer.TYPE;     // Catch: Exception -> L9
        Method r17 = r13.getMethod("setExtraFlags", new Class[]{r16, r16});     // Catch: Exception -> L9
        if (r12 == false) goto L7;
        r17.invoke(r10, new Object[]{Integer.valueOf(r15), Integer.valueOf(r15)});     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r17.invoke(r10, new Object[]{0, Integer.valueOf(r15)});     // Catch: Exception -> L9
    L14:
        return;
    }

    public final int R(int r10) {
        if (this.f22231e.f22190k == true) goto L5;
        return r10;
    L5:
        return r10 | 16;
    }

    public final void S(int r10, int r11, int r12, int r13) {
        ViewGroup r14 = this.f22230d;
        if (r14 == null) goto L5;
        r14.setPadding(r10, r11, r12, r13);
    L5:
        this.f22244r = r10;
        this.f22245s = r11;
        this.f22246t = r12;
        this.f22247u = r13;
    }

    public final int T(int r10) {
        if (this.f22231e.f22189j == true) goto L5;
        return r10;
    L5:
        return r10 | 8192;
    }

    public final void X() {
        ViewGroup r10 = this.f22229c;
        int r11 = f22225w;
        View r12 = r10.findViewById(r11);
        if (r12 != null) goto L6;
        r12 = new View(this.f22227a);
        r12.setId(r11);
        this.f22229c.addView(r12);
    L6:
        if (this.f22232f.l() == false) goto L8;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, this.f22232f.d());
        r13.gravity = 80;
    L9:
        r12.setLayoutParams(r13);
        m9.b r14 = this.f22231e;
        r12.setBackgroundColor(androidx.core.graphics.d.c(r14.f22181b, r14.f22197r, r14.f22185f));
        m9.b r15 = this.f22231e;
        if (r15.E == true) goto L12;
    L16:
        r12.setVisibility(8);
        return;
    L12:
        if (r15.F == false) goto L16;
        if (r15.f22187h == true) goto L16;
        r12.setVisibility(0);
        return;
    L8:
        r13 = new FrameLayout.LayoutParams(this.f22232f.f(), -1);
        r13.gravity = 8388613;
        goto L9
    }

    public final void Y() {
        ViewGroup r10 = this.f22229c;
        int r11 = f22224v;
        View r12 = r10.findViewById(r11);
        if (r12 != null) goto L5;
        r12 = new View(this.f22227a);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, this.f22232f.i());
        r13.gravity = 48;
        r12.setLayoutParams(r13);
        r12.setVisibility(0);
        r12.setId(r11);
        this.f22229c.addView(r12);
    L5:
        m9.b r14 = this.f22231e;
        if (r14.f22195p == false) goto L8;
        r12.setBackgroundColor(androidx.core.graphics.d.c(r14.f22180a, r14.f22196q, r14.f22184e));
        return;
    L8:
        r12.setBackgroundColor(androidx.core.graphics.d.c(r14.f22180a, 0, r14.f22184e));
    }

    public e Z(boolean r10, float r11) {
        this.f22231e.f22189j = r10;
        if (r10 == true) goto L5;
    L7:
        m9.b r12 = this.f22231e;
        r12.A = 0;
        r12.f22184e = 0.0f;
    L8:
        return this;
    L5:
        if (L() == true) goto L7;
        this.f22231e.f22184e = r11;
        goto L8
    }

    public final void a0() {
        if (this.f22231e.f22198s.size() == 0) goto L16;
        Iterator r10 = this.f22231e.f22198s.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r11 = (Map.Entry) r10.next();
        View r12 = (View) r11.getKey();
        Map r13 = (Map) r11.getValue();
        Integer r14 = Integer.valueOf(this.f22231e.f22180a);
        Integer r15 = Integer.valueOf(this.f22231e.f22196q);
        Iterator r16 = r13.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        Map.Entry r17 = (Map.Entry) r16.next();
        Integer r18 = (Integer) r17.getKey();
        r15 = (Integer) r17.getValue();
        r14 = r18;
        goto L9
    L11:
        if (r12 == null) goto L6;
        if (Math.abs(this.f22231e.f22199t - 0.0f) == 0.0f) goto L14;
        r12.setBackgroundColor(androidx.core.graphics.d.c(r14.intValue(), r15.intValue(), this.f22231e.f22199t));
        goto L6
    L14:
        r12.setBackgroundColor(androidx.core.graphics.d.c(r14.intValue(), r15.intValue(), this.f22231e.f22184e));
        goto L6
    L26:
        return;
    }

    public e b0() {
        this.f22231e.f22180a = 0;
        return this;
    }

    public final void c0() {
        l();
        if (g.i() == false) goto L7;
        m9.b r10 = this.f22231e;
        if (r10.F == false) goto L7;
        r10.F = r10.G;
    L7:
        this.f22232f = new m9.a(this.f22227a);
        if (this.f22236j == false) goto L13;
        e r11 = (e) f22226x.get(this.f22227a.toString());
        if (r11 == null) goto L14;
        r11.f22231e = this.f22231e;
        return;
    L14:
        return;
    }

    public final void l() {
        m9.b r10 = this.f22231e;
        boolean r11 = false;
        if (r10.f22191l == false) goto L10;
        int r12 = r10.f22180a;
        if (r12 == 0) goto L8;
        if (r12 <= (-4539718)) goto L8;
        boolean r13 = true;
    L9:
        Z(r13, r10.f22193n);
    L8:
        r13 = false;
    L10:
        m9.b r14 = this.f22231e;
        if (r14.f22192m == false) goto L18;
        int r15 = r14.f22181b;
        if (r15 == 0) goto L16;
        if (r15 <= (-4539718)) goto L16;
        r11 = true;
    L16:
        O(r11, r14.f22194o);
        return;
    }

    public final void m() {
        Activity r10 = this.f22227a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f22237k == null) goto L7;
        r10.getContentResolver().unregisterContentObserver(this.f22237k);
        this.f22237k = null;
    L7:
        m9.c r11 = this.f22238l;
        if (r11 == null) goto L12;
        r11.a();
        this.f22238l = null;
        return;
    }

    public final void o() {
        m9.b r10 = this.f22231e;
        if (r10.f22182c == true) goto L5;
        return;
    L5:
        if ((this.f22228b.getDecorView().getSystemUiVisibility() & 16) == 0) goto L7;
        boolean r11 = true;
    L8:
        r10.f22190k = r11;
        return;
    L7:
        r11 = false;
        goto L8
    }

    public final void p() {
        if (this.f22231e.f22182c == false) goto L6;
        this.f22231e.f22181b = this.f22228b.getNavigationBarColor();
        return;
    }

    public void q() {
        m();
        Iterator r10 = f22226x.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r11 = (Map.Entry) r10.next();
        if (((String) r11.getKey()).contains(this.f22233g) == true) goto L9;
        if (((String) r11.getKey()).equals(this.f22233g) == false) goto L4;
    L9:
        r10.remove();
        goto L4
    }

    public final void r() {
        if (this.f22236j == false) goto L5;
        e r10 = (e) f22226x.get(this.f22227a.toString());
        if (r10 != null) goto L16;
        return;
    L16:
        if (r10.f22231e.C == true) goto L18;
        m9.c r11 = r10.f22238l;
        if (r11 == null) goto L30;
        r11.b();
        return;
    L30:
        return;
    L18:
        if (r10.f22238l != null) goto L20;
        r10.f22238l = new m9.c(r10, r10.f22227a, r10.f22228b);
    L20:
        r10.f22238l.c(r10.f22231e.D);
        return;
    L5:
        if (this.f22231e.C == true) goto L7;
        m9.c r12 = this.f22238l;
        if (r12 == null) goto L26;
        r12.b();
        return;
    L26:
        return;
    L7:
        if (this.f22238l != null) goto L9;
        this.f22238l = new m9.c(this, this.f22227a, this.f22228b);
    L9:
        this.f22238l.c(this.f22231e.D);
    }

    public final void s() {
        if (this.f22240n == true) goto L15;
        int r10 = this.f22241o;
        if (r10 != 1) goto L7;
        V(this.f22227a, this.f22231e.f22204y);
        this.f22240n = true;
        return;
    L7:
        if (r10 != 2) goto L9;
        W(this.f22227a, this.f22231e.f22204y);
        this.f22240n = true;
        return;
    L9:
        if (r10 != 3) goto L18;
        U(this.f22227a, this.f22231e.f22205z);
        this.f22240n = true;
        return;
    L18:
        return;
    }

    public final void t() {
        if (this.f22243q == true) goto L6;
        WindowManager.LayoutParams r10 = this.f22228b.getAttributes();
        r10.layoutInDisplayCutoutMode = 1;
        this.f22228b.setAttributes(r10);
        this.f22243q = true;
        return;
    }

    public final void u() {
        if (g.i() == true) goto L5;
        v();
        return;
    L5:
        w();
        if (this.f22236j == false) goto L8;
        return;
    L8:
        if (g.i() == false) goto L13;
        x();
        return;
    }

    public final void v() {
        if (n(this.f22229c.findViewById(R.id.content)) == false) goto L9;
        if (this.f22231e.B == false) goto L19;
        S(0, this.f22232f.a(), 0, 0);
        return;
    L19:
        return;
    L9:
        if (this.f22231e.f22203x == true) goto L11;
    L13:
        int r10 = 0;
    L15:
        if (this.f22231e.B == false) goto L17;
        r10 = this.f22232f.i() + this.f22232f.a();
    L17:
        S(0, r10, 0, 0);
        return;
    L11:
        if (this.f22241o != 4) goto L13;
        r10 = this.f22232f.i();
        goto L15
    }

    public final void w() {
        if (n(this.f22229c.findViewById(R.id.content)) == false) goto L9;
        if (this.f22231e.B == false) goto L42;
        S(0, this.f22232f.a(), 0, 0);
        return;
    L42:
        return;
    L9:
        if (this.f22231e.f22203x == true) goto L11;
    L13:
        int r10 = 0;
    L15:
        if (this.f22231e.B == false) goto L18;
        r10 = this.f22232f.i() + this.f22232f.a();
    L18:
        if (this.f22232f.k() == false) goto L39;
        m9.b r11 = this.f22231e;
        if (r11.E == false) goto L39;
        if (r11.F == false) goto L39;
        if (r11.f22186g == false) goto L26;
        int r12 = 0;
        int r13 = 0;
    L31:
        if (this.f22231e.f22187h == false) goto L37;
        if (this.f22232f.l() == false) goto L35;
        r13 = 0;
    L40:
        S(0, r10, r12, r13);
        return;
    L35:
        r12 = 0;
        goto L40
    L37:
        if (this.f22232f.l() == true) goto L40;
        r12 = this.f22232f.f();
        goto L40
    L26:
        if (this.f22232f.l() == false) goto L28;
        r13 = this.f22232f.d();
        r12 = 0;
        goto L31
    L28:
        r12 = this.f22232f.f();
        r13 = 0;
    L39:
        r12 = 0;
        r13 = 0;
        goto L40
    L11:
        if (this.f22241o != 4) goto L13;
        r10 = this.f22232f.i();
        goto L15
    }

    public final void x() {
        View r10 = this.f22229c.findViewById(f22225w);
        m9.b r11 = this.f22231e;
        if (r11.E == true) goto L5;
    L16:
        r10.setVisibility(8);
        return;
    L5:
        if (r11.F == false) goto L16;
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.f22237k != null) goto L19;
        this.f22237k = new a(this, new Handler(), r10);
        Activity r12 = this.f22227a;
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.getContentResolver() != null) goto L14;
        return;
    L14:
        if (this.f22237k == null) goto L22;
        this.f22227a.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.f22237k);
        return;
    L22:
        return;
    }

    public m9.b y() {
        return this.f22231e;
    }
}
