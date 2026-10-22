package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory", "", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory;", "", "value", "I", "getValue", "()I", "VIDEO_CONTENT_CATEGORY_CAMERA", "VIDEO_CONTENT_CATEGRORY_SCREEN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory extends Enum<LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory> {
    public static final LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory VIDEO_CONTENT_CATEGORY_CAMERA = null;
    public static final LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory VIDEO_CONTENT_CATEGRORY_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory[] f147303a = null;
    private final int value;

    static {
        LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory r100 = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory("VIDEO_CONTENT_CATEGORY_CAMERA", 0, 0);
        VIDEO_CONTENT_CATEGORY_CAMERA = r100;
        LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory r101 = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory("VIDEO_CONTENT_CATEGRORY_SCREEN", 1, 1);
        VIDEO_CONTENT_CATEGRORY_SCREEN = r101;
        f147303a = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory[]{r100, r101};
    }

    public static LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory valueOf(String r100) {
        return (LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory) a.a(LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory.class, r100);
    }

    public static LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory[] values() {
        return (LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory[]) f147303a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoContentCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
