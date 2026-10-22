package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskErrorCode;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18936a = null;

    static {
        int[] r100 = new int[LiveWrappedSingleStreamTaskErrorCode.values().length];
        f18936a = r100;
        r100[LiveWrappedSingleStreamTaskErrorCode.OK.ordinal()] = 1;
        r100[LiveWrappedSingleStreamTaskErrorCode.BASE.ordinal()] = 2;
        r100[LiveWrappedSingleStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 3;
        r100[LiveWrappedSingleStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 4;
    }
}
