package com.obric.autogui.common.api.app.foundation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: FoundationStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum FoundationStatus extends Enum<FoundationStatus> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ FoundationStatus[] $VALUES = null;
    public static final FoundationStatus Created = null;
    public static final FoundationStatus NotInitialised = null;
    public static final FoundationStatus Ready = null;

    private static final /* synthetic */ FoundationStatus[] $values() {
        return new FoundationStatus[]{NotInitialised, Created, Ready};
    }

    public static a<FoundationStatus> getEntries() {
        return $ENTRIES;
    }

    private FoundationStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        NotInitialised = new FoundationStatus("NotInitialised", 0);
        Created = new FoundationStatus("Created", 1);
        Ready = new FoundationStatus("Ready", 2);
        FoundationStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static FoundationStatus valueOf(String r2) {
        return (FoundationStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(FoundationStatus.class, r2), FoundationStatus.class, "com.obric.aiagent.plugin");
    }

    public static FoundationStatus[] values() {
        return (FoundationStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FoundationStatus[].class, "com.obric.aiagent.plugin");
    }
}
