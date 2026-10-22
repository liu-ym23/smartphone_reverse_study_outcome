package p0;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import o0.C0888a;
import u0.C1154d;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public final C1154d f19303a;

    /* renamed from: b, reason: collision with root package name */
    protected final Class<?> f19304b;

    public l(Class<?> cls, C1154d c1154d) {
        this.f19304b = cls;
        this.f19303a = c1154d;
    }

    private static boolean a(Field field, Method method, Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (e(field, obj, obj2)) {
            return true;
        }
        try {
            obj.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(obj, obj2);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    private static boolean e(Field field, Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        if (field == null || Modifier.isFinal(field.getModifiers())) {
            return false;
        }
        field.set(obj, obj2);
        return true;
    }

    public int b() {
        return 0;
    }

    public Class<?> c() {
        return this.f19304b;
    }

    public abstract void d(C0888a c0888a, Object obj, Type type, Map<String, Object> map);

    public void f(Object obj, int i5) {
        h(obj, Integer.valueOf(i5));
    }

    public void g(Object obj, long j5) {
        h(obj, Long.valueOf(j5));
    }

    public void h(Object obj, Object obj2) {
        C1154d c1154d;
        Method method;
        String str;
        if (obj2 == null && this.f19303a.f22734e.isPrimitive()) {
            return;
        }
        C1154d c1154d2 = this.f19303a;
        if (c1154d2.f22734e == String.class && (str = c1154d2.f22749t) != null && str.equals("trim")) {
            obj2 = ((String) obj2).trim();
        }
        try {
            c1154d = this.f19303a;
            method = c1154d.f22731b;
        } catch (Exception e6) {
            throw new l0.d("set property error, " + this.f19304b.getName() + "#" + this.f19303a.f22730a, e6);
        }
        if (method == null) {
            Field field = c1154d.f22732c;
            if (!c1154d.f22737h) {
                if (field != null) {
                    field.set(obj, obj2);
                    return;
                }
                return;
            }
            Class<?> cls = c1154d.f22734e;
            if (cls == AtomicInteger.class) {
                AtomicInteger atomicInteger = (AtomicInteger) field.get(obj);
                if (atomicInteger != null) {
                    atomicInteger.set(((AtomicInteger) obj2).get());
                    return;
                }
                return;
            }
            if (cls == AtomicLong.class) {
                AtomicLong atomicLong = (AtomicLong) field.get(obj);
                if (atomicLong != null) {
                    atomicLong.set(((AtomicLong) obj2).get());
                    return;
                }
                return;
            }
            if (cls == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean = (AtomicBoolean) field.get(obj);
                if (atomicBoolean != null) {
                    atomicBoolean.set(((AtomicBoolean) obj2).get());
                    return;
                }
                return;
            }
            if (Map.class.isAssignableFrom(cls)) {
                Map map = (Map) field.get(obj);
                if (map != null && map != Collections.EMPTY_MAP && !map.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    map.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection = (Collection) field.get(obj);
            if (collection != null && obj2 != null && collection != Collections.EMPTY_SET && collection != Collections.EMPTY_LIST && !collection.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                collection.clear();
                collection.addAll((Collection) obj2);
                return;
            }
            return;
        }
        if (!c1154d.f22737h) {
            method.invoke(obj, obj2);
            return;
        }
        Class<?> cls2 = c1154d.f22734e;
        if (cls2 == AtomicInteger.class) {
            AtomicInteger atomicInteger2 = (AtomicInteger) method.invoke(obj, null);
            if (atomicInteger2 != null) {
                atomicInteger2.set(((AtomicInteger) obj2).get());
                return;
            } else {
                a(this.f19303a.f22732c, method, obj, obj2);
                return;
            }
        }
        if (cls2 == AtomicLong.class) {
            AtomicLong atomicLong2 = (AtomicLong) method.invoke(obj, null);
            if (atomicLong2 != null) {
                atomicLong2.set(((AtomicLong) obj2).get());
                return;
            } else {
                a(this.f19303a.f22732c, method, obj, obj2);
                return;
            }
        }
        if (cls2 == AtomicBoolean.class) {
            AtomicBoolean atomicBoolean2 = (AtomicBoolean) method.invoke(obj, null);
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(((AtomicBoolean) obj2).get());
                return;
            } else {
                a(this.f19303a.f22732c, method, obj, obj2);
                return;
            }
        }
        if (Map.class.isAssignableFrom(method.getReturnType())) {
            try {
                Map map2 = (Map) method.invoke(obj, null);
                if (map2 == null) {
                    if (obj2 != null) {
                        a(this.f19303a.f22732c, method, obj, obj2);
                        return;
                    }
                    return;
                } else {
                    if (map2 == Collections.EMPTY_MAP) {
                        return;
                    }
                    if (map2.isEmpty() && ((Map) obj2).isEmpty()) {
                        return;
                    }
                    String name = map2.getClass().getName();
                    if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN") && !name.startsWith("java.util.Collections$Unmodifiable")) {
                        if (map2.getClass().getName().equals("W3.A")) {
                            a(this.f19303a.f22732c, method, obj, obj2);
                            return;
                        } else {
                            map2.putAll((Map) obj2);
                            return;
                        }
                    }
                    return;
                }
            } catch (InvocationTargetException unused) {
                a(this.f19303a.f22732c, method, obj, obj2);
                return;
            }
        }
        try {
            Collection collection2 = (Collection) method.invoke(obj, null);
            if (collection2 == null || obj2 == null) {
                if (collection2 != null || obj2 == null) {
                    return;
                }
                a(this.f19303a.f22732c, method, obj, obj2);
                return;
            }
            String name2 = collection2.getClass().getName();
            if (collection2 != Collections.EMPTY_SET && collection2 != Collections.EMPTY_LIST && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12" && !name2.startsWith("java.util.Collections$Unmodifiable")) {
                if (!collection2.isEmpty()) {
                    collection2.clear();
                } else if (((Collection) obj2).isEmpty()) {
                    return;
                }
                if (!name2.equals("W3.z") && !name2.equals("W3.B")) {
                    collection2.addAll((Collection) obj2);
                    return;
                }
                a(this.f19303a.f22732c, method, obj, obj2);
                return;
            }
            return;
        } catch (InvocationTargetException unused2) {
            a(this.f19303a.f22732c, method, obj, obj2);
            return;
        }
        throw new l0.d("set property error, " + this.f19304b.getName() + "#" + this.f19303a.f22730a, e6);
    }

    public void i(Object obj, String str) {
        h(obj, str);
    }

    public void j(Object obj, boolean z5) {
        h(obj, Boolean.valueOf(z5));
    }
}
