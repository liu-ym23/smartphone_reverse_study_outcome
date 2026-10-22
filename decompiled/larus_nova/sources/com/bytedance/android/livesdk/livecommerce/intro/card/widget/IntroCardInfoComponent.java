package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoBenefitLabelWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoCustomTagWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoElasticTitleWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoProgressBarWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoTagWidget;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroBenefit;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.i0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardInfoComponent;", "Landroid/widget/LinearLayout;", "", "", "getComponentContentDescription", "Loh2/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/widget/FrameLayout;", "d", "Lkotlin/Lazy;", "getShowViewGroup1", "()Landroid/widget/FrameLayout;", "showViewGroup1", "e", "getShowViewGroup2", "showViewGroup2", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardInfoComponent extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f147973g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f147974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public oh2.c f147975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a> f147976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f147977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f147978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f147979f;

    public static final class a {
    }

    static {
    }

    public IntroCardInfoComponent(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IntroCardInfoComponent(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final FrameLayout getShowViewGroup1() {
        return (FrameLayout) this.f147977d.getValue();
    }

    private final FrameLayout getShowViewGroup2() {
        return (FrameLayout) this.f147978e.getValue();
    }

    public final void c() {
        c r100 = this.f147979f;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f147979f = null;
        getShowViewGroup1().removeAllViews();
        getShowViewGroup2().removeAllViews();
    }

    public final void f() {
        Iterator<T> r100 = this.f147976c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r100.next()).release();
        goto L4
    L6:
        ((ArrayList) this.f147976c).clear();
        c();
    }

    public final String getComponentContentDescription() {
        StringBuilder r100 = new StringBuilder();
        Iterator<T> r101 = this.f147976c.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r101.next()).getCurrentContentDescription());
        goto L4
    L7:
        return r100.toString();
    }

    public e getArgument() {
        return this.f147974a;
    }

    public oh2.c getContainerAbility() {
        return this.f147975b;
    }

    public final void e(com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a r100) {
        r100.setArgument(getArgument());
        r100.setContainerAbility(getContainerAbility());
    }

    public void setArgument(e r100) {
        this.f147974a = r100;
    }

    public void setContainerAbility(oh2.c r100) {
        this.f147975b = r100;
    }

    public final void a(g r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "benefitsModel");
        removeAllViews();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_RELEASE_FIX() == false) goto L8;
        Iterator<T> r102 = this.f147976c.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r102.next()).release();
    L8:
        ((ArrayList) this.f147976c).clear();
        c();
        List<p0> r103 = r100.a();
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
        int r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L25;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Pair<LinearLayout, Integer> r108 = d((p0) r106, r101);
        LinearLayout r109 = r108.component1();
        int r110 = r108.component2().intValue();
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-1, -2);
        if (r105 <= 0) goto L19;
        r111.topMargin = r110;
    L19:
        Unit r112 = Unit.INSTANCE;
        addView(r109, r111);
        r105 = r107;
        goto L12
    L25:
        return;
    }

    public final void b(l r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "benefitsModel");
        List<p0> r100 = r110.b();
        if (r100 != null) goto L5;
    L8:
        removeAllViews();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_RELEASE_FIX() == false) goto L14;
        Iterator r101 = ((ArrayList) this.f147976c).iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        ((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r101.next()).release();
    L14:
        ((ArrayList) this.f147976c).clear();
        c();
        addView(getShowViewGroup1(), new LinearLayout.LayoutParams(-1, -2));
        addView(getShowViewGroup2(), new LinearLayout.LayoutParams(-1, -2));
        List<p0> r102 = r110.b();
        if (r102 == null) goto L21;
        long r103 = r110.a() * ((long) 1000);
        FrameLayout r112 = getShowViewGroup1();
        FrameLayout r104 = getShowViewGroup2();
        c();
        this.f147979f = new c(this, r112, r104, r111, r102, r102, r103, r103);
        r112.setVisibility(0);
        c r105 = this.f147979f;
        if (r105 == null) goto L22;
        r105.j();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r100.size() != 1) goto L8;
        a(new g(r110.b()), r111);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r23v0, types: [android.widget.LinearLayout, com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardInfoComponent] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.widget.LinearLayout, java.lang.Object] */
    public final Pair<LinearLayout, Integer> d(p0 r210, int r211) {
        th2.b r100 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r211));
        int r101 = 1;
        int r102 = 0;
        AttributeSet r103 = null;
        if (r100 == null) goto L13;
        Integer r104 = Integer.valueOf(r100.f());
        if (r104.intValue() < 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        int r106 = r104.intValue();
    L14:
        int r107 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r106));
        ?? r108 = new LinearLayout(getContext());
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r108.setOrientation(0);
        List<IntroBenefit> r109 = r210.a();
        if (r109 == null) goto L234;
        Iterator r110 = r109.iterator();
        int r111 = 0;
    L18:
        if (r110.hasNext() == false) goto L234;
        Object r112 = r110.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        IntroBenefit r114 = (IntroBenefit) r112;
        Integer r115 = r114.b();
        int r116 = 2;
        int r117 = 6;
        if (r115 != null) goto L26;
    L70:
        if (r115 != null) goto L73;
    L185:
        Iterator r212 = r110;
        if (r115 != null) goto L189;
    L194:
        if (r115 != null) goto L197;
    L203:
        if (r115 != null) goto L206;
    L208:
        if (r115 != null) goto L211;
    L207:
        AttributeSet r118 = null;
        Object r119 = null;
    L219:
        int r120 = -2;
        Object r121 = r119;
    L217:
        int r122 = -2;
        ?? r123 = r121;
    L221:
        if ((r123 instanceof com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) == true) goto L223;
        ?? r124 = r118;
    L224:
        if (r124 == 0) goto L226;
        ((ArrayList) this.f147976c).add(r124);
    L226:
        if (r123 == 0) goto L232;
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(r122, r120);
        if (r111 <= 0) goto L230;
        r125.setMarginStart(UtilityKotlinExtentionsKt.d(4));
    L230:
        Unit r126 = Unit.INSTANCE;
        r108.addView(r123, r125);
    L232:
        r103 = r118;
        r111 = r113;
        r110 = r212;
        r101 = 1;
        r102 = 0;
        goto L18
    L223:
        r124 = r123;
        goto L224
    L211:
        if (r115.intValue() != 6) goto L207;
        List<ECRitTag> r127 = r114.c();
        if (r127 != null) goto L214;
    L193:
        r118 = null;
    L216:
        r119 = r118;
        goto L219
    L214:
        r118 = null;
        IntroInfoCustomTagWidget r128 = new IntroInfoCustomTagWidget(getContext(), r118, r117, 0);
        e(r128);
        r128.a(r127);
        Object r129 = r128;
    L215:
        r119 = r129;
        goto L219
    L206:
        if (r115.intValue() != 5) goto L208;
    L197:
        if (r115.intValue() != 4) goto L203;
        i0 r130 = r114.e();
        if (r130 == null) goto L201;
        IntroInfoProgressBarWidget r131 = new IntroInfoProgressBarWidget(getContext(), null, r117, 0);
        e(r131);
        r131.a(r130);
        r122 = -1;
    L202:
        r123 = r131;
        r118 = null;
        r120 = -2;
        goto L221
    L201:
        r131 = null;
        r122 = -2;
        goto L202
    L189:
        if (r115.intValue() != 3) goto L194;
        List<PromotionBenefitLabel> r132 = r114.a();
        if (r132 == null) goto L193;
        IntroInfoBenefitLabelWidget r133 = new IntroInfoBenefitLabelWidget(getContext(), null, r117, 0);
        e(r133);
        r133.a(r132);
        r118 = null;
        r129 = r133;
        goto L215
    L73:
        if (r115.intValue() != 2) goto L185;
        List<ECRitTag> r134 = r114.f();
        if (r134 == null) goto L184;
        IntroInfoTagWidget r135 = new IntroInfoTagWidget(getContext(), r103, r117, r102);
        e(r135);
        Intrinsics.checkNotNullParameter(r134, PromotionProductPrivilegesStruct.TAGS);
        r135.f148081d = new StringBuilder();
        r135.f148082e = r134;
        List<ECRitTag> r136 = r134;
        Iterator r137 = r136.iterator();
        int r138 = 0;
    L78:
        if (r137.hasNext() == false) goto L174;
        Object r139 = r137.next();
        int r140 = r138 + 1;
        if (r138 >= 0) goto L82;
        CollectionsKt.throwIndexOverflow();
    L82:
        ECRitTag r141 = (ECRitTag) r139;
        ECUIConfig r142 = r141.getUiConfig();
        List<String> r143 = r141.getText();
        if (r143 == null) goto L85;
        Object r144 = (String) CollectionsKt.firstOrNull(r143);
    L86:
        if (r144 == null) goto L88;
        boolean r145 = true;
    L89:
        if (r142 == null) goto L91;
        Integer r146 = Integer.valueOf(r142.getTextSplitorStyle());
    L92:
        if (r146 == null) goto L109;
        if (r146.intValue() != 0) goto L109;
        ECUrlModel r147 = r141.getTextIcon();
        if (r147 == null) goto L102;
        if (r138 == 0) goto L100;
        boolean r148 = true;
    L101:
        r135.addView(r135.a(r147, r148, r145));
        goto L102
    L100:
        r148 = false;
    L102:
        List<String> r149 = r141.getText();
        if (r149 == null) goto L107;
        String r150 = (String) CollectionsKt.firstOrNull(r149);
        if (r150 == null) goto L107;
        r135.addView(r135.b(r138, r150, r142));
    L107:
        r110 = r110;
    L173:
        r138 = r140;
        r110 = r110;
        r101 = 1;
        r103 = null;
        r116 = 2;
    L109:
        if (r146 == null) goto L128;
        if (r146.intValue() != r116) goto L128;
        if (r138 <= 0) goto L119;
        TextView r151 = new TextView(r135.getContext());
        r151.setTag("text");
        r151.setText(" · ");
        r151.setMaxLines(r101);
        r151.setTextSize(r101, 12.0f);
        r151.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int r152 = s.f45717a;
        if (r142 == null) goto L117;
        String r153 = r142.getTextColor();
    L118:
        r151.setTextColor(s.a(r153, th.a.a(r151.getContext(), R.color.shopping_std_text_white_1)));
        r135.addView(r151);
        goto L119
    L117:
        r153 = null;
    L119:
        ECUrlModel r154 = r141.getTextIcon();
        if (r154 == null) goto L122;
        r135.addView(r135.a(r154, false, r145));
    L122:
        List<String> r155 = r141.getText();
        if (r155 == null) goto L107;
        String r156 = (String) CollectionsKt.firstOrNull(r155);
        if (r156 == null) goto L107;
        r135.addView(r135.b(r138, r156, r142));
    L128:
        if (r138 <= 0) goto L131;
        View r157 = new View(r135.getContext());
        r157.setTag(ItemStyle.ITEM_STYLE_DIVIDER);
        r157.setBackgroundColor(th.a.a(r157.getContext(), R.color.shopping_std_div_line_white));
        LinearLayout.LayoutParams r158 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(0.5f)), UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)));
        r158.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r158.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(1.0f));
        r158.gravity = 17;
        Unit r159 = Unit.INSTANCE;
        r157.setLayoutParams(r158);
        r135.addView(r157);
    L131:
        ECUrlModel r160 = r141.getTextIcon();
        if (r160 == null) goto L134;
        r135.addView(r135.a(r160, false, r145));
    L134:
        List<String> r161 = r141.getText();
        if (r161 == null) goto L173;
        String r162 = (String) CollectionsKt.firstOrNull(r161);
        if (r162 == null) goto L173;
        ECUrlModel r163 = r141.getTextIcon();
        if (r163 == null) goto L143;
        List<String> r164 = r163.getUrlList();
        if (r164 == null) goto L143;
        String r165 = (String) CollectionsKt.firstOrNull(r164);
    L144:
        if (r165 == null) goto L146;
        boolean r166 = true;
    L147:
        TextView r167 = new TextView(r135.getContext());
        r167.setTag("text");
        r167.setMaxLines(1);
        if (r142 == null) goto L158;
        Integer r168 = Integer.valueOf(r142.getTextSize());
        if (r168.intValue() <= 0) goto L152;
        boolean r169 = true;
    L153:
        if (r169 == true) goto L156;
        r168 = null;
    L156:
        if (r168 == null) goto L158;
        float r170 = r168.intValue();
    L159:
        r167.setTextSize(r170);
        int r171 = s.f45717a;
        if (r142 == null) goto L162;
        String r172 = r142.getTextColor();
    L163:
        r167.setTextColor(s.a(r172, th.a.a(r167.getContext(), R.color.shopping_std_text_white_1)));
        r167.setText(r162);
        ViewGroup.LayoutParams r173 = r167.getLayoutParams();
        if ((r173 instanceof LinearLayout.LayoutParams) == true) goto L166;
        r173 = null;
    L166:
        LinearLayout.LayoutParams r174 = (LinearLayout.LayoutParams) r173;
        if (r174 == null) goto L172;
        if (r166 == false) goto L170;
        int r175 = 0;
    L171:
        r174.leftMargin = r175;
        goto L172
    L170:
        r175 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L172:
        r135.addView(r167);
        goto L173
    L162:
        r172 = null;
        goto L163
    L152:
        r169 = false;
    L158:
        r170 = 12.0f;
        goto L159
    L146:
        r166 = false;
    L143:
        r165 = null;
        goto L144
    L91:
        r146 = null;
        goto L92
    L88:
        r145 = false;
        goto L89
    L85:
        r144 = r103;
        goto L86
    L174:
        r212 = r110;
        if (r135.getChildCount() <= 0) goto L177;
        r135.addView(new Space(r135.getContext()), new LinearLayout.LayoutParams(1, 0));
    L177:
        Iterator r176 = r136.iterator();
    L179:
        if (r176.hasNext() == false) goto L183;
        RitTagTrack r177 = ((ECRitTag) r176.next()).getTagTrack();
        if (r177 == null) goto L179;
        r177.setVisibile(true);
        goto L179
    L183:
        r119 = r135;
        r118 = null;
        goto L219
    L184:
        r212 = r110;
        r118 = r103;
        goto L216
    L26:
        if (r115.intValue() != r101) goto L70;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.s r178 = r114.d();
        if (r178 == null) goto L68;
        e r179 = getArgument();
        if (r179 == null) goto L47;
        com.bytedance.android.ec.common.api.jump.model.g r180 = r179.f523256e.invoke(r103);
        if (r180 == null) goto L34;
        Object r181 = r180.f42873a;
    L36:
        if ((r181 instanceof IntroPromotionVO) == true) goto L38;
        r181 = r103;
    L38:
        IntroPromotionVO r182 = (IntroPromotionVO) r181;
        if (r182 == null) goto L45;
        IntroProduct r183 = r182.getProduct();
        if (r183 == null) goto L45;
        if (r183.e() != r101) goto L45;
        int r184 = 1;
    L46:
        if (r184 != r101) goto L47;
    L65:
        r120 = UtilityKotlinExtentionsKt.d(16);
    L67:
        IntroInfoElasticTitleWidget r185 = new IntroInfoElasticTitleWidget(getContext(), r103, r117, r102);
        r185.setArgument(getArgument());
        r185.setContainerAbility(getContainerAbility());
        r185.b(r178);
        Object r186 = r185;
    L69:
        r118 = r103;
        r212 = r110;
        r121 = r186;
    L45:
        r184 = 0;
        goto L46
    L34:
        r181 = r103;
    L47:
        e r187 = getArgument();
        if (r187 == null) goto L66;
        com.bytedance.android.ec.common.api.jump.model.g r188 = r187.f523256e.invoke(r103);
        if (r188 == null) goto L52;
        Object r189 = r188.f42873a;
    L54:
        if ((r189 instanceof IntroPromotionVO) == true) goto L56;
        r189 = r103;
    L56:
        IntroPromotionVO r190 = (IntroPromotionVO) r189;
        if (r190 == null) goto L63;
        IntroProduct r191 = r190.getProduct();
        if (r191 == null) goto L63;
        if (r191.e() != 2) goto L63;
        int r192 = 1;
    L64:
        if (r192 != r101) goto L66;
    L63:
        r192 = 0;
        goto L64
    L52:
        r189 = r103;
    L66:
        r120 = -2;
        goto L67
    L68:
        r186 = r103;
        r120 = -2;
    L234:
        return new Pair(r108, Integer.valueOf(r107));
    L7:
        r105 = false;
    L13:
        r106 = 4;
        goto L14
    }

    public IntroCardInfoComponent(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f147976c = new ArrayList();
        this.f147977d = LazyKt.lazy(new IntroCardInfoComponent$showViewGroup1$2(r100));
        this.f147978e = LazyKt.lazy(new IntroCardInfoComponent$showViewGroup2$2(r100));
        setOrientation(1);
    }

    public /* synthetic */ IntroCardInfoComponent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
