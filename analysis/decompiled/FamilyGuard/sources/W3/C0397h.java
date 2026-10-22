package W3;

import java.lang.reflect.Array;

/* renamed from: W3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0397h {
    public static final <T> T[] a(T[] tArr, int i5) throws NegativeArraySizeException {
        j4.k.g(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i5);
        j4.k.e(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void b(int i5, int i6) {
        if (i5 <= i6) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + i6 + ").");
    }
}
