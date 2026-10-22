package com.stepos.widget.dialog;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001*\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"entriesOrEmpty", "", "", "Lcom/stepos/widget/dialog/StepOSAlertParams;", "(Lcom/stepos/widget/dialog/StepOSAlertParams;)[Ljava/lang/CharSequence;", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSAlertControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence[] entriesOrEmpty(StepOSAlertParams stepOSAlertParams) {
        CharSequence[] items = stepOSAlertParams.getItems();
        return items == null ? new CharSequence[0] : items;
    }
}
