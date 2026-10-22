package g5;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.u;
import d5.v;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a<E> extends u<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final C0084a f8966c = new C0084a();

    /* renamed from: a, reason: collision with root package name */
    public final Class<E> f8967a;

    /* renamed from: b, reason: collision with root package name */
    public final o f8968b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: g5.a$a, reason: collision with other inner class name */
    public class C0084a implements v {
        @Override // d5.v
        public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            boolean z = type instanceof GenericArrayType;
            if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type genericComponentType = z ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
            return new a(iVar, iVar.e(TypeToken.get(genericComponentType)), C$Gson$Types.f(genericComponentType));
        }
    }

    public a(d5.i iVar, u<E> uVar, Class<E> cls) {
        this.f8968b = new o(iVar, uVar, cls);
        this.f8967a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d5.u
    public final Object a(k5.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.R0() == JsonToken.f5478l) {
            aVar.N0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.x0()) {
            arrayList.add(this.f8968b.f9033b.a(aVar));
        }
        aVar.K();
        int size = arrayList.size();
        Class<E> cls = this.f8967a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(objNewInstance, i10, arrayList.get(i10));
        }
        return objNewInstance;
    }

    @Override // d5.u
    public final void b(k5.b bVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            bVar.c0();
            return;
        }
        bVar.o();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f8968b.b(bVar, Array.get(obj, i10));
        }
        bVar.K();
    }
}
