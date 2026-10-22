package x4;

/* renamed from: x4.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1309i extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final transient Z3.i f23855a;

    public C1309i(Z3.i iVar) {
        this.f23855a = iVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f23855a.toString();
    }
}
