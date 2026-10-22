package com.obric.autogui.agents;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import d.x;

/* JADX INFO: compiled from: AgentsManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "AgentsMan";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.autogui.agents.a[] f26790b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.obric.autogui.agents.a f26791c;

    /* JADX INFO: compiled from: AgentsManager.kt */
    @f(b = "AgentsManager.kt", c = {38}, d = "initAgents", e = "com.obric.autogui.agents.AgentsManager")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26796e;
        /* synthetic */ Object f;
        final /* synthetic */ b g;
        int h;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private b() {
    }

    static {
        f26789a = new b();
        com.obric.autogui.agents.a[] r0 = {new com.obric.autogui.agents.scripted.a(), new com.obric.autogui.agents.vlm.b()};
        f26790b = r0;
        f26791c = r0[1];
    }

    public final com.obric.autogui.agents.a a() {
        return f26791c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0088 -> B:20:0x008b). Please report as a decompilation issue!!! */
    public final Object a(com.obric.autogui.session.a r12, d.c.d<? super x> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f;
        Object r15 = d.c.a.b.a();
        int r2 = r0.h;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r16 = r0.f26796e;
        int r3 = r0.f26795d;
        com.obric.autogui.agents.a r4 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r0.f26794c, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a[] r5 = (com.obric.autogui.agents.a[]) ZeusTransformUtils.preCheckCast(r0.f26793b, com.obric.autogui.agents.a[].class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f26792a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L20:
        e r17 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
        if (r17.g() == true) goto L23;
        Loog.INSTANCE.e(TAG, "Cannot init agent (" + r4 + '/' + r4.getType() + "): " + r17.h());
    L23:
        r3 = r3 + 1;
        com.obric.autogui.session.a r18 = r6;
    L15:
        if (r3 >= r16) goto L25;
        r4 = r5[r3];
        r0.f26792a = r18;
        r0.f26793b = r5;
        r0.f26794c = r4;
        r0.f26795d = r3;
        r0.f26796e = r16;
        r0.h = 1;
        Object r7 = r4.a(r18, r0);
        if (r7 != r15) goto L19;
        return r15;
    L19:
        r6 = r18;
        r11 = r7;
        goto L20
    L25:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        com.obric.autogui.agents.a[] r19 = f26790b;
        r3 = 0;
        int r8 = r19.length;
        r5 = r19;
        r18 = r12;
        r16 = r8;
    L7:
        r0 = new a(this, r14);
        goto L8
    }

    public final void a(com.obric.autogui.session.a r4) {
        d.h.b.o.e(r4, SensitiveType.SESSION);
        com.obric.autogui.agents.a[] r3 = f26790b;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].a(r4);
        r1 = r1 + 1;
        goto L3
    }
}
