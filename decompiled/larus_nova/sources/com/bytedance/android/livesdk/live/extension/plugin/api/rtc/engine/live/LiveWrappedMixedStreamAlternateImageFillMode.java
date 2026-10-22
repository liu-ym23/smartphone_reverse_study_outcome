package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamAlternateImageFillMode;", "", "", "<set-?>", "value", "I", "getValue", "()I", "FIT", "FILL", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamAlternateImageFillMode extends Enum<LiveWrappedMixedStreamAlternateImageFillMode> {
    public static final LiveWrappedMixedStreamAlternateImageFillMode FILL = null;
    public static final LiveWrappedMixedStreamAlternateImageFillMode FIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamAlternateImageFillMode[] f147389a = null;
    private int value;

    static {
        LiveWrappedMixedStreamAlternateImageFillMode r100 = new LiveWrappedMixedStreamAlternateImageFillMode("FIT", 0, 0);
        FIT = r100;
        LiveWrappedMixedStreamAlternateImageFillMode r101 = new LiveWrappedMixedStreamAlternateImageFillMode("FILL", 1, 1);
        FILL = r101;
        f147389a = new LiveWrappedMixedStreamAlternateImageFillMode[]{r100, r101};
    }

    public static LiveWrappedMixedStreamAlternateImageFillMode valueOf(String r100) {
        return (LiveWrappedMixedStreamAlternateImageFillMode) a.a(LiveWrappedMixedStreamAlternateImageFillMode.class, r100);
    }

    public static LiveWrappedMixedStreamAlternateImageFillMode[] values() {
        return (LiveWrappedMixedStreamAlternateImageFillMode[]) f147389a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamAlternateImageFillMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
