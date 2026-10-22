package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1478a;

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class a {
        void a(int r1) {
        }

        public void a(boolean r1) {
        }

        public boolean a() {
            return false;
        }

        void b(int r1) {
        }

        public void b(boolean r1) {
        }

        void c(int r1) {
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Window f1479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f1480b;

        b(Window r1, x r2) {
            this.f1479a = r1;
            this.f1480b = r2;
        }

        @Override // androidx.core.view.am.a
        void a(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            h(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        private void h(int r2) {
            if (r2 != 1) goto L5;
            e(4);
            g(1024);
            return;
        L5:
            if (r2 != 2) goto L7;
            e(2);
            return;
        L7:
            if (r2 != 8) goto L15;
            this.f1480b.a();
            return;
        }

        @Override // androidx.core.view.am.a
        void b(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            i(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        private void i(int r2) {
            if (r2 != 1) goto L5;
            d(4);
            return;
        L5:
            if (r2 != 2) goto L7;
            d(2);
            return;
        L7:
            if (r2 != 8) goto L15;
            this.f1480b.b();
            return;
        }

        public void d(int r2) {
            View r1 = this.f1479a.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }

        public void e(int r2) {
            View r1 = this.f1479a.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }

        public void f(int r1) {
            this.f1479a.addFlags(r1);
        }

        public void g(int r1) {
            this.f1479a.clearFlags(r1);
        }

        @Override // androidx.core.view.am.a
        void c(int r4) {
            if (r4 != 0) goto L4;
            e(6144);
            return;
        L4:
            if (r4 != 1) goto L6;
            e(4096);
            d(2048);
            return;
        L6:
            if (r4 != 2) goto L14;
            e(2048);
            d(4096);
            return;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class c extends b {
        c(Window r1, x r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.am.a
        public void a(boolean r2) {
            if (r2 == false) goto L5;
            g(67108864);
            f(Integer.MIN_VALUE);
            d(8192);
            return;
        L5:
            e(8192);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class d extends c {
        d(Window r1, x r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.am.a
        public boolean a() {
            if ((this.f1479a.getDecorView().getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.am.a
        public void b(boolean r2) {
            if (r2 == false) goto L5;
            g(134217728);
            f(Integer.MIN_VALUE);
            d(16);
            return;
        L5:
            e(16);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final am f1481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsetsController f1482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final x f1483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected Window f1484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final androidx.b.g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f1485e;

        e(Window r2, am r3, x r4) {
            this(r2.getInsetsController(), r3, r4);
            this.f1484d = r2;
        }

        e(WindowInsetsController r3, am r4, x r5) {
            WindowInsetsController r6 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.aiagent.plugin");
            this.f1485e = new androidx.b.g();
            this.f1482b = r6;
            this.f1481a = r4;
            this.f1483c = r5;
        }

        @Override // androidx.core.view.am.a
        void a(int r2) {
            if ((r2 & 8) == 0) goto L5;
            this.f1483c.a();
        L5:
            this.f1482b.show(r2 & (-9));
        }

        @Override // androidx.core.view.am.a
        void b(int r2) {
            if ((r2 & 8) == 0) goto L5;
            this.f1483c.b();
        L5:
            this.f1482b.hide(r2 & (-9));
        }

        @Override // androidx.core.view.am.a
        public void a(boolean r3) {
            if (r3 == false) goto L9;
            if (this.f1484d == null) goto L7;
            e(8192);
        L7:
            this.f1482b.setSystemBarsAppearance(8, 8);
            return;
        L9:
            if (this.f1484d == null) goto L11;
            d(8192);
        L11:
            this.f1482b.setSystemBarsAppearance(0, 8);
        }

        @Override // androidx.core.view.am.a
        public boolean a() {
            if ((this.f1482b.getSystemBarsAppearance() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.am.a
        public void b(boolean r2) {
            if (r2 == false) goto L9;
            if (this.f1484d == null) goto L7;
            e(16);
        L7:
            this.f1482b.setSystemBarsAppearance(16, 16);
            return;
        L9:
            if (this.f1484d == null) goto L11;
            d(16);
        L11:
            this.f1482b.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.am.a
        void c(int r1) {
            this.f1482b.setSystemBarsBehavior(r1);
        }

        public void d(int r2) {
            View r1 = this.f1484d.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }

        public void e(int r2) {
            View r1 = this.f1484d.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }
    }

    @Deprecated
    private am(WindowInsetsController r3) {
        WindowInsetsController r4 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.aiagent.plugin");
        this.f1478a = new e(r4, this, new x(r4));
    }

    public am(Window r3, View r4) {
        x r0 = new x(r4);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f1478a = new e(r3, this, r0);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        this.f1478a = new d(r3, r0);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        this.f1478a = new c(r3, r0);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 20) goto L14;
        this.f1478a = new b(r3, r0);
        return;
    L14:
        this.f1478a = new a();
    }

    @Deprecated
    public static am a(WindowInsetsController r2) {
        return new am((WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r2, WindowInsetsController.class, "com.obric.aiagent.plugin"));
    }

    public void a(int r1) {
        this.f1478a.a(r1);
    }

    public void b(int r1) {
        this.f1478a.b(r1);
    }

    public void a(boolean r1) {
        this.f1478a.a(r1);
    }

    public boolean a() {
        return this.f1478a.a();
    }

    public void b(boolean r1) {
        this.f1478a.b(r1);
    }

    public void c(int r1) {
        this.f1478a.c(r1);
    }
}
