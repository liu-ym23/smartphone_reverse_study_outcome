package com.obric.autogui.common.api.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IAssistCardResourceProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AssistCardBgResType extends Enum<AssistCardBgResType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AssistCardBgResType[] $VALUES = null;
    public static final AssistCardBgResType CANCEL = null;
    public static final AssistCardBgResType CLARIFY = null;
    public static final AssistCardBgResType DEFAULT = null;
    public static final AssistCardBgResType FAILURE = null;
    public static final AssistCardBgResType GRADIENT_ROUND = null;
    public static final AssistCardBgResType GREY = null;
    public static final AssistCardBgResType PAUSE = null;
    public static final AssistCardBgResType SUCCESS = null;

    private static final /* synthetic */ AssistCardBgResType[] $values() {
        return new AssistCardBgResType[]{CLARIFY, GRADIENT_ROUND, CANCEL, DEFAULT, PAUSE, GREY, SUCCESS, FAILURE};
    }

    public static a<AssistCardBgResType> getEntries() {
        return $ENTRIES;
    }

    private AssistCardBgResType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        CLARIFY = new AssistCardBgResType("CLARIFY", 0);
        GRADIENT_ROUND = new AssistCardBgResType("GRADIENT_ROUND", 1);
        CANCEL = new AssistCardBgResType("CANCEL", 2);
        DEFAULT = new AssistCardBgResType("DEFAULT", 3);
        PAUSE = new AssistCardBgResType("PAUSE", 4);
        GREY = new AssistCardBgResType("GREY", 5);
        SUCCESS = new AssistCardBgResType("SUCCESS", 6);
        FAILURE = new AssistCardBgResType("FAILURE", 7);
        AssistCardBgResType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AssistCardBgResType valueOf(String r2) {
        return (AssistCardBgResType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistCardBgResType.class, r2), AssistCardBgResType.class, "com.obric.aiagent.plugin");
    }

    public static AssistCardBgResType[] values() {
        return (AssistCardBgResType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistCardBgResType[].class, "com.obric.aiagent.plugin");
    }
}
