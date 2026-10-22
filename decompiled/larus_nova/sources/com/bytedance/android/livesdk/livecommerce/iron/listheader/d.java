package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.view.View;
import com.bytedance.android.ec.core.opt.ab.j;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.ECPromotionListHeaderLayout;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECPromotionListHeaderLayout f148793e;

    public d() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f148793e = (ECPromotionListHeaderLayout) w().b(R.id.list_header_opt).f();
        if ((r100 instanceof i) == true) goto L5;
        r100 = null;
    L5:
        i r101 = (i) r100;
        cl.d r102 = k.a();
        if (r102 == null) goto L11;
        View r103 = w().f();
        if (r101 == null) goto L10;
        r101.d();
    L10:
        r102.c(r103);
    L11:
        int r104 = ph.b.f529227a;
        View r105 = w().f();
        Intrinsics.checkNotNullParameter(r105, "view");
        if (j.a().h() == false) goto L14;
        ph.b.b(r105);
    L14:
        if (r101 == null) goto L21;
        b r106 = r101.d();
        if (r106 == null) goto L22;
        ECPromotionListHeaderLayout r107 = this.f148793e;
        if (r107 == null) goto L23;
        r107.R5(r106, r101);
        return;
    L23:
        return;
    L22:
        return;
    }
}
