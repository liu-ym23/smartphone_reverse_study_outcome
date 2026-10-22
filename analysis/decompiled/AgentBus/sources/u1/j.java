package u1;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes.dex */
public final class j extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    public final int f9953a;

    /* renamed from: b, reason: collision with root package name */
    public final float f9954b;

    /* renamed from: c, reason: collision with root package name */
    public final float f9955c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9956d;

    public j(int i2, float f10, float f11, float f12) {
        this.f9953a = i2;
        this.f9954b = f10;
        this.f9955c = f11;
        this.f9956d = f12;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f9956d, this.f9954b, this.f9955c, this.f9953a);
    }
}
