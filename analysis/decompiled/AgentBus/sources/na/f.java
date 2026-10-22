package na;

/* loaded from: classes.dex */
public final class f extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    public final transient g7.l f6898f;

    public f(g7.l lVar) {
        this.f6898f = lVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return String.valueOf(this.f6898f);
    }
}
