package com.android.ttcjpaysdk.integrated.counter.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.Utils.PaymentUIUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayViewHolderUtils;", "", "()V", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayViewHolderUtils {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006JL\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0006JB\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bJ\u001e\u0010)\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000e¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayViewHolderUtils$Companion;", "", "()V", "loadImage", "", "url", "", "view", "Landroid/widget/ImageView;", "maskView", "isEnable", "", "setIconSize", "iconLayout", "Landroid/view/ViewGroup;", "iconView", "Landroid/view/View;", "iconMaskView", "size", "", "setIconUrl", "setRecommendView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Landroid/widget/TextView;", "mark", "setSubTitleAndSubIcon", "subTitleView", "subTitleIconView", "subIconStr", "subTitleStr", "maxWidth", "isInsufficientCard", "balanceSubTitleStr", "setTitleWithEllipsize", "titleView", "recommendView", "title", "space", "", "isEllipsizeMiddle", "updateIconSize", "paymentMethodInfo", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setRecommendView(Context r100, TextView r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "view");
            PaymentUIUtils.Companion.setMarkView(r100, r101, r102);
        }

        public final void updateIconSize(Context r100, PaymentMethodInfo r101, ViewGroup r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "paymentMethodInfo");
            Intrinsics.checkNotNullParameter(r102, "iconLayout");
            ViewGroup.LayoutParams r103 = r102.getLayoutParams();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r103;
            if (TextUtils.isEmpty(r101.title) == false) goto L7;
            if (TextUtils.isEmpty(r101.mark) == false) goto L7;
        L11:
            r104.setMargins(CJPayBasicUtils.dipToPX(r100, 16.0f), CJPayBasicUtils.dipToPX(r100, 16.0f), CJPayBasicUtils.dipToPX(r100, 16.0f), CJPayBasicUtils.dipToPX(r100, 16.0f));
            return;
        L7:
            if (TextUtils.isEmpty(r101.sub_title) == true) goto L9;
        L12:
            r104.setMargins(CJPayBasicUtils.dipToPX(r100, 16.0f), CJPayBasicUtils.dipToPX(r100, 18.0f), CJPayBasicUtils.dipToPX(r100, 16.0f), CJPayBasicUtils.dipToPX(r100, 18.0f));
            return;
        L9:
            if (TextUtils.isEmpty(r101.sub_title_icon) == true) goto L11;
            goto L11
        }

        public final void loadImage(String r110, ImageView r111, ImageView r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r111, "view");
            Intrinsics.checkNotNullParameter(r112, "maskView");
            PaymentUIUtils.Companion.loadImage$default(PaymentUIUtils.Companion, r110, r111, r112, r113, null, 16, null);
        }

        public final void setIconSize(ViewGroup r100, View r101, View r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "iconLayout");
            Intrinsics.checkNotNullParameter(r101, "iconView");
            Intrinsics.checkNotNullParameter(r102, "iconMaskView");
            if (r103 > 0) goto L5;
            return;
        L5:
            ViewGroup.LayoutParams r104 = r100.getLayoutParams();
            r104.height = r103;
            r104.width = r103;
            ViewGroup.LayoutParams r105 = r101.getLayoutParams();
            r105.height = r103;
            r105.width = r103;
            ViewGroup.LayoutParams r106 = r102.getLayoutParams();
            r106.height = r103;
            r106.width = r103;
        }

        public final void setIconUrl(ImageView r110, ImageView r111, String r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r110, "iconView");
            Intrinsics.checkNotNullParameter(r111, "iconMaskView");
            PaymentUIUtils.Companion.setIconUrl$default(PaymentUIUtils.Companion, r110, r111, r112, r113, null, 16, null);
        }

        public final boolean setTitleWithEllipsize(Context r100, TextView r101, TextView r102, String r103, String r104, float r105, boolean r106) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "titleView");
            Intrinsics.checkNotNullParameter(r102, "recommendView");
            if (TextUtils.isEmpty(r103) == false) goto L5;
            r101.setVisibility(8);
        L17:
            return false;
        L5:
            if (TextUtils.isEmpty(r104) == true) goto L10;
            int r107 = (int) r102.getPaint().measureText(r104);
            if (r107 <= CJPayBasicUtils.dipToPX(r100, 120.0f)) goto L9;
            r107 = CJPayBasicUtils.dipToPX(r100, 120.0f);
        L9:
            int r108 = r107 + CJPayBasicUtils.dipToPX(r100, 8.0f);
        L11:
            int r109 = (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100) - r108) - CJPayBasicUtils.dipToPX(r100, r105);
            r101.setText(r103);
            r101.setVisibility(0);
            r101.setMaxWidth(r109);
            if (r106 == false) goto L14;
            r101.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        L15:
            r101.setSingleLine(true);
            goto L17
        L14:
            r101.setEllipsize(TextUtils.TruncateAt.END);
            goto L15
        L10:
            r108 = 0;
            goto L11
        }

        public final boolean setSubTitleAndSubIcon(Context r100, TextView r101, TextView r102, String r103, String r104, int r105, boolean r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "subTitleView");
            Intrinsics.checkNotNullParameter(r102, "subTitleIconView");
            if (r110 == false) goto L7;
            r102.setVisibility(8);
            r101.setVisibility(0);
            r101.setMaxWidth(r105);
            r101.setEllipsize(TextUtils.TruncateAt.END);
            r101.setSingleLine(true);
            r101.setText(r100.getResources().getString(R.string.cj_pay_card_insufficient));
            return false;
        L7:
            if (TextUtils.isEmpty(r111) == true) goto L11;
            r102.setVisibility(8);
            r101.setVisibility(0);
            r101.setMaxWidth(r105);
            r101.setEllipsize(TextUtils.TruncateAt.END);
            r101.setSingleLine(true);
            r101.setText(r111);
            return false;
        L11:
            if (TextUtils.isEmpty(r103) == true) goto L15;
            r101.setVisibility(8);
            r102.setVisibility(0);
            r102.setMaxWidth(r105);
            r102.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            r102.setSingleLine(true);
            r102.setText(r103);
            return false;
        L15:
            if (TextUtils.isEmpty(r104) == true) goto L18;
            r102.setVisibility(8);
            r101.setVisibility(0);
            r101.setMaxWidth(r105);
            r101.setEllipsize(TextUtils.TruncateAt.END);
            r101.setSingleLine(true);
            r101.setText(r104);
            return false;
        L18:
            r101.setVisibility(8);
            r102.setVisibility(8);
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayViewHolderUtils() {
    }
}
