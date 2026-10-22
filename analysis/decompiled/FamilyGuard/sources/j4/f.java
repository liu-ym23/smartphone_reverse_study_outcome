package j4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Object[] f17827a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        k.g(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return f17827a;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return f17827a;
        }
        Object[] objArrCopyOf = new Object[size];
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            objArrCopyOf[i5] = it.next();
            if (i6 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i7 = ((i6 * 3) + 1) >>> 1;
                if (i7 <= i6) {
                    i7 = 2147483645;
                    if (i6 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i7);
                k.f(objArrCopyOf, "copyOf(...)");
            } else if (!it.hasNext()) {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i6);
                k.f(objArrCopyOf2, "copyOf(...)");
                return objArrCopyOf2;
            }
            i5 = i6;
        }
    }

    public static final Object[] b(Collection<?> collection, Object[] objArr) throws NegativeArraySizeException {
        Object[] objArrCopyOf;
        k.g(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i5 = 0;
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    k.e(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i6 = i5 + 1;
                    objArrCopyOf[i5] = it.next();
                    if (i6 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i7 = ((i6 * 3) + 1) >>> 1;
                        if (i7 <= i6) {
                            i7 = 2147483645;
                            if (i6 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i7);
                        k.f(objArrCopyOf, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i6] = null;
                            return objArr;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i6);
                        k.f(objArrCopyOf2, "copyOf(...)");
                        return objArrCopyOf2;
                    }
                    i5 = i6;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }
}
