package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.card.presenter.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f150177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy<i> f150178m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new j(this.f150178m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(View r100, Lazy<? extends i> r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "ligoViewManager");
        super(0);
        this.f150177l = r100;
        this.f150178m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f150177l;
    }
}
