package J1;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final L1.a f3694a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f3695b;

    /* renamed from: c, reason: collision with root package name */
    public Enum[] f3696c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f3697d;

    public d(Class<?> cls, L1.a aVar, int i10) {
        this.f3695b = cls;
        this.f3694a = aVar;
        if (aVar == null) {
            return;
        }
        Class<?> cls2 = aVar.f4267g;
        if (cls2.isEnum()) {
            Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
            int length = enumArr.length;
            long[] jArr = new long[length];
            this.f3697d = new long[enumArr.length];
            for (int i11 = 0; i11 < enumArr.length; i11++) {
                long jCharAt = -2128831035;
                for (int i12 = 0; i12 < enumArr[i11].name().length(); i12++) {
                    jCharAt = (jCharAt ^ r2.charAt(i12)) * 16777619;
                }
                jArr[i11] = jCharAt;
                this.f3697d[i11] = jCharAt;
            }
            Arrays.sort(this.f3697d);
            this.f3696c = new Enum[enumArr.length];
            for (int i13 = 0; i13 < this.f3697d.length; i13++) {
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    if (this.f3697d[i13] == jArr[i14]) {
                        this.f3696c[i13] = enumArr[i14];
                        break;
                    }
                    i14++;
                }
            }
        }
    }

    public Enum a(long j10) {
        int iBinarySearch;
        if (this.f3696c == null || (iBinarySearch = Arrays.binarySearch(this.f3697d, j10)) == -1) {
            return null;
        }
        return this.f3696c[iBinarySearch];
    }

    public abstract void b(I1.b bVar, Object obj, Type type, Map<String, Object> map);

    public void c(Object obj, double d10) throws IllegalAccessException, IllegalArgumentException {
        this.f3694a.f4263c.setDouble(obj, d10);
    }

    public void d(Object obj, float f10) throws IllegalAccessException, IllegalArgumentException {
        this.f3694a.f4263c.setFloat(obj, f10);
    }

    public void e(Object obj, int i10) throws IllegalAccessException, IllegalArgumentException {
        this.f3694a.f4263c.setInt(obj, i10);
    }

    public void f(Object obj, long j10) throws IllegalAccessException, IllegalArgumentException {
        this.f3694a.f4263c.setLong(obj, j10);
    }

    public void g(Object obj, Object obj2) {
        if (obj2 == null && this.f3694a.f4267g.isPrimitive()) {
            return;
        }
        L1.a aVar = this.f3694a;
        Field field = aVar.f4263c;
        Method method = aVar.f4262b;
        try {
            if (aVar.f4264d) {
                if (!aVar.f4270j) {
                    field.set(obj, obj2);
                    return;
                }
                if (Map.class.isAssignableFrom(aVar.f4267g)) {
                    Map map = (Map) field.get(obj);
                    if (map != null) {
                        map.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                Collection collection = (Collection) field.get(obj);
                if (collection != null) {
                    collection.addAll((Collection) obj2);
                    return;
                }
                return;
            }
            if (!aVar.f4270j) {
                method.invoke(obj, obj2);
                return;
            }
            if (Map.class.isAssignableFrom(aVar.f4267g)) {
                Map map2 = (Map) method.invoke(obj, null);
                if (map2 != null) {
                    map2.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection2 = (Collection) method.invoke(obj, null);
            if (collection2 != null) {
                collection2.addAll((Collection) obj2);
            }
        } catch (Exception e10) {
            throw new JSONException("set property error, " + this.f3694a.f4261a, e10);
        }
    }
}
