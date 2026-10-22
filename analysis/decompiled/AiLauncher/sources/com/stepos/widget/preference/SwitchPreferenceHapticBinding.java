package com.stepos.widget.preference;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.internal.SwitchHapticFeedback;
import com.stepos.widget.list.StepOSListItem;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/preference/SwitchPreferenceHapticBinding;", "", "<init>", "()V", "Lcom/stepos/widget/list/StepOSListItem;", "boundRow", "()Lcom/stepos/widget/list/StepOSListItem;", "row", "LY8/t;", "bind", "(Lcom/stepos/widget/list/StepOSListItem;)V", "performRowClickFeedback", "Ljava/lang/ref/WeakReference;", "rowReference", "Ljava/lang/ref/WeakReference;", "", UxipConstants.f30680s, "isEnabled", "Z", "()Z", "setEnabled", "(Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SwitchPreferenceHapticBinding {
    private boolean isEnabled = true;
    private WeakReference<StepOSListItem> rowReference;

    private final StepOSListItem boundRow() {
        StepOSListItem stepOSListItem;
        WeakReference<StepOSListItem> weakReference = this.rowReference;
        if (weakReference == null || (stepOSListItem = weakReference.get()) == null || stepOSListItem.getSwitchHapticFeedbackOwner() != this) {
            return null;
        }
        return stepOSListItem;
    }

    public final void bind(StepOSListItem row) {
        p.i(row, "row");
        this.rowReference = new WeakReference<>(row);
        row.setSwitchHapticFeedbackOwner$StepOSWidget_release(this);
        row.setSwitchHapticFeedbackEnabled(this.isEnabled);
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void performRowClickFeedback() {
        StepOSListItem stepOSListItemBoundRow;
        if (this.isEnabled && (stepOSListItemBoundRow = boundRow()) != null) {
            SwitchHapticFeedback.INSTANCE.perform(stepOSListItemBoundRow);
        }
    }

    public final void setEnabled(boolean z10) {
        this.isEnabled = z10;
        StepOSListItem stepOSListItemBoundRow = boundRow();
        if (stepOSListItemBoundRow != null) {
            stepOSListItemBoundRow.setSwitchHapticFeedbackEnabled(z10);
        }
    }
}
