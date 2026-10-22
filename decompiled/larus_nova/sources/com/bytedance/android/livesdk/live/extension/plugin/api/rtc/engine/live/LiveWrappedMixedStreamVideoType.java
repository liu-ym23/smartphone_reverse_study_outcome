package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamVideoType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "MIXED_STREAM_VIDEO_TYPE_MAIN", "MIXED_STREAM_VIDEO_TYPE_SCREEN", "MIXED_STREAM_VIDEO_TYPE_3RD", "MIXED_STREAM_VIDEO_TYPE_4TH", "MIXED_STREAM_VIDEO_TYPE_5TH", "MIXED_STREAM_VIDEO_TYPE_6TH", "MIXED_STREAM_VIDEO_TYPE_7TH", "MIXED_STREAM_VIDEO_TYPE_8TH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamVideoType extends Enum<LiveWrappedMixedStreamVideoType> {
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_3RD = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_4TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_5TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_6TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_7TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_8TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_MAIN = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamVideoType[] f147405a = null;
    private int value;

    public static LiveWrappedMixedStreamVideoType valueOf(String r100) {
        return (LiveWrappedMixedStreamVideoType) a.a(LiveWrappedMixedStreamVideoType.class, r100);
    }

    public static LiveWrappedMixedStreamVideoType[] values() {
        return (LiveWrappedMixedStreamVideoType[]) f147405a.clone();
    }

    static {
        LiveWrappedMixedStreamVideoType r100 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_MAIN", 0, 0);
        MIXED_STREAM_VIDEO_TYPE_MAIN = r100;
        LiveWrappedMixedStreamVideoType r101 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_SCREEN", 1, 1);
        MIXED_STREAM_VIDEO_TYPE_SCREEN = r101;
        LiveWrappedMixedStreamVideoType r102 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_3RD", 2, 2);
        MIXED_STREAM_VIDEO_TYPE_3RD = r102;
        LiveWrappedMixedStreamVideoType r103 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_4TH", 3, 3);
        MIXED_STREAM_VIDEO_TYPE_4TH = r103;
        LiveWrappedMixedStreamVideoType r104 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_5TH", 4, 4);
        MIXED_STREAM_VIDEO_TYPE_5TH = r104;
        LiveWrappedMixedStreamVideoType r105 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_6TH", 5, 5);
        MIXED_STREAM_VIDEO_TYPE_6TH = r105;
        LiveWrappedMixedStreamVideoType r106 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_7TH", 6, 6);
        MIXED_STREAM_VIDEO_TYPE_7TH = r106;
        LiveWrappedMixedStreamVideoType r107 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_8TH", 7, 7);
        MIXED_STREAM_VIDEO_TYPE_8TH = r107;
        f147405a = new LiveWrappedMixedStreamVideoType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public LiveWrappedMixedStreamVideoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
