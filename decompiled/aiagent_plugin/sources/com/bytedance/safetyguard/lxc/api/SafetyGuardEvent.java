package com.bytedance.safetyguard.lxc.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardEvents.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SafetyGuardEvent {

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class ProxySessionClosed implements SafetyGuardEvent {
        private final ProxySessionResult result;

        public static /* synthetic */ ProxySessionClosed copy$default(ProxySessionClosed r0, ProxySessionResult r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.result;
        L6:
            return r0.copy(r1);
        }

        public final ProxySessionResult component1() {
            return this.result;
        }

        public final ProxySessionClosed copy(ProxySessionResult r1) {
            o.e(r1, "result");
            return new ProxySessionClosed(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ProxySessionClosed.class) == true) goto L8;
            return false;
        L8:
            ProxySessionClosed r6 = (ProxySessionClosed) ZeusTransformUtils.preCheckCast(r5, ProxySessionClosed.class, "com.obric.aiagent.plugin");
            if (o.a(this.result, r6.result) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "ProxySessionClosed(result=" + this.result + ')';
        }

        public ProxySessionClosed(ProxySessionResult r2) {
            o.e(r2, "result");
            this.result = r2;
        }

        public final ProxySessionResult getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class ProxySessionError implements SafetyGuardEvent {
        private final String message;
        private final String sessionId;

        public static /* synthetic */ ProxySessionError copy$default(ProxySessionError r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.sessionId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.message;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final String component2() {
            return this.message;
        }

        public final ProxySessionError copy(String r1, String r2) {
            o.e(r1, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r2, "message");
            return new ProxySessionError(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ProxySessionError.class) == true) goto L8;
            return false;
        L8:
            ProxySessionError r6 = (ProxySessionError) ZeusTransformUtils.preCheckCast(r5, ProxySessionError.class, "com.obric.aiagent.plugin");
            if (o.a(this.sessionId, r6.sessionId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.message, r6.message) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.sessionId.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            return "ProxySessionError(sessionId=" + this.sessionId + ", message=" + this.message + ')';
        }

        public ProxySessionError(String r2, String r3) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r3, "message");
            this.sessionId = r2;
            this.message = r3;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class ProxySessionReady implements SafetyGuardEvent {
        private final ProxyReady ready;

        public static /* synthetic */ ProxySessionReady copy$default(ProxySessionReady r0, ProxyReady r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.ready;
        L6:
            return r0.copy(r1);
        }

        public final ProxyReady component1() {
            return this.ready;
        }

        public final ProxySessionReady copy(ProxyReady r1) {
            o.e(r1, "ready");
            return new ProxySessionReady(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ProxySessionReady.class) == true) goto L8;
            return false;
        L8:
            ProxySessionReady r6 = (ProxySessionReady) ZeusTransformUtils.preCheckCast(r5, ProxySessionReady.class, "com.obric.aiagent.plugin");
            if (o.a(this.ready, r6.ready) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.ready.hashCode();
        }

        public String toString() {
            return "ProxySessionReady(ready=" + this.ready + ')';
        }

        public ProxySessionReady(ProxyReady r2) {
            o.e(r2, "ready");
            this.ready = r2;
        }

        public final ProxyReady getReady() {
            return this.ready;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class ProxySessionRecovered implements SafetyGuardEvent {
        private final ProxyReady ready;

        public static /* synthetic */ ProxySessionRecovered copy$default(ProxySessionRecovered r0, ProxyReady r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.ready;
        L6:
            return r0.copy(r1);
        }

        public final ProxyReady component1() {
            return this.ready;
        }

        public final ProxySessionRecovered copy(ProxyReady r1) {
            o.e(r1, "ready");
            return new ProxySessionRecovered(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ProxySessionRecovered.class) == true) goto L8;
            return false;
        L8:
            ProxySessionRecovered r6 = (ProxySessionRecovered) ZeusTransformUtils.preCheckCast(r5, ProxySessionRecovered.class, "com.obric.aiagent.plugin");
            if (o.a(this.ready, r6.ready) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.ready.hashCode();
        }

        public String toString() {
            return "ProxySessionRecovered(ready=" + this.ready + ')';
        }

        public ProxySessionRecovered(ProxyReady r2) {
            o.e(r2, "ready");
            this.ready = r2;
        }

        public final ProxyReady getReady() {
            return this.ready;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class ProxySessionRecovering implements SafetyGuardEvent {
        private final String sessionId;

        public static /* synthetic */ ProxySessionRecovering copy$default(ProxySessionRecovering r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.sessionId;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final ProxySessionRecovering copy(String r1) {
            o.e(r1, ObricMemoryConstants.KEY_SESSION_ID);
            return new ProxySessionRecovering(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ProxySessionRecovering.class) == true) goto L8;
            return false;
        L8:
            ProxySessionRecovering r6 = (ProxySessionRecovering) ZeusTransformUtils.preCheckCast(r5, ProxySessionRecovering.class, "com.obric.aiagent.plugin");
            if (o.a(this.sessionId, r6.sessionId) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return "ProxySessionRecovering(sessionId=" + this.sessionId + ')';
        }

        public ProxySessionRecovering(String r2) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            this.sessionId = r2;
        }

        public final String getSessionId() {
            return this.sessionId;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class ProxySessionStarted implements SafetyGuardEvent {
        private final String sessionId;

        public static /* synthetic */ ProxySessionStarted copy$default(ProxySessionStarted r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.sessionId;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final ProxySessionStarted copy(String r1) {
            o.e(r1, ObricMemoryConstants.KEY_SESSION_ID);
            return new ProxySessionStarted(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ProxySessionStarted.class) == true) goto L8;
            return false;
        L8:
            ProxySessionStarted r6 = (ProxySessionStarted) ZeusTransformUtils.preCheckCast(r5, ProxySessionStarted.class, "com.obric.aiagent.plugin");
            if (o.a(this.sessionId, r6.sessionId) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return "ProxySessionStarted(sessionId=" + this.sessionId + ')';
        }

        public ProxySessionStarted(String r2) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            this.sessionId = r2;
        }

        public final String getSessionId() {
            return this.sessionId;
        }
    }
}
