package S;

/* renamed from: S.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0097c extends N {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1736a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1737b;

    public C0097c(int i4, Object obj) {
        this.f1736a = obj;
        this.f1737b = i4;
    }

    public final void a() {
        Object obj = this.f1736a;
        if (!((obj != null ? obj.hashCode() : 0) == this.f1737b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }
}
