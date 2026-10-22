package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogLeaveReasonLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgView", "Landroid/view/View;", "isSelectedState", "", "leaveReasonText", "Landroid/widget/TextView;", "currentText", "", "setItemStyle", "", "isSolid", "updateState", "selected", "updateText", "text", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogLeaveReasonLayout extends RelativeLayout {
    private final View bgView;
    private boolean isSelectedState;
    private final TextView leaveReasonText;

    public final String currentText() {
        return this.leaveReasonText.getText().toString();
    }

    public final boolean isSelectedState() {
        return this.isSelectedState;
    }

    public final void setItemStyle(boolean r100) {
        View r101 = this.bgView;
        if (r100 == false) goto L5;
        int r102 = R.drawable.cj_pay_keep_bg_leave_reason_solid_selector;
    L6:
        r101.setBackgroundResource(r102);
        return;
    L5:
        r102 = R.drawable.cj_pay_keep_bg_leave_reason_selector;
        goto L6
    }

    public final void updateState(boolean r100) {
        if (r100 == false) goto L4;
        this.leaveReasonText.setTextColor(ColorProtector.parseColor("#FFFE2C55"));
    L5:
        this.bgView.setSelected(r100);
        this.isSelectedState = r100;
        return;
    L4:
        this.leaveReasonText.setTextColor(ColorProtector.parseColor("#FF161823"));
        goto L5
    }

    public final void updateText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.leaveReasonText.setText(r100);
    }

    public CJPayKeepDialogLeaveReasonLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_keep_dialog_leave_reason_layout, this, true);
        this.leaveReasonText = (TextView) findViewById(R.id.leave_reason_text);
        this.bgView = findViewById(R.id.leave_reason_bg);
    }

    public static /* synthetic */ void updateState$default(CJPayKeepDialogLeaveReasonLayout r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.updateState(r101);
    }
}
