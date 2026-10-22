package com.stepos.policy.sdk.activity;

import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7954a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyHtmlViewerActivity f7955b;

    public /* synthetic */ a(PolicyHtmlViewerActivity policyHtmlViewerActivity, int i10) {
        this.f7954a = i10;
        this.f7955b = policyHtmlViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f7954a;
        PolicyHtmlViewerActivity policyHtmlViewerActivity = this.f7955b;
        switch (i10) {
            case 0:
                PolicyHtmlViewerActivity.showNetWorkErrorView$lambda$6(policyHtmlViewerActivity, view);
                break;
            default:
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$10(policyHtmlViewerActivity, view);
                break;
        }
    }
}
