package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/uiu/objects/ConversionScene;", "", "<init>", "(Ljava/lang/String;I)V", "SCENE_WIDGETS", "SCENE_FULL_PAGE", "SCENE_POPUP", "SCENE_UNKNOWN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversionScene extends Enum<ConversionScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConversionScene[] $VALUES = null;
    public static final ConversionScene SCENE_FULL_PAGE = null;
    public static final ConversionScene SCENE_POPUP = null;
    public static final ConversionScene SCENE_UNKNOWN = null;
    public static final ConversionScene SCENE_WIDGETS = null;

    private static final /* synthetic */ ConversionScene[] $values() {
        return new ConversionScene[]{SCENE_WIDGETS, SCENE_FULL_PAGE, SCENE_POPUP, SCENE_UNKNOWN};
    }

    public static EnumEntries<ConversionScene> getEntries() {
        return $ENTRIES;
    }

    static {
        SCENE_WIDGETS = new ConversionScene("SCENE_WIDGETS", 0);
        SCENE_FULL_PAGE = new ConversionScene("SCENE_FULL_PAGE", 1);
        SCENE_POPUP = new ConversionScene("SCENE_POPUP", 2);
        SCENE_UNKNOWN = new ConversionScene("SCENE_UNKNOWN", 3);
        ConversionScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ConversionScene[] values() {
        return (ConversionScene[]) $VALUES.clone();
    }

    public static ConversionScene valueOf(String r100) {
        return (ConversionScene) a.a(ConversionScene.class, r100);
    }

    private ConversionScene(String r100, int r101) {
        super(r100, r101);
    }
}
