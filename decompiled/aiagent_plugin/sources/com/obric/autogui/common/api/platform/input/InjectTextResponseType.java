package com.obric.autogui.common.api.platform.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: InjectTextResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum InjectTextResponseType extends Enum<InjectTextResponseType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ InjectTextResponseType[] $VALUES = null;
    public static final InjectTextResponseType ABNORMAL = null;
    public static final InjectTextResponseType NORMAL = null;
    public static final InjectTextResponseType SECURE = null;
    public static final InjectTextResponseType UNKNOWN = null;

    private static final /* synthetic */ InjectTextResponseType[] $values() {
        return new InjectTextResponseType[]{NORMAL, ABNORMAL, SECURE, UNKNOWN};
    }

    public static a<InjectTextResponseType> getEntries() {
        return $ENTRIES;
    }

    private InjectTextResponseType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        NORMAL = new InjectTextResponseType("NORMAL", 0);
        ABNORMAL = new InjectTextResponseType("ABNORMAL", 1);
        SECURE = new InjectTextResponseType("SECURE", 2);
        UNKNOWN = new InjectTextResponseType("UNKNOWN", 3);
        InjectTextResponseType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static InjectTextResponseType valueOf(String r2) {
        return (InjectTextResponseType) ZeusTransformUtils.preCheckCast(Enum.valueOf(InjectTextResponseType.class, r2), InjectTextResponseType.class, "com.obric.aiagent.plugin");
    }

    public static InjectTextResponseType[] values() {
        return (InjectTextResponseType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InjectTextResponseType[].class, "com.obric.aiagent.plugin");
    }
}
