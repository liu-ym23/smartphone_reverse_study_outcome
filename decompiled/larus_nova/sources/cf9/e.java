package cf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = b.f23547a;
        Intrinsics.checkNotNullParameter(r100, "ticket");
        if (r100.f23550a > 0) goto L5;
        boolean r102 = true;
    L7:
        return true ^ r102;
    L5:
        r102 = false;
        goto L7
    }
}
