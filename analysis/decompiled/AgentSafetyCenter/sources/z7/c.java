package z7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16472a;

    /* renamed from: b, reason: collision with root package name */
    public f f16473b;

    @Override // z7.d
    public final String a() {
        switch (this.f16472a) {
            case 0:
                return "format.email";
            default:
                return "format.idn-email";
        }
    }

    @Override // z7.d
    public final String getName() {
        switch (this.f16472a) {
            case 0:
                return "email";
            default:
                return "idn-email";
        }
    }

    @Override // z7.d
    public final boolean matches(String str) {
        switch (this.f16472a) {
        }
        return this.f16473b.a(str);
    }
}
