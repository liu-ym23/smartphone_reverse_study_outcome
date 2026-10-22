package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qj3.b f185130l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new com.bytedance.android.shopping.store.hybridproduct.presenter.b(this.f185130l);
    }

    public d(qj3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "dividerView");
        super(-1, null);
        this.f185130l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f185130l;
    }
}
