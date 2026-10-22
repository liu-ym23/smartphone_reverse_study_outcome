package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAnsMode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ANS_MODE_DISABLE", "ANS_MODE_LOW", "ANS_MODE_MEDIUM", "ANS_MODE_HIGH", "ANS_MODE_AUTOMATIC", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAnsMode extends Enum<LiveWrappedAnsMode> {
    public static final LiveWrappedAnsMode ANS_MODE_AUTOMATIC = null;
    public static final LiveWrappedAnsMode ANS_MODE_DISABLE = null;
    public static final LiveWrappedAnsMode ANS_MODE_HIGH = null;
    public static final LiveWrappedAnsMode ANS_MODE_LOW = null;
    public static final LiveWrappedAnsMode ANS_MODE_MEDIUM = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAnsMode[] f147409a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAnsMode$a] */
    static {
        LiveWrappedAnsMode r100 = new LiveWrappedAnsMode("ANS_MODE_DISABLE", 0, 0);
        ANS_MODE_DISABLE = r100;
        LiveWrappedAnsMode r101 = new LiveWrappedAnsMode("ANS_MODE_LOW", 1, 1);
        ANS_MODE_LOW = r101;
        LiveWrappedAnsMode r102 = new LiveWrappedAnsMode("ANS_MODE_MEDIUM", 2, 2);
        ANS_MODE_MEDIUM = r102;
        LiveWrappedAnsMode r103 = new LiveWrappedAnsMode("ANS_MODE_HIGH", 3, 3);
        ANS_MODE_HIGH = r103;
        LiveWrappedAnsMode r104 = new LiveWrappedAnsMode("ANS_MODE_AUTOMATIC", 4, 4);
        ANS_MODE_AUTOMATIC = r104;
        f147409a = new LiveWrappedAnsMode[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static LiveWrappedAnsMode valueOf(String r100) {
        return (LiveWrappedAnsMode) r27.a.a(LiveWrappedAnsMode.class, r100);
    }

    public static LiveWrappedAnsMode[] values() {
        return (LiveWrappedAnsMode[]) f147409a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAnsMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
