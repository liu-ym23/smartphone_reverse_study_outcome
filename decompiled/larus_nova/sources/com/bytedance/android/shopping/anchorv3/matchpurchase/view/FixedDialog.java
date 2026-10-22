package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/FixedDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedDialog extends BottomSheetDialog {
    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -1);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L9;
        r102.setSoftInputMode(48);
        return;
    }

    public FixedDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
