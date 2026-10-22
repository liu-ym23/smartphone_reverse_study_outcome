package com.bytedanceos.common.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.widget.SubButton;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveGameDialog {
    private Activity mActivity;

    public ReserveGameDialog(Activity r10) {
        this.mActivity = r10;
    }

    public static /* synthetic */ Activity access$000(ReserveGameDialog r10) {
        return r10.mActivity;
    }

    public void showAbandonDialog(final SubButton r10) {
        Activity r11 = this.mActivity;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isFinishing() == true) goto L10;
        final AlertDialog r12 = new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getString(R$string.game_give_up_reserve_dialog_title)).setMessage(this.mActivity.getString(R$string.game_give_up_reserve_dialog_content)).setPositiveButton(this.mActivity.getString(R$string.game_give_up_confirm), new AnonymousClass3(this, r10)).setCancelable(false).setNegativeButton(R$string.cancel, null).create();
        r12.setOnShowListener(new AnonymousClass4(this, r12));
        r12.show();
        return;
    }

    public void showReserveDialog() {
        final HashMap r10 = new HashMap();
        if (AccountDataCache.b().n() == false) goto L5;
        e0.e(R$string.game_reserve_success_toast);
        return;
    L5:
        new AlertDialog.Builder(this.mActivity, 5).setTitle(R$string.game_reserve_success_dialog_title).setMessage(R$string.game_reserve_success_dialog_content).setCancelable(false).setPositiveButton(this.mActivity.getString(R$string.game_reserve_success_dialog_login), new AnonymousClass2(this, r10)).setNegativeButton(R$string.game_reserve_success_dialog_give_up, new AnonymousClass1(this, r10)).show();
    }
}
