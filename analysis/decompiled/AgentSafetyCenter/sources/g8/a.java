package g8;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public Supplier f4366c;

    /* renamed from: f, reason: collision with root package name */
    public Object f4367f = null;

    public a(Supplier supplier) {
        this.f4366c = supplier;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Supplier supplier;
        if (this.f4367f == null && (supplier = this.f4366c) != null) {
            this.f4367f = supplier.get();
            this.f4366c = null;
        }
        return this.f4367f;
    }
}
