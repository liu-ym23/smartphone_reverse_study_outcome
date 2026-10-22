package com.bytedance.android.livesdkapi.message.minigame;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/minigame/MiniGameMessageType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "CHAT", "GIFT", "GIFT_GROUP", "REMIND", "CONTROL", "MEMBER", "FANS_CLUB", "ROOM", "SOCIAL", "LIKE", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MiniGameMessageType extends Enum<MiniGameMessageType> {
    private static final /* synthetic */ MiniGameMessageType[] $VALUES = null;
    public static final MiniGameMessageType CHAT = null;
    public static final MiniGameMessageType CONTROL = null;
    public static final MiniGameMessageType FANS_CLUB = null;
    public static final MiniGameMessageType GIFT = null;
    public static final MiniGameMessageType GIFT_GROUP = null;
    public static final MiniGameMessageType LIKE = null;
    public static final MiniGameMessageType MEMBER = null;
    public static final MiniGameMessageType REMIND = null;
    public static final MiniGameMessageType ROOM = null;
    public static final MiniGameMessageType SOCIAL = null;
    private final int code;

    public static MiniGameMessageType valueOf(String r100) {
        return (MiniGameMessageType) a.a(MiniGameMessageType.class, r100);
    }

    public static MiniGameMessageType[] values() {
        return (MiniGameMessageType[]) $VALUES.clone();
    }

    static {
        MiniGameMessageType r100 = new MiniGameMessageType("CHAT", 0, 1);
        CHAT = r100;
        MiniGameMessageType r101 = new MiniGameMessageType("GIFT", 1, 2);
        GIFT = r101;
        MiniGameMessageType r102 = new MiniGameMessageType("GIFT_GROUP", 2, 3);
        GIFT_GROUP = r102;
        MiniGameMessageType r103 = new MiniGameMessageType("REMIND", 3, 4);
        REMIND = r103;
        MiniGameMessageType r104 = new MiniGameMessageType("CONTROL", 4, 5);
        CONTROL = r104;
        MiniGameMessageType r105 = new MiniGameMessageType("MEMBER", 5, 6);
        MEMBER = r105;
        MiniGameMessageType r106 = new MiniGameMessageType("FANS_CLUB", 6, 7);
        FANS_CLUB = r106;
        MiniGameMessageType r107 = new MiniGameMessageType("ROOM", 7, 8);
        ROOM = r107;
        MiniGameMessageType r108 = new MiniGameMessageType("SOCIAL", 8, 9);
        SOCIAL = r108;
        MiniGameMessageType r109 = new MiniGameMessageType("LIKE", 9, 10);
        LIKE = r109;
        $VALUES = new MiniGameMessageType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final int getCode() {
        return this.code;
    }

    private MiniGameMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
