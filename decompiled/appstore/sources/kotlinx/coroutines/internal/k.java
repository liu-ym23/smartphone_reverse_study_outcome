package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k {
    public static Object a(Object r10) {
        return r10;
    }

    public static /* synthetic */ Object b(Object r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return a(r10);
    }

    public static final Object c(Object r10, Object r11) {
        if (r10 != null) goto L5;
        return a(r11);
    L5:
        if ((r10 instanceof ArrayList) == false) goto L7;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ((ArrayList) r10).add(r11);
        return a(r10);
    L7:
        ArrayList r12 = new ArrayList(4);
        r12.add(r10);
        r12.add(r11);
        return a(r12);
    }
}
