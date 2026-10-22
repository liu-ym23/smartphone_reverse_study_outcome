package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f186783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<QIPresenter> f186784m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        QGroupPresenter r100 = new QGroupPresenter();
        List<QIPresenter> r101 = this.f186784m;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.a((QIPresenter) r102.next());
    L8:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r100, List<? extends QIPresenter> r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(0);
        this.f186783l = r100;
        this.f186784m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f186783l;
    }
}
