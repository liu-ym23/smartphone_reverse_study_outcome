package kotlin.collections;

import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k {
    public static final Object[] a(Object[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, TypedValues.Custom.S_REFERENCE);
        Object r12 = Array.newInstance(r10.getClass().getComponentType(), r11);
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) r12;
    }

    public static final void b(int r10, int r11) {
        if (r10 > r11) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException("toIndex (" + r10 + ") is greater than size (" + r11 + ").");
    }
}
