package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioAlignmentMode;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_ALIGNMENT_MODE_OFF", "AUDIO_ALIGNMENT_MODE_AUDIOMIXING", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioAlignmentMode extends Enum<LiveWrappedAudioAlignmentMode> {
    public static final LiveWrappedAudioAlignmentMode AUDIO_ALIGNMENT_MODE_AUDIOMIXING = null;
    public static final LiveWrappedAudioAlignmentMode AUDIO_ALIGNMENT_MODE_OFF = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioAlignmentMode[] f147319a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode$a] */
    static {
        LiveWrappedAudioAlignmentMode r100 = new LiveWrappedAudioAlignmentMode("AUDIO_ALIGNMENT_MODE_OFF", 0, 0);
        AUDIO_ALIGNMENT_MODE_OFF = r100;
        LiveWrappedAudioAlignmentMode r101 = new LiveWrappedAudioAlignmentMode("AUDIO_ALIGNMENT_MODE_AUDIOMIXING", 1, 1);
        AUDIO_ALIGNMENT_MODE_AUDIOMIXING = r101;
        f147319a = new LiveWrappedAudioAlignmentMode[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedAudioAlignmentMode valueOf(String r100) {
        return (LiveWrappedAudioAlignmentMode) r27.a.a(LiveWrappedAudioAlignmentMode.class, r100);
    }

    public static LiveWrappedAudioAlignmentMode[] values() {
        return (LiveWrappedAudioAlignmentMode[]) f147319a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = b.f571693a[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioAlignmentModeOff";
    L5:
        if (r100 != 2) goto L10;
        return "kAudioAlignmentModeAudioMixing";
    L10:
        return "kAudioAlignmentModeOff";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioAlignmentMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
