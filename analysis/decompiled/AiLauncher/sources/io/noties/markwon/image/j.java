package io.noties.markwon.image;

import android.graphics.Rect;
import io.noties.markwon.image.h;

/* loaded from: classes4.dex */
public class j extends i {
    protected static final String UNIT_EM = "em";
    protected static final String UNIT_PERCENT = "%";

    @Override // io.noties.markwon.image.i
    public Rect a(a aVar) {
        return c(aVar.c(), aVar.g().getBounds(), aVar.f(), aVar.e());
    }

    public int b(h.a aVar, int i10, float f10) {
        return (int) ((UNIT_EM.equals(aVar.f34293b) ? aVar.f34292a * f10 : aVar.f34292a) + 0.5f);
    }

    public Rect c(h hVar, Rect rect, int i10, float f10) {
        if (hVar == null) {
            int iWidth = rect.width();
            if (iWidth > i10) {
                return new Rect(0, 0, i10, (int) ((rect.height() / (iWidth / i10)) + 0.5f));
            }
            return rect;
        }
        h.a aVar = hVar.f34290a;
        h.a aVar2 = hVar.f34291b;
        int iWidth2 = rect.width();
        int iHeight = rect.height();
        float f11 = iWidth2 / iHeight;
        if (aVar != null) {
            int iB = UNIT_PERCENT.equals(aVar.f34293b) ? (int) ((i10 * (aVar.f34292a / 100.0f)) + 0.5f) : b(aVar, iWidth2, f10);
            return new Rect(0, 0, iB, (aVar2 == null || UNIT_PERCENT.equals(aVar2.f34293b)) ? (int) ((iB / f11) + 0.5f) : b(aVar2, iHeight, f10));
        }
        if (aVar2 == null || UNIT_PERCENT.equals(aVar2.f34293b)) {
            return rect;
        }
        int iB2 = b(aVar2, iHeight, f10);
        return new Rect(0, 0, (int) ((iB2 * f11) + 0.5f), iB2);
    }
}
