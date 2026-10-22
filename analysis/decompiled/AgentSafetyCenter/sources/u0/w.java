package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w implements v {

    /* renamed from: c, reason: collision with root package name */
    public final s0.a f13712c = new s0.a(0);

    public final boolean e(int i) {
        return (this.f13712c.get() & i) != 0;
    }

    public final void f(int i) {
        s0.a aVar;
        int i3;
        do {
            aVar = this.f13712c;
            i3 = aVar.get();
            if ((i3 & i) != 0) {
                return;
            }
        } while (!aVar.compareAndSet(i3, i3 | i));
    }
}
