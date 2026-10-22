package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CannotObtain", "Timeout", "NotApproved", "Approved", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PrivacyApprovalStatus extends Enum<PrivacyApprovalStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PrivacyApprovalStatus[] $VALUES = null;
    public static final PrivacyApprovalStatus Approved = null;
    public static final PrivacyApprovalStatus CannotObtain = null;
    public static final PrivacyApprovalStatus NotApproved = null;
    public static final PrivacyApprovalStatus Timeout = null;

    private static final /* synthetic */ PrivacyApprovalStatus[] $values() {
        return new PrivacyApprovalStatus[]{CannotObtain, Timeout, NotApproved, Approved};
    }

    public static EnumEntries<PrivacyApprovalStatus> getEntries() {
        return $ENTRIES;
    }

    private PrivacyApprovalStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        CannotObtain = new PrivacyApprovalStatus("CannotObtain", 0);
        Timeout = new PrivacyApprovalStatus("Timeout", 1);
        NotApproved = new PrivacyApprovalStatus("NotApproved", 2);
        Approved = new PrivacyApprovalStatus("Approved", 3);
        PrivacyApprovalStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static PrivacyApprovalStatus valueOf(String r1) {
        return (PrivacyApprovalStatus) Enum.valueOf(PrivacyApprovalStatus.class, r1);
    }

    public static PrivacyApprovalStatus[] values() {
        return (PrivacyApprovalStatus[]) $VALUES.clone();
    }
}
