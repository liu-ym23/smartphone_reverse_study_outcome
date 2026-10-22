package com.bytedance.android.livesdkapi.depend;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "GAME", "PROP", "RESERVE", "MINIGAME", "MINIPLAY", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceCardType extends Enum<IntroduceCardType> {
    private static final /* synthetic */ IntroduceCardType[] $VALUES = null;
    public static final IntroduceCardType GAME = null;
    public static final IntroduceCardType MINIGAME = null;
    public static final IntroduceCardType MINIPLAY = null;
    public static final IntroduceCardType PROP = null;
    public static final IntroduceCardType RESERVE = null;
    private final int type;

    static {
        IntroduceCardType r100 = new IntroduceCardType("GAME", 0, 1);
        GAME = r100;
        IntroduceCardType r101 = new IntroduceCardType("PROP", 1, 2);
        PROP = r101;
        IntroduceCardType r102 = new IntroduceCardType("RESERVE", 2, 3);
        RESERVE = r102;
        IntroduceCardType r103 = new IntroduceCardType("MINIGAME", 3, 4);
        MINIGAME = r103;
        IntroduceCardType r104 = new IntroduceCardType("MINIPLAY", 4, 5);
        MINIPLAY = r104;
        $VALUES = new IntroduceCardType[]{r100, r101, r102, r103, r104};
    }

    public static IntroduceCardType valueOf(String r100) {
        return (IntroduceCardType) a.a(IntroduceCardType.class, r100);
    }

    public static IntroduceCardType[] values() {
        return (IntroduceCardType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }

    private IntroduceCardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
