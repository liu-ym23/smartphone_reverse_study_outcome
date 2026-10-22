package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class j {
    public static final <T> T[] a(T[] r1, int r2) {
        d.h.b.o.e(r1, "reference");
        Object r3 = Array.newInstance(r1.getClass().getComponentType(), r2);
        d.h.b.o.a(r3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"));
    }

    public static final void a(int r3, int r4) {
        if (r3 > r4) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException("toIndex (" + r3 + ") is greater than size (" + r4 + ").");
    }
}
