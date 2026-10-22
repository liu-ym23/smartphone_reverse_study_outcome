package com.android.ttcjpaysdk.bindcard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.TextViewExtKt;
import com.android.ttcjpaysdk.base.ui.widget.CJPayBoldTextView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardTitleBean;
import com.android.ttcjpaysdk.bindcard.base.utils.ImageUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.TextTypeFaceUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001d\u001a\u00020\u00122\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00160 j\b\u0012\u0004\u0012\u00020\u0016`!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0016H\u0002J0\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayBindCardTitle;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ivSubTitleIcon", "Landroid/widget/ImageView;", "ivTitleIcon", "tvBottomTitle", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayBoldTextView;", "tvLeftTitle", "tvRightTitle", "tvSubTitleText", "Landroid/widget/TextView;", "bindView", "", "getLayoutId", "", "getSubTitleVoucher", "", "processMainTitle", "titleInfo", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardTitleBean;", "processSubTitle", "setMainTitle", "title", "setSubTitle", "voucher", "vouchers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setTitleInfo", "showSubTitleVoucherSingleLine", "", "textView", "voucherText", "showTitleWithPriceInSingleLine", "ivBankIcon", "tvBankName", "bankIconUrl", "bankName", "price", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPayBindCardTitle extends RelativeLayout {
    private ImageView ivSubTitleIcon;
    private ImageView ivTitleIcon;
    private CJPayBoldTextView tvBottomTitle;
    private CJPayBoldTextView tvLeftTitle;
    private CJPayBoldTextView tvRightTitle;
    private TextView tvSubTitleText;

    public int getLayoutId() {
        return R.layout.cj_pay_bind_card_title_layout;
    }

    public final String getSubTitleVoucher() {
        ImageView r100 = this.ivSubTitleIcon;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.getVisibility() != 8) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L22;
        TextView r102 = this.tvSubTitleText;
        if (r102 == null) goto L23;
        CharSequence r103 = r102.getText();
        if (r103 == null) goto L24;
        String r104 = r103.toString();
        if (r104 != null) goto L20;
        return "";
    L20:
        return r104;
    L24:
        return "";
    L23:
        return "";
    L22:
        return "";
    L7:
        r101 = false;
        goto L8
    }

    private final void bindView() {
        View r100 = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        this.ivTitleIcon = (ImageView) r100.findViewById(R.id.iv_title_icon);
        this.tvLeftTitle = (CJPayBoldTextView) r100.findViewById(R.id.tv_title_left);
        this.tvRightTitle = (CJPayBoldTextView) r100.findViewById(R.id.tv_title_right);
        this.tvBottomTitle = (CJPayBoldTextView) r100.findViewById(R.id.tv_title_bottom);
        this.ivSubTitleIcon = (ImageView) r100.findViewById(R.id.iv_sub_title_icon);
        this.tvSubTitleText = (TextView) r100.findViewById(R.id.tv_sub_title_text);
    }

    public CJPayBindCardTitle(Context r100) {
        super(r100);
        bindView();
    }

    private final void processMainTitle(CJPayBindCardTitleBean r100) {
        if ((!StringsKt.isBlank(r100.singleTitle)) == false) goto L5;
        setMainTitle(r100.singleTitle);
        return;
    L5:
        setMainTitle(r100);
    }

    private final void processSubTitle(CJPayBindCardTitleBean r100) {
        if (this.ivSubTitleIcon != null) goto L5;
        return;
    L5:
        if (this.tvSubTitleText != null) goto L8;
        return;
    L8:
        if (r100.hasVoucher() == false) goto L10;
        setSubTitle(r100.voucherList, r100);
        return;
    L10:
        setSubTitle(new ArrayList(), r100);
    }

    private final void setMainTitle(CJPayBindCardTitleBean r110) {
        if (this.ivTitleIcon != null) goto L5;
    L15:
        boolean r100 = false;
    L16:
        String r101 = null;
        if (r100 == false) goto L19;
        CJPayBindCardTitle r102 = this;
    L20:
        if (r102 == null) goto L179;
        String r103 = r110.bankIconUrl;
        String r111 = r110.bankName;
        String r112 = r110.orderAmount;
        boolean r113 = r110.isPayNewCard;
        Context r104 = r102.getContext();
        if (r113 == false) goto L24;
        int r105 = R.string.cj_pay_add_bank_card_pay;
    L25:
        String r106 = r104.getString(r105);
        String r107 = r102.getContext().getString(R.string.cj_pay_add);
        CJPayBoldTextView r108 = r102.tvLeftTitle;
        if (r108 == null) goto L29;
        r108.setText(r107);
    L29:
        CJPayBoldTextView r109 = r102.tvBottomTitle;
        if (r109 == null) goto L33;
        r109.setVisibility(8);
    L33:
        CJPayBoldTextView r114 = r102.tvRightTitle;
        if (r114 == null) goto L37;
        r114.setVisibility(0);
    L37:
        CJPayBoldTextView r115 = r102.tvRightTitle;
        if (r115 == null) goto L41;
        r115.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    L41:
        CJPayBoldTextView r116 = r102.tvRightTitle;
        if (r116 == null) goto L45;
        r116.setSingleLine();
    L45:
        if (StringsKt.isBlank(r103) == false) goto L47;
    L162:
        CJPayBoldTextView r117 = r102.tvLeftTitle;
        if (r117 == null) goto L166;
        r117.setVisibility(8);
    L166:
        ImageView r118 = r102.ivTitleIcon;
        if (r118 == null) goto L170;
        r118.setVisibility(8);
    L170:
        CJPayBoldTextView r119 = r102.tvBottomTitle;
        if (r119 == null) goto L174;
        r119.setVisibility(8);
    L174:
        CJPayBoldTextView r120 = r102.tvRightTitle;
        if (r120 == null) goto L188;
        r120.setText(r106);
        return;
    L188:
        return;
    L47:
        if (StringsKt.isBlank(r111) == true) goto L162;
        if (r113 == true) goto L52;
    L103:
        if (r113 == false) goto L127;
        if (StringsKt.isBlank(r112) == false) goto L127;
        CJPayBoldTextView r121 = r102.tvLeftTitle;
        if (r121 == null) goto L110;
        r121.setVisibility(0);
    L110:
        ImageView r122 = r102.ivTitleIcon;
        if (r122 == null) goto L114;
        r122.setVisibility(0);
    L114:
        ImageView r123 = r102.ivTitleIcon;
        if (r123 == null) goto L117;
        ImageUtil.INSTANCE.loadImage(r103, r123);
    L117:
        CJPayBoldTextView r124 = r102.tvRightTitle;
        if (r124 == null) goto L185;
        StringBuilder r125 = new StringBuilder();
        r125.append(r111);
        Context r126 = CJPayHostInfo.applicationContext;
        if (r126 == null) goto L125;
        Resources r127 = r126.getResources();
        if (r127 == null) goto L125;
        r101 = r127.getString(R.string.cj_pay_card_payment);
    L125:
        r125.append(r101);
        r124.setText(r125.toString());
        return;
    L185:
        return;
    L127:
        if ((!StringsKt.isBlank(r103)) == true) goto L129;
    L150:
        CJPayBoldTextView r128 = r102.tvLeftTitle;
        if (r128 == null) goto L154;
        r128.setVisibility(8);
    L154:
        ImageView r129 = r102.ivTitleIcon;
        if (r129 == null) goto L158;
        r129.setVisibility(8);
    L158:
        CJPayBoldTextView r130 = r102.tvRightTitle;
        if (r130 == null) goto L187;
        r130.setText(r106);
        return;
    L187:
        return;
    L129:
        if ((!StringsKt.isBlank(r111)) == false) goto L150;
        CJPayBoldTextView r131 = r102.tvLeftTitle;
        if (r131 == null) goto L134;
        r131.setVisibility(0);
    L134:
        ImageView r132 = r102.ivTitleIcon;
        if (r132 == null) goto L138;
        r132.setVisibility(0);
    L138:
        ImageView r133 = r102.ivTitleIcon;
        if (r133 == null) goto L141;
        ImageUtil.INSTANCE.loadImage(r103, r133);
    L141:
        CJPayBoldTextView r134 = r102.tvRightTitle;
        if (r134 == null) goto L186;
        StringBuilder r135 = new StringBuilder();
        r135.append(r111);
        Context r136 = CJPayHostInfo.applicationContext;
        if (r136 == null) goto L149;
        Resources r137 = r136.getResources();
        if (r137 == null) goto L149;
        r101 = r137.getString(R.string.cj_pay_card);
    L149:
        r135.append(r101);
        r134.setText(r135.toString());
        return;
    L186:
        return;
    L52:
        if ((!StringsKt.isBlank(r112)) == false) goto L103;
        if (CJPayHostInfo.applicationContext == null) goto L103;
        CJPayBoldTextView r138 = r102.tvLeftTitle;
        if (r138 == null) goto L59;
        r138.setVisibility(8);
    L59:
        ImageView r139 = r102.ivTitleIcon;
        if (r139 == null) goto L63;
        r139.setVisibility(0);
    L63:
        ImageView r140 = r102.ivTitleIcon;
        if (r140 == null) goto L66;
        ImageUtil.INSTANCE.loadImage(r103, r140);
    L66:
        ImageView r141 = r102.ivTitleIcon;
        Intrinsics.checkNotNull(r141);
        CJPayBoldTextView r142 = r102.tvRightTitle;
        Intrinsics.checkNotNull(r142);
        if (r102.showTitleWithPriceInSingleLine(r141, r142, r103, r111, r112) == false) goto L78;
        CJPayBoldTextView r143 = r102.tvRightTitle;
        if (r143 == null) goto L77;
        StringBuilder r144 = new StringBuilder();
        r144.append(r111);
        Context r145 = CJPayHostInfo.applicationContext;
        if (r145 == null) goto L76;
        Resources r146 = r145.getResources();
        if (r146 == null) goto L76;
        r101 = r146.getString(R.string.cj_pay_card_payment_with_price, new Object[]{r112});
    L76:
        r144.append(r101);
        r143.setText(r144.toString());
    L77:
        TextTypeFaceUtils r147 = TextTypeFaceUtils.INSTANCE;
        CJPayBoldTextView r148 = r102.tvRightTitle;
        Intrinsics.checkNotNull(r148);
        r147.setBindCardOrderAmountTypeface(r148);
        return;
    L78:
        CJPayBoldTextView r149 = r102.tvRightTitle;
        if (r149 == null) goto L88;
        StringBuilder r150 = new StringBuilder();
        r150.append(r111);
        Context r151 = CJPayHostInfo.applicationContext;
        if (r151 == null) goto L86;
        Resources r152 = r151.getResources();
        if (r152 == null) goto L86;
        String r153 = r152.getString(R.string.cj_pay_card_payment);
    L87:
        r150.append(r153);
        r149.setText(r150.toString());
    L86:
        r153 = null;
    L88:
        CJPayBoldTextView r154 = r102.tvBottomTitle;
        if (r154 == null) goto L98;
        Context r155 = CJPayHostInfo.applicationContext;
        if (r155 == null) goto L96;
        Resources r156 = r155.getResources();
        if (r156 == null) goto L96;
        String r157 = r156.getString(R.string.cj_pay_currency_money, new Object[]{r112});
    L97:
        r154.setText(r157);
    L96:
        r157 = null;
    L98:
        CJPayBoldTextView r158 = r102.tvBottomTitle;
        if (r158 == null) goto L102;
        r158.setVisibility(0);
    L102:
        TextTypeFaceUtils r159 = TextTypeFaceUtils.INSTANCE;
        CJPayBoldTextView r160 = r102.tvBottomTitle;
        Intrinsics.checkNotNull(r160);
        TextTypeFaceUtils.setOrderAmountType$default(r159, r160, null, 2, null);
        return;
    L24:
        r105 = R.string.cj_pay_add_new_bank_card;
        goto L25
    L179:
        return;
    L19:
        r102 = null;
        goto L20
    L5:
        if (this.tvLeftTitle == null) goto L15;
        if (this.tvRightTitle == null) goto L15;
        if (this.tvBottomTitle == null) goto L15;
        if (this.ivSubTitleIcon == null) goto L15;
        if (this.tvSubTitleText == null) goto L15;
        r100 = true;
        goto L16
    }

    public final void setTitleInfo(CJPayBindCardTitleBean r100) {
        Intrinsics.checkNotNullParameter(r100, "titleInfo");
        if (this.ivTitleIcon != null) goto L5;
    L15:
        boolean r101 = false;
    L16:
        if (r101 == false) goto L18;
        CJPayBindCardTitle r102 = this;
    L19:
        if (r102 == null) goto L22;
        r102.processMainTitle(r100);
        r102.processSubTitle(r100);
        return;
    L22:
        return;
    L18:
        r102 = null;
        goto L19
    L5:
        if (this.tvLeftTitle == null) goto L15;
        if (this.tvRightTitle == null) goto L15;
        if (this.tvBottomTitle == null) goto L15;
        if (this.ivSubTitleIcon == null) goto L15;
        if (this.tvSubTitleText == null) goto L15;
        r101 = true;
        goto L16
    }

    private final void setMainTitle(String r100) {
        ImageView r101 = this.ivTitleIcon;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
    L6:
        CJPayBoldTextView r102 = this.tvLeftTitle;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        CJPayBoldTextView r103 = this.tvBottomTitle;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        CJPayBoldTextView r104 = this.tvRightTitle;
        if (r104 == null) goto L18;
        r104.setVisibility(0);
    L18:
        CJPayBoldTextView r105 = this.tvRightTitle;
        if (r105 == null) goto L22;
        r105.setText(r100);
        TextTypeFaceUtils.INSTANCE.setBindCardOrderAmountTypeface(r105);
        return;
    }

    public CJPayBindCardTitle(Context r100, AttributeSet r101) {
        super(r100, r101);
        bindView();
    }

    private final void setSubTitle(String r100, CJPayBindCardTitleBean r101) {
        if ((!StringsKt.isBlank(r100)) == false) goto L12;
        ImageView r102 = this.ivSubTitleIcon;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        TextView r103 = this.tvSubTitleText;
        if (r103 == null) goto L45;
        TextViewExtKt.showColorText(r103, r100, getResources().getColor(R.color.cj_pay_color_pay_result_red));
        return;
    L45:
        return;
    L12:
        if (r101.hasSafetyIconAndText() == false) goto L23;
        ImageView r104 = this.ivSubTitleIcon;
        if (r104 == null) goto L17;
        r104.setVisibility(0);
    L17:
        ImageView r105 = this.ivSubTitleIcon;
        if (r105 == null) goto L20;
        ImageUtil.INSTANCE.loadImage(r101.safetyIconUrl, r105);
    L20:
        TextView r106 = this.tvSubTitleText;
        if (r106 == null) goto L47;
        TextViewExtKt.showColorText(r106, r101.safetyText, getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_75));
        return;
    L47:
        return;
    L23:
        ImageView r107 = this.ivSubTitleIcon;
        if (r107 == null) goto L28;
        r107.setVisibility(0);
    L28:
        if ((!StringsKt.isBlank(r101.safetyIconUrl)) == false) goto L32;
        ImageView r108 = this.ivSubTitleIcon;
        if (r108 == null) goto L35;
        ImageUtil.INSTANCE.loadImage(r101.safetyIconUrl, r108);
    L35:
        TextView r109 = this.tvSubTitleText;
        if (r109 == null) goto L49;
        String r110 = r101.safetyIconUrl;
        if ((!StringsKt.isBlank(r110)) == true) goto L41;
        r110 = null;
    L41:
        if (r110 != null) goto L43;
        r110 = getResources().getString(R.string.cj_pay_bank_card_million_insurance_title);
    L43:
        TextViewExtKt.showColorText(r109, r110, getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_75));
        return;
    L49:
        return;
    L32:
        ImageView r111 = this.ivSubTitleIcon;
        if (r111 == null) goto L35;
        r111.setBackgroundResource(R.drawable.cj_pay_icon_safe_shield_blue);
        goto L35
    }

    private final boolean showSubTitleVoucherSingleLine(TextView r100, String r101) {
        if (StringsKt.isBlank(r101) == false) goto L5;
        return false;
    L5:
        int r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r103 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r104 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext());
        r100.setText(r101);
        r100.measure(r102, r103);
        if (r104 <= (r100.getMeasuredWidth() + CJPayBasicExtensionKt.dip2px(32.0f, getContext()))) goto L9;
        return true;
    L9:
        return false;
    }

    private final void setSubTitle(ArrayList<String> r100, CJPayBindCardTitleBean r101) {
        if (this.tvSubTitleText != null) goto L6;
        return;
    L6:
        if ((!r100.isEmpty()) == false) goto L18;
        int r102 = r100.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L27;
        String r104 = (String) ListProtector.get(r100, r103);
        if (StringsKt.isBlank(r104) == true) goto L17;
        if (r103 == CollectionsKt.getLastIndex(r100)) goto L13;
        TextView r105 = this.tvSubTitleText;
        Intrinsics.checkNotNull(r105);
        if (showSubTitleVoucherSingleLine(r105, r104) == false) goto L17;
        setSubTitle(r104, r101);
        return;
    L13:
        setSubTitle(r104, r101);
        return;
    L17:
        r103 = r103 + 1;
        goto L8
    L27:
        return;
    L18:
        setSubTitle("", r101);
    }

    private final boolean showTitleWithPriceInSingleLine(ImageView r100, TextView r101, String r102, String r103, String r104) {
        r100.setVisibility(0);
        r101.setVisibility(0);
        ImageUtil.INSTANCE.loadImage(r102, r100);
        StringBuilder r105 = new StringBuilder();
        r105.append(r103);
        Context r106 = CJPayHostInfo.applicationContext;
        if (r106 == null) goto L7;
        Resources r107 = r106.getResources();
        if (r107 == null) goto L7;
        String r108 = r107.getString(R.string.cj_pay_card_payment_with_price, new Object[]{r104});
    L8:
        r105.append(r108);
        r101.setText(r105.toString());
        TextTypeFaceUtils.INSTANCE.setBindCardOrderAmountTypeface(r101);
        int r109 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r110 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r111 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext());
        r100.measure(r109, r110);
        r101.measure(r109, r110);
        if (r111 <= ((r100.getMeasuredWidth() + r101.getMeasuredWidth()) + CJPayBasicExtensionKt.dip2px(36.0f, getContext()))) goto L12;
        return true;
    L12:
        return false;
    L7:
        r108 = null;
        goto L8
    }
}
