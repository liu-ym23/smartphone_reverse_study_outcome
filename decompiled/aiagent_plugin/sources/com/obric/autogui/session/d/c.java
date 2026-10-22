package com.obric.autogui.session.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<d.c.d<? super T>, Object> f30882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<T> f30883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Boolean> f30884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<T, x> f30885e;

    public static /* synthetic */ c a(c r6, String r7, d.h.a.b r8, d.h.a.a r9, d.h.a.a r10, d.h.a.b r11, int r12, Object r13) {
        d.h.a.b<d.c.d<? super T>, Object> r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<T> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Boolean> r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, x> r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f30881a;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r14 = r6.f30882b;
    L8:
        d.h.a.b<d.c.d<? super T>, Object> r2 = r14;
        if ((r12 & 4) == 0) goto L11;
        r15 = r6.f30883c;
    L11:
        d.h.a.a<T> r3 = r15;
        if ((r12 & 8) == 0) goto L14;
        r16 = r6.f30884d;
    L14:
        d.h.a.a<Boolean> r4 = r16;
        if ((r12 & 16) == 0) goto L18;
        r17 = r6.f30885e;
    L18:
        return r6.a(r1, r2, r3, r4, r17);
    }

    private static final boolean f() {
        return true;
    }

    public static /* synthetic */ boolean lambda$I16MpcsnRz4Udmd7vhdCGJkF6PI() {
        return f();
    }

    /* JADX INFO: renamed from: lambda$eoAwZQ9xNmGfypz4YfShrR7-QMM, reason: not valid java name */
    public static /* synthetic */ x m884lambda$eoAwZQ9xNmGfypz4YfShrR7QMM(Object r0) {
        return a(r0);
    }

    public final c<T> a(String r8, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r9, d.h.a.a<? extends T> r10, d.h.a.a<Boolean> r11, d.h.a.b<? super T, x> r12) {
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r8, "tag");
        o.e(r3, "fetch");
        o.e(r4, "fallback");
        o.e(r5, "enabled");
        o.e(r6, "onRelease");
        return new c(r8, r3, r4, r5, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f30881a, r6.f30881a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f30882b, r6.f30882b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f30883c, r6.f30883c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f30884d, r6.f30884d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f30885e, r6.f30885e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f30881a.hashCode() * 31) + this.f30882b.hashCode()) * 31) + this.f30883c.hashCode()) * 31) + this.f30884d.hashCode()) * 31) + this.f30885e.hashCode();
    }

    public String toString() {
        return "AsyncSpec(tag=" + this.f30881a + ", fetch=" + this.f30882b + ", fallback=" + this.f30883c + ", enabled=" + this.f30884d + ", onRelease=" + this.f30885e + ')';
    }

    public c(String r3, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r4, d.h.a.a<? extends T> r5, d.h.a.a<Boolean> r6, d.h.a.b<? super T, x> r7) {
        d.h.a.b<d.c.d<? super T>, Object> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<T> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Boolean> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, x> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r8, "fetch");
        o.e(r9, "fallback");
        o.e(r10, "enabled");
        o.e(r11, "onRelease");
        this.f30881a = r3;
        this.f30882b = r8;
        this.f30883c = r9;
        this.f30884d = r10;
        this.f30885e = r11;
    }

    public final String a() {
        return this.f30881a;
    }

    public final d.h.a.b<d.c.d<? super T>, Object> b() {
        return this.f30882b;
    }

    public final d.h.a.a<T> c() {
        return this.f30883c;
    }

    public /* synthetic */ c(String r8, d.h.a.b r9, d.h.a.a r10, d.h.a.a r11, d.h.a.b r12, int r13, d.h.b.h r14) {
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L5;
        r15 = $$Lambda$c$I16MpcsnRz4Udmd7vhdCGJkF6PI.INSTANCE;
    L5:
        d.h.a.a r5 = r15;
        if ((r13 & 16) == 0) goto L8;
        d.h.a.b r6 = $$Lambda$c$eoAwZQ9xNmGfypz4YfShrR7QMM.INSTANCE;
    L9:
        this(r8, r3, r4, r5, r6);
        return;
    L8:
        r6 = r16;
        goto L9
    }

    public final d.h.a.a<Boolean> d() {
        return this.f30884d;
    }

    private static final x a(Object r0) {
        return x.f38692a;
    }

    public final d.h.a.b<T, x> e() {
        return this.f30885e;
    }
}
