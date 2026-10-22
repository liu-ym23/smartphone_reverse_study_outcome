package ci4;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleOrGone");
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r100.getVisibility() == 8) goto L14;
        r100.setVisibility(8);
        return;
    L14:
        return;
    L5:
        if (r100.getVisibility() == 0) goto L7;
        r100.setVisibility(0);
    }

    public static final void b(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleOrInvisible");
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r100.getVisibility() == 4) goto L14;
        r100.setVisibility(4);
        return;
    L14:
        return;
    L5:
        if (r100.getVisibility() == 0) goto L7;
        r100.setVisibility(0);
    }
}
