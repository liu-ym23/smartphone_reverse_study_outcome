package H1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import t0.J;

/* loaded from: classes.dex */
public final class i implements B {

    /* renamed from: a, reason: collision with root package name */
    public final l1.g f726a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f727b = false;

    public i(l1.g gVar) {
        this.f726a = gVar;
    }

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            if (type instanceof WildcardType) {
                type = ((WildcardType) type).getUpperBounds()[0];
            }
            J.j(Map.class.isAssignableFrom(rawType));
            Type typeF = G1.d.f(type, rawType, G1.d.d(type, rawType, Map.class), new HashMap());
            actualTypeArguments = typeF instanceof ParameterizedType ? ((ParameterizedType) typeF).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new h(this, nVar, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? z.f778c : nVar.e(TypeToken.get(type2)), actualTypeArguments[1], nVar.e(TypeToken.get(actualTypeArguments[1])), this.f726a.b(typeToken));
    }
}
