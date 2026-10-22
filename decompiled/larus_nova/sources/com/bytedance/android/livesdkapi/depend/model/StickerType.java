package com.bytedance.android.livesdkapi.depend.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/StickerType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "Normal", "Aigc", "Interact", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerType extends Enum<StickerType> {
    private static final /* synthetic */ StickerType[] $VALUES = null;
    public static final StickerType Aigc = null;
    public static final StickerType Interact = null;
    public static final StickerType Normal = null;
    private final String typeName;

    static {
        StickerType r100 = new StickerType("Normal", 0, "normal");
        Normal = r100;
        StickerType r101 = new StickerType("Aigc", 1, "ai");
        Aigc = r101;
        StickerType r102 = new StickerType("Interact", 2, "interact_sticker");
        Interact = r102;
        $VALUES = new StickerType[]{r100, r101, r102};
    }

    public static StickerType valueOf(String r100) {
        return (StickerType) a.a(StickerType.class, r100);
    }

    public static StickerType[] values() {
        return (StickerType[]) $VALUES.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    private StickerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
