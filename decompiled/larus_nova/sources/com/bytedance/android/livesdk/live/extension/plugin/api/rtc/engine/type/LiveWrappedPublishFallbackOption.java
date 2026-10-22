package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedPublishFallbackOption;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DISABLE", "SIMULCAST_SMALL_VIDEO_ONLY", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPublishFallbackOption extends Enum<LiveWrappedPublishFallbackOption> {
    public static final a Companion = null;
    public static final LiveWrappedPublishFallbackOption DISABLE = null;
    public static final LiveWrappedPublishFallbackOption SIMULCAST_SMALL_VIDEO_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedPublishFallbackOption[] f147435a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedPublishFallbackOption$a] */
    static {
        LiveWrappedPublishFallbackOption r100 = new LiveWrappedPublishFallbackOption("DISABLE", 0, 0);
        DISABLE = r100;
        LiveWrappedPublishFallbackOption r101 = new LiveWrappedPublishFallbackOption("SIMULCAST_SMALL_VIDEO_ONLY", 1, 1);
        SIMULCAST_SMALL_VIDEO_ONLY = r101;
        f147435a = new LiveWrappedPublishFallbackOption[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedPublishFallbackOption valueOf(String r100) {
        return (LiveWrappedPublishFallbackOption) r27.a.a(LiveWrappedPublishFallbackOption.class, r100);
    }

    public static LiveWrappedPublishFallbackOption[] values() {
        return (LiveWrappedPublishFallbackOption[]) f147435a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPublishFallbackOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
