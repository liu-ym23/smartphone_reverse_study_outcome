package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f148792l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new d();
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(0);
        this.f148792l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f148792l;
    }
}
