package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public xb.l f5624a;

    public abstract void a(f1.d dVar);

    public xb.l b() {
        return this.f5624a;
    }

    public final void c() {
        xb.l lVarB = b();
        if (lVarB != null) {
            lVarB.invoke(this);
        }
    }

    public void d(a2.m mVar) {
        this.f5624a = mVar;
    }
}
