package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum t extends Enum<t> {
    public static final t A = null;
    public static final t B = null;
    public static final t C = null;
    public static final t D = null;
    public static final t E = null;
    public static final t F = null;
    public static final t G = null;
    public static final t H = null;
    public static final t I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final t f19307J = null;
    public static final t K = null;
    public static final t L = null;
    public static final t M = null;
    public static final t N = null;
    public static final t O = null;
    public static final t P = null;
    public static final t Q = null;
    public static final t R = null;
    public static final t S = null;
    public static final t T = null;
    public static final t U = null;
    public static final t V = null;
    public static final t W = null;
    private static final /* synthetic */ t[] X = null;
    private static final /* synthetic */ d.d.a Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f19308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f19309b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f19310c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f19311d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t f19312e = null;
    public static final t f = null;
    public static final t g = null;
    public static final t h = null;
    public static final t i = null;
    public static final t j = null;
    public static final t k = null;
    public static final t l = null;
    public static final t m = null;
    public static final t n = null;
    public static final t o = null;
    public static final t p = null;
    public static final t q = null;
    public static final t r = null;
    public static final t s = null;
    public static final t t = null;
    public static final t u = null;
    public static final t v = null;
    public static final t w = null;
    public static final t x = null;
    public static final t y = null;
    public static final t z = null;

    private static final /* synthetic */ t[] a() {
        return new t[]{f19308a, f19309b, f19310c, f19311d, f19312e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, f19307J, K, L, M, N, O, P, Q, R, S, T, U, V, W};
    }

    private t(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19308a = new t("SKILL_FEATURE_DISABLED", 0);
        f19309b = new t("SKILL_EXTENSION_DISABLED", 1);
        f19310c = new t("SKILL_CAPABILITY_UNAVAILABLE", 2);
        f19311d = new t("SKILL_AVAILABILITY_UNKNOWN", 3);
        f19312e = new t("SKILL_NAME_CONFLICT", 4);
        f = new t("SKILL_NAME_IMMUTABLE", 5);
        g = new t("SKILL_NOT_FOUND", 6);
        h = new t("SKILL_NOT_EDITABLE", 7);
        i = new t("SCAN_IN_PROGRESS", 8);
        j = new t("SECURITY_SCAN_NOT_STARTED", 9);
        k = new t("SECURITY_SCAN_FAILED", 10);
        l = new t("SECURITY_RESULT_UNAVAILABLE", 11);
        m = new t("SECURITY_STATUS_REFRESH_FAILED", 12);
        n = new t("SECURITY_BLOCKED", 13);
        o = new t("DOWNLOAD_SERVICE_UNAVAILABLE", 14);
        p = new t("DOWNLOAD_URL_REJECTED", 15);
        q = new t("DOWNLOAD_TOO_MANY_REDIRECTS", 16);
        r = new t("DOWNLOAD_HTTP_ERROR", 17);
        s = new t("DOWNLOAD_NETWORK_ERROR", 18);
        t = new t("DOWNLOAD_IO_ERROR", 19);
        u = new t("STORE_SKILL_NOT_FOUND", 20);
        v = new t("STORE_SERVICE_UNAVAILABLE", 21);
        w = new t("STORE_NETWORK_FAILURE", 22);
        x = new t("STORE_RESPONSE_INVALID", 23);
        y = new t("SCAN_SUBMISSION_FAILED", 24);
        z = new t("FILE_UNAVAILABLE", 25);
        A = new t("SOURCE_FILE_TOO_LARGE", 26);
        B = new t("SKILL_MARKDOWN_TOO_LARGE", 27);
        C = new t("ZIP_ENTRY_TOO_LARGE", 28);
        D = new t("ZIP_PACKAGE_TOO_LARGE", 29);
        E = new t("ZIP_TOO_MANY_ENTRIES", 30);
        F = new t("INVALID_ZIP", 31);
        G = new t("UNSAFE_ZIP_PATH", 32);
        H = new t("DUPLICATE_ZIP_ENTRY", 33);
        I = new t("STORE_ONLY_PACKAGE", 34);
        f19307J = new t("MISSING_SKILL_MARKDOWN", 35);
        K = new t("MULTIPLE_SKILL_MARKDOWN", 36);
        L = new t("INVALID_SKILL_MARKDOWN_LOCATION", 37);
        M = new t("SKILL_MARKDOWN_CONTENT_TOO_LONG", 38);
        N = new t("FRONTMATTER_MISSING", 39);
        O = new t("FRONTMATTER_UNCLOSED", 40);
        P = new t("DUPLICATE_FRONTMATTER_FIELD", 41);
        Q = new t("NAME_REQUIRED", 42);
        R = new t("SKILL_NAME_INVALID", 43);
        S = new t("DESCRIPTION_REQUIRED", 44);
        T = new t("BODY_REQUIRED", 45);
        U = new t("PROCESSING_FAILED", 46);
        V = new t("PACKAGE_HASH_MISMATCH", 47);
        W = new t("PACKAGE_INVALID", 48);
        t[] r0 = a();
        X = r0;
        Y = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static t valueOf(String r2) {
        return (t) ZeusTransformUtils.preCheckCast(Enum.valueOf(t.class, r2), t.class, "com.obric.aiagent.plugin");
    }

    public static t[] values() {
        return (t[]) ZeusTransformUtils.preCheckCast(X.clone(), t[].class, "com.obric.aiagent.plugin");
    }
}
