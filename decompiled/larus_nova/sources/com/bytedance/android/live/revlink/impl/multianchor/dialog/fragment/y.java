package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class y implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractRecordContainerFragment f93514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f93515b;

    public y(InteractRecordContainerFragment r100, ViewGroup r101) {
        this.f93514a = r100;
        this.f93515b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TabLayout r101 = (TabLayout) this.f93515b.findViewById(R.id.tab);
        if (r101 == null) goto L7;
        TabLayout.Tab r102 = r101.getTabAt(0);
        if (r102 == null) goto L7;
        r102.select();
    L7:
        InteractRecordContainerFragment.ca0(this.f93514a, 0);
    }
}
