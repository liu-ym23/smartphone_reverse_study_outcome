package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OutboundPolicyApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OutboundPolicyDecision {

    /* JADX INFO: compiled from: OutboundPolicyApi.kt */
    public static final class Allow implements OutboundPolicyDecision {
        public static final Allow INSTANCE = null;

        static {
            INSTANCE = new Allow();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, Allow.class) == true) goto L9;
            return false;
        L9:
            Allow r2 = (Allow) ZeusTransformUtils.preCheckCast(r3, Allow.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1435834383;
        }

        public String toString() {
            return "Allow";
        }

        private Allow() {
        }
    }

    /* JADX INFO: compiled from: OutboundPolicyApi.kt */
    public static final class Deny implements OutboundPolicyDecision {
        private final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public Deny() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Deny copy$default(Deny r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.reason;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.reason;
        }

        public final Deny copy(String r1) {
            o.e(r1, "reason");
            return new Deny(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Deny.class) == true) goto L8;
            return false;
        L8:
            Deny r6 = (Deny) ZeusTransformUtils.preCheckCast(r5, Deny.class, "com.obric.aiagent.plugin");
            if (o.a(this.reason, r6.reason) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Deny(reason=" + this.reason + ')';
        }

        public Deny(String r2) {
            o.e(r2, "reason");
            this.reason = r2;
        }

        public /* synthetic */ Deny(String r1, int r2, h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = "Policy denied";
        L5:
            this(r1);
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: OutboundPolicyApi.kt */
    public static final class SidecarAuth implements OutboundPolicyDecision {
        public static final SidecarAuth INSTANCE = null;

        static {
            INSTANCE = new SidecarAuth();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, SidecarAuth.class) == true) goto L9;
            return false;
        L9:
            SidecarAuth r2 = (SidecarAuth) ZeusTransformUtils.preCheckCast(r3, SidecarAuth.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 890819243;
        }

        public String toString() {
            return "SidecarAuth";
        }

        private SidecarAuth() {
        }
    }
}
