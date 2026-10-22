package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class n<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 f61588a;

    public n(LiveOpenFeatureSearchFragmentV3 r100) {
        this.f61588a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveOpenFeatureSearchFragmentV3 r101 = this.f61588a;
        LiveOpenFeatureSearchFragmentV3.S90(r101, (List) r100);
    }
}
