package p;

import b0.o1;

/* loaded from: classes.dex */
public final class l implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4.p f8136a;

    public l(a4.p pVar) {
        this.f8136a = pVar;
    }

    @Override // p.i0
    public final float a(float f10) {
        if (Float.isNaN(f10)) {
            return 0.0f;
        }
        a4.p pVar = this.f8136a;
        float fFloatValue = ((Number) ((c1.w) pVar.f192f).invoke(Float.valueOf(f10))).floatValue();
        ((o1) pVar.f196j).setValue(Boolean.valueOf(fFloatValue > 0.0f));
        ((o1) pVar.f197k).setValue(Boolean.valueOf(fFloatValue < 0.0f));
        return fFloatValue;
    }
}
