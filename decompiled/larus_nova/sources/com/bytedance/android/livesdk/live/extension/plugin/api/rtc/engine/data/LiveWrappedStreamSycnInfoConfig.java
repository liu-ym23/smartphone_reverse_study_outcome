package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveWrappedStreamSycnInfoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedStreamIndex f147359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f147360b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedStreamSycnInfoConfig$LiveWrappedSyncInfoStreamType;", "", "SYNC_INFO_STREAM_TYPE_AUDIO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedSyncInfoStreamType extends Enum<LiveWrappedSyncInfoStreamType> {
        public static final LiveWrappedSyncInfoStreamType SYNC_INFO_STREAM_TYPE_AUDIO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedSyncInfoStreamType[] f147361a = null;

        static {
            LiveWrappedSyncInfoStreamType r100 = new LiveWrappedSyncInfoStreamType();
            SYNC_INFO_STREAM_TYPE_AUDIO = r100;
            f147361a = new LiveWrappedSyncInfoStreamType[]{r100};
        }

        public static LiveWrappedSyncInfoStreamType valueOf(String r100) {
            return (LiveWrappedSyncInfoStreamType) a.a(LiveWrappedSyncInfoStreamType.class, r100);
        }

        public static LiveWrappedSyncInfoStreamType[] values() {
            return (LiveWrappedSyncInfoStreamType[]) f147361a.clone();
        }

        public LiveWrappedSyncInfoStreamType() {
            super("SYNC_INFO_STREAM_TYPE_AUDIO", 0);
        }
    }

    public final String toString() {
        return "StreamSycnInfoConfig{ streamIndex='" + this.f147359a.toString() + "'repeatCount='" + this.f147360b + "'streamType=Audio }";
    }

    public LiveWrappedStreamSycnInfoConfig(LiveWrappedStreamIndex r100, LiveWrappedSyncInfoStreamType r101) {
        Intrinsics.checkNotNullParameter(r100, "streamIndex");
        Intrinsics.checkNotNullParameter(r101, "streamType");
        this.f147359a = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        LiveWrappedSyncInfoStreamType r102 = LiveWrappedSyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO;
        this.f147359a = r100;
        this.f147360b = 0;
    }
}
