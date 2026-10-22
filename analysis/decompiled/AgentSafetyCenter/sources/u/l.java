package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ ad.z f13521a;

    /* JADX WARN: Type inference failed for: r0v2, types: [xb.l, yb.l] */
    @Override // u.j0
    public final float a(float f5) {
        ad.z zVar = this.f13521a;
        if (Float.isNaN(f5)) {
            return 0.0f;
        }
        float fFloatValue = ((Number) ((yb.l) zVar.f637b).invoke(Float.valueOf(f5))).floatValue();
        ((k0.k1) zVar.f641f).setValue(Boolean.valueOf(fFloatValue > 0.0f));
        ((k0.k1) zVar.f642g).setValue(Boolean.valueOf(fFloatValue < 0.0f));
        return fFloatValue;
    }
}
