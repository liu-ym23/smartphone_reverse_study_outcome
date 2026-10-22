package com.bytedance.android.live.broadcast.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/SpeedTestResult;", "", "", "value", "I", "getValue", "()I", "SpeedTestResultUnknown", "SpeedTestResultQualified", "Unqualified", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SpeedTestResult extends Enum<SpeedTestResult> {
    public static final SpeedTestResult SpeedTestResultQualified = null;
    public static final SpeedTestResult SpeedTestResultUnknown = null;
    public static final SpeedTestResult Unqualified = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpeedTestResult[] f59023a = null;
    private final int value;

    static {
        SpeedTestResult r100 = new SpeedTestResult("SpeedTestResultUnknown", 0, 0);
        SpeedTestResultUnknown = r100;
        SpeedTestResult r101 = new SpeedTestResult("SpeedTestResultQualified", 1, 1);
        SpeedTestResultQualified = r101;
        SpeedTestResult r102 = new SpeedTestResult("Unqualified", 2, 2);
        Unqualified = r102;
        f59023a = new SpeedTestResult[]{r100, r101, r102};
    }

    public static SpeedTestResult valueOf(String r100) {
        return (SpeedTestResult) r27.a.a(SpeedTestResult.class, r100);
    }

    public static SpeedTestResult[] values() {
        return (SpeedTestResult[]) f59023a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SpeedTestResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
