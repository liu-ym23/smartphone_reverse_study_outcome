package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum dy extends Enum<dy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dy f19786a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final dy f19787b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final dy f19788c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final dy f19789d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final dy f19790e = null;
    public static final dy f = null;
    public static final dy g = null;
    public static final dy h = null;
    public static final dy i = null;
    public static final dy j = null;
    public static final dy k = null;
    public static final dy l = null;
    public static final dy m = null;
    public static final dy n = null;
    public static final dy o = null;
    public static final dy p = null;
    public static final dy q = null;
    public static final dy r = null;
    public static final dy s = null;
    private static final /* synthetic */ dy[] u = null;
    private static final /* synthetic */ d.d.a v = null;
    private final String t;

    private static final /* synthetic */ dy[] b() {
        return new dy[]{f19786a, f19787b, f19788c, f19789d, f19790e, f, g, h, i, j, k, l, m, n, o, p, q, r, s};
    }

    private dy(String r1, int r2, String r3) {
        super(r1, r2);
        this.t = r3;
    }

    public final String a() {
        return this.t;
    }

    static {
        f19786a = new dy("PACKAGE_DOWNLOAD", 0, "skill_package_download");
        f19787b = new dy("FILE_PREPARE", 1, "skill_file_prepare");
        f19788c = new dy("INSTALL", 2, "skill_install");
        f19789d = new dy("EDIT", 3, "skill_edit");
        f19790e = new dy("SECURITY_SCAN_SUBMIT", 4, "security_scan_submit");
        f = new dy("SECURITY_SCAN_QUERY", 5, "security_scan_query");
        g = new dy("SECURITY_SCAN_TASK_RESULT", 6, "security_scan_task_result");
        h = new dy("SECURITY_SCAN_MANIFEST_FETCH", 7, "security_scan_manifest_fetch");
        i = new dy("SECURITY_SCAN_VERIFY", 8, "security_scan_verify");
        j = new dy("SECURITY_SCAN_DECISION_FETCH", 9, "security_scan_decision_fetch");
        k = new dy("SECURITY_SCAN_DETAIL_REFRESH", 10, "security_scan_detail_refresh");
        l = new dy("MANAGER_INIT", 11, "skill_manager_init");
        m = new dy("SWITCH", 12, "skill_switch");
        n = new dy("DELETE", 13, "skill_delete");
        o = new dy("BACKGROUND_CLEANUP", 14, "skill_background_cleanup");
        p = new dy("COVER_UPDATE", 15, "skill_cover_update");
        q = new dy("STORE_PAGE_LOAD", 16, "skill_store_page_load");
        r = new dy("STORE_METADATA_REFRESH", 17, "skill_store_metadata_refresh");
        s = new dy("CLI_REFRESH", 18, "skill_cli_refresh");
        dy[] r0 = b();
        u = r0;
        v = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static dy valueOf(String r2) {
        return (dy) ZeusTransformUtils.preCheckCast(Enum.valueOf(dy.class, r2), dy.class, "com.obric.aiagent.plugin");
    }

    public static dy[] values() {
        return (dy[]) ZeusTransformUtils.preCheckCast(u.clone(), dy[].class, "com.obric.aiagent.plugin");
    }
}
