package m2;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import d1.i;
import f1.f;
import f1.g;
import td.h;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends CharacterStyle implements UpdateAppearance {

    /* renamed from: c, reason: collision with root package name */
    public h f8189c;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        h hVar = this.f8189c;
        if (textPaint != null) {
            if (k.a(hVar, f.f3864e)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (!(hVar instanceof g)) {
                g5.f.a();
                return;
            }
            textPaint.setStyle(Paint.Style.STROKE);
            g gVar = (g) hVar;
            textPaint.setStrokeWidth(gVar.f3865e);
            textPaint.setStrokeMiter(gVar.f3866f);
            int i = gVar.f3868h;
            textPaint.setStrokeJoin(i == 0 ? Paint.Join.MITER : i == 1 ? Paint.Join.ROUND : i == 2 ? Paint.Join.BEVEL : Paint.Join.MITER);
            int i3 = gVar.f3867g;
            textPaint.setStrokeCap(i3 == 0 ? Paint.Cap.BUTT : i3 == 1 ? Paint.Cap.ROUND : i3 == 2 ? Paint.Cap.SQUARE : Paint.Cap.BUTT);
            i iVar = gVar.i;
            textPaint.setPathEffect(iVar != null ? iVar.f2996a : null);
        }
    }
}
