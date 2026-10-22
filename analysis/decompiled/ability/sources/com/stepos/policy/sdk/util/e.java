package com.stepos.policy.sdk.util;

import android.view.View;
import android.widget.CheckBox;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3959a;
    public final /* synthetic */ CheckBox b;

    public /* synthetic */ e(CheckBox checkBox, int i) {
        this.f3959a = i;
        this.b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f3959a;
        CheckBox checkBox = this.b;
        switch (i) {
            case 0:
                PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(checkBox, view);
                break;
            case 1:
                PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(checkBox, view);
                break;
            default:
                PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4(checkBox, view);
                break;
        }
    }
}
