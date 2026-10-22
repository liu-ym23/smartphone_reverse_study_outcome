package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.platform.model.NoPasswordGuideSource;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.RechargeMonitorService;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeNoPasswordWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeNoPasswordWidget extends AbsRechargeWidget {
    public static final /* synthetic */ int O = 0;
    public long A;
    public boolean B;
    public boolean C;
    public TextView D;
    public TextView E;
    public TextView F;
    public int G;
    public int H;
    public HSImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public HSImageView f90645J;
    public FrameLayout K;
    public boolean L;
    public ConstraintLayout M;
    public b N;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f90646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f90647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f90648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f90649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f90650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f90651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f90652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HSImageView f90653p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f90654q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f90655r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f90656s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewGroup f90657t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f90658u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f90659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HSImageView f90660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HSImageView f90661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HSImageView f90662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f90663z;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90664a;

        public b(RechargeNoPasswordWidget r100) {
            this.f90664a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            RechargeNoPasswordWidget r100 = this.f90664a;
            RechargeDialogContext r101 = r100.f90579h;
            ConstraintLayout r102 = r100.M;
            if (r102 == null) goto L5;
            int r103 = r102.getHeight();
        L6:
            r101.setNoPasswordDialogHeight(r103);
            return;
        L5:
            r103 = 0;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90665a;

        public c(RechargeNoPasswordWidget r100) {
            this.f90665a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RechargeNoPasswordWidget.Fq(this.f90665a, true);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90666a;

        public d(RechargeNoPasswordWidget r100) {
            this.f90666a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RechargeNoPasswordWidget r101 = this.f90666a;
            int r102 = RechargeNoPasswordWidget.O;
            r101.Bq();
            RechargeNoPasswordWidget.Fq(this.f90666a, true);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90667a;

        public e(RechargeNoPasswordWidget r100) {
            this.f90667a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RechargeNoPasswordWidget r101 = this.f90667a;
            int r102 = RechargeNoPasswordWidget.O;
            r101.Cq();
            RechargeNoPasswordWidget.Fq(this.f90667a, true);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90668a;

        public f(RechargeNoPasswordWidget r100) {
            this.f90668a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f90668a.f90579h.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90669a;

        public g(RechargeNoPasswordWidget r100) {
            this.f90669a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f90669a.f90579h.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90670a;

        public h(RechargeNoPasswordWidget r100) {
            this.f90670a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RechargeNoPasswordWidget.Fq(this.f90670a, true);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90671a;

        public i(RechargeNoPasswordWidget r100) {
            this.f90671a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RechargeNoPasswordWidget.zq(this.f90671a, true);
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90672a;

        public j(RechargeNoPasswordWidget r100) {
            this.f90672a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RechargeNoPasswordWidget.zq(this.f90672a, false);
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargeNoPasswordWidget f90673a;

        public k(RechargeNoPasswordWidget r100) {
            this.f90673a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L6;
            RechargeNoPasswordWidget.Fq(this.f90673a, true);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_recharge_no_password_widget;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r100) {
        Intrinsics.checkNotNullParameter(r100, "dealSet");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Aq() {
        NoPasswordScene r100 = this.f90579h.getNoPasswordScene();
        NoPasswordScene r101 = NoPasswordScene.SCENE_FANS_CLUB_JOIN;
        if (r100 != r101) goto L5;
    L14:
        TextView r102 = this.f90647j;
        if (r102 == null) goto L17;
        r102.setText(s1.B(R.string.ttlive_recharge_no_password_fans_club));
    L17:
        long r103 = com.bytedance.android.live.recharge.nopassword.d.f90050a.f90045b;
        long r104 = this.f90574c;
        if (r104 < r103) goto L21;
        r103 = r104;
    L21:
        this.A = r103;
        TextView r105 = this.f90648k;
        if (r105 == null) goto L24;
        r105.setText(String.valueOf(r103));
    L24:
        TextView r106 = this.f90650m;
        if (r106 == null) goto L27;
        r106.setText(this.f90649l);
    L27:
        long r107 = ((Number) this.f90576e.f89611o.f64752a).longValue();
        long r108 = this.A;
        long r109 = r108 / 10;
        long r110 = r108 % 10;
        if (r110 != 0) goto L30;
        StringBuilder r111 = new StringBuilder();
        r111.append(r109);
        r111.append(20803);
        String r112 = r111.toString();
    L31:
        TextView r113 = this.f90651n;
        if (r113 == null) goto L35;
        r113.setText(s1.C(R.string.ttlive_recharge_no_password_panel_pay_detail, new Object[]{r107 + this.f90649l, this.A + this.f90649l, r112}));
    L35:
        if (this.f90579h.getNoPasswordScene() != r101) goto L39;
        TextView r114 = this.f90654q;
        if (r114 == null) goto L43;
        r114.setText(s1.C(R.string.ttlive_recharge_no_password_pay_and_join_fansclub, new Object[]{r112}));
        return;
    L43:
        return;
    L39:
        TextView r115 = this.f90654q;
        if (r115 == null) goto L45;
        r115.setText(s1.C(R.string.ttlive_recharge_no_password_button_text, new Object[]{r112}));
        return;
    L45:
        return;
    L30:
        StringBuilder r116 = new StringBuilder();
        r116.append(r109);
        r116.append('.');
        r116.append(r110);
        r116.append(20803);
        r112 = r116.toString();
        goto L31
    L5:
        if (this.f90579h.getNoPasswordScene() == NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L14;
        com.bytedance.android.live.recharge.model.b r117 = this.f90579h.getMDialogEntranceParams().f90021j;
        if (r117 == null) goto L17;
        h2 r118 = ((IGiftService) jc1.k.n(IGiftService.class)).findLiteGiftById(r117.f90007e);
        if (r118 == null) goto L17;
        TextView r119 = this.f90647j;
        if (r119 == null) goto L17;
        r119.setText(r118.getName());
        goto L17
    }

    public final void Bq() {
        this.G = 206;
        TextView r100 = this.D;
        if (r100 == null) goto L5;
        r100.setText(s1.B(R.string.ttlive_recharge_no_password_douyin_pay));
    L5:
        HSImageView r101 = this.f90653p;
        if (r101 == null) goto L8;
        r101.setActualImageResource(R.drawable.ttlive_recharge_dialog_no_password_douyin_pay);
    L8:
        HSImageView r102 = this.f90660w;
        if (r102 == null) goto L11;
        r102.setActualImageResource(R.drawable.ttlive_recharge_dialog_no_password_selected);
    L11:
        HSImageView r103 = this.f90661x;
        if (r103 == null) goto L15;
        r103.setActualImageResource(R.drawable.ttlive_recharge_dialog_no_password_unselected);
        return;
    }

    public final void Cq() {
        this.G = 201;
        TextView r100 = this.D;
        if (r100 == null) goto L5;
        r100.setText(s1.B(R.string.ttlive_recharge_no_password_zfb_pay));
    L5:
        HSImageView r101 = this.f90653p;
        if (r101 == null) goto L8;
        r101.setActualImageResource(R.drawable.ttlive_recharge_dialog_no_password_zfb_pay);
    L8:
        HSImageView r102 = this.f90661x;
        if (r102 == null) goto L11;
        r102.setActualImageResource(R.drawable.ttlive_recharge_dialog_no_password_selected);
    L11:
        HSImageView r103 = this.f90660w;
        if (r103 == null) goto L15;
        r103.setActualImageResource(R.drawable.ttlive_recharge_dialog_no_password_unselected);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ViewTreeObserver r100 = this.containerView.getViewTreeObserver();
        b r101 = this.N;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutListener");
    L5:
        r100.removeOnGlobalLayoutListener(r101);
    }

    public RechargeNoPasswordWidget(RechargeDialogContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f90649l = r3.b();
        this.G = 206;
        this.H = 206;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f90647j = (TextView) findViewById(R.id.title);
        this.f90648k = (TextView) findViewById(R.id.diamond_count);
        this.f90651n = (TextView) findViewById(R.id.diamond_detail);
        this.f90650m = (TextView) findViewById(R.id.currency);
        ViewGroup r101 = (ViewGroup) findViewById(R.id.pay_method_container);
        this.f90652o = r101;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        TextView r102 = (TextView) findViewById(R.id.pay_method_label);
        this.f90653p = (HSImageView) findViewById(R.id.pay_method_icon);
        this.f90654q = (TextView) findViewById(R.id.use_no_password_button);
        this.f90655r = (TextView) findViewById(R.id.without_no_password_button);
        this.f90656s = (TextView) findViewById(R.id.protocol);
        this.f90657t = (ViewGroup) findViewById(R.id.pay_method_choose_dialog);
        this.f90658u = (ViewGroup) findViewById(R.id.pay_method_douyin_container);
        this.f90659v = (ViewGroup) findViewById(R.id.pay_method_zfb_container);
        this.f90660w = (HSImageView) findViewById(R.id.select_douyin_pay);
        this.f90661x = (HSImageView) findViewById(R.id.select_zfb_pay);
        this.f90662y = (HSImageView) findViewById(R.id.pay_method_dialog_return_button);
        this.f90663z = findViewById(R.id.srceen_center_recharge_mask);
        this.D = (TextView) findViewById(R.id.pay_method_label);
        this.f90646i = findViewById(R.id.close_view);
        this.F = (TextView) findViewById(R.id.recommend_zfb_pay);
        this.E = (TextView) findViewById(R.id.recommend_douyin_pay);
        this.I = (HSImageView) findViewById(R.id.close_panel_btn);
        this.f90645J = (HSImageView) findViewById(R.id.diamond_icon);
        this.K = (FrameLayout) findViewById(R.id.recharge_no_pw_cj_container);
        this.M = (ConstraintLayout) findViewById(R.id.no_password_widget_panel);
        this.N = new b(this);
        ViewTreeObserver r103 = this.containerView.getViewTreeObserver();
        b r104 = this.N;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutListener");
    L8:
        r103.addOnGlobalLayoutListener(r104);
        ImageUtil.loadImage(this.f90645J, r3.a(), 0);
        HSImageView r105 = this.f90662y;
        if (r105 == null) goto L11;
        r105.setOnClickListener(new c(this));
    L11:
        ViewGroup r106 = this.f90658u;
        if (r106 == null) goto L14;
        r106.setOnClickListener(new d(this));
    L14:
        ViewGroup r107 = this.f90659v;
        if (r107 == null) goto L17;
        r107.setOnClickListener(new e(this));
    L17:
        View r108 = this.f90646i;
        if (r108 == null) goto L20;
        r108.setOnClickListener(new f(this));
    L20:
        HSImageView r109 = this.I;
        if (r109 == null) goto L23;
        r109.setOnClickListener(new g(this));
    L23:
        View r110 = this.f90663z;
        if (r110 == null) goto L26;
        r110.setOnClickListener(new h(this));
    L26:
        TextView r111 = this.f90654q;
        if (r111 == null) goto L29;
        r111.setOnClickListener(new i(this));
    L29:
        TextView r112 = this.f90655r;
        if (r112 == null) goto L33;
        r112.setOnClickListener(new j(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        String r101 = s1.C(R.string.ttlive_charge_present_agree, new Object[]{e4.a()});
        String r102 = s1.C(R.string.ttlive_charge_protocal, new Object[]{e4.a()});
        SpannableStringBuilder r103 = SpannableStringBuilder.valueOf(r101 + r102);
        r103.setSpan(new ForegroundColorSpan(s1.h(R.color.ttlive_live_recharge_protocol_blue)), r101.length(), r101.length() + r102.length(), 18);
        TextView r104 = this.f90656s;
        if (r104 == null) goto L5;
        r104.setText(r103);
    L5:
        TextView r105 = this.f90656s;
        if (r105 == null) goto L8;
        r105.setOnClickListener(new m(this));
    L8:
        RxUtilKt.c(this.f90576e.H.compose(RxUtil.rxSchedulerHelper()).subscribe(new p(this)), this.f90575d);
        RxUtilKt.c(this.f90579h.getCloseNoPasswordPayMethodDialog().subscribe(new k(this)), this.f90575d);
        Eq(true, 10);
        Aq();
        Pair[] r106 = new Pair[4];
        r106[0] = TuplesKt.to("is_first_recharge", String.valueOf(wq()));
        String r107 = "0";
        r106[1] = TuplesKt.to("is_include_discount_package", "0");
        r106[2] = TuplesKt.to(ShareConstants.KEY_PANEL_TYPE, "normal");
        if (((com.bytedance.android.live.recharge.platform.model.f) this.f90579h.getRepository().Q.f64752a).e() == false) goto L11;
        Object r108 = "1";
    L12:
        r106[3] = TuplesKt.to("is_integration_recharge", r108);
        Map r109 = MapsKt.toMutableMap(MapsKt.mapOf(r106));
        HashMap r110 = new HashMap();
        int r111 = com.bytedance.android.live.recharge.utils.m.f90492a;
        com.bytedance.android.live.recharge.utils.m.b(r110, this.f90579h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.c.class});
        r109.putAll(r110);
        if (((Boolean) this.f90579h.getRepository().A.f64752a).booleanValue() == false) goto L15;
        r107 = "1";
    L15:
        r109.put("is_diamond_cache", r107);
        r109.putAll(this.f90579h.getReportExtraInfo("livesdk_recharge_show"));
        com.bytedance.android.live.recharge.utils.m.g("livesdk_recharge_show", String.valueOf(this.A), "password_free", r109, this.f90578g);
        com.bytedance.android.live.recharge.trace.g r112 = com.bytedance.android.live.recharge.trace.f.f90392a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_NO_PASSWORD_PANEL_SHOW, r109);
        return;
    L11:
        r108 = "0";
        goto L12
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r100) {
        Aq();
    }

    public static /* synthetic */ void Fq(RechargeNoPasswordWidget r100, boolean r101) {
        r100.Eq(r101, 300);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void zq(RechargeNoPasswordWidget r210, boolean r211) {
        r210.getClass();
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L5;
        RxUtilKt.r(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(r210.context, RechargeNoPasswordWidget$login$1.INSTANCE), "RechargeNoPasswordWidget");
        return;
    L5:
        Iterator r100 = ((Iterable) r210.f90579h.getRepository().f89603g.f64752a).iterator();
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        com.bytedance.android.live.recharge.deal.d r102 = (com.bytedance.android.live.recharge.deal.d) r101;
    L9:
        com.bytedance.android.live.recharge.deal.d r103 = (com.bytedance.android.live.recharge.deal.d) r101;
        if (r103 == null) goto L81;
        com.bytedance.android.live.recharge.deal.d r104 = com.bytedance.android.live.recharge.deal.d.j(r103, r210.A * ((long) 10.0f), false, 1021);
        r210.f90579h.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        com.bytedance.android.live.recharge.platform.model.f r105 = (com.bytedance.android.live.recharge.platform.model.f) r210.f90576e.Q.f64752a;
        HashMap r110 = new HashMap();
        int r106 = com.bytedance.android.live.recharge.utils.m.f90492a;
        com.bytedance.android.live.recharge.utils.m.b(r110, r210.f90579h.getMDialogEntranceParams(), new Object[]{rw0.b.class});
        r110.put("event_module", "customized");
        NoPasswordPayType r107 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
        if (r211 == true) goto L14;
    L45:
        NoPasswordPayType r111 = r107;
        r110.putAll(r210.f90579h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r108 = com.bytedance.android.live.recharge.deal.g.c(r104);
        if (r108 == null) goto L49;
        String r109 = r108.getDiamondDesc();
        if (r109 == null) goto L49;
    L50:
        r110.put("giving_diamond_badge", r109);
        String r112 = "";
        if (r108 == null) goto L56;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r113 = r108.getCouponBarInfo();
        if (r113 == null) goto L56;
        String r114 = r113.getDesc();
        if (r114 == null) goto L56;
    L57:
        r110.put("giving_diamond_bar", r114);
        if (r108 == null) goto L61;
        String r115 = r108.getPreCalcInfo();
        if (r115 == null) goto L61;
    L62:
        r110.put("pre_calc_info", r115);
        if (r211 == false) goto L65;
        Object r116 = "1";
    L66:
        r110.put("no_password_pay", r116);
        Context r117 = r210.context;
        com.bytedance.android.live.recharge.model.d r118 = r210.f90579h.getMDialogEntranceParams();
        long r212 = ((Number) r210.f90579h.getRepository().f89599c.f64752a).longValue();
        if (r210.L == false) goto L70;
        if (r211 == false) goto L70;
        r112 = "recharge_panel";
    L70:
        r210.f90579h.getOrder().setValue(com.bytedance.android.live.recharge.service.e.b(r104, r117, r110, r118, false, 0, false, false, r212, r111, r112, 4608));
        HashMap r119 = new HashMap();
        r119.put("is_first_recharge", String.valueOf(r210.wq()));
        r119.put("given_scores", String.valueOf(r104.f89708d));
        if (r210.L == false) goto L73;
        Object r120 = "1";
    L74:
        r119.put("is_integration_recharge", r120);
        if (r211 == false) goto L77;
        Object r121 = "1";
    L78:
        r119.put("no_password_pay", r121);
        r119.put("deal_badge", r210.f90579h.getDescription(r104));
        com.bytedance.android.live.recharge.utils.m.b(r119, r210.f90579h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.f.class});
        r119.putAll(r210.f90579h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        com.bytedance.android.live.recharge.utils.m.m(String.valueOf(r210.A), "password_free", String.valueOf(r104.f89707c), r119, r210.f90579h.getMDialogEntranceParams());
        int r122 = com.bytedance.android.live.recharge.utils.o.f90493a;
        com.bytedance.android.live.recharge.utils.o.b(true, RechargeMonitorService.TTLIVE_CHARGE_PAGE_CLICK, MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_module", "password_free"), TuplesKt.to("request_page", "live_detail")})), null);
        return;
    L77:
        r121 = "0";
        goto L78
    L73:
        r120 = "0";
        goto L74
    L65:
        r116 = "0";
    L61:
        r115 = "";
    L56:
        r114 = "";
    L49:
        r109 = r104.f89709e;
        goto L50
    L14:
        if (r210.L == false) goto L35;
        if (r105.e() == false) goto L35;
        ALogger.d("RechargeNoPasswordWidget", "财经免密支付方式");
        JSONObject r123 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).I("recharge_panel");
        if (r123 == null) goto L20;
        r110.put("caijing_pay_params", r123.toString());
    L20:
        String r124 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
        if (r124 == null) goto L23;
        r110.put("sdk_version", r124);
    L23:
        r110.put("create_pay_type", "1");
        r110.put("guide_source", NoPasswordGuideSource.PK_ONE_STEP.getValue());
        r110.put(IPerformanceManager.SCENE_LIVE_PK, "1");
        com.bytedance.android.livesdk.revenue.service.room.c r125 = (com.bytedance.android.livesdk.revenue.service.room.c) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        if (r125 == null) goto L32;
        com.bytedance.android.livesdk.revenue.room.a r126 = r125.getRoomContext();
        if (r126 == null) goto L32;
        com.bytedance.live.datacontext.m<IRoom> r127 = r126.getRoom();
        if (r127 == null) goto L32;
        IRoom r128 = r127.getValue();
        if (r128 == null) goto L32;
        Long r129 = Long.valueOf(r128.getRoomId());
    L33:
        r110.put("roomid", String.valueOf(r129));
        r107 = NoPasswordPayType.USE_ONE_STEP_PAY;
    L40:
        if (r210.f90579h.getNoPasswordScene() != NoPasswordScene.SCENE_FANS_CLUB_JOIN) goto L43;
        r110.put("guide_source", NoPasswordGuideSource.FANS_CLUB_JOIN.getValue());
        goto L45
    L43:
        if (r210.f90579h.getNoPasswordScene() != NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L45;
        r110.put("guide_source", NoPasswordGuideSource.FANS_CLUB_SEND_LIGHT_BOARD.getValue());
    L32:
        r129 = null;
    L35:
        if (r105.d() == false) goto L40;
        if ((!r105.c().isEmpty()) == false) goto L40;
        ALogger.d("RechargeNoPasswordWidget", "支付宝或抖音免密支付");
        r110.put("create_pay_type", "3");
        r110.put("guide_source", NoPasswordGuideSource.DOUYIN_OR_ZFB.getValue());
        r110.put("pk_pay_method", String.valueOf(r210.G));
        r107 = NoPasswordPayType.USE_DY_OR_ZFB_PAY;
        goto L40
    L81:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void Eq(boolean r100, long r101) {
        if (r100 == false) goto L7;
        this.f90579h.setAllowBack(true);
        View r102 = this.f90663z;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        ViewGroup r103 = this.f90657t;
        if (r103 == null) goto L24;
        if (r100 == false) goto L14;
        r103.setVisibility(8);
    L15:
        r103.clearAnimation();
        float r104 = r103.getHeight();
        AnimationSet r105 = new AnimationSet(true);
        if (r100 == false) goto L18;
        float r106 = 0.0f;
    L19:
        if (r100 == true) goto L22;
        r104 = 0.0f;
    L22:
        TranslateAnimation r107 = new TranslateAnimation(0.0f, 0.0f, r106, r104);
        r107.setDuration(r101);
        r105.addAnimation(r107);
        r103.startAnimation(r105);
        return;
    L18:
        r106 = r104;
        goto L19
    L14:
        r103.setVisibility(0);
        goto L15
    L24:
        return;
    L7:
        this.f90579h.setAllowBack(false);
        View r108 = this.f90663z;
        if (r108 == null) goto L10;
        r108.setVisibility(0);
        goto L10
    }
}
