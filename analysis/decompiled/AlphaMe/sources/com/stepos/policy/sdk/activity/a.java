package com.stepos.policy.sdk.activity;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12118a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyWebViewActivity f12119b;

    public /* synthetic */ a(PolicyWebViewActivity policyWebViewActivity, int i4) {
        this.f12118a = i4;
        this.f12119b = policyWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f12118a;
        PolicyWebViewActivity policyWebViewActivity = this.f12119b;
        switch (i4) {
            case 0:
                PolicyWebViewActivity.showNotNetWorkView$lambda$8(policyWebViewActivity, view);
                break;
            default:
                PolicyWebViewActivity.showNetWorkErrorView$lambda$5(policyWebViewActivity, view);
                break;
        }
    }
}
