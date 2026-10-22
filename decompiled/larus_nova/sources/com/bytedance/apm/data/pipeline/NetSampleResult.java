package com.bytedance.apm.data.pipeline;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum NetSampleResult extends Enum<NetSampleResult> {
    public static final NetSampleResult HIT = null;
    public static final NetSampleResult NOT_HIT = null;
    public static final NetSampleResult UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetSampleResult[] f190539a = null;

    static {
        NetSampleResult r100 = new NetSampleResult("UNKNOWN", 0);
        UNKNOWN = r100;
        NetSampleResult r101 = new NetSampleResult("HIT", 1);
        HIT = r101;
        NetSampleResult r102 = new NetSampleResult("NOT_HIT", 2);
        NOT_HIT = r102;
        f190539a = new NetSampleResult[]{r100, r101, r102};
    }

    public static NetSampleResult[] values() {
        return (NetSampleResult[]) f190539a.clone();
    }

    public static NetSampleResult valueOf(String r100) {
        return (NetSampleResult) a.a(NetSampleResult.class, r100);
    }

    public NetSampleResult(String r100, int r101) {
        super(r100, r101);
    }
}
