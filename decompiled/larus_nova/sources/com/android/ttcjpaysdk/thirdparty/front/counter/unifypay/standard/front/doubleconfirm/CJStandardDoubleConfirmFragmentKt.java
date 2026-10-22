package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.front.doubleconfirm;

import android.os.Bundle;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"putDoubleConfirmPanelHeightIfMissing", "", "Landroid/os/Bundle;", "panelHeight", "", "bdpay-front-counter_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJStandardDoubleConfirmFragmentKt {
    public static final void putDoubleConfirmPanelHeightIfMissing(Bundle r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r100.containsKey(BaseStandardHomeFragment.KEY_PANEL_HEIGHT) == true) goto L9;
        r100.putInt(BaseStandardHomeFragment.KEY_PANEL_HEIGHT, r101);
        return;
    }
}
