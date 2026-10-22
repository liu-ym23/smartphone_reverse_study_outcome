package com.stepos.policy.sdk.activity;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2780c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ PolicyHtmlViewerActivity f2781f;

    public /* synthetic */ a(int i) {
        this.f2780c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2780c;
        PolicyHtmlViewerActivity policyHtmlViewerActivity = this.f2781f;
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
