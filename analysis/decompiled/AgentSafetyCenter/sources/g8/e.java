package g8;

import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public volatile Supplier f4379c;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f4380f;

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f4379c == null) {
            return this.f4380f;
        }
        synchronized (this) {
            try {
                if (this.f4379c != null) {
                    this.f4380f = this.f4379c.get();
                    this.f4379c = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f4380f;
    }
}
