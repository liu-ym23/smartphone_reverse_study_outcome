package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84278a;

    public e(MiniAppChooseSearchFragment r100) {
        this.f84278a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((EditText) this.f84278a.S90(R.id.search_edit)).setText("");
    }
}
