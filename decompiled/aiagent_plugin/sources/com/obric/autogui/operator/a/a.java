package com.obric.autogui.operator.a;

import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: AOEnvironment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOEnvironment.kt */
    private static final class C0740a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0740a f29252a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f29253b;

        static {
            f29252a = new C0740a();
        }

        private C0740a() {
        }

        public final void a(boolean r1) {
            f29253b = r1;
        }

        public final boolean a() {
            return f29253b;
        }
    }

    public a() {
    }

    public final Object a(Context r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Intent r0 = new Intent("com.obric.autogui.agent.AGENT_RUNNING_STATE_CHANGED");
        r0.putExtra("is_running", true);
        r6.sendBroadcast(r0);
        if (com.obric.autogui.common.a.d.f28974a.a() == true) goto L7;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "accessibility is disabled.");
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        return c(r6, r7);
    }

    public final Object b(Context r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Intent r0 = new Intent("com.obric.autogui.agent.AGENT_RUNNING_STATE_CHANGED");
        r0.putExtra("is_running", false);
        r6.sendBroadcast(r0);
        if (com.obric.autogui.common.a.d.f28974a.a() == true) goto L7;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "accessibility is disabled.");
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        return d(r6, r7);
    }

    private final Object c(Context r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        C0740a r5 = C0740a.f29252a;
        monitor-enter(r5);
        boolean r6 = true;
        if (C0740a.f29252a.a() == true) goto L7;
        C0740a.f29252a.a(true);     // Catch: Throwable -> L15
    L8:
        x r7 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(r5);
        if (r6 == false) goto L14;
        return com.obric.autogui.common.e.f29014b.a();
    L14:
        return com.obric.autogui.common.e.f29014b.a("already started");
    L7:
        r6 = false;
    L15:
        th = move-exception;
        throw th;
    }

    private final Object d(Context r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        C0740a r5 = C0740a.f29252a;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (C0740a.f29252a.a() == false) goto L7;
        C0740a.f29252a.a(false);     // Catch: Throwable -> L11
    L7:
        x r6 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return com.obric.autogui.common.e.f29014b.a("already stopped");
    }
}
