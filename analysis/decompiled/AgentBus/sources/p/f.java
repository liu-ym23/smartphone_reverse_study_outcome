package p;

/* loaded from: classes.dex */
public final class f implements d {

    /* renamed from: b, reason: collision with root package name */
    public final n.f1 f8091b = new n.f1(125, new n.r(0.25f, 0.1f, 0.25f));

    @Override // p.d
    public final float a(float f10, float f11, float f12) {
        float fAbs = Math.abs((f11 + f10) - f10);
        float f13 = (0.3f * f12) - (0.0f * fAbs);
        float f14 = f12 - f13;
        if ((fAbs <= f12) && f14 < fAbs) {
            f13 = f12 - fAbs;
        }
        return f10 - f13;
    }

    @Override // p.d
    public final n.h b() {
        return this.f8091b;
    }
}
