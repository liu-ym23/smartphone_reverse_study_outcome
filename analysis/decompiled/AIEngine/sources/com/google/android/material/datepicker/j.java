package com.google.android.material.datepicker;

import android.view.View;
import android.widget.CheckBox;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4967a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4968b;

    public /* synthetic */ j(Object obj, int i10) {
        this.f4967a = i10;
        this.f4968b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f4967a;
        Object obj = this.f4968b;
        switch (i10) {
            case 0:
                ((MaterialDatePicker) obj).lambda$initHeaderToggle$0(view);
                break;
            case 1:
                ((MaterialDatePicker) obj).onNegativeButtonClick(view);
                break;
            default:
                PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5$lambda$4((CheckBox) obj, view);
                break;
        }
    }
}
