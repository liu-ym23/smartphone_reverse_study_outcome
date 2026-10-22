package com.bytedance.android.ec.common.impl.sku.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.log.SkuLog;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ButtonPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f43123p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f43125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q83.a f43126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f43127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f43128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f43129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f43130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f43131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f43132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f43133o;

    public static final class a {
    }

    public static final class b implements q83.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ButtonPresenter f43134a;

        public b(ButtonPresenter r100) {
            this.f43134a = r100;
        }

        @Override // q83.a
        public final boolean onTick(long r100) {
            com.bytedance.android.ec.model.response.p r101 = ButtonPresenter.e0(this.f43134a).getCheckPayNotificationAction().a();
            if (r101 != null) goto L5;
        L10:
            return true;
        L5:
            if (((TextView) this.f43134a.Z().b(R.id.tv_sku_sold_free).f()).getVisibility() != 0) goto L10;
            if ((!Intrinsics.areEqual(ButtonPresenter.e0(this.f43134a).getCheckPayNotificationSkuId(), ButtonPresenter.e0(this.f43134a).getSelectedSkuId())) == false) goto L9;
            this.f43134a.q0(false);
            LinearLayout r102 = (LinearLayout) this.f43134a.Z().b(R.id.ll_sku_buy_container).f();
            r102.setBackgroundResource(R.drawable.shopping_bg_selector_go_to_goods_btn);
            r102.setClickable(true);
            ButtonPresenter.e0(this.f43134a).cancelQueryPromotionCheckPayNotification(true);
            goto L10
        L9:
            ButtonPresenter.h0(this.f43134a, r101);
            goto L10
        }
    }

    public static final class c implements com.bytedance.android.ec.core.utils.l1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ButtonPresenter f43135a;

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onStart() {
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onFinish() {
            Long r100 = this.f43135a.f43129k;
            if (r100 != null) goto L6;
        L8:
            Long r101 = this.f43135a.f43129k;
            if (r101 != null) goto L12;
            return;
        L12:
            if (r101.longValue() != 7) goto L21;
            TextView r102 = (TextView) this.f43135a.Z().b(R.id.tv_sku_buy_confirm).f();
            if (ButtonPresenter.e0(this.f43135a).getSkuParams().getAddShopCart() == false) goto L16;
        L18:
            r102.setTextSize(17.0f);
            ((TextView) this.f43135a.Z().b(R.id.tv_sku_buy_count_down).f()).setVisibility(8);
            return;
        L16:
            if (ButtonPresenter.e0(this.f43135a).getSkuParams().isFromCartOrInsurance() == true) goto L18;
            r102.setText(th.a.g(this.f43135a.Y().c(), R.string.shopping_buy_now));
            goto L18
        L21:
            return;
        L6:
            if (r100.longValue() != 10) goto L8;
            TextView r103 = (TextView) this.f43135a.Z().b(R.id.ll_sku_add_container).f();
            r103.setOnClickListener(null);
            r103.setEnabled(false);
            LinearLayout r104 = (LinearLayout) this.f43135a.Z().b(R.id.ll_sku_buy_container).f();
            r104.setOnClickListener(null);
            r104.setBackgroundResource(R.drawable.shopping_bg_goods_goto_btn_pressed);
            ((TextView) this.f43135a.Z().b(R.id.tv_sku_buy_count_down).f()).setText(th.a.g(this.f43135a.Y().c(), R.string.shopping_tip_deposit_presale_end));
        }

        public c(ButtonPresenter r100) {
            this.f43135a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onTick(long r110) {
            int r100 = com.bytedance.android.ec.core.utils.c2.f45564h;
            com.bytedance.android.ec.core.utils.c2 r111 = com.bytedance.android.ec.core.utils.c2.a.a(this.f43135a.Y().c(), r110, false);
            Long r112 = this.f43135a.f43129k;
            if (r112 != null) goto L6;
        L12:
            Long r113 = this.f43135a.f43129k;
            if (r113 != null) goto L16;
            return;
        L16:
            if (r113.longValue() != 7) goto L20;
            ((TextView) this.f43135a.Z().b(R.id.tv_sku_buy_count_down).f()).setText(th.a.h(this.f43135a.Y().c(), R.string.shopping_seckill_end_date, new Object[]{r111.f45567c, r111.f45568d, r111.f45569e}));
            return;
        L20:
            return;
        L6:
            if (r112.longValue() != 10) goto L12;
            TextView r114 = (TextView) this.f43135a.Z().b(R.id.tv_sku_buy_count_down).f();
            if (r111.f45565a <= 0) goto L10;
            String r115 = th.a.h(this.f43135a.Y().c(), R.string.shopping_presale_end_day_date, new Object[]{Integer.valueOf(r111.f45565a), r111.f45567c, r111.f45568d, r111.f45569e});
        L11:
            r114.setText(r115);
            return;
        L10:
            r115 = th.a.h(this.f43135a.Y().c(), R.string.shopping_presale_end_date, new Object[]{r111.f45567c, r111.f45568d, r111.f45569e});
            goto L11
        }
    }

    static {
    }

    public final Pair<String, String>[] j0() {
        Pair<String, String>[] r100 = new Pair[5];
        SkuViewModel r101 = this.f43124f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        String r103 = null;
        if (r102 == null) goto L8;
        Long r104 = Long.valueOf(r102.getMinPrice());
    L9:
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EFFECTIVE_MIN_PRICE, String.valueOf(r104));
        SkuViewModel r105 = this.f43124f;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuInfoVO r106 = r105.getSkuInfo().a();
        if (r106 == null) goto L15;
        Long r107 = r106.getDiscountPrice();
    L16:
        r100[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_MIN_PRICE, String.valueOf(r107));
        SkuViewModel r108 = this.f43124f;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        SkuInfoVO r109 = r108.getSkuInfo().a();
        if (r109 == null) goto L22;
        Long r110 = Long.valueOf(r109.getMarketPrice());
    L23:
        r100[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE, String.valueOf(r110));
        SkuViewModel r111 = this.f43124f;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        SkuInfoVO r112 = r111.getSkuInfo().a();
        if (r112 == null) goto L31;
        LogPbData r113 = r112.getLogPb();
        if (r113 == null) goto L31;
        r103 = r113.getImprId();
    L31:
        r100[3] = TuplesKt.to("log_id", r103);
        SkuViewModel r114 = this.f43124f;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r100[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r114.getSelectedSkuId());
        return r100;
    L22:
        r110 = null;
        goto L23
    L15:
        r107 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        Lazy r100 = ActivityCountDownTimer.f43347c;
        ActivityCountDownTimer.a.a().b();
        SkuViewModel r101 = this.f43124f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        cf.t r102 = r101.getSkuLiveService();
        if (r102 == null) goto L9;
        r102.a(m0());
        return;
    }

    public final q83.a m0() {
        if (this.f43126h != null) goto L5;
        this.f43126h = new b(this);
    L5:
        q83.a r100 = this.f43126h;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("soldFreeTextTickListener");
    L8:
        return r100;
    }

    public final void o0() {
        ((TextView) Z().b(R.id.tv_sku_buy_confirm).f()).setTextSize(14.0f);
        TextView r100 = (TextView) Z().b(R.id.tv_sku_buy_count_down).f();
        r100.setVisibility(0);
        if (this.f43130l == false) goto L5;
        int r101 = th.a.a(Y().c(), R.color.shopping_std_text_white_4);
    L6:
        r100.setTextColor(r101);
        Lazy r102 = ActivityCountDownTimer.f43347c;
        ActivityCountDownTimer.a.a().b();
        ActivityCountDownTimer.a.a().a(SystemClock.elapsedRealtime() / 1000, this.f43132n / 1000, new c(this));
        return;
    L5:
        r101 = th.a.a(Y().c(), R.color.shopping_std_text_white_1);
        goto L6
    }

    public ButtonPresenter(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f43133o = LazyKt.lazy(new ButtonPresenter$newClick$2(this, r100));
    }

    public static final /* synthetic */ SkuViewModel e0(ButtonPresenter r100) {
        SkuViewModel r101 = r100.f43124f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    public static final void i0(ButtonPresenter r210) {
        SkuViewModel r100 = r210.f43124f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r101 = r100.getCurrentPrice();
        SkuViewModel r102 = r210.f43124f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        SkuInfoVO r103 = r102.getSkuInfo().a();
        SkuViewModel r104 = r210.f43124f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        rg.a<String> r105 = r104.getOnItemChange().a();
        if (r105 == null) goto L14;
        String r106 = r105.f537663b;
    L15:
        if (r103 == null) goto L19;
        Map<String, SkuItemInfoVO> r107 = r103.getSkuList();
        if (r107 == null) goto L19;
        SkuItemInfoVO r108 = r107.get(r106);
    L20:
        boolean r110 = true;
        if (r108 == null) goto L23;
        r210.f43129k = r108.getSkuType();
        r210.f43130l = r108.isInDepositPresale();
        r210.f43131m = r108.isInSecKill();
        r210.f43132n = r108.getCampaignEndTime();
    L43:
        if (r103 == null) goto L45;
        Integer r109 = Integer.valueOf(r103.getStatus());
    L47:
        if (r210.f43130l == true) goto L54;
        Long r111 = r210.f43129k;
        if (r111 == null) goto L54;
        if (r111.longValue() != 10) goto L54;
        ((LinearLayout) r210.Z().b(R.id.ll_sku_buy_container).f()).setOnClickListener(null);
        ((TextView) r210.Z().b(R.id.ll_sku_add_container).f()).setOnClickListener(null);
    L56:
        if (r109 != null) goto L59;
    L73:
        ((LinearLayout) r210.Z().b(R.id.ll_sku_buy_container).f()).setBackgroundResource(R.drawable.shopping_bg_goods_goto_btn_pressed);
        ((TextView) r210.Z().b(R.id.ll_sku_add_container).f()).setEnabled(false);
    L74:
        SkuViewModel r112 = r210.f43124f;
        if (r112 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L77:
        SkuInfoVO r113 = r112.getSkuInfo().a();
        if (r113 == null) goto L92;
        List<SkuBottomButtons> r114 = r113.getDefaultButtons();
        if (r114 == null) goto L92;
        Iterator<T> r115 = r114.iterator();
    L83:
        if (r115.hasNext() == false) goto L90;
        Object r116 = r115.next();
        if (((SkuBottomButtons) r116).getButtonType() != 1) goto L87;
        boolean r117 = true;
    L88:
        if (r117 == false) goto L83;
    L91:
        SkuBottomButtons r118 = (SkuBottomButtons) r116;
    L93:
        if (r118 == null) goto L95;
        boolean r119 = true;
    L96:
        if (r119 == false) goto L177;
        r210.f43125g = false;
        if (r103 == null) goto L134;
        SkuViewModel r120 = r210.f43124f;
        if (r120 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L103:
        if (r120.getSkuParams().getApplyCoupon() != 1) goto L134;
        Long r121 = r103.getUnUseMinPrice();
        if (r121 == null) goto L107;
        long r122 = r121.longValue();
        long r123 = 0;
    L109:
        if (r122 < r123) goto L134;
        if (r101 > r123) goto L122;
        long r124 = r103.getMinPrice();
        SkuViewModel r125 = r210.f43124f;
        if (r125 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        long r126 = r124 * r125.getCurrentCount();
        Long r127 = r103.getUnUseMinPrice();
        if (r127 == null) goto L118;
        long r128 = r127.longValue();
    L120:
        if (r126 >= r128) goto L131;
    L132:
        boolean r129 = false;
    L133:
        r210.f43125g = r129;
    L131:
        r129 = true;
        goto L133
    L118:
        r128 = 0;
        goto L120
    L122:
        SkuViewModel r130 = r210.f43124f;
        if (r130 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L125:
        long r131 = r101 * r130.getCurrentCount();
        Long r132 = r103.getUnUseMinPrice();
        if (r132 == null) goto L128;
        long r133 = r132.longValue();
    L130:
        if (r131 < r133) goto L132;
    L128:
        r133 = 0;
        goto L130
    L107:
        r123 = 0;
        r122 = 0;
    L134:
        if (r103 == null) goto L155;
        Map<String, SkuItemInfoVO> r134 = r103.getSkuList();
        if (r134 == null) goto L155;
        SkuItemInfoVO r135 = r134.get(r106);
        if (r135 == null) goto L155;
        List<SkuBottomButtons> r136 = r135.getButtons();
        if (r136 == null) goto L155;
        Iterator<T> r137 = r136.iterator();
    L143:
        if (r137.hasNext() == false) goto L150;
        Object r138 = r137.next();
        if (((SkuBottomButtons) r138).getButtonType() != 1) goto L147;
        boolean r139 = true;
    L148:
        if (r139 == false) goto L143;
    L151:
        SkuBottomButtons r140 = (SkuBottomButtons) r138;
        if (r140 == null) goto L155;
        String r141 = r140.getText();
        if (r141 == null) goto L155;
    L172:
        if (r141 != null) goto L176;
        if (r103 == null) goto L175;
        r141 = r103.getButtonLabel();
        goto L176
    L175:
        r141 = null;
    L176:
        ((TextView) r210.Z().b(R.id.tv_sku_buy_confirm).f()).setText(r141);
        goto L177
    L147:
        r139 = false;
        goto L148
    L150:
        r138 = null;
    L155:
        if (r103 == null) goto L171;
        List<SkuBottomButtons> r142 = r103.getDefaultButtons();
        if (r142 == null) goto L171;
        Iterator<T> r143 = r142.iterator();
    L160:
        if (r143.hasNext() == false) goto L167;
        Object r144 = r143.next();
        if (((SkuBottomButtons) r144).getButtonType() != 1) goto L164;
        boolean r145 = true;
    L165:
        if (r145 == false) goto L160;
    L168:
        SkuBottomButtons r146 = (SkuBottomButtons) r144;
        if (r146 == null) goto L171;
        r141 = r146.getText();
        goto L172
    L164:
        r145 = false;
        goto L165
    L167:
        r144 = null;
    L171:
        r141 = null;
    L177:
        if (r103 == null) goto L184;
        Map<String, SkuItemInfoVO> r147 = r103.getSkuList();
        if (r147 == null) goto L184;
        SkuItemInfoVO r148 = r147.get(r106);
        if (r148 == null) goto L184;
        List<SkuBottomButtons> r149 = r148.getButtons();
        if (r149 == null) goto L184;
    L187:
        r210.n0(r149);
        SkuViewModel r150 = r210.f43124f;
        if (r150 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L190:
        r150.setDelayedDispatch(null);
        SkuViewModel r151 = r210.f43124f;
        if (r151 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L194:
        if (jg.g.a(r151.getComboId()) == false) goto L293;
        if (r103 == null) goto L295;
        Map<String, SkuItemInfoVO> r152 = r103.getSkuList();
        if (r152 == null) goto L295;
        Collection<SkuItemInfoVO> r153 = r152.values();
        if (r153 == null) goto L295;
        Iterator<T> r154 = r153.iterator();
    L202:
        if (r154.hasNext() == false) goto L209;
        Object r155 = r154.next();
        String r156 = ((SkuItemInfoVO) r155).getId();
        SkuViewModel r157 = r210.f43124f;
        if (r157 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L207:
        if (Intrinsics.areEqual(r156, r157.getComboId()) == false) goto L202;
    L210:
        SkuItemInfoVO r158 = (SkuItemInfoVO) r155;
        if (r158 == null) goto L295;
        SkuViewModel r159 = r210.f43124f;
        if (r159 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L215:
        long r160 = r159.getCurrentCount();
        String r161 = r158.getDeliveryDelayDesc();
        if (r161 != null) goto L218;
    L221:
        boolean r162 = true;
    L222:
        if (r162 == true) goto L295;
        TextView r163 = (TextView) r210.Z().b(R.id.tv_sku_delivery_time).f();
        int r164 = r158.getNowStock();
        long r165 = r158.getStockNum();
        if (r158.getDeliveryDelayDesc() == null) goto L227;
        r158.getDeliveryDelayBackground();
    L227:
        long r166 = r165 + 1;
        long r167 = r164;
        if (0 <= r167) goto L231;
    L265:
        SimpleDraweeView r168 = (SimpleDraweeView) r210.Z().b(R.id.iv_sku_delay_icon).f();
        if (v.a(r158) == false) goto L283;
        String r169 = r158.getDelayDescIcon();
        if (r169 != null) goto L270;
    L273:
        boolean r170 = true;
    L274:
        if (r170 == true) goto L283;
        CharSequence r171 = r163.getText();
        if (r171 != null) goto L278;
    L281:
        if (r110 == true) goto L283;
        r168.setVisibility(0);
        r168.setImageURI(r158.getDelayDescIcon());
    L285:
        if (v.a(r158) == false) goto L287;
        float r172 = 13.0f;
    L288:
        r163.setTextSize(2, r172);
        Context r173 = r210.Y().c();
        if (v.a(r158) == false) goto L291;
        int r174 = R.color.shopping_std_text_black_1;
    L292:
        r163.setTextColor(th.a.a(r173, r174));
        goto L295
    L291:
        r174 = R.color.shopping_std_text_black_3;
        goto L292
    L287:
        r172 = 11.0f;
        goto L288
    L278:
        if (r171.length() == 0) goto L281;
        r110 = false;
        goto L281
    L270:
        if (r169.length() == 0) goto L273;
        r170 = false;
    L283:
        r168.setVisibility(8);
        goto L285
    L231:
        if (r166 <= r167) goto L265;
        if (r160 > r167) goto L256;
        if (((TextView) r210.Z().b(R.id.tv_sku_sold_free).f()).getVisibility() == 0) goto L237;
        r163.setVisibility(0);
        r210.Z().b(R.id.sku_delay_view).f().setVisibility(0);
    L237:
        r210.f43127i = true;
        r163.setText(r158.getDeliveryDelayDesc());
        String r175 = r158.getDeliveryDelayDesc();
        if (r175 != null) goto L240;
    L243:
        boolean r176 = true;
    L244:
        if (r176 == true) goto L250;
        int r177 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r178 = com.bytedance.android.ec.core.utils.s.b(r158.getDeliveryDelayBackground());
        if (r178 == null) goto L248;
        r210.Z().b(R.id.sku_delay_view).f().setBackgroundColor(r178.intValue());
    L249:
        if (r178 == null) goto L250;
    L251:
        SkuViewModel r179 = r210.f43124f;
        if (r179 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L254:
        r179.setDelayedDispatch(0);
        goto L265
    L248:
        r178 = null;
    L250:
        r210.Z().b(R.id.sku_delay_view).f().setBackgroundColor(0);
        goto L251
    L240:
        if (r175.length() == 0) goto L243;
        r176 = false;
        goto L244
    L256:
        if (r160 <= r165) goto L258;
        r163.setVisibility(8);
        r210.Z().b(R.id.sku_delay_view).f().setVisibility(8);
        r210.f43127i = false;
        goto L265
    L258:
        if (((TextView) r210.Z().b(R.id.tv_sku_sold_free).f()).getVisibility() == 0) goto L260;
        r163.setVisibility(0);
        r210.Z().b(R.id.sku_delay_view).f().setVisibility(0);
    L260:
        r163.setText(r158.getPresellDelayDesc());
        r210.f43127i = true;
        SkuViewModel r180 = r210.f43124f;
        if (r180 != null) goto L263;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L263:
        r180.setDelayedDispatch(1);
        goto L265
    L218:
        if (r161.length() == 0) goto L221;
        r162 = false;
        goto L222
    L209:
        r155 = null;
    L295:
        if (r210.f43130l == false) goto L300;
        if (r210.f43128j == true) goto L300;
        r210.o0();
        return;
    L300:
        if (r210.f43131m == true) goto L302;
    L306:
        ((TextView) r210.Z().b(R.id.tv_sku_buy_count_down).f()).setVisibility(8);
        return;
    L302:
        if (r210.f43128j == true) goto L306;
        if (((r210.f43132n - SystemClock.elapsedRealtime()) / 1000) > 86400) goto L327;
        r210.o0();
        return;
    L327:
        return;
    L293:
        ((TextView) r210.Z().b(R.id.tv_sku_delivery_time).f()).setVisibility(8);
        r210.Z().b(R.id.iv_sku_delay_icon).f().setVisibility(8);
        r210.Z().b(R.id.sku_delay_view).f().setVisibility(8);
        r210.f43127i = false;
    L184:
        if (r103 == null) goto L186;
        r149 = r103.getDefaultButtons();
        goto L187
    L186:
        r149 = null;
        goto L187
    L95:
        r119 = false;
        goto L96
    L87:
        r117 = false;
        goto L88
    L90:
        r116 = null;
    L92:
        r118 = null;
        goto L93
    L59:
        if (r109.intValue() != 2) goto L73;
        if (r103.isSoldOut() == true) goto L73;
        if (r103.isUnderStock() == true) goto L73;
        if (r210.f43130l == true) goto L72;
        Long r181 = r210.f43129k;
        if (r181 == null) goto L72;
        if (r181.longValue() == 10) goto L73;
    L72:
        ((LinearLayout) r210.Z().b(R.id.ll_sku_buy_container).f()).setBackgroundResource(R.drawable.shopping_bg_selector_go_to_goods_btn);
        ((TextView) r210.Z().b(R.id.ll_sku_add_container).f()).setEnabled(true);
    L54:
        ((LinearLayout) r210.Z().b(R.id.ll_sku_buy_container).f()).setOnClickListener((ButtonPresenter$newClick$2.a) r210.f43133o.getValue());
        ((TextView) r210.Z().b(R.id.ll_sku_add_container).f()).setOnClickListener((ButtonPresenter$newClick$2.a) r210.f43133o.getValue());
        goto L56
    L45:
        r109 = null;
        goto L47
    L23:
        if (r103 == null) goto L25;
        Long r182 = r103.getSkuType();
    L26:
        r210.f43129k = r182;
        if (r103 != null) goto L29;
    L31:
        boolean r183 = false;
    L32:
        r210.f43130l = r183;
        if (r103 != null) goto L35;
    L37:
        boolean r184 = false;
    L38:
        r210.f43131m = r184;
        if (r103 == null) goto L41;
        long r185 = r103.getCampaignEndTime();
    L42:
        r210.f43132n = r185;
        goto L43
    L41:
        r185 = 0;
        goto L42
    L35:
        if (r103.isInSecKillDefault() != true) goto L37;
        r184 = true;
        goto L38
    L29:
        if (r103.isInDepositPresaleDefault() != true) goto L31;
        r183 = true;
        goto L32
    L25:
        r182 = null;
    L19:
        r108 = null;
        goto L20
    L14:
        r106 = null;
        goto L15
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        SkuViewModel r111 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43124f = r111;
        if (r111 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        boolean r100 = false;
        if (r111.getSkuParams().getAddShopCart() == true) goto L24;
        SkuViewModel r112 = this.f43124f;
        if (r112 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        if (r112.getSkuParams().isFromCartOrInsurance() == true) goto L24;
        SkuViewModel r113 = this.f43124f;
        if (r113 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        if (r113.getSkuParams().isFromMixPage() == true) goto L24;
        SkuViewModel r114 = this.f43124f;
        if (r114 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        if (r114.getSkuParams().isFromHomePageOneCent() == true) goto L24;
        boolean r115 = false;
    L25:
        this.f43128j = r115;
        SkuViewModel r116 = this.f43124f;
        if (r116 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        if (r116.getSkuParams().isFromSuperMarket() == true) goto L59;
        SkuViewModel r117 = this.f43124f;
        if (r117 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        if (r117.getSkuParams().getAddShopCart() == true) goto L59;
        SkuViewModel r118 = this.f43124f;
        if (r118 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        if (r118.getSkuParams().isFromMixPage() == true) goto L59;
        SkuViewModel r119 = this.f43124f;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        if (r119.getSkuParams().isFromShopCart() == true) goto L59;
        SkuViewModel r120 = this.f43124f;
        if (r120 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        if (r120.getSkuParams().isFromInsuranceApply() == true) goto L58;
        SkuViewModel r121 = this.f43124f;
        if (r121 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        if (r121.getSkuParams().isFromMatchPurchase() == true) goto L58;
        String r122 = th.a.g(Y().c(), R.string.shopping_buy_now);
    L60:
        ((TextView) Z().b(R.id.tv_sku_buy_confirm).f()).setText(r122);
        SkuViewModel r123 = this.f43124f;
        if (r123 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L64:
        if (r123.getSkuParams().getActionType() != 4) goto L66;
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setVisibility(0);
    L67:
        SkuViewModel r124 = this.f43124f;
        if (r124 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        if (r124.getSkuParams().getAddShopCart() == false) goto L79;
        SkuViewModel r101 = this.f43124f;
        if (r101 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        Pair[] r102 = new Pair[1];
        SkuViewModel r125 = this.f43124f;
        if (r125 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L78:
        r102[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r125.getSkuParams().getAddCartEntranceInfo());
        SkuViewModel.doSkuEventAction$default(r101, "show_add_to_cart", r102, "a1.b5267.c7323.d1871", PageFinder.via(this.f450897e), null, 16, null);
    L79:
        SkuViewModel r126 = this.f43124f;
        if (r126 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L83:
        if (r126.getSkuParams().getUsePrerenderSku() == false) goto L95;
        SkuViewModel r127 = this.f43124f;
        if (r127 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L88:
        if (r127.getSkuParams().getSkuPrerenderId().length() <= 0) goto L90;
        r100 = true;
    L90:
        if (r100 == false) goto L95;
        SkuViewModel r128 = this.f43124f;
        if (r128 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        r128.getCancelDownTimer().b(ECQuickUtilKt.a(Y()), new n(this));
    L95:
        SkuViewModel r129 = this.f43124f;
        if (r129 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r129.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new o(this));
        int r130 = qf.a.f532712a;
        SkuViewModel r131 = this.f43124f;
        if (r131 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L102:
        if (qf.a.e.a(r131.getSkuParams()) == true) goto L107;
        SkuViewModel r132 = this.f43124f;
        if (r132 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L106:
        r132.m8148getCurrentPrice().b(ECQuickUtilKt.a(Y()), new p(this));
    L111:
        SkuViewModel r133 = this.f43124f;
        if (r133 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L114:
        r133.getSkuInfo().b(ECQuickUtilKt.a(Y()), new r(this));
        SkuViewModel r134 = this.f43124f;
        if (r134 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L117:
        r134.getApplyCouponSuccess().b(ECQuickUtilKt.a(Y()), new ActionObserver(new ButtonPresenter$initSubscribe$6(this)));
        SkuViewModel r135 = this.f43124f;
        if (r135 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L120:
        r135.getCheckPayNotificationAction().b(ECQuickUtilKt.a(Y()), new s(this));
        SkuViewModel r136 = this.f43124f;
        if (r136 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        r136.getDoAddCartMotionAction().b(ECQuickUtilKt.a(Y()), new ActionObserver(new ButtonPresenter$initSubscribe$8(this)));
        SkuViewModel r137 = this.f43124f;
        if (r137 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L126:
        r137.getUnCheckedName().b(ECQuickUtilKt.a(Y()), new t(this));
        return;
    L107:
        SkuViewModel r138 = this.f43124f;
        if (r138 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L110:
        r138.getOnItemChange().b(Y().e(), new q(this));
        goto L111
    L66:
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setVisibility(8);
    L58:
        r122 = th.a.g(Y().c(), R.string.shopping_confirm);
    L59:
        r122 = th.a.g(Y().c(), R.string.shopping_add_to_cart);
    L24:
        r115 = true;
        goto L25
    }

    public final void n0(List<SkuBottomButtons> r110) {
        if (r110 == null) goto L17;
        Iterator<T> r100 = r110.iterator();
    L5:
        if (r100.hasNext() == false) goto L30;
        SkuBottomButtons r101 = (SkuBottomButtons) r100.next();
        if (r110.size() == 1) goto L8;
        if (r101.getButtonType() == 2) goto L11;
        if (r101.getButtonType() == 1) goto L16;
        if (r101.getButtonType() != 3) goto L5;
    L16:
        ((LinearLayout) Z().b(R.id.ll_sku_buy_container).f()).setVisibility(0);
        ((TextView) Z().b(R.id.tv_sku_buy_confirm).f()).setText(r101.getText());
        ((LinearLayout) Z().b(R.id.ll_sku_buy_container).f()).setEnabled(!r101.isGray());
        ((LinearLayout) Z().b(R.id.ll_sku_buy_container).f()).setTag(Integer.valueOf(r101.getButtonType()));
        goto L5
    L11:
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setVisibility(0);
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setText(r101.getText());
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setEnabled(!r101.isGray());
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setTag(Integer.valueOf(r101.getButtonType()));
        goto L5
    L8:
        ((LinearLayout) Z().b(R.id.ll_sku_buy_container).f()).setVisibility(0);
        ((TextView) Z().b(R.id.tv_sku_buy_confirm).f()).setText(r101.getText());
        ((LinearLayout) Z().b(R.id.ll_sku_buy_container).f()).setEnabled(!r101.isGray());
        ((LinearLayout) Z().b(R.id.ll_sku_buy_container).f()).setTag(Integer.valueOf(r101.getButtonType()));
        ((TextView) Z().b(R.id.ll_sku_add_container).f()).setVisibility(8);
        goto L5
    L30:
        return;
    }

    public final void p0(String r110) {
        SkuViewModel r100 = this.f43124f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        ECAdLogExtra r101 = r100.getSkuParams().getAdLogExtra();
        String r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.getCreativeId();
        if (r103 == null) goto L9;
    L19:
        String r104 = r103;
    L21:
        if (r104 != null) goto L23;
        return;
    L23:
        int r105 = ECSdk.f48106a;
        s83.g r106 = (s83.g) ECSdk.a(s83.g.class);
        SkuViewModel r107 = this.f43124f;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        ECAdLogExtra r108 = r107.getSkuParams().getAdLogExtra();
        if (r108 == null) goto L30;
        String r109 = r108.getLogExtra();
        if (r109 == null) goto L30;
    L40:
        String r111 = r109;
    L42:
        Pair[] r112 = new Pair[6];
        SkuViewModel r113 = this.f43124f;
        if (r113 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        String r114 = r113.getSkuParams().getSourcePage();
        String r115 = "";
        if (r114 != null) goto L48;
        r114 = "";
    L48:
        r112[0] = TuplesKt.to("enter_from", r114);
        SkuViewModel r116 = this.f43124f;
        if (r116 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        String r117 = r116.getSkuParams().getShopId();
        if (r117 != null) goto L54;
        r117 = "";
    L54:
        r112[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r117);
        SkuViewModel r118 = this.f43124f;
        if (r118 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        String r119 = r118.getSkuParams().getProductId();
        if (r119 != null) goto L60;
        r119 = "";
    L60:
        r112[2] = TuplesKt.to("product_id", r119);
        SkuViewModel r120 = this.f43124f;
        if (r120 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        String r121 = r120.getSkuParams().getRoomId();
        if (r121 != null) goto L66;
        r121 = "";
    L66:
        r112[3] = TuplesKt.to("room_id", r121);
        SkuViewModel r122 = this.f43124f;
        if (r122 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        String r123 = r122.getSkuParams().getEntranceInfo();
        if (r123 == null) goto L74;
        JSONObject r124 = jg.g.f(r123);
        if (r124 == null) goto L74;
        String r125 = r124.optString("search_id");
    L75:
        if (r125 != null) goto L77;
        r125 = "";
    L77:
        r112[4] = TuplesKt.to("search_id", r125);
        SkuViewModel r126 = this.f43124f;
        if (r126 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L80:
        String r127 = r126.getSkuParams().getEntranceInfo();
        if (r127 == null) goto L85;
        JSONObject r128 = jg.g.f(r127);
        if (r128 == null) goto L85;
        r102 = r128.optString("search_keyword");
    L85:
        if (r102 == null) goto L88;
        r115 = r102;
    L88:
        r112[5] = TuplesKt.to("search_keyword", r115);
        Map<String, ? extends Object> r129 = MapsKt.mutableMapOf(r112);
        int r130 = r110.hashCode();
        if (r130 == 97926) goto L99;
        if (r130 == 3046176) goto L94;
        return;
    L94:
        if (r110.equals("cart") == true) goto L96;
        return;
    L96:
        if (r106 == null) goto L105;
        r106.d("product_detail_ad", "add_to_cart", "button", r104, r111, r129, null, null);
        return;
    L105:
        return;
    L99:
        if (r110.equals("buy") == false) goto L107;
        r129.put("position", "spu_faceplate");
        if (r106 == null) goto L108;
        r106.d("product_detail_ad", "click_buy_right_now", "button", r104, r111, r129, null, null);
        return;
    L108:
        return;
    L107:
        return;
    L74:
        r125 = null;
    L30:
        SkuViewModel r131 = this.f43124f;
        if (r131 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        SkuParams r132 = r131.getSkuParams();
        if (r132 == null) goto L41;
        String r133 = r132.getEntranceInfo();
        if (r133 == null) goto L41;
        JSONObject r134 = jg.g.f(r133);
        if (r134 == null) goto L41;
        r109 = r134.optString("log_extra");
    L41:
        r111 = null;
    L9:
        SkuViewModel r135 = this.f43124f;
        if (r135 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        SkuParams r136 = r135.getSkuParams();
        if (r136 == null) goto L20;
        String r137 = r136.getEntranceInfo();
        if (r137 == null) goto L20;
        JSONObject r138 = jg.g.f(r137);
        if (r138 == null) goto L20;
        r103 = r138.optString("creative_id");
    L20:
        r104 = null;
        goto L21
    }

    public final void q0(boolean r100) {
        if (r100 == false) goto L5;
        ((TextView) Z().b(R.id.tv_sku_sold_free).f()).setVisibility(0);
        ((TextView) Z().b(R.id.tv_sku_delivery_time).f()).setVisibility(8);
        Z().b(R.id.iv_sku_delay_icon).f().setVisibility(8);
        Z().b(R.id.sku_delay_view).f().setVisibility(8);
        return;
    L5:
        ((TextView) Z().b(R.id.tv_sku_sold_free).f()).setVisibility(8);
        if (this.f43127i == false) goto L10;
        ((TextView) Z().b(R.id.tv_sku_delivery_time).f()).setVisibility(0);
        Z().b(R.id.sku_delay_view).f().setVisibility(0);
        return;
    }

    public static final void h0(ButtonPresenter r110, com.bytedance.android.ec.model.response.p r111) {
        r110.getClass();
        long r100 = r111.f47953c;
        if (r100 <= 0) goto L22;
        long r101 = 1000;
        long r102 = (r100 * r101) - System.currentTimeMillis();
        if (r102 <= 0) goto L17;
        StringBuilder r103 = new StringBuilder();
        long r112 = 60000;
        long r113 = r102 / r112;
        long r104 = r102 - (r112 * r113);
        long r114 = 9;
        if (r113 > r114) goto L9;
        r103.append(0);
    L9:
        r103.append(r113);
        r103.append(":");
        long r105 = r104 / r101;
        if (r105 > r114) goto L12;
        r103.append(0);
    L12:
        r103.append(r105);
        String r106 = r111.f47951a;
        if (r106 == null) goto L28;
        Intrinsics.checkNotNull(r106);
        if (StringsKt.contains$default(r106, "${t}", false, 2, null) == false) goto L28;
        String r107 = r111.f47951a;
        Intrinsics.checkNotNull(r107);
        String r115 = StringsKt.replace$default(r107, "${t}", r103.toString(), false, 4, null);
    L30:
        if (TextUtils.isEmpty(r115) == true) goto L32;
        ((TextView) r110.Z().b(R.id.tv_sku_sold_free).f()).setText(r115);
        r110.q0(true);
        return;
    L32:
        r110.q0(false);
        return;
    L28:
        r115 = "";
        goto L30
    L17:
        r110.q0(false);
        SkuViewModel r116 = r110.f43124f;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        SkuViewModel.checkPayNotification$default(r116, false, null, 2, null);
        goto L28
    L22:
        if (r111.f47954d <= 0) goto L28;
        String r108 = r111.f47951a;
        if (r108 == null) goto L28;
        Intrinsics.checkNotNull(r108);
        if (StringsKt.contains$default(r108, "${t}", false, 2, null) == false) goto L28;
        String r109 = r111.f47951a;
        Intrinsics.checkNotNull(r109);
        r115 = StringsKt.replace$default(r109, "${t}", String.valueOf(r111.f47954d), false, 4, null);
        goto L30
    }

    public final void k0(sc3.b r210, String r310) {
        SkuViewModel r100 = this.f43124f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r101 = r100.getSkuInfo().a();
        if (r101 == null) goto L8;
        SkuPoiInfo r102 = r101.getPoiInfo();
    L9:
        if (r102 == null) goto L11;
        Long r103 = r102.getTotal();
    L12:
        Set<String> r104 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.b r110 = ECProcessMonitor.e("ec_sku");
        JSONObject r111 = new JSONObject();
        SkuViewModel r112 = this.f43124f;     // Catch: Exception -> L25
        if (r112 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L25
    L16:
        r111.put("enter_from", r112.getSkuParams().getSourcePage());     // Catch: Exception -> L25
        SkuViewModel r113 = this.f43124f;     // Catch: Exception -> L25
        if (r113 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L25
    L19:
        String r114 = r113.getSkuParams().getEntranceInfo();     // Catch: Exception -> L25
        if (r114 == null) goto L27;
        JSONObject r115 = jg.g.f(r114);     // Catch: Exception -> L25
        if (r115 == null) goto L27;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r115.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE));     // Catch: Exception -> L25
        r111.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r115.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));     // Catch: Exception -> L25
    L27:
        Unit r105 = Unit.INSTANCE;
        ActionRateListener.c(r110, r111, null, false, 6);
        Set<String> r106 = ECProcessMonitor.f45118a;
        ECProcessMonitor.e("ec_sku").d();
        if (r102 == null) goto L41;
        if (r103 == null) goto L41;
        if (r103.longValue() <= 0) goto L41;
        if (r102.getSelectedPoiInfo() != null) goto L41;
        SkuViewModel r107 = this.f43124f;
        if (r107 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        if (r107.getSelectPoiInfo().a() != null) goto L41;
        UIUtils.displayToast(Y().c(), th.a.f(Y().c()).getString(R.string.shopping_sku_tip_select_shop));
        com.bytedance.android.ec.core.monitor.listener.b.k(ECProcessMonitor.e("ec_sku"), -4, null, 30);
        return;
    L41:
        SkuViewModel r108 = this.f43124f;
        if (r108 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        SkuInfoVO r109 = r108.getSkuInfo().a();
        String r116 = "";
        if (r109 == null) goto L51;
        OrderComponent r117 = r109.getOrderComponent();
        if (r117 == null) goto L51;
        String r118 = r117.getOrderUrl();
        if (r118 == null) goto L51;
    L68:
        if (r118.length() <= 0) goto L70;
        boolean r119 = true;
    L71:
        if (r119 == true) goto L74;
        r118 = null;
    L74:
        if (r118 == null) goto L243;
        int r120 = ECSdk.f48106a;
        IAdapterService r121 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r121 == null) goto L80;
        com.bytedance.android.ec.adapter.api.j r122 = r121.getLiveWindowService();
        if (r122 == null) goto L80;
        r122.stopShowFloatInNextLifecycle();
    L80:
        if (r210 == null) goto L82;
        r210.c(ChainPoint.CREATE_SCHEMA_START, null);
    L82:
        BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c7323.d7439", Boolean.FALSE).withView(a0()).build());
        SkuViewModel r123 = this.f43124f;
        if (r123 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L85:
        SkuParams r124 = r123.getSkuParams();
        Map<String, com.bytedance.android.ec.core.monitor.a> r125 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r126 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r126, "type", com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        com.bytedance.android.ec.core.monitor.c.e(r126, "scene", "live");
        com.bytedance.android.ec.core.monitor.c.f(r126, "url", r118);
        if (r124.isLiveSkuCheck() == false) goto L91;
        com.bytedance.android.ec.core.monitor.c.e(r126, "scene", "live");
        com.bytedance.android.ec.core.monitor.c.h(r126, MetricNames.DEAL_DURATION, null);
        int r127 = com.bytedance.android.ec.common.impl.sku.utils.g.f43357a;
        SkuViewModel r128 = this.f43124f;
        if (r128 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L90:
        String r129 = com.bytedance.android.ec.common.impl.sku.utils.g.a(r310, r128);
    L95:
        com.bytedance.android.ec.core.monitor.c.j(r126, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r126);
        Observable.fromCallable(new u(r129, Y().c())).subscribeOn(Schedulers.io()).subscribe();
        String r130 = com.bytedance.android.ec.core.btm.c.c(r129, a0(), "a1.b5267.c7323.d7439", new Pair[0]);
        int r131 = com.bytedance.android.ec.common.impl.sku.utils.p.f43366a;
        Intrinsics.checkNotNullParameter(r130, "url");
        if (StringsKt.contains$default(r130, "webcast_webview", false, 2, null) == false) goto L106;
        int r132 = jg.f.f498945a;
        SkuViewModel r133 = this.f43124f;
        if (r133 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L101:
        if (jg.f.a(r133) == false) goto L106;
        SkuViewModel r134 = this.f43124f;
        if (r134 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        r130 = com.bytedance.android.ec.common.impl.sku.utils.p.b(r130, r134.getSkuParams().isLiveSkuCheck(), 2);
    L106:
        if (r210 == null) goto L108;
        r210.c(ChainPoint.CREATE_SCHEMA_END, null);
    L108:
        if (r210 == null) goto L112;
        String r135 = r210.b(r130);
        if (r135 == null) goto L112;
        r130 = r135;
    L112:
        IEShoppingService r136 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r136 == null) goto L117;
        sc3.c r137 = r136.getBuyNowService();
        if (r137 == null) goto L117;
        r137.j(r130, "a1.b5267.c7323.d7439");
    L117:
        Activity r138 = jg.h.f498946a.getActivity(a0());
        if (r138 == null) goto L132;
        ECProcessMonitor.e("ec_sku").g();
        int r139 = com.bytedance.android.ec.common.impl.sku.utils.i.f43359a;
        SkuViewModel r140 = this.f43124f;
        if (r140 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L122:
        String r141 = r140.getSkuParams().getPromotionLogId();
        if (r141 != null) goto L125;
        r141 = "";
    L125:
        SkuViewModel r142 = this.f43124f;
        if (r142 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L128:
        String r143 = r142.getSkuParams().getSkuLogId();
        if (r143 != null) goto L131;
        r143 = "";
    L131:
        com.bytedance.android.ec.common.impl.sku.utils.i.a(r130, r138, r141, r143, false);
    L132:
        SkuViewModel r144 = this.f43124f;
        if (r144 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L136:
        if (r144.getHalfCloseSku() != 1) goto L141;
        SkuViewModel r145 = this.f43124f;
        if (r145 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L140:
        SkuViewModel.closeDialogFragment$default(r145, null, 1, null);
    L141:
        SkuViewModel r146 = this.f43124f;
        if (r146 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L144:
        SkuParams r147 = r146.getSkuParams();
        String r148 = r147.getEntranceInfo();
        if (r148 != null) goto L239;
    L149:
        String r149 = "";
    L150:
        String r150 = r147.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r147.isFromMatchPurchase() == false) goto L153;
        String r151 = "1";
    L155:
        if (Intrinsics.areEqual(r150, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L199;
        if (r147.isFromPlayback() == false) goto L199;
        if (Intrinsics.areEqual(r116, "product_ranking_homepage") == false) goto L179;
        SkuViewModel r152 = this.f43124f;
        if (r152 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L163:
        SpreadBuilder r153 = new SpreadBuilder(10);
        SkuViewModel r154 = this.f43124f;
        if (r154 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L166:
        r153.add(TuplesKt.to("coupon_id", r154.getApplyCouponIds()));
        SkuViewModel r155 = this.f43124f;
        if (r155 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L169:
        r153.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r155.getComboId()));
        r153.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r150));
        r153.add(TuplesKt.to("product_detail_reply", "1"));
        r153.add(TuplesKt.to("previous_page", r149));
        r153.add(TuplesKt.to("is_matching_product", r151));
        SkuViewModel r156 = this.f43124f;
        if (r156 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        r153.add(TuplesKt.to("recommend_fxh_method", r156.getRecommendTermCount()));
        SkuViewModel r157 = this.f43124f;
        if (r157 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L175:
        r153.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r157.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r158 = this.f43124f;
        if (r158 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L178:
        r153.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r158.getSelectFxhMethod()));
        r153.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r152, "confirm_product_params", (Pair[]) r153.toArray(new Pair[r153.size()]), "a1.b5267.c7323.d7439", PageFinder.via(this.f450897e), null, 16, null);
        return;
    L179:
        SkuViewModel r159 = this.f43124f;
        if (r159 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L182:
        SpreadBuilder r160 = new SpreadBuilder(9);
        SkuViewModel r161 = this.f43124f;
        if (r161 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L185:
        r160.add(TuplesKt.to("coupon_id", r161.getApplyCouponIds()));
        SkuViewModel r162 = this.f43124f;
        if (r162 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L188:
        r160.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r162.getComboId()));
        r160.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r150));
        r160.add(TuplesKt.to("product_detail_reply", "1"));
        r160.add(TuplesKt.to("is_matching_product", r151));
        r160.addSpread(j0());
        SkuViewModel r163 = this.f43124f;
        if (r163 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L191:
        r160.add(TuplesKt.to("recommend_fxh_method", r163.getRecommendTermCount()));
        SkuViewModel r164 = this.f43124f;
        if (r164 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L194:
        r160.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r164.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r165 = this.f43124f;
        if (r165 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L197:
        r160.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r165.getSelectFxhMethod()));
        SkuViewModel.doSkuEventAction$default(r159, "confirm_product_params", (Pair[]) r160.toArray(new Pair[r160.size()]), "a1.b5267.c7323.d7439", PageFinder.via(this.f450897e), null, 16, null);
        return;
    L199:
        if (Intrinsics.areEqual(r116, "product_ranking_homepage") == false) goto L219;
        SkuViewModel r166 = this.f43124f;
        if (r166 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L203:
        SpreadBuilder r167 = new SpreadBuilder(8);
        SkuViewModel r168 = this.f43124f;
        if (r168 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L206:
        r167.add(TuplesKt.to("coupon_id", r168.getApplyCouponIds()));
        SkuViewModel r169 = this.f43124f;
        if (r169 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L209:
        r167.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r169.getComboId()));
        r167.add(TuplesKt.to("previous_page", r149));
        r167.add(TuplesKt.to("is_matching_product", r151));
        r167.addSpread(j0());
        SkuViewModel r170 = this.f43124f;
        if (r170 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L212:
        r167.add(TuplesKt.to("recommend_fxh_method", r170.getRecommendTermCount()));
        SkuViewModel r171 = this.f43124f;
        if (r171 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L215:
        r167.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r171.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r172 = this.f43124f;
        if (r172 != null) goto L218;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L218:
        r167.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r172.getSelectFxhMethod()));
        SkuViewModel.doSkuEventAction$default(r166, "confirm_product_params", (Pair[]) r167.toArray(new Pair[r167.size()]), "a1.b5267.c7323.d7439", PageFinder.via(this.f450897e), null, 16, null);
        return;
    L219:
        SkuViewModel r173 = this.f43124f;
        if (r173 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L222:
        SpreadBuilder r174 = new SpreadBuilder(7);
        SkuViewModel r175 = this.f43124f;
        if (r175 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L225:
        r174.add(TuplesKt.to("coupon_id", r175.getApplyCouponIds()));
        SkuViewModel r176 = this.f43124f;
        if (r176 != null) goto L228;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L228:
        r174.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r176.getComboId()));
        r174.add(TuplesKt.to("is_matching_product", r151));
        r174.addSpread(j0());
        SkuViewModel r177 = this.f43124f;
        if (r177 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L231:
        r174.add(TuplesKt.to("recommend_fxh_method", r177.getRecommendTermCount()));
        SkuViewModel r178 = this.f43124f;
        if (r178 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L234:
        r174.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(r178.getTermCountList()), ",", null, null, 0, null, null, 62, null)));
        SkuViewModel r179 = this.f43124f;
        if (r179 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L237:
        r174.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, r179.getSelectFxhMethod()));
        SkuViewModel.doSkuEventAction$default(r173, "confirm_product_params", (Pair[]) r174.toArray(new Pair[r174.size()]), "a1.b5267.c7323.d7439", PageFinder.via(this.f450897e), null, 16, null);
        return;
    L153:
        r151 = "0";
        goto L155
    L239:
        JSONObject r180 = new JSONObject(r148);     // Catch: Exception -> L148
        r116 = r180.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r149 = r180.optString("previous_page", "");
        goto L150
    L91:
        com.bytedance.android.ec.core.monitor.c.e(r126, "scene", "video");
        com.bytedance.android.ec.core.monitor.c.h(r126, MetricNames.DEAL_DURATION, null);
        int r181 = com.bytedance.android.ec.common.impl.sku.utils.c.f43352a;
        SkuViewModel r182 = this.f43124f;
        if (r182 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        r129 = com.bytedance.android.ec.common.impl.sku.utils.c.a(r118, r182);
        goto L95
    L243:
        return;
    L70:
        r119 = false;
    L51:
        SkuViewModel r183 = this.f43124f;
        if (r183 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L54:
        r118 = r183.getSkuParams().getH5Url();
        if (r118 != null) goto L57;
    L64:
        if (r310 != null) goto L66;
        r118 = "";
        goto L68
    L66:
        r118 = r310;
        goto L68
    L57:
        if (r118.length() <= 0) goto L59;
        boolean r184 = true;
    L60:
        if (r184 == true) goto L63;
        r118 = null;
    L63:
        if (r118 != null) goto L68;
    L59:
        r184 = false;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L27
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = null;
        goto L9
    }

    public static final void d0(ButtonPresenter r100, boolean r101, sc3.b r102) {
        SkuViewModel r103 = r100.f43124f;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r104 = r103.getSkuInfo().a();
        if (r104 == null) goto L10;
        OrderComponent r105 = r104.getOrderComponent();
        if (r105 == null) goto L10;
        String r106 = r105.getOrderUrl();
    L12:
        if (r106 == null) goto L23;
        int r107 = jg.e.f498944a;
        SkuViewModel r108 = r100.f43124f;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        String r109 = r108.getComboId();
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        String r110 = jg.e.c(r106, com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r109);
        SkuViewModel r111 = r100.f43124f;
        if (r111 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r106 = jg.e.c(r110, "combo_num", String.valueOf(r111.getCurrentCount()));
    L23:
        if (r106 == null) goto L34;
        SkuViewModel r112 = r100.f43124f;
        if (r112 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        if (r112.getSkuParams().isLiveSkuCheck() == false) goto L33;
        SkuViewModel r113 = r100.f43124f;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r113.setHalfCloseSku(0);
    L33:
        r100.l0(r101, r106, r102);
        return;
    L34:
        r100.l0(r101, "", r102);
        Lazy r114 = SkuLog.f43090a;
        SkuLog.a("ButtonPresenter", "finalOrderUrl is null: " + r106);
        return;
    L10:
        r106 = null;
        goto L12
    }

    public final void l0(boolean r310, String r311, sc3.b r312) {
        SkuViewModel r100 = this.f43124f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r100.setLastBehaviorBeforeDismiss("forward");
        if (r310 == true) goto L168;
        Set<String> r101 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.a r102 = ECProcessMonitor.d("ec_sku");
        JSONObject r110 = new JSONObject();
        SkuViewModel r111 = this.f43124f;     // Catch: Exception -> L20
        if (r111 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L20
    L11:
        r110.put("enter_from", r111.getSkuParams().getSourcePage());     // Catch: Exception -> L20
        SkuViewModel r112 = this.f43124f;     // Catch: Exception -> L20
        if (r112 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L20
    L14:
        String r113 = r112.getSkuParams().getEntranceInfo();     // Catch: Exception -> L20
        if (r113 == null) goto L22;
        JSONObject r114 = jg.g.f(r113);     // Catch: Exception -> L20
        if (r114 == null) goto L22;
        r110.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r114.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE));     // Catch: Exception -> L20
        r110.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r114.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL));     // Catch: Exception -> L20
    L22:
        Unit r103 = Unit.INSTANCE;
        ActionRateListener.c(r102, r110, null, false, 6);
        Set<String> r104 = ECProcessMonitor.f45118a;
        ECProcessMonitor.d("ec_sku").d();
        SkuViewModel r105 = this.f43124f;
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        if (r105.getCurrentCount() > 0) goto L28;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -6, null, null, null, 14);
    L162:
        int r106 = ECSdk.f48106a;
        IECUserTrackerService r107 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r107 == null) goto L167;
        of.a r108 = r107.getMarketingService();
        if (r108 == null) goto L167;
        r108.a(com.bytedance.android.ec.core.event.a.VALUE_ADD_CART, PostActionType.DO, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L167:
        p0("cart");
        return;
    L28:
        SkuViewModel r109 = this.f43124f;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuInfoVO r115 = r109.getSkuInfo().a();
        if (r115 != null) goto L34;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -7, null, null, null, 14);
        goto L162
    L34:
        SkuViewModel r116 = this.f43124f;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        SkuParams r117 = r116.getSkuParams();
        ECProcessMonitor.d("ec_sku").j(r117.isSchemaOpen(), r117.getSceneType());
        int r118 = com.bytedance.android.ec.common.impl.sku.utils.h.f43358a;
        Fragment r119 = this.f450897e;
        SkuViewModel r120 = this.f43124f;
        if (r120 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        Context r121 = Y().c();
        String r122 = r117.getOriginType();
        String r123 = r117.getOriginId();
        String r124 = r117.getPromotionId();
        String r125 = r117.getProductId();
        if (r125 != null) goto L43;
        String r126 = "";
    L44:
        String r127 = r117.getAuthorId();
        if (r127 != null) goto L47;
        String r128 = "";
    L48:
        String r129 = r117.getRoomId();
        if (r129 != null) goto L51;
        String r130 = "";
    L52:
        String r131 = r117.getShopId();
        if (r131 != null) goto L55;
        String r132 = "";
    L56:
        SkuViewModel r133 = this.f43124f;
        if (r133 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        String r134 = r133.getComboId();
        if (r134 != null) goto L62;
        String r210 = "";
    L63:
        SkuViewModel r135 = this.f43124f;
        if (r135 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        String r211 = String.valueOf(r135.getCurrentCount());
        SkuViewModel r136 = this.f43124f;
        if (r136 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L69:
        List<String> r137 = r136.getCheckedIdArray();
        if (r137 == null) goto L76;
        Object[] r138 = r137.toArray(new String[0]);
        if (r138 == null) goto L75;
        String[] r139 = (String[]) r138;
    L77:
        String[] r212 = r139;
        String r140 = r117.getTrackExtra();
        if (r140 != null) goto L80;
        String r213 = "";
    L81:
        String r214 = BtmSDK.INSTANCE.getPageId(PageFinder.via(this.f450897e));
        String r141 = r117.getChannelId();
        if (r141 != null) goto L84;
        String r215 = "";
    L85:
        Integer r142 = r117.getChannelType();
        if (r142 == null) goto L88;
        int r216 = r142.intValue();
    L89:
        com.bytedance.android.ec.common.impl.sku.utils.h.b(r119, r120, r115, r121, r122, r123, r124, r126, r128, r130, r132, r210, r211, r212, r213, r214, r215, r216, r117.getBizCampaignType(), r117.getCpsTrack());
        SkuViewModel r143 = this.f43124f;
        if (r143 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L92:
        String r144 = r143.getSkuParams().getEntranceInfo();
        if (r144 != null) goto L196;
    L97:
        String r145 = "";
        String r146 = r145;
    L98:
        String r147 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c7323.d1871", Boolean.FALSE).withView(a0()).build());
        SkuViewModel r148 = this.f43124f;
        if (r148 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L102:
        if (r148.getSkuParams().isFromAnchorV3() == true) goto L104;
        SkuViewModel r149 = this.f43124f;
        if (r149 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        if (r149.getSkuParams().isFromVideoFeed() == false) goto L131;
        SkuViewModel r150 = this.f43124f;
        if (r150 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L127:
        SpreadBuilder r151 = new SpreadBuilder(4);
        r151.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r152 = this.f43124f;
        if (r152 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L130:
        r151.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r152.getSelectedSkuId()));
        r151.add(TuplesKt.to("btm_id", r147));
        r151.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r150, "confirm_add_to_cart", (Pair[]) r151.toArray(new Pair[r151.size()]), null, null, null, 28, null);
        goto L162
    L131:
        SkuViewModel r153 = this.f43124f;
        if (r153 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L135:
        if (r153.getSkuParams().isLiveSkuCheck() == false) goto L155;
        SkuViewModel r154 = this.f43124f;
        if (r154 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L139:
        SpreadBuilder r155 = new SpreadBuilder(6);
        r155.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r156 = this.f43124f;
        if (r156 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        r155.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r156.getSelectedSkuId()));
        SkuViewModel r157 = this.f43124f;
        if (r157 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L145:
        String r158 = r157.getSkuParams().getTrackExtra();
        if (r158 != null) goto L194;
        String r159 = null;
    L151:
        r155.add(TuplesKt.to("cart_track", r159));
        SkuViewModel r160 = this.f43124f;
        if (r160 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        r155.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r160.getSkuParams().getAddCartEntranceInfo()));
        r155.add(TuplesKt.to("btm_id", r147));
        r155.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r154, "click_add_to_cart", (Pair[]) r155.toArray(new Pair[r155.size()]), null, null, null, 28, null);
        goto L162
    L194:
        r159 = new JSONObject(r158).optString("cart_track");     // Catch: Exception -> L149
    L149:
        r159 = "";
        goto L151
    L155:
        SkuViewModel r161 = this.f43124f;
        if (r161 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L158:
        SpreadBuilder r162 = new SpreadBuilder(4);
        r162.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r163 = this.f43124f;
        if (r163 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L161:
        r162.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r163.getSelectedSkuId()));
        r162.add(TuplesKt.to("btm_id", r147));
        r162.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r161, "confirm_add_to_cart", (Pair[]) r162.toArray(new Pair[r162.size()]), null, null, null, 28, null);
        goto L162
    L104:
        if (Intrinsics.areEqual(r145, "product_ranking_homepage") == false) goto L112;
        SkuViewModel r164 = this.f43124f;
        if (r164 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L108:
        SpreadBuilder r165 = new SpreadBuilder(5);
        r165.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r166 = this.f43124f;
        if (r166 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L111:
        r165.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r166.getSelectedSkuId()));
        r165.add(TuplesKt.to("previous_page", r146));
        r165.add(TuplesKt.to("btm_id", r147));
        r165.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r164, "confirm_add_to_cart", (Pair[]) r165.toArray(new Pair[r165.size()]), null, null, null, 28, null);
        goto L162
    L112:
        SkuViewModel r167 = this.f43124f;
        if (r167 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        SpreadBuilder r168 = new SpreadBuilder(4);
        r168.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "sku_card"));
        SkuViewModel r169 = this.f43124f;
        if (r169 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L118:
        r168.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r169.getSelectedSkuId()));
        r168.add(TuplesKt.to("btm_id", r147));
        r168.addSpread(j0());
        SkuViewModel.doSkuEventAction$default(r167, "confirm_add_to_cart", (Pair[]) r168.toArray(new Pair[r168.size()]), null, null, null, 28, null);
        goto L162
    L196:
        JSONObject r170 = new JSONObject(r144);     // Catch: Exception -> L96
        r145 = r170.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "");
        r146 = r170.optString("previous_page", "");
        goto L98
    L88:
        r216 = 0;
        goto L89
    L84:
        r215 = r141;
        goto L85
    L80:
        r213 = r140;
        goto L81
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L76:
        r139 = new String[0];
        goto L77
    L62:
        r210 = r134;
        goto L63
    L55:
        r132 = r131;
        goto L56
    L51:
        r130 = r129;
        goto L52
    L47:
        r128 = r127;
        goto L48
    L43:
        r126 = r125;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L22
    L168:
        SkuViewModel r171 = this.f43124f;
        if (r171 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        if (r171.getCurrentCount() <= 0) goto L187;
        SkuViewModel r172 = this.f43124f;
        if (r172 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L177:
        r172.logAdEvent();
        SkuViewModel r173 = this.f43124f;
        if (r173 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L180:
        r173.setApplyCouponIds(null);
        if (this.f43125g == false) goto L186;
        SkuViewModel r174 = this.f43124f;
        if (r174 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L185:
        SkuViewModel.applyCouponAuto$default(r174, Y().c(), r312, r311, null, null, 24, null);
        goto L187
    L186:
        k0(r312, r311);
    L187:
        int r175 = ECSdk.f48106a;
        IECUserTrackerService r176 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r176 == null) goto L192;
        of.a r177 = r176.getMarketingService();
        if (r177 == null) goto L192;
        r177.a(com.bytedance.android.ec.core.event.a.VALUE_CLICK_PURCHASE, PostActionType.DO, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
    L192:
        p0("buy");
    }
}
