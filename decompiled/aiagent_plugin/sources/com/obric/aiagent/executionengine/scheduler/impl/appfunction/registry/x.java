package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.os.Build;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AppFunctionRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private static final String TAG = "AppFunctionRegistry";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f18310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f18311b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.am f18312c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f18313d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f18314e = null;
    private static volatile List<m> f;
    private static volatile Map<String, ? extends List<m>> g;
    private static final AtomicBoolean h = null;
    private static final AtomicBoolean i = null;
    private static final AtomicBoolean j = null;
    private static final kotlinx.coroutines.w<d.x> k = null;

    /* JADX INFO: compiled from: AppFunctionRegistry.kt */
    public interface a {
        Object a(List<m> r1, d.c.d<? super d.x> r2);
    }

    /* JADX INFO: compiled from: AppFunctionRegistry.kt */
    @d.c.b.a.f(b = "AppFunctionRegistry.kt", c = {101}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionRegistry$awaitReady$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18315a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18315a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            kotlinx.coroutines.w r6 = x.e();
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18315a = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppFunctionRegistry.kt */
    @d.c.b.a.f(b = "AppFunctionRegistry.kt", c = {249, 138, 155}, d = "doRefresh", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionRegistry")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f18319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18320e;

        c(x r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18319d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18318c = r3;
            this.f18320e |= Integer.MIN_VALUE;
            return x.a(this.f18319d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionRegistry.kt */
    @d.c.b.a.f(b = "AppFunctionRegistry.kt", c = {186}, d = "notifyRefreshSucceeded", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionRegistry")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f18324d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18325e;

        d(x r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18324d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18323c = r3;
            this.f18325e |= Integer.MIN_VALUE;
            return x.a(this.f18324d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionRegistry.kt */
    @d.c.b.a.f(b = "AppFunctionRegistry.kt", c = {126}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionRegistry$refresh$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18326a;

        e(d.c.d<? super e> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0036 -> B:15:0x0039). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18326a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r6);     // Catch: Throwable -> L7
        L15:
            if (x.f().get() == false) goto L17;
        L12:
            x.f().set(false);     // Catch: Throwable -> L7
            x r7 = x.f18310a;     // Catch: Throwable -> L7
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f18326a = 1;     // Catch: Throwable -> L7
            if (x.a(r7, r2) != r0) goto L15;
            return r0;
        L17:
            x.g().set(false);
            return d.x.f38692a;
        L7:
            th = move-exception;
            x.g().set(false);
            throw th;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r6);
            goto L12
        }
    }

    /* JADX INFO: compiled from: AppFunctionRegistry.kt */
    @d.c.b.a.f(b = "AppFunctionRegistry.kt", c = {85}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionRegistry$registerRefreshListener$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f18328b;

        f(a r3, d.c.d<? super f> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18328b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f18328b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18327a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(x.d(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L14;
            a r7 = this.f18328b;
            List<m> r2 = x.d();
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18327a = 1;
            if (r7.a(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    public static /* synthetic */ String lambda$ZmXzPbRYy2BtmCxfx0DLbpctsA0() {
        return j();
    }

    private x() {
    }

    public static final /* synthetic */ Object a(x r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(x r2, List r3, d.c.d r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ List d() {
        return f;
    }

    public static final /* synthetic */ kotlinx.coroutines.w e() {
        return k;
    }

    public static final /* synthetic */ AtomicBoolean f() {
        return j;
    }

    public static final /* synthetic */ AtomicBoolean g() {
        return i;
    }

    static {
        f18310a = new x();
        f18311b = d.g.a($$Lambda$x$ZmXzPbRYy2BtmCxfx0DLbpctsA0.INSTANCE);
        f18312c = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f18313d = kotlinx.coroutines.f.c.a(false, 1, null);
        f18314e = new CopyOnWriteArrayList();
        f = d.a.p.b();
        g = ao.b();
        h = new AtomicBoolean(false);
        i = new AtomicBoolean(false);
        j = new AtomicBoolean(false);
        k = kotlinx.coroutines.y.a(null, 1, null);
    }

    private final String h() {
        Object r2 = f18311b.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    }

    private static final String j() {
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 36) goto L6;
        return;
    L6:
        if (h.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        k.f18251a.a();
    }

    public final void a(a r8) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "listener");
        if (f18314e.addIfAbsent(r7) == false) goto L6;
        kotlinx.coroutines.i.a(f18312c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final Object a(long r3, d.c.d<? super d.x> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (k.i() == false) goto L7;
        return d.x.f38692a;
    L7:
        return dg.b(r3, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 36) goto L7;
        i();
        return;
    L7:
        if (i.compareAndSet(false, true) == true) goto L10;
        j.set(true);
        return;
    L10:
        kotlinx.coroutines.i.a(f18312c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(d.c.d<? super d.x> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.aiagent.plugin");
        if ((r0.f18320e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18320e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f18318c;
        Object r16 = d.c.a.b.a();
        int r2 = r0.f18320e;
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L25;
        if (r2 == 2) goto L20;
        if (r2 != 3) goto L19;
        kotlinx.coroutines.f.a r17 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f18316a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Throwable -> L16
    L60:
        d.x r18 = d.x.f38692a;     // Catch: Throwable -> L16
        r17.b(null);
        return d.x.f38692a;
    L16:
        th = th;
    L65:
        r17.b(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        x r3 = (x) ZeusTransformUtils.preCheckCast(r0.f18317b, x.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r5 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f18316a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Throwable -> L23
    L33:
        List<m> r19 = r3.a((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
    L38:
        f = r19;     // Catch: Throwable -> L63
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L63
    L40:
        if (r6.hasNext() == false) goto L49;
        Object r9 = r6.next();     // Catch: Throwable -> L63
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        if (r10.a() != null) goto L44;
    L46:
        boolean r11 = false;
    L47:
        if (r11 == false) goto L40;
        r8.add(r9);     // Catch: Throwable -> L63
        goto L40
    L44:
        if (r10.b() == null) goto L46;
        r11 = true;
        goto L47
    L49:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        Map<String, ? extends List<m>> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        Iterator r20 = r7.iterator();     // Catch: Throwable -> L63
    L51:
        if (r20.hasNext() == false) goto L56;
        Object r21 = r20.next();     // Catch: Throwable -> L63
        m r22 = (m) ZeusTransformUtils.preCheckCast(r21, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        x r110 = f18310a;     // Catch: Throwable -> L63
        String r111 = r22.a();     // Catch: Throwable -> L63
        d.h.b.o.a(r111);     // Catch: Throwable -> L63
        String r23 = r22.b();     // Catch: Throwable -> L63
        d.h.b.o.a(r23);     // Catch: Throwable -> L63
        String r24 = r110.b(r111, r23);     // Catch: Throwable -> L63
        List<m> r112 = r12.get(r24);     // Catch: Throwable -> L63
        if (r112 != null) goto L55;
        r112 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        r12.put(r24, r112);     // Catch: Throwable -> L63
    L55:
        ((List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin")).add(r21);     // Catch: Throwable -> L63
        goto L51
    L56:
        g = r12;     // Catch: Throwable -> L63
        ILogDepend.Companion.i(TAG, "refresh done, enumerated=" + r19.size() + ", schemaKeys=" + g.size());     // Catch: Throwable -> L63
        x r1 = f18310a;     // Catch: Throwable -> L63
        r1.i();     // Catch: Throwable -> L63
        r0.f18316a = r5;     // Catch: Throwable -> L63
        r0.f18317b = null;     // Catch: Throwable -> L63
        r0.f18320e = 3;     // Catch: Throwable -> L63
        if (r1.a(r19, r0) != r16) goto L59;
        return r16;
    L59:
        r17 = r5;
    L63:
        th = th;
        r17 = r5;
    L23:
        Throwable th = th;
    L73:
        ILogDepend.Companion.e(TAG, "doRefresh enumerate failed", th);     // Catch: Throwable -> L63
        r19 = d.a.p.b();     // Catch: Throwable -> L63
        goto L38
    L25:
        kotlinx.coroutines.f.a r25 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f18316a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        kotlinx.coroutines.f.a r113 = r25;
    L71:
        r3 = f18310a;     // Catch: Throwable -> L35
        r r26 = r.f18273a;     // Catch: Throwable -> L35
        r0.f18316a = r113;     // Catch: Throwable -> L35
        r0.f18317b = r3;     // Catch: Throwable -> L35
        r0.f18320e = 2;     // Catch: Throwable -> L35
        Object r27 = r26.a(r0);     // Catch: Throwable -> L35
        if (r27 != r16) goto L32;
        return r16;
    L32:
        r5 = r113;
        r13 = r27;
    L35:
        th = move-exception;
        r5 = r113;
        th = th;
        goto L73
    L26:
        d.o.a(r13);
        r113 = f18313d;
        r0.f18316a = r113;
        r0.f18320e = 1;
        if (r113.a(null, r0) != r16) goto L71;
        return r16;
    L7:
        r0 = new c(this, r15);
        goto L8
    }

    private final List<m> a(List<m> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Object r5 = r4.next();
        String r6 = ((m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin")).e();
        Object r7 = r3.get(r6);
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r3.put(r6, r7);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")).add(r5);
        goto L4
    L9:
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r3.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L24;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10.getValue(), List.class, "com.obric.aiagent.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        boolean r13 = true;
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L15;
    L17:
        Iterator r14 = r12.iterator();
    L19:
        if (r14.hasNext() == false) goto L16;
        if ((!d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r14.next(), m.class, "com.obric.aiagent.plugin")).c(), ((m) ZeusTransformUtils.preCheckCast(d.a.p.k(r11), m.class, "com.obric.aiagent.plugin")).c())) == false) goto L19;
    L22:
        if (r13 == false) goto L11;
        r8.put(r10.getKey(), r10.getValue());
    L16:
        r13 = false;
        goto L22
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
    L24:
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r1.iterator();
    L26:
        if (r17.hasNext() == false) goto L37;
        m r18 = (m) ZeusTransformUtils.preCheckCast(r17.next(), m.class, "com.obric.aiagent.plugin");
        if (r15.containsKey(r18.e()) == false) goto L33;
        String r110 = r18.k();
        if (r110 != null) goto L32;
        ILogDepend.Companion.w(TAG, "drop conflicting AppFunction: invalid fallback name, toolName=" + r18.e() + ", packageName=" + r18.c() + ", functionId=" + r18.d());
        m r20 = null;
    L34:
        if (r20 == null) goto L26;
        r16.add(r20);
        goto L26
    L32:
        ILogDepend.Companion.i(TAG, "tool name conflict: toolName=" + r18.e() + ", fallback=" + r18.k() + ", packageNames=" + r18.c());
        r18 = m.a(r18, null, null, null, null, r110, null, null, null, null, null, 1007, null);
    L33:
        r20 = r18;
        goto L34
    L37:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:31:0x00af). Please report as a decompilation issue!!! */
    private final Object a(List<m> r9, d.c.d<? super d.x> r10) {
        List<m> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.aiagent.plugin");
        if ((r0.f18325e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18325e -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f18323c;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f18325e;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        Iterator r14 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f18322b, Iterator.class, "com.obric.aiagent.plugin");
        List<m> r3 = (List) ZeusTransformUtils.preCheckCast(r0.f18321a, List.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Exception -> L14 CancellationException -> L16
    L31:
        List<m> r15 = r3;
    L22:
        if (r14.hasNext() == false) goto L34;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        r0.f18321a = r15;     // Catch: CancellationException -> L16 Exception -> L28
        r0.f18322b = r14;     // Catch: CancellationException -> L16 Exception -> L28
        r0.f18325e = 1;     // Catch: CancellationException -> L16 Exception -> L28
        if (r4.a(r15, r0) != r13) goto L27;
        return r13;
    L27:
        r3 = r15;
        goto L31
    L28:
        e = move-exception;
        r3 = r15;
        ILogDepend.Companion.e(TAG, "refresh listener failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L31
    L34:
        return d.x.f38692a;
    L16:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "refresh listener failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L31
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r8);
        r14 = ((Iterable) ZeusTransformUtils.preCheckCast(f18314e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r15 = r11;
    L7:
        r0 = new d(this, r12);
        goto L8
    }

    private final void i() {
        kotlinx.coroutines.w<d.x> r1 = k;
        if (r1.i() == true) goto L6;
        r1.a(d.x.f38692a);
        return;
    }

    public final m query(String r5, String r6) {
        d.h.b.o.e(r5, "schemaCategory");
        d.h.b.o.e(r6, "schemaName");
        List r4 = (List) ZeusTransformUtils.preCheckCast(g.get(b(r5, r6)), List.class, "com.obric.aiagent.plugin");
        Object r7 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isEmpty() == false) goto L8;
        return null;
    L8:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        if ((!d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.aiagent.plugin")).c(), f18310a.h())) == false) goto L10;
        r7 = r1;
    L14:
        m r8 = (m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        return r8;
    L17:
        return (m) ZeusTransformUtils.preCheckCast(d.a.p.k(r4), m.class, "com.obric.aiagent.plugin");
    }

    public final List<m> c() {
        return f;
    }

    public final m a(String r5, String r6) {
        d.h.b.o.e(r5, "packageName");
        d.h.b.o.e(r6, "functionId");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        Object r0 = r4.next();
        m r2 = (m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r2.c(), r5) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
    L15:
        return (m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin");
    L8:
        if (d.h.b.o.a(r2.d(), r6) == false) goto L10;
        r3 = true;
        goto L11
    L13:
        r0 = null;
        goto L15
    }

    public final m a(String r3, String r4, String r5) {
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r4, "schemaCategory");
        d.h.b.o.e(r5, "schemaName");
        List r2 = (List) ZeusTransformUtils.preCheckCast(g.get(b(r4, r5)), List.class, "com.obric.aiagent.plugin");
        Object r6 = null;
        if (r2 == null) goto L15;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        Object r0 = r7.next();
        if (d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin")).c(), r3) == false) goto L6;
        r6 = r0;
    L11:
        return (m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.aiagent.plugin");
    L15:
        return null;
    }

    private final String b(String r1, String r2) {
        return r1 + '/' + r2;
    }
}
