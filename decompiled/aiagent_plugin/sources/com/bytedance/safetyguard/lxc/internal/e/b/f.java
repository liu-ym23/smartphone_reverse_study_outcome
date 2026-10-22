package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class f implements SidecarOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ca f10681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f10682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f10683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<x> f10684e;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class AnonymousClass1 extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10685a = null;

        static {
            f10685a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0);
        }

        public final void a() {
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.f$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class AnonymousClass2 extends p implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f10686a;

        AnonymousClass2(f r1) {
            this.f10686a = r1;
            super(1);
        }

        public final void a(Throwable r1) {
            f.a(this.f10686a).b();
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public f(String r3, ca r4, j r5, h r6, d.h.a.a<x> r7) {
        ca r8 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "operationId");
        o.e(r8, "job");
        o.e(r5, "callbackGate");
        o.e(r6, "commitGate");
        o.e(r9, "onCancel");
        this.f10680a = r3;
        this.f10681b = r8;
        this.f10682c = r5;
        this.f10683d = r6;
        this.f10684e = r9;
        r8.a_((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ h a(f r0) {
        return r0.f10683d;
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SidecarOperation.DefaultImpls.close(this);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public String getOperationId() {
        return this.f10680a;
    }

    public /* synthetic */ f(String r8, ca r9, j r10, h r11, d.h.a.a r12, int r13, d.h.b.h r14) {
        ca r3 = (ca) ZeusTransformUtils.wrapperContextForParams(r9, ca.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r13 & 16) == 0) goto L5;
        r15 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10685a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        this(r8, r3, r10, r11, r15);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public boolean cancel() {
        if (this.f10683d.a() == true) goto L6;
        return false;
    L6:
        if (this.f10682c.a(m.f10705a.h()) == true) goto L8;
        return false;
    L8:
        this.f10684e.invoke();
        ce.a(this.f10681b, "sidecar operation cancelled", null, 2, null);
        return true;
    }
}
