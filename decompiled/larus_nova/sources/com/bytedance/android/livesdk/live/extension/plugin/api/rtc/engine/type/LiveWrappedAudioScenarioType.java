package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioScenarioType;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DEFAULT", "CHATROOM", "GAMESTREAMING", "CHORUS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioScenarioType extends Enum<LiveWrappedAudioScenarioType> {
    public static final LiveWrappedAudioScenarioType CHATROOM = null;
    public static final LiveWrappedAudioScenarioType CHORUS = null;
    public static final a Companion = null;
    public static final LiveWrappedAudioScenarioType DEFAULT = null;
    public static final LiveWrappedAudioScenarioType GAMESTREAMING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioScenarioType[] f147416a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioScenarioType$a] */
    static {
        LiveWrappedAudioScenarioType r100 = new LiveWrappedAudioScenarioType("DEFAULT", 0, 0);
        DEFAULT = r100;
        LiveWrappedAudioScenarioType r101 = new LiveWrappedAudioScenarioType("CHATROOM", 1, 1);
        CHATROOM = r101;
        LiveWrappedAudioScenarioType r102 = new LiveWrappedAudioScenarioType("GAMESTREAMING", 2, 2);
        GAMESTREAMING = r102;
        LiveWrappedAudioScenarioType r103 = new LiveWrappedAudioScenarioType("CHORUS", 3, 3);
        CHORUS = r103;
        f147416a = new LiveWrappedAudioScenarioType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedAudioScenarioType valueOf(String r100) {
        return (LiveWrappedAudioScenarioType) r27.a.a(LiveWrappedAudioScenarioType.class, r100);
    }

    public static LiveWrappedAudioScenarioType[] values() {
        return (LiveWrappedAudioScenarioType[]) f147416a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioScenarioType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
