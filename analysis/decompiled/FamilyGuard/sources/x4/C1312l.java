package x4;

import java.util.ArrayList;

/* renamed from: x4.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1312l<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i5, j4.g gVar) {
        if ((i5 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e6) {
        if (obj == null) {
            return a(e6);
        }
        if (obj instanceof ArrayList) {
            j4.k.e(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e6);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e6);
        return a(arrayList);
    }
}
