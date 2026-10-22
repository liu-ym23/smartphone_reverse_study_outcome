package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.b1;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class StatusPresenter extends p implements q83.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f152420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.view.countdown.c f152421h;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatusPresenter f152422a;

        public b(StatusPresenter r100) {
            this.f152422a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ECUIPromotion r101 = (ECUIPromotion) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isAuction() == true) goto L9;
            this.f152422a.E(r101);
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatusPresenter f152424a;

        public c(StatusPresenter r100) {
            this.f152424a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            pk2.d r101 = (pk2.d) r100;
            if (r101.f529590b != 2) goto L6;
            this.f152424a.w().f().animate().alpha(0.0f).setDuration(500).setInterpolator(new FastOutSlowInInterpolator()).start();
        L6:
            if (r101.f529590b != 0) goto L9;
            this.f152424a.w().f().setAlpha(1.0f);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r100 = this.f152421h;
        if (r100 == null) goto L12;
        monitor-enter(r100);
        boolean r101 = r100.f153216b;     // Catch: Throwable -> L9
        monitor-exit(r100);
        if (r101 == false) goto L12;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L17;
        r100 = null;
    L17:
        if (r100 == null) goto L22;
        r100.a();
        this.f152421h = null;
        return;
    L22:
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r102 = false;
        goto L14
    }

    public StatusPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 == null) goto L7;
        QLiveData<ECUIPromotion> r102 = r101.getPromotionState();
        if (r102 == null) goto L7;
        r102.b(r100.getLifecycleOwner(), new b(this));
    L7:
        w().b(R.id.iv_close).a(new StatusPresenter$bind$2(this));
        c0.b((TextView) w().b(R.id.tv_up_desc).f(), 500);
        com.bytedance.android.livesdk.livecommerce.utils.a.a(w().b(R.id.iv_close).f(), th.a.g(u().c(), R.string.ec_close));
        ExplainCardViewModel r103 = this.f152468e;
        if (r103 == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.largemode.b r104 = r103.getLargeModeAdapter();
        if (r104 == null) goto L14;
        ComponentLargeModeConfig r105 = r104.b("ExplainCard", "ExplainCard.TopArea");
        if (r105 == null) goto L14;
        int r106 = LargeModeConfigHelper.f149249a;
        LargeModeConfigHelper.a(r105, w().f());
    L14:
        ExplainCardViewModel r107 = this.f152468e;
        if (r107 == null) goto L21;
        com.bytedance.android.livesdk.livecommerce.largemode.b r108 = r107.getLargeModeAdapter();
        if (r108 == null) goto L21;
        ComponentLargeModeConfig r109 = r108.b("ExplainCard", "ExplainCard.TopArea.Close");
        if (r109 == null) goto L21;
        int r110 = LargeModeConfigHelper.f149249a;
        LargeModeConfigHelper.a(r109, w().b(R.id.iv_close).f());
    L21:
        View r111 = w().b(R.id.layout_tag_1).f();
        ExplainCardViewModel r112 = this.f152468e;
        if (r112 == null) goto L28;
        com.bytedance.android.livesdk.livecommerce.largemode.b r113 = r112.getLargeModeAdapter();
        if (r113 == null) goto L28;
        ComponentLargeModeConfig r114 = r113.b("ExplainCard", "ExplainCard.TopArea.Tag");
        if (r114 == null) goto L28;
        LargeModeConfigHelper.a(r114, r111);
    L28:
        ExplainCardViewModel r115 = this.f152468e;
        if (r115 == null) goto L35;
        com.bytedance.android.livesdk.livecommerce.largemode.b r116 = r115.getLargeModeAdapter();
        if (r116 == null) goto L35;
        ComponentLargeModeConfig r117 = r116.b("ExplainCard", "ExplainCard.TopArea.Tag.Text");
        if (r117 == null) goto L35;
        int r118 = LargeModeConfigHelper.f149249a;
        LargeModeConfigHelper.a(r117, r111.findViewById(R.id.tv_up_desc));
    L35:
        View r119 = w().b(R.id.layout_tag_2).f();
        ExplainCardViewModel r120 = this.f152468e;
        if (r120 == null) goto L42;
        com.bytedance.android.livesdk.livecommerce.largemode.b r121 = r120.getLargeModeAdapter();
        if (r121 == null) goto L42;
        ComponentLargeModeConfig r122 = r121.b("ExplainCard", "ExplainCard.TopArea.Tag");
        if (r122 == null) goto L42;
        LargeModeConfigHelper.a(r122, r119);
    L42:
        ExplainCardViewModel r123 = this.f152468e;
        if (r123 == null) goto L49;
        com.bytedance.android.livesdk.livecommerce.largemode.b r124 = r123.getLargeModeAdapter();
        if (r124 == null) goto L49;
        ComponentLargeModeConfig r125 = r124.b("ExplainCard", "ExplainCard.TopArea.Tag.Text");
        if (r125 == null) goto L49;
        int r126 = LargeModeConfigHelper.f149249a;
        LargeModeConfigHelper.a(r125, r119.findViewById(R.id.tv_up_desc));
    L49:
        ExplainCardViewModel r127 = this.f152468e;
        if (r127 == null) goto L55;
        QLiveData<pk2.d> r128 = r127.getCardExtendInfoState();
        if (r128 == null) goto L56;
        r128.b(r100.getLifecycleOwner(), new c(this));
        return;
    L56:
        return;
    }

    public final void E(ECUIPromotion r210) {
        ECUICampaign r100 = r210.campaign;
        boolean r101 = false;
        w().b(R.id.layout_tag_1).f().setVisibility(0);
        w().b(R.id.layout_tag_2).f().setVisibility(8);
        Query r102 = w().b(R.id.tv_up_desc);
        r102.g(8);
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r103 = this.f152421h;
        if (r103 == null) goto L13;
        monitor-enter(r103);
        boolean r104 = r103.f153216b;     // Catch: Throwable -> L9
        monitor-exit(r103);
        if (r104 == false) goto L13;
        boolean r105 = true;
    L14:
        String r110 = null;
        if (r105 == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L20;
        r103.a();
        this.f152421h = null;
    L20:
        if (r100 == null) goto L22;
        Boolean r106 = r100.isSecKill();
    L24:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L44;
        boolean r107 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.f152505a;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a(r100.startTime, r100.endTime) == false) goto L44;
        long r111 = r100.startTime;
        long r112 = r100.endTime;
        Handler r108 = com.bytedance.android.livesdk.livecommerce.utils.k.f153092a;
        long r113 = SystemClock.elapsedRealtime();
        if (r111 <= r113) goto L30;
    L32:
        boolean r109 = false;
    L33:
        if (r109 == false) goto L44;
        if (r210.getStatus() == 2) goto L44;
        if (r210.isPriceDeduce() == true) goto L44;
        if (r100.fakeSecKill == true) goto L44;
        View r114 = r102.f450937b;
        if ((r114 instanceof TextView) == false) goto L43;
        ((TextView) r114).setTextSize(1, 10.0f);
    L43:
        r102.g(0);
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r115 = new com.bytedance.android.livesdk.livecommerce.view.countdown.c(this);
        r115.c();
        this.f152421h = r115;
        boolean r116 = true;
    L45:
        String r117 = r210.qIvIcon;
        String r118 = r210.upDesc;
        boolean r119 = !r116;
        RitTagTrack r120 = r210.getUpIconTagTrack();
        Query r121 = w().b(R.id.layout_tag_1);
        Query r122 = r121.b(R.id.iv_activity_tag);
        Query r123 = r121.b(R.id.tv_up_desc);
        if (r120 == null) goto L49;
        r120.setVisibile(true);
    L49:
        if ((!Intrinsics.areEqual(r117, this.f152420g)) == false) goto L69;
        this.f152420g = r117;
        if (r117 != null) goto L53;
    L56:
        boolean r124 = true;
    L57:
        if (r124 == false) goto L59;
        r122.c();
        goto L69
    L59:
        r122.g(0);
        GenericDraweeView r125 = (GenericDraweeView) r122.f();
        ImageExtensionsKt.D(r125, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_up_view"));
        b0 r126 = new b0(this);
        if (TextUtils.isEmpty(r117) == true) goto L69;
        if (com.bytedance.android.ec.core.utils.y.m() == false) goto L65;
        ImageExtensionsKt.s(r125, r117, null, null, null, null, null, null, r126, true, null, null, null);
        goto L69
    L65:
        com.bytedance.android.ec.core.imagex.r r127 = com.bytedance.android.ec.core.utils.y.j(r125);
        AbstractDraweeController r128 = Fresco.newDraweeControllerBuilder().setOldController(r125.getController()).setControllerListener(r126).setCallerContext(r127).setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r117)).build()).build();
        if ((r127 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L68;
        ((com.bytedance.android.ec.core.imagex.u) r127).k();
    L68:
        r125.setController(r128);
        goto L69
    L53:
        if (r117.length() == 0) goto L56;
        r124 = false;
    L69:
        if (r119 == false) goto L78;
        HashMap<String, JSONObject> r129 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r118) == false) goto L76;
        r123.e(r118);
        View r130 = r123.f450937b;
        if ((r130 instanceof TextView) == false) goto L75;
        ((TextView) r130).setTextSize(1, 9.0f);
    L75:
        r123.g(0);
        goto L78
    L76:
        r123.c();
    L78:
        if (r123.d() == true) goto L82;
        View r131 = r121.f450937b;
        if (r131 == null) goto L83;
        r131.setBackgroundColor(r131.getContext().getResources().getColor(R.color.ec_color_transparent));
    L83:
        ECCurrentPromotion.a r132 = r210.publicArea;
        if (r132 == null) goto L86;
        r110 = r132.noticeText;
    L86:
        if (r110 != null) goto L88;
    L89:
        r101 = true;
    L90:
        if (r101 == true) goto L97;
        ExplainCardViewModel r133 = this.f152468e;
        if (r133 == null) goto L98;
        r133.postNoFilterNoticeEvent(r110);
        return;
    L98:
        return;
    L97:
        return;
    L88:
        if (r110.length() != 0) goto L90;
    L82:
        r121.f().setBackgroundResource(R.drawable.ec_bg_promotion_card_status_tag);
        goto L83
    L30:
        if ((r112 - r113) > BaseConstants.Time.DAY) goto L32;
        r109 = true;
    L44:
        r116 = false;
        goto L45
    L22:
        r106 = null;
    L9:
        th = move-exception;
        throw th;
    L13:
        r105 = false;
        goto L14
    }

    @Override // q83.a
    public final boolean onTick(long r110) {
        ExplainCardViewModel r100 = this.f152468e;
        if (r100 == null) goto L45;
        QLiveData<ECUIPromotion> r101 = r100.getPromotionState();
        if (r101 == null) goto L45;
        ECUIPromotion r102 = r101.a();
        if (r102 == null) goto L45;
        Query r103 = w().b(R.id.tv_up_desc);
        if (r102.isSecKill().booleanValue() == false) goto L43;
        if (r102.campaign.endTime <= r110) goto L43;
        if (r103.d() == false) goto L43;
        int r104 = b1.f153065e;
        Context r105 = u().c();
        long r106 = r102.campaign.endTime - r110;
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        b1 r111 = new b1();
        if (r106 <= 0) goto L37;
        long r107 = r106 / ((long) 1000);
        int r108 = ((int) r107) % 60;
        long r109 = 60;
        long r112 = r107 / r109;
        int r113 = ((int) r112) % 60;
        int r114 = (int) (r112 / r109);
        int r115 = r114 % 24;
        int r116 = r114 / 24;
        if (r116 <= 0) goto L21;
        String.valueOf(r116);
    L21:
        if (r115 >= 10) goto L23;
        String r117 = th.a.h(r105, R.string.sec_kill_zero_placeholder, new Object[]{Integer.valueOf(r115)});
    L24:
        r111.f153066a = r117;
        if (r113 >= 10) goto L27;
        String r118 = th.a.h(r105, R.string.sec_kill_zero_placeholder, new Object[]{Integer.valueOf(r113)});
    L28:
        r111.f153067b = r118;
        if (r108 >= 10) goto L31;
        String r119 = th.a.h(r105, R.string.sec_kill_zero_placeholder, new Object[]{Integer.valueOf(r108)});
    L32:
        r111.f153068c = r119;
        if (r116 <= 0) goto L35;
        String r120 = th.a.h(r105, R.string.sec_kill_day_placeholder, new Object[]{Integer.valueOf(r116), r111.f153066a, r111.f153067b, r111.f153068c});
    L36:
        r111.f153069d = r120;
    L38:
        String r121 = r111.f153069d;
        if (r121 == null) goto L41;
        w().b(R.id.tv_up_desc).e(r121);
    L41:
        return true;
    L35:
        r120 = th.a.h(r105, R.string.sec_kill_time_placeholder, new Object[]{r111.f153066a, r111.f153067b, r119});
        goto L36
    L31:
        r119 = String.valueOf(r108);
        goto L32
    L27:
        r118 = String.valueOf(r113);
        goto L28
    L23:
        r117 = String.valueOf(r115);
        goto L24
    L37:
        r111.f153066a = th.a.g(r105, R.string.sec_kill_time_error);
        r111.f153067b = th.a.g(r105, R.string.sec_kill_time_error);
        r111.f153068c = th.a.g(r105, R.string.sec_kill_time_error);
    L43:
        if (r103.d() == false) goto L45;
        E(r102);
    L45:
        return false;
    }
}
