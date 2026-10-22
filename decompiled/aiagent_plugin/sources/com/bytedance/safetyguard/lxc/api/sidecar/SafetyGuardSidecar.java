package com.bytedance.safetyguard.lxc.api.sidecar;

import com.bytedance.safetyguard.lxc.internal.e.b.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: SafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SafetyGuardSidecar {

    /* JADX INFO: compiled from: SafetyGuardSidecar.kt */
    public static final class DefaultImpls {
        public static Object configuredApp(SafetyGuardSidecar r2, d<? super SidecarAppInfo> r3) {
            SafetyGuardSidecar r4 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static int getVersion(SafetyGuardSidecar r2) {
            SafetyGuardSidecar r3 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            return 2;
        }

        public static SidecarOperation configCreateApp(SafetyGuardSidecar r9, String r10, SidecarDeviceFlowCallback r11) {
            SafetyGuardSidecar r12 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r9, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            SidecarDeviceFlowCallback r13 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r11, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
            o.e(r10, "production");
            o.e(r13, "callback");
            r13.onComplete(m.a(m.f10705a, "config", "app_registration_unsupported", "sidecar configCreateApp is not supported", null, 8, null));
            return (SidecarOperation) ZeusTransformUtils.preCheckCast(new CompletedSidecarOperation("config-create-app-unsupported"), SidecarOperation.class, "com.obric.aiagent.plugin");
        }

        public static Object configImportApp(SafetyGuardSidecar r7, String r8, String r9, String r10, d<? super SidecarResult> r11) {
            SafetyGuardSidecar r12 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r7, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
            return m.a(m.f10705a, "config", "app_import_unsupported", "sidecar auth config is not supported", null, 8, null);
        }

        public static Object configDeleteApp(SafetyGuardSidecar r7, d<? super SidecarResult> r8) {
            SafetyGuardSidecar r9 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r7, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
            return m.a(m.f10705a, "config", "app_delete_unsupported", "sidecar auth config is not supported", null, 8, null);
        }

        public static SidecarOperation login(SafetyGuardSidecar r9, Set<String> r10, SidecarDeviceFlowCallback r11) {
            SafetyGuardSidecar r12 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r9, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
            SidecarDeviceFlowCallback r14 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r11, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
            o.e(r13, "scopes");
            o.e(r14, "callback");
            r14.onComplete(m.a(m.f10705a, "authentication", "authorization_unsupported", "sidecar login is not supported", null, 8, null));
            return (SidecarOperation) ZeusTransformUtils.preCheckCast(new CompletedSidecarOperation("login-unsupported"), SidecarOperation.class, "com.obric.aiagent.plugin");
        }

        public static SidecarOperation requestGrant(SafetyGuardSidecar r9, Set<String> r10, SidecarDeviceFlowCallback r11) {
            SafetyGuardSidecar r12 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r9, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
            SidecarDeviceFlowCallback r14 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r11, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
            o.e(r13, "scopes");
            o.e(r14, "callback");
            r14.onComplete(m.a(m.f10705a, "authorization", "grant_unsupported", "sidecar requestGrant is not supported", null, 8, null));
            return (SidecarOperation) ZeusTransformUtils.preCheckCast(new CompletedSidecarOperation("request-grant-unsupported"), SidecarOperation.class, "com.obric.aiagent.plugin");
        }

        public static Object logout(SafetyGuardSidecar r7, d<? super SidecarResult> r8) {
            SafetyGuardSidecar r9 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r7, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
            return m.a(m.f10705a, "authentication", "logout_unsupported", "sidecar login is not supported", null, 8, null);
        }

        public static Object status(SafetyGuardSidecar r8, d<? super SidecarAccountStatus> r9) {
            SafetyGuardSidecar r10 = (SafetyGuardSidecar) ZeusTransformUtils.wrapperContextForParams(r8, SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
            d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return new SidecarAccountStatus(null, false, null, null, null, 28, null);
        }
    }

    SidecarOperation configCreateApp(String r1, SidecarDeviceFlowCallback r2);

    Object configDeleteApp(d<? super SidecarResult> r1);

    Object configImportApp(String r1, String r2, String r3, d<? super SidecarResult> r4);

    Object configuredApp(d<? super SidecarAppInfo> r1);

    Object endSession(String r1, d<? super Boolean> r2);

    int getVersion();

    SidecarOperation login(Set<String> r1, SidecarDeviceFlowCallback r2);

    Object logout(d<? super SidecarResult> r1);

    SidecarOperation requestGrant(Set<String> r1, SidecarDeviceFlowCallback r2);

    Object startSession(StartSidecarSessionRequest r1, d<? super SidecarSessionEnv> r2);

    Object status(d<? super SidecarAccountStatus> r1);
}
