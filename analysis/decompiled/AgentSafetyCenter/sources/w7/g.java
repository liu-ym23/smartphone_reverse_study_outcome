package w7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    public e f15316c;

    @Override // java.lang.Throwable
    public final String getMessage() {
        e eVar = this.f15316c;
        return eVar != null ? eVar.a() : super.getMessage();
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
