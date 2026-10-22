package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import dg2.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioVADType;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NO_SPEECH", "SPEECH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioVADType extends Enum<LiveWrappedAudioVADType> {
    public static final a Companion = null;
    public static final LiveWrappedAudioVADType NO_SPEECH = null;
    public static final LiveWrappedAudioVADType SPEECH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioVADType[] f147418a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioVADType$a] */
    static {
        LiveWrappedAudioVADType r100 = new LiveWrappedAudioVADType("NO_SPEECH", 0, 0);
        NO_SPEECH = r100;
        LiveWrappedAudioVADType r101 = new LiveWrappedAudioVADType("SPEECH", 1, 1);
        SPEECH = r101;
        f147418a = new LiveWrappedAudioVADType[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedAudioVADType valueOf(String r100) {
        return (LiveWrappedAudioVADType) r27.a.a(LiveWrappedAudioVADType.class, r100);
    }

    public static LiveWrappedAudioVADType[] values() {
        return (LiveWrappedAudioVADType[]) f147418a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = b.f468372a[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioVADTypeNoSpeech";
    L5:
        if (r100 == 2) goto L8;
        return "valid";
    L8:
        return "kAudioVADTypeSpeech";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioVADType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
