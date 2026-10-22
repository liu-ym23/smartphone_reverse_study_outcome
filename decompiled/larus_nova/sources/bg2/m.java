package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamTaskEvent;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18919a = null;

    static {
        int[] r100 = new int[LiveWrappedMixedStreamTaskEvent.values().length];
        f18919a = r100;
        r100[LiveWrappedMixedStreamTaskEvent.BASE.ordinal()] = 1;
        r100[LiveWrappedMixedStreamTaskEvent.START_SUCCESS.ordinal()] = 2;
        r100[LiveWrappedMixedStreamTaskEvent.START_FAILED.ordinal()] = 3;
        r100[LiveWrappedMixedStreamTaskEvent.UPDATE_SUCCESS.ordinal()] = 4;
        r100[LiveWrappedMixedStreamTaskEvent.UPDATE_FAILED.ordinal()] = 5;
        r100[LiveWrappedMixedStreamTaskEvent.STOP_SUCCESS.ordinal()] = 6;
        r100[LiveWrappedMixedStreamTaskEvent.STOP_FAILED.ordinal()] = 7;
        r100[LiveWrappedMixedStreamTaskEvent.WARNING.ordinal()] = 8;
    }
}
