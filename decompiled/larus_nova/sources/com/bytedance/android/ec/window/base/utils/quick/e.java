package com.bytedance.android.ec.window.base.utils.quick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f49767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fragment f49768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<Fragment, QIPresenter> f49769n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return this.f49769n.invoke(this.f49768m);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f49767l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(View r100, Fragment r101, Function1<? super Fragment, ? extends QIPresenter> r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "presenterGenerator");
        super(0);
        this.f49767l = r100;
        this.f49768m = r101;
        this.f49769n = r102;
    }
}
