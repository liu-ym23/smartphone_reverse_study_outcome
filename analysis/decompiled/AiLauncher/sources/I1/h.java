package I1;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h implements J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final h f3321a = new h();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // J1.f
    public <T> T b(b bVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (T) bVar.U(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        bVar.V(genericComponentType, arrayList);
        if (!(genericComponentType instanceof Class)) {
            return (T) arrayList.toArray();
        }
        T t10 = (T) ((Object[]) Array.newInstance((Class<?>) genericComponentType, arrayList.size()));
        arrayList.toArray((Object[]) t10);
        return t10;
    }
}
