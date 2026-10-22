package bsc;

import androidx.compose.ui.graphics.PathFillType;

/* JADX INFO: loaded from: classes41.dex */
public final class n {
    public static final int a(int r100) {
        m.Companion.getClass();
        if (r100 != m.f20409b) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return PathFillType.Companion.m5131getNonZeroRgk1Os();
    L9:
        return PathFillType.Companion.m5130getEvenOddRgk1Os();
    L5:
        r101 = false;
        goto L6
    }
}
