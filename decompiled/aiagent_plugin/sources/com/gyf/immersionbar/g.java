package com.gyf.immersionbar;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ImmersionBar.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f13847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Fragment f13848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.app.Fragment f13849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Dialog f13850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Window f13851e;
    private ViewGroup f;
    private ViewGroup g;
    private g h;
    private boolean i;
    private boolean j;
    private boolean k;
    private c l;
    private a m;
    private int n;
    private int o;
    private int p;
    private FitsKeyboard q;
    private final Map<String, c> r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: com.gyf.immersionbar.g$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImmersionBar.java */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13856a = null;

        static {
            int[] r0 = new int[b.values().length];
            f13856a = r0;
            r0[b.f13828c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f13856a[b.f13826a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f13856a[b.f13827b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f13856a[b.f13829d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static g a(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        return Q().get(r3, false);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.l.K == false) goto L9;
        t();
        d();
        B();
        O();
        M();
        this.t = true;
        return;
    }

    void b() {
        N();
        if (this.k == false) goto L9;
        g r0 = this.h;
        if (r0 == null) goto L9;
        c r1 = r0.l;
        r1.F = r0.v;
        if (this.h.l.j == b.f13829d) goto L9;
        this.h.d();
    L9:
        this.t = false;
    }

    void c() {
        H();
        if (this.i == false) goto L5;
        return;
    L5:
        if (this.t == true) goto L7;
        return;
    L7:
        if (this.l != null) goto L9;
        return;
    L9:
        if (OSUtils.isEMUI3_x() == false) goto L14;
        if (this.l.f13831J == false) goto L14;
        a();
        return;
    L14:
        if (this.l.j == b.f13829d) goto L21;
        d();
        return;
    }

    void a(Configuration r2) {
        H();
        if (OSUtils.isEMUI3_x() == true) goto L9;
        if (Build.VERSION.SDK_INT == 19) goto L9;
        B();
        return;
    L9:
        if (this.t == true) goto L11;
    L15:
        B();
        return;
    L11:
        if (this.i == true) goto L15;
        if (this.l.I == false) goto L15;
        a();
    }

    private void t() {
        A();
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.t == true) goto L7;
    L8:
        H();
    L9:
        g r0 = this.h;
        if (r0 != null) goto L12;
        return;
    L12:
        if (this.i == false) goto L15;
        r0.l = this.l;
    L15:
        if (this.k == true) goto L17;
        return;
    L17:
        if (r0.v == false) goto L23;
        r0.l.F = false;
        return;
    L23:
        return;
    L7:
        if (this.i == false) goto L9;
        goto L8
    }

    void d() {
        int r1 = 256;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        x();
    L8:
        int r0 = c(r1);
        this.f.setSystemUiVisibility(r0);
        v();
        K();
        if (this.l.M == null) goto L12;
        NavigationBarObserver.getInstance().register((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13847a.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        return;
    L5:
        if (OSUtils.isEMUI3_x() == true) goto L7;
        w();
        r1 = e(d(b(256)));
        u();
        goto L8
    }

    private void u() {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        I();
        J();
        return;
    }

    private void v() {
        if (OSUtils.isMIUI6Later() == false) goto L8;
        SpecialBarFontUtils.setMIUIBarDark(this.f13851e, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.l.k);
        if (this.l.H == false) goto L8;
        SpecialBarFontUtils.setMIUIBarDark(this.f13851e, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", this.l.l);
    L8:
        if (OSUtils.isFlymeOS4Later() == true) goto L10;
        return;
    L10:
        if (this.l.C == 0) goto L12;
        SpecialBarFontUtils.setStatusBarDarkIcon(this.f13847a, this.l.C);
        return;
    L12:
        SpecialBarFontUtils.setStatusBarDarkIcon(this.f13847a, this.l.k);
    }

    private void w() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (this.t == true) goto L12;
        WindowManager.LayoutParams r0 = this.f13851e.getAttributes();     // Catch: Exception -> L8
        r0.layoutInDisplayCutoutMode = 1;     // Catch: Exception -> L8
        this.f13851e.setAttributes(r0);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    private int b(int r7) {
        if (this.t == true) goto L5;
        c r0 = this.l;
        r0.f13834c = this.f13851e.getNavigationBarColor();
    L5:
        int r8 = r7 | 1024;
        if (this.l.h == true) goto L8;
    L10:
        this.f13851e.clearFlags(67108864);
        if (this.m.d() == false) goto L13;
        this.f13851e.clearFlags(134217728);
    L13:
        this.f13851e.addFlags(Integer.MIN_VALUE);
        if (this.l.q == true) goto L16;
        this.f13851e.setStatusBarColor(androidx.core.graphics.e.a(this.l.f13832a, 0, this.l.f13835d));
    L21:
        if (this.l.H == true) goto L23;
        this.f13851e.setNavigationBarColor(this.l.f13834c);
    L27:
        return r8;
    L23:
        if (Build.VERSION.SDK_INT < 29) goto L25;
        this.f13851e.setNavigationBarContrastEnforced(false);
    L25:
        this.f13851e.setNavigationBarColor(androidx.core.graphics.e.a(this.l.f13833b, this.l.s, this.l.f));
        goto L27
    L16:
        if (Build.VERSION.SDK_INT < 29) goto L18;
        this.f13851e.setStatusBarContrastEnforced(false);
    L18:
        this.f13851e.setStatusBarColor(androidx.core.graphics.e.a(this.l.f13832a, this.l.r, this.l.f13835d));
        goto L21
    L8:
        if (this.l.H == false) goto L10;
        r8 = r8 | 512;
        goto L10
    }

    private void x() {
        this.f13851e.addFlags(67108864);
        y();
        if (this.m.d() == true) goto L7;
        if (OSUtils.isEMUI3_x() == true) goto L7;
        return;
    L7:
        if (this.l.H == true) goto L9;
    L11:
        this.f13851e.clearFlags(134217728);
    L13:
        if (this.n != 0) goto L16;
        this.n = this.m.e();
    L16:
        if (this.o != 0) goto L18;
        this.o = this.m.f();
    L18:
        z();
        return;
    L9:
        if (this.l.I == false) goto L11;
        this.f13851e.addFlags(134217728);
        goto L13
    }

    private void y() {
        View r0 = this.f.findViewById(e.f13842a);
        if (r0 != null) goto L6;
        r0 = new View(this.f13847a);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, this.m.b());
        r2.gravity = 48;
        r0.setLayoutParams(r2);
        r0.setVisibility(0);
        r0.setId(e.f13842a);
        this.f.addView(r0);
    L6:
        if (this.l.q == false) goto L8;
        r0.setBackgroundColor(androidx.core.graphics.e.a(this.l.f13832a, this.l.r, this.l.f13835d));
        return;
    L8:
        r0.setBackgroundColor(androidx.core.graphics.e.a(this.l.f13832a, 0, this.l.f13835d));
    }

    private void z() {
        View r0 = this.f.findViewById(e.f13843b);
        if (r0 != null) goto L6;
        r0 = new View(this.f13847a);
        r0.setId(e.f13843b);
        this.f.addView(r0);
    L6:
        if (this.m.a() == false) goto L8;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, this.m.e());
        r1.gravity = 80;
    L9:
        r0.setLayoutParams(r1);
        r0.setBackgroundColor(androidx.core.graphics.e.a(this.l.f13833b, this.l.s, this.l.f));
        if (this.l.H == true) goto L12;
    L16:
        r0.setVisibility(8);
        return;
    L12:
        if (this.l.I == false) goto L16;
        if (this.l.i == true) goto L16;
        r0.setVisibility(0);
        return;
    L8:
        r1 = new FrameLayout.LayoutParams(this.m.f(), -1);
        r1.gravity = 8388613;
        goto L9
    }

    private void A() {
        int r0 = androidx.core.graphics.e.a(this.l.f13832a, this.l.r, this.l.f13835d);
        boolean r2 = true;
        if (this.l.m == false) goto L9;
        if (r0 == 0) goto L9;
        if (r0 <= (-4539718)) goto L7;
        boolean r1 = true;
    L8:
        a(r1, this.l.o);
        goto L9
    L7:
        r1 = false;
    L9:
        int r3 = androidx.core.graphics.e.a(this.l.f13833b, this.l.s, this.l.f);
        if (this.l.n == false) goto L17;
        if (r3 == 0) goto L18;
        if (r3 > (-4539718)) goto L15;
        r2 = false;
    L15:
        b(r2, this.l.p);
        return;
    L18:
        return;
    }

    private int c(int r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        return r3;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L21;
        int r2 = AnonymousClass2.f13856a[this.l.j.ordinal()];
        if (r2 != 1) goto L10;
        r3 = r3 | 518;
        goto L21
    L10:
        if (r2 != 2) goto L12;
        r3 = r3 | DownloadErrorCode.ERROR_SAVE_PATH_EMPTY;
        goto L21
    L12:
        if (r2 != 3) goto L14;
        r3 = r3 | 514;
        goto L21
    L14:
        if (r2 != 4) goto L21;
        r3 = r3 | 0;
    L21:
        return r3 | 4096;
    }

    private void B() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L9:
        C();
    L10:
        L();
        return;
    L7:
        if (OSUtils.isEMUI3_x() == true) goto L9;
        E();
        goto L10
    }

    private void C() {
        if (this.l.E == false) goto L5;
        this.u = true;
        this.g.post(this);
        return;
    L5:
        this.u = false;
        D();
    }

    @Override // java.lang.Runnable
    public void run() {
        D();
    }

    private void D() {
        F();
        if (this.i == false) goto L5;
        return;
    L5:
        if (OSUtils.isEMUI3_x() == false) goto L9;
        G();
        return;
    }

    private void E() {
        if (a(this.f.findViewById(R.id.content)) == false) goto L7;
        a(0, 0, 0, 0);
        return;
    L7:
        if (this.l.y == true) goto L9;
    L11:
        int r0 = 0;
    L13:
        if (this.l.E == false) goto L15;
        r0 = this.m.b() + this.p;
    L15:
        a(0, r0, 0, 0);
        return;
    L9:
        if (this.s != 4) goto L11;
        r0 = this.m.b();
        goto L13
    }

    private void F() {
        if (a(this.f.findViewById(R.id.content)) == false) goto L7;
        a(0, 0, 0, 0);
        return;
    L7:
        if (this.l.y == true) goto L9;
    L11:
        int r0 = 0;
    L13:
        if (this.l.E == false) goto L16;
        r0 = this.m.b() + this.p;
    L16:
        if (this.m.d() == true) goto L18;
    L37:
        int r2 = 0;
        int r3 = 0;
    L38:
        a(0, r0, r2, r3);
        return;
    L18:
        if (this.l.H == false) goto L37;
        if (this.l.I == false) goto L37;
        if (this.l.h == false) goto L24;
        r2 = 0;
        r3 = 0;
    L29:
        if (this.l.i == false) goto L35;
        if (this.m.a() == false) goto L33;
        r3 = 0;
        goto L38
    L33:
        r2 = 0;
        goto L38
    L35:
        if (this.m.a() == true) goto L38;
        r2 = this.m.f();
        goto L38
    L24:
        if (this.m.a() == false) goto L26;
        r3 = this.m.e();
        r2 = 0;
        goto L29
    L26:
        r2 = this.m.f();
        r3 = 0;
        goto L29
    L9:
        if (this.s != 4) goto L11;
        r0 = this.m.b();
        goto L13
    }

    private void G() {
        View r0 = this.f.findViewById(e.f13843b);
        if (this.l.H == true) goto L5;
    L8:
        EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
        r0.setVisibility(8);
        return;
    L5:
        if (this.l.I == false) goto L8;
        if (r0 == null) goto L10;
        EMUI3NavigationBarObserver.getInstance().addOnNavigationBarListener(this);
        EMUI3NavigationBarObserver.getInstance().register((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13847a.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        return;
    }

    private void H() {
        a r0 = new a(this.f13847a);
        this.m = r0;
        if (this.t == true) goto L5;
    L6:
        this.p = r0.c();
        return;
    L5:
        if (this.u == true) goto L6;
    }

    @Override // com.gyf.immersionbar.n
    public void a(boolean r5, j r6) {
        View r7 = this.f.findViewById(e.f13843b);
        if (r7 == null) goto L34;
        this.m = new a(this.f13847a);
        int r0 = this.g.getPaddingBottom();
        int r1 = this.g.getPaddingRight();
        if (r5 == true) goto L8;
        r7.setVisibility(8);
    L7:
        r0 = 0;
        r1 = 0;
    L32:
        a(0, this.g.getPaddingTop(), r1, r0);
        return;
    L8:
        r7.setVisibility(0);
        if (a(this.f.findViewById(R.id.content)) == true) goto L7;
        if (this.n != 0) goto L15;
        this.n = this.m.e();
    L15:
        if (this.o != 0) goto L18;
        this.o = this.m.f();
    L18:
        if (this.l.i == true) goto L32;
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (this.m.a() == false) goto L26;
        r8.gravity = 80;
        r8.height = this.n;
        if (this.l.h == true) goto L24;
        r0 = this.n;
    L25:
        r1 = 0;
    L31:
        r7.setLayoutParams(r8);
        goto L32
    L24:
        r0 = 0;
        goto L25
    L26:
        r8.gravity = 8388613;
        r8.width = this.o;
        if (this.l.h == true) goto L29;
        int r2 = this.o;
    L30:
        r1 = r2;
        r0 = 0;
        goto L31
    L29:
        r2 = 0;
        goto L30
    }

    private int d(int r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L8:
        return r3;
    L5:
        if (this.l.k == false) goto L8;
        return r3 | 8192;
    }

    private int e(int r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L8:
        return r3;
    L5:
        if (this.l.l == false) goto L8;
        return r3 | 16;
    }

    private void I() {
        WindowInsetsController r0 = this.g.getWindowInsetsController();
        if (this.l.k == true) goto L5;
        r0.setSystemBarsAppearance(0, 8);
        return;
    L5:
        if (this.f13851e == null) goto L7;
        a(8192);
    L7:
        r0.setSystemBarsAppearance(8, 8);
    }

    private void J() {
        WindowInsetsController r0 = this.g.getWindowInsetsController();
        if (this.l.l == false) goto L5;
        r0.setSystemBarsAppearance(16, 16);
        return;
    L5:
        r0.setSystemBarsAppearance(0, 16);
    }

    private void K() {
        if (Build.VERSION.SDK_INT < 30) goto L20;
        WindowInsetsController r0 = this.g.getWindowInsetsController();
        if (r0 == null) goto L21;
        int r3 = AnonymousClass2.f13856a[this.l.j.ordinal()];
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L10;
        r0.hide(WindowInsets.Type.statusBars());
    L18:
        r0.setSystemBarsBehavior(2);
        return;
    L10:
        if (r3 != 3) goto L12;
        r0.hide(WindowInsets.Type.navigationBars());
        goto L18
    L12:
        if (r3 != 4) goto L18;
        r0.show(WindowInsets.Type.statusBars());
        r0.show(WindowInsets.Type.navigationBars());
        goto L18
    L17:
        r0.hide(WindowInsets.Type.statusBars());
        r0.hide(WindowInsets.Type.navigationBars());
        goto L18
    L21:
        return;
    }

    public void a(int r2) {
        View r1 = this.f13851e.getDecorView();
        int r0 = r1.getSystemUiVisibility();
        r1.setSystemUiVisibility((~r2) & r0);
    }

    private void L() {
        if (this.l.B == false) goto L5;
        int r0 = this.m.b();
    L6:
        int r2 = this.s;
        if (r2 != 1) goto L9;
        a(this.f13847a, r0, new View[]{this.l.z});
        return;
    L9:
        if (r2 != 2) goto L11;
        b(this.f13847a, r0, new View[]{this.l.z});
        return;
    L11:
        if (r2 != 3) goto L19;
        c(this.f13847a, r0, new View[]{this.l.A});
        return;
    L19:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void M() {
        if (this.l.t.size() == 0) goto L16;
        Iterator<Map.Entry<View, Map<Integer, Integer>>> r0 = this.l.t.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L26;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.getKey(), View.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r1.getValue(), Map.class, "com.obric.aiagent.plugin");
        Integer r4 = Integer.valueOf(this.l.f13832a);
        Integer r5 = Integer.valueOf(this.l.r);
        Iterator r6 = r3.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7.getKey(), Integer.class, "com.obric.aiagent.plugin");
        r5 = (Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.aiagent.plugin");
        r4 = r8;
        goto L9
    L11:
        if (r2 == null) goto L6;
        if (Math.abs(this.l.u - 0.0f) == 0.0f) goto L14;
        r2.setBackgroundColor(androidx.core.graphics.e.a(r4.intValue(), r5.intValue(), this.l.u));
        goto L6
    L14:
        r2.setBackgroundColor(androidx.core.graphics.e.a(r4.intValue(), r5.intValue(), this.l.f13835d));
        goto L6
    L26:
        return;
    }

    private void N() {
        if (this.f13847a == null) goto L9;
        FitsKeyboard r0 = this.q;
        if (r0 == null) goto L7;
        r0.cancel();
        this.q = null;
    L7:
        EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
        NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.l.M);
        return;
    }

    private void O() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (this.i == false) goto L7;
        g r0 = this.h;
        if (r0 != null) goto L18;
        return;
    L18:
        if (r0.l.F == false) goto L23;
        g r1 = this.h;
        if (r1.q != null) goto L22;
        r1.q = new FitsKeyboard(this.h);
    L22:
        g r3 = this.h;
        r3.q.enable(r3.l.G);
        return;
    L23:
        FitsKeyboard r4 = this.h.q;
        if (r4 == null) goto L33;
        r4.disable();
        return;
    L33:
        return;
    L7:
        if (this.l.F == true) goto L9;
        FitsKeyboard r5 = this.q;
        if (r5 == null) goto L29;
        r5.disable();
        return;
    L29:
        return;
    L9:
        if (this.q != null) goto L11;
        this.q = new FitsKeyboard(this);
    L11:
        this.q.enable(this.l.G);
    }

    void e() {
        g r0 = this.h;
        if (r0 == null) goto L8;
        FitsKeyboard r1 = r0.q;
        if (r1 == null) goto L9;
        r1.disable();
        this.h.q.resetKeyboardHeight();
        return;
    L9:
        return;
    }

    public c f() {
        return this.l;
    }

    private void a(int r2, int r3, int r4, int r5) {
        ViewGroup r0 = this.g;
        if (r0 == null) goto L5;
        r0.setPadding(r2, r3, r4, r5);
    L5:
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.z = r5;
    }

    int g() {
        return this.w;
    }

    int h() {
        return this.x;
    }

    int i() {
        return this.y;
    }

    int j() {
        return this.z;
    }

    Activity getActivity() {
        return this.f13847a;
    }

    Window k() {
        return this.f13851e;
    }

    Fragment l() {
        return this.f13848b;
    }

    android.app.Fragment m() {
        return this.f13849c;
    }

    boolean n() {
        return this.j;
    }

    boolean o() {
        return this.t;
    }

    a p() {
        if (this.m != null) goto L6;
        this.m = new a(this.f13847a);
    L6:
        return this.m;
    }

    int q() {
        return this.p;
    }

    public static boolean r() {
        if (OSUtils.isMIUI6Later() == false) goto L5;
    L10:
        return true;
    L5:
        if (OSUtils.isFlymeOS4Later() == true) goto L10;
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        return false;
    }

    public static boolean s() {
        if (OSUtils.isMIUI6Later() == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        return false;
    }

    public static void a(Activity r9, final int r10, View... r11) {
        Activity r12 = (Activity) ZeusTransformUtils.wrapperContextForParams(r9, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L30;
        if (r12 != null) goto L7;
        return;
    L7:
        if (r10 >= 0) goto L9;
        r10 = 0;
    L9:
        int r0 = r11.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L36;
        final View r3 = r11[r2];
        if (r3 == null) goto L29;
        final Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.immersion_fits_layout_overlap, DbHelper.COL_ID, "immersion_fits_layout_overlap")), Integer.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L18;
        r4 = 0;
    L18:
        if (r4.intValue() == r10) goto L29;
        r3.setTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.immersion_fits_layout_overlap, DbHelper.COL_ID, "immersion_fits_layout_overlap"), Integer.valueOf(r10));
        final ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 != null) goto L23;
        r5 = new ViewGroup.LayoutParams(-1, -2);
    L23:
        if (r5.height != (-2)) goto L25;
    L28:
        r3.post(new AnonymousClass1(r5, r3, r10, r4));
        goto L29
    L25:
        if (r5.height == (-1)) goto L28;
        r5.height += r10 - r4.intValue();
        r3.setPadding(r3.getPaddingLeft(), (r3.getPaddingTop() + r10) - r4.intValue(), r3.getPaddingRight(), r3.getPaddingBottom());
        r3.setLayoutParams(r5);
    L29:
        r2 = r2 + 1;
        goto L10
    L36:
        return;
    }

    public static void b(Activity r9, int r10, View... r11) {
        Activity r12 = (Activity) ZeusTransformUtils.wrapperContextForParams(r9, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L24;
        if (r12 != null) goto L7;
        return;
    L7:
        if (r10 >= 0) goto L9;
        r10 = 0;
    L9:
        int r0 = r11.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L29;
        View r3 = r11[r2];
        if (r3 == null) goto L23;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.immersion_fits_layout_overlap, DbHelper.COL_ID, "immersion_fits_layout_overlap")), Integer.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L18;
        r4 = 0;
    L18:
        if (r4.intValue() == r10) goto L23;
        r3.setTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.immersion_fits_layout_overlap, DbHelper.COL_ID, "immersion_fits_layout_overlap"), Integer.valueOf(r10));
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 != null) goto L22;
        r5 = new ViewGroup.MarginLayoutParams(-1, -2);
    L22:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r6.setMargins(r6.leftMargin, (r6.topMargin + r10) - r4.intValue(), r6.rightMargin, r6.bottomMargin);
        r3.setLayoutParams(r6);
    L23:
        r2 = r2 + 1;
        goto L10
    L29:
        return;
    }

    public static void c(Activity r8, int r9, View... r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L24;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r9 >= 0) goto L9;
        r9 = 0;
    L9:
        int r0 = r10.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L29;
        View r3 = r10[r2];
        if (r3 == null) goto L23;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.immersion_fits_layout_overlap, DbHelper.COL_ID, "immersion_fits_layout_overlap")), Integer.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L18;
        r4 = 0;
    L18:
        if (r4.intValue() == r9) goto L23;
        r3.setTag(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.immersion_fits_layout_overlap, DbHelper.COL_ID, "immersion_fits_layout_overlap"), Integer.valueOf(r9));
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 != null) goto L22;
        r5 = new ViewGroup.LayoutParams(-1, 0);
    L22:
        r5.height = r9;
        r3.setLayoutParams(r5);
    L23:
        r2 = r2 + 1;
        goto L10
    L29:
        return;
    }

    public static boolean a(View r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r6.getFitsSystemWindows() == false) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L21;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin");
        int r1 = r7.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L21;
        View r4 = r7.getChildAt(r3);
        if (ZeusTransformUtils.instanceOf(r4, DrawerLayout.class) == false) goto L18;
        if (a(r4) == false) goto L18;
        return true;
    L18:
        if (r4.getFitsSystemWindows() == true) goto L19;
        r3 = r3 + 1;
        goto L11
    L19:
        return true;
    L21:
        return false;
    }

    public static int b(Activity r2) {
        return new a((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).b();
    }

    g(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        Activity r6 = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.aiagent.plugin");
        this.f13847a = r6;
        a(ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin"));
    }

    g(Fragment r4) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.i = true;
        Activity r0 = ZeusTransformUtils.wrapperContext2Activity((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13847a = r0;
        this.f13848b = r4;
        P();
        a(ZeusTransformUtils.getWindow(r0, "com.obric.aiagent.plugin"));
    }

    g(android.app.Fragment r3) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.i = true;
        Activity r1 = ZeusTransformUtils.wrapperContext2Activity(ZeusTransformUtils.getActivity(r3, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13847a = r1;
        this.f13849c = r3;
        P();
        a(ZeusTransformUtils.getWindow(r1, "com.obric.aiagent.plugin"));
    }

    g(DialogFragment r4) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.k = true;
        this.j = true;
        this.f13847a = ZeusTransformUtils.wrapperContext2Activity((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13848b = r4;
        this.f13850d = r4.getDialog();
        P();
        a(this.f13850d.getWindow());
    }

    g(android.app.DialogFragment r3) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.k = true;
        this.j = true;
        this.f13847a = ZeusTransformUtils.wrapperContext2Activity(ZeusTransformUtils.getActivity(r3, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13849c = r3;
        this.f13850d = r3.getDialog();
        P();
        a(this.f13850d.getWindow());
    }

    g(Activity r4, Dialog r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.k = true;
        this.f13847a = ZeusTransformUtils.wrapperContext2Activity(r6, "com.obric.aiagent.plugin");
        this.f13850d = r5;
        P();
        a(this.f13850d.getWindow());
    }

    private void P() {
        if (this.h != null) goto L5;
        this.h = a(this.f13847a);
    L5:
        g r1 = this.h;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.t == true) goto L12;
        r1.a();
        return;
    }

    private void a(Window r3) {
        this.f13851e = r3;
        this.l = new c();
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f13851e.getDecorView(), ViewGroup.class, "com.obric.aiagent.plugin");
        this.f = r4;
        this.g = (ViewGroup) ZeusTransformUtils.preCheckCast(r4.findViewById(R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
    }

    public g a(boolean r2, float r3) {
        this.l.k = r2;
        if (r2 == true) goto L5;
    L7:
        c r4 = this.l;
        r4.C = r4.D;
        c r5 = this.l;
        r5.f13835d = r5.f13836e;
    L8:
        return this;
    L5:
        if (r() == true) goto L7;
        this.l.f13835d = r3;
        goto L8
    }

    public g b(boolean r2, float r3) {
        this.l.l = r2;
        if (r2 == true) goto L5;
    L7:
        c r4 = this.l;
        r4.f = r4.g;
    L8:
        return this;
    L5:
        if (s() == true) goto L7;
        this.l.f = r3;
        goto L8
    }

    public g a(b r3) {
        this.l.j = r3;
        if (Build.VERSION.SDK_INT != 19) goto L5;
    L6:
        c r4 = this.l;
        if (r4.j != b.f13827b) goto L9;
    L12:
        boolean r0 = true;
    L13:
        r4.i = r0;
    L14:
        return this;
    L9:
        if (this.l.j == b.f13828c) goto L12;
        r0 = false;
        goto L13
    L5:
        if (OSUtils.isEMUI3_x() == false) goto L14;
        goto L6
    }

    private static RequestManagerRetriever Q() {
        return RequestManagerRetriever.getInstance();
    }
}
