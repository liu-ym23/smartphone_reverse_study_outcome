package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ad implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.a.e f10122a;

    /* JADX INFO: compiled from: ProxySessionLogger.kt */
    static final class a extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10123a;

        a(String r1) {
            this.f10123a = r1;
            super(0);
        }

        public final String a() {
            return this.f10123a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ProxySessionLogger.kt */
    static final class b extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10124a;

        b(String r1) {
            this.f10124a = r1;
            super(0);
        }

        public final String a() {
            return this.f10124a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ProxySessionLogger.kt */
    static final class c extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10125a;

        c(String r1) {
            this.f10125a = r1;
            super(0);
        }

        public final String a() {
            return this.f10125a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ProxySessionLogger.kt */
    static final class d extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10126a;

        d(String r1) {
            this.f10126a = r1;
            super(0);
        }

        public final String a() {
            return this.f10126a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    public ad(com.bytedance.safetyguard.lxc.internal.a.e r3) {
        com.bytedance.safetyguard.lxc.internal.a.e r4 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "logger");
        this.f10122a = r4;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void a(String r3, String r4) {
        d.h.b.o.e(r3, "tag");
        d.h.b.o.e(r4, "message");
        this.f10122a.a(r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void b(String r3, String r4) {
        d.h.b.o.e(r3, "tag");
        d.h.b.o.e(r4, "message");
        this.f10122a.b(r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void b(String r3, String r4, Throwable r5) {
        d.h.b.o.e(r3, "tag");
        d.h.b.o.e(r4, "message");
        this.f10122a.a(r3, r5, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void a(String r3, String r4, Throwable r5) {
        d.h.b.o.e(r3, "tag");
        d.h.b.o.e(r4, "message");
        this.f10122a.b(r3, r5, (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public String a(String r1) {
        return this.f10122a.a(r1);
    }
}
