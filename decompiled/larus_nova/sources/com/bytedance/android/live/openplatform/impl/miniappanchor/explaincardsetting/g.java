package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainCardSettingDialog f84432a;

    public g(ExplainCardSettingDialog r100) {
        this.f84432a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ExplainCardSettingDialog r101 = this.f84432a;
        r101.f84394i = true;
        r101.finish();
    }
}
