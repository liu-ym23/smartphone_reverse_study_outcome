package b2;

import a4.u;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import q7.k;
import w0.c;
import w0.f;
import w0.g;

/* loaded from: classes.dex */
public final class a extends CharacterStyle implements UpdateAppearance {

    /* renamed from: f, reason: collision with root package name */
    public final c f1478f;

    public a(c cVar) {
        this.f1478f = cVar;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            f fVar = f.f10635b;
            c cVar = this.f1478f;
            if (k.a(cVar, fVar)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (!(cVar instanceof g)) {
                throw new u();
            }
            textPaint.setStyle(Paint.Style.STROKE);
            g gVar = (g) cVar;
            textPaint.setStrokeWidth(gVar.f10636b);
            textPaint.setStrokeMiter(4.0f);
            textPaint.setStrokeJoin(Paint.Join.MITER);
            int i2 = gVar.f10637c;
            textPaint.setStrokeCap(i2 == 0 ? Paint.Cap.BUTT : i2 == 1 ? Paint.Cap.ROUND : i2 == 2 ? Paint.Cap.SQUARE : Paint.Cap.BUTT);
            textPaint.setPathEffect(null);
        }
    }
}
