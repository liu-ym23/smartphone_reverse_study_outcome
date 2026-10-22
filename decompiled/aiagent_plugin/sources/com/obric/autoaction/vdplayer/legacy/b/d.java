package com.obric.autoaction.vdplayer.legacy.b;

import androidx.lifecycle.aj;
import com.obric.autoaction.vdplayer.legacy.b.a;
import com.obric.autoaction.vdplayer.legacy.b.b;
import com.obric.autoaction.vdplayer.legacy.b.c;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: MviViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<S extends c, I extends b, E extends com.obric.autoaction.vdplayer.legacy.b.a> extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x<S> f25668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ak<S> f25669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w<E> f25670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ab<E> f25671d;

    /* JADX INFO: compiled from: MviViewModel.kt */
    @f(b = "MviViewModel.kt", c = {25}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.mvi.MviViewModel$dispatch$1")
    static final class a extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d<S, I, E> f25673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ I f25674c;

        a(d<S, I, E> r3, I r4, d.c.d<? super a> r5) {
            I r6 = (I) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25673b = r3;
            this.f25674c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f25673b, this.f25674c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25672a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d<S, I, E> r7 = this.f25673b;
            I r2 = this.f25674c;
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25672a = 1;
            if (r7.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public S a(S r2, S r3) {
        c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        S r4 = (S) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "oldState");
        d.h.b.o.e(r4, "state");
        return r4;
    }

    public abstract Object a(I r1, d.c.d<? super d.x> r2);

    public d(S r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "initialState");
        x<S> r6 = kotlinx.coroutines.b.am.a(r5);
        this.f25668a = r6;
        this.f25669b = j.a(r6);
        w<E> r7 = ad.a(0, 64, null, 4, null);
        this.f25670c = r7;
        this.f25671d = j.a(r7);
    }

    public final ak<S> b() {
        return this.f25669b;
    }

    public final ab<E> c() {
        return this.f25671d;
    }

    public final void a(I r9) {
        b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, MemorySourceLinkType.INTENT);
        i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new a(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(d.h.a.b<? super S, ? extends S> r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "reducer");
        x<S> r0 = this.f25668a;
    L3:
        S r2 = r0.c();
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if (r0.a(r2, (S) a(r3, (c) ZeusTransformUtils.preCheckCast(r8.invoke(r3), c.class, "com.obric.aiagent.plugin"))) == false) goto L3;
    }

    public final void a(E r3) {
        com.obric.autoaction.vdplayer.legacy.b.a r4 = (com.obric.autoaction.vdplayer.legacy.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.vdplayer.legacy.b.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "effect");
        this.f25670c.a((E) r4);
    }
}
