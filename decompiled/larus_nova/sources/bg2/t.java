package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskEvent;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18937a = null;

    static {
        int[] r100 = new int[LiveWrappedSingleStreamTaskEvent.values().length];
        f18937a = r100;
        r100[LiveWrappedSingleStreamTaskEvent.BASE.ordinal()] = 1;
        r100[LiveWrappedSingleStreamTaskEvent.START_SUCCESS.ordinal()] = 2;
        r100[LiveWrappedSingleStreamTaskEvent.START_FAILED.ordinal()] = 3;
        r100[LiveWrappedSingleStreamTaskEvent.STOP_SUCCESS.ordinal()] = 4;
        r100[LiveWrappedSingleStreamTaskEvent.STOP_FAILED.ordinal()] = 5;
        r100[LiveWrappedSingleStreamTaskEvent.WARNING.ordinal()] = 6;
    }
}
