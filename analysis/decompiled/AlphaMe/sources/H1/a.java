package H1;

import F1.A;
import F1.B;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public final class a implements B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f706a;

    @Override // F1.B
    public final A a(F1.n nVar, TypeToken typeToken) {
        switch (this.f706a) {
            case 0:
                Type type = typeToken.getType();
                boolean z4 = type instanceof GenericArrayType;
                if (!z4 && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                Type genericComponentType = z4 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
                return new b(nVar, nVar.e(TypeToken.get(genericComponentType)), G1.d.e(genericComponentType));
            case 1:
                if (typeToken.getRawType() == Date.class) {
                    return new e();
                }
                return null;
            case 2:
                Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new u(rawType);
            case 3:
                if (typeToken.getRawType() == java.sql.Date.class) {
                    return new K1.a();
                }
                return null;
            case 4:
                if (typeToken.getRawType() == Time.class) {
                    return new K1.b();
                }
                return null;
            default:
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                nVar.getClass();
                return new K1.c(nVar.e(TypeToken.get(Date.class)));
        }
    }
}
