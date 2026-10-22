package u1;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes.dex */
public final class k extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9957a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9958b;

    public k(boolean z4, boolean z10) {
        this.f9957a = z4;
        this.f9958b = z10;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(this.f9957a);
        textPaint.setStrikeThruText(this.f9958b);
    }
}
