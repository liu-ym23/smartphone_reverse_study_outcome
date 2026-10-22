package com.bytedance.android.annie.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x8.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/dialog/NoMarginSheetBaseDialog;", "Lcom/bytedance/android/livesdk/pannel/SheetBaseDialog;", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class NoMarginSheetBaseDialog extends SheetBaseDialog {
    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog
    public final void M0(View r100) {
        if (r100 != null) goto L5;
    L13:
        this.f154349n = true;
        View r101 = this.f154350o;
        if (r101 == null) goto L16;
        r101.setFocusable(false);
        r101.setImportantForAccessibility(2);
    L16:
        a.d("NoMarginSheetBaseDialog", "call disableTouchOutsizeA11yFocus with ture", false);
        return;
    L5:
        if (this.f154354s == false) goto L13;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r102;
        ((ViewGroup.MarginLayoutParams) r103).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) r103).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = 0;
    L10:
        if ((r100 instanceof RadiusLayout) == false) goto L12;
        ((RadiusLayout) r100).setMaxHeight(0);
    L12:
        r102.width = -2;
        r100.setLayoutParams(r102);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (r100 == true) goto L13;
        if (AnnieConfigSettingKeys.ENABLE_DIALOG_PULL_DOWN_GESTURE_BY_FE_HANDLE_CLOSE.a().booleanValue() == false) goto L14;
        SheetBaseBehavior<?> r101 = this.f154336a;     // Catch: Exception -> L10
        if (r101 == null) goto L15;
        r101.f154331a = true;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public NoMarginSheetBaseDialog(Context r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
    }
}
