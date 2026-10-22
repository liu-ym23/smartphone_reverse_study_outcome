package com.obric.aiagent.skill.ovirt.impl.g;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ActiveShellExecution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.aiagent.skill.ovirt.api.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IVirtService f21346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f21349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference<com.obric.aiagent.skill.ovirt.api.b.b.c> f21350e;
    private final w<com.obric.aiagent.skill.ovirt.api.b.b.a> f;
    private final w<x> g;

    public a(IVirtService r3, String r4, String r5, i r6, com.obric.aiagent.skill.ovirt.api.b.b.c r7) {
        IVirtService r8 = (IVirtService) ZeusTransformUtils.wrapperContextForParams(r3, IVirtService.class, "com.obric.aiagent.plugin");
        o.e(r8, "virt");
        o.e(r4, "shellGroupId");
        o.e(r5, "executionId");
        o.e(r6, "outputStore");
        o.e(r7, "initialSnapshot");
        this.f21346a = r8;
        this.f21347b = r4;
        this.f21348c = r5;
        this.f21349d = r6;
        this.f21350e = new AtomicReference(r7);
        this.f = y.a(null, 1, null);
        w<x> r9 = y.a(null, 1, null);
        if (r7.f() == false) goto L5;
        r9.a(x.f38692a);
    L5:
        this.g = r9;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.b.b
    public String a() {
        return this.f21348c;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.b.b
    public Object a(d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r3) {
        d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f.a(r4);
    }

    @Override // com.obric.aiagent.skill.ovirt.api.b.b
    public com.obric.aiagent.skill.ovirt.api.b.b.c b() {
        com.obric.aiagent.skill.ovirt.api.b.b.c r0 = this.f21349d.a(a());
        if (r0 != null) goto L6;
        com.obric.aiagent.skill.ovirt.api.b.b.c r2 = this.f21350e.get();
        o.c(r2, "get(...)");
        return (com.obric.aiagent.skill.ovirt.api.b.b.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.ovirt.api.b.b.c.class, "com.obric.aiagent.plugin");
    L6:
        return r0;
    }

    public final boolean a(boolean r5) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.i("SkRt/Handle", "cancel: forwarding executionId=" + a() + " force=" + r5 + " shellGroupId=" + this.f21347b);
    L7:
        return this.f21346a.getShell().a(a(), r5);
    L5:
        ILogDepend.Companion.i("SkRt/Handle", "cancel: forwarding force=" + r5);
        goto L7
    }

    public final Object b(d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.g.a(r4);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    public final void a(com.obric.aiagent.skill.ovirt.api.b.b.c r2) {
        o.e(r2, "snapshot");
        this.f21350e.set(r2);
        if (r2.f() == false) goto L6;
        this.g.a(x.f38692a);
        return;
    }

    public final void a(com.obric.aiagent.skill.ovirt.api.b.b.a r2) {
        o.e(r2, "result");
        a(r2.a());
        this.f.a(r2);
    }

    public final void a(Throwable r2) {
        o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
        this.f.a(r2);
        this.g.a(x.f38692a);
    }

    public final void c() {
        this.g.a(x.f38692a);
    }
}
