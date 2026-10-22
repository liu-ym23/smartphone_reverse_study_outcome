package com.bytedance.android.livesdkapi.player;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/LivePlayerStreamTypeUtils;", "", "()V", "mapLiveModeToStreamType", "Lcom/bytedance/android/livesdkapi/model/LiveStreamType;", "mode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerStreamTypeUtils {
    public static final LivePlayerStreamTypeUtils INSTANCE = null;

    private LivePlayerStreamTypeUtils() {
    }

    static {
        INSTANCE = new LivePlayerStreamTypeUtils();
    }

    public final LiveStreamType mapLiveModeToStreamType(LiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (r100 != LiveMode.AUDIO) goto L7;
        return LiveStreamType.AUDIO;
    L7:
        return LiveStreamType.VIDEO;
    }
}
