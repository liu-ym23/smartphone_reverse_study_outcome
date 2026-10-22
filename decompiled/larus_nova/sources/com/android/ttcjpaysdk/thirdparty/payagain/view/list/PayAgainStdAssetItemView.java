package com.android.ttcjpaysdk.thirdparty.payagain.view.list;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.component.agreement.CJRowSwitchText;
import com.android.ttcjpaysdk.base.ui.component.tag.CJTagView;
import com.android.ttcjpaysdk.std.asset.view.StdAssetItemView;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetGroupView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/view/list/PayAgainStdAssetItemView;", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetItemView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "parentGroupView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;Landroid/util/AttributeSet;)V", "adapterItemHeight", "", "bindView", "initView", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayAgainStdAssetItemView extends StdAssetItemView {
    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetItemView
    public void adapterItemHeight() {
        super.adapterItemHeight();
        CJRowSwitchText r100 = getOptionVoucher();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Boolean r103 = null;
        if (r102 == false) goto L31;
        CJTagView r104 = getVoucherTags();
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L31;
        TextView r106 = getTitleView();
        if (r106 == null) goto L22;
        CharSequence r107 = r106.getText();
        if (r107 == null) goto L22;
        Boolean r108 = Boolean.valueOf(!StringsKt.isBlank(r107));
    L23:
        if (r108 == null) goto L25;
        boolean r109 = r108.booleanValue();
    L26:
        if (r109 == false) goto L31;
        LinearLayout r110 = getItemContentLayout();
        if (r110 == null) goto L88;
        r110.setMinimumHeight(CJPayBasicExtensionKt.dp(83.0f));
        return;
    L88:
        return;
    L25:
        r109 = false;
    L22:
        r108 = null;
        goto L23
    L13:
        if (CJPayKotlinExtensionsKt.isVisible(r104) != true) goto L15;
        r105 = true;
    L31:
        CJRowSwitchText r111 = getOptionVoucher();
        if (r111 != null) goto L34;
    L36:
        boolean r112 = false;
    L37:
        if (r112 == false) goto L52;
        TextView r113 = getTitleView();
        if (r113 == null) goto L43;
        CharSequence r114 = r113.getText();
        if (r114 == null) goto L43;
        Boolean r115 = Boolean.valueOf(!StringsKt.isBlank(r114));
    L44:
        if (r115 == null) goto L46;
        boolean r116 = r115.booleanValue();
    L47:
        if (r116 == false) goto L52;
        LinearLayout r117 = getItemContentLayout();
        if (r117 == null) goto L89;
        r117.setMinimumHeight(CJPayBasicExtensionKt.dp(59.0f));
        return;
    L89:
        return;
    L46:
        r116 = false;
    L43:
        r115 = null;
    L52:
        TextView r118 = getTitleView();
        if (r118 == null) goto L57;
        CharSequence r119 = r118.getText();
        if (r119 == null) goto L57;
        Boolean r120 = Boolean.valueOf(!StringsKt.isBlank(r119));
    L58:
        if (r120 == null) goto L60;
        boolean r121 = r120.booleanValue();
    L61:
        if (r121 == false) goto L85;
        TextView r122 = getDescTitleView();
        if (r122 == null) goto L67;
        CharSequence r123 = r122.getText();
        if (r123 == null) goto L67;
        r103 = Boolean.valueOf(!StringsKt.isBlank(r123));
    L67:
        if (r103 == null) goto L69;
        boolean r124 = r103.booleanValue();
    L70:
        if (r124 == false) goto L86;
        CJTagView r125 = getVoucherTags();
        if (r125 != null) goto L74;
    L76:
        r101 = false;
    L77:
        if (r101 == false) goto L87;
        LinearLayout r126 = getItemContentLayout();
        if (r126 == null) goto L90;
        r126.setMinimumHeight(CJPayBasicExtensionKt.dp(78.0f));
        return;
    L90:
        return;
    L87:
        return;
    L74:
        if (CJPayKotlinExtensionsKt.isVisible(r125) != true) goto L76;
    L86:
        return;
    L69:
        r124 = false;
        goto L70
    L85:
        return;
    L60:
        r121 = false;
    L57:
        r120 = null;
        goto L58
    L34:
        if (CJPayKotlinExtensionsKt.isVisible(r111) != true) goto L36;
        r112 = true;
        goto L37
    L5:
        if (CJPayKotlinExtensionsKt.isVisible(r100) != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetItemView
    public void bindView() {
        super.bindView();
        ImageView r100 = getIconView();
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L6:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
        r103.width = CJPayBasicExtensionKt.dp(20.0f);
        r103.height = CJPayBasicExtensionKt.dp(20.0f);
        r100.setLayoutParams(r103);
        ImageView r104 = getIconMaskView();
        if (r104 == null) goto L9;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L10:
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r105;
        r106.width = CJPayBasicExtensionKt.dp(20.0f);
        r106.height = CJPayBasicExtensionKt.dp(20.0f);
        r104.setLayoutParams(r106);
        LinearLayout r107 = getItemContentLayout();
        boolean r108 = false;
        if (r107 == null) goto L13;
        int r109 = r107.indexOfChild(getDescTitleView());
    L14:
        LinearLayout r110 = getItemContentLayout();
        if (r110 == null) goto L17;
        int r111 = r110.indexOfChild(getVoucherTags());
    L19:
        if (r109 >= r111) goto L26;
        LinearLayout r112 = getItemContentLayout();
        if (r112 == null) goto L23;
        r112.removeViewAt(r109);
    L23:
        LinearLayout r113 = getItemContentLayout();
        if (r113 == null) goto L26;
        r113.addView(getDescTitleView(), r109 + 1);
    L26:
        View r114 = getSplitLine();
        if (r114 == null) goto L29;
        CJPayViewExtensionsKt.viewGone(r114);
    L29:
        TextView r115 = getGuideView();
        if (r115 == null) goto L32;
        r115.setTextColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_tertiary));
    L32:
        CJRowSwitchText r116 = getOptionVoucher();
        if (r116 == null) goto L35;
        r116.setLeftContentColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_tertiary));
        r116.setLeftContentSize(12);
        r116.setTipsColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_tertiary));
        r116.setTipsSize(12);
    L35:
        TextView r117 = getTitleView();
        if (r117 == null) goto L40;
        CharSequence r118 = r117.getText();
        if (r118 == null) goto L40;
        Boolean r119 = Boolean.valueOf(!StringsKt.isBlank(r118));
    L41:
        if (r119 == null) goto L43;
        boolean r120 = r119.booleanValue();
    L44:
        if (r120 == false) goto L66;
        TextView r121 = getDescTitleView();
        if (r121 == null) goto L50;
        CharSequence r122 = r121.getText();
        if (r122 == null) goto L50;
        Boolean r123 = Boolean.valueOf(!StringsKt.isBlank(r122));
    L51:
        if (r123 == null) goto L53;
        boolean r124 = r123.booleanValue();
    L54:
        if (r124 == false) goto L66;
        CJTagView r125 = getVoucherTags();
        if (r125 != null) goto L58;
    L60:
        boolean r126 = false;
    L61:
        if (r126 == false) goto L66;
        LinearLayout r127 = getItemContentLayout();
        if (r127 == null) goto L100;
        r127.setMinimumHeight(CJPayBasicExtensionKt.dp(80.0f));
    L100:
        TextView r128 = getSubTitleView();
        if (r128 == null) goto L104;
        r128.setMaxLines(1);
    L104:
        TextView r129 = getSubTitleView();
        if (r129 == null) goto L108;
        r129.setEllipsize(TextUtils.TruncateAt.END);
    L108:
        TextView r130 = getSubTitleView();
        if (r130 == null) goto L111;
        r101 = r130.getLayoutParams();
    L111:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r101).rightMargin = CJPayBasicExtensionKt.dp(16.0f);
        return;
    L58:
        if (CJPayKotlinExtensionsKt.isVisible(r125) != true) goto L60;
        r126 = true;
        goto L61
    L53:
        r124 = false;
    L50:
        r123 = null;
    L66:
        TextView r131 = getTitleView();
        if (r131 == null) goto L71;
        CharSequence r132 = r131.getText();
        if (r132 == null) goto L71;
        Boolean r133 = Boolean.valueOf(!StringsKt.isBlank(r132));
    L72:
        if (r133 == null) goto L74;
        boolean r134 = r133.booleanValue();
    L75:
        if (r134 == false) goto L96;
        TextView r135 = getSubTitleView();
        if (r135 == null) goto L81;
        CharSequence r136 = r135.getText();
        if (r136 == null) goto L81;
        Boolean r137 = Boolean.valueOf(!StringsKt.isBlank(r136));
    L82:
        if (r137 == null) goto L84;
        boolean r138 = r137.booleanValue();
    L85:
        if (r138 == true) goto L92;
        CJTagView r139 = getVoucherTags();
        if (r139 != null) goto L89;
    L91:
        if (r108 == false) goto L96;
    L89:
        if (CJPayKotlinExtensionsKt.isVisible(r139) != true) goto L91;
        r108 = true;
    L92:
        LinearLayout r140 = getItemContentLayout();
        if (r140 == null) goto L100;
        r140.setMinimumHeight(CJPayBasicExtensionKt.dp(59.0f));
        goto L100
    L84:
        r138 = false;
    L81:
        r137 = null;
    L96:
        LinearLayout r141 = getItemContentLayout();
        if (r141 == null) goto L100;
        r141.setMinimumHeight(CJPayBasicExtensionKt.dp(52.0f));
        goto L100
    L74:
        r134 = false;
    L71:
        r133 = null;
        goto L72
    L43:
        r120 = false;
    L40:
        r119 = null;
        goto L41
    L17:
        r111 = 0;
        goto L19
    L13:
        r109 = 0;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetItemView
    public void initView() {
        super.initView();
        View r100 = getSplitLine();
        if (r100 == null) goto L6;
        CJPayViewExtensionsKt.viewGone(r100);
        return;
    }

    public PayAgainStdAssetItemView(Context r100, IAssetGroupView r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PayAgainStdAssetItemView(Context r100, IAssetGroupView r101, AttributeSet r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
