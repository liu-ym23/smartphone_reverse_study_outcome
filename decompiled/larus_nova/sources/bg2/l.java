package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamTaskErrorCode;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18918a = null;

    static {
        int[] r100 = new int[LiveWrappedMixedStreamTaskErrorCode.values().length];
        f18918a = r100;
        r100[LiveWrappedMixedStreamTaskErrorCode.OK.ordinal()] = 1;
        r100[LiveWrappedMixedStreamTaskErrorCode.BASE.ordinal()] = 2;
        r100[LiveWrappedMixedStreamTaskErrorCode.TIMEOUT.ordinal()] = 3;
        r100[LiveWrappedMixedStreamTaskErrorCode.INVALID_PARAM_BY_SERVER.ordinal()] = 4;
        r100[LiveWrappedMixedStreamTaskErrorCode.SUB_TIMEOUT_BY_SERVER.ordinal()] = 5;
        r100[LiveWrappedMixedStreamTaskErrorCode.INVALID_STATE_BY_SERVER.ordinal()] = 6;
        r100[LiveWrappedMixedStreamTaskErrorCode.AUTHENTICATION_BY_CDN.ordinal()] = 7;
        r100[LiveWrappedMixedStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 8;
        r100[LiveWrappedMixedStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 9;
        r100[LiveWrappedMixedStreamTaskErrorCode.MIX_IMAGE_FAIL.ordinal()] = 10;
        r100[LiveWrappedMixedStreamTaskErrorCode.STREAM_SYNC_WORSE.ordinal()] = 11;
        r100[LiveWrappedMixedStreamTaskErrorCode.PUSH_WTN_FAILED.ordinal()] = 12;
        r100[LiveWrappedMixedStreamTaskErrorCode.MAX.ordinal()] = 13;
    }
}
