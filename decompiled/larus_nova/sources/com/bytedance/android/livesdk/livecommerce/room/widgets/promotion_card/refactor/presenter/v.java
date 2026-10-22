package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPopExtendInfo;
import com.bytedance.android.ec.model.response.ExtendInfoTopContent;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class v extends p {

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExplainCardViewModel f152489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f152490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c f152491c;

        public a(ExplainCardViewModel r100, v r101, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r102) {
            this.f152489a = r100;
            this.f152490b = r101;
            this.f152491c = r102;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            pk2.d r111 = (pk2.d) r110;
            if (r111.f529590b != 2) goto L42;
            v r100 = this.f152490b;
            ECPopExtendInfo r112 = r111.f529589a;
            if (r112 == null) goto L9;
            ExtendInfoTopContent r113 = r112.getTopContent();
            if (r113 == null) goto L9;
            List<com.bytedance.android.ec.model.live.b> r114 = r113.getContent();
        L11:
            if (r114 == null) goto L15;
            r100.getClass();
            if ((!r114.isEmpty()) != true) goto L15;
            boolean r101 = true;
        L16:
            View r102 = r100.w().b(R.id.layout_small_card_info).f();
            int r103 = 8;
            if (r101 == false) goto L19;
            int r104 = 8;
        L20:
            r102.setVisibility(r104);
            ECCustomizedElementView r105 = (ECCustomizedElementView) r100.w().b(R.id.cev_small_card_top_content).f();
            if (r101 == false) goto L23;
            r103 = 0;
        L23:
            r105.setVisibility(r103);
            if (r101 == false) goto L28;
            if (r114 != null) goto L27;
            r114 = CollectionsKt.emptyList();
        L27:
            r105.b(r114, true);
        L28:
            ECDraweeView r106 = (ECDraweeView) this.f152490b.w().b(R.id.dv_small_card_cover).f();
            ECUIPromotion r115 = this.f152489a.getPromotionState().a();
            if (r115 == null) goto L41;
            h0.e(r106, r115.getImageUrl(), new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_view"), null, null, 120);
            if (r115.getStatus() != 1) goto L33;
        L40:
            this.f152490b.w().b(R.id.v_small_card_cover_mask).c();
            goto L41
        L33:
            if (r115.getStatus() == 7000) goto L40;
            if (r115.getStatus() == 8000) goto L40;
            if (r115.getStatus() == 9000) goto L40;
            this.f152490b.w().b(R.id.v_small_card_cover_mask).g(0);
        L41:
            this.f152490b.y().postDelayed(new u(this), 300);
            return;
        L19:
            r104 = 0;
        L15:
            r101 = false;
        L9:
            r114 = null;
            goto L11
        L42:
            this.f152490b.w().f().setBackgroundColor(0);
            this.f152490b.w().g(4);
        }
    }

    public v() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 == null) goto L6;
        r101.getCardExtendInfoState().b(r100.getLifecycleOwner(), new a(r101, this, r100));
        return;
    }
}
