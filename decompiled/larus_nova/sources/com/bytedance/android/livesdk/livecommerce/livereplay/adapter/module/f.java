package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cf.j;
import cf.l;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter.ECProductCardPresenter;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.b f149283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<j> f149284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ni2.b f149285n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        ECProductCardPresenter r100 = new ECProductCardPresenter(this, this.f149285n);
        ((ArrayList) this.f149284m).add(r100);
        return r100;
    }

    public f(ni2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(0);
        this.f149285n = r100;
        this.f149284m = new ArrayList();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        if (r100 != null) goto L6;
        return 8;
    L6:
        if ((r100 instanceof ni2.a) == true) goto L8;
        r100 = null;
    L8:
        ni2.a r101 = (ni2.a) r100;
        if (r101 != null) goto L12;
        return 8;
    L12:
        if (r101.f519240m == false) goto L15;
        return 8;
    L15:
        if (r101.f519228a == false) goto L18;
        return 0;
    L18:
        return 8;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r210, ViewGroup r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r211 != null) goto L6;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("[ECProductCardUIModule onCreateView] parent is null", null);
        return new FrameLayout(r210);
    L6:
        String r100 = this.f149285n.f519244d.f(null);
        String r101 = this.f149285n.f519244d.d(null);
        this.f149285n.f519244d.g();
        String r102 = this.f149285n.f519244d.e(null);
        this.f149285n.f519244d.c();
        this.f149285n.f519244d.i();
        this.f149285n.f519244d.j();
        this.f149285n.f519244d.h();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r110 = new com.bytedance.android.livesdk.livecommerce.promotion.card.g.a(r100, r101, "", r102, "", "", "", "", this.f149285n.f519244d.a(null), this.f149285n.f519244d.b(null), null, true, 7168);
        d r103 = new d(this);
        e r104 = new e(this);
        int r105 = ECSdk.f48106a;
        l r111 = (l) ECSdk.a(l.class);
        if (r111 == null) goto L15;
        int r106 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.f149355a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.f149285n.f519248h) == false) goto L11;
        c r107 = new c(this);
    L12:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r108 = r111.Da(r211, new com.bytedance.android.livesdk.livecommerce.promotion.card.g(r110, r103, r104, r107, this.f149285n.f519243c), false);
        if (r108 == null) goto L15;
        int r109 = b.f149279a;
        final String r112 = this.f149285n.f519248h;
        Intrinsics.checkNotNullParameter(r108, "promotionCard");
        Intrinsics.checkNotNullParameter(r112, "enterFrom");
        r108.w2(new com.bytedance.android.livesdk.livecommerce.promotion.card.j(((k) IPromotionUIConfig.f150021a.getValue()).f150096a).a(PromotionCardModuleName.Title, ECProductCardUIConfig$updateUI$1.INSTANCE).a(PromotionCardModuleName.ImageAreaModule, ECProductCardUIConfig$updateUI$2.INSTANCE).a(PromotionCardModuleName.ImageAreaIndex, ECProductCardUIConfig$updateUI$3.INSTANCE).a(PromotionCardModuleName.BottomModule, ECProductCardUIConfig$updateUI$4.INSTANCE).a(PromotionCardModuleName.InfoAreaModule, new ECProductCardUIConfig$updateUI$5(r112)).a(PromotionCardModuleName.Parent, ECProductCardUIConfig$updateUI$6.INSTANCE).f150062a);
        this.f149283l = r108;
        goto L15
    L11:
        r107 = null;
    L15:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r113 = this.f149283l;
        if (r113 != null) goto L20;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("[ECProductCardUIModule onCreateView] createNewPromotionListItem error", null);
        return new FrameLayout(r210);
    L20:
        return com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r113);
    }
}
