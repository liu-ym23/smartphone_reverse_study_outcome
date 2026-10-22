package com.obric.aiagent.executionengine.eventstaskmanager.spi;

import android.content.Context;
import android.os.Looper;
import com.obric.aiagent.platform.depend.IAppContext;
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
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TaskApiExecution.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.spi.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskApiExecution.kt */
    @f(b = "TaskApiExecution.kt", c = {25}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.TaskApiExecutionKt$backgroundRun$2")
    static final class C0364a<T> extends l implements m<am, d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m<String, d<? super T>, Object> f17857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17858c;

        C0364a(m<? super String, ? super d<? super T>, ? extends Object> r3, String r4, d<? super C0364a> r5) {
            m<String, d<? super T>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f17857b = r6;
            this.f17858c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d<? super T> r4) {
            return ((C0364a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0364a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0364a(this.f17857b, this.f17858c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = b.a();
            int r1 = this.f17856a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r4);
            m<String, d<? super T>, Object> r5 = this.f17857b;
            String r2 = this.f17858c;
            this.f17856a = 1;
            r4 = r5.invoke(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public static final String a() {
        return com.obric.aiagent.executionengine.eventstaskmanager.timertask.a.a.f17874a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> Object a(m<? super String, ? super d<? super T>, ? extends Object> r5, d<? super T> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        String r0 = a();
        if (d.h.b.o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C0364a(r7, r0, null), m.class, "com.obric.aiagent.plugin"), r8);
    L7:
        return r7.invoke(r0, r8);
    }
}
