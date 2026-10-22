package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum CCActionFailureReason extends Enum<CCActionFailureReason> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ CCActionFailureReason[] $VALUES = null;
    public static final CCActionFailureReason ApiError = null;
    public static final CCActionFailureReason InvalidArgument = null;
    public static final CCActionFailureReason InvalidSession = null;
    public static final CCActionFailureReason SessionClosed = null;
    public static final CCActionFailureReason Unsupported = null;

    private static final /* synthetic */ CCActionFailureReason[] $values() {
        return new CCActionFailureReason[]{Unsupported, InvalidSession, InvalidArgument, SessionClosed, ApiError};
    }

    public static a<CCActionFailureReason> getEntries() {
        return $ENTRIES;
    }

    private CCActionFailureReason(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Unsupported = new CCActionFailureReason("Unsupported", 0);
        InvalidSession = new CCActionFailureReason("InvalidSession", 1);
        InvalidArgument = new CCActionFailureReason("InvalidArgument", 2);
        SessionClosed = new CCActionFailureReason("SessionClosed", 3);
        ApiError = new CCActionFailureReason("ApiError", 4);
        CCActionFailureReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static CCActionFailureReason valueOf(String r2) {
        return (CCActionFailureReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(CCActionFailureReason.class, r2), CCActionFailureReason.class, "com.obric.aiagent.plugin");
    }

    public static CCActionFailureReason[] values() {
        return (CCActionFailureReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CCActionFailureReason[].class, "com.obric.aiagent.plugin");
    }
}
