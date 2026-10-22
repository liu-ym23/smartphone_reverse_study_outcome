package D1;

import A1.t;
import D1.i;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes.dex */
final class m<T> extends t<T> {

    /* renamed from: a, reason: collision with root package name */
    private final A1.e f1101a;

    /* renamed from: b, reason: collision with root package name */
    private final t<T> f1102b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f1103c;

    m(A1.e eVar, t<T> tVar, Type type) {
        this.f1101a = eVar;
        this.f1102b = tVar;
        this.f1103c = type;
    }

    private Type e(Type type, Object obj) {
        return (obj == null || !(type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) ? type : obj.getClass();
    }

    @Override // A1.t
    public T b(G1.a aVar) {
        return this.f1102b.b(aVar);
    }

    @Override // A1.t
    public void d(G1.c cVar, T t5) {
        t<T> tVarK = this.f1102b;
        Type typeE = e(this.f1103c, t5);
        if (typeE != this.f1103c) {
            tVarK = this.f1101a.k(com.google.gson.reflect.a.get(typeE));
            if (tVarK instanceof i.b) {
                t<T> tVar = this.f1102b;
                if (!(tVar instanceof i.b)) {
                    tVarK = tVar;
                }
            }
        }
        tVarK.d(cVar, t5);
    }
}
