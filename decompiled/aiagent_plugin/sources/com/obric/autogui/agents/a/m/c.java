package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f26656a;

    public static /* synthetic */ boolean lambda$GWRBfz1EGNIrklfcyfDr2a5opG0(a r0, b r1) {
        return a(r0, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26656a, r6.f26656a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f26656a.hashCode();
    }

    public String toString() {
        return "ActionEffectBlockingTiming(stages=" + this.f26656a + ')';
    }

    public c(List<b> r3) {
        List<b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "stages");
        this.f26656a = r4;
    }

    public final long a() {
        return a(a.f26647a);
    }

    public final long b() {
        return a(a.f26648b);
    }

    public final long c() {
        return a(a.f26649c);
    }

    public final long d() {
        return a(a.f26650d);
    }

    public final long e() {
        return (b() + c()) + d();
    }

    public final long f() {
        return a(a.f);
    }

    public final long g() {
        return a(a.f26651e);
    }

    public final long h() {
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f26656a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r4 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r4 = r4 + d.l.n.a(((b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin")).c(), 0);
        goto L4
    L6:
        return r4;
    }

    private final long a(final a r9) {
        Iterator r8 = d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(this.f26656a, Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$c$GWRBfz1EGNIrklfcyfDr2a5opG0(r9)).a();
        long r4 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r4 = r4 + d.l.n.a(((b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.aiagent.plugin")).c(), 0);
        goto L4
    L6:
        return r4;
    }

    private static final boolean a(a r1, b r2) {
        d.h.b.o.e(r2, "it");
        if (r2.b() != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
