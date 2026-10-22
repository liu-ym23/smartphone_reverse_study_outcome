package ia;

/* loaded from: classes.dex */
public final class k0 extends Exception {

    /* renamed from: f, reason: collision with root package name */
    public final Throwable f4965f;

    public k0(Throwable th, x xVar, g7.l lVar) {
        super("Coroutine dispatcher " + xVar + " threw an exception, context = " + lVar, th);
        this.f4965f = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f4965f;
    }
}
