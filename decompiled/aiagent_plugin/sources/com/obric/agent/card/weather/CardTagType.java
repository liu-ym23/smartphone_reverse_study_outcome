package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum CardTagType extends Enum<CardTagType> {
    private static final /* synthetic */ d.d.a $ENTRIES = null;
    private static final /* synthetic */ CardTagType[] $VALUES = null;
    public static final CardTagType BAD = null;
    public static final CardTagType GOOD = null;
    public static final CardTagType MEDIUM = null;

    private static final /* synthetic */ CardTagType[] $values() {
        return new CardTagType[]{GOOD, MEDIUM, BAD};
    }

    public static d.d.a<CardTagType> getEntries() {
        return $ENTRIES;
    }

    private CardTagType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        GOOD = new CardTagType("GOOD", 0);
        MEDIUM = new CardTagType("MEDIUM", 1);
        BAD = new CardTagType("BAD", 2);
        CardTagType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static CardTagType valueOf(String r2) {
        return (CardTagType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CardTagType.class, r2), CardTagType.class, "com.obric.aiagent.plugin");
    }

    public static CardTagType[] values() {
        return (CardTagType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CardTagType[].class, "com.obric.aiagent.plugin");
    }
}
