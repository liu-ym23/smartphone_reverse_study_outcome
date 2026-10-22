package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamPushTargetType;", "", "", "value", "targetType", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PUSH_TO_CDN", "PUSH_TO_WTN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamPushTargetType extends Enum<LiveWrappedMixedStreamPushTargetType> {
    public static final a Companion = null;
    public static final LiveWrappedMixedStreamPushTargetType PUSH_TO_CDN = null;
    public static final LiveWrappedMixedStreamPushTargetType PUSH_TO_WTN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamPushTargetType[] f147397a = null;
    private final int targetType;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushTargetType$a] */
    static {
        LiveWrappedMixedStreamPushTargetType r100 = new LiveWrappedMixedStreamPushTargetType("PUSH_TO_CDN", 0, 0);
        PUSH_TO_CDN = r100;
        LiveWrappedMixedStreamPushTargetType r101 = new LiveWrappedMixedStreamPushTargetType("PUSH_TO_WTN", 1, 1);
        PUSH_TO_WTN = r101;
        f147397a = new LiveWrappedMixedStreamPushTargetType[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedMixedStreamPushTargetType valueOf(String r100) {
        return (LiveWrappedMixedStreamPushTargetType) r27.a.a(LiveWrappedMixedStreamPushTargetType.class, r100);
    }

    public static LiveWrappedMixedStreamPushTargetType[] values() {
        return (LiveWrappedMixedStreamPushTargetType[]) f147397a.clone();
    }

    public final int value() {
        return this.targetType;
    }

    public LiveWrappedMixedStreamPushTargetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.targetType = r102;
    }
}
