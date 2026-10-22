package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/base/MicSeatScene;", "", "AUDIO_LINK", "AUDIO_LINK_ANCHOR", "AUDIO_LINK_LARGE", "AUDIO_LINK_C_POSITION", "AUDIO_LINK_C_POSITION_V2", "AUDIO_LINK_HEAD_RADIO", "AUDIO_LINK_DYNAMIC_ISLAND", "AUDIO_LINK_HAMLET_AVATAR", "AUDIO_LINK_HAMLET_AVATAR_C_POSITION", "AUDIO_LINK_STAGE_ENLARGE", "AUDIO_LINK_STAGE_ENLARGE_MAIN", "VIDEO_LINK", "VIDEO_LINK_EQUAL", "KTV", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicSeatScene extends Enum<MicSeatScene> {
    public static final MicSeatScene AUDIO_LINK = null;
    public static final MicSeatScene AUDIO_LINK_ANCHOR = null;
    public static final MicSeatScene AUDIO_LINK_C_POSITION = null;
    public static final MicSeatScene AUDIO_LINK_C_POSITION_V2 = null;
    public static final MicSeatScene AUDIO_LINK_DYNAMIC_ISLAND = null;
    public static final MicSeatScene AUDIO_LINK_HAMLET_AVATAR = null;
    public static final MicSeatScene AUDIO_LINK_HAMLET_AVATAR_C_POSITION = null;
    public static final MicSeatScene AUDIO_LINK_HEAD_RADIO = null;
    public static final MicSeatScene AUDIO_LINK_LARGE = null;
    public static final MicSeatScene AUDIO_LINK_STAGE_ENLARGE = null;
    public static final MicSeatScene AUDIO_LINK_STAGE_ENLARGE_MAIN = null;
    public static final MicSeatScene KTV = null;
    public static final MicSeatScene VIDEO_LINK = null;
    public static final MicSeatScene VIDEO_LINK_EQUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MicSeatScene[] f72236a = null;

    static {
        MicSeatScene r100 = new MicSeatScene("AUDIO_LINK", 0);
        AUDIO_LINK = r100;
        MicSeatScene r101 = new MicSeatScene("AUDIO_LINK_ANCHOR", 1);
        AUDIO_LINK_ANCHOR = r101;
        MicSeatScene r102 = new MicSeatScene("AUDIO_LINK_LARGE", 2);
        AUDIO_LINK_LARGE = r102;
        MicSeatScene r103 = new MicSeatScene("AUDIO_LINK_C_POSITION", 3);
        AUDIO_LINK_C_POSITION = r103;
        MicSeatScene r104 = new MicSeatScene("AUDIO_LINK_C_POSITION_V2", 4);
        AUDIO_LINK_C_POSITION_V2 = r104;
        MicSeatScene r105 = new MicSeatScene("AUDIO_LINK_HEAD_RADIO", 5);
        AUDIO_LINK_HEAD_RADIO = r105;
        MicSeatScene r106 = new MicSeatScene("AUDIO_LINK_DYNAMIC_ISLAND", 6);
        AUDIO_LINK_DYNAMIC_ISLAND = r106;
        MicSeatScene r107 = new MicSeatScene("AUDIO_LINK_HAMLET_AVATAR", 7);
        AUDIO_LINK_HAMLET_AVATAR = r107;
        MicSeatScene r108 = new MicSeatScene("AUDIO_LINK_HAMLET_AVATAR_C_POSITION", 8);
        AUDIO_LINK_HAMLET_AVATAR_C_POSITION = r108;
        MicSeatScene r109 = new MicSeatScene("AUDIO_LINK_STAGE_ENLARGE", 9);
        AUDIO_LINK_STAGE_ENLARGE = r109;
        MicSeatScene r110 = new MicSeatScene("AUDIO_LINK_STAGE_ENLARGE_MAIN", 10);
        AUDIO_LINK_STAGE_ENLARGE_MAIN = r110;
        MicSeatScene r111 = new MicSeatScene("VIDEO_LINK", 11);
        VIDEO_LINK = r111;
        MicSeatScene r112 = new MicSeatScene("VIDEO_LINK_EQUAL", 12);
        VIDEO_LINK_EQUAL = r112;
        MicSeatScene r113 = new MicSeatScene("KTV", 13);
        KTV = r113;
        f72236a = new MicSeatScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public static MicSeatScene valueOf(String r100) {
        return (MicSeatScene) a.a(MicSeatScene.class, r100);
    }

    public static MicSeatScene[] values() {
        return (MicSeatScene[]) f72236a.clone();
    }

    public MicSeatScene(String r100, int r101) {
        super(r100, r101);
    }
}
