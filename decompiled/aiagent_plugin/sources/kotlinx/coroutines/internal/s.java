package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: InlineList.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39414a;

    public static String a(Object r2) {
        return "InlineList(holder=" + r2 + ')';
    }

    public static int b(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static boolean b(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, s.class) == true) goto L6;
        return false;
    L6:
        if (d.h.b.o.a(r3, ((s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.aiagent.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static <E> Object c(Object r0) {
        return r0;
    }

    public final /* synthetic */ Object a() {
        return this.f39414a;
    }

    public boolean equals(Object r1) {
        return b(this.f39414a, r1);
    }

    public int hashCode() {
        return b(this.f39414a);
    }

    public String toString() {
        return a(this.f39414a);
    }

    public static /* synthetic */ Object a(Object r0, int r1, d.h.b.h r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return c(r0);
    }

    public static final Object a(Object r2, E r3) {
        if (kotlinx.coroutines.aq.a() == true) goto L5;
    L9:
        if (r2 != null) goto L12;
        return c(r3);
    L12:
        if (ZeusTransformUtils.instanceOf(r2, ArrayList.class) == false) goto L14;
        d.h.b.o.a(r2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ((ArrayList) ZeusTransformUtils.preCheckCast(r2, ArrayList.class, "com.obric.aiagent.plugin")).add(r3);
        return c(r2);
    L14:
        ArrayList r0 = new ArrayList(4);
        r0.add(r2);
        r0.add(r3);
        return c(r0);
    L5:
        if ((!ZeusTransformUtils.instanceOf(r3, List.class)) == true) goto L9;
        throw new AssertionError();
    }
}
