package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.a0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedPlayerError;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OK", "FORMAT_NOT_SUPPORT", "INVALID_PATH", "INVALID_STATE", "INVALID_POSITION", "INVALID_VOLUME", "INVALID_PITCH", "INVALID_AUDIO_TRACK_INDEX", "INVALID_PLAYBACK_SPEED", "INVALID_EFFECT_ID", "ERROR_CURRENTLY_PLAYING", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPlayerError extends Enum<LiveWrappedPlayerError> {
    public static final a Companion = null;
    public static final LiveWrappedPlayerError ERROR_CURRENTLY_PLAYING = null;
    public static final LiveWrappedPlayerError FORMAT_NOT_SUPPORT = null;
    public static final LiveWrappedPlayerError INVALID_AUDIO_TRACK_INDEX = null;
    public static final LiveWrappedPlayerError INVALID_EFFECT_ID = null;
    public static final LiveWrappedPlayerError INVALID_PATH = null;
    public static final LiveWrappedPlayerError INVALID_PITCH = null;
    public static final LiveWrappedPlayerError INVALID_PLAYBACK_SPEED = null;
    public static final LiveWrappedPlayerError INVALID_POSITION = null;
    public static final LiveWrappedPlayerError INVALID_STATE = null;
    public static final LiveWrappedPlayerError INVALID_VOLUME = null;
    public static final LiveWrappedPlayerError OK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedPlayerError[] f147345a = null;
    private int value;

    public static LiveWrappedPlayerError valueOf(String r100) {
        return (LiveWrappedPlayerError) r27.a.a(LiveWrappedPlayerError.class, r100);
    }

    public static LiveWrappedPlayerError[] values() {
        return (LiveWrappedPlayerError[]) f147345a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerError$a] */
    static {
        LiveWrappedPlayerError r100 = new LiveWrappedPlayerError("OK", 0, 0);
        OK = r100;
        LiveWrappedPlayerError r101 = new LiveWrappedPlayerError("FORMAT_NOT_SUPPORT", 1, 1);
        FORMAT_NOT_SUPPORT = r101;
        LiveWrappedPlayerError r102 = new LiveWrappedPlayerError("INVALID_PATH", 2, 2);
        INVALID_PATH = r102;
        LiveWrappedPlayerError r103 = new LiveWrappedPlayerError("INVALID_STATE", 3, 3);
        INVALID_STATE = r103;
        LiveWrappedPlayerError r104 = new LiveWrappedPlayerError("INVALID_POSITION", 4, 4);
        INVALID_POSITION = r104;
        LiveWrappedPlayerError r105 = new LiveWrappedPlayerError("INVALID_VOLUME", 5, 5);
        INVALID_VOLUME = r105;
        LiveWrappedPlayerError r106 = new LiveWrappedPlayerError("INVALID_PITCH", 6, 6);
        INVALID_PITCH = r106;
        LiveWrappedPlayerError r107 = new LiveWrappedPlayerError("INVALID_AUDIO_TRACK_INDEX", 7, 7);
        INVALID_AUDIO_TRACK_INDEX = r107;
        LiveWrappedPlayerError r108 = new LiveWrappedPlayerError("INVALID_PLAYBACK_SPEED", 8, 8);
        INVALID_PLAYBACK_SPEED = r108;
        LiveWrappedPlayerError r109 = new LiveWrappedPlayerError("INVALID_EFFECT_ID", 9, 9);
        INVALID_EFFECT_ID = r109;
        LiveWrappedPlayerError r110 = new LiveWrappedPlayerError("ERROR_CURRENTLY_PLAYING", 10, 10);
        ERROR_CURRENTLY_PLAYING = r110;
        f147345a = new LiveWrappedPlayerError[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(a0.f571691a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "ERROR_CURRENTLY_PLAYING";
    L6:
        return "INVALID_EFFECT_ID";
    L7:
        return "INVALID_PLAYBACK_SPEED";
    L8:
        return "INVALID_AUDIO_TRACK_INDEX";
    L9:
        return "INVALID_PITCH";
    L10:
        return "INVALID_VOLUME";
    L11:
        return "INVALID_POSITION";
    L12:
        return "INVALID_STATE";
    L13:
        return "INVALID_PATH";
    L14:
        return "FORMAT_NOT_SUPPORT";
    L15:
        return "OK";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPlayerError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
