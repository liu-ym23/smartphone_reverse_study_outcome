package o7;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f9288a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        t tVar;
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(null);
                    Method method = cls.getMethod("allocateInstance", Class.class);
                    q qVar = new q();
                    qVar.f9283b = method;
                    qVar.f9284c = obj;
                    VarHandle.storeStoreFence();
                    tVar = qVar;
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    s sVar = new s();
                    sVar.f9287b = declaredMethod;
                    VarHandle.storeStoreFence();
                    tVar = sVar;
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                r rVar = new r();
                rVar.f9285b = declaredMethod3;
                rVar.f9286c = iIntValue;
                VarHandle.storeStoreFence();
                tVar = rVar;
            }
        } catch (Exception unused3) {
            tVar = new t();
        }
        f9288a = tVar;
    }

    public abstract Object a(Class cls);
}
