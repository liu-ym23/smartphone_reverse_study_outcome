package androidx.lifecycle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public z f1449c;

    /* renamed from: f, reason: collision with root package name */
    public o f1450f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1451g;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1451g) {
            return;
        }
        this.f1449c.f(this.f1450f);
        this.f1451g = true;
    }
}
