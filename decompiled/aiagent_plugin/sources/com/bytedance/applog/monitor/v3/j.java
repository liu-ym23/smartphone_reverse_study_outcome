package com.bytedance.applog.monitor.v3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StatsCountKeys.java */
/* JADX INFO: loaded from: classes.dex */
public final enum j extends Enum<j> {
    public static final j A = null;
    public static final j B = null;
    public static final j C = null;
    public static final j D = null;
    public static final j E = null;
    public static final j F = null;
    public static final j G = null;
    public static final j H = null;
    public static final j I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final j f5823J = null;
    public static final j K = null;
    public static final j L = null;
    public static final j M = null;
    public static final j N = null;
    public static final j O = null;
    public static final j P = null;
    public static final j Q = null;
    public static final j R = null;
    public static final j S = null;
    public static final j T = null;
    public static final j U = null;
    public static final j V = null;
    public static final j W = null;
    public static final j X = null;
    public static final j Y = null;
    public static final j Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f5824a = null;
    public static final j aa = null;
    public static final j ab = null;
    public static final j ac = null;
    public static final j ad = null;
    public static final j ae = null;
    public static final j af = null;
    public static final j ag = null;
    public static final j ah = null;
    private static final /* synthetic */ j[] ai = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f5825b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f5826c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f5827d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f5828e = null;
    public static final j f = null;
    public static final j g = null;
    public static final j h = null;
    public static final j i = null;
    public static final j j = null;
    public static final j k = null;
    public static final j l = null;
    public static final j m = null;
    public static final j n = null;
    public static final j o = null;
    public static final j p = null;
    public static final j q = null;
    public static final j r = null;
    public static final j s = null;
    public static final j t = null;
    public static final j u = null;
    public static final j v = null;
    public static final j w = null;
    public static final j x = null;
    public static final j y = null;
    public static final j z = null;

    private j(String r1, int r2) {
        super(r1, r2);
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(ai.clone(), j[].class, "com.obric.aiagent.plugin");
    }

    static {
        f5824a = new j("COLLECT_EVENT_COUNT", 0);
        f5825b = new j("COLLECT_LAUNCH_COUNT", 1);
        f5826c = new j("COLLECT_FRONT_LAUNCH_COUNT", 2);
        f5827d = new j("COLLECT_TERMINATE_COUNT", 3);
        f5828e = new j("ACCEPT_EVENT_COUNT", 4);
        f = new j("REPORT_SUCCESS_EVENT_COUNT", 5);
        g = new j("REPORT_FAILED_EVENT_COUNT", 6);
        h = new j("REPORT_SUCCESS_LAUNCH_COUNT", 7);
        i = new j("REPORT_FAILED_LAUNCH_COUNT", 8);
        j = new j("REPORT_SUCCESS_TERMINATE_COUNT", 9);
        k = new j("REPORT_FAILED_TERMINATE_COUNT", 10);
        l = new j("REPORT_EVENT_DELAY_METRICS", 11);
        m = new j("CACHE_DROP_EVENT_COUNT", 12);
        n = new j("FILTER_DROP_EVENT_COUNT", 13);
        o = new j("SAMPLING_DROP_EVENT_COUNT", 14);
        p = new j("REALTIME_EVENT_COUNT", 15);
        q = new j("PILED_UP_EVENT_COUNT", 16);
        r = new j("PILED_UP_LAUNCH_COUNT", 17);
        s = new j("PILED_UP_TERMINATE_COUNT", 18);
        t = new j("PILED_UP_PACK_COUNT", 19);
        u = new j("PILED_UP_DB_SIZE_KB", 20);
        v = new j("REPORT_REQUEST_COUNT", 21);
        w = new j("REPORT_REQUEST_FAILED_COUNT", 22);
        x = new j("CONFIG_REQUEST_COUNT", 23);
        y = new j("CONFIG_REQUEST_FAILED_COUNT", 24);
        z = new j("CLEAN_UP_EVENT_COUNT", 25);
        A = new j("CLEAN_UP_LAUNCH_COUNT", 26);
        B = new j("CLEAN_UP_TERMINATE_COUNT", 27);
        C = new j("CONGESTION_BLOCK_REQUEST_COUNT", 28);
        D = new j("BACKOFF_BLOCK_REQUEST_COUNT", 29);
        E = new j("ADJUST_TERMINATE_BLOCK_REQUEST_COUNT", 30);
        F = new j("FLUSH_COUNT", 31);
        G = new j("DB_ERROR_COUNT", 32);
        H = new j("MEM_ERROR_COUNT", 33);
        I = new j("ENCRYPT_ERROR_COUNT", 34);
        f5823J = new j("PACK_ERROR_COUNT", 35);
        K = new j("NO_NETWORK_COUNT", 36);
        L = new j("REQUEST_ERROR_COUNT", 37);
        M = new j("COMPRESS_ERROR_COUNT", 38);
        N = new j("CONCURRENT_MODIFY_ERROR_COUNT", 39);
        O = new j("SOF_ERROR_COUNT", 40);
        P = new j("JSON_ERROR_COUNT", 41);
        Q = new j("REPORT_REALTIME_EVENTS_SUCCESS_COUNT", 42);
        R = new j("REPORT_REALTIME_EVENTS_FAILED_COUNT", 43);
        S = new j("APPLOG_BLOCK_EVENT_COUNT", 44);
        T = new j("REMOVE_EVENT_PARAM_COUNT", 45);
        U = new j("REMOVE_CUSTOM_HEADER_COUNT", 46);
        V = new j("INSERT_EVENT_V3_FAILED_COUNT", 47);
        W = new j("INSERT_EVENT_V1_FAILED_COUNT", 48);
        X = new j("INSERT_EVENT_MISC_FAILED_COUNT", 49);
        Y = new j("INSERT_SESSION_FAILED_COUNT", 50);
        Z = new j("INSERT_PAGE_FAILED_COUNT", 51);
        aa = new j("INSERT_PACK_FAILED_COUNT", 52);
        ab = new j("QUERY_EVENT_V3_FAILED_COUNT", 53);
        ac = new j("QUERY_EVENT_V1_FAILED_COUNT", 54);
        ad = new j("QUERY_EVENT_MISC_FAILED_COUNT", 55);
        ae = new j("QUERY_SESSION_FAILED_COUNT", 56);
        af = new j("QUERY_PAGE_FAILED_COUNT", 57);
        ag = new j("COLLECT_IMPRESSION_ERROR_COUNT", 58);
        ah = new j("PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT", 59);
        ai = new j[]{f5824a, f5825b, f5826c, f5827d, f5828e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, f5823J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah};
    }
}
