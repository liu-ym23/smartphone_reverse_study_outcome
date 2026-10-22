package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum Features$ReportInterval extends Enum<Features$ReportInterval> {
    public static final Features$ReportInterval BIG_THAN_60 = null;
    public static final Features$ReportInterval DEFAULT_60 = null;
    public static final Features$ReportInterval LESS_THAN_60 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Features$ReportInterval[] f192498a = null;
    private int value;

    static {
        Features$ReportInterval r100 = new Features$ReportInterval("DEFAULT_60", 0, 0);
        DEFAULT_60 = r100;
        Features$ReportInterval r101 = new Features$ReportInterval("LESS_THAN_60", 1, 1);
        LESS_THAN_60 = r101;
        Features$ReportInterval r102 = new Features$ReportInterval("BIG_THAN_60", 2, 2);
        BIG_THAN_60 = r102;
        f192498a = new Features$ReportInterval[]{r100, r101, r102};
    }

    public static Features$ReportInterval[] values() {
        return (Features$ReportInterval[]) f192498a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static Features$ReportInterval valueOf(String r100) {
        return (Features$ReportInterval) a.a(Features$ReportInterval.class, r100);
    }

    public Features$ReportInterval(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
