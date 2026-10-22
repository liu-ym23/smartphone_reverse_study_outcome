package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f84426a;

    public a(int r100) {
        this.f84426a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Object[] r101 = new Object[1];
        if (this.f84426a != 1) goto L5;
        String r102 = s1.B(R.string.ttlive_mini_app_coexist_component_commerce);
    L6:
        r101[0] = r102;
        f2.c(s1.C(R.string.ttlive_mini_app_disable_open_first_explain_card_setting_tip, r101), 0);
        return;
    L5:
        r102 = "";
        goto L6
    }
}
