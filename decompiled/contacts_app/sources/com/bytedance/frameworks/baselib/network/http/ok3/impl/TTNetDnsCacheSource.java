package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes2.dex */
final enum TTNetDnsCacheSource extends Enum<TTNetDnsCacheSource> {
    private static final /* synthetic */ TTNetDnsCacheSource[] $VALUES = null;
    public static final TTNetDnsCacheSource SOURCE_ASYNC_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PRELOAD_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PROC = null;
    public static final TTNetDnsCacheSource UNKNOWN = null;
    final int mValue;

    public static TTNetDnsCacheSource valueOf(String r1) {
        return (TTNetDnsCacheSource) Enum.valueOf(TTNetDnsCacheSource.class, r1);
    }

    public static TTNetDnsCacheSource[] values() {
        return (TTNetDnsCacheSource[]) $VALUES.clone();
    }

    static {
        TTNetDnsCacheSource r0 = new TTNetDnsCacheSource("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        TTNetDnsCacheSource r1 = new TTNetDnsCacheSource("SOURCE_HTTPDNS", 1, 3);
        SOURCE_HTTPDNS = r1;
        TTNetDnsCacheSource r2 = new TTNetDnsCacheSource("SOURCE_PROC", 2, 6);
        SOURCE_PROC = r2;
        TTNetDnsCacheSource r6 = new TTNetDnsCacheSource("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7);
        SOURCE_PRELOAD_BATCH_HTTPDNS = r6;
        TTNetDnsCacheSource r7 = new TTNetDnsCacheSource("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8);
        SOURCE_ASYNC_BATCH_HTTPDNS = r7;
        $VALUES = new TTNetDnsCacheSource[]{r0, r1, r2, r6, r7};
    }

    private TTNetDnsCacheSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }
}
