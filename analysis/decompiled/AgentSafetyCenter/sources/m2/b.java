package m2;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import d1.h0;
import k0.i0;
import k0.k1;
import k2.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends CharacterStyle implements UpdateAppearance {

    /* renamed from: c, reason: collision with root package name */
    public h0 f8190c;

    /* renamed from: f, reason: collision with root package name */
    public float f8191f;

    /* renamed from: g, reason: collision with root package name */
    public k1 f8192g;

    /* renamed from: h, reason: collision with root package name */
    public i0 f8193h;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        k.b(textPaint, this.f8191f);
        textPaint.setShader((Shader) this.f8193h.getValue());
    }
}
