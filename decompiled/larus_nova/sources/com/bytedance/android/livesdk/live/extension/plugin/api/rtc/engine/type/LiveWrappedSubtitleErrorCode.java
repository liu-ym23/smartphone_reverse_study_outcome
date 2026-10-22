package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSubtitleErrorCode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SUBTITLE_ERROR_CODE_UNKNOW", "SUBTITLE_ERROR_CODE_SUCCESS", "SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR", "SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR", "SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR", "SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM", "SUBTITLE_ERROR_CODE_ALREADY_ON", "SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE", "SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSubtitleErrorCode extends Enum<LiveWrappedSubtitleErrorCode> {
    public static final a Companion = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_ALREADY_ON = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_SUCCESS = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_UNKNOW = null;
    public static final LiveWrappedSubtitleErrorCode SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSubtitleErrorCode[] f147450a = null;
    private final int value;

    public static LiveWrappedSubtitleErrorCode valueOf(String r100) {
        return (LiveWrappedSubtitleErrorCode) r27.a.a(LiveWrappedSubtitleErrorCode.class, r100);
    }

    public static LiveWrappedSubtitleErrorCode[] values() {
        return (LiveWrappedSubtitleErrorCode[]) f147450a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubtitleErrorCode$a] */
    static {
        LiveWrappedSubtitleErrorCode r100 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_UNKNOW", 0, -1);
        SUBTITLE_ERROR_CODE_UNKNOW = r100;
        LiveWrappedSubtitleErrorCode r101 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_SUCCESS", 1, 0);
        SUBTITLE_ERROR_CODE_SUCCESS = r101;
        LiveWrappedSubtitleErrorCode r102 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR", 2, 1);
        SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR = r102;
        LiveWrappedSubtitleErrorCode r103 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR", 3, 2);
        SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR = r103;
        LiveWrappedSubtitleErrorCode r104 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR", 4, 3);
        SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR = r104;
        LiveWrappedSubtitleErrorCode r105 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM", 5, 4);
        SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM = r105;
        LiveWrappedSubtitleErrorCode r106 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_ALREADY_ON", 6, 5);
        SUBTITLE_ERROR_CODE_ALREADY_ON = r106;
        LiveWrappedSubtitleErrorCode r107 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE", 7, 6);
        SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE = r107;
        LiveWrappedSubtitleErrorCode r108 = new LiveWrappedSubtitleErrorCode("SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT", 8, 7);
        SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT = r108;
        f147450a = new LiveWrappedSubtitleErrorCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSubtitleErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
