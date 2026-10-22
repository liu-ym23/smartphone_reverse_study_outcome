package com.android.ttcjpaysdk.bindcard.base.ui.wrapper.confirm;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.widget.CJPayBoldTextView;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/confirm/BindCardConfirmHalfPageWrapper;", "Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/confirm/BindCardConfirmBaseWrapper;", "contentView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "(Landroid/view/View;Landroid/app/Activity;)V", "confirmTitle", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayBoldTextView;", "halfRootView", "Landroid/widget/LinearLayout;", "bindViews", "", "confirmInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "getHalfRootView", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindCardConfirmHalfPageWrapper extends BindCardConfirmBaseWrapper {
    private CJPayBoldTextView confirmTitle;
    private LinearLayout halfRootView;

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.confirm.BindCardConfirmBaseWrapper
    public View getHalfRootView() {
        return this.halfRootView;
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.confirm.BindCardConfirmBaseWrapper
    public void bindViews(CJPayNoPwdPayInfo r100) {
        super.bindViews(r100);
        CJPayBoldTextView r101 = this.confirmTitle;
        if (r101 == null) goto L13;
        CJPayNoPwdPayInfo r102 = getSecondConfirmInfo();
        if (r102 == null) goto L10;
        String r103 = r102.sub_title;
        if (r103 == null) goto L10;
    L11:
        r101.setText(r103);
        return;
    L10:
        r103 = "";
        goto L11
    }

    public BindCardConfirmHalfPageWrapper(View r100, Activity r101) {
        super(r100, r101);
        setStyle(CJPayNoPwdPayInfo.SecondTradeConfirm.BINDCARD_HALFPAGE.getStyle());
        CJLogger.d(getTAG(), "init style:" + getStyle());
        LinearLayout r102 = null;
        if (r100 == null) goto L5;
        CJPayBoldTextView r103 = (CJPayBoldTextView) r100.findViewById(R.id.confirm_title);
    L6:
        this.confirmTitle = r103;
        if (r100 == null) goto L9;
        r102 = (LinearLayout) r100.findViewById(R.id.layout_pay_confirm_half_page);
    L9:
        this.halfRootView = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
