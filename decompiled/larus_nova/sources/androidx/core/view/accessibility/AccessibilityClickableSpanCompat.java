package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
    private final int mClickableSpanActionId;
    private final AccessibilityNodeInfoCompat mNodeInfoCompat;
    private final int mOriginalClickableSpanId;

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        Bundle r101 = new Bundle();
        r101.putInt(SPAN_ID, this.mOriginalClickableSpanId);
        this.mNodeInfoCompat.performAction(this.mClickableSpanActionId, r101);
    }

    public AccessibilityClickableSpanCompat(int r100, AccessibilityNodeInfoCompat r101, int r102) {
        this.mOriginalClickableSpanId = r100;
        this.mNodeInfoCompat = r101;
        this.mClickableSpanActionId = r102;
    }
}
