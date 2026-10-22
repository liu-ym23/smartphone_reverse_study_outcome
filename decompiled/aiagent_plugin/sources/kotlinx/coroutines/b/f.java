package kotlinx.coroutines.b;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Distinct.kt */
/* JADX INFO: loaded from: classes4.dex */
final class f<T> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.h.a.b<T, Object> f39019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.h.a.m<Object, Object, Boolean> f39020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h<T> f39021c;

    /* JADX INFO: compiled from: Distinct.kt */
    static final class a<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f<T> f39022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<Object> f39023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T> f39024c;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Distinct.kt */
        @d.c.b.a.f(b = "Distinct.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "emit", e = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2")
        static final class C1052a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f39025a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a<T> f39026b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f39027c;

            /* JADX WARN: Multi-variable type inference failed */
            C1052a(a<? super T> r3, d.c.d<? super C1052a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39026b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f39025a = r3;
                this.f39027c |= Integer.MIN_VALUE;
                return this.f39026b.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        a(f<T> r3, d.h.b.z.f<Object> r4, i<? super T> r5) {
            i<T> r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
            this.f39022a = r3;
            this.f39023b = r4;
            this.f39024c = r6;
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
        @Override // kotlinx.coroutines.b.i
        public final Object emit(T r7, d.c.d<? super d.x> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, C1052a.class) == false) goto L7;
            C1052a r0 = (C1052a) ZeusTransformUtils.preCheckCast(r9, C1052a.class, "com.obric.aiagent.plugin");
            if ((r0.f39027c & Integer.MIN_VALUE) == 0) goto L7;
            r0.f39027c -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f39025a;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f39027c;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            d.o.a(r10);
        L25:
            return d.x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r10);
            T r11 = (T) this.f39022a.f39019a.invoke(r7);
            if (this.f39023b.f38504a != kotlinx.coroutines.b.a.t.f38938a) goto L17;
        L21:
            this.f39023b.f38504a = r11;
            i<T> r6 = this.f39024c;
            r0.f39027c = 1;
            if (r6.emit(r7, r0) != r2) goto L25;
            return r2;
        L17:
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.f39022a.f39020b.invoke(this.f39023b.f38504a, r11), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L21;
            return d.x.f38692a;
        L7:
            r0 = new C1052a(this, r9);
            goto L8
        }
    }

    public f(h<? extends T> r3, d.h.a.b<? super T, ? extends Object> r4, d.h.a.m<Object, Object, Boolean> r5) {
        h<T> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, Object> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<Object, Object, Boolean> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        this.f39021c = r6;
        this.f39019a = r7;
        this.f39020b = r8;
    }

    @Override // kotlinx.coroutines.b.h
    public Object collect(i<? super T> r5, d.c.d<? super d.x> r6) {
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r0 = new d.h.b.z.f();
        r0.f38504a = (T) kotlinx.coroutines.b.a.t.f38938a;
        Object r4 = this.f39021c.collect((i) ZeusTransformUtils.preCheckCast(new a(this, r0, r7), i.class, "com.obric.aiagent.plugin"), r8);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return d.x.f38692a;
    }
}
