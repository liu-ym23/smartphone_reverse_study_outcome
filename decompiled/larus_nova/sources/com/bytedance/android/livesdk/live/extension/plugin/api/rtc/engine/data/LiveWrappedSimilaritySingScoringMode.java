package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedSimilaritySingScoringMode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SING_SCORING_MODE_SPECTRAL_SIMILARITY", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSimilaritySingScoringMode extends Enum<LiveWrappedSimilaritySingScoringMode> {
    public static final a Companion = null;
    public static final LiveWrappedSimilaritySingScoringMode SING_SCORING_MODE_SPECTRAL_SIMILARITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSimilaritySingScoringMode[] f147355a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimilaritySingScoringMode$a] */
    static {
        LiveWrappedSimilaritySingScoringMode r100 = new LiveWrappedSimilaritySingScoringMode();
        SING_SCORING_MODE_SPECTRAL_SIMILARITY = r100;
        f147355a = new LiveWrappedSimilaritySingScoringMode[]{r100};
        Companion = new a();
    }

    public static LiveWrappedSimilaritySingScoringMode valueOf(String r100) {
        return (LiveWrappedSimilaritySingScoringMode) r27.a.a(LiveWrappedSimilaritySingScoringMode.class, r100);
    }

    public static LiveWrappedSimilaritySingScoringMode[] values() {
        return (LiveWrappedSimilaritySingScoringMode[]) f147355a.clone();
    }

    public LiveWrappedSimilaritySingScoringMode() {
        super("SING_SCORING_MODE_SPECTRAL_SIMILARITY", 0);
        this.value = 0;
    }

    public final int value() {
        return this.value;
    }

    public static final /* synthetic */ int access$getValue$p(LiveWrappedSimilaritySingScoringMode r100) {
        return r100.value;
    }

    public static final /* synthetic */ void access$setValue$p(LiveWrappedSimilaritySingScoringMode r100, int r101) {
        r100.value = r101;
    }
}
