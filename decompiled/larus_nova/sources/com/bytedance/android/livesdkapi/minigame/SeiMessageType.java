package com.bytedance.android.livesdkapi.minigame;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/SeiMessageType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "CHANGE_GAME", "ADS", "RECHARGE", "REAL_NAME_AUTH", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SeiMessageType extends Enum<SeiMessageType> {
    private static final /* synthetic */ SeiMessageType[] $VALUES = null;
    public static final SeiMessageType ADS = null;
    public static final SeiMessageType CHANGE_GAME = null;
    public static final SeiMessageType REAL_NAME_AUTH = null;
    public static final SeiMessageType RECHARGE = null;
    private final int code;

    static {
        SeiMessageType r100 = new SeiMessageType("CHANGE_GAME", 0, 0);
        CHANGE_GAME = r100;
        SeiMessageType r101 = new SeiMessageType("ADS", 1, 1);
        ADS = r101;
        SeiMessageType r102 = new SeiMessageType("RECHARGE", 2, 2);
        RECHARGE = r102;
        SeiMessageType r103 = new SeiMessageType("REAL_NAME_AUTH", 3, 3);
        REAL_NAME_AUTH = r103;
        $VALUES = new SeiMessageType[]{r100, r101, r102, r103};
    }

    public static SeiMessageType valueOf(String r100) {
        return (SeiMessageType) a.a(SeiMessageType.class, r100);
    }

    public static SeiMessageType[] values() {
        return (SeiMessageType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    private SeiMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
