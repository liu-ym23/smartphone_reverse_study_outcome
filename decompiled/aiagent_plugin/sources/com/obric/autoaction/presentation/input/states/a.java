package com.obric.autoaction.presentation.input.states;

import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.g;
import d.h.b.o;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: AssistInputState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements com.obric.autogui.util.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IAssistInputStateManager.StateType f24964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private am f24965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, ? extends Object> f24966c;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistInputState.kt */
    @f(b = "AssistInputState.kt", c = {32}, d = "beforeEnter$suspendImpl", e = "com.obric.autoaction.presentation.input.states.AssistInputState")
    static final class C0584a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24970d;

        C0584a(a r3, d.c.d<? super C0584a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24969c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24968b = r3;
            this.f24970d |= Integer.MIN_VALUE;
            return a.a(this.f24969c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.util.c.b
    public Object a(com.obric.autogui.util.c.b r3, d.c.d<? super x> r4) {
        return a(this, (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a(IAssistInputStateManager.StateType r2) {
        o.e(r2, "type");
        this.f24964a = r2;
    }

    @Override // com.obric.autogui.util.c.b
    public void c() {
        com.obric.autogui.util.c.b.a.a(this);
    }

    public final IAssistInputStateManager.StateType getType() {
        return this.f24964a;
    }

    public final am a() {
        return this.f24965b;
    }

    public final void a(Map<String, ? extends Object> r3) {
        this.f24966c = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<String, Object> b() {
        return this.f24966c;
    }

    @Override // com.obric.autogui.util.c.b
    public void a(com.obric.autogui.util.c.b r3) {
        o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "toState");
        am r4 = this.f24965b;
        if (r4 == null) goto L5;
        an.a(r4, null, 1, null);
    L5:
        this.f24965b = null;
    }

    static /* synthetic */ Object a(a r5, com.obric.autogui.util.c.b r6, d.c.d<? super x> r7) {
        com.obric.autogui.util.c.b r8 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0584a.class) == false) goto L7;
        C0584a r0 = (C0584a) ZeusTransformUtils.preCheckCast(r9, C0584a.class, "com.obric.aiagent.plugin");
        if ((r0.f24970d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24970d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f24968b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24970d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (a) ZeusTransformUtils.preCheckCast(r0.f24967a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L17:
        r5.f24965b = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin")));
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        r0.f24967a = r5;
        r0.f24970d = 1;
        if (com.obric.autogui.util.c.b.a.a(r5, r8, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new C0584a(r5, r9);
        goto L8
    }
}
