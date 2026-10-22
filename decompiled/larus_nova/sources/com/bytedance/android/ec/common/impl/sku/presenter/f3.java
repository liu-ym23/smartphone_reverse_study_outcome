package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuTrustTagContentView;
import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import com.bytedance.android.ec.model.sku.BackgroundInfo;
import com.bytedance.android.ec.model.sku.BlankObject;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.bytedance.android.ec.model.sku.ImageObject;
import com.bytedance.android.ec.model.sku.SkuTrustTagItem;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.bytedance.android.ec.model.sku.TextObject;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f3 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommonMarqueeView f43222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f43223h;

    public static final class a implements ul.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f3 f43224a;

        public a(f3 r100) {
            this.f43224a = r100;
        }

        @Override // ul.c
        public final void a(boolean r100) {
            if (r100 == false) goto L4;
            this.f43224a.Y().d().q(dg.v.class, 0);
            return;
        L4:
            this.f43224a.Y().d().q(dg.v.class, 8);
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        List<ul.c> r100 = ul.b.f550585a;
        ul.b.a(this.f43223h);
        CommonMarqueeView r101 = this.f43222g;
        if (r101 == null) goto L5;
        r101.setOnViewExposedListener(null);
    L5:
        CommonMarqueeView r102 = this.f43222g;
        if (r102 == null) goto L9;
        r102.d();
        return;
    }

    public f3(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f43223h = new a(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        SkuViewModel r100 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43221f = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r101 = r100.getSkuInfo().a();
        if (r101 == null) goto L136;
        SkuTrustTags r102 = r101.getTrustTags();
        if (r102 == null) goto L137;
        List<SkuTrustTagItem> r103 = r102.getSkuDocument();
        int r104 = 0;
        if (r103 != null) goto L13;
    L107:
        List<ul.c> r105 = ul.b.f550585a;
        ul.b.b(this.f43223h);
        SkuViewModel r106 = this.f43221f;
        if (r106 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L110:
        Map<String, String> r107 = r102.getShowEventTrack();
        if (r107 == null) goto L121;
        ArrayList r108 = new ArrayList(r107.size());
        Iterator<Map.Entry<String, String>> r109 = r107.entrySet().iterator();
    L114:
        if (r109.hasNext() == false) goto L116;
        Map.Entry<String, String> r111 = r109.next();
        r108.add(TuplesKt.to(r111.getKey(), r111.getValue()));
        goto L114
    L116:
        Object[] r112 = r108.toArray(new Pair[0]);
        if (r112 == null) goto L120;
        Pair[] r113 = (Pair[]) r112;
    L122:
        SkuViewModel.doSkuEventAction$default(r106, "sku_panel_module_show", (Pair[]) Arrays.copyOf(r113, r113.length), null, null, null, 28, null);
        return;
    L120:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L121:
        r113 = new Pair[0];
        goto L122
    L13:
        if (this.f43222g != null) goto L23;
        CommonMarqueeView r114 = (CommonMarqueeView) Z().b(R.id.trust_tags_list_container).f();
        this.f43222g = r114;
        r114.setInterval(3000);
        CommonMarqueeView r115 = this.f43222g;
        if (r115 == null) goto L17;
        r115.setItemSpacing(com.bytedance.android.shopping.extensions.b.b(4));
    L17:
        CommonMarqueeView r116 = this.f43222g;
        if (r116 == null) goto L20;
        r116.setOrientation(true);
    L20:
        CommonMarqueeView r117 = this.f43222g;
        if (r117 == null) goto L23;
        r117.setOnViewExposedListener(new TrustTagsPresenter$bind$$inlined$let$lambda$1(this));
    L23:
        CommonMarqueeView r118 = this.f43222g;
        if (r118 == null) goto L26;
        r118.removeAllViews();
    L26:
        Iterator<T> r119 = r103.iterator();
    L28:
        if (r119.hasNext() == false) goto L101;
        SkuTrustTagItem r120 = (SkuTrustTagItem) r119.next();
        SkuTrustTagsView r121 = new SkuTrustTagsView(Y().c(), null, 6, r104);
        Intrinsics.checkNotNullParameter(r120, MapController.ITEM_LAYER_TAG);
        BackgroundInfo r122 = r120.getBackground();
        if (r122 == null) goto L42;
        GradientDrawable r123 = new GradientDrawable();
        Integer r124 = r122.getCornerRadius();
        if (r124 == null) goto L34;
        r123.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r124.intValue())));
    L34:
        String r125 = r122.getBackgroundColor();
        if (r125 != null) goto L124;
    L39:
        r121.setBackground(r123);
        Integer r126 = r122.getHeight();
        if (r126 == null) goto L42;
        wg.a.d(r121, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r126.intValue())));
        goto L42
    L124:
        r123.setColor(Color.parseColor(r125));     // Catch: Exception -> L38
    L42:
        List<ContentInfo> r127 = r120.getContent();
        if (r127 == null) goto L97;
        int r128 = (com.bytedance.android.ec.core.utils.k1.m(r121.getContext()) - com.bytedance.android.shopping.extensions.b.b(24)) - com.bytedance.android.shopping.extensions.b.b(24);
        r121.removeAllViews();
        SkuTrustTagContentView r129 = new SkuTrustTagContentView(r121.getContext(), null, 6, r104);
        Intrinsics.checkNotNullParameter(r127, "contents");
        Iterator<T> r130 = r127.iterator();
        int r131 = 0;
    L46:
        if (r130.hasNext() == false) goto L96;
        ContentInfo r132 = (ContentInfo) r130.next();
        ImageObject r133 = r132.getImageObject();
        if (r133 == null) goto L63;
        List<String> r134 = r133.getUrlList();
        if (r134 == null) goto L63;
        String r135 = (String) CollectionsKt.firstOrNull(r134);
        if (r135 == null) goto L63;
        SimpleDraweeView r136 = new SimpleDraweeView(r129.getContext());
        ((GenericDraweeHierarchy) r136.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r136.setImageURI(r135);
        Integer r137 = r133.getWidth();
        if (r137 == null) goto L57;
        int r138 = vf4.a.b(r137);
    L58:
        Integer r139 = r133.getHeight();
        if (r139 == null) goto L61;
        int r140 = vf4.a.b(r139);
    L62:
        LinearLayout.LayoutParams r141 = new LinearLayout.LayoutParams(r138, r140);
        r141.gravity = 16;
        r136.setLayoutParams(r141);
        View r142 = r136;
    L64:
        TextObject r143 = r132.getTextObject();
        View r144 = r142;
        if (r143 == null) goto L85;
        TextView r145 = new TextView(r129.getContext());
        String r146 = r143.getText();
        if (r146 == null) goto L84;
        r145.setText(r146);
        String r147 = r143.getFontColor();
        if (r147 != null) goto L126;
    L73:
        Integer r148 = r143.getFontSize();
        if (r148 == null) goto L76;
        r145.setTextSize(r148.intValue());
    L76:
        Boolean r149 = r143.getBold();
        if (r149 != null) goto L79;
    L83:
        r145.setGravity(16);
        r145.setSingleLine();
        LinearLayout.LayoutParams r150 = new LinearLayout.LayoutParams(-2, -2);
        r150.gravity = 16;
        r145.setLayoutParams(r150);
        r144 = r145;
        goto L85
    L79:
        if (r149.booleanValue() == false) goto L81;
        Typeface r151 = Typeface.DEFAULT_BOLD;
    L82:
        r145.setTypeface(r151);
        goto L83
    L81:
        r151 = Typeface.DEFAULT;
        goto L82
    L126:
        r145.setTextColor(Color.parseColor(r147));     // Catch: Exception -> L72
        goto L73
    L84:
        r144 = null;
    L85:
        BlankObject r152 = r132.getBlankObject();
        View r153 = r144;
        if (r152 == null) goto L91;
        View r154 = new View(r129.getContext());
        vf4.a.b(0);
        Integer r155 = r152.getWidth();
        if (r155 == null) goto L90;
        r154.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(Integer.valueOf(r155.intValue())), vf4.a.b(2)));
        r153 = r154;
        goto L91
    L90:
        r153 = null;
    L91:
        if (r153 == null) goto L46;
        r153.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if ((r153.getMeasuredWidth() + r131) >= r128) goto L46;
        r129.addView(r153);
        r131 = r131 + r153.getMeasuredWidth();
        r129.f43416b.add(r132);
        goto L46
    L61:
        r140 = -1;
        goto L62
    L57:
        r138 = -2;
    L63:
        r142 = null;
        goto L64
    L96:
        Unit r156 = Unit.INSTANCE;
        r121.f43168a = r129;
        r121.addView(r129);
    L97:
        r121.requestLayout();
        CommonMarqueeView r157 = this.f43222g;
        if (r157 == null) goto L100;
        r157.addView(r121);
    L100:
        r104 = 0;
        goto L28
    L101:
        CommonMarqueeView r158 = this.f43222g;
        if (r158 == null) goto L104;
        r158.post(new e3(this));
    L104:
        CommonMarqueeView r159 = this.f43222g;
        if (r159 == null) goto L107;
        r159.c();
        goto L107
    L137:
        return;
    }
}
