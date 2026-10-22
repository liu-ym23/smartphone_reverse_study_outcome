package com.bytedance.android.livesdkapi.depend.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/InsertEffectType;", "", "(Ljava/lang/String;I)V", "Recommend", "Campaign", "Interact", "Config", "Other", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InsertEffectType extends Enum<InsertEffectType> {
    private static final /* synthetic */ InsertEffectType[] $VALUES = null;
    public static final InsertEffectType Campaign = null;
    public static final InsertEffectType Config = null;
    public static final InsertEffectType Interact = null;
    public static final InsertEffectType Other = null;
    public static final InsertEffectType Recommend = null;

    static {
        InsertEffectType r100 = new InsertEffectType("Recommend", 0);
        Recommend = r100;
        InsertEffectType r101 = new InsertEffectType("Campaign", 1);
        Campaign = r101;
        InsertEffectType r102 = new InsertEffectType("Interact", 2);
        Interact = r102;
        InsertEffectType r103 = new InsertEffectType("Config", 3);
        Config = r103;
        InsertEffectType r104 = new InsertEffectType("Other", 4);
        Other = r104;
        $VALUES = new InsertEffectType[]{r100, r101, r102, r103, r104};
    }

    public static InsertEffectType valueOf(String r100) {
        return (InsertEffectType) a.a(InsertEffectType.class, r100);
    }

    public static InsertEffectType[] values() {
        return (InsertEffectType[]) $VALUES.clone();
    }

    private InsertEffectType(String r100, int r101) {
        super(r100, r101);
    }
}
