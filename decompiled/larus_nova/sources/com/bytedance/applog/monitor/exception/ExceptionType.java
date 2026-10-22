package com.bytedance.applog.monitor.exception;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum ExceptionType extends Enum<ExceptionType> {
    public static final ExceptionType CacheOverflow = null;
    public static final ExceptionType CommonError = null;
    public static final ExceptionType HighFrequency = null;
    public static final ExceptionType InterruptionBlockList = null;
    public static final ExceptionType InterruptionEventList = null;
    public static final ExceptionType InterruptionInvalidDid = null;
    public static final ExceptionType InterruptionSampling = null;
    public static final ExceptionType InterruptionTouristMode = null;
    public static final ExceptionType LargeSize = null;
    public static final ExceptionType OutOfDataBoundary = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExceptionType[] f192494a = null;

    static {
        ExceptionType r100 = new ExceptionType("InterruptionInvalidDid", 0);
        InterruptionInvalidDid = r100;
        ExceptionType r101 = new ExceptionType("InterruptionBlockList", 1);
        InterruptionBlockList = r101;
        ExceptionType r102 = new ExceptionType("InterruptionTouristMode", 2);
        InterruptionTouristMode = r102;
        ExceptionType r103 = new ExceptionType("InterruptionEventList", 3);
        InterruptionEventList = r103;
        ExceptionType r104 = new ExceptionType("InterruptionSampling", 4);
        InterruptionSampling = r104;
        ExceptionType r105 = new ExceptionType("OutOfDataBoundary", 5);
        OutOfDataBoundary = r105;
        ExceptionType r110 = new ExceptionType("CacheOverflow", 6);
        CacheOverflow = r110;
        ExceptionType r111 = new ExceptionType("CommonError", 7);
        CommonError = r111;
        ExceptionType r112 = new ExceptionType("HighFrequency", 8);
        HighFrequency = r112;
        ExceptionType r113 = new ExceptionType("LargeSize", 9);
        LargeSize = r113;
        f192494a = new ExceptionType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static ExceptionType[] values() {
        return (ExceptionType[]) f192494a.clone();
    }

    public static ExceptionType valueOf(String r100) {
        return (ExceptionType) a.a(ExceptionType.class, r100);
    }

    public ExceptionType(String r100, int r101) {
        super(r100, r101);
    }
}
