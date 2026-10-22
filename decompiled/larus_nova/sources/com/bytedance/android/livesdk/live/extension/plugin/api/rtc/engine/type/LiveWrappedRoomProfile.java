package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRoomProfile;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "COMMUNICATION", "GAME", "CLOUD_GAME", "LOW_LATENCY", "CHAT_ROOM", "INTERACTIVE_PODCAST", "CHORUS", "GAME_STREAMING", "MEETING", "MEETING_ROOM", "CLASSROOM", "CALL", "LIVE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRoomProfile extends Enum<LiveWrappedRoomProfile> {
    public static final LiveWrappedRoomProfile CALL = null;
    public static final LiveWrappedRoomProfile CHAT_ROOM = null;
    public static final LiveWrappedRoomProfile CHORUS = null;
    public static final LiveWrappedRoomProfile CLASSROOM = null;
    public static final LiveWrappedRoomProfile CLOUD_GAME = null;
    public static final LiveWrappedRoomProfile COMMUNICATION = null;
    public static final a Companion = null;
    public static final LiveWrappedRoomProfile GAME = null;
    public static final LiveWrappedRoomProfile GAME_STREAMING = null;
    public static final LiveWrappedRoomProfile INTERACTIVE_PODCAST = null;
    public static final LiveWrappedRoomProfile LIVE = null;
    public static final LiveWrappedRoomProfile LOW_LATENCY = null;
    public static final LiveWrappedRoomProfile MEETING = null;
    public static final LiveWrappedRoomProfile MEETING_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedRoomProfile[] f147443a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static LiveWrappedRoomProfile valueOf(String r100) {
        return (LiveWrappedRoomProfile) r27.a.a(LiveWrappedRoomProfile.class, r100);
    }

    public static LiveWrappedRoomProfile[] values() {
        return (LiveWrappedRoomProfile[]) f147443a.clone();
    }

    static {
        LiveWrappedRoomProfile r100 = new LiveWrappedRoomProfile("COMMUNICATION", 0, 0);
        COMMUNICATION = r100;
        LiveWrappedRoomProfile r101 = new LiveWrappedRoomProfile("GAME", 1, 2);
        GAME = r101;
        LiveWrappedRoomProfile r102 = new LiveWrappedRoomProfile("CLOUD_GAME", 2, 3);
        CLOUD_GAME = r102;
        LiveWrappedRoomProfile r103 = new LiveWrappedRoomProfile("LOW_LATENCY", 3, 4);
        LOW_LATENCY = r103;
        LiveWrappedRoomProfile r104 = new LiveWrappedRoomProfile("CHAT_ROOM", 4, 6);
        CHAT_ROOM = r104;
        LiveWrappedRoomProfile r105 = new LiveWrappedRoomProfile("INTERACTIVE_PODCAST", 5, 10);
        INTERACTIVE_PODCAST = r105;
        LiveWrappedRoomProfile r106 = new LiveWrappedRoomProfile("CHORUS", 6, 12);
        CHORUS = r106;
        LiveWrappedRoomProfile r107 = new LiveWrappedRoomProfile("GAME_STREAMING", 7, 14);
        GAME_STREAMING = r107;
        LiveWrappedRoomProfile r108 = new LiveWrappedRoomProfile("MEETING", 8, 16);
        MEETING = r108;
        LiveWrappedRoomProfile r109 = new LiveWrappedRoomProfile("MEETING_ROOM", 9, 17);
        MEETING_ROOM = r109;
        LiveWrappedRoomProfile r110 = new LiveWrappedRoomProfile("CLASSROOM", 10, 18);
        CLASSROOM = r110;
        LiveWrappedRoomProfile r111 = new LiveWrappedRoomProfile("CALL", 11, 19);
        CALL = r111;
        LiveWrappedRoomProfile r112 = new LiveWrappedRoomProfile("LIVE", 12, 20);
        LIVE = r112;
        f147443a = new LiveWrappedRoomProfile[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRoomProfile(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
