package com.obric.autogui.common.api.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IAssistCardResourceProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AssistCardIconResType extends Enum<AssistCardIconResType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AssistCardIconResType[] $VALUES = null;
    public static final AssistCardIconResType CHECKMARK = null;
    public static final AssistCardIconResType EXCLAMATION_MARK = null;
    public static final AssistCardIconResType LEFT_HAND_AI_FILL = null;
    public static final AssistCardIconResType REFRESH = null;
    public static final AssistCardIconResType STOP = null;
    public static final AssistCardIconResType TEXT = null;
    public static final AssistCardIconResType TIME_LAPSE = null;

    private static final /* synthetic */ AssistCardIconResType[] $values() {
        return new AssistCardIconResType[]{LEFT_HAND_AI_FILL, TEXT, REFRESH, TIME_LAPSE, CHECKMARK, EXCLAMATION_MARK, STOP};
    }

    public static a<AssistCardIconResType> getEntries() {
        return $ENTRIES;
    }

    private AssistCardIconResType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        LEFT_HAND_AI_FILL = new AssistCardIconResType("LEFT_HAND_AI_FILL", 0);
        TEXT = new AssistCardIconResType("TEXT", 1);
        REFRESH = new AssistCardIconResType("REFRESH", 2);
        TIME_LAPSE = new AssistCardIconResType("TIME_LAPSE", 3);
        CHECKMARK = new AssistCardIconResType("CHECKMARK", 4);
        EXCLAMATION_MARK = new AssistCardIconResType("EXCLAMATION_MARK", 5);
        STOP = new AssistCardIconResType("STOP", 6);
        AssistCardIconResType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AssistCardIconResType valueOf(String r2) {
        return (AssistCardIconResType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistCardIconResType.class, r2), AssistCardIconResType.class, "com.obric.aiagent.plugin");
    }

    public static AssistCardIconResType[] values() {
        return (AssistCardIconResType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistCardIconResType[].class, "com.obric.aiagent.plugin");
    }
}
