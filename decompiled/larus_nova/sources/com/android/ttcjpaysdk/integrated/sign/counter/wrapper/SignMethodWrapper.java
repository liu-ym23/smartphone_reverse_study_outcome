package com.android.ttcjpaysdk.integrated.sign.counter.wrapper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.ui.Utils.PaymentUIUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.integrated.sign.counter.data.DataInfo;
import com.android.ttcjpaysdk.integrated.sign.counter.data.SignCreateResponse;
import com.android.ttcjpaysdk.integrated.sign.counter.data.SignMethodInfo;
import com.android.ttcjpaysdk.integrated.sign.counter.data.TypeItems;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/wrapper/SignMethodWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "hasClickFold", "", "mSignList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignMethodInfo;", "Lkotlin/collections/ArrayList;", "mSignListLayout", "Landroid/widget/LinearLayout;", "onSignMethodListener", "Lcom/android/ttcjpaysdk/integrated/sign/counter/wrapper/SignMethodWrapper$OnSignMethodListener;", "signCreateResponse", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;", "calFoldData", "Lkotlin/Pair;", "", "getClickListener", "Landroid/view/View$OnClickListener;", "methodInfo", "initData", "", "isEnable", "isSign", "setCheckBox", "itemView", "setIcon", "setItem", "setMark", "setSignListData", "setSignListView", "setSubTitle", d.f25925o, "OnSignMethodListener", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignMethodWrapper extends BaseWrapper {
    private boolean hasClickFold;
    private ArrayList<SignMethodInfo> mSignList;
    private LinearLayout mSignListLayout;
    private OnSignMethodListener onSignMethodListener;
    private SignCreateResponse signCreateResponse;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/wrapper/SignMethodWrapper$OnSignMethodListener;", "", "isUnClick", "", "onDefaultMethod", "", "signMethodInfo", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignMethodInfo;", "onSelectMethod", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnSignMethodListener {
        boolean isUnClick();

        void onDefaultMethod(SignMethodInfo r100);

        void onSelectMethod(SignMethodInfo r100);
    }

    private final Pair<Boolean, Integer> calFoldData() {
        SignCreateResponse r100 = this.signCreateResponse;
        if (r100 == null) goto L7;
        DataInfo r101 = r100.data;
        if (r101 == null) goto L7;
        int r102 = r101.show_num;
    L8:
        int r103 = this.mSignList.size();
        if (r102 <= 0) goto L17;
        if (r102 >= this.mSignList.size()) goto L17;
        if (this.hasClickFold == true) goto L17;
        return new Pair(Boolean.TRUE, Integer.valueOf(r102));
    L17:
        return new Pair(Boolean.FALSE, Integer.valueOf(r103));
    L7:
        r102 = 0;
        goto L8
    }

    private final void setSignListData() {
        this.mSignList.clear();
        SignCreateResponse r100 = this.signCreateResponse;
        Object r101 = null;
        if (r100 == null) goto L28;
        Iterator<T> r102 = r100.data.sorted_ptcodes.iterator();
    L6:
        if (r102.hasNext() == false) goto L28;
        String r103 = (String) r102.next();
        Iterator<T> r104 = r100.data.paytype_items.iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((TypeItems) r105).ptcode, r103) == false) goto L9;
    L14:
        TypeItems r106 = (TypeItems) r105;
        if (r106 == null) goto L6;
        SignMethodInfo r107 = new SignMethodInfo();
        r107.icon_url = r106.icon_url;
        r107.title = r106.title;
        r107.sub_title = r106.sub_title;
        r107.sub_title_color = r106.sub_title_color;
        r107.mark = r106.mark;
        r107.paymentType = r106.ptcode;
        if (r106.sign_status != 1) goto L19;
        boolean r108 = true;
    L20:
        r107.is_sign_withholding = r108;
        r107.status = String.valueOf(r106.status);
        if (TextUtils.isEmpty(r100.data.default_ptcode) == false) goto L23;
    L27:
        this.mSignList.add(r107);
        goto L6
    L23:
        if (Intrinsics.areEqual(r107.status, "1") == false) goto L27;
        if (r107.is_sign_withholding == true) goto L27;
        r107.isChecked = Intrinsics.areEqual(r106.ptcode, r100.data.default_ptcode);
        goto L27
    L19:
        r108 = false;
        goto L20
    L13:
        r105 = null;
    L28:
        Iterator<T> r109 = this.mSignList.iterator();
    L30:
        if (r109.hasNext() == false) goto L34;
        Object r110 = r109.next();
        if (((SignMethodInfo) r110).isChecked == false) goto L30;
    L35:
        SignMethodInfo r111 = (SignMethodInfo) r110;
        if (r111 != null) goto L52;
        Iterator<T> r112 = this.mSignList.iterator();
    L39:
        if (r112.hasNext() == false) goto L48;
        Object r113 = r112.next();
        SignMethodInfo r114 = (SignMethodInfo) r113;
        if (Intrinsics.areEqual(r114.status, "1") == true) goto L43;
    L45:
        boolean r115 = false;
    L46:
        if (r115 == false) goto L39;
        r101 = r113;
        goto L48
    L43:
        if (r114.is_sign_withholding == true) goto L45;
        r115 = true;
    L48:
        r111 = (SignMethodInfo) r101;
        if (r111 == null) goto L52;
        r111.isChecked = true;
    L52:
        OnSignMethodListener r116 = this.onSignMethodListener;
        if (r116 == null) goto L72;
        r116.onDefaultMethod(r111);
        return;
    L72:
        return;
    L34:
        r110 = null;
        goto L35
    }

    private final void setSignListView() {
        LinearLayout r100 = this.mSignListLayout;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        Pair<Boolean, Integer> r101 = calFoldData();
        if (r101.getFirst().booleanValue() == true) goto L8;
    L10:
        List<SignMethodInfo> r102 = this.mSignList;
    L11:
        Iterator r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L18;
        SignMethodInfo r104 = (SignMethodInfo) r103.next();
        View r105 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_item_sign_confirm_layout, null);
        setIcon(r105, r104);
        setTitle(r105, r104);
        setSubTitle(r105, r104);
        setMark(r105, r104);
        setCheckBox(r105, r104);
        setItem(r105, r104);
        r105.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r106 = this.mSignListLayout;
        if (r106 == null) goto L13;
        r106.addView(r105);
        goto L13
    L18:
        if (r101.getFirst().booleanValue() == false) goto L29;
        final View r107 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_item_sign_confirm_more_method, null);
        LinearLayout r108 = this.mSignListLayout;
        if (r108 == null) goto L22;
        r108.addView(r107);
    L22:
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r107, new AnonymousClass2(this, r107));
        return;
    L29:
        return;
    L8:
        if (r101.getSecond().intValue() >= this.mSignList.size()) goto L10;
        r102 = this.mSignList.subList(0, r101.getSecond().intValue());
        goto L11
    }

    public SignMethodWrapper(View r100) {
        super(r100);
        if (r100 == null) goto L5;
        LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.cj_pay_sign_list);
    L6:
        this.mSignListLayout = r101;
        this.mSignList = new ArrayList();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final /* synthetic */ ArrayList access$getMSignList$p(SignMethodWrapper r100) {
        return r100.mSignList;
    }

    public static final /* synthetic */ OnSignMethodListener access$getOnSignMethodListener$p(SignMethodWrapper r100) {
        return r100.onSignMethodListener;
    }

    public static final /* synthetic */ void access$setSignListView(SignMethodWrapper r100) {
        r100.setSignListView();
    }

    private final View.OnClickListener getClickListener(final SignMethodInfo r100) {
        return new AnonymousClass1(this, r100);
    }

    private final boolean isEnable(SignMethodInfo r100) {
        return Intrinsics.areEqual(r100.status, "1");
    }

    private final boolean isSign(SignMethodInfo r100) {
        return r100.is_sign_withholding;
    }

    public static final /* synthetic */ void access$setHasClickFold$p(SignMethodWrapper r100, boolean r101) {
        r100.hasClickFold = r101;
    }

    private final void setCheckBox(View r100, SignMethodInfo r101) {
        CJPayCircleCheckBox r102 = (CJPayCircleCheckBox) r100.findViewById(R.id.cj_pay_payment_method_checkbox);
        r102.setIESNewStyle(true);
        if (isEnable(r101) == true) goto L5;
        r102.setEnabled(false);
        r102.setOnClickListener(null);
        r102.setWithCircleWhenUnchecked(false);
        r102.setChecked(false);
        return;
    L5:
        if (isSign(r101) == false) goto L7;
        r102.setUnavailable();
        r102.setOnClickListener(null);
        return;
    L7:
        r102.setEnabled(true);
        r102.setOnClickListener(getClickListener(r101));
        r102.setWithCircleWhenUnchecked(true);
        r102.setChecked(r101.isChecked);
    }

    private final void setIcon(View r110, SignMethodInfo r111) {
        ImageView r100 = (ImageView) r110.findViewById(R.id.cj_pay_payment_method_icon_unable_mask);
        ImageView r101 = (ImageView) r110.findViewById(R.id.cj_pay_payment_method_icon);
        PaymentUIUtils.Companion.setIconUrl$default(PaymentUIUtils.Companion, r101, r100, r111.icon_url, true, null, 16, null);
    }

    private final void setItem(View r100, SignMethodInfo r101) {
        if (isEnable(r101) == false) goto L5;
        r100.setOnClickListener(getClickListener(r101));
    L7:
        if (isSign(r101) == false) goto L10;
        r100.setOnClickListener(null);
        return;
    L10:
        return;
    L5:
        r100.setOnClickListener(null);
        goto L7
    }

    private final void setMark(View r100, SignMethodInfo r110) {
        TextView r101 = (TextView) r100.findViewById(R.id.cj_pay_payment_method_recommend_icon);
        if (r110.is_sign_withholding == false) goto L11;
        PaymentUIUtils.Companion r102 = PaymentUIUtils.Companion;
        Context r103 = getContext();
        Context r111 = getContext();
        if (r111 == null) goto L9;
        Resources r112 = r111.getResources();
        if (r112 == null) goto L9;
        String r113 = r112.getString(R.string.cj_pay_counter_outer_pay_signed);
    L10:
        r102.setMarkView(r103, r101, r113);
        r102.updateLabel(r101, getContext(), "#7E161823", "#7E161823", "#00000000", 2.0f);
        return;
    L9:
        r113 = null;
        goto L10
    L11:
        PaymentUIUtils.Companion r104 = PaymentUIUtils.Companion;
        r104.setMarkView(getContext(), r101, r110.mark);
        PaymentUIUtils.Companion.updateLabelStyle$default(r104, r101, getContext(), isEnable(r110), 5, null, 16, null);
    }

    private final void setSubTitle(View r100, SignMethodInfo r101) {
        TextView r102 = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_title);
        if (TextUtils.isEmpty(r101.sub_title) == true) goto L21;
        r102.setText(r101.sub_title);
        int r103 = 0;
        r102.setVisibility(0);
        if (isEnable(r101) == true) goto L7;
        Context r104 = getContext();
        if (r104 == null) goto L17;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L17;
        r103 = r105.getColor(R.color.cj_pay_color_gray_161823_opacity_34);
    L17:
        r102.setTextColor(r103);
        return;
    L7:
        if (TextUtils.isEmpty(r101.sub_title_color) == true) goto L22;
        r102.setTextColor(Color.parseColor(r101.sub_title_color));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SignMethodWrapper#setSubTitle", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SignMethodWrapper#setSubTitle", e);
        return;
    L22:
        return;
    }

    private final void setTitle(View r100, SignMethodInfo r101) {
        TextView r102 = (TextView) r100.findViewById(R.id.cj_pay_payment_method_title);
        r102.setText(r101.title);
        CJPayFakeBoldUtils.fakeBold(r102);
        int r103 = 0;
        if (isEnable(r101) == false) goto L10;
        Context r104 = getContext();
        if (r104 == null) goto L9;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L9;
        r103 = r105.getColor(R.color.cj_pay_color_black_161823);
    L9:
        r102.setTextColor(r103);
        return;
    L10:
        Context r106 = getContext();
        if (r106 == null) goto L15;
        Resources r107 = r106.getResources();
        if (r107 == null) goto L15;
        r103 = r107.getColor(R.color.cj_pay_color_gray_161823_opacity_34);
    L15:
        r102.setTextColor(r103);
    }

    public final void initData(SignCreateResponse r100, OnSignMethodListener r101) {
        this.signCreateResponse = r100;
        this.onSignMethodListener = r101;
        setSignListData();
        setSignListView();
    }
}
