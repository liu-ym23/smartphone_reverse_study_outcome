package com.stepos.policy.sdk.util;

import android.view.View;
import android.widget.CheckBox;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2796c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ CheckBox f2797f;

    public /* synthetic */ b(int i) {
        this.f2796c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2796c;
        CheckBox checkBox = this.f2797f;
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
