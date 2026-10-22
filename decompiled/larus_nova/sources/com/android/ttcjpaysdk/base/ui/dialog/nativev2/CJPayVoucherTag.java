package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.ui.data.RetainMsg;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayVoucherTag;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "afterDesc", "Landroid/widget/TextView;", "leftAmount", "leftTipText", "leftTipView", "Landroid/view/View;", "rightTagView", "rightText", "rightTipText", "adjustFontSize", "", "text", "", "refreshVoucherTag", "retainMsg", "Lcom/android/ttcjpaysdk/base/ui/data/RetainMsg;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayVoucherTag extends RelativeLayout {
    private final TextView afterDesc;
    private final TextView leftAmount;
    private final TextView leftTipText;
    private final View leftTipView;
    private final View rightTagView;
    private final TextView rightText;
    private final TextView rightTipText;

    private final void adjustFontSize(String r100) {
        CJPayFontUtils.setDouYinMediumTypeface(getContext(), this.leftAmount);
        this.leftAmount.setLetterSpacing(-0.09f);
        TextView r101 = this.leftAmount;
        if (r100.length() > 3) goto L6;
        float r102 = 26.0f;
    L9:
        r101.setTextSize(r102);
        return;
    L6:
        if (r100.length() > 5) goto L8;
        r102 = 24.0f;
        goto L9
    L8:
        r102 = 20.0f;
        goto L9
    }

    public final void refreshVoucherTag(RetainMsg r100) {
        Intrinsics.checkNotNullParameter(r100, "retainMsg");
        this.rightTagView.setVisibility(8);
        this.leftTipView.setVisibility(8);
        String r101 = r100.tag_msg;
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 != true) goto L10;
    L11:
        if (r102 == false) goto L18;
        String r104 = r100.tag_position;
        if (Intrinsics.areEqual(r104, "left") == false) goto L16;
        this.leftTipText.setText(r100.tag_msg);
        this.leftTipView.setVisibility(0);
        goto L18
    L16:
        if (Intrinsics.areEqual(r104, "top_right") == false) goto L18;
        this.rightTipText.setText(r100.tag_msg);
        this.rightTagView.setVisibility(0);
    L18:
        String r105 = r100.left_msg_type;
        if (r105 == null) goto L42;
        int r106 = r105.hashCode();
        if (r106 == (-1413853096)) goto L37;
        if (r106 == 3556653) goto L34;
        if (r106 != 273184065) goto L42;
        if (r105.equals("discount") == false) goto L42;
        this.afterDesc.setText(getContext().getString(R.string.cj_pay_keep_dialog_native_v2_discount));
        this.afterDesc.setVisibility(0);
        String r107 = r100.left_msg;
        if (r107 == null) goto L42;
        adjustFontSize(r107);
        goto L42
    L34:
        if (r105.equals("text") == false) goto L42;
        this.afterDesc.setVisibility(8);
        goto L42
    L37:
        if (r105.equals("amount") == false) goto L42;
        this.afterDesc.setText(getContext().getString(R.string.cj_pay_keep_dialog_native_v2_yuan));
        this.afterDesc.setVisibility(0);
        String r108 = r100.left_msg;
        if (r108 == null) goto L42;
        adjustFontSize(r108);
    L42:
        this.leftAmount.setText(r100.left_msg);
        this.leftAmount.setVisibility(0);
        this.rightText.setText(r100.right_msg);
        return;
    L7:
        r103 = false;
    L10:
        r102 = false;
        goto L11
    }

    public CJPayVoucherTag(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_keep_dialog_v2_voucher_tag, this, true);
        this.leftTipView = findViewById(R.id.voucher_tag_number_pre_des_layout);
        this.leftTipText = (TextView) findViewById(R.id.voucher_tag_number_pre_des);
        this.leftAmount = (TextView) findViewById(R.id.voucher_tag_number);
        this.afterDesc = (TextView) findViewById(R.id.voucher_tag_number_after_desc);
        this.rightText = (TextView) findViewById(R.id.voucher_tag_text);
        this.rightTagView = findViewById(R.id.voucher_tag_right_tip);
        this.rightTipText = (TextView) findViewById(R.id.voucher_tag_top_right_tip_text);
    }
}
