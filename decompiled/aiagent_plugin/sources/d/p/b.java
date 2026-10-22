package d.p;

import java.text.DecimalFormat;

/* JADX INFO: compiled from: DurationJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f38676a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f38677b = null;

    static {
        int r0 = 0;
        f38676a = false;
        ThreadLocal<DecimalFormat>[] r2 = new ThreadLocal[4];
    L3:
        if (r0 >= 4) goto L5;
        r2[r0] = new ThreadLocal();
        r0 = r0 + 1;
        goto L3
    L5:
        f38677b = r2;
    }

    public static final boolean a() {
        return f38676a;
    }
}
