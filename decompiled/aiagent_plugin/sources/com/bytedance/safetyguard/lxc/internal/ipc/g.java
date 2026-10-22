package com.bytedance.safetyguard.lxc.internal.ipc;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAccountStatus;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarSessionEnv;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SidecarIpcAdapters.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final SidecarResultParcel a(SidecarResult r31, String r32) {
        o.e(r31, "<this>");
        o.e(r32, "operationId");
        boolean r5 = r31.getSuccess();
        int r6 = r31.getCode();
        String r7 = r31.getType();
        String r8 = r31.getSubtype();
        String r9 = r31.getMessage();
        String r10 = r31.getHint();
        String r11 = r31.getAppId();
        String r12 = r31.getUserOpenId();
        SidecarBrand r2 = r31.getBrand();
        if (r2 == null) goto L5;
        int r3 = r2.ordinal();
    L6:
        int r14 = r3;
        List r15 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r31.getScopes(), Iterable.class, "com.obric.aiagent.plugin"));
        Integer r4 = r31.getSubcode();
        if (r4 == null) goto L9;
        int r16 = r4.intValue();
    L11:
        if (r31.getSubcode() == null) goto L13;
        boolean r17 = true;
    L15:
        return new SidecarResultParcel(0, r32, 0, r5, r6, r7, r8, r9, r10, r11, r12, null, r14, r15, r16, r17, false, false, false, 0, 0, null, 0, null, 16713733, null);
    L13:
        r17 = false;
        goto L15
    L9:
        r16 = 0;
        goto L11
    L5:
        r3 = -1;
        goto L6
    }

    public static final SidecarResultParcel a(SidecarAccountStatus r31, String r32) {
        o.e(r31, "<this>");
        o.e(r32, "operationId");
        SidecarAppInfo r2 = r31.getApp();
        if (r2 == null) goto L5;
        String r11 = r2.getAppId();
    L6:
        SidecarAppInfo r3 = r31.getApp();
        if (r3 == null) goto L9;
        String r12 = r3.getCurrentUserOpenId();
    L10:
        SidecarAppInfo r4 = r31.getApp();
        if (r4 == null) goto L13;
        String r13 = r4.getCurrentUserName();
    L14:
        SidecarAppInfo r5 = r31.getApp();
        if (r5 == null) goto L19;
        SidecarBrand r6 = r5.getBrand();
        if (r6 == null) goto L19;
        int r7 = r6.ordinal();
    L20:
        int r14 = r7;
        List r15 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r31.getGrantedScopes(), Iterable.class, "com.obric.aiagent.plugin"));
        boolean r18 = r31.getLoggedIn();
        SidecarAppInfo r8 = r31.getApp();
        if (r8 == null) goto L23;
        boolean r19 = r8.getHasUserToken();
    L24:
        SidecarAppInfo r9 = r31.getApp();
        if (r9 == null) goto L27;
        boolean r20 = r9.getHasBotToken();
    L28:
        Long r10 = r31.getAccessTokenExpiresAtMillis();
        if (r10 == null) goto L31;
        long r21 = r10.longValue();
    L32:
        Long r1 = r31.getRefreshTokenExpiresAtMillis();
        if (r1 == null) goto L35;
        long r23 = r1.longValue();
    L37:
        return new SidecarResultParcel(0, r32, 2, true, 0, null, null, "ok", null, r11, r12, r13, r14, r15, 0, false, r18, r19, r20, r21, r23, null, 0, null, 14729569, null);
    L35:
        r23 = -1;
        goto L37
    L31:
        r21 = -1;
        goto L32
    L27:
        r20 = false;
        goto L28
    L23:
        r19 = false;
    L19:
        r7 = -1;
        goto L20
    L13:
        r13 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static final SidecarResultParcel a(SidecarAppInfo r31, String r32) {
        o.e(r32, "operationId");
        String r1 = null;
        if (r31 == null) goto L5;
        String r11 = r31.getAppId();
    L6:
        if (r31 == null) goto L8;
        String r12 = r31.getCurrentUserOpenId();
    L9:
        if (r31 == null) goto L11;
        r1 = r31.getCurrentUserName();
    L11:
        String r13 = r1;
        if (r31 == null) goto L16;
        SidecarBrand r2 = r31.getBrand();
        if (r2 == null) goto L16;
        int r3 = r2.ordinal();
    L17:
        int r14 = r3;
        boolean r4 = false;
        if (r31 == null) goto L20;
        boolean r19 = r31.getHasUserToken();
    L21:
        if (r31 == null) goto L24;
        r4 = r31.getHasBotToken();
    L24:
        return new SidecarResultParcel(0, r32, 3, true, 0, null, null, "ok", null, r11, r12, r13, r14, null, 0, false, false, r19, r4, 0, 0, null, 0, null, 16376161, null);
    L20:
        r19 = false;
    L16:
        r3 = -1;
        goto L17
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public static final SidecarResultParcel a(SidecarSessionEnv r31, String r32) {
        o.e(r31, "<this>");
        o.e(r32, "operationId");
        return new SidecarResultParcel(0, r32, 4, true, 0, null, null, "ok", null, r31.getAppId(), null, null, r31.getBrand().ordinal(), null, 0, false, false, false, false, 0, 0, r31.getSessionId(), r31.getExpiresAtMillis(), r31.getProxyKey(), 2092385, null);
    }

    public static final SidecarResult a(SidecarResultParcel r14) {
        o.e(r14, "<this>");
        f.f10920a.a(r14);
        boolean r1 = true;
        if (r14.getResultType() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L14;
        boolean r3 = r14.getSuccess();
        int r4 = r14.getCode();
        String r5 = r14.getType();
        String r6 = r14.getSubtype();
        String r7 = r14.getMessage();
        String r8 = r14.getHint();
        String r9 = r14.getAppId();
        String r10 = r14.getUserOpenId();
        SidecarBrand r11 = e(r14);
        Set r12 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r14.getScopes(), Iterable.class, "com.obric.aiagent.plugin"));
        Integer r0 = Integer.valueOf(r14.getSubcode());
        ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r14.getHasSubcode() == false) goto L10;
        Integer r13 = r0;
    L12:
        return new SidecarResult(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L10:
        r13 = null;
        goto L12
    L14:
        throw new IllegalArgumentException("sidecar callback did not contain a SidecarResult".toString());
    }

    public static final SidecarAccountStatus b(SidecarResultParcel r14) {
        o.e(r14, "<this>");
        f.f10920a.a(r14);
        boolean r1 = true;
        if (r14.getResultType() != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L28;
        String r2 = r14.getAppId();
        if (r2 == null) goto L10;
        SidecarAppInfo r5 = a(r14, r2);
    L11:
        boolean r6 = r14.getLoggedIn();
        Set r3 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r14.getScopes(), Iterable.class, "com.obric.aiagent.plugin"));
        Long r4 = Long.valueOf(r14.getAccessTokenExpiresAtMillis());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        Long r9 = r4;
    L18:
        Long r15 = Long.valueOf(r14.getRefreshTokenExpiresAtMillis());
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue() >= 0) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        Long r10 = r15;
    L26:
        return new SidecarAccountStatus(r5, r6, r3, r9, r10);
    L24:
        r10 = null;
        goto L26
    L17:
        r9 = null;
        goto L18
    L14:
        r8 = false;
        goto L15
    L10:
        r5 = null;
        goto L11
    L28:
        throw new IllegalArgumentException("sidecar callback did not contain account status".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final SidecarAppInfo c(SidecarResultParcel r2) {
        o.e(r2, "<this>");
        f.f10920a.a(r2);
        if (r2.getResultType() != 3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        String r1 = r2.getAppId();
        if (r1 != null) goto L14;
        return null;
    L14:
        return a(r2, r1);
    L13:
        throw new IllegalArgumentException("sidecar callback did not contain configured app".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final SidecarSessionEnv d(SidecarResultParcel r8) {
        o.e(r8, "<this>");
        f.f10920a.a(r8);
        if (r8.getResultType() != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L26;
        String r2 = r8.getSessionId();
        if (r2 == null) goto L24;
        long r3 = r8.getExpiresAtMillis();
        String r5 = r8.getAppId();
        if (r5 == null) goto L22;
        String r6 = r8.getProxyKey();
        if (r6 == null) goto L20;
        SidecarBrand r7 = e(r8);
        if (r7 == null) goto L18;
        return new SidecarSessionEnv(r2, r3, r5, r6, r7);
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());
    L24:
        throw new IllegalArgumentException("Required value was null.".toString());
    L26:
        throw new IllegalArgumentException("sidecar callback did not contain a session".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final SidecarResultParcel a(String r16, String r17) {
        o.e(r16, "operationId");
        o.e(r17, "message");
        return a(new SidecarResult(false, 503, WsConstants.KEY_SERVICE, "service_unavailable", r17, "retry the sidecar operation", null, null, null, null, null, 1984, null), r16);
    }

    private static final SidecarAppInfo a(SidecarResultParcel r8, String r9) {
        SidecarBrand r2 = e(r8);
        if (r2 == null) goto L7;
        return new SidecarAppInfo(r9, r2, r8.getUserOpenId(), r8.getCurrentUserName(), r8.getHasUserToken(), r8.getHasBotToken());
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private static final SidecarBrand e(SidecarResultParcel r3) {
        Integer r4 = Integer.valueOf(r3.getBrand());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L13;
        d.d.a<SidecarBrand> r1 = SidecarBrand.getEntries();
        return (SidecarBrand) ZeusTransformUtils.preCheckCast(p.d((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue()), SidecarBrand.class, "com.obric.aiagent.plugin");
    L13:
        return null;
    L5:
        r0 = false;
        goto L7
    }
}
