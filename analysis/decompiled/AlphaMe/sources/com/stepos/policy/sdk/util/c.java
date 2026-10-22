package com.stepos.policy.sdk.util;

import android.view.View;
import android.widget.CheckBox;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12263a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CheckBox f12264b;

    public /* synthetic */ c(CheckBox checkBox, int i4) {
        this.f12263a = i4;
        this.f12264b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f12263a;
        CheckBox checkBox = this.f12264b;
        switch (i4) {
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
