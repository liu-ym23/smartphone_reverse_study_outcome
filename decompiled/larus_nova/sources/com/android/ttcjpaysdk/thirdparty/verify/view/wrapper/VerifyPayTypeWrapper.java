package com.android.ttcjpaysdk.thirdparty.verify.view.wrapper;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.base.ui.data.SubPayTypeDisplayInfo;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayExtentSizeUtils;
import com.android.ttcjpaysdk.bdpay.paymentmethod.utils.PaymentMethodUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.verify.utils.PwdHelper;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u00014B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J!\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u0010J\u001c\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002J'\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0006\u0010$\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyPayTypeWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "withAnimation", "", "isDynamicLayout", "(Landroid/view/View;Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;ZLjava/lang/Boolean;)V", "arrowIv", "Landroid/widget/ImageView;", "combineWrapper", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyCombineWrapper;", "Ljava/lang/Boolean;", "onPayTypeClickListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyPayTypeWrapper$OnPayTypeClickListener;", "payIconIv", "getPayInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "payTypeLLayout", "getPayTypeLLayout", "()Landroid/view/View;", "payTypeLayout", "payTypeRlLayout", "getPayTypeRlLayout", "paymentInfoTv", "Landroid/widget/TextView;", "paymentLinearLayout", "Landroid/widget/LinearLayout;", "paymentNameTv", "subPayTypeTv", "expandPayTpeTouchArea", "", "setListener", "setMarginTopWithoutDiscount", "withoutDiscount", "(ZLjava/lang/Boolean;)V", "setOnCheckClickListener", "listener", "setPayTypeView", "title", "", "iconUrl", "updateChangedPayType", "updateInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "(Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;ZLjava/lang/Boolean;)V", "updateCreditPayExpandData", "expandResult", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "updateCreditPayFee", "OnPayTypeClickListener", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class VerifyPayTypeWrapper extends BaseWrapper {
    private final ImageView arrowIv;
    private final VerifyCombineWrapper combineWrapper;
    private final Boolean isDynamicLayout;
    private OnPayTypeClickListener onPayTypeClickListener;
    private final ImageView payIconIv;
    private final CJPayPayInfo payInfo;
    private final View payTypeLLayout;
    private final View payTypeLayout;
    private final View payTypeRlLayout;
    private final TextView paymentInfoTv;
    private final LinearLayout paymentLinearLayout;
    private final TextView paymentNameTv;
    private final TextView subPayTypeTv;
    private final boolean withAnimation;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyPayTypeWrapper$OnPayTypeClickListener;", "", "onPayTypeChangeClick", "", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnPayTypeClickListener {
        void onPayTypeChangeClick();
    }

    private final void expandPayTpeTouchArea() {
        CJPayExtentSizeUtils.expendTouchArea(this.arrowIv, new int[]{CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext()) - CJPayBasicExtensionKt.dp(48.0f), CJPayBasicExtensionKt.dip2px(20.0f, getContext()), CJPayBasicExtensionKt.dip2px(10.0f, getContext()), CJPayBasicExtensionKt.dip2px(20.0f, getContext())});
    }

    private final void setListener() {
        ImageView r100 = this.arrowIv;
        if (r100 == null) goto L6;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new AnonymousClass1(this));
        return;
    }

    public final CJPayPayInfo getPayInfo() {
        return this.payInfo;
    }

    public final View getPayTypeLLayout() {
        return this.payTypeLLayout;
    }

    public final View getPayTypeRlLayout() {
        return this.payTypeRlLayout;
    }

    public static final /* synthetic */ OnPayTypeClickListener access$getOnPayTypeClickListener$p(VerifyPayTypeWrapper r100) {
        return r100.onPayTypeClickListener;
    }

    private final void updateCreditPayFee(FrontSubPayTypeInfo r100) {
        LinearLayout r101 = this.paymentLinearLayout;
        boolean r102 = false;
        Unit r103 = null;
        if (r101 == null) goto L16;
        CJPayPayInfo r104 = this.payInfo;
        if (r104 == null) goto L10;
        CJPayPayInfo.RegionShowConfig r105 = r104.region_show_config;
        if (r105 == null) goto L10;
        String r106 = r105.sub_pay_type_desc_region;
    L12:
        if (TextUtils.equals(r106, "0") == false) goto L14;
        int r107 = 8;
    L15:
        r101.setVisibility(r107);
        goto L16
    L14:
        r107 = 0;
    L10:
        r106 = null;
    L16:
        CJPayPayInfo r108 = this.payInfo;
        if (r108 == null) goto L23;
        ArrayList<String> r109 = r108.cashier_tag;
        if (r109 == null) goto L23;
        if (r109.contains("sub_pay_type_desc_region_expr") != true) goto L23;
        boolean r110 = true;
    L24:
        String r111 = "";
        if (r110 == false) goto L51;
        ArrayList<CJPayCreditPayMethods> r112 = r100.pay_type_data.credit_pay_methods;
        if (r112 != null) goto L29;
    L48:
        String r113 = "";
    L49:
        if (r103 != null) goto L83;
        FrontPayTypeData r114 = r100.pay_type_data;
        r111 = r114.password_page_desc_title;
        r113 = r114.password_page_desc;
    L83:
        if (r111.length() <= 0) goto L85;
        boolean r115 = true;
    L86:
        if (r115 == false) goto L90;
        TextView r116 = this.paymentNameTv;
        if (r116 == null) goto L94;
        CJPayViewExtensionsKt.setTextAndVisible(r116, r111);
    L94:
        if (r113.length() <= 0) goto L96;
        r102 = true;
    L96:
        if (r102 == false) goto L100;
        TextView r117 = this.paymentInfoTv;
        if (r117 == null) goto L110;
        CJPayViewExtensionsKt.setTextAndVisible(r117, r113);
        return;
    L110:
        return;
    L100:
        TextView r118 = this.paymentInfoTv;
        if (r118 == null) goto L112;
        CJPayViewExtensionsKt.viewGone(r118);
        return;
    L112:
        return;
    L90:
        TextView r119 = this.paymentNameTv;
        if (r119 == null) goto L94;
        CJPayViewExtensionsKt.viewGone(r119);
        goto L94
    L85:
        r115 = false;
        goto L86
    L29:
        if (r112.size() <= 0) goto L31;
        boolean r120 = true;
    L32:
        if (r120 == true) goto L35;
        r112 = null;
    L35:
        if (r112 == null) goto L48;
        Iterator<T> r121 = r112.iterator();
    L38:
        if (r121.hasNext() == false) goto L42;
        Object r122 = r121.next();
        if (((CJPayCreditPayMethods) r122).choose == false) goto L38;
    L43:
        CJPayCreditPayMethods r123 = (CJPayCreditPayMethods) r122;
        if (r123 == null) goto L46;
        String r124 = r123.password_page_desc_title;
        String r125 = r123.password_page_desc;
        r103 = Unit.INSTANCE;
        r111 = r125;
        String r126 = r124;
    L47:
        String r127 = r111;
        r111 = r126;
        r113 = r127;
        goto L49
    L46:
        r126 = "";
        goto L47
    L42:
        r122 = null;
        goto L43
    L31:
        r120 = false;
        goto L32
    L51:
        ArrayList<CJPayCreditPayMethods> r128 = r100.pay_type_data.credit_pay_methods;
        if (r128 != null) goto L54;
    L79:
        r113 = "";
    L80:
        if (r103 != null) goto L83;
        r113 = getContext().getResources().getString(R.string.cj_pay_pwd_credit_instalments_tip);
        goto L83
    L54:
        if (r128.size() <= 0) goto L56;
        boolean r129 = true;
    L57:
        if (r129 == true) goto L60;
        r128 = null;
    L60:
        if (r128 == null) goto L79;
        Iterator<T> r130 = r128.iterator();
    L63:
        if (r130.hasNext() == false) goto L67;
        Object r131 = r130.next();
        if (((CJPayCreditPayMethods) r131).choose == false) goto L63;
    L68:
        CJPayCreditPayMethods r132 = (CJPayCreditPayMethods) r131;
        if (r132 != null) goto L71;
        String r133 = "";
    L78:
        r113 = r133;
        goto L80
    L71:
        if (Intrinsics.areEqual(r132.installment, "1") == false) goto L73;
    L75:
        r133 = r132.pay_type_desc + '(' + r132.fee_desc + ')';
    L76:
        r103 = Unit.INSTANCE;
        goto L78
    L73:
        if (r132.fee != 0) goto L75;
        r133 = r132.pay_type_desc;
        goto L76
    L67:
        r131 = null;
        goto L68
    L56:
        r129 = false;
    L23:
        r110 = false;
        goto L24
    }

    public final void setOnCheckClickListener(OnPayTypeClickListener r100) {
        this.onPayTypeClickListener = r100;
    }

    public final void updateCreditPayExpandData(VoucherDialogExpandResult r100) {
        Intrinsics.checkNotNullParameter(r100, "expandResult");
        if (Intrinsics.areEqual(r100._credit_pay_installment, "1") == true) goto L10;
        if (r100.expand_fee != 0) goto L10;
        if ((!StringsKt.isBlank(r100.expand_pay_type_desc)) == false) goto L10;
        String r101 = r100.expand_pay_type_desc;
    L18:
        TextView r102 = this.paymentInfoTv;
        if (r102 == null) goto L21;
        CJPayViewExtensionsKt.setTextAndVisible(r102, r101);
    L21:
        setMarginTopWithoutDiscount(true, this.isDynamicLayout);
        return;
    L10:
        if ((!StringsKt.isBlank(r100.expand_pay_type_desc)) == false) goto L15;
        if ((!StringsKt.isBlank(r100.expand_fee_desc)) == false) goto L15;
        r101 = r100.expand_pay_type_desc + '(' + r100.expand_fee_desc + ')';
    L15:
        if ((!StringsKt.isBlank(r100.expand_pay_type_desc)) == false) goto L17;
        r101 = r100.expand_pay_type_desc;
        goto L18
    L17:
        r101 = "";
        goto L18
    }

    private final void setPayTypeView(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        TextView r102 = this.subPayTypeTv;
        if (r102 == null) goto L7;
        CJPayViewExtensionsKt.setTextAndVisible(r102, r100);
    L7:
        final ImageView r103 = this.payIconIv;
        ViewGroup.LayoutParams r104 = null;
        if (r103 != null) goto L10;
    L15:
        ImageView r105 = this.payIconIv;
        if (r105 == null) goto L20;
        r105.setVisibility(0);
    L20:
        if (this.withAnimation == true) goto L25;
        View r106 = this.payTypeLayout;
        if (r106 == null) goto L46;
        r106.setVisibility(0);
    L46:
        CJPayPayInfo r107 = this.payInfo;
        if (r107 == null) goto L51;
        CJPayPayInfo.RegionShowConfig r108 = r107.region_show_config;
        if (r108 == null) goto L51;
        String r109 = r108.sub_pay_type_change_region;
    L53:
        if (TextUtils.equals(r109, "0") == false) goto L70;
        ImageView r110 = this.arrowIv;
        if (r110 == null) goto L57;
        CJPayViewExtensionsKt.viewGone(r110);
    L57:
        TextView r111 = this.paymentInfoTv;
        if (r111 == null) goto L60;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L62:
        if ((r112 instanceof LinearLayout.LayoutParams) == false) goto L75;
        TextView r113 = this.paymentInfoTv;
        if (r113 == null) goto L66;
        r104 = r113.getLayoutParams();
    L66:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r104;
        r114.rightMargin = 0;
        TextView r115 = this.paymentInfoTv;
        if (r115 == null) goto L77;
        r115.setLayoutParams(r114);
        return;
    L77:
        return;
    L75:
        return;
    L60:
        r112 = null;
        goto L62
    L70:
        ImageView r116 = this.arrowIv;
        if (r116 == null) goto L73;
        CJPayViewExtensionsKt.viewVisible(r116);
    L73:
        setListener();
        return;
    L51:
        r109 = null;
        goto L53
    L25:
        View r117 = this.payTypeLayout;
        if (r117 == null) goto L29;
        r117.setAlpha(0.0f);
    L29:
        View r118 = this.payTypeLayout;
        if (r118 == null) goto L33;
        r118.setVisibility(0);
    L33:
        View r119 = this.payTypeLayout;
        if (r119 == null) goto L42;
        ViewPropertyAnimator r120 = r119.animate();
        if (r120 == null) goto L42;
        ViewPropertyAnimator r121 = r120.alpha(1.0f);
        if (r121 == null) goto L42;
        ViewPropertyAnimator r122 = r121.setInterpolator(new LinearInterpolator());
        if (r122 == null) goto L42;
        r122.setDuration(300);
    L42:
        View r123 = this.payTypeLayout;
        if (r123 == null) goto L46;
        r123.setAlpha(1.0f);
        goto L46
    L10:
        if ((!TextUtils.isEmpty(r101)) == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        final long r124 = System.currentTimeMillis();
        ImageLoader.Companion.getInstance().loadImage(r101, new VerifyPayTypeWrapper$setPayTypeView$2$1(r103, r124));
        goto L15
    }

    public void setMarginTopWithoutDiscount(boolean r100, Boolean r101) {
        RelativeLayout.LayoutParams r102 = null;
        if (r100 == true) goto L5;
    L16:
        View r103 = this.payTypeLLayout;
        if (r103 == null) goto L19;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L21:
        if ((r104 instanceof RelativeLayout.LayoutParams) == false) goto L23;
        RelativeLayout.LayoutParams r105 = (RelativeLayout.LayoutParams) r104;
    L24:
        if (r105 == null) goto L26;
        r105.topMargin = CJPayBasicExtensionKt.dp(0.0f);
    L26:
        boolean r106 = false;
        if (r101 != null) goto L29;
    L31:
        if (r106 == false) goto L42;
        View r107 = this.payTypeLLayout;
        if (r107 == null) goto L35;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
    L37:
        if ((r108 instanceof RelativeLayout.LayoutParams) == false) goto L39;
        r102 = (RelativeLayout.LayoutParams) r108;
    L39:
        if (r102 == null) goto L43;
        r102.bottomMargin = CJPayBasicExtensionKt.dp(4.0f);
        return;
    L43:
        return;
    L35:
        r108 = null;
        goto L37
    L42:
        return;
    L29:
        if (r101.booleanValue() != true) goto L31;
        r106 = true;
        goto L31
    L23:
        r105 = null;
        goto L24
    L19:
        r104 = null;
        goto L21
    L5:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L16;
        View r109 = this.payTypeLLayout;
        if (r109 == null) goto L9;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
    L11:
        if ((r110 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        RelativeLayout.LayoutParams r111 = (RelativeLayout.LayoutParams) r110;
    L14:
        if (r111 == null) goto L26;
        r111.topMargin = CJPayBasicExtensionKt.dp(18.0f);
        goto L26
    L13:
        r111 = null;
        goto L14
    L9:
        r110 = null;
        goto L11
    }

    public final void updateChangedPayType(FrontSubPayTypeInfo r100, boolean r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "updateInfo");
        LinearLayout r103 = this.paymentLinearLayout;
        if (r103 == null) goto L6;
        r103.setVisibility(8);
    L6:
        this.combineWrapper.hideWrapper();
        if (r100.isAssetStandard() == false) goto L18;
        setPayTypeView(r100.getTitle(), r100.getIconUrl());
        if (TextUtils.isEmpty(r100.getSubTitle()) == true) goto L17;
        TextView r104 = this.paymentInfoTv;
        if (r104 == null) goto L13;
        CJPayViewExtensionsKt.setTextAndVisible(r104, r100.getSubTitle());
    L13:
        LinearLayout r105 = this.paymentLinearLayout;
        if (r105 == null) goto L17;
        r105.setVisibility(0);
    L17:
        setMarginTopWithoutDiscount(r101, r102);
        return;
    L18:
        String r106 = r100.sub_pay_type;
        if (r106 != null) goto L21;
        return;
    L21:
        switch(r106.hashCode()) {
            case -1787710669: goto L43;
            case -1581701048: goto L40;
            case -1184259671: goto L37;
            case -563976606: goto L33;
            case -339185956: goto L30;
            case 3107561: goto L27;
            case 1381242926: goto L24;
            default: goto L51;
        };
    L51:
        return;
    L24:
        if (r106.equals("fund_pay") == false) goto L49;
    L45:
        setPayTypeView(r100.title, r100.icon_url);
        setMarginTopWithoutDiscount(r101, r102);
        return;
    L49:
        return;
    L27:
        if (r106.equals(PaymentMethodUtils.ECNY) == true) goto L45;
        return;
    L30:
        if (r106.equals("balance") == true) goto L45;
        return;
    L33:
        if (r106.equals("credit_pay") == false) goto L54;
        setPayTypeView(r100.title, r100.icon_url);
        updateCreditPayFee(r100);
        setMarginTopWithoutDiscount(r101, r102);
        return;
    L54:
        return;
    L37:
        if (r106.equals("income") == true) goto L45;
        return;
    L40:
        if (r106.equals("share_pay") == true) goto L45;
        return;
    L43:
        if (r106.equals("bank_card") == true) goto L45;
    }

    public VerifyPayTypeWrapper(View r110, CJPayPayInfo r111, boolean r112, Boolean r113) {
        super(r110);
        this.payInfo = r111;
        this.withAnimation = r112;
        this.isDynamicLayout = r113;
        Object r114 = null;
        if (r110 == null) goto L5;
        View r100 = r110.findViewById(R.id.pay_type_area_layout);
    L6:
        this.payTypeRlLayout = r100;
        if (r110 == null) goto L9;
        View r101 = r110.findViewById(R.id.pay_type_layout);
    L10:
        this.payTypeLLayout = r101;
        if (r110 == null) goto L13;
        View r102 = r110.findViewById(R.id.cj_pay_view_pay_type_layout);
    L14:
        this.payTypeLayout = r102;
        if (r110 == null) goto L17;
        ImageView r103 = (ImageView) r110.findViewById(R.id.iv_pay_icon);
    L18:
        this.payIconIv = r103;
        if (r110 == null) goto L21;
        TextView r104 = (TextView) r110.findViewById(R.id.tv_sub_pay_type);
    L22:
        this.subPayTypeTv = r104;
        if (r110 == null) goto L25;
        LinearLayout r105 = (LinearLayout) r110.findViewById(R.id.ll_payment);
    L26:
        this.paymentLinearLayout = r105;
        if (r110 == null) goto L29;
        TextView r106 = (TextView) r110.findViewById(R.id.tv_payment_info);
    L30:
        this.paymentInfoTv = r106;
        if (r110 == null) goto L33;
        TextView r107 = (TextView) r110.findViewById(R.id.tv_payment_name);
    L34:
        this.paymentNameTv = r107;
        if (r110 == null) goto L37;
        ImageView r108 = (ImageView) r110.findViewById(R.id.iv_arrow);
    L38:
        this.arrowIv = r108;
        VerifyCombineWrapper r109 = new VerifyCombineWrapper(r110, r111);
        this.combineWrapper = r109;
        boolean r115 = !PwdHelper.INSTANCE.hasNewDiscount(r111);
        if (r111 == null) goto L41;
        Boolean r116 = Boolean.valueOf(r111.isAssetStandard());
    L43:
        if (r116 == null) goto L45;
        boolean r117 = r116.booleanValue();
    L47:
        if (r117 == false) goto L92;
        if (r111 == null) goto L248;
        AssetInfoBean r118 = r111.asset_info;
        if (r118 != null) goto L52;
        return;
    L52:
        if (r111.isCombinePay() == true) goto L54;
        AssetInfoBean.AssetBasicShowInfoBean r119 = r118.asset_basic_show_info;
        setPayTypeView(r119.title, r119.icon_url);
        if (TextUtils.isEmpty(r118.asset_basic_show_info.sub_title) == true) goto L91;
        if (r106 == null) goto L91;
        CJPayViewExtensionsKt.setTextAndVisible(r106, r118.asset_basic_show_info.sub_title);
    L91:
        setMarginTopWithoutDiscount(r115, r113);
        expandPayTpeTouchArea();
        return;
    L54:
        if (r118.asset_combine_pay_info.asset_to_combine_asset_info_list.size() <= 0) goto L250;
        if (r113 == null) goto L57;
        boolean r120 = r113.booleanValue();
    L58:
        if (r120 == true) goto L61;
        if (r115 == false) goto L61;
        r109.setMarginTop(CJPayBasicExtensionKt.dip2px(18.0f, r109.getContext()));
    L61:
        Pair[] r121 = new Pair[2];
        CJPayPayInfo r122 = r109.getPayInfo();
        if (r122 == null) goto L64;
        String r123 = r122.getCombinePayTitle1();
    L65:
        Object r124 = "";
        if (r123 != null) goto L68;
        r123 = "";
    L68:
        CJPayPayInfo r125 = r109.getPayInfo();
        if (r125 == null) goto L71;
        String r126 = r125.getCombinePayAmountDesc1();
    L72:
        if (r126 != null) goto L74;
        r126 = "";
    L74:
        r121[0] = new Pair(r123, r126);
        CJPayPayInfo r127 = r109.getPayInfo();
        if (r127 == null) goto L77;
        String r128 = r127.getCombinePayTitle2();
    L78:
        if (r128 != null) goto L80;
        r128 = "";
    L80:
        CJPayPayInfo r129 = r109.getPayInfo();
        if (r129 == null) goto L83;
        r114 = r129.getCombinePayAmountDesc2();
    L83:
        if (r114 == null) goto L86;
        r124 = r114;
    L86:
        r121[1] = new Pair(r128, r124);
        r109.setCombineViews(CollectionsKt.arrayListOf(r121), r109.getContext().getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50), 13.0f);
        r109.showWrapper();
        return;
    L77:
        r128 = null;
        goto L78
    L71:
        r126 = null;
        goto L72
    L64:
        r123 = null;
        goto L65
    L57:
        r120 = false;
        goto L58
    L250:
        return;
    L248:
        return;
    L92:
        if (r111 == null) goto L94;
        String r130 = r111.business_scene;
    L96:
        if (r130 != null) goto L98;
    L206:
        CJPayPayInfo r131 = this.payInfo;
        if (r131 == null) goto L211;
        CJPayPayInfo.RegionShowConfig r132 = r131.region_show_config;
        if (r132 == null) goto L211;
        String r133 = r132.sub_pay_type_change_region;
    L213:
        if (TextUtils.equals(r133, "0") == false) goto L230;
        ImageView r134 = this.arrowIv;
        if (r134 == null) goto L217;
        CJPayViewExtensionsKt.viewGone(r134);
    L217:
        TextView r135 = this.paymentInfoTv;
        if (r135 == null) goto L220;
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
    L222:
        if ((r136 instanceof LinearLayout.LayoutParams) == false) goto L253;
        TextView r137 = this.paymentInfoTv;
        if (r137 == null) goto L226;
        r114 = r137.getLayoutParams();
    L226:
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r138 = (LinearLayout.LayoutParams) r114;
        r138.rightMargin = 0;
        TextView r139 = this.paymentInfoTv;
        if (r139 == null) goto L255;
        r139.setLayoutParams(r138);
        return;
    L255:
        return;
    L253:
        return;
    L220:
        r136 = null;
        goto L222
    L230:
        ImageView r140 = this.arrowIv;
        if (r140 == null) goto L233;
        CJPayViewExtensionsKt.viewVisible(r140);
    L233:
        setListener();
        return;
    L211:
        r133 = null;
        goto L213
    L98:
        switch(r130.hashCode()) {
            case -1694580976: goto L191;
            case -1524118967: goto L181;
            case -836325908: goto L150;
            case -668293988: goto L147;
            case -234858324: goto L123;
            case 62163359: goto L120;
            case 1178008188: goto L104;
            case 1898614428: goto L101;
            default: goto L206;
        };
    L101:
        if (r130.equals(CJPayConstant.CJ_PAY_BUSINESS_SCENE_PRE_PAY_ECNY) == false) goto L206;
    L183:
        ArrayList<SubPayTypeDisplayInfo> r141 = r111.sub_pay_type_display_info_list;
        if (r141 == null) goto L189;
        Iterator<T> r142 = r141.iterator();
    L187:
        if (r142.hasNext() == false) goto L189;
        SubPayTypeDisplayInfo r143 = (SubPayTypeDisplayInfo) r142.next();
        setPayTypeView(r143.title, r143.icon_url);
    L189:
        setMarginTopWithoutDiscount(r115, this.isDynamicLayout);
        expandPayTpeTouchArea();
        goto L206
    L104:
        if (r130.equals("Pre_Pay_SharePay") == false) goto L206;
        ArrayList<SubPayTypeDisplayInfo> r144 = r111.sub_pay_type_display_info_list;
        if (r144 == null) goto L118;
        Iterator<T> r145 = r144.iterator();
    L110:
        if (r145.hasNext() == false) goto L114;
        Object r146 = r145.next();
        if (Intrinsics.areEqual(((SubPayTypeDisplayInfo) r146).sub_pay_type, "share_pay") == false) goto L110;
    L115:
        SubPayTypeDisplayInfo r147 = (SubPayTypeDisplayInfo) r146;
        if (r147 == null) goto L118;
        setPayTypeView(r147.title, r147.icon_url);
        goto L118
    L114:
        r146 = null;
    L118:
        setMarginTopWithoutDiscount(r115, this.isDynamicLayout);
        expandPayTpeTouchArea();
        goto L206
    L120:
        if (r130.equals("Pre_Pay_BankCard") == true) goto L183;
    L123:
        if (r130.equals("Pre_Pay_Combine") == false) goto L206;
        ArrayList<SubPayTypeDisplayInfo> r148 = r111.sub_pay_type_display_info_list;
        if (r148 == null) goto L128;
        int r149 = r148.size();
    L129:
        if (r149 <= 1) goto L206;
        if (r113 == null) goto L132;
        boolean r150 = r113.booleanValue();
    L133:
        if (r150 == true) goto L136;
        if (r115 == false) goto L136;
        r109.setMarginTop(CJPayBasicExtensionKt.dip2px(18.0f, r109.getContext()));
    L136:
        CJPayPayInfo r151 = r109.getPayInfo();
        if (r151 == null) goto L144;
        ArrayList<SubPayTypeDisplayInfo> r152 = r151.sub_pay_type_display_info_list;
        if (r152 == null) goto L144;
        ArrayList r153 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r152, 10));
        Iterator<T> r154 = r152.iterator();
    L142:
        if (r154.hasNext() == false) goto L145;
        SubPayTypeDisplayInfo r155 = (SubPayTypeDisplayInfo) r154.next();
        r153.add(TuplesKt.to(r155.title, r155.payment_info));
    L145:
        r109.setCombineViews(r153, r109.getContext().getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50), 13.0f);
        r109.showWrapper();
    L144:
        r153 = null;
        goto L145
    L132:
        r150 = false;
        goto L133
    L128:
        r149 = 0;
        goto L129
    L147:
        if (r130.equals("Pre_Pay_Income") == true) goto L183;
    L150:
        if (r130.equals("Pre_Pay_Credit") == false) goto L206;
        if (r105 == null) goto L163;
        CJPayPayInfo.RegionShowConfig r156 = r111.region_show_config;
        if (r156 == null) goto L157;
        String r157 = r156.sub_pay_type_desc_region;
    L159:
        if (TextUtils.equals(r157, "0") == false) goto L161;
        int r158 = 8;
    L162:
        r105.setVisibility(r158);
        goto L163
    L161:
        r158 = 0;
        goto L162
    L157:
        r157 = null;
    L163:
        ArrayList<SubPayTypeDisplayInfo> r159 = r111.sub_pay_type_display_info_list;
        if (r159 == null) goto L206;
        Iterator<T> r160 = r159.iterator();
    L167:
        if (r160.hasNext() == false) goto L206;
        SubPayTypeDisplayInfo r161 = (SubPayTypeDisplayInfo) r160.next();
        if (TextUtils.isEmpty(r161.payment_info) == true) goto L179;
        TextView r162 = this.paymentInfoTv;
        if (r162 == null) goto L174;
        CJPayViewExtensionsKt.setTextAndVisible(r162, r161.payment_info);
    L174:
        if (TextUtils.isEmpty(r161.password_page_desc_title) == true) goto L179;
        TextView r163 = this.paymentNameTv;
        if (r163 == null) goto L179;
        r163.setText(r161.password_page_desc_title);
    L179:
        setPayTypeView(r161.title, r161.icon_url);
        setMarginTopWithoutDiscount(r115, this.isDynamicLayout);
        expandPayTpeTouchArea();
        goto L167
    L181:
        if (r130.equals("Pre_Pay_Balance") == true) goto L183;
    L191:
        if (r130.equals(CJPayCounterConstant.CJ_PAY_KEY_PRE_PAY_FUND) == false) goto L206;
        ArrayList<SubPayTypeDisplayInfo> r164 = r111.sub_pay_type_display_info_list;
        if (r164 == null) goto L205;
        Iterator<T> r165 = r164.iterator();
    L197:
        if (r165.hasNext() == false) goto L201;
        Object r166 = r165.next();
        if (Intrinsics.areEqual(((SubPayTypeDisplayInfo) r166).sub_pay_type, "fund_pay") == false) goto L197;
    L202:
        SubPayTypeDisplayInfo r167 = (SubPayTypeDisplayInfo) r166;
        if (r167 == null) goto L205;
        setPayTypeView(r167.title, r167.icon_url);
        goto L205
    L201:
        r166 = null;
    L205:
        setMarginTopWithoutDiscount(r115, this.isDynamicLayout);
        expandPayTpeTouchArea();
        goto L206
    L94:
        r130 = null;
        goto L96
    L45:
        r117 = false;
        goto L47
    L41:
        r116 = null;
        goto L43
    L37:
        r108 = null;
        goto L38
    L33:
        r107 = null;
        goto L34
    L29:
        r106 = null;
        goto L30
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = null;
        goto L22
    L17:
        r103 = null;
        goto L18
    L13:
        r102 = null;
        goto L14
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = null;
        goto L6
    }

    public static /* synthetic */ void setMarginTopWithoutDiscount$default(VerifyPayTypeWrapper r100, boolean r101, Boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = Boolean.FALSE;
    L6:
        r100.setMarginTopWithoutDiscount(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMarginTopWithoutDiscount");
    }

    public /* synthetic */ VerifyPayTypeWrapper(View r100, CJPayPayInfo r101, boolean r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = Boolean.valueOf(PwdHelper.INSTANCE.isDynamicPwd(r101));
    L8:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ void updateChangedPayType$default(VerifyPayTypeWrapper r100, FrontSubPayTypeInfo r101, boolean r102, Boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = Boolean.FALSE;
    L6:
        r100.updateChangedPayType(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateChangedPayType");
    }
}
