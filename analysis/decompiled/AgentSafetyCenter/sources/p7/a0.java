package p7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends x {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f9828e;

    /* renamed from: b, reason: collision with root package name */
    public Constructor f9829b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f9830c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f9831d;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        f9828e = map;
    }

    @Override // p7.x
    public final Object a() {
        return (Object[]) this.f9830c.clone();
    }

    @Override // p7.x
    public final Object b(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f9829b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e10) {
            ac.a aVar = r7.c.f10473a;
            od.f.g("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
            return null;
        } catch (IllegalArgumentException | InstantiationException e11) {
            throw new RuntimeException("Failed to invoke constructor '" + r7.c.b(constructor) + "' with args " + Arrays.toString(objArr), e11);
        } catch (InvocationTargetException e12) {
            od.f.g("Failed to invoke constructor '" + r7.c.b(constructor) + "' with args " + Arrays.toString(objArr), e12.getCause());
            return null;
        }
    }

    @Override // p7.x
    public final void c(Object obj, u7.a aVar, w wVar) {
        Object[] objArr = (Object[]) obj;
        HashMap map = this.f9831d;
        String str = wVar.f9906c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            g5.f.i("Could not find the index in the constructor '", r7.c.b(this.f9829b), "' for field with name '", str, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
            return;
        }
        int iIntValue = num.intValue();
        Object obj2 = wVar.f9909f.read(aVar);
        if (obj2 != null || !wVar.f9910g) {
            objArr[iIntValue] = obj2;
        } else {
            StringBuilder sbO = androidx.activity.b.o("null is not allowed as value for record component '", str, "' of primitive type; at path ");
            sbO.append(aVar.A());
            throw new m7.k(sbO.toString());
        }
    }
}
