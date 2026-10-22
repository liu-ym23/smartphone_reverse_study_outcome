package B9;

import java.util.Iterator;

/* renamed from: B9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0174a implements x9.b {
    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(int i, Object obj);

    public abstract Iterator d(Object obj);

    public Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return f(decoder);
    }

    public abstract int e(Object obj);

    public final Object f(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        Object objA = a();
        int iB = b(objA);
        A9.c cVarBeginStructure = decoder.beginStructure(getDescriptor());
        if (!cVarBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                h(cVarBeginStructure, iDecodeElementIndex + iB, objA);
            }
        } else {
            int iDecodeCollectionSize = cVarBeginStructure.decodeCollectionSize(getDescriptor());
            c(iDecodeCollectionSize, objA);
            g(cVarBeginStructure, objA, iB, iDecodeCollectionSize);
        }
        cVarBeginStructure.endStructure(getDescriptor());
        return j(objA);
    }

    public abstract void g(A9.c cVar, Object obj, int i, int i6);

    public abstract void h(A9.c cVar, int i, Object obj);

    public abstract Object i(Object obj);

    public abstract Object j(Object obj);
}
