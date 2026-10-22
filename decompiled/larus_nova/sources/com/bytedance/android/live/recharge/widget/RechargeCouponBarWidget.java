package com.bytedance.android.live.recharge.widget;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.config.GemExchangeCouponConfig;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeCouponBarWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCouponBarWidget extends AbsRechargeWidget {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f90615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f90616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ConstraintLayout f90617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zy0.d f90618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f90619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RechargeDialogContext f90620n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeCouponBarWidget f90621a;

        public b(RechargeCouponBarWidget r100) {
            this.f90621a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            com.bytedance.android.live.recharge.deal.f r102 = this.f90621a.f90620n.getSelectedDeal();
            if (r102 == null) goto L8;
            ConstraintLayout r103 = this.f90621a.f90617k;
            if (r103 == null) goto L9;
            r103.post(new j(r102, this));
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_recharge_coupon_bar_widget;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        zy0.d r100 = this.f90618l;
        if (r100 == null) goto L7;
        xy0.a<?> r101 = r100.g();
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        this.f90619m = 0;
    }

    public RechargeCouponBarWidget(RechargeDialogContext r100) {
        Intrinsics.checkNotNullParameter(r100, "rechargeContext");
        super(r100);
        this.f90620n = r100;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f90617k = (ConstraintLayout) findViewById(R.id.coupon_root);
        this.f90615i = (TextView) findViewById(R.id.coupon_title);
        this.f90616j = (TextView) findViewById(R.id.coupon_subtitle);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        RxUtilKt.c(this.f90620n.getDealsSelectedEvent().subscribe(new b(this)), this.f90575d);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r110) {
        Intrinsics.checkNotNullParameter(r110, "dealSet");
        com.bytedance.android.live.recharge.model.diamond.d r100 = r110.getBizExtra().getGemExchangeCouponInfo();
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r101 = r110.getPanelExtraInfo();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r104 = r103.next();
        if (com.bytedance.android.live.recharge.platform.business.model.diamond.j.a(r104.getValue()) == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        Object r105 = null;
        if ((!r102.isEmpty()) == false) goto L23;
        this.f90619m = 1;
        Iterator<T> r106 = r110.c().iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        if (((com.bytedance.android.live.recharge.deal.u) r107).f89764b != r110.d()) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L12;
        r105 = r107;
        goto L19
    L16:
        r108 = false;
    L19:
        com.bytedance.android.live.recharge.deal.u r109 = (com.bytedance.android.live.recharge.deal.u) r105;
        if (r109 == null) goto L58;
        zq(r109);
        return;
    L58:
        return;
    L23:
        if (r100.getCanShow() == true) goto L25;
    L44:
        ConstraintLayout r111 = this.f90617k;
        if (r111 == null) goto L62;
        UtilityKotlinExtentionsKt.z(r111, false);
        return;
    L62:
        return;
    L25:
        if (r100.getMainTitle().length() <= 0) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L44;
        this.f90619m = 2;
        com.bytedance.android.live.recharge.model.diamond.d r113 = r110.getBizExtra().getGemExchangeCouponInfo();
        GemExchangeCouponConfig r114 = (GemExchangeCouponConfig) com.bytedance.android.live.recharge.utils.t.f90519p.getValue(null, com.bytedance.android.live.recharge.utils.t.f90504a[14]);
        ConstraintLayout r115 = this.f90617k;
        if (r115 == null) goto L32;
        UtilityKotlinExtentionsKt.z(r115, true);
    L32:
        TextView r116 = this.f90615i;
        if (r116 == null) goto L35;
        r116.setText(r114.getTitle());
    L35:
        TextView r117 = this.f90616j;
        if (r117 == null) goto L38;
        r117.setText(r113.getMainTitle());
    L38:
        TextView r118 = this.f90616j;
        if (r118 == null) goto L41;
        r118.setTextColor(s1.h(R.color.ttlive_recharge_dialog_text_hint_highlight));
    L41:
        ConstraintLayout r119 = this.f90617k;
        if (r119 == null) goto L60;
        r119.setOnClickListener(new k(this, r114, r110));
        return;
    L60:
        return;
    L27:
        r112 = false;
        goto L28
    }

    public final void zq(com.bytedance.android.live.recharge.deal.f r100) {
        Intrinsics.checkNotNullParameter(r100, "deal");
        if (this.f90619m == 1) goto L6;
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L11;
        ConstraintLayout r101 = this.f90617k;
        if (r101 == null) goto L82;
        UtilityKotlinExtentionsKt.z(r101, false);
        return;
    L82:
        return;
    L11:
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r102 = com.bytedance.android.live.recharge.deal.g.c(r100);
        if (r102 == null) goto L75;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r103 = r102.getCouponBarInfo();
        if (r103 == null) goto L16;
        String r104 = r103.getTitle();
    L17:
        if (r104 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L36;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r106 = r102.getCouponBarInfo();
        if (r106 == null) goto L27;
        String r107 = r106.getDesc();
    L28:
        if (r107 != null) goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == true) goto L36;
        boolean r109 = true;
    L37:
        if (r109 == true) goto L40;
        r102 = null;
    L40:
        if (r102 == null) goto L75;
        ConstraintLayout r110 = this.f90617k;
        if (r110 == null) goto L44;
        UtilityKotlinExtentionsKt.z(r110, true);
    L44:
        TextView r111 = this.f90615i;
        if (r111 == null) goto L51;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r112 = r102.getCouponBarInfo();
        if (r112 == null) goto L49;
        String r113 = r112.getTitle();
    L50:
        r111.setText(r113);
        goto L51
    L49:
        r113 = null;
    L51:
        TextView r114 = this.f90616j;
        if (r114 == null) goto L58;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r115 = r102.getCouponBarInfo();
        if (r115 == null) goto L56;
        String r116 = r115.getDesc();
    L57:
        r114.setText(r116);
        goto L58
    L56:
        r116 = null;
    L58:
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r117 = r102.getCouponBarInfo();
        if (r117 == null) goto L63;
        Integer r118 = r117.getDescStyle();
        if (r118 == null) goto L63;
        int r119 = r118.intValue();
    L64:
        TextView r120 = this.f90616j;
        if (r120 == null) goto L73;
        if (r119 != 1) goto L68;
        int r121 = s1.h(R.color.ttlive_recharge_diamond_unit_color);
    L72:
        r120.setTextColor(r121);
        Unit r122 = Unit.INSTANCE;
    L74:
        if (r122 == null) goto L75;
    L78:
        String r123 = (String) com.bytedance.android.live.recharge.util.g.f90437h.getValue(null, com.bytedance.android.live.recharge.util.g.f90430a[6]);
        ConstraintLayout r124 = this.f90617k;
        if (r124 == null) goto L83;
        r124.setOnClickListener(new RechargeCouponBarWidget$onDealSelected$3(this, r123, r100));
        return;
    L83:
        return;
    L68:
        if (r119 == 2) goto L70;
        r121 = s1.h(R.color.ttlive_recharge_dialog_text_hint_transport);
        goto L72
    L70:
        r121 = s1.h(R.color.ttlive_recharge_dialog_text_hint_highlight);
        goto L72
    L73:
        r122 = null;
    L63:
        r119 = 0;
        goto L64
    L30:
        if (r107.length() == 0) goto L33;
        r108 = false;
        goto L34
    L27:
        r107 = null;
    L36:
        r109 = false;
        goto L37
    L19:
        if (r104.length() == 0) goto L22;
        r105 = false;
        goto L23
    L16:
        r104 = null;
    L75:
        ConstraintLayout r125 = this.f90617k;
        if (r125 == null) goto L78;
        UtilityKotlinExtentionsKt.z(r125, false);
        Unit r126 = Unit.INSTANCE;
        goto L78
    }
}
