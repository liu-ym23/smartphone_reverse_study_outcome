package com.android.ttcjpaysdk.integrated.counter.dypay.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayViewHolderUtils;
import com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/dypay/viewholder/GroupTypeDyPayBaseViewHolder;", "Lcom/android/ttcjpaysdk/integrated/counter/viewholder/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dyPayIcon", "Landroid/widget/ImageView;", "dyPayIconUnableMask", "dyPaySubTitle", "Landroid/widget/TextView;", "getDyPaySubTitle", "()Landroid/widget/TextView;", "dyPayTitle", "subPayLayout", "Landroid/widget/LinearLayout;", "getSubPayLayout", "()Landroid/widget/LinearLayout;", "bindData", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "doExtra", "hideView", "enable", "", "setSubTitle", d.f25925o, "integrated-counter-dy-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GroupTypeDyPayBaseViewHolder extends BaseViewHolder {
    private final Context context;
    private final ImageView dyPayIcon;
    private final ImageView dyPayIconUnableMask;
    private final TextView dyPaySubTitle;
    private final TextView dyPayTitle;
    private final LinearLayout subPayLayout;

    public abstract void doExtra(PaymentMethodInfo r100);

    public abstract void hideView(boolean r100);

    public final Context getContext() {
        return this.context;
    }

    public final TextView getDyPaySubTitle() {
        return this.dyPaySubTitle;
    }

    public final LinearLayout getSubPayLayout() {
        return this.subPayLayout;
    }

    public GroupTypeDyPayBaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.context = r100.getContext();
        this.subPayLayout = (LinearLayout) r100.findViewById(R.id.cj_pay_item_douyin_subpay_layout);
        this.dyPayIcon = (ImageView) r100.findViewById(R.id.cj_pay_douyin_pay_icon);
        this.dyPayIconUnableMask = (ImageView) r100.findViewById(R.id.cj_pay_douyin_pay_icon_unable_mask);
        this.dyPayTitle = (TextView) r100.findViewById(R.id.cj_pay_douyin_pay_title);
        this.dyPaySubTitle = (TextView) r100.findViewById(R.id.cj_pay_douyin_pay_sub_title);
    }

    private final void setSubTitle(PaymentMethodInfo r100) {
        TextView r101 = this.dyPaySubTitle;
        String r102 = r100.sub_title;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        int r105 = 8;
    L12:
        r101.setVisibility(r105);
        String r106 = r100.sub_title;
        if (r106 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        if (r107 == true) goto L44;
        this.dyPaySubTitle.setText(r100.sub_title);
        this.dyPaySubTitle.setEllipsize(TextUtils.TruncateAt.END);
        this.dyPaySubTitle.setSingleLine(false);
        String r108 = r100.sub_title_color;
        if (r108 == null) goto L27;
        if (r108.length() == 0) goto L27;
        r103 = false;
    L27:
        if (r103 == false) goto L42;
        TextView r109 = this.dyPaySubTitle;
        if (r100.isCardAvailable() == false) goto L39;
        int r110 = this.context.getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50);
    L40:
        r109.setTextColor(r110);
        return;
    L39:
        r110 = this.context.getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_34);
        goto L40
    L42:
        this.dyPaySubTitle.setTextColor(Color.parseColor(r100.sub_title_color));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("GroupTypeDyPayBaseViewHolder#setSubTitle", e);
        CJBasicCommonUtils.logCatch("CJCatch", "GroupTypeDyPayBaseViewHolder#setSubTitle", e);
        TextView r111 = this.dyPaySubTitle;
        if (r100.isCardAvailable() == false) goto L34;
        int r112 = this.context.getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50);
    L35:
        r111.setTextColor(r112);
        return;
    L34:
        r112 = this.context.getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_34);
        goto L35
    L44:
        return;
    L15:
        if (r106.length() == 0) goto L18;
        r107 = false;
        goto L19
    L11:
        r105 = 0;
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    private final void setTitle(PaymentMethodInfo r100) {
        this.dyPayTitle.setText(r100.title);
        CJPayFakeBoldUtils.fakeBold(this.dyPayTitle);
        TextView r101 = this.dyPayTitle;
        if (r100.isCardAvailable() == false) goto L5;
        Resources r102 = this.context.getResources();
        int r103 = R.color.cj_pay_color_black_161823;
    L6:
        r101.setTextColor(r102.getColor(r103));
        return;
    L5:
        r102 = this.context.getResources();
        r103 = R.color.cj_pay_color_gray_161823_opacity_34;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder
    public void bindData(PaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.bindData(r100);
        CJPayViewHolderUtils.Companion.setIconUrl(this.dyPayIcon, this.dyPayIconUnableMask, r100.icon_url, r100.isCardAvailable());
        setTitle(r100);
        setSubTitle(r100);
        hideView(r100.isCardAvailable());
        if (r100.isCardAvailable() == false) goto L6;
        doExtra(r100);
        return;
    }
}
