package com.bytedance.safetyguard.lxc.internal.service;

import com.bytedance.safetyguard.lxc.api.OutboundPolicyDecision;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
interface p {

    /* JADX INFO: compiled from: ServiceProxySession.kt */
    public static final class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OutboundPolicyDecision f11042a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11042a, r6.f11042a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11042a.hashCode();
        }

        public String toString() {
            return "Completed(decision=" + this.f11042a + ')';
        }

        public a(OutboundPolicyDecision r3) {
            OutboundPolicyDecision r4 = (OutboundPolicyDecision) ZeusTransformUtils.wrapperContextForParams(r3, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "decision");
            this.f11042a = r4;
        }

        public final OutboundPolicyDecision a() {
            return this.f11042a;
        }
    }

    /* JADX INFO: compiled from: ServiceProxySession.kt */
    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11043a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f11043a, r6.f11043a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11043a.hashCode();
        }

        public String toString() {
            return "Failed(reason=" + this.f11043a + ')';
        }

        public b(String r2) {
            d.h.b.o.e(r2, "reason");
            this.f11043a = r2;
        }

        public final String a() {
            return this.f11043a;
        }
    }
}
