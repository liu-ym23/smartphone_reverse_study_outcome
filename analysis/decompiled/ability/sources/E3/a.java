package E3;

import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public Supplier f461a;
    public Object b = null;

    public a(Supplier supplier) {
        this.f461a = supplier;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Supplier supplier;
        if (this.b == null && (supplier = this.f461a) != null) {
            this.b = supplier.get();
            this.f461a = null;
        }
        return this.b;
    }
}
