package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioSelectionPriority;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_SELECTION_PRIORITY_NORMAL", "AUDIO_SELECTION_PRIORITY_HIGIH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioSelectionPriority extends Enum<LiveWrappedAudioSelectionPriority> {
    public static final LiveWrappedAudioSelectionPriority AUDIO_SELECTION_PRIORITY_HIGIH = null;
    public static final LiveWrappedAudioSelectionPriority AUDIO_SELECTION_PRIORITY_NORMAL = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioSelectionPriority[] f147417a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioSelectionPriority$a] */
    static {
        LiveWrappedAudioSelectionPriority r100 = new LiveWrappedAudioSelectionPriority("AUDIO_SELECTION_PRIORITY_NORMAL", 0, 0);
        AUDIO_SELECTION_PRIORITY_NORMAL = r100;
        LiveWrappedAudioSelectionPriority r101 = new LiveWrappedAudioSelectionPriority("AUDIO_SELECTION_PRIORITY_HIGIH", 1, 1);
        AUDIO_SELECTION_PRIORITY_HIGIH = r101;
        f147417a = new LiveWrappedAudioSelectionPriority[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedAudioSelectionPriority valueOf(String r100) {
        return (LiveWrappedAudioSelectionPriority) r27.a.a(LiveWrappedAudioSelectionPriority.class, r100);
    }

    public static LiveWrappedAudioSelectionPriority[] values() {
        return (LiveWrappedAudioSelectionPriority[]) f147417a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioSelectionPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
