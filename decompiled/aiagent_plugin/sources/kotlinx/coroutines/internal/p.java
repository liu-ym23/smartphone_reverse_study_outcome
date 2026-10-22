package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f39404a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f39405b = null;

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    static final class a extends d.h.b.p implements d.h.a.b<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f39406a;

        a(Constructor<?> r1) {
            this.f39406a = r1;
            super(1);
        }

        public final Throwable a(Throwable r4) {
            Object r3 = this.f39406a.newInstance(new Object[]{r4.getMessage(), r4});
            d.h.b.o.a(r3, "null cannot be cast to non-null type kotlin.Throwable");
            return (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Throwable invoke(Throwable r3) {
            return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    static final class b extends d.h.b.p implements d.h.a.b<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f39407a;

        b(Constructor<?> r1) {
            this.f39407a = r1;
            super(1);
        }

        public final Throwable a(Throwable r4) {
            Object r3 = this.f39407a.newInstance(new Object[]{r4.getMessage()});
            d.h.b.o.a(r3, "null cannot be cast to non-null type kotlin.Throwable");
            Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin");
            r5.initCause(r4);
            return r5;
        }

        @Override // d.h.a.b
        public /* synthetic */ Throwable invoke(Throwable r3) {
            return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    static final class c extends d.h.b.p implements d.h.a.b<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f39408a;

        c(Constructor<?> r1) {
            this.f39408a = r1;
            super(1);
        }

        public final Throwable a(Throwable r3) {
            Object r2 = this.f39408a.newInstance(new Object[]{r3});
            d.h.b.o.a(r2, "null cannot be cast to non-null type kotlin.Throwable");
            return (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Throwable invoke(Throwable r3) {
            return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    static final class d extends d.h.b.p implements d.h.a.b<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f39409a;

        d(Constructor<?> r1) {
            this.f39409a = r1;
            super(1);
        }

        public final Throwable a(Throwable r3) {
            Object r2 = this.f39409a.newInstance(new Object[0]);
            d.h.b.o.a(r2, "null cannot be cast to non-null type kotlin.Throwable");
            Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
            r4.initCause(r3);
            return r4;
        }

        @Override // d.h.a.b
        public /* synthetic */ Throwable invoke(Throwable r3) {
            return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    static final class e extends d.h.b.p implements d.h.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f39410a = null;

        static {
            f39410a = new e();
        }

        e() {
            super(1);
        }

        public final Void a(Throwable r1) {
            return null;
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(Object r3) {
            return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    static final class f extends d.h.b.p implements d.h.a.b<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Throwable, Throwable> f39411a;

        f(d.h.a.b<? super Throwable, ? extends Throwable> r3) {
            this.f39411a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Throwable invoke(Throwable r3) {
            return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }

        public final Throwable a(Throwable r5) {
            d.h.a.b<Throwable, Throwable> r4 = this.f39411a;
            Object r1 = null;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L10
            Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r4.invoke(r5), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            if (d.h.b.o.a(r5.getMessage(), r6.getMessage()) == false) goto L6;
        L8:
            Object r7 = d.n.f(r6);     // Catch: Throwable -> L10
        L13:
            if (d.n.b(r7) == true) goto L17;
            r1 = r7;
        L17:
            return (Throwable) ZeusTransformUtils.preCheckCast(r1, Throwable.class, "com.obric.aiagent.plugin");
        L6:
            if (d.h.b.o.a(r6.getMessage(), r5.toString()) == true) goto L8;
            r6 = null;
        L10:
            th = move-exception;
            d.n.a r8 = d.n.f38560a;
            r7 = d.n.f(d.o.a(th));
            goto L13
        }
    }

    public static final /* synthetic */ d.h.a.b a(Class r0) {
        return b(r0);
    }

    static {
        f39404a = a(Throwable.class, -1);
    L8:
        k r1 = (k) ZeusTransformUtils.preCheckCast(av.f39384a, k.class, "com.obric.aiagent.plugin");
    L9:
        f39405b = r1;
        return;
    L4:
        if (r.a() == false) goto L6;
        r1 = (k) ZeusTransformUtils.preCheckCast(av.f39384a, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L11:
        goto L9
    L6:
        r1 = (k) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.internal.c.f39388a, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E a(E r3) {
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.ag.class) == false) goto L14;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L6
        Object r4 = d.n.f(((kotlinx.coroutines.ag) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.ag.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L6
    L9:
        if (d.n.b(r4) == false) goto L12;
        r4 = null;
    L12:
        return (E) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin");
    L6:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L9
    L14:
        return (E) ZeusTransformUtils.preCheckCast(f39405b.a(r3.getClass()).invoke(r3), Throwable.class, "com.obric.aiagent.plugin");
    }

    private static final <E extends Throwable> d.h.a.b<Throwable, Throwable> b(Class<E> r13) {
        d.h.a.b<Throwable, Throwable> r0 = (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f39410a, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (f39404a == a(r13, 0)) goto L5;
        return r0;
    L5:
        Constructor<?>[] r14 = r13.getConstructors();
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length), Collection.class, "com.obric.aiagent.plugin");
        int r4 = r14.length;
        int r5 = 0;
    L6:
        Object r6 = null;
        if (r5 >= r4) goto L29;
        Constructor<?> r7 = r14[r5];
        Class<?>[] r8 = r7.getParameterTypes();
        int r9 = r8.length;
        if (r9 != 0) goto L11;
        d.m r10 = d.s.a(a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r7), d.h.a.b.class, "com.obric.aiagent.plugin")), 0);
    L28:
        r1.add(r10);
        r5 = r5 + 1;
        goto L6
    L11:
        if (r9 == 1) goto L20;
        if (r9 == 2) goto L15;
        r10 = d.s.a(null, -1);
        goto L28
    L15:
        if (d.h.b.o.a(r8[0], String.class) == true) goto L17;
    L19:
        r10 = d.s.a(null, -1);
        goto L28
    L17:
        if (d.h.b.o.a(r8[1], Throwable.class) == false) goto L19;
        r10 = d.s.a(a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r7), d.h.a.b.class, "com.obric.aiagent.plugin")), 3);
        goto L28
    L20:
        Class<?> r11 = r8[0];
        if (d.h.b.o.a(r11, String.class) == false) goto L24;
        r10 = d.s.a(a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r7), d.h.a.b.class, "com.obric.aiagent.plugin")), 2);
        goto L28
    L24:
        if (d.h.b.o.a(r11, Throwable.class) == false) goto L26;
        r10 = d.s.a(a((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r7), d.h.a.b.class, "com.obric.aiagent.plugin")), 1);
        goto L28
    L26:
        r10 = d.s.a(null, -1);
        goto L28
    L29:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r15.hasNext() == false) goto L41;
        r6 = r15.next();
        if (r15.hasNext() == false) goto L41;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r6, d.m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L36:
        Object r3 = r15.next();
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin")).b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r2 >= r12) goto L40;
        r6 = r3;
        r2 = r12;
    L40:
        if (r15.hasNext() == true) goto L36;
    L41:
        d.m r16 = (d.m) ZeusTransformUtils.preCheckCast(r6, d.m.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L58;
        d.h.a.b<Throwable, Throwable> r17 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r16.a(), d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L47;
        return r0;
    L47:
        return r17;
    L58:
        return r0;
    }

    private static final d.h.a.b<Throwable, Throwable> a(d.h.a.b<? super Throwable, ? extends Throwable> r2) {
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new f((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    private static final int a(Class<?> r3, int r4) {
        d.h.a.a(r3);
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(Integer.valueOf(a(r3, 0, 1, null)));     // Catch: Throwable -> L5
    L7:
        Integer r6 = Integer.valueOf(r4);
        if (d.n.b(r5) == false) goto L11;
        r5 = r6;
    L11:
        return ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    static /* synthetic */ int a(Class r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return b(r0, r1);
    }

    private static final int b(Class<?> r5, int r6) {
    L2:
        Field[] r0 = r5.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if ((!Modifier.isStatic(r0[r2].getModifiers())) == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r6 = r6 + r3;
        r5 = r5.getSuperclass();
        if (r5 != null) goto L2;
        return r6;
    }
}
