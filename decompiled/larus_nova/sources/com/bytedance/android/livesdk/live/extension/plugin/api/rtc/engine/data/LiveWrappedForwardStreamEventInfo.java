package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveWrappedForwardStreamEventInfo {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedForwardStreamEventInfo$LiveWrappedForwardStreamEvent;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FORWARD_STREAM_EVENT_DISCONNECTED", "FORWARD_STREAM_EVENT_CONNECTED", "FORWARD_STREAM_EVENT_INTERRUPT", "FORWARD_STREAM_EVENT_DST_ROOM_UPDATED", "FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedForwardStreamEvent extends Enum<LiveWrappedForwardStreamEvent> {
        public static final a Companion = null;
        public static final LiveWrappedForwardStreamEvent FORWARD_STREAM_EVENT_CONNECTED = null;
        public static final LiveWrappedForwardStreamEvent FORWARD_STREAM_EVENT_DISCONNECTED = null;
        public static final LiveWrappedForwardStreamEvent FORWARD_STREAM_EVENT_DST_ROOM_UPDATED = null;
        public static final LiveWrappedForwardStreamEvent FORWARD_STREAM_EVENT_INTERRUPT = null;
        public static final LiveWrappedForwardStreamEvent FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedForwardStreamEvent[] f147335a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedForwardStreamEvent r100 = new LiveWrappedForwardStreamEvent("FORWARD_STREAM_EVENT_DISCONNECTED", 0, 0);
            FORWARD_STREAM_EVENT_DISCONNECTED = r100;
            LiveWrappedForwardStreamEvent r101 = new LiveWrappedForwardStreamEvent("FORWARD_STREAM_EVENT_CONNECTED", 1, 1);
            FORWARD_STREAM_EVENT_CONNECTED = r101;
            LiveWrappedForwardStreamEvent r102 = new LiveWrappedForwardStreamEvent("FORWARD_STREAM_EVENT_INTERRUPT", 2, 2);
            FORWARD_STREAM_EVENT_INTERRUPT = r102;
            LiveWrappedForwardStreamEvent r103 = new LiveWrappedForwardStreamEvent("FORWARD_STREAM_EVENT_DST_ROOM_UPDATED", 3, 3);
            FORWARD_STREAM_EVENT_DST_ROOM_UPDATED = r103;
            LiveWrappedForwardStreamEvent r104 = new LiveWrappedForwardStreamEvent("FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL", 4, 4);
            FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL = r104;
            f147335a = new LiveWrappedForwardStreamEvent[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        public static LiveWrappedForwardStreamEvent valueOf(String r100) {
            return (LiveWrappedForwardStreamEvent) r27.a.a(LiveWrappedForwardStreamEvent.class, r100);
        }

        public static LiveWrappedForwardStreamEvent[] values() {
            return (LiveWrappedForwardStreamEvent[]) f147335a.clone();
        }

        public final int value() {
            return this.value;
        }

        public LiveWrappedForwardStreamEvent(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }
}
