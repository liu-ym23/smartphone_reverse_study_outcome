package com.obric.autogui.common.api.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: AssistantPrivacyApprovalStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AssistantPrivacyApprovalStatus extends Enum<AssistantPrivacyApprovalStatus> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AssistantPrivacyApprovalStatus[] $VALUES = null;
    public static final AssistantPrivacyApprovalStatus Approved = null;
    public static final AssistantPrivacyApprovalStatus CannotObtain = null;
    public static final AssistantPrivacyApprovalStatus NotApproved = null;
    public static final AssistantPrivacyApprovalStatus Timeout = null;

    private static final /* synthetic */ AssistantPrivacyApprovalStatus[] $values() {
        return new AssistantPrivacyApprovalStatus[]{CannotObtain, Timeout, Approved, NotApproved};
    }

    public static a<AssistantPrivacyApprovalStatus> getEntries() {
        return $ENTRIES;
    }

    private AssistantPrivacyApprovalStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        CannotObtain = new AssistantPrivacyApprovalStatus("CannotObtain", 0);
        Timeout = new AssistantPrivacyApprovalStatus("Timeout", 1);
        Approved = new AssistantPrivacyApprovalStatus("Approved", 2);
        NotApproved = new AssistantPrivacyApprovalStatus("NotApproved", 3);
        AssistantPrivacyApprovalStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AssistantPrivacyApprovalStatus valueOf(String r2) {
        return (AssistantPrivacyApprovalStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistantPrivacyApprovalStatus.class, r2), AssistantPrivacyApprovalStatus.class, "com.obric.aiagent.plugin");
    }

    public static AssistantPrivacyApprovalStatus[] values() {
        return (AssistantPrivacyApprovalStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistantPrivacyApprovalStatus[].class, "com.obric.aiagent.plugin");
    }
}
