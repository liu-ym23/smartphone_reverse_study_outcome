package g5;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f19947a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f19948b = -1;

    static {
    }

    public static long a() {
        if (f19948b != (-1)) goto L6;
        f19948b = 1000 / b();
    L6:
        return f19948b;
    }

    public static long b() {
        return c(100);
    }

    public static long c(long r10) {
        long r11 = f19947a;
        if (r11 <= 0) goto L5;
        return r11;
    L5:
        long r12 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r12 <= 0) goto L8;
        r10 = r12;
    L8:
        f19947a = r10;
        return r10;
    }
}
