package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f39366a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39367b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f39368c = null;

    public static final /* synthetic */ Throwable a(Throwable r2, d.c.b.a.e r3) {
        return b(r2, (d.c.b.a.e) ZeusTransformUtils.wrapperContextForParams(r3, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    }

    static {
        Object r0 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        Object r1 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        f39366a = new a.a().a();
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r4 = d.n.f(ZeusTransformUtils.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl", "com.obric.aiagent.plugin").getCanonicalName());     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r4) != null) goto L10;
        r1 = r4;
    L10:
        f39367b = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L13
        Object r5 = d.n.f(ZeusTransformUtils.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt", "com.obric.aiagent.plugin").getCanonicalName());     // Catch: Throwable -> L13
    L16:
        if (d.n.c(r5) != null) goto L18;
        r0 = r5;
    L18:
        f39368c = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        return;
    L13:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
    L5:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    public static final <E extends Throwable> E a(E r1) {
        if (kotlinx.coroutines.aq.c() == true) goto L5;
        return r1;
    L5:
        Throwable r0 = p.a(r1);
        if (r0 != null) goto L9;
        return r1;
    L9:
        return (E) c(r0);
    }

    private static final <E extends Throwable> E c(E r7) {
        StackTraceElement[] r0 = r7.getStackTrace();
        int r1 = r0.length;
        int r2 = r0.length - 1;
        if (r2 < 0) goto L10;
    L4:
        int r4 = r2 - 1;
        if (d.h.b.o.a(f39368c, r0[r2].getClassName()) == true) goto L11;
        if (r4 < 0) goto L10;
        r2 = r4;
    L11:
        int r5 = r2 + 1;
        int r6 = a(r0, f39367b);
        int r8 = 0;
        if (r6 != (-1)) goto L14;
        int r3 = 0;
    L15:
        int r9 = (r1 - r2) - r3;
        StackTraceElement[] r10 = new StackTraceElement[r9];
    L16:
        if (r8 >= r9) goto L21;
        if (r8 != 0) goto L19;
        StackTraceElement r11 = f39366a;
    L20:
        r10[r8] = r11;
        r8 = r8 + 1;
        goto L16
    L19:
        r11 = r0[(r5 + r8) - 1];
        goto L20
    L21:
        r7.setStackTrace(r10);
        return r7;
    L14:
        r3 = r1 - r6;
    L10:
        r2 = -1;
        goto L11
    }

    private static final <E extends Throwable> E b(E r4, d.c.b.a.e r5) {
        d.c.b.a.e r6 = (d.c.b.a.e) ZeusTransformUtils.wrapperContextForParams(r5, d.c.b.a.e.class, "com.obric.aiagent.plugin");
        d.m r0 = d(r4);
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(r0.c(), Throwable.class, "com.obric.aiagent.plugin");
        StackTraceElement[] r1 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r0.d(), StackTraceElement[].class, "com.obric.aiagent.plugin");
        Throwable r3 = p.a(r2);
        if (r3 != null) goto L5;
        return r4;
    L5:
        ArrayDeque<StackTraceElement> r7 = a(r6);
        if (r7.isEmpty() == false) goto L8;
        return r4;
    L8:
        if (r2 == r4) goto L11;
        a(r1, r7);
    L11:
        return (E) a(r2, r3, r7);
    }

    private static final <E extends Throwable> E a(E r6, E r7, ArrayDeque<StackTraceElement> r8) {
        r8.addFirst(f39366a);
        StackTraceElement[] r9 = r6.getStackTrace();
        int r0 = a(r9, f39367b);
        int r2 = 0;
        if (r0 != (-1)) goto L6;
        r7.setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).toArray(new StackTraceElement[0]), StackTraceElement[].class, "com.obric.aiagent.plugin"));
        return r7;
    L6:
        StackTraceElement[] r3 = new StackTraceElement[r8.size() + r0];
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L9;
        r3[r4] = r9[r4];
        r4 = r4 + 1;
        goto L7
    L9:
        Iterator<StackTraceElement> r10 = r8.iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        int r11 = r2 + 1;
        r3[r2 + r0] = (StackTraceElement) ZeusTransformUtils.preCheckCast(r10.next(), StackTraceElement.class, "com.obric.aiagent.plugin");
        r2 = r11;
        goto L11
    L13:
        r7.setStackTrace(r3);
        return r7;
    }

    private static final <E extends Throwable> d.m<E, StackTraceElement[]> d(E r6) {
        Throwable r0 = r6.getCause();
        if (r0 == null) goto L17;
        if (d.h.b.o.a(r0.getClass(), r6.getClass()) == false) goto L17;
        StackTraceElement[] r2 = r6.getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        if (a(r2[r4]) == true) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L21;
        return d.s.a(r0, r2);
    L21:
        return d.s.a(r6, new StackTraceElement[0]);
    L12:
        r5 = false;
    L17:
        return d.s.a(r6, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E b(E r6) {
        E r0 = (E) r6.getCause();
        if (r0 != null) goto L5;
    L15:
        return r6;
    L5:
        if (d.h.b.o.a(r0.getClass(), r6.getClass()) == false) goto L15;
        StackTraceElement[] r1 = r6.getStackTrace();
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L13;
        if (a(r1[r4]) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r3 = true;
    L13:
        if (r3 == false) goto L15;
        return r0;
    }

    private static final ArrayDeque<StackTraceElement> a(d.c.b.a.e r2) {
        d.c.b.a.e r3 = (d.c.b.a.e) ZeusTransformUtils.wrapperContextForParams(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
        ArrayDeque<StackTraceElement> r0 = new ArrayDeque();
        StackTraceElement r1 = r3.getStackTraceElement();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (ZeusTransformUtils.instanceOf(r3, d.c.b.a.e.class) == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L16;
        r3 = r3.getCallerFrame();
        if (r3 == null) goto L16;
        StackTraceElement r4 = r3.getStackTraceElement();
        if (r4 == null) goto L6;
        r0.add(r4);
    L16:
        return r0;
    }

    public static final boolean a(StackTraceElement r4) {
        return d.o.o.b(r4.getClassName(), a.b.a(), false, 2, null);
    }

    private static final boolean a(StackTraceElement r2, StackTraceElement r3) {
        if (r2.getLineNumber() == r3.getLineNumber()) goto L5;
    L11:
        return false;
    L5:
        if (d.h.b.o.a(r2.getMethodName(), r3.getMethodName()) == false) goto L11;
        if (d.h.b.o.a(r2.getFileName(), r3.getFileName()) == false) goto L11;
        if (d.h.b.o.a(r2.getClassName(), r3.getClassName()) == false) goto L11;
        return true;
    }

    private static final void a(StackTraceElement[] r6, ArrayDeque<StackTraceElement> r7) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (a(r6[r1]) == true) goto L9;
        r1 = r1 + 1;
    L9:
        int r2 = r1 + 1;
        int r3 = r6.length - 1;
        if (r2 <= r3) goto L12;
        return;
    L12:
        if (a(r6[r3], (StackTraceElement) ZeusTransformUtils.preCheckCast(r7.getLast(), StackTraceElement.class, "com.obric.aiagent.plugin")) == false) goto L14;
        r7.removeLast();
    L14:
        r7.addFirst(r6[r3]);
        if (r3 == r2) goto L21;
        r3 = r3 - 1;
        goto L12
    L21:
        return;
    L8:
        r1 = -1;
        goto L9
    }

    private static final int a(StackTraceElement[] r3, String r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (d.h.b.o.a(r4, r3[r1].getClassName()) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }
}
