package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 f61579a;

    public f(LiveOpenFeatureChooseListFragmentV3 r100) {
        this.f61579a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L5;
        LiveOpenFeatureChooseListFragmentV3 r101 = this.f61579a;
        int r102 = LiveOpenFeatureChooseListFragmentV3.F;
        r101.aa0(true);
        return;
    L5:
        LiveOpenFeatureChooseListFragmentV3 r103 = this.f61579a;
        int r104 = LiveOpenFeatureChooseListFragmentV3.F;
        r103.aa0(false);
    }
}
