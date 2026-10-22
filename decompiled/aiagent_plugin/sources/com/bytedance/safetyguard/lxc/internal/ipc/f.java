package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.l.j;
import d.o.k;
import d.o.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: ProxyIpcValidator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10920a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f10921b = null;

    private f() {
    }

    public static /* synthetic */ IBinder a(f r1, int r2, IBinder r3, int r4, int r5, int r6, Object r7) {
        IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = Binder.getCallingUid();
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = Process.myUid();
    L9:
        return r1.a(r2, r8, r4, r5);
    }

    public final IBinder a(int r3, IBinder r4, int r5, int r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        if (r5 != r6) goto L10;
        if (r7 == null) goto L8;
        a(r3);
        return r7;
    L8:
        throw new SecurityException("clientToken is required");
    L10:
        throw new SecurityException("SafetyGuard proxy service only accepts same-UID callers");
    }

    public final ProxyAttachRequestParcel a(ProxyAttachRequestParcel r3, ParcelFileDescriptor r4, IProxyClientCallback r5, IOutboundPolicyCallback r6) {
        IProxyClientCallback r7 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r5, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        IOutboundPolicyCallback r8 = (IOutboundPolicyCallback) ZeusTransformUtils.wrapperContextForParams(r6, IOutboundPolicyCallback.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L35;
        a(r3.getProtocolVersion());
        a("attachmentId", r3.getAttachmentId());
        a(ObricMemoryConstants.KEY_SESSION_ID, r3.getSessionId());
        a(r3.getConfig());
        if (r4 != null) goto L7;
        c("proxyFd is required");
        throw new d.d();
    L7:
        if (r4.getFileDescriptor().valid() == false) goto L31;
        boolean r9 = false;
        if (r7 == null) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L29;
        int r11 = r3.getConfig().getPolicyMode();
        if (r11 == 0) goto L23;
        if (r11 != 1) goto L26;
        if (r8 == null) goto L19;
        r9 = true;
    L19:
        if (r9 == true) goto L26;
        c("custom policy mode requires a callback");
        throw new d.d();
    L26:
        return r3;
    L23:
        if (r8 != null) goto L25;
        r9 = true;
    L25:
        if (r9 == true) goto L26;
        c("default policy mode must not provide a callback");
        throw new d.d();
    L29:
        c("proxy callback is required");
        throw new d.d();
    L11:
        r10 = false;
        goto L12
    L31:
        c("proxyFd is closed");
        throw new d.d();
    L35:
        c("attach request is required");
        throw new d.d();
    }

    public final void a(ProxyServiceConfigParcel r14) {
        if (r14 == null) goto L46;
        a(r14.getProtocolVersion());
        a("connectTimeoutMillis", r14.getConnectTimeoutMillis(), 100, 120000);
        a("helloTimeoutMillis", r14.getHelloTimeoutMillis(), 100, 60000);
        a("maxStreams", r14.getMaxStreams(), 1, 1024);
        a("maxPendingBytes", r14.getMaxPendingBytes(), 65536, 67108864);
        a("recoveryTimeoutMillis", r14.getRecoveryTimeoutMillis(), 100, 120000);
        int r1 = 0;
        if (r14.getPolicyMode() != 0) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        c("unsupported policyMode=" + r14.getPolicyMode());
        throw new d.d();
    L12:
        if (r14.getAllowedDomainRules().size() > 128) goto L14;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L43;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.getAllowedDomainRules(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r2 = 0;
        int r6 = 0;
    L19:
        if (r15.hasNext() == false) goto L25;
        Object r7 = r15.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L23;
        p.c();
    L23:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        f r10 = f10920a;
        r10.a("allowedDomainRules[" + r6 + ']', r8, 253, false);
        r2 = r2 + r10.d(r8);
        r6 = r9;
        goto L19
    L25:
        if (r2 > 16384) goto L27;
        boolean r16 = true;
    L28:
        if (r16 == false) goto L41;
        if (r14.getAllowedPorts().length > 1024) goto L32;
        boolean r17 = true;
    L33:
        if (r17 == false) goto L39;
        int[] r18 = r14.getAllowedPorts();
        int r19 = r18.length;
        int r3 = 0;
    L35:
        if (r1 >= r19) goto L37;
        f10920a.a("allowedPorts[" + r3 + ']', r18[r1], 1, SupportMenu.USER_MASK);
        r1 = r1 + 1;
        r3 = r3 + 1;
        goto L35
    L37:
        return;
    L39:
        throw new e(3, "too many allowedPorts");
    L32:
        r17 = false;
        goto L33
    L41:
        throw new e(3, "allowedDomainRules exceed total byte limit");
    L27:
        r16 = false;
        goto L28
    L43:
        throw new e(3, "too many allowedDomainRules");
    L14:
        r13 = false;
        goto L16
    L6:
        if (r14.getPolicyMode() == 1) goto L9;
        r0 = false;
        goto L10
    L46:
        c("proxy config is required");
        throw new d.d();
    }

    public final SidecarCommandParcel a(SidecarCommandParcel r14) {
        if (r14 == null) goto L58;
        a(r14.getProtocolVersion());
        a("operationId", r14.getOperationId());
        j r0 = c.f10915a.a();
        int r1 = r0.a();
        int r2 = r0.b();
        int r3 = r14.getCommand();
        boolean r4 = true;
        if (r1 > r3) goto L7;
        if (r3 > r2) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L56;
        int r6 = r14.getCommand();
        if (r6 != 1) goto L12;
        b("production", r14.getProduction());
    L19:
        c("production", r14.getProduction());
        c("appId", r14.getAppId());
        c("appSecret", r14.getAppSecret());
        c("cliName", r14.getCliName());
        if (r14.getScopes().size() > 256) goto L22;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L55;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.getScopes(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r9 = 0;
        int r10 = 0;
    L27:
        if (r8.hasNext() == false) goto L33;
        Object r11 = r8.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L31;
        p.c();
    L31:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        f r15 = f10920a;
        r15.a("scopes[" + r10 + ']', r13, 256, false);
        r9 = r9 + r15.d(r13);
        r10 = r12;
        goto L27
    L33:
        if (r9 > 16384) goto L35;
        boolean r16 = true;
    L36:
        if (r16 == false) goto L53;
        if (r14.getTtlSeconds() == (-1)) goto L48;
        long r17 = r14.getTtlSeconds();
        if (1 <= r17) goto L42;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == true) goto L48;
        r4 = false;
        goto L48
    L42:
        if (r17 >= 86401) goto L44;
        r18 = true;
    L48:
        if (r4 == false) goto L50;
        return r14;
    L50:
        c("ttlSeconds must be -1 or between 1 and 86400");
        throw new d.d();
    L53:
        throw new e(3, "scopes exceed total byte limit");
    L35:
        r16 = false;
        goto L36
    L55:
        throw new e(3, "too many scopes");
    L22:
        r7 = false;
        goto L24
    L12:
        if (r6 != 2) goto L14;
        b("production", r14.getProduction());
        b("appId", r14.getAppId());
        b("appSecret", r14.getAppSecret());
        goto L19
    L14:
        if (r6 != 9) goto L19;
        b("cliName", r14.getCliName());
        goto L19
    L56:
        c("unsupported sidecar command=" + r14.getCommand());
        throw new d.d();
    L7:
        r5 = false;
        goto L8
    L58:
        c("sidecar command is required");
        throw new d.d();
    }

    public final void a(OutboundTargetParcel r6) {
        if (r6 == null) goto L21;
        a(r6.getProtocolVersion());
        boolean r3 = false;
        a("host", r6.getHost(), 253, false);
        a("port", r6.getPort(), 1, SupportMenu.USER_MASK);
        int r0 = r6.getType();
        if (r0 >= 0) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L19;
        int r2 = r6.getIngressProxy();
        if (r2 >= 0) goto L13;
    L15:
        if (r3 == false) goto L17;
        return;
    L17:
        c("unsupported ingressProxy=" + r6.getIngressProxy());
        throw new d.d();
    L13:
        if (r2 >= 4) goto L15;
        r3 = true;
        goto L15
    L19:
        c("unsupported target type=" + r6.getType());
        throw new d.d();
    L6:
        if (r0 >= 3) goto L8;
        r1 = true;
        goto L9
    L21:
        c("outbound target is required");
        throw new d.d();
    }

    public final void a(PolicyDecisionParcel r5) {
        if (r5 == null) goto L15;
        a(r5.getProtocolVersion());
        int r0 = r5.getDecision();
        boolean r2 = false;
        if (r0 >= 0) goto L6;
    L8:
        if (r2 == false) goto L13;
        String r4 = r5.getReason();
        if (r4 == null) goto L17;
        f10920a.a("policy reason", r4, 2048, true);
        return;
    L17:
        return;
    L13:
        c("unsupported policy decision=" + r5.getDecision());
        throw new d.d();
    L6:
        if (r0 >= 3) goto L8;
        r2 = true;
        goto L8
    L15:
        c("policy decision is required");
        throw new d.d();
    }

    public final void a(String r6) {
        if (r6 != null) goto L4;
        c("action payload is required");
        throw new d.d();
    L4:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        c("action payload must not be blank");
        throw new d.d();
    L6:
        if (d(r6) > 65536) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        if ((!o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null)) == false) goto L13;
        return;
    L13:
        c("action payload contains a null character");
        throw new d.d();
    L16:
        throw new e(3, "action payload exceeds byte limit");
    L8:
        r0 = false;
        goto L9
    }

    public final void a(ActionContextTokenParcel r5) {
        if (r5 == null) goto L11;
        a("action session instance", r5.getSessionInstanceId());
        if (r5.getActivationSequence() <= 0) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L9;
        return;
    L9:
        c("action activation sequence must be positive");
        throw new d.d();
    L6:
        r6 = false;
        goto L7
    L11:
        c("action token is required");
        throw new d.d();
    }

    public final void a(ActionActivationResultParcel r4) {
        if (r4 == null) goto L22;
        a(r4.getProtocolVersion());
        b(r4.getResultCode());
        boolean r1 = true;
        if (r4.getResultCode() != 0) goto L14;
        if (r4.getMessage() == null) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L11;
        a(r4.getToken());
        return;
    L11:
        c("successful action activation must not carry a message");
        throw new d.d();
    L14:
        if (r4.getToken() == null) goto L17;
        r1 = false;
    L17:
        if (r1 == false) goto L20;
        b(r4.getMessage());
        return;
    L20:
        c("failed action activation must not carry a token");
        throw new d.d();
    L22:
        c("action activation result is required");
        throw new d.d();
    }

    public final void a(ActionFinishResultParcel r4) {
        if (r4 == null) goto L22;
        a(r4.getProtocolVersion());
        b(r4.getResultCode());
        boolean r1 = true;
        if (r4.getResultCode() != 0) goto L14;
        if (r4.getMessage() == null) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L11;
        a(r4.getResult());
        return;
    L11:
        c("successful action finish must not carry a message");
        throw new d.d();
    L14:
        if (r4.getResult() == null) goto L17;
        r1 = false;
    L17:
        if (r1 == false) goto L20;
        b(r4.getMessage());
        return;
    L20:
        c("failed action finish must not carry a result");
        throw new d.d();
    L22:
        c("action finish result is required");
        throw new d.d();
    }

    public final void a(ActionEgressResultParcel r12) {
        if (r12 == null) goto L121;
        a(r12.getProtocolVersion());
        j r0 = b.f10913a.a();
        int r1 = r0.a();
        int r2 = r0.b();
        int r3 = r12.getStatus();
        boolean r4 = false;
        if (r1 > r3) goto L7;
        if (r3 > r2) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L119;
        List r6 = p.a();
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r12.getUnapprovedCategories(), Collection.class, "com.obric.aiagent.plugin"));
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r12.getDeniedCategories(), Collection.class, "com.obric.aiagent.plugin"));
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r12.getApprovedCategories(), Collection.class, "com.obric.aiagent.plugin"));
        List r7 = p.a(r6);
        if (r7.size() > 256) goto L12;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L118;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        a((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r9.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin"));
        goto L17
    L19:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getUnapprovedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r10.iterator();
    L21:
        if (r13.hasNext() == false) goto L23;
        r11.add(((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r13.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L21
    L23:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getDeniedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        r16.add(((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r17.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L25
    L27:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getApprovedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r19.iterator();
    L29:
        if (r21.hasNext() == false) goto L31;
        r20.add(((SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r21.next(), SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin")).getSensitiveCategory());
        goto L29
    L31:
        List r22 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin");
        if (p.s((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).size() != r14.size()) goto L34;
        boolean r23 = true;
    L35:
        if (r23 == true) goto L37;
        c("duplicate unapproved category");
        throw new d.d();
    L37:
        if (p.s((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).size() != r18.size()) goto L39;
        boolean r24 = true;
    L40:
        if (r24 == true) goto L42;
        c("duplicate denied category");
        throw new d.d();
    L42:
        if (p.s((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin")).size() != r22.size()) goto L44;
        boolean r25 = true;
    L45:
        if (r25 == true) goto L47;
        c("duplicate approved category");
        throw new d.d();
    L47:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(p.q((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L49;
        c("action category sets overlap");
        throw new d.d();
    L49:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(p.q((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L51;
        c("action category sets overlap");
        throw new d.d();
    L51:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(p.q((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L53;
        c("action category sets overlap");
        throw new d.d();
    L53:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L56;
        int r26 = 2;
    L60:
        if (r12.getStatus() != r26) goto L62;
        boolean r27 = true;
    L63:
        if (r27 == true) goto L65;
        c("action status does not match categories");
        throw new d.d();
    L65:
        if (r12.getAttemptedTargets().size() > 512) goto L67;
        boolean r28 = true;
    L68:
        if (r28 == false) goto L102;
        LinkedHashSet r29 = new LinkedHashSet();
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.getAttemptedTargets(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L71:
        if (r30.hasNext() == false) goto L85;
        AttemptedOutboundTargetParcel r31 = (AttemptedOutboundTargetParcel) ZeusTransformUtils.preCheckCast(r30.next(), AttemptedOutboundTargetParcel.class, "com.obric.aiagent.plugin");
        f r32 = f10920a;
        r32.a(r31.getTarget());
        if (r31.getCount() <= 0) goto L75;
        boolean r33 = true;
    L76:
        if (r33 == false) goto L82;
        if (r29.add(r31.getTarget()) == true) goto L71;
        r32.c("duplicate attempted target");
        throw new d.d();
    L82:
        r32.c("attempted target count must be positive");
        throw new d.d();
    L75:
        r33 = false;
        goto L76
    L85:
        if (r12.getUnreportedAttemptCount() < 0) goto L87;
        boolean r34 = true;
    L88:
        if (r34 == false) goto L99;
        boolean r35 = r12.getAttemptedTargetsTruncated();
        if (r12.getUnreportedAttemptCount() <= 0) goto L92;
        boolean r110 = true;
    L93:
        if (r35 != r110) goto L95;
        r4 = true;
    L95:
        if (r4 == false) goto L97;
        return;
    L97:
        c("attempt truncation metadata is inconsistent");
        throw new d.d();
    L92:
        r110 = false;
        goto L93
    L99:
        c("unreported attempt count must be non-negative");
        throw new d.d();
    L87:
        r34 = false;
        goto L88
    L102:
        throw new e(3, "too many attempted targets");
    L67:
        r28 = false;
        goto L68
    L62:
        r27 = false;
        goto L63
    L56:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L58;
        r26 = 1;
        goto L60
    L58:
        r26 = 0;
        goto L60
    L44:
        r25 = false;
        goto L45
    L39:
        r24 = false;
        goto L40
    L34:
        r23 = false;
        goto L35
    L118:
        throw new e(3, "too many action categories");
    L12:
        r8 = false;
        goto L14
    L119:
        c("unsupported action status");
        throw new d.d();
    L7:
        r5 = false;
        goto L8
    L121:
        c("action egress result is required");
        throw new d.d();
    }

    public final void a(ProxyReadyParcel r6) {
        if (r6 == null) goto L5;
        a(r6.getProtocolVersion());
        a(ObricMemoryConstants.KEY_SESSION_ID, r6.getSessionId());
        a("maxFramePayload", r6.getMaxFramePayload(), 1, 67108864);
        a("dataChunkSize", r6.getDataChunkSize(), 1, r6.getMaxFramePayload());
        a("streamWindow", r6.getStreamWindow(), 1, 67108864);
        return;
    L5:
        c("ready result is required");
        throw new d.d();
    }

    public final void a(ProxySessionResultParcel r8) {
        if (r8 == null) goto L63;
        a(r8.getProtocolVersion());
        a(ObricMemoryConstants.KEY_SESSION_ID, r8.getSessionId());
        int r0 = r8.getCloseReason();
        boolean r1 = true;
        if (r0 >= 0) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L61;
        int r3 = r8.getErrorCode();
        if (r3 >= 0) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L59;
        String r5 = r8.getMessage();
        if (r5 == null) goto L21;
        f10920a.a("result message", r5, 2048, true);
    L21:
        if (r8.getOpenedStreamCount() >= 0) goto L23;
    L29:
        boolean r6 = false;
    L30:
        if (r6 == true) goto L32;
        c("session result counters must be non-negative");
        throw new d.d();
    L32:
        if (r8.getTerminalActionToken() == null) goto L34;
        boolean r7 = true;
    L36:
        if (r8.getTerminalActionResult() == null) goto L38;
        boolean r9 = true;
    L39:
        if (r7 != r9) goto L41;
        boolean r10 = true;
    L42:
        if (r10 == false) goto L55;
        if (r7 == false) goto L54;
        a(r8.getTerminalActionToken());
        a(r8.getTerminalActionResult());
        ActionFinishResultParcel r11 = r8.getTerminalActionResult();
        if (r11 != null) goto L47;
    L49:
        r1 = false;
    L50:
        if (r1 == true) goto L65;
        c("terminal action result must be successful");
        throw new d.d();
    L65:
        return;
    L47:
        if (r11.getResultCode() != 0) goto L49;
    L54:
        return;
    L55:
        c("terminal action token and result must be present together");
        throw new d.d();
    L41:
        r10 = false;
        goto L42
    L38:
        r9 = false;
        goto L39
    L34:
        r7 = false;
        goto L36
    L23:
        if (r8.getRejectedStreamCount() < 0) goto L29;
        if (r8.getBytesFromGateway() < 0) goto L29;
        if (r8.getBytesToGateway() < 0) goto L29;
        r6 = true;
        goto L30
    L59:
        c("unsupported errorCode=" + r8.getErrorCode());
        throw new d.d();
    L13:
        if (r3 >= 21) goto L15;
        r4 = true;
        goto L16
    L61:
        c("unsupported closeReason=" + r8.getCloseReason());
        throw new d.d();
    L6:
        if (r0 >= 8) goto L8;
        r2 = true;
        goto L9
    L63:
        c("session result is required");
        throw new d.d();
    }

    public final void a(ProxyDiagnosticParcel r6) {
        if (r6 == null) goto L17;
        a(r6.getProtocolVersion());
        String r0 = r6.getAttachmentId();
        if (r0 == null) goto L6;
        f10920a.a("attachmentId", r0);
    L6:
        int r1 = r6.getSeverity();
        if (r1 >= 0) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        a("diagnostic code", r6.getCode(), 64, false);
        a("diagnostic message", r6.getMessage(), 2048, true);
        return;
    L15:
        c("unsupported diagnostic severity=" + r6.getSeverity());
        throw new d.d();
    L9:
        if (r1 >= 3) goto L11;
        r2 = true;
        goto L12
    L17:
        c("diagnostic is required");
        throw new d.d();
    }

    public final void a(SidecarResultParcel r17) {
        if (r17 == null) goto L142;
        a(r17.getProtocolVersion());
        a("operationId", r17.getOperationId());
        j r1 = d.f10917a.a();
        int r2 = r1.a();
        int r3 = r1.b();
        int r4 = r17.getResultType();
        if (r2 > r4) goto L8;
        if (r4 > r3) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L140;
        a("sidecar result message", r17.getMessage(), 2048, true);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{r17.getType(), r17.getSubtype(), r17.getHint(), r17.getAppId(), r17.getUserOpenId(), r17.getCurrentUserName(), r17.getSessionId(), r17.getProxyKey()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r7 = 0;
    L12:
        if (r6.hasNext() == false) goto L21;
        Object r9 = r6.next();
        int r11 = r7 + 1;
        if (r7 >= 0) goto L16;
        p.c();
    L16:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L19;
        f10920a.c("sidecar result field[" + r7 + ']', r10);
    L19:
        r7 = r11;
        goto L12
    L21:
        if (r17.getScopes().size() > 256) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L139;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r17.getScopes(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r13 = 0;
        int r14 = 0;
    L27:
        if (r12.hasNext() == false) goto L33;
        Object r15 = r12.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L31;
        p.c();
    L31:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");
        f r19 = f10920a;
        r19.a("result scopes[" + r14 + ']', r18, 256, false);
        r13 = r13 + r19.d(r18);
        r14 = r16;
        goto L27
    L33:
        if (r13 > 16384) goto L35;
        boolean r20 = true;
    L36:
        if (r20 == false) goto L137;
        if (r17.getBrand() == (-1)) goto L47;
        int r21 = SidecarBrand.getEntries().size();
        int r22 = r17.getBrand();
        if (r22 < 0) goto L43;
        if (r22 >= r21) goto L43;
        boolean r23 = true;
    L44:
        if (r23 == true) goto L47;
        boolean r24 = false;
    L48:
        if (r24 == true) goto L50;
        c("unsupported sidecar brand=" + r17.getBrand());
        throw new d.d();
    L50:
        if (r17.getAccessTokenExpiresAtMillis() < (-1)) goto L52;
        boolean r25 = true;
    L53:
        if (r25 == true) goto L55;
        c("accessTokenExpiresAtMillis must be -1 or non-negative");
        throw new d.d();
    L55:
        if (r17.getRefreshTokenExpiresAtMillis() < (-1)) goto L57;
        boolean r26 = true;
    L58:
        if (r26 == true) goto L60;
        c("refreshTokenExpiresAtMillis must be -1 or non-negative");
        throw new d.d();
    L60:
        if (r17.getExpiresAtMillis() < 0) goto L62;
        boolean r27 = true;
    L63:
        if (r27 == false) goto L128;
        int r28 = r17.getResultType();
        if (r28 == 2) goto L118;
        if (r28 == 3) goto L118;
        if (r28 != 4) goto L150;
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getSessionId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r29 != null) goto L72;
    L75:
        boolean r30 = true;
    L77:
        if ((!r30) == false) goto L115;
        CharSequence r31 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getAppId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r31 != null) goto L81;
    L84:
        boolean r32 = true;
    L86:
        if ((!r32) == false) goto L113;
        CharSequence r33 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getProxyKey(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r33 != null) goto L90;
    L93:
        boolean r34 = true;
    L95:
        if ((!r34) == true) goto L97;
        c("sidecar session result requires proxyKey");
        throw new d.d();
    L97:
        if (r17.getBrand() < 0) goto L99;
        boolean r35 = true;
    L100:
        if (r35 == true) goto L102;
        c("sidecar session result requires brand");
        throw new d.d();
    L102:
        if (r17.getExpiresAtMillis() <= 0) goto L104;
        boolean r36 = true;
    L105:
        if (r36 == true) goto L151;
        c("sidecar session result requires expiration");
        throw new d.d();
    L151:
        return;
    L104:
        r36 = false;
        goto L105
    L99:
        r35 = false;
        goto L100
    L90:
        if (r33.length() == 0) goto L93;
        r34 = false;
        goto L95
    L113:
        c("sidecar session result requires appId");
        throw new d.d();
    L81:
        if (r31.length() == 0) goto L84;
        r32 = false;
        goto L86
    L115:
        c("sidecar session result requires sessionId");
        throw new d.d();
    L72:
        if (r29.length() == 0) goto L75;
        r30 = false;
        goto L77
    L150:
        return;
    L118:
        if (r17.getAppId() != null) goto L120;
        return;
    L120:
        if (r17.getBrand() < 0) goto L122;
        boolean r37 = true;
    L123:
        if (r37 == true) goto L152;
        c("sidecar app result requires brand");
        throw new d.d();
    L152:
        return;
    L122:
        r37 = false;
        goto L123
    L128:
        c("expiresAtMillis must be non-negative");
        throw new d.d();
    L62:
        r27 = false;
        goto L63
    L57:
        r26 = false;
        goto L58
    L52:
        r25 = false;
    L43:
        r23 = false;
    L47:
        r24 = true;
        goto L48
    L137:
        throw new e(3, "result scopes exceed total byte limit");
    L35:
        r20 = false;
        goto L36
    L139:
        throw new e(3, "too many result scopes");
    L23:
        r8 = false;
        goto L24
    L140:
        c("unsupported sidecar resultType=" + r17.getResultType());
        throw new d.d();
    L8:
        r5 = false;
        goto L9
    L142:
        c("sidecar result is required");
        throw new d.d();
    }

    public final void a(int r4) {
        if (r4 != 3) goto L6;
        return;
    L6:
        throw new e(2, "unsupported protocolVersion=" + r4);
    }

    private final void b(int r4) {
        j r0 = a.f10911a.a();
        int r1 = r0.a();
        boolean r2 = false;
        if (r4 > r0.b()) goto L6;
        if (r1 > r4) goto L6;
        r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        c("unsupported action result code");
        throw new d.d();
    }

    private final void b(String r4) {
        if (r4 == null) goto L5;
        a("action failure message", r4, 2048, false);
        return;
    L5:
        c("failed action request requires a message");
        throw new d.d();
    }

    private final void a(SensitiveCategoryInfoParcel r5) {
        if (f10921b.a((CharSequence) ZeusTransformUtils.preCheckCast(r5.getSensitiveCategory(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L15;
        String r4 = r5.getCategoryDesc();
        if (r4 != null) goto L7;
        return;
    L7:
        if (f10920a.d(r4) > 1024) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L13;
        return;
    L13:
        throw new e(3, "sensitive category description exceeds byte limit");
    L9:
        r6 = false;
        goto L10
    L15:
        c("sensitive category code is invalid");
        throw new d.d();
    }

    public final void a(String r3, String r4) {
        d.h.b.o.e(r3, "name");
        d.h.b.o.e(r4, "value");
        a(r3, r4, 128, false);
    }

    private final void b(String r3, String r4) {
        if (r4 == null) goto L8;
        a(r3, r4, 4096, false);
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        return;
    L6:
        c(r3 + " must not be blank");
        throw new d.d();
    L8:
        c(r3 + " is required");
        throw new d.d();
    }

    private final void c(String r3, String r4) {
        if (r4 == null) goto L5;
        f10920a.a(r3, r4, 4096, true);
        return;
    }

    private final void a(String r4, String r5, int r6, boolean r7) {
        boolean r1 = false;
        if (r7 == false) goto L5;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        c(r4 + " must not be empty");
        throw new d.d();
    L14:
        if (d(r5) > r6) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L37;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r11 = 0;
    L20:
        if (r11 >= r10.length()) goto L31;
        char r12 = r10.charAt(r11);
        if (r12 != 0) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == true) goto L32;
        r11 = r11 + 1;
    L32:
        if (r1 == false) goto L34;
        return;
    L34:
        c(r4 + " contains control characters");
        throw new d.d();
    L24:
        if (Character.isISOControl(r12) == true) goto L27;
        r13 = false;
        goto L28
    L31:
        r1 = true;
        goto L32
    L37:
        throw new e(3, r4 + " exceeds " + r6 + " UTF-8 bytes");
    L16:
        r9 = false;
        goto L17
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L11;
        r8 = false;
        goto L12
    L7:
        r14 = false;
        goto L8
    }

    private final void a(String r2, int r3, int r4, int r5) {
        boolean r0 = false;
        if (r4 > r3) goto L6;
        if (r3 > r5) goto L6;
        r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        c(r2 + " must be between " + r4 + " and " + r5);
        throw new d.d();
    }

    private final Void c(String r2) {
        throw new e(1, r2);
    }

    private final int d(String r1) {
        byte[] r0 = r1.getBytes(d.o.d.f38623b);
        d.h.b.o.c(r0, "getBytes(...)");
        return r0.length;
    }

    static {
        f10920a = new f();
        f10921b = new k("^[A-Za-z0-9][A-Za-z0-9_.:-]{0,127}$");
    }
}
