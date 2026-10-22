package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4628a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f4629b;

    public b() {
    }

    @Override // android.ss.com.vboost.h.c
    public void a() {
        LogUtil.debug(f4628a, "release");
    }

    @Override // android.ss.com.vboost.h.c
    public void a(long r100) {
        if (f4629b == null) goto L6;
        LogUtil.debug(f4628a, "try boost timeout " + r100);
        f4629b.a(r100);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public boolean a(Context r100) {
        if (f4629b != null) goto L6;
        f4629b = new a(r100);
    L6:
        if (f4629b.a() == false) goto L9;
        LogUtil.info(f4628a, "CHRYPerfInterface init.");
        return true;
    L9:
        return false;
    }

    @Override // android.ss.com.vboost.h.c
    public void b() {
        if (f4629b == null) goto L6;
        LogUtil.debug(f4628a, "try boost");
        f4629b.a(30000);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void b(long r100) {
        if (f4629b == null) goto L6;
        LogUtil.debug(f4628a, "try boost gpu with timeout " + r100);
        f4629b.a(r100);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void c(long r100) {
        if (f4629b == null) goto L6;
        LogUtil.debug(f4628a, "try boost storage with timeout " + r100);
        f4629b.a(r100);
        return;
    }
}
