package com.bytedance.android.live.profit.miniplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/miniplay/SupportLiveScene;", "", "", "value", "I", "getValue", "()I", "ALL_SCENE", "UNKNOWN_SCENE", "VIDEO_SINGLE_BROADCAST", "VIDEO_DOUBLE_PLAYERS_PK", "VIDEO_MULTI_ANCHOR_LINK", "VIDEO_AUDIENCE_LINK", "VIDEO_CHAT_ROOM", "VIDEO_EQUAL_CHAT_ROOM", "VIDEO_MEDIA_MULTI_ANCHOR", "VIDEO_LINK_ROOM", "AUDIO_SINGLE_BROADCAST", "AUDIO_CHAT_ROOM", "AUDIO_KTV_ROOM", "AUDIO_LINK_ROOM", "AUDIO_DOUBLE_PLAYERS_PK", "SCREEN_RECORD", "SCREEN_RECORD_LINK", "OBS_BROADCAST", "OBS_DOUBLE_PLAYERS_PK", "OBS_MULTI_ANCHOR_LINK", "OBS_AUDIENCE_LINK", "OBS_VIDEO_CHAT_ROOM", "OBS_AUDIO_CHAT_ROOM", "OBS_EQUAL_CHAT_ROOM", "OBS_KTV_ROOM", "OBS_LINK_ROOM", "OBS_MEDIA_MULTI_ANCHOR", "MEDIA_BROADCAST", "MEDIA_MULTI_ANCHOR", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SupportLiveScene extends Enum<SupportLiveScene> {
    public static final SupportLiveScene ALL_SCENE = null;
    public static final SupportLiveScene AUDIO_CHAT_ROOM = null;
    public static final SupportLiveScene AUDIO_DOUBLE_PLAYERS_PK = null;
    public static final SupportLiveScene AUDIO_KTV_ROOM = null;
    public static final SupportLiveScene AUDIO_LINK_ROOM = null;
    public static final SupportLiveScene AUDIO_SINGLE_BROADCAST = null;
    public static final SupportLiveScene MEDIA_BROADCAST = null;
    public static final SupportLiveScene MEDIA_MULTI_ANCHOR = null;
    public static final SupportLiveScene OBS_AUDIENCE_LINK = null;
    public static final SupportLiveScene OBS_AUDIO_CHAT_ROOM = null;
    public static final SupportLiveScene OBS_BROADCAST = null;
    public static final SupportLiveScene OBS_DOUBLE_PLAYERS_PK = null;
    public static final SupportLiveScene OBS_EQUAL_CHAT_ROOM = null;
    public static final SupportLiveScene OBS_KTV_ROOM = null;
    public static final SupportLiveScene OBS_LINK_ROOM = null;
    public static final SupportLiveScene OBS_MEDIA_MULTI_ANCHOR = null;
    public static final SupportLiveScene OBS_MULTI_ANCHOR_LINK = null;
    public static final SupportLiveScene OBS_VIDEO_CHAT_ROOM = null;
    public static final SupportLiveScene SCREEN_RECORD = null;
    public static final SupportLiveScene SCREEN_RECORD_LINK = null;
    public static final SupportLiveScene UNKNOWN_SCENE = null;
    public static final SupportLiveScene VIDEO_AUDIENCE_LINK = null;
    public static final SupportLiveScene VIDEO_CHAT_ROOM = null;
    public static final SupportLiveScene VIDEO_DOUBLE_PLAYERS_PK = null;
    public static final SupportLiveScene VIDEO_EQUAL_CHAT_ROOM = null;
    public static final SupportLiveScene VIDEO_LINK_ROOM = null;
    public static final SupportLiveScene VIDEO_MEDIA_MULTI_ANCHOR = null;
    public static final SupportLiveScene VIDEO_MULTI_ANCHOR_LINK = null;
    public static final SupportLiveScene VIDEO_SINGLE_BROADCAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SupportLiveScene[] f88271a = null;
    private final int value;

    public static SupportLiveScene valueOf(String r100) {
        return (SupportLiveScene) a.a(SupportLiveScene.class, r100);
    }

    public static SupportLiveScene[] values() {
        return (SupportLiveScene[]) f88271a.clone();
    }

    static {
        SupportLiveScene r100 = new SupportLiveScene("ALL_SCENE", 0, -1);
        ALL_SCENE = r100;
        SupportLiveScene r101 = new SupportLiveScene("UNKNOWN_SCENE", 1, 0);
        UNKNOWN_SCENE = r101;
        SupportLiveScene r102 = new SupportLiveScene("VIDEO_SINGLE_BROADCAST", 2, 1);
        VIDEO_SINGLE_BROADCAST = r102;
        SupportLiveScene r103 = new SupportLiveScene("VIDEO_DOUBLE_PLAYERS_PK", 3, 2);
        VIDEO_DOUBLE_PLAYERS_PK = r103;
        SupportLiveScene r104 = new SupportLiveScene("VIDEO_MULTI_ANCHOR_LINK", 4, 4);
        VIDEO_MULTI_ANCHOR_LINK = r104;
        SupportLiveScene r105 = new SupportLiveScene("VIDEO_AUDIENCE_LINK", 5, 5);
        VIDEO_AUDIENCE_LINK = r105;
        SupportLiveScene r106 = new SupportLiveScene("VIDEO_CHAT_ROOM", 6, 6);
        VIDEO_CHAT_ROOM = r106;
        SupportLiveScene r107 = new SupportLiveScene("VIDEO_EQUAL_CHAT_ROOM", 7, 7);
        VIDEO_EQUAL_CHAT_ROOM = r107;
        SupportLiveScene r108 = new SupportLiveScene("VIDEO_MEDIA_MULTI_ANCHOR", 8, 8);
        VIDEO_MEDIA_MULTI_ANCHOR = r108;
        SupportLiveScene r109 = new SupportLiveScene("VIDEO_LINK_ROOM", 9, 9);
        VIDEO_LINK_ROOM = r109;
        SupportLiveScene r110 = new SupportLiveScene("AUDIO_SINGLE_BROADCAST", 10, 100);
        AUDIO_SINGLE_BROADCAST = r110;
        SupportLiveScene r111 = new SupportLiveScene("AUDIO_CHAT_ROOM", 11, 101);
        AUDIO_CHAT_ROOM = r111;
        SupportLiveScene r112 = new SupportLiveScene("AUDIO_KTV_ROOM", 12, 102);
        AUDIO_KTV_ROOM = r112;
        SupportLiveScene r113 = new SupportLiveScene("AUDIO_LINK_ROOM", 13, 103);
        AUDIO_LINK_ROOM = r113;
        SupportLiveScene r114 = new SupportLiveScene("AUDIO_DOUBLE_PLAYERS_PK", 14, 104);
        AUDIO_DOUBLE_PLAYERS_PK = r114;
        SupportLiveScene r115 = new SupportLiveScene("SCREEN_RECORD", 15, 200);
        SCREEN_RECORD = r115;
        SupportLiveScene r116 = new SupportLiveScene("SCREEN_RECORD_LINK", 16, 201);
        SCREEN_RECORD_LINK = r116;
        SupportLiveScene r117 = new SupportLiveScene("OBS_BROADCAST", 17, 300);
        OBS_BROADCAST = r117;
        SupportLiveScene r118 = new SupportLiveScene("OBS_DOUBLE_PLAYERS_PK", 18, 301);
        OBS_DOUBLE_PLAYERS_PK = r118;
        SupportLiveScene r119 = new SupportLiveScene("OBS_MULTI_ANCHOR_LINK", 19, 302);
        OBS_MULTI_ANCHOR_LINK = r119;
        SupportLiveScene r120 = new SupportLiveScene("OBS_AUDIENCE_LINK", 20, 303);
        OBS_AUDIENCE_LINK = r120;
        SupportLiveScene r121 = new SupportLiveScene("OBS_VIDEO_CHAT_ROOM", 21, 304);
        OBS_VIDEO_CHAT_ROOM = r121;
        SupportLiveScene r122 = new SupportLiveScene("OBS_AUDIO_CHAT_ROOM", 22, 305);
        OBS_AUDIO_CHAT_ROOM = r122;
        SupportLiveScene r123 = new SupportLiveScene("OBS_EQUAL_CHAT_ROOM", 23, 306);
        OBS_EQUAL_CHAT_ROOM = r123;
        SupportLiveScene r124 = new SupportLiveScene("OBS_KTV_ROOM", 24, 307);
        OBS_KTV_ROOM = r124;
        SupportLiveScene r125 = new SupportLiveScene("OBS_LINK_ROOM", 25, 308);
        OBS_LINK_ROOM = r125;
        SupportLiveScene r126 = new SupportLiveScene("OBS_MEDIA_MULTI_ANCHOR", 26, 309);
        OBS_MEDIA_MULTI_ANCHOR = r126;
        SupportLiveScene r127 = new SupportLiveScene("MEDIA_BROADCAST", 27, 400);
        MEDIA_BROADCAST = r127;
        SupportLiveScene r128 = new SupportLiveScene("MEDIA_MULTI_ANCHOR", 28, 401);
        MEDIA_MULTI_ANCHOR = r128;
        f88271a = new SupportLiveScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
    }

    public final int getValue() {
        return this.value;
    }

    public SupportLiveScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }

    public /* synthetic */ SupportLiveScene(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
