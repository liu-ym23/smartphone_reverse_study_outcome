package com.obric.aiagent.skill.manager.impl;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ci extends Enum<ci> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ci f19660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ci f19661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ci f19662c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ci f19663d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ci f19664e = null;
    public static final ci f = null;
    public static final ci g = null;
    public static final ci h = null;
    public static final ci i = null;
    private static final /* synthetic */ ci[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final String j;

    private static final /* synthetic */ ci[] b() {
        return new ci[]{f19660a, f19661b, f19662c, f19663d, f19664e, f, g, h, i};
    }

    private ci(String r1, int r2, String r3) {
        super(r1, r2);
        this.j = r3;
    }

    public final String a() {
        return this.j;
    }

    static {
        f19660a = new ci("INVALID_INPUT", 0, "invalid_input");
        f19661b = new ci("DISPLAY_NAME_CONFLICT", 1, "display_name_conflict");
        f19662c = new ci("SKILL_NOT_FOUND", 2, "skill_not_found");
        f19663d = new ci("DOWNLOAD_FAILED", 3, MonitorConstants.EXTRA_DOWNLOAD_SERVICE_NAME_FAIL);
        f19664e = new ci("FILE_WRITE_FAILED", 4, "file_write_failed");
        f = new ci("FILE_PARSE_FAILED", 5, "file_parse_failed");
        g = new ci("POLICY_REJECTED", 6, "policy_rejected");
        h = new ci("SERVICE_UNAVAILABLE", 7, "service_unavailable");
        i = new ci("UNKNOWN", 8, SensitiveType.UNKNOWN);
        ci[] r0 = b();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ci valueOf(String r2) {
        return (ci) ZeusTransformUtils.preCheckCast(Enum.valueOf(ci.class, r2), ci.class, "com.obric.aiagent.plugin");
    }

    public static ci[] values() {
        return (ci[]) ZeusTransformUtils.preCheckCast(k.clone(), ci[].class, "com.obric.aiagent.plugin");
    }
}
