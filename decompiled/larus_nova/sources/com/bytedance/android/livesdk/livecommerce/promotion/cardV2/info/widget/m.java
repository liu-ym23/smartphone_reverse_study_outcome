package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.ec.model.response.ECSalePointDataV2;
import com.bytedance.android.ec.model.response.a0;
import com.bytedance.android.ec.model.response.b0;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.ec.model.response.x;
import com.bytedance.android.ec.model.response.y;
import com.bytedance.android.ec.model.response.z;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class m extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePromotionCardArgs f150654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f150655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f150656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f150657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.k f150658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f150659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECSalePointView f150660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ECSalePointView f150661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ECSalePointViewV2 f150662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ECSalePointViewV2 f150663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.ec.core.utils.rotation.a f150664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public StringBuilder f150665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150666m;

    public static final class a {
    }

    static {
    }

    public m(Context r100) {
        this(r100, null, 14);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "tag_and_sales_point";
    }

    private final ECSalePointViewV2 getSalePointView() {
        ECSalePointViewV2 r100 = new ECSalePointViewV2(getContext());
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f150665l;
        if (r100 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
        LivePromotionCardArgs r100 = this.f150654a;
        if (r100 == null) goto L7;
        ILivePromotionCardContainerHandler r101 = r100.f150038b;
        if (r101 == null) goto L7;
        r101.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r102 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        u r103 = this.f150659f;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L10:
        r102.b(r103);
        com.bytedance.android.ec.core.utils.rotation.a r104 = this.f150664k;
        if (r104 == null) goto L13;
        r104.a();
    L13:
        this.f150664k = null;
        ECSalePointViewV2 r105 = this.f150662i;
        if (r105 == null) goto L16;
        r105.f150619f = null;
        r105.f150620g = null;
        r105.f150621h = false;
        r105.removeAllViews();
        ((LinkedHashMap) r105.f150618e).clear();
    L16:
        ECSalePointViewV2 r106 = this.f150663j;
        if (r106 == null) goto L20;
        r106.f150619f = null;
        r106.f150620g = null;
        r106.f150621h = false;
        r106.removeAllViews();
        ((LinkedHashMap) r106.f150618e).clear();
        return;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a getAbility() {
        return this.f150666m;
    }

    public final void c(ECCarouselData r100) {
        if (r100.getType() != 3) goto L9;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r101 = this.f150666m;
        if (r101 == null) goto L15;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r102 = r101.b();
        if (r102 == null) goto L16;
        r102.r(r100.getEventParam(), ECTagAndSalePointWidget$reportEvent$1.INSTANCE);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r103 = this.f150666m;
        if (r103 == null) goto L18;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r104 = r103.b();
        if (r104 == null) goto L19;
        r104.p(r100.getEventParam(), ECTagAndSalePointWidget$reportEvent$2.INSTANCE);
        return;
    L19:
        return;
    }

    public final void setArgument(LivePromotionCardArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150654a = r100;
    }

    public final void b(ECSalePointViewV2 r110, ECSalePointDataV2 r210) {
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r100 = this.f150658e;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r101 = this.f150666m;
        if (r101 == null) goto L5;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r102 = r101.b();
    L6:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r210, "data");
        r110.removeAllViews();
        ((LinkedHashMap) r110.f150618e).clear();
        r110.f150621h = false;
        r110.f150619f = r210;
        r110.f150620g = r102;
        List<x> r103 = r210.b();
        if (r103 == null) goto L64;
        Iterator<T> r104 = r103.iterator();
        int r105 = 0;
    L10:
        if (r104.hasNext() == false) goto L64;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        x r108 = (x) r106;
        String r111 = a2.d(r108.b());
        if (r111 == null) goto L24;
        Context r112 = r110.getContext();
        TextView r113 = (TextView) r110.f(r110.f150615b);
        if (r113 != null) goto L19;
        r113 = new TextView(r112);
        r113.setTextSize(1, 12.0f);
        r113.setTextColor(th.a.a(r112, R.color.shopping_color_FFFF003C));
        r113.setEllipsize(TextUtils.TruncateAt.END);
        r113.setMaxLines(1);
        r113.setIncludeFontPadding(false);
    L19:
        r113.setText(r111);
        int r114 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r115 = com.bytedance.android.ec.core.utils.s.b(r108.a());
        if (r115 == null) goto L22;
        int r116 = r115.intValue();
    L23:
        r113.setTextColor(r116);
        r113.setEllipsize(TextUtils.TruncateAt.END);
    L25:
        if (r113 == null) goto L63;
        r110.f150618e.put(r113, r108);
        if (r105 <= 0) goto L53;
        Context r109 = r110.getContext();
        y r117 = r210.d();
        if (r117 == null) goto L32;
        Long r118 = r117.b();
    L33:
        if (r118 != null) goto L36;
    L49:
        View r119 = (Space) r110.f(r110.f150616c);
        View r120 = r119;
        if (r119 != null) goto L52;
        Space r121 = new Space(r109);
        r121.setLayoutParams(new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(6), -1));
        r120 = r121;
    L52:
        r110.addView(r120);
        View r122 = r120;
    L54:
        r110.addView(r113);
        if (r122 == null) goto L57;
        r110.setHideGroup(new View[]{r122, r113});
    L57:
        if (r100 == null) goto L63;
        IPromotionUIConfig.d r123 = r100.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r123 == null) goto L63;
        IPromotionUIConfig.b r124 = r123.a();
        if (r124 == null) goto L63;
        UIConfigHelper.c(r113, r124);
        goto L63
    L36:
        if (r118.longValue() != 1) goto L49;
        View r125 = r110.f(r110.f150617d);
        View r126 = r125;
        if (r125 != null) goto L40;
        r126 = new View(r109);
    L40:
        LinearLayoutCompat.LayoutParams r127 = new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), UtilityKotlinExtentionsKt.d(10));
        r127.setMargins(UtilityKotlinExtentionsKt.d(4), 0, UtilityKotlinExtentionsKt.d(4), UtilityKotlinExtentionsKt.d(Double.valueOf(0.3d)));
        Unit r128 = Unit.INSTANCE;
        r126.setLayoutParams(r127);
        r126.setTag(R.id.ec_sale_point_view_tag, "divider_line");
        int r129 = com.bytedance.android.ec.core.utils.s.f45717a;
        y r130 = r210.d();
        if (r130 == null) goto L43;
        String r131 = r130.a();
    L44:
        Integer r132 = com.bytedance.android.ec.core.utils.s.b(r131);
        if (r132 == null) goto L47;
        int r133 = r132.intValue();
    L48:
        r126.setBackgroundColor(r133);
        r120 = r126;
        goto L52
    L47:
        r133 = th.a.a(r109, R.color.shopping_color_73FF003C);
        goto L48
    L43:
        r131 = null;
        goto L44
    L32:
        r118 = null;
        goto L33
    L53:
        r122 = null;
    L63:
        r105 = r107;
        goto L10
    L22:
        r116 = th.a.a(r110.getContext(), R.color.shopping_color_FFFF003C);
        goto L23
    L24:
        r113 = null;
    L64:
        StringBuilder r134 = this.f150665l;
        if (r134 == null) goto L74;
        r134.append(r210.a());
        return;
    L74:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public m(Context r100, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f150666m = r101;
        u r103 = new u(getContext(), r101);
        r103.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Float.valueOf(16.0f))));
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L16;
        ((LinearLayout.LayoutParams) r104).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(6.0f)), 0);
        r103.setVisibility(8);
        Unit r105 = Unit.INSTANCE;
        this.f150659f = r103;
        addView(r103);
        this.f150660g = new ECSalePointView(getContext());
        this.f150661h = new ECSalePointView(getContext());
        FrameLayout r106 = new FrameLayout(getContext());
        ECSalePointView r107 = this.f150660g;
        if (r107 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L10:
        r106.addView(r107);
        ECSalePointView r108 = this.f150661h;
        if (r108 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L13:
        r106.addView(r108);
        ECSalePointViewV2 r109 = getSalePointView();
        this.f150662i = r109;
        r106.addView(r109);
        ECSalePointViewV2 r110 = getSalePointView();
        this.f150663j = r110;
        r106.addView(r110);
        addView(r106);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void a(b0 r210, boolean r211, long r212, com.bytedance.android.livesdk.livecommerce.promotion.card.k r213) {
        Intrinsics.checkNotNullParameter(r210, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r213, "style");
        this.f150655b = r210;
        this.f150656c = r211;
        this.f150657d = r212;
        this.f150658e = r213;
        this.f150665l = new StringBuilder();
        b0 r100 = this.f150655b;
        if (r100 != null) goto L5;
    L63:
        b0 r101 = this.f150655b;
        if (r101 == null) goto L68;
        z r102 = r101.a();
        if (r102 == null) goto L68;
        List<ECSalePointDataV2> r103 = r102.c();
    L70:
        if (r103 == null) goto L72;
        boolean r104 = true;
    L74:
        if (r104 == false) goto L136;
        ECSalePointView r105 = this.f150660g;
        if (r105 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L78:
        r105.setVisibility(8);
        ECSalePointView r106 = this.f150661h;
        if (r106 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L81:
        r106.setVisibility(8);
        ECSalePointViewV2 r107 = this.f150662i;
        if (r107 == null) goto L84;
        r107.setVisibility(8);
    L84:
        ECSalePointViewV2 r108 = this.f150663j;
        if (r108 == null) goto L87;
        r108.setVisibility(8);
    L87:
        b0 r109 = this.f150655b;
        if (r109 == null) goto L90;
        z r110 = r109.a();
    L91:
        b0 r111 = this.f150655b;
        if (r111 == null) goto L100;
        z r112 = r111.a();
        if (r112 == null) goto L100;
        List<ECSalePointDataV2> r113 = r112.c();
        if (r113 == null) goto L100;
        if ((!r113.isEmpty()) == false) goto L100;
        List<ECSalePointDataV2> r114 = r113;
    L101:
        if (r109 == null) goto L198;
        if (r110 == null) goto L199;
        if (r114 == null) goto L200;
        long r115 = r110.a();
        if (r115 > 0) goto L107;
    L129:
        ECSalePointViewV2 r116 = this.f150662i;
        Object r117 = CollectionsKt.firstOrNull(r114);
        if (r116 == null) goto L204;
        if (r117 == null) goto L205;
        ECSalePointDataV2 r118 = (ECSalePointDataV2) r117;
        StringBuilder r119 = this.f150665l;
        if (r119 == null) goto L135;
        StringsKt.clear(r119);
    L135:
        r116.setVisibility(0);
        b(r116, r118);
        return;
    L205:
        return;
    L204:
        return;
    L107:
        if (r114.size() == 1) goto L129;
        if (r114.size() <= 1) goto L201;
        ECSalePointViewV2 r120 = this.f150662i;
        if (r120 == null) goto L213;
        ECSalePointViewV2 r121 = this.f150663j;
        if (r121 == null) goto L214;
        com.bytedance.android.ec.core.utils.rotation.a r122 = this.f150664k;
        if (r122 == null) goto L120;
        r122.a();
    L120:
        this.f150664k = null;
        LivePromotionCardArgs r123 = this.f150654a;
        if (r123 == null) goto L125;
        ILivePromotionCardContainerHandler r124 = r123.f150038b;
        if (r124 == null) goto L125;
        boolean r125 = r124.h(Decision.DEGRADE_SALE_POINT_LOOP);
    L126:
        this.f150664k = new o(this, r120, r121, r114, r114, r115, r115, r125);
        r120.setVisibility(0);
        com.bytedance.android.ec.core.utils.rotation.a r126 = this.f150664k;
        if (r126 == null) goto L202;
        r126.j();
        return;
    L202:
        return;
    L125:
        r125 = false;
        goto L126
    L214:
        return;
    L213:
        return;
    L201:
        return;
    L200:
        return;
    L199:
        return;
    L198:
        return;
    L100:
        r114 = null;
        goto L101
    L90:
        r110 = null;
        goto L91
    L136:
        ECSalePointViewV2 r127 = this.f150662i;
        if (r127 == null) goto L139;
        r127.setVisibility(8);
    L139:
        ECSalePointViewV2 r128 = this.f150663j;
        if (r128 == null) goto L142;
        r128.setVisibility(8);
    L142:
        ECSalePointView r129 = this.f150660g;
        if (r129 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L145:
        r129.setVisibility(8);
        ECSalePointView r130 = this.f150661h;
        if (r130 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L148:
        r130.setVisibility(8);
        b0 r131 = this.f150655b;
        if (r131 == null) goto L151;
        z r132 = r131.a();
    L152:
        b0 r133 = this.f150655b;
        if (r133 == null) goto L161;
        z r134 = r133.a();
        if (r134 == null) goto L161;
        List<ECCarouselData> r135 = r134.b();
        if (r135 == null) goto L161;
        if ((!r135.isEmpty()) == false) goto L161;
    L162:
        if (r131 == null) goto L207;
        if (r132 == null) goto L208;
        if (r135 == null) goto L209;
        ECSalePointCarouselData r136 = new ECSalePointCarouselData(r132.a(), r135, null, 4, null);
        if (r136.getCarouselTime() > 0) goto L168;
    L187:
        ECCarouselData r137 = (ECCarouselData) CollectionsKt.first(r135);
        ECSalePointView r138 = this.f150660g;
        if (r138 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L190:
        r138.setVisibility(0);
        ECSalePointView r139 = this.f150660g;
        if (r139 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L193:
        r139.a(r137, this.f150658e);
        StringBuilder r140 = this.f150665l;
        if (r140 == null) goto L196;
        StringsKt.append(r140, new String[]{r137.getBefore(), r137.getContent()});
    L196:
        c((ECCarouselData) CollectionsKt.first(r135));
        return;
    L168:
        if (r135.size() == 1) goto L187;
        if (r135.size() <= 1) goto L210;
        long r141 = r136.getCarouselTime();
        com.bytedance.android.ec.core.utils.rotation.a r142 = this.f150664k;
        if (r142 == null) goto L175;
        r142.a();
    L175:
        this.f150664k = null;
        LivePromotionCardArgs r143 = this.f150654a;
        if (r143 == null) goto L180;
        ILivePromotionCardContainerHandler r144 = r143.f150038b;
        if (r144 == null) goto L180;
        boolean r145 = r144.h(Decision.DEGRADE_SALE_POINT_LOOP);
    L181:
        this.f150664k = new n(this, r135, r135, r141, r141, r145);
        ECSalePointView r146 = this.f150660g;
        if (r146 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L184:
        r146.setVisibility(0);
        com.bytedance.android.ec.core.utils.rotation.a r147 = this.f150664k;
        if (r147 == null) goto L211;
        r147.j();
        return;
    L211:
        return;
    L180:
        r145 = false;
        goto L181
    L210:
        return;
    L209:
        return;
    L208:
        return;
    L207:
        return;
    L161:
        r135 = null;
        goto L162
    L151:
        r132 = null;
        goto L152
    L72:
        r104 = false;
    L68:
        r103 = null;
        goto L70
    L5:
        if (r100.c() == null) goto L7;
    L13:
        u r148 = this.f150659f;
        if (r148 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L16:
        r148.setVisibility(0);
        final u r149 = this.f150659f;
        if (r149 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L19:
        boolean r150 = this.f150656c;
        long r151 = this.f150657d;
        int r152 = u.f150678k;
        r149.getClass();
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r149.f150683e = r150;
        r149.f150684f = r151;
        r149.f150682d = false;
        t1 r153 = r100.c();
        if (r153 == null) goto L27;
        UtilityKotlinExtentionsKt.f(r153.c(), r153.a(), new TagIVAndCountdownLayout$bind$$inlined$let$lambda$1(r149));
        List<String> r154 = r153.b();
        if (r154 == null) goto L26;
        String r155 = (String) CollectionsKt.firstOrNull(r154);
        if (r155 == null) goto L26;
        h0.e(r149.f150679a, r155, null, null, null, 120);
    L26:
        ExtensionsKt.visible(r149.f150679a);
    L28:
        r149.f150687i = null;
        a0 r156 = r100.b();
        r149.f150681c = r156;
        if (r156 == null) goto L35;
        r149.a(r156);
        ViewGroup.LayoutParams r157 = r149.f150679a.getLayoutParams();
        if (r157 == null) goto L34;
        ((LinearLayout.LayoutParams) r157).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)), 0);
    L38:
        u r158 = this.f150659f;
        if (r158 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L41:
        int r159 = u.f150678k;
        if (r158.c(null) == false) goto L52;
        LivePromotionCardArgs r160 = this.f150654a;
        if (r160 == null) goto L48;
        ILivePromotionCardContainerHandler r161 = r160.f150038b;
        if (r161 == null) goto L48;
        r161.a();
    L48:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r162 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        u r163 = this.f150659f;
        if (r163 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L51:
        r162.a(r163);
        goto L63
    L52:
        LivePromotionCardArgs r164 = this.f150654a;
        if (r164 == null) goto L57;
        ILivePromotionCardContainerHandler r165 = r164.f150038b;
        if (r165 == null) goto L57;
        r165.a();
    L57:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r166 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        u r167 = this.f150659f;
        if (r167 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L60:
        r166.b(r167);
        goto L63
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L35:
        r149.f150680b.setVisibility(8);
        ViewGroup.LayoutParams r168 = r149.f150679a.getLayoutParams();
        if (r168 == null) goto L62;
        ((LinearLayout.LayoutParams) r168).setMargins(0, 0, 0, 0);
        goto L38
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L27:
        r149.f150679a.setVisibility(8);
        goto L28
    L7:
        if (r100.b() != null) goto L13;
        u r169 = this.f150659f;
        if (r169 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L12:
        r169.setVisibility(8);
        goto L38
    }
}
