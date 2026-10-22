package w7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class m extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    public final e f15335c;

    public m(String str) {
        super(str);
        this.f15335c = null;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        e eVar = this.f15335c;
        return eVar != null ? eVar.a() : super.getMessage();
    }

    public m(e eVar) {
        this.f15335c = eVar;
    }

    public m(Throwable th) {
        super(th);
        this.f15335c = null;
    }
}
