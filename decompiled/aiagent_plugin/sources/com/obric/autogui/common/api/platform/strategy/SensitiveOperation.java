package com.obric.autogui.common.api.platform.strategy;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: SensitiveOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum SensitiveOperation extends Enum<SensitiveOperation> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ SensitiveOperation[] $VALUES = null;
    public static final SensitiveOperation ACCESS_FINE_LOCATION = null;
    public static final SensitiveOperation ACCESS_FOR_COARSE_LOCATION = null;
    public static final SensitiveOperation ACCESS_FOR_FULL_APP_LIST = null;

    private static final /* synthetic */ SensitiveOperation[] $values() {
        return new SensitiveOperation[]{ACCESS_FINE_LOCATION, ACCESS_FOR_COARSE_LOCATION, ACCESS_FOR_FULL_APP_LIST};
    }

    public static a<SensitiveOperation> getEntries() {
        return $ENTRIES;
    }

    private SensitiveOperation(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ACCESS_FINE_LOCATION = new SensitiveOperation("ACCESS_FINE_LOCATION", 0);
        ACCESS_FOR_COARSE_LOCATION = new SensitiveOperation("ACCESS_FOR_COARSE_LOCATION", 1);
        ACCESS_FOR_FULL_APP_LIST = new SensitiveOperation("ACCESS_FOR_FULL_APP_LIST", 2);
        SensitiveOperation[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static SensitiveOperation valueOf(String r2) {
        return (SensitiveOperation) ZeusTransformUtils.preCheckCast(Enum.valueOf(SensitiveOperation.class, r2), SensitiveOperation.class, "com.obric.aiagent.plugin");
    }

    public static SensitiveOperation[] values() {
        return (SensitiveOperation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SensitiveOperation[].class, "com.obric.aiagent.plugin");
    }
}
