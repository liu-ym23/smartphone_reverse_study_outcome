package d9;

/* renamed from: d9.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1395p implements V7.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f4314a;

    public C1395p(int i) {
        this.f4314a = i;
    }

    @Override // V7.b
    public final Object getValue(Object obj, Z7.t property) {
        AbstractC1383d thisRef = (AbstractC1383d) obj;
        kotlin.jvm.internal.k.f(thisRef, "thisRef");
        kotlin.jvm.internal.k.f(property, "property");
        return thisRef.f4305a.get(this.f4314a);
    }
}
