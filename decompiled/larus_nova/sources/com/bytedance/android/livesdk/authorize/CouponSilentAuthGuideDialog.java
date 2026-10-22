package com.bytedance.android.livesdk.authorize;

import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/authorize/CouponSilentAuthGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CouponSilentAuthGuideDialog extends CommonBottomDialog {
    public CouponSilentAuthGuideDialog() {
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_coupon_silent_auth_confirm;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        String r100 = p.f104219a;
        p.f("guide", true);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        TextView r101 = (TextView) findViewById(R.id.tvAuthTitle);
        if (r101 == null) goto L5;
        r101.setText(getContext().getString(R.string.ttlive_coupon_silent_auth_guide_title));
    L5:
        TextView r102 = (TextView) findViewById(R.id.tvAuthContent);
        if (r102 == null) goto L8;
        r102.setText(getContext().getString(R.string.ttlive_silent_auth_guide_sub_content));
    L8:
        TextView r103 = (TextView) findViewById(R.id.btnConfirm);
        if (r103 == null) goto L12;
        r103.setText(getContext().getString(R.string.ttlive_coupon_silent_auth_dialog_confirm_auth));
    L12:
        throw null;
    }
}
