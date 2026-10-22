package com.obric.aiagent.skill.virt.impl.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.virt.Ctrd;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: VirtBackendFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    private static final String TAG = "Virt/BackendSelection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f22061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f22062b = null;

    /* JADX INFO: compiled from: VirtBackendFactory.kt */
    @d.c.b.a.f(b = "VirtBackendFactory.kt", c = {70}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.VirtBackendFactory$probeCtrd$task$1$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22063a;

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22063a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            Ctrd r6 = Ctrd.INSTANCE;
            d.c.d<? super Integer> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22063a = 1;
            r5 = r6.getApiVersion(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ Integer lambda$cuKyE275uAEWnDfnTMul5OrNCK8() {
        return b();
    }

    private m() {
    }

    public final n a(Context r20, com.obric.aiagent.skill.virt.impl.c.b r21) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r21, "shellMonitor");
        d r3 = a();
        if (r3.a() == null) goto L6;
        ILogDepend.Companion.i(TAG, "Backend selected: ctrd apiVersion=" + r3.a());
        return (n) ZeusTransformUtils.preCheckCast(new n.a((k) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.virt.impl.a.a.a(r1, "doubao", r21), k.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin");
    L6:
        ILogDepend.Companion.i(TAG, "Ctrd unavailable; checking LXC reason=" + r3.b());
        com.obric.aiagent.skill.virt.impl.a.c.a r4 = new com.obric.aiagent.skill.virt.impl.a.c.a(r1, new com.obric.aiagent.skill.virt.impl.a.c.b("doubao", null, null, null, null, null, 0, 0, 254, null), r21);
        boolean r0 = r4.d();     // Catch: Exception -> L9
    L15:
        if (r0 == false) goto L18;
        ILogDepend.Companion.i(TAG, "Backend selected: lxc fallbackReason=" + r3.b());
        return (n) ZeusTransformUtils.preCheckCast(new n.a((k) ZeusTransformUtils.preCheckCast(r4, k.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin");
    L18:
        String r2 = "ctrd=" + r3.b() + ",lxc=unsupported";
        ILogDepend.Companion.w(TAG, "Virt Backend unavailable: " + r2);
        return (n) ZeusTransformUtils.preCheckCast(new n.b(r2), n.class, "com.obric.aiagent.plugin");
    L9:
        e = move-exception;
        if (IAppContext.Companion.isDebug() == false) goto L13;
        ILogDepend.Companion.w(TAG, "LXC support probe failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L14:
        r0 = false;
        goto L15
    L13:
        ILogDepend.Companion.w(TAG, "LXC support probe failed");
        goto L14
    }

    private final d a() {
        FutureTask r0 = new FutureTask($$Lambda$m$cuKyE275uAEWnDfnTMul5OrNCK8.INSTANCE);
        Thread r1 = new Thread((Runnable) ZeusTransformUtils.preCheckCast(r0, Runnable.class, "com.obric.aiagent.plugin"), "Virt-Ctrd-Probe");
        r1.setDaemon(true);
        r1.start();
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS), Integer.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 ExecutionException -> L10 InterruptedException -> L28 TimeoutException -> L29
        ILogDepend.Companion.i(TAG, "Ctrd probe apiVersion=" + r4);     // Catch: Exception -> L8 ExecutionException -> L10 InterruptedException -> L28 TimeoutException -> L29
        if (r4.intValue() <= 0) goto L6;
        d r5 = new d(r4, null);     // Catch: Exception -> L8 ExecutionException -> L10 InterruptedException -> L28 TimeoutException -> L29
    L31:
        return r5;
    L6:
        r5 = new d(null, "api-version-" + r4);     // Catch: Exception -> L8 ExecutionException -> L10 InterruptedException -> L28 TimeoutException -> L29
    L28:
        r0.cancel(true);
        Thread.currentThread().interrupt();
        return new d(null, "interrupted");
    L10:
        e = move-exception;
        Throwable r2 = e.getCause();
        if (r2 != null) goto L15;
        r2 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
    L15:
        if (ZeusTransformUtils.instanceOf(r2, CancellationException.class) == false) goto L17;
        throw r2;
    L17:
        if (ZeusTransformUtils.instanceOf(r2, NoClassDefFoundError.class) == false) goto L21;
        d r9 = a((NoClassDefFoundError) ZeusTransformUtils.preCheckCast(r2, NoClassDefFoundError.class, "com.obric.aiagent.plugin"));
    L36:
        return r9;
    L21:
        if (ZeusTransformUtils.instanceOf(r2, Error.class) == false) goto L23;
        throw r2;
    L23:
        if (ZeusTransformUtils.instanceOf(r2, Exception.class) == false) goto L25;
        r9 = a((Exception) ZeusTransformUtils.preCheckCast(r2, Exception.class, "com.obric.aiagent.plugin"));
        goto L36
    L25:
        throw e;
    L29:
        r0.cancel(true);
        return new d(null, "timeout");
    L8:
        e = move-exception;
        return a(e);
    }

    private static final Integer b() {
        return (Integer) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Integer.class, "com.obric.aiagent.plugin");
    }

    private final d a(Exception r5) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.w(TAG, "Ctrd probe failed", (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        return new d(null, "exception-" + r5.getClass().getSimpleName());
    L5:
        ILogDepend.Companion.w(TAG, "Ctrd probe failed");
        goto L7
    }

    private final d a(NoClassDefFoundError r9) {
        String r8 = r9.getMessage();
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f22062b, Iterable.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L8;
    L10:
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r1.next(), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L12;
    L15:
        if (r4 == true) goto L18;
        ILogDepend.Companion.i(TAG, "Ctrd framework is absent; falling back to LXC");
        return new d(null, "framework-class-missing");
    L18:
        throw r9;
    L9:
        r4 = true;
        goto L15
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        goto L9
    }

    static {
        f22061a = new m();
        f22062b = ax.a(new String[]{"com/obric/virt/CtrdManager", "com/obric/virt/ObricCtrdManager"});
    }
}
