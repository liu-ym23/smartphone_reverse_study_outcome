package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioAEDType;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NO_MUSIC", "MUSIC", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioAEDType extends Enum<LiveWrappedAudioAEDType> {
    public static final a Companion = null;
    public static final LiveWrappedAudioAEDType MUSIC = null;
    public static final LiveWrappedAudioAEDType NO_MUSIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioAEDType[] f147410a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioAEDType$a] */
    static {
        LiveWrappedAudioAEDType r100 = new LiveWrappedAudioAEDType("NO_MUSIC", 0, 0);
        NO_MUSIC = r100;
        LiveWrappedAudioAEDType r101 = new LiveWrappedAudioAEDType("MUSIC", 1, 1);
        MUSIC = r101;
        f147410a = new LiveWrappedAudioAEDType[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedAudioAEDType valueOf(String r100) {
        return (LiveWrappedAudioAEDType) r27.a.a(LiveWrappedAudioAEDType.class, r100);
    }

    public static LiveWrappedAudioAEDType[] values() {
        return (LiveWrappedAudioAEDType[]) f147410a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = dg2.a.f468371a[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioAEDTypeNoMusic";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kAudioAEDTypeMusic";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioAEDType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
