package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum CCSessionFailureReason extends Enum<CCSessionFailureReason> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ CCSessionFailureReason[] $VALUES = null;
    public static final CCSessionFailureReason ApiError = null;
    public static final CCSessionFailureReason ClosedBeforeCreated = null;
    public static final CCSessionFailureReason CreationFailed = null;
    public static final CCSessionFailureReason DisplayUnavailable = null;
    public static final CCSessionFailureReason InvalidSession = null;
    public static final CCSessionFailureReason Unsupported = null;

    private static final /* synthetic */ CCSessionFailureReason[] $values() {
        return new CCSessionFailureReason[]{Unsupported, CreationFailed, ClosedBeforeCreated, DisplayUnavailable, InvalidSession, ApiError};
    }

    public static a<CCSessionFailureReason> getEntries() {
        return $ENTRIES;
    }

    private CCSessionFailureReason(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Unsupported = new CCSessionFailureReason("Unsupported", 0);
        CreationFailed = new CCSessionFailureReason("CreationFailed", 1);
        ClosedBeforeCreated = new CCSessionFailureReason("ClosedBeforeCreated", 2);
        DisplayUnavailable = new CCSessionFailureReason("DisplayUnavailable", 3);
        InvalidSession = new CCSessionFailureReason("InvalidSession", 4);
        ApiError = new CCSessionFailureReason("ApiError", 5);
        CCSessionFailureReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static CCSessionFailureReason valueOf(String r2) {
        return (CCSessionFailureReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(CCSessionFailureReason.class, r2), CCSessionFailureReason.class, "com.obric.aiagent.plugin");
    }

    public static CCSessionFailureReason[] values() {
        return (CCSessionFailureReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CCSessionFailureReason[].class, "com.obric.aiagent.plugin");
    }
}
