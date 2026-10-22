package D1;

import A1.t;
import A1.u;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a<E> extends t<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final u f1043c = new C0016a();

    /* renamed from: a, reason: collision with root package name */
    private final Class<E> f1044a;

    /* renamed from: b, reason: collision with root package name */
    private final t<E> f1045b;

    /* renamed from: D1.a$a, reason: collision with other inner class name */
    static class C0016a implements u {
        C0016a() {
        }

        @Override // A1.u
        public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeG = C1.b.g(type);
            return new a(eVar, eVar.k(com.google.gson.reflect.a.get(typeG)), C1.b.k(typeG));
        }
    }

    public a(A1.e eVar, t<E> tVar, Class<E> cls) {
        this.f1045b = new m(eVar, tVar, cls);
        this.f1044a = cls;
    }

    @Override // A1.t
    public Object b(G1.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.V() == G1.b.NULL) {
            aVar.O();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.w()) {
            arrayList.add(this.f1045b.b(aVar));
        }
        aVar.r();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f1044a, size);
        for (int i5 = 0; i5 < size; i5++) {
            Array.set(objNewInstance, i5, arrayList.get(i5));
        }
        return objNewInstance;
    }

    @Override // A1.t
    public void d(G1.c cVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            cVar.D();
            return;
        }
        cVar.f();
        int length = Array.getLength(obj);
        for (int i5 = 0; i5 < length; i5++) {
            this.f1045b.d(cVar, Array.get(obj, i5));
        }
        cVar.r();
    }
}
