package com.bytedance.applog.monitor.v3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventStage.java */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {
    public static final a A = null;
    public static final a B = null;
    public static final a C = null;
    public static final a D = null;
    public static final a E = null;
    public static final a F = null;
    public static final a G = null;
    public static final a H = null;
    public static final a I = null;
    private static final /* synthetic */ a[] K = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5768b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5769c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5770d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5771e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    public static final a j = null;
    public static final a k = null;
    public static final a l = null;
    public static final a m = null;
    public static final a n = null;
    public static final a o = null;
    public static final a p = null;
    public static final a q = null;
    public static final a r = null;
    public static final a s = null;
    public static final a t = null;
    public static final a u = null;
    public static final a v = null;
    public static final a w = null;
    public static final a x = null;
    public static final a y = null;
    public static final a z = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final String f5772J;

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(K.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("UNKNOWN", 0, "-1");
        f5767a = r0;
        a r1 = new a("COLLECTED", 1, "00");
        f5768b = r1;
        a r3 = new a("PARAMS_INVALID_DROP", 2, "01");
        f5769c = r3;
        a r5 = new a("NOT_INIT_DROP", 3, "02");
        f5770d = r5;
        a r7 = new a("PRE_PROCESS_START", 4, "03");
        f5771e = r7;
        a r9 = new a("CACHED_BEFORE_HANDLE", 5, "04");
        f = r9;
        a r11 = new a("CACHE_DROP_BEFORE_HANDLE", 6, "05");
        g = r11;
        a r13 = new a("DATA_LIST_ADDED", 7, "06");
        h = r13;
        a r12 = new a("PRE_PROCESS_END", 8, "0F");
        i = r12;
        a r10 = new a("PROCESS_START", 9, "10");
        j = r10;
        a r8 = new a("TOURIST_BREAK", 10, "11");
        k = r8;
        a r6 = new a("FILTER_EVENT_BLOCKED", 11, "12");
        l = r6;
        a r4 = new a("FILTER_SERVER_BLOCKED", 12, "13");
        m = r4;
        a r2 = new a("FILTER_CUSTOM_BLOCKED", 13, "14");
        n = r2;
        a r14 = new a("FILTER_SAMPLING_DROPPED", 14, "15");
        o = r14;
        a r15 = new a("NO_SESSION_DROP", 15, "16");
        p = r15;
        a r16 = new a("PROCESS_END", 16, "1F");
        q = r16;
        a r17 = new a("DB_SAVE_START", 17, "20");
        r = r17;
        a r18 = new a("HANDLE_REALTIME_START", 18, "21");
        s = r18;
        a r19 = new a("REALTIME_SEND_START", 19, "22");
        t = r19;
        a r20 = new a("REALTIME_SEND_FAILED", 20, "23");
        u = r20;
        a r21 = new a("REALTIME_CRASH_DROP", 21, "24");
        v = r21;
        a r22 = new a("PRIORITY_HANDLE", 22, "28");
        w = r22;
        a r23 = new a("PRIORITY_ACCEPT", 23, "29");
        x = r23;
        a r24 = new a("DB_INSERT_START", 24, "2A");
        y = r24;
        a r25 = new a("DB_SAVE_FAILED", 25, "2B");
        z = r25;
        a r26 = new a("DB_SAVE_END", 26, "2F");
        A = r26;
        a r27 = new a("REPORT_START", 27, "30");
        B = r27;
        a r28 = new a("PACK_END", 28, "31");
        C = r28;
        a r29 = new a("PACK_INSERT_START", 29, "34");
        D = r29;
        a r30 = new a("PACK_INSERT_FAILED", 30, "35");
        E = r30;
        a r31 = new a("PACK_INSERT_END", 31, "36");
        F = r31;
        a r32 = new a("POST_START", 32, "3A");
        G = r32;
        a r33 = new a("POST_FAILED", 33, "3B");
        H = r33;
        a r34 = new a("REPORT_END", 34, "3F");
        I = r34;
        K = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
    }

    private a(String r1, int r2, String r3) {
        super(r1, r2);
        this.f5772J = r3;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f5772J;
    }

    public static a a(String r5) {
        a[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        a r3 = r0[r2];
        if (r3.f5772J.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return f5767a;
    }
}
