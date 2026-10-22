package com.obric.aiagent.skill.virt.impl.b;

import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.c;
import com.obric.aiagent.skill.virt.api.g;
import com.obric.aiagent.skill.virt.api.h;
import com.obric.aiagent.skill.virt.api.x;
import com.obric.aiagent.skill.virt.impl.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.o;

/* JADX INFO: compiled from: VirtFiles.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IVirtService.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f22068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.impl.c.a f22069b;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VirtFiles.kt */
    @f(b = "VirtFiles.kt", c = {32}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.file.VirtFiles$exportFile$2")
    static final class C0473a extends l implements d.h.a.b<d<? super com.obric.aiagent.skill.virt.api.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f22072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f22073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.b f22074e;

        C0473a(a r3, x r4, c r5, com.obric.aiagent.skill.virt.api.b r6, d<? super C0473a> r7) {
            x r8 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
            c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f22071b = r3;
            this.f22072c = r8;
            this.f22073d = r9;
            this.f22074e = r6;
            super(1, r10);
        }

        public final Object a(d<? super com.obric.aiagent.skill.virt.api.d> r3) {
            return ((C0473a) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C0473a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(d<?> r9) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0473a(this.f22071b, this.f22072c, this.f22073d, this.f22074e, r7), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super com.obric.aiagent.skill.virt.api.d> r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22070a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            k r9 = a.a(this.f22071b);
            String r2 = this.f22072c.a();
            c r3 = this.f22073d;
            com.obric.aiagent.skill.virt.api.b r4 = this.f22074e;
            d<? super com.obric.aiagent.skill.virt.api.d> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f22070a = 1;
            r8 = r9.a(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtFiles.kt */
    @f(b = "VirtFiles.kt", c = {24}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.file.VirtFiles$importFile$2")
    static final class b extends l implements d.h.a.b<d<? super h>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f22077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f22078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.virt.api.f f22079e;

        b(a r3, g r4, x r5, com.obric.aiagent.skill.virt.api.f r6, d<? super b> r7) {
            g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
            x r9 = (x) ZeusTransformUtils.wrapperContextForParams(r5, x.class, "com.obric.aiagent.plugin");
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f22076b = r3;
            this.f22077c = r8;
            this.f22078d = r9;
            this.f22079e = r6;
            super(1, r10);
        }

        public final Object a(d<? super h> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(d<?> r9) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f22076b, this.f22077c, this.f22078d, this.f22079e, r7), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super h> r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22075a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            k r9 = a.a(this.f22076b);
            g r2 = this.f22077c;
            String r3 = this.f22078d.a();
            com.obric.aiagent.skill.virt.api.f r4 = this.f22079e;
            d<? super h> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f22075a = 1;
            r8 = r9.a(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    public a(k r3, com.obric.aiagent.skill.virt.impl.c.a r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "backend");
        d.h.b.o.e(r4, "shellManager");
        this.f22068a = r5;
        this.f22069b = r4;
    }

    public static final /* synthetic */ k a(a r0) {
        return r0.f22068a;
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.b
    public Object a(g r9, x r10, com.obric.aiagent.skill.virt.api.f r11, d<? super h> r12) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r9, g.class, "com.obric.aiagent.plugin");
        x r5 = (x) ZeusTransformUtils.wrapperContextForParams(r10, x.class, "com.obric.aiagent.plugin");
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        return this.f22069b.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this, r4, r5, r11, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r13);
    }

    @Override // com.obric.aiagent.skill.virt.api.IVirtService.b
    public Object a(x r9, c r10, com.obric.aiagent.skill.virt.api.b r11, d<? super com.obric.aiagent.skill.virt.api.d> r12) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r9, x.class, "com.obric.aiagent.plugin");
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r10, c.class, "com.obric.aiagent.plugin");
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        return this.f22069b.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0473a(this, r4, r5, r11, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r13);
    }
}
