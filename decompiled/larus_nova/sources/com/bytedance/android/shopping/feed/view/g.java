package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f175639a;

    public g(Context r100) {
        this.f175639a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UIUtils.displayToast(this.f175639a, R.string.shopping_inflow_urge_click_toast, 0);
    }
}
