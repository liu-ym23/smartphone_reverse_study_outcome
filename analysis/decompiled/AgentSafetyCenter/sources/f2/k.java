package f2;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3896a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3897b;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(this.f3896a);
        textPaint.setStrikeThruText(this.f3897b);
    }
}
