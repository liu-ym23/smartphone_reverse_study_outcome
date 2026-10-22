package aq3;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowVideoElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final vp.c f15895n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final vp.c f15896o;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowInnerFlowVideoElementPresenter(this.f15895n, this.f15896o);
    }

    public g(View r100, vp.c r101, vp.c r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "videoPlayerProxy");
        super(r100, yp3.h.f568704a);
        this.f15895n = r101;
        this.f15896o = r102;
    }
}
