package yb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class o extends p implements fc.b {
    public o(Class cls, String str, String str2, int i) {
        super(b.f16081c, cls, str, str2, i);
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
        ((fc.b) ((fc.c) aVarE)).b();
    }

    @Override // fc.b
    public Object get(Object obj) {
        b();
        throw null;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        return get(obj);
    }
}
