package com.obric.autoaction.vdplayer.legacy.a.b;

import com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: SecureLayerUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f25664a;

    /* JADX INFO: compiled from: SecureLayerUseCase.kt */
    @d.c.b.a.f(b = "SecureLayerUseCase.kt", c = {23}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.domain.data.SecureLayerUseCase$observeSecureChanged$1")
    static final class a extends l implements m<q<? super Boolean>, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f25666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f25667c;

        a(b r3, d<? super a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f25666b = r3;
            super(2, r5);
        }

        public static /* synthetic */ x lambda$AALOkAqxBzDhP39IWaKkk5lQEhU(b r0) {
            return a(r0);
        }

        public static /* synthetic */ x lambda$ySKPe6QxjLz9nI0E58Zt3x4VEsM(q r0, boolean r1) {
            return a(r0, r1);
        }

        public final Object a(q<? super Boolean> r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f25666b, r5);
            r0.f25667c = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(q<? super Boolean> r3, d<? super x> r4) {
            return a((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25665a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            final q r7 = (q) ZeusTransformUtils.preCheckCast(this.f25667c, q.class, "com.obric.aiagent.plugin");
            d.h.a.b<? super Boolean, x> r2 = new $$Lambda$b$a$ySKPe6QxjLz9nI0E58Zt3x4VEsM(r7);
            IVirtualDisplayApi r4 = b.a(this.f25666b);
            if (r4 == null) goto L11;
            r4.registerSecureChangedListener(r2);
        L11:
            r7.a_(d.c.b.a.b.a(this.f25666b.a()));
            final b r3 = this.f25666b;
            d.h.a.a r5 = new $$Lambda$b$a$AALOkAqxBzDhP39IWaKkk5lQEhU(r3);
            d r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25665a = 1;
            if (kotlinx.coroutines.a.o.a(r7, r5, r8) != r0) goto L15;
            return r0;
        }

        private static final x a(q r2, boolean r3) {
            ((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin")).a_(Boolean.valueOf(r3));
            return x.f38692a;
        }

        private static final x a(b r1) {
            IVirtualDisplayApi r2 = b.a(r1);
            if (r2 == null) goto L6;
            r2.registerSecureChangedListener(null);
        L6:
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: lambda$PSgtN_ZNWUUuGsls-dZZlhbTdzE, reason: not valid java name */
    public static /* synthetic */ IVirtualDisplayApi m688lambda$PSgtN_ZNWUUuGslsdZZlhbTdzE() {
        return d();
    }

    public b() {
        this.f25664a = g.a($$Lambda$b$PSgtN_ZNWUUuGslsdZZlhbTdzE.INSTANCE);
    }

    public static final /* synthetic */ IVirtualDisplayApi a(b r0) {
        return r0.c();
    }

    private final IVirtualDisplayApi c() {
        return (IVirtualDisplayApi) ZeusTransformUtils.preCheckCast(this.f25664a.b(), IVirtualDisplayApi.class, "com.obric.aiagent.plugin");
    }

    public final boolean a() {
        IVirtualDisplayApi r2 = c();
        if (r2 == null) goto L8;
        if (r2.getIsSecureLayer() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public final h<Boolean> b() {
        return j.c((m) ZeusTransformUtils.preCheckCast(new a(this, null), m.class, "com.obric.aiagent.plugin"));
    }

    private static final IVirtualDisplayApi d() {
        return (IVirtualDisplayApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtualDisplayApi.class), IVirtualDisplayApi.class, "com.obric.aiagent.plugin");
    }
}
