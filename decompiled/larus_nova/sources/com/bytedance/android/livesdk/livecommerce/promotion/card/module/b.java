package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f150168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LivePromotionCardArgs f150169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final w83.d<?> f150170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy<i> f150171o;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new com.bytedance.android.livesdk.livecommerce.promotion.card.presenter.b(this.f150169m, this.f150170n, this.f150171o);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f150168l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r100, LivePromotionCardArgs r101, w83.d<?> r102, Lazy<? extends i> r103) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "arguments");
        Intrinsics.checkNotNullParameter(r102, "ligoContext");
        Intrinsics.checkNotNullParameter(r103, "ligoViewManager");
        super(0);
        this.f150168l = r100;
        this.f150169m = r101;
        this.f150170n = r102;
        this.f150171o = r103;
    }
}
