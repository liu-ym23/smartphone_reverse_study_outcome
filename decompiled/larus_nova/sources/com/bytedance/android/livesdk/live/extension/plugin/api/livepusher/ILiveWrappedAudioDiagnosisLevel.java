package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedAudioDiagnosisLevel;", "", "", "value", "I", "AudioDiagnosisLevelNormal", "AudioDiagnosisLevelLow", "AudioDiagnosisLevelHigh", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ILiveWrappedAudioDiagnosisLevel extends Enum<ILiveWrappedAudioDiagnosisLevel> {
    public static final ILiveWrappedAudioDiagnosisLevel AudioDiagnosisLevelHigh = null;
    public static final ILiveWrappedAudioDiagnosisLevel AudioDiagnosisLevelLow = null;
    public static final ILiveWrappedAudioDiagnosisLevel AudioDiagnosisLevelNormal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILiveWrappedAudioDiagnosisLevel[] f147287a = null;
    private final int value;

    static {
        ILiveWrappedAudioDiagnosisLevel r100 = new ILiveWrappedAudioDiagnosisLevel("AudioDiagnosisLevelNormal", 0, 0);
        AudioDiagnosisLevelNormal = r100;
        ILiveWrappedAudioDiagnosisLevel r101 = new ILiveWrappedAudioDiagnosisLevel("AudioDiagnosisLevelLow", 1, -1);
        AudioDiagnosisLevelLow = r101;
        ILiveWrappedAudioDiagnosisLevel r102 = new ILiveWrappedAudioDiagnosisLevel("AudioDiagnosisLevelHigh", 2, -2);
        AudioDiagnosisLevelHigh = r102;
        f147287a = new ILiveWrappedAudioDiagnosisLevel[]{r100, r101, r102};
    }

    public static ILiveWrappedAudioDiagnosisLevel valueOf(String r100) {
        return (ILiveWrappedAudioDiagnosisLevel) a.a(ILiveWrappedAudioDiagnosisLevel.class, r100);
    }

    public static ILiveWrappedAudioDiagnosisLevel[] values() {
        return (ILiveWrappedAudioDiagnosisLevel[]) f147287a.clone();
    }

    public final int value() {
        return this.value;
    }

    public ILiveWrappedAudioDiagnosisLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
