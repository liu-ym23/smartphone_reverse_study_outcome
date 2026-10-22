package yb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends p implements fc.b, fc.c {
    public m(String str, String str2) {
        super(b.f16081c, a2.w.class, str, str2, 1);
    }

    @Override // yb.c
    public final fc.a a() {
        v.f16099a.getClass();
        return this;
    }

    @Override // fc.b
    public final void b() {
        if (this.f16093k) {
            g5.f.o("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return;
        }
        fc.a aVarE = e();
        if (aVarE == this) {
            throw new kc.v("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        ((m) ((fc.c) aVarE)).b();
    }

    @Override // fc.b
    public final Object get(Object obj) {
        throw null;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        b();
        throw null;
    }
}
