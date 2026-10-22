package com.bytedance.android.live.multilink.external.api.core.type;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/multilink/external/api/core/type/AckFromSource;", "", "PK_WITH_AUDIENCE_SILENCE_API", "PK_WITH_AUDIENCE_SILENCE_MESSAGE", "PK_WITH_AUDIENCE_CAMERA_API", "PK_WITH_AUDIENCE_CAMERA_MESSAGE", "TALK_ROOM_SILENCE_API", "TALK_ROOM_SILENCE_MESSAGE", "TALK_ROOM_CAMERA_API", "TALK_ROOM_CAMERA_MESSAGE", "VOICE_CHAT_SILENCE_API", "VOICE_CHAT_SILENCE_MESSAGE", "KTV_CAMERA_API", "KTV_CAMERA_MESSAGE", "LINK_MULTI_RTS", "multilink-external-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AckFromSource extends Enum<AckFromSource> {
    public static final AckFromSource KTV_CAMERA_API = null;
    public static final AckFromSource KTV_CAMERA_MESSAGE = null;
    public static final AckFromSource LINK_MULTI_RTS = null;
    public static final AckFromSource PK_WITH_AUDIENCE_CAMERA_API = null;
    public static final AckFromSource PK_WITH_AUDIENCE_CAMERA_MESSAGE = null;
    public static final AckFromSource PK_WITH_AUDIENCE_SILENCE_API = null;
    public static final AckFromSource PK_WITH_AUDIENCE_SILENCE_MESSAGE = null;
    public static final AckFromSource TALK_ROOM_CAMERA_API = null;
    public static final AckFromSource TALK_ROOM_CAMERA_MESSAGE = null;
    public static final AckFromSource TALK_ROOM_SILENCE_API = null;
    public static final AckFromSource TALK_ROOM_SILENCE_MESSAGE = null;
    public static final AckFromSource VOICE_CHAT_SILENCE_API = null;
    public static final AckFromSource VOICE_CHAT_SILENCE_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AckFromSource[] f83246a = null;

    static {
        AckFromSource r100 = new AckFromSource("PK_WITH_AUDIENCE_SILENCE_API", 0);
        PK_WITH_AUDIENCE_SILENCE_API = r100;
        AckFromSource r101 = new AckFromSource("PK_WITH_AUDIENCE_SILENCE_MESSAGE", 1);
        PK_WITH_AUDIENCE_SILENCE_MESSAGE = r101;
        AckFromSource r102 = new AckFromSource("PK_WITH_AUDIENCE_CAMERA_API", 2);
        PK_WITH_AUDIENCE_CAMERA_API = r102;
        AckFromSource r103 = new AckFromSource("PK_WITH_AUDIENCE_CAMERA_MESSAGE", 3);
        PK_WITH_AUDIENCE_CAMERA_MESSAGE = r103;
        AckFromSource r104 = new AckFromSource("TALK_ROOM_SILENCE_API", 4);
        TALK_ROOM_SILENCE_API = r104;
        AckFromSource r105 = new AckFromSource("TALK_ROOM_SILENCE_MESSAGE", 5);
        TALK_ROOM_SILENCE_MESSAGE = r105;
        AckFromSource r106 = new AckFromSource("TALK_ROOM_CAMERA_API", 6);
        TALK_ROOM_CAMERA_API = r106;
        AckFromSource r107 = new AckFromSource("TALK_ROOM_CAMERA_MESSAGE", 7);
        TALK_ROOM_CAMERA_MESSAGE = r107;
        AckFromSource r108 = new AckFromSource("VOICE_CHAT_SILENCE_API", 8);
        VOICE_CHAT_SILENCE_API = r108;
        AckFromSource r109 = new AckFromSource("VOICE_CHAT_SILENCE_MESSAGE", 9);
        VOICE_CHAT_SILENCE_MESSAGE = r109;
        AckFromSource r110 = new AckFromSource("KTV_CAMERA_API", 10);
        KTV_CAMERA_API = r110;
        AckFromSource r111 = new AckFromSource("KTV_CAMERA_MESSAGE", 11);
        KTV_CAMERA_MESSAGE = r111;
        AckFromSource r112 = new AckFromSource("LINK_MULTI_RTS", 12);
        LINK_MULTI_RTS = r112;
        f83246a = new AckFromSource[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static AckFromSource valueOf(String r100) {
        return (AckFromSource) a.a(AckFromSource.class, r100);
    }

    public static AckFromSource[] values() {
        return (AckFromSource[]) f83246a.clone();
    }

    public AckFromSource(String r100, int r101) {
        super(r100, r101);
    }
}
