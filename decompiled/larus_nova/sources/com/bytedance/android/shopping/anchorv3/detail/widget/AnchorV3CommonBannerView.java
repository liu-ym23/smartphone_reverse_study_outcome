package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionBannerItemStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.detail.utils.BannerRenderHelper;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jd3.m0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/AnchorV3CommonBannerView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3CommonBannerView extends LinearLayout implements com.bytedance.android.shopping.feed.view.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f164831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f164833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f164834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f164835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f164836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f164837g;

    public static final class a {
    }

    static {
    }

    public AnchorV3CommonBannerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3CommonBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public AnchorV3CommonBannerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.shopping_view_anchor_v3_common_banner, this);
        this.f164831a = (ECDraweeView) findViewById(R.id.anchor_v3_common_banner_icon);
        this.f164832b = (TextView) findViewById(R.id.anchor_v3_common_banner_description);
        this.f164834d = (ImageView) findViewById(R.id.anchor_v3_common_arrow);
        this.f164835e = (ViewGroup) findViewById(R.id.anchor_v3_banner_items_layout);
        this.f164836f = (LinearLayout) findViewById(R.id.anchor_v3_common_banner_box);
        setGravity(16);
    }

    public /* synthetic */ AnchorV3CommonBannerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void b(AnchorV3CommonBannerView r110, PromotionProductBannerStruct r111, Function1 r112, boolean r210, int r211, boolean r212, int r213) {
        int r100 = 0;
        if ((r213 & 8) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r213 & 16) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r213 & 32) == 0) goto L13;
        boolean r103 = false;
    L15:
        if (r101 == true) goto L22;
        ViewGroup.LayoutParams r104 = r110.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r104 = null;
    L19:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L22;
        r105.bottomMargin = r102;
    L22:
        r110.setVisibility(0);
        if (ECAppInfoService.f48114e.f() == false) goto L30;
        Integer r106 = r111.getBannerType();
        if (r106 == null) goto L30;
        if (r106.intValue() != 31) goto L30;
        r111.setIconLeftDistance(6);
        r111.setIconRightDistance(3);
        r111.setBoxTopPadding(3);
        r111.setBoxBottomPadding(3);
        r111.setBoxRightPadding(3);
    L30:
        ECUrlModel r107 = r111.getIcon();
        if (r107 == null) goto L173;
        r110.f164831a.setVisibility(0);
        ECDraweeView r108 = r110.f164831a;
        ViewGroup.LayoutParams r113 = r108.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r113 = null;
    L35:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        if (r114 == null) goto L38;
        r114.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111.getIconLeftDistance()));
        r114.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111.getIconRightDistance()));
        Unit r115 = Unit.INSTANCE;
    L39:
        r108.setLayoutParams(r114);
        y.a(r110.f164831a, r107);
        goto L173
    L38:
        r114 = null;
    L173:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L42
        Object r116 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r111.getTextColor())));     // Catch: Throwable -> L42
    L45:
        if (Result.m9455isFailureimpl(r116) == false) goto L47;
        r116 = null;
    L47:
        Integer r117 = (Integer) r116;
        if (r117 == null) goto L50;
        DrawableCompat.setTint(r110.f164834d.getDrawable(), r117.intValue());
    L50:
        ECUrlModel r118 = r111.getBackgroundImg();
        if (r118 == null) goto L53;
        y.l(r118, -1, -1, new b(r110));
    L53:
        r110.f164836f.setPadding(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111.getBoxLeftPadding())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111.getBoxTopPadding())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111.getBoxRightPadding())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111.getBoxBottomPadding())));
        if (r103 == false) goto L56;
        ViewExtensionsKt.g(r110.f164836f, 12.0f, 12.0f, 12.0f, 12.0f);
    L56:
        r110.f164833c = r111.getUrl();
        boolean r119 = true;
        if (r111.getBannerContentStrategy() != 1) goto L146;
        Integer r120 = r111.getBannerType();
        if (r120 != null) goto L62;
    L112:
        r110.f164835e.setVisibility(0);
        List<PromotionBannerItemStruct> r121 = r111.getBannerItems();
        if (r121 == null) goto L147;
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L116:
        if (r123.hasNext() == false) goto L120;
        Object r124 = r123.next();
        if (((PromotionBannerItemStruct) r124).getUse() == false) goto L116;
        r122.add(r124);
        goto L116
    L120:
        Iterator r125 = r122.iterator();
    L122:
        if (r125.hasNext() == false) goto L147;
        PromotionBannerItemStruct r126 = (PromotionBannerItemStruct) r125.next();
        ViewGroup r127 = r110.f164835e;
        View r128 = LayoutInflater.from(r110.getContext()).inflate(R.layout.shopping_anchor_v3_banner_item, r110.f164835e, false);
        SimpleDraweeView r129 = (SimpleDraweeView) r128.findViewById(R.id.banner_item_icon);
        TextView r130 = (TextView) r128.findViewById(R.id.banner_item_text);
        r130.setText(r126.getContent());
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L126
        Object r132 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r126.getContentColor())));     // Catch: Throwable -> L126
    L129:
        if (Result.m9455isFailureimpl(r132) == false) goto L131;
        r132 = null;
    L131:
        Integer r133 = (Integer) r132;
        if (r133 == null) goto L134;
        int r134 = r133.intValue();
    L135:
        r130.setTextColor(r134);
        ECUrlModel r135 = r126.getIcon();
        if (r135 == null) goto L145;
        ViewGroup.LayoutParams r136 = r129.getLayoutParams();
        if ((r136 instanceof LinearLayout.LayoutParams) == true) goto L140;
        r136 = null;
    L140:
        LinearLayout.LayoutParams r137 = (LinearLayout.LayoutParams) r136;
        if (r137 == null) goto L143;
        r137.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r135.getWidth()));
        r137.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r135.getHeight()));
        Unit r138 = Unit.INSTANCE;
    L144:
        r129.setLayoutParams(r137);
        r129.setVisibility(0);
        y.a(r129, r126.getIcon());
        goto L145
    L143:
        r137 = null;
    L145:
        LinearLayout.LayoutParams r139 = new LinearLayout.LayoutParams(-2, -2);
        r139.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r126.getLeftMargin()));
        Unit r140 = Unit.INSTANCE;
        r127.addView(r128, r139);
        goto L122
    L134:
        r134 = -1;
    L126:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L147:
        Integer r142 = r111.getBannerType();
        if (r142 != null) goto L151;
    L155:
        if (r101 == false) goto L157;
        r110.setOnClickListener(null);
    L158:
        boolean r143 = CollectionsKt.listOf(new Integer[]{32, 31}).contains(r111.getBannerType());
        if (r101 == true) goto L166;
        String r144 = r110.f164833c;
        if (r144 == null) goto L166;
        if ((!StringsKt.isBlank(r144)) != true) goto L166;
        if (r143 == true) goto L166;
    L167:
        ImageView r145 = r110.f164834d;
        if (r119 == true) goto L171;
        r100 = 8;
    L171:
        r145.setVisibility(r100);
        return;
    L166:
        r119 = false;
        goto L167
    L157:
        r110.setOnClickListener(new c(r110, r112, r111));
        goto L158
    L151:
        if (r142.intValue() != 14) goto L155;
        if (r110.f164837g == true) goto L155;
        int r146 = com.bytedance.android.ec.core.anchorv3.a.f43797a;
        Context r147 = r110.getContext();
        Intrinsics.checkNotNullParameter("security_source", "infoName");
        m0 r148 = new m0();
        Intrinsics.checkNotNullParameter("security_source", "<set-?>");
        r148.f498388a = "security_source";
        com.bytedance.android.ec.core.anchorv3.b.a(r148, r147, null);
        r110.f164837g = true;
        goto L155
    L62:
        if (r120.intValue() != 31) goto L112;
        List<PromotionBannerItemStruct> r149 = r111.getBannerItems();
        String r150 = "";
        if (r149 == null) goto L75;
        ArrayList r151 = new ArrayList();
        Iterator<T> r152 = r149.iterator();
    L67:
        if (r152.hasNext() == false) goto L71;
        Object r153 = r152.next();
        if (((PromotionBannerItemStruct) r153).getUse() == false) goto L67;
        r151.add(r153);
        goto L67
    L71:
        Iterator r154 = r151.iterator();
    L73:
        if (r154.hasNext() == false) goto L75;
        r150 = r150 + ((PromotionBannerItemStruct) r154.next()).getContent();
    L75:
        SpannableString r155 = new SpannableString(r150);
        List<PromotionBannerItemStruct> r156 = r111.getBannerItems();
        if (r156 == null) goto L107;
        ArrayList r157 = new ArrayList();
        Iterator<T> r158 = r156.iterator();
    L79:
        if (r158.hasNext() == false) goto L83;
        Object r159 = r158.next();
        if (((PromotionBannerItemStruct) r159).getUse() == false) goto L79;
        r157.add(r159);
        goto L79
    L83:
        Iterator r160 = r157.iterator();
        int r161 = 0;
    L85:
        if (r160.hasNext() == false) goto L107;
        PromotionBannerItemStruct r162 = (PromotionBannerItemStruct) r160.next();
        Result.Companion r163 = Result.Companion;     // Catch: Throwable -> L89
        Object r164 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r162.getContentColor())));     // Catch: Throwable -> L89
    L92:
        if (Result.m9455isFailureimpl(r164) == false) goto L94;
        r164 = null;
    L94:
        Integer r165 = (Integer) r164;
        if (r165 == null) goto L97;
        int r166 = r165.intValue();
    L98:
        ForegroundColorSpan r167 = new ForegroundColorSpan(r166);
        String r168 = r162.getContent();
        if (r168 == null) goto L101;
        Integer r169 = Integer.valueOf(r168.length());
    L102:
        Intrinsics.checkNotNull(r169);
        r155.setSpan(r167, r161, r169.intValue() + r161, 33);
        String r170 = r162.getContent();
        if (r170 == null) goto L105;
        Integer r171 = Integer.valueOf(r170.length());
    L106:
        Intrinsics.checkNotNull(r171);
        r161 = r161 + r171.intValue();
        goto L85
    L105:
        r171 = null;
        goto L106
    L101:
        r169 = null;
        goto L102
    L97:
        r166 = -16777216;
    L89:
        th = move-exception;
        Result.Companion r172 = Result.Companion;
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L107:
        r110.f164832b.setText(r155);
        r110.f164832b.setVisibility(0);
        TextView r173 = r110.f164832b;
        ViewGroup.LayoutParams r174 = r173.getLayoutParams();
        if (r174 == null) goto L111;
        ViewGroup.MarginLayoutParams r175 = (ViewGroup.MarginLayoutParams) r174;
        r175.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        Unit r176 = Unit.INSTANCE;
        r173.setLayoutParams(r175);
        r110.f164832b.setTextSize(2, 11.0f);
        goto L147
    L111:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L146:
        r110.f164832b.setVisibility(0);
        r110.f164832b.setText(r111.getContent());
        BannerRenderHelper.a(r110.f164832b, r111, r101);
    L42:
        th = move-exception;
        Result.Companion r177 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
