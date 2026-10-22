package com.obric.aiagent.assistant.utils;

import androidx.core.os.EnvironmentCompat;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/assistant/utils/DefaultAssistantStatus;", "", AccountConst.KEY_ERROR_CODE, "", "errorMessage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "Unknown", "IsDefaultAssistant", "NotDefaultAssistant", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DefaultAssistantStatus extends Enum<DefaultAssistantStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DefaultAssistantStatus[] $VALUES = null;
    public static final DefaultAssistantStatus IsDefaultAssistant = null;
    public static final DefaultAssistantStatus NotDefaultAssistant = null;
    public static final DefaultAssistantStatus Unknown = null;
    private final int errorCode;
    private final String errorMessage;

    private static final /* synthetic */ DefaultAssistantStatus[] $values() {
        return new DefaultAssistantStatus[]{Unknown, IsDefaultAssistant, NotDefaultAssistant};
    }

    public static EnumEntries<DefaultAssistantStatus> getEntries() {
        return $ENTRIES;
    }

    private DefaultAssistantStatus(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.errorCode = r3;
        this.errorMessage = r4;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    static {
        Unknown = new DefaultAssistantStatus("Unknown", 0, -1, EnvironmentCompat.MEDIA_UNKNOWN);
        IsDefaultAssistant = new DefaultAssistantStatus("IsDefaultAssistant", 1, 0, "isDefaultAssistant");
        NotDefaultAssistant = new DefaultAssistantStatus("NotDefaultAssistant", 2, 1, "notDefaultAssistant");
        DefaultAssistantStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DefaultAssistantStatus valueOf(String r1) {
        return (DefaultAssistantStatus) Enum.valueOf(DefaultAssistantStatus.class, r1);
    }

    public static DefaultAssistantStatus[] values() {
        return (DefaultAssistantStatus[]) $VALUES.clone();
    }
}
