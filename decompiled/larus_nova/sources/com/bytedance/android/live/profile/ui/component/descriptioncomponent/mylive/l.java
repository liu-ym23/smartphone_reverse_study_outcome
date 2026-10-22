package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabItemAdapter.LoadingViewHolder f86637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabDataHelper f86638b;

    public l(TabItemAdapter.LoadingViewHolder r100, TabDataHelper r101) {
        this.f86637a = r100;
        this.f86638b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TextView r101 = this.f86637a.f86606b;
        if (r101 == null) goto L5;
        r101.setText(s1.B(R.string.ttlive_tab_loading));
    L5:
        ImageView r102 = this.f86637a.f86607c;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        TabDataHelper r103 = this.f86638b;
        if (r103 == null) goto L12;
        r103.c();
        return;
    }
}
