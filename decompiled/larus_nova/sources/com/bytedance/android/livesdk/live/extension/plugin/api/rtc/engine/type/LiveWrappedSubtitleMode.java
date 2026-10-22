package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSubtitleMode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SUBTITLE_MODE_RECOGINTE", "SUBTITLE_MODE_TRANSLATION", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSubtitleMode extends Enum<LiveWrappedSubtitleMode> {
    public static final a Companion = null;
    public static final LiveWrappedSubtitleMode SUBTITLE_MODE_RECOGINTE = null;
    public static final LiveWrappedSubtitleMode SUBTITLE_MODE_TRANSLATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSubtitleMode[] f147451a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubtitleMode$a] */
    static {
        LiveWrappedSubtitleMode r100 = new LiveWrappedSubtitleMode("SUBTITLE_MODE_RECOGINTE", 0, 0);
        SUBTITLE_MODE_RECOGINTE = r100;
        LiveWrappedSubtitleMode r101 = new LiveWrappedSubtitleMode("SUBTITLE_MODE_TRANSLATION", 1, 1);
        SUBTITLE_MODE_TRANSLATION = r101;
        f147451a = new LiveWrappedSubtitleMode[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedSubtitleMode valueOf(String r100) {
        return (LiveWrappedSubtitleMode) r27.a.a(LiveWrappedSubtitleMode.class, r100);
    }

    public static LiveWrappedSubtitleMode[] values() {
        return (LiveWrappedSubtitleMode[]) f147451a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSubtitleMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
