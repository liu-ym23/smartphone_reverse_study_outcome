package ck3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.search.presenter.ShopSearchHistoryPresenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f24020l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ShopSearchHistoryPresenter();
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(-1, null);
        this.f24020l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f24020l;
    }
}
