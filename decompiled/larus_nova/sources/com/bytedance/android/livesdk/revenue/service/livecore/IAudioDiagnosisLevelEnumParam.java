package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IAudioDiagnosisLevelEnumParam;", "", "", "value", "I", "getValue", "()I", "AudioDiagnosisLevelNormal", "AudioDiagnosisLevelLow", "AudioDiagnosisLevelHigh", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IAudioDiagnosisLevelEnumParam extends Enum<IAudioDiagnosisLevelEnumParam> {
    public static final IAudioDiagnosisLevelEnumParam AudioDiagnosisLevelHigh = null;
    public static final IAudioDiagnosisLevelEnumParam AudioDiagnosisLevelLow = null;
    public static final IAudioDiagnosisLevelEnumParam AudioDiagnosisLevelNormal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IAudioDiagnosisLevelEnumParam[] f157364a = null;
    private final int value;

    static {
        IAudioDiagnosisLevelEnumParam r100 = new IAudioDiagnosisLevelEnumParam("AudioDiagnosisLevelNormal", 0, 0);
        AudioDiagnosisLevelNormal = r100;
        IAudioDiagnosisLevelEnumParam r101 = new IAudioDiagnosisLevelEnumParam("AudioDiagnosisLevelLow", 1, -1);
        AudioDiagnosisLevelLow = r101;
        IAudioDiagnosisLevelEnumParam r102 = new IAudioDiagnosisLevelEnumParam("AudioDiagnosisLevelHigh", 2, -2);
        AudioDiagnosisLevelHigh = r102;
        f157364a = new IAudioDiagnosisLevelEnumParam[]{r100, r101, r102};
    }

    public static IAudioDiagnosisLevelEnumParam valueOf(String r100) {
        return (IAudioDiagnosisLevelEnumParam) a.a(IAudioDiagnosisLevelEnumParam.class, r100);
    }

    public static IAudioDiagnosisLevelEnumParam[] values() {
        return (IAudioDiagnosisLevelEnumParam[]) f157364a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public IAudioDiagnosisLevelEnumParam(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
