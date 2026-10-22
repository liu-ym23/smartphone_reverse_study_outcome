package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.ActionEgressStatus;
import com.bytedance.safetyguard.lxc.api.AttemptedOutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundIngressProxy;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyApiKt;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyDecision;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTargetType;
import com.bytedance.safetyguard.lxc.api.ProxyReady;
import com.bytedance.safetyguard.lxc.api.ProxySessionCloseReason;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyConfig;
import com.bytedance.safetyguard.lxc.api.SensitiveCategoryInfo;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionContextTokenParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionEgressResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionFinishResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.AttemptedOutboundTargetParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.IOutboundPolicyCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.OutboundTargetParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.PolicyDecisionParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyReadyParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxySessionResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.SensitiveCategoryInfoParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ProxyIpcClientMappers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f10007a = null;

    public static final /* synthetic */ PolicyDecisionParcel a(OutboundPolicyDecision r2) {
        return b((OutboundPolicyDecision) ZeusTransformUtils.wrapperContextForParams(r2, OutboundPolicyDecision.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Executor a() {
        return f10007a;
    }

    public static final /* synthetic */ PolicyDecisionParcel b() {
        return c();
    }

    public static /* synthetic */ Thread lambda$sEm1ovve0aivVmbjUNTsICWjTbU(Runnable r0) {
        return a(r0);
    }

    public static final ProxyServiceConfigParcel a(SafetyGuardProxyConfig r13) {
        d.h.b.o.e(r13, "<this>");
        ProxyServiceConfigParcel r0 = new ProxyServiceConfigParcel(0, r13.getProxy().getConnectTimeoutMillis(), r13.getProxy().getHelloTimeoutMillis(), r13.getProxy().getMaxStreams(), r13.getProxy().getMaxPendingBytes(), null, null, !OutboundPolicyApiKt.isBuiltInSidecarAware(r13.getPolicyEvaluator()) ? 1 : 0, r13.getProxy().getRecoveryTimeoutMillis(), 97, null);
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final IOutboundPolicyCallback b(SafetyGuardProxyConfig r3) {
        d.h.b.o.e(r3, "<this>");
        Executor r1 = null;
        Object[] r2 = 0;
        if (OutboundPolicyApiKt.isBuiltInSidecarAware(r3.getPolicyEvaluator()) == false) goto L6;
        return null;
    L6:
        return (IOutboundPolicyCallback) ZeusTransformUtils.preCheckCast(new LocalPolicyCallback(r3.getPolicyEvaluator(), r1, 2, r2 == true ? 1 : 0), IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
    }

    public static final ProxyReady a(ProxyReadyParcel r9) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r9);
        if (r9 == null) goto L7;
        return new ProxyReady(r9.getSessionId(), r9.getReused(), r9.getAcceptedFeatureBitmap(), r9.getMaxFramePayload(), r9.getDataChunkSize(), r9.getStreamWindow());
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final ProxySessionResult a(ProxySessionResultParcel r14) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r14);
        if (r14 == null) goto L18;
        ProxySessionCloseReason r5 = (ProxySessionCloseReason) ZeusTransformUtils.preCheckCast(d.a.p.d((List) ZeusTransformUtils.preCheckCast(ProxySessionCloseReason.getEntries(), List.class, "com.obric.aiagent.plugin"), r14.getCloseReason()), ProxySessionCloseReason.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (r14.getErrorCode() != 0) goto L9;
        ProxySessionErrorCode r0 = null;
    L12:
        return new ProxySessionResult(r14.getSessionId(), r5, r0, r14.getMessage(), (int) d.l.n.b(r14.getOpenedStreamCount(), 2147483647L), (int) d.l.n.b(r14.getRejectedStreamCount(), 2147483647L), r14.getBytesFromGateway(), r14.getBytesToGateway());
    L9:
        r0 = (ProxySessionErrorCode) ZeusTransformUtils.preCheckCast(d.a.p.d((List) ZeusTransformUtils.preCheckCast(ProxySessionErrorCode.getEntries(), List.class, "com.obric.aiagent.plugin"), r14.getErrorCode() - 1), ProxySessionErrorCode.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L12;
        throw new IllegalArgumentException("Unsupported proxy error code: " + r14.getErrorCode());
    L16:
        throw new IllegalArgumentException("Unsupported close reason: " + r14.getCloseReason());
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final w b(ProxySessionResultParcel r2) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r2);
        if (r2 == null) goto L15;
        ActionContextTokenParcel r1 = r2.getTerminalActionToken();
        if (r1 != null) goto L8;
        return null;
    L8:
        ActionFinishResultParcel r3 = r2.getTerminalActionResult();
        if (r3 == null) goto L13;
        return new w(a(r1), a(r3.getResult()));
    L13:
        throw new IllegalArgumentException("Required value was null.".toString());
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final ActionContextTokenParcel a(ActionContextToken r4) {
        d.h.b.o.e(r4, "<this>");
        ActionContextTokenParcel r0 = new ActionContextTokenParcel(r4.getSessionInstanceId$safetyguard_runtime_release(), r4.getActivationSequence$safetyguard_runtime_release());
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r0);
        return r0;
    }

    public static final ActionContextToken a(ActionContextTokenParcel r4) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r4);
        if (r4 == null) goto L7;
        return new ActionContextToken(r4.getSessionInstanceId(), r4.getActivationSequence());
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final ActionEgressResult a(ActionEgressResultParcel r12) {
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r12);
        if (r12 == null) goto L34;
        int r0 = r12.getStatus();
        if (r0 != 0) goto L7;
        ActionEgressStatus r1 = ActionEgressStatus.ALLOWED;
    L15:
        ActionEgressStatus r2 = r1;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getUnapprovedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        SensitiveCategoryInfoParcel r6 = (SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r5.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin");
        r4.add(new SensitiveCategoryInfo(r6.getSensitiveCategory(), r6.getCategoryDesc()));
        goto L17
    L19:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getDeniedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        SensitiveCategoryInfoParcel r11 = (SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r10.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin");
        r9.add(new SensitiveCategoryInfo(r11.getSensitiveCategory(), r11.getCategoryDesc()));
        goto L21
    L23:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getApprovedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        SensitiveCategoryInfoParcel r17 = (SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r16.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin");
        r15.add(new SensitiveCategoryInfo(r17.getSensitiveCategory(), r17.getCategoryDesc()));
        goto L25
    L27:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getAttemptedTargets(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r19.iterator();
    L29:
        if (r21.hasNext() == false) goto L32;
        AttemptedOutboundTargetParcel r22 = (AttemptedOutboundTargetParcel) ZeusTransformUtils.preCheckCast(r21.next(), AttemptedOutboundTargetParcel.class, "com.obric.aiagent.plugin");
        r20.add(new AttemptedOutboundTarget(a(r22.getTarget()), r22.getCount()));
        goto L29
    L32:
        return new ActionEgressResult(r2, r7, r13, r18, (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"), r12.getAttemptedTargetsTruncated(), r12.getUnreportedAttemptCount());
    L7:
        if (r0 != 1) goto L9;
        r1 = ActionEgressStatus.CLARIFICATION_REQUIRED;
        goto L15
    L9:
        if (r0 != 2) goto L12;
        r1 = ActionEgressStatus.ACCESS_DENIED;
        goto L15
    L12:
        throw new IllegalArgumentException("Unsupported action status");
    L34:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final OutboundTarget a(OutboundTargetParcel r7) {
        d.h.b.o.e(r7, "<this>");
        String r1 = r7.getHost();
        int r2 = r7.getPort();
        int r3 = r7.getType();
        if (r3 == 0) goto L10;
        if (r3 == 1) goto L9;
        if (r3 != 2) goto L8;
        OutboundTargetType r4 = OutboundTargetType.IPV6;
    L11:
        int r6 = r7.getIngressProxy();
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 != 2) goto L16;
        OutboundIngressProxy r8 = OutboundIngressProxy.SOCKS5_CONNECT;
    L24:
        return new OutboundTarget(r1, r2, r4, r8);
    L16:
        if (r6 != 3) goto L19;
        r8 = OutboundIngressProxy.SIDECAR_AUTH;
        goto L24
    L19:
        throw new IllegalArgumentException("Unsupported ingress proxy: " + r7.getIngressProxy());
    L21:
        r8 = OutboundIngressProxy.HTTP_CONNECT;
        goto L24
    L22:
        r8 = OutboundIngressProxy.HTTP_FORWARD;
        goto L24
    L8:
        throw new IllegalArgumentException("Unsupported target type: " + r7.getType());
    L9:
        r4 = OutboundTargetType.IPV4;
        goto L11
    L10:
        r4 = OutboundTargetType.DOMAIN;
        goto L11
    }

    private static final PolicyDecisionParcel b(OutboundPolicyDecision r8) {
        OutboundPolicyDecision r9 = (OutboundPolicyDecision) ZeusTransformUtils.wrapperContextForParams(r8, OutboundPolicyDecision.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r9, OutboundPolicyDecision.Allow.INSTANCE) == false) goto L6;
        return new PolicyDecisionParcel(0, 0, null, 5, null);
    L6:
        if (d.h.b.o.a(r9, OutboundPolicyDecision.SidecarAuth.INSTANCE) == false) goto L9;
        return new PolicyDecisionParcel(0, 2, null, 5, null);
    L9:
        if (ZeusTransformUtils.instanceOf(r9, OutboundPolicyDecision.Deny.class) == false) goto L13;
        return new PolicyDecisionParcel(0, 1, ((OutboundPolicyDecision.Deny) ZeusTransformUtils.preCheckCast(r9, OutboundPolicyDecision.Deny.class, "com.obric.aiagent.plugin")).getReason(), 1, null);
    L13:
        throw new d.k();
    }

    private static final PolicyDecisionParcel c() {
        return new PolicyDecisionParcel(0, 1, "Business policy callback failed", 1, null);
    }

    static {
        f10007a = (Executor) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new ArrayBlockingQueue(64), BlockingQueue.class, "com.obric.aiagent.plugin"), $$Lambda$l$sEm1ovve0aivVmbjUNTsICWjTbU.INSTANCE, (RejectedExecutionHandler) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor.AbortPolicy(), RejectedExecutionHandler.class, "com.obric.aiagent.plugin")), Executor.class, "com.obric.aiagent.plugin");
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "safetyguard-policy-callback");
        r0.setDaemon(true);
        return r0;
    }
}
