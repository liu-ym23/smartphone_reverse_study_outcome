package b2;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import b0.a2;
import b0.i0;
import b0.o1;
import t0.e;
import u0.k;
import z1.j;

/* loaded from: classes.dex */
public final class b extends CharacterStyle implements UpdateAppearance {

    /* renamed from: f, reason: collision with root package name */
    public final float f1479f;

    /* renamed from: g, reason: collision with root package name */
    public final o1 f1480g = b0.b.n(new e(9205357640488583168L));

    /* renamed from: h, reason: collision with root package name */
    public final i0 f1481h = b0.b.j(new a2(1, this));

    public b(k kVar, float f10) {
        this.f1479f = f10;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        j.a(textPaint, this.f1479f);
        textPaint.setShader((Shader) this.f1481h.getValue());
    }
}
