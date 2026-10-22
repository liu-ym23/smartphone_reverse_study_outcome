package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4644a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f4645b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f4646c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f4647d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f4648e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f4649f = 1500000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f4650g = 2000000;

    public f() {
    }

    private void c() {
        f4648e = e.a();
        f4649f = e.a(0);
        f4650g = e.a(6);
    }

    private void d() {
        int r100 = f4647d;
        if (r100 == (-1)) goto L6;
        f4645b.a(r100);
        LogUtil.debug(f4644a, "userDisableIfNeed  sCurPerfHandle = " + f4647d);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void a() {
        d();
        LogUtil.debug(f4644a, "release");
    }

    @Override // android.ss.com.vboost.h.c
    public void a(long r110) {
        d();
        g r100 = f4645b;
        if (r100 == null) goto L8;
        int r101 = r100.b();
        f4647d = r101;
        if ((-1) == r101) goto L9;
        LogUtil.debug(f4644a, "try boost timeout " + r110);
        f4645b.a(f4647d, 10, 3, -1, -1, -1);
        f4645b.a(f4647d, 1, f4648e, -1, -1, -1);
        f4645b.a(f4647d, 4, f4650g, -1, -1, -1);
        f4645b.a(f4647d, 6, f4650g, f4649f, -1, -1);
        f4645b.a(f4647d, 23, 1000, -1, -1, -1);
        f4645b.a(f4647d, (int) r110);
        return;
    L9:
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public boolean a(Context r100) {
        if (f4645b != null) goto L12;
        g r101 = new g(r100);
        f4645b = r101;
        if (r101.a() == false) goto L12;
        f4645b.b(0);
        f4646c = f4645b.b(3);
        int r102 = f4645b.b();
        f4647d = r102;
        if (r102 != (-1)) goto L10;
        LogUtil.warn(f4644a, "it not support PerfService!");
        return false;
    L10:
        c();
        LogUtil.info(f4644a, "MTKPerfInterface init.");
        return true;
    L12:
        return false;
    }

    @Override // android.ss.com.vboost.h.c
    public void b() {
        d();
        g r100 = f4645b;
        if (r100 == null) goto L8;
        int r101 = r100.b();
        f4647d = r101;
        if ((-1) == r101) goto L9;
        LogUtil.debug(f4644a, "try boost");
        f4645b.a(f4647d, 10, 3, -1, -1, -1);
        f4645b.a(f4647d, 1, f4648e, -1, -1, -1);
        f4645b.a(f4647d, 4, f4650g, -1, -1, -1);
        f4645b.a(f4647d, 6, f4650g, f4649f, -1, -1);
        f4645b.a(f4647d, 23, 1000, -1, -1, -1);
        f4645b.a(f4647d, 30000);
        return;
    L9:
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void b(long r110) {
        d();
        g r100 = f4645b;
        if (r100 == null) goto L8;
        int r101 = r100.b();
        f4647d = r101;
        if ((-1) == r101) goto L9;
        LogUtil.debug(f4644a, "try boost gpu");
        f4645b.a(f4647d, 10, 3, -1, -1, -1);
        f4645b.a(f4647d, 8, f4646c, -1, -1, -1);
        f4645b.a(f4647d, (int) r110);
        return;
    L9:
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void c(long r110) {
        d();
        g r100 = f4645b;
        if (r100 == null) goto L8;
        int r101 = r100.b();
        f4647d = r101;
        if ((-1) == r101) goto L9;
        LogUtil.debug(f4644a, "try boost storage");
        f4645b.a(f4647d, 10, 3, -1, -1, -1);
        f4645b.a(f4647d, (int) r110);
        return;
    L9:
        return;
    }
}
