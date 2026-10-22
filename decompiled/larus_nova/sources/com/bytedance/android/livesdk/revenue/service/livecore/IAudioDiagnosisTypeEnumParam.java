package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IAudioDiagnosisTypeEnumParam;", "", "", "value", "I", "getValue", "()I", "AudioDiagnosisTypeLoop", "AudioDiagnosisTypeOneShot", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IAudioDiagnosisTypeEnumParam extends Enum<IAudioDiagnosisTypeEnumParam> {
    public static final IAudioDiagnosisTypeEnumParam AudioDiagnosisTypeLoop = null;
    public static final IAudioDiagnosisTypeEnumParam AudioDiagnosisTypeOneShot = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IAudioDiagnosisTypeEnumParam[] f157366a = null;
    private final int value;

    static {
        IAudioDiagnosisTypeEnumParam r100 = new IAudioDiagnosisTypeEnumParam("AudioDiagnosisTypeLoop", 0, 0);
        AudioDiagnosisTypeLoop = r100;
        IAudioDiagnosisTypeEnumParam r101 = new IAudioDiagnosisTypeEnumParam("AudioDiagnosisTypeOneShot", 1, 1);
        AudioDiagnosisTypeOneShot = r101;
        f157366a = new IAudioDiagnosisTypeEnumParam[]{r100, r101};
    }

    public static IAudioDiagnosisTypeEnumParam valueOf(String r100) {
        return (IAudioDiagnosisTypeEnumParam) a.a(IAudioDiagnosisTypeEnumParam.class, r100);
    }

    public static IAudioDiagnosisTypeEnumParam[] values() {
        return (IAudioDiagnosisTypeEnumParam[]) f157366a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public IAudioDiagnosisTypeEnumParam(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
