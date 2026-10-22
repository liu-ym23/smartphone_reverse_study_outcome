package com.obric.autogui.util.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ThreadUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ThreadUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final am f31518a = null;

    /* JADX INFO: renamed from: com.obric.autogui.util.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ThreadUtil.kt */
    @f(b = "ThreadUtil.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.util.thread.ThreadUtilKt$runOnMainThread$1")
    static final class C0865a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f31520b;

        C0865a(Runnable r3, d<? super C0865a> r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f31520b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0865a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0865a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0865a(this.f31520b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            b.a();
            if (this.f31519a != 0) goto L7;
            o.a(r2);
            this.f31520b.run();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f31518a = an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(Runnable r8) {
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "runnable");
        i.a(f31518a, null, null, (m) ZeusTransformUtils.preCheckCast(new C0865a(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final Object a(long r2, d<? super x> r4) {
        Object r3 = ax.a(r2, (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
        if (r3 != b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }
}
