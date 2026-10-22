package com.bytedance.android.live.liveinteract.api.chatroom.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/event/KtvRoomLyricsStateEventType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "START_KTV_ROOM", "TURNING_NEXT", "SINGER_BEGIN_SING", "SING", "PAUSE_SING", "RESUME_SING", "STOP_SING", "CLOSE_KTV_ROOM", "PREPARE", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvRoomLyricsStateEventType extends Enum<KtvRoomLyricsStateEventType> {
    public static final KtvRoomLyricsStateEventType CLOSE_KTV_ROOM = null;
    public static final KtvRoomLyricsStateEventType PAUSE_SING = null;
    public static final KtvRoomLyricsStateEventType PREPARE = null;
    public static final KtvRoomLyricsStateEventType RESUME_SING = null;
    public static final KtvRoomLyricsStateEventType SING = null;
    public static final KtvRoomLyricsStateEventType SINGER_BEGIN_SING = null;
    public static final KtvRoomLyricsStateEventType START_KTV_ROOM = null;
    public static final KtvRoomLyricsStateEventType STOP_SING = null;
    public static final KtvRoomLyricsStateEventType TURNING_NEXT = null;
    public static final KtvRoomLyricsStateEventType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvRoomLyricsStateEventType[] f71428a = null;
    private final int value;

    public static KtvRoomLyricsStateEventType valueOf(String r100) {
        return (KtvRoomLyricsStateEventType) a.a(KtvRoomLyricsStateEventType.class, r100);
    }

    public static KtvRoomLyricsStateEventType[] values() {
        return (KtvRoomLyricsStateEventType[]) f71428a.clone();
    }

    static {
        KtvRoomLyricsStateEventType r100 = new KtvRoomLyricsStateEventType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        KtvRoomLyricsStateEventType r101 = new KtvRoomLyricsStateEventType("START_KTV_ROOM", 1, 1);
        START_KTV_ROOM = r101;
        KtvRoomLyricsStateEventType r102 = new KtvRoomLyricsStateEventType("TURNING_NEXT", 2, 2);
        TURNING_NEXT = r102;
        KtvRoomLyricsStateEventType r103 = new KtvRoomLyricsStateEventType("SINGER_BEGIN_SING", 3, 3);
        SINGER_BEGIN_SING = r103;
        KtvRoomLyricsStateEventType r104 = new KtvRoomLyricsStateEventType("SING", 4, 4);
        SING = r104;
        KtvRoomLyricsStateEventType r105 = new KtvRoomLyricsStateEventType("PAUSE_SING", 5, 5);
        PAUSE_SING = r105;
        KtvRoomLyricsStateEventType r106 = new KtvRoomLyricsStateEventType("RESUME_SING", 6, 6);
        RESUME_SING = r106;
        KtvRoomLyricsStateEventType r107 = new KtvRoomLyricsStateEventType("STOP_SING", 7, 7);
        STOP_SING = r107;
        KtvRoomLyricsStateEventType r108 = new KtvRoomLyricsStateEventType("CLOSE_KTV_ROOM", 8, 8);
        CLOSE_KTV_ROOM = r108;
        KtvRoomLyricsStateEventType r109 = new KtvRoomLyricsStateEventType("PREPARE", 9, 9);
        PREPARE = r109;
        f71428a = new KtvRoomLyricsStateEventType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final int getValue() {
        return this.value;
    }

    public KtvRoomLyricsStateEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
