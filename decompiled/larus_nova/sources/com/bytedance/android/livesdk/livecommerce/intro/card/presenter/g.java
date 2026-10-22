package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardButtonComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.k0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hl.m;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g extends oh2.a implements com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IntroPromotionVO f147897i;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f147898a;

        public a(g r100) {
            this.f147898a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IntroPromotionVO r101 = (IntroPromotionVO) r100;
            this.f147898a.f147897i = r101;
            if (r101 == null) goto L11;
            k0 r102 = r101.getPurchase();
            if (r102 == null) goto L13;
            g r103 = this.f147898a;
            s0 r104 = r101.getControl();
            if (r104 == null) goto L9;
            Integer r105 = Integer.valueOf(r104.d());
        L10:
            ((IntroCardButtonComponent) r103.w().f()).a(r102, r105);
            return;
        L9:
            r105 = null;
            goto L10
        L13:
            return;
        L11:
            Unit r106 = Unit.INSTANCE;
        }
    }

    public g() {
        super(0);
    }

    @Override // oh2.a, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
    }

    @Override // oh2.a
    public final void D(oh2.h r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ((IntroCardButtonComponent) w().f()).setPresenter(this);
        IntroCardViewModel r101 = this.f523246e;
        if (r101 == null) goto L8;
        bk2.e<IntroPromotionVO> r102 = r101.getCardState();
        if (r102 == null) goto L9;
        r102.b(r100.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a
    public final void h(View r210, l0 r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r211, "purchaseButton");
        com.bytedance.android.ec.core.utils.s0.a(new m());
        oh2.e r100 = this.f523247f;
        String r101 = null;
        if (r100 == null) goto L7;
        oh2.d r102 = r100.f523255d;
        if (r102 == null) goto L7;
        LiveActionTracker r103 = r102.b(null);
    L8:
        IntroPromotionVO r104 = this.f147897i;
        if (r104 == null) goto L13;
        IntroProduct r105 = r104.getProduct();
        if (r105 == null) goto L13;
        String r106 = r105.i();
    L14:
        IntroPromotionVO r107 = this.f147897i;
        if (r107 == null) goto L19;
        IntroProduct r108 = r107.getProduct();
        if (r108 == null) goto L19;
        String r109 = r108.g();
    L20:
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r110 = r211.a();
        if (r110 == null) goto L23;
        boolean r111 = true;
    L24:
        xh.a r112 = xh.c.a("Live");
        Pair[] r113 = new Pair[3];
        r113[0] = TuplesKt.to("button_enabled", String.valueOf(!r111));
        if (r106 != null) goto L27;
        r106 = "";
    L27:
        r113[1] = TuplesKt.to("promotion_id", r106);
        if (r109 != null) goto L30;
        r109 = "";
    L30:
        r113[2] = TuplesKt.to("product_id", r109);
        r112.d("good_list", "cell_action_button", MapsKt.mapOf(r113));
        if (r103 == null) goto L33;
        il2.a.C6280a.a(r103, DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_CARD, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "button")), false, null, null, null, 60);
    L33:
        oh2.e r114 = this.f523247f;
        if (r114 == null) goto L38;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r115 = r114.f523253b;
        if (r115 == null) goto L38;
        r115.b();
        String r116 = "a1128.b3295.c59667.d30614";
    L40:
        if (r116 != null) goto L42;
        String r117 = "";
    L43:
        BtmItemBuilder r118 = new BtmItemBuilder(r117, Boolean.TRUE).withView(r210);
        com.bytedance.android.btm.api.model.d r119 = BtmUtilsKt.e(r116, PageFinder.via(r210));
        if (r103 == null) goto L46;
        r103.f150736g = r119;
    L46:
        if (r111 == true) goto L60;
        oh2.c r120 = this.f523248g;
        if (r120 == null) goto L55;
        oh2.e r121 = this.f523247f;
        if (r121 == null) goto L54;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r122 = r121.f523253b;
        if (r122 == null) goto L54;
        r122.b();
        r101 = "a1128.b3295.c59667.d30614";
    L54:
        oh2.c.a.b(r120, "button", false, r101, r210);
    L55:
        if (r103 == null) goto L73;
        il2.a r123 = il2.a.C6280a.a(r103, "check_buy_btn", null, false, "buy_btn_disable", null, null, 48);
        if (r123 == null) goto L74;
        ((LiveActionTracker) r123).e(false);
        return;
    L74:
        return;
    L73:
        return;
    L60:
        if (r110 != null) goto L62;
        return;
    L62:
        oh2.c r124 = this.f523248g;
        if (r124 == null) goto L66;
        r124.a("button", true, r116, r118, r210);
    L66:
        if (r103 == 0) goto L69;
        il2.a.C6280a.a(r103, "check_buy_btn", MapsKt.mapOf(TuplesKt.to("action", r110)), false, null, null, null, 60);
    L69:
        oh2.c r125 = this.f523248g;
        if (r125 == null) goto L75;
        oh2.c.a.a(r125, u().c(), "button", 1, r110, r119, BtmSDK.INSTANCE.getPageId(PageFinder.via(r210)), r103);
        return;
    L75:
        return;
    L42:
        r117 = r116;
    L38:
        r116 = null;
        goto L40
    L23:
        r111 = false;
    L19:
        r109 = null;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }
}
