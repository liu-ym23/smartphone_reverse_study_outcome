package com.bytedance.android.livesdk.gift.vs.panel.view.v2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.j0;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.config.j;
import com.bytedance.android.livesdk.gift.platform.business.config.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.GiftTabTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.manager.PropManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/view/v2/LiveGiftBottomWidgetKt;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftBottomWidgetKt extends LiveRecyclableWidget implements View.OnClickListener {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f132447t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f132448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f132449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f132450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f132451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f132452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f132453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f132454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f132455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f132456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<b> f132457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f132458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f132459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f132460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f132461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public zv0.b f132462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a22.a f132463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f132464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f132465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final GiftViewModelManager f132466s;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f132467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f132468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f132469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f132470d;

        public b() {
        }
    }

    public final class c extends RecyclerView.Adapter<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGiftBottomWidgetKt f132471a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f132471a.f132457j).size();
        }

        public c(LiveGiftBottomWidgetKt r100) {
            this.f132471a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            if (r100 != 0) goto L5;
            return 0;
        L5:
            if (r100 != (getItemCount() - 1)) goto L7;
            return 2;
        L7:
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            d r102 = (d) r100;
            Intrinsics.checkNotNullParameter(r102, "liveGiftTabViewHolder");
            b r103 = (b) ListProtector.get(this.f132471a.f132457j, r101);
            if (r103 != null) goto L5;
            r102.getClass();
            return;
        L5:
            r102.f132472a.setGravity(48);
            r102.f132472a.setText(r103.f132467a);
            Pair r104 = (Pair) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, new Pair(Integer.valueOf(R.color.ttlive_gift_bottom_tab_selected_color), Integer.valueOf(R.color.ttlive_gift_bottom_tab_normal_color)));
            GiftTabTextView r105 = r102.f132472a;
            Resources r106 = r102.f132473b.context.getResources();
            if (r103.f132470d == false) goto L8;
            Object r107 = r104.getFirst();
        L9:
            r105.setTextColor(r106.getColor(((Number) r107).intValue()));
            GiftTabTextView r108 = r102.f132472a;
            boolean r109 = r103.f132469c;
            View r110 = r108.f126608c;
            int r111 = 0;
            if (r110 == null) goto L15;
            if (r109 == false) goto L13;
            int r112 = 0;
        L14:
            r110.setVisibility(r112);
            goto L15
        L13:
            r112 = 8;
        L15:
            r102.f132472a.setTextSize(14.0f);
            GiftTabTextView r113 = r102.f132472a;
            Map<Integer, Integer> r114 = tz1.a.f548041a;
            r113.setIsNeedSort(Boolean.valueOf(tz1.a.d(r103.f132468b)));
            GiftTabTextView r115 = r102.f132472a;
            if (r103.f132470d == false) goto L18;
            r111 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.p(r103.f132468b);
        L18:
            r115.setStatus(r111);
            r102.itemView.setOnClickListener(new com.bytedance.android.livesdk.gift.vs.panel.view.v2.a(r102, r103));
            if (r103.f132469c == false) goto L21;
            c0 r116 = c0.f130474a;
            c0.f(r103.f132468b);
        L21:
            r3.d(r102.itemView, r103.f132467a, r103.f132470d, true);
            return;
        L8:
            r107 = r104.getSecond();
            goto L9
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "viewGroup");
            View r112 = LayoutInflater.from(this.f132471a.context).inflate(R.layout.ttlive_gift_bottom_view_holder, null);
            View r100 = r112.findViewById(R.id.gift_tab_text);
            if (r100 == null) goto L5;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        L7:
            if ((r101 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
            r101 = null;
        L9:
            ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
            int r103 = 0;
            if (r102 == null) goto L30;
            boolean r104 = true;
            if (r111 == 0) goto L19;
            if (r111 != 1) goto L15;
            y2(r102, s1.f(18.0f), s1.f(16.0f));
        L29:
            r100.setLayoutParams(r102);
            goto L30
        L15:
            if (r111 != 2) goto L29;
            y2(r102, s1.f(50.0f), s1.f(25.0f));
            goto L29
        L19:
            int r113 = s1.f(16.0f);
            int r105 = s1.f(12.0f);
            GiftViewModelManager r106 = this.f132471a.f132466s;
            if (r106 != null) goto L22;
        L24:
            r104 = false;
        L26:
            if (u.l(r104, null) == false) goto L28;
            r113 = r105;
        L28:
            ((ViewGroup.MarginLayoutParams) r102).leftMargin = r113;
            r102.setMarginStart(r113);
            y2(r102, s1.f(18.0f), s1.f(16.0f));
            goto L29
        L22:
            if (r106.getIsVertical() != true) goto L24;
        L30:
            LiveGiftBottomWidgetKt r114 = this.f132471a;
            if (r114.f132464q == true) goto L33;
        L35:
            r112.setVisibility(r103);
            return new d(this.f132471a, r112);
        L33:
            if (r114.f132465r == true) goto L35;
            r103 = 8;
            goto L35
        L5:
            r101 = null;
            goto L7
        }

        public final void y2(ConstraintLayout.LayoutParams r100, int r101, int r102) {
            GiftViewModelManager r103 = this.f132471a.f132466s;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.getIsVertical() != true) goto L7;
        L9:
            if (u.l(r104, null) == false) goto L11;
            r101 = r102;
        L11:
            ((ViewGroup.MarginLayoutParams) r100).rightMargin = r101;
            r100.setMarginEnd(r101);
            return;
        L7:
            r104 = false;
            goto L9
        }
    }

    public final class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GiftTabTextView f132472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveGiftBottomWidgetKt f132473b;

        public d(LiveGiftBottomWidgetKt r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f132473b = r100;
            super(r101);
            this.f132472a = (GiftTabTextView) r101.findViewById(R.id.gift_tab_text);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f132474a = null;

        static {
            f132474a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    static {
    }

    public final void wq() {
        TextView r100 = this.f132450c;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L7:
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r101 = null;
    L9:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        GiftViewModelManager r103 = this.f132466s;
        int r104 = 0;
        if (r103 == null) goto L14;
        boolean r105 = true;
        if (r103.getIsVertical() != true) goto L14;
    L15:
        boolean r106 = u.l(r105, null);
        if (r106 == false) goto L18;
        r104 = 8;
    L18:
        if (r106 == false) goto L20;
        float r107 = 8.0f;
    L21:
        int r108 = s1.f(r107);
        View r109 = this.f132453f;
        if (r109 == null) goto L24;
        r109.setVisibility(r104);
    L24:
        if (r102 == null) goto L26;
        r102.rightMargin = r108;
    L26:
        TextView r110 = this.f132450c;
        if (r110 == null) goto L30;
        r110.setLayoutParams(r102);
        return;
    L30:
        return;
    L20:
        r107 = 20.0f;
    L14:
        r105 = false;
        goto L15
    L5:
        r101 = null;
        goto L7
    }

    public final void zq() {
        IRechargeService r100 = (IRechargeService) k.f(IRechargeService.class);
        if (r100 == null) goto L7;
        zv0.f r101 = r100.rechargeCenter();
        if (r101 == null) goto L7;
        long r102 = r101.getAvailableDiamonds();
    L8:
        boolean r103 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin();
        if (((Boolean) nz1.a.f521350n.getValue(null, nz1.a.f521324a[12])).booleanValue() == true) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (r102 <= 0) goto L32;
        if (r103 == false) goto L32;
        if (r104 == true) goto L32;
        TextView r105 = this.f132450c;
        if (r105 == null) goto L22;
        r105.setText(j0.a(r102));
    L22:
        TextView r106 = this.f132450c;
        if (r106 == null) goto L25;
        r106.setTextColor(this.context.getResources().getColor(R.color.ttlive_gift_bottom_diamond_color));
    L25:
        TextView r107 = this.f132450c;
        if (r107 == null) goto L28;
        r107.setTextSize(1, 16.0f);
    L28:
        HSImageView r108 = this.f132451d;
        if (r108 == null) goto L31;
        r108.setVisibility(0);
    L31:
        wq();
        j r109 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r110 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.f126567d.getClass();
        ImageUtil.loadImage(this.f132451d, ((DiamondConfig) r109.c(r110, DiamondConfig.a.a())).f126568a, 0);
        return;
    L32:
        TextView r111 = this.f132450c;
        if (r111 == null) goto L35;
        r111.setText(e4.a());
    L35:
        int r112 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_BOTTOM_RECHARGE_COLOR, Integer.valueOf(R.color.ttlive_gift_bottom_recharge_color))).intValue();
        TextView r113 = this.f132450c;
        if (r113 == null) goto L38;
        r113.setTextColor(this.context.getResources().getColor(r112));
    L38:
        TextView r114 = this.f132450c;
        if (r114 == null) goto L41;
        r114.setTextSize(1, 14.0f);
    L41:
        HSImageView r115 = this.f132451d;
        if (r115 == null) goto L44;
        r115.setVisibility(8);
    L44:
        wq();
        return;
    L11:
        if (u.p() == true) goto L13;
        r104 = true;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        boolean r100 = false;
        if (((n) com.bytedance.android.livesdk.gift.util.b.a().d(n.class)).f() == 1) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L26:
        return R.layout.ttlive_base_gift_bottom_widget_top;
    L10:
        if (this.dataCenter != null) goto L12;
    L21:
        if (r100 == true) goto L26;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L26;
        return R.layout.ttlive_base_gift_bottom_widget_bottom;
    L12:
        if (x.d() == false) goto L21;
        GiftContext r102 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r102 == null) goto L21;
        m<Boolean> r103 = r102.isVSPadUseVerticalStyle();
        if (r103 == null) goto L21;
        if (r103.getValue().booleanValue() != true) goto L21;
        r100 = true;
        goto L21
    L5:
        if (((n) com.bytedance.android.livesdk.gift.util.b.a().d(n.class)).e() != 1) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        ((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().sync("gift_panel");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.gift.util.b.e(this);
        zv0.b r100 = this.f132462o;
        if (r100 == null) goto L5;
        r100.onUnload();
    L5:
        this.f132461n.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void yq() {
        GiftListViewModelNew r100 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.l();
        if (r100 == null) goto L5;
        List<w1> r101 = r100.g();
    L6:
        w1 r102 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.g();
        com.bytedance.tools.kcp.spongepreference.runtime.a r103 = ay1.b.E;
        KProperty<?>[] r104 = ay1.b.f16675a;
        Integer r105 = null;
        boolean r106 = true;
        int r107 = 0;
        if (((Boolean) r103.getValue(null, r104[35])).booleanValue() == true) goto L18;
        GiftViewModelManager r108 = this.f132466s;
        if (r108 == null) goto L18;
        if (r108.getSendToAnchor(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == true) goto L18;
        if (r102 == null) goto L18;
        if (r102.getPageType() != 5) goto L18;
        if ((!com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.c().isEmpty()) == false) goto L18;
        ToastUtil.a(R.string.ttlive_live_send_props_to_linker_tips, 0);
        r103.setValue(null, r104[35], Boolean.TRUE);
    L18:
        List<w1> r109 = r101;
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r109.iterator();
    L20:
        if (r111.hasNext() == false) goto L25;
        Object r112 = r111.next();
        if (((w1) r112).getDisplay() == false) goto L20;
        r110.add(r112);
        goto L20
    L25:
        if (r110.size() <= 1) goto L27;
        boolean r113 = true;
    L28:
        this.f132465r = r113;
        if (PadConfigUtils.c() == false) goto L31;
    L34:
        boolean r114 = true;
    L36:
        if (e5.n() == false) goto L38;
    L41:
        boolean r115 = true;
    L42:
        GiftViewModelManager r116 = this.f132466s;
        if (r116 != null) goto L45;
    L46:
        if (r114 == false) goto L75;
    L47:
        if (r114 == false) goto L61;
        if (r115 == false) goto L50;
        int r117 = s1.f(7.0f);
    L51:
        ConstraintLayout r118 = (ConstraintLayout) this.contentView.findViewById(R.id.container_cl);
        if (r118 == null) goto L54;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
    L56:
        if ((r119 instanceof ViewGroup.MarginLayoutParams) == true) goto L58;
        r119 = null;
    L58:
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        if (r120 == null) goto L61;
        r120.topMargin = r117;
        goto L61
    L54:
        r119 = null;
        goto L56
    L50:
        r117 = s1.f(5.0f);
    L61:
        if (r114 == true) goto L64;
        if (r115 == true) goto L64;
        int r121 = s1.f(10.0f);
    L65:
        RecyclerView r122 = this.f132448a;
        if (r122 == null) goto L68;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
    L70:
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r123 = null;
    L72:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (r124 == null) goto L75;
        r124.bottomMargin = r121;
        goto L75
    L68:
        r123 = null;
    L64:
        r121 = s1.f(6.0f);
    L75:
        ((ArrayList) this.f132457j).clear();
        if (Lists.isEmpty(r101) == false) goto L78;
        b r125 = new b();
        r125.f132468b = 0;
        r125.f132470d = true;
        r125.f132467a = this.context.getString(R.string.ttlive_live_gift);
        ((ArrayList) this.f132457j).add(r125);
    L108:
        c r126 = this.f132449b;
        if (r126 == null) goto L111;
        r126.notifyDataSetChanged();
    L111:
        zq();
        boolean r127 = u.i(r102);
        int r128 = 8;
        if (r127 == false) goto L114;
    L121:
        View r129 = this.f132454g;
        if (r129 == null) goto L124;
        r129.setVisibility(8);
    L124:
        a22.a r130 = this.f132463p;
        if (r130 == null) goto L134;
        ArrayList r131 = new ArrayList();
        Iterator<T> r132 = r109.iterator();
    L128:
        if (r132.hasNext() == false) goto L132;
        Object r133 = r132.next();
        if (((w1) r133).getDisplay() == false) goto L128;
        r131.add(r133);
        goto L128
    L132:
        r130.X10(r131);
    L134:
        if (this.f132464q == false) goto L184;
        RecyclerView r134 = this.f132448a;
        if (r134 == null) goto L155;
        Integer r135 = Integer.valueOf(r134.getChildCount());
        if (r135.intValue() > 0) goto L142;
        r106 = false;
    L142:
        if (r106 == false) goto L144;
        r105 = r135;
    L144:
        if (r105 == null) goto L183;
        int r136 = r105.intValue();
        if (this.f132465r == false) goto L148;
        r128 = 0;
    L148:
        if (r107 >= r136) goto L185;
        RecyclerView r137 = this.f132448a;
        if (r137 == null) goto L154;
        View r138 = r137.getChildAt(r107);
        if (r138 == null) goto L154;
        r138.setVisibility(r128);
    L154:
        r107 = r107 + 1;
        goto L148
    L185:
        return;
    L183:
        return;
    L155:
        return;
    L184:
        return;
    L114:
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L121;
        if (u.p() == true) goto L121;
        View r139 = this.f132454g;
        if (r139 == null) goto L124;
        r139.setVisibility(0);
        goto L124
    L78:
        if (r102 != null) goto L80;
        w1 r140 = (w1) ListProtector.get(r101, 0);
    L81:
        this.f132458k = r140.getPageType();
        Iterator<w1> r141 = r101.iterator();
    L83:
        if (r141.hasNext() == false) goto L108;
        w1 r142 = r141.next();
        if (r142.getDisplay() == false) goto L83;
        b r143 = new b();
        r143.f132467a = r142.getPageName();
        if (r142.getPageType() != r140.getPageType()) goto L90;
        boolean r144 = true;
    L91:
        r143.f132470d = r144;
        r143.f132468b = r142.getPageType();
        if (this.f132459l == true) goto L94;
    L107:
        ((ArrayList) this.f132457j).add(r143);
        goto L83
    L94:
        if (this.f132458k != 5) goto L105;
        PropManager r145 = PropManager.b();
        r145.getClass();
        HashSet<Long> r146 = ay1.b.t();
        Iterator r147 = ((ArrayList) r145.f130786a).iterator();
    L97:
        if (r147.hasNext() == false) goto L103;
        l2 r148 = (l2) r147.next();
        if (r148.getReddotTip() == false) goto L97;
        if (r146.contains(Long.valueOf(r148.getId())) == true) goto L97;
        r146.add(Long.valueOf(r148.getId()));
        goto L97
    L103:
        Intrinsics.checkNotNullParameter(r146, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r149 = ay1.b.M;
        KProperty<?>[] r150 = ay1.b.f16675a;
        r149.setValue(null, r150[46], r146);
        ay1.b.C(false);
        String r151 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getCastSecUid();
        HashMap<String, String> r152 = ay1.b.s();
        r152.put(r151, String.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r152, "<set-?>");
        ay1.b.Y.setValue(null, r150[62], r152);
        this.f132459l = false;
        goto L107
    L105:
        if (r142.getPageType() != 5) goto L107;
        r143.f132469c = true;
        goto L107
    L90:
        r144 = false;
        goto L91
    L80:
        r140 = r102;
        goto L81
    L45:
        if (r116.getIsVertical() == true) goto L47;
    L38:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L41;
        r115 = false;
        goto L42
    L31:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L34;
        r114 = false;
        goto L36
    L27:
        r113 = false;
        goto L28
    L5:
        r101 = new ArrayList();
        goto L6
    }

    public LiveGiftBottomWidgetKt(GiftViewModelManager r100) {
        this.f132466s = r100;
        this.f132457j = new ArrayList();
        this.f132461n = new CompositeDisposable();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (r100.getId() != R.id.charge_layout) goto L6;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.m(null, true));
        h.X();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f132448a = (RecyclerView) findViewById(R.id.tab_list);
        this.f132450c = (TextView) findViewById(R.id.recharge_view);
        this.f132451d = (HSImageView) findViewById(R.id.coin_icon);
        this.f132452e = findViewById(R.id.charge_layout);
        RecyclerView r101 = this.f132448a;
        if (r101 == null) goto L5;
        r101.setHorizontalFadingEdgeEnabled(true);
    L5:
        RecyclerView r102 = this.f132448a;
        if (r102 == null) goto L8;
        r102.setFadingEdgeLength(s1.f(40.0f));
    L8:
        View r103 = findViewById(R.id.start_board);
        if (r103 == null) goto L11;
        r103.setVisibility(8);
    L11:
        View r104 = findViewById(R.id.end_board);
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        this.f132453f = findViewById(R.id.recharge_arrow);
        this.f132454g = findViewById(R.id.bottom_bg_view);
        TextView r105 = (TextView) findViewById(R.id.income_to_coins_label);
        this.f132455h = r105;
        if (r105 == null) goto L17;
        r105.setText(s1.C(R.string.ttlive_gift_income_to_coins, new Object[]{com.bytedance.android.livesdk.utils.r3.c()}));
    L17:
        this.f132456i = (TextView) findViewById(R.id.income_to_coins_num_tv);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f132449b = new c(this);
        RecyclerView r101 = this.f132448a;
        boolean r102 = false;
        if (r101 == null) goto L5;
        r101.setItemViewCacheSize(16);
        r101.setAdapter(this.f132449b);
        r101.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
    L5:
        View r103 = this.contentView;
        if (r103 == null) goto L9;
        r103.setOnClickListener(e.f132474a);
    L9:
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L13;
        View r104 = this.f132454g;
        if (r104 == null) goto L13;
        r104.setVisibility(8);
    L13:
        zq();
        com.bytedance.android.livesdk.gift.util.b.d("GiftListViewModel", this, new com.bytedance.android.livesdk.gift.vs.panel.view.v2.d(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftTabViewModel", this, new com.bytedance.android.livesdk.gift.vs.panel.view.v2.d(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", this, new com.bytedance.android.livesdk.gift.vs.panel.view.v2.d(this), true);
        this.f132461n.add(((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.vs.panel.view.v2.e(this), f.f132483a));
        View r105 = this.f132452e;
        if (r105 == null) goto L16;
        r105.setOnClickListener(this);
    L16:
        isScreenPortrait();
        int r106 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        RecyclerView r107 = this.f132448a;
        if (r107 == null) goto L20;
        r107.addOnScrollListener(new AnonymousClass3(this));
    L20:
        if (ay1.b.v() == false) goto L23;
        this.f132459l = true;
    L23:
        if (u.p() == false) goto L28;
        View r108 = this.f132454g;
        if (r108 == null) goto L28;
        r108.setVisibility(8);
    L28:
        if (this.f132455h != null) goto L30;
        return;
    L30:
        if (this.f132456i == null) goto L43;
        GiftViewModelManager r109 = this.f132466s;
        if (r109 == null) goto L37;
        if (r109.getIsVertical() != true) goto L37;
        r102 = true;
    L37:
        if (u.k(r102) == 2) goto L39;
        return;
    L39:
        if (xq(null) == false) goto L45;
        this.f132461n.add(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).pl().subscribe(new com.bytedance.android.livesdk.gift.vs.panel.view.v2.b(this), com.bytedance.android.livesdk.gift.vs.panel.view.v2.c.f132480a));
        return;
    L45:
        return;
    }

    public final boolean xq(ds2.d r110) {
        View r100 = this.f132452e;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L10;
        r101 = r102;
    L10:
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r101;
        GiftViewModelManager r104 = this.f132466s;
        boolean r105 = false;
        if (r104 != null) goto L13;
    L15:
        boolean r106 = false;
    L17:
        if (u.l(r106, r110) == false) goto L26;
        ArrayList r107 = new ArrayList();
        r107.add(this.f132455h);
        r107.add(this.f132456i);
        zv0.b r111 = ((IRechargeService) k.n(IRechargeService.class)).getCashExchangeDelegate(this.f132455h, r107, this.f132456i, new LiveGiftBottomWidgetKt$adjustContainerHeight$1(this), 2, this.context);
        this.f132462o = r111;
        if (r111 == null) goto L21;
        r111.setDataCenter(this.dataCenter);
    L21:
        TextView r112 = this.f132455h;
        if (r112 == null) goto L24;
        r112.setVisibility(0);
    L24:
        if (r103 == null) goto L35;
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = s1.f(12.0f);
    L35:
        View r113 = this.f132452e;
        if (r113 == null) goto L38;
        r113.setLayoutParams(r103);
    L38:
        wq();
        return r105;
    L26:
        TextView r114 = this.f132455h;
        if (r114 == null) goto L29;
        r114.setVisibility(8);
    L29:
        TextView r115 = this.f132456i;
        if (r115 == null) goto L32;
        r115.setVisibility(8);
    L32:
        if (r103 == null) goto L34;
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = s1.f(16.0f);
    L34:
        r105 = true;
        goto L35
    L13:
        if (r104.getIsVertical() != true) goto L15;
        r106 = true;
        goto L17
    L5:
        r102 = null;
        goto L7
    }
}
