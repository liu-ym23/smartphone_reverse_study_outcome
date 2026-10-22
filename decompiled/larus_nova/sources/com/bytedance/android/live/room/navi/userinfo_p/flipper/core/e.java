package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final BaseTabFlipper.LayoutParams a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$flipperLp");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof BaseTabFlipper.LayoutParams) == true) goto L6;
        r101 = null;
    L6:
        return (BaseTabFlipper.LayoutParams) r101;
    }

    public static final w91.e b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$flipperTabData");
        BaseTabFlipper.LayoutParams r101 = a(r100);
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.f100027b;
    L7:
        if ((r103 instanceof w91.e) == false) goto L11;
        r102 = r103;
    L11:
        return (w91.e) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static final w91.e c(w91.f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$flipperTabData");
        BaseTabFlipper.LayoutParams r101 = a(r100.a());
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.f100027b;
    L7:
        if ((r103 instanceof w91.e) == false) goto L11;
        r102 = r103;
    L11:
        return (w91.e) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static final <T> T d(List<? extends T> r100, int r101) {
        if (r100 == null) goto L9;
        if (r101 >= 0) goto L6;
        return null;
    L6:
        if (r101 < r100.size()) goto L8;
        return null;
    L8:
        return (T) ListProtector.get(r100, r101);
    L9:
        return null;
    }

    public static final void e(w91.f r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setText");
        View r102 = r100.a().findViewById(R.id.tv_common_text);
        if ((r102 instanceof TextView) == true) goto L5;
        r102 = null;
    L5:
        TextView r103 = (TextView) r102;
        if (r103 == null) goto L9;
        r103.setText(r101);
        return;
    }
}
