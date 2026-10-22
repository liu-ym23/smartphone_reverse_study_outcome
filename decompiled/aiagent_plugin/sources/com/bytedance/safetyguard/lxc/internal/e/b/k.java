package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.api.SidecarAuthResponse;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.s;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SidecarErrorMapper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f10703a = null;

    static {
        f10703a = new k();
    }

    private final String b(int r1) {
        if (r1 != 400) goto L5;
        return "Bad Request";
    L5:
        if (r1 != 401) goto L7;
        return "Unauthorized";
    L7:
        if (r1 != 403) goto L9;
        return "Forbidden";
    L9:
        if (r1 != 413) goto L11;
        return "Payload Too Large";
    L11:
        if (r1 != 502) goto L13;
        return "Bad Gateway";
    L13:
        if (r1 == 503) goto L15;
        return "Error";
    L15:
        return "Service Unavailable";
    }

    private k() {
    }

    public final SidecarAuthResponse a() {
        return a(this, 503, "Service Unavailable", 99991660, "sidecar_not_configured", null, 16, null);
    }

    public final SidecarAuthResponse b() {
        return a(this, 401, "Unauthorized", 99991661, "token_missing", null, 16, null);
    }

    public final SidecarAuthResponse a(com.bytedance.safetyguard.lxc.internal.e.h.a r9) {
        o.e(r9, WsConstants.KEY_CONNECTION_ERROR);
        com.bytedance.safetyguard.lxc.internal.e.c.g r4 = r9.c();
        if (r4 == null) goto L8;
        l r1 = l.f10704a;
        String r0 = r9.b();
        if (r0 != null) goto L7;
        r0 = "token-resolve";
    L7:
        SidecarResult r2 = l.a(r1, "authentication", r0, r4, null, 8, null);
    L9:
        if (r2 == null) goto L11;
        JSONObject r8 = new JSONObject().put(MonitorConstants.CODE, 99991667).put("msg", r9.a()).put("detail", r9.getMessage());
        Integer r10 = r2.getSubcode();
        if (r10 == null) goto L15;
        r8.put("subcode", ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
    L15:
        r8.put("type", r2.getType());
        r8.put("subtype", r2.getSubtype());
        r8.put("message", r2.getMessage());
        r8.put("hint", r2.getHint());
        Map r3 = ao.a(s.a(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8"));
        String r11 = r8.toString() + '\n';
        Charset r5 = StandardCharsets.UTF_8;
        o.c(r5, "UTF_8");
        byte[] r12 = r11.getBytes(r5);
        o.c(r12, "getBytes(...)");
        return new SidecarAuthResponse(401, "Unauthorized", r3, r12);
    L11:
        return a(401, "Unauthorized", 99991667, r9.a(), r9.getMessage());
    L8:
        r2 = null;
        goto L9
    }

    public final SidecarAuthResponse c() {
        return a(this, 401, "Unauthorized", 99991662, "sidecar_session_invalid", null, 16, null);
    }

    public final SidecarAuthResponse a(int r9) {
        return a(this, r9, b(r9), 99991663, "sidecar_request_rejected", null, 16, null);
    }

    public final SidecarAuthResponse d() {
        return a(this, BDVideoUploaderBase.KeyIsMaxUploadSpeedThresh, "Payload Too Large", 99991665, "sidecar_request_too_large", null, 16, null);
    }

    public final SidecarAuthResponse e() {
        return a(this, EntityType.AUDITORY_RECORDING, "Bad Gateway", 99991666, "sidecar_response_too_large", null, 16, null);
    }

    public final SidecarAuthResponse f() {
        return a(this, EntityType.AUDITORY_RECORDING, "Bad Gateway", 99991670, "sidecar_forward_failed", null, 16, null);
    }

    public final SidecarAuthResponse g() {
        return a(this, 500, "Internal Server Error", 99991699, "sidecar_internal_error", null, 16, null);
    }

    static /* synthetic */ SidecarAuthResponse a(k r6, int r7, String r8, int r9, String r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.a(r7, r8, r9, r10, r11);
    }

    private final SidecarAuthResponse a(int r4, String r5, int r6, String r7, String r8) {
        if (r8 == null) goto L4;
        String r3 = a(r8);
    L6:
        if (r3 != null) goto L8;
        String r9 = "{\"code\":" + r6 + ",\"msg\":\"" + r7 + "\"}\n";
    L9:
        Map r10 = ao.a(s.a(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8"));
        Charset r11 = StandardCharsets.UTF_8;
        o.c(r11, "UTF_8");
        byte[] r12 = r9.getBytes(r11);
        o.c(r12, "getBytes(...)");
        return new SidecarAuthResponse(r4, r5, r10, r12);
    L8:
        r9 = "{\"code\":" + r6 + ",\"msg\":\"" + r7 + "\",\"detail\":\"" + r3 + "\"}\n";
        goto L9
    L4:
        r3 = null;
        goto L6
    }

    private final String a(String r13) {
        return d.o.o.a(d.o.o.a(d.o.o.a(d.o.o.a(r13, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
    }
}
