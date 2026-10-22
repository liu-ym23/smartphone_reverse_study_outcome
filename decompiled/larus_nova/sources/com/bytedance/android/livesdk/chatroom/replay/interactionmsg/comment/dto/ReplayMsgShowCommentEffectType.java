package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.dto;

import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public final enum ReplayMsgShowCommentEffectType extends Enum<ReplayMsgShowCommentEffectType> {
    private static final /* synthetic */ ReplayMsgShowCommentEffectType[] $VALUES = null;
    public static final ReplayMsgShowCommentEffectType TYPE_NOT_SET = null;
    public long value;

    static {
        ReplayMsgShowCommentEffectType r100 = new ReplayMsgShowCommentEffectType("TYPE_NOT_SET", 0, 0);
        TYPE_NOT_SET = r100;
        $VALUES = new ReplayMsgShowCommentEffectType[]{r100};
    }

    public static ReplayMsgShowCommentEffectType[] values() {
        return (ReplayMsgShowCommentEffectType[]) $VALUES.clone();
    }

    public static ReplayMsgShowCommentEffectType valueOf(String r100) {
        return (ReplayMsgShowCommentEffectType) a.a(ReplayMsgShowCommentEffectType.class, r100);
    }

    private ReplayMsgShowCommentEffectType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
