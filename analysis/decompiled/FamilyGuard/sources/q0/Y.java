package q0;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import o0.C0888a;

/* loaded from: classes.dex */
public class Y implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final Y f19722a = new Y();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        c0946i.G(obj instanceof AtomicReference ? ((AtomicReference) obj).get() : ((Reference) obj).get());
    }

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object objJ0 = c0888a.j0(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return (T) new AtomicReference(objJ0);
        }
        if (rawType == WeakReference.class) {
            return (T) new WeakReference(objJ0);
        }
        if (rawType == SoftReference.class) {
            return (T) new SoftReference(objJ0);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }
}
