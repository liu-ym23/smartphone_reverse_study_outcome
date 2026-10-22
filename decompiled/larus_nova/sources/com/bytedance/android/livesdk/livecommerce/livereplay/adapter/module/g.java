package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter.ECSimpleProductCardPresenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ni2.b f149286l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        ni2.b r100 = this.f149286l;
        return new ECSimpleProductCardPresenter(r100.f519248h, r100.f519250j);
    }

    public g(ni2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(0);
        this.f149286l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof ni2.a) == true) goto L8;
        r100 = null;
    L8:
        ni2.a r101 = (ni2.a) r100;
        if (r101 != null) goto L12;
        return 8;
    L12:
        if (r101.f519240m == false) goto L15;
        return 0;
    L15:
        if (r101.f519228a == false) goto L18;
        return 8;
    L18:
        return 0;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ShoppingAsyncInflater.f45268e.getClass();
        return ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_view_live_replay_simple_card, r101, false);
    }
}
