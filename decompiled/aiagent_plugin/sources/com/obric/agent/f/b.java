package com.obric.agent.f;

import com.obric.agent.e;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: InternalIntentProcessorCenter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f14548b = null;

    /* JADX INFO: compiled from: InternalIntentProcessorCenter.kt */
    @d.c.b.a.f(b = "InternalIntentProcessorCenter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.internal.InternalIntentProcessorCenter$process$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.f.a f14550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f14551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14552d;

        a(com.obric.agent.f.a r3, IntentAppAction r4, String r5, d<? super a> r6) {
            com.obric.agent.f.a r7 = (com.obric.agent.f.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.f.a.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f14550b = r7;
            this.f14551c = r4;
            this.f14552d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f14550b, this.f14551c, this.f14552d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14549a != 0) goto L7;
            o.a(r2);
            this.f14550b.b(this.f14551c, this.f14552d);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ List lambda$_CXW5OZbjtyfZYeEbr3BbcWP5BA() {
        return b();
    }

    private b() {
    }

    static {
        f14547a = new b();
        f14548b = g.a($$Lambda$b$_CXW5OZbjtyfZYeEbr3BbcWP5BA.INSTANCE);
    }

    private final List<com.obric.agent.f.a> a() {
        return (List) ZeusTransformUtils.preCheckCast(f14548b.b(), List.class, "com.obric.aiagent.plugin");
    }

    private static final List b() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r0.add(new c());
        return r0;
    }

    public final boolean a(IntentAppAction r10, String r11) {
        d.h.b.o.e(r10, "action");
        d.h.b.o.e(r11, "actionName");
        Iterator<com.obric.agent.f.a> r9 = a().iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        com.obric.agent.f.a r0 = (com.obric.agent.f.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.agent.f.a.class, "com.obric.aiagent.plugin");
        if (r0.a(r10, r11) == false) goto L4;
        i.a(e.f14435a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r0, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return true;
    L9:
        return false;
    }
}
