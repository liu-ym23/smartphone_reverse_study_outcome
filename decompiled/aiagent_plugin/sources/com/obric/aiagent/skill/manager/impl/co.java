package com.obric.aiagent.skill.manager.impl;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SkillInstallTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cl f19685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final hd f19686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ea f19687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<Boolean> f19688e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;

    /* JADX INFO: compiled from: SkillInstallTracking.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final co a(cl r18, hd r19, d.h.a.a<Boolean> r20) {
            d.h.a.a r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r18, "context");
            d.h.b.o.e(r19, "reporter");
            d.h.b.o.e(r14, "fileDownloadedProvider");
            r19.a(r18);
            dy r3 = dy.f19788c;
            String r0 = r18.f();
            if (r0 != null) goto L6;
            r0 = eb.a();
        L6:
            return new co(r18, r19, new ea(r3, r19, r0, 0, null, 0, false, 120, null), r14, null);
        }
    }

    static {
        f19684a = new a(null);
    }

    public /* synthetic */ co(cl r2, hd r3, ea r4, d.h.a.a r5, d.h.b.h r6) {
        this(r2, r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private co(cl r3, hd r4, ea r5, d.h.a.a<Boolean> r6) {
        d.h.a.a<Boolean> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        this.f19685b = r3;
        this.f19686c = r4;
        this.f19687d = r5;
        this.f19688e = r7;
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
    }

    public final String a() {
        return this.f19687d.a();
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r2) {
        d.h.b.o.e(r2, "savedSkill");
        b(r2);
        c(r2);
    }

    public final void b(com.obric.aiagent.skill.manager.api.e r13) {
        d.h.b.o.e(r13, "savedSkill");
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        hd.a(this.f19686c, cl.a(this.f19685b, null, r13.b(), r13.a(), null, null, null, null, 121, null), ck.f19670a, null, 4, null);
    }

    public final void c(com.obric.aiagent.skill.manager.api.e r17) {
        d.h.b.o.e(r17, "savedSkill");
        if (this.g.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ea.a(this.f19687d, dz.f19791a, r17, null, null, null, null, null, null, null, null, cn.a(this.f19685b), DownloadErrorCode.ERROR_THREAD_INTERRUPT, null);
    }

    public final void a(cj r21, Throwable r22) {
        d.h.b.o.e(r21, "stage");
        d.h.b.o.e(r22, "throwable");
        boolean r4 = false;
        if (this.f.compareAndSet(false, true) == false) goto L14;
        ci r6 = cn.a(this.f19685b.a(), r21, r22);
        this.f19686c.a(this.f19685b, ck.f19671b, r6);
        hd r7 = this.f19686c;
        cl r8 = this.f19685b;
        d.h.a.a<Boolean> r0 = this.f19688e;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r1 = d.n.f(r0.invoke());     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r1) == false) goto L12;
        r1 = null;
    L12:
        r7.a(r8, r6, (Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.aiagent.plugin"));
    L7:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
    L14:
        if (this.g.compareAndSet(false, true) == false) goto L22;
        ea r11 = this.f19687d;
        dz r12 = dz.f19792b;
        String r13 = this.f19685b.c();
        dw r14 = eb.a(r22);
        String r15 = cn.a(r21);
        if (r21 != cj.f19665a) goto L18;
        r4 = true;
    L18:
        ea.a(r11, r12, null, r13, null, null, null, r14, r15, Boolean.valueOf(r4), null, cn.a(this.f19685b), 570, null);
        return;
    }

    public final void b() {
        this.f.compareAndSet(false, true);
        if (this.g.compareAndSet(false, true) == false) goto L6;
        ea.a(this.f19687d, dz.f19793c, null, this.f19685b.c(), null, null, null, dw.n, null, null, null, cn.a(this.f19685b), 954, null);
        return;
    }
}
