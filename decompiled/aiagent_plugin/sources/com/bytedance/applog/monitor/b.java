package com.bytedance.applog.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MonitorKey.java */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {
    public static final b A = null;
    private static final /* synthetic */ b[] B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5758b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5759c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f5760d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f5761e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    public static final b k = null;
    public static final b l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    public static final b p = null;
    public static final b q = null;
    public static final b r = null;
    public static final b s = null;
    public static final b t = null;
    public static final b u = null;
    public static final b v = null;
    public static final b w = null;
    public static final b x = null;
    public static final b y = null;
    public static final b z = null;

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(B.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("monitor_default", 0);
        f5757a = r0;
        b r1 = new b("event", 1);
        f5758b = r1;
        b r3 = new b("event_v3", 2);
        f5759c = r3;
        b r5 = new b("log_data", 3);
        f5760d = r5;
        b r7 = new b("item_impression", 4);
        f5761e = r7;
        b r9 = new b("launch", 5);
        f = r9;
        b r11 = new b("terminate", 6);
        g = r11;
        b r13 = new b("real_event", 7);
        h = r13;
        b r15 = new b("pack", 8);
        i = r15;
        b r14 = new b("database", 9);
        j = r14;
        b r12 = new b("register", 10);
        k = r12;
        b r10 = new b("active", 11);
        l = r10;
        b r8 = new b("config", 12);
        m = r8;
        b r6 = new b("ab_config", 13);
        n = r6;
        b r4 = new b("engine", 14);
        o = r4;
        b r2 = new b("log_send", 15);
        p = r2;
        b r16 = new b("migrate_old", 16);
        q = r16;
        b r17 = new b("f_cache_event", 17);
        r = r17;
        b r18 = new b("filtered_event", 18);
        s = r18;
        b r19 = new b("f_db_insert_event", 19);
        t = r19;
        b r20 = new b("f_to_pack_event", 20);
        u = r20;
        b r21 = new b("sampling_event", 21);
        v = r21;
        b r22 = new b("f_to_bytes_event", 22);
        w = r22;
        b r23 = new b("f_to_bytes_encrypt_event", 23);
        x = r23;
        b r24 = new b("large_event", 24);
        y = r24;
        b r25 = new b("f_expire_event", 25);
        z = r25;
        b r26 = new b("f_oom_event", 26);
        A = r26;
        B = new b[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26};
    }
}
