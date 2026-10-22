package com.bytedance.android.livesdk.gift.platform.format.panel.view.v2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.j0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.GiftTabTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.scope.m;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/view/v2/FormatGiftBottomWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftBottomWidget extends LiveRecyclableWidget implements View.OnClickListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f132192o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f132193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f132194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f132195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f132196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f132197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f132198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f132199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f132200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f132201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f132202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f132203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f132204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zv0.b f132205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final GiftViewModelManager f132206n;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f132207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f132208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f132209c;

        public b() {
        }
    }

    public final class c extends RecyclerView.Adapter<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftBottomWidget f132210a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f132210a.f132203k).size();
        }

        public c(FormatGiftBottomWidget r100) {
            this.f132210a = r100;
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
            b r103 = (b) ListProtector.get(this.f132210a.f132203k, r101);
            if (r103 != null) goto L5;
            r102.getClass();
            return;
        L5:
            r102.f132211a.setGravity(48);
            r102.f132211a.setText(r103.f132207a);
            Pair r104 = (Pair) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, new Pair(Integer.valueOf(R.color.ttlive_gift_bottom_tab_selected_color), Integer.valueOf(R.color.black)));
            GiftTabTextView r105 = r102.f132211a;
            Resources r106 = r102.f132212b.context.getResources();
            if (r103.f132209c == false) goto L8;
            Object r107 = r104.getFirst();
        L9:
            r105.setTextColor(r106.getColor(((Number) r107).intValue()));
            View r108 = r102.f132211a.f126608c;
            if (r108 == null) goto L12;
            r108.setVisibility(8);
        L12:
            r102.f132211a.setTextSize(14.0f);
            GiftTabTextView r109 = r102.f132211a;
            Map<Integer, Integer> r110 = tz1.a.f548041a;
            r109.setIsNeedSort(Boolean.valueOf(tz1.a.d(r103.f132208b)));
            GiftTabTextView r111 = r102.f132211a;
            if (r103.f132209c == false) goto L15;
            int r112 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.k(r103.f132208b);
        L16:
            r111.setStatus(r112);
            r102.itemView.setOnClickListener(new com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.a(r102, r103));
            return;
        L15:
            r112 = 0;
            goto L16
        L8:
            r107 = r104.getSecond();
            goto L9
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "viewGroup");
            View r112 = LayoutInflater.from(this.f132210a.context).inflate(R.layout.ttlive_gift_bottom_view_holder, null);
            View r100 = r112.findViewById(R.id.gift_tab_text);
            if (r100 == null) goto L5;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        L7:
            if ((r101 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
            r101 = null;
        L9:
            ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
            if (r102 == null) goto L30;
            boolean r103 = true;
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
            int r104 = s1.f(12.0f);
            GiftViewModelManager r105 = this.f132210a.f132206n;
            if (r105 != null) goto L22;
        L24:
            r103 = false;
        L26:
            if (u.l(r103, null) == false) goto L28;
            r113 = r104;
        L28:
            ((ViewGroup.MarginLayoutParams) r102).leftMargin = r113;
            r102.setMarginStart(r113);
            y2(r102, s1.f(18.0f), s1.f(16.0f));
            goto L29
        L22:
            if (r105.getIsVertical() != true) goto L24;
        L30:
            FormatGiftBottomWidget r114 = this.f132210a;
            int r106 = FormatGiftBottomWidget.f132192o;
            r114.getClass();
            r112.setVisibility(0);
            return new d(this.f132210a, r112);
        L5:
            r101 = null;
            goto L7
        }

        public final void y2(ConstraintLayout.LayoutParams r100, int r101, int r102) {
            GiftViewModelManager r103 = this.f132210a.f132206n;
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
        public final GiftTabTextView f132211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FormatGiftBottomWidget f132212b;

        public d(FormatGiftBottomWidget r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f132212b = r100;
            super(r101);
            this.f132211a = (GiftTabTextView) r101.findViewById(R.id.gift_tab_text);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f132213a = null;

        static {
            f132213a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftBottomWidget f132214a;

        public f(FormatGiftBottomWidget r100) {
            this.f132214a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FormatGiftBottomWidget r101 = this.f132214a;
            FormatGiftBottomWidget.wq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftBottomWidget f132215a;

        public g(FormatGiftBottomWidget r100) {
            this.f132215a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FormatGiftBottomWidget r101 = this.f132215a;
            FormatGiftBottomWidget.wq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftBottomWidget f132216a;

        public h(FormatGiftBottomWidget r100) {
            this.f132216a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FormatGiftBottomWidget r101 = this.f132216a;
            FormatGiftBottomWidget.wq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f132217a = null;

        static {
            f132217a = new i();
        }

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_format_gift_bottom_widget_bottom;
    }

    public final void zq() {
        IRechargeService r100 = (IRechargeService) k.f(IRechargeService.class);
        if (r100 == null) goto L7;
        zv0.f r101 = r100.rechargeCenter();
        if (r101 == null) goto L7;
        long r102 = r101.getAvailableDiamonds();
    L8:
        boolean r103 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin();
        View r104 = this.f132198f;
        if (r104 == null) goto L11;
        r104.setVisibility(8);
    L11:
        HSImageView r105 = this.f132196d;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        a1.m(this.f132196d, R.drawable.ttlive_format_diamond);
        if (r102 <= 0) goto L27;
        if (r103 == false) goto L27;
        TextView r106 = this.f132195c;
        if (r106 == null) goto L21;
        r106.setText(j0.a(r102));
    L21:
        TextView r107 = this.f132195c;
        if (r107 == null) goto L24;
        r107.setTextColor(this.context.getResources().getColor(R.color.ttlive_format_gift_bottom_diamond_color));
    L24:
        TextView r108 = this.f132195c;
        if (r108 == null) goto L37;
        r108.setTextSize(1, 16.0f);
        return;
    L37:
        return;
    L27:
        TextView r109 = this.f132195c;
        if (r109 == null) goto L30;
        r109.setText(e4.a());
    L30:
        TextView r110 = this.f132195c;
        if (r110 == null) goto L33;
        r110.setTextColor(this.context.getResources().getColor(R.color.ttlive_format_gift_bottom_diamond_color));
    L33:
        TextView r111 = this.f132195c;
        if (r111 == null) goto L39;
        r111.setTextSize(1, 14.0f);
        return;
    L39:
        return;
    L7:
        r102 = 0;
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
        zv0.b r100 = this.f132205m;
        if (r100 == null) goto L5;
        r100.onUnload();
    L5:
        this.f132204l.clear();
    }

    public final void yq() {
        FormatGiftListViewModel r100 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.h();
        if (r100 == null) goto L5;
        List<w1> r101 = r100.h();
    L6:
        w1 r102 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.d();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (((w1) r105).getDisplay() == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        r103.size();
        if (PadConfigUtils.c() == false) goto L15;
    L18:
        boolean r106 = true;
    L20:
        if (e5.n() == false) goto L22;
    L25:
        boolean r107 = true;
    L26:
        GiftViewModelManager r108 = this.f132206n;
        if (r108 != null) goto L29;
    L30:
        if (r106 == false) goto L61;
    L31:
        ViewGroup.LayoutParams r109 = null;
        if (r106 == false) goto L46;
        if (r107 == false) goto L35;
        int r110 = s1.f(7.0f);
    L36:
        ConstraintLayout r111 = (ConstraintLayout) this.contentView.findViewById(R.id.container_cl);
        if (r111 == null) goto L39;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L41:
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L43;
        r112 = null;
    L43:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 == null) goto L46;
        r113.topMargin = r110;
        goto L46
    L39:
        r112 = null;
        goto L41
    L35:
        r110 = s1.f(5.0f);
    L46:
        if (r106 == true) goto L49;
        if (r107 == true) goto L49;
        int r114 = s1.f(10.0f);
    L50:
        RecyclerView r115 = this.f132193a;
        if (r115 == null) goto L53;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
    L55:
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L58;
        r109 = r116;
    L58:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r109;
        if (r117 == null) goto L61;
        r117.bottomMargin = r114;
        goto L61
    L53:
        r116 = null;
    L49:
        r114 = s1.f(6.0f);
    L61:
        ((ArrayList) this.f132203k).clear();
        if (Lists.isEmpty(r101) == false) goto L64;
        b r118 = new b();
        r118.f132208b = 0;
        r118.f132209c = true;
        r118.f132207a = this.context.getString(R.string.ttlive_live_gift);
        ((ArrayList) this.f132203k).add(r118);
    L77:
        c r119 = this.f132194b;
        if (r119 == null) goto L80;
        r119.notifyDataSetChanged();
    L80:
        zq();
        View r120 = this.f132199g;
        if (r120 == null) goto L94;
        r120.setVisibility(8);
        return;
    L94:
        return;
    L64:
        if (r102 != null) goto L66;
        r102 = (w1) ListProtector.get(r101, 0);
    L66:
        r102.getPageType();
        Iterator<w1> r121 = r101.iterator();
    L68:
        if (r121.hasNext() == false) goto L77;
        w1 r122 = r121.next();
        if (r122.getDisplay() == false) goto L68;
        b r123 = new b();
        r123.f132207a = r122.getPageName();
        if (r122.getPageType() != r102.getPageType()) goto L75;
        boolean r124 = true;
    L76:
        r123.f132209c = r124;
        r123.f132208b = r122.getPageType();
        ((ArrayList) this.f132203k).add(r123);
        goto L68
    L75:
        r124 = false;
        goto L76
    L29:
        if (r108.getIsVertical() == true) goto L31;
    L22:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L25;
        r107 = false;
        goto L26
    L15:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L18;
        r106 = false;
        goto L20
    L5:
        r101 = new ArrayList();
        goto L6
    }

    public FormatGiftBottomWidget(GiftViewModelManager r100) {
        this.f132206n = r100;
        this.f132203k = new ArrayList();
        this.f132204l = new CompositeDisposable();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (r100.getId() != R.id.charge_layout) goto L6;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.m(null, true));
        com.bytedance.android.livesdk.gift.platform.core.utils.h.X();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f132193a = (RecyclerView) findViewById(R.id.tab_list);
        this.f132195c = (TextView) findViewById(R.id.recharge_view);
        this.f132196d = (HSImageView) findViewById(R.id.coin_icon);
        this.f132197e = findViewById(R.id.charge_layout);
        RecyclerView r101 = this.f132193a;
        if (r101 == null) goto L5;
        r101.setHorizontalFadingEdgeEnabled(true);
    L5:
        RecyclerView r102 = this.f132193a;
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
        this.f132198f = findViewById(R.id.recharge_arrow);
        this.f132199g = findViewById(R.id.bottom_bg_view);
        this.f132200h = findViewById(R.id.close_button);
        TextView r105 = (TextView) findViewById(R.id.income_to_coins_label);
        this.f132201i = r105;
        if (r105 == null) goto L17;
        r105.setText(s1.C(R.string.ttlive_gift_income_to_coins, new Object[]{r3.c()}));
    L17:
        this.f132202j = (TextView) findViewById(R.id.income_to_coins_num_tv);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f132194b = new c(this);
        RecyclerView r101 = this.f132193a;
        boolean r102 = false;
        if (r101 == null) goto L5;
        r101.setItemViewCacheSize(16);
        r101.setAdapter(this.f132194b);
        r101.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
    L5:
        View r103 = this.contentView;
        if (r103 == null) goto L9;
        r103.setOnClickListener(e.f132213a);
    L9:
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L13;
        View r104 = this.f132199g;
        if (r104 == null) goto L13;
        r104.setVisibility(8);
    L13:
        RecyclerView r105 = this.f132193a;
        if (r105 == null) goto L16;
        ViewUtilsKt.e(r105);
    L16:
        zq();
        f r106 = new f(this);
        q12.a r107 = q12.b.f531284a;
        if (r107 == null) goto L19;
        Object r108 = m.f163449e.d(r107, FormatGiftListViewModel.class);
    L20:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r109 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r108;
        if (r109 == null) goto L23;
        GiftStateMachineConfig.g r110 = r109.c(this, r106);
    L24:
        if (r110 == null) goto L26;
        r106.onChanged(r110);
    L26:
        g r111 = new g(this);
        q12.a r112 = q12.b.f531284a;
        if (r112 == null) goto L29;
        Object r113 = m.f163449e.d(r112, FormatGiftTabViewModel.class);
    L30:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r114 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r113;
        if (r114 == null) goto L33;
        GiftStateMachineConfig.g r115 = r114.c(this, r111);
    L34:
        if (r115 == null) goto L36;
        r111.onChanged(r115);
    L36:
        h r116 = new h(this);
        q12.a r117 = q12.b.f531284a;
        if (r117 == null) goto L39;
        Object r118 = m.f163449e.d(r117, FormatGiftPanelDialogViewModel.class);
    L40:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r119 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r118;
        if (r119 == null) goto L43;
        GiftStateMachineConfig.g r120 = r119.c(this, r116);
    L44:
        if (r120 == null) goto L46;
        r116.onChanged(r120);
    L46:
        this.f132204l.add(((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.d(this), com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.e.f132223a));
        View r121 = this.f132197e;
        if (r121 == null) goto L49;
        r121.setOnClickListener(this);
    L49:
        View r122 = this.f132200h;
        if (r122 == null) goto L52;
        r122.setOnClickListener(i.f132217a);
    L52:
        boolean r123 = isScreenPortrait();
        int r124 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        boolean r125 = !r123;
        View r126 = this.f132199g;
        if (r126 == null) goto L56;
        r126.setVisibility(8);
    L56:
        if (this.f132201i != null) goto L58;
        return;
    L58:
        if (this.f132202j == null) goto L71;
        GiftViewModelManager r127 = this.f132206n;
        if (r127 == null) goto L65;
        if (r127.getIsVertical() != true) goto L65;
        r102 = true;
    L65:
        if (u.k(r102) == 2) goto L67;
        return;
    L67:
        if (xq(null) == false) goto L73;
        this.f132204l.add(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).pl().subscribe(new com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.b(this), com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.c.f132221a));
        return;
    L73:
        return;
    L71:
        return;
    L43:
        r120 = null;
        goto L44
    L39:
        r118 = null;
        goto L40
    L33:
        r115 = null;
        goto L34
    L29:
        r113 = null;
        goto L30
    L23:
        r110 = null;
        goto L24
    L19:
        r108 = null;
        goto L20
    }

    public final boolean xq(ds2.d r110) {
        View r100 = this.f132197e;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L7:
        if ((r101 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
        r101 = null;
    L9:
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        GiftViewModelManager r103 = this.f132206n;
        boolean r104 = false;
        if (r103 != null) goto L12;
    L14:
        boolean r105 = false;
    L16:
        if (u.l(r105, r110) == false) goto L26;
        ArrayList r106 = new ArrayList();
        r106.add(this.f132201i);
        r106.add(this.f132202j);
        zv0.b r111 = ((IRechargeService) k.n(IRechargeService.class)).getCashExchangeDelegate(this.f132201i, r106, this.f132202j, new FormatGiftBottomWidget$adjustContainerHeight$1(this), 2, this.context);
        this.f132205m = r111;
        if (r111 == null) goto L20;
        r111.setDataCenter(this.dataCenter);
    L20:
        TextView r112 = this.f132201i;
        if (r112 == null) goto L23;
        r112.setVisibility(0);
    L23:
        if (r102 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r102).rightMargin = s1.f(12.0f);
    L25:
        boolean r113 = false;
    L35:
        View r107 = this.f132197e;
        if (r107 == null) goto L38;
        r107.setLayoutParams(r102);
    L38:
        TextView r108 = this.f132195c;
        if (r108 == null) goto L41;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L43:
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r109 = null;
    L45:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r109;
        GiftViewModelManager r115 = this.f132206n;
        if (r115 == null) goto L51;
        if (r115.getIsVertical() != true) goto L51;
        r104 = true;
    L51:
        if (u.l(r104, null) == false) goto L53;
        float r116 = 8.0f;
    L54:
        int r117 = s1.f(r116);
        View r118 = this.f132198f;
        if (r118 == null) goto L57;
        r118.setVisibility(8);
    L57:
        if (r114 == null) goto L59;
        r114.rightMargin = r117;
    L59:
        TextView r119 = this.f132195c;
        if (r119 == null) goto L62;
        r119.setLayoutParams(r114);
    L62:
        return r113;
    L53:
        r116 = 20.0f;
        goto L54
    L41:
        r109 = null;
        goto L43
    L26:
        TextView r120 = this.f132201i;
        if (r120 == null) goto L29;
        r120.setVisibility(8);
    L29:
        TextView r121 = this.f132202j;
        if (r121 == null) goto L32;
        r121.setVisibility(8);
    L32:
        if (r102 == null) goto L34;
        ((ViewGroup.MarginLayoutParams) r102).rightMargin = s1.f(16.0f);
    L34:
        r113 = true;
        goto L35
    L12:
        if (r103.getIsVertical() != true) goto L14;
        r105 = true;
        goto L16
    L5:
        r101 = null;
        goto L7
    }

    public static final void wq(FormatGiftBottomWidget r100, GiftStateMachineConfig.g r101) {
        r100.getClass();
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof GiftStateMachineConfig.e.b) == false) goto L8;
    L9:
        r100.yq();
    L11:
        if ((r101 instanceof GiftStateMachineConfig.h.a) == false) goto L14;
        r100.yq();
    L14:
        if ((r101 instanceof GiftStateMachineConfig.a) == false) goto L17;
        r100.zq();
        return;
    L17:
        return;
    L8:
        if ((r101 instanceof GiftStateMachineConfig.e.c) == false) goto L11;
        goto L9
    }
}
