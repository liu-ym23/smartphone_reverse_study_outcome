package com.obric.autogui.operator.a;

import android.content.Context;
import android.util.EventsUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends com.obric.autogui.operator.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29284a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<a.C0743a> f29285c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<w<com.obric.autogui.operator.c>> f29286b;

    /* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
        private static final class C0743a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final b f29287a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final w<com.obric.autogui.operator.c> f29288b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0743a.class) == true) goto L8;
                return false;
            L8:
                C0743a r6 = (C0743a) ZeusTransformUtils.preCheckCast(r5, C0743a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f29287a, r6.f29287a) == true) goto L12;
                return false;
            L12:
                if (o.a(this.f29288b, r6.f29288b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f29287a.hashCode() * 31) + this.f29288b.hashCode();
            }

            public String toString() {
                return "ExecutionSlot(operation=" + this.f29287a + ", completion=" + this.f29288b + ')';
            }

            public C0743a(b r3, w<com.obric.autogui.operator.c> r4) {
                w<com.obric.autogui.operator.c> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
                o.e(r3, "operation");
                o.e(r5, "completion");
                this.f29287a = r3;
                this.f29288b = r5;
            }

            public final b a() {
                return this.f29287a;
            }

            public final w<com.obric.autogui.operator.c> b() {
                return this.f29288b;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
        @d.c.b.a.f(b = "AOMutualExclusiveOperation.kt", c = {64}, d = "awaitAnyCompletion", e = "com.obric.autogui.operator.impl.AOMutualExclusiveOperation$Companion")
        static final class C0744b extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29289a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29290b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f29291c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f29292d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f29293e;
            int f;

            C0744b(a r3, d.c.d<? super C0744b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29293e = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29292d = r3;
                this.f |= Integer.MIN_VALUE;
                return this.f29293e.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a() {
            C0743a r2 = (C0743a) ZeusTransformUtils.preCheckCast(b.b().get(), C0743a.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L7;
            return null;
        L7:
            return r2.a();
        }

        public final void b() {
            b r0 = a();
            if (r0 == null) goto L5;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "there's ongoing operation: " + r0 + " which is being cleared!");
        L5:
            b.b().set(null);
        }

        public final Object a(d.c.d<? super Boolean> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, C0744b.class) == false) goto L7;
            C0744b r0 = (C0744b) ZeusTransformUtils.preCheckCast(r10, C0744b.class, "com.obric.aiagent.plugin");
            if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
            r0.f -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f29292d;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            long r4 = r0.f29291c;
            C0743a r8 = (C0743a) ZeusTransformUtils.preCheckCast(r0.f29290b, C0743a.class, "com.obric.aiagent.plugin");
            a r1 = (a) ZeusTransformUtils.preCheckCast(r0.f29289a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
            C0743a r12 = r8;
            a this = r1;
        L20:
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [await-mutual] op = " + r12.a() + "; l = " + (System.currentTimeMillis() - r4) + "ms");
            return d.c.b.a.b.a(true);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r11);
            r12 = (C0743a) ZeusTransformUtils.preCheckCast(b.b().get(), C0743a.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L23;
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [await-mutual] op = " + r12.a());
            long r6 = System.currentTimeMillis();
            w<com.obric.autogui.operator.c> r5 = r12.b();
            r0.f29289a = this;
            r0.f29290b = r12;
            r0.f29291c = r6;
            r0.f = 1;
            if (r5.a(r0) != r2) goto L19;
            return r2;
        L19:
            r4 = r6;
            goto L20
        L23:
            return d.c.b.a.b.a(false);
        L7:
            r0 = new C0744b(this, r10);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
    @d.c.b.a.f(b = "AOMutualExclusiveOperation.kt", c = {152}, d = "operateSingleton$suspendImpl", e = "com.obric.autogui.operator.impl.AOMutualExclusiveOperation")
    static final class C0745b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f29294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f29295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f29296c;

        C0745b(b r3, d.c.d<? super C0745b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29295b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29294a = r3;
            this.f29296c |= Integer.MIN_VALUE;
            return b.a(this.f29295b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
    @d.c.b.a.f(b = "AOMutualExclusiveOperation.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "perform", e = "com.obric.autogui.operator.impl.AOMutualExclusiveOperation")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f29299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29300d;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29299c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29298b = r3;
            this.f29300d |= Integer.MIN_VALUE;
            return this.f29299c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOMutualExclusiveOperation.kt */
    @d.c.b.a.f(b = "AOMutualExclusiveOperation.kt", c = {116}, d = "performInternal", e = "com.obric.autogui.operator.impl.AOMutualExclusiveOperation")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f29304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29305e;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29304d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29303c = r3;
            this.f29305e |= Integer.MIN_VALUE;
            return b.a(this.f29304d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public Object b(Context r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object c(Context r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        return b(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public b() {
        this.f29286b = new AtomicReference(y.a(null, 1, null));
    }

    public static final /* synthetic */ Object a(b r2, Context r3, a.C0743a r4, d.c.d r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReference b() {
        return f29285c;
    }

    static {
        f29284a = new a(null);
        f29285c = new AtomicReference(null);
    }

    @Override // com.obric.autogui.operator.b
    public final Object a(Context r7, d.c.d<? super com.obric.autogui.operator.c> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r0.f29300d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29300d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f29298b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29300d;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        w<com.obric.autogui.operator.c> r6 = (w) ZeusTransformUtils.preCheckCast(r0.f29297a, w.class, "com.obric.aiagent.plugin");
        d.o.a(r11);     // Catch: Throwable -> L14
    L23:
        r6.a((com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        return (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
    L14:
        th = th;
    L27:
        r6.a(th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r11);
        w<com.obric.autogui.operator.c> r12 = y.a(null, 1, null);
        this.f29286b.set(r12);
        a.C0743a r4 = new a.C0743a(this, r12);
        r0.f29297a = r12;     // Catch: Throwable -> L25
        r0.f29300d = 1;     // Catch: Throwable -> L25
        Object r13 = a(r9, r4, r0);     // Catch: Throwable -> L25
        if (r13 != r2) goto L22;
        return r2;
    L22:
        r11 = r13;
        r6 = r12;
    L25:
        th = th;
        r6 = r12;
    L7:
        r0 = new c(this, r10);
        goto L8
    }

    private final Object a(Context r9, a.C0743a r10, d.c.d<? super com.obric.autogui.operator.c> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r13, d.class, "com.obric.aiagent.plugin");
        if ((r1.f29305e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f29305e -= Integer.MIN_VALUE;
    L8:
        Object r14 = r1.f29303c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f29305e;
        b r7 = null;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        r10 = (a.C0743a) ZeusTransformUtils.preCheckCast(r1.f29302b, a.C0743a.class, "com.obric.aiagent.plugin");
        b this = (b) ZeusTransformUtils.preCheckCast(r1.f29301a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Throwable -> L14
    L28:
        Object r15 = n.f((com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L31:
        Throwable r16 = n.c(r15);
        if (r16 != null) goto L38;
        com.obric.autogui.operator.c r8 = (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        if (f29285c.compareAndSet(r10, null) == false) goto L37;
        return r8;
    L37:
        throw new IllegalStateException("invalid state; mExecutingOperation is not set correctly.");
    L38:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "performSingletonOperation failed", r16);
        f29285c.compareAndSet(r10, null);
        if (ZeusTransformUtils.instanceOf(r16, CancellationException.class) == false) goto L43;
        return new com.obric.autogui.operator.h(ZeusTransformUtils.mapRes(R.string.espe_execute_op_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_cancelled"), "action cancelled", "operation_cancelled");
    L43:
        return new com.obric.autogui.operator.h(ZeusTransformUtils.mapRes(R.string.espe_execute_op_exception, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_exception"), "performSingletonOperation failed", "operation_exception");
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r14);
        AtomicReference<a.C0743a> r17 = f29285c;
        if (r17.compareAndSet(null, r10) == true) goto L25;
        Loog r18 = Loog.INSTANCE;
        String r19 = LogUtil.INSTANCE.getCLAZZ_TAG(this);
        StringBuilder r110 = new StringBuilder().append("executing operation = ");
        a.C0743a r111 = (a.C0743a) ZeusTransformUtils.preCheckCast(r17.get(), a.C0743a.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L23;
        r7 = r111.a();
    L23:
        r18.e(r19, r110.append(r7).toString());
        return new com.obric.autogui.operator.h(ZeusTransformUtils.mapRes(R.string.espe_execute_op_another_executing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_another_executing"), "executing operation", "operation_already_executing");
    L25:
        n.a r112 = n.f38560a;     // Catch: Throwable -> L14
        b r113 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r1.f29301a = this;     // Catch: Throwable -> L14
        r1.f29302b = r10;     // Catch: Throwable -> L14
        r1.f29305e = 1;     // Catch: Throwable -> L14
        r14 = r113.b(r12, r1);     // Catch: Throwable -> L14
        if (r14 != r3) goto L28;
        return r3;
    L14:
        th = move-exception;
        n.a r114 = n.f38560a;
        r15 = n.f(d.o.a(th));
    L7:
        r1 = new d(this, r13);
        goto L8
    }

    static /* synthetic */ Object a(b r5, Context r6, d.c.d<? super com.obric.autogui.operator.c> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0745b.class) == false) goto L7;
        C0745b r0 = (C0745b) ZeusTransformUtils.preCheckCast(r9, C0745b.class, "com.obric.aiagent.plugin");
        if ((r0.f29296c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29296c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f29294a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29296c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
    L18:
        return new com.obric.autogui.operator.n((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        r0.f29296c = 1;
        r10 = r5.c(r8, r0);
        if (r10 != r2) goto L18;
        return r2;
    L7:
        r0 = new C0745b(r5, r9);
        goto L8
    }

    static /* synthetic */ Object b(b r1, Context r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }
}
