package aq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowFloatLynxPresenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends QUIModule {
    public h() {
        super(0);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowInnerFlowFloatLynxPresenter();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new View(a().getContext());
    }
}
