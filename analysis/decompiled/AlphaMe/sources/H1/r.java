package H1;

import androidx.fragment.app.A;
import com.google.gson.stream.JsonReader;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class r extends p {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f752e;

    /* renamed from: b, reason: collision with root package name */
    public final Constructor f753b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f754c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f755d;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(Property.DEFAULT_FLOAT_VALUE));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        f752e = map;
    }

    public r(Class cls, LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
        this.f755d = new HashMap();
        AbstractC0557a abstractC0557a = J1.c.f880a;
        Constructor constructorV = abstractC0557a.v(cls);
        this.f753b = constructorV;
        J1.c.e(constructorV);
        String[] strArrA = abstractC0557a.A(cls);
        for (int i4 = 0; i4 < strArrA.length; i4++) {
            this.f755d.put(strArrA[i4], Integer.valueOf(i4));
        }
        Class<?>[] parameterTypes = this.f753b.getParameterTypes();
        this.f754c = new Object[parameterTypes.length];
        for (int i5 = 0; i5 < parameterTypes.length; i5++) {
            this.f754c[i5] = f752e.get(parameterTypes[i5]);
        }
    }

    @Override // H1.p
    public final Object d() {
        return (Object[]) this.f754c.clone();
    }

    @Override // H1.p
    public final Object e(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f753b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e4) {
            AbstractC0557a abstractC0557a = J1.c.f880a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        } catch (IllegalArgumentException | InstantiationException e5) {
            throw new RuntimeException("Failed to invoke constructor '" + J1.c.b(constructor) + "' with args " + Arrays.toString(objArr), e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("Failed to invoke constructor '" + J1.c.b(constructor) + "' with args " + Arrays.toString(objArr), e6.getCause());
        }
    }

    @Override // H1.p
    public final void f(Object obj, JsonReader jsonReader, o oVar) {
        Object[] objArr = (Object[]) obj;
        HashMap map = this.f755d;
        String str = oVar.f739c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            throw new IllegalStateException("Could not find the index in the constructor '" + J1.c.b(this.f753b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
        int iIntValue = num.intValue();
        Object objB = oVar.f745i.b(jsonReader);
        if (objB != null || !oVar.f748l) {
            objArr[iIntValue] = objB;
        } else {
            StringBuilder sbW = B0.g.w("null is not allowed as value for record component '", str, "' of primitive type; at path ");
            sbW.append(jsonReader.getPath());
            throw new A(sbW.toString(), 5);
        }
    }
}
