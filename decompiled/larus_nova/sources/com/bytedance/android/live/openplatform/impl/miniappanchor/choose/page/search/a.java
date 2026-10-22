package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84274a;

    public a(MiniAppChooseSearchFragment r100) {
        this.f84274a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = com.bytedance.android.live.openplatform.impl.base.utils.k.f84065a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(this.f84274a.getContext(), this.f84274a.S90(R.id.search_edit));
    }
}
