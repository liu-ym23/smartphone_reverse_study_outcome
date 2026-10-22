package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.GlobalSearchSession;
import android.app.appsearch.observer.ObserverCallback;
import android.app.appsearch.observer.ObserverSpec;
import android.os.Build;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: AppFunctionEnableObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static final String TAG = "AppFuncEnableObserver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f18251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.am f18252b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ExecutorService f18253c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f18254d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f18255e = null;
    private static GlobalSearchSession f;
    private static volatile ca g;
    private static final AppFunctionEnableObserver$observer$1 h = null;

    /* JADX INFO: compiled from: AppFunctionEnableObserver.kt */
    static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<GlobalSearchSession> f18256a;

        a(kotlinx.coroutines.n<? super GlobalSearchSession> r3) {
            this.f18256a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((AppSearchResult) ZeusTransformUtils.preCheckCast(r3, AppSearchResult.class, "com.obric.aiagent.plugin"));
        }

        public final void a(AppSearchResult<GlobalSearchSession> r5) {
            if (r5.isSuccess() == false) goto L5;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18256a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r4.resumeWith(d.n.f(r5.getResultValue()));
            return;
        L5:
            ILogDepend.Companion.e(k.TAG, "createGlobalSearchSession failed: " + r5.getErrorMessage());
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18256a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r7 = d.n.f38560a;
            r6.resumeWith(d.n.f(null));
        }
    }

    /* JADX INFO: compiled from: AppFunctionEnableObserver.kt */
    @d.c.b.a.f(b = "AppFunctionEnableObserver.kt", c = {102}, d = "registerObserver", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionEnableObserver")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f18259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18260d;

        b(k r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18259c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18258b = r3;
            this.f18260d |= Integer.MIN_VALUE;
            return k.a(this.f18259c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionEnableObserver.kt */
    @d.c.b.a.f(b = "AppFunctionEnableObserver.kt", c = {144}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionEnableObserver$scheduleRefresh$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18261a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18261a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            ILogDepend.Companion.i(k.TAG, "debounced refresh AppFunctionRegistry");
            x.f18310a.b();
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18261a = 1;
            if (ax.a(1000, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppFunctionEnableObserver.kt */
    @d.c.b.a.f(b = "AppFunctionEnableObserver.kt", c = {155, 95}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionEnableObserver$start$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18263b;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18263b;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f18262a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r9);     // Catch: Throwable -> L9
        L24:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L27;
            k.c().set(true);     // Catch: Throwable -> L9
        L27:
            d.x r10 = d.x.f38692a;     // Catch: Throwable -> L9
            r8.b(null);
            return d.x.f38692a;
        L9:
            Throwable th = th;
        L32:
            r8.b(null);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            kotlinx.coroutines.f.a r2 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f18262a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
            kotlinx.coroutines.f.a r11 = r2;
        L34:
        L30:
            th = move-exception;
            kotlinx.coroutines.f.a r7 = r11;
            th = th;
            r8 = r7;
            goto L32
        L18:
            if (k.c().get() == true) goto L26;
            k r3 = k.f18251a;     // Catch: Throwable -> L30
            this.f18262a = r11;     // Catch: Throwable -> L30
            this.f18263b = 2;     // Catch: Throwable -> L30
            Object r12 = k.a(r3, this);     // Catch: Throwable -> L30
            if (r12 != r0) goto L22;
            return r0;
        L22:
            kotlinx.coroutines.f.a r13 = r11;
            r9 = r12;
            r8 = r13;
            goto L24
        L26:
            r8 = r11;
            goto L27
        L14:
            d.o.a(r9);
            r11 = k.b();
            d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18262a = r11;
            this.f18263b = 1;
            if (r11.a(null, r4) != r0) goto L34;
            return r0;
        }
    }

    private k() {
    }

    public static final /* synthetic */ Object a(k r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(k r0) {
        r0.e();
    }

    public static final /* synthetic */ boolean a(k r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a b() {
        return f18254d;
    }

    public static final /* synthetic */ AtomicBoolean c() {
        return f18255e;
    }

    public static final /* synthetic */ ExecutorService d() {
        return f18253c;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionEnableObserver$observer$1] */
    static {
        f18251a = new k();
        f18252b = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f18253c = Executors.newSingleThreadExecutor();
        f18254d = kotlinx.coroutines.f.c.a(false, 1, null);
        f18255e = new AtomicBoolean(false);
        h = new AppFunctionEnableObserver$observer$1();
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 36) goto L6;
        return;
    L6:
        if (f18255e.get() == false) goto L8;
        return;
    L8:
        kotlinx.coroutines.i.a(f18252b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(d.c.d<? super Boolean> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r1.f18260d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f18260d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f18258b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f18260d;
        boolean r5 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        k this = (k) ZeusTransformUtils.preCheckCast(r1.f18257a, k.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        GlobalSearchSession r12 = (GlobalSearchSession) ZeusTransformUtils.preCheckCast(r11, GlobalSearchSession.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L34;
        k r8 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "openGlobalSession failed, enable/disable observing degraded");
        return d.c.b.a.b.a(false);
    L34:
        ObserverSpec r13 = new ObserverSpec.Builder().build();     // Catch: Throwable -> L23
        d.h.b.o.c(r13, "build(...)");     // Catch: Throwable -> L23
        r12.registerObserverCallback("android", r13, (Executor) ZeusTransformUtils.preCheckCast(f18253c, Executor.class, "com.obric.aiagent.plugin"), (ObserverCallback) ZeusTransformUtils.preCheckCast(h, ObserverCallback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        f = r12;     // Catch: Throwable -> L23
        ILogDepend.Companion.i(TAG, "registerObserverCallback done on android");     // Catch: Throwable -> L23
    L31:
        return d.c.b.a.b.a(r5);
    L23:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "registerObserverCallback failed", th);
        d.n.a r14 = d.n.f38560a;     // Catch: Throwable -> L27
        r12.close();     // Catch: Throwable -> L27
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L27
    L29:
        r5 = false;
    L27:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        r1.f18257a = this;
        r1.f18260d = 1;
        r11 = b(r1);
        if (r11 != r3) goto L17;
        return r3;
    L7:
        r1 = new b(this, r10);
        goto L8
    }

    private final Object b(d.c.d<? super GlobalSearchSession> r6) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        AppSearchManager r7 = (AppSearchManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(AppSearchManager.class), AppSearchManager.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        return null;
    L6:
        kotlinx.coroutines.o r1 = new kotlinx.coroutines.o(d.c.a.b.a(r5), 1);
        r1.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r7.createGlobalSearchSession((Executor) ZeusTransformUtils.preCheckCast(d(), Executor.class, "com.obric.aiagent.plugin"), (Consumer) ZeusTransformUtils.preCheckCast(new a(r2), Consumer.class, "com.obric.aiagent.plugin"));
        Object r8 = r1.h();
        if (r8 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r5);
    L9:
        return r8;
    }

    private final boolean a(String r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (d.o.o.b(r4, "AppFunctionRuntimeMetadata", false, 2, null) == false) goto L8;
    L9:
        return true;
    L8:
        if (d.o.o.b(r4, "AppFunctionStaticMetadata", false, 2, null) == true) goto L9;
        return false;
    }

    private final void e() {
        ca r8 = g;
        if (r8 == null) goto L5;
        ca.a.a(r8, null, 1, null);
    L5:
        g = kotlinx.coroutines.i.a(f18252b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
