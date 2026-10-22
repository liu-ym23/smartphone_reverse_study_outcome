package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21550a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f21552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f21554e;

    /* JADX INFO: compiled from: ShellApi.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f21550a = new a(null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aa.class) == true) goto L8;
        return false;
    L8:
        aa r10 = (aa) ZeusTransformUtils.preCheckCast(r9, aa.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21551b, r10.f21551b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21552c, r10.f21552c) == true) goto L15;
        return false;
    L15:
        if (this.f21553d == r10.f21553d) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f21554e, r10.f21554e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f21551b.hashCode() * 31) + this.f21552c.hashCode()) * 31) + Long.hashCode(this.f21553d)) * 31;
        q r3 = this.f21554e;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "VirtSyncShellSpec(command=" + this.f21551b + ", workDir=" + this.f21552c + ", timeoutMs=" + this.f21553d + ", observation=" + this.f21554e + ')';
    }

    public aa(String r3, x r4, long r5, q r7) {
        x r6 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "command");
        d.h.b.o.e(r6, "workDir");
        this.f21551b = r3;
        this.f21552c = r6;
        this.f21553d = r5;
        this.f21554e = r7;
        boolean r8 = false;
        if (1 <= r5) goto L5;
    L7:
        if (r8 == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("VirtSyncShellSpec.timeoutMs must be in 1..60000".toString());
    L5:
        if (r5 >= 60001) goto L7;
        r8 = true;
        goto L7
    }

    public final String a() {
        return this.f21551b;
    }

    public final x b() {
        return this.f21552c;
    }

    public final long c() {
        return this.f21553d;
    }

    public final q d() {
        return this.f21554e;
    }
}
