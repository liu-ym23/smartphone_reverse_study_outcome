package com.obric.autogui.common.api.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IAssistCardResourceProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AssistCardIdResType extends Enum<AssistCardIdResType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AssistCardIdResType[] $VALUES = null;
    public static final AssistCardIdResType APP_ICON = null;
    public static final AssistCardIdResType BTN_1 = null;
    public static final AssistCardIdResType BTN_1_ICON = null;
    public static final AssistCardIdResType BTN_1_TEXT = null;
    public static final AssistCardIdResType BTN_2 = null;
    public static final AssistCardIdResType BTN_2_ICON = null;
    public static final AssistCardIdResType BTN_2_TEXT = null;
    public static final AssistCardIdResType BTN_3 = null;
    public static final AssistCardIdResType BTN_3_ICON = null;
    public static final AssistCardIdResType BTN_3_TEXT = null;
    public static final AssistCardIdResType BTN_GROUP = null;
    public static final AssistCardIdResType CONTENT_TEXT = null;
    public static final AssistCardIdResType ROOT = null;
    public static final AssistCardIdResType STATUS_ICON = null;
    public static final AssistCardIdResType STATUS_TEXT = null;

    private static final /* synthetic */ AssistCardIdResType[] $values() {
        return new AssistCardIdResType[]{ROOT, STATUS_TEXT, CONTENT_TEXT, STATUS_ICON, APP_ICON, BTN_GROUP, BTN_1, BTN_1_ICON, BTN_1_TEXT, BTN_2, BTN_2_ICON, BTN_2_TEXT, BTN_3, BTN_3_ICON, BTN_3_TEXT};
    }

    public static a<AssistCardIdResType> getEntries() {
        return $ENTRIES;
    }

    private AssistCardIdResType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ROOT = new AssistCardIdResType("ROOT", 0);
        STATUS_TEXT = new AssistCardIdResType("STATUS_TEXT", 1);
        CONTENT_TEXT = new AssistCardIdResType("CONTENT_TEXT", 2);
        STATUS_ICON = new AssistCardIdResType("STATUS_ICON", 3);
        APP_ICON = new AssistCardIdResType("APP_ICON", 4);
        BTN_GROUP = new AssistCardIdResType("BTN_GROUP", 5);
        BTN_1 = new AssistCardIdResType("BTN_1", 6);
        BTN_1_ICON = new AssistCardIdResType("BTN_1_ICON", 7);
        BTN_1_TEXT = new AssistCardIdResType("BTN_1_TEXT", 8);
        BTN_2 = new AssistCardIdResType("BTN_2", 9);
        BTN_2_ICON = new AssistCardIdResType("BTN_2_ICON", 10);
        BTN_2_TEXT = new AssistCardIdResType("BTN_2_TEXT", 11);
        BTN_3 = new AssistCardIdResType("BTN_3", 12);
        BTN_3_ICON = new AssistCardIdResType("BTN_3_ICON", 13);
        BTN_3_TEXT = new AssistCardIdResType("BTN_3_TEXT", 14);
        AssistCardIdResType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AssistCardIdResType valueOf(String r2) {
        return (AssistCardIdResType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistCardIdResType.class, r2), AssistCardIdResType.class, "com.obric.aiagent.plugin");
    }

    public static AssistCardIdResType[] values() {
        return (AssistCardIdResType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistCardIdResType[].class, "com.obric.aiagent.plugin");
    }
}
