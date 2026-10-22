package H1;

import F1.A;
import F1.B;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import t0.J;

/* loaded from: classes.dex */
public final class d implements B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f713a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.g f714b;

    public /* synthetic */ d(l1.g gVar, int i4) {
        this.f713a = i4;
        this.f714b = gVar;
    }

    public static A b(l1.g gVar, F1.n nVar, TypeToken typeToken, JsonAdapter jsonAdapter) {
        A a4;
        Object objI = gVar.b(TypeToken.get((Class) jsonAdapter.value())).i();
        boolean zNullSafe = jsonAdapter.nullSafe();
        if (objI instanceof A) {
            a4 = (A) objI;
        } else {
            if (!(objI instanceof B)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objI.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            a4 = ((B) objI).a(nVar, typeToken);
        }
        return (a4 == null || !zNullSafe) ? a4 : a4.a();
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        int i4 = this.f713a;
        l1.g gVar = this.f714b;
        switch (i4) {
            case 0:
                Type type = typeToken.getType();
                Class rawType = typeToken.getRawType();
                if (!Collection.class.isAssignableFrom(rawType)) {
                    return null;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                }
                J.j(Collection.class.isAssignableFrom(rawType));
                Type typeF = G1.d.f(type, rawType, G1.d.d(type, rawType, Collection.class), new HashMap());
                Class cls = typeF instanceof ParameterizedType ? ((ParameterizedType) typeF).getActualTypeArguments()[0] : Object.class;
                return new c(nVar, cls, nVar.e(TypeToken.get(cls)), gVar.b(typeToken));
            default:
                JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
                if (jsonAdapter == null) {
                    return null;
                }
                return b(gVar, nVar, typeToken, jsonAdapter);
        }
    }
}
