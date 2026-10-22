package com.obric.assistant.dm.api.statemachine.core;

import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<S extends State, E extends DMEvent> implements f<S, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends S> f22464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends S> f22465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<? extends E> f22466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m<S, E, S> f22467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m<S, E, Boolean> f22468e;

    private static final boolean d(State r1, DMEvent r2) {
        o.e(r1, "<unused var>");
        o.e(r2, "<unused var>");
        return true;
    }

    public static /* synthetic */ boolean lambda$NTgJCYatUo8tHODDF7fDaKxCA1Q(State r0, DMEvent r1) {
        return d(r0, r1);
    }

    public c(Class<? extends S> r3, Class<? extends S> r4, Class<? extends E> r5, m<? super S, ? super E, ? extends S> r6, m<? super S, ? super E, Boolean> r7) {
        m<S, E, S> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
        m<S, E, Boolean> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
        o.e(r3, "fromState");
        o.e(r4, "toState");
        o.e(r5, "triggerEvent");
        o.e(r8, "transitionLogic");
        o.e(r9, "canTransitionLogic");
        this.f22464a = r3;
        this.f22465b = r4;
        this.f22466c = r5;
        this.f22467d = r8;
        this.f22468e = r9;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public void a(S r1, S r2, E r3) {
        f.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public void c(S r1, E r2) {
        f.a.a(this, r1, r2);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public Class<? extends S> a() {
        return this.f22464a;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public Class<? extends S> b() {
        return this.f22465b;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public Class<? extends E> c() {
        return this.f22466c;
    }

    public /* synthetic */ c(Class r8, Class r9, Class r10, m r11, m r12, int r13, h r14) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
        m r15 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.aiagent.plugin");
        if ((r13 & 16) == 0) goto L5;
        r15 = $$Lambda$c$NTgJCYatUo8tHODDF7fDaKxCA1Q.INSTANCE;
    L5:
        this(r8, r9, r10, r5, r15);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public boolean a(S r2, E r3) {
        o.e(r2, "currentState");
        o.e(r3, "event");
        if (ZeusTransformUtils.instanceOf(a(), r2) == true) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(c(), r3) == false) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f22468e.invoke(r2, r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L9;
        return true;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.f
    public S b(S r2, E r3) {
        o.e(r2, "currentState");
        o.e(r3, "event");
        return (S) ZeusTransformUtils.preCheckCast(this.f22467d.invoke(r2, r3), State.class, "com.obric.aiagent.plugin");
    }
}
