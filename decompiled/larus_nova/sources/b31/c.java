package b31;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final int a(GravityDef r100) {
        Intrinsics.checkNotNullParameter(r100, "gravityDef");
        switch(b.f17173a[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return 0;
    L7:
        return 51;
    L8:
        return 5;
    L9:
        return 3;
    L10:
        return 1;
    L11:
        return 80;
    L12:
        return 48;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static final void b(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutData");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "layoutData");
        if (r103.width == r101.f17167a) goto L11;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L24;
        return;
    L24:
        r103.width = r101.f17167a;
        r103.height = r101.f17168b;
        r103.leftMargin = r101.f17170d;
        r103.rightMargin = r101.f17171e;
        r103.topMargin = r101.f17169c;
        r103.gravity = a(r101.f17172f);
        r100.setLayoutParams(r103);
        return;
    L11:
        if (r103.height != r101.f17168b) goto L21;
        if (r103.leftMargin != r101.f17170d) goto L21;
        if (r103.rightMargin != r101.f17171e) goto L21;
        if (r103.topMargin != r101.f17169c) goto L21;
        if (r103.gravity != a(r101.f17172f)) goto L21;
        r104 = true;
        goto L22
    }
}
