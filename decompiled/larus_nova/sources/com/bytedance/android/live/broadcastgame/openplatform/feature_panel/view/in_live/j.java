package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureChooseListFragment f61508a;

    public j(LiveOpenFeatureChooseListFragment r100) {
        this.f61508a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L5;
        LiveOpenFeatureChooseListFragment r101 = this.f61508a;
        int r102 = LiveOpenFeatureChooseListFragment.f61466p;
        r101.Y90(true);
        return;
    L5:
        LiveOpenFeatureChooseListFragment r103 = this.f61508a;
        int r104 = LiveOpenFeatureChooseListFragment.f61466p;
        r103.Y90(false);
    }
}
