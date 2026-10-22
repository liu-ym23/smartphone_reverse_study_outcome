package as9;

import android.content.Context;
import android.os.Build;
import android.os.Looper;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Looper f16143a;

    public static a a(int r100, Context r101) {
        if (r100 != 0) goto L6;
        return new yr9.b(r101, f16143a);
    L6:
        if (r100 == 1) goto L8;
    L11:
        return null;
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        return new yr9.a(r101, f16143a);
    }
}
