package C1;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public abstract class m {

    static class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f596a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f597b;

        a(Method method, Object obj) {
            this.f596a = method;
            this.f597b = obj;
        }

        @Override // C1.m
        public <T> T c(Class<T> cls) {
            m.a(cls);
            return (T) this.f596a.invoke(this.f597b, cls);
        }
    }

    static class b extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f599b;

        b(Method method, int i5) {
            this.f598a = method;
            this.f599b = i5;
        }

        @Override // C1.m
        public <T> T c(Class<T> cls) {
            m.a(cls);
            return (T) this.f598a.invoke(null, cls, Integer.valueOf(this.f599b));
        }
    }

    static class c extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f600a;

        c(Method method) {
            this.f600a = method;
        }

        @Override // C1.m
        public <T> T c(Class<T> cls) {
            m.a(cls);
            return (T) this.f600a.invoke(null, cls, Object.class);
        }
    }

    static class d extends m {
        d() {
        }

        @Override // C1.m
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static m b() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, iIntValue);
        }
    }

    public abstract <T> T c(Class<T> cls);
}
