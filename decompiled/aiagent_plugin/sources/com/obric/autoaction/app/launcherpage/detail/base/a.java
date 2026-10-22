package com.obric.autoaction.app.launcherpage.detail.base;

import androidx.lifecycle.p;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DetailContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.detail.base.b.d f23234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f23235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f23236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f23238e;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DetailContext.kt */
    public static final class C0505a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f23239a;

        C0505a(a r1) {
            this.f23239a = r1;
        }

        @Override // com.obric.autoaction.app.launcherpage.detail.base.b
        public EventTask a() {
            return a.a(this.f23239a).l();
        }

        @Override // com.obric.autoaction.app.launcherpage.detail.base.b
        public EventTask b() {
            return a.a(this.f23239a).m();
        }

        @Override // com.obric.autoaction.app.launcherpage.detail.base.b
        public String c() {
            return a.a(this.f23239a).o();
        }

        @Override // com.obric.autoaction.app.launcherpage.detail.base.b
        public String d() {
            return a.a(this.f23239a).i();
        }
    }

    public a(com.obric.autoaction.app.launcherpage.detail.base.b.d r3, d r4, p r5, String r6) {
        com.obric.autoaction.app.launcherpage.detail.base.b.d r7 = (com.obric.autoaction.app.launcherpage.detail.base.b.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.b.d.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
        o.e(r7, "viewModel");
        o.e(r8, "host");
        o.e(r9, "lifecycleOwner");
        this.f23234a = r7;
        this.f23235b = r8;
        this.f23236c = r9;
        this.f23237d = r6;
        this.f23238e = (b) ZeusTransformUtils.preCheckCast(new C0505a(this), b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.b.d a(a r0) {
        return r0.f23234a;
    }

    public final d a() {
        return this.f23235b;
    }

    public final p b() {
        return this.f23236c;
    }

    public final b c() {
        return this.f23238e;
    }

    public final void a(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        this.f23234a.a(r4);
    }
}
