package com.bytedance.android.livesdkapi.depend.live;

import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum MessageSceneType extends Enum<MessageSceneType> {
    private static final /* synthetic */ MessageSceneType[] $VALUES = null;
    public static final MessageSceneType ANCHOR_COMMENT_SECTION = null;
    public static final MessageSceneType AUDIENCE_COMMENT_SECTION = null;
    public static final MessageSceneType DEFAULT = null;
    public static final MessageSceneType PUBLIC_SCREEN = null;

    static {
        MessageSceneType r100 = new MessageSceneType("DEFAULT", 0);
        DEFAULT = r100;
        MessageSceneType r101 = new MessageSceneType("ANCHOR_COMMENT_SECTION", 1);
        ANCHOR_COMMENT_SECTION = r101;
        MessageSceneType r102 = new MessageSceneType("AUDIENCE_COMMENT_SECTION", 2);
        AUDIENCE_COMMENT_SECTION = r102;
        MessageSceneType r103 = new MessageSceneType("PUBLIC_SCREEN", 3);
        PUBLIC_SCREEN = r103;
        $VALUES = new MessageSceneType[]{r100, r101, r102, r103};
    }

    public static MessageSceneType[] values() {
        return (MessageSceneType[]) $VALUES.clone();
    }

    public static MessageSceneType valueOf(String r100) {
        return (MessageSceneType) a.a(MessageSceneType.class, r100);
    }

    private MessageSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
