package com.android.ttcjpaysdk.bindcard.unionpay.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayBankBean;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J \u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0002J0\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020!H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "adapterListener", "Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;", "getAdapterListener", "()Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;", "setAdapterListener", "(Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;)V", "bankCardTextView", "Landroid/widget/TextView;", "cardCheckBox", "Landroid/widget/CheckBox;", "cardStatusTextView", "iconMaskView", "Landroid/widget/ImageView;", "iconView", "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBankBean;", "foldBankInfoIfNeeded", "", "textView", "bankInfo", "getCardType", "cardType", "loadIconUrl", "url", "maskView", "isEnable", "", "setBankCardText", "text", "setCheckboxStatus", "checkBox", "displayDesc", "isChecked", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindCardViewHolder extends RecyclerView.ViewHolder {
    private UnionPayBindCardAdapter.OnUnionPayBindCardAdapterListener adapterListener;
    private final TextView bankCardTextView;
    private final CheckBox cardCheckBox;
    private final TextView cardStatusTextView;
    private final ImageView iconMaskView;
    private final ImageView iconView;

    public final UnionPayBindCardAdapter.OnUnionPayBindCardAdapterListener getAdapterListener() {
        return this.adapterListener;
    }

    public UnionPayBindCardViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.iconView = (ImageView) r100.findViewById(R.id.iv_bank_icon);
        this.iconMaskView = (ImageView) r100.findViewById(R.id.iv_bank_icon_unable_mask);
        this.bankCardTextView = (TextView) r100.findViewById(R.id.tv_bank_card);
        this.cardCheckBox = (CheckBox) r100.findViewById(R.id.cb_card);
        this.cardStatusTextView = (TextView) r100.findViewById(R.id.tv_card_status);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_bindcard_unionpay_adapter_UnionPayBindCardViewHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final String getCardType(String r100) {
        if (Intrinsics.areEqual("DEBIT", r100) == false) goto L11;
        Context r101 = CJPayHostInfo.applicationContext;
        if (r101 == null) goto L20;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L21;
        String r103 = r102.getString(R.string.cj_pay_debit_card);
        if (r103 != null) goto L19;
        return "";
    L19:
        return r103;
    L21:
        return "";
    L20:
        return "";
    L11:
        Context r104 = CJPayHostInfo.applicationContext;
        if (r104 == null) goto L22;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L23;
        r103 = r105.getString(R.string.cj_pay_credit_card);
        if (r103 != null) goto L19;
        return "";
    L23:
        return "";
    L22:
        return "";
    }

    public final void bindData(final UnionPayBankBean r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        String r100 = r110.icon_url;
        String r101 = r110.card_no_mask;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        String r102 = "";
    L8:
        boolean r103 = Intrinsics.areEqual(r110.status, "1");
        loadIconUrl(r100, this.iconView, this.iconMaskView, r103);
        setBankCardText(r102, this.bankCardTextView, r103);
        setCheckboxStatus(this.cardCheckBox, this.cardStatusTextView, r103, r110.display_desc, r110.isChecked);
        if (r103 == false) goto L11;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.itemView, new AnonymousClass1(this, r110));
        return;
    L11:
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.itemView, AnonymousClass2.INSTANCE);
        return;
    L5:
        if (r101.length() < 4) goto L7;
        r102 = foldBankInfoIfNeeded(this.bankCardTextView, r110.bank_name + getCardType(r110.card_type) + " (" + r101.substring(r101.length() - 4, r101.length()) + ')');
        goto L8
    }

    public final void setAdapterListener(UnionPayBindCardAdapter.OnUnionPayBindCardAdapterListener r100) {
        this.adapterListener = r100;
    }

    private final String foldBankInfoIfNeeded(TextView r100, String r101) {
        if (CJPayHostInfo.applicationContext != null) goto L5;
        return r101;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        float r102 = r100.getPaint().measureText(r101);
        Context r103 = CJPayHostInfo.applicationContext;
        Intrinsics.checkNotNull(r103);
        float r104 = INVOKEVIRTUAL_com_android_ttcjpaysdk_bindcard_unionpay_adapter_UnionPayBindCardViewHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r103.getResources()).widthPixels - CJPayBasicExtensionKt.dip2pxF(176.0f, CJPayHostInfo.applicationContext);
        if (r102 <= r104) goto L12;
        float r105 = ((r104 - r100.getPaint().measureText(" (0000)")) - r100.getPaint().measureText("...")) / r100.getPaint().measureText("字");
        int r106 = (int) (r105 / 2);
        return r101.substring(0, r106) + "..." + r101.substring((r101.length() - 7) - ((int) (r105 - r106)));
    L12:
        return r101;
    L11:
        return r101;
    }

    private final void setBankCardText(String r100, TextView r101, boolean r102) {
        r101.setText(r100);
        Context r103 = CJPayHostInfo.applicationContext;
        if (r103 == null) goto L9;
        Resources r104 = r103.getResources();
        if (r102 == false) goto L7;
        int r105 = R.color.cj_pay_color_black_161823;
    L8:
        r101.setTextColor(r104.getColor(r105));
        goto L9
    L7:
        r105 = R.color.cj_pay_color_gray_161823_opacity_34;
    L9:
        CJPayFakeBoldUtils.fakeBold(r101);
    }

    private final void loadIconUrl(String r100, final ImageView r101, final ImageView r102, final boolean r103) {
        ImageLoader.Companion.getInstance().loadImage(r100, new C91331(r101, r103, r102));
    }

    private final void setCheckboxStatus(CheckBox r100, TextView r101, boolean r102, String r103, boolean r104) {
        if (r102 == false) goto L5;
        r101.setVisibility(8);
        r100.setVisibility(0);
        r100.setChecked(r104);
        this.itemView.setSelected(r104);
        return;
    L5:
        r100.setVisibility(8);
        this.itemView.setSelected(false);
        r101.setVisibility(0);
        r101.setText(r103);
    }
}
