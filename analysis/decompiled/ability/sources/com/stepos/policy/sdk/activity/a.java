package com.stepos.policy.sdk.activity;

import android.view.View;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3942a;
    public final /* synthetic */ PolicyHtmlViewerActivity b;

    public /* synthetic */ a(PolicyHtmlViewerActivity policyHtmlViewerActivity, int i) {
        this.f3942a = i;
        this.b = policyHtmlViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f3942a;
        PolicyHtmlViewerActivity policyHtmlViewerActivity = this.b;
        switch (i) {
            case 0:
                PolicyHtmlViewerActivity.showNetWorkErrorView$lambda$5(policyHtmlViewerActivity, view);
                break;
            default:
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$9(policyHtmlViewerActivity, view);
                break;
        }
    }
}
