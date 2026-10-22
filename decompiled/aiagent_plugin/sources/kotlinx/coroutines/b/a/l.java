package kotlinx.coroutines.b.a;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ai;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dm;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: compiled from: Combine.kt */
    @d.c.b.a.f(b = "Combine.kt", c = {51, ITaskManager.Stub.TRANSACTION_tryActiveAgent, 76}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f38920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f38921d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f38922e;
        final /* synthetic */ kotlinx.coroutines.b.h<T>[] f;
        final /* synthetic */ d.h.a.a<T[]> g;
        final /* synthetic */ d.h.a.q<kotlinx.coroutines.b.i<? super R>, T[], d.c.d<? super d.x>, Object> h;
        final /* synthetic */ kotlinx.coroutines.b.i<R> i;
        private /* synthetic */ Object j;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.a.l$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Combine.kt */
        @d.c.b.a.f(b = "Combine.kt", c = {28}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f38923a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h<T>[] f38924b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f38925c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f38926d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.a.d<ai<Object>> f38927e;

            /* JADX INFO: renamed from: kotlinx.coroutines.b.a.l$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Combine.kt */
            static final class C10491<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.a.d<ai<Object>> f38928a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ int f38929b;

                /* JADX INFO: renamed from: kotlinx.coroutines.b.a.l$a$1$1$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: Combine.kt */
                @d.c.b.a.f(b = "Combine.kt", c = {29, 30}, d = "emit", e = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1")
                static final class C1050a extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f38930a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ C10491<T> f38931b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    int f38932c;

                    /* JADX WARN: Multi-variable type inference failed */
                    C1050a(C10491<? super T> r3, d.c.d<? super C1050a> r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f38931b = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f38930a = r3;
                        this.f38932c |= Integer.MIN_VALUE;
                        return this.f38931b.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                C10491(kotlinx.coroutines.a.d<ai<Object>> r3, int r4) {
                    this.f38928a = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
                    this.f38929b = r4;
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(T r6, d.c.d<? super d.x> r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C1050a.class) == false) goto L7;
                    C1050a r0 = (C1050a) ZeusTransformUtils.preCheckCast(r8, C1050a.class, "com.obric.aiagent.plugin");
                    if ((r0.f38932c & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f38932c -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f38930a;
                    Object r1 = d.c.a.b.a();
                    int r2 = r0.f38932c;
                    if (r2 == 0) goto L16;
                    if (r2 == 1) goto L15;
                    if (r2 != 2) goto L14;
                    d.o.a(r9);
                L23:
                    return d.x.f38692a;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L15:
                    d.o.a(r9);
                L19:
                    r0.f38932c = 2;
                    if (dm.a(r0) != r1) goto L23;
                    return r1;
                L16:
                    d.o.a(r9);
                    kotlinx.coroutines.a.d<ai<Object>> r10 = this.f38928a;
                    ai<Object> r3 = new ai(this.f38929b, r6);
                    r0.f38932c = 1;
                    if (r10.a(r3, r0) != r1) goto L19;
                    return r1;
                L7:
                    r0 = new C1050a(this, r8);
                    goto L8
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(kotlinx.coroutines.b.h<? extends T>[] r3, int r4, AtomicInteger r5, kotlinx.coroutines.a.d<ai<Object>> r6, d.c.d<? super AnonymousClass1> r7) {
                kotlinx.coroutines.a.d<ai<Object>> r8 = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f38924b = r3;
                this.f38925c = r4;
                this.f38926d = r5;
                this.f38927e = r8;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f38924b, this.f38925c, this.f38926d, this.f38927e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f38923a;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                d.o.a(r8);     // Catch: Throwable -> L7
            L15:
                if (this.f38926d.decrementAndGet() != 0) goto L19;
                kotlinx.coroutines.a.t.a.a((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(this.f38927e, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"), null, 1, null);
            L19:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r8);
                kotlinx.coroutines.b.h r9 = this.f38924b[this.f38925c];     // Catch: Throwable -> L7
                kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new C10491(this.f38927e, this.f38925c), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                this.f38923a = 1;     // Catch: Throwable -> L7
                if (r9.collect(r2, r5) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                if (this.f38926d.decrementAndGet() != 0) goto L23;
                kotlinx.coroutines.a.t.a.a((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(this.f38927e, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"), null, 1, null);
            L23:
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.b.h<? extends T>[] r3, d.h.a.a<T[]> r4, d.h.a.q<? super kotlinx.coroutines.b.i<? super R>, ? super T[], ? super d.c.d<? super d.x>, ? extends Object> r5, kotlinx.coroutines.b.i<? super R> r6, d.c.d<? super a> r7) {
            d.h.a.a<T[]> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.q<kotlinx.coroutines.b.i<? super R>, T[], d.c.d<? super d.x>, Object> r9 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.q.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.i<R> r10 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            a r11 = new a(this.f, this.g, this.h, this.i, r7);
            r11.j = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0164 -> B:44:0x018b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0188 -> B:44:0x018b). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r2 = d.c.a.b.a();
            int r3 = this.f38922e;
            int r4 = 0;
            if (r3 == 0) goto L12;
            if (r3 == 1) goto L11;
            if (r3 == 2) goto L10;
            if (r3 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r5 = this.f38921d;
            int r6 = this.f38920c;
            byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(this.f38919b, byte[].class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.a.d r9 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(this.f38918a, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
            Object[] r10 = (Object[]) ZeusTransformUtils.preCheckCast(this.j, Object[].class, "com.obric.aiagent.plugin");
            d.o.a(r25);
        L44:
            Object[] r15 = r10;
            int r23 = r6;
            r4 = r5;
            int r7 = r23;
        L20:
            byte r8 = (byte) (r4 + 1);
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r15;
            this.f38918a = r9;
            this.f38919b = r1;
            this.f38920c = r7;
            this.f38921d = r8;
            this.f38922e = 1;
            Object r12 = r9.a_(r11);
            if (r12 != r2) goto L23;
            return r2;
        L23:
            r10 = r15;
            r6 = r7;
            r5 = r8;
        L24:
            ai r13 = (ai) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.h.d(r12), ai.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L27;
        L28:
            int r14 = r13.a();
            Object r16 = r10[r14];
            r10[r14] = r13.b();
            if (r16 != t.f38939b) goto L32;
            r6 = r6 - 1;
        L32:
            if (r1[r14] == r5) goto L35;
            r1[r14] = (byte) r5;
            r13 = (ai) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.a.h.d(r9.r_()), ai.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L28;
        L35:
            if (r6 != 0) goto L44;
            Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast(this.g.invoke(), Object[].class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L41;
            d.h.a.q<kotlinx.coroutines.b.i<? super R>, T[], d.c.d<? super d.x>, Object> r18 = this.h;
            Object r19 = this.i;
            this.j = r10;
            this.f38918a = r9;
            this.f38919b = r1;
            this.f38920c = r6;
            this.f38921d = r5;
            this.f38922e = 2;
            if (r18.invoke(r19, r10, this) != r2) goto L44;
            return r2;
        L41:
            d.a.i.a(r10, r17, 0, 0, 0, 14, null);
            d.h.a.q<kotlinx.coroutines.b.i<? super R>, T[], d.c.d<? super d.x>, Object> r110 = this.h;
            Object r111 = this.i;
            this.j = r10;
            this.f38918a = r9;
            this.f38919b = r1;
            this.f38920c = r6;
            this.f38921d = r5;
            this.f38922e = 3;
            if (r110.invoke(r111, r17, this) != r2) goto L44;
            return r2;
        L45:
            if (r6 != 0) goto L44;
            goto L44
        L27:
            return d.x.f38692a;
        L11:
            r5 = this.f38921d;
            r6 = this.f38920c;
            r1 = (byte[]) ZeusTransformUtils.preCheckCast(this.f38919b, byte[].class, "com.obric.aiagent.plugin");
            r9 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(this.f38918a, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
            r10 = (Object[]) ZeusTransformUtils.preCheckCast(this.j, Object[].class, "com.obric.aiagent.plugin");
            d.o.a(r25);
            r12 = ((kotlinx.coroutines.a.h) ZeusTransformUtils.preCheckCast(r25, kotlinx.coroutines.a.h.class, "com.obric.aiagent.plugin")).a();
            goto L24
        L12:
            d.o.a(r25);
            am r20 = (am) ZeusTransformUtils.preCheckCast(this.j, am.class, "com.obric.aiagent.plugin");
            r7 = this.f.length;
            if (r7 == 0) goto L15;
            r15 = new Object[r7];
            d.a.i.a(r15, t.f38939b, 0, 0, 6, null);
            kotlinx.coroutines.a.d r22 = kotlinx.coroutines.a.g.a(r7, null, null, 6, null);
            AtomicInteger r112 = new AtomicInteger(r7);
            int r113 = 0;
        L17:
            if (r113 >= r7) goto L19;
            int r114 = r113;
            kotlinx.coroutines.i.a(r20, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f, r114, r112, r22, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            r113 = r114 + 1;
            r112 = r112;
            goto L17
        L19:
            r1 = new byte[r7];
            r9 = r22;
            goto L20
        L15:
            return d.x.f38692a;
        }
    }

    public static final <R, T> Object a(kotlinx.coroutines.b.i<? super R> r8, kotlinx.coroutines.b.h<? extends T>[] r9, d.h.a.a<T[]> r10, d.h.a.q<? super kotlinx.coroutines.b.i<? super R>, ? super T[], ? super d.c.d<? super d.x>, ? extends Object> r11, d.c.d<? super d.x> r12) {
        kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.q r5 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        Object r14 = o.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r9, r4, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
        if (r14 != d.c.a.b.a()) goto L6;
        return r14;
    L6:
        return d.x.f38692a;
    }
}
