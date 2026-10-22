package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import N5.CardEnvelope;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.U;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/U;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "LN5/i;", "envelope", "D", "(LN5/i;LN5/n;)V", "LT5/s;", "detailBinding", "LT5/s;", "", "cardId", "Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U extends N5.d {
    private static final float CTA_TEXT_SIZE_SP = 15.0f;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float GALLERY_HEIGHT_DP = 180.0f;
    private static final float GALLERY_TOP_CORNER_DP = 20.0f;
    private String cardId;
    private T5.s detailBinding;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JW\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u000b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ5\u0010\"\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0 2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\n2\u0006\u0010!\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/U$a;", "", "<init>", "()V", "LT5/s;", "binding", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;", "item", "Lkotlin/Function2;", "", "LY8/t;", "onOpenLink", "Lkotlin/Function0;", "onCollapse", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;", "style", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LT5/s;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;Lp9/p;Lp9/a;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;)V", "f", "(LT5/s;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;)V", Const.INTENT_KEY_UMID, "q", "Landroid/widget/TextView;", "tv", "o", "(Landroid/widget/TextView;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;)V", "Landroid/view/View;", "row", "valueTv", UxipConstants.f30680s, "n", "(Landroid/view/View;Landroid/widget/TextView;Ljava/lang/String;)V", "", "gallery", "l", "(LT5/s;Ljava/util/List;Lp9/a;)V", "url", "r", "(Ljava/lang/String;)Ljava/lang/String;", "", "count", "p", "(LT5/s;I)V", "Landroid/widget/FrameLayout;", "e", "(Landroid/widget/FrameLayout;)V", "", "GALLERY_TOP_CORNER_DP", "F", "GALLERY_HEIGHT_DP", "CTA_TEXT_SIZE_SP", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.U$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/amap/U$a$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.U$a$a, reason: collision with other inner class name */
        public static final class C0309a extends ViewOutlineProvider {
            final /* synthetic */ float $radiusPx;

            public C0309a(float f10) {
                this.$radiusPx = f10;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                int width = view.getWidth();
                int height = view.getHeight();
                float f10 = this.$radiusPx;
                outline.setRoundRect(0, 0, width, height + ((int) f10), f10);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/amap/U$a$b", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.U$a$b */
        public static final class b extends ViewPager2.i {
            final /* synthetic */ LinearLayout $dots;

            public b(LinearLayout linearLayout) {
                this.$dots = linearLayout;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageSelected(int position) {
                int childCount = this.$dots.getChildCount();
                int i10 = 0;
                while (i10 < childCount) {
                    this.$dots.getChildAt(i10).setSelected(i10 == position);
                    i10++;
                }
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final void g(View view, float f10, int i10) {
            int i11;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams == null || marginLayoutParams.topMargin == (i11 = (int) (i10 * f10))) {
                return;
            }
            marginLayoutParams.topMargin = i11;
            view.setLayoutParams(marginLayoutParams);
        }

        public static /* synthetic */ void i(Companion companion, T5.s sVar, PoiDetailCardItem poiDetailCardItem, p9.p pVar, InterfaceC5063a interfaceC5063a, PoiDetailStyle poiDetailStyle, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                interfaceC5063a = null;
            }
            InterfaceC5063a interfaceC5063a2 = interfaceC5063a;
            if ((i10 & 16) != 0) {
                poiDetailStyle = PoiDetailStyle.INSTANCE.a();
            }
            companion.h(sVar, poiDetailCardItem, pVar, interfaceC5063a2, poiDetailStyle);
        }

        public static final void j(p9.p pVar, CardAction cardAction, View view) {
            pVar.invoke(cardAction != null ? cardAction.getAppLink() : null, cardAction != null ? cardAction.getWebLink() : null);
        }

        public static final void k(T5.s sVar, PoiDetailStyle poiDetailStyle) {
            U.INSTANCE.q(sVar, poiDetailStyle);
        }

        public static final void m(InterfaceC5063a interfaceC5063a, View view) {
            interfaceC5063a.invoke();
        }

        public final void d(T5.s binding, PoiDetailStyle style) {
            if (style.getCtaGravityEnd() || style.getCtaCompact()) {
                TextView btnPoiAction = binding.btnPoiAction;
                kotlin.jvm.internal.p.h(btnPoiAction, "btnPoiAction");
                DisplayMetrics displayMetrics = btnPoiAction.getResources().getDisplayMetrics();
                ViewGroup.LayoutParams layoutParams = btnPoiAction.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    int i10 = style.getCtaGravityEnd() ? 8388613 : 1;
                    if (layoutParams2.gravity != i10) {
                        layoutParams2.gravity = i10;
                        btnPoiAction.setLayoutParams(layoutParams2);
                    }
                }
                if (style.getCtaCompact()) {
                    if (btnPoiAction.getTextSize() != TypedValue.applyDimension(2, U.CTA_TEXT_SIZE_SP, displayMetrics)) {
                        btnPoiAction.setTextSize(2, U.CTA_TEXT_SIZE_SP);
                    }
                    float f10 = displayMetrics.density;
                    int i11 = (int) (20 * f10);
                    int i12 = (int) (9 * f10);
                    if (btnPoiAction.getPaddingLeft() != i11 || btnPoiAction.getPaddingTop() != i12) {
                        btnPoiAction.setPadding(i11, i12, i11, i12);
                    }
                    ViewGroup.LayoutParams layoutParams3 = btnPoiAction.getLayoutParams();
                    if (layoutParams3 != null && layoutParams3.height != -2) {
                        layoutParams3.height = -2;
                        btnPoiAction.setLayoutParams(layoutParams3);
                    }
                    int i13 = R$id.tag_poi_cta_compact;
                    if (btnPoiAction.getTag(i13) == null) {
                        btnPoiAction.setBackgroundResource(R$drawable.bg_card_cta_small);
                        btnPoiAction.setTextColor(btnPoiAction.getResources().getColor(R$color.card_cta_text, null));
                        btnPoiAction.setTag(i13, Boolean.TRUE);
                    }
                }
            }
        }

        public final void e(FrameLayout gallery) {
            gallery.setOutlineProvider(new C0309a(gallery.getResources().getDisplayMetrics().density * 20.0f));
            gallery.setClipToOutline(true);
        }

        public final void f(T5.s binding, PoiDetailStyle style) {
            float f10 = binding.b().getResources().getDisplayMetrics().density;
            TextView tvPoiMeta = binding.tvPoiMeta;
            kotlin.jvm.internal.p.h(tvPoiMeta, "tvPoiMeta");
            g(tvPoiMeta, f10, style.getTitleToMetaDp());
            LinearLayout llPoiInfo = binding.llPoiInfo;
            kotlin.jvm.internal.p.h(llPoiInfo, "llPoiInfo");
            g(llPoiInfo, f10, style.getMetaToInfoBlockDp());
            LinearLayout rowPoiHours = binding.rowPoiHours;
            kotlin.jvm.internal.p.h(rowPoiHours, "rowPoiHours");
            g(rowPoiHours, f10, style.getInfoRowGapDp());
            LinearLayout rowPoiPrice = binding.rowPoiPrice;
            kotlin.jvm.internal.p.h(rowPoiPrice, "rowPoiPrice");
            g(rowPoiPrice, f10, style.getInfoRowGapDp());
            LinearLayout rowPoiTip = binding.rowPoiTip;
            kotlin.jvm.internal.p.h(rowPoiTip, "rowPoiTip");
            g(rowPoiTip, f10, style.getInfoRowGapDp());
            TextView tvPoiDescription = binding.tvPoiDescription;
            kotlin.jvm.internal.p.h(tvPoiDescription, "tvPoiDescription");
            g(tvPoiDescription, f10, style.getInfoToDescDp());
            d(binding, style);
        }

        public final void h(final T5.s binding, PoiDetailCardItem item, final p9.p<? super String, ? super String, Y8.t> onOpenLink, InterfaceC5063a<Y8.t> onCollapse, final PoiDetailStyle style) {
            kotlin.jvm.internal.p.i(binding, "binding");
            kotlin.jvm.internal.p.i(item, "item");
            kotlin.jvm.internal.p.i(onOpenLink, "onOpenLink");
            kotlin.jvm.internal.p.i(style, "style");
            f(binding, style);
            l(binding, item.f(), onCollapse);
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(item.getName());
            String strD2 = jVar.d(item.getDistanceText());
            if (strD != null && strD2 != null) {
                strD = strD + " · " + strD2;
            }
            C3251a c3251a = C3251a.INSTANCE;
            TextView tvPoiName = binding.tvPoiName;
            kotlin.jvm.internal.p.h(tvPoiName, "tvPoiName");
            c3251a.e(tvPoiName, strD);
            TextView tvPoiMeta = binding.tvPoiMeta;
            kotlin.jvm.internal.p.h(tvPoiMeta, "tvPoiMeta");
            o(tvPoiMeta, item);
            binding.tvPoiRating.setVisibility(8);
            binding.tvPoiReviewCount.setVisibility(8);
            binding.rowPoiDistance.setVisibility(8);
            binding.rowPoiStatus.setVisibility(8);
            LinearLayout rowPoiAddress = binding.rowPoiAddress;
            kotlin.jvm.internal.p.h(rowPoiAddress, "rowPoiAddress");
            TextView tvPoiAddress = binding.tvPoiAddress;
            kotlin.jvm.internal.p.h(tvPoiAddress, "tvPoiAddress");
            n(rowPoiAddress, tvPoiAddress, item.getAddressText());
            LinearLayout rowPoiHours = binding.rowPoiHours;
            kotlin.jvm.internal.p.h(rowPoiHours, "rowPoiHours");
            TextView tvPoiHours = binding.tvPoiHours;
            kotlin.jvm.internal.p.h(tvPoiHours, "tvPoiHours");
            n(rowPoiHours, tvPoiHours, item.getBusinessHoursText());
            LinearLayout rowPoiPrice = binding.rowPoiPrice;
            kotlin.jvm.internal.p.h(rowPoiPrice, "rowPoiPrice");
            TextView tvPoiPrice = binding.tvPoiPrice;
            kotlin.jvm.internal.p.h(tvPoiPrice, "tvPoiPrice");
            n(rowPoiPrice, tvPoiPrice, item.getPriceText());
            LinearLayout rowPoiTip = binding.rowPoiTip;
            kotlin.jvm.internal.p.h(rowPoiTip, "rowPoiTip");
            TextView tvPoiTip = binding.tvPoiTip;
            kotlin.jvm.internal.p.h(tvPoiTip, "tvPoiTip");
            n(rowPoiTip, tvPoiTip, item.getTipText());
            TextView tvPoiDescription = binding.tvPoiDescription;
            kotlin.jvm.internal.p.h(tvPoiDescription, "tvPoiDescription");
            c3251a.e(tvPoiDescription, item.getDescription());
            final CardAction action = item.getAction();
            String appLink = action != null ? action.getAppLink() : null;
            if (appLink == null || La.H.x0(appLink)) {
                String webLink = action != null ? action.getWebLink() : null;
                if (webLink == null || La.H.x0(webLink)) {
                    binding.btnPoiAction.setVisibility(8);
                    binding.vPoiBottomFade.setVisibility(8);
                    binding.flPoiFooter.setVisibility(8);
                    q(binding, style);
                    return;
                }
            }
            binding.btnPoiAction.setVisibility(0);
            binding.vPoiBottomFade.setVisibility(0);
            binding.flPoiFooter.setVisibility(0);
            TextView textView = binding.btnPoiAction;
            String strD3 = jVar.d(action != null ? action.getLabel() : null);
            if (strD3 == null) {
                strD3 = "开始导航";
            }
            textView.setText(strD3);
            binding.btnPoiAction.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    U.Companion.j(onOpenLink, action, view);
                }
            });
            binding.flPoiFooter.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.S
                @Override // java.lang.Runnable
                public final void run() {
                    U.Companion.k(binding, style);
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x010b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void l(T5.s r20, java.util.List<java.lang.String> r21, final p9.InterfaceC5063a<Y8.t> r22) {
            /*
                Method dump skipped, instructions count: 408
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.amap.U.Companion.l(T5.s, java.util.List, p9.a):void");
        }

        public final void n(View row, TextView valueTv, String value) {
            String strD = N5.j.INSTANCE.d(value);
            if (strD == null) {
                row.setVisibility(8);
            } else {
                valueTv.setText(strD);
                row.setVisibility(0);
            }
        }

        public final void o(TextView tv, PoiDetailCardItem item) throws Resources.NotFoundException {
            C3251a c3251a = C3251a.INSTANCE;
            String strH = c3251a.h(item.getRating());
            ArrayList arrayList = new ArrayList(3);
            if (strH != null) {
                arrayList.add(strH);
            }
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(item.getDistanceText());
            if (strD != null) {
                arrayList.add(strD);
            }
            String strD2 = jVar.d(item.getStatusText());
            if (strD2 != null) {
                arrayList.add(strD2);
            }
            if (arrayList.isEmpty()) {
                tv.setVisibility(8);
                c3251a.f(tv);
                return;
            }
            int color = tv.getResources().getColor(R$color.card_map_poi_meta, null);
            tv.setVisibility(0);
            tv.setTextSize(11.0f);
            tv.setTextColor(color);
            tv.setText(Z8.F.A0(arrayList, " · ", null, null, 0, null, null, 62, null));
            if (strH == null) {
                c3251a.f(tv);
            } else {
                c3251a.a(tv, color);
                tv.setCompoundDrawablePadding((int) (tv.getResources().getDisplayMetrics().density * 8.0f));
            }
        }

        public final void p(T5.s binding, int count) {
            LinearLayout llGalleryDots = binding.llGalleryDots;
            kotlin.jvm.internal.p.h(llGalleryDots, "llGalleryDots");
            llGalleryDots.removeAllViews();
            ViewPager2 vpGallery = binding.vpGallery;
            kotlin.jvm.internal.p.h(vpGallery, "vpGallery");
            int i10 = R$id.tag_poi_gallery_page_callback;
            Object tag = vpGallery.getTag(i10);
            ViewPager2.i iVar = tag instanceof ViewPager2.i ? (ViewPager2.i) tag : null;
            if (iVar != null) {
                vpGallery.r(iVar);
            }
            vpGallery.setTag(i10, null);
            if (count <= 1) {
                llGalleryDots.setVisibility(8);
                return;
            }
            llGalleryDots.setVisibility(0);
            Context context = llGalleryDots.getContext();
            float f10 = context.getResources().getDisplayMetrics().density;
            int i11 = (int) (6 * f10);
            int i12 = (int) (3 * f10);
            int currentItem = vpGallery.getCurrentItem();
            int i13 = 0;
            while (i13 < count) {
                View view = new View(context);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i11, i11);
                marginLayoutParams.setMarginStart(i12);
                marginLayoutParams.setMarginEnd(i12);
                view.setLayoutParams(marginLayoutParams);
                view.setBackgroundResource(R$drawable.bg_card_map_gallery_dot);
                view.setSelected(i13 == currentItem);
                llGalleryDots.addView(view);
                i13++;
            }
            b bVar = new b(llGalleryDots);
            vpGallery.j(bVar);
            vpGallery.setTag(R$id.tag_poi_gallery_page_callback, bVar);
        }

        public final void q(T5.s binding, PoiDetailStyle style) {
            FrameLayout flPoiFooter = binding.flPoiFooter;
            kotlin.jvm.internal.p.h(flPoiFooter, "flPoiFooter");
            View vPoiBottomFade = binding.vPoiBottomFade;
            kotlin.jvm.internal.p.h(vPoiBottomFade, "vPoiBottomFade");
            NestedScrollView scrollPoiDetail = binding.scrollPoiDetail;
            kotlin.jvm.internal.p.h(scrollPoiDetail, "scrollPoiDetail");
            float f10 = flPoiFooter.getResources().getDisplayMetrics().density;
            int i10 = (int) (com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME * f10);
            int i11 = (int) (16 * f10);
            if (flPoiFooter.getVisibility() != 0) {
                vPoiBottomFade.setVisibility(8);
                if (scrollPoiDetail.getPaddingBottom() != i11) {
                    scrollPoiDetail.setPadding(scrollPoiDetail.getPaddingLeft(), scrollPoiDetail.getPaddingTop(), scrollPoiDetail.getPaddingRight(), i11);
                    return;
                }
                return;
            }
            vPoiBottomFade.setVisibility(0);
            int iF = C5685n.f(flPoiFooter.getHeight(), (int) (style.getFooterMinHeightDp() * f10));
            int iMax = Math.max(i10, ((int) (56 * f10)) + iF);
            ViewGroup.LayoutParams layoutParams = vPoiBottomFade.getLayoutParams();
            if (layoutParams.height != iMax) {
                layoutParams.height = iMax;
                vPoiBottomFade.setLayoutParams(layoutParams);
            }
            int i12 = iF + i11;
            if (scrollPoiDetail.getPaddingBottom() != i12) {
                scrollPoiDetail.setPadding(scrollPoiDetail.getPaddingLeft(), scrollPoiDetail.getPaddingTop(), scrollPoiDetail.getPaddingRight(), i12);
            }
        }

        public final String r(String url) {
            if (!La.D.X(url, "http://", false, 2, null)) {
                return url;
            }
            return "https://" + La.H.R0(url, "http://");
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.cardId = "";
    }

    public static final Y8.t U(PoiDetailCardItem poiDetailCardItem, U u10, String str, String str2) {
        M5.a aVar = M5.a.INSTANCE;
        CardAction action = poiDetailCardItem.getAction();
        if (aVar.d(action != null ? action.getLabel() : null)) {
            M5.a.b(aVar, u10.cardId, M5.a.CARD_TYPE_POI_DETAIL, M5.a.ACTION_START_NAV, null, 8, null);
        }
        N5.d.G(u10, str, str2, null, false, false, false, 60, null);
        return Y8.t.f7040a;
    }

    @Override // N5.d
    public void C(N5.n model) {
        kotlin.jvm.internal.p.i(model, "model");
        if (model instanceof O) {
            O o10 = (O) model;
            this.cardId = o10.getCardId();
            final PoiDetailCardItem poiDetailCardItem = (PoiDetailCardItem) Z8.F.s0(o10.b());
            if (poiDetailCardItem == null) {
                return;
            }
            Companion companion = INSTANCE;
            T5.s sVar = this.detailBinding;
            if (sVar == null) {
                kotlin.jvm.internal.p.A("detailBinding");
                sVar = null;
            }
            Companion.i(companion, sVar, poiDetailCardItem, new p9.p() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.P
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return U.U(poiDetailCardItem, this, (String) obj, (String) obj2);
                }
            }, null, null, 16, null);
        }
    }

    @Override // N5.d
    public void D(CardEnvelope envelope, N5.n model) {
        String taskId;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        M5.a aVar = M5.a.INSTANCE;
        if (model == null || (taskId = model.getCardId()) == null) {
            taskId = envelope.getTaskId();
        }
        aVar.c(taskId, M5.a.CARD_TYPE_POI_DETAIL);
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.s sVarC = T5.s.c(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(sVarC, "inflate(...)");
        this.detailBinding = sVarC;
        C3251a c3251a = C3251a.INSTANCE;
        if (sVarC == null) {
            kotlin.jvm.internal.p.A("detailBinding");
            sVarC = null;
        }
        FrameLayout frameLayoutB = sVarC.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        c3251a.b(frameLayoutB);
    }

    public /* synthetic */ U(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
