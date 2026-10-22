package p7;

import java.lang.invoke.VarHandle;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class i implements m7.o {
    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) throws SecurityException {
        Class rawType = aVar.getRawType();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        j jVar = new j();
        HashMap map = new HashMap();
        jVar.f9874a = map;
        jVar.f9875b = new HashMap();
        jVar.f9876c = new HashMap();
        try {
            Field[] declaredFields = rawType.getDeclaredFields();
            int i = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i] = field;
                    i++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r52 = (Enum) field2.get(null);
                String strName = r52.name();
                String string = r52.toString();
                n7.b bVar = (n7.b) field2.getAnnotation(n7.b.class);
                if (bVar != null) {
                    strName = bVar.value();
                    for (String str : bVar.alternate()) {
                        map.put(str, r52);
                    }
                }
                map.put(strName, r52);
                jVar.f9875b.put(string, r52);
                jVar.f9876c.put(r52, strName);
            }
            VarHandle.storeStoreFence();
            return jVar;
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        }
    }
}
