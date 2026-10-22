package e8;

import java.io.Serializable;
import q7.v;

/* loaded from: classes.dex */
public final class n extends ea.k {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3162b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3163c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f3164d;

    public /* synthetic */ n(Object obj, Serializable serializable, int i2) {
        this.f3162b = i2;
        this.f3163c = obj;
        this.f3164d = serializable;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [p7.k, q7.m] */
    @Override // ea.k
    public void b(Object obj) {
        switch (this.f3162b) {
            case 2:
                f8.c cVar = (f8.c) obj;
                q7.k.e(cVar, "current");
                v vVar = (v) this.f3164d;
                if (vVar.f8820f == null && ((Boolean) ((q7.m) this.f3163c).invoke(cVar)).booleanValue()) {
                    vVar.f8820f = cVar;
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, p7.k] */
    @Override // ea.k
    public final boolean c(Object obj) {
        switch (this.f3162b) {
            case 0:
                f8.e eVar = (f8.e) obj;
                v vVar = (v) this.f3164d;
                q7.k.e(eVar, "javaClassDescriptor");
                String strA = n7.o.A(eVar, (String) this.f3163c);
                if (q.f3177b.contains(strA)) {
                    vVar.f8820f = j.f3152f;
                } else if (q.f3178c.contains(strA)) {
                    vVar.f8820f = j.f3153g;
                } else if (q.f3176a.contains(strA)) {
                    vVar.f8820f = j.f3155i;
                }
                return vVar.f8820f == null;
            case 1:
                boolean[] zArr = (boolean[]) this.f3164d;
                if (((Boolean) this.f3163c.invoke(obj)).booleanValue()) {
                    zArr[0] = true;
                }
                return !zArr[0];
            default:
                q7.k.e((f8.c) obj, "current");
                return ((v) this.f3164d).f8820f == null;
        }
    }

    @Override // ea.k
    public final Object i() {
        switch (this.f3162b) {
            case 0:
                j jVar = (j) ((v) this.f3164d).f8820f;
                return jVar == null ? j.f3154h : jVar;
            case 1:
                return Boolean.valueOf(((boolean[]) this.f3164d)[0]);
            default:
                return (f8.c) ((v) this.f3164d).f8820f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(v vVar, p7.k kVar) {
        this.f3162b = 2;
        this.f3164d = vVar;
        this.f3163c = (q7.m) kVar;
    }
}
