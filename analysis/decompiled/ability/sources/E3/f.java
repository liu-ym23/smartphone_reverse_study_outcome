package E3;

import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final class f implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public volatile Supplier f466a;
    public volatile Object b;

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f466a == null) {
            return this.b;
        }
        synchronized (this) {
            try {
                if (this.f466a != null) {
                    this.b = this.f466a.get();
                    this.f466a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.b;
    }
}
