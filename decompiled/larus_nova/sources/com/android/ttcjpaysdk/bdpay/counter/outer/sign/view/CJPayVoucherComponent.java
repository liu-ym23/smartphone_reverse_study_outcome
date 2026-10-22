package com.android.ttcjpaysdk.bdpay.counter.outer.sign.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.auth.ktextension.CJPayViewExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u001c\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0015J\u001c\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\"\u001a\u00020\u001dH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/view/CJPayVoucherComponent;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "leftMsgDesc", "Landroid/widget/TextView;", "leftTagMsg", "leftTagMsgLayout", "Landroid/view/View;", "rootView", "topLabelCountDownTV", "topLabelDescTV", "topLabelV", "voucherDescV", "voucherInfo", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/view/VoucherInfo;", "voucherLabelV", "voucherMeasureV", "voucherWorthV", "countDownTick", "", "time", "", "disableCard", "initTopLabel", "voucherLabel", "", "countDown", "", "initVoucherCard", "terminateCountDown", "updateBackgroundDrawable", "view", "id", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayVoucherComponent extends FrameLayout {
    public static final Companion Companion = null;
    private static final int LayoutId = 0;
    private TextView leftMsgDesc;
    private TextView leftTagMsg;
    private View leftTagMsgLayout;
    private FrameLayout rootView;
    private TextView topLabelCountDownTV;
    private TextView topLabelDescTV;
    private View topLabelV;
    private TextView voucherDescV;
    private VoucherInfo voucherInfo;
    private TextView voucherLabelV;
    private TextView voucherMeasureV;
    private TextView voucherWorthV;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/view/CJPayVoucherComponent$Companion;", "", "()V", "LayoutId", "", "getLayoutId", "()I", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int getLayoutId() {
            return CJPayVoucherComponent.access$getLayoutId$cp();
        }
    }

    static {
        Companion = new Companion(null);
        LayoutId = R.layout.cj_pay_item_voucher_layout;
    }

    private final void disableCard() {
        int r100 = ColorProtector.parseColor("#57161823");
        TextView r101 = this.voucherWorthV;
        if (r101 == null) goto L5;
        r101.setTextColor(r100);
    L5:
        TextView r102 = this.voucherMeasureV;
        if (r102 == null) goto L8;
        r102.setTextColor(r100);
    L8:
        TextView r103 = this.voucherLabelV;
        if (r103 == null) goto L11;
        r103.setTextColor(r100);
    L11:
        TextView r104 = this.voucherDescV;
        if (r104 == null) goto L14;
        r104.setTextColor(r100);
    L14:
        TextView r105 = this.leftMsgDesc;
        if (r105 == null) goto L17;
        r105.setTextColor(r100);
    L17:
        TextView r106 = this.leftTagMsg;
        if (r106 == null) goto L20;
        r106.setTextColor(r100);
    L20:
        View r107 = this.leftTagMsgLayout;
        if (r107 == null) goto L23;
        CJPayViewExtensionKt.setBgStyle(r107, getContext(), ColorProtector.parseColor("#14161823"), ColorProtector.parseColor("#14161823"), 2);
    L23:
        VoucherInfo r108 = this.voucherInfo;
        if (r108 == null) goto L26;
        String r109 = r108.voucherBgType;
    L28:
        if (Intrinsics.areEqual(r109, "solid_line_voucher_bg") == false) goto L30;
        int r110 = R.drawable.cj_pay_bg_disable_voucher_item_solid_line;
    L31:
        updateBackgroundDrawable(this.rootView, r110);
        updateBackgroundDrawable(this.topLabelV, R.drawable.cj_pay_bg_voucher_component_label_disable);
        return;
    L30:
        Intrinsics.areEqual(r109, "broken_line_voucher_bg");
        r110 = R.drawable.cj_pay_bg_disable_voucher_item;
        goto L31
    L26:
        r109 = null;
        goto L28
    }

    public final void terminateCountDown() {
        TextView r100 = this.topLabelCountDownTV;
        if (r100 == null) goto L7;
        r100.setVisibility(8);
        return;
    }

    public static final /* synthetic */ int access$getLayoutId$cp() {
        return LayoutId;
    }

    public CJPayVoucherComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View r101 = LayoutInflater.from(r100).inflate(LayoutId, this);
        this.rootView = (FrameLayout) r101.findViewById(R.id.cj_pay_voucher_item_root);
        this.voucherWorthV = (TextView) r101.findViewById(R.id.cj_pay_voucher_item_voucher_worth);
        this.voucherMeasureV = (TextView) r101.findViewById(R.id.cj_pay_voucher_item_voucher_measure);
        this.voucherLabelV = (TextView) r101.findViewById(R.id.cj_pay_voucher_item_voucher_label);
        this.voucherDescV = (TextView) r101.findViewById(R.id.cj_pay_voucher_item_voucher_desc);
        this.topLabelV = r101.findViewById(R.id.cj_pay_voucher_item_top_label);
        this.topLabelDescTV = (TextView) r101.findViewById(R.id.cj_pay_voucher_item_top_label_desc);
        this.topLabelCountDownTV = (TextView) r101.findViewById(R.id.cj_pay_voucher_item_top_count_down);
        this.leftMsgDesc = (TextView) r101.findViewById(R.id.voucher_left_msg_desc);
        this.leftTagMsgLayout = r101.findViewById(R.id.voucher_left_tag_des_layout);
        this.leftTagMsg = (TextView) r101.findViewById(R.id.voucher_left_tag_des);
    }

    public final void countDownTick(long r100) {
        View r101 = this.topLabelV;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        TextView r103 = this.topLabelCountDownTV;
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        if (r100 > 0) goto L17;
        disableCard();
        String r104 = "00:00:00";
    L18:
        TextView r105 = this.topLabelCountDownTV;
        if (r105 == null) goto L23;
        r105.setText(" " + r104);
        return;
    L23:
        return;
    L17:
        long r106 = 1000;
        long r107 = (r100 % r106) / ((long) 10);
        long r108 = r100 / r106;
        long r109 = 60;
        long r110 = r108 % r109;
        long r111 = r108 / r109;
        String r112 = StringsKt.padStart(String.valueOf(r107), 2, '0');
        String r113 = StringsKt.padStart(String.valueOf(r110), 2, '0');
        r104 = StringsKt.padStart(String.valueOf(r111), 2, '0') + ':' + r113 + ':' + r112;
        goto L18
    L5:
        if (r101.getVisibility() != 8) goto L7;
        r102 = true;
        goto L8
    }

    public final void initVoucherCard(VoucherInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "voucherInfo");
        this.voucherInfo = r100;
        TextView r101 = this.voucherWorthV;
        if (r101 == null) goto L12;
        CJPayViewExtensionsKt.setTextAndVisible(r101, r100.voucherWorth);
        String r102 = r100.voucherWorth;
        if (r102 != null) goto L7;
    L11:
        CJPayFontUtils.setDouYinMediumTypeface(r101.getContext(), r101);
        goto L12
    L7:
        if (r102.length() > 5) goto L9;
        float r103 = 22.0f;
    L10:
        r101.setTextSize(2, r103);
        goto L11
    L9:
        r103 = 16.0f;
    L12:
        TextView r104 = this.voucherMeasureV;
        if (r104 == null) goto L15;
        CJPayViewExtensionsKt.setTextAndVisible(r104, r100.voucherMeasure);
    L15:
        TextView r105 = this.voucherLabelV;
        if (r105 == null) goto L18;
        CJPayViewExtensionsKt.setTextAndVisible(r105, r100.voucherLabel);
    L18:
        TextView r106 = this.voucherDescV;
        if (r106 == null) goto L21;
        CJPayViewExtensionsKt.setTextAndVisible(r106, r100.voucherDesc);
    L21:
        TextView r107 = this.leftMsgDesc;
        if (r107 == null) goto L24;
        CJPayViewExtensionsKt.setTextAndVisible(r107, r100.leftMsgDesc);
    L24:
        View r108 = this.leftTagMsgLayout;
        if (r108 == null) goto L37;
        String r109 = r100.voucherLeftDesc;
        int r110 = 0;
        if (r109 != null) goto L30;
    L33:
        boolean r111 = true;
    L34:
        if (r111 == false) goto L36;
        r110 = 8;
    L36:
        r108.setVisibility(r110);
        goto L37
    L30:
        if (r109.length() == 0) goto L33;
        r111 = false;
    L37:
        TextView r112 = this.leftTagMsg;
        if (r112 == null) goto L40;
        CJPayViewExtensionsKt.setTextAndVisible(r112, r100.voucherLeftDesc);
    L40:
        initTopLabel(r100.voucherTopLabel, r100.countDown);
        CJPayFakeBoldUtils.fakeBold(this.voucherLabelV);
        String r113 = r100.voucherBgType;
        if (Intrinsics.areEqual(r113, "solid_line_voucher_bg") == false) goto L44;
        updateBackgroundDrawable(this.rootView, R.drawable.cj_pay_bg_voucher_item_solid_line);
        return;
    L44:
        if (Intrinsics.areEqual(r113, "broken_line_voucher_bg") == false) goto L48;
        updateBackgroundDrawable(this.rootView, R.drawable.cj_pay_bg_voucher_item);
        return;
    }

    private final void initTopLabel(String r100, int r101) {
        if (r100 != null) goto L5;
        Boolean r102 = null;
    L10:
        if (r102 == null) goto L12;
        boolean r103 = r102.booleanValue();
    L13:
        if (r103 == false) goto L22;
        View r104 = this.topLabelV;
        if (r104 == null) goto L18;
        r104.setVisibility(0);
    L18:
        TextView r105 = this.topLabelDescTV;
        if (r105 == null) goto L28;
        r105.setText(r100);
        return;
    L28:
        return;
    L22:
        View r106 = this.topLabelV;
        if (r106 == null) goto L29;
        r106.setVisibility(8);
        return;
    L29:
        return;
    L12:
        r103 = false;
        goto L13
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r107 = true;
    L8:
        r102 = Boolean.valueOf(r107);
        goto L10
    L7:
        r107 = false;
        goto L8
    }

    private final void updateBackgroundDrawable(View r100, int r101) {
        if (r100 == null) goto L5;
        r100.setBackground(ContextCompat.getDrawable(r100.getContext(), r101));
        r100.setPadding(0, 0, 0, 0);
        return;
    }

    public static /* synthetic */ void initTopLabel$default(CJPayVoucherComponent r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.initTopLabel(r101, r102);
    }
}
