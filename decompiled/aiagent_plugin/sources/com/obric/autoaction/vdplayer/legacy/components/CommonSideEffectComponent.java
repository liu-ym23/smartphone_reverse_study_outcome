package com.obric.autoaction.vdplayer.legacy.components;

import androidx.lifecycle.p;
import com.obric.autoaction.a.f;
import com.obric.autoaction.vdplayer.legacy.d.q;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: CommonSideEffectComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CommonSideEffectComponent implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.h.a.a<x> f25707a;

    /* JADX INFO: compiled from: CommonSideEffectComponent.kt */
    @d.c.b.a.f(b = "CommonSideEffectComponent.kt", c = {26}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.CommonSideEffectComponent$onAttach$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonSideEffectComponent f25711d;

        a(u r3, com.obric.autoaction.a.c r4, CommonSideEffectComponent r5, d<? super a> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f25709b = r3;
            this.f25710c = r4;
            this.f25711d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f25709b, this.f25710c, this.f25711d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25708a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ab<q> r7 = this.f25709b.c();
            final com.obric.autoaction.a.c r3 = this.f25710c;
            final CommonSideEffectComponent r4 = this.f25711d;
            i<? super q> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), i.class, "com.obric.aiagent.plugin");
            d<?> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25708a = 1;
            if (r7.collect(r2, r5) != r0) goto L12;
            return r0;
        }
    }

    public CommonSideEffectComponent() {
    }

    public static final /* synthetic */ void a(CommonSideEffectComponent r2, d.h.a.a r3) {
        r2.f25707a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r10) {
        d.h.b.o.e(r10, "componentHost");
        f.a.a(this, r10);
        u r0 = (u) ZeusTransformUtils.preCheckCast(r10.c().a(u.class), u.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(r10.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r0, r10, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // androidx.lifecycle.d
    public void d(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.d(r4);
        d.h.a.a<x> r5 = this.f25707a;
        if (r5 == null) goto L5;
        r5.invoke();
    L5:
        this.f25707a = null;
    }
}
