package com.stepos.policy.sdk.util;

import android.view.View;
import android.widget.CheckBox;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7988a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CheckBox f7989b;

    public /* synthetic */ e(CheckBox checkBox, int i10) {
        this.f7988a = i10;
        this.f7989b = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f7988a;
        CheckBox checkBox = this.f7989b;
        switch (i10) {
            case 0:
                PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2$lambda$1(checkBox, view);
                break;
            default:
                PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$3(checkBox, view);
                break;
        }
    }
}
