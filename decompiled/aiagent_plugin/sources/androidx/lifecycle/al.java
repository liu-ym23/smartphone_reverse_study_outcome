package androidx.lifecycle;

import androidx.lifecycle.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class al<VM extends aj> implements d.f<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.m.c<VM> f2019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<ao> f2020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<am.b> f2021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<androidx.lifecycle.a.a> f2022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private VM f2023e;

    /* JADX INFO: renamed from: androidx.lifecycle.al$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewModelLazy.kt */
    static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<androidx.lifecycle.a.a.C0057a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f2024a = null;

        static {
            f2024a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0);
        }

        public final androidx.lifecycle.a.a.C0057a a() {
            return androidx.lifecycle.a.a.C0057a.f1967a;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a.C0057a invoke() {
            return a();
        }
    }

    public al(d.m.c<VM> r10, d.h.a.a<? extends ao> r11, d.h.a.a<? extends am.b> r12) {
        d.m.c r3 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r10, d.m.c.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "viewModelClass");
        d.h.b.o.e(r4, "storeProducer");
        d.h.b.o.e(r5, "factoryProducer");
        this(r3, r4, r5, null, 8, null);
    }

    public al(d.m.c<VM> r3, d.h.a.a<? extends ao> r4, d.h.a.a<? extends am.b> r5, d.h.a.a<? extends androidx.lifecycle.a.a> r6) {
        d.m.c<VM> r7 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        d.h.a.a<ao> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<am.b> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<androidx.lifecycle.a.a> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "viewModelClass");
        d.h.b.o.e(r8, "storeProducer");
        d.h.b.o.e(r9, "factoryProducer");
        d.h.b.o.e(r10, "extrasProducer");
        this.f2019a = r7;
        this.f2020b = r8;
        this.f2021c = r9;
        this.f2022d = r10;
    }

    @Override // d.f
    public /* synthetic */ Object b() {
        return a();
    }

    public /* synthetic */ al(d.m.c r2, d.h.a.a r3, d.h.a.a r4, d.h.a.a r5, int r6, d.h.b.h r7) {
        d.m.c r8 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f2024a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        this(r8, r9, r10, r11);
    }

    public VM a() {
        VM r0 = this.f2023e;
        if (r0 != null) goto L6;
        am.b r1 = (am.b) ZeusTransformUtils.preCheckCast(this.f2021c.invoke(), am.b.class, "com.obric.aiagent.plugin");
        VM r2 = (VM) new am((ao) ZeusTransformUtils.preCheckCast(this.f2020b.invoke(), ao.class, "com.obric.aiagent.plugin"), r1, (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(this.f2022d.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin")).a(d.h.a.a(this.f2019a));
        this.f2023e = r2;
        return r2;
    L6:
        return r0;
    }
}
