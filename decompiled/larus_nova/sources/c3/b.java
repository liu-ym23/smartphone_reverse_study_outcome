package c3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final boolean a(String r100) {
        if (r100 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a r101 = new a(r100);
        if (r101.f22260b > 0) goto L11;
        if (r101.f22261c > 0) goto L11;
        if (r101.f22262d > 0) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }
}
