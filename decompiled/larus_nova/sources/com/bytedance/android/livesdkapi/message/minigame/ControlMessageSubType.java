package com.bytedance.android.livesdkapi.message.minigame;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/minigame/ControlMessageSubType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "ACTION_END", "ACTION_ROOM_BANNED", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ControlMessageSubType extends Enum<ControlMessageSubType> {
    private static final /* synthetic */ ControlMessageSubType[] $VALUES = null;
    public static final ControlMessageSubType ACTION_END = null;
    public static final ControlMessageSubType ACTION_ROOM_BANNED = null;
    private final int code;

    static {
        ControlMessageSubType r100 = new ControlMessageSubType("ACTION_END", 0, 3);
        ACTION_END = r100;
        ControlMessageSubType r101 = new ControlMessageSubType("ACTION_ROOM_BANNED", 1, 4);
        ACTION_ROOM_BANNED = r101;
        $VALUES = new ControlMessageSubType[]{r100, r101};
    }

    public static ControlMessageSubType valueOf(String r100) {
        return (ControlMessageSubType) a.a(ControlMessageSubType.class, r100);
    }

    public static ControlMessageSubType[] values() {
        return (ControlMessageSubType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    private ControlMessageSubType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
