package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroElasticMultiElementTitle;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroElasticTitle;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.q;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoElasticTitleWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "getCurrentContentDescription", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getType", "()I", "type", "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoElasticTitleWidget extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public oh2.e f148052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public oh2.c f148053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f148054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IntroInfoTagAndCountdownLayout f148055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IntroInfoSalePointView f148056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IntroInfoSalePointView f148057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f148058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s f148059i;

    public IntroInfoElasticTitleWidget(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IntroInfoElasticTitleWidget(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f148054d;
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
        IntroInfoTagAndCountdownLayout r100 = this.f148055e;
        if (r100 == null) goto L10;
        oh2.e r101 = getArgument();
        if (r101 == null) goto L9;
        oh2.d r102 = r101.f523255d;
        if (r102 == null) goto L9;
        r102.a();
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(r100);
    L10:
        d r103 = this.f148058h;
        if (r103 == null) goto L13;
        r103.a();
    L13:
        this.f148058h = null;
    }

    public oh2.e getArgument() {
        return this.f148052b;
    }

    public oh2.c getContainerAbility() {
        return this.f148053c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public int getType() {
        return this.f148051a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(s r110) {
        Intrinsics.checkNotNullParameter(r110, "elasticTitle");
        this.f148054d = new StringBuilder();
        this.f148059i = r110;
        if (this.f148055e == null) goto L5;
        getArgument();
    L5:
        IntroInfoTagAndCountdownLayout r100 = this.f148055e;
        if (r100 == null) goto L9;
        r100.f148069a = getContainerAbility();
    L9:
        if (r110.c() == null) goto L11;
    L16:
        IntroInfoTagAndCountdownLayout r101 = this.f148055e;
        if (r101 == null) goto L19;
        r101.setVisibility(0);
    L19:
        final IntroInfoTagAndCountdownLayout r102 = this.f148055e;
        if (r102 == null) goto L59;
        int r103 = IntroInfoTagAndCountdownLayout.f148068j;
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r102.f148074f = 0;
        r102.f148073e = false;
        t1 r104 = r110.c();
        if (r104 == null) goto L29;
        UtilityKotlinExtentionsKt.f(r104.c(), r104.a(), new IntroInfoTagAndCountdownLayout$bind$$inlined$let$lambda$1(r102));
        List<String> r105 = r104.b();
        if (r105 == null) goto L28;
        String r111 = (String) CollectionsKt.firstOrNull(r105);
        if (r111 == null) goto L28;
        h0.e(r102.f148070b, r111, null, null, null, 120);
    L28:
        ViewExtensionsKt.g(r102.f148070b, 0.0f, 0.0f, 0.0f, 0.0f);
        r102.f148070b.setVisibility(0);
    L30:
        r102.f148077i = null;
        r r106 = r110.b();
        r102.f148072d = r106;
        if (r106 == null) goto L54;
        r102.a(r106);
        ViewGroup.LayoutParams r107 = r102.f148070b.getLayoutParams();
        if (r107 == null) goto L53;
        ((LinearLayout.LayoutParams) r107).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(2.0f)), 0);
        r r108 = r102.f148072d;
        if (r108 == null) goto L47;
        String r109 = r108.a();
        if (r109 == null) goto L47;
        Integer r112 = com.bytedance.android.ec.core.utils.s.b(r109);
        if (r112 == null) goto L47;
        int r113 = r112.intValue();
        r r114 = r102.f148072d;
        if (r114 == null) goto L43;
        String r115 = r114.b();
    L44:
        r102.f148071c.setTextColor(com.bytedance.android.ec.core.utils.s.a(r115, -1));
        int r116 = c0.f45558a;
        c0.b(r102.f148071c, 400);
        d2.e(r102, UtilityKotlinExtentionsKt.d(4));
        r102.f148071c.setTypeface(Typeface.MONOSPACE);
        r102.setPadding(0, 0, UtilityKotlinExtentionsKt.d(2), 0);
        if (Build.VERSION.SDK_INT < 23) goto L59;
        float r117 = UtilityKotlinExtentionsKt.c(3);
        GradientDrawable r118 = new GradientDrawable();
        r118.setStroke(2, r113);
        r118.setCornerRadius(r117);
        r102.setForeground(r118);
        goto L59
    L43:
        r115 = null;
    L47:
        r r119 = r102.f148072d;
        if (r119 == null) goto L50;
        String r120 = r119.b();
    L51:
        r102.c(r120);
        Unit r121 = Unit.INSTANCE;
        goto L59
    L50:
        r120 = null;
        goto L51
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L54:
        ViewGroup.LayoutParams r122 = r102.f148070b.getLayoutParams();
        if (r122 == null) goto L58;
        ((LinearLayout.LayoutParams) r122).setMargins(0, 0, 0, 0);
        r102.c(null);
        r102.f148071c.setVisibility(8);
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L29:
        r102.f148070b.setVisibility(8);
    L59:
        IntroInfoTagAndCountdownLayout r123 = this.f148055e;
        if (r123 == null) goto L75;
        int r124 = IntroInfoTagAndCountdownLayout.f148068j;
        if (r123.b(null) == false) goto L69;
        oh2.e r125 = getArgument();
        if (r125 == null) goto L68;
        oh2.d r126 = r125.f523255d;
        if (r126 == null) goto L68;
        r126.a();
    L68:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.a(r123);
        goto L75
    L69:
        oh2.e r127 = getArgument();
        if (r127 == null) goto L74;
        oh2.d r128 = r127.f523255d;
        if (r128 == null) goto L74;
        r128.a();
    L74:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(r123);
    L75:
        s r129 = this.f148059i;
        if (r129 == null) goto L78;
        q r130 = r129.a();
    L79:
        s r131 = this.f148059i;
        if (r131 == null) goto L88;
        q r132 = r131.a();
        if (r132 == null) goto L88;
        List<IntroElasticMultiElementTitle> r133 = r132.b();
        if (r133 == null) goto L88;
        if ((!r133.isEmpty()) == false) goto L88;
    L89:
        if (r129 == null) goto L113;
        if (r130 == null) goto L114;
        if (r133 == null) goto L115;
        long r134 = r130.a();
        if (r134 > 0) goto L95;
    L111:
        Unit r135 = (Unit) UtilityKotlinExtentionsKt.f(this.f148056f, CollectionsKt.firstOrNull(r133), new IntroInfoElasticTitleWidget$setSalePointCarousel$$inlined$lets3$lambda$1(this));
        return;
    L95:
        if (r133.size() == 1) goto L111;
        if (r133.size() <= 1) goto L116;
        IntroInfoSalePointView r136 = this.f148056f;
        if (r136 == null) goto L119;
        IntroInfoSalePointView r137 = this.f148057g;
        if (r137 == null) goto L120;
        d r138 = this.f148058h;
        if (r138 == null) goto L108;
        r138.a();
    L108:
        this.f148058h = null;
        this.f148058h = new d(this, r136, r137, r133, r133, r134, r134);
        r136.setVisibility(0);
        d r139 = this.f148058h;
        if (r139 == null) goto L117;
        r139.j();
        return;
    L117:
        return;
    L120:
        return;
    L119:
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L88:
        r133 = null;
        goto L89
    L78:
        r130 = null;
        goto L79
    L11:
        if (r110.b() != null) goto L16;
        IntroInfoTagAndCountdownLayout r140 = this.f148055e;
        if (r140 == null) goto L59;
        r140.setVisibility(8);
        goto L59
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r100) {
        this.f148052b = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r100) {
        this.f148053c = r100;
    }

    public IntroInfoElasticTitleWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148051a = 1;
        setGravity(16);
        IntroInfoTagAndCountdownLayout r103 = new IntroInfoTagAndCountdownLayout(getContext(), null, 6, 0);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14)));
        r103.setPadding(0, 0, UtilityKotlinExtentionsKt.d(4), 0);
        r103.setVisibility(8);
        addView(r103);
        Unit r104 = Unit.INSTANCE;
        this.f148055e = r103;
        IntroInfoSalePointView r105 = new IntroInfoSalePointView(getContext());
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r105);
        this.f148056f = r105;
        IntroInfoSalePointView r106 = new IntroInfoSalePointView(getContext());
        r106.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r106);
        this.f148057g = r106;
        o0.c(this, 16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Integer, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Integer, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoSalePointView, com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout, java.lang.Object] */
    public static final void a(IntroInfoElasticTitleWidget r110, final IntroInfoSalePointView r111, IntroElasticMultiElementTitle r112) {
        r110.getClass();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "data");
        r111.removeAllViews();
        List<IntroElasticTitle> r100 = r112.b();
        AttributeSet r101 = null;
        if (r100 == null) goto L85;
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L85;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        final IntroElasticTitle r106 = (IntroElasticTitle) r104;
        final String r107 = a2.d(r106.d());
        if (r107 == null) goto L66;
        Context r113 = r111.getContext();
        ArrayList r114 = (ArrayList) r111.f148066b;
        if ((!r114.isEmpty()) == false) goto L17;
        View r115 = (View) ListProtector.remove(r114, 0);
        ViewParent r116 = r115.getParent();
        Object r117 = r115;
        if (r116 != null) goto L17;
    L18:
        final GradientAndItalicTextView r118 = (GradientAndItalicTextView) r117;
        float r119 = 12.0f;
        if (r118 != null) goto L21;
        r118 = new GradientAndItalicTextView(r113, r101, 6, 0);
        r118.setTextSize(1, 12.0f);
        r118.setTextColor(th.a.a(r113, R.color.shopping_color_FFCCCCCC));
        r118.setEllipsize(TextUtils.TruncateAt.END);
        r118.setMaxLines(1);
        r118.setIncludeFontPadding(false);
    L21:
        Integer r120 = r106.getType();
        if (r120 != null) goto L25;
    L37:
        ?? r121 = Integer.valueOf(r106.e());
        if (r121.intValue() <= 0) goto L40;
        boolean r122 = true;
    L41:
        if (r122 == true) goto L44;
        r121 = r101;
    L44:
        if (r121 == 0) goto L46;
        r119 = r121.intValue();
    L46:
        r118.setTextSize(1, r119);
        c0.b(r118, 400);
    L47:
        r118.setText(r107);
        List<String> r123 = r106.c();
        if (r123 == null) goto L60;
        ?? r124 = PromotionCardStyleHelper.ButtonHelper.a(r123);
        if (((ArrayList) r124).size() != 3) goto L52;
        boolean r125 = true;
    L53:
        if (r125 == true) goto L56;
        r124 = r101;
    L56:
        if (r124 == 0) goto L60;
        int[] r126 = CollectionsKt.toIntArray(r124);
        if (r126 == null) goto L60;
        r118.setLinearGradientCreator(new ol2.a(r126, new float[]{0.0491f, 0.3019f, 0.7577f}, IntroInfoSalePointView$bindData$1$view$1$1$4$1.INSTANCE));
    L61:
        UtilityKotlinExtentionsKt.h(r126, new IntroInfoSalePointView$bindData$$inlined$forEachIndexed$lambda$1(r118, r107, r106, r111));
        if (Intrinsics.areEqual(r106.a(), Boolean.TRUE) == false) goto L64;
        c0.b(r118, 500);
    L65:
        r118.setEllipsize(TextUtils.TruncateAt.END);
    L67:
        if (r118 == null) goto L84;
        if (r103 <= 0) goto L80;
        Context r108 = r111.getContext();
        ArrayList r109 = (ArrayList) r111.f148067c;
        if ((!r109.isEmpty()) == false) goto L75;
        View r127 = (View) ListProtector.remove(r109, 0);
        if (r127.getParent() != null) goto L75;
    L76:
        Space r128 = (Space) r127;
        if (r128 != null) goto L79;
        r128 = new Space(r108);
        r128.setLayoutParams(new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(4), -1));
    L79:
        r111.addView(r128);
    L81:
        r111.addView(r118);
        if (r128 == null) goto L84;
        r111.setHideGroup(new View[]{r128, r118});
    L75:
        r127 = null;
        goto L76
    L80:
        r128 = null;
    L84:
        r103 = r105;
        r101 = null;
        goto L6
    L64:
        c0.b(r118, 400);
        goto L65
    L52:
        r125 = false;
    L60:
        r126 = null;
        goto L61
    L40:
        r122 = false;
        goto L41
    L25:
        if (r120.intValue() != 3) goto L37;
        ?? r129 = Integer.valueOf(r106.e());
        if (r129.intValue() <= 0) goto L29;
        boolean r130 = true;
    L30:
        if (r130 == true) goto L33;
        r129 = r101;
    L33:
        if (r129 == 0) goto L35;
        float r131 = r129.intValue();
    L36:
        r118.setTextSize(1, r131);
        c0.b(r118, 500);
        goto L47
    L35:
        r131 = 10.0f;
        goto L36
    L29:
        r130 = false;
    L17:
        r117 = r101;
        goto L18
    L66:
        r118 = null;
    L85:
        StringBuilder r132 = r110.f148054d;
        if (r132 == null) goto L88;
        r132.append(r112.a());
    L88:
        List<s1> r133 = r112.c();
        if (r133 == null) goto L114;
        Iterator r134 = r133.iterator();
    L92:
        if (r134.hasNext() == false) goto L130;
        s1 r135 = (s1) r134.next();
        String r136 = r135.a();
        Map<String, String> r137 = r135.b();
        if (r136 == null) goto L92;
        if (r136.length() <= 0) goto L98;
        boolean r138 = true;
    L99:
        if (r138 == true) goto L102;
        r136 = null;
    L102:
        if (r136 == null) goto L92;
        oh2.e r139 = r110.getArgument();
        if (r139 == null) goto L92;
        IntroCardEventCenter r140 = r139.f523252a;
        if (r140 == null) goto L92;
        oh2.e r141 = r110.getArgument();
        if (r141 == null) goto L112;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r142 = r141.f523253b;
        if (r142 == null) goto L112;
        r142.c();
        String r143 = "a1128.b3295.c59667.d30609";
    L113:
        r140.a(r136, r137, r143);
    L112:
        r143 = null;
        goto L113
    L98:
        r138 = false;
        goto L99
    L130:
        return;
    }

    public /* synthetic */ IntroInfoElasticTitleWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
