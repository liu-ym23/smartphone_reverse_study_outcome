package ci8;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final d a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Fragment r101 = r100.getParentFragment();
    L3:
        if (r101 == 0) goto L9;
        if ((r101 instanceof d) == true) goto L7;
        r101 = r101.getParentFragment();
        goto L3
    L7:
        return (d) r101;
    L9:
        return null;
    }

    public static final boolean b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Fragment r101 = r100.getParentFragment();
    L3:
        if (r101 == null) goto L9;
        if ((r101 instanceof d) == true) goto L6;
        r101 = r101.getParentFragment();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
