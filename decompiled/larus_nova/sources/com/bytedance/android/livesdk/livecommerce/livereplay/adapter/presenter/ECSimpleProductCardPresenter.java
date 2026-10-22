package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.event.c;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.facebook.common.util.UriUtil;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ECSimpleProductCardPresenter extends QPresenter implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ni2.a f149294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f149295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f149296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewModelProvider.Factory f149297h;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        this.f149294e = null;
        w().f().getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (w().f().getGlobalVisibleRect(this.f149295f) == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L15;
        ni2.a r101 = this.f149294e;
        if (r101 == null) goto L15;
        int r102 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.f149355a;
        AbsECScrollProductCardBaseVideModel r103 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(u(), this.f149296g, this.f149297h);
        if (r103 == null) goto L15;
        c.d(r103, new com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a.i(r101, y()));
    L15:
        if (mi2.a.f514049b == false) goto L22;
        mi2.a.f514049b = false;
        i r104 = i.f47987a;
        d r105 = r104.get(mi2.a.f514048a);
        if (r105 == null) goto L19;
        r105.a("render_end");
    L19:
        d r106 = r104.get(mi2.a.f514048a);
        if (r106 == null) goto L22;
        r106.report();
    L22:
        return true;
    L5:
        if (w().f().isShown() == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        Object r101 = null;
        if ((r100 instanceof ni2.a) == true) goto L5;
        QModel r102 = null;
    L6:
        this.f149294e = (ni2.a) r102;
        if (r100 != null) goto L11;
        ECPromotionImageView r103 = (ECPromotionImageView) w().b(R.id.piv_image).f();
        r103.setForceRadius(10);
        r103.setCallerContext(new r("ec_live", "ec_live_replay_simple_product_image"));
        ECUIPromotion r104 = new ECUIPromotion();
        UriUtil.getUriForResourceId(R.drawable.ec_live_promotion_list_loading_bg).toString();
        Unit r105 = Unit.INSTANCE;
        ECLiveImageUtils.h(r103, r104, 1, false, false);
        ECLiveImageUtils.g(r103, UriUtil.getUriForResourceId(R.drawable.ec_bg_transparent).toString());
        return;
    L11:
        if ((r100 instanceof ni2.a) == true) goto L13;
        r100 = null;
    L13:
        final ni2.a r106 = (ni2.a) r100;
        if (r106 != null) goto L17;
        return;
    L17:
        if (r106.f519237j != null) goto L19;
        return;
    L19:
        cl.d r107 = k.a();
        if (r107 == null) goto L22;
        r107.c(w().f());
    L22:
        ECPromotionImageView r108 = (ECPromotionImageView) w().b(R.id.piv_image).f();
        r108.setForceRadius(10);
        r108.setCallerContext(new r("ec_live", "ec_live_replay_simple_product_image"));
        ECUIPromotion r109 = r106.f519237j;
        ECLiveImageUtils.h(r108, r109, r109.getStatus(), false, false);
        ECLiveImageUtils.g(r108, r106.f519237j.getBorderImageUrl());
        Query r110 = w().b(R.id.tv_index);
        if (r106.f519235h == false) goto L31;
        r110.g(0);
        r110.e(String.valueOf(r106.f519237j.getIronIndex()));
        if ((r110 instanceof TextView) == false) goto L28;
        r101 = r110;
    L28:
        TextView r111 = (TextView) r101;
        if (r111 == null) goto L32;
        c0.b(r111, 500);
    L32:
        int r112 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.f149355a;
        final AbsECScrollProductCardBaseVideModel r113 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(u(), this.f149296g, this.f149297h);
        w().f().getViewTreeObserver().addOnPreDrawListener(this);
        f.a(w(), new ECSimpleProductCardPresenter$onBind$4(this, r113, r106));
        return;
    L31:
        r110.c();
        goto L32
    L5:
        r102 = r100;
        goto L6
    }

    public ECSimpleProductCardPresenter(String r100, ViewModelProvider.Factory r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this.f149296g = r100;
        this.f149297h = r101;
        this.f149295f = new Rect();
    }
}
