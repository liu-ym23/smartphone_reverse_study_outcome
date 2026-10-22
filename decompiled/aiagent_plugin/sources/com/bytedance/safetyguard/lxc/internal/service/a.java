package com.bytedance.safetyguard.lxc.internal.service;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.ActionEgressStatus;
import com.bytedance.safetyguard.lxc.api.AttemptedOutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundIngressProxy;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTargetType;
import com.bytedance.safetyguard.lxc.api.SensitiveCategoryInfo;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionActivationResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionContextTokenParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionEgressResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ActionFinishResultParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.AttemptedOutboundTargetParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.OutboundTargetParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.SensitiveCategoryInfoParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ActionIpcServiceMappers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionIpcServiceMappers.kt */
    public /* synthetic */ class C0248a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10926a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10927b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f10928c = null;

        static {
            int[] r0 = new int[ActionEgressStatus.values().length];
            r0[ActionEgressStatus.ALLOWED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ActionEgressStatus.CLARIFICATION_REQUIRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[ActionEgressStatus.ACCESS_DENIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L8:
            f10926a = r0;
            int[] r1 = new int[OutboundTargetType.values().length];
            r1[OutboundTargetType.DOMAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r1[OutboundTargetType.IPV4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L45:
            r1[OutboundTargetType.IPV6.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L12:
            f10927b = r1;
            int[] r2 = new int[OutboundIngressProxy.values().length];
            r2[OutboundIngressProxy.HTTP_FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L29:
            r2[OutboundIngressProxy.HTTP_CONNECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L37:
            r2[OutboundIngressProxy.SOCKS5_CONNECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L31:
            r2[OutboundIngressProxy.SIDECAR_AUTH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L17:
            f10928c = r2;
        }
    }

    private static final String c(int r0) {
        switch(r0) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            case 9: goto L3;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        return "Action service is unavailable";
    L4:
        return "Action service protocol mismatch";
    L5:
        return "Action belongs to another attachment";
    L6:
        return "Action token is invalid";
    L7:
        return "No action is active";
    L8:
        return "Another action is already active";
    L9:
        return "Proxy attachment was not found";
    L10:
        return "Proxy session is closed";
    L11:
        return "Proxy attachment is not ready";
    L12:
        return "Action payload is invalid";
    }

    public static final ActionActivationResultParcel a(ActionContextToken r8) {
        d.h.b.o.e(r8, "token");
        ActionActivationResultParcel r0 = new ActionActivationResultParcel(0, null, b(r8), 0, 10, null);
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r0);
        return r0;
    }

    public static final ActionActivationResultParcel a(int r8) {
        ActionActivationResultParcel r7 = new ActionActivationResultParcel(r8, c(r8), null, 0, 12, null);
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r7);
        return r7;
    }

    public static final ActionFinishResultParcel a(ActionEgressResult r8) {
        d.h.b.o.e(r8, "result");
        ActionFinishResultParcel r0 = new ActionFinishResultParcel(0, null, b(r8), 0, 10, null);
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r0);
        return r0;
    }

    public static final ActionFinishResultParcel b(int r8) {
        ActionFinishResultParcel r7 = new ActionFinishResultParcel(r8, c(r8), null, 0, 12, null);
        com.bytedance.safetyguard.lxc.internal.ipc.f.f10920a.a(r7);
        return r7;
    }

    public static final int a(Throwable r1) {
        d.h.b.o.e(r1, WsConstants.KEY_CONNECTION_ERROR);
        String r2 = r1.getMessage();
        if (r2 != null) goto L5;
    L31:
        return 9;
    L5:
        switch(r2.hashCode()) {
            case -1374941674: goto L28;
            case -1174112477: goto L24;
            case 1075109777: goto L20;
            case 1287572230: goto L16;
            case 1908126549: goto L12;
            case 1946809716: goto L8;
            default: goto L31;
        };
    L8:
        if (r2.equals("TOKEN_MISMATCH") == false) goto L31;
        return 7;
    L12:
        if (r2.equals("SESSION_CLOSED") == false) goto L31;
        return 3;
    L16:
        if (r2.equals("INVALID_PAYLOAD") == false) goto L31;
        return 1;
    L20:
        if (r2.equals("NO_ACTIVE_ACTION") == false) goto L31;
        return 6;
    L24:
        if (r2.equals("ACTION_OWNER_MISMATCH") == false) goto L31;
        return 8;
    L28:
        if (r2.equals("ACTION_ALREADY_ACTIVE") == false) goto L31;
        return 5;
    }

    public static final ActionContextTokenParcel b(ActionContextToken r4) {
        d.h.b.o.e(r4, "<this>");
        return new ActionContextTokenParcel(r4.getSessionInstanceId$safetyguard_runtime_release(), r4.getActivationSequence$safetyguard_runtime_release());
    }

    public static final ActionEgressResultParcel b(ActionEgressResult r14) {
        d.h.b.o.e(r14, "<this>");
        int r0 = C0248a.f10926a[r14.getStatus().ordinal()];
        int r1 = 2;
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L6;
        int r4 = 1;
    L13:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r14.getUnapprovedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r2.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r3.add(a((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r5.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")));
        goto L15
    L17:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r14.getDeniedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r8.add(a((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r9.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")));
        goto L19
    L21:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r14.getApprovedCategories(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        r12.add(a((SensitiveCategoryInfo) ZeusTransformUtils.preCheckCast(r13.next(), SensitiveCategoryInfo.class, "com.obric.aiagent.plugin")));
        goto L23
    L25:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14.getAttemptedTargets(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L27:
        if (r18.hasNext() == false) goto L30;
        AttemptedOutboundTarget r19 = (AttemptedOutboundTarget) ZeusTransformUtils.preCheckCast(r18.next(), AttemptedOutboundTarget.class, "com.obric.aiagent.plugin");
        r17.add(new AttemptedOutboundTargetParcel(a(r19.getTarget()), r19.getCount()));
        goto L27
    L30:
        return new ActionEgressResultParcel(0, r4, r6, r10, r15, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), r14.getAttemptedTargetsTruncated(), r14.getUnreportedAttemptCount(), 1, null);
    L6:
        if (r0 != 3) goto L9;
    L12:
        r4 = r1;
        goto L13
    L9:
        throw new d.k();
    L11:
        r1 = 0;
        goto L12
    }

    private static final SensitiveCategoryInfoParcel a(SensitiveCategoryInfo r2) {
        return new SensitiveCategoryInfoParcel(r2.getSensitiveCategory(), r2.getCategoryDesc());
    }

    private static final OutboundTargetParcel a(OutboundTarget r9) {
        String r2 = r9.getHost();
        int r3 = r9.getPort();
        int r0 = C0248a.f10927b[r9.getType().ordinal()];
        int r5 = 2;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L8;
        int r7 = 2;
    L11:
        int r10 = C0248a.f10928c[r9.getIngressProxy().ordinal()];
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L20;
        if (r10 == 3) goto L23;
        if (r10 != 4) goto L19;
        r5 = 3;
        goto L23
    L19:
        throw new d.k();
    L23:
        return new OutboundTargetParcel(0, r2, r3, r7, r5, 1, null);
    L20:
        r5 = 1;
        goto L23
    L21:
        r5 = 0;
        goto L23
    L8:
        throw new d.k();
    L9:
        r7 = 1;
        goto L11
    L10:
        r7 = 0;
        goto L11
    }
}
