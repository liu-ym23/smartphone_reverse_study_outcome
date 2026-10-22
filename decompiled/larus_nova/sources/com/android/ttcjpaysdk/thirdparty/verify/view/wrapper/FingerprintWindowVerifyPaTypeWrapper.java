package com.android.ttcjpaysdk.thirdparty.verify.view.wrapper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/FingerprintWindowVerifyPaTypeWrapper;", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyPayTypeWrapper;", "contentView", "Landroid/view/View;", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "withAnimation", "", "(Landroid/view/View;Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;Z)V", "setMarginTopWithoutDiscount", "", "withoutDiscount", "isDynamicLayout", "(ZLjava/lang/Boolean;)V", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FingerprintWindowVerifyPaTypeWrapper extends VerifyPayTypeWrapper {
    @Override // com.android.ttcjpaysdk.thirdparty.verify.view.wrapper.VerifyPayTypeWrapper
    public void setMarginTopWithoutDiscount(boolean r100, Boolean r101) {
        View r102 = getPayTypeLLayout();
        RelativeLayout.LayoutParams r103 = null;
        if (r102 == null) goto L5;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
    L7:
        if ((r104 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        r103 = (RelativeLayout.LayoutParams) r104;
    L9:
        if (r103 == null) goto L12;
        r103.topMargin = CJPayBasicExtensionKt.dp(18.0f);
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L7
    }

    public FingerprintWindowVerifyPaTypeWrapper(View r100, CJPayPayInfo r101, boolean r102) {
        super(r100, r101, r102, Boolean.FALSE);
    }

    public /* synthetic */ FingerprintWindowVerifyPaTypeWrapper(View r100, CJPayPayInfo r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }
}
