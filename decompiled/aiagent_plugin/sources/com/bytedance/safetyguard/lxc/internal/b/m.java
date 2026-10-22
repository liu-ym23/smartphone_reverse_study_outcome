package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
/* JADX INFO: loaded from: classes.dex */
public interface m {

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f9773a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9773a, r6.f9773a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f9773a.hashCode();
        }

        public String toString() {
            return "Allowed(target=" + this.f9773a + ')';
        }

        public a(q r2) {
            d.h.b.o.e(r2, "target");
            this.f9773a = r2;
        }

        public final q a() {
            return this.f9773a;
        }
    }

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f9774a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9774a, r6.f9774a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f9774a.hashCode();
        }

        public String toString() {
            return "Denied(failure=" + this.f9774a + ')';
        }

        public b(j r2) {
            d.h.b.o.e(r2, "failure");
            this.f9774a = r2;
        }

        public final j a() {
            return this.f9774a;
        }
    }

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g.a f9775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.c.c f9776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f9777c;

        public c(g.a r2, com.bytedance.safetyguard.lxc.internal.c.c r3, Object r4) {
            d.h.b.o.e(r2, "target");
            d.h.b.o.e(r3, "ingressProxy");
            d.h.b.o.e(r4, "owner");
            this.f9775a = r2;
            this.f9776b = r3;
            this.f9777c = r4;
        }

        public final g.a a() {
            return this.f9775a;
        }

        public final com.bytedance.safetyguard.lxc.internal.c.c b() {
            return this.f9776b;
        }

        public final Object c() {
            return this.f9777c;
        }
    }

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public static final class d implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f9778a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9778a, r6.f9778a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f9778a.hashCode();
        }

        public String toString() {
            return "SidecarAuth(target=" + this.f9778a + ')';
        }

        public d(q r2) {
            d.h.b.o.e(r2, "target");
            this.f9778a = r2;
        }
    }
}
