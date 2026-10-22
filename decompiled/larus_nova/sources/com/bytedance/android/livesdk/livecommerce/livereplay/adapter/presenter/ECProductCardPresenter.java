package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import cf.j;
import cf.r;
import cj2.c;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.f;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.b;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes10.dex */
public final class ECProductCardPresenter extends QPresenter implements j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f149287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f149288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f149289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f149290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ni2.b f149291i;

    @Override // cf.j
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        r r100 = this.f149287e;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("promotionItem");
    L6:
        r100.onViewRecycled();
    L7:
        b r101 = this.f149288f;
        if (r101 == null) goto L13;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L11:
        r101.release();
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (this.f149288f == null) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L13;
        b r102 = this.f149290h.f149283l;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L11:
        this.f149288f = r102;
    L13:
        if ((r100 instanceof ni2.a) == true) goto L15;
        r100 = null;
    L15:
        final ni2.a r103 = (ni2.a) r100;
        if (r103 != null) goto L19;
        return;
    L19:
        if (r103.f519237j != null) goto L21;
        return;
    L21:
        b r104 = this.f149288f;
        if (r104 != null) goto L24;
    L33:
        int r105 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.f149355a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.f149291i.f519248h) == false) goto L37;
        c r106 = cj2.a.f23945a;
        cj2.a.d("1", r103.f519234g, r103.f519233f, this.f149291i.f519244d.f(Integer.valueOf(r103.f519237j.getIronIndex())), BtmSDK.INSTANCE.getPageId(PageFinder.via(y())));
        return;
    L37:
        return;
    L24:
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L26:
        r104.w2(new com.bytedance.android.livesdk.livecommerce.promotion.card.j(r104.getUIConfig()).a(PromotionCardModuleName.ImageAreaIndex, new ECProductCardPresenter$onBind$3(r103)).f150062a);
        b r107 = this.f149288f;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L29:
        com.bytedance.android.ec.common.api.jump.model.a r108 = (com.bytedance.android.ec.common.api.jump.model.a) ((Function0) this.f149289g.getValue()).invoke();
        if (r108 != null) goto L32;
        r108 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
    L32:
        b.a.b(r107, (g) r108.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r103.f519237j)));
        goto L33
    L5:
        r101 = false;
        goto L7
    }

    @Override // cf.j
    public final void e(ql.a r100) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
        int r101 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.f149355a;
        QContext r102 = u();
        ni2.b r103 = this.f149291i;
        AbsECScrollProductCardBaseVideModel r104 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(r102, r103.f519248h, r103.f519250j);
        if (r104 == null) goto L6;
        r104.clickProductCard();
        return;
    }

    public ECProductCardPresenter(f r100, ni2.b r101) {
        Intrinsics.checkNotNullParameter(r100, "uiModule");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f149290h = r100;
        this.f149291i = r101;
        this.f149289g = LazyKt.lazy(new ECProductCardPresenter$absParams$2(this));
    }

    @Override // cf.j
    public final void c(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r100, "promotionId");
    }
}
