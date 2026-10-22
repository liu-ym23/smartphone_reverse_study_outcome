package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ReplyRoomBattleOperate;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REPLY_ROOM_BATTLE_OPERATE_UNKNOWN", "REPLY_ROOM_BATTLE_OPERATE_SELECT_GUESTS", "REPLY_ROOM_BATTLE_OPERATE_END_INVITE", "REPLY_ROOM_BATTLE_OPERATE_END_REPLY", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyRoomBattleOperate extends Enum<ReplyRoomBattleOperate> {
    private static final /* synthetic */ ReplyRoomBattleOperate[] $VALUES = null;
    public static final ReplyRoomBattleOperate REPLY_ROOM_BATTLE_OPERATE_END_INVITE = null;
    public static final ReplyRoomBattleOperate REPLY_ROOM_BATTLE_OPERATE_END_REPLY = null;
    public static final ReplyRoomBattleOperate REPLY_ROOM_BATTLE_OPERATE_SELECT_GUESTS = null;
    public static final ReplyRoomBattleOperate REPLY_ROOM_BATTLE_OPERATE_UNKNOWN = null;
    private final int value;

    static {
        ReplyRoomBattleOperate r100 = new ReplyRoomBattleOperate("REPLY_ROOM_BATTLE_OPERATE_UNKNOWN", 0, 0);
        REPLY_ROOM_BATTLE_OPERATE_UNKNOWN = r100;
        ReplyRoomBattleOperate r101 = new ReplyRoomBattleOperate("REPLY_ROOM_BATTLE_OPERATE_SELECT_GUESTS", 1, 1);
        REPLY_ROOM_BATTLE_OPERATE_SELECT_GUESTS = r101;
        ReplyRoomBattleOperate r102 = new ReplyRoomBattleOperate("REPLY_ROOM_BATTLE_OPERATE_END_INVITE", 2, 2);
        REPLY_ROOM_BATTLE_OPERATE_END_INVITE = r102;
        ReplyRoomBattleOperate r103 = new ReplyRoomBattleOperate("REPLY_ROOM_BATTLE_OPERATE_END_REPLY", 3, 3);
        REPLY_ROOM_BATTLE_OPERATE_END_REPLY = r103;
        $VALUES = new ReplyRoomBattleOperate[]{r100, r101, r102, r103};
    }

    public static ReplyRoomBattleOperate valueOf(String r100) {
        return (ReplyRoomBattleOperate) a.a(ReplyRoomBattleOperate.class, r100);
    }

    public static ReplyRoomBattleOperate[] values() {
        return (ReplyRoomBattleOperate[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private ReplyRoomBattleOperate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
