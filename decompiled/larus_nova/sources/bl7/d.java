package bl7;

import android.app.Application;
import rk7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f19500a;

    static {
        f19500a = -1;
    }

    public static boolean a() {
        Application r100 = m.f538347a;
        int r101 = m.f();
        if (r101 == 8662) goto L7;
        if (r101 == 8661) goto L7;
        return true;
    L7:
        if (f19500a != (-1)) goto L10;
        f19500a = il7.m.a().f("sp_key_new_timer", Boolean.FALSE) ? 1 : 0;
    L10:
        if (f19500a == 1) goto L15;
        return false;
    L15:
        return true;
    }
}
