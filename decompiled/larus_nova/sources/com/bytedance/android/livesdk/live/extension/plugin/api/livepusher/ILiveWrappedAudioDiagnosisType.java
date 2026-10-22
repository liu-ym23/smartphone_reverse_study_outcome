package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedAudioDiagnosisType;", "", "", "value", "I", "AudioDiagnosisTypeLoop", "AudioDiagnosisTypeOneShot", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ILiveWrappedAudioDiagnosisType extends Enum<ILiveWrappedAudioDiagnosisType> {
    public static final ILiveWrappedAudioDiagnosisType AudioDiagnosisTypeLoop = null;
    public static final ILiveWrappedAudioDiagnosisType AudioDiagnosisTypeOneShot = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILiveWrappedAudioDiagnosisType[] f147289a = null;
    private final int value;

    static {
        ILiveWrappedAudioDiagnosisType r100 = new ILiveWrappedAudioDiagnosisType("AudioDiagnosisTypeLoop", 0, 0);
        AudioDiagnosisTypeLoop = r100;
        ILiveWrappedAudioDiagnosisType r101 = new ILiveWrappedAudioDiagnosisType("AudioDiagnosisTypeOneShot", 1, 1);
        AudioDiagnosisTypeOneShot = r101;
        f147289a = new ILiveWrappedAudioDiagnosisType[]{r100, r101};
    }

    public static ILiveWrappedAudioDiagnosisType valueOf(String r100) {
        return (ILiveWrappedAudioDiagnosisType) a.a(ILiveWrappedAudioDiagnosisType.class, r100);
    }

    public static ILiveWrappedAudioDiagnosisType[] values() {
        return (ILiveWrappedAudioDiagnosisType[]) f147289a.clone();
    }

    public ILiveWrappedAudioDiagnosisType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
