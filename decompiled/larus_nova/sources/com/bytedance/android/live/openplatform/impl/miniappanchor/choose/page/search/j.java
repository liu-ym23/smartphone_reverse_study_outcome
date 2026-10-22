package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f84283a;

    public j(k r100) {
        this.f84283a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((OpenPlatformFullScreenErrorView) this.f84283a.f84284a.S90(R.id.error_view)).R5();
        MiniAppChooseSearchFragment.T90(this.f84283a.f84284a);
    }
}
