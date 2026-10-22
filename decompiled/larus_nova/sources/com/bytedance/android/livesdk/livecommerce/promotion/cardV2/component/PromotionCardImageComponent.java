package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.w;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECLiveExplainWaveView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.BottomBannerType;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionFloatIcon;
import com.bytedance.android.ec.model.response.a1;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.HotAtmosphereHelperV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.ECPromotionImageView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.d1;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardImageComponent;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "argument", "", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "ability", "setAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardImageComponent extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public AnimatorSet A;
    public String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePromotionCardArgsV2 f150509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jj2.c f150511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECPromotionImageView f150512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECPromotionTopTagLinearlayout f150513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECDraweeView f150514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f150515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f150516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECDraweeView f150517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ECDraweeView f150518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CardView f150519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ECHotAtmosphereView f150520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AuctionHotAtmosphereView f150521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewStub f150522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a f150523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HotAtmosphereHelperV2 f150524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f150525q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<y0, Unit> f150526r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d1 f150527s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f150528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f150529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f150530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ConstraintLayout f150531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ECDraweeView f150532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ECDraweeView f150533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f150534z;

    public static final class a {
    }

    static {
    }

    public PromotionCardImageComponent(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromotionCardImageComponent(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void c() {
        AnimatorSet r100 = this.A;
        if (r100 != null) goto L5;
    L7:
        this.A = null;
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        r100.cancel();
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        jj2.c r100 = this.f150511c;
        if (r100 != null) goto L5;
    L6:
        c();
        return;
    L5:
        if (r100.f499300n != true) goto L6;
    }

    public final void b(jj2.c r210) {
        Intrinsics.checkNotNullParameter(r210, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        jj2.c r100 = this.f150511c;
        if (r100 == null) goto L5;
        z0 r101 = r100.f499289c;
    L7:
        if ((!Intrinsics.areEqual(r101, r210.f499289c)) == false) goto L11;
        k r102 = this.f150525q;
        if (r102 == null) goto L11;
        Lazy r103 = UIUtils.f45548a;
        UIUtils.c().removeCallbacks(r102);
    L11:
        this.f150511c = r210;
        this.f150512d.setPromotionImageBindConfig(new w(new j(this), null));
        this.f150512d.setForceRadius(8);
        this.f150512d.setCallerContext(new r("ec_live", "goods_info_view"));
        jj2.c r104 = this.f150511c;
        if (r104 == null) goto L20;
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r105 = r104.f499291e;
        if (r105 == null) goto L20;
        IPromotionUIConfig.d r106 = r105.a(PromotionCardModuleName.ImageAreaIndex);
        if (r106 == null) goto L20;
        IPromotionUIConfig.b r107 = r106.a();
        if (r107 == null) goto L20;
        IPromotionUIConfig.b r108 = IPromotionUIConfig.b.a(r107);
        int r109 = UIConfigHelper.f150297a;
        UIConfigHelper.c(this.f150513e, r108);
    L20:
        ECPromotionImageView r110 = this.f150512d;
        LivePromotionCardArgsV2 r111 = this.f150509a;
        if (r111 == null) goto L34;
        ILivePromotionCardContainerHandler r112 = r111.f150038b;
        if (r112 == null) goto L34;
        String r113 = (String) r112.n(ILivePromotionCardContainerHandler.Scene.ExplainBarWaveIcon, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r113 == null) goto L34;
        if (r113.length() <= 0) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == true) goto L33;
        r113 = null;
    L33:
        if (r113 == null) goto L34;
    L35:
        r110.setAnimation(r113);
        jj2.c r115 = this.f150511c;
        if (r115 != null) goto L38;
    L61:
        boolean r116 = r210.f499294h;
        ECPromotionImageView r117 = this.f150512d;
        r117.f150804k.setVisibility(8);
        TextView r118 = r117.f150803j;
        r118.setText(th.a.g(r118.getContext(), R.string.ec_explaining_text));
        this.f150519k.setVisibility(8);
        String r119 = "";
        if (r116 != true) goto L120;
        LivePromotionCardArgsV2 r120 = this.f150509a;
        if (r120 == null) goto L68;
        ILivePromotionCardContainerHandler r121 = r120.f150038b;
        if (r121 == null) goto L68;
        boolean r122 = r121.h(Decision.HIDE_EXPLAINING_ANIM);
    L69:
        ECPromotionImageView r123 = this.f150512d;
        r123.getClass();
        Lazy r124 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L75;
        r123.f150801h.setVisibility(0);
        if (r122 == false) goto L74;
        r123.f150800g.setVisibility(8);
        r123.f150800g.clearAnimation();
    L76:
        TextView r125 = r123.f150803j;
        r125.setText(th.a.g(r125.getContext(), R.string.ec_explaining_text));
        this.f150512d.getExplaingingLayout().setClickable(false);
        jj2.c r126 = this.f150511c;
        if (r126 == null) goto L191;
        z0 r127 = r126.f499289c;
        if (r127 == null) goto L191;
        final a1 r128 = r127.c();
        if (r128 == null) goto L191;
        Long r129 = r128.d();
        if (r129 == null) goto L191;
        if (r129.longValue() <= 50) goto L191;
        this.f150512d.setBottomBannerInfo(r128);
        BottomBannerType r130 = r128.b();
        if (r130 != null) goto L90;
    L91:
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r131 = PromotionCardImageComponent$update3DModelStatus$btmInfo$2.INSTANCE;
    L93:
        LivePromotionCardArgsV2 r132 = this.f150509a;
        if (r132 == null) goto L102;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r133 = r132.f150037a;
        if (r133 == null) goto L102;
        jj2.c r134 = this.f150511c;
        if (r134 == null) goto L100;
        int r135 = r134.f499295i;
    L101:
        final String r136 = r133.a(r131, r135);
    L103:
        com.bytedance.android.ec.core.widget.f.c(this.f150512d.getExplaingingLayout(), null, "bind_key_live_promotion_list", new PromotionCardImageComponent$update3DModelStatus$1(this, r136, r128), 1);
        StringBuilder r137 = new StringBuilder("livesdk_");
        s1 r138 = r128.g();
        if (r138 == null) goto L106;
        String r139 = r138.c();
    L107:
        if (r139 != null) goto L109;
        r139 = "";
    L109:
        r137.append(r139);
        r137.append("_show");
        String r140 = r137.toString();
        LivePromotionCardArgsV2 r141 = this.f150509a;
        if (r141 == null) goto L191;
        il.a r142 = r141.f150041e;
        if (r142 == null) goto L191;
        jj2.c r143 = this.f150511c;
        if (r143 == null) goto L119;
        String r144 = r143.f499292f;
        if (r144 == null) goto L119;
        r119 = r144;
    L119:
        r142.c(r140, r119, new PromotionCardImageComponent$update3DModelStatus$2(this, r136));
        goto L191
    L106:
        r139 = null;
        goto L107
    L100:
        r135 = 0;
    L102:
        r136 = null;
        goto L103
    L90:
        if (c.f150556b[r130.ordinal()] != 1) goto L91;
        r131 = PromotionCardImageComponent$update3DModelStatus$btmInfo$1.INSTANCE;
    L191:
        jj2.c r145 = this.f150511c;
        if (r145 == null) goto L196;
        z0 r146 = r145.f499289c;
        if (r146 == null) goto L196;
        List<y0> r147 = r146.g();
    L197:
        UtilityKotlinExtentionsKt.f(r145, r147, new PromotionCardImageComponent$updateLeftTag$1(this));
        f(r210, false);
        List<ECPromotionFloatIcon> r148 = r210.f499289c.e();
        final ECDraweeView r149 = this.f150512d.getFloatIconView();
        if (r148 == null) goto L241;
        final ECPromotionFloatIcon r150 = (ECPromotionFloatIcon) CollectionsKt.firstOrNull(r148);
        if (r150 == null) goto L241;
        if (r150.getIcon() == null) goto L204;
        boolean r151 = true;
    L205:
        if (r151 == true) goto L208;
        r150 = null;
    L208:
        if (r150 == null) goto L241;
        ViewGroup.LayoutParams r152 = r149.getLayoutParams();
        if ((r152 instanceof LinearLayout.LayoutParams) == true) goto L212;
        r152 = null;
    L212:
        LinearLayout.LayoutParams r153 = (LinearLayout.LayoutParams) r152;
        if (r153 == null) goto L240;
        Long r154 = r150.getPos();
        if (r154 != null) goto L218;
    L220:
        Long r155 = r150.getPos();
        if (r155 != null) goto L224;
    L226:
        ECUrlModel r156 = r150.getIcon();
        if (r156 == null) goto L229;
        int r157 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r156.getWidth()));
    L230:
        r153.width = r157;
        ECUrlModel r158 = r150.getIcon();
        if (r158 == null) goto L233;
        int r159 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r158.getHeight()));
    L234:
        r153.height = r159;
        r149.setLayoutParams(r153);
        r149.setVisibility(0);
        h0.d(r149, r150.getIcon(), new r("ec_live", "ec_promotion_card_float_icon"), null, null, null, null, 120);
        String r160 = r150.getJumpUrl();
        if (r160 == null) goto L239;
        final String r161 = a2.d(r160);
        if (r161 == null) goto L239;
        com.bytedance.android.ec.core.widget.f.c(r149, null, null, new PromotionCardImageComponent$updateFloatIcon$$inlined$also$lambda$1(r161, r150, this, r149), 3);
    L242:
        jj2.c r162 = this.f150511c;
        if (r162 == null) goto L252;
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r163 = r162.f499291e;
        if (r163 == null) goto L252;
        IPromotionUIConfig.d r164 = r163.a(PromotionCardModuleName.HotAtmosphere);
        if (r164 == null) goto L252;
        int r165 = UIConfigHelper.f150297a;
        UIConfigHelper.d(this.f150520l, r164);
        AuctionHotAtmosphereView r166 = this.f150521m;
        if (r166 == null) goto L252;
        UIConfigHelper.d(r166, r164);
    L252:
        if (r210.f499290d != UpdateType.UPDATE_EXPOSE) goto L255;
        this.f150529u = true;
        return;
    L255:
        return;
    L239:
        r149.setOnClickListener(null);
        Unit r167 = Unit.INSTANCE;
        goto L242
    L233:
        r159 = 0;
        goto L234
    L229:
        r157 = 0;
        goto L230
    L224:
        if (r155.longValue() != 2) goto L226;
        r153.gravity = GravityCompat.END;
        goto L226
    L218:
        if (r154.longValue() != 1) goto L220;
        r153.gravity = GravityCompat.START;
        goto L226
    L240:
        r149.setVisibility(8);
        Unit r168 = Unit.INSTANCE;
        goto L242
    L204:
        r151 = false;
    L241:
        r149.setVisibility(8);
        Unit r169 = Unit.INSTANCE;
    L196:
        r147 = null;
        goto L197
    L74:
        r123.f150800g.setVisibility(0);
        r123.f150800g.setAnimation(r123.f150807n);
        r123.f150800g.playAnimation();
        r123.f150800g.loop(true);
        goto L76
    L75:
        r123.f150798e.setVisibility(0);
        ECLiveExplainWaveView r170 = r123.f150799f.f45915a;
        r170.f45975k = true;
        r170.invalidate();
    L68:
        r122 = false;
        goto L69
    L120:
        if (r116 == true) goto L191;
        jj2.c r171 = this.f150511c;
        if (r171 == null) goto L191;
        z0 r172 = r171.f499289c;
        if (r172 == null) goto L191;
        final a1 r173 = r172.c();
        if (r173 == null) goto L191;
        Long r174 = r173.d();
        if (r174 == null) goto L191;
        if (r174.longValue() >= 50) goto L191;
        jj2.c r175 = this.f150511c;
        if (r175 == null) goto L140;
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r176 = r175.f499291e;
        if (r176 == null) goto L140;
        IPromotionUIConfig.d r177 = r176.a(PromotionCardModuleName.ImageAreaBottomTip);
        if (r177 == null) goto L140;
        Boolean r178 = r177.d();
        if (r178 == null) goto L140;
        boolean r179 = r178.booleanValue();
    L141:
        if (r179 == false) goto L190;
        BottomBannerType r180 = r173.b();
        if (r180 != null) goto L146;
    L147:
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r181 = PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$btmInfo$2.INSTANCE;
    L148:
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r182 = r181;
        LivePromotionCardArgsV2 r183 = this.f150509a;
        if (r183 == null) goto L159;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r184 = r183.f150037a;
        if (r184 == null) goto L159;
        jj2.c r185 = this.f150511c;
        if (r185 == null) goto L157;
        Integer r186 = Integer.valueOf(r185.f499295i);
    L158:
        final String r187 = r184.a(r182, com.bytedance.android.shopping.extensions.k.g(r186, 0));
    L160:
        StringBuilder r188 = new StringBuilder("livesdk_");
        s1 r189 = r173.g();
        if (r189 == null) goto L163;
        String r190 = r189.c();
    L164:
        if (r190 != null) goto L166;
        r190 = "";
    L166:
        r188.append(r190);
        r188.append("_show");
        String r191 = r188.toString();
        LivePromotionCardArgsV2 r192 = this.f150509a;
        if (r192 == null) goto L176;
        il.a r193 = r192.f150041e;
        if (r193 == null) goto L176;
        jj2.c r194 = this.f150511c;
        if (r194 == null) goto L174;
        String r195 = r194.f499292f;
        if (r195 == null) goto L174;
    L175:
        r193.c(r191, r195, new PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$1(this, r187));
    L174:
        r195 = "";
    L176:
        String r196 = a2.d(r173.f());
        if (r196 != null) goto L179;
        r196 = th.a.g(getContext(), R.string.ec_promotion_list_tip_look_explain);
    L179:
        this.f150516h.setText(r196);
        this.f150519k.setAlpha(1.0f);
        a(this.f150517i, r173.c(), "ec_promotion_card_bottom_banner_left");
        a(this.f150518j, r173.e(), "ec_promotion_card_bottom_banner_right");
        Integer r197 = ECLiveABUtils.INSTANCE.getEC_LIVE_LIST_REPLAY_BUTTON_ENHANCE();
        if (r197 != null) goto L183;
    L188:
        this.f150519k.setBackgroundResource(R.drawable.ec_bg_audience_live_promotion_explain_end);
        this.f150519k.setCardElevation(0.0f);
    L189:
        this.f150519k.setVisibility(0);
        com.bytedance.android.ec.core.widget.f.c(this.f150519k, null, "bind_key_live_promotion_list", new PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$3(this, r187, r173), 1);
        this.f150519k.setFocusable(true);
        this.f150519k.setContentDescription(r196 + th.a.g(getContext(), R.string.ec_button));
        goto L191
    L183:
        if (r197.intValue() != 1) goto L188;
        ViewGroup.LayoutParams r198 = this.f150519k.getLayoutParams();
        if (r198 == null) goto L187;
        r198.height = UtilityKotlinExtentionsKt.d(22);
        this.f150519k.setLayoutParams(r198);
    L187:
        this.f150519k.setRadius(q.a(11));
        this.f150519k.setCardElevation(q.a(2));
        this.f150519k.setCardBackgroundColor(th.a.a(getContext(), R.color.ec_color_E5FFFFFF));
        this.f150516h.setTextSize(1, 11.0f);
        goto L189
    L163:
        r190 = null;
        goto L164
    L157:
        r186 = null;
    L159:
        r187 = null;
        goto L160
    L146:
        if (c.f150555a[r180.ordinal()] != 1) goto L147;
        r181 = PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$btmInfo$1.INSTANCE;
        goto L148
    L190:
        this.f150519k.setVisibility(8);
    L140:
        r179 = true;
        goto L141
    L38:
        if (this.f150528t == false) goto L51;
        this.f150512d.a();
        d1 r199 = this.f150527s;
        if (r199 == null) goto L50;
        r199.f153074a = 1;
        if (r199.f153075b == true) goto L47;
        Runnable r200 = r199.f153076c;
        if (r200 == null) goto L46;
        r200.run();
    L46:
        boolean r201 = true;
    L48:
        if (r201 == false) goto L50;
        r199.f153075b = true;
        goto L50
    L47:
        r201 = false;
    L50:
        this.f150528t = false;
    L52:
        String r202 = r115.f499289c.h();
        if (r202 == null) goto L55;
        ECPromotionImageView r203 = this.f150512d;
        r203.f150797d.setText(r202);
        r203.f150797d.setVisibility(0);
    L55:
        ECPromotionImageView r204 = this.f150512d;
        String r205 = r115.f499289c.b();
        r204.getClass();
        if (TextUtils.isEmpty(r205) == true) goto L58;
        r204.f150796c.setVisibility(0);
        ECLiveImageUtils.i(r204.f150796c, r205, r204.getImageRadius(), android.R.color.transparent);
        goto L61
    L58:
        ECNetImageView r206 = r204.f150796c;
        if (r206 == null) goto L61;
        r206.setVisibility(8);
        goto L61
    L51:
        ECPromotionImageView r207 = this.f150512d;
        y.e(r207.f150795b, r115.f499289c.d(), -1, -1, r207.f150806m);
        r207.a();
        goto L52
    L29:
        r114 = false;
    L34:
        r113 = "live_music_wave_icon_normal.json";
        goto L35
    L5:
        r101 = null;
        goto L7
    }

    public final void d(z0 r110) {
        Intrinsics.checkNotNullParameter(r110, "promotionImage");
        boolean r100 = true;
        this.f150528t = true;
        this.f150527s = new d1();
        String r101 = r110.d();
        r r102 = new r("ec_live", "goods_info_view");
        Function1<Bitmap, Unit> r103 = new PromotionCardImageComponent$fetchCoverImage$1(this);
        h0 r111 = h0.f44678a;
        if (r101 != null) goto L5;
    L8:
        if (r100 == true) goto L12;
        ImageExtensionsKt.f(r101, r102, null, null, null, r103, 96);
        return;
    L12:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r100 = false;
        goto L8
    }

    public final void setAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f150510b = r100;
    }

    public final void setArgument(final LivePromotionCardArgsV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150509a = r100;
        this.f150520l.setDegradeModeCallback(new PromotionCardImageComponent$updateHotAtmosphereDegradeStatus$1(r100));
    }

    public static void e(View r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public final void f(jj2.c r100, boolean r101) {
        ECHotAtmosphere r102 = r100.f499289c.f();
        ECAuctionAtmosphere r103 = r100.f499289c.a();
        int r104 = 0;
        if (r102 == null) goto L14;
        String r105 = r102.num;
        if (r105 == null) goto L11;
        Integer r106 = StringsKt.toIntOrNull(r105);
        if (r106 == null) goto L9;
        int r107 = r106.intValue();
    L10:
        if (r107 > 0) goto L14;
    L9:
        r107 = 0;
    L11:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r108 = this.f150510b;
        if (r108 == null) goto L14;
        r108.e(Action.SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR);
    L14:
        if (r103 == null) goto L48;
        ECAuctionDigitalAtmosphere r109 = r103.getDigital();
        View r110 = null;
        if (r109 == null) goto L21;
        ECAuctionAtmosphereData r111 = r109.getData();
        if (r111 == null) goto L21;
        String r112 = r111.getNum();
        if (r112 == null) goto L21;
    L27:
        if (r112 == null) goto L32;
        Integer r113 = StringsKt.toIntOrNull(r112);
        if (r113 == null) goto L31;
        r104 = r113.intValue();
    L31:
        if (r104 <= 0) goto L32;
    L36:
        if (this.f150521m != null) goto L48;
        ViewStub r114 = this.f150522n;
        if (r114 == null) goto L40;
        View r115 = r114.inflate();
    L42:
        if ((r115 instanceof AuctionHotAtmosphereView) == false) goto L45;
        r110 = r115;
    L45:
        final AuctionHotAtmosphereView r116 = (AuctionHotAtmosphereView) r110;
        if (r116 == null) goto L48;
        this.f150521m = r116;
        this.f150524p = new HotAtmosphereHelperV2(r116, this.f150513e, new PromotionCardImageComponent$inflateAuctionAtmosphereView$$inlined$also$lambda$1(r116, this));
        goto L48
    L40:
        r115 = null;
    L32:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r117 = this.f150510b;
        if (r117 == null) goto L36;
        r117.e(Action.SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR);
    L21:
        ECAuctionCountdownAtmosphere r118 = r103.getCountDown();
        if (r118 == null) goto L26;
        ECAuctionAtmosphereData r119 = r118.getData();
        if (r119 == null) goto L26;
        r112 = r119.getNum();
    L26:
        r112 = null;
    L48:
        if (r103 == null) goto L55;
        HotAtmosphereHelperV2 r120 = this.f150524p;
        if (r120 == null) goto L52;
        r120.a(r100, r101);
    L52:
        HotAtmosphereHelperV2 r121 = this.f150524p;
        if (r121 == null) goto L62;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(r121);
        return;
    L62:
        return;
    L55:
        HotAtmosphereHelperV2 r122 = this.f150524p;
        if (r122 == null) goto L58;
        r122.c(r100);
    L58:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a r123 = this.f150523o;
        if (r123 == null) goto L64;
        r123.a(r100, r101);
        return;
    }

    public PromotionCardImageComponent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150526r = new PromotionCardImageComponent$clearFlickerIcon$1(this);
        this.f150530v = UtilityKotlinExtentionsKt.d(20);
        th.a.c(r100, R.layout.shopping_layout_promotion_card_image_module_v2, this, true);
        this.f150512d = (ECPromotionImageView) findViewById(R.id.piv_image);
        ECPromotionTopTagLinearlayout r103 = (ECPromotionTopTagLinearlayout) findViewById(R.id.top_left_tag_layout);
        this.f150513e = r103;
        this.f150514f = (ECDraweeView) findViewById(R.id.iv_status_tag);
        this.f150515g = (TextView) findViewById(R.id.tv_promotion_index);
        this.f150519k = (CardView) findViewById(R.id.tv_explain_layout);
        this.f150517i = (ECDraweeView) findViewById(R.id.tv_explain_left_icon);
        this.f150518j = (ECDraweeView) findViewById(R.id.tv_explain_right_icon);
        this.f150516h = (TextView) findViewById(R.id.tv_explain_end);
        ECHotAtmosphereView r104 = (ECHotAtmosphereView) findViewById(R.id.layout_hot_atmosphere);
        this.f150520l = r104;
        this.f150522n = (ViewStub) findViewById(R.id.layout_hot_atmosphere_auction_stub);
        this.f150531w = (ConstraintLayout) findViewById(R.id.status_fold_container);
        this.f150532x = (ECDraweeView) findViewById(R.id.status_fold_tag);
        this.f150533y = (ECDraweeView) findViewById(R.id.status_fold_bg);
        this.f150534z = (TextView) findViewById(R.id.status_fold_text);
        int r105 = UtilityKotlinExtentionsKt.d(8);
        int r106 = UtilityKotlinExtentionsKt.d(8);
        r103.f153238a.d(r105, 0, 0, r106);
        this.f150523o = new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a(r104, r103, new AnonymousClass1(this));
    }

    public static void a(ECDraweeView r110, ECUrlModel r111, String r112) {
        if (r111 == null) goto L20;
        boolean r100 = false;
        r110.setVisibility(0);
        ViewGroup.LayoutParams r101 = r110.getLayoutParams();
        if (r101 == null) goto L19;
        Integer r102 = Integer.valueOf(r111.getWidth());
        if (r102.intValue() <= 0) goto L8;
        boolean r103 = true;
    L9:
        Integer r104 = null;
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        r101.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r102, 12)));
        Integer r105 = Integer.valueOf(r111.getHeight());
        if (r105.intValue() <= 0) goto L16;
        r100 = true;
    L16:
        if (r100 == false) goto L18;
        r104 = r105;
    L18:
        r101.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r104, 12)));
        r110.setLayoutParams(r101);
        goto L19
    L8:
        r103 = false;
    L19:
        h0.d(r110, r111, new r("ec_live", r112), null, null, null, null, 120);
        return;
    L20:
        r110.setVisibility(8);
        Unit r113 = Unit.INSTANCE;
    }

    public /* synthetic */ PromotionCardImageComponent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
