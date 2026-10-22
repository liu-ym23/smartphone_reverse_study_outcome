package X;

import androidx.lifecycle.T;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f5768a = new d();

    private d() {
    }

    public final <T extends T> T a(Class<T> cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        j4.k.g(cls, "modelClass");
        try {
            T tNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            j4.k.f(tNewInstance, "{\n            modelClass…).newInstance()\n        }");
            return tNewInstance;
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("Cannot create an instance of " + cls, e8);
        }
    }
}
