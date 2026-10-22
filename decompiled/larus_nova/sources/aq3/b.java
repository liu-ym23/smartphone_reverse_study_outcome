package aq3;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowBarrageElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final vp.c f15892n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f15893o;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowInnerFlowBarrageElementPresenter(this.f15892n, this.f15893o);
    }

    public b(View r100, vp.c r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "barrageElementPlayerProxy");
        super(r100, yp3.a.f568699a);
        this.f15892n = r101;
        this.f15893o = false;
    }
}
