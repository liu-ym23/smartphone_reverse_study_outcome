package com.bytedance.android.livesdkapi.depend.model.live.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/utils/LiveModeUtils;", "", "()V", "valueOf", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "id", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveModeUtils {
    public static final LiveModeUtils INSTANCE = null;

    private LiveModeUtils() {
    }

    static {
        INSTANCE = new LiveModeUtils();
    }

    public final LiveMode valueOf(int r100) {
        return LiveMode.Companion.valueOf(r100);
    }
}
