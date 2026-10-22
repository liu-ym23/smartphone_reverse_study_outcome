package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.ec.window.base.view.ECWindowLiveCircleView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowBaseInfoPresenterBase;", "Lcom/bytedance/android/window/shop/home/presenter/ECWindowInfoPresenterBase;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowBaseInfoPresenterBase extends ECWindowInfoPresenterBase {
    public static final /* synthetic */ int H = 0;
    public final int F;
    public final int G;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowBaseInfoPresenterBase f188266a;

        public a(ECWindowBaseInfoPresenterBase r100) {
            this.f188266a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            uq3.a r101 = (uq3.a) r100;
            if (r101 == null) goto L28;
            ECWindowBaseInfoPresenterBase r102 = this.f188266a;
            int r103 = ECWindowBaseInfoPresenterBase.H;
            if (r102.F() == false) goto L23;
            uq3.o r104 = r101.f551204c;
            if (r104 == null) goto L11;
            WindowV3LiveRoomVO r105 = r104.f551255f;
        L12:
            if (r105 == null) goto L23;
            if (r102.O().isCroppedStyle() == false) goto L17;
        L19:
            SimpleDraweeView r106 = r102.f188405v;
            if (r106 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("headImg");
        L22:
            r106.setOnClickListener(r102);
            goto L23
        L17:
            if (r102.d0() == true) goto L19;
            ECWindowLiveCircleView r107 = (ECWindowLiveCircleView) r102.w().b(R.id.ec_window_head_live_circle_big).f();
            r107.setVisibility(0);
            r107.a();
            r102.w().b(R.id.ec_window_head_live_diagram).f().setVisibility(0);
            goto L19
        L11:
            r105 = null;
        L23:
            ECWindowBaseInfoPresenterBase r108 = this.f188266a;
            View r109 = r108.w().b(R.id.ec_shop_info_area_follow).f();
            View r110 = r108.w().b(R.id.ll_shop_name).f();
            View r111 = r108.w().b(R.id.iv_shop_user_wrapper).f();
            wg.a.c(r109);
            r108.O().getTopBarInfoParam().getClass();
            r108.O().getTopBarInfoParam().getClass();
            wg.a.c(r110);
            r108.O().getTopBarInfoParam().getClass();
            r108.O().getTopBarInfoParam().getClass();
            wg.a.c(r111);
            r108.O().getTopBarInfoParam().getClass();
            r108.O().getTopBarInfoParam().getClass();
            com.bytedance.android.window.shop.home.f r112 = r108.O().getTopBarInfoParam();
            r111.getHeight();
            r112.getClass();
            com.bytedance.android.window.shop.home.f r113 = r108.O().getTopBarInfoParam();
            r111.getWidth();
            r113.getClass();
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r114 = this.f188266a.O().getPipeline();
            if (r114 == null) goto L27;
            r114.b(WindowLaunchTask.f187753h, Unit.INSTANCE);
            return;
        L27:
            return;
        }
    }

    public ECWindowBaseInfoPresenterBase() {
        this.F = (int) BodyPartID.bodyIdMax;
        this.G = 654301398;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final void i0() {
        if (F() == false) goto L8;
        Function3<String, Boolean, String, Unit> r100 = O().getJump2Live();
        if (r100 == null) goto L7;
        Unit r101 = r100.invoke("live_cell_head", Boolean.FALSE, null);
    L7:
        k0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "1031")));
        return;
    L8:
        h0();
        k0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "1032")));
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final int b0() {
        return this.G;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final int c0() {
        return this.F;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        super.A(r100);
        O().getHeaderResponse().a(U(), new a(this), false);
    }

    public final void k0(String r110, Map<String, String> r111) {
        uq3.a r112 = O().getHeaderResponse().getValue();
        String r100 = null;
        if (r112 == null) goto L5;
        uq3.o r113 = r112.f551204c;
    L6:
        uq3.a r101 = O().getHeaderResponse().getValue();
        if (r101 == null) goto L24;
        uq3.o r102 = r101.f551204c;
        if (r102 == null) goto L24;
        if (r102.f551270u != true) goto L24;
        if (r113 == null) goto L14;
        List<uq3.p> r103 = r113.f551267r;
    L15:
        List<uq3.p> r104 = r103;
        if (r104 != null) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == true) goto L24;
        boolean r106 = true;
    L25:
        if (r113 == null) goto L27;
        ECUrlModel r107 = r113.f551256g;
    L28:
        if (r107 == null) goto L30;
        String r108 = "101";
    L31:
        ECWindowViewModel r109 = O();
        Pair<String, String>[] r114 = new Pair[8];
        r114[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        if (r113 == null) goto L36;
        uq3.k r115 = r113.f551268s;
        if (r115 == null) goto L36;
        String r116 = r115.f551239a;
    L37:
        r114[1] = TuplesKt.to("fans_cnt", r116);
        Integer r117 = O().getShopParam().getFollowStatus();
        if (r117 == null) goto L40;
        String r118 = String.valueOf(r117.intValue());
    L41:
        r114[2] = TuplesKt.to("follow_status", r118);
        r114[3] = TuplesKt.to("author_id", O().getShopParam().getAuthorId());
        r114[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, O().getEntranceInfo());
        if (r113 == null) goto L48;
        WindowAuthorReputationVO r119 = r113.f551254e;
        if (r119 == null) goto L48;
        Double r120 = r119.getScore();
        if (r120 == null) goto L48;
        r100 = String.valueOf(r120.doubleValue());
    L48:
        r114[5] = TuplesKt.to("experience_score", r100);
        if (r106 == false) goto L51;
        String r121 = "1";
    L52:
        r114[6] = TuplesKt.to("is_fans_comment", r121);
        r114[7] = TuplesKt.to("background_picture_type", r108);
        r109.doEventAction("store_experience_score_click", r111, r114);
        return;
    L51:
        r121 = "0";
        goto L52
    L40:
        r118 = null;
    L36:
        r116 = null;
        goto L37
    L30:
        r108 = BDLocationException.ERROR_UID_IS_EMPTY;
        goto L31
    L27:
        r107 = null;
        goto L28
    L18:
        if (r104.isEmpty() == true) goto L21;
        r105 = false;
        goto L22
    L14:
        r103 = null;
    L24:
        r106 = false;
        goto L25
    L5:
        r113 = null;
        goto L6
    }
}
