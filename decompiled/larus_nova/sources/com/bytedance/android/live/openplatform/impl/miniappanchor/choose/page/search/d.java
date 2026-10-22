package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84277a;

    public d(MiniAppChooseSearchFragment r100) {
        this.f84277a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == true) goto L5;
        ((ImageView) this.f84277a.S90(R.id.clear_search_input)).setVisibility(4);
        return;
    L5:
        if (((EditText) this.f84277a.S90(R.id.search_edit)).getText().length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        ((ImageView) this.f84277a.S90(R.id.clear_search_input)).setVisibility(4);
        return;
    L10:
        ((ImageView) this.f84277a.S90(R.id.clear_search_input)).setVisibility(0);
        return;
    L7:
        r102 = false;
        goto L8
    }
}
