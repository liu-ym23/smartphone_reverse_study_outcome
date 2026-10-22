package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.view.ViewGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w83.i f150203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy<w83.i> f150204f;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        w83.i r100 = this.f150203e;
        if (r100 == null) goto L6;
        r100.d((ViewGroup) w().f());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Lazy<? extends w83.i> r100) {
        Intrinsics.checkNotNullParameter(r100, "ligoViewManager");
        this.f150204f = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (this.f150203e != null) goto L5;
        this.f150203e = this.f150204f.getValue();
    L5:
        Boolean r101 = null;
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L8;
        r100 = null;
    L8:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r102 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r100;
        if (r102 == null) goto L38;
        IPromotionUIConfig.d r103 = r102.f150061c.a(PromotionCardModuleName.TopModule);
        if (r103 == null) goto L14;
        r101 = r103.d();
    L14:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == true) goto L45;
        ECUIPromotion r104 = r102.f150059a.f42855a;
        int r105 = i.f150202a[r102.f150060b.ordinal()];
        if (r105 != 1) goto L19;
        ll.a r106 = r104.promotionHeader;
        if (r106 == null) goto L33;
        w().g(0);
        w83.i r107 = this.f150203e;
        if (r107 == null) goto L41;
        ll.b r108 = w83.i.a.a(r107, (ViewGroup) w().f(), r106, false, 12);
        if (r108 == null) goto L42;
        Integer r109 = r108.f509658a;
        if (r109 == null) goto L43;
        w().b(r109.intValue()).f().getLayoutParams().width = -1;
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L33:
        w83.i r110 = this.f150203e;
        if (r110 == null) goto L36;
        r110.d((ViewGroup) w().f());
    L36:
        w().c();
        return;
    L19:
        if (r105 != 2) goto L46;
        w83.i r111 = this.f150203e;
        if (r111 == null) goto L39;
        r111.d((ViewGroup) w().f());
        return;
    L39:
        return;
    L46:
        return;
    L45:
        return;
    }
}
