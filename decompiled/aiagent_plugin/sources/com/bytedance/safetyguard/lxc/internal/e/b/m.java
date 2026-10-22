package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: SidecarResultFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10705a = null;

    static {
        f10705a = new m();
    }

    private m() {
    }

    public final SidecarResult a(String r16, SidecarBrand r17, String r18) {
        o.e(r16, "appId");
        o.e(r17, PlatformConst.BUNDLE_KEY_BRAND);
        return new SidecarResult(true, 0, null, null, "app configured", null, r16, r18, r17, null, null, 1582, null);
    }

    public final SidecarResult a(String r16, SidecarBrand r17) {
        o.e(r16, "appId");
        o.e(r17, PlatformConst.BUNDLE_KEY_BRAND);
        return new SidecarResult(true, 0, null, null, "app imported", null, r16, null, r17, null, null, 1710, null);
    }

    public final SidecarResult a(String r15) {
        o.e(r15, "appId");
        return new SidecarResult(true, 0, null, null, "app deleted", null, r15, null, null, null, null, 1966, null);
    }

    public final SidecarResult a() {
        return a(this, "config", "unsupported_production", 400, "unsupported production", null, null, null, null, 240, null);
    }

    public final SidecarResult b(String r13) {
        o.e(r13, "message");
        return a(this, "config", "app_registration_failed", 500, r13, "retry configCreateApp or use configImportApp with an existing app", null, null, null, 224, null);
    }

    public final SidecarResult b() {
        return a(this, "config", "invalid_app_id", 400, "appId must not be blank", null, null, null, null, 240, null);
    }

    public final SidecarResult c() {
        return a(this, "config", "invalid_app_secret", 400, "appSecret must not be blank", null, null, null, null, 240, null);
    }

    public final SidecarResult c(String r13) {
        o.e(r13, "message");
        return a(this, "config", "credential_store_failed", 500, r13, "retry the operation; clear app configuration if the failure persists", null, null, null, 224, null);
    }

    public final SidecarResult d() {
        return a(this, SensitiveType.SESSION, "invalid_session_ttl", 400, "ttlSeconds must be positive and produce a valid expiration time", null, null, null, null, 240, null);
    }

    public final SidecarResult d(String r13) {
        o.e(r13, "message");
        return a(this, "config", "unsupported_brand", 400, r13, null, null, null, null, 240, null);
    }

    public final SidecarResult e() {
        return a(this, "config", "app_not_found", 404, "app not found", null, null, null, null, 240, null);
    }

    public static /* synthetic */ SidecarResult a(m r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "app not configured";
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = null;
    L9:
        return r0.a(r1, r2);
    }

    public final SidecarResult a(String r13, String r14) {
        o.e(r13, "message");
        return a(this, "config", "not_configured", 404, r13, r14, null, null, null, 224, null);
    }

    public final SidecarResult e(String r13) {
        o.e(r13, "appId");
        return a(this, "config", "not_configured", 404, "app is not configured", "call configCreateApp or configImportApp before login", r13, null, null, 192, null);
    }

    public final SidecarResult f(String r13) {
        o.e(r13, "appId");
        return a(this, "config", "bot_credentials_missing", 401, "configured App does not support bot identity", null, r13, null, null, 208, null);
    }

    public final SidecarResult g(String r13) {
        o.e(r13, "appId");
        return a(this, "authentication", "user_not_logged_in", 401, "current user is not logged in", null, r13, null, null, 208, null);
    }

    public final SidecarResult b(String r13, String r14) {
        o.e(r13, "appId");
        o.e(r14, "userOpenId");
        return a(this, "authentication", "user_not_logged_in", 401, "current user credential is not available", null, r13, r14, null, 144, null);
    }

    public final SidecarResult a(String r16, String r17, Set<String> r18) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.aiagent.plugin");
        o.e(r16, "appId");
        o.e(r17, "userOpenId");
        o.e(r11, "scopes");
        return new SidecarResult(true, 0, null, null, "authorization complete", null, r16, r17, null, r11, null, 1326, null);
    }

    public final SidecarResult c(String r16, String r17) {
        o.e(r16, "appId");
        return new SidecarResult(true, 0, null, null, "logout complete", null, r16, r17, null, null, null, 1838, null);
    }

    public static /* synthetic */ SidecarResult a(m r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    public final SidecarResult a(String r13, String r14, String r15, String r16) {
        o.e(r13, "type");
        o.e(r14, "subtype");
        o.e(r15, "message");
        return a(this, r13, r14, 501, r15, null, r16, null, null, 208, null);
    }

    public final SidecarResult f() {
        return a(this, "config", "operation_in_progress", 409, "OPERATION_IN_PROGRESS", null, null, null, null, 240, null);
    }

    public final SidecarResult g() {
        return a(this, "config", "app_already_configured", 409, "APP_ALREADY_CONFIGURED", null, null, null, null, 240, null);
    }

    public final SidecarResult h() {
        return a(this, "operation", "operation_cancelled", 499, "sidecar operation cancelled", null, null, null, null, 240, null);
    }

    public final SidecarResult b(String r13, String r14, String r15, String r16) {
        o.e(r13, "subtype");
        o.e(r14, "message");
        o.e(r15, "hint");
        o.e(r16, "appId");
        return a(this, "authentication", r13, 401, r14, r15, r16, null, null, 192, null);
    }

    public static /* synthetic */ SidecarResult a(m r12, String r13, String r14, int r15, String r16, String r17, String r18, String r19, Integer r20, int r21, Object r22) {
        if ((r21 & 16) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r21 & 32) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r21 & 64) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r21 & 128) == 0) goto L17;
        Integer r11 = null;
    L19:
        return r12.a(r13, r14, r15, r16, r8, r9, r10, r11);
    L17:
        r11 = r20;
        goto L19
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    public final SidecarResult a(String r16, String r17, int r18, String r19, String r20, String r21, String r22, Integer r23) {
        o.e(r16, "type");
        o.e(r17, "subtype");
        o.e(r19, "message");
        return new SidecarResult(false, r18, r16, r17, r19, r20, r21, r22, null, null, r23, 768, null);
    }
}
