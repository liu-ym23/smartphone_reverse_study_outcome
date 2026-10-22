package a2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final yb.l f46a;

    /* renamed from: b, reason: collision with root package name */
    public final yb.l f47b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(xb.a aVar, xb.a aVar2) {
        this.f46a = (yb.l) aVar;
        this.f47b = (yb.l) aVar2;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r2v1, types: [xb.a, yb.l] */
    public final String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.f46a.invoke()).floatValue() + ", maxValue=" + ((Number) this.f47b.invoke()).floatValue() + ", reverseScrolling=false)";
    }
}
