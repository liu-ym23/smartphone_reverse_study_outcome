package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragment f61515a;

    public q(LiveOpenFeatureSearchFragment r100) {
        this.f61515a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveOpenFeatureSearchFragment r101 = this.f61515a;
        LiveOpenFeatureSearchFragment.T90(r101, (List) r100);
    }
}
