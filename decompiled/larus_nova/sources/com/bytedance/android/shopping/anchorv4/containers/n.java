package com.bytedance.android.shopping.anchorv4.containers;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv3.compat.ToggleBottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n extends ToggleBottomSheetDialog {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Integer> f166226k;

    @Override // com.bytedance.android.shopping.anchorv3.compat.ToggleBottomSheetDialog
    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        if (r100 == 0) goto L5;
        if (r101 != null) goto L5;
        r101 = th.a.c(getContext(), r100, null, false);
    L5:
        if (r101 == null) goto L13;
        View r103 = r101.findViewById(R.id.coordinator);
        if (r103 == null) goto L13;
        L0(r103);
        View r104 = r103.findViewById(R.id.commerce_design_bottom_sheet);
        if (r104 == null) goto L13;
        BottomSheetBehavior r105 = BottomSheetBehavior.from(r104);
        if (r105 == null) goto L13;
        r105.setPeekHeight(this.f166226k.invoke().intValue());
    L13:
        if (r101 == null) goto L16;
        return r101;
    L16:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public n(FragmentActivity r100, com.bytedance.android.shopping.anchorv3.compat.g r101, Function0 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "getPeekHeight");
        Intrinsics.checkNotNullParameter(r103, "onClose");
        super(r100, 0, r101, r103);
        this.f166226k = r102;
    }
}
