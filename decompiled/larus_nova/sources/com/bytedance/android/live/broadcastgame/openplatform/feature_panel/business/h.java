package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements a20.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsOpenFeaturePanelViewModel f61440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a20.k f61441b;

    @Override // a20.c
    public final AbsOpenFeaturePanelViewModel f() {
        return this.f61440a;
    }

    public h(AbsOpenFeaturePanelViewModel r100, a20.k r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        new CompositeDisposable();
        this.f61440a = r100;
        this.f61441b = r101;
    }
}
