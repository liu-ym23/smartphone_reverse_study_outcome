package r;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccessibilityNodeInfoCompat f23669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23670c;

    public a(int r10, AccessibilityNodeInfoCompat r11, int r12) {
        this.f23668a = r10;
        this.f23669b = r11;
        this.f23670c = r12;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r10) {
        Bundle r11 = new Bundle();
        r11.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f23668a);
        this.f23669b.M(this.f23670c, r11);
    }
}
