package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0013\"\u0004\b\u0016\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusFull;", "", "enableStatus", "Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "privacyApprovalStatus", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "isRoleAssistant", "", "isLogin", "<init>", "(Lcom/obric/aiagent/assistant/utils/AppEnableStatus;Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;ZZ)V", "getEnableStatus", "()Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "setEnableStatus", "(Lcom/obric/aiagent/assistant/utils/AppEnableStatus;)V", "getPrivacyApprovalStatus", "()Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "setPrivacyApprovalStatus", "(Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;)V", "()Z", "setRoleAssistant", "(Z)V", "setLogin", "toString", "", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricAppStatusFull {
    private AppEnableStatus enableStatus;
    private boolean isLogin;
    private boolean isRoleAssistant;
    private PrivacyApprovalStatus privacyApprovalStatus;

    public ObricAppStatusFull() {
        this(null, null, false, false, 15, null);
    }

    public ObricAppStatusFull(AppEnableStatus r2, PrivacyApprovalStatus r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "enableStatus");
        Intrinsics.checkNotNullParameter(r3, "privacyApprovalStatus");
        this.enableStatus = r2;
        this.privacyApprovalStatus = r3;
        this.isRoleAssistant = r4;
        this.isLogin = r5;
    }

    public /* synthetic */ ObricAppStatusFull(AppEnableStatus r2, PrivacyApprovalStatus r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = AppEnableStatus.NoInstalled;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = PrivacyApprovalStatus.CannotObtain;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }

    public final AppEnableStatus getEnableStatus() {
        return this.enableStatus;
    }

    public final void setEnableStatus(AppEnableStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enableStatus = r2;
    }

    public final PrivacyApprovalStatus getPrivacyApprovalStatus() {
        return this.privacyApprovalStatus;
    }

    public final void setPrivacyApprovalStatus(PrivacyApprovalStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.privacyApprovalStatus = r2;
    }

    public final boolean isRoleAssistant() {
        return this.isRoleAssistant;
    }

    public final void setRoleAssistant(boolean r1) {
        this.isRoleAssistant = r1;
    }

    public final boolean isLogin() {
        return this.isLogin;
    }

    public final void setLogin(boolean r1) {
        this.isLogin = r1;
    }

    public String toString() {
        return "AppEnableStatus = " + this.enableStatus.name() + ", PrivacyApprovalStatus = " + this.privacyApprovalStatus.name() + ", isRoleAssistant = " + this.isRoleAssistant + ", isLogin = " + this.isLogin;
    }
}
