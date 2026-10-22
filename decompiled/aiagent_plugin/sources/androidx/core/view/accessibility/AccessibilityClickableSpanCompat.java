package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
    private final int mClickableSpanActionId;
    private final b mNodeInfoCompat;
    private final int mOriginalClickableSpanId;

    public AccessibilityClickableSpanCompat(int r1, b r2, int r3) {
        this.mOriginalClickableSpanId = r1;
        this.mNodeInfoCompat = r2;
        this.mClickableSpanActionId = r3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r3) {
        Bundle r4 = new Bundle();
        r4.putInt(SPAN_ID, this.mOriginalClickableSpanId);
        this.mNodeInfoCompat.a(this.mClickableSpanActionId, r4);
    }
}
