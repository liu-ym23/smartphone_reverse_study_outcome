package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftRechargeViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeIconParams;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeViewParams;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIRechargeView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftRechargeViewState, GiftAction> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f127569w = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f127570m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f127571n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f127572o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f127573p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f127574q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f127575r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f127576s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public zv0.b f127577t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public HSImageView f127578u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DataCenter f127579v;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        int r100 = 0;
        p(0);
        this.f127570m = r().findViewById(R.id.bottom_bg_view);
        this.f127571n = (TextView) r().findViewById(R.id.recharge_view);
        this.f127572o = (HSImageView) r().findViewById(R.id.coin_icon);
        this.f127573p = r().findViewById(R.id.charge_layout);
        this.f127574q = r().findViewById(R.id.recharge_arrow);
        TextView r101 = (TextView) r().findViewById(R.id.income_to_coins_label);
        this.f127575r = r101;
        if (r101 == null) goto L5;
        r101.setText(s1.C(R.string.ttlive_gift_income_to_coins, new Object[]{r3.c()}));
    L5:
        this.f127576s = (TextView) r().findViewById(R.id.income_to_coins_num_tv);
        this.f127578u = (HSImageView) r().findViewById(R.id.anchor_panel_switch);
        View r102 = this.f127570m;
        if (r102 != null) goto L8;
    L13:
        View r103 = this.f127573p;
        if (r103 == null) goto L17;
        r103.setOnClickListener(new o0(this));
        return;
    L17:
        return;
    L8:
        if (u() == true) goto L10;
    L11:
        r100 = 8;
    L12:
        r102.setVisibility(r100);
        goto L13
    L10:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == false) goto L12;
        goto L11
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        zv0.b r100 = this.f127577t;
        if (r100 == null) goto L5;
        r100.onUnload();
    L5:
        this.f127577t = null;
    }

    public final void t() {
        TextView r100 = this.f127571n;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L7:
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r101 = null;
    L9:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.l(u(), null) == false) goto L19;
        View r103 = this.f127574q;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        if (r102 == null) goto L16;
        r102.rightMargin = s1.f(8.0f);
    L16:
        TextView r104 = this.f127571n;
        if (r104 == null) goto L28;
        r104.setLayoutParams(r102);
        return;
    L28:
        return;
    L19:
        View r105 = this.f127574q;
        if (r105 == null) goto L22;
        r105.setVisibility(0);
    L22:
        if (r102 == null) goto L24;
        r102.rightMargin = s1.f(20.0f);
    L24:
        TextView r106 = this.f127571n;
        if (r106 == null) goto L30;
        r106.setLayoutParams(r102);
        return;
    L30:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean u() {
        Boolean r100 = (Boolean) this.f127579v.get("data_is_portrait", Boolean.TRUE);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (PadConfigUtils.c() == false) goto L5;
        return R.layout.ttlive_base_gift_recharge_view_pad;
    L5:
        return R.layout.ttlive_base_gift_recharge_view;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIRechargeView$bindToParent$1 r101 = GiftMVIRechargeView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r210, MVIState r211) {
        GiftRechargeViewState r100 = (GiftRechargeViewState) r211;
        Intrinsics.checkNotNullParameter(r210, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r100, "state");
        com.bytedance.android.anya.r0<GiftRechargeViewState, RechargeViewParams> r101 = r100.getRechargeViewParams();
        Object r102 = r210.f41740c.a(r101);
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L50;
        r210.f41739b.f41563a.invoke(r101);
        RechargeViewParams r104 = (RechargeViewParams) r102;
        if (r104.getEnableAnchorPanelEntrance() == false) goto L22;
        View r105 = this.f127573p;
        if (r105 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r105);
    L9:
        TextView r106 = this.f127575r;
        if (r106 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r106);
    L12:
        TextView r107 = this.f127576s;
        if (r107 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r107);
    L15:
        HSImageView r108 = this.f127578u;
        if (r108 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r108);
    L18:
        HSImageView r109 = this.f127578u;
        if (r109 == null) goto L50;
        r109.setOnClickListener(new m0(this));
        goto L50
    L22:
        if (r104.getTouchText() == null) goto L24;
        ((ur2.a) vh6.c.b(ur2.a.class)).a4(r104.getTouchText(), RevRenderConfig.SyncDecodeContext, new n0(this, r104));
    L49:
        t();
        goto L50
    L24:
        TextView r110 = this.f127571n;
        if (r110 == null) goto L27;
        r110.setText(r104.getText());
    L27:
        View r111 = this.f127573p;
        if (r111 == null) goto L34;
        Object[] r112 = new Object[3];
        TextView r113 = this.f127571n;
        if (r113 == null) goto L32;
        CharSequence r114 = r113.getText();
    L33:
        r112[0] = r114;
        r112[1] = r3.c();
        r112[2] = e4.a();
        r111.setContentDescription(s1.C(R.string.ttlive_live_recharge_entrance_accessibility, r112));
        goto L34
    L32:
        r114 = null;
    L34:
        TextView r115 = this.f127571n;
        if (r115 == null) goto L37;
        r115.setTextSize(1, r104.getTextSize());
    L37:
        TextView r116 = this.f127571n;
        if (r116 == null) goto L40;
        r116.setTextColor(getContext().getResources().getColor(r104.getTextColorRes()));
    L40:
        String r117 = e4.a();
        TextView r118 = this.f127571n;
        if (r118 == null) goto L48;
        CharSequence r119 = r118.getText();
        if (r119 == null) goto L48;
        String r120 = r119.toString();
        if (r120 == null) goto L48;
        if (r120.equals(r117) == true) goto L49;
    L48:
        com.bytedance.android.livesdk.r3.c(this.f127573p, getContext().getString(R.string.ttlive_gift_panel_recharge_accessibility_desc, new Object[]{r104.getText(), e4.a()}), true);
    L50:
        com.bytedance.android.anya.r0<GiftRechargeViewState, RechargeIconParams> r121 = r100.getIconViewParams();
        Object r122 = r210.f41740c.a(r121);
        if (r122 == null) goto L61;
        r210.f41739b.f41563a.invoke(r121);
        RechargeIconParams r123 = (RechargeIconParams) r122;
        HSImageView r124 = this.f127572o;
        if (r124 == null) goto L55;
        r124.setVisibility(r123.getVisibility());
    L55:
        py.k r125 = r123.getImageModel();
        if (r125.isValid() == true) goto L59;
        r125 = null;
    L59:
        if (r125 == null) goto L61;
        ImageUtil.loadImage(this.f127572o, r125, 0);
    L61:
        com.bytedance.android.anya.r0<GiftRechargeViewState, Boolean> r126 = r100.getShowIncomeToCoins();
        Object r127 = r210.f41740c.a(r126);
        if (r127 == null) goto L108;
        r210.f41739b.f41563a.invoke(r126);
        boolean r128 = ((Boolean) r127).booleanValue();
        View r129 = this.f127573p;
        if (r129 == null) goto L66;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
    L68:
        if ((r130 instanceof ConstraintLayout.LayoutParams) == true) goto L70;
        r130 = null;
    L70:
        ConstraintLayout.LayoutParams r131 = (ConstraintLayout.LayoutParams) r130;
        if (r128 == true) goto L73;
        TextView r132 = this.f127575r;
        if (r132 == null) goto L99;
        r132.setVisibility(8);
    L99:
        TextView r133 = this.f127576s;
        if (r133 == null) goto L102;
        r133.setVisibility(8);
    L102:
        if (r131 == null) goto L104;
        ((ViewGroup.MarginLayoutParams) r131).rightMargin = s1.f(16.0f);
    L104:
        View r134 = this.f127573p;
        if (r134 == null) goto L107;
        r134.setLayoutParams(r131);
    L107:
        t();
        goto L108
    L73:
        if (this.f127575r == null) goto L108;
        if (this.f127576s == null) goto L108;
        ArrayList r135 = new ArrayList(2);
        TextView r136 = this.f127575r;
        if (r136 == null) goto L80;
        r135.add(r136);
    L80:
        TextView r137 = this.f127576s;
        if (r137 == null) goto L83;
        r135.add(r137);
    L83:
        IRechargeService r138 = (IRechargeService) jc1.k.n(IRechargeService.class);
        TextView r139 = this.f127575r;
        TextView r140 = this.f127576s;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.d.f126579g.getValue(null, com.bytedance.android.livesdk.gift.platform.business.d.f126573a[5])).booleanValue() == false) goto L87;
        Function1<Integer, Unit> r141 = GiftMVIRechargeView$incomeToCoinsEntranceOptimize$1.INSTANCE;
    L90:
        Function1<Integer, Unit> r142 = r141;
    L91:
        zv0.b r143 = r138.getCashExchangeDelegate(r139, r135, r140, r142, 2, getContext());
        this.f127577t = r143;
        if (r143 == null) goto L94;
        r143.setDataCenter(this.f127579v);
    L94:
        if (r131 == null) goto L104;
        ((ViewGroup.MarginLayoutParams) r131).rightMargin = s1.f(12.0f);
        goto L104
    L87:
        if (this.f127570m != null) goto L89;
        r142 = null;
        goto L91
    L89:
        r141 = new GiftMVIRechargeView$adjustContainerHeight$1(this);
        goto L90
    L66:
        r130 = null;
    L108:
        com.bytedance.android.anya.r0<GiftRechargeViewState, Boolean> r144 = r100.getShowExchangeDouyinDiamond();
        Object r145 = r210.f41740c.a(r144);
        if (r145 == null) goto L154;
        r210.f41739b.f41563a.invoke(r144);
        boolean r146 = ((Boolean) r145).booleanValue();
        View r147 = this.f127573p;
        if (r147 == null) goto L113;
        ViewGroup.LayoutParams r148 = r147.getLayoutParams();
    L115:
        if ((r148 instanceof ConstraintLayout.LayoutParams) == false) goto L118;
        r103 = r148;
    L118:
        ConstraintLayout.LayoutParams r149 = (ConstraintLayout.LayoutParams) r103;
        if (r146 == true) goto L121;
        TextView r150 = this.f127575r;
        if (r150 == null) goto L144;
        r150.setVisibility(8);
    L144:
        TextView r151 = this.f127576s;
        if (r151 == null) goto L147;
        r151.setVisibility(8);
    L147:
        if (r149 == null) goto L149;
        ((ViewGroup.MarginLayoutParams) r149).rightMargin = s1.f(16.0f);
    L149:
        View r152 = this.f127573p;
        if (r152 == null) goto L152;
        r152.setLayoutParams(r149);
    L152:
        t();
        return;
    L121:
        if (this.f127575r == null) goto L155;
        TextView r153 = this.f127576s;
        if (r153 == null) goto L156;
        r153.setVisibility(8);
        TextView r154 = this.f127575r;
        if (r154 == null) goto L129;
        r154.setVisibility(0);
    L129:
        if (Intrinsics.areEqual(r3.c(), "抖币") == false) goto L133;
        TextView r155 = this.f127575r;
        if (r155 == null) goto L136;
        r155.setText(s1.C(R.string.ttlive_gift_recharge_diamond_to_coins_old, new Object[]{r3.c()}));
    L136:
        if (r149 == null) goto L138;
        ((ViewGroup.MarginLayoutParams) r149).rightMargin = s1.f(12.0f);
    L138:
        TextView r156 = this.f127575r;
        if (r156 == null) goto L149;
        r156.setOnClickListener(new l0(this));
        goto L149
    L133:
        TextView r157 = this.f127575r;
        if (r157 == null) goto L136;
        r157.setText(s1.C(R.string.ttlive_gift_recharge_diamond_to_coins, new Object[]{r3.c()}));
        goto L136
    L156:
        return;
    L155:
        return;
    L113:
        r148 = null;
        goto L115
    }

    public GiftMVIRechargeView(Context r100, ViewGroup r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        super(r100, r101);
        this.f127579v = r102;
    }
}
