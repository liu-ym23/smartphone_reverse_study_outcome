package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum TTNetDnsSource extends Enum<TTNetDnsSource> {
    private static final /* synthetic */ TTNetDnsSource[] $VALUES = null;
    public static final TTNetDnsSource NOT_SET = null;
    public static final TTNetDnsSource SERVE_FROM_ASYNC_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_CACHE = null;
    public static final TTNetDnsSource SERVE_FROM_HARDCODE_HOSTS = null;
    public static final TTNetDnsSource SERVE_FROM_HTTP_DNS_JOB = null;
    public static final TTNetDnsSource SERVE_FROM_PREFER_ADDR = null;
    public static final TTNetDnsSource SERVE_FROM_PROC_DNS_JOB = null;
    final int mValue;

    static {
        TTNetDnsSource r10 = new TTNetDnsSource("NOT_SET", 0, 0);
        NOT_SET = r10;
        TTNetDnsSource r11 = new TTNetDnsSource("SERVE_FROM_CACHE", 1, 2);
        SERVE_FROM_CACHE = r11;
        TTNetDnsSource r12 = new TTNetDnsSource("SERVE_FROM_PREFER_ADDR", 2, 5);
        SERVE_FROM_PREFER_ADDR = r12;
        TTNetDnsSource r13 = new TTNetDnsSource("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        SERVE_FROM_HTTP_DNS_JOB = r13;
        TTNetDnsSource r14 = new TTNetDnsSource("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        SERVE_FROM_PROC_DNS_JOB = r14;
        TTNetDnsSource r15 = new TTNetDnsSource("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        SERVE_FROM_HARDCODE_HOSTS = r15;
        TTNetDnsSource r16 = new TTNetDnsSource("SERVE_FROM_BATCH_PRELOAD", 6, 19);
        SERVE_FROM_BATCH_PRELOAD = r16;
        TTNetDnsSource r17 = new TTNetDnsSource("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20);
        SERVE_FROM_ASYNC_BATCH_PRELOAD = r17;
        $VALUES = new TTNetDnsSource[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private TTNetDnsSource(String r10, int r11, int r12) {
        super(r10, r11);
        this.mValue = r12;
    }

    public static TTNetDnsSource valueOf(String r10) {
        return (TTNetDnsSource) Enum.valueOf(TTNetDnsSource.class, r10);
    }

    public static TTNetDnsSource[] values() {
        return (TTNetDnsSource[]) $VALUES.clone();
    }
}
