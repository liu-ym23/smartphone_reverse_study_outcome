package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedSEICountPerFrame;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SEI_COUNT_PER_FRAME_SINGLE", "SEI_COUNT_PER_FRAME_MULTI", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSEICountPerFrame extends Enum<LiveWrappedSEICountPerFrame> {
    public static final a Companion = null;
    public static final LiveWrappedSEICountPerFrame SEI_COUNT_PER_FRAME_MULTI = null;
    public static final LiveWrappedSEICountPerFrame SEI_COUNT_PER_FRAME_SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSEICountPerFrame[] f147353a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSEICountPerFrame$a] */
    static {
        LiveWrappedSEICountPerFrame r100 = new LiveWrappedSEICountPerFrame("SEI_COUNT_PER_FRAME_SINGLE", 0, 0);
        SEI_COUNT_PER_FRAME_SINGLE = r100;
        LiveWrappedSEICountPerFrame r101 = new LiveWrappedSEICountPerFrame("SEI_COUNT_PER_FRAME_MULTI", 1, 1);
        SEI_COUNT_PER_FRAME_MULTI = r101;
        f147353a = new LiveWrappedSEICountPerFrame[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedSEICountPerFrame valueOf(String r100) {
        return (LiveWrappedSEICountPerFrame) r27.a.a(LiveWrappedSEICountPerFrame.class, r100);
    }

    public static LiveWrappedSEICountPerFrame[] values() {
        return (LiveWrappedSEICountPerFrame[]) f147353a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSEICountPerFrame(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
