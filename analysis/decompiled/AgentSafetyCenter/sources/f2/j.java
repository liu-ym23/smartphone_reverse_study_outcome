package f2;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    public int f3892a;

    /* renamed from: b, reason: collision with root package name */
    public float f3893b;

    /* renamed from: c, reason: collision with root package name */
    public float f3894c;

    /* renamed from: d, reason: collision with root package name */
    public float f3895d;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f3895d, this.f3893b, this.f3894c, this.f3892a);
    }
}
