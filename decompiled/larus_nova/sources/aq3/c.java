package aq3;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowHotCommentElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final vp.c f15894n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowInnerFlowHotCommentElementPresenter(this.f15894n);
    }

    public c(View r100, vp.c r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "hotElementPlayerProxy");
        super(r100, yp3.b.f568700a);
        this.f15894n = r101;
    }
}
