package g5;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.u;
import d5.v;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements v {

    /* renamed from: a, reason: collision with root package name */
    public final f5.a f8969a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<E> extends u<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        public final o f8970a;

        /* renamed from: b, reason: collision with root package name */
        public final f5.g<? extends Collection<E>> f8971b;

        public a(d5.i iVar, Type type, u<E> uVar, f5.g<? extends Collection<E>> gVar) {
            this.f8970a = new o(iVar, uVar, type);
            this.f8971b = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d5.u
        public final Object a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            Collection<E> collectionC = this.f8971b.c();
            aVar.a();
            while (aVar.x0()) {
                collectionC.add(this.f8970a.f9033b.a(aVar));
            }
            aVar.K();
            return collectionC;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                bVar.c0();
                return;
            }
            bVar.o();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f8970a.b(bVar, it.next());
            }
            bVar.K();
        }
    }

    public b(f5.a aVar) {
        this.f8969a = aVar;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        b1.j(Collection.class.isAssignableFrom(rawType));
        Type typeH = C$Gson$Types.h(type, rawType, C$Gson$Types.e(type, rawType, Collection.class), new HashMap());
        Class cls = typeH instanceof ParameterizedType ? ((ParameterizedType) typeH).getActualTypeArguments()[0] : Object.class;
        return new a(iVar, cls, iVar.e(TypeToken.get(cls)), this.f8969a.b(typeToken));
    }
}
