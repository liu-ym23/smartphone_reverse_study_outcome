package g5;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.u;
import d5.v;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements v {

    /* renamed from: a, reason: collision with root package name */
    public final f5.a f8987a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a<K, V> extends u<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final o f8988a;

        /* renamed from: b, reason: collision with root package name */
        public final o f8989b;

        /* renamed from: c, reason: collision with root package name */
        public final f5.g<? extends Map<K, V>> f8990c;

        public a(f fVar, d5.i iVar, Type type, u<K> uVar, Type type2, u<V> uVar2, f5.g<? extends Map<K, V>> gVar) {
            this.f8988a = new o(iVar, uVar, type);
            this.f8989b = new o(iVar, uVar2, type2);
            this.f8990c = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d5.u
        public final Object a(k5.a aVar) throws IOException {
            JsonToken jsonTokenR0 = aVar.R0();
            if (jsonTokenR0 == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            Map<K, V> mapC = this.f8990c.c();
            if (jsonTokenR0 == JsonToken.f5471a) {
                aVar.a();
                while (aVar.x0()) {
                    aVar.a();
                    Object objA = this.f8988a.f9033b.a(aVar);
                    if (mapC.put(objA, this.f8989b.f9033b.a(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + objA);
                    }
                    aVar.K();
                }
                aVar.K();
                return mapC;
            }
            aVar.o();
            while (aVar.x0()) {
                androidx.datastore.preferences.protobuf.f.f1806a.getClass();
                if (aVar instanceof e) {
                    e eVar = (e) aVar;
                    eVar.b1(JsonToken.f5475e);
                    Map.Entry entry = (Map.Entry) ((Iterator) eVar.f1()).next();
                    eVar.h1(entry.getValue());
                    eVar.h1(new d5.r((String) entry.getKey()));
                } else {
                    int iC = aVar.f9926k;
                    if (iC == 0) {
                        iC = aVar.C();
                    }
                    if (iC == 13) {
                        aVar.f9926k = 9;
                    } else if (iC == 12) {
                        aVar.f9926k = 8;
                    } else {
                        if (iC != 14) {
                            throw aVar.a1("a name");
                        }
                        aVar.f9926k = 10;
                    }
                }
                Object objA2 = this.f8988a.f9033b.a(aVar);
                if (mapC.put(objA2, this.f8989b.f9033b.a(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + objA2);
                }
            }
            aVar.P();
            return mapC;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                bVar.c0();
                return;
            }
            bVar.w();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                bVar.Q(String.valueOf(entry.getKey()));
                this.f8989b.b(bVar, entry.getValue());
            }
            bVar.P();
        }
    }

    public f(f5.a aVar) {
        this.f8987a = aVar;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            if (type instanceof WildcardType) {
                type = ((WildcardType) type).getUpperBounds()[0];
            }
            b1.j(Map.class.isAssignableFrom(rawType));
            Type typeH = C$Gson$Types.h(type, rawType, C$Gson$Types.e(type, rawType, Map.class), new HashMap());
            actualTypeArguments = typeH instanceof ParameterizedType ? ((ParameterizedType) typeH).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        Type[] typeArr = actualTypeArguments;
        return new a(this, iVar, typeArr[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? p.f9037c : iVar.e(TypeToken.get(type2)), typeArr[1], iVar.e(TypeToken.get(actualTypeArguments[1])), this.f8987a.b(typeToken));
    }
}
