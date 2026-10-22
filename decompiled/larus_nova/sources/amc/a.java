package amc;

import kotlin.jvm.internal.Intrinsics;
import vlc.o;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final o a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUrlSwitcher");
        if ((r100 instanceof h) == true) goto L5;
        r100 = null;
    L5:
        h r101 = (h) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.o();
    }
}
