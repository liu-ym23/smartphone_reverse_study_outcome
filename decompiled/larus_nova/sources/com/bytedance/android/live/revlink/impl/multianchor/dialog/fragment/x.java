package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractRecordContainerFragment f93513a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    public x(InteractRecordContainerFragment r100) {
        this.f93513a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (r100.getText() != null) goto L5;
        return;
    L5:
        InteractRecordContainerFragment r101 = this.f93513a;
        int r102 = InteractRecordContainerFragment.f93429o;
        r101.da0(r100, true);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (r100.getText() != null) goto L5;
        return;
    L5:
        InteractRecordContainerFragment r101 = this.f93513a;
        int r102 = InteractRecordContainerFragment.f93429o;
        r101.da0(r100, false);
    }
}
