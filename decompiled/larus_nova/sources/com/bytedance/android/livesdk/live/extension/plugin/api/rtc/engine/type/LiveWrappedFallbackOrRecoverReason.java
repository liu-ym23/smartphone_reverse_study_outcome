package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedFallbackOrRecoverReason;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FALLBACK_OR_RECOVER_REASON_UNKNOWN", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE", "FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE", "FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedFallbackOrRecoverReason extends Enum<LiveWrappedFallbackOrRecoverReason> {
    public static final a Companion = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedFallbackOrRecoverReason[] f147419a = null;
    private int value;

    public static LiveWrappedFallbackOrRecoverReason valueOf(String r100) {
        return (LiveWrappedFallbackOrRecoverReason) r27.a.a(LiveWrappedFallbackOrRecoverReason.class, r100);
    }

    public static LiveWrappedFallbackOrRecoverReason[] values() {
        return (LiveWrappedFallbackOrRecoverReason[]) f147419a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedFallbackOrRecoverReason$a] */
    static {
        LiveWrappedFallbackOrRecoverReason r100 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_UNKNOWN", 0, -1);
        FALLBACK_OR_RECOVER_REASON_UNKNOWN = r100;
        LiveWrappedFallbackOrRecoverReason r101 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH", 1, 0);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH = r101;
        LiveWrappedFallbackOrRecoverReason r102 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE", 2, 1);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE = r102;
        LiveWrappedFallbackOrRecoverReason r103 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH", 3, 2);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH = r103;
        LiveWrappedFallbackOrRecoverReason r104 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE", 4, 3);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE = r104;
        LiveWrappedFallbackOrRecoverReason r105 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH", 5, 4);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH = r105;
        LiveWrappedFallbackOrRecoverReason r106 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE", 6, 5);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE = r106;
        LiveWrappedFallbackOrRecoverReason r107 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH", 7, 6);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH = r107;
        LiveWrappedFallbackOrRecoverReason r108 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE", 8, 7);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE = r108;
        f147419a = new LiveWrappedFallbackOrRecoverReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public LiveWrappedFallbackOrRecoverReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
