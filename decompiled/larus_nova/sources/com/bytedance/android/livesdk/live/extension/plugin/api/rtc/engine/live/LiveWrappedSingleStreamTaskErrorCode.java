package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import bg2.s;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedSingleStreamTaskErrorCode;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OK", "BASE", "UNKNOWN_BY_SERVER", "SIGNAL_REQUEST_TIMEOUT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSingleStreamTaskErrorCode extends Enum<LiveWrappedSingleStreamTaskErrorCode> {
    public static final LiveWrappedSingleStreamTaskErrorCode BASE = null;
    public static final a Companion = null;
    public static final LiveWrappedSingleStreamTaskErrorCode OK = null;
    public static final LiveWrappedSingleStreamTaskErrorCode SIGNAL_REQUEST_TIMEOUT = null;
    public static final LiveWrappedSingleStreamTaskErrorCode UNKNOWN_BY_SERVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSingleStreamTaskErrorCode[] f147406a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskErrorCode$a] */
    static {
        LiveWrappedSingleStreamTaskErrorCode r100 = new LiveWrappedSingleStreamTaskErrorCode("OK", 0, 0);
        OK = r100;
        LiveWrappedSingleStreamTaskErrorCode r101 = new LiveWrappedSingleStreamTaskErrorCode("BASE", 1, 1090);
        BASE = r101;
        LiveWrappedSingleStreamTaskErrorCode r102 = new LiveWrappedSingleStreamTaskErrorCode("UNKNOWN_BY_SERVER", 2, 1091);
        UNKNOWN_BY_SERVER = r102;
        LiveWrappedSingleStreamTaskErrorCode r103 = new LiveWrappedSingleStreamTaskErrorCode("SIGNAL_REQUEST_TIMEOUT", 3, 1092);
        SIGNAL_REQUEST_TIMEOUT = r103;
        f147406a = new LiveWrappedSingleStreamTaskErrorCode[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedSingleStreamTaskErrorCode valueOf(String r100) {
        return (LiveWrappedSingleStreamTaskErrorCode) r27.a.a(LiveWrappedSingleStreamTaskErrorCode.class, r100);
    }

    public static LiveWrappedSingleStreamTaskErrorCode[] values() {
        return (LiveWrappedSingleStreamTaskErrorCode[]) f147406a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = s.f18936a[ordinal()];
        if (r100 != 1) goto L5;
        return "OK";
    L5:
        if (r100 != 2) goto L7;
        return "BASE";
    L7:
        if (r100 != 3) goto L9;
        return "UNKNOWN_BY_SERVER";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "SIGNAL_REQUEST_TIMEOUT";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSingleStreamTaskErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
